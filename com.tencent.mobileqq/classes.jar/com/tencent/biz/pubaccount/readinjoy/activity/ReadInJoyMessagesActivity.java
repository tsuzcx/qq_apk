package com.tencent.biz.pubaccount.readinjoy.activity;

import abqw;
import ajgx;
import alpo;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import azmj;
import bdag;
import bhpo;
import bhpy;
import bhql;
import bhwu;
import bhyj;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;
import nrt;
import nzf;
import nzg;
import nzh;
import org.json.JSONException;
import org.json.JSONObject;
import ors;
import owr;
import owy;
import oxb;
import oxd;
import oxe;
import qzi;
import stn;
import sts;
import sut;
import suv;
import syp;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements ajgx, View.OnClickListener, bhpo, bhwu, owr
{
  public static int a;
  public static final String a;
  public static int b;
  public View a;
  private bhyj jdField_a_of_type_Bhyj = new nzg(this);
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private List<sut> jdField_a_of_type_JavaUtilList;
  private oxe jdField_a_of_type_Oxe = new nzf(this);
  private sts jdField_a_of_type_Sts;
  public boolean a;
  public boolean b;
  private int c = 0;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = alpo.a(2131713508);
  }
  
  public static DragFrameLayout a(Activity paramActivity)
  {
    DragFrameLayout localDragFrameLayout = null;
    ViewGroup localViewGroup = (ViewGroup)paramActivity.getWindow().getDecorView();
    int i = 0;
    View localView = null;
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        localView = localViewGroup.getChildAt(i);
        if ((localView instanceof DragFrameLayout)) {
          return (DragFrameLayout)localView;
        }
        if (!(localView instanceof TopGestureLayout)) {}
      }
      else
      {
        if (localView != null)
        {
          localDragFrameLayout = new DragFrameLayout(paramActivity.getApplication());
          localViewGroup.addView(localDragFrameLayout, 0);
          localViewGroup.removeView(localView);
          if (localView.getParent() != null) {
            ((ViewGroup)localView.getParent()).removeView(localView);
          }
          localDragFrameLayout.addView(localView);
        }
        return localDragFrameLayout;
      }
      i += 1;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)super.getAppRuntime());
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    setContentView(2131560130);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    setTitle(jdField_a_of_type_JavaLangString);
    this.leftView.setText(alpo.a(2131713314));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131365759);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366279));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131166272));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296787));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_Bhyj);
    this.jdField_a_of_type_Sts = new sts(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_Sts.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Sts);
    this.jdField_a_of_type_Sts.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166014);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
  }
  
  private void d()
  {
    oxb.a().a(this.jdField_a_of_type_Oxe);
    qzi localqzi;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localqzi = qzi.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 1)
    {
      localqzi.a(str, i);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Sts.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378291)).setText(alpo.a(2131713301));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372420)).setImageResource(2130842432);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166014);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130849999);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166014);
  }
  
  public void a()
  {
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      super.getWindow().addFlags(67108864);
      if (this.mSystemBarComp == null) {
        this.mSystemBarComp = new SystemBarCompact(this, true, -1);
      }
      this.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label161;
      }
      if ((bdag.b()) || (bdag.d())) {
        break label140;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848925);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label140:
      this.mSystemBarComp.setStatusBarColor(-7829368);
      this.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label161:
      if ((Build.VERSION.SDK_INT >= 23) && (!bdag.b()) && (!bdag.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!bdag.b()) && (!bdag.d()))
      {
        this.mSystemBarComp.setStatusBarColor(-4210753);
      }
      else
      {
        this.mSystemBarComp.setStatusBarColor(-1);
        this.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void a(View paramView) {}
  
  public void a(List<sut> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_Sts == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
      return;
    }
    if (paramList != null) {
      this.jdField_a_of_type_JavaUtilList = paramList;
    }
    if (this.c != 0)
    {
      ThreadManager.getUIHandler().postDelayed(new ReadInJoyMessagesActivity.3(this, paramList), 1500L);
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Sts.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Sts.b();
    this.jdField_a_of_type_Sts.c();
    this.jdField_a_of_type_Sts.notifyDataSetChanged();
    e();
  }
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131379267))
    {
      paramDragFrameLayout = (sut)paramDragFrameLayout.a().getTag(2131377191);
      if (paramDragFrameLayout != null)
      {
        azmj.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void b()
  {
    ((oxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a().e();
    qzi localqzi;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localqzi = qzi.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localqzi.a(str, i);
      return;
    }
  }
  
  public void b(View paramView) {}
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    c();
    a();
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeHandler(getClass());
    }
    if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
    {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(null);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(null);
    }
    if (this.jdField_a_of_type_Sts != null)
    {
      this.jdField_a_of_type_Sts.a();
      this.jdField_a_of_type_Sts = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    oxb.a().b(this.jdField_a_of_type_Oxe);
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    ((oxd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a().e();
  }
  
  public void finish()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("extra_private_letter_count", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.d());
    setResult(-1, localIntent);
    super.finish();
  }
  
  public boolean onBackEvent()
  {
    if (getIntent().getBooleanExtra("shouldBackSelfAct", false))
    {
      Intent localIntent = new Intent(this, ReadInJoySelfActivity.class);
      localIntent.setFlags(67108864);
      startActivity(localIntent);
    }
    return super.onBackEvent();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131377188: 
      do
      {
        return;
      } while (((Integer)paramView.getTag(2131377192)).intValue() != stn.d);
      localObject2 = paramView.getTag(2131377191);
      Object localObject3 = paramView.getTag(2131377200);
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label490;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label495;
        }
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject2 = "";
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", ors.d);
          ((JSONObject)localObject3).put("reddot_num", localInteger);
          localObject3 = ((JSONObject)localObject3).toString();
          localObject2 = localObject3;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            localJSONException.printStackTrace();
            continue;
            paramView = "";
          }
        }
        nrt.a(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject2, false);
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        nrt.a(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", ors.c(localInteger.intValue()), false);
        if (TextUtils.isEmpty(suv.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        paramView = paramView.getTag(2131377193);
        if (paramView == null) {
          break label544;
        }
        paramView = (String)paramView;
        localObject2 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject2).putExtra("uintype", 1008);
        ((Intent)localObject2).putExtra("uin", (String)localObject1);
        ((Intent)localObject2).putExtra("uinname", paramView);
        ((Intent)localObject2).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject2).putExtra("red_hot_count", localInteger);
        ((Intent)localObject2).putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity((Intent)localObject2);
        syp.a(null, "SUBSCRIPT_AIO_COST");
        return;
        localObject1 = "";
        break;
        i = 0;
        break label128;
        azmj.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131370196: 
      paramView = paramView.getTag(2131377200);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        owy.a().a(paramView);
        return;
      }
    case 2131370202: 
      paramView = paramView.getTag(2131377200);
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        owy.a().b(paramView);
        return;
      }
    case 2131370201: 
      localObject1 = paramView.getTag(2131377200);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        paramView = paramView.getTag(2131377193);
        if (paramView == null) {
          break label740;
        }
      }
      for (paramView = (String)paramView;; paramView = "")
      {
        localObject2 = (bhpy)bhql.a(getActivity(), null);
        ((bhpy)localObject2).a(String.format(getResources().getString(2131696972), new Object[] { paramView }));
        ((bhpy)localObject2).a(2131696917, 3);
        ((bhpy)localObject2).c(2131690648);
        ((bhpy)localObject2).a(new nzh(this, (String)localObject1, (bhpy)localObject2));
        ((bhpy)localObject2).show();
        return;
        localObject1 = "";
        break;
      }
    case 2131370180: 
      label128:
      label490:
      label495:
      paramView = paramView.getTag(2131377200);
      label544:
      label740:
      if (paramView != null) {}
      for (paramView = (String)paramView;; paramView = "")
      {
        owy.a().c(paramView);
        return;
      }
    }
    int j = ((Integer)paramView.getTag(2131377192)).intValue();
    int i = ((Integer)paramView.getTag(2131375192)).intValue();
    if (j == stn.e) {
      ors.a(this, (String)paramView.getTag(2131377396));
    }
    j = ((Integer)paramView.getTag(2131375191)).intValue();
    if (j == jdField_a_of_type_Int) {
      nrt.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ors.c(i), false);
    }
    for (;;)
    {
      paramView.findViewById(2131379267).setVisibility(8);
      paramView.findViewById(2131362838).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.k();
      return;
      if (j == jdField_b_of_type_Int) {
        nrt.a(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", ors.c(i), false);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.c = paramInt;
    switch (paramInt)
    {
    default: 
      abqw.a().a("list_subscript");
      return;
    }
    abqw.a().a("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */