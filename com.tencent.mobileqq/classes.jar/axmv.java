import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.intimate_relation.intimate_relation.IntimateBestFriend;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation_ext.intimate_relation_ext.IntimateRelationExtMsg;

public class axmv
{
  static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramQQAppInterface != null)
    {
      long l = System.currentTimeMillis();
      try
      {
        i = paramQQAppInterface.d();
        if (QLog.isColorLevel()) {
          QLog.i("FriendIntimateRelationshipHelper", 2, "getBindIntimateRelationshipFriendCount cost:" + (System.currentTimeMillis() - l) + "  count:" + i);
        }
        return i;
      }
      catch (Throwable paramQQAppInterface)
      {
        for (;;)
        {
          QLog.i("FriendIntimateRelationshipHelper", 2, "getBindIntimateRelationshipFriendCount e:" + paramQQAppInterface.getMessage());
          int i = 0;
        }
      }
    }
    return 0;
  }
  
  public static String a()
  {
    return arav.a().jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    arau localarau = arav.a();
    switch (paramInt1)
    {
    default: 
      str = localarau.c;
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      if (paramInt2 == 0)
      {
        str = localarau.d;
      }
      else if (paramInt2 == 1)
      {
        str = localarau.e;
      }
      else if (paramInt2 == 2)
      {
        str = localarau.f;
        continue;
        if (paramInt2 == 0)
        {
          str = localarau.g;
        }
        else if (paramInt2 == 1)
        {
          str = localarau.h;
        }
        else if (paramInt2 == 2)
        {
          str = localarau.i;
          continue;
          if (paramInt2 == 0)
          {
            str = localarau.j;
          }
          else if (paramInt2 == 1)
          {
            str = localarau.k;
          }
          else if (paramInt2 == 2)
          {
            str = localarau.l;
            continue;
            if (paramInt2 == 0) {
              str = localarau.m;
            } else if (paramInt2 == 1) {
              str = localarau.n;
            } else if (paramInt2 == 2) {
              str = localarau.o;
            }
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(arav.a().jdField_b_of_type_JavaLangString).buildUpon();
    localBuilder.appendQueryParameter("uin", paramString);
    paramString = localBuilder.toString();
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 2, "bindPageURL url:" + paramString);
    }
    return paramString;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = axlp.a(paramQQAppInterface, paramString1, paramInt, 0L);
    String str1 = axlp.a(paramQQAppInterface, paramString1, paramInt, 1L);
    String str2 = axlp.a(paramQQAppInterface, paramString1, paramInt, 2L);
    paramQQAppInterface = paramString2;
    if (paramString2.contains("#intimateshipicon1"))
    {
      paramQQAppInterface = paramString2.replace("#intimateshipicon1", str3);
      localArrayList.add(str3);
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipicon2"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipicon2", str1);
      localArrayList.add(str1);
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipicon3"))
    {
      paramQQAppInterface = paramString1.replace("#intimateshipicon3", str2);
      localArrayList.add(str2);
    }
    localArrayList.add(0, paramQQAppInterface);
    return localArrayList;
  }
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, anvk paramanvk, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = axlp.a(paramQQAppInterface, paramInt, 0L);
    String str2 = axlp.a(paramQQAppInterface, paramInt, 1L);
    String str1 = axlp.a(paramQQAppInterface, paramInt, 2L);
    paramInt = paramanvk.n;
    int i = paramanvk.o;
    int j = paramanvk.p;
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipday1")) {
      paramQQAppInterface = paramString1.replace("#intimateshipday1", String.valueOf(paramInt));
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipday2")) {
      paramString1 = paramQQAppInterface.replace("#intimateshipday2", String.valueOf(i));
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipmsgcount")) {
      paramQQAppInterface = paramString1.replace("#intimateshipmsgcount", String.valueOf(j));
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipname1"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipname1", str3);
      localArrayList.add(str3);
    }
    paramQQAppInterface = paramString1;
    if (paramString1.contains("#intimateshipname2"))
    {
      paramQQAppInterface = paramString1.replace("#intimateshipname2", str2);
      localArrayList.add(str2);
    }
    paramString1 = paramQQAppInterface;
    if (paramQQAppInterface.contains("#intimateshipname3"))
    {
      paramString1 = paramQQAppInterface.replace("#intimateshipname3", str1);
      localArrayList.add(str1);
    }
    localArrayList.add(0, paramString1.replace(anvx.a(2131704348), paramString2));
    return localArrayList;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, anvk paramanvk, String paramString1, String paramString2, int paramInt1, int paramInt2, aooq paramaooq, int paramInt3, int paramInt4)
  {
    QLog.i("FriendIntimateRelationshipHelper", 1, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " intimateType:" + paramInt1);
    if ((TextUtils.isEmpty(paramString2)) || (axma.a(paramQQAppInterface))) {
      return;
    }
    Object localObject2 = ContactUtils.getFriendShowName(paramQQAppInterface, paramString1);
    Object localObject1 = paramString2;
    if (paramInt3 == 2097154)
    {
      localObject1 = paramString2;
      if (paramInt4 == 0)
      {
        localObject3 = arki.c();
        localObject1 = paramString2;
        if (((arkh)localObject3).jdField_a_of_type_Boolean) {
          localObject1 = paramString2 + ((arkh)localObject3).jdField_a_of_type_JavaLangString;
        }
      }
    }
    localObject2 = a(paramQQAppInterface, (String)localObject1, (String)localObject2, paramanvk, paramInt1);
    Object localObject3 = a(paramQQAppInterface, paramString1, (String)((List)localObject2).get(0), paramInt1);
    paramanvk = (String)((List)localObject3).get(0);
    ((List)localObject3).remove(0);
    ((List)localObject2).remove(0);
    paramString2 = new avhz(paramString1, paramString1, paramanvk, 0, -5040, paramInt3, bcrg.a());
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).hasRead = 0;
    ((MessageForUniteGrayTip)localObject1).subType = paramInt4;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramString2);
    ((MessageForUniteGrayTip)localObject1).tipParam.d = (paramString1 + "_intimate_" + String.valueOf(paramaooq.jdField_b_of_type_Long) + "_" + String.valueOf(paramaooq.jdField_b_of_type_Int));
    int i;
    Object localObject4;
    int j;
    if (((List)localObject3).size() > 0)
    {
      i = 0;
      while (i < ((List)localObject3).size())
      {
        paramaooq = new Bundle();
        localObject4 = (String)((List)localObject3).get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramaooq.putString("image_resource", (String)localObject4);
          j = 0;
          do
          {
            k = paramanvk.indexOf((String)localObject4, j);
            j = ((String)localObject4).length() + k;
            if (k >= 0)
            {
              paramString2.a(k, j, paramaooq);
              if (QLog.isColorLevel()) {
                QLog.d("FriendIntimateRelationshipHelper", 2, "iconPos=" + k + " fromIndex=" + j);
              }
            }
          } while (k >= 0);
        }
        i += 1;
      }
    }
    int m;
    String str1;
    label561:
    int i2;
    int i3;
    int i1;
    Object localObject5;
    Object localObject6;
    if (((List)localObject2).size() > 0)
    {
      Collections.sort((List)localObject2, new axmx());
      paramaooq = new ArrayList();
      i = 0;
      m = 0;
      if (m < ((List)localObject2).size())
      {
        localObject4 = new Bundle();
        str1 = (String)((List)localObject2).get(m);
        j = i;
        if (!TextUtils.isEmpty(str1))
        {
          ((Bundle)localObject4).putInt("key_action", 11);
          ((Bundle)localObject4).putString("key_action_DATA", str1);
          j = 0;
          i2 = paramanvk.indexOf(str1, j);
          i3 = str1.length();
          i1 = i2 + i3;
          localObject5 = paramaooq.iterator();
          do
          {
            if (!((Iterator)localObject5).hasNext()) {
              break;
            }
            localObject6 = (Pair)((Iterator)localObject5).next();
          } while ((i2 < ((Integer)((Pair)localObject6).first).intValue()) || (i2 >= ((Integer)((Pair)localObject6).second).intValue()));
        }
      }
    }
    for (int k = 1;; k = 0)
    {
      j = paramanvk.length();
      int n = k;
      label732:
      String str2;
      if (k == 0)
      {
        n = k;
        if (((List)localObject3).size() > 0)
        {
          n = k;
          if (i2 >= 0)
          {
            n = k;
            if (i2 < j)
            {
              n = k;
              if (i1 >= 0)
              {
                n = k;
                if (i1 < j) {
                  if (paramanvk.indexOf(str1, i1) >= 0)
                  {
                    j = 1;
                    if ((((List)localObject2).size() <= 1) && (j == 0))
                    {
                      n = k;
                      if (i <= 0) {
                        break label858;
                      }
                    }
                    localObject5 = paramanvk.substring(0, i2);
                    localObject6 = paramanvk.substring(i1);
                    Iterator localIterator = ((List)localObject3).iterator();
                    j = 0;
                    label786:
                    if (!localIterator.hasNext()) {
                      break label846;
                    }
                    str2 = (String)localIterator.next();
                    if (!((String)localObject6).startsWith(str2)) {
                      break label830;
                    }
                    j = 1;
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        break label786;
        j = 0;
        break label732;
        label830:
        if (((String)localObject5).endsWith(str2))
        {
          j = 1;
          continue;
          label846:
          n = k;
          if (j == 0) {
            n = 1;
          }
          label858:
          if (n != 0) {}
          for (;;)
          {
            if (i2 < 0)
            {
              j = i;
              m += 1;
              i = j;
              break;
              paramaooq.add(new Pair(Integer.valueOf(i2), Integer.valueOf(i2 + i3)));
              j = i;
              if (i2 >= 0)
              {
                i += 1;
                paramString2.a(i2, i1, (Bundle)localObject4);
                j = i;
                if (QLog.isColorLevel())
                {
                  QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + i2 + " fromIndex=" + i1);
                  j = i;
                }
              }
              i = j;
              continue;
              if ((paramInt3 == 2097154) && (paramInt4 == 0))
              {
                paramaooq = arki.c();
                if (paramaooq.jdField_a_of_type_Boolean)
                {
                  localObject2 = new Bundle();
                  ((Bundle)localObject2).putInt("key_action", 1);
                  paramInt3 = 10;
                  switch (paramInt1)
                  {
                  default: 
                    paramInt1 = paramInt3;
                  }
                }
              }
              for (;;)
              {
                ((Bundle)localObject2).putString("key_action_DATA", String.format(paramaooq.jdField_b_of_type_JavaLangString, new Object[] { paramString1, Integer.valueOf(paramInt1) }));
                paramInt2 = paramanvk.length() - paramaooq.jdField_a_of_type_JavaLangString.length();
                if (paramInt2 >= 0)
                {
                  paramString2.a(paramInt2, paramanvk.length(), (Bundle)localObject2);
                  bdla.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt1, 0, "", "", "", "");
                }
                avia.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
                return;
                if (paramInt2 == 0)
                {
                  paramInt1 = 25;
                }
                else
                {
                  paramInt1 = 26;
                  continue;
                  if (paramInt2 == 0)
                  {
                    paramInt1 = 23;
                  }
                  else
                  {
                    paramInt1 = 24;
                    continue;
                    if (paramInt2 == 0)
                    {
                      paramInt1 = 27;
                    }
                    else
                    {
                      paramInt1 = 28;
                      continue;
                      if (paramInt2 == 0) {
                        paramInt1 = 21;
                      } else {
                        paramInt1 = 22;
                      }
                    }
                  }
                }
              }
            }
          }
          j = i1;
          break label561;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    paramQQAppInterface = new intimate_relation_ext.IntimateRelationExtMsg();
    try
    {
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if (paramQQAppInterface != null)
      {
        boolean bool1 = bool2;
        if (paramQQAppInterface.uint64_icon_status.has())
        {
          bool1 = bool2;
          if (paramQQAppInterface.uint64_icon_status.get() == 1L) {
            bool1 = true;
          }
        }
        if (paramExtensionInfo.isExtinguish != bool1) {
          paramExtensionInfo.isExtinguish = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.i("FriendIntimateRelationshipHelper", 1, "handleGetIntimateRelationExtMsgInfo ext_info.uint64_icon_status.has():" + paramQQAppInterface.uint64_icon_status.has() + " newIsExtinguish:" + bool1);
        }
      }
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramQQAppInterface = null;
        paramArrayOfByte.printStackTrace();
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, aooq paramaooq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramaooq);
    }
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramaooq == null)) {}
    long l1;
    long l2;
    afsf localafsf;
    anvk localanvk;
    do
    {
      do
      {
        return;
        l1 = paramaooq.jdField_b_of_type_Long;
        l2 = paramaooq.c;
        localafsf = afsf.a(paramRelationalChainChange, paramaooq.jdField_a_of_type_Boolean);
      } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localafsf.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localafsf.jdField_b_of_type_JavaLangString)));
      localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramRelationalChainChange = localanvk.e(localafsf.jdField_b_of_type_JavaLangString);
      QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramaooq + "changePushInfo:" + localafsf);
    } while ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isFriend()));
    ExtensionInfo localExtensionInfo = localanvk.a(localafsf.jdField_b_of_type_JavaLangString);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = localafsf.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject3 = (auzb)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER);
      Object localObject1 = null;
      Object localObject2 = null;
      Bundle localBundle = null;
      String str2 = null;
      String str1 = null;
      label323:
      int i;
      switch (localafsf.jdField_a_of_type_Int)
      {
      default: 
        paramRelationalChainChange = str1;
      case 1: 
        do
        {
          QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 changeType:" + localafsf.jdField_a_of_type_Int + " grayTips:" + paramRelationalChainChange + " uin:" + localExtensionInfo.uin + " isOpen:" + a(localafsf.jdField_a_of_type_JavaLangString) + " intimate_type:" + localExtensionInfo.intimate_type + " intimate_level:" + localExtensionInfo.intimate_level + " intimate_chatDays:" + localExtensionInfo.intimate_chatDays + " isExtinguish:" + localExtensionInfo.isExtinguish + " last_intimate_chatTime:" + localExtensionInfo.last_intimate_chatTime);
          return;
          paramRelationalChainChange = str1;
        } while (localafsf.jdField_b_of_type_Afsi == null);
        if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 1) || (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 2) || (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 26) || (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 3))
        {
          localExtensionInfo.intimate_type = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int;
          localExtensionInfo.intimate_chatDays = 0;
          localExtensionInfo.intimate_level = localafsf.jdField_b_of_type_Afsi.a();
          localExtensionInfo.isExtinguish = false;
          if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c > 0L)) {
            localExtensionInfo.last_intimate_chatTime = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c;
          }
          str1 = axmy.a(paramQQAppInterface.getApp(), 162);
          localanvk.a(localExtensionInfo);
          if (a(localafsf.jdField_a_of_type_JavaLangString))
          {
            i = axlu.a(localafsf);
            a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, str1, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int, localafsf.jdField_b_of_type_Afsi.a(), paramaooq, 2097153, i);
            ((auzb)localObject3).notifyUI(2, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString });
          }
          paramRelationalChainChange = str1;
          if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface = (anxz)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
            paramRelationalChainChange = str1;
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(1);
            }
          }
        }
        break;
      }
      for (paramRelationalChainChange = str1;; paramRelationalChainChange = null)
      {
        QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:" + localafsf.jdField_b_of_type_JavaLangString + " changePushInfo.now:" + localafsf.jdField_b_of_type_Afsi);
        break label323;
        int k = 0;
        int j = 0;
        if (localafsf.jdField_a_of_type_Afsi != null)
        {
          k = localafsf.jdField_a_of_type_Afsi.jdField_a_of_type_Int;
          j = localafsf.jdField_a_of_type_Afsi.a();
        }
        int m = j;
        i = k;
        if (k == 0)
        {
          m = j;
          i = k;
          if (localafsf.jdField_b_of_type_Afsi != null)
          {
            i = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int;
            m = localafsf.jdField_b_of_type_Afsi.a();
          }
        }
        if (i == 0)
        {
          j = localExtensionInfo.intimate_type;
          k = localExtensionInfo.intimate_level;
        }
        for (;;)
        {
          if ((j == 1) || (j == 2) || (j == 26) || (j == 3))
          {
            localExtensionInfo.intimate_type = 0;
            localExtensionInfo.intimate_level = 0;
            localExtensionInfo.intimate_chatDays = 0;
            localExtensionInfo.isExtinguish = false;
            i = 163;
            if (k == 1)
            {
              i = 164;
              label943:
              str1 = axmy.a(paramQQAppInterface.getApp(), i);
              localanvk.a(localExtensionInfo);
              if (a(localafsf.jdField_a_of_type_JavaLangString))
              {
                a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, str1, j, 0, paramaooq, 2097154, 1);
                ((auzb)localObject3).notifyUI(1, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
                ((auzd)paramQQAppInterface.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(localafsf.jdField_b_of_type_JavaLangString);
              }
              paramRelationalChainChange = str1;
              if (j == 1)
              {
                paramQQAppInterface = (anxz)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LOVE_STATE_CHANGE_HANDLER);
                paramRelationalChainChange = str1;
                if (paramQQAppInterface != null) {
                  paramQQAppInterface.a(0);
                }
              }
            }
          }
          for (paramRelationalChainChange = str1;; paramRelationalChainChange = null)
          {
            QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:" + j + " intimate_level:" + k + " friendUin:" + localafsf.jdField_b_of_type_JavaLangString);
            break label323;
            if (k != 2) {
              break label943;
            }
            i = 165;
            break label943;
            paramRelationalChainChange = str1;
            if (!a()) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (!a(localafsf.jdField_a_of_type_JavaLangString)) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (localafsf.jdField_b_of_type_Afsi == null) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (localafsf.jdField_a_of_type_Afsi == null) {
              break label323;
            }
            if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c > 0L)) {
              localExtensionInfo.last_intimate_chatTime = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c;
            }
            k = localafsf.jdField_b_of_type_Afsi.a();
            m = localafsf.jdField_a_of_type_Afsi.a();
            if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 2) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 26))
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 3) {}
            }
            else
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (k > m)
              {
                j = -1;
                if (k != 1) {
                  break label1570;
                }
                if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) {
                  break label1509;
                }
                i = 150;
              }
            }
            label1570:
            for (;;)
            {
              paramRelationalChainChange = axmy.a(paramQQAppInterface.getApp(), i);
              localExtensionInfo.intimate_type = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int;
              localExtensionInfo.intimate_level = k;
              localanvk.a(localExtensionInfo);
              i = axlu.a(localafsf);
              a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int, k, paramaooq, 2097153, i);
              ((auzb)localObject3).notifyUI(3, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString, Integer.valueOf(localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
              QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:" + localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
              break;
              label1509:
              if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 2)
              {
                i = 158;
              }
              else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 26)
              {
                i = 168;
              }
              else
              {
                i = j;
                if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 3)
                {
                  i = 154;
                  continue;
                  i = j;
                  if (k == 2) {
                    if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 1)
                    {
                      i = 151;
                    }
                    else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 2)
                    {
                      i = 159;
                    }
                    else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 26)
                    {
                      i = 169;
                    }
                    else
                    {
                      i = j;
                      if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 3) {
                        i = 155;
                      }
                    }
                  }
                }
              }
            }
            paramRelationalChainChange = str1;
            if (!a()) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (!a(localafsf.jdField_a_of_type_JavaLangString)) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (localafsf.jdField_b_of_type_Afsi == null) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (localafsf.jdField_a_of_type_Afsi == null) {
              break label323;
            }
            if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c > 0L)) {
              localExtensionInfo.last_intimate_chatTime = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c;
            }
            k = localafsf.jdField_b_of_type_Afsi.a();
            m = localafsf.jdField_a_of_type_Afsi.a();
            if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 2) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 26))
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject2;
              if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 3) {}
            }
            else
            {
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject2;
              if (k < m)
              {
                j = -1;
                if (m != 1) {
                  break label2084;
                }
                if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) {
                  break label2023;
                }
                i = 152;
              }
            }
            label2084:
            for (;;)
            {
              paramRelationalChainChange = axmy.a(paramQQAppInterface.getApp(), i);
              localExtensionInfo.intimate_type = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int;
              localExtensionInfo.intimate_level = k;
              localanvk.a(localExtensionInfo);
              a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int, k, paramaooq, 2097154, 0);
              ((auzb)localObject3).notifyUI(3, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString, Integer.valueOf(localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
              QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:" + localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
              break;
              label2023:
              if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 2)
              {
                i = 160;
              }
              else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 26)
              {
                i = 170;
              }
              else
              {
                i = j;
                if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 3)
                {
                  i = 156;
                  continue;
                  i = j;
                  if (m == 2) {
                    if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 1)
                    {
                      i = 153;
                    }
                    else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 2)
                    {
                      i = 161;
                    }
                    else if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 26)
                    {
                      i = 171;
                    }
                    else
                    {
                      i = j;
                      if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int == 3) {
                        i = 157;
                      }
                    }
                  }
                }
              }
            }
            paramRelationalChainChange = str1;
            if (!a()) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (!a(localafsf.jdField_a_of_type_JavaLangString)) {
              break label323;
            }
            paramRelationalChainChange = str1;
            if (localafsf.jdField_b_of_type_Afsi == null) {
              break label323;
            }
            if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 0) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk != null)) {
              if ((!TextUtils.isEmpty(localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_a_of_type_JavaLangString)) && (!axma.a(paramQQAppInterface)))
              {
                localObject1 = axmy.a(paramQQAppInterface, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.jdField_a_of_type_JavaLangString, ContactUtils.getFriendShowName(paramQQAppInterface, localafsf.jdField_b_of_type_JavaLangString), localanvk);
                localObject2 = axmy.a(paramQQAppInterface, (String)((List)localObject1).get(0), localafsf.jdField_b_of_type_JavaLangString);
                paramRelationalChainChange = (String)((List)localObject2).get(0);
                ((List)localObject1).remove(0);
                ((List)localObject2).remove(0);
                paramaooq = new avhz(localafsf.jdField_b_of_type_JavaLangString, localafsf.jdField_b_of_type_JavaLangString, paramRelationalChainChange, 0, -5020, 2097153, bcrg.a());
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  i = 0;
                  while (i < ((List)localObject2).size())
                  {
                    localBundle = new Bundle();
                    str2 = (String)((List)localObject2).get(i);
                    if (!TextUtils.isEmpty(str2))
                    {
                      localBundle.putString("image_resource", str2);
                      j = paramRelationalChainChange.lastIndexOf(str2);
                      if (j >= 0) {
                        paramaooq.a(j, str2.length() + j, localBundle);
                      }
                      if (QLog.isColorLevel()) {
                        QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramRelationalChainChange + "iconPos=" + j + "icon=" + str2 + "grayStr=" + paramRelationalChainChange);
                      }
                    }
                    i += 1;
                  }
                }
                if ((localObject1 != null) && (((List)localObject1).size() > 0))
                {
                  Collections.sort((List)localObject1, new axmw());
                  localObject2 = new ArrayList();
                  j = 0;
                  label2570:
                  if (j < ((List)localObject1).size())
                  {
                    localBundle = new Bundle();
                    str2 = (String)((List)localObject1).get(j);
                    if (!TextUtils.isEmpty(str2))
                    {
                      localBundle.putInt("key_action", 11);
                      localBundle.putString("key_action_DATA", str2);
                      i = 0;
                      label2635:
                      m = paramRelationalChainChange.indexOf(str2, i);
                      if (m >= 0) {
                        break label2663;
                      }
                    }
                  }
                }
              }
            }
            label3749:
            for (;;)
            {
              label2649:
              label2663:
              int n;
              if (m < 0)
              {
                j += 1;
                break label2570;
                n = str2.length();
                i = m + n;
                localObject3 = ((ArrayList)localObject2).iterator();
                Pair localPair;
                do
                {
                  if (!((Iterator)localObject3).hasNext()) {
                    break;
                  }
                  localPair = (Pair)((Iterator)localObject3).next();
                } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
              }
              for (k = 1;; k = 0)
              {
                if (k != 0) {
                  break label3749;
                }
                ((ArrayList)localObject2).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
                if (m >= 0)
                {
                  paramaooq.a(m, i, localBundle);
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + m + " fromIndex=" + i);
                  }
                }
                break label2649;
                break label2635;
                localObject1 = new MessageForUniteGrayTip();
                ((MessageForUniteGrayTip)localObject1).hasRead = 0;
                ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramaooq);
                paramaooq = new StringBuilder(21);
                paramaooq.append(l1).append("_").append(l2);
                ((MessageForUniteGrayTip)localObject1).tipParam.d = paramaooq.toString();
                paramaooq = paramQQAppInterface.getMessageFacade().getMsgList(localafsf.jdField_b_of_type_JavaLangString, 0);
                if ((paramaooq != null) && (!paramaooq.isEmpty()))
                {
                  paramaooq = (MessageRecord)paramaooq.get(paramaooq.size() - 1);
                  if (((paramaooq instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramaooq).tipParam != null) && (((MessageForUniteGrayTip)paramaooq).subType == ((MessageForUniteGrayTip)localObject1).subType) && (((MessageForUniteGrayTip)paramaooq).tipParam.c.equals(((MessageForUniteGrayTip)localObject1).tipParam.c)) && (((MessageForUniteGrayTip)localObject1).tipParam.jdField_a_of_type_Long - ((MessageForUniteGrayTip)paramaooq).tipParam.jdField_a_of_type_Long <= 1L))
                  {
                    if (!QLog.isColorLevel()) {
                      break;
                    }
                    QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                    return;
                  }
                }
                if (!TextUtils.isEmpty(paramRelationalChainChange)) {
                  avia.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
                }
                localExtensionInfo.intimate_level = localafsf.jdField_b_of_type_Afsi.a();
                if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c > 0L) {
                  localExtensionInfo.last_intimate_chatTime = localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Afsk.c;
                }
                localanvk.a(localExtensionInfo);
                paramRelationalChainChange = new ArrayList();
                paramRelationalChainChange.add(localafsf.jdField_b_of_type_JavaLangString);
                paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(107, true, paramRelationalChainChange);
                QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:" + localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int + " intimate_level:" + localafsf.jdField_b_of_type_Afsi.a());
                paramRelationalChainChange = str1;
                break label323;
                paramRelationalChainChange = str1;
                if (!a()) {
                  break label323;
                }
                paramRelationalChainChange = str1;
                if (!a(localafsf.jdField_a_of_type_JavaLangString)) {
                  break label323;
                }
                paramRelationalChainChange = str1;
                if (localafsf.jdField_b_of_type_Afsi == null) {
                  break label323;
                }
                if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 2) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 26))
                {
                  paramRelationalChainChange = localBundle;
                  if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 3) {}
                }
                else
                {
                  localExtensionInfo.isExtinguish = false;
                  localanvk.a(localExtensionInfo);
                  paramRelationalChainChange = axmy.a(paramQQAppInterface.getApp(), 167);
                  a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int, localafsf.jdField_b_of_type_Afsi.a(), paramaooq, 2097153, 0);
                  ((auzb)localObject3).notifyUI(3, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString, Integer.valueOf(localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int), Integer.valueOf(localafsf.jdField_b_of_type_Afsi.a()), Integer.valueOf(localafsf.jdField_b_of_type_Afsi.a()) });
                  ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localafsf.jdField_b_of_type_JavaLangString);
                }
                QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:" + localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int + " intimate_level:" + localafsf.jdField_b_of_type_Afsi.a());
                break label323;
                paramRelationalChainChange = str1;
                if (!a()) {
                  break label323;
                }
                paramRelationalChainChange = str1;
                if (!a(localafsf.jdField_a_of_type_JavaLangString)) {
                  break label323;
                }
                paramRelationalChainChange = str1;
                if (localafsf.jdField_b_of_type_Afsi == null) {
                  break label323;
                }
                if ((localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 1) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 2) && (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 26))
                {
                  paramRelationalChainChange = str2;
                  if (localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int != 3) {}
                }
                else
                {
                  localExtensionInfo.isExtinguish = true;
                  localanvk.a(localExtensionInfo);
                  paramRelationalChainChange = axmy.a(paramQQAppInterface.getApp(), 166);
                  a(paramQQAppInterface, localanvk, localafsf.jdField_b_of_type_JavaLangString, paramRelationalChainChange, localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int, localafsf.jdField_b_of_type_Afsi.a(), paramaooq, 2097154, 0);
                  ((auzb)localObject3).notifyUI(3, true, new Object[] { localafsf.jdField_b_of_type_JavaLangString, Integer.valueOf(localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int), Integer.valueOf(localafsf.jdField_b_of_type_Afsi.a()), Integer.valueOf(localafsf.jdField_b_of_type_Afsi.a()) });
                  ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).notifyUI(3, true, localafsf.jdField_b_of_type_JavaLangString);
                }
                QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:" + localafsf.jdField_b_of_type_Afsi.jdField_a_of_type_Int + " intimate_level:" + localafsf.jdField_b_of_type_Afsi.a());
                break label323;
              }
            }
          }
          k = m;
          j = i;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, intimate_relation.IntimateInfo paramIntimateInfo)
  {
    boolean bool = false;
    if (paramIntimateInfo == null) {}
    long l;
    do
    {
      return;
      l = paramIntimateInfo.frd_uin.get();
    } while (l <= 0L);
    anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    ExtensionInfo localExtensionInfo2 = localanvk.a(Long.toString(l));
    ExtensionInfo localExtensionInfo1;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = Long.toString(l);
      label67:
      if ((!paramIntimateInfo.is_del.has()) || (!paramIntimateInfo.is_del.get())) {
        break label354;
      }
      localExtensionInfo1.intimate_type = 0;
      localExtensionInfo1.intimate_level = 0;
      localExtensionInfo1.intimate_chatDays = 0;
      localExtensionInfo1.isExtinguish = false;
      bool = true;
    }
    for (;;)
    {
      if (bool) {
        localanvk.a(localExtensionInfo1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo end changed:" + bool + "  uin:" + l + " isOpen:" + a(paramQQAppInterface.getCurrentUin()) + " intimate_type:" + localExtensionInfo1.intimate_type + " intimate_level:" + localExtensionInfo1.intimate_level + " isExtinguish:" + localExtensionInfo1.isExtinguish + " intimate_chatDays:" + localExtensionInfo1.intimate_chatDays);
      return;
      localExtensionInfo1 = localExtensionInfo2;
      if (!QLog.isColorLevel()) {
        break label67;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo before uin:" + l + " isOpen:" + a(paramQQAppInterface.getCurrentUin()) + " intimate_type:" + localExtensionInfo2.intimate_type + " intimate_level:" + localExtensionInfo2.intimate_level + " isExtinguish:" + localExtensionInfo2.isExtinguish + " intimate_chatDays:" + localExtensionInfo2.intimate_chatDays);
      localExtensionInfo1 = localExtensionInfo2;
      break label67;
      label354:
      if (paramIntimateInfo.lover.has())
      {
        localExtensionInfo1.intimate_type = 1;
        localExtensionInfo1.intimate_level = paramIntimateInfo.lover.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.lover.chat_days.get();
        if ((paramIntimateInfo.lover.buffer.has()) && (paramIntimateInfo.lover.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.lover.buffer.get().toByteArray());
          bool = true;
        }
      }
      else if (paramIntimateInfo.ladybro.has())
      {
        localExtensionInfo1.intimate_type = 2;
        localExtensionInfo1.intimate_level = paramIntimateInfo.ladybro.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.ladybro.chat_days.get();
        if ((paramIntimateInfo.ladybro.buffer.has()) && (paramIntimateInfo.ladybro.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.ladybro.buffer.get().toByteArray());
          bool = true;
        }
      }
      else if (paramIntimateInfo.bestfriend.has())
      {
        localExtensionInfo1.intimate_type = 26;
        localExtensionInfo1.intimate_level = paramIntimateInfo.bestfriend.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.bestfriend.chat_days.get();
        if ((paramIntimateInfo.bestfriend.buffer.has()) && (paramIntimateInfo.bestfriend.buffer.get() != null))
        {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.bestfriend.buffer.get().toByteArray());
          bool = true;
        }
      }
      else
      {
        if (!paramIntimateInfo.buddy.has()) {
          continue;
        }
        localExtensionInfo1.intimate_type = 3;
        localExtensionInfo1.intimate_level = paramIntimateInfo.buddy.level.get();
        localExtensionInfo1.intimate_chatDays = paramIntimateInfo.buddy.chat_days.get();
        if ((paramIntimateInfo.buddy.buffer.has()) && (paramIntimateInfo.buddy.buffer.get() != null)) {
          a(paramQQAppInterface, localExtensionInfo1, paramIntimateInfo.buddy.buffer.get().toByteArray());
        }
      }
      bool = true;
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    boolean bool = jdField_a_of_type_Boolean;
    if (!TextUtils.isEmpty(paramString))
    {
      jdField_a_of_type_Boolean = paramBoolean;
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).edit();
      localEditor.putBoolean("friend_intimate_isOpen", paramBoolean);
      localEditor.commit();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "updateIsOpen uin:" + paramString + " isOpen:" + paramBoolean + "  sLastIsOpen:" + jdField_a_of_type_Boolean + " lastOpen:" + bool);
    }
  }
  
  public static boolean a()
  {
    if (System.currentTimeMillis() - jdField_a_of_type_Long < 1000L) {
      return b;
    }
    jdField_a_of_type_Long = System.currentTimeMillis();
    b = arav.a().jdField_a_of_type_Boolean;
    QLog.i("FriendIntimateRelationshipHelper", 1, "isUpgradeOpen res:" + b);
    return b;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    if ((paramFriends != null) && (!paramFriends.isFriend())) {
      return false;
    }
    if (paramExtensionInfo != null) {}
    for (int j = paramExtensionInfo.intimate_type;; j = 0)
    {
      int i;
      boolean bool2;
      boolean bool1;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        paramFriends = new intimate_relation.IntimateInfo();
        try
        {
          paramFriends.mergeFrom(paramArrayOfByte);
          i = 0;
        }
        catch (Exception paramFriends)
        {
          for (;;)
          {
            paramFriends.printStackTrace();
            paramFriends = null;
            i = 1;
            continue;
            if (paramFriends.ladybro.has())
            {
              paramExtensionInfo.intimate_type = 2;
              paramExtensionInfo.intimate_level = paramFriends.ladybro.level.get();
              paramExtensionInfo.intimate_chatDays = paramFriends.ladybro.chat_days.get();
              if ((paramFriends.ladybro.buffer.has()) && (paramFriends.ladybro.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, paramFriends.ladybro.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
            }
            else if (paramFriends.bestfriend.has())
            {
              paramExtensionInfo.intimate_type = 26;
              paramExtensionInfo.intimate_level = paramFriends.bestfriend.level.get();
              paramExtensionInfo.intimate_chatDays = paramFriends.bestfriend.chat_days.get();
              if ((paramFriends.bestfriend.buffer.has()) && (paramFriends.bestfriend.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, paramFriends.bestfriend.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
            }
            else if (paramFriends.buddy.has())
            {
              paramExtensionInfo.intimate_type = 3;
              paramExtensionInfo.intimate_level = paramFriends.buddy.level.get();
              paramExtensionInfo.intimate_chatDays = paramFriends.buddy.chat_days.get();
              if ((paramFriends.buddy.buffer.has()) && (paramFriends.buddy.buffer.get() != null)) {
                a(paramQQAppInterface, paramExtensionInfo, paramFriends.buddy.buffer.get().toByteArray());
              }
              bool2 = true;
              bool1 = true;
              continue;
            }
            else
            {
              bool2 = false;
              bool1 = false;
            }
          }
        }
        if ((paramFriends != null) && (paramExtensionInfo != null)) {
          if (paramFriends.lover.has())
          {
            paramExtensionInfo.intimate_type = 1;
            paramExtensionInfo.intimate_level = paramFriends.lover.level.get();
            paramExtensionInfo.intimate_chatDays = paramFriends.lover.chat_days.get();
            if ((paramFriends.lover.buffer.has()) && (paramFriends.lover.buffer.get() != null)) {
              a(paramQQAppInterface, paramExtensionInfo, paramFriends.lover.buffer.get().toByteArray());
            }
            bool2 = true;
            bool1 = true;
          }
        }
      }
      for (;;)
      {
        if ((!bool2) && (i == 0) && (paramExtensionInfo != null) && ((paramExtensionInfo.intimate_type != 0) || (paramExtensionInfo.intimate_level != 0) || (paramExtensionInfo.intimate_chatDays != 0) || (paramExtensionInfo.isExtinguish)))
        {
          paramExtensionInfo.intimate_type = 0;
          paramExtensionInfo.intimate_level = 0;
          paramExtensionInfo.intimate_chatDays = 0;
          paramExtensionInfo.isExtinguish = false;
          bool1 = true;
          if ((paramQQAppInterface != null) && (paramExtensionInfo != null))
          {
            paramFriends = new StringBuilder().append("handleGetIntimateInfo hasFlag:").append(bool2).append("  uin:").append(paramExtensionInfo.uin).append(" isOpen:").append(a(paramQQAppInterface.getCurrentUin())).append(" old_type:").append(j).append(" intimate_type:").append(paramExtensionInfo.intimate_type).append(" intimate_level:").append(paramExtensionInfo.intimate_level).append(" intimate_chatDays:").append(paramExtensionInfo.intimate_chatDays).append(" isExtinguish:").append(paramExtensionInfo.isExtinguish).append(" vecIntimateInfo.length:");
            paramQQAppInterface = localObject;
            if (paramArrayOfByte != null) {
              paramQQAppInterface = Integer.valueOf(paramArrayOfByte.length);
            }
            QLog.i("FriendIntimateRelationshipHelper", 1, paramQQAppInterface + " changed:" + bool1);
          }
          return bool1;
        }
        bool1 = false;
        i = 0;
        bool2 = false;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, jdField_a_of_type_JavaLangString)))
    {
      boolean bool = jdField_a_of_type_Boolean;
      String str = jdField_a_of_type_JavaLangString;
      jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences(paramString, 0).getBoolean("friend_intimate_isOpen", false);
      QLog.d("FriendIntimateRelationshipHelper", 1, "isOpen oldOpen:" + bool + " sLastIsOpen:" + jdField_a_of_type_Boolean + "  oldUin:" + str + "  sLastUin:" + jdField_a_of_type_JavaLangString);
    }
    QLog.i("FriendIntimateRelationshipHelper", 1, "isOpen res:" + jdField_a_of_type_Boolean);
    return jdField_a_of_type_Boolean;
  }
  
  public static String b()
  {
    return arav.a().S;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    arau localarau = arav.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateDarkBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      if (paramInt2 == 0)
      {
        str = localarau.p;
      }
      else if (paramInt2 == 1)
      {
        str = localarau.q;
      }
      else if (paramInt2 == 2)
      {
        str = localarau.r;
        continue;
        if (paramInt2 == 0)
        {
          str = localarau.s;
        }
        else if (paramInt2 == 1)
        {
          str = localarau.t;
        }
        else if (paramInt2 == 2)
        {
          str = localarau.u;
          continue;
          if (paramInt2 == 0)
          {
            str = localarau.v;
          }
          else if (paramInt2 == 1)
          {
            str = localarau.w;
          }
          else if (paramInt2 == 2)
          {
            str = localarau.x;
            continue;
            if (paramInt2 == 0) {
              str = localarau.y;
            } else if (paramInt2 == 1) {
              str = localarau.z;
            } else if (paramInt2 == 2) {
              str = localarau.A;
            }
          }
        }
      }
    }
  }
  
  public static String c(int paramInt1, int paramInt2)
  {
    String str = "";
    arau localarau = arav.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      QLog.i("FriendIntimateRelationshipHelper", 1, "getAIOIntimateShareBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      return str;
      str = localarau.B;
      continue;
      if (paramInt2 == 0)
      {
        str = localarau.C;
      }
      else if (paramInt2 == 1)
      {
        str = localarau.D;
      }
      else if (paramInt2 == 2)
      {
        str = localarau.E;
        continue;
        if (paramInt2 == 0)
        {
          str = localarau.F;
        }
        else if (paramInt2 == 1)
        {
          str = localarau.G;
        }
        else if (paramInt2 == 2)
        {
          str = localarau.H;
          continue;
          if (paramInt2 == 0)
          {
            str = localarau.I;
          }
          else if (paramInt2 == 1)
          {
            str = localarau.J;
          }
          else if (paramInt2 == 2)
          {
            str = localarau.K;
            continue;
            if (paramInt2 == 0) {
              str = localarau.L;
            } else if (paramInt2 == 1) {
              str = localarau.M;
            } else if (paramInt2 == 2) {
              str = localarau.N;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axmv
 * JD-Core Version:    0.7.0.1
 */