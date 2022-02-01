package com.tencent.biz.qqcircle.richframework.widget.actionsheet;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.util.AccessibilityUtil;
import com.tencent.biz.qqcircle.richframework.widget.VerticalCenterImageSpan;
import com.tencent.biz.qqcircle.utils.ImmersiveUtils;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import cooperation.qqcircle.helpers.QCircleSkinHelper.OnThemeUpdateListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ActionSheet
  extends ReportDialog
  implements QCircleSkinHelper.OnThemeUpdateListener
{
  private ActionSheet.OnDismissListener A = null;
  private int B = -1;
  private boolean C = false;
  private SparseArray<View> D;
  private int E = 300;
  private boolean F;
  private HashSet<Integer> G;
  private boolean H = true;
  private View.OnClickListener I;
  private View.OnClickListener J;
  private boolean K;
  private boolean L = true;
  private boolean M = false;
  private ActionSheet.OnPreShowListener N = null;
  private ActionSheet.WatchDismissActions O = null;
  private View.OnClickListener P = new ActionSheet.9(this);
  private Map<Integer, ActionSheet.OnTextImageFetchedListener> Q = new HashMap();
  private Map<Integer, URLDrawable> R = new HashMap();
  private boolean S = false;
  protected Resources a;
  public LinearLayout b;
  public boolean c;
  protected boolean d = false;
  public View.OnClickListener e = new ActionSheet.10(this);
  private Context f;
  private LayoutInflater g;
  private Handler h;
  private ViewGroup i;
  private RelativeLayout j;
  private CharSequence k;
  private CharSequence l;
  private ArrayList<Pair<CharSequence, Integer>> m;
  private List<Integer> n = new ArrayList();
  private HashMap<CharSequence, ActionMenuItem> o = new HashMap();
  private CharSequence p;
  private int q;
  private int r = 0;
  private TextView s;
  private HashMap<Integer, Drawable> t = new HashMap();
  private HashMap<Integer, Drawable> u = new HashMap();
  private HashMap<Integer, Integer> v = new HashMap();
  private HashMap<Integer, String> w = new HashMap();
  private SparseArray<Integer> x = new SparseArray();
  private ActionSheet.OnButtonClickListener y = null;
  private ActionSheet.OnButtonClickListenerV2 z = null;
  
  protected ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true, -1, null);
  }
  
  @TargetApi(14)
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramContext, 2131952168);
    Window localWindow = getWindow();
    if (Build.VERSION.SDK_INT >= 14) {
      localWindow.setDimAmount(0.5F);
    }
    this.f = paramContext;
    this.F = paramBoolean1;
    this.g = LayoutInflater.from(paramContext);
    this.a = paramContext.getResources();
    this.h = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.d() == 1)) {
      localWindow.addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      localWindow.setFlags(1024, 1024);
    }
    ImmersiveUtils.a(localWindow, true);
    if (Build.VERSION.SDK_INT >= 21) {
      localWindow.setNavigationBarColor(QCircleSkinHelper.getInstance().getColor(2131167059));
    }
    paramContext = this.g;
    if (paramInt == -1) {
      paramInt = 2131626760;
    }
    this.i = ((ViewGroup)paramContext.inflate(paramInt, null));
    if (paramLayoutParams != null) {
      super.setContentView(this.i, paramLayoutParams);
    } else {
      super.setContentView(this.i);
    }
    this.j = ((RelativeLayout)this.i.findViewById(2131427544));
    this.b = ((LinearLayout)this.i.findViewById(2131427552));
    this.i.getChildAt(0).setOnClickListener(this.e);
    this.j.setOnClickListener(null);
    this.I = this.e;
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131951622);
    }
    return paramContext;
  }
  
  private CharSequence a(CharSequence paramCharSequence, Drawable paramDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("icon");
    localStringBuilder.append(paramCharSequence);
    paramCharSequence = new SpannableStringBuilder(localStringBuilder.toString());
    paramDrawable.setBounds(0, 0, ViewUtils.a(20.0F), ViewUtils.a(20.0F));
    paramDrawable = new VerticalCenterImageSpan(paramDrawable, 0);
    paramDrawable.a(ViewUtils.a(6.5F), ViewUtils.a(6.5F));
    paramCharSequence.setSpan(paramDrawable, 0, 4, 18);
    return paramCharSequence;
  }
  
  private void a(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if (paramPair != null)
    {
      if (paramTextView == null) {
        return;
      }
      if (((Integer)paramPair.second).intValue() == 11) {
        paramTextView.setTextSize(12.0F);
      }
    }
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getContext().getString(2131888076));
      localStringBuilder.append(paramTextView.getText());
      paramTextView.setContentDescription(localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getContext().getString(2131888078));
    localStringBuilder.append(paramTextView.getText());
    paramTextView.setContentDescription(localStringBuilder.toString());
  }
  
  private void a(URLDrawable paramURLDrawable, Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if ((paramURLDrawable != null) && (paramPair != null))
    {
      if (paramTextView == null) {
        return;
      }
      paramURLDrawable.setURLDrawableListener(new ActionSheet.3(this, paramTextView, paramPair));
      paramURLDrawable.setDownloadListener(new ActionSheet.4(this));
      RFThreadManager.execute(new ActionSheet.5(this, paramURLDrawable), RFThreadManager.Normal);
    }
  }
  
  private void a(CharSequence paramCharSequence, ActionSheet.OnTextImageFetchedListener paramOnTextImageFetchedListener)
  {
    if (paramCharSequence != null)
    {
      if (paramOnTextImageFetchedListener == null) {
        return;
      }
      int i1 = paramCharSequence.hashCode();
      this.Q.put(Integer.valueOf(i1), paramOnTextImageFetchedListener);
    }
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131951622);
    }
    return paramContext;
  }
  
  private void b(Pair<CharSequence, Integer> paramPair, TextView paramTextView)
  {
    if (paramPair != null)
    {
      if (paramTextView == null) {
        return;
      }
      if ((((Integer)paramPair.second).intValue() == 10) && (paramPair.first != null))
      {
        a((CharSequence)paramPair.first, new ActionSheet.2(this, paramTextView));
        if (this.R.containsKey(Integer.valueOf(((CharSequence)paramPair.first).hashCode())))
        {
          URLDrawable localURLDrawable = (URLDrawable)this.R.get(Integer.valueOf(((CharSequence)paramPair.first).hashCode()));
          if (localURLDrawable != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("prepareContentViews ");
            localStringBuilder.append(localURLDrawable);
            QLog.i("ActionSheet", 1, localStringBuilder.toString());
            if (localURLDrawable.getStatus() == 1)
            {
              paramTextView.setText(a((CharSequence)paramPair.first, localURLDrawable));
              return;
            }
            a(localURLDrawable, paramPair, paramTextView);
          }
        }
      }
    }
  }
  
  private void i()
  {
    if (this.c) {
      return;
    }
    Object localObject2;
    int i1;
    if (this.k != null)
    {
      localObject1 = this.g.inflate(d(), null);
      ((View)localObject1).setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845294));
      ((View)localObject1).setOnClickListener(new ActionSheet.1(this));
      this.s = ((TextView)((View)localObject1).findViewById(2131427564));
      this.s.setVisibility(0);
      this.s.setMaxLines(2147483647);
      this.s.setText(this.k);
      this.s.setContentDescription(this.k);
      this.s.setTextColor(Color.parseColor("#777777"));
      if (this.l != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131427561);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.l);
        ((TextView)localObject2).setContentDescription(this.l);
      }
      this.b.addView((View)localObject1, 0);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (this.K) {
      i1 = 1;
    }
    Object localObject1 = this.m;
    Object localObject3;
    if (localObject1 != null)
    {
      int i2 = i1 + ((ArrayList)localObject1).size();
      int i3 = this.m.size();
      if ((i3 != this.n.size()) && (this.n.size() != 0)) {
        throw new IllegalArgumentException("buttons size and custom ids size not match");
      }
      i1 = 0;
      while (i1 < i3)
      {
        Pair localPair = (Pair)this.m.get(i1);
        if (((Integer)localPair.second).intValue() == 65537)
        {
          localObject2 = this.g.inflate(e(), null);
          localObject3 = (TextView)((View)localObject2).findViewById(2131427549);
          localObject1 = (TextView)((View)localObject2).findViewById(2131446620);
          localObject4 = ((CharSequence)localPair.first).toString();
          int i4 = ((String)localObject4).indexOf('\n');
          if ((i4 >= 0) && (i4 < ((CharSequence)localPair.first).length()))
          {
            ((TextView)localObject3).setText(((String)localObject4).substring(0, i4));
            ((TextView)localObject1).setText(((String)localObject4).substring(i4 + 1));
            ((View)localObject2).findViewById(2131430148).setContentDescription(((TextView)localObject3).getText());
          }
          else
          {
            ((TextView)localObject3).setText((CharSequence)localPair.first);
          }
          localObject4 = (Integer)this.x.get(i1);
          if (localObject4 != null) {
            ((TextView)localObject1).setTextColor(((Integer)localObject4).intValue());
          }
          AccessibilityUtil.a(((View)localObject2).findViewById(2131430148), LinearLayout.class.getName());
        }
        else
        {
          localObject1 = this.g.inflate(2131626762, null);
          localObject4 = (TextView)((View)localObject1).findViewById(2131427549);
          ((TextView)localObject4).setText((CharSequence)localPair.first);
          AccessibilityUtil.a((View)localObject4, Button.class.getName());
          if (((Integer)localPair.second).intValue() == 11)
          {
            a(localPair, (TextView)localObject4);
            localObject2 = localObject1;
            localObject3 = localObject4;
          }
          else
          {
            localObject2 = localObject1;
            localObject3 = localObject4;
            if (((Integer)localPair.second).intValue() == 10)
            {
              b(localPair, (TextView)localObject4);
              localObject3 = localObject4;
              localObject2 = localObject1;
            }
          }
        }
        localObject1 = this.o;
        if ((localObject1 != null) && (((HashMap)localObject1).size() > 0))
        {
          localObject1 = (ActionMenuItem)this.o.get(localPair.first);
          if ((localObject1 != null) && (((ActionMenuItem)localObject1).b != 0)) {
            ((TextView)localObject3).setId(((ActionMenuItem)localObject1).b);
          }
        }
        localObject1 = (ImageView)((View)localObject2).findViewById(2131427562);
        Object localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject4).rightMargin = ViewUtils.a(15.0F);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        if (this.t.containsKey(Integer.valueOf(i1)))
        {
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageDrawable((Drawable)this.t.get(Integer.valueOf(i1)));
        }
        else
        {
          ((ImageView)localObject1).setImageDrawable(null);
          ((ImageView)localObject1).setVisibility(8);
        }
        localObject1 = (ImageView)((View)localObject2).findViewById(2131427563);
        localObject4 = (RelativeLayout.LayoutParams)((ImageView)localObject1).getLayoutParams();
        if ((this.v.containsKey(Integer.valueOf(i1))) && (((Integer)this.v.get(Integer.valueOf(i1))).intValue() == 0))
        {
          ((RelativeLayout.LayoutParams)localObject4).width = ViewUtils.a(28.0F);
          ((RelativeLayout.LayoutParams)localObject4).height = ViewUtils.a(28.0F);
          ((RelativeLayout.LayoutParams)localObject4).addRule(15);
        }
        ((RelativeLayout.LayoutParams)localObject4).rightMargin = ViewUtils.a(5.0F);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        if (this.u.containsKey(Integer.valueOf(i1)))
        {
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageDrawable((Drawable)this.u.get(Integer.valueOf(i1)));
        }
        else
        {
          ((ImageView)localObject1).setImageDrawable(null);
          ((ImageView)localObject1).setVisibility(8);
        }
        if (((Integer)localPair.second).intValue() == 9)
        {
          if (this.w.containsKey(Integer.valueOf(i1))) {
            ((TextView)localObject3).setTextColor(Color.parseColor((String)this.w.get(Integer.valueOf(i1))));
          }
        }
        else {
          ((TextView)localObject3).setTextColor(g(((Integer)localPair.second).intValue()));
        }
        if ((this.d) && (i2 > 1) && (i1 == i3 - 1) && (this.p == null)) {
          localObject1 = f(4);
        } else if ((i1 == 0) && (i2 == i3) && (i2 == 1)) {
          localObject1 = f(0);
        } else if ((i1 == 0) && (i2 == i3) && (i2 > 1))
        {
          if (this.M) {
            localObject1 = f(1);
          } else {
            localObject1 = f(3);
          }
        }
        else if ((i1 == i3 - 1) && (i2 > 1)) {
          localObject1 = f(0);
        } else {
          localObject1 = f(3);
        }
        ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
        if (i1 < this.n.size()) {
          ((View)localObject2).setId(((Integer)this.n.get(i1)).intValue());
        } else {
          ((View)localObject2).setId(i1);
        }
        ((View)localObject2).setOnClickListener(this.P);
        this.b.addView((View)localObject2);
        if (this.C)
        {
          if (this.D == null) {
            this.D = new SparseArray();
          }
          this.D.append(i1, localObject2);
          if (i1 == this.B)
          {
            ((View)localObject2).findViewById(2131427550).setVisibility(0);
            a((TextView)localObject3, true);
          }
          else
          {
            a((TextView)localObject3, false);
          }
        }
        i1 += 1;
      }
    }
    if (this.p != null)
    {
      localObject1 = this.g.inflate(f(), null);
      if (this.q != 0)
      {
        localObject2 = (Button)((View)localObject1).findViewById(2131427547);
        ((Button)localObject2).setVisibility(0);
        ((Button)localObject2).setText(this.q);
        ((Button)localObject2).setTextColor(this.r);
        ((Button)localObject2).setContentDescription(this.p);
        localObject3 = this.J;
        if (localObject3 != null) {
          ((Button)localObject2).setOnClickListener((View.OnClickListener)localObject3);
        }
      }
      localObject2 = (Button)((View)localObject1).findViewById(2131427548);
      ((Button)localObject2).setOnClickListener(this.I);
      ((Button)localObject2).setText(this.p);
      ((Button)localObject2).setContentDescription(this.p);
      this.b.addView((View)localObject1);
    }
    this.c = true;
  }
  
  private void j()
  {
    Object localObject = this.j;
    ((RelativeLayout)localObject).setTranslationY(((RelativeLayout)localObject).getHeight());
    this.i.setVisibility(0);
    localObject = this.N;
    if (localObject != null) {
      ((ActionSheet.OnPreShowListener)localObject).a();
    }
    this.j.animate().setDuration(this.E).translationY(0.0F).start();
  }
  
  private void k()
  {
    this.j.animate().setDuration(this.E).translationY(this.j.getHeight()).setListener(new ActionSheet.8(this)).start();
  }
  
  public void a()
  {
    this.c = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.j.invalidate();
  }
  
  public void a(int paramInt)
  {
    a(this.a.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.a.getText(paramInt1), paramInt2);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.I = paramOnClickListener;
  }
  
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.j.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.j.addView(paramView, localLayoutParams);
    }
  }
  
  public void a(ActionMenuItem paramActionMenuItem, int paramInt)
  {
    if (paramActionMenuItem == null) {
      return;
    }
    this.o.put(paramActionMenuItem.c, paramActionMenuItem);
    a(paramActionMenuItem.c, paramInt);
  }
  
  public void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.y = paramOnButtonClickListener;
  }
  
  public void a(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.A = paramOnDismissListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.k = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.m == null) {
        this.m = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.m.contains(paramCharSequence)) {
        this.m.add(paramCharSequence);
      }
      if (!this.C) {
        return;
      }
      throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
    }
  }
  
  public void b()
  {
    this.c = false;
    this.b.removeAllViews();
    i();
  }
  
  public void b(int paramInt)
  {
    a(this.a.getText(paramInt), 0);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public ActionMenuItem c(int paramInt)
  {
    return c(d(paramInt));
  }
  
  public ActionMenuItem c(CharSequence paramCharSequence)
  {
    HashMap localHashMap = this.o;
    if (localHashMap == null) {
      return null;
    }
    return (ActionMenuItem)localHashMap.get(paramCharSequence);
  }
  
  public void c()
  {
    this.c = false;
    this.m.clear();
    this.o.clear();
    this.t.clear();
    this.u.clear();
    this.v.clear();
    this.w.clear();
    this.j.removeAllViews();
  }
  
  protected int d()
  {
    return 2131626763;
  }
  
  public String d(int paramInt)
  {
    Object localObject = this.m;
    if ((localObject != null) && (paramInt < ((ArrayList)localObject).size()))
    {
      localObject = (Pair)this.m.get(paramInt);
      if (localObject != null) {
        return ((CharSequence)((Pair)localObject).first).toString();
      }
    }
    return null;
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.p = paramCharSequence;
    }
  }
  
  public void dismiss()
  {
    ActionSheet.WatchDismissActions localWatchDismissActions = this.O;
    if (localWatchDismissActions != null) {
      localWatchDismissActions.a();
    }
    if (this.L)
    {
      this.L = false;
      this.h.postDelayed(new ActionSheet.7(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.S) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  protected int e()
  {
    return 2131626764;
  }
  
  public void e(int paramInt)
  {
    d(this.a.getText(paramInt));
  }
  
  protected int f()
  {
    return 2131626761;
  }
  
  public Drawable f(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return QCircleSkinHelper.getInstance().getDrawable(2130845293);
          }
          return QCircleSkinHelper.getInstance().getDrawable(2130845296);
        }
        return QCircleSkinHelper.getInstance().getDrawable(2130845293);
      }
      return QCircleSkinHelper.getInstance().getDrawable(2130845299);
    }
    return QCircleSkinHelper.getInstance().getDrawable(2130845290);
  }
  
  protected int g(int paramInt)
  {
    paramInt &= 0xFFFF;
    if (paramInt != 3)
    {
      if (paramInt != 8)
      {
        if (paramInt != 11) {
          return QCircleSkinHelper.getInstance().getColor(2131167084);
        }
        return QCircleSkinHelper.getInstance().getColor(2131165412);
      }
      return QCircleSkinHelper.getInstance().getColor(2131165409);
    }
    return QCircleSkinHelper.getInstance().getColor(2131165410);
  }
  
  public ViewGroup g()
  {
    return this.i;
  }
  
  /* Error */
  public void h()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 815	android/app/Dialog:dismiss	()V
    //   4: return
    //   5: astore_1
    //   6: aload_1
    //   7: athrow
    //   8: astore_1
    //   9: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	10	0	this	ActionSheet
    //   5	2	1	localObject	Object
    //   8	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   0	4	5	finally
    //   0	4	8	java/lang/Exception
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    QCircleSkinHelper.getInstance().registerOnThemeUpdateListener(this);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    QCircleSkinHelper.getInstance().unregisterOnThemeUpdateListener(this);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.F) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void onThemeUpdate()
  {
    b();
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    this.i.setVisibility(4);
    super.show();
    i();
    this.h.postDelayed(new ActionSheet.6(this), 200L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.actionsheet.ActionSheet
 * JD-Core Version:    0.7.0.1
 */