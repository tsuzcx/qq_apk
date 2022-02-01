package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;

final class AIOGalleryUtils$1
  extends AsyncTask<Void, Void, Integer>
{
  AIOGalleryUtils$1(Context paramContext, int paramInt, URLDrawable paramURLDrawable, QQAppInterface paramQQAppInterface, StructMsgForImageShare paramStructMsgForImageShare, PicMessageExtraData paramPicMessageExtraData) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    int i = this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus();
    Integer localInteger = Integer.valueOf(1);
    if (i != 1) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.downloadImediatly(false);
    }
    URLDrawable.removeMemoryCacheByUrl(this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString());
    if (this.jdField_a_of_type_ComTencentImageURLDrawable.getTag() == null) {
      return localInteger;
    }
    paramVarArgs = ((MessageForPic)this.jdField_a_of_type_ComTencentImageURLDrawable.getTag()).path;
    paramVarArgs = AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs);
    if (paramVarArgs != null)
    {
      AIOGalleryUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, paramVarArgs);
      return Integer.valueOf(2);
    }
    paramVarArgs = this.jdField_a_of_type_ComTencentImageURLDrawable.getURL().toString();
    if (!AbsDownloader.hasFile(paramVarArgs))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, has file");
      }
      return localInteger;
    }
    File localFile = AbsDownloader.getFile(paramVarArgs);
    paramVarArgs = null;
    if (localFile != null) {
      paramVarArgs = SecUtil.getFileMd5(localFile.getAbsolutePath());
    }
    if (paramVarArgs != null)
    {
      String str = "";
      if (!"".equals(paramVarArgs))
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(AppConstants.SDCARD_IMG_FAVORITE);
        ((StringBuilder)localObject1).append(".nomedia");
        FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData;
        if ((localObject2 != null) && (((PicMessageExtraData)localObject2).isDiyDouTu())) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("_diydoutu@");
          if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId)) {
            str = "0";
          } else {
            str = this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData.emojiId;
          }
          ((StringBuilder)localObject2).append(str);
          str = ((StringBuilder)localObject2).toString();
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(AppConstants.SDCARD_IMG_FAVORITE);
        ((StringBuilder)localObject2).append(DiySecureFileHelper.a((String)localObject1));
        ((StringBuilder)localObject2).append(paramVarArgs);
        ((StringBuilder)localObject2).append(str);
        ((StringBuilder)localObject2).append(".jpg");
        paramVarArgs = ((StringBuilder)localObject2).toString();
        try
        {
          FileUtils.copyFile(localFile, new File(paramVarArgs));
          return Integer.valueOf(AIOGalleryUtils.a(this.jdField_a_of_type_AndroidContentContext, paramVarArgs, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare, this.jdField_a_of_type_ComTencentMobileqqDataPicMessageExtraData));
        }
        catch (Exception paramVarArgs)
        {
          QLog.d("AIOGalleryUtils", 1, paramVarArgs, new Object[0]);
          return localInteger;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryUtils", 2, "addCustomEmotionFromDownLoad fail, md5 is null");
    }
    return localInteger;
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131694906, 0).b(this.jdField_a_of_type_Int);
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2004", 1);
      return;
    }
    if (paramInteger.intValue() == 2)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, 2131689646, 0).b(this.jdField_a_of_type_Int);
      EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus("2003", 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryUtils.1
 * JD-Core Version:    0.7.0.1
 */