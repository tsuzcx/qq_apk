package com.tencent.mobileqq.activity;

import aaod;
import ajyc;
import android.content.Context;
import android.text.TextUtils;
import anqu;
import askc;
import askd;
import awzw;
import axaq;
import bbev;
import bbrj;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public final class ChatActivityFacade$20
  implements Runnable
{
  public ChatActivityFacade$20(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Context paramContext, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = ((askd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    if (localObject1 == null)
    {
      localObject2 = new StringBuilder().append("sendEmosmMsg ePackage == null name:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", epid_eid:");
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId == null) {
          break label208;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
        label95:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("_");
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId == null) {
          break label215;
        }
      }
      label208:
      label215:
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;; localObject1 = "~")
      {
        QLog.e("ChatActivityFacade", 1, (String)localObject1);
        bbrj.a("emotionType", "emotionActionSend", "3", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, bbev.b(this.jdField_a_of_type_AndroidContentContext) + "", "", "", "", "");
        return;
        localObject1 = "~";
        break;
        localObject1 = "~";
        break label95;
      }
    }
    Object localObject2 = new MarkFaceMessage();
    if (aaod.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
      ((MarkFaceMessage)localObject2).isReword = true;
    }
    ((MarkFaceMessage)localObject2).cSubType = ((EmoticonPackage)localObject1).type;
    ((MarkFaceMessage)localObject2).sbufID = anqu.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType);
    ((MarkFaceMessage)localObject2).dwTabID = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).intValue();
    ((MarkFaceMessage)localObject2).sbfKey = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey.getBytes();
    ((MarkFaceMessage)localObject2).imageWidth = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.width;
    ((MarkFaceMessage)localObject2).imageHeight = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.height;
    ((MarkFaceMessage)localObject2).faceName = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    boolean bool1;
    label405:
    askc localaskc;
    int i;
    label635:
    boolean bool2;
    if (((EmoticonPackage)localObject1).isAPNG == 2)
    {
      bool1 = true;
      ((MarkFaceMessage)localObject2).isAPNG = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) {
        ((MarkFaceMessage)localObject2).mediaType = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) {
        break label1220;
      }
      ((MarkFaceMessage)localObject2).mediaType = 2;
      if (QLog.isColorLevel()) {
        QLog.i("ChatActivityFacade", 2, "sendEmosmMsg epid = :" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId + ",eid = :" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId + ";type = " + ((EmoticonPackage)localObject1).type + ";jobtype = " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType + ";mfm.mediatype = " + ((MarkFaceMessage)localObject2).mediaType);
      }
      if ((1 == ((EmoticonPackage)localObject1).type) || (4 == ((EmoticonPackage)localObject1).type)) {
        ((MarkFaceMessage)localObject2).cSubType = 3;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)) {
        ((MarkFaceMessage)localObject2).mobileparam = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.getBytes();
      }
      ((MarkFaceMessage)localObject2).voicePrintItems = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.parseSoundPrintString();
      ((MarkFaceMessage)localObject2).backColor = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.backColor;
      ((MarkFaceMessage)localObject2).volumeColor = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.volumeColor;
      localaskc = (askc)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(200);
      MarketFaceExtPb.ResvAttr localResvAttr = new MarketFaceExtPb.ResvAttr();
      PBUInt32Field localPBUInt32Field = localResvAttr.uint32_emoji_type;
      if (!((MarkFaceMessage)localObject2).isAPNG) {
        break label1240;
      }
      i = 2;
      localPBUInt32Field.set(i);
      if ((((EmoticonPackage)localObject1).endTime == 0L) && (((EmoticonPackage)localObject1).beginTime == 0L))
      {
        long l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.i("ChatActivityFacade", 2, "sendEmosmMsg, endTime and beginTime = 0, set tiem = " + l);
        }
        ((EmoticonPackage)localObject1).beginTime = l;
        ((EmoticonPackage)localObject1).endTime = l;
      }
      bool1 = localaskc.b((EmoticonPackage)localObject1);
      bool2 = localaskc.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((((EmoticonPackage)localObject1).copywritingType != askc.jdField_a_of_type_Int) || (bool1) || (bool2))
      {
        if (!bool1) {
          break label1245;
        }
        ((MarkFaceMessage)localObject2).copywritingType = askc.f;
        ((MarkFaceMessage)localObject2).copywritingContent = ((EmoticonPackage)localObject1).ipName;
        ((MarkFaceMessage)localObject2).jumpUrl = ((EmoticonPackage)localObject1).ipJumpUrl;
        ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
        ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
        ((MarkFaceMessage)localObject2).from = ajyc.a(2131701551);
        label812:
        ((MarkFaceMessage)localObject2).hasIpProduct = ((EmoticonPackage)localObject1).hasIpProduct;
        localPBUInt32Field = localResvAttr.uint32_has_ip_product;
        if (!((MarkFaceMessage)localObject2).hasIpProduct) {
          break label1388;
        }
        i = 1;
        label839:
        localPBUInt32Field.set(i);
        localResvAttr.uint32_source_type.set(((MarkFaceMessage)localObject2).copywritingType);
        localResvAttr.uint32_start_time.set((int)((MarkFaceMessage)localObject2).beginTime);
        localResvAttr.uint32_end_time.set((int)((MarkFaceMessage)localObject2).endTime);
        if (!TextUtils.isEmpty(((MarkFaceMessage)localObject2).from)) {
          localResvAttr.str_source_type_name.set(((MarkFaceMessage)localObject2).from);
        }
        if (!TextUtils.isEmpty(((MarkFaceMessage)localObject2).copywritingContent)) {
          localResvAttr.str_source_name.set(((MarkFaceMessage)localObject2).copywritingContent);
        }
        if (!TextUtils.isEmpty(((MarkFaceMessage)localObject2).jumpUrl)) {
          localResvAttr.str_source_jump_url.set(((MarkFaceMessage)localObject2).jumpUrl);
        }
      }
      if ((((MarkFaceMessage)localObject2).voicePrintItems != null) && (!((MarkFaceMessage)localObject2).voicePrintItems.isEmpty())) {
        localResvAttr.uint32_voice_item_height_arr.set(((MarkFaceMessage)localObject2).voicePrintItems);
      }
      if (!TextUtils.isEmpty(((MarkFaceMessage)localObject2).backColor)) {
        localResvAttr.str_back_color.set(((MarkFaceMessage)localObject2).backColor);
      }
      if (!TextUtils.isEmpty(((MarkFaceMessage)localObject2).volumeColor)) {
        localResvAttr.str_volume_color.set(((MarkFaceMessage)localObject2).volumeColor);
      }
      ((MarkFaceMessage)localObject2).resvAttr = localResvAttr.toByteArray();
      if (((MarkFaceMessage)localObject2).copywritingType != askc.jdField_a_of_type_Int)
      {
        i = localaskc.a((int)awzw.a(), ((EmoticonPackage)localObject1).epId, ((MarkFaceMessage)localObject2).copywritingContent, ((MarkFaceMessage)localObject2).copywritingType);
        if (i != 0) {
          break label1393;
        }
        ((MarkFaceMessage)localObject2).shouldDisplay = true;
      }
    }
    for (;;)
    {
      localObject2 = axaq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int, (MarkFaceMessage)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "diversionRunnable, epId = " + ((EmoticonPackage)localObject1).epId + " ePackage.copywritingType = " + ((EmoticonPackage)localObject1).copywritingType + " currentTime = " + System.currentTimeMillis());
      }
      localObject1 = new ChatActivityFacade.20.1(this, (MessageForMarketFace)localObject2, (EmoticonPackage)localObject1);
      ThreadManager.getUIHandler().post((Runnable)localObject1);
      return;
      bool1 = false;
      break;
      label1220:
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 4) {
        break label405;
      }
      ((MarkFaceMessage)localObject2).mediaType = 3;
      break label405;
      label1240:
      i = 1;
      break label635;
      label1245:
      if (bool2)
      {
        ((MarkFaceMessage)localObject2).copywritingType = askc.f;
        ((MarkFaceMessage)localObject2).copywritingContent = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.ipsiteName;
        ((MarkFaceMessage)localObject2).jumpUrl = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.ipsiteUrl;
        ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
        ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
        ((MarkFaceMessage)localObject2).from = ajyc.a(2131701553);
        break label812;
      }
      if (localaskc.a((EmoticonPackage)localObject1)) {
        break label812;
      }
      ((MarkFaceMessage)localObject2).copywritingType = ((EmoticonPackage)localObject1).copywritingType;
      ((MarkFaceMessage)localObject2).copywritingContent = ((EmoticonPackage)localObject1).diversionName;
      ((MarkFaceMessage)localObject2).jumpUrl = ((EmoticonPackage)localObject1).jumpUrl;
      ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
      ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
      ((MarkFaceMessage)localObject2).from = ((EmoticonPackage)localObject1).comeFom;
      break label812;
      label1388:
      i = 0;
      break label839;
      label1393:
      if ((i == 1) && (((MarkFaceMessage)localObject2).hasIpProduct))
      {
        ((MarkFaceMessage)localObject2).shouldDisplay = true;
        ((MarkFaceMessage)localObject2).showIpProduct = true;
        ((MarkFaceMessage)localObject2).from = askc.jdField_a_of_type_JavaLangString;
        ((MarkFaceMessage)localObject2).copywritingContent = askc.b;
      }
      else
      {
        ((MarkFaceMessage)localObject2).shouldDisplay = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.20
 * JD-Core Version:    0.7.0.1
 */