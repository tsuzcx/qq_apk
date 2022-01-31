package com.tencent.biz.qqstory.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
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
import com.tencent.mobileqq.util.FaceDrawable;
import java.util.List;
import java.util.Locale;
import otb;
import otc;
import otd;

public class PollWidgetUtils$WidgetWrapper
  implements View.OnAttachStateChangeListener, View.OnClickListener, View.OnLayoutChangeListener, PollWidgetUtils.IPollWidget
{
  public float a;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public ViewGroup a;
  public PollWidgetUtils.OnPollDetailClickListener a;
  PollWidgetUtils.OnSelectedChangedListener jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener = new otb(this);
  PollWidgetUtils.OptionElement jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  public PollWidgetUtils.QuestionElement a;
  public List a;
  public boolean a;
  public float b;
  public int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  PollWidgetUtils.OptionElement jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  public float c;
  public int c;
  private boolean c;
  public float d;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  public float e;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean;
  public float f;
  public float g;
  public float h;
  
  static
  {
    if (!PollWidgetUtils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_b_of_type_Boolean = bool;
      return;
    }
  }
  
  public PollWidgetUtils$WidgetWrapper(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2130970142, null, false));
    try
    {
      this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362750).setBackgroundResource(2130841997);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
      this.jdField_a_of_type_AndroidViewViewGroup.addOnAttachStateChangeListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement = new PollWidgetUtils.QuestionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369140));
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement = new PollWidgetUtils.SingleOptionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369142), 0);
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener);
      this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement = new PollWidgetUtils.SingleOptionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369141), 1);
      this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener);
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      for (;;)
      {
        SLog.c("WidgetWrapper", "load drawable qim_qqstory_poll_guide_animation_ex oom", paramContext);
      }
    }
  }
  
  private void b()
  {
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      SLog.b("WidgetWrapper", "mAttendWidget is null, no action, return");
      return;
    }
    float f4 = this.f * this.jdField_a_of_type_Float + this.jdField_b_of_type_Float;
    float f5 = this.g * this.jdField_a_of_type_Float + this.jdField_c_of_type_Float;
    int i = this.jdField_b_of_type_AndroidViewViewGroup.getHeight();
    int j = this.jdField_b_of_type_AndroidViewViewGroup.getWidth();
    float[] arrayOfFloat = PollWidgetUtils.a(0.0F, this.jdField_d_of_type_Int * 1.0F / 2.0F + i * 1.0F / 2.0F + UIUtils.a(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 10.0F), this.h);
    float f2 = arrayOfFloat[0];
    float f1 = arrayOfFloat[1];
    float f3;
    if ((this.jdField_d_of_type_Float * f2 + f4 < 0.0F) || ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null) && (f5 + this.jdField_e_of_type_Float * f1 > ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getHeight())) || ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() != null) && (f4 + this.jdField_d_of_type_Float * f2 > ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getWidth())) || (this.jdField_e_of_type_Float * f1 + f5 < 0.0F))
    {
      f2 = -f2;
      f3 = -f1;
      f1 = f2;
      f2 = f1;
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidViewViewGroup.setX(this.jdField_d_of_type_Float * f2 + f4 - j * 1.0F / 2.0F);
      this.jdField_b_of_type_AndroidViewViewGroup.setY(this.jdField_e_of_type_Float * f3 + f5 - i * 1.0F / 2.0F);
      this.jdField_b_of_type_AndroidViewViewGroup.setRotation(this.h);
      this.jdField_b_of_type_AndroidViewViewGroup.setScaleX(this.jdField_d_of_type_Float);
      this.jdField_b_of_type_AndroidViewViewGroup.setScaleY(this.jdField_e_of_type_Float);
      if (j != 0) {
        b(this.jdField_a_of_type_Boolean);
      }
      for (;;)
      {
        SLog.a("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()));
        SLog.b("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(this.jdField_a_of_type_Boolean), FeedUtils.a(5) });
        SLog.a("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(f2), Float.valueOf(f3));
        return;
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
      }
      f3 = f1;
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public Bitmap a()
  {
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidViewViewGroup.getWidth(), this.jdField_a_of_type_AndroidViewViewGroup.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    this.jdField_a_of_type_AndroidViewViewGroup.draw(localCanvas);
    return localBitmap;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public PollWidgetUtils.OptionElement a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return new PollWidgetUtils.NullOptionElement(this, this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a, paramInt);
    case 0: 
      return this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
    }
    return this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  }
  
  public PollWidgetUtils.QuestionElement a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement;
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_e_of_type_Int = b();
      this.jdField_d_of_type_Int = c();
      this.jdField_d_of_type_Float = (this.jdField_a_of_type_Float * this.jdField_a_of_type_Int / this.jdField_e_of_type_Int);
      this.jdField_e_of_type_Float = (this.jdField_a_of_type_Float * this.jdField_b_of_type_Int / this.jdField_d_of_type_Int);
    } while ((this.jdField_e_of_type_Int == 0) || (this.jdField_d_of_type_Int == 0));
    float f1 = this.f * this.jdField_a_of_type_Float + this.jdField_b_of_type_Float;
    float f2 = this.g * this.jdField_a_of_type_Float + this.jdField_c_of_type_Float;
    a().setX(f1 - this.jdField_e_of_type_Int * 1.0F / 2.0F);
    a().setY(f2 - this.jdField_d_of_type_Int * 1.0F / 2.0F);
    a().setRotation(this.h);
    a().setScaleX(this.jdField_d_of_type_Float);
    a().setScaleY(this.jdField_e_of_type_Float);
    SLog.b("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { a().a(), Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(this.h), Float.valueOf(this.jdField_d_of_type_Float), Float.valueOf(this.jdField_e_of_type_Float), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) });
    SLog.a("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float));
    b();
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    SLog.c("WidgetWrapper", "setPositionInfo %.2f, %.2f, %.2f, %d, %d, %.2f, %.2f, r:%.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Int = b();
    this.jdField_d_of_type_Int = c();
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
    this.jdField_c_of_type_Float = paramFloat3;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.f = paramFloat4;
    this.g = paramFloat5;
    this.h = paramFloat6;
  }
  
  public void a(StoryVideoItem.PollLayout paramPollLayout, float paramFloat1, float paramFloat2)
  {
    float f1 = paramPollLayout.jdField_c_of_type_Int;
    float f2 = paramPollLayout.jdField_d_of_type_Int;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    if (f2 * 1.0F / f1 > paramFloat2 * 1.0F / paramFloat1)
    {
      this.jdField_a_of_type_Float = (paramFloat1 * 1.0F / f1);
      this.jdField_c_of_type_Float = (-(this.jdField_a_of_type_Float * f2 - paramFloat2) / 2.0F);
    }
    for (;;)
    {
      a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramPollLayout.jdField_e_of_type_Int, paramPollLayout.f, paramPollLayout.g, paramPollLayout.h, paramPollLayout.i);
      return;
      this.jdField_a_of_type_Float = (paramFloat2 * 1.0F / f2);
      this.jdField_b_of_type_Float = (-(f1 * this.jdField_a_of_type_Float - paramFloat1) / 2.0F);
    }
  }
  
  public void a(PollWidgetUtils.OnPollDetailClickListener paramOnPollDetailClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnPollDetailClickListener = paramOnPollDetailClickListener;
  }
  
  public void a(PollWidgetUtils.OnWidgetElementClickListener paramOnWidgetElementClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement.a(paramOnWidgetElementClickListener);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(paramOnWidgetElementClickListener);
    this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(paramOnWidgetElementClickListener);
  }
  
  public void a(List paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null) {
      SLog.b("WidgetWrapper", "setPollUsers mAttendWidget == null stack=%s", FeedUtils.a(4));
    }
    Object localObject1;
    do
    {
      return;
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        SLog.e("WidgetWrapper", "setPollUsers mPollUsers == null stack=%s", new Object[] { FeedUtils.a(4) });
        return;
      }
      SLog.a("WidgetWrapper", "setPollUsers mAttendWidget usercount: %d", Integer.valueOf(paramList.size()));
      localObject1 = new StringBuilder();
      i = 0;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject1).append(((QQUserUIItem)paramList.get(i)).getName());
        ((StringBuilder)localObject1).append(", ");
        i += 1;
      }
      SLog.a("WidgetWrapper", "pollUsers: %s", ((StringBuilder)localObject1).toString());
      localObject1 = (ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369136);
    } while (localObject1 == null);
    int j = ((ViewGroup)localObject1).getChildCount() - 1;
    int k = paramList.size();
    int i = Math.min(j, k);
    k = Math.max(k, paramInt);
    paramInt = 0;
    if (paramInt < i)
    {
      View localView = ((ViewGroup)localObject1).getChildAt(paramInt);
      Object localObject2;
      if ((localView instanceof ImageView))
      {
        localObject2 = (QQUserUIItem)paramList.get(paramInt);
        if ((!TextUtils.isEmpty(((QQUserUIItem)localObject2).qq)) && (!TextUtils.equals(((QQUserUIItem)localObject2).qq, "0"))) {
          break label287;
        }
        UIUtils.a((ImageView)localView, ((QQUserUIItem)localObject2).headUrl, 80, 80, 1);
      }
      for (;;)
      {
        localView.setVisibility(0);
        paramInt += 1;
        break;
        label287:
        Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130843461);
        localObject2 = FaceDrawable.a(QQStoryContext.a(), 1, String.valueOf(((QQUserUIItem)localObject2).qq), 3, localDrawable, localDrawable);
        ((ImageView)localView).setImageDrawable((Drawable)localObject2);
      }
    }
    paramInt = i;
    while (paramInt < j)
    {
      paramList = ((ViewGroup)localObject1).getChildAt(paramInt);
      if ((paramList instanceof ImageView)) {
        paramList.setVisibility(4);
      }
      paramInt += 1;
    }
    if (k <= j) {}
    for (paramList = String.format(Locale.getDefault(), "%d人参与 >", new Object[] { Integer.valueOf(k) });; paramList = String.format(Locale.getDefault(), "等%d人参与 >", new Object[] { Integer.valueOf(k) }))
    {
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131366094)).setText(paramList);
      return;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = a();
    int j = arrayOfWidgetElement.length;
    int i = 0;
    while (i < j)
    {
      arrayOfWidgetElement[i].e(paramBoolean);
      i += 1;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int m = 0;
    int k = 0;
    if (paramArrayOfInt == null) {
      SLog.e("WidgetWrapper", "Error: setOptionNumbers get null numbers!! stack = %s", new Object[] { FeedUtils.a(5) });
    }
    for (;;)
    {
      return;
      int j = 0;
      int i = 0;
      while (j < paramArrayOfInt.length)
      {
        i += paramArrayOfInt[j];
        j += 1;
      }
      j = m;
      if (i <= 0)
      {
        i = k;
        while (i < paramArrayOfInt.length)
        {
          a(i).a(0.0F);
          i += 1;
        }
      }
      else
      {
        while (j < paramArrayOfInt.length)
        {
          a(j).a(paramArrayOfInt[j] * 100.0F / i);
          j += 1;
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public PollWidgetUtils.WidgetElement[] a()
  {
    return new PollWidgetUtils.WidgetElement[] { this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement, this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement, this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement };
  }
  
  public int b()
  {
    return a().getWidth();
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup;
    if (this.jdField_b_of_type_AndroidViewViewGroup != null)
    {
      localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 4)
    {
      localViewGroup.setVisibility(i);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public int c()
  {
    return a().getHeight();
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jdField_e_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      while (i < 2500)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new otc(this), i);
        i += 500;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new otd(this), i);
      return;
    }
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement.a(false);
  }
  
  public void e(boolean paramBoolean)
  {
    AnimationDrawable localAnimationDrawable = (AnimationDrawable)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362750).getBackground();
    if (localAnimationDrawable != null)
    {
      if (!paramBoolean) {
        break label51;
      }
      localAnimationDrawable.start();
    }
    for (;;)
    {
      ((PollWidgetUtils.SingleOptionElement)this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement).d(paramBoolean);
      ((PollWidgetUtils.SingleOptionElement)this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement).d(paramBoolean);
      return;
      label51:
      localAnimationDrawable.stop();
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnPollDetailClickListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnPollDetailClickListener.a(this);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (paramView == this.jdField_b_of_type_AndroidViewViewGroup)
    {
      SLog.b("WidgetWrapper", "attendWidget onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      b();
      return;
    }
    SLog.b("WidgetWrapper", "onLayoutChange (%d, %d, %d, %d) -> (%d, %d, %d, %d)", new Object[] { Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    a();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    paramView = paramView.getParent();
    if ((!jdField_b_of_type_Boolean) && ((paramView == null) || (!(paramView instanceof ViewGroup)))) {
      throw new AssertionError();
    }
    paramView = (ViewGroup)paramView;
    if (paramView.getId() == 2131372120)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidViewViewGroup.getContext()).inflate(2130970141, paramView)).findViewById(2131369135));
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369137)).setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()) }));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
      a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Int);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper
 * JD-Core Version:    0.7.0.1
 */