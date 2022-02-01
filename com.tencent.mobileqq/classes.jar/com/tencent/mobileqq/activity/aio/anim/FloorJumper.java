package com.tencent.mobileqq.activity.aio.anim;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
  static final float jdField_b_of_type_Float;
  static final float[] jdField_b_of_type_ArrayOfFloat = { 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.042F, 1.024F, 1.006F, 0.988F, 0.97F, 0.952F, 0.966F, 0.984F, 1.002F, 1.02F, 1.038F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.05F, 1.0356F, 1.0212F, 1.0068F, 0.9924F, 0.978F, 0.9636F, 0.9508F, 0.9652F, 0.9796F, 0.994F, 1.0084F, 1.0228F, 1.0436F, 0.98488F, 0.97336F, 0.96184F, 0.95032F, 0.9612F, 0.97272F, 0.98424F, 1.02288F };
  static final float jdField_c_of_type_Float;
  static final float jdField_d_of_type_Float;
  static final int jdField_d_of_type_Int = jdField_a_of_type_ArrayOfFloat.length * 10;
  long jdField_a_of_type_Long = 0L;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_a_of_type_AndroidViewView;
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  long jdField_b_of_type_Long = 0L;
  int jdField_c_of_type_Int = -1;
  long jdField_c_of_type_Long = 0L;
  private long jdField_d_of_type_Long = 0L;
  float jdField_e_of_type_Float;
  int jdField_e_of_type_Int;
  float jdField_f_of_type_Float;
  int jdField_f_of_type_Int;
  float jdField_g_of_type_Float = jdField_a_of_type_Float * 750.0F;
  int jdField_g_of_type_Int;
  int h;
  int i;
  int j;
  
  static
  {
    float f1 = jdField_a_of_type_Float;
    jdField_b_of_type_Float = 39.772724F * f1;
    jdField_c_of_type_Float = 17.5F * f1;
    jdField_d_of_type_Float = f1 * 3000.0F;
  }
  
  public FloorJumper(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
  }
  
  private BaseChatItemLayout a(long paramLong)
  {
    int k = 0;
    Object localObject2;
    if (paramLong == 0L) {
      while (k < this.jdField_a_of_type_ComTencentWidgetListView.getChildCount())
      {
        localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(k);
        if ((localObject1 instanceof BaseChatItemLayout))
        {
          localObject2 = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject1);
          if ((((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_Int != 0) && (((BaseBubbleBuilder.ViewHolder)localObject2).jdField_a_of_type_AndroidViewView.getTop() + ((View)localObject1).getTop() + BaseChatItemLayout.h > 0)) {
            return (BaseChatItemLayout)localObject1;
          }
        }
        k += 1;
      }
    }
    int i3 = this.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount();
    int i4 = this.jdField_a_of_type_ComTencentWidgetListView.getFooterViewsCount();
    k = this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    int i5 = this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition();
    int m;
    if (k > 1)
    {
      k -= 1;
      m = 1;
    }
    else
    {
      m = 0;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentWidgetListView.getAdapter();
    if (localObject1 == null) {
      return null;
    }
    int i6 = ((ListAdapter)localObject1).getCount();
    int n = k;
    int i2;
    for (int i1 = 0; n <= i5; i1 = i2)
    {
      if (n < i3)
      {
        i2 = i1;
      }
      else
      {
        if (n >= i6 - i4) {
          return null;
        }
        if (i1 == 0)
        {
          i2 = i1;
          if (paramLong == ((ListAdapter)localObject1).getItemId(n)) {
            i2 = 1;
          }
        }
        else
        {
          localObject2 = this.jdField_a_of_type_ComTencentWidgetListView.getChildAt(n - k - m);
          if (((localObject2 instanceof BaseChatItemLayout)) && (((BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject2)).jdField_a_of_type_Int != 0)) {
            return (BaseChatItemLayout)localObject2;
          }
          i2 = i1;
          if (localObject2 == null)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("not found idx: ");
            ((StringBuilder)localObject2).append(n);
            ((StringBuilder)localObject2).append(", first: ");
            ((StringBuilder)localObject2).append(k);
            ((StringBuilder)localObject2).append(", last: ");
            ((StringBuilder)localObject2).append(i5);
            QLog.i("floor_jumper", 2, ((StringBuilder)localObject2).toString());
            i2 = i1;
          }
        }
      }
      n += 1;
    }
    return null;
  }
  
  private void a(AioAnimationRule paramAioAnimationRule, ChatMessage paramChatMessage)
  {
    EggsUtil.a(null, "0X800B072", paramChatMessage.frienduin, paramAioAnimationRule);
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject.length >= 5) && ((paramArrayOfObject[3] instanceof AioAnimationRule)))
    {
      if (!(paramArrayOfObject[4] instanceof ChatMessage)) {
        return;
      }
      AioAnimationRule localAioAnimationRule = (AioAnimationRule)paramArrayOfObject[3];
      if (!a(localAioAnimationRule.a)) {
        return;
      }
      paramArrayOfObject = (ChatMessage)paramArrayOfObject[4];
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("set jump url, url = ");
        localStringBuilder.append(localAioAnimationRule.a);
        QLog.d("FloorJumper", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new FloorJumper.1(this, localAioAnimationRule, paramArrayOfObject));
    }
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("http")) || (paramString.startsWith("https")));
  }
  
  int a(int paramInt, BaseBubbleBuilder.ViewHolder paramViewHolder)
  {
    int k;
    int n;
    if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.isSend())
    {
      k = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.k + BaseChatItemLayout.p;
      n = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.j;
      m = BaseChatItemLayout.o;
    }
    else
    {
      k = paramViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + BaseChatItemLayout.j + BaseChatItemLayout.o;
      n = paramViewHolder.jdField_a_of_type_AndroidViewView.getRight() - BaseChatItemLayout.k;
      m = BaseChatItemLayout.k;
    }
    int m = n - m;
    double d3;
    if (paramInt <= k)
    {
      if (m - jdField_c_of_type_Float < k) {
        return k;
      }
      d1 = Math.random();
      d2 = m - k - jdField_c_of_type_Float;
      Double.isNaN(d2);
      d3 = k;
      Double.isNaN(d3);
      return (int)(d1 * d2 + d3);
    }
    if (paramInt >= m)
    {
      f1 = k;
      f2 = jdField_c_of_type_Float;
      if (f1 + f2 < m) {
        return m;
      }
      d1 = f1 + f2;
      d2 = Math.random();
      d3 = m - k - jdField_c_of_type_Float;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (int)(d1 + d2 * d3);
    }
    float f1 = paramInt - k;
    float f2 = jdField_c_of_type_Float;
    if ((f1 <= f2) && (m - paramInt <= f2)) {
      return paramInt;
    }
    f2 = jdField_c_of_type_Float;
    if ((f1 > f2) && (m - paramInt > f2))
    {
      d1 = Math.random();
      f2 = m - k;
      f1 = jdField_c_of_type_Float;
      d2 = f2 - f1 - f1;
      Double.isNaN(d2);
      f2 = (int)(d1 * d2);
      return (int)(k + f1 + f2);
    }
    if (f1 > jdField_c_of_type_Float)
    {
      d1 = Math.random();
      d2 = f1 - jdField_c_of_type_Float;
      Double.isNaN(d2);
      f1 = (int)(d1 * d2);
      return (int)(paramInt - f1);
    }
    double d1 = Math.random();
    double d2 = m - paramInt - jdField_c_of_type_Float;
    Double.isNaN(d2);
    f1 = (int)(d1 * d2);
    return (int)(paramInt + f1);
  }
  
  long a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return -1L;
    }
    long l1 = AnimationUtils.currentAnimationTimeMillis();
    int k = this.jdField_b_of_type_Int;
    float f1;
    if (k != 1)
    {
      float f2;
      float f3;
      int m;
      if (k != 2)
      {
        if (k == 3) {
          break label698;
        }
        if (k != 4)
        {
          if (k != 5) {
            return -1L;
          }
          f1 = (float)(l1 - this.jdField_c_of_type_Long) / 1000.0F;
          f2 = this.jdField_f_of_type_Float;
          f3 = jdField_d_of_type_Float;
          k = (int)(f2 * f1 + f3 * f1 * f1 / 2.0F);
          m = (int)(this.jdField_e_of_type_Float * f1);
          f1 = Math.min(this.jdField_g_of_type_Float, Math.abs(f2 + f3 * f1)) / this.jdField_g_of_type_Float;
          this.j = (this.h + k);
          this.i = (this.jdField_g_of_type_Int + m);
          if ((this.j <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) && (this.i >= -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) && (this.i <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
          {
            a(this.i, this.j, new float[] { f1 * 0.25F + 0.9F });
            return FloorJumperSet.jdField_a_of_type_Long;
          }
          a(0, this.jdField_a_of_type_AndroidViewView.getWidth(), new float[0]);
          c();
          return -1L;
        }
      }
      l2 = this.jdField_d_of_type_Long;
      if (l2 == 0L)
      {
        f1 = (float)(l1 - this.jdField_c_of_type_Long) / 1000.0F;
        f2 = this.jdField_f_of_type_Float;
        f3 = jdField_d_of_type_Float;
        k = (int)(f2 * f1 + f3 * f1 * f1 / 2.0F);
        int n = (int)(this.jdField_e_of_type_Float * f1);
        f1 = Math.min(this.jdField_g_of_type_Float, Math.abs(f2 + f3 * f1)) / this.jdField_g_of_type_Float * 0.25F + 0.9F;
        m = this.jdField_f_of_type_Int;
        if (k > m)
        {
          f1 = 1.0F;
          this.jdField_d_of_type_Long = l1;
          k = m;
        }
        this.j = (this.h + k);
        this.i = (this.jdField_g_of_type_Int + n);
        a(this.i, this.j, new float[] { f1 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      if (l1 - l2 <= jdField_d_of_type_Int)
      {
        f1 = (float)(l1 - l2) / 1000.0F;
        m = Math.round((float)(l1 - l2) / 10.0F);
        localObject = jdField_a_of_type_ArrayOfFloat;
        k = m;
        if (m >= localObject.length) {
          k = localObject.length - 1;
        }
        f1 = (int)(Math.max(Math.min(this.jdField_e_of_type_Float, jdField_b_of_type_Float), -jdField_b_of_type_Float) * f1);
        f2 = jdField_a_of_type_ArrayOfFloat[k];
        f3 = jdField_a_of_type_Float;
        float f4 = jdField_b_of_type_ArrayOfFloat[k];
        this.i = ((int)(this.jdField_g_of_type_Int + this.jdField_e_of_type_Int + f1));
        this.j = ((int)(this.h + this.jdField_f_of_type_Int - f2 * f3));
        a(this.i, this.j, new float[] { f4 });
        return FloorJumperSet.jdField_a_of_type_Long;
      }
      this.j = (this.h + this.jdField_f_of_type_Int);
      a(this.i, this.j, new float[0]);
      k = (int)(Math.random() * 800.0D + 500.0D - 400.0D);
      l1 = AnimationUtils.currentAnimationTimeMillis();
      l2 = k;
      this.jdField_c_of_type_Long = (l1 + l2);
      this.jdField_b_of_type_Int = 3;
      return l2;
    }
    label698:
    long l2 = this.jdField_c_of_type_Long;
    if (l1 < l2) {
      return l2 - l1;
    }
    BaseBubbleBuilder.ViewHolder localViewHolder;
    double d1;
    double d2;
    if (this.jdField_b_of_type_Int == 1)
    {
      this.jdField_c_of_type_Long = l1;
      localObject = a(0L);
      if (localObject != null)
      {
        localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
        if (localViewHolder != null)
        {
          this.jdField_b_of_type_Int = 2;
          this.jdField_a_of_type_Long = 0L;
          this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
          this.jdField_d_of_type_Long = 0L;
          this.jdField_e_of_type_Int = 0;
          this.jdField_f_of_type_Int = (localViewHolder.jdField_a_of_type_AndroidViewView.getTop() + ((BaseChatItemLayout)localObject).getTop() + BaseChatItemLayout.h - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY());
          this.jdField_g_of_type_Int = a((localViewHolder.jdField_a_of_type_AndroidViewView.getLeft() + localViewHolder.jdField_a_of_type_AndroidViewView.getRight()) / 2, localViewHolder);
          this.h = 0;
          this.jdField_e_of_type_Float = 0.0F;
          d1 = jdField_a_of_type_Float * 500.0F;
          d2 = Math.random();
          Double.isNaN(d1);
          this.jdField_f_of_type_Float = ((float)(d1 * d2));
          this.j = 0;
          this.i = 0;
          return 0L;
        }
      }
      else
      {
        this.jdField_b_of_type_Int = 5;
        k = this.jdField_a_of_type_ComTencentWidgetListView.getWidth() / 2;
        d1 = Math.random();
        f1 = jdField_a_of_type_Float;
        d2 = f1;
        Double.isNaN(d2);
        this.jdField_g_of_type_Int = (k + (int)(d1 * 160.0D * d2 - 80.0D));
        this.h = this.j;
        this.jdField_d_of_type_Long = 0L;
        this.jdField_a_of_type_Long = 0L;
        this.jdField_b_of_type_Long = 0L;
        this.jdField_e_of_type_Int = 0;
        this.jdField_f_of_type_Int = 0;
        this.jdField_e_of_type_Float = 0.0F;
        d1 = f1 * 500.0F;
        d2 = Math.random();
        Double.isNaN(d1);
        this.jdField_f_of_type_Float = ((float)(d1 * d2));
      }
      return 0L;
    }
    Object localObject = a(this.jdField_b_of_type_Long);
    if (localObject != null)
    {
      localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a((View)localObject);
      if (localViewHolder != null)
      {
        this.jdField_g_of_type_Int = this.i;
        this.h = this.j;
        this.jdField_b_of_type_Int = 4;
        this.jdField_c_of_type_Long = l1;
        this.jdField_d_of_type_Long = 0L;
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
        this.jdField_b_of_type_Long = localViewHolder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.uniseq;
        this.jdField_f_of_type_Float = ((float)-((Math.random() - 1.0D) * 300.0D + 750.0D) * jdField_a_of_type_Float);
        this.jdField_f_of_type_Int = (localViewHolder.jdField_a_of_type_AndroidViewView.getTop() + ((BaseChatItemLayout)localObject).getTop() + BaseChatItemLayout.h - this.jdField_a_of_type_ComTencentWidgetListView.getScrollY() - this.h);
        f1 = this.jdField_f_of_type_Float;
        d1 = Math.sqrt(f1 * f1 + jdField_d_of_type_Float * 2.0F * this.jdField_f_of_type_Int);
        d2 = this.jdField_f_of_type_Float;
        Double.isNaN(d2);
        double d3 = jdField_d_of_type_Float;
        Double.isNaN(d3);
        d1 = (d1 - d2) / d3;
        this.jdField_e_of_type_Int = (a(this.i, localViewHolder) - this.i);
        d2 = this.jdField_e_of_type_Int;
        Double.isNaN(d2);
        this.jdField_e_of_type_Float = ((float)(d2 / d1));
        return 0L;
      }
    }
    this.jdField_g_of_type_Int = this.i;
    this.h = this.j;
    this.jdField_b_of_type_Int = 5;
    this.jdField_c_of_type_Long = l1;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_e_of_type_Int = 0;
    this.jdField_f_of_type_Int = 0;
    this.jdField_e_of_type_Float = ((float)(Math.random() * 400.0D - 100.0D));
    this.jdField_f_of_type_Float = ((float)-((Math.random() - 1.0D) * 300.0D + 750.0D) * jdField_a_of_type_Float);
    return 0L;
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
        return;
      }
      this.jdField_a_of_type_AndroidViewView.setScaleY(1.0F);
      this.jdField_a_of_type_AndroidViewView.setScaleX(1.0F);
    }
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int k;
      if (paramBoolean)
      {
        k = this.jdField_b_of_type_Int;
        int m;
        BaseBubbleBuilder.ViewHolder localViewHolder;
        int n;
        int i1;
        int i2;
        if ((k != 1) && (k != 2) && (k != 3))
        {
          if (k == 4)
          {
            k = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
            m = AIOUtils.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
            if ((k >= this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()) && (k <= this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()))
            {
              localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, k));
              if (localViewHolder != null)
              {
                m = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                n = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop();
                i1 = BaseChatItemLayout.h;
                i2 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
                k = this.h;
                m = m + n + i1 - i2 - (this.jdField_f_of_type_Int + k);
                if (m != 0)
                {
                  this.h = (k + m);
                  this.j += m;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
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
                m = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
                n = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop();
                i1 = BaseChatItemLayout.h;
                i2 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
                k = this.h;
                m = m + n + i1 - i2 - (this.jdField_f_of_type_Int + k);
                if (m != 0)
                {
                  this.h = (k + m);
                  this.j += m;
                  this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
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
        else
        {
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
            localViewHolder = (BaseBubbleBuilder.ViewHolder)AIOUtils.a(AIOUtils.a(this.jdField_a_of_type_ComTencentWidgetListView, k));
            if (localViewHolder != null)
            {
              m = localViewHolder.jdField_a_of_type_AndroidViewView.getTop();
              n = localViewHolder.jdField_a_of_type_ComTencentMobileqqActivityAioBaseChatItemLayout.getTop();
              i1 = BaseChatItemLayout.h;
              i2 = this.jdField_a_of_type_ComTencentWidgetListView.getScrollY();
              k = this.h;
              m = m + n + i1 - i2 - (this.jdField_f_of_type_Int + k);
              if (m != 0)
              {
                this.h = (k + m);
                this.j += m;
                this.jdField_a_of_type_AndroidViewView.offsetTopAndBottom(m);
              }
            }
            else
            {
              c();
              return false;
            }
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner != null) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        if ((this.j <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getHeight() + this.jdField_a_of_type_AndroidViewView.getHeight()) && (this.i >= -this.jdField_a_of_type_AndroidViewView.getWidth() / 2) && (this.i <= this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth() + this.jdField_a_of_type_AndroidViewView.getWidth() / 2))
        {
          if (this.j <= 0)
          {
            k = this.jdField_b_of_type_Int;
            if (k != 1)
            {
              if ((k != 2) && (k != 3) && (k != 4))
              {
                if (k != 5) {
                  return true;
                }
                a(new Object[0]);
                a(this.i, this.j, new float[0]);
                return true;
              }
              k = AIOUtils.a(this.jdField_b_of_type_Long, this.jdField_a_of_type_ComTencentWidgetListView.getAdapter());
              if ((k < this.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition()) || (k > this.jdField_a_of_type_ComTencentWidgetListView.getLastVisiblePosition()))
              {
                a(new Object[0]);
                a(this.i, this.j, new float[0]);
              }
            }
          }
          return true;
        }
        c();
        return false;
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidViewView = null;
      return false;
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
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)paramVarArgs[0]);
      localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (localObject == null) {
        return false;
      }
      localObject = ((Drawable)localObject).getBounds();
      this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentWidgetListView.getContext());
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.jdField_a_of_type_AndroidViewView, -1, AIOAnimationConatiner.a, false);
      if (((Rect)localObject).isEmpty()) {
        this.jdField_a_of_type_AndroidViewView.layout(-this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth(), -this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight(), 0, 0);
      } else {
        this.jdField_a_of_type_AndroidViewView.layout(-((Rect)localObject).width(), -((Rect)localObject).height(), 0, 0);
      }
      if (VersionUtils.e())
      {
        localObject = this.jdField_a_of_type_AndroidViewView;
        ((View)localObject).setPivotX(((View)localObject).getWidth() / 2);
        localObject = this.jdField_a_of_type_AndroidViewView;
        ((View)localObject).setPivotY(((View)localObject).getHeight());
        this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
      }
    }
    else
    {
      ((View)localObject).offsetLeftAndRight(-((View)localObject).getRight());
      localObject = this.jdField_a_of_type_AndroidViewView;
      ((View)localObject).offsetTopAndBottom(-((View)localObject).getBottom());
    }
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Boolean = true;
    if (paramVarArgs.length > 1) {
      localObject = paramVarArgs[1];
    } else {
      localObject = Integer.valueOf(0);
    }
    int k = ((Integer)localObject).intValue();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("start floor jumper. delay: ");
      ((StringBuilder)localObject).append(k);
      QLog.d("eggs", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_c_of_type_Long = (AnimationUtils.currentAnimationTimeMillis() + k);
    this.jdField_b_of_type_Int = 1;
    a(paramVarArgs);
    return true;
  }
  
  protected void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.FloorJumper
 * JD-Core Version:    0.7.0.1
 */