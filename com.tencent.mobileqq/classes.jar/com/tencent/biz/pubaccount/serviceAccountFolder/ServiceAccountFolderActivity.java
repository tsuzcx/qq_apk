package com.tencent.biz.pubaccount.serviceAccountFolder;

import Override;
import aaej;
import aafq;
import abbe;
import agej;
import alpv;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anzj;
import apeg;
import bbav;
import bdll;
import bjbs;
import blha;
import blpp;
import bmtd;
import com.tencent.biz.subscribe.account_folder.recommend_banner.TopRecommendListView;
import com.tencent.biz.subscribe.account_folder.top_pannel.TopPanelView;
import com.tencent.biz.subscribe.baseUI.ExtraTypeInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.webprocess.WebProcessManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import ttt;
import tua;
import tub;
import tug;
import tyi;
import uae;

public class ServiceAccountFolderActivity
  extends IphoneTitleBarActivity
  implements alpv, Handler.Callback, View.OnClickListener, blpp
{
  private long jdField_a_of_type_Long;
  private aafq jdField_a_of_type_Aafq;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bjbs jdField_a_of_type_Bjbs;
  private TopRecommendListView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView;
  private TopPanelView jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<tua> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new blha(Looper.getMainLooper(), this, true);
  private tub jdField_a_of_type_Tub;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private TextView c;
  private TextView d;
  
  private void b()
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)getSystemService("input_method");
    if (localInputMethodManager == null) {
      return;
    }
    try
    {
      Field localField = localInputMethodManager.getClass().getDeclaredField("mLastSrvView");
      if (!localField.isAccessible()) {
        localField.setAccessible(true);
      }
      localField.set(localInputMethodManager, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ServiceAccountFolderActivity", "[onDestroy]", localThrowable);
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377382);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369088));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369042));
    this.d = ((TextView)findViewById(2131369080));
    this.c = ((TextView)super.findViewById(2131379635));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView = ((TopRecommendListView)super.findViewById(2131377389));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView = new TopPanelView(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Aafq = new aafq(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.addHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369452));
    this.jdField_a_of_type_Bjbs = new bjbs(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bjbs.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bjbs.c(2131694703);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131377384);
    ((TextView)findViewById(2131377383)).setText("暂无" + tyi.b() + "消息");
  }
  
  private void c(boolean paramBoolean)
  {
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchFlag(paramBoolean);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderActivity", 2, "enableFlingRight->enable:" + paramBoolean);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(tug.a(this.app));
    if (this.leftView != null) {
      this.leftView.setContentDescription(anzj.a(2131712708));
    }
    Object localObject;
    if (this.jdField_b_of_type_Boolean)
    {
      if (this.c != null)
      {
        this.c.setVisibility(8);
        localObject = this.c.getLayoutParams();
        if ((localObject instanceof ViewGroup.MarginLayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(32.0F, getResources());
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.d != null) {
        this.d.setVisibility(8);
      }
      if (this.rightViewText != null)
      {
        if (!tyi.b()) {
          break label320;
        }
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(anzj.a(2131718465));
        this.rightViewText.setOnClickListener(this);
      }
    }
    for (;;)
    {
      g();
      return;
      if (this.d != null)
      {
        localObject = this.d.getBackground();
        if ((localObject != null) && ((localObject instanceof GradientDrawable)))
        {
          GradientDrawable localGradientDrawable = (GradientDrawable)((Drawable)localObject).mutate();
          localGradientDrawable.setColor(getResources().getColorStateList(2131166987).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.d.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.d.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(40.0F, getResources());
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.d.setTextColor(getResources().getColor(2131166987));
        this.d.setVisibility(8);
      }
      if (this.c == null) {
        break;
      }
      this.c.setVisibility(8);
      break;
      label320:
      this.rightViewText.setVisibility(8);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setRightIconMenuListener(this);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setContentBackground(getResources().getDrawable(2130838779), false);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setBackgroundResource(2130838779);
    this.jdField_a_of_type_Tub = new tub(this.app, this, this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView);
    this.jdField_a_of_type_Tub.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_JavaUtilList = tug.a().a();
    this.jdField_a_of_type_Tub.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(this.jdField_a_of_type_Tub);
  }
  
  private void f()
  {
    View localView = super.findViewById(2131376731);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131378956);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131369042);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_Boolean) {}
    for (TextView localTextView = this.c;; localTextView = this.d)
    {
      if ((localTextView != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo != null) && (this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo.sourceType == 9004)) {
        ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.3(this, localTextView));
      }
      return;
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        tua localtua = (tua)localIterator.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localtua.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localtua.jdField_a_of_type_JavaLangString);
          String str2 = "";
          String str1 = str2;
          if (localtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            str1 = str2;
            if (localtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
              str1 = localtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          apeg.a(this.app, localtua.jdField_a_of_type_JavaLangString, localtua.jdField_a_of_type_Int, localtua.b, localtua.jdField_a_of_type_JavaLangCharSequence.toString(), str1);
        }
      }
    }
  }
  
  private void i()
  {
    Manager localManager = this.app.getManager(36);
    if ((localManager instanceof bbav))
    {
      ((bbav)localManager).a(104000, "104000.104001");
      QLog.d("ServiceAccountFolderActivity", 2, "uin:" + this.app.c() + "   exposurePublicAccountMessagePopRedDot");
    }
  }
  
  protected TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof DragFrameLayout)) {
          localObject = (ViewGroup)localView;
        }
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null)
    {
      this.jdField_a_of_type_Boolean = true;
      localTopGestureLayout.setInterceptTouchEventListener(new ttt(this));
      return;
    }
    QLog.e("ServiceAccountFolderActivity", 2, "processTopPanelTouchEvent failed! topGestureLayout return null!");
  }
  
  public void a(View paramView)
  {
    c(false);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(8);
      if (ThemeUtil.isInNightMode(this.app))
      {
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838779);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          Rect localRect = new Rect();
          getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
          int i = localRect.height();
          int j = View.MeasureSpec.makeMeasureSpec(0, 0);
          int k = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.jdField_b_of_type_AndroidViewView.measure(j, k);
          i = (i - this.jdField_b_of_type_AndroidViewView.getMeasuredHeight()) / 2;
          j = (int)getResources().getDimension(2131299011);
          ((ViewGroup.MarginLayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams()).topMargin = (i - j);
          this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showEmptyView->show:" + paramBoolean);
      }
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#f5f5f5"));
      break;
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setVisibility(0);
      if (this.jdField_b_of_type_AndroidViewView != null) {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
    }
  }
  
  public void b(View paramView)
  {
    c(true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bjbs != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bjbs.isShowing())) {
        break label80;
      }
      this.jdField_a_of_type_Bjbs.show();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label80:
      if ((!paramBoolean) && (this.jdField_a_of_type_Bjbs.isShowing())) {
        this.jdField_a_of_type_Bjbs.dismiss();
      }
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0) || (!tyi.b())) {}
    for (;;)
    {
      super.doOnCreate(paramBundle);
      super.setContentView(2131559645);
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_b_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
      c();
      d();
      e();
      f();
      tug.a().a(this.app, NetConnInfoCenter.getServerTime());
      paramBundle = (WebProcessManager)this.app.getManager(13);
      if (paramBundle != null) {
        paramBundle.e();
      }
      i();
      return true;
      Intent localIntent = new Intent();
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        localIntent.putExtras(localBundle);
      }
      localIntent.setClass(this, ServiceAccountFolderActivityNew.class);
      startActivity(localIntent);
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    tug.a().a(this.app, NetConnInfoCenter.getServerTime());
    abbe.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Aafq != null) {
      this.jdField_a_of_type_Aafq.b();
    }
    if (this.jdField_a_of_type_Tub != null) {
      this.jdField_a_of_type_Tub.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.jdField_a_of_type_Bjbs != null) {
      this.jdField_a_of_type_Bjbs.dismiss();
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout != null) {
      localTopGestureLayout.setInterceptTouchEventListener(null);
    }
    b();
    super.doOnDestroy();
  }
  
  public void doOnPause()
  {
    super.doOnPause();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a();
    }
    tug.a().a(this.app, NetConnInfoCenter.getServerTime());
    apeg.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.2(this, tug.a()));
    uae.a("SERVICE_FOLDER_COST", null);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 100)
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(100);
      ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.1(this));
    }
    do
    {
      return true;
      if (paramMessage.what == 101)
      {
        this.jdField_a_of_type_Tub.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_Tub.getCount() == 0) {}
        for (boolean bool = true;; bool = false)
        {
          a(bool);
          g();
          h();
          return true;
        }
      }
    } while (paramMessage.what != 102);
    g();
    return true;
  }
  
  public void onChange(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    tua localtua;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131380442))
    {
      paramInt = ((Integer)paramDragFrameLayout.a().getTag()).intValue();
      localtua = (tua)this.jdField_a_of_type_Tub.getItem(paramInt);
      if (localtua != null)
      {
        l = tug.a().a(localtua);
        localQQAppInterface = this.app;
        if (!localtua.a()) {
          break label255;
        }
      }
    }
    label255:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      bdll.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localtua.b, "" + (paramInt + 1), "" + l);
      tug.a().b(this.app, localtua, true);
      abbe.a(localtua.jdField_a_of_type_JavaLangString, "auth_page", "ignore", 0, 0, new String[0]);
      g();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "onChange->drag red dot:" + localtua.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      finish();
      continue;
      MiniAppLauncher.startMiniApp(this, QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4"), 2016, null, null);
      bmtd.a();
      bdll.b(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      continue;
      aaej.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */