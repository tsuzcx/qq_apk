import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
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

public class avpe
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
  
  public static avov a(String paramString)
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
        break label1079;
      }
      QLog.e("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, exception: ", localException1);
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
                break label1135;
              }
              localObject5 = localObject1;
              paramString = new avov(1);
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
              ((avow)localObject3).a(1, localObject4);
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
            break label1135;
            localObject5 = localObject1;
            if (str.equals("dialog"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                paramString = (String)localObject1;
                localObject1 = localObject3;
                break label1135;
              }
              localObject5 = localObject1;
              paramString = new avov(6);
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
          localObject4 = new avow(2);
          localObject3 = paramString;
          paramString = (String)localObject4;
        }
        else
        {
          localObject5 = localObject1;
          if (str.equals("url"))
          {
            localObject5 = localObject1;
            localObject4 = new avow(3);
            localObject3 = paramString;
            paramString = (String)localObject4;
          }
          else
          {
            localObject5 = localObject1;
            if (str.equals("qq"))
            {
              localObject5 = localObject1;
              localObject4 = new avow(4);
              localObject3 = paramString;
              paramString = (String)localObject4;
            }
            else
            {
              localObject5 = localObject1;
              if (str.equals("img"))
              {
                localObject5 = localObject1;
                localObject4 = new avow(5);
                localObject3 = paramString;
                paramString = (String)localObject4;
              }
              else
              {
                localObject5 = localObject1;
                if (str.equals("title"))
                {
                  localObject5 = localObject1;
                  localObject4 = new avow(7);
                  localObject3 = paramString;
                  paramString = (String)localObject4;
                }
                else
                {
                  localObject5 = localObject1;
                  if (str.equals("alert"))
                  {
                    localObject5 = localObject1;
                    localObject4 = new avow(8);
                    localObject3 = paramString;
                    paramString = (String)localObject4;
                  }
                  else
                  {
                    localObject5 = localObject1;
                    if (str.equals("btn"))
                    {
                      localObject5 = localObject1;
                      localObject4 = new avow(9);
                      localObject3 = paramString;
                      paramString = (String)localObject4;
                    }
                    else
                    {
                      localObject5 = localObject1;
                      if (str.equals("item"))
                      {
                        localObject5 = localObject1;
                        localObject4 = new avow(10);
                        localObject3 = paramString;
                        paramString = (String)localObject4;
                      }
                      else
                      {
                        localObject5 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label1173;
                        }
                        localObject5 = localObject1;
                        QLog.i("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, illegel note: " + str);
                        break label1173;
                        localObject5 = localObject1;
                        bool = a(paramString, (avow)localObject3, localXmlPullParser);
                        localObject4 = paramString;
                        localObject3 = paramString;
                        paramString = (String)localObject1;
                        localObject1 = localObject3;
                        break label1135;
                        localObject5 = localObject1;
                        localObject3 = localXmlPullParser.getText();
                        if (localObject4 != null)
                        {
                          localObject5 = localObject1;
                          if (((avow)localObject4).a())
                          {
                            localObject5 = localObject1;
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                            {
                              localObject5 = localObject1;
                              ((avow)localObject4).a(2, localObject3);
                              localObject3 = paramString;
                              paramString = (String)localObject1;
                              localObject1 = localObject3;
                              break label1135;
                              localObject5 = localObject1;
                              if (str.equals("gtip"))
                              {
                                localObject3 = paramString;
                                break label1184;
                              }
                              localObject5 = localObject1;
                              localObject3 = paramString;
                              if (str.equals("dialog")) {
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("nor"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avow)localObject4).a();
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("url"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avow)localObject4).a();
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("qq"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avow)localObject4).a();
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("img"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avow)localObject4).a();
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("title"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avow)localObject4).a();
                                break label1184;
                              }
                              localObject5 = localObject1;
                              if (str.equals("alert"))
                              {
                                if (localObject4 == null)
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString.a();
                                  break label1184;
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
                                    break label1184;
                                  }
                                }
                                else
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString;
                                  if (!str.equals("item")) {
                                    break label1184;
                                  }
                                  localObject5 = localObject1;
                                  localObject3 = ((avow)localObject4).a();
                                  break label1184;
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
    label1195:
    for (;;)
    {
      label1079:
      paramString = localException5;
      break label1139;
      localObject3 = localException5;
      Object localObject2 = paramString;
      paramString = (String)localObject3;
      for (;;)
      {
        label1135:
        if (bool) {
          break label1195;
        }
        label1139:
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
  
  public static MessageForUniteGrayTip a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, long paramLong1, String paramString2, long paramLong2, long paramLong3, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "createUniteGrayTip contentXml " + paramString2);
    }
    paramString2 = a(paramString2);
    if ((paramString2 == null) || (a(paramString1, paramQQAppInterface, paramLong2, paramLong3, paramArrayOfByte))) {}
    avpd localavpd;
    Object localObject1;
    do
    {
      return null;
      localavpd = new avpd(paramString1, paramQQAppInterface.getCurrentAccountUin(), "", paramInt1, paramInt2, 655397, paramLong1);
      localObject1 = paramString2.a();
    } while (localObject1 == null);
    paramString2 = "";
    HashMap localHashMap = ((avow)localObject1).a();
    Iterator localIterator = localHashMap.keySet().iterator();
    if (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      Object localObject2 = localHashMap.get(localInteger);
      if (localInteger.intValue() != 1) {
        break label219;
      }
      paramString2 = (String)localObject2;
    }
    label219:
    for (;;)
    {
      break;
      a(paramQQAppInterface, localavpd, (avow)localObject1, paramInt1, paramString1);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, localavpd);
      ((MessageForUniteGrayTip)localObject1).saveExtInfoToExtStr("unite_gray_tips_align", paramString2);
      a(paramQQAppInterface, paramString1, paramInt1, paramLong2, paramLong3, paramArrayOfByte);
      return localObject1;
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
        break label48;
      }
    }
    label48:
    for (Object localObject = "null";; localObject = Long.valueOf(b.uniseq))
    {
      QLog.e(str, 2, new Object[] { "revoke msg set current send msg and clean click msg ,uinseq =", localObject });
      return;
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, avpd paramavpd, avow paramavow, int paramInt, String paramString)
  {
    if (paramavpd.jdField_a_of_type_JavaUtilArrayList != null) {
      paramavpd.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = paramavow.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      paramavow = (avow)localIterator.next();
      Object localObject1;
      Object localObject2;
      Object localObject3;
      int j;
      int i;
      switch (paramavow.jdField_a_of_type_Int)
      {
      default: 
        break;
      case 2: 
        paramavow = paramavow.a();
        localObject1 = paramavow.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Integer)((Iterator)localObject1).next();
          localObject3 = paramavow.get(localObject2);
          if (((Integer)localObject2).intValue() == 2) {
            localStringBuilder.append(localObject3);
          }
        }
      case 3: 
        paramavow = paramavow.a();
        localObject2 = paramavow.keySet();
        j = localStringBuilder.length();
        i = localStringBuilder.length();
        localObject1 = new Bundle();
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          if (((Integer)localObject3).intValue() == 2)
          {
            localObject3 = (String)paramavow.get(localObject3);
            localStringBuilder.append((String)localObject3);
            i = j + ((String)localObject3).length();
          }
          for (;;)
          {
            break;
            if (((Integer)localObject3).intValue() == 5)
            {
              localObject3 = (String)paramavow.get(localObject3);
              if (((String)localObject3).equals("2")) {
                ((Bundle)localObject1).putString("textColor", "#FFFF596A");
              }
              for (;;)
              {
                break;
                if (((String)localObject3).equals("3")) {
                  ((Bundle)localObject1).putString("textColor", "#FF4D94FF");
                }
              }
            }
            if (((Integer)localObject3).intValue() == 4)
            {
              localObject3 = (String)paramavow.get(localObject3);
              if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
              {
                ((Bundle)localObject1).putInt("key_action", 1);
                ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
              }
              else if (((String)localObject3).startsWith("mqq"))
              {
                ((Bundle)localObject1).putInt("key_action", 3);
                ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
              }
            }
          }
        }
        paramavpd.a(j, i, (Bundle)localObject1);
        break;
      case 4: 
        localObject3 = paramavow.a();
        Object localObject4 = ((HashMap)localObject3).keySet();
        i = localStringBuilder.length();
        localStringBuilder.length();
        localObject1 = "";
        paramavow = "";
        localObject2 = new Bundle();
        localObject4 = ((Set)localObject4).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          Object localObject5 = (Integer)((Iterator)localObject4).next();
          if (((Integer)localObject5).intValue() == 6) {
            localObject1 = (String)((HashMap)localObject3).get(localObject5);
          }
          for (;;)
          {
            break;
            if (((Integer)localObject5).intValue() == 7)
            {
              paramavow = (String)((HashMap)localObject3).get(localObject5);
            }
            else
            {
              if (((Integer)localObject5).intValue() == 5)
              {
                localObject5 = (String)((HashMap)localObject3).get(localObject5);
                if (((String)localObject5).equals("2")) {
                  ((Bundle)localObject2).putString("textColor", "#FFFF596A");
                }
                for (;;)
                {
                  break;
                  if (((String)localObject5).equals("3")) {
                    ((Bundle)localObject2).putString("textColor", "#FF4D94FF");
                  }
                }
              }
              if (((Integer)localObject5).intValue() == 4)
              {
                localObject5 = (String)((HashMap)localObject3).get(localObject5);
                if ((((String)localObject5).startsWith("http://")) || (((String)localObject5).startsWith("https://")))
                {
                  ((Bundle)localObject2).putInt("key_action", 1);
                  ((Bundle)localObject2).putString("key_action_DATA", (String)localObject5);
                }
                else if (((String)localObject5).startsWith("mqq"))
                {
                  ((Bundle)localObject2).putInt("key_action", 3);
                  ((Bundle)localObject2).putString("key_action_DATA", (String)localObject5);
                }
              }
            }
          }
        }
        if (((String)localObject1).equals(paramQQAppInterface.getCurrentAccountUin())) {
          paramavow = anzj.a(2131714679);
        }
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent name : " + paramavow);
          }
          localStringBuilder.append(paramavow);
          paramavpd.a(i, paramavow.length() + i, (Bundle)localObject2);
          break;
          if (adak.d(paramInt)) {
            paramavow = bhlg.j(paramQQAppInterface, (String)localObject1);
          } else if (adak.a(paramInt)) {
            paramavow = bhlg.h(paramQQAppInterface, paramString, (String)localObject1);
          }
        }
      case 5: 
        paramavow = paramavow.a();
        localObject2 = paramavow.keySet();
        j = localStringBuilder.length();
        i = localStringBuilder.length();
        localObject1 = new Bundle();
        localObject2 = ((Set)localObject2).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Integer)((Iterator)localObject2).next();
          if (((Integer)localObject3).intValue() == 8)
          {
            localObject3 = (String)paramavow.get(localObject3);
            i = "icon".length();
            localStringBuilder.append("icon");
            ((Bundle)localObject1).putString("image_resource", (String)localObject3);
            i += j;
          }
          for (;;)
          {
            break;
            if (((Integer)localObject3).intValue() == 4)
            {
              localObject3 = (String)paramavow.get(localObject3);
              if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
              {
                ((Bundle)localObject1).putInt("key_action", 1);
                ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
              }
              else if (((String)localObject3).startsWith("mqq"))
              {
                ((Bundle)localObject1).putInt("key_action", 3);
                ((Bundle)localObject1).putString("key_action_DATA", (String)localObject3);
              }
            }
          }
        }
        paramavpd.a(j, i, (Bundle)localObject1);
      }
    }
    paramavpd.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
    QLog.d(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent content :" + localStringBuilder);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "rebuildUniteTipsContent");
    }
    avpd localavpd = paramMessageForUniteGrayTip.tipParam;
    String str = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
    if ((localavpd != null) && (localavpd.jdField_b_of_type_Int == 655397) && (!TextUtils.isEmpty(str))) {}
    try
    {
      a(paramQQAppInterface, localavpd, a(str).a(), paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.frienduin);
      paramMessageForUniteGrayTip.msg = localavpd.jdField_c_of_type_JavaLangString;
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
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
            paramQQAppInterface.a().f(131072);
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
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList, int paramInt, String paramString, avpd paramavpd)
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
      if (((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1051)) || (!bhnt.a(localMessageRecord.issend)))
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
            paramList = localMessageRecord.getExtInfoFromExtStr(bcrn.i);
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
              paramList = localMessageRecord.getExtInfoFromExtStr(bcrn.j);
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
          break label896;
        }
      }
    }
    label896:
    for (;;)
    {
      try
      {
        paramList = new JSONObject();
        paramList.put(bcrn.k, localObject);
        paramList.put(bcrn.l, paramInt);
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
        localObject = BaseApplicationImpl.getApplication().getString(2131693870);
        paramString = paramString.concat(" ");
        j = paramString.length();
        k = ((String)localObject).length() + j;
        paramString = paramString.concat((String)localObject);
        paramavpd.jdField_c_of_type_JavaLangString = paramString;
        paramMessageForUniteGrayTip.msg = paramString;
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 27);
        ((Bundle)localObject).putString("key_action_DATA", paramMessageForUniteGrayTip.editMsgData);
        if (!TextUtils.isEmpty(paramList)) {
          ((Bundle)localObject).putString("key_a_action_DATA", localJSONArray.toString());
        }
        paramavpd.a(j, k, (Bundle)localObject);
        if (QLog.isColorLevel())
        {
          if (paramMessageForUniteGrayTip.editMsgData != null)
          {
            paramInt = paramMessageForUniteGrayTip.editMsgData.length();
            i = paramInt;
            if (paramInt > 2) {
              i = 2;
            }
            paramavpd = jdField_a_of_type_JavaLangString;
            l1 = paramMessageForUniteGrayTip.editTime;
            l2 = paramMessageForUniteGrayTip.msgUid;
            l3 = paramMessageForUniteGrayTip.uniseq;
            if (i <= 0) {
              break label873;
            }
            paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
            QLog.d(paramavpd, 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
          }
        }
        else {
          bdll.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
        }
      }
      label873:
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
    a(paramQQAppInterface, paramString, -1L, paramMsgInviteExt);
  }
  
  /* Error */
  private static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +46 -> 49
    //   6: getstatic 16	avpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc_w 662
    //   13: iconst_4
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 455	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: lload_3
    //   31: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: lload 5
    //   39: invokestatic 261	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: invokestatic 666	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: lload_3
    //   50: lload 5
    //   52: invokestatic 671	bggn:a	(JJ)Z
    //   55: ifeq +123 -> 178
    //   58: aload 7
    //   60: ifnull +25 -> 85
    //   63: iload_2
    //   64: iconst_1
    //   65: if_icmpne +20 -> 85
    //   68: aload_0
    //   69: sipush 346
    //   72: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   75: checkcast 673	bggj
    //   78: aload_1
    //   79: aload 7
    //   81: iconst_1
    //   82: invokevirtual 676	bggj:a	(Ljava/lang/String;[BI)V
    //   85: ldc2_w 677
    //   88: lload 5
    //   90: lcmp
    //   91: ifne +178 -> 269
    //   94: lconst_1
    //   95: lload_3
    //   96: lcmp
    //   97: ifne +172 -> 269
    //   100: aload 7
    //   102: ifnull +167 -> 269
    //   105: iload_2
    //   106: iconst_1
    //   107: if_icmpne +162 -> 269
    //   110: new 680	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData
    //   113: dup
    //   114: invokespecial 681	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:<init>	()V
    //   117: astore 8
    //   119: aload 8
    //   121: aload 7
    //   123: invokevirtual 685	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload 8
    //   129: getfield 688	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 612	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   135: ifeq +319 -> 454
    //   138: aload 8
    //   140: getfield 688	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: invokevirtual 614	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   146: i2l
    //   147: lstore_3
    //   148: ldc 183
    //   150: astore_0
    //   151: aload 8
    //   153: getfield 692	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 695	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   159: ifeq +12 -> 171
    //   162: aload 8
    //   164: getfield 692	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   167: invokevirtual 697	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   170: astore_0
    //   171: lconst_0
    //   172: lload_3
    //   173: lcmp
    //   174: ifne +48 -> 222
    //   177: return
    //   178: lload 5
    //   180: ldc2_w 698
    //   183: lcmp
    //   184: ifne -99 -> 85
    //   187: aload 7
    //   189: ifnull -104 -> 85
    //   192: iload_2
    //   193: iconst_1
    //   194: if_icmpne -109 -> 85
    //   197: aload_0
    //   198: bipush 52
    //   200: invokevirtual 578	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   203: checkcast 580	com/tencent/mobileqq/app/TroopManager
    //   206: astore_0
    //   207: aload_0
    //   208: ifnull -123 -> 85
    //   211: aload_0
    //   212: aload_1
    //   213: aload 7
    //   215: iconst_1
    //   216: invokevirtual 700	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;[BI)V
    //   219: goto -134 -> 85
    //   222: new 493	org/json/JSONObject
    //   225: dup
    //   226: invokespecial 494	org/json/JSONObject:<init>	()V
    //   229: astore 8
    //   231: aload 8
    //   233: ldc_w 702
    //   236: aload_0
    //   237: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   240: pop
    //   241: aload 8
    //   243: ldc_w 704
    //   246: aload_1
    //   247: invokevirtual 500	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   250: pop
    //   251: ldc_w 706
    //   254: ldc_w 708
    //   257: aload 8
    //   259: invokevirtual 709	org/json/JSONObject:toString	()Ljava/lang/String;
    //   262: ldc_w 711
    //   265: invokestatic 716	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   268: pop
    //   269: ldc2_w 717
    //   272: lload 5
    //   274: lcmp
    //   275: ifne -98 -> 177
    //   278: aload 7
    //   280: ifnull -103 -> 177
    //   283: new 720	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr
    //   286: dup
    //   287: invokespecial 721	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:<init>	()V
    //   290: astore_0
    //   291: aload_0
    //   292: aload 7
    //   294: invokevirtual 722	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   297: pop
    //   298: iconst_0
    //   299: istore_2
    //   300: aload_0
    //   301: getfield 725	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   304: invokevirtual 612	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   307: ifeq +11 -> 318
    //   310: aload_0
    //   311: getfield 725	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   314: invokevirtual 614	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   317: istore_2
    //   318: iconst_1
    //   319: iload_2
    //   320: if_icmpne +99 -> 419
    //   323: aconst_null
    //   324: ldc_w 562
    //   327: ldc 183
    //   329: ldc 183
    //   331: ldc_w 727
    //   334: ldc_w 727
    //   337: iconst_1
    //   338: iconst_0
    //   339: ldc_w 729
    //   342: ldc_w 729
    //   345: ldc 183
    //   347: ldc 183
    //   349: invokestatic 569	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   352: return
    //   353: astore_0
    //   354: aload_0
    //   355: invokevirtual 730	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   358: getstatic 16	avpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   361: iconst_1
    //   362: ldc_w 732
    //   365: aload_0
    //   366: invokestatic 490	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   369: return
    //   370: astore_0
    //   371: getstatic 16	avpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   374: iconst_1
    //   375: ldc_w 734
    //   378: aload_0
    //   379: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   382: goto -131 -> 251
    //   385: astore_0
    //   386: aload_0
    //   387: invokevirtual 730	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   390: getstatic 16	avpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   393: iconst_1
    //   394: ldc_w 732
    //   397: aload_0
    //   398: invokestatic 490	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   401: goto -132 -> 269
    //   404: astore_0
    //   405: getstatic 16	avpe:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   408: iconst_1
    //   409: ldc_w 736
    //   412: aload_0
    //   413: invokestatic 164	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   416: goto -147 -> 269
    //   419: iconst_2
    //   420: iload_2
    //   421: if_icmpne -244 -> 177
    //   424: aconst_null
    //   425: ldc_w 562
    //   428: ldc 183
    //   430: ldc 183
    //   432: ldc_w 727
    //   435: ldc_w 727
    //   438: iconst_2
    //   439: iconst_0
    //   440: ldc_w 729
    //   443: ldc_w 729
    //   446: ldc 183
    //   448: ldc 183
    //   450: invokestatic 569	bdll:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   453: return
    //   454: lconst_0
    //   455: lstore_3
    //   456: goto -308 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	459	0	paramQQAppInterface	QQAppInterface
    //   0	459	1	paramString	String
    //   0	459	2	paramInt	int
    //   0	459	3	paramLong1	long
    //   0	459	5	paramLong2	long
    //   0	459	7	paramArrayOfByte	byte[]
    //   117	141	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   283	298	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   300	318	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   323	352	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   424	453	353	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   231	251	370	org/json/JSONException
    //   110	148	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   151	171	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   222	231	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   231	251	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   251	269	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   371	382	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   405	416	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   251	269	404	java/lang/UnsatisfiedLinkError
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addTroopTipsMr troopUin: " + paramString);
    }
    if (paramLong < 0L) {
      NetConnInfoCenter.getServerTime();
    }
    paramQQAppInterface = (aoip)paramQQAppInterface.a(20);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "addFriendTipsMr troopUin=" + paramString);
    }
    paramQQAppInterface.a(paramString, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
    String str = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
    paramArrayOfByte = localTroopManager.b(str);
    Object localObject = (aoip)paramQQAppInterface.a(20);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new TroopInfo();
      paramArrayOfByte.troopuin = String.valueOf(str);
      paramArrayOfByte.troopcode = String.valueOf(paramLong1);
      localTroopManager.a(paramArrayOfByte);
      ((aoip)localObject).j(paramArrayOfByte.troopuin);
      ((aoip)localObject).a(1, antz.a(paramArrayOfByte.troopuin), 0L, 2, 0, 0, true);
    }
    for (;;)
    {
      ((aoip)localObject).a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
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
      a(paramQQAppInterface, paramArrayOfByte.troopuin, paramLong2, (Bundle)localObject);
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
      long l1;
      long l2;
      int i;
      long l3;
      int j;
      int k;
      Object localObject1;
      long l4;
      try
      {
        localObject2 = new submsgtype0x122.MsgBody();
        ((submsgtype0x122.MsgBody)localObject2).mergeFrom(paramArrayOfByte);
        if (!((submsgtype0x122.MsgBody)localObject2).uint64_busi_type.has()) {
          break label607;
        }
        l1 = ((submsgtype0x122.MsgBody)localObject2).uint64_busi_type.get();
        if (!((submsgtype0x122.MsgBody)localObject2).uint64_busi_id.has()) {
          break label613;
        }
        l2 = ((submsgtype0x122.MsgBody)localObject2).uint64_busi_id.get();
        if (!((submsgtype0x122.MsgBody)localObject2).uint32_ctrl_flag.has()) {
          break label619;
        }
        i = ((submsgtype0x122.MsgBody)localObject2).uint32_ctrl_flag.get();
        if (!((submsgtype0x122.MsgBody)localObject2).uint64_templ_id.has()) {
          break label625;
        }
        l3 = ((submsgtype0x122.MsgBody)localObject2).uint64_templ_id.get();
        if (!((submsgtype0x122.MsgBody)localObject2).uint32_c2c_type.has()) {
          break label631;
        }
        j = ((submsgtype0x122.MsgBody)localObject2).uint32_c2c_type.get();
        if (!((submsgtype0x122.MsgBody)localObject2).uint32_service_type.has()) {
          break label637;
        }
        k = ((submsgtype0x122.MsgBody)localObject2).uint32_service_type.get();
        if (!((submsgtype0x122.MsgBody)localObject2).bytes_content.has()) {
          break label643;
        }
        paramArrayOfByte = ((submsgtype0x122.MsgBody)localObject2).bytes_content.get().toByteArray();
        if (!((submsgtype0x122.MsgBody)localObject2).bytes_pb_reserv.has()) {
          break label648;
        }
        localObject1 = ((submsgtype0x122.MsgBody)localObject2).bytes_pb_reserv.get().toByteArray();
        if (!((submsgtype0x122.MsgBody)localObject2).uint64_tips_seq_id.has()) {
          break label654;
        }
        l4 = ((submsgtype0x122.MsgBody)localObject2).uint64_tips_seq_id.get();
        localObject2 = "";
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
          continue;
        }
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        int m = 0;
        int n = a(i);
        i = m;
        if (j == 1)
        {
          j = b(k);
          i = j;
          if (j != -1) {
            break label603;
          }
          i = 0;
          break label603;
        }
        paramMsgInfo = a(paramQQAppInterface, String.valueOf(paramMsgInfo.lFromUin), i, n, paramMsgInfo.uMsgTime, paramArrayOfByte, l1, l2, (byte[])localObject1);
        if (paramMsgInfo == null) {
          break label606;
        }
        paramMsgInfo.tipParam.d = String.valueOf(l4);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id" + l4);
        }
        paramMsgInfo.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
        paramMsgInfo.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
        paramMsgInfo.saveExtInfoToExtStr("uint64_templ_id", String.valueOf(l3));
        paramMsgInfo.saveExtInfoToExtStr("bytes_content", paramArrayOfByte);
        if (i != 0) {
          continue;
        }
        i = 1;
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          break label606;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail ", paramQQAppInterface);
        return;
        i = 2;
        continue;
        localObject1 = new submsgtype0x122.MsgBody();
        ((submsgtype0x122.MsgBody)localObject1).mergeFrom(paramArrayOfByte);
        banh.a().a((submsgtype0x122.MsgBody)localObject1, paramMsgInfo, paramQQAppInterface);
        return;
      }
      catch (NullPointerException paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          break label606;
        }
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail2 ", paramQQAppInterface);
        return;
      }
      catch (UnsupportedEncodingException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        return;
      }
      bdll.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", i, 0, "" + l2, "" + l1, "", "");
      paramMsgInfo.prewrite();
      a(paramQQAppInterface, paramMsgInfo);
      return;
      paramArrayOfByte = (byte[])localObject2;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
        paramArrayOfByte = (byte[])localObject2;
        continue;
        label603:
        continue;
        label606:
        return;
        label607:
        l1 = 0L;
        continue;
        label613:
        l2 = 0L;
        continue;
        label619:
        i = 0;
        continue;
        label625:
        l3 = 0L;
        continue;
        label631:
        j = 0;
        continue;
        label637:
        k = 0;
        continue;
        label643:
        paramArrayOfByte = null;
        continue;
        label648:
        localObject1 = null;
        continue;
        label654:
        l4 = 0L;
      }
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
        break label43;
      }
    }
    label43:
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
  
  private static boolean a(avow paramavow1, avow paramavow2, XmlPullParser paramXmlPullParser)
  {
    paramavow1.a(paramavow2);
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    if (i < j)
    {
      paramavow2 = paramXmlPullParser.getAttributeName(i);
      String str = paramXmlPullParser.getAttributeValue(i);
      if (paramavow2.equals("txt")) {
        paramavow1.a(2, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramavow2.equals("jp"))
        {
          paramavow1.a(4, str);
        }
        else if (paramavow2.equals("uin"))
        {
          paramavow1.a(6, str);
        }
        else if (paramavow2.equals("nm"))
        {
          paramavow1.a(7, str);
        }
        else if (paramavow2.equals("si"))
        {
          paramavow1.a(3, str);
        }
        else if (paramavow2.equals("col"))
        {
          paramavow1.a(5, str);
        }
        else if (paramavow2.equals("jp"))
        {
          paramavow1.a(4, str);
        }
        else if (paramavow2.equals("src"))
        {
          paramavow1.a(8, str);
        }
        else
        {
          if (!paramavow2.equals("align")) {
            break label225;
          }
          paramavow1.a(1, str);
        }
      }
      label225:
      if (QLog.isColorLevel()) {
        QLog.i("handleC2COnlinePushMsgGrayTipResp", 2, "parseXML, illegel field: " + paramavow2);
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
        if (((paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_Boolean) || (adak.h(paramMessageForUniteGrayTip.msgtype))) && ((paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_Boolean) || (adak.i(paramMessageForUniteGrayTip.msgtype)))) {
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
          String str = " " + BaseApplicationImpl.getApplication().getString(2131693870);
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
            bdll.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 1, 0, "", "", "", "");
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
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    boolean bool3 = true;
    boolean bool2 = false;
    boolean bool1 = false;
    if (TextUtils.isEmpty(paramString))
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin friendUin :" + paramString + " busiId:" + paramLong2 + "isHideGrayfalse");
        bool2 = bool1;
      }
    }
    do
    {
      do
      {
        do
        {
          return bool2;
          paramQQAppInterface = (bggj)paramQQAppInterface.getManager(346);
          paramQQAppInterface.b(paramString);
          bool1 = bool2;
          if (bggn.a(paramLong1, paramLong2)) {
            if (!bdgb.b())
            {
              bool1 = bool2;
              if (paramQQAppInterface.b(paramString)) {}
            }
            else
            {
              bool1 = true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin:" + paramString + " busiId:" + paramLong2 + " isHideGray" + bool1);
          }
          bool2 = bool1;
        } while (bool1);
        bool2 = bool1;
      } while (paramLong2 != 1021L);
      paramQQAppInterface = (agml)aran.a().a(609);
      bool2 = bool1;
    } while (paramQQAppInterface == null);
    bool2 = paramQQAppInterface.a(paramString);
    if (!bool2) {
      bool1 = bool3;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "friendUin:" + paramString + " busiId:" + paramLong2 + " isHideGray" + bool1 + " bSwitchOpen:" + bool2);
      }
      return bool1;
    }
  }
  
  public static boolean a(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + "isHideGrayfalse");
      }
      return false;
    }
    if (paramLong2 == 1038L)
    {
      if (!bgnm.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + ",isHideGray:" + bool);
        }
        return bool;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface == null) {
        break label199;
      }
    }
    label199:
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface != null) && ((paramQQAppInterface.isHomeworkTroop()) || (paramQQAppInterface.isQidianPrivateTroop()))) {}
      for (bool = true;; bool = false)
      {
        break;
        bool = a(paramString, paramQQAppInterface, paramLong1, paramLong2);
        break;
      }
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
      continue;
      i = 1045;
      continue;
      i = 10008;
      continue;
      i = 10009;
      continue;
      i = 10010;
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
        break label47;
      }
    }
    label47:
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpe
 * JD-Core Version:    0.7.0.1
 */