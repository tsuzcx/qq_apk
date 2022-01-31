import android.app.Activity;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x686.Oidb_0x686.CharmEvent;
import tencent.im.oidb.cmd0x686.Oidb_0x686.NearbyCharmNotify;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd.SelfInfo;

public class auul
  implements Manager
{
  int jdField_a_of_type_Int = -2147483648;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  ConcurrentHashMap<String, Long> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public boolean a;
  int jdField_b_of_type_Int = -2147483648;
  ConcurrentHashMap<String, Long> jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Integer> c = new ConcurrentHashMap();
  public ConcurrentHashMap<String, Integer> d = new ConcurrentHashMap();
  
  public auul(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("Q.nearby_people_card.", 4, "updateNearbyProfileCardHead");
    }
    paramQQAppInterface.a(paramQQAppInterface.getCurrentAccountUin(), 200);
    awgf localawgf = paramQQAppInterface.getEntityManagerFactory(paramQQAppInterface.getAccount()).createEntityManager();
    if (localawgf != null)
    {
      NearbyPeopleCard localNearbyPeopleCard = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { paramQQAppInterface.getCurrentAccountUin() });
      if ((localNearbyPeopleCard != null) && (localNearbyPeopleCard.tinyId > 0L)) {
        paramQQAppInterface.a(String.valueOf(localNearbyPeopleCard.tinyId), 202);
      }
      localawgf.a();
    }
    ThreadManager.getSubThreadHandler().postDelayed(new NearbyCardManager.1(paramQQAppInterface), 2000L);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, Oidb_0x686.CharmEvent paramCharmEvent, Oidb_0x686.NearbyCharmNotify paramNearbyCharmNotify)
  {
    auwz.a("Q.nearby", "updateNearbyPeopleCard", new Object[] { paramString, paramCharmEvent, paramNearbyCharmNotify });
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString)) || ((paramCharmEvent == null) && (paramNearbyCharmNotify == null))) {}
    awgf localawgf;
    do
    {
      return;
      Object localObject = null;
      localawgf = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramQQAppInterface = localObject;
      if (!bdnn.a(paramString)) {
        paramQQAppInterface = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
      }
    } while (paramQQAppInterface == null);
    if ((paramCharmEvent != null) && (paramCharmEvent.uint32_new_charm.get() > 0) && (paramCharmEvent.uint32_cur_level_threshold.get() > paramCharmEvent.uint32_next_level_threshold.get()))
    {
      paramQQAppInterface.charm = paramCharmEvent.uint32_new_charm.get();
      paramQQAppInterface.charmLevel = paramCharmEvent.uint32_new_charm_level.get();
      paramQQAppInterface.curThreshold = paramCharmEvent.uint32_cur_level_threshold.get();
      paramQQAppInterface.nextThreshold = paramCharmEvent.uint32_next_level_threshold.get();
    }
    for (;;)
    {
      localawgf.a(paramQQAppInterface);
      localawgf.a();
      return;
      if (paramNearbyCharmNotify != null)
      {
        paramQQAppInterface.charm = paramNearbyCharmNotify.uint32_new_charm.get();
        paramQQAppInterface.charmLevel = paramNearbyCharmNotify.uint32_new_charm_level.get();
        paramQQAppInterface.curThreshold = paramNearbyCharmNotify.uint32_cur_level_threshold.get();
        paramQQAppInterface.nextThreshold = paramNearbyCharmNotify.uint32_next_level_threshold.get();
        paramQQAppInterface.profPercent = paramNearbyCharmNotify.uint32_new_prof_percent.get();
      }
    }
  }
  
  public static boolean a(Activity paramActivity, String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    if (paramInt == 1) {
      azqs.b(null, "dc00899", "grp_lbs", "", "app_down", "exp_msg", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      bdgm.a(paramActivity, 230).setMessage(paramString1).setNegativeButton(alud.a(2131707505), new auun()).setPositiveButton(alud.a(2131707508), new auum(paramString2, paramInt, paramActivity)).show();
      return true;
      if (paramInt == 2) {
        azqs.b(null, "dc00899", "grp_lbs", "", "app_down", "exp_pic", 0, 0, "", "", "", "");
      }
    }
  }
  
  public int a()
  {
    Card localCard;
    if (this.jdField_b_of_type_Int == -2147483648)
    {
      localCard = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if ((localCard != null) && ((localCard.age != 0) || (!TextUtils.isEmpty(localCard.strNick)))) {}
    }
    else
    {
      return this.jdField_b_of_type_Int;
    }
    if (-2147483648 != localCard.age) {}
    for (int i = localCard.age;; i = -2147483648)
    {
      a(i);
      break;
    }
  }
  
  public int a(int paramInt)
  {
    int k = 0;
    int i = -1;
    int j;
    if (paramInt != 0)
    {
      j = k;
      if (paramInt != 1) {}
    }
    else
    {
      j = b();
      if (j != 1) {
        break label55;
      }
      i = 0;
    }
    for (;;)
    {
      if (i != 0)
      {
        j = k;
        if (i != 1) {}
      }
      else
      {
        if (i != 1) {
          break label67;
        }
        if (paramInt != 1) {
          break;
        }
        j = 3;
      }
      return j;
      label55:
      if (j == 2) {
        i = 1;
      }
    }
    return 2;
    label67:
    if (paramInt == 1) {
      return 1;
    }
    return 4;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_Int = paramInt;
      auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_age", Integer.valueOf(this.jdField_b_of_type_Int));
    }
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	auul:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   6: ifnull +19 -> 25
    //   9: aload_0
    //   10: getfield 31	auul:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   13: invokevirtual 283	java/util/concurrent/ConcurrentHashMap:isEmpty	()Z
    //   16: istore_2
    //   17: iload_2
    //   18: ifne +7 -> 25
    //   21: aload_1
    //   22: ifnonnull +6 -> 28
    //   25: aload_0
    //   26: monitorexit
    //   27: return
    //   28: aload_0
    //   29: getfield 31	auul:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   32: aload_1
    //   33: invokevirtual 287	java/util/concurrent/ConcurrentHashMap:containsKey	(Ljava/lang/Object;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: getfield 31	auul:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   43: aload_1
    //   44: invokevirtual 291	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: pop
    //   48: goto -23 -> 25
    //   51: astore_1
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_1
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	this	auul
    //   0	56	1	paramString	String
    //   16	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	17	51	finally
    //   28	48	51	finally
  }
  
  public void a(String paramString, long paramLong)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
      }
      return;
    }
    finally {}
  }
  
  public void a(oidb_0x8dd.SelfInfo paramSelfInfo)
  {
    if (paramSelfInfo == null) {
      return;
    }
    awgf localawgf = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager();
    Object localObject2;
    Object localObject1;
    if (localawgf != null)
    {
      localObject2 = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (paramSelfInfo.uint64_tinyid.get() > 0L) {
          localObject1 = (NearbyPeopleCard)localawgf.a(NearbyPeopleCard.class, "tinyId=?", new String[] { String.valueOf(paramSelfInfo.uint64_tinyid.get()) });
        }
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new NearbyPeopleCard();
      }
      if (paramSelfInfo.uint64_tinyid.get() > 0L)
      {
        ((NearbyPeopleCard)localObject2).tinyId = paramSelfInfo.uint64_tinyid.get();
        ((NearbyPeopleCard)localObject2).uin = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      }
      i = paramSelfInfo.uint32_vote_num.get();
      if ((paramSelfInfo.uint32_vote_num.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject2).likeCount = i;
      }
      i = paramSelfInfo.uint32_vote_increment.get();
      if ((paramSelfInfo.uint32_vote_increment.has()) && (i > 0)) {
        ((NearbyPeopleCard)localObject2).likeCountInc = i;
      }
      ((NearbyPeopleCard)localObject2).gender = ((byte)paramSelfInfo.uint32_gender.get());
      ((NearbyPeopleCard)localObject2).nickname = paramSelfInfo.bytes_nick.get().toStringUtf8();
      ((NearbyPeopleCard)localObject2).age = paramSelfInfo.uint32_age.get();
      if (((NearbyPeopleCard)localObject2).getStatus() != 1000) {
        break label482;
      }
      localawgf.b((awge)localObject2);
      localObject1 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject1 != null)
      {
        i = paramSelfInfo.uint32_vote_num.get();
        if ((!paramSelfInfo.uint32_vote_num.has()) || (i <= 0)) {
          break label515;
        }
        ((Card)localObject1).lVoteCount = i;
      }
    }
    label515:
    for (int i = 1;; i = 0)
    {
      int k = paramSelfInfo.uint32_vote_increment.get();
      int j = i;
      if (paramSelfInfo.uint32_vote_increment.has())
      {
        j = i;
        if (k > 0)
        {
          ((Card)localObject1).iVoteIncrement = k;
          j = 1;
        }
      }
      if (j != 0)
      {
        auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), ((Card)localObject1).lVoteCount, ((Card)localObject1).iVoteIncrement);
        localawgf.a((awge)localObject1);
      }
      localawgf.a();
      b(paramSelfInfo.uint32_gender.get());
      a(paramSelfInfo.uint32_age.get());
      auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_third_line_info", paramSelfInfo.str_third_line_info.get());
      auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_third_line_icon", paramSelfInfo.str_third_line_icon.get());
      return;
      label482:
      if ((((NearbyPeopleCard)localObject2).getStatus() != 1001) && (((NearbyPeopleCard)localObject2).getStatus() != 1002)) {
        break;
      }
      localawgf.a((awge)localObject2);
      break;
    }
  }
  
  public boolean a()
  {
    return ((Boolean)auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "self_god_flag", Boolean.valueOf(false))).booleanValue();
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool3;
    if (paramNearbyPeopleCard != null)
    {
      bool2 = bool3;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        if (this.d.containsKey(paramNearbyPeopleCard.uin))
        {
          this.d.remove(paramNearbyPeopleCard.uin);
          bool1 = true;
        }
        bool2 = bool1;
        if (!bool1)
        {
          bool2 = bool1;
          if (this.d.containsKey(String.valueOf(paramNearbyPeopleCard.tinyId)))
          {
            this.d.remove(String.valueOf(paramNearbyPeopleCard.tinyId));
            return true;
          }
        }
      }
    }
    return bool2;
  }
  
  public boolean a(NearbyPeopleCard paramNearbyPeopleCard, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    boolean bool1 = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Boolean = false;
    if (paramNearbyPeopleCard == null) {
      return true;
    }
    boolean bool2 = b(paramNearbyPeopleCard);
    int k = 0;
    int j = 0;
    int i = k;
    if (paramNearbyPeopleCard != null)
    {
      i = k;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        i = j;
        if (this.d.containsKey(paramNearbyPeopleCard.uin))
        {
          this.d.remove(paramNearbyPeopleCard.uin);
          i = 1;
        }
        if (this.d.containsKey(String.valueOf(paramNearbyPeopleCard.tinyId)))
        {
          this.d.remove(String.valueOf(paramNearbyPeopleCard.tinyId));
          i = 1;
        }
      }
    }
    if (i != 0) {
      return true;
    }
    if (bool2) {
      return true;
    }
    if (TextUtils.isEmpty(paramNearbyPeopleCard.uin)) {
      return true;
    }
    if ((bool1) && (paramString.equals(paramNearbyPeopleCard.uin))) {
      return true;
    }
    if (!paramBoolean3) {
      return true;
    }
    if ((paramBoolean1) || (paramBoolean2)) {
      return true;
    }
    if (51 == paramInt) {
      try
      {
        if (!this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramNearbyPeopleCard.uin)) {
          return true;
        }
      }
      finally {}
    }
    for (long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramNearbyPeopleCard.uin)).longValue();; l = ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramNearbyPeopleCard.uin)).longValue())
    {
      l = SystemClock.elapsedRealtime() - l;
      if (!bdeu.a(paramString, paramNearbyPeopleCard.uin)) {
        break;
      }
      if (l < 300000L) {
        break label316;
      }
      return true;
      if (!this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramNearbyPeopleCard.uin)) {
        return true;
      }
    }
    if (l >= 300000L) {
      return true;
    }
    label316:
    return (!TextUtils.isEmpty(paramNearbyPeopleCard.uin)) && (((auvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207)).a(paramNearbyPeopleCard.uin));
  }
  
  public int b()
  {
    Object localObject;
    int i;
    if (this.jdField_a_of_type_Int == -2147483648)
    {
      localObject = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (localObject == null) {
        break label51;
      }
      i = ((Card)localObject).shGender;
    }
    for (;;)
    {
      b(i);
      return this.jdField_a_of_type_Int;
      label51:
      localObject = (NearbyPeopleCard)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).createEntityManager().a(NearbyPeopleCard.class, "uin=?", new String[] { this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() });
      if (localObject != null) {
        i = ((NearbyPeopleCard)localObject).gender;
      } else {
        i = -1;
      }
    }
  }
  
  public void b(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Int = 0;
    }
    for (;;)
    {
      if (i != this.jdField_a_of_type_Int)
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
        if (localObject != null)
        {
          localObject = ((HotChatManager)localObject).a(false);
          if (localObject != null) {
            ((astd)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null, paramInt, NetConnInfoCenter.getServerTime());
          }
        }
        auwq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_gender", Integer.valueOf(this.jdField_a_of_type_Int));
      }
      return;
      this.jdField_a_of_type_Int = 1;
      continue;
      this.jdField_a_of_type_Int = 2;
    }
  }
  
  public void b(String paramString, long paramLong)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramLong > 0L)) {
      this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public boolean b(NearbyPeopleCard paramNearbyPeopleCard)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramNearbyPeopleCard != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramNearbyPeopleCard.uin))
      {
        bool1 = bool2;
        if (this.c.containsKey(paramNearbyPeopleCard.uin))
        {
          this.c.remove(paramNearbyPeopleCard.uin);
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy()
  {
    try
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     auul
 * JD-Core Version:    0.7.0.1
 */