package com.tencent.luggage.setting.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ItemAnimator;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.luggage.ui.WmpfPresentationActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper.a;
import com.tencent.luggage.wxa.eh.b;
import com.tencent.luggage.wxa.eh.d;
import com.tencent.luggage.wxa.eh.d.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.dialog.e;
import com.tencent.mm.ui.base.c;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.ISwitch;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/setting/ui/AppBrandUserInfoAuthorizeUI;", "Lcom/tencent/mm/ui/base/BaseLuggageActivity;", "Lcom/tencent/luggage/util/LuggageActivityHelper$ILuggageActivityHelper;", "()V", "currentSelectedUserId", "", "hadShowCloseNote", "", "isOpen", "mOriginalToCompare", "", "Lcom/tencent/luggage/setting/ui/WxaUserInfoListAdapter$Item;", "mProgressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "mUserinfoListItems", "mainSwitch", "Lcom/tencent/mm/ui/widget/MMSwitchBtn;", "rootView", "Landroid/view/View;", "wxaUserInfoListOperationController", "Lcom/tencent/luggage/setting/entity/WxaUserInfoListOperationController;", "checkUserInfoModified", "dismiss", "", "getLayoutId", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "processMainSwitchClick", "check", "showUserInfoPanel", "open", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class AppBrandUserInfoAuthorizeUI
  extends c
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  public static final AppBrandUserInfoAuthorizeUI.a a = new AppBrandUserInfoAuthorizeUI.a(null);
  private final List<a.a> b = (List)new ArrayList();
  private List<a.a> c;
  private boolean d;
  private boolean e;
  private int f;
  private MMSwitchBtn g;
  private e h;
  private d i;
  private View j;
  
  private final void a()
  {
    Object localObject1 = this.h;
    if (localObject1 != null) {
      ((e)localObject1).dismiss();
    }
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("key_result_user_info_list_been_modified", b());
    ((Intent)localObject1).putExtra("key_result_is_open", this.d);
    ((Intent)localObject1).putExtra("key_result_selected_user_id", this.f);
    Object localObject2 = PresentationActivityHelper.Companion;
    Intent localIntent = getIntent();
    Intrinsics.checkExpressionValueIsNotNull(localIntent, "getIntent()");
    ((PresentationActivityHelper.a)localObject2).a(-1, localIntent, (Intent)localObject1);
    localObject1 = WmpfPresentationActivityHelper.a;
    localObject2 = (Activity)this;
    ((WmpfPresentationActivityHelper)localObject1).a((Activity)localObject2);
    WmpfPresentationActivityHelper.a.b((Activity)localObject2);
  }
  
  private final void a(boolean paramBoolean)
  {
    Function0 localFunction01 = (Function0)new AppBrandUserInfoAuthorizeUI.k(this);
    Function0 localFunction02 = (Function0)new AppBrandUserInfoAuthorizeUI.l(this, paramBoolean);
    if ((!paramBoolean) && (!this.e))
    {
      this.e = true;
      com.tencent.luggage.wxa.el.a.a.a((Context)this, (DialogInterface.OnClickListener)new AppBrandUserInfoAuthorizeUI.h(localFunction02), (DialogInterface.OnClickListener)new AppBrandUserInfoAuthorizeUI.i(localFunction01), (DialogInterface.OnCancelListener)new AppBrandUserInfoAuthorizeUI.j(localFunction01));
      return;
    }
    localFunction02.invoke();
  }
  
  private final void b(boolean paramBoolean)
  {
    Object localObject = this.j;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("rootView");
    }
    localObject = ((View)localObject).findViewById(2131449262);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "rootView.findViewById<Li…ut>(R.id.user_info_panel)");
    localObject = (LinearLayout)localObject;
    int k;
    if (paramBoolean) {
      k = 0;
    } else {
      k = 8;
    }
    ((LinearLayout)localObject).setVisibility(k);
  }
  
  private final boolean b()
  {
    Object localObject1 = this.c;
    boolean bool = true;
    if (localObject1 != null)
    {
      if (((List)localObject1).size() != this.b.size()) {
        return true;
      }
      localObject1 = ((Iterable)this.b).iterator();
      bool = false;
      while (((Iterator)localObject1).hasNext())
      {
        a.a locala1 = (a.a)((Iterator)localObject1).next();
        Object localObject2 = this.c;
        if (localObject2 != null)
        {
          localObject2 = ((Iterable)localObject2).iterator();
          int k = 0;
          for (;;)
          {
            m = k;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            a.a locala2 = (a.a)((Iterator)localObject2).next();
            if (locala1.f() == locala2.f()) {
              k = 1;
            }
          }
        }
        int m = 0;
        if (m == 0) {
          bool = true;
        }
      }
    }
    return bool;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected int getLayoutId()
  {
    return 2131624014;
  }
  
  public void onBackPressed()
  {
    a();
    super.onBackPressed();
  }
  
  public void onConfigurationChanged(@Nullable Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    d locald = this.i;
    if (locald == null) {
      Intrinsics.throwUninitializedPropertyAccessException("wxaUserInfoListOperationController");
    }
    locald.b();
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int k = getIntent().getIntExtra("key_display_id", 0);
    paramBundle = getWindow();
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window");
    paramBundle = paramBundle.getDecorView().findViewById(16908290);
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "window.decorView.findVie…ew>(android.R.id.content)");
    paramBundle = paramBundle.getParent();
    if (paramBundle != null)
    {
      this.j = ((View)paramBundle);
      Object localObject1;
      if (k != 0)
      {
        paramBundle = this.j;
        if (paramBundle == null) {
          Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        if ((paramBundle instanceof ViewGroup))
        {
          paramBundle = WmpfPresentationActivityHelper.a;
          localObject1 = (Activity)this;
          localObject2 = this.j;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          if (localObject2 != null) {
            paramBundle.a((Activity)localObject1, (ViewGroup)localObject2, k, true);
          } else {
            throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
          }
        }
      }
      else
      {
        WmpfPresentationActivityHelper.a.a((Activity)this, null, k, false);
      }
      paramBundle = (FrameLayout)findViewById(2131428917);
      Context localContext = (Context)this;
      paramBundle.addView(LayoutInflater.from(localContext).inflate(2131624013, (ViewGroup)paramBundle, false), -1, -1);
      setBackBtn((MenuItem.OnMenuItemClickListener)new AppBrandUserInfoAuthorizeUI.e(this));
      setTitle(2131886987);
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        localObject1 = (b)paramBundle.getParcelable("key_user_info");
      } else {
        localObject1 = null;
      }
      paramBundle = getIntent().getExtras();
      if (paramBundle != null) {
        paramBundle = paramBundle.getString("key_app_id");
      } else {
        paramBundle = null;
      }
      Object localObject2 = getIntent().getExtras();
      if (localObject2 != null) {
        localObject2 = Boolean.valueOf(((Bundle)localObject2).getBoolean("key_is_state_open"));
      } else {
        localObject2 = null;
      }
      boolean bool;
      if (localObject2 != null) {
        bool = ((Boolean)localObject2).booleanValue();
      } else {
        bool = false;
      }
      this.d = bool;
      b(this.d);
      if ((localObject1 != null) && (paramBundle != null))
      {
        this.f = ((b)localObject1).d();
        paramBundle = this.j;
        if (paramBundle == null) {
          Intrinsics.throwUninitializedPropertyAccessException("rootView");
        }
        paramBundle = paramBundle.findViewById(2131437921);
        if (paramBundle != null)
        {
          paramBundle = (MMSwitchBtn)paramBundle;
          paramBundle.setCheck(this.d);
          paramBundle.setSwitchListener((MMSwitchBtn.ISwitch)new AppBrandUserInfoAuthorizeUI.d(this));
          this.g = paramBundle;
          paramBundle = getIntent().getExtras();
          if (paramBundle != null) {
            paramBundle = paramBundle.getString("key_nickname");
          } else {
            paramBundle = null;
          }
          if (paramBundle == null) {
            paramBundle = "";
          }
          localObject2 = this.j;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          localObject2 = ((View)localObject2).findViewById(2131431733);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "rootView.findViewById<TextView>(R.id.desc)");
          localObject2 = (TextView)localObject2;
          Object localObject3 = StringCompanionObject.INSTANCE;
          localObject3 = getString(2131886986);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "getString(R.string.appbr…g_usernifo_authrize_desc)");
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramBundle;
          localObject3 = String.format((String)localObject3, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "java.lang.String.format(format, *args)");
          ((TextView)localObject2).setText((CharSequence)localObject3);
          localObject2 = this.j;
          if (localObject2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          localObject2 = ((View)localObject2).findViewById(2131449233);
          Intrinsics.checkExpressionValueIsNotNull(localObject2, "rootView.findViewById<Te…iew>(R.id.user_Info_desc)");
          localObject2 = (TextView)localObject2;
          localObject3 = StringCompanionObject.INSTANCE;
          localObject3 = getString(2131886989);
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "getString(R.string.appbr…rize_user_info_list_desc)");
          arrayOfObject = new Object[1];
          arrayOfObject[0] = paramBundle;
          paramBundle = String.format((String)localObject3, Arrays.copyOf(arrayOfObject, arrayOfObject.length));
          Intrinsics.checkExpressionValueIsNotNull(paramBundle, "java.lang.String.format(format, *args)");
          ((TextView)localObject2).setText((CharSequence)paramBundle);
          paramBundle = this.j;
          if (paramBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          paramBundle = paramBundle.findViewById(2131449261);
          Intrinsics.checkExpressionValueIsNotNull(paramBundle, "rootView.findViewById<Re…iew>(R.id.user_info_list)");
          ((RecyclerView)paramBundle).setNestedScrollingEnabled(false);
          this.i = new d(localContext, (b)localObject1, "", (d.b)new AppBrandUserInfoAuthorizeUI.f(this));
          paramBundle = this.i;
          if (paramBundle == null) {
            Intrinsics.throwUninitializedPropertyAccessException("wxaUserInfoListOperationController");
          }
          paramBundle.a((com.tencent.luggage.wxa.eh.a.a)new AppBrandUserInfoAuthorizeUI.g(this));
          paramBundle = new a(this.b);
          localObject1 = this.j;
          if (localObject1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootView");
          }
          localObject1 = (RecyclerView)((View)localObject1).findViewById(2131449261);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "userInfoList");
          ((RecyclerView)localObject1).setAdapter((RecyclerView.Adapter)paramBundle);
          ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(localContext));
          ((RecyclerView)localObject1).setItemAnimator((RecyclerView.ItemAnimator)null);
          paramBundle.a((a.c)new AppBrandUserInfoAuthorizeUI.b(this));
          paramBundle.a((a.b)new AppBrandUserInfoAuthorizeUI.c(this));
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMSwitchBtn");
      }
      o.d("AppBrandUserInfoAuthorizeUI", "WxaUserInfoData or appId is null, finish activity");
      a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.View");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.AppBrandUserInfoAuthorizeUI
 * JD-Core Version:    0.7.0.1
 */