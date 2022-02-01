package com.tencent.luggage.wxa.standalone_open_runtime.ui;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ui.base.l;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/ui/WxaProfileActivity$WxaProfileServiceView;", "Landroid/widget/LinearLayout;", "ctx", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "descName", "getDescName", "()Ljava/lang/String;", "setDescName", "(Ljava/lang/String;)V", "headerName", "getHeaderName", "setHeaderName", "itemDesc", "getItemDesc", "setItemDesc", "itemHeader", "getItemHeader", "setItemHeader", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
final class WxaProfileActivity$WxaProfileServiceView
  extends LinearLayout
{
  @NotNull
  private String a = "";
  @NotNull
  private String b = "";
  @NotNull
  private String c = "service_header";
  @NotNull
  private String d = "service_desc";
  private HashMap e;
  
  public WxaProfileActivity$WxaProfileServiceView(@NotNull Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(l.c(paramContext, 2131168464));
    setOrientation(0);
    Object localObject = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject).setAccessible(true);
    localObject = (View)((Constructor)localObject).newInstance(new Object[] { getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
    TextView localTextView = (TextView)localObject;
    l.c((View)localTextView, this.c);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    localLayoutParams.setMarginStart(l.a(paramContext, 2131296336));
    localLayoutParams.setMarginEnd(l.a(paramContext, 2131296336));
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setGravity(8388627);
    localTextView.setTextColor(l.c(paramContext, 2131165207));
    localTextView.setTextSize(0, l.a(paramContext, 2131296390));
    addView((View)localObject);
    localObject = TextView.class.getDeclaredConstructor(new Class[] { Context.class });
    ((Constructor)localObject).setAccessible(true);
    localObject = (View)((Constructor)localObject).newInstance(new Object[] { getContext() });
    Intrinsics.checkExpressionValueIsNotNull(localObject, "view");
    localTextView = (TextView)localObject;
    l.c((View)localTextView, this.d);
    localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.setMarginStart(l.a(paramContext, 2131296336));
    localLayoutParams.setMarginEnd(l.a(paramContext, 2131296336));
    localLayoutParams.gravity = 8388627;
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localLayoutParams);
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(l.c(paramContext, 2131165207));
    localTextView.setTextSize(0, l.a(paramContext, 2131296390));
    localTextView.setGravity(8388627);
    addView((View)localObject);
  }
  
  public void _$_clearFindViewByIdCache()
  {
    HashMap localHashMap = this.e;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public View _$_findCachedViewById(int paramInt)
  {
    if (this.e == null) {
      this.e = new HashMap();
    }
    View localView2 = (View)this.e.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this.e.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  @NotNull
  public final String getDescName()
  {
    return this.d;
  }
  
  @NotNull
  public final String getHeaderName()
  {
    return this.c;
  }
  
  @NotNull
  public final String getItemDesc()
  {
    return this.b;
  }
  
  @NotNull
  public final String getItemHeader()
  {
    return this.a;
  }
  
  public final void setDescName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    ((TextView)l.a(this, this.d)).setId(paramString.hashCode());
    this.d = paramString;
  }
  
  public final void setHeaderName(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    ((TextView)l.a(this, this.c)).setId(paramString.hashCode());
    this.c = paramString;
  }
  
  public final void setItemDesc(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    ((TextView)l.a(this, this.d)).setText((CharSequence)paramString);
    this.b = paramString;
  }
  
  public final void setItemHeader(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    ((TextView)l.a(this, this.c)).setText((CharSequence)paramString);
    this.a = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.WxaProfileActivity.WxaProfileServiceView
 * JD-Core Version:    0.7.0.1
 */