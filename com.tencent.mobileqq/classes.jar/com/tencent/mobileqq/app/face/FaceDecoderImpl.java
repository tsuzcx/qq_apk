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
    if ((paramInt1 == 1001) && (paramString != null) && (!AvatarUtil.a(paramString))) {
      localObject = AvatarUtil.c(paramString);
    } else {
      localObject = paramString;
    }
    int i = paramInt1;
    if (paramInt1 == 4)
    {
      i = paramInt1;
      if (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(paramString)) {
        i = 113;
      }
    }
    if (i == 113) {
      paramByte = 3;
    }
    paramByte = AvatarUtil.a(paramByte);
    IQQAvatarDataService localIQQAvatarDataService = (IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "");
    Object localObject = localIQQAvatarDataService.getBitmapFromCache(localIQQAvatarDataService.getFaceBitmapCacheKey(i, (String)localObject, paramByte, paramInt2, paramInt3, true));
    if ((localObject != null) && (i == 1001))
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
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (paramFaceInfo != null)
    {
      if (this.mAppIntf == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDecodeTaskCompleted, faceInfo=");
        ((StringBuilder)localObject).append(paramFaceInfo.toString());
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.iRunningRequests -= 1;
      if ((!this.mReadyRequests.isEmpty()) && (!this.mPause)) {
        runNextTask();
      }
      Object localObject = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
      if (localObject != null)
      {
        int j = FaceInfo.r;
        int i;
        if (paramBitmap != null) {
          i = FaceInfo.f;
        } else {
          i = FaceInfo.g;
        }
        ((FaceInfo)localObject).a(j, i);
      }
      if ((this.mDecodeTaskCompletionListener != null) && (paramBitmap != null)) {
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
      }
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo != null)
    {
      if (this.mAppIntf == null) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramAppInterface = new StringBuilder();
        paramAppInterface.append("onDecodeTaskCompletedNeedDownload, faceInfo=");
        paramAppInterface.append(paramFaceInfo.toString());
        QLog.i("Q.qqhead.FaceDecoderImpl", 2, paramAppInterface.toString());
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
      if ((!this.mPause) && (!this.mReadyRequests.isEmpty()) && (this.iRunningRequests < this.maxDecodingTask)) {
        runNextTask();
      }
    }
  }
  
  protected void onUpdateHead(boolean paramBoolean, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    if (this.mAppIntf == null) {
      return;
    }
    Object localObject = FaceInfo.a(paramInt1, paramString, paramInt2, paramInt3);
    if ((paramBoolean) && (!this.mPause))
    {
      Bitmap localBitmap = getBitmapFromCache(paramInt1, paramString, paramInt2, (byte)3, paramInt3);
      if (localBitmap != null)
      {
        localObject = (FaceInfo)this.mInProgress.remove(localObject);
        if (localObject != null) {
          ((FaceInfo)localObject).a(FaceInfo.r, FaceInfo.f);
        }
        if (this.mDecodeTaskCompletionListener != null) {
          this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramInt1, paramString, localBitmap);
        }
      }
      else
      {
        paramString = (FaceInfo)this.mInProgress.get(localObject);
        if (paramString != null)
        {
          enqueueDecode(paramString);
          return;
        }
        paramString = (FaceInfo)this.mRefreshMap.remove(localObject);
        if (paramString != null)
        {
          paramString.a(FaceInfo.j);
          this.mInProgress.put(localObject, paramString);
          enqueueDecode(paramString);
        }
      }
    }
    else
    {
      paramString = (FaceInfo)this.mInProgress.remove(localObject);
      if (paramString != null)
      {
        paramInt2 = FaceInfo.r;
        if (!paramBoolean) {
          paramInt1 = FaceInfo.g;
        } else {
          paramInt1 = FaceInfo.h;
        }
        paramString.a(paramInt2, paramInt1);
      }
    }
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    return false;
  }
  
  public void refreshApolloFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      Object localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(116, paramString, 200);
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        long l = ((Setting)((Pair)localObject).second).headImgTimestamp;
        if (l != paramLong)
        {
          localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
          if (localObject != null) {
            ((IQQAvatarHandlerService)localObject).getApolloHead(paramString, (byte)1, (byte)0, paramInt);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshApolloFaceWithTimeStamp id=");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", sizeType =");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", timestamp=");
            ((StringBuilder)localObject).append(paramLong);
            ((StringBuilder)localObject).append(",headImgTimestamp=");
            ((StringBuilder)localObject).append(l);
            QLog.d("Q.qqhead.qaif", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L))
    {
      if (this.mAppIntf == null) {
        return;
      }
      if ((paramInt1 == 32) && (paramInt2 != 200) && (paramInt2 != 200) && (paramInt2 != 204)) {
        return;
      }
      byte b;
      if (paramInt1 == 32) {
        b = 1;
      } else {
        b = 0;
      }
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
      if (paramInt1 == 32)
      {
        refreshStrangerFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
      if (paramInt1 == 16)
      {
        refreshQCallFaceWithTimeStamp(paramString, paramInt2, paramLong);
        return;
      }
      if (paramInt1 == 116) {
        refreshApolloFaceWithTimeStamp(paramString, paramInt3, paramLong);
      }
    }
  }
  
  public void refreshQCallFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      if ((paramInt != 200) && (paramInt != 204) && (paramInt != 202)) {
        return;
      }
      Object localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(16, paramString, paramInt);
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        long l = ((Setting)((Pair)localObject).second).headImgTimestamp;
        if (l != paramLong)
        {
          localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
          if (localObject != null) {
            ((IQQAvatarHandlerService)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshQCallFaceWithTimeStamp id=");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", idtype =");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", timestamp=");
            ((StringBuilder)localObject).append(paramLong);
            ((StringBuilder)localObject).append(",headImgTimestamp=");
            ((StringBuilder)localObject).append(l);
            QLog.d("Q.qqhead.qaif", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public void refreshStrangerFaceWithTimeStamp(String paramString, int paramInt, long paramLong)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramLong <= 0L) {
        return;
      }
      if ((paramInt != 200) && (paramInt != 204) && (paramInt != 202)) {
        return;
      }
      Object localObject = ((IQQAvatarDataService)this.mAppIntf.getRuntimeService(IQQAvatarDataService.class, "")).getQQHeadSetting(32, paramString, paramInt);
      if ((localObject != null) && (((Pair)localObject).second != null))
      {
        long l = ((Setting)((Pair)localObject).second).headImgTimestamp;
        if (l != paramLong)
        {
          localObject = (IQQAvatarHandlerService)this.mAppIntf.getRuntimeService(IQQAvatarHandlerService.class, "");
          if (localObject != null) {
            ((IQQAvatarHandlerService)localObject).getStrangerHead(paramString, paramInt, (byte)1, (byte)0);
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("refreshStrangerFaceWithTimeStamp id=");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", idtype =");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", timestamp=");
            ((StringBuilder)localObject).append(paramLong);
            ((StringBuilder)localObject).append(",headImgTimestamp=");
            ((StringBuilder)localObject).append(l);
            QLog.d("Q.qqhead.qaif", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() >= 5))
    {
      byte b2 = 3;
      byte b1;
      if (paramInt3 == 0)
      {
        b1 = b2;
        if (paramInt2 != 101) {
          b1 = b2;
        }
      }
      else
      {
        b1 = (byte)paramInt3;
      }
      paramInt3 = AvatarUtil.a(b1);
      localObject = FaceInfo.a(paramInt2, paramString, paramInt1, paramInt4);
      FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(localObject);
      if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.j, 300000L)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestDecodeFace, uin repeat. uin=");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("Q.qqhead.FaceDecoderImpl", 2, ((StringBuilder)localObject).toString());
        }
        if ((localFaceInfo.b) && (!paramBoolean2)) {
          localFaceInfo.b = false;
        }
        localFaceInfo.c = paramInt3;
        return true;
      }
      paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, paramByte, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
      paramString.a(FaceInfo.j);
      this.mInProgress.put(localObject, paramString);
      enqueueDecode(paramString);
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDecodeFace fail. type=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", uin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("Q.qqhead.FaceDecoderImpl", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    return false;
  }
  
  protected void runNextTask()
  {
    if (this.mReadyRequests.isEmpty())
    {
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, " runNextTask, mReadyRequests is empty");
      return;
    }
    FaceInfo localFaceInfo;
    try
    {
      localFaceInfo = (FaceInfo)this.mReadyRequests.removeFirst();
      try
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append(" runNextTask, faceinfo=");
          localStringBuilder1.append(localFaceInfo.toString());
          QLog.i("Q.qqhead.FaceDecoderImpl", 2, localStringBuilder1.toString());
        }
        if (((localFaceInfo.jdField_a_of_type_Int == 101) || (localFaceInfo.jdField_a_of_type_Int == 1001)) && (this.mDiscussObserver == null))
        {
          this.mDiscussObserver = new FaceDecoderImpl.MyDiscussionObserver(this, null);
          this.mAppIntf.addObserver(this.mDiscussObserver);
        }
        if (((localFaceInfo.jdField_a_of_type_Int == 4) || (localFaceInfo.jdField_a_of_type_Int == 113)) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).hasSetTroopHead(localFaceInfo.jdField_a_of_type_JavaLangString)))
        {
          if (this.mTroopHeaderObserver == null) {
            this.mTroopHeaderObserver = new FaceDecoderImpl.MyTroopHeaderObserver(this, null);
          }
          this.mAppIntf.addObserver(this.mTroopHeaderObserver);
        }
        this.iRunningRequests += 1;
        FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.mAppIntf, localFaceInfo, this));
        return;
      }
      catch (Throwable localThrowable1) {}
      if (localFaceInfo == null) {
        break label234;
      }
    }
    catch (Throwable localThrowable2)
    {
      localFaceInfo = null;
    }
    this.iRunningRequests -= 1;
    label234:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("runNextTask exception and info is ");
      localStringBuilder2.append(localFaceInfo);
      QLog.i("Q.qqhead.FaceDecoderImpl", 2, localStringBuilder2.toString(), localThrowable2);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl
 * JD-Core Version:    0.7.0.1
 */