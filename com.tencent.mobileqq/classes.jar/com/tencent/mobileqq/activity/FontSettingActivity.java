package com.tencent.mobileqq.activity;

import aarq;
import aarr;
import aars;
import aart;
import aaru;
import aarv;
import aarw;
import aarx;
import aary;
import ackc;
import ajed;
import ajia;
import ajjy;
import ajrm;
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
import awqx;
import azvu;
import azwg;
import bemt;
import bemx;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.CirclePageIndicator;
import com.tencent.widget.ListView;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class FontSettingActivity
  extends BaseActivity
  implements ViewPager.OnPageChangeListener, bemt
{
  private float jdField_a_of_type_Float = 16.0F;
  public aaru a;
  aarv jdField_a_of_type_Aarv;
  public aarw a;
  aary jdField_a_of_type_Aary;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  azwg jdField_a_of_type_Azwg;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  public ArrayList<View> a;
  public List<ChatMessage> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new aart(this);
  public boolean a;
  ViewGroup b;
  public ListView b;
  public ArrayList<aarx> b;
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
    this.jdField_a_of_type_Float = ajia.a();
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
    ((TextView)paramView.findViewById(2131302804)).setOnClickListener(new aarq(this));
    ((TextView)paramView.findViewById(2131302847)).setText(ajjy.a(2131638899));
    ((TextView)paramView.findViewById(2131302804)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131300954));
    this.jdField_a_of_type_Aarv = new aarv(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Aarv);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131300945));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Aaru = new aaru(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Aaru);
    this.jdField_a_of_type_Aarw = new aarw(this, this.app, this.jdField_a_of_type_Aaru, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_Azwg = new azwg(this, this.app);
    this.jdField_a_of_type_Aarw.a(this.jdField_a_of_type_Azwg);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_Aary = new aary(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Aary);
    this.jdField_a_of_type_Aarv.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131300948));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new bemx(ajjy.a(2131638907), TypedValue.applyDimension(1, 13.92F, ajia.a)));
    localArrayList.add(new bemx("", TypedValue.applyDimension(1, 15.0F, ajia.a)));
    localArrayList.add(new bemx(ajjy.a(2131638906), TypedValue.applyDimension(1, 16.0F, ajia.a)));
    localArrayList.add(new bemx("", TypedValue.applyDimension(1, 17.0F, ajia.a)));
    localArrayList.add(new bemx(ajjy.a(2131638905), TypedValue.applyDimension(1, 18.0F, ajia.a)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131625537));
    localArrayList.add(getString(2131625538));
    localArrayList.add(getString(2131625539));
    localArrayList.add(getString(2131625540));
    localArrayList.add(getString(2131625541));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131311572));
    this.jdField_a_of_type_AndroidViewViewGroup = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131167766));
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
      Object localObject1 = ajjy.a(2131638908);
      localMessageForText.msg = ((String)localObject1);
      localMessageForText.sb = ((CharSequence)localObject1);
      localObject1 = new MessageForText();
      Object localObject2 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject1).frienduin = ((String)localObject2);
      ((MessageForText)localObject1).selfuin = ((String)localObject2);
      ((MessageForText)localObject1).senderuin = ((String)localObject2);
      ((MessageForText)localObject1).issend = 1;
      localObject2 = ajjy.a(2131638898);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      ((MessageForText)localObject1).vipBubbleID = ((ajrm)this.app.a(13)).b();
      localObject2 = new MessageForText();
      ((MessageForText)localObject2).frienduin = "2720152058";
      ((MessageForText)localObject2).senderuin = "2720152058";
      ((MessageForText)localObject2).issend = 1000;
      String str = ajjy.a(2131638901);
      ((MessageForText)localObject2).msg = str;
      ((MessageForText)localObject2).sb = str;
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc = new ackc();
      if (ackc.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Ackc.a);
      }
    }
  }
  
  private void h()
  {
    aarx localaarx1 = new aarx(this, 0, ajjy.a(2131633766), ajjy.a(2131638902), "3:28PM", "2720152058", 0);
    aarx localaarx2 = new aarx(this, 2130839782, ajjy.a(2131624994), ajjy.a(2131638897), "3:28PM", ajed.x, 7000);
    aarx localaarx3 = new aarx(this, 2130839784, ajjy.a(2131623945), ajjy.a(2131638903), "3:28PM", ajed.C, 5000);
    aarx localaarx4 = new aarx(this, 2130843326, ajjy.a(2131628834), ajjy.a(2131638904), "3:28PM", ajed.z, 6000);
    aarx localaarx5 = new aarx(this, 0, ajjy.a(2131638909), ajjy.a(2131638900), "3:28PM", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localaarx1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localaarx2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localaarx3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localaarx4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localaarx5);
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
      ajia.a(this);
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
      awqx.b(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.jdField_a_of_type_Float, "", "", "");
      if (!ajia.a(this, this.jdField_a_of_type_Float, false)) {
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
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838504);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838504);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Float == ajia.a()) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppDialog = azvu.a(this, 2131627096, 2131627094, 2131627093, 2131627095, new aarr(this), new aars(this));
    } while (isFinishing());
    this.jdField_a_of_type_AndroidAppDialog.show();
  }
  
  public void doOnBackPressed()
  {
    c();
  }
  
  @TargetApi(14)
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131495203);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131309736));
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
    this.jdField_a_of_type_Aary.a();
    this.app.removeHandler(FontSettingActivity.class);
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    i();
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt) {}
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */