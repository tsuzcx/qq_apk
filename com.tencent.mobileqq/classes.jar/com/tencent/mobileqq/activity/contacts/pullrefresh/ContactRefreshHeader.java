package com.tencent.mobileqq.activity.contacts.pullrefresh;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.IPullRefreshHeader;

public class ContactRefreshHeader
  extends RelativeLayout
  implements SwipeRefreshTrigger, SwipeTrigger, IPullRefreshHeader
{
  private int jdField_a_of_type_Int = 0;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private RotateAnimation jdField_a_of_type_AndroidViewAnimationRotateAnimation;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ContactRefreshHeader.OnRefreshHeaderUpdateListener jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader$OnRefreshHeaderUpdateListener;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private RotateAnimation jdField_b_of_type_AndroidViewAnimationRotateAnimation;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  private int g = 0;
  private int h;
  
  public ContactRefreshHeader(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ContactRefreshHeader(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(0.0F, 180.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_a_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setDuration(100L);
    this.jdField_b_of_type_AndroidViewAnimationRotateAnimation.setFillAfter(true);
    this.h = getResources().getDimensionPixelOffset(2131298921);
  }
  
  @TargetApi(17)
  public static void a(RelativeLayout.LayoutParams paramLayoutParams, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramLayoutParams.removeRule(paramInt);
      return;
    }
    paramLayoutParams.addRule(12, 0);
  }
  
  private long b()
  {
    ContactRefreshHeader.OnRefreshHeaderUpdateListener localOnRefreshHeaderUpdateListener = this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader$OnRefreshHeaderUpdateListener;
    if (localOnRefreshHeaderUpdateListener != null) {
      return localOnRefreshHeaderUpdateListener.a();
    }
    return 0L;
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 0) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramInt);
    }
  }
  
  private void d(long paramLong)
  {
    if (paramLong != 0L)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("%s%s", new Object[] { this.jdField_a_of_type_AndroidContentContext.getString(2131719248), TimeFormatterUtils.a(paramLong, true, "yyyy-MM-dd") }));
      int i = this.f;
      if (i >= 0) {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(i);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
  }
  
  private void g()
  {
    Object localObject = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localObject == null) {
      return;
    }
    localObject = (RelativeLayout.LayoutParams)((RelativeLayout)localObject).getLayoutParams();
    if (this.jdField_a_of_type_Int == 0)
    {
      a((RelativeLayout.LayoutParams)localObject, 10);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
    }
    else
    {
      a((RelativeLayout.LayoutParams)localObject, 12);
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    return this;
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable;
    String str;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          localDrawable = null;
          str = "";
        }
        else
        {
          localDrawable = getResources().getDrawable(2130849865);
          str = getResources().getString(2131719247);
        }
      }
      else
      {
        localDrawable = getResources().getDrawable(2130849864);
        str = getResources().getString(2131719247);
      }
    }
    else
    {
      localDrawable = getResources().getDrawable(2130849866);
      str = getResources().getString(2131719253);
    }
    Object localObject = str;
    if (localDrawable != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(str);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    b(this.e);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    Drawable localDrawable;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localDrawable = null;
        } else {
          localDrawable = getResources().getDrawable(2130849865);
        }
      }
      else {
        localDrawable = getResources().getDrawable(2130849864);
      }
    }
    else {
      localDrawable = getResources().getDrawable(2130849866);
    }
    Object localObject = paramString;
    if (localDrawable != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidWidgetTextView.getTextSize() + 2;
      localDrawable.setBounds(0, 0, paramInt, paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[O]");
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramString);
      localObject = new SpannableString(((StringBuilder)localObject).toString());
      ((SpannableString)localObject).setSpan(new ImageSpan(localDrawable, 0), 0, 3, 17);
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    b(this.e);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (!this.jdField_b_of_type_Boolean))
    {
      int i = this.h;
      if (paramInt > i)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          b(b());
        }
      }
      else if ((paramInt < i) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_Boolean = true;
        c(b());
      }
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719249);
      b(this.d);
      label18:
      d(paramLong);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      return;
    }
    catch (Exception localException)
    {
      break label18;
    }
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      a(0L);
    }
  }
  
  public void b(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.jdField_a_of_type_AndroidViewAnimationRotateAnimation);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719252);
    b(this.c);
    d(paramLong);
  }
  
  public void c() {}
  
  public void c(long paramLong)
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.g == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849862);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839429);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719250);
    }
    else
    {
      if (this.g == 0) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849863);
      } else {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839430);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719251);
    }
    b(this.jdField_b_of_type_Int);
    d(paramLong);
  }
  
  public void d()
  {
    if (!this.jdField_b_of_type_Boolean) {
      e();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetTextView.setText(2131719250);
    this.jdField_a_of_type_AndroidWidgetImageView.clearAnimation();
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void f()
  {
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null)
    {
      localProgressBar.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365169));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131376345));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376342));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376344));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131376350));
    if (this.jdField_a_of_type_Int != 0) {
      g();
    }
    if (this.g != 0) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839431);
    }
    c(0L);
  }
  
  public void setHeaderBgColor(int paramInt)
  {
    setBackgroundColor(paramInt);
  }
  
  @TargetApi(16)
  public void setHeaderBgDrawable(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      setBackground(paramDrawable);
      return;
    }
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setHeaderBgRes(int paramInt)
  {
    setBackgroundResource(paramInt);
  }
  
  public void setPullType(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      g();
    }
  }
  
  public void setRefresh(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setRefreshHeaderUpdateListener(ContactRefreshHeader.OnRefreshHeaderUpdateListener paramOnRefreshHeaderUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsPullrefreshContactRefreshHeader$OnRefreshHeaderUpdateListener = paramOnRefreshHeaderUpdateListener;
  }
  
  public void setTextColor(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = paramInt4;
    this.f = paramInt5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader
 * JD-Core Version:    0.7.0.1
 */