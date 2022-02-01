package com.tencent.mm.ui.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.FontMetrics;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView.BufferType;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.widget.menu.MMPopupMenu;
import java.util.ArrayList;
import java.util.Iterator;

public class SelectableTextHelper
{
  public static final String TAG = "SelectableTextHelper";
  private boolean A = true;
  private boolean B = false;
  private boolean C = true;
  private boolean D = true;
  private boolean E = true;
  private boolean F = false;
  private boolean G = false;
  private int[] H = new int[2];
  private final Runnable I = new SelectableTextHelper.1(this);
  private final Runnable J = new SelectableTextHelper.2(this);
  private int[] K = new int[2];
  private SelectableTextHelper.OnTouchOutsideListener L;
  private ArrayList<SelectableTextHelper.ImageSpanInfo> M;
  private SelectableTextHelper.CursorHandle a;
  private SelectableTextHelper.CursorHandle b;
  private SelectableTextHelper.SelectionInfo c = new SelectableTextHelper.SelectionInfo(this);
  private SelectableTextHelper.OnSelectListener d;
  private Context e;
  private View f;
  private SelectableTextHelper.OuterMenuAction g;
  private View.OnClickListener h;
  private View.OnTouchListener i;
  private Spannable j;
  private MMPopupMenu k;
  private int l = 0;
  private int m;
  private int n;
  private int o;
  private int p;
  private int q;
  private b r;
  private int s;
  private int t;
  private View.OnAttachStateChangeListener u;
  private ViewTreeObserver.OnScrollChangedListener v;
  private ViewTreeObserver.OnPreDrawListener w;
  private ViewTreeObserver.OnGlobalLayoutListener x;
  private View.OnTouchListener y;
  private boolean z = false;
  
  public SelectableTextHelper(SelectableTextHelper.Builder paramBuilder)
  {
    this.f = SelectableTextHelper.Builder.a(paramBuilder);
    this.g = SelectableTextHelper.Builder.b(paramBuilder);
    this.h = SelectableTextHelper.Builder.c(paramBuilder);
    this.i = SelectableTextHelper.Builder.d(paramBuilder);
    this.k = SelectableTextHelper.Builder.e(paramBuilder);
    this.l = SelectableTextHelper.Builder.f(paramBuilder);
    this.e = this.f.getContext();
    this.o = SelectableTextHelper.Builder.g(paramBuilder);
    this.p = SelectableTextHelper.Builder.h(paramBuilder);
    this.s = TextLayoutUtil.getLineHeight(this.f);
    if (this.q == 0) {
      this.q = ((int)TextLayoutUtil.getTextSize(this.f));
    } else {
      this.q = g.a(this.e, SelectableTextHelper.Builder.i(paramBuilder));
    }
    this.u = new SelectableTextHelper.3(this);
    this.w = new SelectableTextHelper.4(this);
    this.v = new SelectableTextHelper.5(this);
    this.x = new SelectableTextHelper.6(this);
    this.y = new SelectableTextHelper.7(this);
    init();
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    Object localObject = this.M;
    int i1 = paramInt;
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      SelectableTextHelper.ImageSpanInfo localImageSpanInfo;
      do
      {
        i1 = paramInt;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localImageSpanInfo = (SelectableTextHelper.ImageSpanInfo)((Iterator)localObject).next();
      } while (!localImageSpanInfo.a(paramInt));
      if (paramBoolean) {
        return localImageSpanInfo.a;
      }
      i1 = localImageSpanInfo.b;
    }
    return i1;
  }
  
  private SelectableTextHelper.CursorHandle a(boolean paramBoolean)
  {
    if (SelectableTextHelper.CursorHandle.a(this.a) == paramBoolean) {
      return this.a;
    }
    return this.b;
  }
  
  private void a(int paramInt)
  {
    this.f.removeCallbacks(this.I);
    if (paramInt <= 0)
    {
      this.I.run();
      return;
    }
    this.f.postDelayed(this.I, paramInt);
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    paramInt1 = TextLayoutUtil.getOffsetForPosition(this.f, paramInt1, paramInt2);
    b(paramInt1, paramInt1 + 1);
  }
  
  private void a(SpannableString paramSpannableString)
  {
    this.M = new ArrayList();
    int i2;
    for (int i1 = 0; i1 < paramSpannableString.length(); i1 = i2)
    {
      i2 = paramSpannableString.nextSpanTransition(i1, paramSpannableString.length(), ImageSpan.class);
      Object localObject = (ImageSpan[])paramSpannableString.getSpans(i1, i2, ImageSpan.class);
      if (1 == localObject.length)
      {
        localObject = new SelectableTextHelper.ImageSpanInfo(this);
        ((SelectableTextHelper.ImageSpanInfo)localObject).a = i1;
        ((SelectableTextHelper.ImageSpanInfo)localObject).b = i2;
        this.M.add(localObject);
      }
      else
      {
        f.e("SelectableTextHelper", "other situation occur! length: %d.", new Object[] { Integer.valueOf(localObject.length) });
      }
      f.b("SelectableTextHelper", "spans from %d to %d.", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2) });
    }
    f.b("SelectableTextHelper", this.M.toString(), new Object[0]);
  }
  
  private void a(SelectableTextHelper.CursorHandle paramCursorHandle)
  {
    if (paramCursorHandle == null) {
      return;
    }
    int i1;
    if (SelectableTextHelper.CursorHandle.a(paramCursorHandle)) {
      i1 = this.c.a;
    } else {
      i1 = this.c.b;
    }
    if (i1 >= 0)
    {
      if (i1 > TextLayoutUtil.getText(this.f).length()) {
        return;
      }
      Object localObject = TextLayoutUtil.getPaint(this.f);
      int i2 = 0;
      if (localObject != null)
      {
        i2 = (int)((TextPaint)localObject).getFontMetrics().descent;
        localObject = this.f;
        i2 = TextLayoutUtil.getLineBaseline((View)localObject, TextLayoutUtil.getLineForOffset((View)localObject, i1)) + i2;
        i1 = (int)TextLayoutUtil.getPrimaryHorizontal(this.f, i1);
      }
      else
      {
        i1 = 0;
      }
      paramCursorHandle.show(i1, i2);
    }
  }
  
  private boolean a()
  {
    AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.e.getSystemService("accessibility");
    return (localAccessibilityManager.isEnabled()) && (localAccessibilityManager.isTouchExplorationEnabled());
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    resetSelectionInfo();
    if ((TextLayoutUtil.getText(this.f) instanceof Spannable)) {
      this.j = ((Spannable)TextLayoutUtil.getText(this.f));
    }
    if ((this.j != null) && (paramInt1 < TextLayoutUtil.getText(this.f).length()))
    {
      selectText(paramInt1, paramInt2);
      return;
    }
    SelectableTextHelper.SelectionInfo localSelectionInfo = this.c;
    localSelectionInfo.a = 0;
    localSelectionInfo.b = 0;
  }
  
  public boolean cursorIsHide()
  {
    return this.D;
  }
  
  public void destroy()
  {
    this.z = false;
    this.A = true;
    this.B = false;
    this.f.removeCallbacks(this.I);
    this.f.getViewTreeObserver().removeOnScrollChangedListener(this.v);
    this.f.getViewTreeObserver().removeOnPreDrawListener(this.w);
    this.f.getViewTreeObserver().removeOnGlobalLayoutListener(this.x);
    this.f.removeOnAttachStateChangeListener(this.u);
    setMenuHide(true);
    setCursorHide(true);
    hideSelectView();
    resetSelectionInfo();
    this.a = null;
    this.b = null;
    SelectableTextHelper.OuterMenuAction localOuterMenuAction = this.g;
    if (localOuterMenuAction != null) {
      localOuterMenuAction.dismiss();
    }
  }
  
  public SelectableTextHelper.OuterMenuAction getOuterMenuAction()
  {
    return this.g;
  }
  
  public void hideCursorHandle()
  {
    SelectableTextHelper.CursorHandle localCursorHandle = this.a;
    if (localCursorHandle != null) {
      localCursorHandle.dismiss();
    }
    localCursorHandle = this.b;
    if (localCursorHandle != null) {
      localCursorHandle.dismiss();
    }
  }
  
  public void hideOperateMenu()
  {
    MMPopupMenu localMMPopupMenu = this.k;
    if (localMMPopupMenu != null) {
      localMMPopupMenu.dismiss();
    }
  }
  
  public void hideOuterMenu()
  {
    SelectableTextHelper.OuterMenuAction localOuterMenuAction = this.g;
    if (localOuterMenuAction != null) {
      localOuterMenuAction.dismiss();
    }
  }
  
  public void hideSelectView()
  {
    hideCursorHandle();
    hideOperateMenu();
    SelectableTextHelper.OuterMenuAction localOuterMenuAction = this.g;
    if (localOuterMenuAction != null) {
      localOuterMenuAction.dismiss();
    }
  }
  
  public void init()
  {
    if (!this.A)
    {
      f.b("SelectableTextHelper", "not destroy, isReInit: %s.", new Object[] { Boolean.valueOf(this.z) });
      this.z = true;
      return;
    }
    f.b("SelectableTextHelper", "not init yet, need to init.", new Object[0]);
    this.z = false;
    this.A = false;
    this.B = false;
    if (this.g == null)
    {
      View localView = this.f;
      TextLayoutUtil.setText(localView, TextLayoutUtil.getText(localView), TextView.BufferType.SPANNABLE);
    }
    this.a = new SelectableTextHelper.CursorHandle(this, true);
    if (this.g != null)
    {
      this.a.setOutsideTouchable(true);
      this.a.setTouchInterceptor(new SelectableTextHelper.8(this));
      this.a.setOnDismissListener(new SelectableTextHelper.9(this));
    }
    this.b = new SelectableTextHelper.CursorHandle(this, false);
    this.f.setOnLongClickListener(new SelectableTextHelper.10(this));
    this.f.setOnTouchListener(this.y);
    this.f.setOnClickListener(new SelectableTextHelper.11(this));
    this.f.addOnAttachStateChangeListener(this.u);
    this.f.getViewTreeObserver().addOnPreDrawListener(this.w);
    this.f.getViewTreeObserver().addOnScrollChangedListener(this.v);
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(this.x);
    this.f.getViewTreeObserver().addOnGlobalLayoutListener(new SelectableTextHelper.12(this));
  }
  
  public boolean menuIsHide()
  {
    return this.C;
  }
  
  public void resetSelectionInfo()
  {
    this.c.c = null;
    Spannable localSpannable = this.j;
    if (localSpannable != null)
    {
      b localb = this.r;
      if (localb != null)
      {
        localSpannable.removeSpan(localb);
        this.r = null;
      }
    }
  }
  
  public void selectText(int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {
      this.c.a = a(paramInt1, true);
    }
    if (paramInt2 != -1) {
      this.c.b = a(paramInt2, false);
    }
    if (this.c.a >= 0)
    {
      if (this.c.a > TextLayoutUtil.getText(this.f).length()) {
        return;
      }
      if (this.c.b >= 0)
      {
        if (this.c.b > TextLayoutUtil.getText(this.f).length()) {
          return;
        }
        if (this.c.a > this.c.b)
        {
          paramInt1 = this.c.a;
          localObject = this.c;
          ((SelectableTextHelper.SelectionInfo)localObject).a = ((SelectableTextHelper.SelectionInfo)localObject).b;
          this.c.b = paramInt1;
        }
        Object localObject = this.j;
        if (localObject != null)
        {
          SelectableTextHelper.SelectionInfo localSelectionInfo = this.c;
          localSelectionInfo.c = ((Spannable)localObject).subSequence(localSelectionInfo.a, this.c.b).toString();
          localObject = this.r;
          if (localObject != null) {
            ((b)localObject).a(this.c.a, this.c.b);
          } else {
            this.r = new b(this.f, this.e.getResources().getColor(this.o), this.c.a, this.c.b);
          }
          paramInt1 = TextLayoutUtil.getLineForOffset(this.f, this.c.a);
          paramInt1 = TextLayoutUtil.getLineStart(this.f, paramInt1);
          this.j.setSpan(this.r, paramInt1, this.c.b, 17);
          localObject = this.d;
          if (localObject != null) {
            ((SelectableTextHelper.OnSelectListener)localObject).onTextSelected(this.c.c);
          }
        }
      }
    }
  }
  
  public void setAutoSelectEnd(int paramInt)
  {
    this.t = paramInt;
  }
  
  public void setCursorHide(boolean paramBoolean)
  {
    this.D = paramBoolean;
  }
  
  public void setMenuHide(boolean paramBoolean)
  {
    this.C = paramBoolean;
  }
  
  public void setOnTouchOutsideListener(SelectableTextHelper.OnTouchOutsideListener paramOnTouchOutsideListener)
  {
    this.L = paramOnTouchOutsideListener;
  }
  
  public void setSelectListener(SelectableTextHelper.OnSelectListener paramOnSelectListener)
  {
    this.d = paramOnSelectListener;
  }
  
  public void showCursorHandle()
  {
    if (!a())
    {
      a(this.a);
      a(this.b);
    }
  }
  
  public void showOperateMenu()
  {
    if (this.k != null)
    {
      localObject = new int[2];
      this.f.getLocationInWindow((int[])localObject);
      float f3 = TextLayoutUtil.getPrimaryHorizontal(this.f, this.c.a);
      float f2 = TextLayoutUtil.getPrimaryHorizontal(this.f, this.c.b);
      int i1 = TextLayoutUtil.getLineForOffset(this.f, this.c.a);
      float f1;
      if (TextLayoutUtil.getLineForOffset(this.f, this.c.b) <= i1)
      {
        f1 = f2;
        if (f2 > f3) {}
      }
      else
      {
        localView = this.f;
        f1 = TextLayoutUtil.getLineWidth(localView, TextLayoutUtil.getLineForOffset(localView, this.c.a));
      }
      int i2 = (int)((f3 + f1) / 2.0F) + this.l;
      View localView = this.f;
      int i3 = TextLayoutUtil.getLineTop(localView, TextLayoutUtil.getLineForOffset(localView, this.c.a)) + localObject[1] + this.e.getResources().getDimensionPixelSize(2131297338);
      f.b("SelectableTextHelper", "dancy test posX:%s, startline:%s, endline:%s, leftpadding:%s", new Object[] { Integer.valueOf(i2), Integer.valueOf(TextLayoutUtil.getLineForOffset(this.f, this.c.a)), Integer.valueOf(TextLayoutUtil.getLineForOffset(this.f, this.c.b)), Integer.valueOf(this.l) });
      i1 = i2;
      if (i2 <= 0) {
        i1 = 16;
      }
      i2 = i3;
      if (i3 < 0) {
        i2 = 16;
      }
      i3 = i1;
      if (i1 > TextLayoutUtil.getScreenWidth(this.e)) {
        i3 = TextLayoutUtil.getScreenWidth(this.e) - 16;
      }
      this.k.show(i3, i2);
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((SelectableTextHelper.OuterMenuAction)localObject).onInnerMenuShow();
    }
  }
  
  public void showOuterMenu()
  {
    SelectableTextHelper.OuterMenuAction localOuterMenuAction = this.g;
    if (localOuterMenuAction != null) {
      localOuterMenuAction.open(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper
 * JD-Core Version:    0.7.0.1
 */