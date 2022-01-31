import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.RelationalChainChange;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ToDegradeInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0xc7.submsgtype0xc7.ToDegradeItem;

public class ascj
{
  public static SpannableStringBuilder a(Context paramContext, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if ((TextUtils.isEmpty(paramSpannableStringBuilder)) || (paramContext == null)) {}
    do
    {
      return paramSpannableStringBuilder;
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "updateReactiveIconResource start:" + paramSpannableStringBuilder);
      }
      localObject1 = paramSpannableStringBuilder.toString();
      try
      {
        k = bajq.b(16.0F);
        localObject3 = asbg.a();
        localArrayList = new ArrayList();
        localObject2 = asbg.a((String)localObject1);
        if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
          break label638;
        }
        i = 0;
        localObject4 = ((ArrayList)localObject2).iterator();
      }
      catch (Throwable paramContext)
      {
        for (;;)
        {
          int k;
          Object localObject3;
          ArrayList localArrayList;
          int i;
          Object localObject4;
          Object localObject5;
          asbj localasbj;
          Object localObject2 = localObject1;
          localObject1 = paramContext;
          paramContext = (Context)localObject2;
          localObject2 = paramContext;
          if (QLog.isColorLevel())
          {
            QLog.d("ReactivePushHelper", 2, "updateReactiveIconResource exception:" + localObject1);
            localObject2 = paramContext;
            continue;
            break label641;
          }
        }
      }
      if (((Iterator)localObject4).hasNext())
      {
        localObject5 = (asbi)((Iterator)localObject4).next();
        if (TextUtils.isEmpty(((asbi)localObject5).jdField_b_of_type_JavaLangString)) {
          break label635;
        }
        localasbj = new asbj(paramContext, 0, ((asbi)localObject5).jdField_b_of_type_JavaLangString, bajq.b(16.0F), null);
        localObject2 = "[icon]";
        if (!TextUtils.isEmpty(((asbi)localObject5).c)) {
          localObject2 = ((asbi)localObject5).c;
        }
        ((asbi)localObject5).jdField_a_of_type_Int += i;
        ((asbi)localObject5).jdField_b_of_type_Int += i;
        paramSpannableStringBuilder.replace(((asbi)localObject5).jdField_a_of_type_Int, ((asbi)localObject5).jdField_b_of_type_Int, (CharSequence)localObject2);
        paramSpannableStringBuilder.setSpan(localasbj, ((asbi)localObject5).jdField_a_of_type_Int, ((asbi)localObject5).jdField_a_of_type_Int + ((String)localObject2).length(), 33);
        i = ((asbi)localObject5).jdField_a_of_type_Int + ((String)localObject2).length() - ((asbi)localObject5).jdField_b_of_type_Int + i;
        break label641;
      }
      localObject2 = paramSpannableStringBuilder.toString();
      localObject1 = localObject2;
      for (;;)
      {
        try
        {
          localObject2 = ((List)localObject3).iterator();
          if (!((Iterator)localObject2).hasNext()) {
            continue;
          }
          localObject3 = (String)((Iterator)localObject2).next();
          i = ((String)localObject1).indexOf((String)localObject3);
          if ((i == -1) || (i < 0)) {
            continue;
          }
          localObject4 = localArrayList.iterator();
          if (!((Iterator)localObject4).hasNext()) {
            continue;
          }
          localObject5 = (Pair)((Iterator)localObject4).next();
          if ((i < ((Integer)((Pair)localObject5).first).intValue()) || (i >= ((Integer)((Pair)localObject5).second).intValue())) {
            continue;
          }
          j = 1;
        }
        catch (Throwable localThrowable)
        {
          paramContext = (Context)localObject1;
          localObject1 = localThrowable;
          continue;
          int j = 0;
          continue;
        }
        if ((j == 0) && (asbg.b.containsKey(localObject3)))
        {
          localObject4 = (Integer)asbg.b.get(localObject3);
          if ((localObject4 != null) && (((Integer)localObject4).intValue() != 0))
          {
            localObject4 = paramContext.getResources().getDrawable(((Integer)localObject4).intValue());
            if (localObject4 != null)
            {
              ((Drawable)localObject4).setBounds(0, 0, k, k);
              paramSpannableStringBuilder.setSpan(new ImageSpan((Drawable)localObject4, 0), i, ((String)localObject3).length() + i, 33);
              localArrayList.add(new Pair(Integer.valueOf(i), Integer.valueOf(((String)localObject3).length() + i)));
            }
          }
        }
        i = ((String)localObject1).indexOf((String)localObject3, ((String)localObject3).length() + i);
      }
      localObject2 = localObject1;
    } while (!QLog.isColorLevel());
    QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource end:" + (String)localObject2);
    return paramSpannableStringBuilder;
  }
  
  public static SpannableStringBuilder a(Context paramContext, String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramContext == null)) {
      return null;
    }
    return a(paramContext, new SpannableStringBuilder(paramString));
  }
  
  private static String a(QQAppInterface paramQQAppInterface, String paramString, List<asck> paramList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    String str1 = "";
    int i = 1;
    int j = 0;
    label24:
    if (j < paramList.size())
    {
      int k = ((asck)paramList.get(j)).jdField_a_of_type_Int;
      int m = ((asck)paramList.get(j)).jdField_b_of_type_Int;
      if (!asav.a(paramQQAppInterface, k, m)) {
        break label260;
      }
      if (i == 0)
      {
        str1 = str1 + "、";
        label106:
        String str3 = asbg.a(k, m);
        String str2 = "#name_" + str3;
        str3 = "#icon_" + str3;
        str1 = str1 + str2 + str3;
      }
    }
    label260:
    for (;;)
    {
      j += 1;
      break label24;
      i = 0;
      break label106;
      paramString = paramString.replace("#icon", str1);
      paramQQAppInterface = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReactivePushHelper", 2, "buildToDegradeGrayTips strTips:" + paramString + " listsize:" + paramList.size());
      return paramString;
    }
  }
  
  private static String a(QQAppInterface paramQQAppInterface, List<asck> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "getDowngradeTipsTemplate list is null");
      }
      return null;
    }
    String str = ascd.a(paramQQAppInterface.getApp(), 134);
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "getDowngradeTipsTemplate:" + str);
    }
    return a(paramQQAppInterface, str, paramList);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource start:" + paramString);
    }
    paramString = paramString.replaceAll("[icon]", "");
    Iterator localIterator = asbg.a(paramString).iterator();
    while (localIterator.hasNext()) {
      paramString = paramString.replaceAll(((asbi)localIterator.next()).jdField_a_of_type_JavaLangString, "");
    }
    localIterator = asbg.a().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (paramString.contains(str)) {
        paramString = paramString.replaceAll(str, "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "removeReactiveIconResource end:" + paramString);
    }
    return paramString;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "saveShowNotificationTime, time:" + paramLong1 + " localtime:" + paramLong2 + " frienduin:" + paramString);
    }
    String str = "" + paramLong1 + "_" + paramLong2;
    baig.e(BaseApplicationImpl.getContext(), paramQQAppInterface.c(), str, paramString);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "saveShowTipsTime, time:" + paramLong + " frienduin:" + paramString);
    }
    baig.a(BaseApplicationImpl.getContext(), paramQQAppInterface.c(), paramString, paramLong);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, akcb paramakcb, int paramInt1, int paramInt2, long paramLong, String paramString4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReactivePushHelper", 2, "insertGrayTips uin:" + paramString1 + " grayTips:" + paramString2 + " nick:" + paramString3 + " lNotifyTime:" + paramLong);
    }
    if (TextUtils.isEmpty(paramString2)) {}
    long l;
    do
    {
      Object localObject;
      do
      {
        return;
        localObject = paramString2;
        if (paramString2.contains("#nick")) {
          localObject = paramString2.replaceAll("#nick", paramString3);
        }
        paramString3 = new StringBuilder((String)localObject);
        paramString2 = asba.a(paramQQAppInterface, paramString4, paramString3);
        paramString3 = paramString3.toString();
        paramString4 = new aqax(paramString4, paramString4, paramString3, 0, -5040, paramInt1, awao.a());
        localObject = new MessageForUniteGrayTip();
        ((MessageForUniteGrayTip)localObject).hasRead = 0;
        ((MessageForUniteGrayTip)localObject).subType = paramInt2;
        ((MessageForUniteGrayTip)localObject).initGrayTipMsg(paramQQAppInterface, paramString4);
        ((MessageForUniteGrayTip)localObject).tipParam.d = (paramString1 + "_reactive_" + paramakcb.b + "_" + paramLong);
        asba.a(paramQQAppInterface, paramString3, paramString4, paramString2);
        ((MessageForUniteGrayTip)localObject).saveExtInfoToExtStr("mutualmark_WillDowngradeSoon", "true");
        aqay.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject);
        awqx.b(paramQQAppInterface, "dc00898", "", "", "0X800A1BC", "0X800A1BC", 0, 0, "", "", "", "");
        l = System.currentTimeMillis() / 1000L;
      } while (!a(paramQQAppInterface, paramLong, l, "0"));
      paramString2 = paramQQAppInterface.a().a(((MessageForUniteGrayTip)localObject).frienduin, ((MessageForUniteGrayTip)localObject).istroop);
      paramQQAppInterface.a().c(paramString2);
      paramQQAppInterface.a(1, true, true);
      paramQQAppInterface.a().c(null);
      awqx.b(paramQQAppInterface, "dc00898", "", "", "0X800A1BE", "0X800A1BE", 1, 0, "", "", "", "");
      a(paramQQAppInterface, paramLong, l, "0");
    } while (!QLog.isColorLevel());
    QLog.d("ReactivePushHelper", 2, "ShowNotification, localtime:" + l + " servertime:" + paramLong + " frienduin:" + paramString1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, akcb paramakcb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReactivePushHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 app:" + paramQQAppInterface + "  changeInfo:" + paramRelationalChainChange + "  msginfo:" + paramakcb);
    }
    if ((paramQQAppInterface == null) || (paramRelationalChainChange == null) || (paramakcb == null)) {}
    String str;
    int i;
    ajjj localajjj;
    do
    {
      long l;
      do
      {
        return;
        l = paramRelationalChainChange.uint64_src_uin.get();
        str = String.valueOf(paramRelationalChainChange.uint64_dst_uin.get());
      } while ((!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), String.valueOf(l))) || (TextUtils.isEmpty(str)));
      i = paramRelationalChainChange.uint32_change_type.get();
      localajjj = (ajjj)paramQQAppInterface.getManager(51);
      Friends localFriends = localajjj.e(str);
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 friend:" + localFriends + " changeType:" + i);
      }
      if ((localFriends == null) || (localFriends.isFriend())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ReactivePushHelper", 2, "decodeC2CMsgPkgSubMsgType0xc7 is not friend");
    return;
    if (localajjj.a(str) == null) {
      new ExtensionInfo().uin = str;
    }
    switch (i)
    {
    case 1: 
    case 2: 
    case 3: 
    case 10002: 
    case 10003: 
    case 10004: 
    default: 
      return;
    }
    a(paramQQAppInterface, paramRelationalChainChange, str, paramakcb);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, submsgtype0xc7.RelationalChainChange paramRelationalChainChange, String paramString, akcb paramakcb)
  {
    if (paramRelationalChainChange.msg_to_degrade_info.has()) {}
    for (submsgtype0xc7.ToDegradeInfo localToDegradeInfo = (submsgtype0xc7.ToDegradeInfo)paramRelationalChainChange.msg_to_degrade_info.get(); localToDegradeInfo == null; localToDegradeInfo = null) {
      return;
    }
    if (localToDegradeInfo.bytes_nick.has())
    {
      paramRelationalChainChange = localToDegradeInfo.bytes_nick.get().toStringUtf8();
      label57:
      if (!localToDegradeInfo.notify_time.has()) {
        break label254;
      }
    }
    submsgtype0xc7.RelationalChainChange localRelationalChainChange;
    submsgtype0xc7.ToDegradeItem localToDegradeItem;
    label254:
    for (long l1 = localToDegradeInfo.notify_time.get();; l1 = 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "onWillDowngradeSoon, nick:" + paramRelationalChainChange + " notifytime:" + l1);
      }
      if (!a(paramQQAppInterface, l1, paramString)) {
        break;
      }
      localRelationalChainChange = paramRelationalChainChange;
      if (TextUtils.isEmpty(paramRelationalChainChange))
      {
        paramRelationalChainChange = babh.m(paramQQAppInterface, paramString);
        localRelationalChainChange = paramRelationalChainChange;
        if (QLog.isColorLevel())
        {
          QLog.d("ReactivePushHelper", 2, "onWillDowngradeSoon, local nick:" + paramRelationalChainChange);
          localRelationalChainChange = paramRelationalChainChange;
        }
      }
      if (!localToDegradeInfo.rpt_to_degrade_item.has()) {
        break;
      }
      paramRelationalChainChange = new ArrayList();
      int i = 0;
      for (;;)
      {
        if (i >= localToDegradeInfo.rpt_to_degrade_item.size()) {
          break label554;
        }
        localToDegradeItem = (submsgtype0xc7.ToDegradeItem)localToDegradeInfo.rpt_to_degrade_item.get(i);
        if (localToDegradeItem != null) {
          break;
        }
        i += 1;
      }
      paramRelationalChainChange = null;
      break label57;
    }
    if (localToDegradeItem.type.has()) {}
    for (int j = localToDegradeItem.type.get();; j = -1)
    {
      if (asbg.b(j)) {
        break label332;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("ReactivePushHelper", 2, "onWillDowngradeSoon, unkown type:" + j);
      break;
    }
    label332:
    int k;
    label353:
    int m;
    label374:
    int n;
    if (localToDegradeItem.old_level.has())
    {
      k = localToDegradeItem.old_level.get();
      if (!localToDegradeItem.new_level.has()) {
        break label536;
      }
      m = localToDegradeItem.new_level.get();
      if (!localToDegradeItem.continuity_days.has()) {
        break label542;
      }
      n = localToDegradeItem.continuity_days.get();
      label395:
      if (!localToDegradeItem.uint64_last_action_time.has()) {
        break label548;
      }
    }
    label536:
    label542:
    label548:
    for (long l2 = localToDegradeItem.uint64_last_action_time.get();; l2 = 0L)
    {
      paramRelationalChainChange.add(new asck(j, k, m, n, l2));
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ReactivePushHelper", 2, "onWillDowngradeSoon: uin:" + paramString + " nType:" + j + " nOldLevel:" + k + " nNewLevel:" + m + " nContinuityDays:" + n + " lLastActionTime:" + l2);
      break;
      k = 0;
      break label353;
      m = 0;
      break label374;
      n = 0;
      break label395;
    }
    label554:
    paramRelationalChainChange = a(paramQQAppInterface, paramRelationalChainChange);
    if ((!TextUtils.isEmpty(paramRelationalChainChange)) && (!asbg.a(paramQQAppInterface))) {
      a(paramQQAppInterface, paramString, paramRelationalChainChange, localRelationalChainChange, paramakcb, 2097155, 0, l1, paramString);
    }
    a(paramQQAppInterface, l1, paramString);
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, String paramString)
  {
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    if (paramQQAppInterface == null) {}
    long l;
    do
    {
      return false;
      l = baig.a(BaseApplicationImpl.getContext(), paramQQAppInterface.c(), paramString);
      if (QLog.isColorLevel()) {
        QLog.d("ReactivePushHelper", 2, "needShowTips, LastTime:" + l + " servertime:" + paramLong + " frienduin:" + paramString);
      }
      if (l == 0L) {
        return true;
      }
    } while (paramLong == l);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    if ((paramMessage == null) || (paramQQAppInterface == null)) {
      return false;
    }
    if (paramMessage.msgtype != -5040) {
      return false;
    }
    try
    {
      paramQQAppInterface = (MessageForUniteGrayTip)paramQQAppInterface.a().b(paramMessage.frienduin, paramMessage.istroop, paramMessage.uniseq);
      if (paramQQAppInterface == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "query msg, msg is null");
        }
        return false;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "query msg exception:" + paramQQAppInterface.toString());
        }
        paramQQAppInterface = null;
      }
      if ((paramQQAppInterface.tipParam != null) && (asbg.b(paramQQAppInterface.tipParam.jdField_b_of_type_Int)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ReactivePushHelper", 2, "isReactivePushTips : true");
        }
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ascj
 * JD-Core Version:    0.7.0.1
 */