package com.tencent.av.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.av.SessionMgr;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.viewcontroller.OperationBtnItem;
import com.tencent.av.ui.viewcontroller.QavOperationMenuViewController;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.TagIndex;
import com.tencent.av.utils.TintStateDrawable;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

public class QavOperationMenuView
  extends QavMenuBaseView
  implements View.OnClickListener
{
  QavOperationMenuViewController a = null;
  ViewGroup b = null;
  BeautySeekView c = null;
  LinearLayout d = null;
  HScrollView e;
  long f = 0L;
  ImageView j = null;
  QavMenuActionListener k = null;
  private RedTouch[] l = new RedTouch[5];
  private boolean m = false;
  private long n = 0L;
  private final long o = 1000L;
  private Rect p = null;
  private Rect q = null;
  
  public QavOperationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QavOperationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private RedTouch a(View paramView, int paramInt1, int paramInt2)
  {
    RedTouch localRedTouch1;
    if ((paramView != null) && (paramView.getId() == paramInt1))
    {
      RedTouch localRedTouch2 = AVRedTouchUtil.a(this.h, paramView, paramInt2);
      localRedTouch1 = localRedTouch2;
      if (localRedTouch2 != null)
      {
        localRedTouch2.a(0, (int)UITools.b(getContext(), paramView.getPaddingRight()), (int)UITools.b(getContext(), paramView.getPaddingTop()), 0).a();
        return localRedTouch2;
      }
    }
    else
    {
      localRedTouch1 = null;
    }
    return localRedTouch1;
  }
  
  private void a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("QavOperationMenuView_");
    ((StringBuilder)localObject).append(AudioHelper.c());
    this.g = ((StringBuilder)localObject).toString();
    setGravity(80);
    LayoutInflater.from(getContext()).inflate(2131625790, this, true);
    setBackgroundResource(2130843186);
    this.b = ((ViewGroup)findViewById(2131429372));
    this.c = ((BeautySeekView)this.b.findViewById(2131429389));
    this.c.a(getContext().getString(2131893146), "BEAUTY_SKIN", 50, 0);
    this.c.setBeautySeekActionListener(new QavOperationMenuView.1(this));
    this.j = ((ImageView)findViewById(2131429387));
    if (this.j != null)
    {
      localObject = getResources().getDrawable(2130842918);
      TintStateDrawable localTintStateDrawable = TintStateDrawable.a(getResources(), 2130842918, 2131166696);
      localTintStateDrawable.setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      this.j.setImageDrawable(localTintStateDrawable);
      this.j.setBackgroundDrawable(null);
      this.j.setOnClickListener(this);
    }
    e();
    this.d = ((LinearLayout)findViewById(2131439670));
    this.e = ((HScrollView)findViewById(2131439671));
    c();
  }
  
  private void a(OperationBtnItem paramOperationBtnItem, View paramView)
  {
    paramView.setClickable(paramOperationBtnItem.f());
    int i;
    if (paramOperationBtnItem.h()) {
      i = 0;
    } else {
      i = 8;
    }
    paramView.setVisibility(i);
    if ((paramView instanceof TextView))
    {
      TextView localTextView = (TextView)paramView;
      int i1 = TagIndex.a(paramView, 2131444709);
      int i2 = TagIndex.a(paramView, 2131430986);
      String str = paramOperationBtnItem.e();
      paramView = TagIndex.b(paramView, 2131444732);
      if (!TextUtils.isEmpty(str))
      {
        localTextView.setTag(2131444709, Integer.valueOf(0));
        if (str != paramView)
        {
          localTextView.setTag(2131444732, str);
          paramView = a(localTextView, str);
          paramView.setBounds(0, 0, AIOUtils.b(28.0F, localTextView.getResources()), AIOUtils.b(28.0F, localTextView.getResources()));
          localTextView.setCompoundDrawables(null, paramView, null, null);
        }
      }
      else
      {
        localTextView.setTag(2131444732, null);
        if (paramOperationBtnItem.g()) {
          i = 2131166707;
        } else {
          i = 2131166706;
        }
        if ((paramOperationBtnItem.c() != i1) || (i != i2))
        {
          localTextView.setTag(2131444709, Integer.valueOf(paramOperationBtnItem.c()));
          localTextView.setTag(2131430986, Integer.valueOf(i));
          AudioHelper.a(getResources(), localTextView, paramOperationBtnItem.c(), i, i);
        }
      }
      if (!StringUtil.isEmpty(paramOperationBtnItem.d())) {
        localTextView.setText(paramOperationBtnItem.d());
      }
      if ((paramOperationBtnItem.b) || (paramOperationBtnItem.a == 0))
      {
        paramOperationBtnItem.a = ((int)Math.max(UITools.a(localTextView), AIOUtils.b(28.0F, getResources())));
        paramOperationBtnItem.b = false;
        if (QLog.isDevelopLevel())
        {
          paramView = new StringBuilder();
          paramView.append("updateView, width[");
          paramView.append(paramOperationBtnItem.a);
          paramView.append("], title[");
          paramView.append(paramOperationBtnItem.d());
          paramView.append("]");
          QLog.i("WTogether", 2, paramView.toString());
        }
      }
    }
  }
  
  private void a(ArrayList<OperationBtnItem> paramArrayList)
  {
    if (QLog.isDevelopLevel())
    {
      String str = this.g;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doRealReport, size:=[");
      localStringBuilder.append(paramArrayList.size());
      localStringBuilder.append("]");
      QLog.d(str, 4, localStringBuilder.toString());
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      int i = ((OperationBtnItem)paramArrayList.next()).b();
      AVUtil.a("0X800BC09", DataReport.b(SessionMgr.a().b()), i, "", "", "", "");
    }
  }
  
  private void a(ArrayList<OperationBtnItem> paramArrayList1, ArrayList<OperationBtnItem> paramArrayList2, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 < 0) {
        return;
      }
      int i = 0;
      while ((paramInt1 <= paramInt2) && (paramInt1 < paramArrayList2.size()) && (i < 6))
      {
        i += 1;
        paramArrayList1.add(paramArrayList2.get(paramInt1));
        paramInt1 += 1;
      }
    }
  }
  
  private ArrayList<OperationBtnItem> c(int paramInt)
  {
    int i = this.e.getChildAt(0).getMeasuredWidth();
    int i5 = UITools.a(getContext());
    ArrayList localArrayList1 = this.a.b();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramInt != 0) && (localArrayList1.size() > 5) && (i > i5))
    {
      i = 0;
      int i1 = 0;
      Object localObject;
      for (int i2 = 0; (i < localArrayList1.size()) && (i1 <= 5); i2 = i3)
      {
        localObject = (OperationBtnItem)localArrayList1.get(i);
        i4 = i1;
        i3 = i2;
        if (((OperationBtnItem)localObject).h())
        {
          if (i1 != 5) {
            i3 = ((OperationBtnItem)localObject).a;
          } else {
            i3 = ((OperationBtnItem)localObject).a / 2;
          }
          i3 = i2 + i3;
          i4 = i1 + 1;
        }
        i += 1;
        i1 = i4;
      }
      int i3 = (int)((i5 - i2) * 1.0F / 5.5F);
      i1 = 0;
      i = 0;
      while (i1 < localArrayList1.size())
      {
        i += ((OperationBtnItem)localArrayList1.get(i1)).a + i3;
        if (i > paramInt) {
          break label221;
        }
        i1 += 1;
      }
      i1 = 0;
      label221:
      int i4 = i5 - (i - paramInt);
      paramInt = i1 + 1;
      i2 = 0;
      i = 0;
      while ((i1 >= 0) && (paramInt < localArrayList1.size()))
      {
        i2 += ((OperationBtnItem)localArrayList1.get(paramInt)).a / 2 + i3;
        i = paramInt;
        if (i2 > i4) {
          break;
        }
        i = paramInt;
        paramInt += 1;
      }
      if (QLog.isDevelopLevel())
      {
        localObject = this.g;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doRealReport, startPos:=[");
        localStringBuilder.append(i1);
        localStringBuilder.append("], endPos:=");
        localStringBuilder.append(i);
        localStringBuilder.append(", expireLength:=");
        localStringBuilder.append(i4);
        QLog.d((String)localObject, 4, localStringBuilder.toString());
      }
      a(localArrayList2, localArrayList1, i1, i);
      return localArrayList2;
    }
    a(localArrayList2, localArrayList1, 0, 4);
    return localArrayList2;
  }
  
  private void c()
  {
    this.e.setOnScrollListener(new QavOperationMenuView.2(this));
  }
  
  private void d()
  {
    if (!this.e.isShown()) {
      return;
    }
    this.n = System.currentTimeMillis();
    a(c(Math.abs(this.e.getScrollX())));
  }
  
  private boolean d(int paramInt)
  {
    Object localObject2 = this.d;
    boolean bool2 = false;
    if (localObject2 == null) {
      return false;
    }
    int i = 0;
    boolean bool1;
    Object localObject1;
    for (;;)
    {
      bool1 = bool2;
      if (i >= ((LinearLayout)localObject2).getChildCount()) {
        break;
      }
      localObject1 = ((LinearLayout)localObject2).getChildAt(i);
      if ((localObject1 != null) && (((View)localObject1).getId() == paramInt) && (((View)localObject1).isShown()))
      {
        if (this.p == null) {
          this.p = new Rect();
        }
        if (this.q == null)
        {
          localObject2 = getResources().getDisplayMetrics();
          this.q = new Rect(0, 0, ((DisplayMetrics)localObject2).widthPixels, ((DisplayMetrics)localObject2).heightPixels);
        }
        ((View)localObject1).getGlobalVisibleRect(this.p);
        bool1 = this.p.intersect(this.q);
        break;
      }
      i += 1;
    }
    if (QLog.isDevelopLevel())
    {
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("checkOperationBtnIsVisible, ret[");
      ((StringBuilder)localObject2).append(bool1);
      ((StringBuilder)localObject2).append("], id[");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append("]");
      QLog.i((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    }
    return bool1;
  }
  
  private int e(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1;
    case 2131893088: 
      return 4;
    case 2131893080: 
      return 3;
    case 2131893077: 
      return 0;
    case 2131893074: 
      return 1;
    }
    return 2;
  }
  
  private void e()
  {
    if ((this.j != null) && (EffectsRenderController.c()) && (AEFilterSupport.a() > 3))
    {
      if (SessionMgr.a().b().r())
      {
        this.j.setVisibility(8);
        return;
      }
      this.j.setVisibility(0);
      return;
    }
    ImageView localImageView = this.j;
    if (localImageView != null) {
      localImageView.setVisibility(8);
    }
  }
  
  public Drawable a(TextView paramTextView, String paramString)
  {
    int i = AIOUtils.b(28.0F, paramTextView.getResources());
    paramTextView = URLDrawable.URLDrawableOptions.obtain();
    paramTextView.mRequestWidth = i;
    paramTextView.mRequestHeight = i;
    paramTextView.mFailedDrawable = null;
    paramTextView.mLoadingDrawable = null;
    paramTextView = URLDrawable.getDrawable(paramString, paramTextView);
    paramTextView.setTag(URLDrawableDecodeHandler.a(i, i));
    paramTextView.setDecodeHandler(URLDrawableDecodeHandler.b);
    if (paramTextView.getStatus() == 1) {
      return paramTextView;
    }
    paramTextView.draw(new Canvas());
    return paramTextView;
  }
  
  View a(int paramInt, OperationBtnItem paramOperationBtnItem)
  {
    Object localObject = this.d;
    if ((localObject != null) && (paramInt >= 0))
    {
      if (((LinearLayout)localObject).getChildCount() <= paramInt)
      {
        paramOperationBtnItem = b(paramOperationBtnItem);
        this.d.addView(paramOperationBtnItem, paramInt);
        return paramOperationBtnItem;
      }
      localObject = this.d.getChildAt(paramInt);
      OperationBtnItem localOperationBtnItem = (OperationBtnItem)((View)localObject).getTag(2131439677);
      if ((localOperationBtnItem != null) && (localOperationBtnItem.a() == paramOperationBtnItem.a())) {
        return localObject;
      }
      paramOperationBtnItem = b(paramOperationBtnItem);
      this.d.addView(paramOperationBtnItem, paramInt);
      return paramOperationBtnItem;
    }
    return null;
  }
  
  public View a(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem != null)
    {
      if (this.d == null) {
        return null;
      }
      int i = 0;
      while (i < this.d.getChildCount())
      {
        View localView = this.d.getChildAt(i);
        OperationBtnItem localOperationBtnItem = (OperationBtnItem)localView.getTag(2131439677);
        if ((localOperationBtnItem != null) && (localOperationBtnItem.a() == paramOperationBtnItem.a())) {
          return localView;
        }
        i += 1;
      }
    }
    return null;
  }
  
  void a(int paramInt)
  {
    BeautySeekView localBeautySeekView = this.c;
    if (localBeautySeekView != null) {
      localBeautySeekView.a(paramInt);
    }
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    super.a(paramLong, paramBoolean);
    if (paramBoolean)
    {
      a(this.h.n("BEAUTY_SKIN"));
      b();
      postDelayed(new QavOperationMenuView.3(this), 100L);
    }
  }
  
  public void a(QavPanel paramQavPanel)
  {
    super.a(paramQavPanel);
    if (this.h != null) {
      a(this.h.n("BEAUTY_SKIN"));
    }
  }
  
  public int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 2131893088: 
      return 10;
    case 2131893080: 
      return 9;
    case 2131893077: 
      return 2;
    case 2131893074: 
      return 6;
    }
    return 7;
  }
  
  View b(OperationBtnItem paramOperationBtnItem)
  {
    if (paramOperationBtnItem == null) {
      return null;
    }
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    Button localButton = new Button(getContext());
    localButton.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localButton.setSingleLine();
    AudioHelper.a(getResources(), localButton, paramOperationBtnItem.c(), 2131166706, 2131166706);
    if (!StringUtil.isEmpty(paramOperationBtnItem.d())) {
      localButton.setText(paramOperationBtnItem.d());
    }
    localButton.setBackgroundColor(0);
    localButton.setId(paramOperationBtnItem.a());
    localButton.setOnClickListener(this);
    localButton.setTag(2131439677, paramOperationBtnItem);
    localButton.setTextSize(ViewUtils.pxTosp(AIOUtils.b(12.0F, getResources())));
    localButton.setCompoundDrawablePadding(AIOUtils.b(8.0F, getResources()));
    float f1 = UITools.a(localButton);
    paramOperationBtnItem.a = ((int)Math.max(f1, AIOUtils.b(28.0F, getResources())));
    paramOperationBtnItem.b = false;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createOperationBtn, title[");
      ((StringBuilder)localObject).append(paramOperationBtnItem.d());
      ((StringBuilder)localObject).append("], titleTxtWidth[");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append("], width[");
      ((StringBuilder)localObject).append(paramOperationBtnItem.a);
      ((StringBuilder)localObject).append("]");
      QLog.i("WTogether", 4, ((StringBuilder)localObject).toString());
    }
    return localButton;
  }
  
  @SuppressLint({"ResourceType"})
  public void b()
  {
    super.b();
    Object localObject1;
    if (this.c != null)
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (((QavOperationMenuViewController)localObject1).c()))
      {
        this.b.setVisibility(0);
        this.c.a = true;
        e();
        localObject1 = this.j;
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0))
        {
          localObject1 = this.l;
          if (localObject1[2] == null) {
            localObject1[2] = AVRedTouchUtil.a(this.h, this.j, 7);
          }
        }
      }
      else
      {
        this.b.setVisibility(8);
      }
    }
    if (this.d != null)
    {
      localObject1 = this.a;
      if ((localObject1 != null) && (((QavOperationMenuViewController)localObject1).a().size() != 0))
      {
        localObject1 = this.a.a().iterator();
        int i = 0;
        int i1 = 0;
        Object localObject2;
        int i2;
        int i3;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (OperationBtnItem)((Iterator)localObject1).next();
          View localView = a(i, (OperationBtnItem)localObject2);
          if (localView == null) {
            break;
          }
          i2 = localView.getId();
          i3 = e(i2);
          if (i3 >= 0)
          {
            RedTouch[] arrayOfRedTouch = this.l;
            if (i3 < arrayOfRedTouch.length) {
              arrayOfRedTouch[i3] = a(localView, i2, b(i2));
            }
          }
          a((OperationBtnItem)localObject2, localView);
          i2 = i + 1;
          i = i2;
          if (((OperationBtnItem)localObject2).h())
          {
            i = i2;
            if (AudioHelper.a(0) == 1)
            {
              if (i1 % 2 == 0) {
                localView.setBackgroundColor(-536881408);
              } else {
                localView.setBackgroundColor(-539173668);
              }
              i1 += 1;
              i = i2;
            }
          }
        }
        i1 = this.d.getChildCount();
        if (i1 > i) {
          this.d.removeViews(i, i1 - i);
        }
        localObject1 = this.a;
        if (localObject1 != null)
        {
          localObject1 = ((QavOperationMenuViewController)localObject1).b();
          i = ((ArrayList)localObject1).size();
          int i6 = this.d.getChildCount();
          if (i <= 5) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          int i7 = ImmersiveUtils.getScreenWidth();
          if (i2 != 0) {
            i = i7 / i;
          } else {
            i = (int)(i7 * 1.0F / 5.5F);
          }
          int i5;
          int i4;
          if (i2 == 0)
          {
            i = 0;
            i1 = 0;
            for (i3 = 0; (i < ((ArrayList)localObject1).size()) && (i1 <= 5); i3 = i4)
            {
              localObject2 = (OperationBtnItem)((ArrayList)localObject1).get(i);
              i5 = i1;
              i4 = i3;
              if (((OperationBtnItem)localObject2).h())
              {
                if (i1 != 5) {
                  i4 = ((OperationBtnItem)localObject2).a;
                } else {
                  i4 = ((OperationBtnItem)localObject2).a / 2;
                }
                i4 = i3 + i4;
                i5 = i1 + 1;
              }
              i += 1;
              i1 = i5;
            }
            if (i7 > i3) {
              i = (int)((i7 - i3) * 1.0F / 5.5F);
            } else {
              i = 0;
            }
          }
          else
          {
            ReportController.b(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
          }
          if ((i & 0x1) != 0) {
            i += 1;
          }
          i3 = 0;
          for (i1 = 0; (i3 < i6) && (i1 < ((ArrayList)localObject1).size()); i1 = i4)
          {
            localObject2 = this.d.getChildAt(i3);
            if ((localObject2 != null) && (((View)localObject2).getVisibility() == 0)) {
              i5 = 1;
            } else {
              i5 = 0;
            }
            i4 = i1;
            if (i5 != 0)
            {
              if (i2 != 0)
              {
                i4 = i;
              }
              else
              {
                i4 = i1 + 1;
                i5 = ((OperationBtnItem)((ArrayList)localObject1).get(i1)).a + i;
                i1 = i4;
                i4 = i5;
              }
              ((View)localObject2).setLayoutParams(new LinearLayout.LayoutParams(i4, -2));
              i4 = i1;
            }
            i3 += 1;
          }
        }
        this.d.requestLayout();
        return;
      }
      this.d.removeAllViewsInLayout();
    }
  }
  
  public void b(long paramLong, boolean paramBoolean)
  {
    super.b(paramLong, paramBoolean);
    if (paramBoolean)
    {
      this.m = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(this.g, 2, "onHide");
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    long l1 = SystemClock.elapsedRealtime();
    if (((i & 0xFF) != 2) || (Math.abs(l1 - this.f) > 200L))
    {
      this.f = l1;
      BaseToolbar.keepInToolbar(this.h, -1029L);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  @SuppressLint({"ResourceType"})
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    Object localObject;
    if (i1 == 2131429387)
    {
      localObject = this.k;
      if (localObject != null) {
        ((QavMenuActionListener)localObject).a(this, 3);
      }
      AVUtil.a("0X800A566", 0);
    }
    else
    {
      localObject = this.k;
      if (localObject != null) {
        ((QavMenuActionListener)localObject).a(this, paramView);
      }
    }
    int i = e(i1);
    i1 = b(i1);
    if (i >= 0)
    {
      localObject = this.l;
      if (i < localObject.length)
      {
        if (localObject[i] != null) {
          AVRedTouchUtil.a(this.h, this.l[i], i1);
        }
        this.l[i] = null;
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setQavMenuActionListener(QavMenuActionListener paramQavMenuActionListener)
  {
    this.k = paramQavMenuActionListener;
  }
  
  public void setViewController(QavOperationMenuViewController paramQavOperationMenuViewController)
  {
    this.a = paramQavOperationMenuViewController;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.QavOperationMenuView
 * JD-Core Version:    0.7.0.1
 */