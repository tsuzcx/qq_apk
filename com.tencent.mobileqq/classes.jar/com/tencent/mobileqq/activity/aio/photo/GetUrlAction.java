package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class GetUrlAction
  implements Callback
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private IAIOImageProviderCallBack jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MessageForShortVideo jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
  private String jdField_a_of_type_JavaLangString;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int b;
  private int c;
  
  public GetUrlAction(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, IAIOImageProviderCallBack paramIAIOImageProviderCallBack, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo = paramMessageForShortVideo;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = paramIAIOImageProviderCallBack;
    this.jdField_a_of_type_Long = paramLong;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  private void a(FileMsg paramFileMsg)
  {
    int i = paramFileMsg.status;
    if (i != 2002)
    {
      if (i != 2003)
      {
        if (i != 2005)
        {
          if (i != 5001)
          {
            if (i != 5002) {
              return;
            }
            this.jdField_a_of_type_Int = paramFileMsg.errorCode;
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("handleMessage STATUS_FILE_EXPIRED  error = ");
              paramFileMsg.append(this.jdField_a_of_type_Int);
              QLog.d("carverW GetUrlAction", 2, paramFileMsg.toString());
            }
          }
          else
          {
            this.jdField_a_of_type_Int = paramFileMsg.errorCode;
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("handleMessage STATUS_FILE_UNSAFE  error = ");
              paramFileMsg.append(this.jdField_a_of_type_Int);
              QLog.d("carverW GetUrlAction", 2, paramFileMsg.toString());
            }
          }
        }
        else
        {
          this.jdField_a_of_type_Int = paramFileMsg.errorCode;
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("handleMessage STATUS_RECV_ERROR  error = ");
            paramFileMsg.append(this.jdField_a_of_type_Int);
            QLog.d("carverW GetUrlAction", 2, paramFileMsg.toString());
          }
        }
      }
      else if (QLog.isColorLevel()) {
        QLog.d("carverW GetUrlAction", 2, "handleMessage STATUS_RECV_FINISHED");
      }
    }
    else
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("STATUS_RECV_PROCESS: get url finished urls=");
        ((StringBuilder)localObject).append(paramFileMsg.urls);
        ((StringBuilder)localObject).append(" domain =");
        ((StringBuilder)localObject).append(paramFileMsg.domain);
        ((StringBuilder)localObject).append(" mMsg=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
        QLog.d("carverW GetUrlAction", 2, ((StringBuilder)localObject).toString());
      }
      if (paramFileMsg.urls != null)
      {
        this.jdField_a_of_type_ArrayOfJavaLangString = paramFileMsg.urls;
        this.jdField_a_of_type_JavaLangString = paramFileMsg.domain;
        i = 0;
        while (i < 1)
        {
          if (!StringUtil.a(this.jdField_a_of_type_JavaLangString))
          {
            localObject = new StringBuilder();
            String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
            ((StringBuilder)localObject).append(arrayOfString[i]);
            ((StringBuilder)localObject).append("&txhost=");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
            arrayOfString[i] = ((StringBuilder)localObject).toString();
          }
          i += 1;
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
        if ((localObject != null) && (MessageForShortVideo.class.isInstance(localObject)) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack != null))
        {
          localObject = SVUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, "mp4");
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a(this.jdField_a_of_type_Long, this.b, this.c, (String)localObject, this.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, paramFileMsg.fileType, null);
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin;
    long l = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq;
    localObject = ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    FileTransferManager localFileTransferManager = FileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localFileTransferManager != null) {
      localFileTransferManager.a((View)localObject, this);
    }
    localObject = SVBusiUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo, 1);
    if (localObject != null) {
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo;
    if ((paramView != null) && (paramView.uniseq == paramFileMsg.uniseq))
    {
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append(" handleMessage what==");
        paramView.append(paramInt1);
        paramView.append(", arg1:");
        paramView.append(paramInt2);
        paramView.append(" fileType=");
        paramView.append(paramFileMsg.fileType);
        paramView.append(" status=");
        paramView.append(paramFileMsg.status);
        paramView.append(" msg.id=");
        paramView.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq);
        QLog.d("carverW GetUrlAction", 2, paramView.toString());
      }
      if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 20)) {
        a(paramFileMsg);
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append(" handleMessage return file.uniseq=");
      paramView.append(paramFileMsg.uniseq);
      QLog.d("carverW GetUrlAction", 2, paramView.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.GetUrlAction
 * JD-Core Version:    0.7.0.1
 */