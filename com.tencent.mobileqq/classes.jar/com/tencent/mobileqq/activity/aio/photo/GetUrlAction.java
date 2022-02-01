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
  private String[] a;
  private String b;
  private int c = 0;
  private QQAppInterface d;
  private MessageForShortVideo e;
  private IAIOImageProviderCallBack f;
  private long g;
  private int h;
  private int i;
  
  public GetUrlAction(QQAppInterface paramQQAppInterface, MessageForShortVideo paramMessageForShortVideo, IAIOImageProviderCallBack paramIAIOImageProviderCallBack, long paramLong, int paramInt1, int paramInt2)
  {
    this.d = paramQQAppInterface;
    this.e = paramMessageForShortVideo;
    this.f = paramIAIOImageProviderCallBack;
    this.g = paramLong;
    this.h = paramInt1;
    this.i = paramInt2;
  }
  
  private void a(FileMsg paramFileMsg)
  {
    int j = paramFileMsg.status;
    if (j != 2002)
    {
      if (j != 2003)
      {
        if (j != 2005)
        {
          if (j != 5001)
          {
            if (j != 5002) {
              return;
            }
            this.c = paramFileMsg.errorCode;
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("handleMessage STATUS_FILE_EXPIRED  error = ");
              paramFileMsg.append(this.c);
              QLog.d("carverW GetUrlAction", 2, paramFileMsg.toString());
            }
          }
          else
          {
            this.c = paramFileMsg.errorCode;
            if (QLog.isColorLevel())
            {
              paramFileMsg = new StringBuilder();
              paramFileMsg.append("handleMessage STATUS_FILE_UNSAFE  error = ");
              paramFileMsg.append(this.c);
              QLog.d("carverW GetUrlAction", 2, paramFileMsg.toString());
            }
          }
        }
        else
        {
          this.c = paramFileMsg.errorCode;
          if (QLog.isColorLevel())
          {
            paramFileMsg = new StringBuilder();
            paramFileMsg.append("handleMessage STATUS_RECV_ERROR  error = ");
            paramFileMsg.append(this.c);
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
        ((StringBuilder)localObject).append(this.e);
        QLog.d("carverW GetUrlAction", 2, ((StringBuilder)localObject).toString());
      }
      if (paramFileMsg.urls != null)
      {
        this.a = paramFileMsg.urls;
        this.b = paramFileMsg.domain;
        j = 0;
        while (j < 1)
        {
          if (!StringUtil.isEmpty(this.b))
          {
            localObject = new StringBuilder();
            String[] arrayOfString = this.a;
            ((StringBuilder)localObject).append(arrayOfString[j]);
            ((StringBuilder)localObject).append("&txhost=");
            ((StringBuilder)localObject).append(this.b);
            arrayOfString[j] = ((StringBuilder)localObject).toString();
          }
          j += 1;
        }
        localObject = this.e;
        if ((localObject != null) && (MessageForShortVideo.class.isInstance(localObject)) && (this.f != null))
        {
          localObject = SVUtils.a(this.e, "mp4");
          this.f.a(this.g, this.h, this.i, (String)localObject, this.a, this.b, this.e, paramFileMsg.fileType, null);
        }
      }
    }
  }
  
  public void a()
  {
    Object localObject = this.e.frienduin;
    long l = this.e.uniseq;
    localObject = ((ITransFileController)this.d.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject, l);
    if ((localObject != null) && ((localObject instanceof BaseDownloadProcessor))) {
      ((BaseDownloadProcessor)localObject).cancel();
    }
    localObject = new View(BaseApplicationImpl.getApplication());
    FileTransferManager localFileTransferManager = FileTransferManager.a(this.d);
    if (localFileTransferManager != null) {
      localFileTransferManager.a((View)localObject, this);
    }
    localObject = SVBusiUtil.a(this.d, this.e, 1);
    if (localObject != null) {
      ShortVideoBusiManager.a((ShortVideoReq)localObject, this.d);
    }
  }
  
  public void handleMessage(View paramView, FileMsg paramFileMsg, int paramInt1, int paramInt2)
  {
    paramView = this.e;
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
        paramView.append(this.e.uniseq);
        QLog.d("carverW GetUrlAction", 2, paramView.toString());
      }
      if ((paramFileMsg.fileType == 6) || (paramFileMsg.fileType == 17) || (paramFileMsg.fileType == 9) || (paramFileMsg.fileType == 67) || (paramFileMsg.fileType == 20)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.GetUrlAction
 * JD-Core Version:    0.7.0.1
 */