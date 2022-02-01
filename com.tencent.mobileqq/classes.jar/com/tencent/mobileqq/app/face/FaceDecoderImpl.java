package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.avatar.api.IQQAvatarDataService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.utils.AvatarUtil;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDiscussionHandlerService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class FaceDecoderImpl
  extends FaceDecoderBase
  implements DecodeCompletionListener
{
  private static final String TAG = "Q.qqhead.FaceDecoderImpl";
  private AppInterface mAppIntf;
  private FaceDecoderImpl.MyAvatarObserver mAvatarObserver;
  private FaceDecoderImpl.MyDiscussionObserver mDiscussObserver;
  private FaceDecoderImpl.MyTroopHeaderObserver mTroopHeaderObserver;
  
  public FaceDecoderImpl(AppInterface paramAppInterface)
  {
    this.maxDecodingTask = 4;
    this.mAppIntf = paramAppInterface;
  }
  
  public void destory()
  {
    AppInterface localAppInterface = this.mAppIntf;
    FaceDecoderImpl.MyDiscussionObserver localMyDiscussionObserver = this.mDiscussObserver;
    FaceDecoderImpl.MyAvatarObserver localMyAvatarObserver = this.mAvatarObserver;
    FaceDecoderImpl.MyTroopHeaderObserver localMyTroopHeaderObserver = this.mTroopHeaderObserver;
    this.mAppIntf = null;
    this.mDiscussObserver = null;
    this.mTroopHeaderObserver = null;
    this.mAvatarObserver = null;
    if (localAppInterface != null)
    {
      if (localMyDiscussionObserver != null) {
        localAppInterface.removeObserver(localMyDiscussionObserver);
      }
      if (localMyAvatarObserver != null) {
        localAppInterface.removeObserver(localMyAvatarObserver);
      }
      if (localMyTroopHeaderObserver != null) {
        localAppInterface.removeObserver(localMyTroopHeaderObserver);
      }
    }
    super.destory();
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte, int paramInt3)
  {
    if (this.mAppIntf == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "getBitmapFromCache, mApp is null");
      }
      return null;
    }
    if ((paramInt1 == 1001) && (paramString != null) && (!AvatarUtil.a(paramString))) {}
    for (Object localObject = AvatarUtil.c(paramString);; localObject = paramString)
    {
      if ((paramInt1 == 4) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(paramString))) {
        paramInt1 = 113;
      }
      for (;;)
      {
        if (paramInt1 == 113) {
          paramByte = 3;
        }
        paramByte = AvatarUtil.a(paramByte);
        IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "");
        localObject = localIQQAvatarDataService.getBitmapFromCache(localIQQAvatarDataService.getFaceBitmapCacheKey(paramInt1, (String)localObject, paramByte, paramInt2, paramInt3, true));
        if ((localObject != null) && (paramInt1 == 1001))
        {
          ((IDiscussionHandlerService)this.mAppIntf.getRuntimeService(IDiscussionHandlerService.class, "")).checkPstnIconInfoAndUpdate(paramString);
          if (this.mDiscussObserver == null)
          {
            this.mDiscussObserver = new FaceDecoderImpl.MyDiscussionObserver(this, null);
            this.mAppIntf.addObserver(this.mDiscussObserver);
          }
        }
        return localObject;
      }
    }
  }
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if ((paramFaceInfo == null) || (this.mAppIntf == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompleted, faceInfo=" + paramFaceInfo.toString());
    }
    this.iRunningRequests -= 1;
    if ((!this.mReadyRequests.isEmpty()) && (!this.mPause)) {
      runNextTask();
    }
    FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
    int j;
    if (localFaceInfo != null)
    {
      j = FaceInfo.r;
      if (paramBitmap == null) {
        break label161;
      }
    }
    label161:
    for (int i = FaceInfo.f;; i = FaceInfo.g)
    {
      localFaceInfo.a(j, i);
      if ((this.mDecodeTaskCompletionListener == null) || (paramBitmap == null)) {
        break;
      }
      this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      return;
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramFaceInfo == null) || (this.mAppIntf == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, "onDecodeTaskCompletedNeedDownload, faceInfo=" + paramFaceInfo.toString());
      }
      this.iRunningRequests -= 1;
      paramAppInterface = (FaceInfo)this.mInProgress.get(paramFaceInfo.b());
      if (paramAppInterface != null)
      {
        if (this.mAvatarObserver == null)
        {
          this.mAvatarObserver = new FaceDecoderImpl.MyAvatarObserver(this, null);
          this.mAppIntf.addObserver(this.mAvatarObserver);
        }
        FaceDecoder.requestDownloadFace(this.mAppIntf, paramAppInterface);
      }
    } while ((this.mPause) || (this.mReadyRequests.isEmpty()) || (this.iRunningRequests >= this.maxDecodingTask));
    runNextTask();
  }
  
  protected void onUpdateHead(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.mAppIntf == null) {}
    label181:
    do
    {
      Object localObject;
      do
      {
        Bitmap localBitmap;
        do
        {
          return;
          localObject = FaceInfo.a(paramInt1, paramString, paramInt2, paramInt3);
          if ((paramInt1 == 101) && ((!paramBoolean) || (this.mPause))) {
            break label181;
          }
          localBitmap = getBitmapFromCache(paramInt1, paramString, paramInt2, (byte)3, paramInt3);
          if (localBitmap == null) {
            break;
          }
          localObject = (FaceInfo)this.mInProgress.remove(localObject);
          if (localObject != null) {
            ((FaceInfo)localObject).a(FaceInfo.r, FaceInfo.f);
          }
        } while (this.mDecodeTaskCompletionListener == null);
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramInt1, paramString, localBitmap);
        return;
        paramString = (FaceInfo)this.mInProgress.get(localObject);
        if (paramString != null)
        {
          enqueueDecode(paramString);
          return;
        }
        paramString = (FaceInfo)this.mRefreshMap.remove(localObject);
      } while (paramString == null);
      paramString.a(FaceInfo.j);
      this.mInProgress.put(localObject, paramString);
      enqueueDecode(paramString);
      return;
      paramString = (FaceInfo)this.mInProgress.remove(localObject);
    } while (paramString == null);
    paramInt2 = FaceInfo.r;
    if (!paramBoolean) {}
    for (paramInt1 = FaceInfo.g;; paramInt1 = FaceInfo.h)
    {
      paramString.a(paramInt2, paramInt1);
      return;
    }
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    return false;
  }
  
  public void refreshApolloFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    long l;
    do
    {
      do
      {
        do
        {
          return;
          localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(116, paramString, 200);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (localObject != null) {
        ((IQQAvatarHandlerService)localObject).getApolloHead(paramString, (byte)1, (byte)0, paramInt);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshApolloFaceWithTimeStamp id=" + paramString + ", sizeType =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L) || (this.mAppIntf == null)) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 200) && (paramInt2 != 204));
      if (paramInt1 == 32) {}
      for (byte b = 1;; b = 0)
      {
        FaceInfo localFaceInfo = new FaceInfo(paramInt1, paramString, false, b, 3, false, paramInt2, false, paramInt3);
        String str = FaceInfo.a(paramInt1, paramString, paramInt2, paramInt3);
        if (this.mRefreshMap.get(str) == null) {
          this.mRefreshMap.put(str, localFaceInfo);
        }
        if (this.mAvatarObserver == null)
        {
          this.mAvatarObserver = new FaceDecoderImpl.MyAvatarObserver(this, null);
          this.mAppIntf.addObserver(this.mAvatarObserver);
        }
        if (paramInt1 != 32) {
          break;
        }
        refreshStrangerFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
      if (paramInt1 == 16)
      {
        refreshQCallFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
    } while (paramInt1 != 116);
    refreshApolloFaceWithTimeStamp(paramString, paramInt3, paramLong);
  }
  
  public void refreshQCallFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(16, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (localObject != null) {
        ((IQQAvatarHandlerService)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshQCallFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public void refreshStrangerFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramLong <= 0L)) {}
    label13:
    long l;
    do
    {
      do
      {
        do
        {
          break label13;
          do
          {
            return;
          } while ((paramInt != 200) && (paramInt != 204) && (paramInt != 202));
          localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(32, paramString, paramInt);
        } while ((localObject == null) || (((Pair)localObject).second == null));
        l = ((Setting)((Pair)localObject).second).headImgTimestamp;
      } while (l == paramLong);
      Object localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
      if (localObject != null) {
        ((IQQAvatarHandlerService)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.qqhead.qaif", 2, "refreshStrangerFaceWithTimeStamp id=" + paramString + ", idtype =" + paramInt + ", timestamp=" + paramLong + ",headImgTimestamp=" + l);
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace fail. type=" + paramInt2 + ", uin=" + paramString);
      }
      return false;
    }
    byte b = 3;
    if (paramInt3 == 0) {
      if ((paramInt2 != 101) && (paramInt2 != 1001)) {}
    }
    String str;
    for (b = 3;; b = (byte)paramInt3)
    {
      paramInt3 = AvatarUtil.a(b);
      str = FaceInfo.a(paramInt2, paramString, paramInt1, paramInt4);
      FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(str);
      if ((localFaceInfo == null) || (localFaceInfo.a(FaceInfo.j, 300000L))) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.FaceDecoderImpl", 2, "requestDecodeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      localFaceInfo.c = paramInt3;
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
    paramString.a(FaceInfo.j);
    this.mInProgress.put(str, paramString);
    enqueueDecode(paramString);
    return true;
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return false;
  }
  
  protected void runNextTask()
  {
    Object localObject1 = null;
    if (this.mReadyRequests.isEmpty()) {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
    }
    label214:
    do
    {
      return;
      try
      {
        localObject2 = (FaceInfo)this.mReadyRequests.removeFirst();
        try
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, faceinfo=" + ((FaceInfo)localObject2).toString());
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 101) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 1001)) && (this.mDiscussObserver == null))
          {
            this.mDiscussObserver = new FaceDecoderImpl.MyDiscussionObserver(this, null);
            this.mAppIntf.addObserver(this.mDiscussObserver);
          }
          if (((((FaceInfo)localObject2).jdField_a_of_type_Int == 4) || (((FaceInfo)localObject2).jdField_a_of_type_Int == 113)) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(((FaceInfo)localObject2).jdField_a_of_type_JavaLangString)))
          {
            if (this.mTroopHeaderObserver == null) {
              this.mTroopHeaderObserver = new FaceDecoderImpl.MyTroopHeaderObserver(this, null);
            }
            this.mAppIntf.addObserver(this.mTroopHeaderObserver);
          }
          this.iRunningRequests += 1;
          FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.mAppIntf, (FaceInfo)localObject2, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          localObject1 = localObject2;
          localObject2 = localThrowable2;
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        break label214;
      }
      if (localObject1 != null) {
        this.iRunningRequests -= 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("Q.qqhead.FaceDecoderImpl", 2, "runNextTask exception and info is " + localObject1, (Throwable)localObject2);
  }
  
  public void setAppRuntime(AppInterface paramAppInterface)
  {
    if (this.mAppIntf != paramAppInterface)
    {
      destory();
      this.mAppIntf = paramAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl
 * JD-Core Version:    0.7.0.1
 */