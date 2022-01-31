import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.intimate_relation.intimate_relation.IntimateBuddy;
import tencent.intimate_relation.intimate_relation.IntimateInfo;
import tencent.intimate_relation.intimate_relation.IntimateLadybro;
import tencent.intimate_relation.intimate_relation.IntimateLover;
import tencent.intimate_relation_ext.intimate_relation_ext.IntimateRelationExtMsg;

public class aupd
{
  static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (aloz)paramQQAppInterface.getManager(51);
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
    return aojh.a().jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    aojg localaojg = aojh.a();
    switch (paramInt1)
    {
    default: 
      str = localaojg.c;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "getAIOIntimateBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      }
      return str;
      if (paramInt2 == 0)
      {
        str = localaojg.d;
      }
      else if (paramInt2 == 1)
      {
        str = localaojg.e;
      }
      else if (paramInt2 == 2)
      {
        str = localaojg.f;
        continue;
        if (paramInt2 == 0)
        {
          str = localaojg.g;
        }
        else if (paramInt2 == 1)
        {
          str = localaojg.h;
        }
        else if (paramInt2 == 2)
        {
          str = localaojg.i;
          continue;
          if (paramInt2 == 0) {
            str = localaojg.j;
          } else if (paramInt2 == 1) {
            str = localaojg.k;
          } else if (paramInt2 == 2) {
            str = localaojg.l;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(aojh.a().jdField_b_of_type_JavaLangString).buildUpon();
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
    String str3 = auny.a(paramQQAppInterface, paramString1, paramInt, 0L);
    String str1 = auny.a(paramQQAppInterface, paramString1, paramInt, 1L);
    String str2 = auny.a(paramQQAppInterface, paramString1, paramInt, 2L);
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
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, aloz paramaloz, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = auny.a(paramQQAppInterface, paramInt, 0L);
    String str2 = auny.a(paramQQAppInterface, paramInt, 1L);
    String str1 = auny.a(paramQQAppInterface, paramInt, 2L);
    paramInt = paramaloz.n;
    int i = paramaloz.o;
    int j = paramaloz.p;
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
    localArrayList.add(0, paramString1.replace(alpo.a(2131705252), paramString2));
    return localArrayList;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, aloz paramaloz, String paramString1, String paramString2, int paramInt1, int paramInt2, amgu paramamgu, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendIntimateRelationshipHelper", 2, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " intimateType:" + paramInt1);
    }
    if ((TextUtils.isEmpty(paramString2)) || (auoj.a(paramQQAppInterface))) {
      return;
    }
    Object localObject2 = bdbt.m(paramQQAppInterface, paramString1);
    Object localObject1 = paramString2;
    if (paramInt3 == 2097154)
    {
      localObject1 = paramString2;
      if (paramInt4 == 0)
      {
        localObject3 = aoqt.c();
        localObject1 = paramString2;
        if (((aoqs)localObject3).jdField_a_of_type_Boolean) {
          localObject1 = paramString2 + ((aoqs)localObject3).jdField_a_of_type_JavaLangString;
        }
      }
    }
    localObject2 = a(paramQQAppInterface, (String)localObject1, (String)localObject2, paramaloz, paramInt1);
    Object localObject3 = a(paramQQAppInterface, paramString1, (String)((List)localObject2).get(0), paramInt1);
    paramaloz = (String)((List)localObject3).get(0);
    ((List)localObject3).remove(0);
    ((List)localObject2).remove(0);
    paramString2 = new aslp(paramString1, paramString1, paramaloz, 0, -5040, paramInt3, ayvc.a());
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).hasRead = 0;
    ((MessageForUniteGrayTip)localObject1).subType = paramInt4;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramString2);
    ((MessageForUniteGrayTip)localObject1).tipParam.d = (paramString1 + "_intimate_" + String.valueOf(paramamgu.jdField_b_of_type_Long) + "_" + String.valueOf(paramamgu.jdField_b_of_type_Int));
    int i;
    Object localObject4;
    int j;
    if (((List)localObject3).size() > 0)
    {
      i = 0;
      while (i < ((List)localObject3).size())
      {
        paramamgu = new Bundle();
        localObject4 = (String)((List)localObject3).get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramamgu.putString("image_resource", (String)localObject4);
          j = 0;
          do
          {
            k = paramaloz.indexOf((String)localObject4, j);
            j = ((String)localObject4).length() + k;
            if (k >= 0)
            {
              paramString2.a(k, j, paramamgu);
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
    label567:
    int i2;
    int i3;
    int i1;
    Object localObject5;
    Object localObject6;
    if (((List)localObject2).size() > 0)
    {
      Collections.sort((List)localObject2, new aupf());
      paramamgu = new ArrayList();
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
          i2 = paramaloz.indexOf(str1, j);
          i3 = str1.length();
          i1 = i2 + i3;
          localObject5 = paramamgu.iterator();
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
      j = paramaloz.length();
      int n = k;
      label738:
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
                  if (paramaloz.indexOf(str1, i1) >= 0)
                  {
                    j = 1;
                    if ((((List)localObject2).size() <= 1) && (j == 0))
                    {
                      n = k;
                      if (i <= 0) {
                        break label864;
                      }
                    }
                    localObject5 = paramaloz.substring(0, i2);
                    localObject6 = paramaloz.substring(i1);
                    Iterator localIterator = ((List)localObject3).iterator();
                    j = 0;
                    label792:
                    if (!localIterator.hasNext()) {
                      break label852;
                    }
                    str2 = (String)localIterator.next();
                    if (!((String)localObject6).startsWith(str2)) {
                      break label836;
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
        break label792;
        j = 0;
        break label738;
        label836:
        if (((String)localObject5).endsWith(str2))
        {
          j = 1;
          continue;
          label852:
          n = k;
          if (j == 0) {
            n = 1;
          }
          label864:
          if (n != 0) {}
          for (;;)
          {
            if (i2 < 0)
            {
              j = i;
              m += 1;
              i = j;
              break;
              paramamgu.add(new Pair(Integer.valueOf(i2), Integer.valueOf(i2 + i3)));
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
                paramamgu = aoqt.c();
                if (paramamgu.jdField_a_of_type_Boolean)
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
                ((Bundle)localObject2).putString("key_action_DATA", String.format(paramamgu.jdField_b_of_type_JavaLangString, new Object[] { paramString1, Integer.valueOf(paramInt1) }));
                paramInt2 = paramaloz.length() - paramamgu.jdField_a_of_type_JavaLangString.length();
                if (paramInt2 >= 0)
                {
                  paramString2.a(paramInt2, paramaloz.length(), (Bundle)localObject2);
                  azmj.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt1, 0, "", "", "", "");
                }
                aslq.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
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
          j = i1;
          break label567;
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
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, amgu paramamgu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramamgu);
    }
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramamgu == null)) {}
    long l1;
    long l2;
    aend localaend;
    aloz localaloz;
    do
    {
      do
      {
        return;
        l1 = paramamgu.jdField_b_of_type_Long;
        l2 = paramamgu.c;
        localaend = aend.a(paramRelationalChainChange, paramamgu.jdField_a_of_type_Boolean);
      } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localaend.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localaend.jdField_b_of_type_JavaLangString)));
      localaloz = (aloz)paramQQAppInterface.getManager(51);
      paramRelationalChainChange = localaloz.e(localaend.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramamgu + "changePushInfo:" + localaend);
      }
    } while ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isFriend()));
    ExtensionInfo localExtensionInfo = localaloz.a(localaend.jdField_b_of_type_JavaLangString);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = localaend.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject4 = (asdx)paramQQAppInterface.a(153);
      Object localObject2 = null;
      Object localObject3 = null;
      Bundle localBundle = null;
      String str = null;
      Object localObject1 = null;
      label327:
      int i;
      switch (localaend.jdField_a_of_type_Int)
      {
      default: 
        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
      case 1: 
        do
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 changeType:" + localaend.jdField_a_of_type_Int + " grayTips:" + paramRelationalChainChange + " uin:" + localExtensionInfo.uin + " isOpen:" + a(localaend.jdField_a_of_type_JavaLangString) + " intimate_type:" + localExtensionInfo.intimate_type + " intimate_level:" + localExtensionInfo.intimate_level + " intimate_chatDays:" + localExtensionInfo.intimate_chatDays + " isExtinguish:" + localExtensionInfo.isExtinguish + " last_intimate_chatTime:" + localExtensionInfo.last_intimate_chatTime);
          return;
          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
        } while (localaend.jdField_b_of_type_Aeng == null);
        if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 1) || (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 2) || (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 3))
        {
          localExtensionInfo.intimate_type = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
          localExtensionInfo.intimate_chatDays = 0;
          localExtensionInfo.intimate_level = localaend.jdField_b_of_type_Aeng.a();
          localExtensionInfo.isExtinguish = false;
          if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni != null) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c > 0L)) {
            localExtensionInfo.last_intimate_chatTime = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c;
          }
          localObject1 = aupg.a(paramQQAppInterface.getApp(), 162);
          localaloz.a(localExtensionInfo);
          if (a(localaend.jdField_a_of_type_JavaLangString))
          {
            i = auod.a(localaend);
            a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int, localaend.jdField_b_of_type_Aeng.a(), paramamgu, 2097153, i);
            ((asdx)localObject4).notifyUI(2, true, new Object[] { localaend.jdField_b_of_type_JavaLangString });
          }
          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
          if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface = (alrm)paramQQAppInterface.a(172);
            paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
            if (paramQQAppInterface != null) {
              paramQQAppInterface.a(1);
            }
          }
        }
        break;
      }
      for (paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;; paramRelationalChainChange = null)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:" + localaend.jdField_b_of_type_JavaLangString + " changePushInfo.now:" + localaend.jdField_b_of_type_Aeng);
          break label327;
          int k = 0;
          int j = 0;
          if (localaend.jdField_a_of_type_Aeng != null)
          {
            k = localaend.jdField_a_of_type_Aeng.jdField_a_of_type_Int;
            j = localaend.jdField_a_of_type_Aeng.a();
          }
          int m = j;
          i = k;
          if (k == 0)
          {
            m = j;
            i = k;
            if (localaend.jdField_b_of_type_Aeng != null)
            {
              i = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
              m = localaend.jdField_b_of_type_Aeng.a();
            }
          }
          if (i == 0)
          {
            j = localExtensionInfo.intimate_type;
            k = localExtensionInfo.intimate_level;
          }
          for (;;)
          {
            if ((j == 1) || (j == 2) || (j == 3))
            {
              localExtensionInfo.intimate_type = 0;
              localExtensionInfo.intimate_level = 0;
              localExtensionInfo.intimate_chatDays = 0;
              localExtensionInfo.isExtinguish = false;
              i = 163;
              if (k == 1)
              {
                i = 164;
                label939:
                localObject1 = aupg.a(paramQQAppInterface.getApp(), i);
                localaloz.a(localExtensionInfo);
                if (a(localaend.jdField_a_of_type_JavaLangString))
                {
                  a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, j, 0, paramamgu, 2097154, 1);
                  ((asdx)localObject4).notifyUI(1, true, new Object[] { localaend.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
                  ((asdz)paramQQAppInterface.getManager(323)).a(localaend.jdField_b_of_type_JavaLangString);
                }
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (j == 1)
                {
                  paramQQAppInterface = (alrm)paramQQAppInterface.a(172);
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (paramQQAppInterface != null) {
                    paramQQAppInterface.a(0);
                  }
                }
              }
            }
            for (paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;; paramRelationalChainChange = null)
            {
              if (QLog.isColorLevel()) {
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:" + j + " intimate_level:" + k + " friendUin:" + localaend.jdField_b_of_type_JavaLangString);
              }
              break label327;
              if (k != 2) {
                break label939;
              }
              i = 165;
              break label939;
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a()) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a(localaend.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localaend.jdField_b_of_type_Aeng == null) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localaend.jdField_a_of_type_Aeng == null) {
                break label327;
              }
              if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni != null) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c > 0L)) {
                localExtensionInfo.last_intimate_chatTime = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c;
              }
              k = localaend.jdField_b_of_type_Aeng.a();
              m = localaend.jdField_a_of_type_Aeng.a();
              if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 2))
              {
                localObject1 = localObject2;
                if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 3) {}
              }
              else
              {
                localObject1 = localObject2;
                if (k > m)
                {
                  j = -1;
                  if (k != 1) {
                    break label1555;
                  }
                  if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) {
                    break label1514;
                  }
                  i = 150;
                }
              }
              label1555:
              for (;;)
              {
                localObject1 = aupg.a(paramQQAppInterface.getApp(), i);
                localExtensionInfo.intimate_type = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
                localExtensionInfo.intimate_level = k;
                localaloz.a(localExtensionInfo);
                i = auod.a(localaend);
                a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int, k, paramamgu, 2097153, i);
                ((asdx)localObject4).notifyUI(3, true, new Object[] { localaend.jdField_b_of_type_JavaLangString, Integer.valueOf(localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:" + localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                break;
                label1514:
                if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 2)
                {
                  i = 158;
                }
                else
                {
                  i = j;
                  if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 3)
                  {
                    i = 154;
                    continue;
                    i = j;
                    if (k == 2) {
                      if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 1)
                      {
                        i = 151;
                      }
                      else if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 2)
                      {
                        i = 159;
                      }
                      else
                      {
                        i = j;
                        if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 3) {
                          i = 155;
                        }
                      }
                    }
                  }
                }
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a()) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a(localaend.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localaend.jdField_b_of_type_Aeng == null) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localaend.jdField_a_of_type_Aeng == null) {
                break label327;
              }
              if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni != null) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c > 0L)) {
                localExtensionInfo.last_intimate_chatTime = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c;
              }
              k = localaend.jdField_b_of_type_Aeng.a();
              m = localaend.jdField_a_of_type_Aeng.a();
              if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 2))
              {
                localObject1 = localObject3;
                if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 3) {}
              }
              else
              {
                localObject1 = localObject3;
                if (k < m)
                {
                  j = -1;
                  if (m != 1) {
                    break label2032;
                  }
                  if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) {
                    break label1991;
                  }
                  i = 152;
                }
              }
              for (;;)
              {
                localObject1 = aupg.a(paramQQAppInterface.getApp(), i);
                localExtensionInfo.intimate_type = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int;
                localExtensionInfo.intimate_level = k;
                localaloz.a(localExtensionInfo);
                a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int, k, paramamgu, 2097154, 0);
                ((asdx)localObject4).notifyUI(3, true, new Object[] { localaend.jdField_b_of_type_JavaLangString, Integer.valueOf(localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:" + localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                break;
                label1991:
                if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 2)
                {
                  i = 160;
                }
                else
                {
                  i = j;
                  if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 3)
                  {
                    i = 156;
                    continue;
                    label2032:
                    i = j;
                    if (m == 2) {
                      if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 1)
                      {
                        i = 153;
                      }
                      else if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 2)
                      {
                        i = 161;
                      }
                      else
                      {
                        i = j;
                        if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int == 3) {
                          i = 157;
                        }
                      }
                    }
                  }
                }
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a()) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (!a(localaend.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localaend.jdField_b_of_type_Aeng == null) {
                break label327;
              }
              if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 0) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni != null)) {
                if ((!TextUtils.isEmpty(localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.jdField_a_of_type_JavaLangString)) && (!auoj.a(paramQQAppInterface)))
                {
                  localObject2 = aupg.a(paramQQAppInterface, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.jdField_a_of_type_JavaLangString, bdbt.m(paramQQAppInterface, localaend.jdField_b_of_type_JavaLangString), localaloz);
                  localObject3 = aupg.a(paramQQAppInterface, (String)((List)localObject2).get(0), localaend.jdField_b_of_type_JavaLangString);
                  paramRelationalChainChange = (String)((List)localObject3).get(0);
                  ((List)localObject2).remove(0);
                  ((List)localObject3).remove(0);
                  paramamgu = new aslp(localaend.jdField_b_of_type_JavaLangString, localaend.jdField_b_of_type_JavaLangString, paramRelationalChainChange, 0, -5020, 2097153, ayvc.a());
                  if ((localObject3 != null) && (((List)localObject3).size() > 0))
                  {
                    i = 0;
                    while (i < ((List)localObject3).size())
                    {
                      localBundle = new Bundle();
                      str = (String)((List)localObject3).get(i);
                      if (!TextUtils.isEmpty(str))
                      {
                        localBundle.putString("image_resource", str);
                        j = paramRelationalChainChange.lastIndexOf(str);
                        if (j >= 0) {
                          paramamgu.a(j, str.length() + j, localBundle);
                        }
                        if (QLog.isColorLevel()) {
                          QLog.d("reactive", 2, "addHotFriendAIOGrayTips grayStr=" + paramRelationalChainChange + "iconPos=" + j + "icon=" + str + "grayStr=" + paramRelationalChainChange);
                        }
                      }
                      i += 1;
                    }
                  }
                  label2563:
                  if ((localObject2 != null) && (((List)localObject2).size() > 0))
                  {
                    Collections.sort((List)localObject2, new aupe());
                    localObject3 = new ArrayList();
                    j = 0;
                    label2498:
                    if (j < ((List)localObject2).size())
                    {
                      localBundle = new Bundle();
                      str = (String)((List)localObject2).get(j);
                      if (!TextUtils.isEmpty(str))
                      {
                        localBundle.putInt("key_action", 11);
                        localBundle.putString("key_action_DATA", str);
                        i = 0;
                        m = paramRelationalChainChange.indexOf(str, i);
                        if (m >= 0) {
                          break label2591;
                        }
                      }
                    }
                  }
                }
              }
              label2577:
              label2591:
              label3684:
              for (;;)
              {
                int n;
                if (m < 0)
                {
                  j += 1;
                  break label2498;
                  n = str.length();
                  i = m + n;
                  localObject4 = ((ArrayList)localObject3).iterator();
                  Pair localPair;
                  do
                  {
                    if (!((Iterator)localObject4).hasNext()) {
                      break;
                    }
                    localPair = (Pair)((Iterator)localObject4).next();
                  } while ((m < ((Integer)localPair.first).intValue()) || (m >= ((Integer)localPair.second).intValue()));
                }
                for (k = 1;; k = 0)
                {
                  if (k != 0) {
                    break label3684;
                  }
                  ((ArrayList)localObject3).add(new Pair(Integer.valueOf(m), Integer.valueOf(m + n)));
                  if (m >= 0)
                  {
                    paramamgu.a(m, i, localBundle);
                    if (QLog.isColorLevel()) {
                      QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + m + " fromIndex=" + i);
                    }
                  }
                  break label2577;
                  break label2563;
                  localObject2 = new MessageForUniteGrayTip();
                  ((MessageForUniteGrayTip)localObject2).hasRead = 0;
                  ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, paramamgu);
                  paramamgu = new StringBuilder(21);
                  paramamgu.append(l1).append("_").append(l2);
                  ((MessageForUniteGrayTip)localObject2).tipParam.d = paramamgu.toString();
                  paramamgu = paramQQAppInterface.a().b(localaend.jdField_b_of_type_JavaLangString, 0);
                  if ((paramamgu != null) && (!paramamgu.isEmpty()))
                  {
                    paramamgu = (MessageRecord)paramamgu.get(paramamgu.size() - 1);
                    if (((paramamgu instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramamgu).tipParam != null) && (((MessageForUniteGrayTip)paramamgu).subType == ((MessageForUniteGrayTip)localObject2).subType) && (((MessageForUniteGrayTip)paramamgu).tipParam.c.equals(((MessageForUniteGrayTip)localObject2).tipParam.c)) && (((MessageForUniteGrayTip)localObject2).tipParam.jdField_a_of_type_Long - ((MessageForUniteGrayTip)paramamgu).tipParam.jdField_a_of_type_Long <= 1L))
                    {
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                      return;
                    }
                  }
                  if (!TextUtils.isEmpty(paramRelationalChainChange)) {
                    aslq.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
                  }
                  localExtensionInfo.intimate_level = localaend.jdField_b_of_type_Aeng.a();
                  if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c > 0L) {
                    localExtensionInfo.last_intimate_chatTime = localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Aeni.c;
                  }
                  localaloz.a(localExtensionInfo);
                  paramRelationalChainChange = new ArrayList();
                  paramRelationalChainChange.add(localaend.jdField_b_of_type_JavaLangString);
                  paramQQAppInterface.a(1).notifyUI(107, true, paramRelationalChainChange);
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:" + localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int + " intimate_level:" + localaend.jdField_b_of_type_Aeng.a());
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  break label327;
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a()) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a(localaend.jdField_a_of_type_JavaLangString)) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (localaend.jdField_b_of_type_Aeng == null) {
                    break label327;
                  }
                  if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 2))
                  {
                    localObject1 = localBundle;
                    if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 3) {}
                  }
                  else
                  {
                    localExtensionInfo.isExtinguish = false;
                    localaloz.a(localExtensionInfo);
                    localObject1 = aupg.a(paramQQAppInterface.getApp(), 167);
                    a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int, localaend.jdField_b_of_type_Aeng.a(), paramamgu, 2097153, 0);
                    ((asdx)localObject4).notifyUI(3, true, new Object[] { localaend.jdField_b_of_type_JavaLangString, Integer.valueOf(localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int), Integer.valueOf(localaend.jdField_b_of_type_Aeng.a()), Integer.valueOf(localaend.jdField_b_of_type_Aeng.a()) });
                    ((FriendListHandler)paramQQAppInterface.a(1)).notifyUI(3, true, localaend.jdField_b_of_type_JavaLangString);
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:" + localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int + " intimate_level:" + localaend.jdField_b_of_type_Aeng.a());
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  break label327;
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a()) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a(localaend.jdField_a_of_type_JavaLangString)) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (localaend.jdField_b_of_type_Aeng == null) {
                    break label327;
                  }
                  if ((localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 1) && (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 2))
                  {
                    localObject1 = str;
                    if (localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int != 3) {}
                  }
                  else
                  {
                    localExtensionInfo.isExtinguish = true;
                    localaloz.a(localExtensionInfo);
                    localObject1 = aupg.a(paramQQAppInterface.getApp(), 166);
                    a(paramQQAppInterface, localaloz, localaend.jdField_b_of_type_JavaLangString, (String)localObject1, localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int, localaend.jdField_b_of_type_Aeng.a(), paramamgu, 2097154, 0);
                    ((asdx)localObject4).notifyUI(3, true, new Object[] { localaend.jdField_b_of_type_JavaLangString, Integer.valueOf(localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int), Integer.valueOf(localaend.jdField_b_of_type_Aeng.a()), Integer.valueOf(localaend.jdField_b_of_type_Aeng.a()) });
                    ((FriendListHandler)paramQQAppInterface.a(1)).notifyUI(3, true, localaend.jdField_b_of_type_JavaLangString);
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:" + localaend.jdField_b_of_type_Aeng.jdField_a_of_type_Int + " intimate_level:" + localaend.jdField_b_of_type_Aeng.a());
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  break label327;
                }
              }
            }
            k = m;
            j = i;
          }
        }
        break label327;
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
    aloz localaloz = (aloz)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo2 = localaloz.a(Long.toString(l));
    ExtensionInfo localExtensionInfo1;
    if (localExtensionInfo2 == null)
    {
      localExtensionInfo1 = new ExtensionInfo();
      localExtensionInfo1.uin = Long.toString(l);
      label66:
      if ((!paramIntimateInfo.is_del.has()) || (!paramIntimateInfo.is_del.get())) {
        break label353;
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
        localaloz.a(localExtensionInfo1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo end changed:" + bool + "  uin:" + l + " isOpen:" + a(paramQQAppInterface.c()) + " intimate_type:" + localExtensionInfo1.intimate_type + " intimate_level:" + localExtensionInfo1.intimate_level + " isExtinguish:" + localExtensionInfo1.isExtinguish + " intimate_chatDays:" + localExtensionInfo1.intimate_chatDays);
      return;
      localExtensionInfo1 = localExtensionInfo2;
      if (!QLog.isColorLevel()) {
        break label66;
      }
      QLog.i("FriendIntimateRelationshipHelper", 1, "handleGet0x5e0IntimateInfo before uin:" + l + " isOpen:" + a(paramQQAppInterface.c()) + " intimate_type:" + localExtensionInfo2.intimate_type + " intimate_level:" + localExtensionInfo2.intimate_level + " isExtinguish:" + localExtensionInfo2.isExtinguish + " intimate_chatDays:" + localExtensionInfo2.intimate_chatDays);
      localExtensionInfo1 = localExtensionInfo2;
      break label66;
      label353:
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
    b = aojh.a().jdField_a_of_type_Boolean;
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 2, "isUpgradeOpen res:" + b);
    }
    return b;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Friends paramFriends, ExtensionInfo paramExtensionInfo, byte[] paramArrayOfByte)
  {
    Object localObject = null;
    boolean bool1;
    if ((paramFriends != null) && (!paramFriends.isFriend()))
    {
      bool1 = false;
      return bool1;
    }
    if (paramExtensionInfo != null) {}
    for (int j = paramExtensionInfo.intimate_type;; j = 0)
    {
      int i;
      boolean bool2;
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
        boolean bool3 = bool1;
        if (!bool2)
        {
          bool3 = bool1;
          if (i == 0)
          {
            bool3 = bool1;
            if (paramExtensionInfo != null) {
              if ((paramExtensionInfo.intimate_type == 0) && (paramExtensionInfo.intimate_level == 0) && (paramExtensionInfo.intimate_chatDays == 0))
              {
                bool3 = bool1;
                if (!paramExtensionInfo.isExtinguish) {}
              }
              else
              {
                paramExtensionInfo.intimate_type = 0;
                paramExtensionInfo.intimate_level = 0;
                paramExtensionInfo.intimate_chatDays = 0;
                paramExtensionInfo.isExtinguish = false;
                bool3 = true;
              }
            }
          }
        }
        bool1 = bool3;
        if (!QLog.isColorLevel()) {
          break;
        }
        bool1 = bool3;
        if (paramQQAppInterface == null) {
          break;
        }
        bool1 = bool3;
        if (paramExtensionInfo == null) {
          break;
        }
        if (paramExtensionInfo.intimate_type == 0)
        {
          bool1 = bool3;
          if (paramExtensionInfo.intimate_type == j) {
            break;
          }
        }
        paramFriends = new StringBuilder().append("handleGetIntimateInfo hasFlag:").append(bool2).append("  uin:").append(paramExtensionInfo.uin).append(" isOpen:").append(a(paramQQAppInterface.c())).append(" old_type:").append(j).append(" intimate_type:").append(paramExtensionInfo.intimate_type).append(" intimate_level:").append(paramExtensionInfo.intimate_level).append(" intimate_chatDays:").append(paramExtensionInfo.intimate_chatDays).append(" isExtinguish:").append(paramExtensionInfo.isExtinguish).append(" vecIntimateInfo.length:");
        paramQQAppInterface = localObject;
        if (paramArrayOfByte != null) {
          paramQQAppInterface = Integer.valueOf(paramArrayOfByte.length);
        }
        QLog.i("FriendIntimateRelationshipHelper", 1, paramQQAppInterface + " changed:" + bool3);
        return bool3;
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
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 1, "isOpen oldOpen:" + bool + " sLastIsOpen:" + jdField_a_of_type_Boolean + "  oldUin:" + str + "  sLastUin:" + jdField_a_of_type_JavaLangString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 2, "isOpen res:" + jdField_a_of_type_Boolean);
    }
    return jdField_a_of_type_Boolean;
  }
  
  public static String b()
  {
    return aojh.a().J;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    aojg localaojg = aojh.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "getAIOIntimateDarkBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      }
      return str;
      if (paramInt2 == 0)
      {
        str = localaojg.m;
      }
      else if (paramInt2 == 1)
      {
        str = localaojg.n;
      }
      else if (paramInt2 == 2)
      {
        str = localaojg.o;
        continue;
        if (paramInt2 == 0)
        {
          str = localaojg.p;
        }
        else if (paramInt2 == 1)
        {
          str = localaojg.q;
        }
        else if (paramInt2 == 2)
        {
          str = localaojg.r;
          continue;
          if (paramInt2 == 0) {
            str = localaojg.s;
          } else if (paramInt2 == 1) {
            str = localaojg.t;
          } else if (paramInt2 == 2) {
            str = localaojg.u;
          }
        }
      }
    }
  }
  
  public static String c(int paramInt1, int paramInt2)
  {
    String str = "";
    aojg localaojg = aojh.a();
    switch (paramInt1)
    {
    default: 
      str = "";
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "getAIOIntimateShareBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      }
      return str;
      str = localaojg.v;
      continue;
      if (paramInt2 == 0)
      {
        str = localaojg.w;
      }
      else if (paramInt2 == 1)
      {
        str = localaojg.x;
      }
      else if (paramInt2 == 2)
      {
        str = localaojg.y;
        continue;
        if (paramInt2 == 0)
        {
          str = localaojg.z;
        }
        else if (paramInt2 == 1)
        {
          str = localaojg.A;
        }
        else if (paramInt2 == 2)
        {
          str = localaojg.B;
          continue;
          if (paramInt2 == 0) {
            str = localaojg.C;
          } else if (paramInt2 == 1) {
            str = localaojg.D;
          } else if (paramInt2 == 2) {
            str = localaojg.E;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aupd
 * JD-Core Version:    0.7.0.1
 */