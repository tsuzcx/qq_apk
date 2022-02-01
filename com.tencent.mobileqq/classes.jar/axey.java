import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.photo.PhotoListPanel;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLongMsg;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForRichText;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.MsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoItem;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.PhotoMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgInfo.TextMsgNode;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.1;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.5;
import com.tencent.mobileqq.mixedmsg.MixedMsgManager.6;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.RichText;

public class axey
  implements Manager
{
  private static final String jdField_a_of_type_JavaLangString = antf.ba + "fight/pic_expire.png";
  private long jdField_a_of_type_Long;
  public QQAppInterface a;
  public ConcurrentHashMap<Long, ChatMessage> a;
  
  public axey(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private MessageForMixedMsg a(List<MessageRecord> paramList, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, int paramInt, boolean paramBoolean)
  {
    if (paramList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "constructMixedMr, input elemList is null, return...");
      }
      return null;
    }
    MessageForMixedMsg localMessageForMixedMsg = (MessageForMixedMsg)bcry.a(-1035);
    Object localObject = (MessageRecord)paramList.get(0);
    ((MessageRecord)localObject).longMsgId = 0;
    MessageRecord.copyMessageRecordBaseField(localMessageForMixedMsg, (MessageRecord)localObject);
    if (localMessageForMixedMsg.istroop == 1) {
      nlj.a().b(localMessageForMixedMsg);
    }
    if ((paramSourceMsgInfo != null) && (paramArrayList != null) && (paramArrayList.size() > 0)) {
      paramSourceMsgInfo = new JSONObject();
    }
    try
    {
      localObject = new JSONArray();
      int i = 0;
      while (i < paramArrayList.size())
      {
        ((JSONArray)localObject).put(i, ((MessageForText.AtTroopMemberInfo)paramArrayList.get(i)).toJsonObject());
        i += 1;
      }
      paramSourceMsgInfo.put("0", localObject);
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("MixedMsgManager", 1, localJSONException, new Object[0]);
        continue;
        paramInt = -1;
      }
    }
    bgme.a(paramInt, paramSourceMsgInfo.toString(), localMessageForMixedMsg);
    localMessageForMixedMsg.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
    localMessageForMixedMsg.issend = 1;
    localMessageForMixedMsg.msgtype = -1035;
    localMessageForMixedMsg.extraflag = 32772;
    localMessageForMixedMsg.msgElemList = paramList;
    if (paramBoolean)
    {
      paramInt = 1;
      localMessageForMixedMsg.mRobotFlag = paramInt;
      localMessageForMixedMsg.atInfoList = paramArrayList;
      localMessageForMixedMsg.prewrite();
      return localMessageForMixedMsg;
    }
  }
  
  public static MessageForPic a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if (paramString1 != null)
    {
      paramString2 = bcry.a(paramQQAppInterface, paramString3, paramString2, paramInt);
      paramString2.path = paramString1;
      paramString2.size = 0L;
      paramString2.uniseq = (System.currentTimeMillis() + (Math.random() * 10000.0D));
      paramString2.type = 1;
      paramString2.isRead = true;
      paramString2.localUUID = azqk.a();
      paramString2.md5 = bhml.a(MD5.getFileMd5(paramString2.path));
      if (azru.a(paramString1))
      {
        paramString1 = new PicMessageExtraData();
        paramString1.textSummary = paramQQAppInterface.getApp().getString(2131691126);
        paramString2.picExtraData = paramString1;
      }
      paramString2.serial();
      return paramString2;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    int m = paramMessageForMixedMsg.msgElemList.size();
    int j = 0;
    int i = 0;
    Object localObject;
    if (j < m)
    {
      localObject = (MessageRecord)paramMessageForMixedMsg.msgElemList.get(j);
      if ((localObject instanceof MessageForText))
      {
        localObject = bcrw.a((MessageForText)localObject);
        if (localObject != null) {}
      }
    }
    for (;;)
    {
      j += 1;
      break;
      int k = 0;
      while (k < ((im_msg_body.RichText)localObject).elems.size())
      {
        localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
        k += 1;
      }
      continue;
      if ((localObject instanceof MessageForRichText))
      {
        localObject = ((MessageForPic)localObject).richText;
        if (localObject != null)
        {
          localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(0));
          i += 1;
        }
      }
      else if ((localObject instanceof MessageForReplyText))
      {
        localObject = bcrw.a((MessageForReplyText)localObject);
        if (localObject != null)
        {
          k = 0;
          while (k < ((im_msg_body.RichText)localObject).elems.size())
          {
            localRichText.elems.add(((im_msg_body.RichText)localObject).elems.get(k));
            k += 1;
            continue;
            i = localRichText.toByteArray().length;
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg, richTextLength : " + i);
            }
            paramMessageForMixedMsg.mRichTextLength = i;
            a(paramString, paramInt, paramMessageForMixedMsg, paramQQAppInterface, false);
            if (QLog.isColorLevel()) {
              QLog.d("MixedMsgManager", 2, "packAndSendMsg,, send by longStruct message");
            }
            return;
          }
        }
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, ArrayList<azqf> paramArrayList, MessageForMixedMsg paramMessageForMixedMsg)
  {
    azqk localazqk = azqb.a(8, 7);
    localazqk.a(paramArrayList);
    localazqk.a(new axez(this, paramMessageForMixedMsg, paramQQAppInterface, paramString, paramInt));
    azqb.a(localazqk, paramQQAppInterface);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, String paramString, Map<String, Boolean> paramMap)
  {
    Object localObject = (bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    ((bbnr)localObject).a(paramString, paramMessageForMixedMsg.uniseq);
    ((bbnr)localObject).a(paramMessageForMixedMsg, null);
    Map localMap = Collections.synchronizedMap(new HashMap());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMessageForMixedMsg.msgElemList.iterator();
    while (localIterator.hasNext())
    {
      paramString = (MessageRecord)localIterator.next();
      if ((paramString instanceof MessageForPic))
      {
        MessageForPic localMessageForPic = (MessageForPic)paramString;
        if (auog.a(localMessageForPic.path))
        {
          localObject = (List)localMap.get(localMessageForPic.path);
          paramString = (String)localObject;
          if (localObject == null)
          {
            localHashMap.put(localMessageForPic, new axfc(this, paramMessageForMixedMsg, localMap, localMessageForPic.path, paramArrayList));
            paramString = new ArrayList();
          }
          paramString.add(Integer.valueOf(localMessageForPic.subMsgId));
          localMap.put(localMessageForPic.path, paramString);
        }
      }
    }
    paramMessageForMixedMsg = localHashMap.entrySet().iterator();
    if (paramMessageForMixedMsg.hasNext())
    {
      paramArrayList = (Map.Entry)paramMessageForMixedMsg.next();
      paramString = (axfc)paramArrayList.getValue();
      if (paramMap == null) {
        break label346;
      }
      localObject = (Boolean)paramMap.get(paramString.jdField_a_of_type_JavaLangString);
      if (localObject == null) {
        break label346;
      }
    }
    label346:
    for (boolean bool = ((Boolean)localObject).booleanValue();; bool = false)
    {
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForPic)paramArrayList.getKey(), bool, paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("MixedMsgManager", 2, "send pic req:" + paramString.jdField_a_of_type_JavaLangString + ", raw:" + bool);
      break;
      return;
    }
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    if ((paramMessageForMixedMsg.istroop != 3000) && (paramMessageForMixedMsg.istroop != 1)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32770, paramMessageForMixedMsg.sendFailCode);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    a(true, paramBoolean, paramMessageForMixedMsg, null);
  }
  
  private void a(MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 32768, paramMessageForMixedMsg.sendFailCode);
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(Long.valueOf(paramMessageForMixedMsg.mForwardFromUniSeq));
    bbnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.uniseq);
    a(false, paramBoolean, paramMessageForMixedMsg, paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    bdll.b(null, "dc00898", "", "", paramString, paramString, paramInt, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, MessageForMixedMsg paramMessageForMixedMsg, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_isresend", String.valueOf(paramMessageForMixedMsg.mIsResend));
    if (!paramMessageForMixedMsg.mIsResend)
    {
      localHashMap.put("param_forwardFromUin", paramMessageForMixedMsg.mForwardFromUin);
      localHashMap.put("param_forwardFromUinType", String.valueOf(paramMessageForMixedMsg.mForwardFromIsTroop));
    }
    localHashMap.put("param_senderUin", paramMessageForMixedMsg.senderuin);
    localHashMap.put("param_toUin", paramMessageForMixedMsg.frienduin);
    localHashMap.put("param_toUinType", String.valueOf(paramMessageForMixedMsg.istroop));
    localHashMap.put("param_sendByLongStruct", String.valueOf(paramBoolean2));
    localHashMap.put("param_richTextLength", String.valueOf(paramMessageForMixedMsg.mRichTextLength));
    if (paramString != null) {
      localHashMap.put("param_errDesc", paramString);
    }
    bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgForward", paramBoolean1, 0L, 0L, localHashMap, "");
  }
  
  private boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, String paramString1, String paramString2, String paramString3, int paramInt1, long paramLong, int paramInt2, azrg paramazrg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "[sendLongTextMsg]data.length = " + paramArrayOfByte.length);
    }
    beyg localbeyg = new beyg();
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.jdField_b_of_type_Int = 131078;
    localbeyg.h = 1;
    localbeyg.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
    localbeyg.jdField_b_of_type_JavaLangString = paramString1;
    localbeyg.c = paramString2;
    localbeyg.d = paramString3;
    localbeyg.jdField_a_of_type_Int = paramInt1;
    localbeyg.jdField_a_of_type_Long = paramLong;
    localbeyg.e = paramInt2;
    localbeyg.jdField_a_of_type_Azrg = paramazrg;
    localbeyg.r = a();
    paramQQAppInterface.a().a(localbeyg);
    return true;
  }
  
  public int a()
  {
    return 2;
  }
  
  public void a(SessionInfo paramSessionInfo, long paramLong, int paramInt)
  {
    Object localObject = (ChatMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject != null) {
      if (((ChatMessage)localObject).msgtype == -1036)
      {
        localObject = (MessageForMixedMsg)((MessageForLongMsg)localObject).rebuildLongMsg();
        ((MessageForMixedMsg)localObject).mForwardFromUniSeq = paramLong;
        ((MessageForMixedMsg)localObject).forwardID = paramInt;
        bbdn.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageForMixedMsg)localObject, paramSessionInfo, paramInt);
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        localObject = (MessageForMixedMsg)localObject;
      }
    }
    QLog.e("MixedMsgManager", 2, "forwardMixedMsg, not find in cache !");
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean)
  {
    a(paramSessionInfo, paramMessageForMixedMsg, paramBoolean, 0);
  }
  
  public void a(SessionInfo paramSessionInfo, MessageForMixedMsg paramMessageForMixedMsg, boolean paramBoolean, int paramInt)
  {
    paramSessionInfo = new MixedMsgManager.1(this, paramSessionInfo, paramInt, paramMessageForMixedMsg, paramBoolean);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(paramSessionInfo);
  }
  
  public void a(QQAppInterface paramQQAppInterface, BaseChatPie paramBaseChatPie, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList, MixedMsgInfo paramMixedMsgInfo)
  {
    if ((paramQQAppInterface == null) || (paramBaseChatPie == null) || (paramMixedMsgInfo == null)) {}
    Object localObject1;
    label228:
    do
    {
      int m;
      Object localObject2;
      do
      {
        return;
        localObject1 = paramMixedMsgInfo.b();
        if ((TextUtils.isEmpty(paramMixedMsgInfo.b())) && (localObject1 != null) && (((List)localObject1).size() == 1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "sendMixedMrInfo, only 1 pic, send by pic message");
          }
          aiaf.a(paramQQAppInterface, paramBaseChatPie, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout, paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioPanelPanelIconLinearLayout, false, null).a(paramBaseChatPie, (List)localObject1, false);
          return;
        }
        int i;
        MessageForReplyText.SourceMsgInfo localSourceMsgInfo;
        boolean bool1;
        Object localObject3;
        int k;
        int j;
        Object localObject4;
        Object localObject5;
        if (localObject1 == null)
        {
          i = 0;
          a("0X800AE1B", i);
          localSourceMsgInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo;
          localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
          m = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
          paramBaseChatPie = new ArrayList();
          boolean bool2 = false;
          bool1 = bool2;
          if (paramArrayList != null)
          {
            bool1 = bool2;
            if (!paramArrayList.isEmpty())
            {
              localObject2 = (bgty)paramQQAppInterface.getManager(203);
              localObject3 = paramArrayList.iterator();
              do
              {
                bool1 = bool2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
              } while (!((bgty)localObject2).a(((MessageForText.AtTroopMemberInfo)((Iterator)localObject3).next()).uin));
              bool1 = true;
            }
          }
          localObject2 = new HashMap();
          k = 0;
          i = 1;
          if (k >= paramMixedMsgInfo.a().size()) {
            break label672;
          }
          localObject3 = (MixedMsgInfo.MsgNode)paramMixedMsgInfo.a().get(k);
          j = i;
          if ((localObject3 instanceof MixedMsgInfo.TextMsgNode))
          {
            localObject4 = ((MixedMsgInfo.MsgNode)localObject3).text();
            j = i;
            if (!TextUtils.isEmpty((CharSequence)localObject4))
            {
              if ((i == 0) || (localSourceMsgInfo == null)) {
                break label601;
              }
              localObject5 = bcry.a(paramQQAppInterface, (String)localObject1, m, localSourceMsgInfo, (String)localObject4);
              ((MessageForReplyText)localObject5).atInfoList = paramArrayList;
              paramBaseChatPie.add(localObject5);
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, "Attach at first text node");
              }
              i = 0;
              j = i;
              if (QLog.isColorLevel())
              {
                QLog.d("MixedMsgManager", 2, "add txt:" + (String)localObject4);
                j = i;
              }
            }
          }
          if ((localObject3 instanceof MixedMsgInfo.PhotoMsgNode))
          {
            localObject3 = ((MixedMsgInfo.PhotoMsgNode)localObject3).getPhotoItem();
            if ((localObject3 != null) && (auog.a(((MixedMsgInfo.PhotoItem)localObject3).path)))
            {
              localObject4 = a(paramQQAppInterface, ((MixedMsgInfo.PhotoItem)localObject3).path, null, (String)localObject1, m);
              ThreadManager.getFileThreadHandler().post(new MixedMsgManager.6(this, (MessageForPic)localObject4));
              ((MessageForPic)localObject4).subMsgId = paramBaseChatPie.size();
              paramBaseChatPie.add(localObject4);
              localObject5 = (Boolean)((Map)localObject2).get(((MessageForPic)localObject4).path);
              if (localObject5 != null) {
                break label640;
              }
              ((Map)localObject2).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject3).isOriginal));
            }
          }
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("MixedMsgManager", 2, "add pic:" + ((MessageForPic)localObject4).path + ", raw:" + ((Map)localObject2).get(((MessageForPic)localObject4).path));
          }
          k += 1;
          i = j;
          break label228;
          i = ((List)localObject1).size();
          break;
          localObject5 = bcry.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), (String)localObject1, (String)localObject1, m, (byte)1, (byte)0, (short)0, (String)localObject4);
          ((MessageForText)localObject5).atInfoList = paramArrayList;
          paramBaseChatPie.add(localObject5);
          break label348;
          if (!((Boolean)localObject5).booleanValue()) {
            ((Map)localObject2).put(((MessageForPic)localObject4).path, Boolean.valueOf(((MixedMsgInfo.PhotoItem)localObject3).isOriginal));
          }
        }
        paramBaseChatPie = a(paramBaseChatPie, paramArrayList, localSourceMsgInfo, m, bool1);
      } while (paramBaseChatPie == null);
      a(paramBaseChatPie, paramArrayList, (String)localObject1, (Map)localObject2);
      paramQQAppInterface.a().f((String)localObject1, m);
    } while (!QLog.isColorLevel());
    label348:
    QLog.d("MixedMsgManager", 2, "orderSender, sessionUin:" + (String)localObject1 + ", sequin:" + paramBaseChatPie.uniseq);
    label601:
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic, boolean paramBoolean, azrg paramazrg)
  {
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = paramMessageForPic.selfuin;
    localbeyg.c = paramMessageForPic.frienduin;
    localbeyg.jdField_a_of_type_Int = paramMessageForPic.istroop;
    localbeyg.jdField_b_of_type_Int = 1;
    localbeyg.jdField_a_of_type_Long = (paramMessageForPic.uniseq + paramMessageForPic.subMsgId);
    for (Object localObject = localbeyg.c + localbeyg.jdField_a_of_type_Long; paramQQAppInterface.a().jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(localObject); localObject = localbeyg.c + localbeyg.jdField_a_of_type_Long) {
      localbeyg.jdField_a_of_type_Long += 100L;
    }
    localbeyg.jdField_a_of_type_Boolean = true;
    localbeyg.f = false;
    localObject = new beyk();
    ((beyk)localObject).jdField_a_of_type_Boolean = paramBoolean;
    localbeyg.jdField_a_of_type_JavaLangObject = localObject;
    localbeyg.i = paramMessageForPic.path;
    localbeyg.jdField_a_of_type_Azrg = paramazrg;
    localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageForPic;
    paramQQAppInterface.a().a(localbeyg);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    paramMessageRecord.extraflag = 32768;
    paramQQAppInterface.a().a(paramMessageRecord.frienduin, paramMessageRecord.istroop, paramMessageRecord.uniseq);
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, false, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, ArrayList<String> paramArrayList, boolean paramBoolean, String paramString2, ArrayList<MessageForText.AtTroopMemberInfo> paramArrayList1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo)
  {
    if ((paramQQAppInterface == null) || (paramArrayList == null) || (paramArrayList.isEmpty())) {
      return;
    }
    Object localObject = new ArrayList();
    boolean bool;
    if (paramSourceMsgInfo != null)
    {
      paramString2 = bcry.a(paramQQAppInterface, paramString1, paramInt, paramSourceMsgInfo, paramString2);
      paramString2.atInfoList = paramArrayList1;
      ((List)localObject).add(paramString2);
      bool = false;
    }
    for (;;)
    {
      label64:
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramString2 = (String)paramArrayList.next();
        if (auog.a(paramString2))
        {
          paramString2 = a(paramQQAppInterface, paramString2, null, paramString1, paramInt);
          if (paramString2 != null)
          {
            ThreadManager.post(new MixedMsgManager.5(this, paramString2), 8, null, true);
            paramString2.subMsgId = ((List)localObject).size();
            ((List)localObject).add(paramString2);
            continue;
            if (TextUtils.isEmpty(paramString2)) {
              break label417;
            }
            paramString2 = bcry.a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString1, paramInt, (byte)1, (byte)0, (short)0, paramString2);
            paramString2.atInfoList = paramArrayList1;
            if ((paramString2.atInfoList == null) || (paramString2.atInfoList.isEmpty())) {
              break label411;
            }
            bgty localbgty = (bgty)paramQQAppInterface.getManager(203);
            Iterator localIterator = paramString2.atInfoList.iterator();
            do
            {
              if (!localIterator.hasNext()) {
                break;
              }
            } while (!localbgty.a(((MessageForText.AtTroopMemberInfo)localIterator.next()).uin));
          }
        }
      }
      label411:
      for (bool = true;; bool = false)
      {
        ((List)localObject).add(paramString2);
        break label64;
        paramArrayList = a((List)localObject, paramArrayList1, paramSourceMsgInfo, paramInt, bool);
        if (paramArrayList == null) {
          break;
        }
        paramString2 = new HashMap();
        paramSourceMsgInfo = paramArrayList.msgElemList.iterator();
        while (paramSourceMsgInfo.hasNext())
        {
          localObject = (MessageRecord)paramSourceMsgInfo.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            if (auog.a(((MessageForPic)localObject).path)) {
              paramString2.put(((MessageForPic)localObject).path, Boolean.valueOf(paramBoolean));
            }
          }
        }
        a(paramArrayList, paramArrayList1, paramString1, paramString2);
        paramQQAppInterface.a().f(paramString1, paramInt);
        return;
      }
      label417:
      bool = false;
    }
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_istroop", String.valueOf(paramMessageRecord.istroop));
    localHashMap.put("param_issend", String.valueOf(paramMessageRecord.issend));
    localHashMap.put("param_msgtype", String.valueOf(paramMessageRecord.msgtype));
    localHashMap.put("param_isAnonymous", String.valueOf(nlj.a(paramMessageRecord)));
    bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgReceived", true, 0L, 0L, localHashMap, "");
  }
  
  public void a(String paramString, int paramInt, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, " sendStructLongMsg start");
    }
    if ((paramMessageForMixedMsg instanceof ChatMessage)) {
      paramMessageForMixedMsg.mPendantAnimatable = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg saveMessage end and pack StructLongMsg start currenttime:" + System.currentTimeMillis());
    }
    byte[] arrayOfByte = paramQQAppInterface.a().a().a(paramMessageForMixedMsg);
    if (arrayOfByte == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "step2: sendStructLongMsg pack failed! packData is null.............................");
      }
      a(paramMessageForMixedMsg, true, "sendStructLongMsg pack fail : packData is null");
    }
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        paramString = new axfa(this, paramQQAppInterface, paramMessageForMixedMsg, paramString, paramInt);
        paramBoolean = a(paramQQAppInterface, arrayOfByte, paramQQAppInterface.getCurrentAccountUin(), paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.frienduin, paramMessageForMixedMsg.istroop, paramMessageForMixedMsg.uniseq, 1035, new axfb(this, paramQQAppInterface, paramMessageForMixedMsg, paramString));
        if (!paramBoolean) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("MixedMsgManager", 2, "sendLongTextMsg successful, uploadLongTextMsgPkg start!");
      return;
    } while (!QLog.isColorLevel());
    QLog.d("MixedMsgManager", 2, "sendLongTextMsg failed! isSuccess:" + paramBoolean);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("param_uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localHashMap.put("param_isTroop", String.valueOf(paramInt));
    if (paramBoolean)
    {
      bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientAutoPull", true, 0L, 0L, localHashMap, "");
      return;
    }
    bdmc.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MixedMsgClientManualPull", true, 0L, 0L, localHashMap, "");
  }
  
  protected void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord.istroop != 3000) && (paramMessageRecord.istroop != 1)) {
      paramMessageRecord.extraflag = 32770;
    }
    String str = paramMessageRecord.frienduin;
    int i = paramMessageRecord.istroop;
    long l = paramMessageRecord.uniseq;
    paramQQAppInterface.a().notifyUI(1000, true, new Object[] { str, Integer.valueOf(i), Integer.valueOf(-1), null, Long.valueOf(0L), Long.valueOf(l) });
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axey
 * JD-Core Version:    0.7.0.1
 */