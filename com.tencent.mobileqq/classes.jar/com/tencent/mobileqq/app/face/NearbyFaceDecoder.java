package com.tencent.mobileqq.app.face;

import AvatarInfo.QQHeadInfo;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
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
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  FaceDownloader jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader;
  FaceObserver jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver;
  
  public NearbyFaceDecoder(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader = ((QQAvatarManagerServiceImpl)paramAppInterface.getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceDownloader();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader.addFaceDownloadListener(this);
  }
  
  public void destory()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null))
    {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceObserver = null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader != null) && (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDownloader.removeFaceDownloadListener(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    super.destory();
  }
  
  public Bitmap getBitmapFromCache(int paramInt1, String paramString, int paramInt2, byte paramByte, int paramInt3)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) {
      paramString = null;
    }
    String str;
    Bitmap localBitmap;
    do
    {
      return paramString;
      str = FaceInfo.a(paramInt1, paramString, paramInt2, paramByte, paramInt3);
      localBitmap = ((IQQAvatarManagerService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarManagerService.class, "nearby")).getFaceFromCache(str);
      paramString = localBitmap;
    } while (!QLog.isColorLevel());
    QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "getBitmapFromcache bmpkey = " + str + " and bmp = " + localBitmap);
    return localBitmap;
  }
  
  public void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted,avatar=" + paramBitmap + ",faceInfo=" + paramFaceInfo);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)) {
      return;
    }
    this.iRunningRequests -= 1;
    if ((!this.mReadyRequests.isEmpty()) && (!this.mPause)) {
      runNextTask();
    }
    Object localObject = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.r;
      if (paramBitmap == null) {
        break label316;
      }
      i = FaceInfo.f;
      label117:
      ((FaceInfo)localObject).a(j, i);
      if ((this.mStatDecodeTime) && (paramBitmap != null)) {
        if ((paramBitmap == null) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.r] <= 0L) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.j] <= 0L)) {
          break label365;
        }
      }
    }
    label316:
    label323:
    label365:
    for (long l = localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.r] - localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.j];; l = 0L)
    {
      if (l > 0L)
      {
        i = NetworkUtil.a(BaseApplication.getContext());
        if (i != 1) {
          break label323;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        if (localObject != null) {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onDecodeTaskCompleted.cost=" + l);
        }
        if ((this.mDecodeTaskCompletionListener == null) || (paramBitmap == null)) {
          break;
        }
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
        return;
        i = FaceInfo.g;
        break label117;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        } else {
          localObject = null;
        }
      }
    }
  }
  
  public void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_a_of_type_ComTencentCommonAppAppInterface == null) || (paramFaceInfo == null));
      this.iRunningRequests -= 1;
      if ((paramFaceInfo.jdField_a_of_type_Int == 32) && (paramFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo == null) && ((FaceInfo)this.mInProgress.get(paramFaceInfo.b()) != null)) {
        ((FaceHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(FaceConstant.Nearby.NEAR_BY_FACE_HANDLER)).a(paramFaceInfo);
      }
    } while ((this.mPause) || (this.mReadyRequests.isEmpty()) || (this.iRunningRequests >= this.maxDecodingTask));
    runNextTask();
  }
  
  public void onFaceDownloadFinished(boolean paramBoolean, FaceInfo paramFaceInfo, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished,isSuccess=" + paramBoolean + ",faceInfo=" + paramFaceInfo + ",bitmap=" + paramBitmap);
    }
    if ((paramFaceInfo == null) || (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)) {
      return;
    }
    Object localObject = (FaceInfo)this.mInProgress.remove(paramFaceInfo.b());
    int i;
    if (localObject != null)
    {
      int j = FaceInfo.r;
      if (paramBitmap == null) {
        break label301;
      }
      i = FaceInfo.f;
      label96:
      ((FaceInfo)localObject).a(j, i);
      if ((this.mStatDecodeTime) && (paramBitmap != null)) {
        if ((localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.r] <= 0L) || (localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.j] <= 0L)) {
          break label348;
        }
      }
    }
    label301:
    label309:
    label348:
    for (long l = localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.r] - localObject.jdField_a_of_type_ArrayOfLong[FaceInfo.j];; l = 0L)
    {
      if (l > 0L)
      {
        localObject = "";
        i = NetworkUtil.a(BaseApplication.getContext());
        if (i != 1) {
          break label309;
        }
        localObject = "actNearByFaceShowCostWIFI";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), (String)localObject, true, l, 0L, null, "");
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "onFaceDownloadFinished.cost=" + l);
        }
        if ((this.mDecodeTaskCompletionListener == null) || (paramBitmap == null)) {
          break;
        }
        this.mDecodeTaskCompletionListener.onDecodeTaskCompleted(this.iRunningRequests + this.mReadyRequests.size(), paramFaceInfo.jdField_a_of_type_Int, paramFaceInfo.jdField_a_of_type_JavaLangString, paramBitmap);
        return;
        i = FaceInfo.g;
        break label96;
        if (i == 2) {
          localObject = "actNearByFaceShowCost2G";
        } else if (i == 3) {
          localObject = "actNearByFaceShowCost3G";
        } else if (i == 4) {
          localObject = "actNearByFaceShowCost4G";
        }
      }
    }
  }
  
  public boolean preloadFacesWithFaceInfo(ArrayList<HeadRequest> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "preloadFacesWithFaceInfo.size = " + paramArrayList.size());
    }
    new ArrayList(paramArrayList.size());
    int i = 0;
    if (i < paramArrayList.size())
    {
      HeadRequest localHeadRequest = (HeadRequest)paramArrayList.get(i);
      if (getBitmapFromCache(32, localHeadRequest.jdField_a_of_type_JavaLangString, localHeadRequest.jdField_a_of_type_Int, (byte)3, 0) != null) {}
      for (;;)
      {
        i += 1;
        break;
        requestDecodeFaceWithFaceInfo(localHeadRequest.jdField_a_of_type_JavaLangString, localHeadRequest.jdField_a_of_type_Int, true, 32, true, (byte)1, 3, localHeadRequest.jdField_a_of_type_AvatarInfoQQHeadInfo);
      }
    }
    return true;
  }
  
  public void refreshFaceWithTimeStamp(int paramInt1, String paramString, int paramInt2, long paramLong, int paramInt3) {}
  
  public boolean requestDecodeFace(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace fail , uin = " + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1, paramInt4);
    FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.j, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeStrangeFace, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      return true;
    }
    paramString = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, paramBoolean3, paramInt4);
    paramString.a(FaceInfo.j);
    this.mInProgress.put(str, paramString);
    enqueueDecode(paramString);
    return true;
  }
  
  public boolean requestDecodeFaceWithFaceInfo(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, QQHeadInfo paramQQHeadInfo)
  {
    if ((paramString == null) || (paramString.length() < 5))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo fail , uin = " + paramString);
      }
      return false;
    }
    String str = FaceInfo.a(paramInt2, paramString, paramInt1, 0);
    FaceInfo localFaceInfo = (FaceInfo)this.mInProgress.get(str);
    if ((localFaceInfo != null) && (!localFaceInfo.a(FaceInfo.j, 300000L)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo, uin repeat. uin=" + paramString);
      }
      if ((localFaceInfo.b) && (!paramBoolean2)) {
        localFaceInfo.b = false;
      }
      if (paramQQHeadInfo != null) {
        localFaceInfo.a(paramQQHeadInfo);
      }
      return true;
    }
    localFaceInfo = new FaceInfo(paramInt2, paramString, paramBoolean2, (byte)1, paramInt3, false, paramInt1, 1);
    localFaceInfo.a(paramQQHeadInfo);
    localFaceInfo.a(FaceInfo.j);
    this.mInProgress.put(str, localFaceInfo);
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "requestDecodeFaceWithFaceInfo.uin = " + paramString + ",faceinfo=" + localFaceInfo);
    }
    enqueueDecode(localFaceInfo);
    return true;
  }
  
  protected void runNextTask()
  {
    localObject1 = null;
    do
    {
      try
      {
        FaceInfo localFaceInfo = (FaceInfo)this.mReadyRequests.removeFirst();
        if (localObject1 == null) {
          continue;
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          this.iRunningRequests += 1;
          FaceDecodeTask.execute(FaceDecodeTask.getFaceDecodeTask(this.jdField_a_of_type_ComTencentCommonAppAppInterface, localFaceInfo, this));
          return;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localObject1 = localThrowable1;
            Object localObject2 = localThrowable2;
          }
        }
        localThrowable1 = localThrowable1;
      }
      this.iRunningRequests -= 1;
    } while (!QLog.isColorLevel());
    QLog.i("Q.qqhead.NearbyFaceDecoder", 2, "runNextTask faceInfo is " + localObject1, localThrowable1);
  }
  
  public void setAppRuntime(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != paramAppInterface)
    {
      destory();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.NearbyFaceDecoder
 * JD-Core Version:    0.7.0.1
 */