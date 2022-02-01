package com.tencent.mobileqq.app.generalflag;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.vas.font.api.FontManagerConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import msf.msgsvc.msg_svc.PbSendMsgReq;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class ExtensionInfoGeneralFlagProvider
  implements IGeneralFlagProvider
{
  private static void a(generalflags.ResvAttr paramResvAttr, ExtensionInfo paramExtensionInfo)
  {
    if (paramExtensionInfo.pendantDiyId > 0) {
      paramResvAttr.uint32_pendant_diy_id.set(paramExtensionInfo.pendantDiyId);
    }
    if (paramExtensionInfo.faceId > 0) {
      paramResvAttr.uint32_face_id.set(paramExtensionInfo.faceId);
    }
    if (paramExtensionInfo.fontEffect > 0) {
      paramResvAttr.uint32_req_font_effect_id.set(paramExtensionInfo.fontEffect);
    }
  }
  
  private void a(generalflags.ResvAttr paramResvAttr, ExtensionInfo paramExtensionInfo, String paramString)
  {
    int i;
    if (!TextUtils.isEmpty(paramString)) {
      i = Integer.parseInt(paramString);
    } else {
      i = 0;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("getGeneralFlagElemFromMsg: fontId=");
      paramString.append(paramExtensionInfo.uVipFont);
      paramString.append(" subFontId=");
      paramString.append(i);
      QLog.d("Q.msg.MessageHandlerUtils", 2, paramString.toString());
    }
    paramResvAttr.uint64_subfont_id.set(i);
    if ((paramExtensionInfo.diyFontTimestampMap != null) && (paramExtensionInfo.diyFontTimestampMap.get(Integer.valueOf((int)paramExtensionInfo.uVipFont)) != null)) {
      paramResvAttr.uint32_diy_font_timestamp.set(((Integer)paramExtensionInfo.diyFontTimestampMap.get(Integer.valueOf((int)paramExtensionInfo.uVipFont))).intValue());
    }
  }
  
  public boolean[] a(AppInterface paramAppInterface, boolean paramBoolean1, boolean paramBoolean2, MessageRecord paramMessageRecord, generalflags.ResvAttr paramResvAttr, msg_svc.PbSendMsgReq paramPbSendMsgReq, im_msg_body.GeneralFlags paramGeneralFlags)
  {
    paramAppInterface = ((FriendsManager)paramAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramAppInterface.getCurrentUin());
    if (paramAppInterface != null)
    {
      paramGeneralFlags.uint64_pendant_id.set(paramAppInterface.pendantId);
      paramResvAttr.uint32_mobile_custom_font.set(FontManagerConstants.generateFontValue(paramAppInterface));
      a(paramResvAttr, paramAppInterface, paramMessageRecord.getExtInfoFromExtStr("vip_sub_font_id"));
      a(paramResvAttr, paramAppInterface);
      paramBoolean1 = true;
      paramBoolean2 = true;
    }
    return new boolean[] { paramBoolean1, paramBoolean2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.generalflag.ExtensionInfoGeneralFlagProvider
 * JD-Core Version:    0.7.0.1
 */