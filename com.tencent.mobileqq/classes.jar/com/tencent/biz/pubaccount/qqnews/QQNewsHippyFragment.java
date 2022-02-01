package com.tencent.biz.pubaccount.qqnews;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.util.UiThreadUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/qqnews/QQNewsHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "isThemeDefault", "", "navBarAIO", "Lcom/tencent/mobileqq/widget/navbar/NavBarAIO;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "clearUnreadRedDot", "", "getLayoutResId", "", "initNavBar", "initViews", "onPostThemeChanged", "onResume", "setImmersiveBar", "setNavBarLeftView", "setNavBarRightView", "setNavBarTitleText", "setNavClickListener", "updateUnreadNumOnTitleBar", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQNewsHippyFragment
  extends CommonHippyFragment
{
  private final SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = new SessionInfo();
  private NavBarAIO jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  
  private final void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO = ((NavBarAIO)this.mRootView.findViewById(2131374902));
    c();
    d();
    e();
    f();
    h();
    i();
  }
  
  private final void c()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        localNavBarAIO.setBackgroundResource(2130850507);
      }
      for (;;)
      {
        localObject = localNavBarAIO.getLayoutParams();
        if (localObject != null) {
          break;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        localNavBarAIO.setBackgroundResource(2130850508);
      }
      Object localObject = (LinearLayout.LayoutParams)localObject;
      ((LinearLayout.LayoutParams)localObject).setMargins(0, StatusBarUtil.a((Activity)getActivity()), 0, 0);
      localNavBarAIO.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  private final void d()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localObject1 != null)
    {
      Object localObject2 = (TextView)((NavBarAIO)localObject1).findViewById(2131379432);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)QQNewsUtilKt.a());
        ((TextView)localObject2).setContentDescription(((TextView)localObject2).getText());
      }
      localObject2 = ((NavBarAIO)localObject1).findViewById(2131379477);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((NavBarAIO)localObject1).findViewById(2131379478);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject1 = ((NavBarAIO)localObject1).findViewById(2131378647);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  private final void e()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null)
    {
      ThreadManagerV2.excute((Runnable)new QQNewsHippyFragment.setNavBarLeftView..inlined.apply.lambda.1(this), 32, null, true);
      localNavBarAIO.e();
      localNavBarAIO.setEarIconVisible(false);
    }
  }
  
  private final void f()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if ((localNavBarAIO != null) && ((ImageView)localNavBarAIO.findViewById(2131369501) != null)) {
      localNavBarAIO.setRight1Icon(2130850547, 2130850548);
    }
  }
  
  private final void g()
  {
    Object localObject2 = QQNewsUtilKt.a();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof QQAppInterface)) {
      localObject1 = null;
    }
    localObject2 = (QQAppInterface)localObject1;
    int i;
    Ref.ObjectRef localObjectRef;
    if (localObject2 != null)
    {
      int j = QCallFacade.a((QQAppInterface)localObject2);
      localObject1 = ((QQAppInterface)localObject2).getMessageFacade();
      if (localObject1 == null) {
        break label108;
      }
      i = ((QQMessageFacade)localObject1).b();
      i += j;
      localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = "";
      if (i > 0) {
        if (i <= 99) {
          break label113;
        }
      }
    }
    label108:
    label113:
    for (localObject1 = "99+";; localObject1 = String.valueOf(i))
    {
      localObjectRef.element = localObject1;
      UiThreadUtil.a((Runnable)new QQNewsHippyFragment.updateUnreadNumOnTitleBar..inlined.let.lambda.1(localObjectRef, this, (QQAppInterface)localObject2));
      return;
      i = 0;
      break;
    }
  }
  
  private final void h()
  {
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null) {
      localNavBarAIO.setOnSelectListener((OnItemSelectListener)new QQNewsHippyFragment.setNavClickListener..inlined.apply.lambda.1(this));
    }
  }
  
  private final void i()
  {
    if (QQNewsUtilKt.a() > 0) {
      QQNewsUtilKt.a();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public int getLayoutResId()
  {
    return 2131558453;
  }
  
  public void initViews()
  {
    super.initViews();
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a = "2909288299";
    b();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    this.jdField_a_of_type_Boolean = ThemeUtil.isDefaultOrDIYTheme(false);
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null)
    {
      localNavBarAIO.d();
      localNavBarAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
      localNavBarAIO.setRight1Icon(2130850547, 2130850548);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NavBarAIO localNavBarAIO = this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO;
    if (localNavBarAIO != null) {
      localNavBarAIO.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsHippyFragment
 * JD-Core Version:    0.7.0.1
 */