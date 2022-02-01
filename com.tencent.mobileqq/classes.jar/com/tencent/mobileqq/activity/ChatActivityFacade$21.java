package com.tencent.mobileqq.activity;

import admh;
import android.content.Context;
import android.text.TextUtils;
import anvx;
import asdi;
import awyq;
import awyr;
import bcrg;
import bcsa;
import bhpl;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

public final class ChatActivityFacade$21
  implements Runnable
{
  public ChatActivityFacade$21(QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, Context paramContext, SessionInfo paramSessionInfo, EmojiStickerManager.StickerInfo paramStickerInfo) {}
  
  public void run()
  {
    Object localObject1 = ((awyr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EMOTICON_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
    if (localObject1 == null)
    {
      localObject2 = new StringBuilder().append("sendEmosmMsg ePackage == null name:");
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name != null)
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append(", epid_eid:");
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId == null) {
          break label209;
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
        label96:
        localObject2 = ((StringBuilder)localObject2).append((String)localObject1).append("_");
        if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId == null) {
          break label216;
        }
      }
      label209:
      label216:
      for (localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;; localObject1 = "~")
      {
        QLog.e("ChatActivityFacade", 1, (String)localObject1);
        bhpl.a("emotionType", "emotionActionSend", "3", this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, NetworkUtil.getNetworkType(this.jdField_a_of_type_AndroidContentContext) + "", "", "", "", "");
        return;
        localObject1 = "~";
        break;
        localObject1 = "~";
        break label96;
      }
    }
    Object localObject2 = new MarkFaceMessage();
    if (admh.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) {
      ((MarkFaceMessage)localObject2).isReword = true;
    }
    ((MarkFaceMessage)localObject2).cSubType = ((EmoticonPackage)localObject1).type;
    ((MarkFaceMessage)localObject2).sbufID = asdi.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType);
    ((MarkFaceMessage)localObject2).dwTabID = Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).intValue();
    ((MarkFaceMessage)localObject2).sbfKey = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.encryptKey.getBytes();
    ((MarkFaceMessage)localObject2).imageWidth = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.width;
    ((MarkFaceMessage)localObject2).imageHeight = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.height;
    ((MarkFaceMessage)localObject2).faceName = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
    boolean bool1;
    label406:
    awyq localawyq;
    int i;
    label636:
    boolean bool2;
    if (((EmoticonPackage)localObject1).isAPNG == 2)
    {
      bool1 = true;
      ((MarkFaceMessage)localObject2).isAPNG = bool1;
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) {
        ((MarkFaceMessage)localObject2).mediaType = 1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 1) {
        break label1289;
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
      localawyq = (awyq)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.COMMERCIAL_DRAINAGE_MANAGER);
      MarketFaceExtPb.ResvAttr localResvAttr = new MarketFaceExtPb.ResvAttr();
      PBUInt32Field localPBUInt32Field = localResvAttr.uint32_emoji_type;
      if (!((MarkFaceMessage)localObject2).isAPNG) {
        break label1309;
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
      bool1 = localawyq.b((EmoticonPackage)localObject1);
      bool2 = localawyq.a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
      if ((((EmoticonPackage)localObject1).copywritingType != awyq.jdField_a_of_type_Int) || (bool1) || (bool2))
      {
        if (!bool1) {
          break label1314;
        }
        ((MarkFaceMessage)localObject2).copywritingType = awyq.f;
        ((MarkFaceMessage)localObject2).copywritingContent = ((EmoticonPackage)localObject1).ipName;
        ((MarkFaceMessage)localObject2).jumpUrl = ((EmoticonPackage)localObject1).ipJumpUrl;
        ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
        ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
        ((MarkFaceMessage)localObject2).from = anvx.a(2131701066);
        label814:
        ((MarkFaceMessage)localObject2).hasIpProduct = ((EmoticonPackage)localObject1).hasIpProduct;
        localPBUInt32Field = localResvAttr.uint32_has_ip_product;
        if (!((MarkFaceMessage)localObject2).hasIpProduct) {
          break label1457;
        }
        i = 1;
        label841:
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
      if (((MarkFaceMessage)localObject2).copywritingType != awyq.jdField_a_of_type_Int)
      {
        i = localawyq.a((int)bcrg.a(), ((EmoticonPackage)localObject1).epId, ((MarkFaceMessage)localObject2).copywritingContent, ((MarkFaceMessage)localObject2).copywritingType);
        if (i != 0) {
          break label1462;
        }
        ((MarkFaceMessage)localObject2).shouldDisplay = true;
      }
    }
    for (;;)
    {
      localObject2 = bcsa.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.troopUin, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType, (MarkFaceMessage)localObject2);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo.isShown = false;
        EmojiStickerManager.a((MessageRecord)localObject2, this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo);
        EmojiStickerManager.a().a((MessageRecord)localObject2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "stickerInfo = " + this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiStickerManager$StickerInfo);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatActivityFacade", 2, "diversionRunnable, epId = " + ((EmoticonPackage)localObject1).epId + " ePackage.copywritingType = " + ((EmoticonPackage)localObject1).copywritingType + " currentTime = " + System.currentTimeMillis());
      }
      localObject1 = new ChatActivityFacade.21.1(this, (MessageForMarketFace)localObject2, (EmoticonPackage)localObject1);
      ThreadManager.getUIHandler().post((Runnable)localObject1);
      return;
      bool1 = false;
      break;
      label1289:
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType != 4) {
        break label406;
      }
      ((MarkFaceMessage)localObject2).mediaType = 3;
      break label406;
      label1309:
      i = 1;
      break label636;
      label1314:
      if (bool2)
      {
        ((MarkFaceMessage)localObject2).copywritingType = awyq.f;
        ((MarkFaceMessage)localObject2).copywritingContent = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.ipsiteName;
        ((MarkFaceMessage)localObject2).jumpUrl = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.ipsiteUrl;
        ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
        ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
        ((MarkFaceMessage)localObject2).from = anvx.a(2131701076);
        break label814;
      }
      if (localawyq.a((EmoticonPackage)localObject1)) {
        break label814;
      }
      ((MarkFaceMessage)localObject2).copywritingType = ((EmoticonPackage)localObject1).copywritingType;
      ((MarkFaceMessage)localObject2).copywritingContent = ((EmoticonPackage)localObject1).diversionName;
      ((MarkFaceMessage)localObject2).jumpUrl = ((EmoticonPackage)localObject1).jumpUrl;
      ((MarkFaceMessage)localObject2).beginTime = ((EmoticonPackage)localObject1).beginTime;
      ((MarkFaceMessage)localObject2).endTime = ((EmoticonPackage)localObject1).endTime;
      ((MarkFaceMessage)localObject2).from = ((EmoticonPackage)localObject1).comeFom;
      break label814;
      label1457:
      i = 0;
      break label841;
      label1462:
      if ((i == 1) && (((MarkFaceMessage)localObject2).hasIpProduct))
      {
        ((MarkFaceMessage)localObject2).shouldDisplay = true;
        ((MarkFaceMessage)localObject2).showIpProduct = true;
        ((MarkFaceMessage)localObject2).from = awyq.jdField_a_of_type_JavaLangString;
        ((MarkFaceMessage)localObject2).copywritingContent = awyq.b;
      }
      else
      {
        ((MarkFaceMessage)localObject2).shouldDisplay = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.21
 * JD-Core Version:    0.7.0.1
 */