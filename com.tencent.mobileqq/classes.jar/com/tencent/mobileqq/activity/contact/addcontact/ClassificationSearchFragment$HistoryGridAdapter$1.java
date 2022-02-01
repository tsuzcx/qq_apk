package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
    PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem localPublicAccountSearchRecommendItem = (PublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramView.getTag();
    Object localObject = (PublicAccountDataManager)this.a.a.a.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if ((localObject != null) && (((PublicAccountDataManager)localObject).c(localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString) != null)) {}
    for (boolean bool = true;; bool = false)
    {
      if (bool)
      {
        localObject = new Intent(this.a.a.a(), ChatActivity.class);
        if (localPublicAccountSearchRecommendItem.jdField_a_of_type_Boolean)
        {
          ((Intent)localObject).putExtra("uintype", 1008);
          ((Intent)localObject).putExtra("uin", localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString);
          ((Intent)localObject).putExtra("uinname", localPublicAccountSearchRecommendItem.b);
          ((Intent)localObject).putExtra("start_time", System.currentTimeMillis());
          this.a.a.a().startActivity((Intent)localObject);
          label137:
          if (!ClassificationSearchFragment.HistoryGridAdapter.a(this.a)) {
            break label396;
          }
        }
      }
      label396:
      for (localObject = "houtai";; localObject = "duan")
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.a.a.a, localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString, "0X8007404", "0X8007404", 0, 0, "", "", (String)localObject, "");
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder("clickRecommendAccount->");
          localStringBuilder.append("source:").append((String)localObject);
          localStringBuilder.append(", puin:").append(localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(", isFollow:").append(bool);
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ((Intent)localObject).putExtra("uintype", 1024);
        break;
        if (localPublicAccountSearchRecommendItem.jdField_a_of_type_Boolean)
        {
          localObject = new ActivityURIRequest(this.a.a.a(), "/pubaccount/detail");
          ((ActivityURIRequest)localObject).extra().putInt("uintype", 1008);
          ((ActivityURIRequest)localObject).extra().putInt("source", 118);
          QRoute.startUri((URIRequest)localObject, null);
          break label137;
        }
        localObject = CrmUtils.a(this.a.a.a(), null, "", false, -1, false, -1);
        ((Intent)localObject).putExtra("uin", localPublicAccountSearchRecommendItem.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).addFlags(67108864);
        this.a.a.a().startActivity((Intent)localObject);
        break label137;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.HistoryGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */