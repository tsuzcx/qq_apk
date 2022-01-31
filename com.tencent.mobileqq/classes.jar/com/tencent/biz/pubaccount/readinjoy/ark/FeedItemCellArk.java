package com.tencent.biz.pubaccount.readinjoy.ark;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class FeedItemCellArk
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private ArkAppContainer jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
  private ArkAppView jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
  private ArkAppMessage jdField_a_of_type_ComTencentMobileqqDataArkAppMessage;
  private View b;
  
  public FeedItemCellArk(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (ReadInJoyUtils.a() != null)
    {
      MobileQQ localMobileQQ = ReadInJoyUtils.a().getApplication();
      if (localMobileQQ == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FeedItemCellArk", 2, "FeedItemCellArk, context is null.");
        }
        return;
      }
      this.jdField_a_of_type_AndroidContentContext = localMobileQQ;
    }
    b(paramArkAppMessage, paramBaseArticleInfo);
  }
  
  private LinearLayout a(View paramView)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramView != null)
    {
      localObject1 = localObject2;
      if ((paramView.getParent() instanceof LinearLayout)) {
        localObject1 = (LinearLayout)paramView.getParent();
      }
    }
    return localObject1;
  }
  
  private void a(ArkAppMessage paramArkAppMessage)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage = new ArkAppMessage();
    }
    if (paramArkAppMessage == null) {
      return;
    }
    b(paramArkAppMessage);
  }
  
  private boolean a(ArkAppMessage paramArkAppMessage)
  {
    return (ReadInJoyArkUtil.b(this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage)) && (ReadInJoyArkUtil.b(paramArkAppMessage)) && (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appName.equals(paramArkAppMessage.appName)) && (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appView.equals(paramArkAppMessage.appView)) && (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appMinVersion.equals(paramArkAppMessage.appMinVersion)) && (this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.metaList.equals(paramArkAppMessage.metaList));
  }
  
  private void b(View paramView)
  {
    LinearLayout localLinearLayout = a(paramView);
    if (localLinearLayout != null) {
      localLinearLayout.removeView(paramView);
    }
  }
  
  private void b(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  private void b(ArkAppMessage paramArkAppMessage)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage != null) && (paramArkAppMessage != null))
    {
      if (!TextUtils.isEmpty(paramArkAppMessage.appName)) {
        this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appName = paramArkAppMessage.appName;
      }
      if (!TextUtils.isEmpty(paramArkAppMessage.appView)) {
        this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appView = paramArkAppMessage.appView;
      }
      if (!TextUtils.isEmpty(paramArkAppMessage.appMinVersion)) {
        this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.appMinVersion = paramArkAppMessage.appMinVersion;
      }
      if (!TextUtils.isEmpty(paramArkAppMessage.metaList)) {
        this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage.metaList = paramArkAppMessage.metaList;
      }
    }
  }
  
  private void b(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    a(paramArkAppMessage);
    b(paramBaseArticleInfo);
    c();
    d();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localReadInJoyArkItem = ReadInJoyArkCache.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendSeq, this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (localReadInJoyArkItem != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      }
    }
    while (!QLog.isColorLevel())
    {
      ReadInJoyArkCache.ReadInJoyArkItem localReadInJoyArkItem;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("FeedItemCellArk", 2, "ArkItem is null.");
      return;
    }
    QLog.d("FeedItemCellArk", 2, new Object[] { "ArkAppMessage is null or ArticleInfo is null or Context is null, mArkAppMessage: ", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage, ", mArticleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo });
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_AndroidViewView == null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      if (this.b == null)
      {
        this.b = new View(this.jdField_a_of_type_AndroidContentContext);
        this.b.setBackgroundColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131493479));
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, AIOUtils.a(5.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
        if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mChannelID == 70L)) {
          localLayoutParams.height = AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        }
        this.b.setLayoutParams(localLayoutParams);
      }
      b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
      b(this.b);
      localLinearLayout.addView(this.b);
      a(localLinearLayout);
    }
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FeedItemCellArk", 2, "refreshArkAppView.");
    }
    f();
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo != null) && (this.jdField_a_of_type_AndroidContentContext != null))
    {
      localReadInJoyArkItem = ReadInJoyArkCache.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mRecommendSeq, this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo);
      if (localReadInJoyArkItem != null)
      {
        if ((this.jdField_a_of_type_AndroidViewView instanceof LinearLayout))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.getParent() == this.jdField_a_of_type_AndroidViewView) {
            b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          }
          b(localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView);
          ((LinearLayout)this.jdField_a_of_type_AndroidViewView).addView(localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView, 0);
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView = localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer = localReadInJoyArkItem.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer;
      }
    }
    while (!QLog.isColorLevel())
    {
      ReadInJoyArkCache.ReadInJoyArkItem localReadInJoyArkItem;
      do
      {
        return;
      } while (!QLog.isColorLevel());
      QLog.d("FeedItemCellArk", 2, "ArkItem is null.");
      return;
    }
    QLog.d("FeedItemCellArk", 2, new Object[] { "ArkAppMessage is null or ArticleInfo is null or Context is null, mArkAppMessage: ", this.jdField_a_of_type_ComTencentMobileqqDataArkAppMessage, ", mArticleInfo: ", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo });
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FeedItemCellArk", 2, "pause arkContainer.");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(0);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(BaseArticleInfo paramBaseArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
  }
  
  public void a(ArkAppMessage paramArkAppMessage, BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramArkAppMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("FeedItemCellArk", 2, "bindData() arkAppMessage is null");
      }
    }
    do
    {
      return;
      if ((!a(paramArkAppMessage)) || (!ReadInJoyArkCache.a.a()))
      {
        b(paramArkAppMessage);
        a(paramBaseArticleInfo);
        e();
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer == null));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppView.initArkView(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FeedItemCellArk", 2, "resume arkContainer.");
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppContainer.doOnEvent(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ark.FeedItemCellArk
 * JD-Core Version:    0.7.0.1
 */