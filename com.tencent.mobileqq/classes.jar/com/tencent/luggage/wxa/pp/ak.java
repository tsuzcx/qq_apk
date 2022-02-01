package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Locale;
import org.joor.Reflect;

public enum ak
{
  static final Class a;
  
  static
  {
    Object localObject;
    try
    {
      Class localClass = Class.forName("android.view.inputmethod.ComposingText");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      o.b("MicroMsg.AppBrand.InputUtil", "class for ComposingText e = %s", new Object[] { localClassNotFoundException });
      localObject = null;
    }
    a = localObject;
  }
  
  static int a(Integer paramInteger, int paramInt)
  {
    if (paramInteger != null) {
      paramInt = paramInteger.intValue();
    }
    return paramInt;
  }
  
  static Spannable a(CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    if ((localObject instanceof Spannable)) {
      return (Spannable)localObject;
    }
    return new SpannableStringBuilder((CharSequence)localObject);
  }
  
  public static InputMethodManager a(View paramView)
  {
    if (paramView != null)
    {
      Context localContext = paramView.getContext();
      paramView = localContext;
      if (localContext != null) {}
    }
    else
    {
      paramView = r.a();
    }
    return (InputMethodManager)paramView.getSystemService("input_method");
  }
  
  public static boolean a(View paramView1, View paramView2)
  {
    if (paramView1 != null)
    {
      if (paramView2 == null) {
        return false;
      }
      paramView2 = paramView2.getParent();
      ViewParent localViewParent;
      do
      {
        if (paramView1 == paramView2) {
          return true;
        }
        localViewParent = paramView2.getParent();
        paramView2 = localViewParent;
      } while (localViewParent != null);
    }
    return false;
  }
  
  static boolean a(Boolean paramBoolean)
  {
    return (paramBoolean != null) && (paramBoolean.booleanValue());
  }
  
  static boolean a(Object paramObject)
  {
    return a.isInstance(paramObject);
  }
  
  public static void b(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      o.c("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo skip >=30");
      return;
    }
    Object localObject = a(paramView);
    if (localObject == null) {
      paramView = "NULL Imm";
    }
    try
    {
      paramView = (View)Reflect.on(localObject).get("mServedView");
      localObject = (View)Reflect.on(localObject).get("mNextServedView");
      paramView = String.format(Locale.US, "mServedView=%s, mNextServedView=%s", new Object[] { paramView, localObject });
      o.d("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo: %s", new Object[] { paramView });
      return;
    }
    catch (Exception paramView)
    {
      o.b("MicroMsg.AppBrand.InputUtil", "dumpImmDebugInfo reflect failed %s", new Object[] { paramView });
    }
  }
  
  public static boolean b(CharSequence paramCharSequence)
  {
    boolean bool3 = paramCharSequence instanceof Spanned;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramCharSequence = (Spanned)paramCharSequence;
      paramCharSequence = paramCharSequence.getSpans(0, paramCharSequence.length(), a);
      bool1 = bool2;
      if (paramCharSequence != null)
      {
        bool1 = bool2;
        if (paramCharSequence.length > 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ak
 * JD-Core Version:    0.7.0.1
 */