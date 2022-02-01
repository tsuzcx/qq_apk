package com.tencent.mobileqq.activity.aio.helper;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.weiyun.api.IOpenWeiyunVipHelper;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.weiyun.api.IWeiyunSaveTipsHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class FMHelper$MyFMObserver
  extends FMObserver
{
  private FMHelper$MyFMObserver(FMHelper paramFMHelper) {}
  
  protected void a()
  {
    FMHelper.a(this.a).an();
  }
  
  protected void a(int paramInt, long paramLong, String paramString)
  {
    FileManagerUtil.a(paramLong, paramInt, paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt);
    FMHelper.a(this.a).an();
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    FMHelper.a(this.a).an();
  }
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FMHelper.a(this.a).an();
  }
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2)
  {
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      FileManagerUtil.a(paramString2);
      return;
    }
    FileManagerUtil.a(paramLong);
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      FileManagerUtil.a(paramString);
    }
    FMHelper.a(this.a).an();
  }
  
  protected void a(ThumbnailInfo paramThumbnailInfo)
  {
    if (paramThumbnailInfo == null) {
      return;
    }
    if ((paramThumbnailInfo.a instanceof FileManagerEntity))
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramThumbnailInfo.a;
      if ((paramThumbnailInfo.b != null) && (paramThumbnailInfo.b.length() > 0))
      {
        localFileManagerEntity.strThumbPath = paramThumbnailInfo.b;
        FMHelper.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        FMHelper.a(this.a).an();
        return;
      }
      if (localFileManagerEntity.thumbInvalidCode == 1)
      {
        FMHelper.a(this.a).getFileManagerDataCenter().c(localFileManagerEntity);
        FMHelper.a(this.a).an();
      }
    }
  }
  
  protected void a(Integer paramInteger, long paramLong, String paramString)
  {
    FMHelper.a(this.a).an();
    FileManagerUtil.a(paramLong, paramInteger.intValue(), paramString);
    ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInteger.intValue());
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FMHelper.a(this.a).an();
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnFileTransferEnd : isSuccess[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], uniseq[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], nSessionId[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], peerType[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("]");
      QLog.d("FMHelper", 2, localStringBuilder.toString());
    }
    paramString1 = FMHelper.a(this.a).getFileManagerDataCenter().a(paramLong2);
    if ((paramString1 != null) && (paramString1.nOpType == 6))
    {
      if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(paramInt2)) {
        if (paramBoolean)
        {
          ((IWeiyunSaveTipsHelper)QRoute.api(IWeiyunSaveTipsHelper.class)).showTopTips(FMHelper.a(this.a), FMHelper.a(this.a).a(), AIOUtils.a(FMHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
        }
        else if (((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips())
        {
          ((IWeiyunResponseHandler)QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(FMHelper.a(this.a));
        }
        else
        {
          if (!TextUtils.isEmpty(paramString2)) {
            QQToast.a(FMHelper.a(this.a).getApp(), paramString2, 1).b(AIOUtils.a(FMHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
          } else {
            QQToast.a(FMHelper.a(this.a).getApp(), 2131692689, 1).b(AIOUtils.a(FMHelper.a(this.a).jdField_a_of_type_AndroidContentContext));
          }
          ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt2);
        }
      }
    }
    else if ((!paramBoolean) && (paramString1 != null) && (!TextUtils.isEmpty(paramString1.peerUin)) && (paramString1.peerUin.equalsIgnoreCase(FMHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)))
    {
      FileManagerUtil.a(paramLong2, paramInt2, paramString2);
      ((IOpenWeiyunVipHelper)QRoute.api(IOpenWeiyunVipHelper.class)).showWeiYunSpaceOrFlowLimitDialog(null, paramInt2);
    }
    FMHelper.a(this.a).an();
  }
  
  protected void b()
  {
    FMHelper.a(this.a).an();
  }
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt)
  {
    FMHelper.a(this.a).an();
  }
  
  protected void c()
  {
    FMHelper.a(this.a).an();
  }
  
  protected void d()
  {
    FMHelper.a(this.a).an();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FMHelper.MyFMObserver
 * JD-Core Version:    0.7.0.1
 */