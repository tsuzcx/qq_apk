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
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (((paramObject instanceof FaceDrawableImpl.InternalFriendListObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      localObject = (FaceDrawableImpl.InternalFriendListObserver)paramObject;
      if ((TextUtils.isEmpty(((FaceDrawableImpl.InternalFriendListObserver)localObject).uin)) || (!((FaceDrawableImpl.InternalFriendListObserver)localObject).uin.equals((String)paramVarArgs[0]))) {
        break label272;
      }
      bool1 = true;
    }
    for (;;)
    {
      if (bool1)
      {
        paramObject = new QQAvatarManagerServiceImpl.1(this, paramObject, paramInt, paramBoolean, paramVarArgs);
        ThreadManager.getUIHandler().post(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("FaceManager", 2, "dispatchMessage , needDis:" + bool1 + ",type: " + paramInt + ",args: " + paramVarArgs);
        }
      }
      return;
      if (((paramObject instanceof FaceDrawableImpl.InternalDiscussionObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
      {
        localObject = (FaceDrawableImpl.InternalDiscussionObserver)paramObject;
        bool1 = bool2;
        if (!TextUtils.isEmpty(((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin))
        {
          bool1 = bool2;
          if (((FaceDrawableImpl.InternalDiscussionObserver)localObject).discussionUin.equals((String)paramVarArgs[1])) {
            bool1 = true;
          }
        }
      }
      else
      {
        if (((paramObject instanceof FaceDrawableImpl.InternalGroupObserver)) && (paramVarArgs != null) && (paramVarArgs.length > 1))
        {
          localObject = (FaceDrawableImpl.InternalGroupObserver)paramObject;
          if ((!TextUtils.isEmpty(((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin)) && (((FaceDrawableImpl.InternalGroupObserver)localObject).discussionUin.equals((String)paramVarArgs[1])))
          {
            bool1 = true;
            continue;
          }
        }
        bool1 = false;
        continue;
        label272:
        bool1 = false;
      }
    }
  }
  
  private void dispatchMessageToDisFaceObserver(int paramInt, FaceDrawableImpl.DisFaceObserver paramDisFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramDisFaceObserver.onUpdateDiscussionFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
  }
  
  private void dispatchMessageToFaceObserver(int paramInt, FaceDrawableImpl.FaceObserver paramFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
      return;
    case 2: 
      paramFaceObserver.onUpdateMobileQQHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 1: 
      paramFaceObserver.onUpdateCustomHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 3: 
      paramFaceObserver.onUpdateTroopHead(paramBoolean, (String)paramArrayOfObject[0]);
      return;
    case 4: 
      paramFaceObserver.onUpdateStrangerHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
      return;
    case 5: 
      paramFaceObserver.onUpdateQCallHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue(), ((Boolean)paramArrayOfObject[2]).booleanValue());
      return;
    }
    paramFaceObserver.onUpdateApolloHead(paramBoolean, (String)paramArrayOfObject[0], ((Integer)paramArrayOfObject[1]).intValue());
  }
  
  private void dispatchMessageToNewTroopFaceObserver(int paramInt, FaceDrawableImpl.NewTroopFaceObserver paramNewTroopFaceObserver, boolean paramBoolean, Object[] paramArrayOfObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    paramNewTroopFaceObserver.onUpdateGroupFaceIcon(paramBoolean, ((Boolean)paramArrayOfObject[0]).booleanValue(), (String)paramArrayOfObject[1]);
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
    if ((paramObject == null) || (this.mAppForQQInterface == null)) {}
    do
    {
      return;
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
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.newTroopFaceObservers)
    {
      if (!this.newTroopFaceObservers.contains(paramObject)) {
        this.newTroopFaceObservers.add((FaceDrawableImpl.NewTroopFaceObserver)paramObject);
      }
      return;
    }
  }
  
  /* Error */
  public void downloadFace(FaceInfo paramFaceInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 215	com/tencent/mobileqq/avatar/api/impl/QQAvatarManagerServiceImpl:mFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +18 -> 26
    //   11: aload_0
    //   12: new 217	com/tencent/mobileqq/app/NearByFaceDownloader
    //   15: dup
    //   16: aload_0
    //   17: getfield 219	com/tencent/mobileqq/avatar/api/impl/QQAvatarManagerServiceImpl:mApp	Lcom/tencent/common/app/AppInterface;
    //   20: invokespecial 222	com/tencent/mobileqq/app/NearByFaceDownloader:<init>	(Lmqq/app/AppRuntime;)V
    //   23: putfield 215	com/tencent/mobileqq/avatar/api/impl/QQAvatarManagerServiceImpl:mFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   26: aload_0
    //   27: getfield 215	com/tencent/mobileqq/avatar/api/impl/QQAvatarManagerServiceImpl:mFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   30: ifnull +11 -> 41
    //   33: aload_0
    //   34: getfield 215	com/tencent/mobileqq/avatar/api/impl/QQAvatarManagerServiceImpl:mFaceDownloader	Lcom/tencent/mobileqq/app/NearByFaceDownloader;
    //   37: aload_1
    //   38: invokevirtual 225	com/tencent/mobileqq/app/NearByFaceDownloader:addDownloadRequest	(Lcom/tencent/mobileqq/app/face/FaceInfo;)V
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: astore_2
    //   45: ldc 10
    //   47: iconst_1
    //   48: aload_2
    //   49: iconst_0
    //   50: anewarray 4	java/lang/Object
    //   53: invokestatic 229	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   56: goto -30 -> 26
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	this	QQAvatarManagerServiceImpl
    //   0	64	1	paramFaceInfo	FaceInfo
    //   6	2	2	localNearByFaceDownloader	NearByFaceDownloader
    //   44	5	2	localOutOfMemoryError	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   11	26	44	java/lang/OutOfMemoryError
    //   2	7	59	finally
    //   11	26	59	finally
    //   26	41	59	finally
    //   45	56	59	finally
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
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.mFaceCache)
    {
      Bitmap localBitmap2 = (Bitmap)this.mFaceCache.get(paramString);
      Bitmap localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        localBitmap1 = localBitmap2;
        if (this.faceTimestamps != null)
        {
          localBitmap1 = localBitmap2;
          if (this.faceTimestamps.containsKey(paramString))
          {
            long l = ((Long)this.faceTimestamps.get(paramString)).longValue();
            localBitmap1 = localBitmap2;
            if (System.currentTimeMillis() - l > 86400000L)
            {
              this.faceTimestamps.remove(paramString);
              this.mFaceCache.remove(paramString);
              localBitmap1 = null;
            }
          }
        }
      }
      return localBitmap1;
    }
  }
  
  public String getFacePath(FaceInfo paramFaceInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (SystemUtil.a()) {
      localStringBuilder.append(AppConstants.PATH_HEAD_STRANGER);
    }
    for (;;)
    {
      localStringBuilder.append("stranger_").append(Integer.toString(paramFaceInfo.b)).append("_");
      String str = MD5.toMD5(paramFaceInfo.a);
      str = MD5.toMD5(str + paramFaceInfo.a);
      localStringBuilder.append(MD5.toMD5(str + paramFaceInfo.a));
      localStringBuilder.append(".jpg_");
      return localStringBuilder.toString();
      localStringBuilder.append("/data/data/com.tencent.mobileqq/files/head/_stranger/");
    }
  }
  
  public Setting getFaceSetting(String paramString)
  {
    paramString = null;
    EIPCResult localEIPCResult = QIPCClientHelper.getInstance().getClient().callServer("AvatarServerIPCModule", "action_get_face_setting", null);
    if (localEIPCResult.isSuccess()) {
      paramString = (Setting)localEIPCResult.data.getParcelable("key_face_setting");
    }
    return paramString;
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
    if ((this.disFaceObservers != null) && (this.disFaceObservers.size() > 0)) {
      synchronized (this.disFaceObservers)
      {
        Iterator localIterator = this.disFaceObservers.iterator();
        if (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.DisFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public final void notifyFaceDrawableUI(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.faceObservers != null) && (this.faceObservers.size() > 0)) {
      synchronized (this.faceObservers)
      {
        Iterator localIterator = this.faceObservers.iterator();
        if (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.FaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
      }
    }
  }
  
  public final void notifyNewTroopDrawableUI(int paramInt, boolean paramBoolean, Object... paramVarArgs)
  {
    if ((this.newTroopFaceObservers != null) && (this.newTroopFaceObservers.size() > 0)) {
      synchronized (this.newTroopFaceObservers)
      {
        Iterator localIterator = this.newTroopFaceObservers.iterator();
        if (localIterator.hasNext()) {
          dispatchMessage(paramInt, (FaceDrawableImpl.NewTroopFaceObserver)localIterator.next(), paramBoolean, paramVarArgs);
        }
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
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null)) {
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
    if (this.mAppForQQInterface == null) {}
    do
    {
      return;
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
    } while (!(paramObject instanceof FaceDrawableImpl.NewTroopFaceObserver));
    synchronized (this.newTroopFaceObservers)
    {
      this.newTroopFaceObservers.remove(paramObject);
      return;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */