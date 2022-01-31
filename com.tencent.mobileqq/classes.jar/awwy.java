import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.text.format.DateUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.profile.vote.VoteHelper.1;
import com.tencent.mobileqq.profile.vote.VoteHelper.3;
import com.tencent.mobileqq.profile.vote.VoteHelper.4;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class awwy
{
  public static final Object a;
  public static long b;
  public static final Object b;
  public static String d;
  public static String e;
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long;
  public Handler a;
  public VisitorsActivity a;
  public QQAppInterface a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<Long> a;
  public Map<Long, Pair<CardProfile, AtomicInteger>> a;
  int jdField_b_of_type_Int;
  String jdField_b_of_type_JavaLangString;
  public ArrayList<Long> b;
  public Map<Long, Pair<CardProfile, Pair<AtomicInteger, AtomicInteger>>> b;
  String c;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    d = "sp_key_vote_max_friend";
    e = "sp_key_vote_max_stranger";
    jdField_b_of_type_Long = -1L;
  }
  
  public awwy(VisitorsActivity paramVisitorsActivity, Handler paramHandler, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_b_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity = paramVisitorsActivity;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    jdField_b_of_type_Long = -1L;
  }
  
  private void a(ArrayList<Long> paramArrayList)
  {
    this.jdField_b_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    int i = 0;
    if (i < paramArrayList.size())
    {
      if ((Long)paramArrayList.get(i) == null) {}
      for (;;)
      {
        i += 1;
        break;
        if (localalto.b(Long.toString(((Long)paramArrayList.get(i)).longValue()))) {
          this.jdField_a_of_type_JavaUtilArrayList.add(paramArrayList.get(i));
        } else {
          this.jdField_b_of_type_JavaUtilArrayList.add(paramArrayList.get(i));
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "fillTodayVoteArray " + paramArrayList.size() + " friend:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " stranger:" + this.jdField_b_of_type_JavaUtilArrayList.size());
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_b_of_type_Long < 0L) {
      jdField_b_of_type_Long = paramQQAppInterface.getPreferences().getLong("keyShowDoubleZanPopTime", 0L);
    }
    if (DateUtils.isToday(jdField_b_of_type_Long)) {
      return false;
    }
    jdField_b_of_type_Long = System.currentTimeMillis();
    paramQQAppInterface.getPreferences().edit().putLong("keyShowDoubleZanPopTime", jdField_b_of_type_Long).commit();
    return true;
  }
  
  public int a(CardProfile paramCardProfile)
  {
    boolean bool3;
    Object localObject2;
    label52:
    int k;
    label63:
    int j;
    label78:
    boolean bool2;
    int n;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder("checkVote log ");
      bool3 = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(Long.toString(paramCardProfile.lEctID));
      if (bool3)
      {
        localObject2 = this.jdField_a_of_type_JavaUtilArrayList;
        if (!bool3) {
          break label331;
        }
        k = this.jdField_a_of_type_Int;
        if (paramCardProfile.type != 2) {
          break label346;
        }
        if (!bool3) {
          break label340;
        }
        j = 5;
        if ((QLog.isColorLevel()) && (??? != null))
        {
          ((StringBuilder)???).append(",").append("limit").append("=").append(k);
          ((StringBuilder)???).append(",").append("isFrd").append("=").append(bool3);
          ((StringBuilder)???).append(",").append(paramCardProfile.getSimpleZanInfo());
          QLog.i("VisitorsActivity.VoteHelper", 2, ((StringBuilder)???).toString());
        }
        bool2 = false;
        n = 0;
      }
    }
    for (;;)
    {
      boolean bool1;
      int i;
      label331:
      label340:
      label346:
      int m;
      synchronized (jdField_b_of_type_JavaLangObject)
      {
        if (((ArrayList)localObject2).size() < k)
        {
          bool1 = true;
          i = 1;
          if ((bool1) || (i != 0)) {
            break label427;
          }
          if (!bool3) {
            break label418;
          }
          ??? = this.jdField_a_of_type_JavaLangString;
          a(String.format((String)???, new Object[] { Integer.valueOf(k) }));
          azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "0X8006579", "0X8006579", "", j, 1, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.i("VisitorsActivity.VoteHelper", 2, "checkVote " + paramCardProfile.lEctID + " logLevel:" + i + " can:" + bool1);
          }
          if (!bool1) {
            break label666;
          }
          return 1;
          localObject2 = this.jdField_b_of_type_JavaUtilArrayList;
          break label52;
          k = this.jdField_b_of_type_Int;
          break label63;
          j = 6;
          break label78;
          if (bool3)
          {
            j = 7;
            break label78;
          }
          j = 8;
          break label78;
        }
        m = 0;
        i = n;
        bool1 = bool2;
        if (m >= ((ArrayList)localObject2).size()) {
          continue;
        }
        if (((Long)((ArrayList)localObject2).get(m)).longValue() != paramCardProfile.lEctID) {
          break label674;
        }
        bool1 = true;
        i = 2;
      }
      label418:
      ??? = this.jdField_b_of_type_JavaLangString;
      continue;
      label427:
      k = i;
      bool2 = bool1;
      if (bool1)
      {
        k = i;
        bool2 = bool1;
        if (paramCardProfile.bAvailableCnt <= 0L) {
          if (bool3)
          {
            if (!VipUtils.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
              break label613;
            }
            VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "thumbup", "limit_20", "", 1, 0, 0, "", Integer.toString(paramCardProfile.type), "");
            a("已点满SVIP专享20个赞啦~");
          }
        }
      }
      for (;;)
      {
        k = 4;
        bool2 = false;
        localObject2 = String.format(this.c, new Object[] { Long.valueOf(paramCardProfile.bTodayVotedCnt) });
        ??? = localObject2;
        if (paramCardProfile.bSex == 1) {
          ??? = ((String)localObject2).replace(alud.a(2131717260), alud.a(2131717258));
        }
        a((String)???);
        azqs.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "0X8006578", "0X8006578", "", j, 1, 0, "", "", "", "");
        i = k;
        bool1 = bool2;
        break;
        label613:
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          return 2;
        }
        VasWebviewUtil.reportCommercialDrainage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "thumbup", "limit_10", "", 1, 0, 0, "", Integer.toString(paramCardProfile.type), "");
        a("非SVIP用户每天只能点10个赞哦～");
      }
      label666:
      return 0;
      ??? = null;
      break;
      label674:
      m += 1;
    }
  }
  
  public int a(String paramString, int paramInt)
  {
    paramInt = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt(paramString, paramInt);
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "getSp key:" + paramString + " value:" + paramInt);
    }
    return paramInt;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = a(d, 0);
    this.jdField_b_of_type_Int = a(d, 0);
    ArrayList localArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Alpk.c(localArrayList);
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      a(localArrayList);
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699681);
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699683);
      this.c = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getResources().getString(2131699682);
      return;
    }
  }
  
  public void a(long paramLong)
  {
    ThreadManager.postImmediately(new VoteHelper.4(this, paramLong), null, true);
  }
  
  public void a(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Alpk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramLong, paramInt);
  }
  
  public void a(CardProfile paramCardProfile)
  {
    int k = 0;
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        localObject1 = (Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID));
        int i;
        if (localObject1 == null)
        {
          i = 0;
          break label433;
          if (j >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size()) {
            break label427;
          }
          if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j)).lEctID != paramCardProfile.lEctID) {
            break label438;
          }
          localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j);
          j = k;
          if (localObject1 != null)
          {
            ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
            ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
            j = k;
          }
          if (j < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size())
          {
            localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(j);
            if ((localObject1 == null) || (((CardProfile)localObject1).lEctID != paramCardProfile.lEctID)) {
              break label445;
            }
            localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.remove(j);
            ((CardProfile)localObject1).updateTime(paramCardProfile.lTime);
            ((CardProfile)localObject1).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
            ((CardProfile)localObject1).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
            ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
            Object localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = paramCardProfile.clone();
              ((CardProfile)localObject2).type = 3;
              ((CardProfile)localObject2).bTodayVotedCnt = (paramCardProfile.bTodayVotedCnt + i);
              ((CardProfile)localObject2).bAvailableCnt = (paramCardProfile.bAvailableCnt - i);
              ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
            }
            if ((((CardProfile)localObject2).bTodayVotedCnt > 0L) && (((CardProfile)localObject2).bVoteCnt > 0)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.add(0, localObject2);
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile.lEctID);
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g();
            if (QLog.isColorLevel()) {
              QLog.i("VisitorsActivity.VoteHelper", 2, "updateCardProfileToList. uin:" + paramCardProfile.lEctID + " todayCount:" + paramCardProfile.bTodayVotedCnt);
            }
          }
        }
        else
        {
          i = ((AtomicInteger)((Pair)localObject1).second).get();
        }
      }
      Object localObject1 = null;
      continue;
      label427:
      localObject1 = null;
      continue;
      label433:
      int j = 0;
      continue;
      label438:
      j += 1;
      continue;
      label445:
      j += 1;
    }
  }
  
  public void a(CardProfile paramCardProfile, ImageView paramImageView, boolean paramBoolean)
  {
    int i = 1;
    label396:
    label661:
    label850:
    label856:
    label867:
    label880:
    for (;;)
    {
      Object localObject1;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        paramCardProfile.bAvailableCnt -= 1L;
        paramCardProfile.bTodayVotedCnt += 1L;
        if (paramCardProfile.type == 3)
        {
          paramCardProfile.bVoteCnt = ((short)(int)paramCardProfile.bTodayVotedCnt);
          paramCardProfile.dwLikeCustomId = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          if (paramBoolean)
          {
            s = 0;
            paramCardProfile.bIsLastVoteCharged = s;
            i = 0;
            paramCardProfile.updateTime(System.currentTimeMillis() / 1000L);
          }
        }
        else
        {
          if ((!paramBoolean) && (i == 0)) {
            paramCardProfile.payVoteCount = ((short)(paramCardProfile.payVoteCount + 1));
          }
          boolean bool = ((alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(Long.toString(paramCardProfile.lEctID));
          if (QLog.isColorLevel()) {
            QLog.d("VisitorsActivity.VoteHelper", 2, "doVote, uin=" + paramCardProfile.lEctID + ", isFriend=" + bool);
          }
          if ((bool) || (!auvr.d(paramCardProfile.uSource))) {
            break label661;
          }
          if (this.jdField_b_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCardProfile.lEctID))) {
            continue;
          }
          localObject2 = new AtomicInteger(0);
          localObject1 = new AtomicInteger(0);
          Pair localPair = new Pair(localObject2, localObject1);
          this.jdField_b_of_type_JavaUtilMap.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localPair));
          if (!paramBoolean) {
            continue;
          }
          ((AtomicInteger)localObject2).incrementAndGet();
          break label856;
          if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size()) {
            break label850;
          }
          localObject2 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(i);
          if ((localObject2 == null) || (((CardProfile)localObject2).lEctID != paramCardProfile.lEctID)) {
            break label867;
          }
          ((CardProfile)localObject2).bTodayVotedCnt += 1L;
          ((CardProfile)localObject2).bAvailableCnt -= 1L;
          ((CardProfile)localObject2).bVoteCnt = ((short)(int)((CardProfile)localObject2).bTodayVotedCnt);
          localObject1 = localObject2;
          if (!paramBoolean)
          {
            ((CardProfile)localObject2).payVoteCount = ((short)(((CardProfile)localObject2).payVoteCount + 1));
            localObject1 = localObject2;
          }
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            localObject1 = paramCardProfile.clone();
            ((CardProfile)localObject1).type = 3;
            ((CardProfile)localObject1).bVoteCnt = ((short)(int)((CardProfile)localObject1).bTodayVotedCnt);
            ((CardProfile)localObject1).bAvailableCnt = paramCardProfile.bAvailableCnt;
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.add(0, localObject1);
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g();
            localObject2 = localObject1;
            if (QLog.isColorLevel())
            {
              QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteClick add to FavList. uin:" + ((CardProfile)localObject1).lEctID);
              localObject2 = localObject1;
            }
          }
          ((CardProfile)localObject2).updateTime(System.currentTimeMillis() / 1000L);
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramCardProfile.lEctID);
          this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(paramImageView, paramBoolean);
          if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(6)) {
            this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(6, 2000L);
          }
          ThreadManager.post(new VoteHelper.1(this, paramCardProfile.lEctID, paramCardProfile.type, paramBoolean, paramCardProfile.uSource), 2, null, true);
          return;
        }
        short s = 1;
        continue;
        localObject1 = (Pair)((Pair)this.jdField_b_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID))).second;
        Object localObject2 = (AtomicInteger)((Pair)localObject1).first;
        localObject1 = (AtomicInteger)((Pair)localObject1).second;
        continue;
        ((AtomicInteger)localObject1).incrementAndGet();
      }
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(Long.valueOf(paramCardProfile.lEctID)))
      {
        localObject1 = new AtomicInteger(0);
        this.jdField_a_of_type_JavaUtilMap.put(Long.valueOf(paramCardProfile.lEctID), new Pair(paramCardProfile, localObject1));
      }
      for (;;)
      {
        ((AtomicInteger)localObject1).incrementAndGet();
        break;
        localObject1 = (AtomicInteger)((Pair)this.jdField_a_of_type_JavaUtilMap.get(Long.valueOf(paramCardProfile.lEctID))).second;
      }
      for (;;)
      {
        if (i >= this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size()) {
          break label880;
        }
        if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(i)).lEctID == paramCardProfile.lEctID)
        {
          localObject1 = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(i);
          ((CardProfile)localObject1).bTodayVotedCnt += 1L;
          ((CardProfile)localObject1).bAvailableCnt -= 1L;
          break label514;
        }
        i += 1;
        continue;
        localObject1 = null;
        break label396;
        if (i != 0)
        {
          i = 0;
          break;
          i += 1;
          break;
        }
        i = 0;
      }
    }
  }
  
  public void a(String paramString)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 2000L)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(0, paramString);
      this.jdField_a_of_type_Long = l;
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "saveSp key:" + paramString + " value:" + paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt(paramString, paramInt).commit();
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    ThreadManager.postImmediately(new VoteHelper.3(this, paramString, paramInt, paramBoolean), null, false);
  }
  
  public void a(ArrayList<Long> paramArrayList, int paramInt1, int paramInt2, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramLong == 0L) {}
    synchronized (jdField_b_of_type_JavaLangObject)
    {
      a(paramArrayList);
      a(d, this.jdField_a_of_type_Int);
      a(e, this.jdField_b_of_type_Int);
      return;
    }
  }
  
  public boolean a(CardProfile paramCardProfile, ImageView paramImageView)
  {
    boolean bool = true;
    if (!bdin.d(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity))
    {
      a(alud.a(2131717259));
      bool = false;
    }
    int i;
    do
    {
      return bool;
      i = a(paramCardProfile);
      if (i == 0) {
        return false;
      }
    } while (i == 2);
    bool = ajlb.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramCardProfile.lEctID));
    if (QLog.isColorLevel()) {
      QLog.d("NearbyLikeLimitManager", 2, "VisitorActivity->onClickVote, uin=" + paramCardProfile.lEctID + ", isFriend=" + bool);
    }
    if ((!bool) && (auvr.d(paramCardProfile.uSource))) {
      ((auvr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(207)).a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(paramCardProfile.lEctID), new awwz(this, paramCardProfile, paramImageView), "511");
    }
    for (;;)
    {
      return false;
      a(paramCardProfile, paramImageView, true);
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "reqestVote");
    }
    long l1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    alto localalto = (alto)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51);
    Object localObject3 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    long l2;
    Pair localPair;
    boolean bool;
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label228;
      }
      ??? = (Map.Entry)((Iterator)localObject3).next();
      l2 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      bool = localalto.b(Long.toString(l2));
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if (((AtomicInteger)localPair.second).get() > 0) {
          break;
        }
      }
    }
    if (bool) {
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Alpk.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
    }
    for (;;)
    {
      ((AtomicInteger)localPair.second).set(0);
      break;
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Auxh.a(l1, l2, null, 66, ((AtomicInteger)localPair.second).get(), 1);
    }
    label228:
    Iterator localIterator = this.jdField_b_of_type_JavaUtilMap.entrySet().iterator();
    localObject3 = new ArrayList();
    while (localIterator.hasNext())
    {
      ??? = (Map.Entry)localIterator.next();
      l1 = ((Long)((Map.Entry)???).getKey()).longValue();
      localPair = (Pair)((Map.Entry)???).getValue();
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        if ((((AtomicInteger)((Pair)localPair.second).first).get() > 0) || (((AtomicInteger)((Pair)localPair.second).second).get() > 0)) {}
      }
      auvw localauvw = new auvw();
      localauvw.jdField_a_of_type_Int = ((AtomicInteger)((Pair)localPair.second).first).get();
      localauvw.jdField_b_of_type_Int = ((AtomicInteger)((Pair)localPair.second).second).get();
      localauvw.jdField_a_of_type_Long = l1;
      localauvw.d = ((int)((CardProfile)localPair.first).uSource);
      ((ArrayList)localObject3).add(localauvw);
      ((AtomicInteger)((Pair)localPair.second).first).set(0);
      ((AtomicInteger)((Pair)localPair.second).second).set(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Auxh.a((ArrayList)localObject3, 511);
  }
  
  public void b(String paramString, int paramInt, boolean paramBoolean)
  {
    int j = 0;
    long l = Long.valueOf(paramString).longValue();
    if (QLog.isColorLevel()) {
      QLog.i("VisitorsActivity.VoteHelper", 2, "onVoteError, uin:" + paramString + " voteNum:" + paramInt);
    }
    paramString = jdField_a_of_type_JavaLangObject;
    int i = 0;
    label315:
    for (;;)
    {
      try
      {
        if (i < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.size())
        {
          CardProfile localCardProfile = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.get(i);
          if ((localCardProfile != null) && (localCardProfile.lEctID == l))
          {
            localCardProfile.bTodayVotedCnt -= paramInt;
            localCardProfile.bAvailableCnt += paramInt;
            localCardProfile.bVoteCnt = ((short)(localCardProfile.bVoteCnt - paramInt));
            if ((localCardProfile.bTodayVotedCnt > 0L) && (localCardProfile.bVoteCnt > 0)) {
              break label315;
            }
            this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_b_of_type_JavaUtilArrayList.remove(i);
            i = 1;
            if (j < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.size())
            {
              if (((CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j)).lEctID == l)
              {
                localCardProfile = (CardProfile)this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilArrayList.get(j);
                localCardProfile.bTodayVotedCnt -= paramInt;
                localCardProfile.bAvailableCnt += paramInt;
              }
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(l);
              if (i != 0) {
                this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.g();
              }
            }
          }
          else
          {
            i += 1;
            continue;
          }
          j += 1;
          continue;
        }
        i = 0;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwy
 * JD-Core Version:    0.7.0.1
 */