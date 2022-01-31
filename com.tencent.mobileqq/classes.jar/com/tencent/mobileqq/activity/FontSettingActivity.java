package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.LayoutParams;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FontSettingManager.FontLevel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.util.CustomDialogFactory;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import skc;
import skd;
import ske;
import skf;
import skg;
import ski;
import skj;
import skk;
import skl;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, FontSettingManager.FontLevel, RangeButtonView.OnChangeListener
{
  private float jdField_a_of_type_Float = 16.0F;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  FaceDecoder jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  public ListView a;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  public ArrayList a;
  public List a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new skf(this);
  public skg a;
  ski jdField_a_of_type_Ski;
  public skj a;
  skl jdField_a_of_type_Skl;
  public boolean a;
  ViewGroup b;
  public ListView b;
  public ArrayList b;
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
    this.jdField_a_of_type_Float = FontSettingManager.a();
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
    TextView localTextView = (TextView)paramView.findViewById(2131363227);
    localTextView.setText(2131436785);
    localTextView.setOnClickListener(new skc(this));
    ((TextView)paramView.findViewById(2131363363)).setText("字体大小");
    ((TextView)paramView.findViewById(2131363227)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131370069));
    this.jdField_a_of_type_Ski = new ski(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Ski);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131370070));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Skg = new skg(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Skg);
    this.jdField_a_of_type_Skj = new skj(this, this.app, this.jdField_a_of_type_Skg, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder = new FaceDecoder(this, this.app);
    this.jdField_a_of_type_Skj.a(this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_Skl = new skl(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Skl);
    this.jdField_a_of_type_Ski.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131364560));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new RangeButtonView.Title("小", TypedValue.applyDimension(1, 13.92F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 15.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("标准", TypedValue.applyDimension(1, 16.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("", TypedValue.applyDimension(1, 17.0F, FontSettingManager.a)));
    localArrayList.add(new RangeButtonView.Title("大", TypedValue.applyDimension(1, 18.0F, FontSettingManager.a)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131427478));
    localArrayList.add(getString(2131427479));
    localArrayList.add(getString(2131427480));
    localArrayList.add(getString(2131427481));
    localArrayList.add(getString(2131427482));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131366324));
    this.jdField_a_of_type_AndroidViewViewGroup = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131558448));
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
      MessageForText localMessageForText1 = new MessageForText();
      localMessageForText1.frienduin = "2720152058";
      localMessageForText1.senderuin = "2720152058";
      localMessageForText1.issend = 1000;
      localMessageForText1.msg = "拖动下方的滑块，可以设置界面中的字体大小";
      localMessageForText1.sb = "拖动下方的滑块，可以设置界面中的字体大小";
      MessageForText localMessageForText2 = new MessageForText();
      Object localObject = this.app.getCurrentAccountUin();
      localMessageForText2.frienduin = ((String)localObject);
      localMessageForText2.selfuin = ((String)localObject);
      localMessageForText2.senderuin = ((String)localObject);
      localMessageForText2.issend = 1;
      localMessageForText2.msg = "设置字体大小";
      localMessageForText2.sb = "设置字体大小";
      localMessageForText2.vipBubbleID = ((SVIPHandler)this.app.a(13)).b();
      localObject = new MessageForText();
      ((MessageForText)localObject).frienduin = "2720152058";
      ((MessageForText)localObject).senderuin = "2720152058";
      ((MessageForText)localObject).issend = 1000;
      ((MessageForText)localObject).msg = "设置后，会改变聊天，消息列表，联系人列表和动态等中的字体大小";
      ((MessageForText)localObject).sb = "设置后，会改变聊天，消息列表，联系人列表和动态等中的字体大小";
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText1);
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText2);
      this.jdField_a_of_type_JavaUtilList.add(localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground = new ChatBackground();
      if (ChatBackground.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_ComTencentMobileqqActivityAioChatBackground.a);
      }
    }
  }
  
  private void h()
  {
    skk localskk1 = new skk(this, 0, "QQ团队", "你好，如果你有任何关于QQ的意见或建议...", "下午3:28", "2720152058", 0);
    skk localskk2 = new skk(this, 2130839202, "关联QQ号", "验证密码后，才可接受新消息", "下午3:28", AppConstants.w, 7000);
    skk localskk3 = new skk(this, 2130839204, "群助手", "查看“收进群助手且不提醒”的群", "下午3:28", AppConstants.B, 5000);
    skk localskk4 = new skk(this, 2130841551, "我的电脑", "[在线],无需数据线，手机轻松传...", "下午3:28", AppConstants.y, 6000);
    skk localskk5 = new skk(this, 0, "吃喝玩乐", "吃喝玩乐全民升级，餐厅，KTV等", "下午3:28", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localskk1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localskk2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localskk3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localskk4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localskk5);
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
      FontSettingManager.a(this);
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
      ReportController.b(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.jdField_a_of_type_Float, "", "", "");
      if (!FontSettingManager.a(this, this.jdField_a_of_type_Float, false)) {
        bool = true;
      }
      this.d = bool;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_b_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
      this.jdField_a_of_type_ComTencentWidgetListView.removeAllViewsInLayout();
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
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838211);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838211);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Float == FontSettingManager.a()) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppDialog = CustomDialogFactory.a(this, 2131437981, 2131437984, 2131437983, 2131437982, new skd(this), new ske(this));
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  @TargetApi(14)
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2130970323);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131362822));
    if ((this.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      this.jdField_c_of_type_AndroidViewViewGroup.setFitsSystemWindows(true);
      this.jdField_c_of_type_AndroidViewViewGroup.setPadding(0, ImmersiveUtils.a(this), 0, 0);
    }
    this.app.setHandler(FontSettingActivity.class, this.jdField_a_of_type_MqqOsMqqHandler);
    d();
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.jdField_a_of_type_Skl.a();
    this.app.removeHandler(FontSettingActivity.class);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilFaceDecoder.d();
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    i();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  protected void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */