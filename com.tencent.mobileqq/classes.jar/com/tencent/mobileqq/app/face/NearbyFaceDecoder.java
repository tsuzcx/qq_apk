package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.avatar.api.IQQAvatarManagerService;
import com.tencent.mobileqq.avatar.api.impl.QQAvatarManagerServiceImpl;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.HeadRequest;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class NearbyFaceDecoder
  extends FaceDecoderBase
  implements DecodeCompletionListener, FaceDownloader.FaceDownloadListener
{
  AppInterface a;
  FaceObserver b;
  FaceDownloader c;
  
  public NearbyFaceDecoder(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
    this.c = ((QQAvatarManagerServiceImpl)paramAppInterface.getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceDownloader();
    this.c.addFaceDownloadListener(this);
  }
  
  public void destory()
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      AppInterface localAppInterface = this.a;
      if (localAppInterface != null)
      {
        localAppInterface.removeObserver((BusinessObserver)localObject);
        this.b = null;
      }
    }
    localObject = this.c;
    if ((localObject != null) && (this.a != null)) {
      ((FaceDownloader)localObject).removeFaceDownloadListener(this);
    }
    this.a = null;
    super.destory();
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte, int paramInt3)
  {
    if (this.a == null) {
      return null;
    }
    paramString = FaceInfo.a(paramInt1, paramString, paramInt2, paramByte, paramInt3);
    Bitmap localBitmap = ((IQQAvatarManagerService)this.a.getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceFromCache(paramString);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapFromcache bmpkey = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" and bmp = ");
      localStringBuilder.append(localBitmap);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, localStringBuilder.toString());
    }
    return localBitmap;
  }
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDecodeTaskCompleted,avatar=");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",faceInfo=");
      ((StringBuilder)localObject).append(paramFaceInfo);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFaceInfo != null)
    {
      if (this.a == null) {
        return;
      }
      this.iRunningRequests -= 1;
      if ((!this.mReadyRequests.isEmpty()) && (!this.mPause)) {
        runNextTask();
      }
      localObject = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
      if (localObject != null)
      {
        int j = FaceInfo.D;
        int i;
        if (paramBitmap != null) {
          i = FaceInfo.r;
        } else {
          i = FaceInfo.s;
        }
        ((FaceInfo)localObject).a(j, i);
        if ((this.mStatDecodeTime) && (paramBitmap != null))
        {
          long l;
          if ((paramBitmap != null) && (localObject.o[FaceInfo.D] > 0L) && (localObject.o[FaceInfo.v] > 0L)) {
            l = localObject.o[FaceInfo.D] - localObject.o[FaceInfo.v];
          } else {
            l = 0L;
          }
          if (l > 0L)
          {
            localObject = null;
            i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            if (i == 1) {
              localObject = "actNearByFaceShowCostWIFI";
            }
            for (;;)
            {
              break;
              if (i == 2) {
                localObject = "actNearByFaceShowCost2G";
              } else if (i == 3) {
                localObject = "actNearByFaceShowCost3G";
              } else if (i == 4) {
                localObject = "actNearByFaceShowCost4G";
              }
            }
            if (localObject != null) {
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onDecodeTaskCompleted.cost=");
              ((StringBuilder)localObject).append(l);
              QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      if ((this.mDecodeTaskCompletionListener != null) && (paramBitmap != null)) {
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.b, paramFaceInfo.c, paramBitmap);
      }
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {
      return;
    }
    if (this.a != null)
    {
      if (paramFaceInfo == null) {
        return;
      }
      this.iRunningRequests -= 1;
      if ((paramFaceInfo.b == 32) && (paramFaceInfo.p == null) && ((FaceInfo)this.mInProgress.get(paramFaceInfo.b()) != null)) {
        ((FaceHandler)this.a.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).a(paramFaceInfo);
      }
      if ((!this.mPause) && (!this.mReadyRequests.isEmpty()) && (this.iRunningRequests < this.maxDecodingTask)) {
        runNextTask();
      }
    }
  }
  
  public void onFaceDownloadFinished(boolean paramBoolean, FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFaceDownloadFinished,isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",faceInfo=");
      ((StringBuilder)localObject).append(paramFaceInfo);
      ((StringBuilder)localObject).append(",bitmap=");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFaceInfo != null)
    {
      if (this.a == null) {
        return;
      }
      localObject = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
      if (localObject != null)
      {
        int j = FaceInfo.D;
        int i;
        if (paramBitmap != null) {
          i = FaceInfo.r;
        } else {
          i = FaceInfo.s;
        }
        ((FaceInfo)localObject).a(j, i);
        if ((this.mStatDecodeTime) && (paramBitmap != null))
        {
          long l;
          if ((localObject.o[FaceInfo.D] > 0L) && (localObject.o[FaceInfo.v] > 0L)) {
            l = localObject.o[FaceInfo.D] - localObject.o[FaceInfo.v];
          } else {
            l = 0L;
          }
          if (l > 0L)
          {
            i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
            if (i == 1) {
              localObject = "actNearByFaceShowCostWIFI";
            }
            for (;;)
            {
              break;
              if (i == 2) {
                localObject = "actNearByFaceShowCost2G";
              } else if (i == 3) {
                localObject = "actNearByFaceShowCost3G";
              } else if (i == 4) {
                localObject = "actNearByFaceShowCost4G";
              } else {
                localObject = "";
              }
            }
            if (!TextUtils.isEmpty((CharSequence)localObject)) {
              StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.a.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
            }
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("onFaceDownloadFinished.cost=");
              ((StringBuilder)localObject).append(l);
              QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
            }
          }
        }
      }
      if ((this.mDecodeTaskCompletionListener != null) && (paramBitmap != null)) {
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.b, paramFaceInfo.c, paramBitmap);
      }
    }
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    int i = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() <= 0) {
        return false;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("preloadFacesWithFaceInfo.size = ");
        ((StringBuilder)localObject).append(paramArrayList.size());
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
      }
      new ArrayList(paramArrayList.size());
      while (i < paramArrayList.size())
      {
        localObject = (HeadRequest)paramArrayList.get(i);
        if (getBitmapFromCache(32, ((HeadRequest)localObject).a, ((HeadRequest)localObject).b, (byte)3, 0) == null) {
          requestDecodeFaceWithFaceInfo(((HeadRequest)localObject).a, ((HeadRequest)localObject).b, true, 32, true, (byte)1, 3, ((HeadRequest)localObject).d);
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3) {}
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    Object localObject;
    if ((paramString != null) && (paramString.length() >= 5))
    {
      localObject = FaceInfo.a(paramInt2, paramString, paramInt1, paramInt4);
      FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(localObject);
      if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.v, 300000L)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestDecodeStrangeFace, uin repeat. uin=");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
        }
        if ((localFaceInfo.h) && (!paramBoolean2)) {
          localFaceInfo.h = false;
        }
        return true;
      }
      paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
      paramString.a(FaceInfo.v);
      this.mInProgress.put(localObject, paramString);
      enqueueDecode(paramString);
      return true;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDecodeStrangeFace fail , uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    if ((paramString != null) && (paramString.length() >= 5))
    {
      Object localObject = FaceInfo.a(paramInt2, paramString, paramInt1, 0);
      FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(localObject);
      if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.v, 300000L)))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestDecodeFaceWithFaceInfo, uin repeat. uin=");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, ((StringBuilder)localObject).toString());
        }
        if ((localFaceInfo.h) && (!paramBoolean2)) {
          localFaceInfo.h = false;
        }
        if (paramQQHeadInfo != null) {
          localFaceInfo.a(paramQQHeadInfo);
        }
        return true;
      }
      localFaceInfo = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, 1);
      localFaceInfo.a(paramQQHeadInfo);
      localFaceInfo.a(FaceInfo.v);
      this.mInProgress.put(localObject, localFaceInfo);
      if (QLog.isColorLevel())
      {
        paramQQHeadInfo = new StringBuilder();
        paramQQHeadInfo.append("requestDecodeFaceWithFaceInfo.uin = ");
        paramQQHeadInfo.append(paramString);
        paramQQHeadInfo.append(",faceinfo=");
        paramQQHeadInfo.append(localFaceInfo);
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, paramQQHeadInfo.toString());
      }
      enqueueDecode(localFaceInfo);
      return true;
    }
    if (QLog.isColorLevel())
    {
      paramQQHeadInfo = new StringBuilder();
      paramQQHeadInfo.append("requestDecodeFaceWithFaceInfo fail , uin = ");
      paramQQHeadInfo.append(paramString);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, paramQQHeadInfo.toString());
    }
    return false;
  }
  
  protected void runNextTask()
  {
    FaceInfo localFaceInfo;
    try
    {
      localFaceInfo = (FaceInfo)this.mReadyRequests.removeFirst();
      try
      {
        this.iRunningRequests += 1;
        FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.a, localFaceInfo, this));
        return;
      }
      catch (Throwable localThrowable1) {}
      if (localFaceInfo == null) {
        break label55;
      }
    }
    catch (Throwable localThrowable2)
    {
      localFaceInfo = null;
    }
    this.iRunningRequests -= 1;
    label55:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("runNextTask faceInfo is ");
      localStringBuilder.append(localFaceInfo);
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, localStringBuilder.toString(), localThrowable2);
    }
  }
  
  public void setAppRuntime(AppInterface paramAppInterface)
  {
    if (this.a != paramAppInterface)
    {
      destory();
      this.a = paramAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearbyFaceDecoder
 * JD-Core Version:    0.7.0.1
 */