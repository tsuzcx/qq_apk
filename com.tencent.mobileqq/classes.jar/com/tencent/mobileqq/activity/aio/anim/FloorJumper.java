package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ListAdapter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.ViewHolder;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;

public class FloorJumper
  extends AIOAnimationConatiner.AIOAnimator
{
  static final float jdField_a_of_type_Float = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
  static final float[] jdField_a_of_type_ArrayOfFloat = { 0.0F, 3.82F, 7.28F, 10.38F, 13.12F, 15.499998F, 17.52F, 19.18F, 20.48F, 21.420002F, 21.999998F, 22.219999F, 22.08F, 21.580004F, 20.720001F, 19.500004F, 17.920002F, 15.98F, 13.680004F, 11.020004F, 8.0F, 4.620003F, 0.8799973F, 0.0F, 0.0F, 1.568F, 2.848F, 3.839999F, 4.543999F, 4.959999F, 5.087998F, 4.927998F, 4.479999F, 3.744F, 2.719999F, 1.407999F, 0.0F, 0.0F, 0.5824001F, 0.9344F, 1.056F, 0.9472004F, 0.6080008F, 0.0384007F, 0.0F };
  static final float jdField_b_of_type_Float = 39.772724F * jdField_a_of_type_Float;
  static final float[] jdField_b_of_type_ArrayOfFloat = { 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.042F, 1.024F, 1.006F, 0.988F, 0.97F, 0.952F, 0.966F, 0.984F, 1.002F, 1.02F, 1.038F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.0356F, 1.0212F, 1.0068F, 0.9924F, 0.978F, 0.9636F, 0.9508F, 0.9652F, 0.9796F, 0.994F, 1.0084F, 1.0228F, 1.0436F, 0.98488F, 0.97336F, 0.96184F, 0.95032F, 0.9612F, 0.97272F, 0.98424F, 1.02288F };
  static final float jdField_c_of_type_Float = 17.5F * jdField_a_of_type_Float;
  static final float jdField_d_of_type_Float = 3000.0F * jdField_a_of_type_Float;
  static final int jdField_d_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 10;
  long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  public int c;
  long jdField_c_of_type_Long = 0L;
  private long jdField_d_of_type_Long;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  float jdField_g_of_type_Float = 750.0F * jdField_a_of_type_Float;
  int jdField_g_of_type_Int;
  int h;
  int i;
  int j;
  
  public FloorJumper(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_c_of_type_Int = -1;
  }
  
  private BaseChatItemLayout a(long paramLong)
  {
    int k;
    Object localObject1;
    Object localObject2;
    if (paramLong == 0L)
    {
      k = 0;
      while (k < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(k);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject2 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject1);
          if ((((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_Int != 0) && (((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getTop() + ((View)localObject1).getTop() + BaseChatItemLayout.jdField_g_of_type_Int > 0)) {
            return (BaseChatItemLayout)localObject1;
          }
        }
        k += 1;
      }
    }
    int i2 = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
    int i3 = this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();
    int m = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int i4 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int n;
    if (m > 1)
    {
      n = 1;
      m -= 1;
    }
    for (;;)
    {
      localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
      if (localObject1 == null) {
        return null;
      }
      int i5 = ((ListAdapter)localObject1).getCount();
      k = 0;
      int i1 = m;
      if (i1 <= i4) {
        if (i1 >= i2) {}
      }
      for (;;)
      {
        i1 += 1;
        break;
        if (i1 >= i5 - i3) {
          return null;
        }
        if (k == 0)
        {
          if (paramLong == ((ListAdapter)localObject1).getItemId(i1)) {
            k = 1;
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(i1 - m - n);
          if (((localObject2 instanceof BaseChatItemLayout)) && (((BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2)).jdField_a_of_type_Int != 0)) {
            return (BaseChatItemLayout)localObject2;
          }
          if (localObject2 == null) {
            QLog.i("floor_jumper", 2, "not found idx: " + i1 + ", first: " + m + ", last: " + i4);
          }
        }
      }
      n = 0;
    }
  }
  
  int a(int paramInt, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int k;
    int m;
    int n;
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      k = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.j + BaseChatItemLayout.o;
      m = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.i - BaseChatItemLayout.n;
      if (paramInt > k) {
        break label135;
      }
      if (m - jdField_c_of_type_Float >= k) {
        break label108;
      }
      n = k;
    }
    label108:
    do
    {
      return n;
      k = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.i + BaseChatItemLayout.n;
      m = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.j - BaseChatItemLayout.j;
      break;
      d1 = Math.random();
      double d2 = m - k - jdField_c_of_type_Float;
      return (int)(k + d1 * d2);
      if (paramInt >= m)
      {
        if (k + jdField_c_of_type_Float < m) {
          return m;
        }
        d1 = k + jdField_c_of_type_Float;
        d2 = Math.random();
        return (int)((m - k - jdField_c_of_type_Float) * d2 + d1);
      }
      if (paramInt - k > jdField_c_of_type_Float) {
        break label217;
      }
      n = paramInt;
    } while (m - paramInt <= jdField_c_of_type_Float);
    label135:
    label217:
    float f1;
    if ((paramInt - k > jdField_c_of_type_Float) && (m - paramInt > jdField_c_of_type_Float))
    {
      f1 = (int)(Math.random() * (m - k - jdField_c_of_type_Float - jdField_c_of_type_Float));
      return (int)(k + jdField_c_of_type_Float + f1);
    }
    if (paramInt - k > jdField_c_of_type_Float)
    {
      d1 = Math.random();
      f1 = (int)((paramInt - k - jdField_c_of_type_Float) * d1);
      return (int)(paramInt - f1);
    }
    double d1 = Math.random();
    return (int)((int)((m - paramInt - jdField_c_of_type_Float) * d1) + paramInt);
  }
  
  public long a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return -1L;
    }
    long l = AnimationUtils.currentAnimationTimeMillis();
    switch (this.jdField_b_of_type_Int)
    {
    default: 
      return -1L;
    case 1: 
    case 3: 
      if (l < this.jdField_c_of_type_Long) {
        return this.jdField_c_of_type_Long - l;
      }
      BaseBubbleBuilder.ViewHolder localViewHolder;
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_c_of_type_Long = l;
        localBaseChatItemLayout = a(0L);
        if (localBaseChatItemLayout != null)
        {
          localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(localBaseChatItemLayout);
          if (localViewHolder != null)
          {
            this.jdField_b_of_type_Int = 2;
            this.jdField_a_of_type_Long = 0L;
            this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
            this.jdField_d_of_type_Long = 0L;
            this.jdField_e_of_type_Int = 0;
            k = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
            this.jdField_f_of_type_Int = (localBaseChatItemLayout.getTop() + k + BaseChatItemLayout.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
            this.jdField_g_of_type_Int = a((localViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + localViewHolder.jdField_a_of_type_AndroidViewView.getRight()) / 2, localViewHolder);
            this.h = 0;
            this.jdField_e_of_type_Float = 0.0F;
            this.jdField_f_of_type_Float = ((float)(500.0F * jdField_a_of_type_Float * Math.random()));
            this.j = 0;
            this.i = 0;
          }
        }
        for (;;)
        {
          return 0L;
          this.jdField_b_of_type_Int = 5;
          this.jdField_g_of_type_Int = (this.jdField_a_of_type_ComTencentWidgetListView.getWidth() / 2 + (int)(Math.random() * 160.0D * jdField_a_of_type_Float - 80.0D));
          this.h = this.j;
          this.jdField_d_of_type_Long = 0L;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
          this.jdField_e_of_type_Int = 0;
          this.jdField_f_of_type_Int = 0;
          this.jdField_e_of_type_Float = 0.0F;
          this.jdField_f_of_type_Float = ((float)(500.0F * jdField_a_of_type_Float * Math.random()));
        }
      }
      BaseChatItemLayout localBaseChatItemLayout = a(this.jdField_b_of_type_Long);
      if (localBaseChatItemLayout != null)
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(localBaseChatItemLayout);
        if (localViewHolder != null)
        {
          this.jdField_g_of_type_Int = this.i;
          this.h = this.j;
          this.jdField_b_of_type_Int = 4;
          this.jdField_c_of_type_Long = l;
          this.jdField_d_of_type_Long = 0L;
          this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
          this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          this.jdField_f_of_type_Float = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * jdField_a_of_type_Float);
          k = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
          this.jdField_f_of_type_Int = (localBaseChatItemLayout.getTop() + k + BaseChatItemLayout.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY() - this.h);
          double d1 = (Math.sqrt(this.jdField_f_of_type_Float * this.jdField_f_of_type_Float + jdField_d_of_type_Float * 2.0F * this.jdField_f_of_type_Int) - this.jdField_f_of_type_Float) / jdField_d_of_type_Float;
          this.jdField_e_of_type_Int = (a(this.i, localViewHolder) - this.i);
          this.jdField_e_of_type_Float = ((float)(this.jdField_e_of_type_Int / d1));
        }
      }
      for (;;)
      {
        return 0L;
        this.jdField_g_of_type_Int = this.i;
        this.h = this.j;
        this.jdField_b_of_type_Int = 5;
        this.jdField_c_of_type_Long = l;
        this.jdField_d_of_type_Long = 0L;
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_e_of_type_Int = 0;
        this.jdField_f_of_type_Int = 0;
        this.jdField_e_of_type_Float = ((float)(Math.random() * 400.0D - 100.0D));
        this.jdField_f_of_type_Float = ((float)-(750.0D + (Math.random() - 1.0D) * 300.0D) * jdField_a_of_type_Float);
      }
    case 2: 
    case 4: 
      if (this.jdField_d_of_type_Long == 0L)
      {
        f1 = (float)(l - this.jdField_c_of_type_Long) / 1000.0F;
        m = (int)(this.jdField_f_of_type_Float * f1 + jdField_d_of_type_Float * f1 * f1 / 2.0F);
        int n = (int)(this.jdField_e_of_type_Float * f1);
        f2 = this.jdField_g_of_type_Float;
        f3 = this.jdField_f_of_type_Float;
        f1 = Math.min(f2, Math.abs(f1 * jdField_d_of_type_Float + f3)) / this.jdField_g_of_type_Float * 0.25F + 0.9F;
        k = m;
        if (m > this.jdField_f_of_type_Int)
        {
          k = this.jdField_f_of_type_Int;
          f1 = 1.0F;
          this.jdField_d_of_type_Long = l;
        }
        this.j = (k + this.h);
        this.i = (this.jdField_g_of_type_Int + n);
        a(this.i, this.j, new float[] { f1 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      if (l - this.jdField_d_of_type_Long <= jdField_d_of_type_Int)
      {
        f1 = (float)(l - this.jdField_d_of_type_Long) / 1000.0F;
        m = Math.round((float)(l - this.jdField_d_of_type_Long) / 10.0F);
        k = m;
        if (m >= jdField_a_of_type_ArrayOfFloat.length) {
          k = jdField_a_of_type_ArrayOfFloat.length - 1;
        }
        f1 = (int)(f1 * Math.max(Math.min(this.jdField_e_of_type_Float, jdField_b_of_type_Float), -jdField_b_of_type_Float));
        f2 = jdField_a_of_type_ArrayOfFloat[k];
        f3 = jdField_a_of_type_Float;
        float f4 = jdField_b_of_type_ArrayOfFloat[k];
        this.i = ((int)(f1 + (this.jdField_g_of_type_Int + this.jdField_e_of_type_Int)));
        this.j = ((int)(this.h + this.jdField_f_of_type_Int - f2 * f3));
        a(this.i, this.j, new float[] { f4 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      this.j = (this.h + this.jdField_f_of_type_Int);
      a(this.i, this.j, new float[0]);
      k = (int)(500.0D + Math.random() * 800.0D - 400.0D);
      this.jdField_c_of_type_Long = (AnimationUtils.currentAnimationTimeMillis() + k);
      this.jdField_b_of_type_Int = 3;
      return k;
    }
    float f1 = (float)(l - this.jdField_c_of_type_Long) / 1000.0F;
    int k = (int)(this.jdField_f_of_type_Float * f1 + jdField_d_of_type_Float * f1 * f1 / 2.0F);
    int m = (int)(this.jdField_e_of_type_Float * f1);
    float f2 = this.jdField_g_of_type_Float;
    float f3 = this.jdField_f_of_type_Float;
    f1 = Math.min(f2, Math.abs(f1 * jdField_d_of_type_Float + f3)) / this.jdField_g_of_type_Float;
    this.j = (k + this.h);
    this.i = (this.jdField_g_of_type_Int + m);
    if ((this.j > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) || (this.i < -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) || (this.i > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
    {
      a(0, this.jdField_a_of_type_AndroidViewView.getWidth(), new float[0]);
      c();
      return -1L;
    }
    a(this.i, this.j, new float[] { f1 * 0.25F + 0.9F });
    return FloorJumperSet.jdField_a_of_type_Long;
  }
  
  @TargetApi(11)
  void a(int paramInt1, int paramInt2, float... paramVarArgs)
  {
    int k = this.jdField_a_of_type_AndroidViewView.getLeft();
    int m = this.jdField_a_of_type_AndroidViewView.getWidth() / 2;
    int n = this.jdField_a_of_type_AndroidViewView.getBottom();
    this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(paramInt2 - n);
    this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(paramInt1 - (k + m));
    if (VersionUtils.e())
    {
      if ((paramVarArgs != null) && (paramVarArgs.length > 0))
      {
        this.jdField_a_of_type_AndroidViewView.setScaleY(paramVarArgs[0]);
        this.jdField_a_of_type_AndroidViewView.setScaleX(2.0F - paramVarArgs[0]);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
    this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramBoolean) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      int k;
      while ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner == null) || (this.jdField_a_of_type_AndroidViewView == null))
      {
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        this.jdField_a_of_type_AndroidViewView = null;
        return false;
        k = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        if (k < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition())
        {
          this.j = -1;
        }
        else if (k > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition())
        {
          if (this.jdField_d_of_type_Long > 0L)
          {
            c();
            return false;
          }
          this.jdField_b_of_type_Int = 5;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = 0L;
        }
        else
        {
          BaseBubbleBuilder.ViewHolder localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, k));
          if (localViewHolder != null)
          {
            k = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
            k = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + k + BaseChatItemLayout.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY() - (this.h + this.jdField_f_of_type_Int);
            if (k != 0)
            {
              this.h += k;
              this.j += k;
              this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(k);
            }
          }
          else
          {
            c();
            return false;
            k = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
            int m = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
            if ((k >= this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()) && (k <= this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, k));
              if (localViewHolder != null)
              {
                k = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                k = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + k + BaseChatItemLayout.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY() - (this.h + this.jdField_f_of_type_Int);
                if (k != 0)
                {
                  this.h += k;
                  this.j += k;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(k);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if ((m >= this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()) && (m <= this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, m));
              if (localViewHolder != null)
              {
                k = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                k = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop() + k + BaseChatItemLayout.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY() - (this.h + this.jdField_f_of_type_Int);
                if (k != 0)
                {
                  this.h += k;
                  this.j += k;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(k);
                }
              }
              else
              {
                c();
                return false;
              }
            }
            else if (k < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition())
            {
              this.j = -1;
            }
            else if (m > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition())
            {
              this.jdField_b_of_type_Int = 5;
              this.jdField_a_of_type_Long = 0L;
              this.jdField_b_of_type_Long = 0L;
            }
            else
            {
              c();
              return false;
            }
          }
        }
      }
      if ((this.j > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) || (this.i < -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) || (this.i > this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
      {
        c();
        return false;
      }
      if (this.j <= 0) {
        switch (this.jdField_b_of_type_Int)
        {
        }
      }
      for (;;)
      {
        return true;
        k = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
        if ((k < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()) || (k > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()))
        {
          a(new Object[0]);
          a(this.i, this.j, new float[0]);
          continue;
          a(new Object[0]);
          a(this.i, this.j, new float[0]);
        }
      }
    }
    c();
    return false;
  }
  
  protected boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.jdField_a_of_type_Boolean) {
      return a(true);
    }
    return false;
  }
  
  @TargetApi(11)
  protected boolean a(Object... paramVarArgs)
  {
    Rect localRect;
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)paramVarArgs[0]);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        return false;
      }
      localRect = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getBounds();
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      if (localRect.isEmpty())
      {
        this.jdField_a_of_type_AndroidViewView.layout(-this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), -this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight(), 0, 0);
        if (VersionUtils.e())
        {
          this.jdField_a_of_type_AndroidViewView.setPivotX(this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
          this.jdField_a_of_type_AndroidViewView.setPivotY(this.jdField_a_of_type_AndroidViewView.getHeight());
          this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
        }
        label161:
        this.jdField_b_of_type_Int = 2;
        this.jdField_a_of_type_Boolean = true;
        if (paramVarArgs.length <= 1) {
          break label301;
        }
      }
    }
    label301:
    for (paramVarArgs = paramVarArgs[1];; paramVarArgs = Integer.valueOf(0))
    {
      int k = ((Integer)paramVarArgs).intValue();
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "start floor jumper. delay: " + k);
      }
      long l = AnimationUtils.currentAnimationTimeMillis();
      this.jdField_c_of_type_Long = (k + l);
      this.jdField_b_of_type_Int = 1;
      return true;
      this.jdField_a_of_type_AndroidViewView.layout(-localRect.width(), -localRect.height(), 0, 0);
      break;
      this.jdField_a_of_type_AndroidViewView.offsetLeftAndRight(-this.jdField_a_of_type_AndroidViewView.getRight());
      this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(-this.jdField_a_of_type_AndroidViewView.getBottom());
      break label161;
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumper
 * JD-Core Version:    0.7.0.1
 */