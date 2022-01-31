package com.tencent.biz.pubaccount.serviceAccountFolder;

import aciy;
import ahdb;
import ajjy;
import akij;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
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
import auqh;
import awqx;
import bbms;
import beez;
import benm;
import bfpr;
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
import rny;
import rof;
import rog;
import rol;
import rsp;
import ruf;
import vvy;
import vxe;
import wye;

public class ServiceAccountFolderActivity
  extends IphoneTitleBarActivity
  implements ahdb, Handler.Callback, View.OnClickListener, benm
{
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private bbms jdField_a_of_type_Bbms;
  private TopRecommendListView jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView;
  private TopPanelView jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView;
  private ExtraTypeInfo jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private DragFrameLayout jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private List<rof> jdField_a_of_type_JavaUtilList;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  private rog jdField_a_of_type_Rog;
  private vxe jdField_a_of_type_Vxe;
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
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131310134);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302847));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131302804));
    this.d = ((TextView)findViewById(2131302839));
    this.c = ((TextView)super.findViewById(2131312188));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView = ((TopRecommendListView)super.findViewById(2131310141));
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView = new TopPanelView(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_Vxe = new vxe(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.addHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131303102));
    this.jdField_a_of_type_Bbms = new bbms(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bbms.setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_Bbms.c(2131629936);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout = DragFrameLayout.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this, false);
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131310136);
    ((TextView)findViewById(2131310135)).setText("暂无" + rsp.b() + "消息");
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(rol.a(this.app));
    if (this.leftView != null) {
      this.leftView.setContentDescription(ajjy.a(2131648047));
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
          ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(32.0F, getResources());
          this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      if (this.d != null) {
        this.d.setVisibility(8);
      }
      if (this.rightViewText != null)
      {
        if (!rsp.b()) {
          break label320;
        }
        this.rightViewText.setVisibility(0);
        this.rightViewText.setText(ajjy.a(2131654040));
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
          localGradientDrawable.setColor(getResources().getColorStateList(2131101257).getDefaultColor());
          ((Drawable)localObject).setAlpha(46);
          this.d.setBackgroundDrawable(localGradientDrawable);
        }
        if (ThemeUtil.isInNightMode(this.app))
        {
          localObject = this.d.getLayoutParams();
          if ((localObject instanceof ViewGroup.MarginLayoutParams))
          {
            ((RelativeLayout.LayoutParams)localObject).leftMargin = aciy.a(40.0F, getResources());
            this.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
          }
        }
        this.d.setTextColor(getResources().getColor(2131101257));
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
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setContentBackground(getResources().getDrawable(2130838504), false);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setBackgroundResource(2130838504);
    this.jdField_a_of_type_Rog = new rog(this.app, this, this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView);
    this.jdField_a_of_type_Rog.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout);
    this.jdField_a_of_type_JavaUtilList = rol.a().a();
    this.jdField_a_of_type_Rog.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(this.jdField_a_of_type_Rog);
  }
  
  private void f()
  {
    View localView = super.findViewById(2131309578);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131311553);
    if (localView != null) {
      IphoneTitleBarActivity.setLayerType(localView);
    }
    localView = super.findViewById(2131302804);
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
        rof localrof = (rof)localIterator.next();
        if (!this.jdField_a_of_type_JavaUtilArrayList.contains(localrof.jdField_a_of_type_JavaLangString))
        {
          this.jdField_a_of_type_JavaUtilArrayList.add(localrof.jdField_a_of_type_JavaLangString);
          String str2 = "";
          String str1 = str2;
          if (localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
          {
            str1 = str2;
            if (localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
              str1 = localrof.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
            }
          }
          akij.a(this.app, localrof.jdField_a_of_type_JavaLangString, localrof.jdField_a_of_type_Int, localrof.b, localrof.jdField_a_of_type_JavaLangCharSequence.toString(), str1);
        }
      }
    }
  }
  
  private void i()
  {
    Manager localManager = this.app.getManager(36);
    if ((localManager instanceof auqh))
    {
      ((auqh)localManager).a(104000, "104000.104001");
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
      localTopGestureLayout.setInterceptTouchEventListener(new rny(this));
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
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130838504);
        if (this.jdField_b_of_type_AndroidViewView != null)
        {
          Rect localRect = new Rect();
          getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
          int i = localRect.height();
          int j = View.MeasureSpec.makeMeasureSpec(0, 0);
          int k = View.MeasureSpec.makeMeasureSpec(0, 0);
          this.jdField_b_of_type_AndroidViewView.measure(j, k);
          i = (i - this.jdField_b_of_type_AndroidViewView.getMeasuredHeight()) / 2;
          j = (int)getResources().getDimension(2131167766);
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
  
  public void a(boolean paramBoolean, int paramInt, DragFrameLayout paramDragFrameLayout)
  {
    rof localrof;
    long l;
    QQAppInterface localQQAppInterface;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (paramDragFrameLayout.a() != null) && (paramDragFrameLayout.a().getId() == 2131312826))
    {
      paramInt = ((Integer)paramDragFrameLayout.a().getTag()).intValue();
      localrof = (rof)this.jdField_a_of_type_Rog.getItem(paramInt);
      if (localrof != null)
      {
        l = rol.a().a(localrof);
        localQQAppInterface = this.app;
        if (!localrof.a()) {
          break label255;
        }
      }
    }
    label255:
    for (paramDragFrameLayout = "0";; paramDragFrameLayout = "1")
    {
      awqx.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X800687D", "0X800687D", 0, 0, paramDragFrameLayout, "" + localrof.b, "" + (paramInt + 1), "" + l);
      rol.a().b(this.app, localrof, true);
      wye.a(localrof.jdField_a_of_type_JavaLangString, "auth_page", "ignore", 0, 0, new String[0]);
      g();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "onChange->drag red dot:" + localrof.jdField_a_of_type_JavaLangString);
      }
      return;
    }
  }
  
  public void b(View paramView)
  {
    c(true);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbms != null)
    {
      if ((!paramBoolean) || (this.jdField_a_of_type_Bbms.isShowing())) {
        break label80;
      }
      this.jdField_a_of_type_Bbms.show();
      this.jdField_a_of_type_MqqOsMqqHandler.postDelayed(new ServiceAccountFolderActivity.4(this), 5000L);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderActivity", 2, "showProgressBar->show:" + paramBoolean);
      }
      return;
      label80:
      if ((!paramBoolean) && (this.jdField_a_of_type_Bbms.isShowing())) {
        this.jdField_a_of_type_Bbms.dismiss();
      }
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if ((QzoneConfig.getInstance().getConfig("qqsubscribe", "JumpToNewServiceAccount", 1) <= 0) || (!rsp.b())) {}
    for (;;)
    {
      super.doOnCreate(paramBundle);
      super.setContentView(2131493887);
      this.jdField_a_of_type_ComTencentBizSubscribeBaseUIExtraTypeInfo = ((ExtraTypeInfo)getIntent().getSerializableExtra("key_subscribe_intent_extra_type_info"));
      this.app.setHandler(getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      this.jdField_b_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
      c();
      d();
      e();
      f();
      rol.a().a(this.app, NetConnInfoCenter.getServerTime());
      if (rsp.b()) {
        this.jdField_a_of_type_Vxe.b();
      }
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
    rol.a().a(this.app, NetConnInfoCenter.getServerTime());
    wye.a(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "auth_page", "exp", 0, 0, new String[] { "", String.valueOf(System.currentTimeMillis() - this.jdField_a_of_type_Long) });
    if (this.jdField_a_of_type_MqqOsMqqHandler != null) {
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    }
    this.app.removeHandler(getClass());
    if (this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.removeHeaderView(this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderTop_pannelTopPanelView);
      this.jdField_a_of_type_ComTencentBizSubscribeAccount_folderRecommend_bannerTopRecommendListView.setAdapter(null);
    }
    if (this.jdField_a_of_type_Vxe != null) {
      this.jdField_a_of_type_Vxe.c();
    }
    if (this.jdField_a_of_type_Rog != null) {
      this.jdField_a_of_type_Rog.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a(this);
    if (this.jdField_a_of_type_Bbms != null) {
      this.jdField_a_of_type_Bbms.dismiss();
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
    rol.a().a(this.app, NetConnInfoCenter.getServerTime());
    akij.a(this.app, "9953", 1, 1, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
    ThreadManager.executeOnSubThread(new ServiceAccountFolderActivity.2(this, rol.a()));
    ruf.a("SERVICE_FOLDER_COST", null);
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
        this.jdField_a_of_type_Rog.a(this.jdField_a_of_type_JavaUtilList);
        if (this.jdField_a_of_type_Rog.getCount() == 0) {}
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
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131302804: 
    case 2131303102: 
      finish();
      return;
    case 2131302816: 
      MiniAppLauncher.startMiniApp(this, QzoneConfig.getInstance().getConfig("qqminiapp", "publicAcuntDiscoverPageSchema", "mqqapi://miniapp/open?_atype=0&_mappid=1109786902&_mvid=&_vt=3&_sig=f945854d8893417d87b3599d8dce7bdde77f409be5548044ed67383266b1fbf4"), 2016, null, null);
      bfpr.a();
      awqx.b(this.app, "dc00898", "", "", "auth_page", "clk_find", 0, 0, "", "", "", "");
      return;
    }
    vvy.a("https://h5.qzone.qq.com/subscription/followlist?_proxy=1_wv=3");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity
 * JD-Core Version:    0.7.0.1
 */