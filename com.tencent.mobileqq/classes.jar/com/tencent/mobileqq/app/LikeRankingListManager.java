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
  QQAppInterface a;
  String b;
  LikeRankingInfo c;
  List<LikeRankingInfo> d;
  int e;
  boolean f;
  long g = -1L;
  boolean h = true;
  boolean i = true;
  
  public LikeRankingListManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.c = new LikeRankingInfo();
    this.b = this.a.getCurrentAccountUin();
    if (!TextUtils.isEmpty(this.b)) {
      this.c.uin = Long.valueOf(this.b).longValue();
    }
    paramQQAppInterface = this.a.getPreferences();
    this.h = paramQQAppInterface.getBoolean("notify_on_like_ranking_list", true);
    this.c.totalLikeCount = paramQQAppInterface.getInt("like_ranking_list_total_like_count", -1);
    this.c.likeCountOfToday = paramQQAppInterface.getInt("like_ranking_list_today_like_count", -1);
    this.c.rankingNum = paramQQAppInterface.getInt("like_ranking_list_ranking_num", 0);
    this.i = paramQQAppInterface.getBoolean("partake__like_ranking_list", true);
  }
  
  public List<LikeRankingInfo> a()
  {
    List localList = this.d;
    if (localList == null) {
      return null;
    }
    return new ArrayList(localList);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 != this.c.likeCountOfToday) || (paramInt3 != this.c.totalLikeCount) || (paramInt2 != this.c.rankingNum))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LikeRankingListManager", 2, String.format("updateMyRank todayVoteCount:%d rank:%d total:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) }));
      }
      Object localObject = this.c;
      ((LikeRankingInfo)localObject).totalLikeCount = paramInt3;
      ((LikeRankingInfo)localObject).likeCountOfToday = paramInt1;
      ((LikeRankingInfo)localObject).rankingNum = paramInt2;
      localObject = this.a.getPreferences().edit();
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_total_like_count", paramInt3);
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_today_like_count", paramInt1);
      ((SharedPreferences.Editor)localObject).putInt("like_ranking_list_ranking_num", paramInt2);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
    SharedPreferences.Editor localEditor = this.a.getPreferences().edit();
    localEditor.putLong("like_ranking_list_animation_time", paramLong);
    localEditor.commit();
  }
  
  public void a(List<LikeRankingInfo> paramList, int paramInt, boolean paramBoolean)
  {
    this.d = new ArrayList(paramList);
    this.e = paramInt;
    this.f = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.h == paramBoolean) {
      return;
    }
    this.h = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify_on_like_ranking_list");
    localStringBuilder.append(this.b);
    localEditor.putBoolean(localStringBuilder.toString(), this.h).commit();
  }
  
  public LikeRankingInfo b()
  {
    return this.c;
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.i == paramBoolean) {
      return;
    }
    this.i = paramBoolean;
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.a.getApp()).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("partake__like_ranking_list");
    localStringBuilder.append(this.b);
    localEditor.putBoolean(localStringBuilder.toString(), this.i).commit();
    ((IUtil)QRoute.api(IUtil.class)).onLikeRankListConfigChanged(this.a, paramBoolean);
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public boolean d()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("notify_on_like_ranking_list");
    localStringBuilder.append(this.b);
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
  
  public boolean e()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.a.getApp());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("partake__like_ranking_list");
    localStringBuilder.append(this.b);
    this.i = ((SharedPreferences)localObject).getBoolean(localStringBuilder.toString(), true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPartakeRankingEnabled=");
      ((StringBuilder)localObject).append(this.i);
      QLog.d("LikeRankingListManager", 2, ((StringBuilder)localObject).toString());
    }
    return this.i;
  }
  
  public boolean f()
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(l);
    int j = localCalendar1.get(11);
    boolean bool = true;
    if ((j >= 22) && (j < 24))
    {
      if (this.g < 0L) {
        this.g = this.a.getPreferences().getLong("like_ranking_list_animation_time", 0L);
      }
      Calendar localCalendar2 = Calendar.getInstance();
      localCalendar2.setTimeInMillis(this.g);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.LikeRankingListManager
 * JD-Core Version:    0.7.0.1
 */