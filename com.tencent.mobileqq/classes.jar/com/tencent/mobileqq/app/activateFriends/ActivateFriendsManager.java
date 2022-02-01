package com.tencent.mobileqq.app.activateFriends;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver;
import com.tencent.mobileqq.activity.activateFriend.biz.QQReminderSwitchObserver.QQReminderSwitchListener;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgBody;
import tencent.im.c2c.msgtype0x210.submsgtype0xeb.submsgtype0xeb.MsgInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.GeoGraphicNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x76.SubMsgType0x76.MsgBody;

public class ActivateFriendsManager
  extends Observable
  implements Manager
{
  public int a;
  private long jdField_a_of_type_Long;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQReminderSwitchObserver jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver;
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
  
  public ActivateFriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_act_frd");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.jdField_a_of_type_AndroidContentSharedPreferences = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_stamp", 0L);
    this.jdField_c_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_memorial_check_stamp", 0L);
    this.jdField_b_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_check_interval", 120000L);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_AndroidContentSharedPreferences.getLong("key_memorial_check_interval", 120000L);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver = new QQReminderSwitchObserver();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(MessageCache.a() * 1000L);
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(6);
    ((Calendar)localObject).add(6, 1);
    int m = ((Calendar)localObject).get(6);
    localObject = new GregorianCalendar();
    ((GregorianCalendar)localObject).set(5, paramInt3);
    ((GregorianCalendar)localObject).set(2, paramInt2 - 1);
    ((GregorianCalendar)localObject).set(1, paramInt1);
    paramInt3 = ((GregorianCalendar)localObject).get(6);
    if (i == paramInt1)
    {
      if (paramInt3 < k) {
        return 0;
      }
      if (paramInt3 == k) {
        return 1;
      }
      if (paramInt3 == m) {
        return 2;
      }
      return 3;
    }
    if (paramInt1 > i)
    {
      if ((paramInt1 == i + 1) && (j + 1 - 0 == 12) && (paramInt2 == 1) && (m == paramInt3)) {
        return 2;
      }
      return 3;
    }
    return 0;
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
    tmp6_5[0] = 2131689774;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131689779;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131689778;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131689772;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131689771;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131689776;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131689775;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131689770;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131689773;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131689777;
    tmp54_48;
    return paramContext.getString(arrayOfInt[new java.util.Random().nextInt(arrayOfInt.length)]);
  }
  
  public static String a(Context paramContext, SubMsgType0x76.MsgBody paramMsgBody)
  {
    String str2 = paramMsgBody.bytes_notify_wording.get().toStringUtf8();
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramMsgBody.uint32_msg_type.get() == 1) {
        return String.format(paramContext.getString(2131689767), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
      }
      if (paramMsgBody.uint32_msg_type.get() == 2) {
        return paramContext.getString(2131689765);
      }
      str1 = str2;
      if (paramMsgBody.uint32_msg_type.get() == 3) {
        str1 = paramContext.getString(2131689769);
      }
    }
    return str1;
  }
  
  private Set<Long> a(int paramInt)
  {
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = this.jdField_b_of_type_JavaUtilSet;
    } else if (paramInt == 2) {
      localObject1 = this.jdField_c_of_type_JavaUtilSet;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new HashSet(6);
      localObject1 = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_uin_sended_");
      localStringBuilder.append(paramInt);
      localObject1 = ((SharedPreferences)localObject1).getString(localStringBuilder.toString(), "");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUinSendedSet, str = ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(", msgType = ");
        localStringBuilder.append(paramInt);
        QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      }
      localObject1 = ((String)localObject1).split("-");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder = localObject1[i];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localStringBuilder)));
        }
        i += 1;
      }
      if (paramInt == 1)
      {
        this.jdField_b_of_type_JavaUtilSet = ((Set)localObject2);
        return localObject2;
      }
      this.jdField_c_of_type_JavaUtilSet = ((Set)localObject2);
    }
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
    Object localObject1 = paramQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
    HashSet localHashSet = new HashSet(((List)localObject1).size());
    if (QLog.isColorLevel())
    {
      localStringBuilder.append(null);
      localStringBuilder.append("get unread msgs|");
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
          if (QLog.isColorLevel())
          {
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append("|");
          }
        }
      }
    }
    int i;
    if (paramMsgBody.rpt_msg_info.has())
    {
      paramMsgBody = paramMsgBody.rpt_msg_info.get().iterator();
      do
      {
        i = j;
        if (!paramMsgBody.hasNext()) {
          break;
        }
        localObject1 = Integer.toString(((submsgtype0xeb.MsgInfo)paramMsgBody.next()).uint32_msg_seq.get());
      } while (!localHashSet.contains(localObject1));
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("we have ");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" in unread msgs|");
      }
      i = 1;
    }
    else
    {
      i = j;
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("rpt_msg_info is null|");
        i = j;
      }
    }
    if (i != 0) {
      paramQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ActivateFriends.Manager", 2, localStringBuilder.toString());
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
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_uin_wished_");
      localStringBuilder.append(paramInt);
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUinWishedSet, str = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", type = ");
        localStringBuilder.append(paramInt);
        QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localStringBuilder = localObject[paramInt];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localStringBuilder)));
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
      Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_uin_expired_");
      localStringBuilder.append(paramInt);
      localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUinWishedSet, str = ");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(", type = ");
        localStringBuilder.append(paramInt);
        QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
      }
      localObject = ((String)localObject).split("-");
      int i = localObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        localStringBuilder = localObject[paramInt];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localStringBuilder)));
        }
        paramInt += 1;
      }
      this.jdField_e_of_type_JavaUtilSet = localHashSet;
    }
    return this.jdField_e_of_type_JavaUtilSet;
  }
  
  String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramString.length() <= 3) {
      return paramString;
    }
    return paramString.substring(paramString.length() - 3, paramString.length());
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 60000L);
  }
  
  public void a(int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePushMessage  msgType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_sended_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_wished_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_expired_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
    } else if (paramInt == 2) {
      this.jdField_c_of_type_JavaUtilSet = new HashSet();
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      if (paramInt == 2) {
        i = 1;
      }
      LpReportInfo_pf00064.allReport(220, 1, i);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("key_last_birth_msg_stamp", MessageCache.a()).commit();
      ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.4(this));
    }
  }
  
  public void a(int paramInt, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString)
  {
    a(paramInt, paramArrayOfLong1, paramArrayOfLong2, paramString, -1);
  }
  
  public void a(int paramInt1, long[] paramArrayOfLong1, long[] paramArrayOfLong2, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessages | uin = ");
      int j = 0;
      int k;
      int i;
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0))
      {
        k = paramArrayOfLong1.length;
        i = 0;
      }
      while (i < k)
      {
        localStringBuilder.append(a(String.valueOf(paramArrayOfLong1[i])));
        localStringBuilder.append(",");
        i += 1;
        continue;
        localStringBuilder.append("null");
      }
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0))
      {
        k = paramArrayOfLong2.length;
        i = j;
      }
      while (i < k)
      {
        localStringBuilder.append(paramArrayOfLong2[i]);
        localStringBuilder.append(",");
        i += 1;
        continue;
        localStringBuilder.append("null");
      }
      localStringBuilder.append(" | giftId = ");
      localStringBuilder.append(paramInt2);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ActivateFriendsManager.3(this, paramInt1, paramArrayOfLong1, paramString, paramInt2, paramArrayOfLong2));
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveBirthdayCheckInStamp=");
      localStringBuilder.append(this.jdField_b_of_type_Long);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, Map<Long, Integer> paramMap, int paramInt)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(Long.toString(paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("currentUin:");
        paramMap.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramMap.append(" do not equals to QzoneUin");
        paramMap.append(Long.toString(paramLong));
        QLog.d("ActivateFriends.Manager", 2, paramMap.toString());
      }
      return;
    }
    if ((paramMap != null) && (paramMap.size() != 0) && (paramInt == 2))
    {
      HashSet localHashSet = new HashSet(6);
      Object localObject1 = new HashSet(6);
      if ((b(paramInt) != null) && (b(paramInt).size() != 0)) {
        localHashSet.addAll(b(paramInt));
      }
      int i = localHashSet.size();
      Object localObject2 = paramMap.entrySet();
      StringBuilder localStringBuilder1 = new StringBuilder("QZone FriendUin :");
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (Long)((Map.Entry)localObject4).getKey();
        localObject4 = (Integer)((Map.Entry)localObject4).getValue();
        StringBuilder localStringBuilder2;
        if ((localObject3 != null) && (((Integer)localObject4).intValue() == 1))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(Long.toString(((Long)localObject3).longValue()));
          localStringBuilder2.append("_");
          localStringBuilder2.append(localObject4);
          localStringBuilder2.append("|");
          localStringBuilder1.append(localStringBuilder2.toString());
          localHashSet.add(localObject3);
        }
        else if ((localObject3 != null) && (((Integer)localObject4).intValue() == 2))
        {
          localStringBuilder2 = new StringBuilder();
          localStringBuilder2.append(Long.toString(((Long)localObject3).longValue()));
          localStringBuilder2.append("_");
          localStringBuilder2.append(localObject4);
          localStringBuilder2.append("|");
          localStringBuilder1.append(localStringBuilder2.toString());
          ((Set)localObject1).add(localObject3);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, localStringBuilder1.toString());
      }
      localObject2 = new StringBuilder();
      localStringBuilder1 = new StringBuilder();
      Object localObject3 = localHashSet.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((StringBuilder)localObject2).append((Long)((Iterator)localObject3).next());
        ((StringBuilder)localObject2).append("-");
      }
      localObject3 = ((Set)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localStringBuilder1.append((Long)((Iterator)localObject3).next());
        localStringBuilder1.append("-");
      }
      localObject3 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_uin_wished_");
      ((StringBuilder)localObject4).append(paramInt);
      ((SharedPreferences.Editor)localObject3).putString(((StringBuilder)localObject4).toString(), ((StringBuilder)localObject2).toString()).commit();
      localObject2 = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("key_uin_expired_");
      ((StringBuilder)localObject3).append(paramInt);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), localStringBuilder1.toString()).commit();
      this.jdField_d_of_type_JavaUtilSet = localHashSet;
      this.jdField_e_of_type_JavaUtilSet = ((Set)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WishedFriends count = ");
        ((StringBuilder)localObject1).append(paramMap.size());
        ((StringBuilder)localObject1).append(", orginal count = ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(", new count = ");
        ((StringBuilder)localObject1).append(localHashSet.size());
        QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> paramWeakReference)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver.a(paramWeakReference);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("ActivateFriends.Manager", 2, new Object[] { "isOpen: ", Boolean.valueOf(paramBoolean1), " isRemote: ", Boolean.valueOf(paramBoolean2) });
      QLog.d("ActivateFriends.Manager", 2, "stack:", new Throwable());
    }
    if (paramBoolean2)
    {
      ((CardHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).l(paramBoolean1);
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694948));
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
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
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder1.append((Long)((Iterator)localObject).next());
      localStringBuilder1.append("-");
    }
    localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("key_uin_sended_");
    localStringBuilder2.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
    if (paramInt == 1) {
      this.jdField_b_of_type_JavaUtilSet = localHashSet;
    } else {
      this.jdField_c_of_type_JavaUtilSet = localHashSet;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onSendTimingMsgSuc, send count = ");
      localStringBuilder1.append(paramArrayOfLong.length);
      localStringBuilder1.append(", orginal count = ");
      localStringBuilder1.append(j);
      localStringBuilder1.append(", new count = ");
      localStringBuilder1.append(localHashSet.size());
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder1.toString());
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool;
    if (this.jdField_e_of_type_Int == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_e_of_type_Int = paramInt;
    return bool;
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    return a(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getActivateFriendSwitch();
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694948));
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      boolean bool = localMsgBody.bool_strong_notify.get();
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("shouldMsgTips | ");
        paramArrayOfByte.append(bool);
        QLog.d("ActivateFriends.Manager", 2, paramArrayOfByte.toString());
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
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveMemorialCheckInStamp=");
      localStringBuilder.append(this.jdField_d_of_type_Long);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b(long paramLong, int paramInt)
  {
    if ((b(paramInt) != null) && (b(paramInt).size() != 0)) {
      return b(paramInt).contains(Long.valueOf(paramLong));
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getActivateFriendSwitch();
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131694948));
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
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
    ActivateFriendServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, true, false, true);
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    if ((c(paramInt) != null) && (c(paramInt).size() != 0)) {
      return c(paramInt).contains(Long.valueOf(paramLong));
    }
    return false;
  }
  
  public void d()
  {
    synchronized (this.jdField_a_of_type_JavaUtilSet)
    {
      this.jdField_a_of_type_JavaUtilSet.clear();
      return;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendBizQQReminderSwitchObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager
 * JD-Core Version:    0.7.0.1
 */