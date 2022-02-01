package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.PollLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Locale;

public class PollWidgetUtils$WidgetWrapper
  implements View.OnAttachStateChangeListener, View.OnClickListener, View.OnLayoutChangeListener, PollWidgetUtils.IPollWidget
{
  private boolean A = false;
  private Handler B = new Handler(Looper.getMainLooper());
  PollWidgetUtils.QuestionElement a;
  PollWidgetUtils.OptionElement b;
  PollWidgetUtils.OptionElement c;
  public ViewGroup d;
  public int[] e = null;
  public float f;
  public float g;
  public float h;
  public float i;
  public float j;
  public int k;
  public int l;
  public float m;
  public float n;
  public float o;
  public boolean p = false;
  PollWidgetUtils.OnSelectedChangedListener q = new PollWidgetUtils.WidgetWrapper.1(this);
  public PollWidgetUtils.OnPollDetailClickListener r;
  public List<QQUserUIItem> s;
  public int t;
  private ViewGroup v;
  private int w;
  private int x;
  private boolean y = false;
  private boolean z = false;
  
  public PollWidgetUtils$WidgetWrapper(Context paramContext)
  {
    this.d = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131627204, null, false));
    this.d.addOnLayoutChangeListener(this);
    this.d.addOnAttachStateChangeListener(this);
    this.a = new PollWidgetUtils.QuestionElement(this, this.d.findViewById(2131447114));
    this.b = new PollWidgetUtils.SingleOptionElement(this, this.d.findViewById(2131436962), 0);
    this.b.a(this.q);
    this.c = new PollWidgetUtils.SingleOptionElement(this, this.d.findViewById(2131436963), 1);
    this.c.a(this.q);
  }
  
  private void h()
  {
    Object localObject = this.v;
    if (localObject == null)
    {
      SLog.b("WidgetWrapper", "mAttendWidget is null, no action, return");
      return;
    }
    float f2 = this.m;
    float f1 = this.f;
    float f5 = f2 * f1 + this.g;
    float f6 = this.n * f1 + this.h;
    int i1 = ((ViewGroup)localObject).getHeight();
    int i2 = this.v.getWidth();
    f1 = this.w * 1.0F / 2.0F;
    float f7 = i1 * 1.0F / 2.0F;
    localObject = PollWidgetUtils.a(0.0F, f1 + f7 + UIUtils.a(this.v.getContext(), 10.0F), this.o);
    float f4 = localObject[0];
    float f3 = localObject[1];
    if ((this.i * f4 + f5 >= 0.0F) && ((this.v.getParent() == null) || (this.j * f3 + f6 <= ((ViewGroup)this.v.getParent()).getHeight())) && ((this.v.getParent() == null) || (this.i * f4 + f5 <= ((ViewGroup)this.v.getParent()).getWidth())))
    {
      f2 = f3;
      f1 = f4;
      if (this.j * f3 + f6 >= 0.0F) {}
    }
    else
    {
      f1 = -f4;
      f2 = -f3;
    }
    this.v.setX(f5 + this.i * f1 - i2 * 1.0F / 2.0F);
    this.v.setY(f6 + this.j * f2 - f7);
    this.v.setRotation(this.o);
    this.v.setScaleX(this.i);
    this.v.setScaleY(this.j);
    if (i2 != 0) {
      b(this.p);
    } else {
      this.v.setVisibility(4);
    }
    SLog.a("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.v.hashCode()));
    SLog.b("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", new Object[] { Integer.valueOf(this.x), Integer.valueOf(this.w), Integer.valueOf(i2), Integer.valueOf(i1), Boolean.valueOf(this.p), FeedUtils.a(5) });
    SLog.a("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.g), Float.valueOf(this.h), Float.valueOf(f1), Float.valueOf(f2));
  }
  
  public View a()
  {
    return this.d;
  }
  
  public PollWidgetUtils.OptionElement a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new PollWidgetUtils.NullOptionElement(this, this.c.j, paramInt);
      }
      return this.c;
    }
    return this.b;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    SLog.c("WidgetWrapper", "setPositionInfo %.2f, %.2f, %.2f, %d, %d, %.2f, %.2f, r:%.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
    this.y = true;
    this.x = e();
    this.w = f();
    this.f = paramFloat1;
    this.g = paramFloat2;
    this.h = paramFloat3;
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramFloat4;
    this.n = paramFloat5;
    this.o = paramFloat6;
  }
  
  public void a(StoryVideoItem.PollLayout paramPollLayout, float paramFloat1, float paramFloat2)
  {
    float f1 = paramPollLayout.c;
    float f2 = paramPollLayout.d;
    this.g = 0.0F;
    this.h = 0.0F;
    float f3 = f2 * 1.0F / f1;
    float f4 = paramFloat2 * 1.0F;
    if (f3 > f4 / paramFloat1)
    {
      this.f = (paramFloat1 * 1.0F / f1);
      this.h = (-(f2 * this.f - paramFloat2) / 2.0F);
    }
    else
    {
      this.f = (f4 / f2);
      this.g = (-(f1 * this.f - paramFloat1) / 2.0F);
    }
    a(this.f, this.g, this.h, paramPollLayout.e, paramPollLayout.f, paramPollLayout.g, paramPollLayout.h, paramPollLayout.i);
  }
  
  public void a(List<QQUserUIItem> paramList, int paramInt)
  {
    this.s = paramList;
    this.t = paramInt;
    if (this.v == null)
    {
      SLog.b("WidgetWrapper", "setPollUsers mAttendWidget == null stack=%s", FeedUtils.a(4));
      return;
    }
    if (this.s == null)
    {
      SLog.e("WidgetWrapper", "setPollUsers mPollUsers == null stack=%s", new Object[] { FeedUtils.a(4) });
      return;
    }
    SLog.a("WidgetWrapper", "setPollUsers mAttendWidget usercount: %d", Integer.valueOf(paramList.size()));
    Object localObject1 = new StringBuilder();
    int i1 = 0;
    Object localObject2;
    while (i1 < paramList.size())
    {
      localObject2 = (QQUserUIItem)paramList.get(i1);
      if (localObject2 != null)
      {
        ((StringBuilder)localObject1).append(((QQUserUIItem)localObject2).getName());
        ((StringBuilder)localObject1).append(", ");
      }
      i1 += 1;
    }
    SLog.a("WidgetWrapper", "pollUsers: %s", ((StringBuilder)localObject1).toString());
    localObject1 = (ViewGroup)this.v.findViewById(2131437018);
    if (localObject1 != null)
    {
      int i3 = ((ViewGroup)localObject1).getChildCount() - 1;
      i1 = paramList.size();
      int i2 = Math.min(i3, i1);
      int i4 = Math.max(i1, paramInt);
      paramInt = 0;
      for (;;)
      {
        i1 = i2;
        if (paramInt >= i2) {
          break;
        }
        localObject2 = ((ViewGroup)localObject1).getChildAt(paramInt);
        if ((localObject2 instanceof ImageView))
        {
          Object localObject3 = (QQUserUIItem)paramList.get(paramInt);
          if (localObject3 != null)
          {
            if ((!TextUtils.isEmpty(((QQUserUIItem)localObject3).qq)) && (!TextUtils.equals(((QQUserUIItem)localObject3).qq, "0")))
            {
              Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130848247);
              localObject3 = FaceDrawable.getFaceDrawable(QQStoryContext.k(), 1, String.valueOf(((QQUserUIItem)localObject3).qq), 3, localDrawable, localDrawable);
              ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
            }
            else
            {
              UIUtils.a((ImageView)localObject2, ((QQUserUIItem)localObject3).headUrl, 80, 80, 1);
            }
            ((View)localObject2).setVisibility(0);
          }
        }
        paramInt += 1;
      }
      while (i1 < i3)
      {
        paramList = ((ViewGroup)localObject1).getChildAt(i1);
        if ((paramList instanceof ImageView)) {
          paramList.setVisibility(4);
        }
        i1 += 1;
      }
      if (i4 <= i3) {
        paramList = String.format(Locale.getDefault(), "%d人参与 >", new Object[] { Integer.valueOf(i4) });
      } else {
        paramList = String.format(Locale.getDefault(), HardCodeUtil.a(2131906111), new Object[] { Integer.valueOf(i4) });
      }
      ((TextView)this.v.findViewById(2131447236)).setText(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = d();
    int i2 = arrayOfWidgetElement.length;
    int i1 = 0;
    while (i1 < i2)
    {
      arrayOfWidgetElement[i1].c(paramBoolean);
      i1 += 1;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int i4 = 0;
    int i3 = 0;
    if (paramArrayOfInt == null)
    {
      SLog.e("WidgetWrapper", "Error: setOptionNumbers get null numbers!! stack = %s", new Object[] { FeedUtils.a(5) });
      return;
    }
    int i2 = 0;
    int i1 = 0;
    while (i2 < paramArrayOfInt.length)
    {
      i1 += paramArrayOfInt[i2];
      i2 += 1;
    }
    i2 = i4;
    if (i1 <= 0)
    {
      i1 = i3;
      while (i1 < paramArrayOfInt.length)
      {
        a(i1).a(0.0F);
        i1 += 1;
      }
    }
    while (i2 < paramArrayOfInt.length)
    {
      a(i2).a(paramArrayOfInt[i2] * 100.0F / i1);
      i2 += 1;
    }
  }
  
  public PollWidgetUtils.QuestionElement b()
  {
    return this.a;
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.v;
    if (localViewGroup != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 4;
      }
      localViewGroup.setVisibility(i1);
    }
    this.p = paramBoolean;
  }
  
  public void c()
  {
    if (!this.y) {
      return;
    }
    this.x = e();
    this.w = f();
    float f1 = this.f;
    float f2 = this.k;
    int i1 = this.x;
    this.i = (f2 * f1 / i1);
    f2 = this.l;
    int i2 = this.w;
    this.j = (f2 * f1 / i2);
    if (i1 != 0)
    {
      if (i2 == 0) {
        return;
      }
      f2 = this.m * f1 + this.g;
      f1 = this.n * f1 + this.h;
      a().setX(f2 - this.x * 1.0F / 2.0F);
      a().setY(f1 - this.w * 1.0F / 2.0F);
      a().setRotation(this.o);
      a().setScaleX(this.i);
      a().setScaleY(this.j);
      SLog.b("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { b().a(), Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(this.o), Float.valueOf(this.i), Float.valueOf(this.j), Integer.valueOf(this.x), Integer.valueOf(this.w) });
      SLog.a("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.g), Float.valueOf(this.h));
      h();
    }
  }
  
  public PollWidgetUtils.WidgetElement[] d()
  {
    return new PollWidgetUtils.WidgetElement[] { this.a, this.b, this.c };
  }
  
  public int e()
  {
    return a().getWidth();
  }
  
  public int f()
  {
    return a().getHeight();
  }
  
  public boolean g()
  {
    return this.z;
  }
  
  public void onClick(View paramView)
  {
    PollWidgetUtils.OnPollDetailClickListener localOnPollDetailClickListener = this.r;
    if (localOnPollDetailClickListener != null) {
      localOnPollDetailClickListener.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView == this.v)
    {
      SLog.b("WidgetWrapper", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      h();
      return;
    }
    SLog.b("WidgetWrapper", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    c();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView = paramView.getParent();
    if ((!u) && ((paramView == null) || (!(paramView instanceof ViewGroup)))) {
      throw new AssertionError();
    }
    paramView = (ViewGroup)paramView;
    if (paramView.getId() == 2131440494)
    {
      this.v = ((ViewGroup)((ViewGroup)LayoutInflater.from(this.d.getContext()).inflate(2131627203, paramView)).findViewById(2131431795));
      ((TextView)this.v.findViewById(2131447125)).setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(this.v.hashCode()) }));
      this.v.setOnClickListener(this);
      this.v.addOnLayoutChangeListener(this);
      a(this.s, this.t);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper
 * JD-Core Version:    0.7.0.1
 */