package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager.OnTabRedNumsChangeListenner;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
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
import com.tencent.widget.Switch;
import cooperation.readinjoy.ReadInJoyHelper;
import lnr;
import lns;
import lnt;
import lnu;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ReadInJoySelfFragment
  extends ReadInJoyBaseFragment
  implements View.OnClickListener, KandianMergeManager.OnTabRedNumsChangeListenner
{
  private int jdField_a_of_type_Int;
  public View a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView;
  private String jdField_a_of_type_JavaLangString = "";
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianMergeManager jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  private String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = true;
  private String c = "";
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {}
    View localView;
    do
    {
      return;
      localView = this.jdField_a_of_type_AndroidViewView.findViewById(paramInt1);
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
  
  private void h()
  {
    a(2131367232, 2131428491, 0, 2130838631);
    a(2131367231, 2131428492, 0, 2130838631);
    a(2131367237, 2131428487, 0, 2130838631);
    a(2131367230, 2131428488, 0, 2130838631);
    a(2131367236, 2131428489, 0, 2130838631);
    Object localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131367229);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = ImageUtil.a();
    localObject = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1, Long.toString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()), 3, (Drawable)localObject, (Drawable)localObject);
    ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362701)).setImageDrawable((Drawable)localObject);
    ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131365428)).setText(ContactUtils.l(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()));
    this.jdField_a_of_type_AndroidViewView.findViewById(2131367221).setOnClickListener(this);
    localObject = (Switch)this.jdField_a_of_type_AndroidViewView.findViewById(2131367235);
    ((Switch)localObject).setChecked(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.c());
    ((Switch)localObject).setOnClickListener(this);
    ((Switch)localObject).setOnCheckedChangeListener(new lnr(this));
    if (ReadInJoyConstants.a)
    {
      a(2131367238, 2131428490, 0, 2130838626);
      localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131367238);
      if (localObject == null) {
        return;
      }
      ((TextView)((View)localObject).findViewById(2131371143)).setText(ReadInJoyConstants.j);
      this.jdField_a_of_type_AndroidViewView.findViewById(2131367237).setBackgroundResource(2130838629);
    }
    i();
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131362673);
    int i;
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367225));
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        i = ReadInJoyHelper.y(getActivity().getAppRuntime());
        this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI followCnt:" + i);
        }
      }
    }
    localObject = this.jdField_a_of_type_AndroidViewView.findViewById(2131367226);
    if (localObject != null)
    {
      ((View)localObject).setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131367227));
      if (this.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        i = ReadInJoyHelper.z(getActivity().getAppRuntime());
        this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "initUI fansCnt:" + i);
        }
      }
    }
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131367222);
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (!ReadInJoyHelper.a(getActivity().getAppRuntime()).booleanValue()) {
        break label530;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362823));
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setDrawFinishedListener(new lns(this));
      return;
      label530:
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  private void i()
  {
    int i = 3;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
      }
      this.jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(3);
    } while (this.jdField_a_of_type_AndroidViewView == null);
    if (this.jdField_a_of_type_Int > 0) {}
    for (;;)
    {
      CustomWidgetUtil.a((DragTextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366789), i, this.jdField_a_of_type_Int, 2130845927, 99, null);
      return;
      i = 0;
    }
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ReadInJoyWebDataManager.a().b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null)) {
      return;
    }
    ReadInJoyWebDataManager localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
    String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() <= 0) {}
    for (int i = 0;; i = 1)
    {
      localReadInJoyWebDataManager.a(str, i);
      return;
    }
  }
  
  private void l()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView != null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.invalidate();
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "updateFollowAndFansCount followCnt:" + paramInt1 + ", fansCnt:" + paramInt2);
    }
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(paramInt1));
    }
    if (this.jdField_b_of_type_AndroidWidgetTextView != null) {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(ReadInJoyHelper.a(paramInt2));
    }
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      if (paramBoolean) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(boolean paramBoolean, Activity paramActivity, Bundle paramBundle)
  {
    super.a(paramBoolean, paramActivity, paramBundle);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    i();
    j();
    k();
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.self.SelfFragment", 2, "notifyShowSelf()");
    }
    ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
    l();
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().post(new lnu(this));
  }
  
  public void d()
  {
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
  }
  
  public void e() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131367239: 
    default: 
      return;
    case 2131367229: 
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB5", "0X8007DB5", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_a_of_type_Int), false);
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager == null) {
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
      }
      int i = this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.e() - this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
      if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b() > 0)
      {
        paramView = ReadInJoyConstants.g + i;
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.readinjoy.self.SelfFragment", 2, "person message box url: " + paramView);
        }
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ReadInJoyUtils.b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b()), false);
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b();
        this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
        if (ReadInJoyHelper.f()) {
          break;
        }
        ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161)).j();
        return;
        paramView = ReadInJoyConstants.c + i;
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), i);
      }
    case 2131367221: 
      paramView = ReadInJoyUtils.a();
      if (TextUtils.isEmpty(paramView)) {
        QLog.e("Q.readinjoy.self.SelfFragment", 2, "click personal page , but uin is empty !");
      }
      for (;;)
      {
        PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8007DB4", "0X8007DB4", 0, 0, "", "", "", ReadInJoyUtils.c(), false);
        return;
        paramView = ReadInJoyConstants.f + Base64Util.encodeToString(paramView.getBytes(), 2);
        ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), paramView);
      }
    case 2131367237: 
      ThreadManager.postImmediately(new lnt(this), null, true);
      startActivity(new Intent(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoySettingActivity.class));
      ReportController.b(null, "CliOper", "", "", "0X800705B", "0X800705B", 0, 0, "", "", "", ReadInJoyUtils.c());
      return;
    case 2131367236: 
      ReadInJoyActivityHelper.b(this.jdField_a_of_type_AndroidViewView.getContext());
      return;
    case 2131367238: 
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.k);
      return;
    case 2131362673: 
      ReadInJoyUtils.b(this.jdField_a_of_type_AndroidViewView.getContext(), "https://post.mp.qq.com/mkandian/follow?_wv=7");
      return;
    case 2131367226: 
      ReadInJoyUtils.b(this.jdField_a_of_type_AndroidViewView.getContext(), "https://post.mp.qq.com/mkandian/fan?_wv=7");
      return;
    case 2131367232: 
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.l);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845B", "0X800845B", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    case 2131367230: 
      ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.m);
      PublicAccountReportUtils.a(null, "CliOper", "", "", "0X800845A", "0X800845A", 0, 0, "", "", "", ReadInJoyUtils.a().toString(), false);
      return;
    }
    ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), ReadInJoyConstants.n);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008E3C", "0X8008E3C", 0, 0, "", "", "", ReadInJoyUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), "7.6.0".replace("", ""), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c()), false);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(getActivity());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130969639, paramViewGroup, false);
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(161));
    h();
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    i();
    ReadInJoyLogicEngine.a().d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoySelfFragment
 * JD-Core Version:    0.7.0.1
 */