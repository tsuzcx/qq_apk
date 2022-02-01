import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mqq.manager.Manager;

public class anxs
  implements Manager
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = -1L;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  LikeRankingInfo jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
  String jdField_a_of_type_JavaLangString;
  List<LikeRankingInfo> jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  boolean b = true;
  boolean c = true;
  
  public anxs(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo = new LikeRankingInfo();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.uin = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    }
    paramQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    this.b = paramQQAppInterface.getBoolean("notify_on_like_ranking_list", true);
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.totalLikeCount = paramQQAppInterface.getInt("like_ranking_list_total_like_count", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday = paramQQAppInterface.getInt("like_ranking_list_today_like_count", -1);
    this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum = paramQQAppInterface.getInt("like_ranking_list_ranking_num", 0);
    this.c = paramQQAppInterface.getBoolean("partake__like_ranking_list", true);
  }
  
  public LikeRankingInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
  }
  
  public List<LikeRankingInfo> a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return new ArrayList(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday) || (paramInt3 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.totalLikeCount) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LikeRankingListManager", 2, String.format("updateMyRank todayVoteCount:%d rank:%d total:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.totalLikeCount = paramInt3;
      this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday = paramInt1;
      this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum = paramInt2;
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      localEditor.putInt("like_ranking_list_total_like_count", paramInt3);
      localEditor.putInt("like_ranking_list_today_like_count", paramInt1);
      localEditor.putInt("like_ranking_list_ranking_num", paramInt2);
      localEditor.commit();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
    localEditor.putLong("like_ranking_list_animation_time", paramLong);
    localEditor.commit();
  }
  
  public void a(List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.b == paramBoolean) {
      return;
    }
    this.b = paramBoolean;
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit().putBoolean("notify_on_like_ranking_list" + this.jdField_a_of_type_JavaLangString, this.b).commit();
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.c == paramBoolean) {
      return;
    }
    this.c = paramBoolean;
    PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit().putBoolean("partake__like_ranking_list" + this.jdField_a_of_type_JavaLangString, this.c).commit();
    aymo.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public boolean b()
  {
    boolean bool = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean("notify_on_like_ranking_list" + this.jdField_a_of_type_JavaLangString, true);
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListManager", 2, "getNotificationSwitch=" + bool);
    }
    return bool;
  }
  
  public boolean c()
  {
    this.c = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).getBoolean("partake__like_ranking_list" + this.jdField_a_of_type_JavaLangString, true);
    if (QLog.isColorLevel()) {
      QLog.d("LikeRankingListManager", 2, "getPartakeRankingEnabled=" + this.c);
    }
    return this.c;
  }
  
  public boolean d()
  {
    boolean bool2 = false;
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l);
    int i = localCalendar1.get(11);
    boolean bool1 = bool2;
    if (i >= 22)
    {
      bool1 = bool2;
      if (i < 24)
      {
        if (this.jdField_a_of_type_Long < 0L) {
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("like_ranking_list_animation_time", 0L);
        }
        Calendar localCalendar2 = Calendar.getInstance();
        localCalendar2.setTimeInMillis(this.jdField_a_of_type_Long);
        if (localCalendar2.get(1) == localCalendar1.get(1))
        {
          bool1 = bool2;
          if (localCalendar2.get(6) == localCalendar1.get(6)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxs
 * JD-Core Version:    0.7.0.1
 */