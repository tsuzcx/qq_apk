package com.tencent.mobileqq.avatar.api.impl;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.NearByFaceDownloader;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.DisFaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.FaceObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalDiscussionObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalFriendListObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.InternalGroupObserver;
import com.tencent.mobileqq.app.face.FaceDrawableImpl.NewTroopFaceObserver;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.config.PicIPManager;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQAvatarManagerServiceImpl
  implements IQQAvatarManagerService
{
  public static final String TAG = "FaceManager";
  List<FaceDrawableImpl.DisFaceObserver> disFaceObservers;
  QQAvatarManagerServiceImpl.InternalDiscussionObserver discussionObserver;
  List<FaceDrawableImpl.FaceObserver> faceObservers;
  ConcurrentHashMap<String, Long> faceTimestamps = new ConcurrentHashMap(4);
  QQAvatarManagerServiceImpl.InternalFriendListObserver friendListObserver;
  AppInterface mApp;
  AppInterface mAppForQQInterface;
  MQLruCache<String, Object> mFaceCache;
  NearByFaceDownloader mFaceDownloader;
  List<FaceDrawableImpl.NewTroopFaceObserver> newTroopFaceObservers;
  QQAvatarManagerServiceImpl.InternalTroopObserver troopObserver;
  
  private void dispatchMessage(int paramInt, Object paramObject, boolean paramBoolean, Object... paramVarArgs)
  {
    boolean bool1 = paramObject instanceof FaceDrawableImpl.InternalFriendListObserver;
    boolean bool2 = false;
    Object localObject;
    if ((bool1) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = (FaceDrawableImpl.InternalFriendListObserver)paramObject;
      bool1 = bool2;
      if (TextUtils.isEmpty(((FaceDrawableImpl.InternalFriendListObserver)localObject).uin)) {
        break label213;
      }
      bool1 = bool2;
      if (!((FaceDrawableImpl.InternalFriendListObserver)localObject).uin.equals((String)paramVarArgs[0])) {
        break label213;
      }
    }
    else if (((paramObject instanceof FaceDrawableImpl.InternalDiscussionObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
    {
      localObject = (FaceDrawableImpl.InternalDiscussionObserver)paramObject;
      bool1 = bool2;
      if (TextUtils.isEmpty(((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin)) {
        break label213;
      }
      bool1 = bool2;
      if (!((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin.equals((String)paramVarArgs[1])) {
        break label213;
      }
    }
    else
    {
      bool1 = bool2;
      if (!(paramObject instanceof FaceDrawableImpl.InternalGroupObserver)) {
        break label213;
      }
      bool1 = bool2;
      if (paramVarArgs == null) {
        break label213;
      }
      bool1 = bool2;
      if (paramVarArgs.length <= 1) {
        break label213;
      }
      localObject = (FaceDrawableImpl.InternalGroupObserver)paramObject;
      bool1 = bool2;
      if (TextUtils.isEmpty(((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin)) {
        break label213;
      }
      bool1 = bool2;
      if (!((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin.equals((String)paramVarArgs[1])) {
        break label213;
      }
    }
    bool1 = true;
    label213:
    if (bool1)
    {
      paramObject = new QQAvatarManagerServiceImpl.1(this, paramObject, paramInt, paramBoolean, paramVarArgs);
      ThreadManager.getUIHandler().post(paramObject);
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("dispatchMessage , needDis:");
        paramObject.append(bool1);
        paramObject.append(",type: ");
        paramObject.append(paramInt);
        paramObject.append(",args: ");
        paramObject.append(paramVarArgs);
        QLog.d("FaceManager", 2, paramObject.toString());
      }
    }
  }
  
  private void dispatchMessageToDisFaceObserver(int paramInt, FaceDrawableImpl.DisFaceObserver paramDisFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 1) {
      return;
    }
    paramDisFaceObserver.onUpdateDiscussionFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
  }
  
  private void dispatchMessageToFaceObserver(int paramInt, FaceDrawableImpl.FaceObserver paramFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 8) {
                return;
              }
              paramFaceObserver.onUpdateApolloHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue());
              return;
            }
            paramFaceObserver.onUpdateQCallHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
            return;
          }
          paramFaceObserver.onUpdateStrangerHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
          return;
        }
        paramFaceObserver.onUpdateTroopHead(paramBoolean, (String)paramArrayOfObject[0]);
        return;
      }
      paramFaceObserver.onUpdateMobileQQHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    }
    paramFaceObserver.onUpdateCustomHead(paramBoolean, (String)paramArrayOfObject[0]);
  }
  
  private void dispatchMessageToNewTroopFaceObserver(int paramInt, FaceDrawableImpl.NewTroopFaceObserver paramNewTroopFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    if (paramInt == TroopAvatarObserver.TYPE_NOTIFY_GET_NEW_TROOP_HEAD) {
      paramNewTroopFaceObserver.onUpdateGroupFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
    }
  }
  
  public static byte getHeadCachePriority(int paramInt)
  {
    if (paramInt == 32) {
      return 1;
    }
    return 2;
  }
  
  public void addObserver(Object paramObject)
  {
    if (paramObject != null)
    {
      if (this.mAppForQQInterface == null) {
        return;
      }
      if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
        synchronized (this.faceObservers)
        {
          if (!this.faceObservers.contains(paramObject)) {
            this.faceObservers.add((FaceDrawableImpl.FaceObserver)paramObject);
          }
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
        synchronized (this.disFaceObservers)
        {
          if (!this.disFaceObservers.contains(paramObject)) {
            this.disFaceObservers.add((FaceDrawableImpl.DisFaceObserver)paramObject);
          }
          return;
        }
      }
      if ((paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver)) {
        synchronized (this.newTroopFaceObservers)
        {
          if (!this.newTroopFaceObservers.contains(paramObject)) {
            this.newTroopFaceObservers.add((FaceDrawableImpl.NewTroopFaceObserver)paramObject);
          }
          return;
        }
      }
    }
  }
  
  public void downloadFace(FaceInfo paramFaceInfo)
  {
    try
    {
      NearByFaceDownloader localNearByFaceDownloader = this.mFaceDownloader;
      if (localNearByFaceDownloader == null) {
        try
        {
          this.mFaceDownloader = new NearByFaceDownloader(this.mApp);
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QLog.e("FaceManager", 1, localOutOfMemoryError, new Object[0]);
        }
      }
      if (this.mFaceDownloader != null) {
        this.mFaceDownloader.addDownloadRequest(paramFaceInfo);
      }
      return;
    }
    finally {}
  }
  
  public String getChooseStrangerGroupIP()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_get_stranger_group_ip", null);
    if ((localEIPCResult.isSuccess()) && (!TextUtils.isEmpty(localEIPCResult.data.getString("key_ip", "")))) {
      return localEIPCResult.data.getString("key_ip");
    }
    return PicIPManager.a(1);
  }
  
  public String getChoosedIP()
  {
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_get_chose_ip", null);
    if ((localEIPCResult.isSuccess()) && (!TextUtils.isEmpty(localEIPCResult.data.getString("key_ip", "")))) {
      return localEIPCResult.data.getString("key_ip");
    }
    return PicIPManager.a(0);
  }
  
  public FaceDownloader getFaceDownloader()
  {
    try
    {
      if (this.mFaceDownloader == null) {
        this.mFaceDownloader = new NearByFaceDownloader(this.mApp);
      }
      NearByFaceDownloader localNearByFaceDownloader = this.mFaceDownloader;
      return localNearByFaceDownloader;
    }
    finally {}
  }
  
  public Bitmap getFaceFromCache(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    for (;;)
    {
      Bitmap localBitmap;
      synchronized (this.mFaceCache)
      {
        localBitmap = (Bitmap)this.mFaceCache.get(paramString);
        if ((localBitmap != null) && (this.faceTimestamps != null) && (this.faceTimestamps.containsKey(paramString)))
        {
          long l = ((Long)this.faceTimestamps.get(paramString)).longValue();
          if (System.currentTimeMillis() - l > 86400000L)
          {
            this.faceTimestamps.remove(paramString);
            this.mFaceCache.remove(paramString);
            paramString = localObject;
            return paramString;
          }
        }
      }
      paramString = localBitmap;
    }
  }
  
  public String getFacePath(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder1 = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder1.append(AppConstants.PATH_HEAD_STRANGER);
    } else {
      localStringBuilder1.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
    }
    localStringBuilder1.append("stranger_");
    localStringBuilder1.append(Integer.toString(paramFaceInfo.b));
    localStringBuilder1.append("_");
    String str = MD5.toMD5(paramFaceInfo.a);
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramFaceInfo.a);
    str = MD5.toMD5(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(str);
    localStringBuilder2.append(paramFaceInfo.a);
    localStringBuilder1.append(MD5.toMD5(localStringBuilder2.toString()));
    localStringBuilder1.append(".jpg_");
    return localStringBuilder1.toString();
  }
  
  public Setting getFaceSetting(String paramString)
  {
    paramString = QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_get_face_setting", null);
    if (paramString.isSuccess()) {
      return (Setting)paramString.data.getParcelable("key_face_setting");
    }
    return null;
  }
  
  public boolean isFaceFileExist(FaceInfo paramFaceInfo)
  {
    paramFaceInfo = getFacePath(paramFaceInfo);
    if (TextUtils.isEmpty(paramFaceInfo)) {
      return false;
    }
    return new File(paramFaceInfo).exists();
  }
  
  public final void notifyDisFaceDrawableUI(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    ??? = this.disFaceObservers;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.disFaceObservers)
      {
        Iterator localIterator = this.disFaceObservers.iterator();
        while (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.DisFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
        return;
      }
    }
  }
  
  public final void notifyFaceDrawableUI(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    ??? = this.faceObservers;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.faceObservers)
      {
        Iterator localIterator = this.faceObservers.iterator();
        while (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.FaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
        return;
      }
    }
  }
  
  public final void notifyNewTroopDrawableUI(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    ??? = this.newTroopFaceObservers;
    if ((??? != null) && (???.size() > 0)) {
      synchronized (this.newTroopFaceObservers)
      {
        Iterator localIterator = this.newTroopFaceObservers.iterator();
        while (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.NewTroopFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
        return;
      }
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if ("module_nearby".equals(paramAppRuntime.getModuleId()))
    {
      this.mApp = ((AppInterface)paramAppRuntime);
      this.mFaceCache = GlobalImageCache.a;
      return;
    }
    this.mAppForQQInterface = ((AppInterface)paramAppRuntime);
    this.friendListObserver = new QQAvatarManagerServiceImpl.InternalFriendListObserver(this, null);
    this.mAppForQQInterface.addDefaultObservers(this.friendListObserver);
    this.discussionObserver = new QQAvatarManagerServiceImpl.InternalDiscussionObserver(this, null);
    this.mAppForQQInterface.addDefaultObservers(this.discussionObserver);
    this.troopObserver = new QQAvatarManagerServiceImpl.InternalTroopObserver(this, null);
    this.mAppForQQInterface.addObserver(this.troopObserver);
    this.faceObservers = new Vector();
    this.disFaceObservers = new Vector();
    this.newTroopFaceObservers = new Vector();
  }
  
  public void onDestroy()
  {
    if (this.mAppForQQInterface != null)
    {
      this.faceObservers.clear();
      this.mAppForQQInterface.removeObserver(this.friendListObserver);
      this.disFaceObservers.clear();
      this.mAppForQQInterface.removeObserver(this.discussionObserver);
      this.mAppForQQInterface.removeObserver(this.troopObserver);
    }
  }
  
  public void putFaceToCache(String paramString, Bitmap paramBitmap, byte paramByte)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBitmap == null) {
        return;
      }
      synchronized (this.mFaceCache)
      {
        this.mFaceCache.put(paramString, paramBitmap, paramByte);
        if (this.faceTimestamps != null) {
          this.faceTimestamps.put(paramString, Long.valueOf(System.currentTimeMillis()));
        }
        return;
      }
    }
  }
  
  public void removeFaceFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (this.mFaceCache)
    {
      this.mFaceCache.remove(paramString);
      return;
    }
  }
  
  public void removeObserver(Object paramObject)
  {
    if (this.mAppForQQInterface == null) {
      return;
    }
    if ((paramObject instanceof FaceDrawableImpl.FaceObserver)) {
      synchronized (this.faceObservers)
      {
        this.faceObservers.remove(paramObject);
        return;
      }
    }
    if ((paramObject instanceof FaceDrawableImpl.DisFaceObserver)) {
      synchronized (this.disFaceObservers)
      {
        this.disFaceObservers.remove(paramObject);
        return;
      }
    }
    if ((paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver)) {
      synchronized (this.newTroopFaceObservers)
      {
        this.newTroopFaceObservers.remove(paramObject);
        return;
      }
    }
  }
  
  public void updateFaceSetting(Setting paramSetting)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_face_setting", paramSetting);
    QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_get_face_setting", localBundle);
  }
  
  public void updateFaceTimestamp(ArrayList<String> paramArrayList, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putStringArrayList("key_key_list", paramArrayList);
    localBundle.putLong("key_update_time", paramLong);
    QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_update_setting_timestamp", localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */