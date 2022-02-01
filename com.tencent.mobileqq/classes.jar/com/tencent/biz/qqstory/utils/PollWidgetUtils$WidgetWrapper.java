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
  public float a;
  public int a;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  public ViewGroup a;
  public PollWidgetUtils.OnPollDetailClickListener a;
  PollWidgetUtils.OnSelectedChangedListener jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener = new PollWidgetUtils.WidgetWrapper.1(this);
  PollWidgetUtils.OptionElement jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  PollWidgetUtils.QuestionElement jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement;
  public List<QQUserUIItem> a;
  public boolean a;
  public int[] a;
  public float b;
  public int b;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  PollWidgetUtils.OptionElement jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  public float c;
  public int c;
  private boolean c;
  public float d;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean = false;
  public float e;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = false;
  public float f;
  public float g;
  public float h;
  
  public PollWidgetUtils$WidgetWrapper(Context paramContext)
  {
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(paramContext).inflate(2131560881, null, false));
    this.jdField_a_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.addOnAttachStateChangeListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement = new PollWidgetUtils.QuestionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131378499));
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement = new PollWidgetUtils.SingleOptionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369827), 0);
    this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener);
    this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement = new PollWidgetUtils.SingleOptionElement(this, this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131369828), 1);
    this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a(this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnSelectedChangedListener);
  }
  
  private void b()
  {
    Object localObject = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localObject == null)
    {
      SLog.b("WidgetWrapper", "mAttendWidget is null, no action, return");
      return;
    }
    float f2 = this.f;
    float f1 = this.jdField_a_of_type_Float;
    float f5 = f2 * f1 + this.jdField_b_of_type_Float;
    float f6 = this.g * f1 + this.jdField_c_of_type_Float;
    int i = ((ViewGroup)localObject).getHeight();
    int j = this.jdField_b_of_type_AndroidViewViewGroup.getWidth();
    f1 = this.jdField_d_of_type_Int * 1.0F / 2.0F;
    float f7 = i * 1.0F / 2.0F;
    localObject = PollWidgetUtils.a(0.0F, f1 + f7 + UIUtils.a(this.jdField_b_of_type_AndroidViewViewGroup.getContext(), 10.0F), this.h);
    float f4 = localObject[0];
    float f3 = localObject[1];
    if ((this.jdField_d_of_type_Float * f4 + f5 >= 0.0F) && ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() == null) || (this.jdField_e_of_type_Float * f3 + f6 <= ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getHeight())) && ((this.jdField_b_of_type_AndroidViewViewGroup.getParent() == null) || (this.jdField_d_of_type_Float * f4 + f5 <= ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.getParent()).getWidth())))
    {
      f2 = f3;
      f1 = f4;
      if (this.jdField_e_of_type_Float * f3 + f6 >= 0.0F) {}
    }
    else
    {
      f1 = -f4;
      f2 = -f3;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setX(f5 + this.jdField_d_of_type_Float * f1 - j * 1.0F / 2.0F);
    this.jdField_b_of_type_AndroidViewViewGroup.setY(f6 + this.jdField_e_of_type_Float * f2 - f7);
    this.jdField_b_of_type_AndroidViewViewGroup.setRotation(this.h);
    this.jdField_b_of_type_AndroidViewViewGroup.setScaleX(this.jdField_d_of_type_Float);
    this.jdField_b_of_type_AndroidViewViewGroup.setScaleY(this.jdField_e_of_type_Float);
    if (j != 0) {
      b(this.jdField_a_of_type_Boolean);
    } else {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(4);
    }
    SLog.a("WidgetWrapper", "relayoutAttendView %d", Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()));
    SLog.b("WidgetWrapper", "relayoutAttendView 2widgets(%d, %d, %d, %d) showAttend? %b, stack=%s", new Object[] { Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int), Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(this.jdField_a_of_type_Boolean), FeedUtils.a(5) });
    SLog.a("WidgetWrapper", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(f1), Float.valueOf(f2));
  }
  
  public int a()
  {
    return a().getWidth();
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public PollWidgetUtils.OptionElement a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return new PollWidgetUtils.NullOptionElement(this, this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement.a, paramInt);
      }
      return this.jdField_b_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
    }
    return this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OptionElement;
  }
  
  public PollWidgetUtils.QuestionElement a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$QuestionElement;
  }
  
  public void a()
  {
    if (!this.jdField_c_of_type_Boolean) {
      return;
    }
    this.jdField_e_of_type_Int = a();
    this.jdField_d_of_type_Int = b();
    float f1 = this.jdField_a_of_type_Float;
    float f2 = this.jdField_a_of_type_Int;
    int i = this.jdField_e_of_type_Int;
    this.jdField_d_of_type_Float = (f2 * f1 / i);
    f2 = this.jdField_b_of_type_Int;
    int j = this.jdField_d_of_type_Int;
    this.jdField_e_of_type_Float = (f2 * f1 / j);
    if (i != 0)
    {
      if (j == 0) {
        return;
      }
      f2 = this.f * f1 + this.jdField_b_of_type_Float;
      f1 = this.g * f1 + this.jdField_c_of_type_Float;
      a().setX(f2 - this.jdField_e_of_type_Int * 1.0F / 2.0F);
      a().setY(f1 - this.jdField_d_of_type_Int * 1.0F / 2.0F);
      a().setRotation(this.h);
      a().setScaleX(this.jdField_d_of_type_Float);
      a().setScaleY(this.jdField_e_of_type_Float);
      SLog.b("WidgetWrapper", "%s relayoutPollView view center (%.2f, %.2f) rotation(%.2f) scale(%.2f, %.2f) widgets(%d, %d)", new Object[] { a().a(), Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(this.h), Float.valueOf(this.jdField_d_of_type_Float), Float.valueOf(this.jdField_e_of_type_Float), Integer.valueOf(this.jdField_e_of_type_Int), Integer.valueOf(this.jdField_d_of_type_Int) });
      SLog.a("WidgetWrapper", "relayoutPollView offset(%.2f, %.2f)", Float.valueOf(this.jdField_b_of_type_Float), Float.valueOf(this.jdField_c_of_type_Float));
      b();
    }
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt1, int paramInt2, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    SLog.c("WidgetWrapper", "setPositionInfo %.2f, %.2f, %.2f, %d, %d, %.2f, %.2f, r:%.2f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Float.valueOf(paramFloat3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(paramFloat4), Float.valueOf(paramFloat5), Float.valueOf(paramFloat6) });
    this.jdField_c_of_type_Boolean = true;
    this.jdField_e_of_type_Int = a();
    this.jdField_d_of_type_Int = b();
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
    float f3 = f2 * 1.0F / f1;
    float f4 = paramFloat2 * 1.0F;
    if (f3 > f4 / paramFloat1)
    {
      this.jdField_a_of_type_Float = (paramFloat1 * 1.0F / f1);
      this.jdField_c_of_type_Float = (-(f2 * this.jdField_a_of_type_Float - paramFloat2) / 2.0F);
    }
    else
    {
      this.jdField_a_of_type_Float = (f4 / f2);
      this.jdField_b_of_type_Float = (-(f1 * this.jdField_a_of_type_Float - paramFloat1) / 2.0F);
    }
    a(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float, this.jdField_c_of_type_Float, paramPollLayout.jdField_e_of_type_Int, paramPollLayout.f, paramPollLayout.g, paramPollLayout.h, paramPollLayout.i);
  }
  
  public void a(List<QQUserUIItem> paramList, int paramInt)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_c_of_type_Int = paramInt;
    if (this.jdField_b_of_type_AndroidViewViewGroup == null)
    {
      SLog.b("WidgetWrapper", "setPollUsers mAttendWidget == null stack=%s", FeedUtils.a(4));
      return;
    }
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      SLog.e("WidgetWrapper", "setPollUsers mPollUsers == null stack=%s", new Object[] { FeedUtils.a(4) });
      return;
    }
    SLog.a("WidgetWrapper", "setPollUsers mAttendWidget usercount: %d", Integer.valueOf(paramList.size()));
    Object localObject1 = new StringBuilder();
    int i = 0;
    Object localObject2;
    while (i < paramList.size())
    {
      localObject2 = (QQUserUIItem)paramList.get(i);
      if (localObject2 != null)
      {
        ((StringBuilder)localObject1).append(((QQUserUIItem)localObject2).getName());
        ((StringBuilder)localObject1).append(", ");
      }
      i += 1;
    }
    SLog.a("WidgetWrapper", "pollUsers: %s", ((StringBuilder)localObject1).toString());
    localObject1 = (ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369880);
    if (localObject1 != null)
    {
      int k = ((ViewGroup)localObject1).getChildCount() - 1;
      i = paramList.size();
      int j = Math.min(k, i);
      int m = Math.max(i, paramInt);
      paramInt = 0;
      for (;;)
      {
        i = j;
        if (paramInt >= j) {
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
              Drawable localDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130846695);
              localObject3 = FaceDrawable.getFaceDrawable(QQStoryContext.a(), 1, String.valueOf(((QQUserUIItem)localObject3).qq), 3, localDrawable, localDrawable);
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
      while (i < k)
      {
        paramList = ((ViewGroup)localObject1).getChildAt(i);
        if ((paramList instanceof ImageView)) {
          paramList.setVisibility(4);
        }
        i += 1;
      }
      if (m <= k) {
        paramList = String.format(Locale.getDefault(), "%d人参与 >", new Object[] { Integer.valueOf(m) });
      } else {
        paramList = String.format(Locale.getDefault(), HardCodeUtil.a(2131708323), new Object[] { Integer.valueOf(m) });
      }
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378607)).setText(paramList);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    PollWidgetUtils.WidgetElement[] arrayOfWidgetElement = a();
    int j = arrayOfWidgetElement.length;
    int i = 0;
    while (i < j)
    {
      arrayOfWidgetElement[i].c(paramBoolean);
      i += 1;
    }
  }
  
  public void a(int[] paramArrayOfInt)
  {
    int m = 0;
    int k = 0;
    if (paramArrayOfInt == null)
    {
      SLog.e("WidgetWrapper", "Error: setOptionNumbers get null numbers!! stack = %s", new Object[] { FeedUtils.a(5) });
      return;
    }
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
    while (j < paramArrayOfInt.length)
    {
      a(j).a(paramArrayOfInt[j] * 100.0F / i);
      j += 1;
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
    return a().getHeight();
  }
  
  public void b(boolean paramBoolean)
  {
    ViewGroup localViewGroup = this.jdField_b_of_type_AndroidViewViewGroup;
    if (localViewGroup != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 4;
      }
      localViewGroup.setVisibility(i);
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    PollWidgetUtils.OnPollDetailClickListener localOnPollDetailClickListener = this.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$OnPollDetailClickListener;
    if (localOnPollDetailClickListener != null) {
      localOnPollDetailClickListener.a(this);
    }
    EventCollector.getInstance().onViewClicked(paramView);
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
    if (paramView.getId() == 2131372931)
    {
      this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)((ViewGroup)LayoutInflater.from(this.jdField_a_of_type_AndroidViewViewGroup.getContext()).inflate(2131560880, paramView)).findViewById(2131365568));
      ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378509)).setText(String.format(Locale.getDefault(), "%d", new Object[] { Integer.valueOf(this.jdField_b_of_type_AndroidViewViewGroup.hashCode()) }));
      this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewViewGroup.addOnLayoutChangeListener(this);
      a(this.jdField_a_of_type_JavaUtilList, this.jdField_c_of_type_Int);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.PollWidgetUtils.WidgetWrapper
 * JD-Core Version:    0.7.0.1
 */