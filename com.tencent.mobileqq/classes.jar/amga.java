import Wallet.AcsMsg;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.1;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.2;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.3;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.4;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager.5;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgBody;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class amga
  extends Observable
  implements Manager
{
  public int a;
  private long jdField_a_of_type_Long;
  private aeom jdField_a_of_type_Aeom;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ActivateFriendsManager.1(this);
  Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private volatile Set<Long> jdField_b_of_type_JavaUtilSet;
  private int jdField_c_of_type_Int = 2;
  private long jdField_c_of_type_Long;
  private volatile Set<Long> jdField_c_of_type_JavaUtilSet;
  private int jdField_d_of_type_Int = 3;
  private long jdField_d_of_type_Long;
  private volatile Set<Long> jdField_d_of_type_JavaUtilSet;
  private int jdField_e_of_type_Int = -2147483648;
  private volatile Set<Long> jdField_e_of_type_JavaUtilSet;
  
  public amga(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences("pref_act_frd" + paramQQAppInterface.getCurrentAccountUin(), 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_stamp", 0L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_memorial_check_stamp", 0L);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_interval", 120000L);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_memorial_check_interval", 120000L);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_Aeom = new aeom(paramQQAppInterface);
    aeol.a(paramQQAppInterface);
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      int i = localMsgBody.uint32_msg_type.get();
      return i;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", paramArrayOfByte);
      }
    }
    return 1;
  }
  
  public static String a(Context paramContext)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131689882;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131689887;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131689886;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131689880;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131689879;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131689884;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131689883;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131689878;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131689881;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131689885;
    tmp54_48;
    return paramContext.getString(arrayOfInt[new java.util.Random().nextInt(arrayOfInt.length)]);
  }
  
  public static String a(Context paramContext, SubMsgType0x76.MsgBody paramMsgBody)
  {
    String str2 = paramMsgBody.bytes_notify_wording.get().toStringUtf8();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramMsgBody.uint32_msg_type.get() != 1) {
        break label63;
      }
      str1 = String.format(paramContext.getString(2131689875), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
    }
    label63:
    do
    {
      return str1;
      if (paramMsgBody.uint32_msg_type.get() == 2) {
        return paramContext.getString(2131689873);
      }
      str1 = str2;
    } while (paramMsgBody.uint32_msg_type.get() != 3);
    return paramContext.getString(2131689877);
  }
  
  private Set<Long> a(int paramInt)
  {
    Object localObject1 = null;
    if (paramInt == 1) {
      localObject1 = this.jdField_b_of_type_JavaUtilSet;
    }
    Object localObject2;
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break label190;
      }
      localObject2 = new HashSet(6);
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_uin_sended_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinSendedSet, str = " + (String)localObject1 + ", msgType = " + paramInt);
      }
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        CharSequence localCharSequence = localObject1[i];
        if (!TextUtils.isEmpty(localCharSequence)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        i += 1;
      }
      if (paramInt == 2) {
        localObject1 = this.jdField_c_of_type_JavaUtilSet;
      }
    }
    if (paramInt == 1)
    {
      this.jdField_b_of_type_JavaUtilSet = ((Set)localObject2);
      label190:
      return localObject2;
    }
    this.jdField_c_of_type_JavaUtilSet = ((Set)localObject2);
    return localObject2;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, submsgtype0xeb.MsgBody paramMsgBody)
  {
    if (paramMsgBody == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder(1024);
    if (QLog.isColorLevel()) {
      localStringBuilder.append("activiate_friends|onReceiveReadedActivateFriendsPush|");
    }
    int j = 0;
    Object localObject1 = paramQQAppInterface.a().b(alof.ad, 9002);
    HashSet localHashSet = new HashSet(((List)localObject1).size());
    if (QLog.isColorLevel()) {
      localStringBuilder.append(null).append("get unread msgs|");
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (MessageRecord)((Iterator)localObject1).next();
      if (!((MessageRecord)localObject2).isread)
      {
        localObject2 = ((MessageRecord)localObject2).getExtInfoFromExtStr("key_msg_ext_msg_seq");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localHashSet.add(localObject2);
          if (QLog.isColorLevel()) {
            localStringBuilder.append((String)localObject2).append("|");
          }
        }
      }
    }
    int i;
    if (paramMsgBody.rpt_msg_info.has())
    {
      paramMsgBody = paramMsgBody.rpt_msg_info.get().iterator();
      for (;;)
      {
        if (paramMsgBody.hasNext())
        {
          localObject1 = Integer.toString(((submsgtype0xeb.MsgInfo)paramMsgBody.next()).uint32_msg_seq.get());
          if (localHashSet.contains(localObject1))
          {
            j = 1;
            i = j;
            if (QLog.isColorLevel())
            {
              localStringBuilder.append("we have ").append((String)localObject1).append(" in unread msgs|");
              i = j;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramQQAppInterface.a().c(alof.ad, 9002);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("ActivateFriends.Manager", 2, localStringBuilder.toString());
      return;
      i = j;
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("rpt_msg_info is null|");
        i = j;
        continue;
        i = 0;
      }
    }
  }
  
  private Set<Long> b(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.jdField_d_of_type_JavaUtilSet != null) {
        return this.jdField_d_of_type_JavaUtilSet;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_uin_wished_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + (String)localObject + ", type = " + paramInt);
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CharSequence localCharSequence = localObject[paramInt];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        paramInt += 1;
      }
      this.jdField_d_of_type_JavaUtilSet = localHashSet;
    }
    return this.jdField_d_of_type_JavaUtilSet;
  }
  
  private Set<Long> c(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.jdField_e_of_type_JavaUtilSet != null) {
        return this.jdField_e_of_type_JavaUtilSet;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_uin_expired_" + paramInt, "");
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "getUinWishedSet, str = " + (String)localObject + ", type = " + paramInt);
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        CharSequence localCharSequence = localObject[paramInt];
        if (!TextUtils.isEmpty(localCharSequence)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localCharSequence)));
        }
        paramInt += 1;
      }
      this.jdField_e_of_type_JavaUtilSet = localHashSet;
    }
    return this.jdField_e_of_type_JavaUtilSet;
  }
  
  String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (paramString.length() <= 3);
    return paramString.substring(paramString.length() - 3, paramString.length());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(int paramInt)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "onReceivePushMessage  msgType = " + paramInt);
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, "").commit();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_wished_" + paramInt, "").commit();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_expired_" + paramInt, "").commit();
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
    }
    for (;;)
    {
      if ((paramInt == 2) || (paramInt == 3))
      {
        if (paramInt == 2) {
          i = 1;
        }
        LpReportInfo_pf00064.allReport(220, 1, i);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_birth_msg_stamp", ayzl.a()).commit();
        ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.4(this));
      }
      return;
      if (paramInt == 2) {
        this.jdField_c_of_type_JavaUtilSet = new HashSet();
      }
    }
  }
  
  public void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    a(paramInt, paramArrayOfLong1, paramArrayOfLong2, paramString, -1);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString, int paramInt2)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessages | uin = ");
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0)) {
        break label120;
      }
      localStringBuilder.append("null");
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0)) {
        break label166;
      }
      localStringBuilder.append("null");
    }
    for (;;)
    {
      localStringBuilder.append(" | giftId = ").append(paramInt2);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.3(this, paramInt1, paramArrayOfLong1, paramString, paramInt2, paramArrayOfLong2));
      return;
      label120:
      int k = paramArrayOfLong1.length;
      int i = 0;
      while (i < k)
      {
        localStringBuilder.append(a(String.valueOf(paramArrayOfLong1[i]))).append(",");
        i += 1;
      }
      break;
      label166:
      k = paramArrayOfLong2.length;
      i = j;
      while (i < k)
      {
        localStringBuilder.append(paramArrayOfLong2[i]).append(",");
        i += 1;
      }
    }
  }
  
  void a(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 120000L) {
      l = 120000L;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Long = l;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", l).commit();
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "saveBirthdayCheckInStamp=" + this.jdField_b_of_type_Long);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(paramString2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true).apply();
      MessageForText localMessageForText = new MessageForText();
      localMessageForText.selfuin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localMessageForText.frienduin = alof.ad;
      localMessageForText.istroop = 9002;
      localMessageForText.senderuin = "";
      localMessageForText.time = NetConnInfoCenter.getServerTime();
      localMessageForText.msg = paramString1;
      localMessageForText.uniseq = paramString2.hashCode();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "---doNotifaction---" + paramString2 + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "---uniseq: " + localMessageForText.uniseq);
      }
      paramString1 = new ArrayList();
      paramString1.add(localMessageForText);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isBackground_Stop);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.D();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "do report : QQnotice.list.show");
      }
      azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "QQnotice", "", "", "QQnotice.list.show", 0, 0, "", "", paramString2, "");
      return;
    }
    catch (Throwable paramString1)
    {
      QLog.e("ActivateFriends.Manager", 1, "doNotifaction throw an exception: " + paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (paramLong > NetConnInfoCenter.getServerTime())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "has not arrive noticetime, set AlarmMangaer first!");
      }
      aeoj localaeoj = (aeoj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(321);
      if (localaeoj != null)
      {
        AcsMsg localAcsMsg = new AcsMsg();
        localAcsMsg.msg_id = paramString2;
        localAcsMsg.notice_time = paramLong;
        localAcsMsg.title = paramString1;
        localaeoj.a(localAcsMsg);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "has arrive noticetime, doNotifaction!");
    }
    a(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).l(paramBoolean1);
      return;
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695398) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramBoolean1).commit();
  }
  
  public void a(long[] paramArrayOfLong, int paramInt)
  {
    HashSet localHashSet = new HashSet(6);
    localHashSet.addAll(a(paramInt));
    int j = localHashSet.size();
    int k = paramArrayOfLong.length;
    int i = 0;
    while (i < k)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong[i]));
      i += 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localHashSet.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((Long)localIterator.next()).append("-");
    }
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("key_uin_sended_" + paramInt, localStringBuilder.toString()).commit();
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilSet = localHashSet;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "onSendTimingMsgSuc, send count = " + paramArrayOfLong.length + ", orginal count = " + j + ", new count = " + localHashSet.size());
      }
      return;
      this.jdField_c_of_type_JavaUtilSet = localHashSet;
    }
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_e_of_type_Int == paramInt) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_e_of_type_Int = paramInt;
      return bool;
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    return a(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).w();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695398) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = localMsgBody.bool_strong_notify.get();
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "shouldMsgTips | " + bool);
      }
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "IsMessageTipsInBackground catch error.", paramArrayOfByte);
      }
    }
    return false;
  }
  
  public void b()
  {
    ActivateFriendsManager.2 local2 = new ActivateFriendsManager.2(this);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.getSubThreadHandler().post(local2);
      return;
    }
    local2.run();
  }
  
  void b(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 120000L) {
      l = 120000L;
    }
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_d_of_type_Long = l;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_memorial_check_stamp", System.currentTimeMillis()).putLong("key_memorial_check_interval", l).commit();
    if (QLog.isColorLevel()) {
      QLog.d("ActivateFriends.Manager", 2, "saveMemorialCheckInStamp=" + this.jdField_d_of_type_Long);
    }
  }
  
  public boolean b(long paramLong, int paramInt)
  {
    if ((b(paramInt) == null) || (b(paramInt).size() == 0)) {
      return false;
    }
    return b(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean) {
      ((alpk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).w();
    }
    return this.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131695398) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false);
  }
  
  public boolean b(byte[] arg1)
  {
    int i = a(???);
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilSet)
      {
        if (!this.jdField_a_of_type_JavaUtilSet.contains(Integer.valueOf(i)))
        {
          bool = true;
          this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(i));
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Int = this.jdField_c_of_type_Int;
    amfz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, true, false, true);
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    if ((c(paramInt) == null) || (c(paramInt).size() == 0)) {
      return false;
    }
    return c(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
  }
  
  public void e()
  {
    ThreadManagerV2.excute(new ActivateFriendsManager.5(this), 16, null, true);
    try
    {
      str1 = aeno.a(NetConnInfoCenter.getServerTimeMillis(), "yyyyMMdd");
      if (QLog.isColorLevel()) {
        QLog.i("ActivateFriends.Manager", 2, "do login currenDayTimeStapStr: " + str1);
      }
      str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("sp_key_fetch_reminder_list_time", "");
      if (QLog.isColorLevel()) {
        QLog.i("ActivateFriends.Manager", 2, "do login cacheCurrenDayTimeStapStr: " + str2);
      }
    }
    catch (Throwable localThrowable)
    {
      String str1;
      String str2;
      long l2;
      label163:
      QLog.e("ActivateFriends.Manager", 1, "checkTodayReminder throw an exception: " + localThrowable);
    }
    try
    {
      l2 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()) % 3600L * 1000L;
      l1 = l2;
      if (QLog.isColorLevel())
      {
        QLog.i("ActivateFriends.Manager", 2, "do login delay: " + l2);
        l1 = l2;
      }
    }
    catch (Exception localException)
    {
      l1 = 0L;
      break label163;
    }
    l2 = NetConnInfoCenter.getServerTimeMillis();
    l1 += aeno.a(NetConnInfoCenter.getServerTimeMillis());
    if (QLog.isColorLevel()) {
      QLog.i("ActivateFriends.Manager", 2, "do login currentDelayTs: " + aeno.a(l1, "yyyy-MM-dd HH:mm:ss"));
    }
    if ((str1.equals(str2)) || (l2 < l1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ActivateFriends.Manager", 2, "already fetch today's data");
      }
    }
    else
    {
      this.jdField_a_of_type_Aeom.a(str1, new amgb(this, str1));
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    aeol.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amga
 * JD-Core Version:    0.7.0.1
 */