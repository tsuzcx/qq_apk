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
  public int a = this.i;
  Set<Integer> b = new HashSet();
  private volatile Set<Long> c;
  private volatile Set<Long> d;
  private volatile Set<Long> e;
  private volatile Set<Long> f;
  private QQAppInterface g;
  private SharedPreferences h;
  private int i = 1;
  private int j = 2;
  private int k = 3;
  private long l;
  private long m;
  private long n;
  private long o;
  private Handler p;
  private QQReminderSwitchObserver q;
  private Runnable r = new ActivateFriendsManager.1(this);
  private int s = -2147483648;
  
  public ActivateFriendsManager(QQAppInterface paramQQAppInterface)
  {
    this.g = paramQQAppInterface;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pref_act_frd");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    this.h = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
    this.l = this.h.getLong("key_check_stamp", 0L);
    this.n = this.h.getLong("key_memorial_check_stamp", 0L);
    this.m = this.h.getLong("key_check_interval", 120000L);
    this.o = this.h.getLong("key_memorial_check_interval", 120000L);
    this.p = new Handler(ThreadManager.getSubThreadLooper());
    this.q = new QQReminderSwitchObserver();
    paramQQAppInterface.addObserver(this.q);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(MessageCache.c() * 1000L);
    int i1 = ((Calendar)localObject).get(1);
    int i2 = ((Calendar)localObject).get(2);
    int i3 = ((Calendar)localObject).get(6);
    ((Calendar)localObject).add(6, 1);
    int i4 = ((Calendar)localObject).get(6);
    localObject = new GregorianCalendar();
    ((GregorianCalendar)localObject).set(5, paramInt3);
    ((GregorianCalendar)localObject).set(2, paramInt2 - 1);
    ((GregorianCalendar)localObject).set(1, paramInt1);
    paramInt3 = ((GregorianCalendar)localObject).get(6);
    if (i1 == paramInt1)
    {
      if (paramInt3 < i3) {
        return 0;
      }
      if (paramInt3 == i3) {
        return 1;
      }
      if (paramInt3 == i4) {
        return 2;
      }
      return 3;
    }
    if (paramInt1 > i1)
    {
      if ((paramInt1 == i1 + 1) && (i2 + 1 - 0 == 12) && (paramInt2 == 1) && (i4 == paramInt3)) {
        return 2;
      }
      return 3;
    }
    return 0;
  }
  
  public static String a(Context paramContext)
  {
    int[] arrayOfInt = new int[10];
    int[] tmp6_5 = arrayOfInt;
    tmp6_5[0] = 2131886412;
    int[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 2131886417;
    int[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 2131886416;
    int[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 2131886410;
    int[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 2131886409;
    int[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 2131886414;
    int[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 2131886413;
    int[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 2131886408;
    int[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 2131886411;
    int[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 2131886415;
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
        return String.format(paramContext.getString(2131886405), new Object[] { paramMsgBody.msg_geographic_notify.bytes_local_city.get().toStringUtf8() });
      }
      if (paramMsgBody.uint32_msg_type.get() == 2) {
        return paramContext.getString(2131886403);
      }
      str1 = str2;
      if (paramMsgBody.uint32_msg_type.get() == 3) {
        str1 = paramContext.getString(2131886407);
      }
    }
    return str1;
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
    int i2 = 0;
    Object localObject1 = paramQQAppInterface.getMessageFacade().h(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
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
    int i1;
    if (paramMsgBody.rpt_msg_info.has())
    {
      paramMsgBody = paramMsgBody.rpt_msg_info.get().iterator();
      do
      {
        i1 = i2;
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
      i1 = 1;
    }
    else
    {
      i1 = i2;
      if (QLog.isColorLevel())
      {
        localStringBuilder.append("rpt_msg_info is null|");
        i1 = i2;
      }
    }
    if (i1 != 0) {
      paramQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 9002);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public static int c(byte[] paramArrayOfByte)
  {
    try
    {
      SubMsgType0x76.MsgBody localMsgBody = new SubMsgType0x76.MsgBody();
      localMsgBody.mergeFrom(paramArrayOfByte);
      int i1 = localMsgBody.uint32_msg_type.get();
      return i1;
    }
    catch (Exception paramArrayOfByte)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ActivateFriends.Manager", 2, "ParseMessageType catch error.", paramArrayOfByte);
      }
    }
    return 1;
  }
  
  private Set<Long> c(int paramInt)
  {
    Object localObject1;
    if (paramInt == 1) {
      localObject1 = this.c;
    } else if (paramInt == 2) {
      localObject1 = this.d;
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new HashSet(6);
      localObject1 = this.h;
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
      int i2 = localObject1.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localStringBuilder = localObject1[i1];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          ((Set)localObject2).add(Long.valueOf(Long.parseLong(localStringBuilder)));
        }
        i1 += 1;
      }
      if (paramInt == 1)
      {
        this.c = ((Set)localObject2);
        return localObject2;
      }
      this.d = ((Set)localObject2);
    }
    return localObject2;
  }
  
  private Set<Long> d(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.e != null) {
        return this.e;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.h;
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
      int i1 = localObject.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        localStringBuilder = localObject[paramInt];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localStringBuilder)));
        }
        paramInt += 1;
      }
      this.e = localHashSet;
    }
    return this.e;
  }
  
  private Set<Long> e(int paramInt)
  {
    if (paramInt == 2)
    {
      if (this.f != null) {
        return this.f;
      }
      HashSet localHashSet = new HashSet(6);
      Object localObject = this.h;
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
      int i1 = localObject.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        localStringBuilder = localObject[paramInt];
        if (!TextUtils.isEmpty(localStringBuilder)) {
          localHashSet.add(Long.valueOf(Long.parseLong(localStringBuilder)));
        }
        paramInt += 1;
      }
      this.f = localHashSet;
    }
    return this.f;
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
    this.p.removeCallbacks(this.r);
    this.p.postDelayed(this.r, 60000L);
  }
  
  public void a(int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceivePushMessage  msgType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.h.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_sended_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    localObject = this.h.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_wished_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    localObject = this.h.edit();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_uin_expired_");
    localStringBuilder.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder.toString(), "").commit();
    if (paramInt == 1) {
      this.c = new HashSet();
    } else if (paramInt == 2) {
      this.d = new HashSet();
    }
    if ((paramInt == 2) || (paramInt == 3))
    {
      if (paramInt == 2) {
        i1 = 1;
      }
      LpReportInfo_pf00064.allReport(220, 1, i1);
      ReportController.b(this.g, "dc00898", "", "", "0X8007210", "0X8007211", 0, 0, "", "", "", "");
      this.h.edit().putLong("key_last_birth_msg_stamp", MessageCache.c()).commit();
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
      int i2 = 0;
      int i3;
      int i1;
      if ((paramArrayOfLong1 != null) && (paramArrayOfLong1.length != 0))
      {
        i3 = paramArrayOfLong1.length;
        i1 = 0;
      }
      while (i1 < i3)
      {
        localStringBuilder.append(a(String.valueOf(paramArrayOfLong1[i1])));
        localStringBuilder.append(",");
        i1 += 1;
        continue;
        localStringBuilder.append("null");
      }
      localStringBuilder.append(" | time = ");
      if ((paramArrayOfLong2 != null) && (paramArrayOfLong2.length != 0))
      {
        i3 = paramArrayOfLong2.length;
        i1 = i2;
      }
      while (i1 < i3)
      {
        localStringBuilder.append(paramArrayOfLong2[i1]);
        localStringBuilder.append(",");
        i1 += 1;
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
    long l1 = paramLong;
    if (paramLong < 120000L) {
      l1 = 120000L;
    }
    this.l = System.currentTimeMillis();
    this.m = l1;
    this.h.edit().putLong("key_check_stamp", System.currentTimeMillis()).putLong("key_check_interval", l1).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveBirthdayCheckInStamp=");
      localStringBuilder.append(this.m);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public void a(long paramLong, Map<Long, Integer> paramMap, int paramInt)
  {
    if (!this.g.getCurrentAccountUin().equals(Long.toString(paramLong)))
    {
      if (QLog.isColorLevel())
      {
        paramMap = new StringBuilder();
        paramMap.append("currentUin:");
        paramMap.append(this.g.getCurrentAccountUin());
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
      if ((d(paramInt) != null) && (d(paramInt).size() != 0)) {
        localHashSet.addAll(d(paramInt));
      }
      int i1 = localHashSet.size();
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
      localObject3 = this.h.edit();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("key_uin_wished_");
      ((StringBuilder)localObject4).append(paramInt);
      ((SharedPreferences.Editor)localObject3).putString(((StringBuilder)localObject4).toString(), ((StringBuilder)localObject2).toString()).commit();
      localObject2 = this.h.edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("key_uin_expired_");
      ((StringBuilder)localObject3).append(paramInt);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), localStringBuilder1.toString()).commit();
      this.e = localHashSet;
      this.f = ((Set)localObject1);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("WishedFriends count = ");
        ((StringBuilder)localObject1).append(paramMap.size());
        ((StringBuilder)localObject1).append(", orginal count = ");
        ((StringBuilder)localObject1).append(i1);
        ((StringBuilder)localObject1).append(", new count = ");
        ((StringBuilder)localObject1).append(localHashSet.size());
        QLog.d("ActivateFriends.Manager", 2, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  public void a(WeakReference<QQReminderSwitchObserver.QQReminderSwitchListener> paramWeakReference)
  {
    this.q.a(paramWeakReference);
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
      ((CardHandler)this.g.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER)).k(paramBoolean1);
      return;
    }
    SharedPreferences.Editor localEditor = this.h.edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g.getApp().getString(2131892675));
    localStringBuilder.append(this.g.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean1).commit();
  }
  
  public void a(long[] paramArrayOfLong, int paramInt)
  {
    HashSet localHashSet = new HashSet(6);
    localHashSet.addAll(c(paramInt));
    int i2 = localHashSet.size();
    int i3 = paramArrayOfLong.length;
    int i1 = 0;
    while (i1 < i3)
    {
      localHashSet.add(Long.valueOf(paramArrayOfLong[i1]));
      i1 += 1;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder1.append((Long)((Iterator)localObject).next());
      localStringBuilder1.append("-");
    }
    localObject = this.h.edit();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("key_uin_sended_");
    localStringBuilder2.append(paramInt);
    ((SharedPreferences.Editor)localObject).putString(localStringBuilder2.toString(), localStringBuilder1.toString()).commit();
    if (paramInt == 1) {
      this.c = localHashSet;
    } else {
      this.d = localHashSet;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("onSendTimingMsgSuc, send count = ");
      localStringBuilder1.append(paramArrayOfLong.length);
      localStringBuilder1.append(", orginal count = ");
      localStringBuilder1.append(i2);
      localStringBuilder1.append(", new count = ");
      localStringBuilder1.append(localHashSet.size());
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder1.toString());
    }
  }
  
  public boolean a(long paramLong, int paramInt)
  {
    return c(paramInt).contains(Long.valueOf(paramLong));
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.g, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getActivateFriendSwitch();
      }
    }
    Object localObject = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g.getApp().getString(2131892675));
    localStringBuilder.append(this.g.getCurrentAccountUin());
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
    long l1 = paramLong;
    if (paramLong < 120000L) {
      l1 = 120000L;
    }
    this.n = System.currentTimeMillis();
    this.o = l1;
    this.h.edit().putLong("key_memorial_check_stamp", System.currentTimeMillis()).putLong("key_memorial_check_interval", l1).commit();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveMemorialCheckInStamp=");
      localStringBuilder.append(this.o);
      QLog.d("ActivateFriends.Manager", 2, localStringBuilder.toString());
    }
  }
  
  public boolean b(int paramInt)
  {
    boolean bool;
    if (this.s == paramInt) {
      bool = true;
    } else {
      bool = false;
    }
    this.s = paramInt;
    return bool;
  }
  
  public boolean b(long paramLong, int paramInt)
  {
    if ((d(paramInt) != null) && (d(paramInt).size() != 0)) {
      return d(paramInt).contains(Long.valueOf(paramLong));
    }
    return false;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.g, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getActivateFriendSwitch();
      }
    }
    Object localObject = this.h;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.g.getApp().getString(2131892675));
    localStringBuilder.append(this.g.getCurrentAccountUin());
    return ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), false);
  }
  
  public boolean b(byte[] arg1)
  {
    int i1 = c(???);
    for (;;)
    {
      synchronized (this.b)
      {
        if (!this.b.contains(Integer.valueOf(i1)))
        {
          bool = true;
          this.b.add(Integer.valueOf(i1));
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void c()
  {
    this.p.removeCallbacks(this.r);
    this.a = this.j;
    ActivateFriendServlet.a(this.g, false, true, false, true);
  }
  
  public boolean c(long paramLong, int paramInt)
  {
    if ((e(paramInt) != null) && (e(paramInt).size() != 0)) {
      return e(paramInt).contains(Long.valueOf(paramLong));
    }
    return false;
  }
  
  public void d()
  {
    synchronized (this.b)
    {
      this.b.clear();
      return;
    }
  }
  
  public void onDestroy()
  {
    this.p.removeCallbacks(this.r);
    this.g.removeObserver(this.q);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager
 * JD-Core Version:    0.7.0.1
 */