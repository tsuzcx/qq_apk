package com.tencent.biz.pubaccount.readinjoy.activity;

import Override;
import adlb;
import alpv;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import anzj;
import bdll;
import bhjr;
import blih;
import blir;
import blji;
import blpp;
import blrf;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.List;
import mqq.os.MqqHandler;
import ocd;
import oki;
import okj;
import okk;
import org.json.JSONException;
import org.json.JSONObject;
import ozs;
import peu;
import pfa;
import pfd;
import pfg;
import pfh;
import rlz;
import tvc;
import tvh;
import twi;
import twk;
import uae;

public class ReadInJoyMessagesActivity
  extends IphoneTitleBarActivity
  implements alpv, View.OnClickListener, blih, blpp, peu
{
  public static int a;
  public static final String a;
  public static int b;
  public View a;
  private blrf jdField_a_of_type_Blrf = new okj(this);
  private KandianMergeManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager;
  protected DragFrameLayout a;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private List<twi> jdField_a_of_type_JavaUtilList;
  private pfh jdField_a_of_type_Pfh = new oki(this);
  private tvh jdField_a_of_type_Tvh;
  public boolean a;
  public boolean b;
  private int c = 0;
  
  static
  {
    jdField_b_of_type_Int = 1;
    jdField_a_of_type_JavaLangString = anzj.a(2131712008);
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
    setContentView(2131560283);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager = ((KandianMergeManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(162));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = a(getActivity());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    }
    setTitle(jdField_a_of_type_JavaLangString);
    this.leftView.setText(anzj.a(2131711814));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131366048);
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)findViewById(2131366584));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDivider(getResources().getDrawable(2131166349));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDividerHeight(getResources().getDimensionPixelSize(2131296849));
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDrawFinishedListener(this.jdField_a_of_type_Blrf);
    this.jdField_a_of_type_Tvh = new tvh(getActivity(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipListView, getActivity().getLayoutInflater());
    this.jdField_a_of_type_Tvh.a(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_Tvh);
    this.jdField_a_of_type_Tvh.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166070);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setRightIconMenuListener(this);
  }
  
  private void d()
  {
    pfd.a().a(this.jdField_a_of_type_Pfh);
    rlz localrlz;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localrlz = rlz.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label48;
      }
    }
    label48:
    for (int i = 0;; i = 1)
    {
      localrlz.a(str, i);
      return;
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Tvh.getCount() == 0)
    {
      ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131379361)).setText(anzj.a(2131711801));
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131373142)).setImageResource(2130842782);
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2131166070);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2130850680);
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setBackgroundResource(2131166070);
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
      if ((bhjr.b()) || (bhjr.d())) {
        break label140;
      }
      this.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130849533);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bhjr.b()) && (!bhjr.d()))
      {
        getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mSystemBarComp.setStatusBarColor(-1);
      }
      else if ((!bhjr.b()) && (!bhjr.d()))
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
  
  public void a(List<twi> paramList)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() != -1)) {}
    while ((this.jdField_a_of_type_Tvh == null) || (this.jdField_a_of_type_AndroidViewView == null)) {
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
    this.jdField_a_of_type_Tvh.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_Tvh.b();
    this.jdField_a_of_type_Tvh.c();
    this.jdField_a_of_type_Tvh.notifyDataSetChanged();
    e();
  }
  
  public void ar_()
  {
    ((pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a().e();
    rlz localrlz;
    String str;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager != null)
    {
      localrlz = rlz.a();
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.i()) {
        break label57;
      }
    }
    label57:
    for (int i = 0;; i = 1)
    {
      localrlz.a(str, i);
      return;
    }
  }
  
  public void b(View paramView) {}
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
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
    if (this.jdField_a_of_type_Tvh != null)
    {
      this.jdField_a_of_type_Tvh.a();
      this.jdField_a_of_type_Tvh = null;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.b(this);
    this.jdField_a_of_type_JavaUtilList = null;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    }
    pfd.a().b(this.jdField_a_of_type_Pfh);
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
    ((pfg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(163)).a().e();
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
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380439))
    {
      paramDragFrameLayout = (twi)paramDragFrameLayout.a().getTag(2131378213);
      if (paramDragFrameLayout != null)
      {
        bdll.b(null, "dc00899", "Pb_account_lifeservice", paramDragFrameLayout.jdField_a_of_type_JavaLangString, "0X80064D1", "0X80064D1", 0, 0, "" + paramDragFrameLayout.jdField_b_of_type_Int, "", "", "");
        paramDragFrameLayout.a();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    Object localObject1;
    switch (paramView.getId())
    {
    default: 
    case 2131378210: 
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      } while (((Integer)paramView.getTag(2131378214)).intValue() != tvc.d);
      localObject2 = paramView.getTag(2131378213);
      Object localObject3 = paramView.getTag(2131378222);
      Integer localInteger;
      if (localObject3 != null)
      {
        localObject1 = (String)localObject3;
        if (localObject3 == null) {
          break label504;
        }
        i = ((Integer)localObject2).intValue();
        localInteger = Integer.valueOf(i);
        if (localInteger.intValue() <= 0) {
          break label509;
        }
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572E", "0X800572E", 0, 0, "", "", "", "");
      }
      for (;;)
      {
        localObject2 = "";
        try
        {
          localObject3 = new JSONObject();
          ((JSONObject)localObject3).put("folder_status", ozs.d);
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
            localObject2 = "";
          }
        }
        ocd.a(null, (String)localObject1, "0X8007DB3", "0X8007DB3", 0, 0, "", "", "", (String)localObject2, false);
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006240", "0X8006240", 0, 0, "", "", "", "");
        ocd.a(null, "CliOper", "", "", "0X80081C8", "0X80081C8", 0, 0, "", "", "", ozs.c(localInteger.intValue()), false);
        if (TextUtils.isEmpty(twk.a().a((String)localObject1)))
        {
          localObject2 = (PublicAccountHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
          if (localObject2 != null) {
            ((PublicAccountHandler)localObject2).a();
          }
        }
        localObject2 = paramView.getTag(2131378215);
        if (localObject2 == null) {
          break label558;
        }
        localObject2 = (String)localObject2;
        localObject3 = new Intent(getActivity(), ChatActivity.class);
        ((Intent)localObject3).putExtra("uintype", 1008);
        ((Intent)localObject3).putExtra("uin", (String)localObject1);
        ((Intent)localObject3).putExtra("uinname", (String)localObject2);
        ((Intent)localObject3).putExtra("start_time", System.currentTimeMillis());
        ((Intent)localObject3).putExtra("red_hot_count", localInteger);
        ((Intent)localObject3).putExtra("is_come_from_readinjoy", true);
        getActivity().startActivity((Intent)localObject3);
        uae.a(null, "SUBSCRIPT_AIO_COST");
        break;
        localObject1 = "";
        break label121;
        i = 0;
        break label135;
        bdll.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572F", "0X800572F", 0, 0, "", "", "", "");
      }
    case 2131370759: 
      localObject1 = paramView.getTag(2131378222);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        pfa.a().a((String)localObject1);
        break;
      }
    case 2131370765: 
      localObject1 = paramView.getTag(2131378222);
      if (localObject1 != null) {}
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        pfa.a().b((String)localObject1);
        break;
      }
    case 2131370764: 
      localObject1 = paramView.getTag(2131378222);
      if (localObject1 != null)
      {
        localObject1 = (String)localObject1;
        label667:
        localObject2 = paramView.getTag(2131378215);
        if (localObject2 == null) {
          break label778;
        }
      }
      label778:
      for (localObject2 = (String)localObject2;; localObject2 = "")
      {
        blir localblir = (blir)blji.a(getActivity(), null);
        localblir.a(String.format(getResources().getString(2131695846), new Object[] { localObject2 }));
        localblir.a(2131695784, 3);
        localblir.c(2131690580);
        localblir.a(new okk(this, (String)localObject1, localblir));
        localblir.show();
        break;
        localObject1 = "";
        break label667;
      }
    case 2131370744: 
      label121:
      label509:
      localObject1 = paramView.getTag(2131378222);
      label135:
      label504:
      if (localObject1 != null) {}
      label558:
      for (localObject1 = (String)localObject1;; localObject1 = "")
      {
        pfa.a().c((String)localObject1);
        break;
      }
    }
    int j = ((Integer)paramView.getTag(2131378214)).intValue();
    int i = ((Integer)paramView.getTag(2131376113)).intValue();
    if (j == tvc.e) {
      ozs.a(this, (String)paramView.getTag(2131378440));
    }
    j = ((Integer)paramView.getTag(2131376112)).intValue();
    if (j == jdField_a_of_type_Int) {
      ocd.a(null, "CliOper", "", "", "0X80080F1", "0X80080F1", 0, 0, "", "", "", ozs.c(i), false);
    }
    for (;;)
    {
      paramView.findViewById(2131380439).setVisibility(8);
      paramView.findViewById(2131362969).setVisibility(0);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager.l();
      break;
      if (j == jdField_b_of_type_Int) {
        ocd.a(null, "CliOper", "", "", "0X80080F2", "0X80080F2", 0, 0, "", "", "", ozs.c(i), false);
      }
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    this.c = paramInt;
    switch (paramInt)
    {
    default: 
      adlb.a().a("list_subscript");
      return;
    }
    adlb.a().a("list_subscript", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyMessagesActivity
 * JD-Core Version:    0.7.0.1
 */