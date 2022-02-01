package com.tencent.biz.qqcircle.bizparts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleSettingBean;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.biz.qqcircle.publish.account.LoginData;
import com.tencent.biz.qqcircle.requests.QCircleGetCircleUnCareListRequest;
import com.tencent.biz.qqcircle.viewmodels.QCirclePersonalDetailViewModel;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;

public class QCirclePrivacySettingContentPart
  extends QCircleBasePart
  implements View.OnClickListener
{
  private TextView a;
  private Switch c;
  private Switch d;
  private Switch e;
  
  private void a(int paramInt)
  {
    if (paramInt == 0)
    {
      this.a.setText("");
      return;
    }
    if (paramInt < 100)
    {
      TextView localTextView = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramInt);
      localTextView.setText(localStringBuilder.toString());
      return;
    }
    this.a.setText("99+");
  }
  
  private void a(Switch paramSwitch)
  {
    paramSwitch.setThumbDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845442));
    paramSwitch.setTrackDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845443));
  }
  
  public static void a(boolean paramBoolean, VSDispatchObserver.onVSRspCallBack<Object> paramonVSRspCallBack)
  {
    if (paramBoolean) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    QCircleConfigHelper.b("qqcircle", "recommend_video_template_profile_switch", (String)localObject);
    LocalMultiProcConfig.putBool("recommend_video_template_profile_switch", paramBoolean);
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("recommend_video_template_profile_switch", localObject);
    localHashMap1.put("qqcircle", localHashMap2);
    Object localObject = paramonVSRspCallBack;
    if (paramonVSRspCallBack == null) {
      localObject = new QCirclePrivacySettingContentPart.4(paramBoolean);
    }
    VSNetworkHelper.getInstance().sendRequest(new QCircleSetMultiCircleWnsConfigRequest(localHashMap1), (VSDispatchObserver.onVSRspCallBack)localObject);
  }
  
  private void b(View paramView)
  {
    this.c = ((Switch)paramView.findViewById(2131441874));
    a(this.c);
    this.c.setOnCheckedChangeListener(new QCirclePrivacySettingContentPart.1(this));
  }
  
  private void d(View paramView)
  {
    this.d = ((Switch)paramView.findViewById(2131441873));
    a(this.d);
    this.d.setOnCheckedChangeListener(new QCirclePrivacySettingContentPart.2(this));
    if (!QCircleConfigHelper.ai())
    {
      QLog.i("QCirclePrivacySettingContentPartonInitView", 2, "QCircleConfigHelper.isQQCircleShowTroopToolBarEntrance()==false");
      paramView.findViewById(2131441870).setVisibility(8);
    }
  }
  
  private void e(View paramView)
  {
    this.e = ((Switch)paramView.findViewById(2131441872));
    a(this.e);
    ((TextView)paramView.findViewById(2131441848)).setText(QCircleConfigHelper.a("qqcircle", "qqcircle_recommend_video_template_profile_switch_header", g().getString(2131895880)));
    ((TextView)paramView.findViewById(2131448668)).setText(QCircleConfigHelper.a("qqcircle", "qqcircle_recommend_video_template_profile_switch_hint", g().getString(2131895881)));
    boolean bool = "1".equals(QCircleConfigHelper.a("qqcircle", "recommend_video_template_profile_switch", "1"));
    this.e.setChecked(bool);
    this.e.setOnCheckedChangeListener(new QCirclePrivacySettingContentPart.3(this));
  }
  
  private void i()
  {
    Object localObject = (QCircleSettingBean)c().getIntent().getSerializableExtra("key_bundle_common_init_bean");
    if (localObject != null)
    {
      this.c.setChecked(((QCircleSettingBean)localObject).canJumpProfile());
      this.d.setChecked(((QCircleSettingBean)localObject).canSyncTroopARK());
      return;
    }
    localObject = (QCirclePersonalDetailViewModel)a(QCirclePersonalDetailViewModel.class);
    ((QCirclePersonalDetailViewModel)localObject).a(LoginData.a().c(), null);
    ((QCirclePersonalDetailViewModel)localObject).b().observe(j(), new QCirclePrivacySettingContentPart.5(this));
    ((QCirclePersonalDetailViewModel)localObject).a(true);
  }
  
  public String a()
  {
    return "QCirclePrivacySettingContentPart";
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    b(paramView);
    d(paramView);
    e(paramView);
    ImageView localImageView = (ImageView)paramView.findViewById(2131436618);
    localImageView.setOnClickListener(this);
    if ((j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)j()).a(localImageView);
    }
    paramView.findViewById(2131441869).setOnClickListener(this);
    this.a = ((TextView)paramView.findViewById(2131441576));
    i();
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    super.onActivityResumed(paramActivity);
    VSNetworkHelper.getInstance().sendRequest(new QCircleGetCircleUnCareListRequest(1), new QCirclePrivacySettingContentPart.6(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 2131436618)
    {
      if ((!j().onBackEvent()) && (c() != null)) {
        c().finish();
      }
    }
    else if (i == 2131441869) {
      QCircleLauncher.e(paramView.getContext(), new QCircleInitBean());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePrivacySettingContentPart
 * JD-Core Version:    0.7.0.1
 */