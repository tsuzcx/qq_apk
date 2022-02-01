package com.tencent.luggage.wxa.pp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.Layout.Alignment;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.style.AlignmentSpan.Standard;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import androidx.annotation.CallSuper;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.tencent.luggage.wxa.pr.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

@SuppressLint({"AppCompatCustomView"})
public abstract class z
  extends EditText
  implements ac, com.tencent.mm.plugin.appbrand.widget.base.c
{
  private InputConnection a;
  private boolean b = false;
  private volatile int c = -1;
  @Nullable
  private final com.tencent.luggage.wxa.pq.b d;
  private final Map<ac.a, Object> e = new ArrayMap();
  private final Map<View.OnFocusChangeListener, Object> f = new ArrayMap();
  private final Map<ac.c, Object> g = new ArrayMap();
  private final z.a h = new z.a(this, null);
  private final PasswordTransformationMethod i = new m();
  private final aa j = new aa(this);
  private boolean k;
  private int l = 0;
  private boolean m = false;
  private final int[] n = new int[2];
  private boolean o = false;
  private ac.b p;
  private char q = '\000';
  
  public z(Context paramContext)
  {
    super(paramContext);
    setBackgroundDrawable(null);
    setIncludeFontPadding(false);
    h();
    setSingleLine(true);
    setTextCursorDrawable(2130838708);
    setTextIsSelectable(true);
    setFocusable(true);
    setFocusableInTouchMode(true);
    if (Build.VERSION.SDK_INT >= 16) {
      setLineSpacing(0.0F, 1.0F);
    }
    setTypeface(Typeface.SANS_SERIF);
    super.addTextChangedListener(this.h);
    super.setPadding(0, 0, 0, 0);
    super.setEditableFactory(new z.1(this));
    if (d()) {
      this.d = new com.tencent.luggage.wxa.pq.b(this);
    } else {
      this.d = null;
    }
    this.k = true;
  }
  
  private String a(Editable paramEditable, com.tencent.luggage.wxa.qt.a parama, com.tencent.luggage.wxa.qt.c paramc)
  {
    int i1 = 0;
    paramc.a = 0;
    parama.a = false;
    if ((paramEditable != null) && (paramEditable.length() > 0))
    {
      Object localObject = paramEditable.toString();
      int i2 = paramEditable.length();
      for (paramEditable = (Editable)localObject; i1 < i2; paramEditable = (Editable)localObject)
      {
        int i3 = paramEditable.codePointAt(i1);
        b.a locala = com.tencent.luggage.wxa.pr.a.a().a(i3);
        localObject = paramEditable;
        if (locala != null)
        {
          localObject = paramEditable;
          if (locala.a != 0)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(Character.toChars(locala.a));
            if (locala.b != 0) {
              localObject = Character.toChars(locala.b);
            } else {
              localObject = "";
            }
            localStringBuilder.append(localObject);
            localObject = localStringBuilder.toString();
            localObject = paramEditable.replace(new String(Character.toChars(i3)), (CharSequence)localObject);
            parama.a = true;
            paramc.a += 1;
          }
        }
        i1 += 1;
      }
      return paramEditable;
    }
    return null;
  }
  
  private void b(int paramInt)
  {
    setGravity(paramInt | getGravity() & 0xFF7FFFFC & 0xFF7FFFFA);
    f();
  }
  
  private void f()
  {
    int i1 = getGravity();
    Object localObject = getHint();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      Spannable localSpannable = ak.a((CharSequence)localObject);
      int i2 = i1 & 0x7;
      i1 = 5;
      if (i2 != 1)
      {
        if (i2 != 5) {
          localObject = Layout.Alignment.ALIGN_NORMAL;
        } else {
          localObject = Layout.Alignment.ALIGN_OPPOSITE;
        }
      }
      else {
        localObject = Layout.Alignment.ALIGN_CENTER;
      }
      localSpannable.setSpan(new AlignmentSpan.Standard((Layout.Alignment)localObject), 0, getHint().length(), 18);
      super.setHint(localSpannable);
      if (Build.VERSION.SDK_INT >= 17)
      {
        i2 = z.3.a[localObject.ordinal()];
        if (i2 != 1)
        {
          if (i2 == 2) {
            i1 = 6;
          }
        }
        else {
          i1 = 4;
        }
        super.setTextAlignment(i1);
      }
    }
  }
  
  private void q()
  {
    this.l = 0;
  }
  
  private boolean r()
  {
    return this.l > 0;
  }
  
  public int a(int paramInt)
  {
    int i1 = getPaddingTop() + (int)(paramInt * (getLineHeight() + getLineSpacingExtra()));
    o.e("MicroMsg.AppBrand.WebEditText", "calculateLinePosition, lineNumber %d, returnHeight %d, layout %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i1), getLayout() });
    return i1;
  }
  
  @CallSuper
  Editable a(Editable paramEditable)
  {
    return this.j.a(paramEditable);
  }
  
  public void a(char paramChar)
  {
    this.q = paramChar;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    throw new IllegalStateException("Should implement performClick(float, float) in this class!");
  }
  
  public void a(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.f.put(paramOnFocusChangeListener, this);
    }
  }
  
  public void a(ac.a parama)
  {
    if (parama != null) {
      this.e.put(parama, this);
    }
  }
  
  public void a(ac.c paramc)
  {
    if (paramc != null) {
      this.g.put(paramc, this);
    }
  }
  
  public void a(u paramu)
  {
    com.tencent.luggage.wxa.pq.b localb = this.d;
    if (localb != null) {
      localb.a(paramu);
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    Editable localEditable = getEditableText();
    if (localEditable == null)
    {
      setText(paramCharSequence, TextView.BufferType.EDITABLE);
      return;
    }
    clearComposingText();
    if (TextUtils.isEmpty(paramCharSequence))
    {
      localEditable.clear();
      return;
    }
    localEditable.replace(0, localEditable.length(), paramCharSequence);
  }
  
  public boolean a()
  {
    return false;
  }
  
  protected final boolean a(int paramInt, Rect paramRect)
  {
    return super.requestFocus(paramInt, paramRect);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.h.a(paramTextWatcher);
  }
  
  public void b(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (paramOnFocusChangeListener != null) {
      this.f.remove(paramOnFocusChangeListener);
    }
  }
  
  public void b(u paramu)
  {
    com.tencent.luggage.wxa.pq.b localb = this.d;
    if (localb != null) {
      localb.b(paramu);
    }
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    l();
    a(paramCharSequence);
    m();
  }
  
  public boolean b()
  {
    return this.m;
  }
  
  public void clearFocus()
  {
    if ((getParent() instanceof ViewGroup))
    {
      ((ViewGroup)getParent()).setFocusableInTouchMode(true);
      ((ViewGroup)getParent()).setDescendantFocusability(131072);
    }
    super.clearFocus();
  }
  
  public boolean d()
  {
    return true;
  }
  
  protected abstract void e();
  
  public int g()
  {
    return a(getLineCount()) + getPaddingBottom();
  }
  
  public com.tencent.luggage.wxa.pq.b getAutoFillController()
  {
    return this.d;
  }
  
  public int getAutofillType()
  {
    return 0;
  }
  
  public int getInputId()
  {
    return this.c;
  }
  
  public char getLastKeyPressed()
  {
    return this.q;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public void h()
  {
    b(3);
  }
  
  public void i()
  {
    b(5);
  }
  
  public void j()
  {
    b(1);
  }
  
  final void k()
  {
    l();
    setText(getEditableText());
    m();
  }
  
  final void l()
  {
    this.l += 1;
  }
  
  final void m()
  {
    this.l = Math.max(0, this.l - 1);
  }
  
  public final boolean n()
  {
    return this.b;
  }
  
  protected final void o()
  {
    super.clearFocus();
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (!this.e.isEmpty())
    {
      ac.a[] arrayOfa = (ac.a[])this.e.keySet().toArray(new ac.a[this.e.size()]);
      int i2 = arrayOfa.length;
      int i1 = 0;
      while (i1 < i2)
      {
        arrayOfa[i1].a(paramConfiguration);
        i1 += 1;
      }
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    InputConnection localInputConnection = super.onCreateInputConnection(paramEditorInfo);
    if (localInputConnection == null) {
      return null;
    }
    this.a = new z.2(this, localInputConnection, false, localInputConnection);
    paramEditorInfo.imeOptions |= 0x10000000;
    if (getImeOptions() != 0) {
      paramEditorInfo.imeOptions &= 0xBFFFFFFF;
    }
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
    if (!paramBoolean) {
      clearComposingText();
    }
    if (paramBoolean) {
      e();
    }
    if (!this.f.isEmpty())
    {
      paramRect = (View.OnFocusChangeListener[])this.f.keySet().toArray(new View.OnFocusChangeListener[this.f.size()]);
      int i1 = paramRect.length;
      paramInt = 0;
      while (paramInt < i1)
      {
        paramRect[paramInt].onFocusChange(this, paramBoolean);
        paramInt += 1;
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      a('\b');
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    if ((bool) && (paramInt == 66)) {
      a('\n');
    }
    this.o = bool;
    return bool;
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (!this.o)
    {
      ac.b localb = this.p;
      if ((localb != null) && (localb.a(paramInt, paramKeyEvent))) {
        return true;
      }
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    o.f("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onLayout");
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    o.f("MicroMsg.AppBrand.WebEditText", "[scrollUp] input onMeasure");
    super.onMeasure(paramInt1, paramInt2);
    if (!this.g.isEmpty())
    {
      Object[] arrayOfObject = this.g.keySet().toArray();
      paramInt2 = arrayOfObject.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        ((ac.c)arrayOfObject[paramInt1]).a(getMeasuredWidth(), getMeasuredHeight());
        paramInt1 += 1;
      }
    }
  }
  
  public void p()
  {
    this.e.clear();
    this.g.clear();
    this.f.clear();
    this.h.a();
    com.tencent.luggage.wxa.pq.b localb = this.d;
    if (localb != null) {
      localb.a();
    }
    super.setOnFocusChangeListener(null);
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.h.b(paramTextWatcher);
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if ((130 == paramInt) && (paramRect == null) && ((getParent() instanceof ViewGroup)))
    {
      ((ViewGroup)getParent()).setDescendantFocusability(262144);
      ((ViewGroup)getParent()).setFocusableInTouchMode(false);
    }
    try
    {
      bool = super.requestFocus(paramInt, paramRect);
      return bool;
    }
    catch (RuntimeException localRuntimeException)
    {
      boolean bool;
      o.b("MicroMsg.AppBrand.WebEditText", "requestFocus e=%s", new Object[] { localRuntimeException });
      try
      {
        bool = super.requestFocus(paramInt, paramRect);
        return bool;
      }
      catch (RuntimeException paramRect)
      {
        o.b("MicroMsg.AppBrand.WebEditText", "requestFocus try again e=%s", new Object[] { paramRect });
      }
    }
    return false;
  }
  
  public void setFixed(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setInputId(int paramInt)
  {
    this.c = paramInt;
  }
  
  @CallSuper
  public void setInputType(int paramInt)
  {
    if (getInputType() == paramInt) {
      return;
    }
    super.setInputType(paramInt);
  }
  
  public void setMaxHeight(int paramInt)
  {
    if (getMaxHeight() == paramInt) {
      return;
    }
    super.setMaxHeight(paramInt);
  }
  
  public void setMinHeight(int paramInt)
  {
    if (getMinHeight() == paramInt) {
      return;
    }
    super.setMinHeight(paramInt);
  }
  
  public void setOnComposingDismissedListener(com.tencent.luggage.wxa.pt.b paramb)
  {
    this.j.a(paramb);
  }
  
  @Deprecated
  public void setOnFocusChangeListener(View.OnFocusChangeListener paramOnFocusChangeListener)
  {
    if (this.f == null)
    {
      super.setOnFocusChangeListener(paramOnFocusChangeListener);
      return;
    }
    a(paramOnFocusChangeListener);
  }
  
  public void setOnKeyUpPostImeListener(ac.b paramb)
  {
    this.p = paramb;
  }
  
  @CallSuper
  public void setPasswordMode(boolean paramBoolean)
  {
    l();
    this.b = paramBoolean;
    PasswordTransformationMethod localPasswordTransformationMethod;
    if (paramBoolean) {
      localPasswordTransformationMethod = this.i;
    } else {
      localPasswordTransformationMethod = null;
    }
    setTransformationMethod(localPasswordTransformationMethod);
    m();
  }
  
  public void setSelection(int paramInt)
  {
    if (getEditableText() == null) {
      return;
    }
    super.setSelection(Math.min(paramInt, getEditableText().length()));
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    int i1 = paramInt1;
    if (paramInt1 < 0) {
      i1 = 0;
    }
    paramInt1 = i1;
    if (i1 >= getEditableText().length()) {
      paramInt1 = getEditableText().length();
    }
    i1 = paramInt2;
    if (paramInt2 < paramInt1) {
      i1 = paramInt1;
    }
    paramInt2 = i1;
    if (i1 >= getEditableText().length()) {
      paramInt2 = getEditableText().length();
    }
    super.setSelection(paramInt1, paramInt2);
  }
  
  public void setSingleLine(boolean paramBoolean) {}
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    super.setText(paramCharSequence, paramBufferType);
  }
  
  public final void setTextCursorDrawable(@DrawableRes int paramInt)
  {
    try
    {
      new com.tencent.luggage.wxa.he.b(this, "mCursorDrawableRes", TextView.class.getName()).a(Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      o.e("MicroMsg.AppBrand.WebEditText", "setTextCursorDrawable, exp = %s", new Object[] { af.a(localException) });
    }
  }
  
  public final void setTextSize(float paramFloat)
  {
    setTextSize(0, paramFloat);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
  }
  
  public void setTypeface(Typeface paramTypeface)
  {
    super.setTypeface(paramTypeface);
  }
  
  public void setTypeface(Typeface paramTypeface, int paramInt)
  {
    super.setTypeface(paramTypeface, paramInt);
  }
  
  public String toString()
  {
    return String.format(Locale.US, "[%s|%s]", new Object[] { getClass().getSimpleName(), Integer.valueOf(getInputId()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.z
 * JD-Core Version:    0.7.0.1
 */