import OnlinePushPack.MsgInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.SystemMsg;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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

public class avia
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
  
  public static avhr a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "parseXML " + paramString);
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
        break label1064;
      }
      localException1 = localException1;
      paramString = null;
      if (!QLog.isColorLevel()) {
        break label1081;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 2, "parseXML, exception: ", localException1);
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
                break label1137;
              }
              localObject5 = localObject1;
              paramString = new avhr(1);
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
              ((avhs)localObject3).a(1, localObject4);
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
            break label1137;
            localObject5 = localObject1;
            if (str.equals("dialog"))
            {
              if (localObject1 != null)
              {
                localObject3 = paramString;
                paramString = (String)localObject1;
                localObject1 = localObject3;
                break label1137;
              }
              localObject5 = localObject1;
              paramString = new avhr(6);
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
          localObject4 = new avhs(2);
          localObject3 = paramString;
          paramString = (String)localObject4;
        }
        else
        {
          localObject5 = localObject1;
          if (str.equals("url"))
          {
            localObject5 = localObject1;
            localObject4 = new avhs(3);
            localObject3 = paramString;
            paramString = (String)localObject4;
          }
          else
          {
            localObject5 = localObject1;
            if (str.equals("qq"))
            {
              localObject5 = localObject1;
              localObject4 = new avhs(4);
              localObject3 = paramString;
              paramString = (String)localObject4;
            }
            else
            {
              localObject5 = localObject1;
              if (str.equals("img"))
              {
                localObject5 = localObject1;
                localObject4 = new avhs(5);
                localObject3 = paramString;
                paramString = (String)localObject4;
              }
              else
              {
                localObject5 = localObject1;
                if (str.equals("title"))
                {
                  localObject5 = localObject1;
                  localObject4 = new avhs(7);
                  localObject3 = paramString;
                  paramString = (String)localObject4;
                }
                else
                {
                  localObject5 = localObject1;
                  if (str.equals("alert"))
                  {
                    localObject5 = localObject1;
                    localObject4 = new avhs(8);
                    localObject3 = paramString;
                    paramString = (String)localObject4;
                  }
                  else
                  {
                    localObject5 = localObject1;
                    if (str.equals("btn"))
                    {
                      localObject5 = localObject1;
                      localObject4 = new avhs(9);
                      localObject3 = paramString;
                      paramString = (String)localObject4;
                    }
                    else
                    {
                      localObject5 = localObject1;
                      if (str.equals("item"))
                      {
                        localObject5 = localObject1;
                        localObject4 = new avhs(10);
                        localObject3 = paramString;
                        paramString = (String)localObject4;
                      }
                      else
                      {
                        localObject5 = localObject1;
                        if (!QLog.isColorLevel()) {
                          break label1175;
                        }
                        localObject5 = localObject1;
                        QLog.i(jdField_a_of_type_JavaLangString, 2, "parseXML, illegel note: " + str);
                        break label1175;
                        localObject5 = localObject1;
                        bool = a(paramString, (avhs)localObject3, localXmlPullParser);
                        localObject4 = paramString;
                        localObject3 = paramString;
                        paramString = (String)localObject1;
                        localObject1 = localObject3;
                        break label1137;
                        localObject5 = localObject1;
                        localObject3 = localXmlPullParser.getText();
                        if (localObject4 != null)
                        {
                          localObject5 = localObject1;
                          if (((avhs)localObject4).a())
                          {
                            localObject5 = localObject1;
                            if (!TextUtils.isEmpty((CharSequence)localObject3))
                            {
                              localObject5 = localObject1;
                              ((avhs)localObject4).a(2, localObject3);
                              localObject3 = paramString;
                              paramString = (String)localObject1;
                              localObject1 = localObject3;
                              break label1137;
                              localObject5 = localObject1;
                              if (str.equals("gtip"))
                              {
                                localObject3 = paramString;
                                break label1186;
                              }
                              localObject5 = localObject1;
                              localObject3 = paramString;
                              if (str.equals("dialog")) {
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("nor"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avhs)localObject4).a();
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("url"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avhs)localObject4).a();
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("qq"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avhs)localObject4).a();
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("img"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avhs)localObject4).a();
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("title"))
                              {
                                localObject5 = localObject1;
                                localObject3 = ((avhs)localObject4).a();
                                break label1186;
                              }
                              localObject5 = localObject1;
                              if (str.equals("alert"))
                              {
                                if (localObject4 == null)
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString.a();
                                  break label1186;
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
                                    break label1186;
                                  }
                                }
                                else
                                {
                                  localObject5 = localObject1;
                                  localObject3 = paramString;
                                  if (!str.equals("item")) {
                                    break label1186;
                                  }
                                  localObject5 = localObject1;
                                  localObject3 = ((avhs)localObject4).a();
                                  break label1186;
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
    label1064:
    label1197:
    for (;;)
    {
      label1081:
      paramString = localException5;
      break label1141;
      localObject3 = localException5;
      Object localObject2 = paramString;
      paramString = (String)localObject3;
      for (;;)
      {
        label1137:
        if (bool) {
          break label1197;
        }
        label1141:
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
    avhz localavhz;
    Object localObject1;
    do
    {
      return null;
      localavhz = new avhz(paramString1, paramQQAppInterface.getCurrentAccountUin(), "", paramInt1, paramInt2, 655397, paramLong1);
      localObject1 = paramString2.a();
    } while (localObject1 == null);
    paramString2 = "";
    HashMap localHashMap = ((avhs)localObject1).a();
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
      a(paramQQAppInterface, localavhz, (avhs)localObject1, paramInt1, paramString1);
      localObject1 = new MessageForUniteGrayTip();
      ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, localavhz);
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
  
  private static void a(QQAppInterface paramQQAppInterface, avhz paramavhz, avhs paramavhs, int paramInt, String paramString)
  {
    if (paramavhz.jdField_a_of_type_JavaUtilArrayList != null) {
      paramavhz.jdField_a_of_type_JavaUtilArrayList.clear();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = paramavhs.jdField_a_of_type_JavaUtilArrayList.iterator();
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int j;
    int i;
    Object localObject5;
    for (;;)
    {
      if (localIterator1.hasNext())
      {
        paramavhs = (avhs)localIterator1.next();
        Object localObject4;
        switch (paramavhs.jdField_a_of_type_Int)
        {
        default: 
          break;
        case 2: 
          paramavhs = paramavhs.a();
          localObject1 = paramavhs.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (Integer)((Iterator)localObject1).next();
            localObject3 = paramavhs.get(localObject2);
            if (((Integer)localObject2).intValue() == 2) {
              localStringBuilder.append(localObject3);
            }
          }
        case 3: 
          paramavhs = paramavhs.a();
          localObject2 = paramavhs.keySet();
          j = localStringBuilder.length();
          i = localStringBuilder.length();
          localObject1 = new Bundle();
          localObject2 = ((Set)localObject2).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Integer)((Iterator)localObject2).next();
            if (((Integer)localObject3).intValue() == 2)
            {
              localObject3 = (String)paramavhs.get(localObject3);
              localStringBuilder.append((String)localObject3);
              i = j + ((String)localObject3).length();
            }
            for (;;)
            {
              break;
              if (((Integer)localObject3).intValue() == 5)
              {
                localObject3 = (String)paramavhs.get(localObject3);
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
                localObject3 = (String)paramavhs.get(localObject3);
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
          paramavhz.a(j, i, (Bundle)localObject1);
          break;
        case 4: 
          localObject5 = paramavhs.a();
          localObject3 = ((HashMap)localObject5).keySet();
          localStringBuilder.length();
          localStringBuilder.length();
          localObject1 = "";
          paramavhs = "";
          localObject2 = "";
          Bundle localBundle = new Bundle();
          Iterator localIterator2 = ((Set)localObject3).iterator();
          if (localIterator2.hasNext())
          {
            localObject3 = (Integer)localIterator2.next();
            if (((Integer)localObject3).intValue() == 6)
            {
              localObject1 = (String)((HashMap)localObject5).get(localObject3);
              localObject3 = localObject2;
              localObject2 = localObject1;
              localObject1 = paramavhs;
              paramavhs = (avhs)localObject3;
            }
            for (;;)
            {
              localObject3 = localObject2;
              localObject2 = paramavhs;
              paramavhs = (avhs)localObject1;
              localObject1 = localObject3;
              break;
              if (((Integer)localObject3).intValue() == 7)
              {
                localObject4 = (String)((HashMap)localObject5).get(localObject3);
                localObject3 = localObject1;
                paramavhs = (avhs)localObject2;
                localObject1 = localObject4;
                localObject2 = localObject3;
              }
              else if (((Integer)localObject3).intValue() == 9)
              {
                localObject4 = (String)((HashMap)localObject5).get(localObject3);
                localObject2 = paramavhs;
                localObject3 = localObject1;
                paramavhs = (avhs)localObject4;
                localObject1 = localObject2;
                localObject2 = localObject3;
              }
              else
              {
                if (((Integer)localObject3).intValue() == 5)
                {
                  localObject3 = (String)((HashMap)localObject5).get(localObject3);
                  if (((String)localObject3).equals("2")) {
                    localBundle.putString("textColor", "#FFFF596A");
                  }
                  for (;;)
                  {
                    localObject3 = paramavhs;
                    localObject4 = localObject1;
                    paramavhs = (avhs)localObject2;
                    localObject1 = localObject3;
                    localObject2 = localObject4;
                    break;
                    if (((String)localObject3).equals("3")) {
                      localBundle.putString("textColor", "#FF4D94FF");
                    }
                  }
                }
                if (((Integer)localObject3).intValue() == 4)
                {
                  localObject3 = (String)((HashMap)localObject5).get(localObject3);
                  if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
                  {
                    localBundle.putInt("key_action", 1);
                    localBundle.putString("key_action_DATA", (String)localObject3);
                    localObject3 = paramavhs;
                    localObject4 = localObject1;
                    paramavhs = (avhs)localObject2;
                    localObject1 = localObject3;
                    localObject2 = localObject4;
                    continue;
                  }
                  if (((String)localObject3).startsWith("mqq"))
                  {
                    localBundle.putInt("key_action", 3);
                    localBundle.putString("key_action_DATA", (String)localObject3);
                  }
                }
                localObject3 = paramavhs;
                localObject4 = localObject1;
                paramavhs = (avhs)localObject2;
                localObject1 = localObject3;
                localObject2 = localObject4;
              }
            }
          }
          if (((String)localObject1).equals(paramQQAppInterface.getCurrentAccountUin()))
          {
            paramavhs = anvx.a(2131715259);
            if (TextUtils.equals("1", (CharSequence)localObject2)) {
              paramavhs = BaseApplicationImpl.getContext().getString(2131692770);
            }
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent name : " + paramavhs);
            }
            localStringBuilder.append(paramavhs);
            paramavhs.length();
            break;
            if (acnh.d(paramInt)) {
              paramavhs = ContactUtils.getFriendDisplayName(paramQQAppInterface, (String)localObject1);
            } else if (acnh.a(paramInt)) {
              paramavhs = ContactUtils.getTroopMemberName(paramQQAppInterface, paramString, (String)localObject1);
            }
          }
        case 5: 
          localObject2 = paramavhs.a();
          localObject4 = ((HashMap)localObject2).keySet();
          j = localStringBuilder.length();
          i = localStringBuilder.length();
          localObject3 = new Bundle();
          paramavhs = "";
          localObject1 = "";
          localObject4 = ((Set)localObject4).iterator();
          label1054:
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (Integer)((Iterator)localObject4).next();
            if (((Integer)localObject5).intValue() == 8)
            {
              paramavhs = (String)((HashMap)localObject2).get(localObject5);
              i = "icon".length();
              ((Bundle)localObject3).putString("image_resource", paramavhs);
              paramavhs = "icon";
              i += j;
            }
          }
          break;
        }
      }
    }
    for (;;)
    {
      break label1054;
      if (((Integer)localObject5).intValue() == 4)
      {
        localObject5 = (String)((HashMap)localObject2).get(localObject5);
        if ((((String)localObject5).startsWith("http://")) || (((String)localObject5).startsWith("https://")))
        {
          ((Bundle)localObject3).putInt("key_action", 1);
          ((Bundle)localObject3).putString("key_action_DATA", (String)localObject5);
        }
        for (;;)
        {
          break;
          if (((String)localObject5).startsWith("mqq"))
          {
            ((Bundle)localObject3).putInt("key_action", 3);
            ((Bundle)localObject3).putString("key_action_DATA", (String)localObject5);
          }
        }
      }
      if (((Integer)localObject5).intValue() == 10)
      {
        localObject1 = (String)((HashMap)localObject2).get(localObject5);
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          i = ((String)localObject1).length();
          ((Bundle)localObject3).putString("image_alt", (String)localObject1);
          i += j;
          continue;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            localStringBuilder.append(paramavhs);
          }
          for (;;)
          {
            paramavhz.a(j, i, (Bundle)localObject3);
            break;
            localStringBuilder.append((String)localObject1);
          }
          paramavhz.jdField_c_of_type_JavaLangString = localStringBuilder.toString();
          QLog.d(jdField_a_of_type_JavaLangString, 2, "parseUniteGrayTipsContent content :" + localStringBuilder);
        }
        else {}
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "rebuildUniteTipsContent");
    }
    avhz localavhz = paramMessageForUniteGrayTip.tipParam;
    Object localObject = paramMessageForUniteGrayTip.getExtInfoFromExtStr("bytes_content");
    if ((localavhz != null) && (localavhz.jdField_b_of_type_Int == 655397) && (!TextUtils.isEmpty((CharSequence)localObject))) {}
    try
    {
      localObject = a((String)localObject);
      if (localObject != null) {
        a(paramQQAppInterface, localavhz, ((avhr)localObject).a(), paramMessageForUniteGrayTip.istroop, paramMessageForUniteGrayTip.frienduin);
      }
      paramMessageForUniteGrayTip.msg = localavhz.jdField_c_of_type_JavaLangString;
      paramMessageForUniteGrayTip.entity = ((avhr)localObject);
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
            paramQQAppInterface.a().refresh(131072);
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
  
  public static void a(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip, List<MessageRecord> paramList, int paramInt, String paramString, avhz paramavhz)
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
      if (((localMessageRecord.msgtype != -1000) && (localMessageRecord.msgtype != -1051)) || (!bhfj.a(localMessageRecord.issend)))
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
        localObject = BaseApplicationImpl.getApplication().getString(2131694160);
        paramString = paramString.concat(" ");
        j = paramString.length();
        k = ((String)localObject).length() + j;
        paramString = paramString.concat((String)localObject);
        paramavhz.jdField_c_of_type_JavaLangString = paramString;
        paramMessageForUniteGrayTip.msg = paramString;
        localObject = new Bundle();
        ((Bundle)localObject).putInt("key_action", 27);
        ((Bundle)localObject).putString("key_action_DATA", paramMessageForUniteGrayTip.editMsgData);
        if (!TextUtils.isEmpty(paramList)) {
          ((Bundle)localObject).putString("key_a_action_DATA", localJSONArray.toString());
        }
        paramavhz.a(j, k, (Bundle)localObject);
        if (QLog.isColorLevel())
        {
          if (paramMessageForUniteGrayTip.editMsgData != null)
          {
            paramInt = paramMessageForUniteGrayTip.editMsgData.length();
            i = paramInt;
            if (paramInt > 2) {
              i = 2;
            }
            paramavhz = jdField_a_of_type_JavaLangString;
            l1 = paramMessageForUniteGrayTip.editTime;
            l2 = paramMessageForUniteGrayTip.msgUid;
            l3 = paramMessageForUniteGrayTip.uniseq;
            if (i <= 0) {
              break label873;
            }
            paramList = paramMessageForUniteGrayTip.editMsgData.substring(0, i);
            QLog.d(paramavhz, 2, new Object[] { "revoke msg beding edit,time=", Long.valueOf(l1), ",wording=", paramString, ",msguid=", Long.valueOf(l2), ",uniseq=", Long.valueOf(l3), ",start =", Integer.valueOf(j), ",end=", Integer.valueOf(k), ",msgDta[0-2]=", paramList, ",msgGray.editMsgData.length=", Integer.valueOf(paramMessageForUniteGrayTip.editMsgData.length()), ",atString=", localJSONArray.toString() });
          }
        }
        else {
          bdla.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 0, 0, "", "", "", "");
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
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
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
    //   6: getstatic 16	avia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   9: iconst_2
    //   10: ldc_w 685
    //   13: iconst_4
    //   14: anewarray 4	java/lang/Object
    //   17: dup
    //   18: iconst_0
    //   19: aload_1
    //   20: aastore
    //   21: dup
    //   22: iconst_1
    //   23: iload_2
    //   24: invokestatic 476	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   27: aastore
    //   28: dup
    //   29: iconst_2
    //   30: lload_3
    //   31: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   34: aastore
    //   35: dup
    //   36: iconst_3
    //   37: lload 5
    //   39: invokestatic 259	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: aastore
    //   43: invokestatic 689	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   46: invokestatic 53	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: lload_3
    //   50: lload 5
    //   52: invokestatic 694	bfwx:a	(JJ)Z
    //   55: ifeq +123 -> 178
    //   58: aload 7
    //   60: ifnull +25 -> 85
    //   63: iload_2
    //   64: iconst_1
    //   65: if_icmpne +20 -> 85
    //   68: aload_0
    //   69: getstatic 697	com/tencent/mobileqq/app/QQManagerFactory:TROOP_HONOR_MANAGER	I
    //   72: invokevirtual 601	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   75: checkcast 699	bfwu
    //   78: aload_1
    //   79: aload 7
    //   81: iconst_1
    //   82: invokevirtual 702	bfwu:a	(Ljava/lang/String;[BI)V
    //   85: ldc2_w 703
    //   88: lload 5
    //   90: lcmp
    //   91: ifne +179 -> 270
    //   94: lconst_1
    //   95: lload_3
    //   96: lcmp
    //   97: ifne +173 -> 270
    //   100: aload 7
    //   102: ifnull +168 -> 270
    //   105: iload_2
    //   106: iconst_1
    //   107: if_icmpne +163 -> 270
    //   110: new 706	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData
    //   113: dup
    //   114: invokespecial 707	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:<init>	()V
    //   117: astore 8
    //   119: aload 8
    //   121: aload 7
    //   123: invokevirtual 711	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   126: pop
    //   127: aload 8
    //   129: getfield 714	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 635	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   135: ifeq +320 -> 455
    //   138: aload 8
    //   140: getfield 714	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:all_read	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   143: invokevirtual 637	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   146: i2l
    //   147: lstore_3
    //   148: ldc 181
    //   150: astore_0
    //   151: aload 8
    //   153: getfield 718	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 721	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   159: ifeq +12 -> 171
    //   162: aload 8
    //   164: getfield 718	tencent/im/oidb/cmd0x857/TroopTips0x857$GrayData:feed_id	Lcom/tencent/mobileqq/pb/PBStringField;
    //   167: invokevirtual 723	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   170: astore_0
    //   171: lconst_0
    //   172: lload_3
    //   173: lcmp
    //   174: ifne +49 -> 223
    //   177: return
    //   178: lload 5
    //   180: ldc2_w 724
    //   183: lcmp
    //   184: ifne -99 -> 85
    //   187: aload 7
    //   189: ifnull -104 -> 85
    //   192: iload_2
    //   193: iconst_1
    //   194: if_icmpne -109 -> 85
    //   197: aload_0
    //   198: getstatic 597	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   201: invokevirtual 601	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   204: checkcast 603	com/tencent/mobileqq/app/TroopManager
    //   207: astore_0
    //   208: aload_0
    //   209: ifnull -124 -> 85
    //   212: aload_0
    //   213: aload_1
    //   214: aload 7
    //   216: iconst_1
    //   217: invokevirtual 726	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;[BI)V
    //   220: goto -135 -> 85
    //   223: new 515	org/json/JSONObject
    //   226: dup
    //   227: invokespecial 516	org/json/JSONObject:<init>	()V
    //   230: astore 8
    //   232: aload 8
    //   234: ldc_w 728
    //   237: aload_0
    //   238: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   241: pop
    //   242: aload 8
    //   244: ldc_w 730
    //   247: aload_1
    //   248: invokevirtual 522	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   251: pop
    //   252: ldc_w 732
    //   255: ldc_w 734
    //   258: aload 8
    //   260: invokevirtual 735	org/json/JSONObject:toString	()Ljava/lang/String;
    //   263: ldc_w 737
    //   266: invokestatic 742	com/tencent/mobileqq/ark/ArkAppCenter:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   269: pop
    //   270: ldc2_w 743
    //   273: lload 5
    //   275: lcmp
    //   276: ifne -99 -> 177
    //   279: aload 7
    //   281: ifnull -104 -> 177
    //   284: new 746	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr
    //   287: dup
    //   288: invokespecial 747	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:<init>	()V
    //   291: astore_0
    //   292: aload_0
    //   293: aload 7
    //   295: invokevirtual 748	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   298: pop
    //   299: iconst_0
    //   300: istore_2
    //   301: aload_0
    //   302: getfield 751	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   305: invokevirtual 635	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   308: ifeq +11 -> 319
    //   311: aload_0
    //   312: getfield 751	tencent/im/oidb/cmd0xe3e/oidb_0xe3e$ResvAttr:uint32_gray_tips_from	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   315: invokevirtual 637	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   318: istore_2
    //   319: iconst_1
    //   320: iload_2
    //   321: if_icmpne +99 -> 420
    //   324: aconst_null
    //   325: ldc_w 580
    //   328: ldc 181
    //   330: ldc 181
    //   332: ldc_w 753
    //   335: ldc_w 753
    //   338: iconst_1
    //   339: iconst_0
    //   340: ldc_w 755
    //   343: ldc_w 755
    //   346: ldc 181
    //   348: ldc 181
    //   350: invokestatic 587	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   353: return
    //   354: astore_0
    //   355: aload_0
    //   356: invokevirtual 756	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   359: getstatic 16	avia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   362: iconst_1
    //   363: ldc_w 758
    //   366: aload_0
    //   367: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   370: return
    //   371: astore_0
    //   372: getstatic 16	avia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   375: iconst_1
    //   376: ldc_w 760
    //   379: aload_0
    //   380: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   383: goto -131 -> 252
    //   386: astore_0
    //   387: aload_0
    //   388: invokevirtual 756	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   391: getstatic 16	avia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   394: iconst_1
    //   395: ldc_w 758
    //   398: aload_0
    //   399: invokestatic 512	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   402: goto -132 -> 270
    //   405: astore_0
    //   406: getstatic 16	avia:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   409: iconst_1
    //   410: ldc_w 762
    //   413: aload_0
    //   414: invokestatic 162	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   417: goto -147 -> 270
    //   420: iconst_2
    //   421: iload_2
    //   422: if_icmpne -245 -> 177
    //   425: aconst_null
    //   426: ldc_w 580
    //   429: ldc 181
    //   431: ldc 181
    //   433: ldc_w 753
    //   436: ldc_w 753
    //   439: iconst_2
    //   440: iconst_0
    //   441: ldc_w 755
    //   444: ldc_w 755
    //   447: ldc 181
    //   449: ldc 181
    //   451: invokestatic 587	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   454: return
    //   455: lconst_0
    //   456: lstore_3
    //   457: goto -309 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	paramQQAppInterface	QQAppInterface
    //   0	460	1	paramString	String
    //   0	460	2	paramInt	int
    //   0	460	3	paramLong1	long
    //   0	460	5	paramLong2	long
    //   0	460	7	paramArrayOfByte	byte[]
    //   117	142	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   284	299	354	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	319	354	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   324	353	354	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   425	454	354	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   232	252	371	org/json/JSONException
    //   110	148	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   151	171	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   223	232	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   232	252	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   252	270	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   372	383	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   406	417	386	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   252	270	405	java/lang/UnsatisfiedLinkError
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "----------addTroopTipsMr troopUin: " + paramString);
    }
    if (paramLong < 0L) {
      NetConnInfoCenter.getServerTime();
    }
    paramQQAppInterface = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.joinSplitMsg", 2, "addFriendTipsMr troopUin=" + paramString);
    }
    paramQQAppInterface.a(paramString, paramBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, long paramLong1, long paramLong2, msg_comm.MsgHead paramMsgHead)
  {
    TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    String str = String.valueOf(SystemMsg.getTroopCodeFromTroopSysMsg(paramArrayOfByte));
    paramArrayOfByte = localTroopManager.b(str);
    Object localObject = (aoep)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new TroopInfo();
      paramArrayOfByte.troopuin = String.valueOf(str);
      paramArrayOfByte.troopcode = String.valueOf(paramLong1);
      localTroopManager.a(paramArrayOfByte);
      ((aoep)localObject).j(paramArrayOfByte.troopuin);
      ((aoep)localObject).a(1, anrb.a(paramArrayOfByte.troopuin), 0L, 2, 0, 0, true);
    }
    for (;;)
    {
      ((aoep)localObject).a(paramArrayOfByte.troopuin, Boolean.valueOf(false));
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
  
  private static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    submsgtype0x122.MsgBody localMsgBody = new submsgtype0x122.MsgBody();
    localMsgBody.mergeFrom(paramArrayOfByte);
    baiv.a().a(localMsgBody, paramMsgInfo, paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp message prepared");
    }
    if (paramBoolean) {}
    try
    {
      b(paramQQAppInterface, paramArrayOfByte, paramMsgInfo);
      return;
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    a(paramQQAppInterface, paramArrayOfByte, paramMsgInfo);
    return;
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
  
  private static boolean a(avhs paramavhs1, avhs paramavhs2, XmlPullParser paramXmlPullParser)
  {
    paramavhs1.a(paramavhs2);
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    if (i < j)
    {
      paramavhs2 = paramXmlPullParser.getAttributeName(i);
      String str = paramXmlPullParser.getAttributeValue(i);
      if (paramavhs2.equals("txt")) {
        paramavhs1.a(2, str);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramavhs2.equals("jp"))
        {
          paramavhs1.a(4, str);
        }
        else if (paramavhs2.equals("uin"))
        {
          paramavhs1.a(6, str);
        }
        else if (paramavhs2.equals("nm"))
        {
          paramavhs1.a(7, str);
        }
        else if (paramavhs2.equals("tp"))
        {
          paramavhs1.a(9, str);
        }
        else if (paramavhs2.equals("si"))
        {
          paramavhs1.a(3, str);
        }
        else if (paramavhs2.equals("col"))
        {
          paramavhs1.a(5, str);
        }
        else if (paramavhs2.equals("src"))
        {
          paramavhs1.a(8, str);
        }
        else if (paramavhs2.equals("align"))
        {
          paramavhs1.a(1, str);
        }
        else
        {
          if (!paramavhs2.equals("alt")) {
            break label247;
          }
          paramavhs1.a(10, str);
        }
      }
      label247:
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "parseXML, illegel field: " + paramavhs2);
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
        if (((paramMessageForUniteGrayTip.tipParam.jdField_a_of_type_Boolean) || (acnh.h(paramMessageForUniteGrayTip.msgtype))) && ((paramMessageForUniteGrayTip.tipParam.jdField_c_of_type_Boolean) || (acnh.i(paramMessageForUniteGrayTip.msgtype)))) {
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
      paramQQAppInterface.getMessageFacade().addMessage(paramMessageForUniteGrayTip, paramQQAppInterface.getCurrentAccountUin(), false, bool2, true, bool1);
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
          String str = " " + BaseApplicationImpl.getApplication().getString(2131694160);
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
            bdla.b(paramQQAppInterface, "dc00898", "", "", "0X8008E55", "0X8008E55", 1, 0, "", "", "", "");
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
          paramQQAppInterface = (bfwu)paramQQAppInterface.getManager(QQManagerFactory.TROOP_HONOR_MANAGER);
          paramQQAppInterface.b(paramString);
          bool1 = bool2;
          if (bfwx.a(paramLong1, paramLong2)) {
            if (!bdfk.b())
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
      paramQQAppInterface = (afwp)aqxe.a().a(609);
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
    boolean bool1 = true;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + "isHideGrayfalse");
      }
      return false;
    }
    if (paramLong2 == 1038L)
    {
      if (!bgek.a(paramString))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "shieldTroopInteractionIconGrayTip friendUin :" + paramString + " busiId:" + paramLong2 + ",isHideGray:" + bool1);
        }
        return bool1;
      }
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface == null) {
        break label219;
      }
    }
    label219:
    for (paramQQAppInterface = paramQQAppInterface.c(paramString);; paramQQAppInterface = null)
    {
      if ((paramQQAppInterface != null) && ((paramQQAppInterface.isHomeworkTroop()) || (paramQQAppInterface.isQidianPrivateTroop()))) {}
      for (bool1 = true;; bool1 = false)
      {
        break;
        boolean bool2 = a(paramString, paramQQAppInterface, paramLong1, paramLong2);
        bool1 = bool2;
        if (bool2) {
          break;
        }
        bool1 = b(paramString, paramQQAppInterface, paramLong1, paramLong2);
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
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, MsgInfo paramMsgInfo)
  {
    Object localObject = new submsgtype0x122.MsgBody();
    ((submsgtype0x122.MsgBody)localObject).mergeFrom(paramArrayOfByte);
    long l1;
    long l2;
    label58:
    label78:
    long l3;
    label99:
    int j;
    label120:
    int k;
    label141:
    label164:
    byte[] arrayOfByte;
    label188:
    long l4;
    if (((submsgtype0x122.MsgBody)localObject).uint64_busi_type.has())
    {
      l1 = ((submsgtype0x122.MsgBody)localObject).uint64_busi_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_busi_id.has()) {
        break label306;
      }
      l2 = ((submsgtype0x122.MsgBody)localObject).uint64_busi_id.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_ctrl_flag.has()) {
        break label312;
      }
      i = ((submsgtype0x122.MsgBody)localObject).uint32_ctrl_flag.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_templ_id.has()) {
        break label317;
      }
      l3 = ((submsgtype0x122.MsgBody)localObject).uint64_templ_id.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_c2c_type.has()) {
        break label323;
      }
      j = ((submsgtype0x122.MsgBody)localObject).uint32_c2c_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).uint32_service_type.has()) {
        break label329;
      }
      k = ((submsgtype0x122.MsgBody)localObject).uint32_service_type.get();
      if (!((submsgtype0x122.MsgBody)localObject).bytes_content.has()) {
        break label335;
      }
      paramArrayOfByte = ((submsgtype0x122.MsgBody)localObject).bytes_content.get().toByteArray();
      if (!((submsgtype0x122.MsgBody)localObject).bytes_pb_reserv.has()) {
        break label340;
      }
      arrayOfByte = ((submsgtype0x122.MsgBody)localObject).bytes_pb_reserv.get().toByteArray();
      if (!((submsgtype0x122.MsgBody)localObject).uint64_tips_seq_id.has()) {
        break label346;
      }
      l4 = ((submsgtype0x122.MsgBody)localObject).uint64_tips_seq_id.get();
      label209:
      localObject = "";
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {
        break label352;
      }
      paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
    }
    for (;;)
    {
      int m = 0;
      int n = a(i);
      i = m;
      if (j == 1)
      {
        j = b(k);
        i = j;
        if (j == -1) {
          i = 0;
        }
      }
      paramMsgInfo = a(paramQQAppInterface, String.valueOf(paramMsgInfo.lFromUin), i, n, paramMsgInfo.uMsgTime, paramArrayOfByte, l1, l2, arrayOfByte);
      if (paramMsgInfo != null) {
        break label377;
      }
      return;
      l1 = 0L;
      break;
      label306:
      l2 = 0L;
      break label58;
      label312:
      i = 0;
      break label78;
      label317:
      l3 = 0L;
      break label99;
      label323:
      j = 0;
      break label120;
      label329:
      k = 0;
      break label141;
      label335:
      paramArrayOfByte = null;
      break label164;
      label340:
      arrayOfByte = null;
      break label188;
      label346:
      l4 = 0L;
      break label209;
      label352:
      paramArrayOfByte = (byte[])localObject;
      if (QLog.isColorLevel())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp fail content is null");
        paramArrayOfByte = (byte[])localObject;
      }
    }
    label377:
    paramMsgInfo.tipParam.d = String.valueOf(l4);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "handleC2COnlinePushMsgGrayTipResp uint64_tips_seq_id" + l4);
    }
    paramMsgInfo.saveExtInfoToExtStr("uint64_busi_type", String.valueOf(l1));
    paramMsgInfo.saveExtInfoToExtStr("uint64_busi_id", String.valueOf(l2));
    paramMsgInfo.saveExtInfoToExtStr("uint64_templ_id", String.valueOf(l3));
    paramMsgInfo.saveExtInfoToExtStr("bytes_content", paramArrayOfByte);
    paramMsgInfo.saveExtInfoToExtStr("uint64_tips_seq_id", String.valueOf(l4));
    if (i == 0) {}
    for (int i = 1;; i = 2)
    {
      bdla.b(paramQQAppInterface, "CliOper", "", "", "0X800A560", "0X800A560", i, 0, "" + l2, "" + l1, "", "");
      paramMsgInfo.prewrite();
      a(paramQQAppInterface, paramMsgInfo);
      return;
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, MessageForUniteGrayTip paramMessageForUniteGrayTip)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade().getMsgList(paramMessageForUniteGrayTip.frienduin, paramMessageForUniteGrayTip.istroop);
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
  
  public static boolean b(String paramString, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    if (!bfyd.a.contains(Long.valueOf(paramLong2))) {
      return false;
    }
    paramString = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString);
    return !((bfyc)paramQQAppInterface.getManager(QQManagerFactory.TROOP_LUCKY_CHARACTER_MANAGER)).a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avia
 * JD-Core Version:    0.7.0.1
 */