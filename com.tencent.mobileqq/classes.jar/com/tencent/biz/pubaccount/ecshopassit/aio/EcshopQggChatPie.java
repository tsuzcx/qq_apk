package com.tencent.biz.pubaccount.ecshopassit.aio;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.ecshopassit.ABTestInfo;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfBean;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfProcessor;
import com.tencent.biz.pubaccount.ecshopassit.conf.EcshopConfUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.ABTestUtil;
import com.tencent.biz.pubaccount.ecshopassit.utils.EcshopUtils;
import com.tencent.biz.pubaccount.ecshopassit.utils.RedPointUtil;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTabView;
import com.tencent.biz.pubaccount.ecshopassit.view.CustomTitleView;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EcshopQggChatPie
  implements IEcshopChatPie
{
  private CustomTabView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView;
  private CustomTitleView jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView;
  public String a;
  
  public EcshopQggChatPie()
  {
    this.jdField_a_of_type_JavaLangString = "bottom";
  }
  
  private void a()
  {
    ABTestInfo localABTestInfo = ABTestUtil.a("exp_qqshop_tabbar");
    if (localABTestInfo != null) {
      this.jdField_a_of_type_JavaLangString = localABTestInfo.a("tab_show", "bottom");
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {
      paramContext.sendBroadcast(new Intent("com.tencent.biz.pubaccount.ecshop.tabpage.finish"));
    }
    if ("top".equals(this.jdField_a_of_type_JavaLangString)) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a();
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    if (("top".equals(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.findViewById(2131369878).setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.findViewById(2131369501).setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(MessageRecord paramMessageRecord) {}
  
  public void a(List<ChatMessage> paramList, IEcshopChatPie.IRefreshCallback paramIRefreshCallback)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)localIterator.next();
        localChatMessage.removeExtInfoToExtStr("add_title");
        if (EcshopUtils.a(localChatMessage) == 1) {
          localIterator.remove();
        }
      }
    }
    if (paramIRefreshCallback != null) {
      paramIRefreshCallback.a(paramList);
    }
  }
  
  public boolean a(Context paramContext, RelativeLayout paramRelativeLayout)
  {
    EcshopConfBean localEcshopConfBean = EcshopConfProcessor.a();
    if (EcshopConfUtil.a(localEcshopConfBean))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.d("EcshopMinusViewChatPie", 2, "initPublicAccountMenu new qqshop pubaccount return");
      }
      if ("top".equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView = new CustomTitleView(paramContext);
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(localEcshopConfBean, 1))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.setTag("echopCustomTabView");
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(1);
          paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView);
          paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.getLayoutParams();
          if (paramContext != null)
          {
            paramContext.width = -1;
            paramContext.height = -2;
            paramContext.addRule(10);
          }
          paramContext = RedPointUtil.a();
          RedPointUtil.a(paramContext);
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTitleView.a(paramContext);
          return true;
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView = new CustomTabView(paramContext);
        if (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(localEcshopConfBean, 1))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.setTag("echopCustomTabView");
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(1);
          paramRelativeLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView);
          paramContext = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.getLayoutParams();
          if (paramContext != null)
          {
            paramContext.width = -1;
            paramContext.height = -2;
            paramContext.addRule(12);
          }
          paramContext = RedPointUtil.a();
          RedPointUtil.a(paramContext);
          this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitViewCustomTabView.a(paramContext);
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean a(RelativeLayout paramRelativeLayout)
  {
    return (EcshopConfUtil.a()) && (paramRelativeLayout != null) && (paramRelativeLayout.findViewWithTag("echopCustomTabView") != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.aio.EcshopQggChatPie
 * JD-Core Version:    0.7.0.1
 */