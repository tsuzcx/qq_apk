package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.LayoutParams;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FontSettingManager.FontLevel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, FontSettingManager.FontLevel, RangeButtonView.OnChangeListener
{
  private float jdField_a_of_type_Float = 16.0F;
  private Dialog jdField_a_of_type_AndroidAppDialog = null;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  FontSettingActivity.AioListAdapter jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$AioListAdapter;
  FontSettingActivity.FontPageAdapter jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$FontPageAdapter;
  FontSettingActivity.MyItemBuilder jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$MyItemBuilder;
  FontSettingActivity.TabListAdapter jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$TabListAdapter;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground = null;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  ArrayList<View> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  List<ChatMessage> jdField_a_of_type_JavaUtilList;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new FontSettingActivity.4(this);
  boolean jdField_a_of_type_Boolean = false;
  ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  ListView jdField_b_of_type_ComTencentWidgetListView;
  ArrayList<FontSettingActivity.RecentData> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  boolean jdField_b_of_type_Boolean = false;
  ViewGroup jdField_c_of_type_AndroidViewViewGroup;
  boolean jdField_c_of_type_Boolean = false;
  private boolean d = false;
  
  private int a()
  {
    this.jdField_a_of_type_Float = FontSettingManager.getFontLevel();
    float f = this.jdField_a_of_type_Float;
    if (f == 13.92F) {
      return 0;
    }
    if (f == 15.0F) {
      return 1;
    }
    if (f == 16.0F) {
      return 2;
    }
    if (f == 17.0F) {
      return 3;
    }
    if (f == 18.0F) {
      return 4;
    }
    return 2;
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
    ((TextView)paramView.findViewById(2131369202)).setOnClickListener(new FontSettingActivity.1(this));
    ((TextView)paramView.findViewById(2131369249)).setText(HardCodeUtil.a(2131704787));
    ((TextView)paramView.findViewById(2131369202)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((ViewPager)findViewById(2131367107));
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$FontPageAdapter = new FontSettingActivity.FontPageAdapter(this);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$FontPageAdapter);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131367097));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$AioListAdapter = new FontSettingActivity.AioListAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$AioListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$MyItemBuilder = new FontSettingActivity.MyItemBuilder(this, this.app, this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$AioListAdapter, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.app.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.app);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$MyItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$TabListAdapter = new FontSettingActivity.TabListAdapter(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$TabListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$FontPageAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131367100));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704795), TypedValue.applyDimension(1, 13.92F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704794), TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics)));
    localArrayList.add(new RangeButtonView.Title(HardCodeUtil.a(2131704793), TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131691119));
    localArrayList.add(getString(2131691120));
    localArrayList.add(getString(2131691121));
    localArrayList.add(getString(2131691122));
    localArrayList.add(getString(2131691123));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131378823));
    this.jdField_a_of_type_AndroidViewViewGroup = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131299168));
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
      Object localObject1 = new MessageForText();
      ((MessageForText)localObject1).frienduin = "2720152058";
      ((MessageForText)localObject1).senderuin = "2720152058";
      ((MessageForText)localObject1).issend = 1000;
      Object localObject2 = HardCodeUtil.a(2131704796);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      localObject2 = new MessageForText();
      Object localObject3 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject2).frienduin = ((String)localObject3);
      ((MessageForText)localObject2).selfuin = ((String)localObject3);
      ((MessageForText)localObject2).senderuin = ((String)localObject3);
      ((MessageForText)localObject2).issend = 1;
      localObject3 = HardCodeUtil.a(2131704786);
      ((MessageForText)localObject2).msg = ((String)localObject3);
      ((MessageForText)localObject2).sb = ((CharSequence)localObject3);
      ((MessageForText)localObject2).vipBubbleID = ((ISVIPHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).b();
      localObject3 = new MessageForText();
      ((MessageForText)localObject3).frienduin = "2720152058";
      ((MessageForText)localObject3).senderuin = "2720152058";
      ((MessageForText)localObject3).issend = 1000;
      String str = HardCodeUtil.a(2131704789);
      ((MessageForText)localObject3).msg = str;
      ((MessageForText)localObject3).sb = str;
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      this.jdField_a_of_type_JavaUtilList.add(localObject3);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
      ((SessionInfo)localObject1).jdField_a_of_type_Int = 0;
      ((SessionInfo)localObject1).b = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      if (ChatBackground.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
  }
  
  private void h()
  {
    FontSettingActivity.RecentData localRecentData1 = new FontSettingActivity.RecentData(this, 0, HardCodeUtil.a(2131699388), HardCodeUtil.a(2131704790), "3:28PM", "2720152058", 0);
    FontSettingActivity.RecentData localRecentData2 = new FontSettingActivity.RecentData(this, 2130840427, HardCodeUtil.a(2131690696), HardCodeUtil.a(2131704785), "3:28PM", AppConstants.SUBACCOUNT_ASSISTANT_UIN, 7000);
    FontSettingActivity.RecentData localRecentData3 = new FontSettingActivity.RecentData(this, 2130840429, HardCodeUtil.a(2131689472), HardCodeUtil.a(2131704791), "3:28PM", AppConstants.TROOP_ASSISTANT_UIN, 5000);
    FontSettingActivity.RecentData localRecentData4 = new FontSettingActivity.RecentData(this, 2130844282, HardCodeUtil.a(2131694380), HardCodeUtil.a(2131704792), "3:28PM", AppConstants.DATALINE_PC_UIN, 6000);
    FontSettingActivity.RecentData localRecentData5 = new FontSettingActivity.RecentData(this, 0, HardCodeUtil.a(2131704797), HardCodeUtil.a(2131704788), "3:28PM", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localRecentData1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localRecentData2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localRecentData3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localRecentData4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localRecentData5);
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
      View localView = localViewGroup.getChildAt(0);
      Object localObject = localViewGroup;
      if (localView != null)
      {
        localObject = localViewGroup;
        if ((localView instanceof ViewGroup)) {
          localObject = (ViewGroup)localView;
        }
      }
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
      if (localObject != null) {
        ((TopGestureLayout)localObject).setInterceptTouchFlag(false);
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
  
  void b()
  {
    if (this.jdField_b_of_type_ComTencentWidgetListView == null) {
      return;
    }
    if (!ThemeBackground.a())
    {
      this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838740);
      this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground = null;
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground == null) {
      this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground = new ThemeBackground();
    }
    if (ThemeBackground.a(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground)) {
      if ((!"null".equals(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      }
      else
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838740);
        this.jdField_a_of_type_ComTencentMobileqqVasThemeDiyThemeBackground = null;
      }
    }
  }
  
  void c()
  {
    if (this.jdField_a_of_type_Float == FontSettingManager.getFontLevel())
    {
      finish();
      return;
    }
    this.jdField_a_of_type_AndroidAppDialog = CustomDialogFactory.a(this, 2131692628, 2131692626, 2131692625, 2131692627, new FontSettingActivity.2(this), new FontSettingActivity.3(this));
    if (!isFinishing()) {
      this.jdField_a_of_type_AndroidAppDialog.show();
    }
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
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561103);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376809));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      this.jdField_c_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    this.app.setHandler(FontSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$TabListAdapter.a();
    this.app.removeHandler(FontSettingActivity.class);
    IFaceDecoder localIFaceDecoder = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localIFaceDecoder != null) {
      localIFaceDecoder.destory();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
  }
  
  public void onChange(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    if (paramInt2 != 0)
    {
      if (paramInt2 != 1)
      {
        if (paramInt2 != 2)
        {
          if (paramInt2 != 3)
          {
            if (paramInt2 == 4) {
              this.jdField_a_of_type_Float = 18.0F;
            }
          }
          else {
            this.jdField_a_of_type_Float = 17.0F;
          }
        }
        else {
          this.jdField_a_of_type_Float = 16.0F;
        }
      }
      else {
        this.jdField_a_of_type_Float = 15.0F;
      }
    }
    else {
      this.jdField_a_of_type_Float = 13.92F;
    }
    QQAppInterface localQQAppInterface = this.app;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append((int)this.jdField_a_of_type_Float);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, localStringBuilder.toString(), "", "", "");
    this.d = (true ^ FontSettingManager.setCustomDensity(this, this.jdField_a_of_type_Float, false));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
    this.jdField_b_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
    this.jdField_a_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$AioListAdapter.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityFontSettingActivity$TabListAdapter.notifyDataSetChanged();
    f();
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
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */