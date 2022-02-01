package com.tencent.comic.api.impl;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicEmoticonService.IQQComicEmoUploadCallback;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msg.im_msg_body.RichText;

class QQComicEmoticonServiceImpl$1
  implements UpCallBack
{
  QQComicEmoticonServiceImpl$1(QQComicEmoticonServiceImpl paramQQComicEmoticonServiceImpl) {}
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult != null)
    {
      if (this.a.mOnInvokeFinishListener == null) {
        return;
      }
      if (paramSendResult.a == 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Upload finish, id=");
          ((StringBuilder)localObject).append(paramSendResult.f);
          QLog.d("VipComicEmoticonUploader", 2, ((StringBuilder)localObject).toString());
        }
        localObject = new Bundle();
        ((Bundle)localObject).putInt("result", 0);
        ((Bundle)localObject).putString("id", paramSendResult.f);
        this.a.mOnInvokeFinishListener.a((Bundle)localObject);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploader", 2, "Upload error");
      }
      Object localObject = new Bundle();
      ((Bundle)localObject).putInt("result", 1);
      ((Bundle)localObject).putInt("errCode", paramSendResult.b);
      ((Bundle)localObject).putString("errMsg", paramSendResult.c);
      this.a.mOnInvokeFinishListener.a((Bundle)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicEmoticonServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */