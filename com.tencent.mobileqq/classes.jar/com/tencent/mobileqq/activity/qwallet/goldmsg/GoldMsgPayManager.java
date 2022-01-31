package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qwallet.plugin.QWalletPayBridge;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.apache.http.util.ByteArrayBuffer;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype3;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.Ptt;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;
import xex;
import xey;
import xez;
import xfa;
import xfb;

public class GoldMsgPayManager
{
  protected static GoldMsgPayManager a;
  protected GoldMsgPayManager.MyResultReceiver a;
  WeakReferenceHandler a;
  public final String a;
  protected ArrayList a;
  protected ArrayList b = new ArrayList();
  
  private GoldMsgPayManager()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = "GoldMsg";
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager$MyResultReceiver = new GoldMsgPayManager.MyResultReceiver(null, this);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
  }
  
  public static GoldMsgPayManager a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager = new GoldMsgPayManager();
      }
      GoldMsgPayManager localGoldMsgPayManager = jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager;
      return localGoldMsgPayManager;
    }
    finally {}
  }
  
  public static void a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager != null) {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    if (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager != null) {
      jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.b.clear();
    }
  }
  
  public static void a(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.a == null) || (paramSessionInfo == null) || (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager == null)) {}
    label158:
    for (;;)
    {
      return;
      if ((jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList != null) && (jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList.size() > 0))
      {
        int i = 0;
        if (i < jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList.size()) {
          if (!((GoldMsgPayManager.PayItem)jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList.get(i)).b) {}
        }
        for (GoldMsgPayManager.PayItem localPayItem = (GoldMsgPayManager.PayItem)jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager.jdField_a_of_type_JavaUtilArrayList.get(i);; localPayItem = null)
        {
          if ((localPayItem == null) || (localPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) || (localPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin == null) || (!localPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin.equals(paramSessionInfo.jdField_a_of_type_JavaLangString))) {
            break label158;
          }
          paramSessionInfo = new Intent("com.tenpay.android.qqplugin.goldmsg.canclepay");
          paramBaseChatPie.a.sendBroadcast(paramSessionInfo);
          return;
          i += 1;
          break;
        }
      }
    }
  }
  
  protected String a(String paramString1, String paramString2, MessageRecord paramMessageRecord, Bundle paramBundle)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramMessageRecord == null))
    {
      QLog.i("GoldMsg", 2, "getMessageMd5 params null");
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject2;
        if (paramMessageRecord.msgtype == -2000)
        {
          if (!(paramMessageRecord instanceof MessageForRichText)) {
            continue;
          }
          paramMessageRecord = (MessageForRichText)paramMessageRecord;
          if ((paramMessageRecord.richText == null) || (!paramMessageRecord.richText.elems.has())) {
            continue;
          }
          localObject2 = paramMessageRecord.richText.elems.get();
          i = 0;
          if (i >= ((List)localObject2).size()) {
            continue;
          }
          paramMessageRecord = (im_msg_body.Elem)((List)localObject2).get(i);
          if (paramMessageRecord == null) {
            continue;
          }
          if ((paramMessageRecord.not_online_image.has()) && (((im_msg_body.NotOnlineImage)paramMessageRecord.not_online_image.get()).pic_md5.has()))
          {
            localObject1 = paramMessageRecord.not_online_image;
            paramMessageRecord = null;
            continue;
            if ((localObject1 == null) || (!((im_msg_body.NotOnlineImage)localObject1).pic_md5.has())) {
              continue;
            }
            localObject1 = ((im_msg_body.NotOnlineImage)localObject1).pic_md5.get().toByteArray();
            paramMessageRecord = (MessageRecord)localObject1;
            if (localObject1 != null)
            {
              paramBundle.putString("pic_md5", Utils.a((byte[])localObject1));
              paramMessageRecord = (MessageRecord)localObject1;
            }
            if (paramMessageRecord == null) {
              break;
            }
            paramBundle = new ByteArrayBuffer(128);
            localObject1 = String.valueOf(paramString1).getBytes("utf-8");
            localObject2 = String.valueOf(paramString2).getBytes("utf-8");
            paramBundle.append((byte[])localObject1, 0, localObject1.length);
            paramBundle.append((byte[])localObject2, 0, localObject2.length);
            paramBundle.append(paramMessageRecord, 0, paramMessageRecord.length);
            if (QLog.isColorLevel()) {
              QLog.i("GoldMsg", 2, "uint32Seq:" + paramString1 + " random:" + paramString2);
            }
            paramString1 = MD5.toMD5(paramBundle.toByteArray());
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("GoldMsg", 2, "md5:" + paramString1);
            continue;
          }
          if ((paramMessageRecord.custom_face.has()) && (((im_msg_body.CustomFace)paramMessageRecord.custom_face.get()).bytes_md5.has()))
          {
            paramMessageRecord = paramMessageRecord.custom_face;
            localObject1 = null;
            continue;
          }
          if ((!paramMessageRecord.common_elem.has()) || (!((im_msg_body.CommonElem)paramMessageRecord.common_elem.get()).uint32_service_type.has()) || (((im_msg_body.CommonElem)paramMessageRecord.common_elem.get()).uint32_service_type.get() != 3) || (!((im_msg_body.CommonElem)paramMessageRecord.common_elem.get()).bytes_pb_elem.has())) {
            continue;
          }
          localObject1 = new hummer_commelem.MsgElemInfo_servtype3();
          ((hummer_commelem.MsgElemInfo_servtype3)localObject1).mergeFrom(((im_msg_body.CommonElem)paramMessageRecord.common_elem.get()).bytes_pb_elem.get().toByteArray());
          if ((((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_c2c_pic.has()) && (((im_msg_body.NotOnlineImage)((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_c2c_pic.get()).pic_md5.has()))
          {
            localObject1 = ((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_c2c_pic;
            paramMessageRecord = null;
            continue;
          }
          if ((!((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_troop_pic.has()) || (!((im_msg_body.CustomFace)((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_troop_pic.get()).bytes_md5.has())) {
            continue;
          }
          paramMessageRecord = ((hummer_commelem.MsgElemInfo_servtype3)localObject1).flash_troop_pic;
          localObject1 = null;
          continue;
          if ((paramMessageRecord == null) || (!paramMessageRecord.bytes_md5.has())) {
            continue;
          }
          localObject1 = paramMessageRecord.bytes_md5.get().toByteArray();
          continue;
        }
        if (paramMessageRecord.msgtype == -2007)
        {
          if ((paramMessageRecord instanceof MessageForMarketFace))
          {
            localObject1 = (MessageForMarketFace)paramMessageRecord;
            if (((MessageForMarketFace)localObject1).mMarkFaceMessage != null)
            {
              paramBundle = ((MessageForMarketFace)localObject1).mMarkFaceMessage.sbufID;
              paramMessageRecord = paramBundle;
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.i("GoldMsg", 2, "sbufID:" + Utils.a(((MessageForMarketFace)localObject1).mMarkFaceMessage.sbufID));
              paramMessageRecord = paramBundle;
            }
          }
        }
        else if (paramMessageRecord.msgtype == -1000)
        {
          if ((paramMessageRecord instanceof MessageForText))
          {
            paramBundle = new byte[1];
            paramBundle[0] = 20;
            localObject1 = MessageProtoCodec.a((MessageForText)paramMessageRecord);
            if ((localObject1 != null) && (((im_msg_body.RichText)localObject1).elems.has()))
            {
              paramMessageRecord = new ByteArrayBuffer(64);
              localObject1 = ((im_msg_body.RichText)localObject1).elems.get();
              i = 0;
              if (i < ((List)localObject1).size())
              {
                localObject2 = (im_msg_body.Elem)((List)localObject1).get(i);
                if (localObject2 == null) {
                  break label1463;
                }
                if (((im_msg_body.Elem)localObject2).text.has())
                {
                  if (!((im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get()).str.has()) {
                    break label1463;
                  }
                  localObject2 = ((im_msg_body.Text)((im_msg_body.Elem)localObject2).text.get()).str.get().toByteArray();
                  paramMessageRecord.append((byte[])localObject2, 0, localObject2.length);
                  break label1463;
                }
                if (((im_msg_body.Elem)localObject2).face.has())
                {
                  if (!((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.has()) {
                    break label1463;
                  }
                  paramMessageRecord.append(paramBundle, 0, 1);
                  arrayOfByte = String.valueOf(((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.get()).getBytes("utf-8");
                  paramMessageRecord.append(arrayOfByte, 0, arrayOfByte.length);
                  paramMessageRecord.append(paramBundle, 0, 1);
                  if (!QLog.isColorLevel()) {
                    break label1463;
                  }
                  QLog.i("GoldMsg", 2, "face.index:" + ((im_msg_body.Face)((im_msg_body.Elem)localObject2).face.get()).index.get());
                  break label1463;
                }
                if ((!((im_msg_body.Elem)localObject2).small_emoji.has()) || (!((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.has())) {
                  break label1463;
                }
                paramMessageRecord.append(paramBundle, 0, 1);
                byte[] arrayOfByte = String.valueOf(((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum.get()).getBytes("utf-8");
                paramMessageRecord.append(arrayOfByte, 0, arrayOfByte.length);
                paramMessageRecord.append(paramBundle, 0, 1);
                if (!QLog.isColorLevel()) {
                  break label1463;
                }
                QLog.i("GoldMsg", 2, "small_emoji.packIdSum:" + ((im_msg_body.SmallEmoji)((im_msg_body.Elem)localObject2).small_emoji.get()).packIdSum);
                break label1463;
              }
              if (paramMessageRecord.length() > 0) {
                paramMessageRecord = paramMessageRecord.toByteArray();
              }
            }
          }
        }
        else if (paramMessageRecord.msgtype == -2002)
        {
          paramMessageRecord = (MessageForRichText)paramMessageRecord;
          if ((paramMessageRecord.richText != null) && (paramMessageRecord.richText.ptt.has()) && (((im_msg_body.Ptt)paramMessageRecord.richText.ptt.get()).bytes_file_md5.has())) {
            paramMessageRecord = ((im_msg_body.Ptt)paramMessageRecord.richText.ptt.get()).bytes_file_md5.get().toByteArray();
          }
        }
        else
        {
          if ((paramMessageRecord.msgtype != -2009) && (paramMessageRecord.msgtype != -2022)) {
            break;
          }
          if ((paramMessageRecord instanceof MessageForRichText))
          {
            paramMessageRecord = (MessageForRichText)paramMessageRecord;
            if ((paramMessageRecord.richText != null) && (paramMessageRecord.richText.elems.has()))
            {
              localObject1 = paramMessageRecord.richText.elems.get();
              i = 0;
              paramMessageRecord = null;
              paramBundle = paramMessageRecord;
              if (i < ((List)localObject1).size())
              {
                paramBundle = (im_msg_body.Elem)((List)localObject1).get(i);
                if (paramBundle == null) {
                  break label1472;
                }
                if ((!paramBundle.video_file.has()) || (!((im_msg_body.VideoFile)paramBundle.video_file.get()).bytes_file_md5.has())) {
                  continue;
                }
                paramMessageRecord = ((im_msg_body.VideoFile)paramBundle.video_file.get()).bytes_file_md5.get().toByteArray();
                break label1472;
              }
            }
            else
            {
              paramBundle = null;
            }
            paramMessageRecord = paramBundle;
            continue;
            break label1472;
          }
        }
        paramMessageRecord = null;
        continue;
        Object localObject1 = null;
        continue;
        paramMessageRecord = null;
        localObject1 = null;
        continue;
        i += 1;
        continue;
        if (localObject1 != null) {
          continue;
        }
        if (paramMessageRecord == null) {
          continue;
        }
        continue;
        return paramString1;
      }
      catch (Exception paramString1)
      {
        return null;
      }
      label1463:
      i += 1;
      continue;
      label1472:
      i += 1;
    }
  }
  
  protected void a(QQAppInterface paramQQAppInterface, GoldMsgPayManager.PayItem paramPayItem)
  {
    if ((paramQQAppInterface == null) || (paramPayItem == null)) {}
    do
    {
      return;
      paramQQAppInterface.a().a(paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq);
      paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.extraflag = 32768;
      paramQQAppInterface.a().a(paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      paramQQAppInterface.a().a(paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, 32768, 1001);
      paramQQAppInterface.a().a(6003, false, new String[] { paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, String.valueOf(paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq) });
    } while ((!MsgProxyUtils.o(paramPayItem.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgtype)) || (paramPayItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver == null));
    paramQQAppInterface = new MessageObserver.StatictisInfo();
    paramQQAppInterface.b = 32768;
    paramQQAppInterface.c = 0;
    paramQQAppInterface.jdField_a_of_type_JavaLangString = "GoldmsgPay resultCode:-1";
    paramPayItem.jdField_a_of_type_ComTencentMobileqqAppMessageObserver.onUpdate(5006, false, new Object[] { paramQQAppInterface });
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GoldMsg", 2, "gotoPay:" + paramMessageRecord.msgseq);
    }
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return;
    }
    long l = VACDReportUtil.a(null, "qqwallet", "goldMsgPay", "payinvoke", null, 0, null);
    Bundle localBundle = new Bundle();
    localBundle.putInt("PayInvokerId", 22);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    Object localObject3;
    if (paramMessageRecord.istroop == 0)
    {
      localObject3 = (FriendsManager)localQQAppInterface.getManager(50);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((FriendsManager)localObject3).c(paramMessageRecord.frienduin);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((Friends)localObject3).uin != null)
          {
            localObject1 = localObject2;
            if (((Friends)localObject3).uin.length() > 0) {
              localObject1 = ((Friends)localObject3).getFriendNickWithAlias();
            }
          }
        }
      }
    }
    String str4 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_status");
    Object localObject4 = new Bundle();
    localObject2 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_msg_seq");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = String.valueOf(0xFFFF & (short)(int)paramMessageRecord.msgseq);
      paramMessageRecord.saveExtInfoToExtStr("goldmsg_msg_seq", (String)localObject2);
    }
    for (int i = 1;; i = 0)
    {
      localObject3 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_msg_random");
      if (TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject3 = String.valueOf(MessageUtils.a(paramMessageRecord.msgUid));
        paramMessageRecord.saveExtInfoToExtStr("goldmsg_msg_random", (String)localObject3);
        i = 1;
      }
      for (;;)
      {
        String str1 = (String)localObject2 + (String)localObject3;
        String str2 = a((String)localObject2, (String)localObject3, paramMessageRecord, (Bundle)localObject4);
        String str3 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_current_amount");
        localObject3 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_time");
        boolean bool = "2".equals(str4);
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          localObject2 = String.valueOf(paramMessageRecord.time);
        }
        int j = i;
        if (paramMessageRecord.msgtype == -2000)
        {
          localObject3 = ((Bundle)localObject4).getString("pic_md5");
          if (!bool)
          {
            paramMessageRecord.saveExtInfoToExtStr("goldmsg_pic_md5", (String)localObject3);
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            GoldMsgChatHelper.a(paramMessageRecord, false);
          }
          localObject3 = new Bundle();
          ((Bundle)localObject3).putString("payee_uin", paramMessageRecord.frienduin);
          ((Bundle)localObject3).putString("payee_nick", (String)localObject1);
          ((Bundle)localObject3).putString("timestamp", (String)localObject2);
          ((Bundle)localObject3).putString("msg_id", str1);
          ((Bundle)localObject3).putString("msg_sign", str2);
          ((Bundle)localObject3).putString("price", str3);
          if (!bool) {
            break label847;
          }
          localObject1 = "1";
          label486:
          ((Bundle)localObject3).putString("is_retry", (String)localObject1);
          if ((paramMessageRecord.istroop == 3000) || (paramMessageRecord.istroop == 1))
          {
            ((Bundle)localObject3).putString("total_num", paramMessageRecord.getExtInfoFromExtStr("goldmsg_rec_count"));
            ((Bundle)localObject3).putString("bus_type", "2");
            ((Bundle)localObject3).putString("channel", "8192");
            if (paramMessageRecord.istroop != 3000) {
              break label855;
            }
          }
        }
        label847:
        label855:
        for (localObject1 = "2";; localObject1 = "3")
        {
          ((Bundle)localObject3).putString("recv_type", (String)localObject1);
          localObject1 = Parcel.obtain();
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletGoldmsgGoldMsgPayManager$MyResultReceiver.writeToParcel((Parcel)localObject1, 0);
          ((Parcel)localObject1).setDataPosition(0);
          localObject4 = (ResultReceiver)ResultReceiver.CREATOR.createFromParcel((Parcel)localObject1);
          ((Parcel)localObject1).recycle();
          localBundle.putParcelable("_qwallet_payresult_receiver", (Parcelable)localObject4);
          localBundle.putBundle("_qwallet_payparams_data", (Bundle)localObject3);
          localBundle.putString("_qwallet_payparams_sn", String.valueOf(paramMessageRecord.msgseq));
          localBundle.putString("_qwallet_payparams_tag", "goldmsg_pay");
          localBundle.putLong("vacreport_key_seq", l);
          paramMessageRecord = new StringBuilder();
          paramMessageRecord.append("&msgId=").append(str1);
          paramMessageRecord.append("&msgMd5=").append(str2);
          paramMessageRecord.append("&price=").append(str3);
          paramMessageRecord.append("&retry=").append(bool);
          paramMessageRecord.append("&time=").append((String)localObject2);
          VACDReportUtil.a(l, str1, "loadPluginStart", paramMessageRecord.toString(), 0, null);
          QWalletPayBridge.getWalletDataByService(BaseApplicationImpl.sApplication, localQQAppInterface, localBundle);
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new xfa(this), 60000L);
          return;
          localObject4 = paramMessageRecord.getExtInfoFromExtStr("goldmsg_pic_md5");
          j = i;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break;
          }
          j = i;
          if (((String)localObject3).equals(localObject4)) {
            break;
          }
          paramMessageRecord.saveExtInfoToExtStr("goldmsg_md5_tag", "1");
          j = 1;
          break;
          localObject1 = "0";
          break label486;
        }
      }
    }
  }
  
  public void a(MessageRecord paramMessageRecord, MessageObserver paramMessageObserver, boolean paramBoolean)
  {
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("pay mr:");
      if (paramMessageRecord == null)
      {
        localObject = "null";
        QLog.i("GoldMsg", 2, localObject + " isResend:" + paramBoolean);
      }
    }
    else
    {
      bool = a();
      localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if (paramMessageRecord == null) {}
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilArrayList.add(new GoldMsgPayManager.PayItem(paramMessageRecord, paramMessageObserver, paramBoolean));
        if ((bool) || (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break label191;
        }
        paramMessageObserver = (GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        paramMessageObserver.b = true;
        if (paramMessageRecord != null) {
          ThreadManager.getUIHandler().postDelayed(new xex(this, paramMessageRecord), MessageHandler.d);
        }
        if (paramMessageObserver != null) {
          ThreadManager.post(new xey(this, paramMessageObserver), 10, null, false);
        }
        return;
      }
      finally {}
      localObject = Long.valueOf(paramMessageRecord.msgseq);
      break;
      label191:
      paramMessageObserver = null;
    }
  }
  
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (String.valueOf(((GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq).equals(paramString))
        {
          ((GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long = (NetConnInfoCenter.getServerTimeMillis() / 1000L);
          return;
        }
        i += 1;
      }
    }
  }
  
  protected void a(String paramString, int paramInt, Bundle paramBundle)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramBundle == null)) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = QWalletTools.a();
    } while (localQQAppInterface == null);
    String str1 = null;
    Object localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
    int i = 0;
    label37:
    Object localObject1 = str1;
    label269:
    label278:
    label829:
    label835:
    label842:
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          if (String.valueOf(((GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq).equals(paramString))
          {
            localObject1 = (GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
            this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          }
        }
        else
        {
          if (localObject1 != null) {
            break label842;
          }
          i = 0;
          if (i >= this.b.size()) {
            break label842;
          }
          if (!String.valueOf(((GoldMsgPayManager.PayItem)this.b.get(i)).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msgseq).equals(paramString)) {
            break label269;
          }
          localObject1 = (GoldMsgPayManager.PayItem)this.b.get(i);
          this.b.remove(i);
          if (QLog.isColorLevel()) {
            QLog.d("GoldMsg", 2, "onPayResult resultCode=" + paramInt + ",msgseq=" + paramString);
          }
          if (paramInt != 0) {
            break label278;
          }
          a(null, null, false);
          if (localObject1 != null) {
            break label347;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("GoldMsg", 2, "item not found");
          return;
        }
        i += 1;
        break label37;
      }
      finally {}
      i += 1;
      continue;
      paramString = this.jdField_a_of_type_JavaUtilArrayList;
      i = 0;
      try
      {
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          a(localQQAppInterface, (GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i));
          this.jdField_a_of_type_JavaUtilArrayList.remove(i);
          i += 1;
        }
        continue;
      }
      finally {}
      label347:
      int j = 0;
      paramString = "";
      i = j;
      if (paramBundle != null)
      {
        paramString = paramBundle.getString("listid");
        str1 = paramBundle.getString("newprice");
        if (TextUtils.isEmpty(str1)) {
          break label835;
        }
      }
      for (;;)
      {
        try
        {
          l = Long.parseLong(str1);
          if (l <= 0L) {
            break label829;
          }
          localObject2 = GoldMsgChatHelper.a().a(0, ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin);
          if (localObject2 != null)
          {
            if ((l <= ((GoldMsgChatHelper.GoldMsgChatState)localObject2).b) || (paramInt != 0)) {
              continue;
            }
            ((GoldMsgChatHelper.GoldMsgChatState)localObject2).a(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.selfuin, ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, l, 0);
          }
          QWalletSetting.a(localQQAppInterface.getCurrentAccountUin(), "goldmsg_setmoneyfrom_" + ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, l);
          localObject2 = ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.getExtInfoFromExtStr("goldmsg_current_amount");
          if ((TextUtils.isEmpty((CharSequence)localObject2)) || (l <= Long.parseLong((String)localObject2))) {
            break label829;
          }
          ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("goldmsg_current_amount", str1);
          localQQAppInterface.a().a(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          i = 1;
        }
        catch (Exception localException)
        {
          long l;
          i = j;
          continue;
          String str2 = "2";
          continue;
          a(localQQAppInterface, (GoldMsgPayManager.PayItem)localObject1);
        }
        localObject2 = ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        if (paramInt == 0)
        {
          str1 = "1";
          ((MessageRecord)localObject2).saveExtInfoToExtStr("goldmsg_status", str1);
          ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord.saveExtInfoToExtStr("goldmsg_order_id", paramString);
          if (paramInt != 0) {
            continue;
          }
          paramString = (QQMessageFacade)localQQAppInterface.getManager(19);
          if (paramString != null)
          {
            paramString.b(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqAppMessageObserver, ((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_Boolean);
            GoldMsgChatHelper.a(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, false);
          }
          paramString = paramBundle.getString("golden_msg_guide");
          if (!TextUtils.isEmpty(paramString)) {
            b(paramString);
          }
          if (i != 0) {
            break;
          }
          localQQAppInterface.a().a(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
          return;
          ((GoldMsgChatHelper.GoldMsgChatState)localObject2).jdField_a_of_type_Long = l;
          continue;
        }
        if ((paramInt == -1) || (!paramBundle.getBoolean("gold_msg_nopass", false))) {
          break;
        }
        paramBundle = paramBundle.getString("retmsg");
        paramString = paramBundle;
        if (!TextUtils.isEmpty(paramBundle))
        {
          paramString = "[提示]" + paramBundle;
          GoldMsgChatHelper.a(((GoldMsgPayManager.PayItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramString, 0, 0, null, -5040);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("GoldMsg", 2, "err msg:" + paramString);
        return;
        i = 0;
        continue;
        i = j;
      }
    }
  }
  
  public boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("GoldMsg", 2, "checkPay");
    }
    long l = NetConnInfoCenter.getServerTimeMillis() / 1000L;
    int i = 0;
    boolean bool1 = false;
    int j = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      k = j;
      if (((GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).b)
      {
        if (l - ((GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Long <= 240L) {
          break label342;
        }
        bool1 = true;
      }
    }
    for (int k = 1;; k = j)
    {
      i += 1;
      j = k;
      break;
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GoldMsg", 2, "outoftime:" + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        localObject1 = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localObject1 instanceof QQAppInterface)) {
          break label336;
        }
      }
      label336:
      Object localObject3;
      for (Object localObject1 = (QQAppInterface)localObject1;; localObject3 = null)
      {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
        ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
        i = 0;
        for (;;)
        {
          try
          {
            if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
            {
              a((QQAppInterface)localObject1, (GoldMsgPayManager.PayItem)this.jdField_a_of_type_JavaUtilArrayList.get(i));
              this.b.add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
              this.jdField_a_of_type_JavaUtilArrayList.remove(i);
              i += 1;
              continue;
            }
            bool2 = false;
            if (QLog.isColorLevel()) {
              QLog.i("GoldMsg", 2, "isPaying:" + bool2);
            }
            return bool2;
          }
          finally {}
          boolean bool2 = bool1;
          if (bool1)
          {
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
            this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.postDelayed(new xez(this), 60000L);
            bool2 = bool1;
          }
        }
      }
      label342:
      bool1 = true;
    }
  }
  
  public void b(String paramString)
  {
    ThreadManager.getUIHandler().post(new xfb(this, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager
 * JD-Core Version:    0.7.0.1
 */