package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.os.Looper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ComponentContentRecommend$7
  extends ReadInJoyObserver
{
  ComponentContentRecommend$7(ComponentContentRecommend paramComponentContentRecommend) {}
  
  public void a(boolean paramBoolean, long paramLong, List<RecommendFollowInfo> paramList)
  {
    if ((ComponentContentRecommend.a(this.a) == null) || (ComponentContentRecommend.a(this.a).mRecommendFollowInfos == null))
    {
      QQToast.a(ComponentContentRecommend.a(this.a), 1, HardCodeUtil.a(2131702376), 1).a();
      ComponentContentRecommend.a(this.a).clearAnimation();
    }
    while (ComponentContentRecommend.a(this.a).mArticleID != paramLong) {
      return;
    }
    if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0))
    {
      QQToast.a(ComponentContentRecommend.a(this.a), 1, HardCodeUtil.a(2131702379), 1).a();
      ComponentContentRecommend.a(this.a).clearAnimation();
      return;
    }
    ComponentContentRecommend.a(this.a).clearAnimation();
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.clear();
    ComponentContentRecommend.a(this.a).mRecommendFollowInfos.a.addAll(paramList);
    ReadInJoyLogicEngine.a().e(ComponentContentRecommend.a(this.a));
    ComponentContentRecommend.a(this.a).clear();
    ComponentContentRecommend.a(this.a).addAll(paramList);
    ComponentContentRecommend.a(this.a).notifyDataSetChanged();
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {}
    for (int i = 1; i == 0; i = 0)
    {
      QLog.e(ComponentContentRecommend.a, 2, "Please call this method in main thread!!!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ComponentContentRecommend.a, 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
    }
    Iterator localIterator = ComponentContentRecommend.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (paramLong == localRecommendFollowInfo.uin) {
        localRecommendFollowInfo.isFollowed = paramBoolean;
      }
    }
    ComponentContentRecommend.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.7
 * JD-Core Version:    0.7.0.1
 */