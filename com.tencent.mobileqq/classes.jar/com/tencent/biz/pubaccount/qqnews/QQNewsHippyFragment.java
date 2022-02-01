package com.tencent.biz.pubaccount.qqnews;

import android.content.Context;
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
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.util.UiThreadUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/qqnews/QQNewsHippyFragment;", "Lcom/tencent/hippy/qq/fragment/CommonHippyFragment;", "()V", "isThemeDefault", "", "navBarAIO", "Lcom/tencent/mobileqq/widget/navbar/NavBarAIO;", "sessionInfo", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "clearUnreadRedDot", "", "getLayoutResId", "", "initNavBar", "initViews", "onPostThemeChanged", "onResume", "setImmersiveBar", "setNavBarLeftView", "setNavBarRightView", "setNavBarTitleText", "setNavClickListener", "updateUnreadNumOnTitleBar", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQNewsHippyFragment
  extends CommonHippyFragment
{
  private NavBarAIO a;
  private boolean b;
  private final SessionInfo c = new SessionInfo();
  private HashMap d;
  
  private final void b()
  {
    this.a = ((NavBarAIO)this.mRootView.findViewById(2131442608));
    c();
    d();
    e();
    f();
    h();
    i();
  }
  
  private final void c()
  {
    NavBarAIO localNavBarAIO = this.a;
    if (localNavBarAIO != null)
    {
      if (this.b) {
        localNavBarAIO.setBackgroundResource(2130852228);
      } else {
        localNavBarAIO.setBackgroundResource(2130852229);
      }
      Object localObject = localNavBarAIO.getLayoutParams();
      if (localObject != null)
      {
        localObject = (LinearLayout.LayoutParams)localObject;
        ((LinearLayout.LayoutParams)localObject).setMargins(0, ImmersiveUtils.getStatusBarHeight((Context)getActivity()), 0, 0);
        localNavBarAIO.setLayoutParams((ViewGroup.LayoutParams)localObject);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }
  }
  
  private final void d()
  {
    Object localObject1 = this.a;
    if (localObject1 != null)
    {
      Object localObject2 = (TextView)((NavBarAIO)localObject1).findViewById(2131447463);
      if (localObject2 != null)
      {
        ((TextView)localObject2).setText((CharSequence)QQNewsUtilKt.d());
        ((TextView)localObject2).setContentDescription(((TextView)localObject2).getText());
      }
      localObject2 = ((NavBarAIO)localObject1).findViewById(2131447511);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject2 = ((NavBarAIO)localObject1).findViewById(2131447512);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(8);
      }
      localObject1 = ((NavBarAIO)localObject1).findViewById(2131446540);
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
  }
  
  private final void e()
  {
    NavBarAIO localNavBarAIO = this.a;
    if (localNavBarAIO != null)
    {
      ThreadManagerV2.excute((Runnable)new QQNewsHippyFragment.setNavBarLeftView..inlined.apply.lambda.1(this), 32, null, true);
      localNavBarAIO.e();
      localNavBarAIO.setEarIconVisible(false);
    }
  }
  
  private final void f()
  {
    NavBarAIO localNavBarAIO = this.a;
    if ((localNavBarAIO != null) && ((ImageView)localNavBarAIO.findViewById(2131436194) != null)) {
      localNavBarAIO.setRight1Icon(2130852269, 2130852270);
    }
  }
  
  private final void g()
  {
    Object localObject2 = QQNewsUtilKt.c();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof QQAppInterface)) {
      localObject1 = null;
    }
    localObject2 = (QQAppInterface)localObject1;
    if (localObject2 != null)
    {
      int j = QCallFacade.a((QQAppInterface)localObject2);
      localObject1 = ((QQAppInterface)localObject2).getMessageFacade();
      if (localObject1 != null) {
        i = ((QQMessageFacade)localObject1).w();
      } else {
        i = 0;
      }
      int i = j + i;
      Ref.ObjectRef localObjectRef = new Ref.ObjectRef();
      localObjectRef.element = "";
      if (i > 0)
      {
        if (i > 99) {
          localObject1 = "99+";
        } else {
          localObject1 = String.valueOf(i);
        }
        localObjectRef.element = localObject1;
      }
      UiThreadUtil.a((Runnable)new QQNewsHippyFragment.updateUnreadNumOnTitleBar..inlined.let.lambda.1(localObjectRef, this, (QQAppInterface)localObject2));
    }
  }
  
  private final void h()
  {
    NavBarAIO localNavBarAIO = this.a;
    if (localNavBarAIO != null) {
      localNavBarAIO.setOnSelectListener((OnItemSelectListener)new QQNewsHippyFragment.setNavClickListener..inlined.apply.lambda.1(this));
    }
  }
  
  private final void i()
  {
    if (QQNewsUtilKt.a() > 0) {
      QQNewsUtilKt.b();
    }
  }
  
  public void a()
  {
    HashMap localHashMap = this.d;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  protected int getLayoutResId()
  {
    return 2131624026;
  }
  
  protected void initViews()
  {
    super.initViews();
    this.b = ThemeUtil.isDefaultOrDIYTheme(false);
    this.c.b = "2909288299";
    b();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    this.b = ThemeUtil.isDefaultOrDIYTheme(false);
    NavBarAIO localNavBarAIO = this.a;
    if (localNavBarAIO != null)
    {
      localNavBarAIO.d();
      localNavBarAIO.a(this.c);
      localNavBarAIO.setRight1Icon(2130852269, 2130852270);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    NavBarAIO localNavBarAIO = this.a;
    if (localNavBarAIO != null) {
      localNavBarAIO.a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsHippyFragment
 * JD-Core Version:    0.7.0.1
 */