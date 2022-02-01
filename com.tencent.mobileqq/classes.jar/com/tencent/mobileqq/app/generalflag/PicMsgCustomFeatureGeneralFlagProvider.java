package com.tencent.mobileqq.app.generalflag;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.zhitu.ZhituManager;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class PicMsgCustomFeatureGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private static boolean a(MessageRecord paramMessageRecord, boolean paramBoolean, generalflags.ResvAttr paramResvAttr)
  {
    boolean bool = paramBoolean;
    if ((paramMessageRecord instanceof MessageForPic))
    {
      bool = paramBoolean;
      if (ZhituManager.b((MessageForPic)paramMessageRecord))
      {
        paramBoolean = true;
        paramResvAttr.uint32_custom_featureid.set(33025);
        bool = paramBoolean;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.msg.MessageHandlerUtils", 2, "getGeneralFlagElemFromMsg [zhitu] set uint32_custom_featureid ");
          bool = paramBoolean;
        }
      }
    }
    return bool;
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    return new boolean[] { paramBoolean1, a(paramMessageRecord, paramBoolean2, paramResvAttr) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.PicMsgCustomFeatureGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */