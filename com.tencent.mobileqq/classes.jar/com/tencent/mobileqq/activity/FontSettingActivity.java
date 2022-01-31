package com.tencent.mobileqq.activity;

import acws;
import acwt;
import acwu;
import acwv;
import acww;
import acwx;
import acwy;
import acwz;
import acxa;
import aeqq;
import alof;
import alsf;
import alud;
import amca;
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
import azqs;
import bdap;
import bdbb;
import biai;
import biam;
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
  implements ViewPager.OnPageChangeListener, biai
{
  private float jdField_a_of_type_Float = 16.0F;
  public acww a;
  acwx jdField_a_of_type_Acwx;
  public acwy a;
  acxa jdField_a_of_type_Acxa;
  private Dialog jdField_a_of_type_AndroidAppDialog;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  bdbb jdField_a_of_type_Bdbb;
  SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  ThemeBackground jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
  CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  ListView jdField_a_of_type_ComTencentWidgetListView;
  RangeButtonView jdField_a_of_type_ComTencentWidgetRangeButtonView;
  public ArrayList<View> a;
  public List<ChatMessage> a;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new acwv(this);
  public boolean a;
  ViewGroup b;
  public ListView b;
  public ArrayList<acwz> b;
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
    this.jdField_a_of_type_Float = alsf.a();
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
    ((TextView)paramView.findViewById(2131368624)).setOnClickListener(new acws(this));
    ((TextView)paramView.findViewById(2131368670)).setText(alud.a(2131705079));
    ((TextView)paramView.findViewById(2131368624)).setMaxWidth(getResources().getDisplayMetrics().widthPixels);
  }
  
  private void d()
  {
    e();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)findViewById(2131366689));
    this.jdField_a_of_type_Acwx = new acwx(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_Acwx);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)findViewById(2131366679));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding((int)TypedValue.applyDimension(1, 10.0F, getResources().getDisplayMetrics()));
    this.jdField_a_of_type_ComTencentWidgetListView = a();
    g();
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_Acww = new acww(this);
    this.jdField_a_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Acww);
    this.jdField_a_of_type_Acwy = new acwy(this, this.app, this.jdField_a_of_type_Acww, this, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, null);
    this.jdField_a_of_type_Bdbb = new bdbb(this, this.app);
    this.jdField_a_of_type_Acwy.a(this.jdField_a_of_type_Bdbb);
    h();
    this.jdField_b_of_type_ComTencentWidgetListView = a();
    b();
    this.jdField_a_of_type_Acxa = new acxa(this, this, this.app, this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_b_of_type_ComTencentWidgetListView);
    this.jdField_b_of_type_ComTencentWidgetListView.setAdapter(this.jdField_a_of_type_Acxa);
    this.jdField_a_of_type_Acwx.notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView = ((RangeButtonView)findViewById(2131366682));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new biam(alud.a(2131705087), TypedValue.applyDimension(1, 13.92F, alsf.a)));
    localArrayList.add(new biam("", TypedValue.applyDimension(1, 15.0F, alsf.a)));
    localArrayList.add(new biam(alud.a(2131705086), TypedValue.applyDimension(1, 16.0F, alsf.a)));
    localArrayList.add(new biam("", TypedValue.applyDimension(1, 17.0F, alsf.a)));
    localArrayList.add(new biam(alud.a(2131705085), TypedValue.applyDimension(1, 18.0F, alsf.a)));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setTitleData(localArrayList);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setOnChangerListener(this);
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setThumbPosition(a());
    localArrayList = new ArrayList();
    localArrayList.add(getString(2131691163));
    localArrayList.add(getString(2131691164));
    localArrayList.add(getString(2131691165));
    localArrayList.add(getString(2131691166));
    localArrayList.add(getString(2131691167));
    this.jdField_a_of_type_ComTencentWidgetRangeButtonView.setContentDescList(localArrayList);
  }
  
  private void e()
  {
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131377975));
    this.jdField_a_of_type_AndroidViewViewGroup = new NavBarCommon(this);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)getResources().getDimension(2131298914));
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
      Object localObject1 = alud.a(2131705088);
      localMessageForText.msg = ((String)localObject1);
      localMessageForText.sb = ((CharSequence)localObject1);
      localObject1 = new MessageForText();
      Object localObject2 = this.app.getCurrentAccountUin();
      ((MessageForText)localObject1).frienduin = ((String)localObject2);
      ((MessageForText)localObject1).selfuin = ((String)localObject2);
      ((MessageForText)localObject1).senderuin = ((String)localObject2);
      ((MessageForText)localObject1).issend = 1;
      localObject2 = alud.a(2131705078);
      ((MessageForText)localObject1).msg = ((String)localObject2);
      ((MessageForText)localObject1).sb = ((CharSequence)localObject2);
      ((MessageForText)localObject1).vipBubbleID = ((amca)this.app.a(13)).b();
      localObject2 = new MessageForText();
      ((MessageForText)localObject2).frienduin = "2720152058";
      ((MessageForText)localObject2).senderuin = "2720152058";
      ((MessageForText)localObject2).issend = 1000;
      String str = alud.a(2131705081);
      ((MessageForText)localObject2).msg = str;
      ((MessageForText)localObject2).sb = str;
      this.jdField_a_of_type_JavaUtilList.add(localMessageForText);
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_a_of_type_JavaUtilList.add(localObject2);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.b = ChatTextSizeSettingActivity.a(this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq = new aeqq();
      if (aeqq.a(this, this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true, 7, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq)) {
        this.jdField_a_of_type_ComTencentWidgetListView.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Aeqq.a);
      }
    }
  }
  
  private void h()
  {
    acwz localacwz1 = new acwz(this, 0, alud.a(2131699926), alud.a(2131705082), "3:28PM", "2720152058", 0);
    acwz localacwz2 = new acwz(this, 2130840178, alud.a(2131690606), alud.a(2131705077), "3:28PM", alof.x, 7000);
    acwz localacwz3 = new acwz(this, 2130840180, alud.a(2131689481), alud.a(2131705083), "3:28PM", alof.C, 5000);
    acwz localacwz4 = new acwz(this, 2130843834, alud.a(2131694654), alud.a(2131705084), "3:28PM", alof.z, 6000);
    acwz localacwz5 = new acwz(this, 0, alud.a(2131705089), alud.a(2131705080), "3:28PM", "2632129500", 0);
    this.jdField_b_of_type_JavaUtilArrayList.add(localacwz1);
    this.jdField_b_of_type_JavaUtilArrayList.add(localacwz2);
    this.jdField_b_of_type_JavaUtilArrayList.add(localacwz3);
    this.jdField_b_of_type_JavaUtilArrayList.add(localacwz4);
    this.jdField_b_of_type_JavaUtilArrayList.add(localacwz5);
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
      alsf.a(this);
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
      azqs.b(this.app, "CliOper", "", "", "0X8004FA2", "0X8004FA2", 0, 0, "" + (int)this.jdField_a_of_type_Float, "", "", "");
      if (!alsf.a(this, this.jdField_a_of_type_Float, false)) {
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
          this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838593);
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground == null) {
          this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = new ThemeBackground();
        }
      } while (!ThemeBackground.getThemeBackground(this.jdField_b_of_type_ComTencentWidgetListView.getContext(), "theme_bg_message_path_png", this.app.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground));
      if (("null".equals(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.path)) || (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null))
      {
        this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(2130838593);
        this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground = null;
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img == null);
    this.jdField_b_of_type_ComTencentWidgetListView.setContentBackground(this.jdField_a_of_type_ComTencentMobileqqThemeDiyThemeBackground.img);
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Float == alsf.a()) {
      finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidAppDialog = bdap.a(this, 2131692818, 2131692816, 2131692815, 2131692817, new acwt(this), new acwu(this));
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
    super.setContentView(2131560979);
    this.jdField_c_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131376034));
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
    this.jdField_a_of_type_Acxa.a();
    this.app.removeHandler(FontSettingActivity.class);
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FontSettingActivity
 * JD-Core Version:    0.7.0.1
 */