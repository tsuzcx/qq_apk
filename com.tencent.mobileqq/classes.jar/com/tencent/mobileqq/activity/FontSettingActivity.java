package com.tencent.mobileqq.activity;

import Override;
import adxp;
import adxq;
import adxr;
import adxs;
import adxt;
import adxu;
import adxv;
import adxw;
import adxx;
import afrb;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anvx;
import aocy;
import bdla;
import bgys;
import bles;
import blew;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FontSettingManager.FontLevel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, bles, FontSettingManager.FontLevel
{
  private float jdField_a_of_type_Float = 16.0F;
  public adxt a;
  adxu jdField_a_of_type_Adxu;
  public adxv a;
  adxx jdField_a_of_type_Adxx;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  public ArrayList<View> a;
  public List<ChatMessage> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new adxs(this);
  public boolean a;
  ViewGroup b;
  public ListView b;
  public ArrayList<adxw> b;
  public boolean b;
  ViewGroup c;
  public boolean c;
  private boolean d;
  
  public FontSettingActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
  }
  
  private int a()
  {
    int j = 2;
    this.jdField_a_of_type_Float = FontSettingManager.getFontLevel();
    int i;
    if (this.jdField_a_of_type_Float == 13.92F) {
      i = 0;
    }
    do
    {
      do
      {
        return i;
        if (this.jdField_a_of_type_Float == 15.0F) {
          return 1;
        }
        i = j;
      } while (this.jdField_a_of_type_Float == 16.0F);
      if (this.jdField_a_of_type_Float == 17.0F) {
        return 3;
      }
      i = j;
    } while (this.jdField_a_of_type_Float != 18.0F);
    return 4;
  }
  
  private ListView a()
  {
    ListView localListView = new ListView(this);
    ViewPager.LayoutParams localLayoutParams = new ViewPager.LayoutParams();
    localLayoutParams.height = -1;
    localLayoutParams.width = -1;
    localListView.setDivider(null);
    localListView.setDividerHeight(0);
    return localListView;
  }
  
  private void a(View paramView)
  {
    ((TextView)paramView.findViewById(2131369231)).setOnClickListener(new adxp(this));
    ((TextView)paramView.findViewById(2131369278)).setText(anvx.a(2131704163));
    ((TextView)paramView.findViewById(2131369231)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131367134));
    this.jdField_a_of_type_Adxu = new adxu(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Adxu);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131367124));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Adxt = new adxt(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Adxt);
    this.jdField_a_of_type_Adxv = new adxv(this, this.app, this.jdField_a_of_type_Adxt, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_Adxv.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_Adxx = new adxx(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Adxx);
    this.jdField_a_of_type_Adxu.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131367127));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new blew(anvx.a(2131704171), TypedValue.applyDimension(1, 13.92F, FontSettingManager.systemMetrics)));
    localArrayList.add(new blew("", TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new blew(anvx.a(2131704170), TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new blew("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new blew(anvx.a(2131704169), TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131691091));
    localArrayList.add(getString(2131691092));
    localArrayList.add(getString(2131691093));
    localArrayList.add(getString(2131691094));
    localArrayList.add(getString(2131691095));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131379040));
    this.jdField_a_of_type_AndroidViewViewGroup = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131299080));
    a(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_b_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewViewGroup, 0, localLayoutParams);
  }
  
  private void f()
  {
    this.jdField_b_of_type_AndroidViewViewGroup.removeViewAt(0);
    e();
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
      MessageForText localMessageForText = new MessageForText();
      localMessageForText.frienduin = "2720152058";
      localMessageForText.senderuin = "2720152058";
      localMessageForText.issend = 1000;
      Object localObject1 = anvx.a(2131704172);
      localMessageForText.msg = ((String)localObject1);
      localMessageForText.sb = ((CharSequence)localObject1);
      localObject1 = new MessageForText();
      Object localObject2 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject1).frienduin = ((String)localObject2);
      ((MessageForText)localObject1).selfuin = ((String)localObject2);
      ((MessageForText)localObject1).senderuin = ((String)localObject2);
      ((MessageForText)localObject1).issend = 1;
      localObject2 = anvx.a(2131704162);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      ((MessageForText)localObject1).vipBubbleID = ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
      localObject2 = new MessageForText();
      ((MessageForText)localObject2).frienduin = "2720152058";
      ((MessageForText)localObject2).senderuin = "2720152058";
      ((MessageForText)localObject2).issend = 1000;
      String str = anvx.a(2131704165);
      ((MessageForText)localObject2).msg = str;
      ((MessageForText)localObject2).sb = str;
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg = new afrb();
      if (afrb.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curFriendUin, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.chatBg.a);
      }
    }
  }
  
  private void h()
  {
    adxw localadxw1 = new adxw(this, 0, anvx.a(2131698937), anvx.a(2131704166), "3:28PM", "2720152058", 0);
    adxw localadxw2 = new adxw(this, 2130840443, anvx.a(2131690666), anvx.a(2131704161), "3:28PM", AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    adxw localadxw3 = new adxw(this, 2130840445, anvx.a(2131689472), anvx.a(2131704167), "3:28PM", AppConstants.TROOP_ASSISTANT_UIN, 5000);
    adxw localadxw4 = new adxw(this, 2130844186, anvx.a(2131694211), anvx.a(2131704168), "3:28PM", AppConstants.DATALINE_PC_UIN, 6000);
    adxw localadxw5 = new adxw(this, 0, anvx.a(2131704173), anvx.a(2131704164), "3:28PM", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localadxw1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localadxw2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localadxw3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localadxw4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localadxw5);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup2 = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup2.getChildAt(0);
      ViewGroup localViewGroup1 = localViewGroup2;
      if (localView != null)
      {
        localViewGroup1 = localViewGroup2;
        if ((localView instanceof ViewGroup)) {
          localViewGroup1 = (ViewGroup)localView;
        }
      }
      if ((localViewGroup1 instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localViewGroup1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout.setInterceptTouchFlag(false);
      }
    }
  }
  
  public void a()
  {
    if ((this.d) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_Boolean = false;
      this.d = false;
      FontSettingManager.revertToLsatDendisy(this);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      bdla.b(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.jdField_a_of_type_Float, "", "", "");
      if (!FontSettingManager.setCustomDensity(this, this.jdField_a_of_type_Float, false)) {
        bool = true;
      }
      this.d = bool;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.textSizeForTextItem = ChatTextSizeSettingActivity.a(this);
      this.jdField_b_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
      this.jdField_a_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
      this.jdField_a_of_type_Adxt.notifyDataSetChanged();
      this.jdField_a_of_type_Adxx.notifyDataSetChanged();
      f();
      return;
      this.jdField_a_of_type_Float = 13.92F;
      continue;
      this.jdField_a_of_type_Float = 15.0F;
      continue;
      this.jdField_a_of_type_Float = 16.0F;
      continue;
      this.jdField_a_of_type_Float = 17.0F;
      continue;
      this.jdField_a_of_type_Float = 18.0F;
    }
  }
  
  void b()
  {
    if (this.jdField_b_of_type_ComTencentWidgetListView == null) {}
    do
    {
      do
      {
        return;
        if (!ThemeBackground.getThemeBackgroundEnable())
        {
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838912);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838912);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Float == FontSettingManager.getFontLevel()) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppDialog = bgys.a(this, 2131692538, 2131692536, 2131692535, 2131692537, new adxq(this), new adxr(this));
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561161);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376947));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      this.jdField_c_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.app.setHandler(FontSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Adxx.a();
    this.app.removeHandler(FontSettingActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */