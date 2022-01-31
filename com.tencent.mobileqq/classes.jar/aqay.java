import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.MessageRecord;>;
import java.util.Set;
import msf.msgcomm.msg_comm.ExtGroupKeyInfo;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import tencent.im.s2c.msgtype0x210.submsgtype0x122.submsgtype0x122.MsgBody;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class aqay
{
  private static MessageRecord jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  public static String a;
  private static List<MessageRecord> jdField_a_of_type_JavaUtilList = new ArrayList(1);
  private static MessageRecord b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "UniteGrayTip";
  }
  
  public static int a(int paramInt)
  {
    int k = 1;
    int i;
    int j;
    if ((paramInt & 0x1) == 1)
    {
      i = 1;
      if ((paramInt & 0x2) != 2) {
        break label50;
      }
      j = 1;
      label20:
      if ((paramInt & 0x4) != 4) {
        break label55;
      }
      paramInt = k;
    }
    for (;;)
    {
      if (i != 0)
      {
        if ((j == 0) || (paramInt != 0))
        {
          return -5040;
          i = 0;
          break;
          label50:
          j = 0;
          break label20;
          label55:
          paramInt = 0;
          continue;
        }
        return -5021;
      }
    }
    if (j != 0)
    {
      if (paramInt != 0) {
        return -5020;
      }
      return -5023;
    }
    return -5022;
  }
  
  public static aqap a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp parseXML " + paramString);
    }
    Object localObject4;
    boolean bool;
    Object localObject3;
    try
    {
      paramString = new ByteArrayInputStream(paramString.getBytes("utf-8"));
      localXmlPullParser = Xml.newPullParser();
      localXmlPullParser.setInput(paramString, "utf-8");
      i = localXmlPullParser.getEventType();
      localObject4 = null;
      bool = true;
      localObject1 = null;
      paramString = null;
    }
    catch (Exception localException1)
    {
      try
      {
        XmlPullParser localXmlPullParser;
        int i = localXmlPullParser.next();
        localObject3 = paramString;
        paramString = (String)localObject1;
        Object localObject1 = localObject3;
      }
      catch (Exception localException4)
      {
        Object localObject5;
        break label1063;
      }
      localException1 = localException1;
      paramString = null;
      if (!QLog.isColorLevel()) {
        break label1098;
      }
      QLog.i("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, exception: " + localException1.getStackTrace());
      bool = false;
    }
    if (i != 1)
    {
      localObject5 = localObject1;
      for (;;)
      {
        try
        {
          str = localXmlPullParser.getName();
          switch (i)
          {
          case 2: 
            localObject5 = localObject1;
            if (str.equals("gtip"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                paramString = (String)localObject1;
                localObject1 = localObject3;
                break label1154;
              }
              localObject5 = localObject1;
              paramString = new aqap(1);
            }
            break;
          }
        }
        catch (Exception localException3)
        {
          String str;
          int j;
          paramString = localObject5;
          continue;
        }
        try
        {
          localObject3 = paramString.a();
          j = localXmlPullParser.getAttributeCount();
          i = 0;
          if (i < j)
          {
            localObject1 = localXmlPullParser.getAttributeName(i);
            localObject4 = localXmlPullParser.getAttributeValue(i);
            if (((String)localObject1).equals("align")) {
              ((aqaq)localObject3).a(1, localObject4);
            }
            i += 1;
            continue;
          }
          localObject1 = paramString;
          paramString = (String)localObject3;
          if (!bool)
          {
            localObject4 = paramString;
            paramString = (String)localObject1;
            localObject1 = localObject3;
            break label1154;
            localObject5 = localObject1;
            if (str.equals("dialog"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                paramString = (String)localObject1;
                localObject1 = localObject3;
                break label1154;
              }
              localObject5 = localObject1;
              paramString = new aqap(6);
            }
          }
        }
        catch (Exception localException2)
        {
          continue;
        }
        try
        {
          localObject3 = paramString.a();
          localObject1 = paramString;
          paramString = (String)localObject3;
        }
        catch (Exception localException5)
        {
          continue;
          paramString = (String)localObject4;
          continue;
          paramString = (String)localObject4;
          continue;
        }
        localObject5 = localObject1;
        if (str.equals("nor"))
        {
          localObject5 = localObject1;
          localObject4 = new aqaq(2);
          localObject3 = paramString;
          paramString = (String)localObject4;
        }
        else
        {
          localObject5 = localObject1;
          if (str.equals("url"))
          {
            localObject5 = localObject1;
            localObject4 = new aqaq(3);
            localObject3 = paramString;
            paramString = (String)localObject4;
          }
          else
          {
            localObject5 = localObject1;
            if (str.equals("qq"))
            {
              localObject5 = localObject1;
              localObject4 = new aqaq(4);
              localObject3 = paramString;
              paramString = (String)localObject4;
            }
            else
            {
              localObject5 = localObject1;
              if (str.equals("img"))
              {
                localObject5 = localObject1;
                localObject4 = new aqaq(5);
                localObject3 = paramString;
                paramString = (String)localObject4;
              }
              else
              {
                localObject5 = localObject1;
                if (str.equals("title"))
                {
                  localObject5 = localObject1;
                  localObject4 = new aqaq(7);
                  localObject3 = paramString;
                  paramString = (String)localObject4;
                }
                else
                {
                  localObject5 = localObject1;
                  if (str.equals("alert"))
                  {
                    localObject5 = localObject1;
                    localObject4 = new aqaq(8);
                    localObject3 = paramString;
                    paramString = (String)localObject4;
                  }
                  else
                  {
                    localObject5 = localObject1;
                    if (str.equals("btn"))
                    {
                      localObject5 = localObject1;
                      localObject4 = new aqaq(9);
                      localObject3 = paramString;
                      paramString = (String)localObject4;
                    }
                    else
                    {
                      localObject5 = localObject1;
                      if (str.equals("item"))
                      {
                        localObject5 = localObject1;
                        localObject4 = new aqaq(10);
                        localObject3 = paramString;
                        paramString = (String)localObject4;
                      }
                      else
                      {
                        localObject5 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label1192;
                        }
                        localObject5 = localObject1;
                        QLog.i("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, illegel note: " + str);
                        break label1192;
                        localObject5 = localObject1;
                        bool = a(paramString, (aqaq)localObject3, localXmlPullParser);
                        localObject4 = paramString;
                        localObject3 = paramString;
                        paramString = (String)localObject1;
                        localObject1 = localObject3;
                        break label1154;
                        localObject5 = localObject1;
                        localObject3 = localXmlPullParser.getText();
                        if (localObject4 != null)
                        {
                          localObject5 = localObject1;
                          if (((aqaq)localObject4).a())
                          {
                            localObject5 = localObject1;
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                            {
                              localObject5 = localObject1;
                              ((aqaq)localObject4).a(2, localObject3);
                              localObject3 = paramString;
                              paramString = (String)localObject1;
                              localObject1 = localObject3;
                              break label1154;
                              localObject5 = localObject1;
                              if (str.equals("gtip"))
                              {
                                localObject3 = paramString;
                                break label1203;
                              }
                              localObject5 = localObject1;
                              localObject3 = paramString;
                              if (str.equals("dialog")) {
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("nor"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((aqaq)localObject4).a();
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("url"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((aqaq)localObject4).a();
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("qq"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((aqaq)localObject4).a();
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("img"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((aqaq)localObject4).a();
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("title"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((aqaq)localObject4).a();
                                break label1203;
                              }
                              localObject5 = localObject1;
                              if (str.equals("alert"))
                              {
                                if (localObject4 == null)
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString.a();
                                  break label1203;
                                }
                              }
                              else
                              {
                                localObject5 = localObject1;
                                if (str.equals("btn"))
                                {
                                  if (localObject4 == null)
                                  {
                                    localObject5 = localObject1;
                                    localObject3 = paramString.a();
                                    break label1203;
                                  }
                                }
                                else
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString;
                                  if (!str.equals("item")) {
                                    break label1203;
                                  }
                                  localObject5 = localObject1;
                                  localObject3 = ((aqaq)localObject4).a();
                                  break label1203;
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label1063:
    label1192:
    label1203:
    label1214:
    for (;;)
    {
      label1098:
      paramString = localException5;
      break label1158;
      localObject3 = localException5;
      Object localObject2 = paramString;
      paramString = (String)localObject3;
      for (;;)
      {
        if (bool) {
          break label1214;
        }
        if (!bool) {
          paramString = null;
        }
        return paramString;
        localObject3 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject3;
        continue;
        bool = false;
        localObject3 = paramString;
        paramString = (String)localObject4;
        break;
        localObject4 = null;
        paramString = (String)localObject2;
        localObject2 = localObject3;
      }
    }
  }
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2, long paramLong1, aqap paramaqap, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    if (paramaqap == null) {}
    StringBuilder localStringBuilder;
    aqax localaqax;
    Object localObject1;
    do
    {
      return null;
      localStringBuilder = new StringBuilder();
      localaqax = new aqax(paramString, paramQQAppInterface.getCurrentAccountUin(), localStringBuilder.toString(), paramInt1, paramInt2, 655397, paramLong1);
      localObject1 = paramaqap.a();
    } while (localObject1 == null);
    Object localObject2 = "";
    Object localObject3 = ((aqaq)localObject1).a();
    Object localObject4 = ((HashMap)localObject3).keySet().iterator();
    Object localObject5;
    if (((Iterator)localObject4).hasNext())
    {
      paramaqap = (Integer)((Iterator)localObject4).next();
      localObject5 = ((HashMap)localObject3).get(paramaqap);
      if (paramaqap.intValue() != 1) {
        break label1188;
      }
    }
    label1188:
    for (paramaqap = (String)localObject5;; paramaqap = (aqap)localObject2)
    {
      localObject2 = paramaqap;
      break;
      localObject3 = ((aqaq)localObject1).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        paramaqap = (aqaq)((Iterator)localObject3).next();
        int i;
        switch (paramaqap.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 2: 
          paramaqap = paramaqap.a();
          localObject1 = paramaqap.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (Integer)((Iterator)localObject1).next();
            localObject5 = paramaqap.get(localObject4);
            if (((Integer)localObject4).intValue() == 2) {
              localStringBuilder.append(localObject5);
            }
          }
        case 3: 
          paramaqap = paramaqap.a();
          localObject4 = paramaqap.keySet();
          i = localStringBuilder.length();
          paramInt2 = localStringBuilder.length();
          localObject1 = new Bundle();
          localObject4 = ((Set)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Integer)((Iterator)localObject4).next();
            if (((Integer)localObject5).intValue() == 2)
            {
              localObject5 = (String)paramaqap.get(localObject5);
              localStringBuilder.append((String)localObject5);
              paramInt2 = i + ((String)localObject5).length();
            }
            for (;;)
            {
              break;
              if (((Integer)localObject5).intValue() == 5)
              {
                localObject5 = (String)paramaqap.get(localObject5);
                if (((String)localObject5).equals("2")) {
                  ((Bundle)localObject1).putString("textColor", "#FFFF596A");
                }
                for (;;)
                {
                  break;
                  if (((String)localObject5).equals("3")) {
                    ((Bundle)localObject1).putString("textColor", "#FF4D94FF");
                  }
                }
              }
              if (((Integer)localObject5).intValue() == 4)
              {
                localObject5 = (String)paramaqap.get(localObject5);
                if ((((String)localObject5).startsWith("http://")) || (((String)localObject5).startsWith("https://")))
                {
                  ((Bundle)localObject1).putInt("key_action", 1);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject5);
                }
                else if (((String)localObject5).startsWith("mqq"))
                {
                  ((Bundle)localObject1).putInt("key_action", 3);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject5);
                }
              }
            }
          }
          localaqax.a(i, paramInt2, (Bundle)localObject1);
          break;
        case 4: 
          localObject5 = paramaqap.a();
          Object localObject6 = ((HashMap)localObject5).keySet();
          paramInt2 = localStringBuilder.length();
          localStringBuilder.length();
          localObject1 = "";
          paramaqap = "";
          localObject4 = new Bundle();
          localObject6 = ((Set)localObject6).iterator();
          if (((Iterator)localObject6).hasNext())
          {
            Object localObject7 = (Integer)((Iterator)localObject6).next();
            if (((Integer)localObject7).intValue() == 6) {
              localObject1 = (String)((HashMap)localObject5).get(localObject7);
            }
            for (;;)
            {
              break;
              if (((Integer)localObject7).intValue() == 7)
              {
                paramaqap = (String)((HashMap)localObject5).get(localObject7);
              }
              else
              {
                if (((Integer)localObject7).intValue() == 5)
                {
                  localObject7 = (String)((HashMap)localObject5).get(localObject7);
                  if (((String)localObject7).equals("2")) {
                    ((Bundle)localObject4).putString("textColor", "#FFFF596A");
                  }
                  for (;;)
                  {
                    break;
                    if (((String)localObject7).equals("3")) {
                      ((Bundle)localObject4).putString("textColor", "#FF4D94FF");
                    }
                  }
                }
                if (((Integer)localObject7).intValue() == 4)
                {
                  localObject7 = (String)((HashMap)localObject5).get(localObject7);
                  if ((((String)localObject7).startsWith("http://")) || (((String)localObject7).startsWith("https://")))
                  {
                    ((Bundle)localObject4).putInt("key_action", 1);
                    ((Bundle)localObject4).putString("key_action_DATA", (String)localObject7);
                  }
                  else if (((String)localObject7).startsWith("mqq"))
                  {
                    ((Bundle)localObject4).putInt("key_action", 3);
                    ((Bundle)localObject4).putString("key_action_DATA", (String)localObject7);
                  }
                }
              }
            }
          }
          if (((String)localObject1).equals(paramQQAppInterface.getCurrentAccountUin())) {
            paramaqap = ajjy.a(2131650107);
          }
          localStringBuilder.append(paramaqap);
          localaqax.a(paramInt2, paramaqap.length() + paramInt2, (Bundle)localObject4);
          break;
        case 5: 
          paramaqap = paramaqap.a();
          localObject4 = paramaqap.keySet();
          i = localStringBuilder.length();
          paramInt2 = localStringBuilder.length();
          localObject1 = new Bundle();
          localObject4 = ((Set)localObject4).iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Integer)((Iterator)localObject4).next();
            if (((Integer)localObject5).intValue() == 8)
            {
              localObject5 = (String)paramaqap.get(localObject5);
              paramInt2 = "icon".length();
              localStringBuilder.append("icon");
              ((Bundle)localObject1).putString("image_resource", (String)localObject5);
              paramInt2 += i;
            }
            for (;;)
            {
              break;
              if (((Integer)localObject5).intValue() == 4)
              {
                localObject5 = (String)paramaqap.get(localObject5);
                if ((((String)localObject5).startsWith("http://")) || (((String)localObject5).startsWith("https://")))
                {
                  ((Bundle)localObject1).putInt("key_action", 1);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject5);
                }
                else if (((String)localObject5).startsWith("mqq"))
                {
                  ((Bundle)localObject1).putInt("key_action", 3);
                  ((Bundle)localObject1).putString("key_action_DATA", (String)localObject5);
                }
              }
            }
          }
          localaqax.a(i, paramInt2, (Bundle)localObject1);
        }
      }
      localaqax.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
      QLog.d(jdField_a_of_type_JavaLangString, 2, "createUniteGrayTip content :" + localStringBuilder);
      paramaqap = new MessageForUniteGrayTip();
      paramaqap.initGrayTipMsg(paramQQAppInterface, localaqax);
      paramaqap.saveExtInfoToExtStr("unite_gray_tips_align", (String)localObject2);
      a(paramQQAppInterface, paramString, paramInt1, paramLong2, paramLong3, paramArrayOfByte);
      return paramaqap;
    }
  }
  
  public static void a()
  {
    b = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (b != null) {
        break label50;
      }
    }
    label50:
    for (Object localObject = "null";; localObject = Long.valueOf(b.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg set current send msg and clean click msg ,uinseq =", localObject });
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, int paramInt)
  {
    if (jdField_a_of_type_JavaUtilList.size() > 0)
    {
      localArrayList = new ArrayList(2);
      localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        localMessageRecord = (MessageRecord)localIterator.next();
        if (localMessageRecord.msgUid == paramMessageForUniteGrayTip.msgUid) {
          localArrayList.add(localMessageRecord);
        }
      }
      if (localArrayList.size() > 0)
      {
        a(paramQQAppInterface, paramMessageForUniteGrayTip, localArrayList, paramInt, paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString, paramMessageForUniteGrayTip.tipParam);
        paramMessageForUniteGrayTip.updateUniteGrayTipMsgData(paramQQAppInterface);
        paramQQAppInterface = BaseActivity.sTopActivity;
        if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof FragmentActivity)))
        {
          paramQQAppInterface = ((FragmentActivity)paramQQAppInterface).getChatFragment();
          if (paramQQAppInterface != null) {
            paramQQAppInterface.a().e(131072);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
        }
      }
      jdField_a_of_type_JavaUtilList.removeAll(jdField_a_of_type_JavaUtilList);
    }
    while (!QLog.isColorLevel())
    {
      ArrayList localArrayList;
      Iterator localIterator;
      MessageRecord localMessageRecord;
      return;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handleRevokeSameGrayMsgSelfMsgToEditalbe not find msgGray.msgUid =", Long.valueOf(paramMessageForUniteGrayTip.msgUid), ",uinseq=", Long.valueOf(paramMessageForUniteGrayTip.uniseq) });
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList, int paramInt, String paramString, aqax paramaqax)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    Object localObject = null;
    JSONArray localJSONArray = new JSONArray();
    int i = 0;
    Iterator localIterator = paramList.iterator();
    paramList = (List<MessageRecord>)localObject;
    int j;
    while (localIterator.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)localIterator.next();
      if (((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1051)) || (!bado.a(localMessageRecord.issend)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, new Object[] { "revoke msg handle not text msg or not local send, type = ", Integer.valueOf(localMessageRecord.msgtype), ",mr.issend=", Integer.valueOf(localMessageRecord.issend), ",uniseq=", Long.valueOf(localMessageRecord.uniseq) });
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          localObject = jdField_a_of_type_JavaLangString;
          if (localMessageRecord.msg == null) {
            break label334;
          }
          j = localMessageRecord.msg.length();
        }
        for (;;)
        {
          QLog.d((String)localObject, 2, new Object[] { "revoke msg edit mr.msg length = ", Integer.valueOf(j) });
          localStringBuilder.append(localMessageRecord.msg);
          if (paramInt == 1)
          {
            paramList = localMessageRecord.getExtInfoFromExtStr(awav.i);
            label243:
            localObject = paramList;
            if (!TextUtils.isEmpty(paramList)) {
              break label389;
            }
            localObject = paramList;
            if (localMessageRecord.msgtype != -1051) {
              break label389;
            }
            localObject = paramList;
            if (localMessageRecord.atInfoList == null) {
              break label389;
            }
            paramList = localMessageRecord.atInfoList;
            localObject = new JSONArray();
            j = 0;
            label296:
            if (j >= paramList.size()) {}
          }
          else
          {
            try
            {
              ((JSONArray)localObject).put(j, ((MessageForText.AtTroopMemberInfo)paramList.get(j)).toJsonObject());
              j += 1;
              break label296;
              label334:
              j = 0;
              continue;
              if (paramInt != 3000) {
                break label243;
              }
              paramList = localMessageRecord.getExtInfoFromExtStr(awav.j);
            }
            catch (JSONException localJSONException)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle gray json info:", localJSONException);
                }
              }
            }
          }
        }
        localObject = ((JSONArray)localObject).toString();
        label389:
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label895;
        }
      }
    }
    label872:
    label895:
    for (;;)
    {
      try
      {
        paramList = new JSONObject();
        paramList.put(awav.k, localObject);
        paramList.put(awav.l, paramInt);
        localJSONArray.put(i, paramList);
        i += 1;
        paramList = (List<MessageRecord>)localObject;
      }
      catch (JSONException paramList)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle gray at info:", paramList);
        continue;
      }
      if ((localStringBuilder != null) && (localStringBuilder.length() > 0))
      {
        paramMessageForUniteGrayTip.editState = 1;
        paramMessageForUniteGrayTip.editTime = NetConnInfoCenter.getServerTimeMillis();
        paramMessageForUniteGrayTip.editMsgData = localStringBuilder.toString();
        localObject = BaseApplicationImpl.getApplication().getString(2131628770);
        paramString = paramString.concat(" ");
        j = paramString.length();
        k = ((String)localObject).length() + j;
        paramString = paramString.concat((String)localObject);
        paramaqax.jdField_c_of_type_JavaLangString = paramString;
        paramMessageForUniteGrayTip.msg = paramString;
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 27);
        ((Bundle)localObject).putString("key_action_DATA", paramMessageForUniteGrayTip.editMsgData);
        if (!TextUtils.isEmpty(paramList)) {
          ((Bundle)localObject).putString("key_a_action_DATA", localJSONArray.toString());
        }
        paramaqax.a(j, k, (Bundle)localObject);
        if (QLog.isColorLevel())
        {
          if (paramMessageForUniteGrayTip.editMsgData != null)
          {
            paramInt = paramMessageForUniteGrayTip.editMsgData.length();
            i = paramInt;
            if (paramInt > 2) {
              i = 2;
            }
            paramaqax = jdField_a_of_type_JavaLangString;
            l1 = paramMessageForUniteGrayTip.editTime;
            l2 = paramMessageForUniteGrayTip.msgUid;
            l3 = paramMessageForUniteGrayTip.uniseq;
            if (i <= 0) {
              break label872;
            }
            paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
            QLog.d(paramaqax, 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
          }
        }
        else {
          awqx.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
        }
      }
      while (!QLog.isColorLevel()) {
        for (;;)
        {
          int k;
          long l1;
          long l2;
          long l3;
          return;
          paramInt = 0;
          continue;
          paramList = "";
        }
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "revoke msg handle empty msg data");
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForSystemMsg paramMessageForSystemMsg, structmsg.MsgInviteExt paramMsgInviteExt, String paramString)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    long l = paramMessageForSystemMsg.structMsg.msg.action_uin.get();
    int i = -1;
    paramMessageForSystemMsg = null;
    if (paramMsgInviteExt.uint32_src_type.has())
    {
      i = paramMsgInviteExt.uint32_src_type.get();
      paramMessageForSystemMsg = String.valueOf(paramMsgInviteExt.uint64_src_code.get());
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "addTroopTipsFromSystemMsg-->from:" + i + " fromUin:" + paramMessageForSystemMsg);
    }
    paramMsgInviteExt = new Bundle();
    paramMsgInviteExt.putLong("troop_uin", Long.parseLong(paramString));
    paramMsgInviteExt.putString("inviteUin", String.valueOf(l));
    paramMsgInviteExt.putInt("from", i);
    paramMsgInviteExt.putString("fromUin", paramMessageForSystemMsg);
    paramMsgInviteExt.putBoolean("isSysPush", false);
    paramMsgInviteExt.putBoolean("isFromReqSystemMsgNew", true);
    a(paramQQAppInterface, paramString, -1L, true, false, paramMsgInviteExt);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, String.format("handleReserveData, friendUin: %s, uinType: %s, busiType: %s, busiId: %s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(paramLong1), Long.valueOf(paramLong2) }));
    }
    if ((azce.a(paramLong1, paramLong2)) && (paramArrayOfByte != null) && (paramInt == 1)) {
      ((azcd)paramQQAppInterface.getManager(346)).a(paramString, paramArrayOfByte, 1);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, boolean paramBoolean1, boolean paramBoolean2, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addTroopTipsMr troopUin: " + paramString);
    }
    long l = paramLong;
    if (paramLong < 0L) {
      l = NetConnInfoCenter.getServerTime();
    }
    Object localObject = (ajtg)paramQQAppInterface.a(20);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "addFriendTipsMr troopUin=" + paramString);
    }
    ((ajtg)localObject).a(paramString, paramBundle);
    int j;
    if (paramBoolean1)
    {
      paramBundle = paramQQAppInterface.a().b(paramString, 1);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.iterator();
        int i = 0;
        j = i;
        if (!paramBundle.hasNext()) {
          break label196;
        }
        localObject = (MessageRecord)paramBundle.next();
        if ((Math.abs(((MessageRecord)localObject).time - l) >= 30L) || (((MessageRecord)localObject).msgtype != -5021)) {
          break label285;
        }
        i = 1;
      }
    }
    label285:
    for (;;)
    {
      break;
      j = 0;
      label196:
      if (j == 0) {
        paramQQAppInterface.a().c(paramString, 8);
      }
      for (;;)
      {
        if (paramBoolean2) {}
        try
        {
          paramLong = Long.parseLong(paramString);
          azkm.a(paramQQAppInterface, 0, Long.parseLong(paramString), paramLong, Long.parseLong(paramQQAppInterface.getCurrentAccountUin()), "", (int)System.currentTimeMillis(), "OidbSvc.0x852_48", (short)34, false, true);
          return;
          paramQQAppInterface.a().c(paramString, 8);
        }
        catch (NumberFormatException paramQQAppInterface)
        {
          while (!QLog.isColorLevel()) {}
          QLog.d(jdField_a_of_type_JavaLangString, 2, "troopCode not long type!");
          return;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    String str = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
    paramArrayOfByte = localTroopManager.b(str);
    Object localObject = (ajtg)paramQQAppInterface.a(20);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new TroopInfo();
      paramArrayOfByte.troopuin = String.valueOf(str);
      paramArrayOfByte.troopcode = String.valueOf(paramLong1);
      localTroopManager.a(paramArrayOfByte);
      ((ajtg)localObject).j(paramArrayOfByte.troopuin);
      ((ajtg)localObject).a(1, ajex.a(paramArrayOfByte.troopuin), 0L, 2, 0, 0, true);
    }
    for (;;)
    {
      ((ajtg)localObject).a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "handleTroopSystemMessageResp-->msgTime:" + paramLong2 + ":addFriendTipsMr");
      }
      localObject = new Bundle();
      ((Bundle)localObject).putLong("troop_uin", Long.parseLong(paramArrayOfByte.troopuin));
      ((Bundle)localObject).putString("inviteUin", null);
      ((Bundle)localObject).putInt("from", -1);
      ((Bundle)localObject).putString("fromUin", null);
      ((Bundle)localObject).putBoolean("isSysPush", true);
      ((Bundle)localObject).putBoolean("isFromReqSystemMsgNew", false);
      if ((paramMsgHead != null) && (paramMsgHead.ext_group_key_info.has()))
      {
        paramMsgHead = (msg_comm.ExtGroupKeyInfo)paramMsgHead.ext_group_key_info.get();
        int i = paramMsgHead.cur_max_seq.get();
        paramLong1 = paramMsgHead.cur_time.get();
        ((Bundle)localObject).putInt("joinTroopSeq", i);
        ((Bundle)localObject).putLong("joinTroopTime", paramLong1);
      }
      a(paramQQAppInterface, paramArrayOfByte.troopuin, paramLong2, true, true, (Bundle)localObject);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp message prepared");
    }
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        submsgtype0x122.MsgBody localMsgBody = new submsgtype0x122.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint64_busi_type.has()) {
          break label557;
        }
        l1 = localMsgBody.uint64_busi_type.get();
        if (!localMsgBody.uint64_busi_id.has()) {
          break label563;
        }
        l2 = localMsgBody.uint64_busi_id.get();
        if (!localMsgBody.uint32_ctrl_flag.has()) {
          break label569;
        }
        i = localMsgBody.uint32_ctrl_flag.get();
        if (!localMsgBody.uint32_c2c_type.has()) {
          break label575;
        }
        j = localMsgBody.uint32_c2c_type.get();
        if (!localMsgBody.uint32_service_type.has()) {
          break label581;
        }
        k = localMsgBody.uint32_service_type.get();
        if (!localMsgBody.bytes_content.has()) {
          break label587;
        }
        localObject = localMsgBody.bytes_content.get().toByteArray();
        if (!localMsgBody.bytes_pb_reserv.has()) {
          break label593;
        }
        paramArrayOfByte = localMsgBody.bytes_pb_reserv.get().toByteArray();
        if (!localMsgBody.uint64_tips_seq_id.has()) {
          break label598;
        }
        l3 = localMsgBody.uint64_tips_seq_id.get();
        if ((localObject != null) && (localObject.length > 0))
        {
          localObject = new String((byte[])localObject, "utf-8");
          int m = 0;
          int n = a(i);
          i = m;
          if (j == 1)
          {
            j = b(k);
            i = j;
            if (j != -1) {
              break label553;
            }
            i = 0;
            break label553;
          }
          localObject = a((String)localObject);
          paramArrayOfByte = a(paramQQAppInterface, String.valueOf(paramMsgInfo.lFromUin), i, n, paramMsgInfo.uMsgTime, (aqap)localObject, l1, l2, paramArrayOfByte);
          if (paramArrayOfByte == null) {
            break label556;
          }
          paramArrayOfByte.tipParam.d = String.valueOf(l3);
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id" + l3);
          }
          paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
          paramArrayOfByte.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
          if (i != 0) {
            break label611;
          }
          i = 1;
          awqx.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", i, 0, "" + l2, "" + l1, "", "");
          a(paramQQAppInterface, paramArrayOfByte);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label604;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label556;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail ", paramQQAppInterface);
        return;
      }
      catch (NullPointerException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label556;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail2 ", paramQQAppInterface);
        return;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      Object localObject = new submsgtype0x122.MsgBody();
      ((submsgtype0x122.MsgBody)localObject).mergeFrom(paramArrayOfByte);
      audy.a().a((submsgtype0x122.MsgBody)localObject, paramMsgInfo, paramQQAppInterface);
      return;
      label553:
      continue;
      label556:
      return;
      label557:
      long l1 = 0L;
      continue;
      label563:
      long l2 = 0L;
      continue;
      label569:
      int i = 0;
      continue;
      label575:
      int j = 0;
      continue;
      label581:
      int k = 0;
      continue;
      label587:
      localObject = null;
      continue;
      label593:
      paramArrayOfByte = null;
      continue;
      label598:
      long l3 = 0L;
      continue;
      label604:
      localObject = "";
      continue;
      label611:
      i = 2;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramMessageRecord;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label44;
      }
    }
    label44:
    for (paramMessageRecord = "null";; paramMessageRecord = Long.valueOf(jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg current clicked msg uinseq =", paramMessageRecord });
      return;
    }
  }
  
  public static void a(List<MessageRecord> paramList)
  {
    jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  private static boolean a(aqaq paramaqaq1, aqaq paramaqaq2, XmlPullParser paramXmlPullParser)
  {
    paramaqaq1.a(paramaqaq2);
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    if (i < j)
    {
      paramaqaq2 = paramXmlPullParser.getAttributeName(i);
      String str = paramXmlPullParser.getAttributeValue(i);
      if (paramaqaq2.equals("txt")) {
        paramaqaq1.a(2, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramaqaq2.equals("jp"))
        {
          paramaqaq1.a(4, str);
        }
        else if (paramaqaq2.equals("uin"))
        {
          paramaqaq1.a(6, str);
        }
        else if (paramaqaq2.equals("nm"))
        {
          paramaqaq1.a(7, str);
        }
        else if (paramaqaq2.equals("si"))
        {
          paramaqaq1.a(3, str);
        }
        else if (paramaqaq2.equals("col"))
        {
          paramaqaq1.a(5, str);
        }
        else if (paramaqaq2.equals("jp"))
        {
          paramaqaq1.a(4, str);
        }
        else if (paramaqaq2.equals("src"))
        {
          paramaqaq1.a(8, str);
        }
        else
        {
          if (!paramaqaq2.equals("align")) {
            break label225;
          }
          paramaqaq1.a(1, str);
        }
      }
      label225:
      if (QLog.isColorLevel()) {
        QLog.i("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, illegel field: " + paramaqaq2);
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (paramMessageForUniteGrayTip == null) {}
    do
    {
      do
      {
        return false;
        if (((paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_Boolean) || (akbm.g(paramMessageForUniteGrayTip.msgtype))) && ((paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_Boolean) || (akbm.h(paramMessageForUniteGrayTip.msgtype)))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, error param");
      return false;
    } while (b(paramQQAppInterface, paramMessageForUniteGrayTip));
    boolean bool2 = paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Boolean;
    if (!paramMessageForUniteGrayTip.tipParam.e) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      paramQQAppInterface.a().a(paramMessageForUniteGrayTip, paramQQAppInterface.getCurrentAccountUin(), false, bool2, true, bool1);
      return true;
    }
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord.msgtype == -2031) {}
    do
    {
      return true;
      if (!(paramMessageRecord instanceof MessageForUniteGrayTip)) {
        break;
      }
      paramMessageRecord = (MessageForUniteGrayTip)paramMessageRecord;
      if (paramMessageRecord.tipParam == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
        }
        return false;
      }
    } while (paramMessageRecord.tipParam.jdField_b_of_type_Int == 1);
    return false;
  }
  
  public static boolean a(MessageForUniteGrayTip paramMessageForUniteGrayTip, QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    long l1;
    long l2;
    int i;
    int j;
    long l3;
    long l4;
    long l5;
    if (paramMessageForUniteGrayTip != null)
    {
      bool1 = bool2;
      if (paramMessageForUniteGrayTip.editState == 1)
      {
        l1 = NetConnInfoCenter.getServerTimeMillis() - paramMessageForUniteGrayTip.editTime;
        if ((b == null) || (paramMessageForUniteGrayTip.uniseq != b.uniseq))
        {
          bool1 = bool2;
          if (Math.abs(l1) < 180000L) {}
        }
        else
        {
          l2 = System.currentTimeMillis();
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_JavaUtilArrayList != null)) {
            paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_JavaUtilArrayList.clear();
          }
          paramMessageForUniteGrayTip.editState = 0;
          paramMessageForUniteGrayTip.editTime = 0L;
          StringBuilder localStringBuilder = new StringBuilder();
          String str = " " + BaseApplicationImpl.getApplication().getString(2131628770);
          if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString != null)) {
            paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString = paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_JavaLangString.replace(str, "");
          }
          if (paramMessageForUniteGrayTip.msg != null) {
            paramMessageForUniteGrayTip.msg = paramMessageForUniteGrayTip.msg.replace(localStringBuilder.toString(), "");
          }
          if (paramMessageForUniteGrayTip.contentDescription != null) {
            paramMessageForUniteGrayTip.contentDescription = paramMessageForUniteGrayTip.contentDescription.replace(localStringBuilder.toString(), "");
          }
          if (paramMessageForUniteGrayTip.tipParam != null) {
            paramMessageForUniteGrayTip.updateUniteGrayTipMsgData(paramQQAppInterface);
          }
          if ((b != null) && (paramMessageForUniteGrayTip.uniseq == b.uniseq)) {
            awqx.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 1, 0, "", "", "", "");
          }
          if ((b != null) && (paramMessageForUniteGrayTip.uniseq == b.uniseq)) {
            b = null;
          }
          if (QLog.isColorLevel())
          {
            if (paramMessageForUniteGrayTip.editMsgData == null) {
              break label475;
            }
            i = paramMessageForUniteGrayTip.editMsgData.length();
            j = i;
            if (i > 2) {
              j = 2;
            }
            paramQQAppInterface = jdField_a_of_type_JavaLangString;
            l3 = System.currentTimeMillis();
            l4 = paramMessageForUniteGrayTip.msgUid;
            l5 = paramMessageForUniteGrayTip.uniseq;
            if (j <= 0) {
              break label480;
            }
          }
        }
      }
    }
    label475:
    label480:
    for (paramMessageForUniteGrayTip = paramMessageForUniteGrayTip.editMsgData.substring(0, j);; paramMessageForUniteGrayTip = "")
    {
      QLog.e(paramQQAppInterface, 2, new Object[] { "revoke msg handle update edit cost =", Long.valueOf(l3 - l2), ", disappear time delta =", Long.valueOf(l1), ", msguid=", Long.valueOf(l4), ",uniseq=", Long.valueOf(l5), ",msgDta[0-2]=", paramMessageForUniteGrayTip });
      bool1 = true;
      return bool1;
      i = 0;
      break;
    }
  }
  
  private static int b(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder("<---getTempUinType: dump info:");
        localStringBuilder.append(" serviceType:").append(paramInt);
        QLog.d(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      }
      return i;
      i = 1000;
      continue;
      i = 1004;
      continue;
      i = 1024;
      continue;
      i = 1005;
      continue;
      i = 1008;
      continue;
      i = 1006;
      continue;
      i = 1009;
      continue;
      i = 1001;
      continue;
      i = 1020;
      continue;
      i = 1021;
      continue;
      i = 1022;
      continue;
      i = 1023;
      continue;
      i = 1010;
      continue;
      i = 7400;
      continue;
      i = 10002;
      continue;
      i = 10004;
      continue;
      i = 1036;
      continue;
      i = 1032;
      continue;
      i = 1037;
      continue;
      i = 1038;
      continue;
      i = 1044;
    }
  }
  
  public static void b()
  {
    jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
    b = null;
    String str;
    if (QLog.isColorLevel())
    {
      str = jdField_a_of_type_JavaLangString;
      if (b != null) {
        break label48;
      }
    }
    label48:
    for (Object localObject = "null";; localObject = Long.valueOf(b.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg cleanCurrentRevokeMsg ,uinseq =", localObject });
      return;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    paramQQAppInterface = paramQQAppInterface.a().b(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop);
    if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
    {
      Object localObject1;
      Object localObject2;
      if ((paramMessageForUniteGrayTip.tipParam != null) && (paramMessageForUniteGrayTip.tipParam.d != null))
      {
        localObject1 = paramQQAppInterface.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if (((localObject2 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject2).tipParam != null) && (paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int == ((MessageForUniteGrayTip)localObject2).tipParam.jdField_b_of_type_Int) && (paramMessageForUniteGrayTip.tipParam.d.equals(((MessageForUniteGrayTip)localObject2).tipParam.d)))
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, repeat grayTip in cache");
            }
            return true;
          }
        }
      }
      int i = paramQQAppInterface.size() - 1;
      if (i >= 0)
      {
        if ((paramQQAppInterface.size() - i <= 10) && ((paramQQAppInterface.get(i) instanceof MessageForUniteGrayTip)))
        {
          localObject1 = (MessageForUniteGrayTip)paramQQAppInterface.get(i);
          if ((((MessageForUniteGrayTip)localObject1).tipParam != null) && (paramMessageForUniteGrayTip.tipParam != null)) {
            break label231;
          }
        }
        for (;;)
        {
          i -= 1;
          break;
          label231:
          int k;
          int j;
          if (paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_ArrayOfInt != null)
          {
            localObject2 = paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_ArrayOfInt;
            k = localObject2.length;
            j = 0;
            while (j < k)
            {
              if (localObject2[j] == ((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_Int)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
                }
                return true;
              }
              j += 1;
            }
          }
          if (((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_ArrayOfInt != null)
          {
            localObject1 = ((MessageForUniteGrayTip)localObject1).tipParam.jdField_b_of_type_ArrayOfInt;
            k = localObject1.length;
            j = 0;
            while (j < k)
            {
              if (localObject1[j] == paramMessageForUniteGrayTip.tipParam.jdField_b_of_type_Int)
              {
                if (QLog.isColorLevel()) {
                  QLog.e(jdField_a_of_type_JavaLangString, 2, "addGrayTipMsg failed, mutex grayTip in cache");
                }
                return true;
              }
              j += 1;
            }
          }
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqay
 * JD-Core Version:    0.7.0.1
 */