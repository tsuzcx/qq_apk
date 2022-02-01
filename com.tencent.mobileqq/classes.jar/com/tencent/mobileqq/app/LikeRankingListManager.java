package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.redtouch.IUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import mqq.manager.Manager;

public class LikeRankingListManager
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
  
  public LikeRankingListManager(QQAppInterface paramQQAppInterface)
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
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return null;
    }
    return new ArrayList(localList);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.likeCountOfToday) || (paramInt3 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.totalLikeCount) || (paramInt2 != this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo.rankingNum))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LikeRankingListManager", 2, String.format("updateMyRank todayVoteCount:%d rank:%d total:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataLikeRankingInfo;
      ((LikeRankingInfo)localObject).totalLikeCount = paramInt3;
      ((LikeRankingInfo)localObject).likeCountOfToday = paramInt1;
      ((LikeRankingInfo)localObject).rankingNum = paramInt2;
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit();
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_total_like_count", paramInt3);
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_today_like_count", paramInt1);
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_ranking_num", paramInt2);
      ((SharedPreferences.Editor)localObject).commit();
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
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify_on_like_ranking_list");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localEditor.putBoolean(localStringBuilder.toString(), this.b).commit();
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
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("partake__like_ranking_list");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localEditor.putBoolean(localStringBuilder.toString(), this.c).commit();
    ((IUtil)QRoute.api(IUtil.class)).onLikeRankListConfigChanged(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
  }
  
  public boolean b()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify_on_like_ranking_list");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    boolean bool = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNotificationSwitch=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("LikeRankingListManager", 2, ((StringBuilder)localObject).toString());
    }
    return bool;
  }
  
  public boolean c()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("partake__like_ranking_list");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    this.c = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPartakeRankingEnabled=");
      ((StringBuilder)localObject).append(this.c);
      QLog.d("LikeRankingListManager", 2, ((StringBuilder)localObject).toString());
    }
    return this.c;
  }
  
  public boolean d()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l);
    int i = localCalendar1.get(11);
    boolean bool = true;
    if ((i >= 22) && (i < 24))
    {
      if (this.jdField_a_of_type_Long < 0L) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("like_ranking_list_animation_time", 0L);
      }
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(this.jdField_a_of_type_Long);
      if (localCalendar2.get(1) != localCalendar1.get(1)) {
        break label117;
      }
      if (localCalendar2.get(6) != localCalendar1.get(6)) {
        return true;
      }
    }
    bool = false;
    label117:
    return bool;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.LikeRankingListManager
 * JD-Core Version:    0.7.0.1
 */