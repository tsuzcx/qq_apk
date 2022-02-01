package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ClassificationSearchFragment$HistoryGridAdapter$1
  implements View.OnClickListener
{
  ClassificationSearchFragment$HistoryGridAdapter$1(ClassificationSearchFragment.HistoryGridAdapter paramHistoryGridAdapter) {}
  
  public void onClick(View paramView)
  {
    IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem localPublicAccountSearchRecommendItem = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramView.getTag();
    Object localObject = (IPublicAccountDataManager)this.a.a.r.getRuntimeService(IPublicAccountDataManager.class, "all");
    boolean bool;
    if ((localObject != null) && ((PublicAccountInfo)((IPublicAccountDataManager)localObject).findPublicAccountInfoCache(localPublicAccountSearchRecommendItem.a) != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      localObject = new Intent(this.a.a.o(), ChatActivity.class);
      if (localPublicAccountSearchRecommendItem.c) {
        ((Intent)localObject).putExtra("uintype", 1008);
      } else {
        ((Intent)localObject).putExtra("uintype", 1024);
      }
      ((Intent)localObject).putExtra("uin", localPublicAccountSearchRecommendItem.a);
      ((Intent)localObject).putExtra("uinname", localPublicAccountSearchRecommendItem.b);
      ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
      this.a.a.o().startActivity((Intent)localObject);
    }
    else if (localPublicAccountSearchRecommendItem.c)
    {
      localObject = new ActivityURIRequest(this.a.a.o(), "/pubaccount/detail");
      ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
      ((ActivityURIRequest)localObject).extra().putInt("source", 118);
      QRoute.startUri((URIRequest)localObject, null);
    }
    else
    {
      localObject = CrmUtils.a(this.a.a.o(), null, "", false, -1, false, -1);
      ((Intent)localObject).putExtra("uin", localPublicAccountSearchRecommendItem.a);
      ((Intent)localObject).addFlags(67108864);
      this.a.a.o().startActivity((Intent)localObject);
    }
    if (ClassificationSearchFragment.HistoryGridAdapter.a(this.a)) {
      localObject = "houtai";
    } else {
      localObject = "duan";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.a.r, localPublicAccountSearchRecommendItem.a, "0X8007404", "0X8007404", 0, 0, "", "", (String)localObject, "");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("clickRecommendAccount->");
      localStringBuilder.append("source:");
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(", puin:");
      localStringBuilder.append(localPublicAccountSearchRecommendItem.a);
      localStringBuilder.append(", isFollow:");
      localStringBuilder.append(bool);
      QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.HistoryGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */