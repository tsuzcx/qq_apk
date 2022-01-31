package com.tencent.device.msg.data;

import alpo;
import android.os.Parcelable.Creator;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qphone.base.util.BaseApplication;
import ztq;

public class MessageForDevShortVideo
  extends MessageForShortVideo
{
  public static final Parcelable.Creator<MessageForShortVideo> CREATOR = new ztq();
  public long fileSessionId;
  
  public String getSummary()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localObject;
    }
    switch (this.videoFileStatus)
    {
    default: 
      return null;
    case 2003: 
      return alpo.a(2131706974);
    case 1003: 
      return ((QQAppInterface)localObject).getApp().getString(2131691353);
    case 1005: 
      return ((QQAppInterface)localObject).getApp().getString(2131691353);
    }
    return alpo.a(2131706969);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.device.msg.data.MessageForDevShortVideo
 * JD-Core Version:    0.7.0.1
 */