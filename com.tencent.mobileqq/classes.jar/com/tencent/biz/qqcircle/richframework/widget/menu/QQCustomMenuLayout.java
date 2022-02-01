package com.tencent.biz.qqcircle.richframework.widget.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.MenuContainerStyle;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.MenuItemStyle;
import com.tencent.biz.qqcircle.richframework.widget.menu.style.QQDefaultMenuContainerStyle;
import com.tencent.biz.qqcircle.utils.RFThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class QQCustomMenuLayout
  extends LinearLayout
{
  private BubblePopupWindow a;
  private QQCustomMenuList b;
  private View.OnClickListener c;
  private Context d;
  private int e = 0;
  private int f;
  private int g;
  private int h = QQCustomMenuItemPriorityHelper.a;
  private QQCustomMenuLayout.DefaultMenuLine i;
  private QQCustomMenuLayout.DefaultMenuLine j;
  private int k;
  private boolean l = false;
  private Integer m = null;
  private MenuContainerStyle n;
  private BubblePopupWindow.QQMenuNoIconEmptyInterface o = new QQCustomMenuLayout.1(this);
  
  public QQCustomMenuLayout(Context paramContext)
  {
    super(paramContext);
    this.d = paramContext;
    setOrientation(1);
    this.n = new QQDefaultMenuContainerStyle();
    setMenuContainerStyle(this.n);
  }
  
  private StateListDrawable a(float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    localGradientDrawable1.setShape(0);
    localGradientDrawable1.setColor(this.n.a(this.d));
    localGradientDrawable1.setCornerRadii(paramArrayOfFloat);
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    localGradientDrawable2.setShape(0);
    localGradientDrawable2.setColor(this.n.b(this.d));
    localGradientDrawable2.setCornerRadii(paramArrayOfFloat);
    paramArrayOfFloat = new StateListDrawable();
    paramArrayOfFloat.setExitFadeDuration(400);
    paramArrayOfFloat.addState(new int[] { 16842919 }, localGradientDrawable2);
    paramArrayOfFloat.addState(new int[0], localGradientDrawable1);
    return paramArrayOfFloat;
  }
  
  private View a(QQCustomMenuItem paramQQCustomMenuItem, float[] paramArrayOfFloat)
  {
    StateListDrawable localStateListDrawable = a(paramArrayOfFloat);
    Object localObject = paramQQCustomMenuItem.a();
    paramArrayOfFloat = (float[])localObject;
    if (this.l)
    {
      paramArrayOfFloat = (float[])localObject;
      if (((String)localObject).length() > 4)
      {
        paramArrayOfFloat = new StringBuilder();
        paramArrayOfFloat.append(((String)localObject).substring(0, 3));
        paramArrayOfFloat.append("…");
        paramArrayOfFloat = paramArrayOfFloat.toString();
      }
    }
    localObject = new TextView(getContext());
    ((TextView)localObject).setText(paramArrayOfFloat);
    ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject).setTextSize(paramQQCustomMenuItem.c().a());
    ((TextView)localObject).setMaxLines(1);
    ((TextView)localObject).setContentDescription(paramQQCustomMenuItem.a());
    ((TextView)localObject).setTextColor(paramQQCustomMenuItem.c().a(this.d));
    ((TextView)localObject).setIncludeFontPadding(true);
    ((TextView)localObject).setCompoundDrawables(paramQQCustomMenuItem.c, null, null, null);
    ((TextView)localObject).setGravity(17);
    paramArrayOfFloat = a((View)localObject);
    paramArrayOfFloat.setBackgroundDrawable(localStateListDrawable);
    paramArrayOfFloat.setId(paramQQCustomMenuItem.b());
    return paramArrayOfFloat;
  }
  
  private TextView a(int paramInt, boolean paramBoolean, float[] paramArrayOfFloat)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    Resources localResources = this.d.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 2131166456;
    } else {
      i1 = 2131166458;
    }
    localGradientDrawable.setColor(localResources.getColor(i1));
    localGradientDrawable.setCornerRadii(paramArrayOfFloat);
    paramArrayOfFloat = new TextView(getContext());
    paramArrayOfFloat.setText("");
    paramArrayOfFloat.setTextSize(1.0F);
    paramArrayOfFloat.setWidth(paramInt);
    paramArrayOfFloat.setMaxLines(1);
    paramArrayOfFloat.setPadding(0, 0, 0, 0);
    paramArrayOfFloat.setTextColor(-1);
    paramArrayOfFloat.setBackgroundDrawable(localGradientDrawable);
    paramArrayOfFloat.setGravity(17);
    return paramArrayOfFloat;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    int i4 = getWidth();
    removeAllViews();
    boolean bool2 = RFThemeUtil.a();
    int i5 = this.b.a() - paramInt;
    boolean bool1 = true;
    int i1;
    if (paramInt == 0) {
      i1 = this.h;
    } else {
      i1 = this.h - 1;
    }
    int i2;
    if (paramInt == 0) {
      i2 = this.h * 2;
    } else {
      i2 = this.h * 2 - 1;
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[menu] showMenu offset: ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" count: ");
      ((StringBuilder)localObject1).append(i5);
      QLog.d("QQCustomMenuNoIconLayout", 2, ((StringBuilder)localObject1).toString());
    }
    int i3 = 0;
    Object localObject2;
    while (i3 < i5)
    {
      localObject2 = this.b.a(i3 + paramInt);
      if (i3 == 0)
      {
        if ((paramInt == 0) && (i5 == 1)) {
          localObject1 = getFullRadii();
        } else if (i5 <= i1) {
          localObject1 = getLeftRadii();
        } else {
          localObject1 = getTopLeftRadii();
        }
        localObject1 = a((QQCustomMenuItem)localObject2, (float[])localObject1);
      }
      else if (((paramInt == 0) && (i3 == i1 - 1)) || ((paramInt == 0) && (i5 < i1) && (i3 == i5 - 1)))
      {
        if (i5 <= i1) {
          localObject1 = getRightRadii();
        } else {
          localObject1 = getTopRightRadii();
        }
        localObject1 = a((QQCustomMenuItem)localObject2, (float[])localObject1);
      }
      else if (i3 == i1)
      {
        localObject1 = a((QQCustomMenuItem)localObject2, getBottomLeftRadii());
      }
      else if (i3 == i2 - 1)
      {
        localObject1 = a((QQCustomMenuItem)localObject2, getBottomRightRadii());
      }
      else
      {
        localObject1 = a((QQCustomMenuItem)localObject2, getNonRadii());
      }
      if (i3 < i1)
      {
        if (this.i == null) {
          this.i = new QQCustomMenuLayout.DefaultMenuLine(this, this.d);
        }
        this.i.addView((View)localObject1, new LinearLayout.LayoutParams(this.f, -1));
        if (i3 < i1 - 1)
        {
          if (i3 != i5 - 1) {
            QQCustomMenuLayout.DefaultMenuLine.a(this.i);
          }
        }
        else if (paramInt > 0)
        {
          QQCustomMenuLayout.DefaultMenuLine.a(this.i);
          localObject2 = this.i;
          if (i5 <= i1) {
            localObject1 = getRightRadii();
          } else {
            localObject1 = getTopRightRadii();
          }
          ((QQCustomMenuLayout.DefaultMenuLine)localObject2).addView(a(false, (float[])localObject1), new LinearLayout.LayoutParams(this.f, -1));
        }
      }
      else
      {
        if (i3 >= i2) {
          break label553;
        }
        if (this.j == null) {
          this.j = new QQCustomMenuLayout.DefaultMenuLine(this, this.d);
        }
        this.j.addView((View)localObject1, new LinearLayout.LayoutParams(this.f, -1));
        if (i3 < i2 - 1) {
          QQCustomMenuLayout.DefaultMenuLine.a(this.j);
        }
      }
      i3 += 1;
      continue;
      label553:
      localObject1 = this.j;
      if (localObject1 != null)
      {
        ((QQCustomMenuLayout.DefaultMenuLine)localObject1).removeViewAt(((QQCustomMenuLayout.DefaultMenuLine)localObject1).getChildCount() - 1);
        this.j.addView(a(true, getBottomRightRadii()), new LinearLayout.LayoutParams(this.f, -1));
      }
    }
    if ((i5 > i1) && (i5 < i2) && (this.j != null))
    {
      i3 = i2 - i5;
      i2 = 0;
      while (i2 < i3)
      {
        int i6 = i3 - 1;
        if (i2 == i6) {
          localObject1 = a(this.f, bool2, getBottomRightRadii());
        } else {
          localObject1 = a(this.f, bool2, getNonRadii());
        }
        localObject2 = new LinearLayout.LayoutParams(this.f, -1);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        this.j.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        if (i2 < i6) {
          QQCustomMenuLayout.DefaultMenuLine.a(this.j);
        }
        i2 += 1;
      }
    }
    if ((paramInt > 0) && (i5 < i1))
    {
      QQCustomMenuLayout.DefaultMenuLine.a(this.i);
      this.i.addView(a(false, getRightRadii()), new LinearLayout.LayoutParams(this.f, -1));
    }
    addView(this.i, new LinearLayout.LayoutParams(-2, this.g));
    if (this.j != null)
    {
      a(bool2);
      addView(this.j, new LinearLayout.LayoutParams(-2, this.g));
    }
    if (paramBoolean)
    {
      paramInt = this.f;
      i2 = Math.min(i5 + 1, this.h);
      localObject1 = this.a;
      if (i5 >= i1) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      ((BubblePopupWindow)localObject1).a((paramInt + 1) * i2 - 1, paramBoolean, i4);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    View localView = new View(this.d);
    Resources localResources = this.d.getResources();
    int i1;
    if (paramBoolean) {
      i1 = 2131166461;
    } else {
      i1 = 2131166463;
    }
    localView.setBackgroundColor(localResources.getColor(i1));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
    localView = new View(this.d);
    localResources = this.d.getResources();
    if (paramBoolean) {
      i1 = 2131166460;
    } else {
      i1 = 2131166462;
    }
    localView.setBackgroundColor(localResources.getColor(i1));
    addView(localView, new LinearLayout.LayoutParams(-1, 1));
  }
  
  private float[] getBottomLeftRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 };
  }
  
  private float[] getBottomRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, i1, i1, 0.0F, 0.0F };
  }
  
  private float[] getFullRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, i1, i1, i1, i1, i1, i1 };
  }
  
  private float[] getLeftRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, i1, i1 };
  }
  
  private float[] getNonRadii()
  {
    return new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] getRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, i1, i1, i1, i1, 0.0F, 0.0F };
  }
  
  private float[] getTopLeftRadii()
  {
    int i1 = this.k;
    return new float[] { i1, i1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  private float[] getTopRightRadii()
  {
    int i1 = this.k;
    return new float[] { 0.0F, 0.0F, i1, i1, 0.0F, 0.0F, 0.0F, 0.0F };
  }
  
  int a(int paramInt)
  {
    int i1 = 0;
    if (paramInt > 0)
    {
      i1 = this.h;
      i1 = i1 * 2 - 1 + 0 + (paramInt - 1) * (i1 * 2 - 2);
    }
    return i1;
  }
  
  protected View a(View paramView)
  {
    FrameLayout localFrameLayout = new FrameLayout(getContext());
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localFrameLayout.addView(paramView, localLayoutParams);
    localFrameLayout.setOnClickListener(new QQCustomMenuLayout.2(this));
    return localFrameLayout;
  }
  
  protected ImageView a(boolean paramBoolean, float[] paramArrayOfFloat)
  {
    paramArrayOfFloat = a(paramArrayOfFloat);
    ImageView localImageView = new ImageView(getContext());
    int i1;
    if (paramBoolean) {
      i1 = 2130851600;
    } else {
      i1 = 2130851601;
    }
    localImageView.setImageResource(i1);
    localImageView.setContentDescription(getResources().getString(2131915718));
    localImageView.setBackgroundDrawable(paramArrayOfFloat);
    localImageView.setScaleType(ImageView.ScaleType.CENTER);
    localImageView.setOnClickListener(new QQCustomMenuLayout.3(this, paramBoolean));
    return localImageView;
  }
  
  public void a()
  {
    a(0, false);
  }
  
  public Integer getContainerBottom()
  {
    return this.m;
  }
  
  public void removeAllViews()
  {
    super.removeAllViews();
    this.i = null;
    this.j = null;
  }
  
  public void setContainerBottom(Integer paramInteger)
  {
    this.m = paramInteger;
  }
  
  public void setIgnoreTouchLocation(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void setMenuContainerStyle(MenuContainerStyle paramMenuContainerStyle)
  {
    this.n = paramMenuContainerStyle;
    this.k = paramMenuContainerStyle.a();
    this.f = paramMenuContainerStyle.b();
    this.g = paramMenuContainerStyle.c();
  }
  
  public void setMenuIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.c = paramOnClickListener;
  }
  
  public void setMenuList(QQCustomMenuList paramQQCustomMenuList)
  {
    this.b = paramQQCustomMenuList.b();
    if (QLog.isColorLevel())
    {
      paramQQCustomMenuList = new StringBuilder();
      paramQQCustomMenuList.append("[menu] setMenu MENU:");
      paramQQCustomMenuList.append(this.b.toString());
      QLog.d("QQCustomMenuNoIconLayout", 4, paramQQCustomMenuList.toString());
    }
  }
  
  public void setPopupWindow(BubblePopupWindow paramBubblePopupWindow)
  {
    this.a = paramBubblePopupWindow;
    this.a.a(this.o);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.menu.QQCustomMenuLayout
 * JD-Core Version:    0.7.0.1
 */