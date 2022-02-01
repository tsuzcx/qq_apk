package com.tencent.mm.ui.widget.edittext;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.RequiresApi;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SelectableEditTextHelper
{
  private static Map<Integer, CharSequence> E = new HashMap();
  private static String F;
  private int A;
  private int B;
  private int C;
  private SelectableEditTextHelper.Builder D;
  private int[] G = new int[2];
  private boolean H;
  private ActionMode.Callback I = new SelectableEditTextHelper.11(this);
  private int J = -1;
  private final Runnable K = new SelectableEditTextHelper.12(this);
  private boolean L = false;
  private SelectableEditTextHelper.CursorHandle a;
  private SelectableEditTextHelper.CursorHandle b;
  private SelectableEditTextHelper.OperateWindow c;
  private SelectableEditTextHelper.SelectionInfo d = new SelectableEditTextHelper.SelectionInfo();
  private SelectableEditTextHelper.OnSelectListener e;
  private Context f;
  private TextView g;
  private Spannable h;
  private ViewTreeObserver.OnPreDrawListener i;
  private ViewTreeObserver.OnScrollChangedListener j;
  private View.OnAttachStateChangeListener k;
  private View.OnLayoutChangeListener l;
  private TextWatcher m;
  private View.OnLongClickListener n;
  private View.OnTouchListener o;
  private View.OnFocusChangeListener p;
  private View.OnClickListener q;
  private SelectableEditTextHelper.OnMenuCallback r;
  private int s;
  private int t;
  private int u;
  private boolean v;
  private boolean w = true;
  private int x;
  private boolean y;
  private boolean z = false;
  
  public SelectableEditTextHelper(SelectableEditTextHelper.Builder paramBuilder)
  {
    this.D = paramBuilder;
    this.g = SelectableEditTextHelper.Builder.a(paramBuilder);
    this.f = this.g.getContext();
    this.s = this.f.getResources().getColor(SelectableEditTextHelper.Builder.b(paramBuilder));
    this.t = this.f.getResources().getColor(SelectableEditTextHelper.Builder.c(paramBuilder));
    this.u = g.a(this.f, (int)SelectableEditTextHelper.Builder.d(paramBuilder));
    this.x = TextLayoutUtil.getLineHeight(this.g);
    this.y = SelectableEditTextHelper.Builder.e(paramBuilder);
    boolean bool;
    if ((!TextUtils.isEmpty(Build.BRAND)) && (TextUtils.equals(Build.BRAND.toLowerCase(), "xiaomi"))) {
      bool = true;
    } else {
      bool = false;
    }
    this.H = bool;
    f.c("SelectableEditTextHelper", "init %s,%s,%s,%s", new Object[] { Boolean.valueOf(this.y), SelectableEditTextHelper.Builder.f(this.D), F, Build.BRAND });
    e();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (this.g.getLayout() != null)
    {
      if (this.g.getWidth() == 0) {
        return;
      }
      SelectableEditTextHelper.CursorHandle localCursorHandle = this.a;
      int i1 = 1;
      if (localCursorHandle == null) {
        this.a = new SelectableEditTextHelper.CursorHandle(this, true);
      }
      if (this.b == null) {
        this.b = new SelectableEditTextHelper.CursorHandle(this, false);
      }
      paramInt1 = this.g.getOffsetForPosition(paramInt1, paramInt2);
      if (!paramBoolean) {
        paramInt1 = this.g.getSelectionStart();
      }
      int i2 = paramInt1 + 1;
      if ((this.g.getText() instanceof Spannable)) {
        this.h = ((Spannable)this.g.getText());
      }
      if (this.h == null) {
        return;
      }
      if ((paramInt1 < this.g.getText().length()) && (paramBoolean)) {
        paramInt2 = i1;
      } else {
        paramInt2 = 0;
      }
      if (paramInt2 != 0)
      {
        this.g.setCursorVisible(false);
        i1 = i2;
      }
      else
      {
        i1 = paramInt1;
      }
      if ((!this.w) && (this.d.mStart == paramInt1) && (this.d.mEnd == i1)) {
        return;
      }
      g();
      h();
      this.w = false;
      b(paramInt1, i1);
      if (paramInt2 != 0)
      {
        a(this.a);
        a(this.b);
      }
      a(this.c);
    }
  }
  
  private void a(Menu paramMenu)
  {
    if ((paramMenu != null) && (SelectableEditTextHelper.Builder.g(this.D).size() > 0))
    {
      int i1 = 0;
      while (i1 < paramMenu.size())
      {
        MenuItem localMenuItem = paramMenu.getItem(i1);
        f.b("SelectableEditTextHelper", "filterReuseMenus:%s", new Object[] { localMenuItem.getTitle() });
        if (SelectableEditTextHelper.Builder.g(this.D).contains(localMenuItem.getTitle()))
        {
          f.b("SelectableEditTextHelper", "reuse bingo:%s", new Object[] { localMenuItem.getTitle() });
          E.put(Integer.valueOf(localMenuItem.getItemId()), localMenuItem.getTitle());
        }
        i1 += 1;
      }
    }
  }
  
  private void a(SelectableEditTextHelper.CursorHandle paramCursorHandle)
  {
    if (paramCursorHandle == null) {
      return;
    }
    Layout localLayout = this.g.getLayout();
    int i1;
    if (SelectableEditTextHelper.CursorHandle.a(paramCursorHandle)) {
      i1 = this.d.mStart;
    } else {
      i1 = this.d.mEnd;
    }
    paramCursorHandle.show((int)localLayout.getPrimaryHorizontal(i1), localLayout.getLineBottom(localLayout.getLineForOffset(i1)));
  }
  
  private void a(SelectableEditTextHelper.OperateWindow paramOperateWindow)
  {
    if (paramOperateWindow != null) {
      paramOperateWindow.show();
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      this.d.mStart = paramInt1;
    }
    if (paramInt2 != -1) {
      this.d.mEnd = paramInt2;
    }
    Object localObject;
    if (this.d.mStart > this.d.mEnd)
    {
      paramInt2 = this.d.mStart;
      localObject = this.d;
      ((SelectableEditTextHelper.SelectionInfo)localObject).mStart = ((SelectableEditTextHelper.SelectionInfo)localObject).mEnd;
      this.d.mEnd = paramInt2;
    }
    if (this.h != null)
    {
      if (paramInt1 >= this.g.getText().length()) {
        return;
      }
      localObject = this.d;
      ((SelectableEditTextHelper.SelectionInfo)localObject).mSelectionContent = this.h.subSequence(((SelectableEditTextHelper.SelectionInfo)localObject).mStart, this.d.mEnd).toString();
      this.g.setHighlightColor(this.s);
      Selection.setSelection(this.h, this.d.mStart, this.d.mEnd);
      localObject = this.e;
      if (localObject != null) {
        ((SelectableEditTextHelper.OnSelectListener)localObject).onTextSelected(this.d.mSelectionContent);
      }
    }
  }
  
  private void b(SelectableEditTextHelper.CursorHandle paramCursorHandle)
  {
    if (paramCursorHandle != null) {
      paramCursorHandle.dismiss();
    }
  }
  
  private void b(SelectableEditTextHelper.OperateWindow paramOperateWindow)
  {
    if (paramOperateWindow != null) {
      paramOperateWindow.dismiss();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      f.b("SelectableEditTextHelper", "setInsertionDisabled", new Object[0]);
      Object localObject1 = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject1).setAccessible(true);
      localObject1 = ((Field)localObject1).get(this.g);
      Object localObject2 = Class.forName("android.widget.Editor");
      Field localField = ((Class)localObject2).getDeclaredField("mInsertionControllerEnabled");
      localField.setAccessible(true);
      localField.set(localObject1, Boolean.valueOf(paramBoolean));
      localObject2 = ((Class)localObject2).getDeclaredField("mSelectionControllerEnabled");
      ((Field)localObject2).setAccessible(true);
      ((Field)localObject2).set(localObject1, Boolean.valueOf(paramBoolean));
      return;
    }
    catch (Exception localException)
    {
      f.e("SelectableEditTextHelper", "setInsertionDisabled error msg:%s", new Object[] { localException.getMessage() });
    }
  }
  
  private boolean b()
  {
    return (SelectableEditTextHelper.Builder.g(this.D).size() > 0) && (Build.BRAND != null) && (SelectableEditTextHelper.Builder.h(this.D).contains(Build.BRAND.toLowerCase())) && (!TextUtils.equals(F, SelectableEditTextHelper.Builder.f(this.D))) && (Build.VERSION.SDK_INT >= 23) && (this.y);
  }
  
  private boolean b(TextView paramTextView)
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      localObject = Class.forName("android.widget.Editor").getDeclaredMethod("startInsertionActionMode", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramTextView, new Object[0]);
      return true;
    }
    catch (Throwable paramTextView)
    {
      f.e("SelectableEditTextHelper", "startInsertionActionMode err:%s", new Object[] { paramTextView.getMessage() });
    }
    return false;
  }
  
  private SelectableEditTextHelper.CursorHandle c(boolean paramBoolean)
  {
    if (SelectableEditTextHelper.CursorHandle.a(this.a) == paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  @RequiresApi(api=23)
  private void c()
  {
    d();
    boolean bool1 = exemptAllDeclaredMethods();
    boolean bool2 = b(this.g);
    F = SelectableEditTextHelper.Builder.f(this.D);
    f.c("SelectableEditTextHelper", "startInsertionActionMode SDK_INT:%s, exemptRes:%s ,res:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
  }
  
  private static void c(TextView paramTextView)
  {
    try
    {
      Object localObject = TextView.class.getDeclaredField("mEditor");
      ((Field)localObject).setAccessible(true);
      paramTextView = ((Field)localObject).get(paramTextView);
      localObject = Class.forName("android.widget.Editor").getDeclaredMethod("stopSelectionActionMode", new Class[0]);
      ((Method)localObject).setAccessible(true);
      ((Method)localObject).invoke(paramTextView, new Object[0]);
      return;
    }
    catch (Throwable paramTextView)
    {
      paramTextView.printStackTrace();
      f.e("SelectableEditTextHelper", "stopSelectionMode err:%s", new Object[] { paramTextView.getMessage() });
    }
  }
  
  private void d()
  {
    try
    {
      Field localField = TextView.class.getDeclaredField("mTextSelectHandleRes");
      localField.setAccessible(true);
      localField.set(this.g, Integer.valueOf(2130853311));
      return;
    }
    catch (Exception localException)
    {
      f.e("SelectableEditTextHelper", "disableSysHandle fail:", new Object[] { localException.getMessage() });
    }
  }
  
  private void e()
  {
    TextView localTextView = this.g;
    localTextView.setText(localTextView.getText(), TextView.BufferType.SPANNABLE);
    this.h = ((Spannable)this.g.getText());
    this.g.setCustomSelectionActionModeCallback(this.I);
    if (Build.VERSION.SDK_INT >= 23) {
      this.g.setCustomInsertionActionModeCallback(this.I);
    }
    this.g.setOnLongClickListener(new SelectableEditTextHelper.1(this));
    this.g.setOnTouchListener(new SelectableEditTextHelper.2(this));
    this.g.setOnClickListener(new SelectableEditTextHelper.3(this));
    this.g.setOnFocusChangeListener(new SelectableEditTextHelper.4(this));
    if (!this.y) {
      return;
    }
    this.m = new SelectableEditTextHelper.5(this);
    this.k = new SelectableEditTextHelper.6(this);
    this.l = new SelectableEditTextHelper.7(this);
    this.i = new SelectableEditTextHelper.8(this);
    this.j = new SelectableEditTextHelper.9(this);
    this.g.addTextChangedListener(this.m);
    this.g.addOnAttachStateChangeListener(this.k);
    this.g.addOnLayoutChangeListener(this.l);
    this.g.getViewTreeObserver().addOnPreDrawListener(this.i);
    this.g.getViewTreeObserver().addOnScrollChangedListener(this.j);
    this.c = new SelectableEditTextHelper.OperateWindow(this, this.f);
  }
  
  public static boolean exemptAllDeclaredMethods()
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      Object localObject = Class.class.getDeclaredMethod("forName", new Class[] { String.class });
      Method localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, [Ljava.lang.Class.class });
      Class localClass = (Class)((Method)localObject).invoke(null, new Object[] { "dalvik.system.VMRuntime" });
      localObject = (Method)localMethod.invoke(localClass, new Object[] { "getRuntime", null });
      localMethod = (Method)localMethod.invoke(localClass, new Object[] { "setHiddenApiExemptions", { [Ljava.lang.String.class } });
      localObject = ((Method)localObject).invoke(null, new Object[0]);
      if (localObject != null)
      {
        if (localMethod == null) {
          return false;
        }
        localMethod.invoke(localObject, new Object[] { { "L" } });
        return true;
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return true;
    return false;
  }
  
  private void f()
  {
    if ((!TextUtils.isEmpty(Build.BRAND)) && ("vivo".equals(Build.BRAND.toLowerCase())) && (Build.VERSION.SDK_INT < 23)) {
      this.g.post(new SelectableEditTextHelper.10(this));
    }
  }
  
  private void g()
  {
    this.w = true;
    b(this.a);
    b(this.b);
    b(this.c);
  }
  
  private void h()
  {
    this.d.mSelectionContent = null;
  }
  
  private int i()
  {
    return this.g.getScrollY();
  }
  
  void a(boolean paramBoolean)
  {
    if (this.L) {
      return;
    }
    if (!paramBoolean)
    {
      closeSelectAndTools();
      return;
    }
    int i1 = this.g.getSelectionStart();
    if (this.w)
    {
      if (this.J != i1)
      {
        closeSelectAndTools();
      }
      else
      {
        a(this.A, this.B, false);
        this.J = i1;
      }
    }
    else {
      closeSelectAndTools();
    }
    this.g.setCursorVisible(true);
    this.J = i1;
  }
  
  public void closeSelectAndTools()
  {
    h();
    g();
    Selection.setSelection(this.g.getEditableText(), this.g.getSelectionEnd());
  }
  
  public void destroy()
  {
    this.g.removeTextChangedListener(this.m);
    this.g.removeOnAttachStateChangeListener(this.k);
    this.g.removeOnLayoutChangeListener(this.l);
    this.g.getViewTreeObserver().removeOnScrollChangedListener(this.j);
    this.g.getViewTreeObserver().removeOnPreDrawListener(this.i);
    h();
    g();
    this.a = null;
    this.b = null;
    this.c = null;
  }
  
  public void pause()
  {
    this.L = true;
    closeSelectAndTools();
  }
  
  public void resume()
  {
    closeSelectAndTools();
    this.L = false;
  }
  
  public void setMenuCallback(SelectableEditTextHelper.OnMenuCallback paramOnMenuCallback)
  {
    this.r = paramOnMenuCallback;
  }
  
  public void setOutOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.q = paramOnClickListener;
  }
  
  public void setOutOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    this.p = paramOnFocusChangeListener;
  }
  
  public void setOutOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.n = paramOnLongClickListener;
  }
  
  public void setOutOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.o = paramOnTouchListener;
  }
  
  public void setSelectListener(SelectableEditTextHelper.OnSelectListener paramOnSelectListener)
  {
    this.e = paramOnSelectListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper
 * JD-Core Version:    0.7.0.1
 */