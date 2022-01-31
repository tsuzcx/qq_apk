package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.CustomWidgetUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import lep;
import leq;
import ler;
import les;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoySelfActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner
{
  private int jdField_a_of_type_Int;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public KandianMergeManager a;
  ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new les(this);
  public QQAppInterface a;
  private boolean jdField_a_of_type_Boolean = true;
  private TextView b;
  
  private void a()
  {
    this.app = ((QQAppInterface)super.getAppRuntime());
    if (this.app == null) {}
    int i;
    do
    {
      return;
      ReadInJoyWebDataManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
      {
        localObject = ReadInJoyWebDataManager.a();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0) {
          break label575;
        }
        i = 0;
        ((ReadInJoyWebDataManager)localObject).a(str, i);
      }
      setContentView(2130969639);
      a(2131367232, 2131428491, 0, 2130838631);
      a(2131367231, 2131428492, 0, 2130838631);
      a(2131367236, 2131428489, 0, 2130838631);
      a(2131367237, 2131428487, 0, 2130838631);
      a(2131367230, 2131428488, 0, 2130838631);
      setTitle("我的");
      this.leftView.setText("返回");
      localObject = this.mContentView.findViewById(2131367229);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(this);
      }
      localObject = ImageUtil.a();
      localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, Long.toString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()), 3, (Drawable)localObject, (Drawable)localObject);
      ((ImageView)this.mContentView.findViewById(2131362701)).setImageDrawable((Drawable)localObject);
      ((TextView)this.mContentView.findViewById(2131365428)).setText(ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
      this.mContentView.findViewById(2131367221).setOnClickListener(this);
      this.mContentView.findViewById(2131367233).setVisibility(8);
      if (!ReadInJoyConstants.jdField_a_of_type_Boolean) {
        break;
      }
      a(2131367238, 2131428490, 0, 2130838626);
      localObject = this.mContentView.findViewById(2131367238);
    } while (localObject == null);
    ((TextView)((View)localObject).findViewById(2131371143)).setText(ReadInJoyConstants.j);
    this.mContentView.findViewById(2131367237).setBackgroundResource(2130838629);
    c();
    Object localObject = this.mContentView.findViewById(2131362673);
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131367225));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        i = ReadInJoyHelper.y(getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "initUI followCnt:" + i);
        }
      }
    }
    localObject = this.mContentView.findViewById(2131367226);
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(this);
      this.b = ((TextView)this.mContentView.findViewById(2131367227));
      if (this.b != null)
      {
        i = ReadInJoyHelper.z(getAppRuntime());
        this.b.setText(ReadInJoyHelper.a(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "initUI fansCnt:" + i);
        }
      }
    }
    this.jdField_a_of_type_AndroidViewView = this.mContentView.findViewById(2131367222);
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      if (!ReadInJoyHelper.a(getAppRuntime()).booleanValue()) {
        break label580;
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      ((BounceScrollView)this.mContentView.findViewById(2131362823)).setDrawFinishedListener(new lep(this));
      return;
      label575:
      i = 1;
      break;
      label580:
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.mContentView == null) {}
    View localView;
    do
    {
      return;
      localView = this.mContentView.findViewById(paramInt1);
    } while (localView == null);
    TextView localTextView = (TextView)localView.findViewById(2131371143);
    localTextView.setText(paramInt2);
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView.setVisibility(0);
    localView.setBackgroundResource(paramInt4);
    localView.setOnClickListener(this);
  }
  
  private void c()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    if (this.mContentView == null) {
      return;
    }
    if (this.jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      CustomWidgetUtil.a((DragTextView)this.mContentView.findViewById(2131366789), i, this.jdField_a_of_type_Int, 2130845927, 99, null);
      return;
      i = 0;
    }
  }
  
  private void d()
  {
    ReadInJoyLogicEngine.a().d(this.app.c());
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new ler(this));
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)ReadInJoyUtils.a());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    a();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    c();
    d();
    if (!this.jdField_a_of_type_Boolean) {
      PublicTracker.a("self_tab_cost", null);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131367239: 
    default: 
      return;
    case 2131367229: 
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_a_of_type_Int), false);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
      }
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e() - this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0)
      {
        paramView = ReadInJoyConstants.g + i;
        ReadInJoyUtils.a(this.mContentView.getContext(), paramView);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.ReadInJoySelfActivity", 2, "person message box url: " + paramView);
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), false);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.j();
        return;
        paramView = ReadInJoyConstants.c + i;
        ReadInJoyUtils.a(this.mContentView.getContext(), i);
      }
    case 2131367221: 
      paramView = ReadInJoyUtils.a();
      if (TextUtils.isEmpty(paramView)) {
        QLog.e("Q.readinjoy.self.ReadInJoySelfActivity", 2, "click personal page , but uin is empty !");
      }
      for (;;)
      {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
        return;
        paramView = ReadInJoyConstants.f + Base64Util.encodeToString(paramView.getBytes(), 2);
        ReadInJoyUtils.a(this.mContentView.getContext(), paramView);
      }
    case 2131367237: 
      ThreadManager.postImmediately(new leq(this), null, true);
      startActivity(new Intent(this.mContentView.getContext(), ReadInJoySettingActivity.class));
      ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    case 2131367236: 
      ReadInJoyActivityHelper.b(this.mContentView.getContext());
      return;
    case 2131367238: 
      ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.k);
      return;
    case 2131362673: 
      ReadInJoyUtils.b(this.mContentView.getContext(), "https://post.mp.qq.com/mkandian/follow?_wv=7");
      return;
    case 2131367226: 
      ReadInJoyUtils.b(this.mContentView.getContext(), "https://post.mp.qq.com/mkandian/fan?_wv=7");
      return;
    case 2131367232: 
      ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.l);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    case 2131367230: 
      ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.m);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    }
    ReadInJoyUtils.a(this.mContentView.getContext(), ReadInJoyConstants.n);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", ReadInJoyUtils.a(this.mContentView.getContext(), "7.6.0".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySelfActivity
 * JD-Core Version:    0.7.0.1
 */