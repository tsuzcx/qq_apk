import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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

public class asyg
{
  static long jdField_a_of_type_Long;
  private static String jdField_a_of_type_JavaLangString;
  static boolean jdField_a_of_type_Boolean;
  static boolean b;
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (ajxl)paramQQAppInterface.getManager(51);
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
    return amsj.a().jdField_a_of_type_JavaLangString;
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    String str = "";
    amsi localamsi = amsj.a();
    switch (paramInt1)
    {
    default: 
      str = localamsi.c;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "getAIOIntimateBG intimateType:" + paramInt1 + " level:" + paramInt2 + " res:" + str);
      }
      return str;
      if (paramInt2 == 0)
      {
        str = localamsi.d;
      }
      else if (paramInt2 == 1)
      {
        str = localamsi.e;
      }
      else if (paramInt2 == 2)
      {
        str = localamsi.f;
        continue;
        if (paramInt2 == 0)
        {
          str = localamsi.g;
        }
        else if (paramInt2 == 1)
        {
          str = localamsi.h;
        }
        else if (paramInt2 == 2)
        {
          str = localamsi.i;
          continue;
          if (paramInt2 == 0) {
            str = localamsi.j;
          } else if (paramInt2 == 1) {
            str = localamsi.k;
          } else if (paramInt2 == 2) {
            str = localamsi.l;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Uri.Builder localBuilder = Uri.parse(amsj.a().jdField_b_of_type_JavaLangString).buildUpon();
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
    String str3 = asxb.a(paramQQAppInterface, paramString1, paramInt, 0L);
    String str1 = asxb.a(paramQQAppInterface, paramString1, paramInt, 1L);
    String str2 = asxb.a(paramQQAppInterface, paramString1, paramInt, 2L);
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
  
  public static List<String> a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, ajxl paramajxl, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    String str3 = asxb.a(paramQQAppInterface, paramInt, 0L);
    String str2 = asxb.a(paramQQAppInterface, paramInt, 1L);
    String str1 = asxb.a(paramQQAppInterface, paramInt, 2L);
    paramInt = paramajxl.n;
    int i = paramajxl.o;
    int j = paramajxl.p;
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
    localArrayList.add(0, paramString1.replace(ajya.a(2131704880), paramString2));
    return localArrayList;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, ajxl paramajxl, String paramString1, String paramString2, int paramInt1, int paramInt2, akqm paramakqm, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendIntimateRelationshipHelper", 2, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " intimateType:" + paramInt1);
    }
    if ((TextUtils.isEmpty(paramString2)) || (asxm.a(paramQQAppInterface))) {
      return;
    }
    Object localObject2 = bbcz.m(paramQQAppInterface, paramString1);
    Object localObject1 = paramString2;
    if (paramInt3 == 2097154)
    {
      localObject1 = paramString2;
      if (paramInt4 == 0)
      {
        localObject3 = amzm.c();
        localObject1 = paramString2;
        if (((amzl)localObject3).jdField_a_of_type_Boolean) {
          localObject1 = paramString2 + ((amzl)localObject3).jdField_a_of_type_JavaLangString;
        }
      }
    }
    localObject2 = a(paramQQAppInterface, (String)localObject1, (String)localObject2, paramajxl, paramInt1);
    Object localObject3 = a(paramQQAppInterface, paramString1, (String)((List)localObject2).get(0), paramInt1);
    paramajxl = (String)((List)localObject3).get(0);
    ((List)localObject3).remove(0);
    ((List)localObject2).remove(0);
    paramString2 = new aqvb(paramString1, paramString1, paramajxl, 0, -5040, paramInt3, awzy.a());
    localObject1 = new MessageForUniteGrayTip();
    ((MessageForUniteGrayTip)localObject1).hasRead = 0;
    ((MessageForUniteGrayTip)localObject1).subType = paramInt4;
    ((MessageForUniteGrayTip)localObject1).initGrayTipMsg(paramQQAppInterface, paramString2);
    ((MessageForUniteGrayTip)localObject1).tipParam.d = (paramString1 + "_intimate_" + String.valueOf(paramakqm.jdField_b_of_type_Long) + "_" + String.valueOf(paramakqm.jdField_b_of_type_Int));
    int i;
    Object localObject4;
    int j;
    if (((List)localObject3).size() > 0)
    {
      i = 0;
      while (i < ((List)localObject3).size())
      {
        paramakqm = new Bundle();
        localObject4 = (String)((List)localObject3).get(i);
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          paramakqm.putString("image_resource", (String)localObject4);
          j = 0;
          do
          {
            k = paramajxl.indexOf((String)localObject4, j);
            j = ((String)localObject4).length() + k;
            if (k >= 0)
            {
              paramString2.a(k, j, paramakqm);
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
      Collections.sort((List)localObject2, new asyi());
      paramakqm = new ArrayList();
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
          i2 = paramajxl.indexOf(str1, j);
          i3 = str1.length();
          i1 = i2 + i3;
          localObject5 = paramakqm.iterator();
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
      j = paramajxl.length();
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
                  if (paramajxl.indexOf(str1, i1) >= 0)
                  {
                    j = 1;
                    if ((((List)localObject2).size() <= 1) && (j == 0))
                    {
                      n = k;
                      if (i <= 0) {
                        break label864;
                      }
                    }
                    localObject5 = paramajxl.substring(0, i2);
                    localObject6 = paramajxl.substring(i1);
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
              paramakqm.add(new Pair(Integer.valueOf(i2), Integer.valueOf(i2 + i3)));
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
                paramakqm = amzm.c();
                if (paramakqm.jdField_a_of_type_Boolean)
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
                ((Bundle)localObject2).putString("key_action_DATA", String.format(paramakqm.jdField_b_of_type_JavaLangString, new Object[] { paramString1, Integer.valueOf(paramInt1) }));
                paramInt2 = paramajxl.length() - paramakqm.jdField_a_of_type_JavaLangString.length();
                if (paramInt2 >= 0)
                {
                  paramString2.a(paramInt2, paramajxl.length(), (Bundle)localObject2);
                  axqy.b(paramQQAppInterface, "dc00898", "", "", "qq_vip", "0X8009CA5", paramInt1, 0, "", "", "", "");
                }
                aqvc.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject1);
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
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, akqm paramakqm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramakqm);
    }
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramakqm == null)) {}
    long l1;
    long l2;
    acvt localacvt;
    ajxl localajxl;
    do
    {
      do
      {
        return;
        l1 = paramakqm.jdField_b_of_type_Long;
        l2 = paramakqm.c;
        localacvt = acvt.a(paramRelationalChainChange, paramakqm.jdField_a_of_type_Boolean);
      } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), localacvt.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(localacvt.jdField_b_of_type_JavaLangString)));
      localajxl = (ajxl)paramQQAppInterface.getManager(51);
      paramRelationalChainChange = localajxl.e(localacvt.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 msginfo:" + paramakqm + "changePushInfo:" + localacvt);
      }
    } while ((paramRelationalChainChange != null) && (!paramRelationalChainChange.isFriend()));
    ExtensionInfo localExtensionInfo = localajxl.a(localacvt.jdField_b_of_type_JavaLangString);
    if (localExtensionInfo == null)
    {
      localExtensionInfo = new ExtensionInfo();
      localExtensionInfo.uin = localacvt.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      Object localObject4 = (aqkh)paramQQAppInterface.a(153);
      Object localObject2 = null;
      Object localObject3 = null;
      Bundle localBundle = null;
      String str = null;
      Object localObject1 = null;
      label327:
      int i;
      switch (localacvt.jdField_a_of_type_Int)
      {
      default: 
        paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
      case 1: 
        do
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FriendIntimateRelationshipHelper", 1, "decodeC2CMsgPkgSubMsgType0xc7 changeType:" + localacvt.jdField_a_of_type_Int + " grayTips:" + paramRelationalChainChange + " uin:" + localExtensionInfo.uin + " isOpen:" + a(localacvt.jdField_a_of_type_JavaLangString) + " intimate_type:" + localExtensionInfo.intimate_type + " intimate_level:" + localExtensionInfo.intimate_level + " intimate_chatDays:" + localExtensionInfo.intimate_chatDays + " isExtinguish:" + localExtensionInfo.isExtinguish + " last_intimate_chatTime:" + localExtensionInfo.last_intimate_chatTime);
          return;
          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
        } while (localacvt.jdField_b_of_type_Acvw == null);
        if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 1) || (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 2) || (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 3))
        {
          localExtensionInfo.intimate_type = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int;
          localExtensionInfo.intimate_chatDays = 0;
          localExtensionInfo.intimate_level = localacvt.jdField_b_of_type_Acvw.a();
          localExtensionInfo.isExtinguish = false;
          if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c > 0L)) {
            localExtensionInfo.last_intimate_chatTime = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c;
          }
          localObject1 = asyj.a(paramQQAppInterface.getApp(), 162);
          localajxl.a(localExtensionInfo);
          if (a(localacvt.jdField_a_of_type_JavaLangString))
          {
            i = asxg.a(localacvt);
            a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int, localacvt.jdField_b_of_type_Acvw.a(), paramakqm, 2097153, i);
            ((aqkh)localObject4).notifyUI(2, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString });
          }
          paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
          if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 1)
          {
            paramQQAppInterface = (ajzy)paramQQAppInterface.a(172);
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
          QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Add friendUin:" + localacvt.jdField_b_of_type_JavaLangString + " changePushInfo.now:" + localacvt.jdField_b_of_type_Acvw);
          break label327;
          int k = 0;
          int j = 0;
          if (localacvt.jdField_a_of_type_Acvw != null)
          {
            k = localacvt.jdField_a_of_type_Acvw.jdField_a_of_type_Int;
            j = localacvt.jdField_a_of_type_Acvw.a();
          }
          int m = j;
          i = k;
          if (k == 0)
          {
            m = j;
            i = k;
            if (localacvt.jdField_b_of_type_Acvw != null)
            {
              i = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int;
              m = localacvt.jdField_b_of_type_Acvw.a();
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
                localObject1 = asyj.a(paramQQAppInterface.getApp(), i);
                localajxl.a(localExtensionInfo);
                if (a(localacvt.jdField_a_of_type_JavaLangString))
                {
                  a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, j, 0, paramakqm, 2097154, 1);
                  ((aqkh)localObject4).notifyUI(1, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString, Boolean.valueOf(true) });
                  ((aqkj)paramQQAppInterface.getManager(323)).a(localacvt.jdField_b_of_type_JavaLangString);
                }
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (j == 1)
                {
                  paramQQAppInterface = (ajzy)paramQQAppInterface.a(172);
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
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Del intimate_type:" + j + " intimate_level:" + k + " friendUin:" + localacvt.jdField_b_of_type_JavaLangString);
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
              if (!a(localacvt.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localacvt.jdField_b_of_type_Acvw == null) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localacvt.jdField_a_of_type_Acvw == null) {
                break label327;
              }
              if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c > 0L)) {
                localExtensionInfo.last_intimate_chatTime = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c;
              }
              k = localacvt.jdField_b_of_type_Acvw.a();
              m = localacvt.jdField_a_of_type_Acvw.a();
              if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 2))
              {
                localObject1 = localObject2;
                if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 3) {}
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
                  if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) {
                    break label1514;
                  }
                  i = 150;
                }
              }
              label1555:
              for (;;)
              {
                localObject1 = asyj.a(paramQQAppInterface.getApp(), i);
                localExtensionInfo.intimate_type = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int;
                localExtensionInfo.intimate_level = k;
                localajxl.a(localExtensionInfo);
                i = asxg.a(localacvt);
                a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int, k, paramakqm, 2097153, i);
                ((aqkh)localObject4).notifyUI(3, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString, Integer.valueOf(localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Upgrade intimate_type:" + localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                break;
                label1514:
                if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 2)
                {
                  i = 158;
                }
                else
                {
                  i = j;
                  if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 3)
                  {
                    i = 154;
                    continue;
                    i = j;
                    if (k == 2) {
                      if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 1)
                      {
                        i = 151;
                      }
                      else if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 2)
                      {
                        i = 159;
                      }
                      else
                      {
                        i = j;
                        if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 3) {
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
              if (!a(localacvt.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localacvt.jdField_b_of_type_Acvw == null) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localacvt.jdField_a_of_type_Acvw == null) {
                break label327;
              }
              if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c > 0L)) {
                localExtensionInfo.last_intimate_chatTime = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c;
              }
              k = localacvt.jdField_b_of_type_Acvw.a();
              m = localacvt.jdField_a_of_type_Acvw.a();
              if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 2))
              {
                localObject1 = localObject3;
                if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 3) {}
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
                  if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) {
                    break label1991;
                  }
                  i = 152;
                }
              }
              for (;;)
              {
                localObject1 = asyj.a(paramQQAppInterface.getApp(), i);
                localExtensionInfo.intimate_type = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int;
                localExtensionInfo.intimate_level = k;
                localajxl.a(localExtensionInfo);
                a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int, k, paramakqm, 2097154, 0);
                ((aqkh)localObject4).notifyUI(3, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString, Integer.valueOf(localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int), Integer.valueOf(m), Integer.valueOf(k) });
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                if (!QLog.isColorLevel()) {
                  break;
                }
                QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Downgrade intimate_type:" + localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int + " intimate_level:" + k + " old_intimate_level:" + m);
                paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                break;
                label1991:
                if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 2)
                {
                  i = 160;
                }
                else
                {
                  i = j;
                  if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 3)
                  {
                    i = 156;
                    continue;
                    label2032:
                    i = j;
                    if (m == 2) {
                      if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 1)
                      {
                        i = 153;
                      }
                      else if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 2)
                      {
                        i = 161;
                      }
                      else
                      {
                        i = j;
                        if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int == 3) {
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
              if (!a(localacvt.jdField_a_of_type_JavaLangString)) {
                break label327;
              }
              paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
              if (localacvt.jdField_b_of_type_Acvw == null) {
                break label327;
              }
              if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 0) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy != null)) {
                if ((!TextUtils.isEmpty(localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_a_of_type_JavaLangString)) && (!asxm.a(paramQQAppInterface)))
                {
                  localObject2 = asyj.a(paramQQAppInterface, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.jdField_a_of_type_JavaLangString, bbcz.m(paramQQAppInterface, localacvt.jdField_b_of_type_JavaLangString), localajxl);
                  localObject3 = asyj.a(paramQQAppInterface, (String)((List)localObject2).get(0), localacvt.jdField_b_of_type_JavaLangString);
                  paramRelationalChainChange = (String)((List)localObject3).get(0);
                  ((List)localObject2).remove(0);
                  ((List)localObject3).remove(0);
                  paramakqm = new aqvb(localacvt.jdField_b_of_type_JavaLangString, localacvt.jdField_b_of_type_JavaLangString, paramRelationalChainChange, 0, -5020, 2097153, awzy.a());
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
                          paramakqm.a(j, str.length() + j, localBundle);
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
                    Collections.sort((List)localObject2, new asyh());
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
                    paramakqm.a(m, i, localBundle);
                    if (QLog.isColorLevel()) {
                      QLog.d("FriendIntimateRelationshipHelper", 2, "spanPos=" + m + " fromIndex=" + i);
                    }
                  }
                  break label2577;
                  break label2563;
                  localObject2 = new MessageForUniteGrayTip();
                  ((MessageForUniteGrayTip)localObject2).hasRead = 0;
                  ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, paramakqm);
                  paramakqm = new StringBuilder(21);
                  paramakqm.append(l1).append("_").append(l2);
                  ((MessageForUniteGrayTip)localObject2).tipParam.d = paramakqm.toString();
                  paramakqm = paramQQAppInterface.a().b(localacvt.jdField_b_of_type_JavaLangString, 0);
                  if ((paramakqm != null) && (!paramakqm.isEmpty()))
                  {
                    paramakqm = (MessageRecord)paramakqm.get(paramakqm.size() - 1);
                    if (((paramakqm instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)paramakqm).tipParam != null) && (((MessageForUniteGrayTip)paramakqm).subType == ((MessageForUniteGrayTip)localObject2).subType) && (((MessageForUniteGrayTip)paramakqm).tipParam.c.equals(((MessageForUniteGrayTip)localObject2).tipParam.c)) && (((MessageForUniteGrayTip)localObject2).tipParam.jdField_a_of_type_Long - ((MessageForUniteGrayTip)paramakqm).tipParam.jdField_a_of_type_Long <= 1L))
                    {
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                      QLog.d("FriendReactive", 2, "addHotFriendAIOGray look! backend give repeat push!");
                      return;
                    }
                  }
                  if (!TextUtils.isEmpty(paramRelationalChainChange)) {
                    aqvc.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
                  }
                  localExtensionInfo.intimate_level = localacvt.jdField_b_of_type_Acvw.a();
                  if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c > 0L) {
                    localExtensionInfo.last_intimate_chatTime = localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Acvy.c;
                  }
                  localajxl.a(localExtensionInfo);
                  paramRelationalChainChange = new ArrayList();
                  paramRelationalChainChange.add(localacvt.jdField_b_of_type_JavaLangString);
                  paramQQAppInterface.a(1).notifyUI(107, true, paramRelationalChainChange);
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Egalitarian_Soon intimate_type:" + localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int + " intimate_level:" + localacvt.jdField_b_of_type_Acvw.a());
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  break label327;
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a()) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a(localacvt.jdField_a_of_type_JavaLangString)) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (localacvt.jdField_b_of_type_Acvw == null) {
                    break label327;
                  }
                  if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 2))
                  {
                    localObject1 = localBundle;
                    if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 3) {}
                  }
                  else
                  {
                    localExtensionInfo.isExtinguish = false;
                    localajxl.a(localExtensionInfo);
                    localObject1 = asyj.a(paramQQAppInterface.getApp(), 167);
                    a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int, localacvt.jdField_b_of_type_Acvw.a(), paramakqm, 2097153, 0);
                    ((aqkh)localObject4).notifyUI(3, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString, Integer.valueOf(localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int), Integer.valueOf(localacvt.jdField_b_of_type_Acvw.a()), Integer.valueOf(localacvt.jdField_b_of_type_Acvw.a()) });
                    ((FriendListHandler)paramQQAppInterface.a(1)).notifyUI(3, true, localacvt.jdField_b_of_type_JavaLangString);
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Light intimate_type:" + localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int + " intimate_level:" + localacvt.jdField_b_of_type_Acvw.a());
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  break label327;
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a()) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!a(localacvt.jdField_a_of_type_JavaLangString)) {
                    break label327;
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (localacvt.jdField_b_of_type_Acvw == null) {
                    break label327;
                  }
                  if ((localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 1) && (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 2))
                  {
                    localObject1 = str;
                    if (localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int != 3) {}
                  }
                  else
                  {
                    localExtensionInfo.isExtinguish = true;
                    localajxl.a(localExtensionInfo);
                    localObject1 = asyj.a(paramQQAppInterface.getApp(), 166);
                    a(paramQQAppInterface, localajxl, localacvt.jdField_b_of_type_JavaLangString, (String)localObject1, localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int, localacvt.jdField_b_of_type_Acvw.a(), paramakqm, 2097154, 0);
                    ((aqkh)localObject4).notifyUI(3, true, new Object[] { localacvt.jdField_b_of_type_JavaLangString, Integer.valueOf(localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int), Integer.valueOf(localacvt.jdField_b_of_type_Acvw.a()), Integer.valueOf(localacvt.jdField_b_of_type_Acvw.a()) });
                    ((FriendListHandler)paramQQAppInterface.a(1)).notifyUI(3, true, localacvt.jdField_b_of_type_JavaLangString);
                  }
                  paramRelationalChainChange = (submsgtype0xc7.RelationalChainChange)localObject1;
                  if (!QLog.isColorLevel()) {
                    break label327;
                  }
                  QLog.i("FriendIntimateRelationshipHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 Type_Icon_Extinguish intimate_type:" + localacvt.jdField_b_of_type_Acvw.jdField_a_of_type_Int + " intimate_level:" + localacvt.jdField_b_of_type_Acvw.a());
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
    ajxl localajxl = (ajxl)paramQQAppInterface.getManager(51);
    ExtensionInfo localExtensionInfo2 = localajxl.a(Long.toString(l));
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
        localajxl.a(localExtensionInfo1);
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
    b = amsj.a().jdField_a_of_type_Boolean;
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
    return amsj.a().J;
  }
  
  public static String b(int paramInt1, int paramInt2)
  {
    String str = "";
    amsi localamsi = amsj.a();
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
        str = localamsi.m;
      }
      else if (paramInt2 == 1)
      {
        str = localamsi.n;
      }
      else if (paramInt2 == 2)
      {
        str = localamsi.o;
        continue;
        if (paramInt2 == 0)
        {
          str = localamsi.p;
        }
        else if (paramInt2 == 1)
        {
          str = localamsi.q;
        }
        else if (paramInt2 == 2)
        {
          str = localamsi.r;
          continue;
          if (paramInt2 == 0) {
            str = localamsi.s;
          } else if (paramInt2 == 1) {
            str = localamsi.t;
          } else if (paramInt2 == 2) {
            str = localamsi.u;
          }
        }
      }
    }
  }
  
  public static String c(int paramInt1, int paramInt2)
  {
    String str = "";
    amsi localamsi = amsj.a();
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
      str = localamsi.v;
      continue;
      if (paramInt2 == 0)
      {
        str = localamsi.w;
      }
      else if (paramInt2 == 1)
      {
        str = localamsi.x;
      }
      else if (paramInt2 == 2)
      {
        str = localamsi.y;
        continue;
        if (paramInt2 == 0)
        {
          str = localamsi.z;
        }
        else if (paramInt2 == 1)
        {
          str = localamsi.A;
        }
        else if (paramInt2 == 2)
        {
          str = localamsi.B;
          continue;
          if (paramInt2 == 0) {
            str = localamsi.C;
          } else if (paramInt2 == 1) {
            str = localamsi.D;
          } else if (paramInt2 == 2) {
            str = localamsi.E;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asyg
 * JD-Core Version:    0.7.0.1
 */