package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FeedUtils;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar;
import dov.com.tencent.biz.qqstory.takevideo.interact.RateWidgetRatingBar.OnRatingChangeListener;
import java.text.DecimalFormat;
import ovt;
import ovu;

public class RateWidget
  extends InteractPasterWidget
  implements View.OnClickListener, RateWidgetRatingBar.OnRatingChangeListener
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131369156);
  private RateWidget.AttendViewClickListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$AttendViewClickListener;
  private RateWidget.WidgetRatingChangedListener jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$WidgetRatingChangedListener;
  private RateWidgetRatingBar jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar = (RateWidgetRatingBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131369157);
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private TextView d;
  
  public RateWidget(Context paramContext)
  {
    super(paramContext, 2130970145);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setOnRatingChangeListener(this);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_AndroidWidgetTextView.getHint().toString();
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setRating((int)paramFloat);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    if (paramInt <= 0)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0人参与");
      return;
    }
    float f = (float)paramLong * 1.0F / (paramInt * 1.0F);
    Object localObject = new DecimalFormat(".0").format(f);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
      this.jdField_d_of_type_AndroidWidgetTextView.setText("0人参与");
      return;
    }
    localObject = ((String)localObject).split("\\.");
    if (localObject.length == 1)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[0]);
      this.jdField_c_of_type_AndroidWidgetTextView.setText("0");
    }
    for (;;)
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramInt + "人参与");
      return;
      if (localObject.length == 2)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setText(localObject[0]);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(localObject[1]);
      }
    }
  }
  
  public void a(RateWidget.AttendViewClickListener paramAttendViewClickListener, boolean paramBoolean)
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$AttendViewClickListener = paramAttendViewClickListener;
      paramAttendViewClickListener = this.jdField_a_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      paramAttendViewClickListener.setVisibility(i);
      return;
    }
  }
  
  public void a(RateWidget.WidgetRatingChangedListener paramWidgetRatingChangedListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$WidgetRatingChangedListener = paramWidgetRatingChangedListener;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramArrayOfString[0]);
  }
  
  public Rect[] a()
  {
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidWidgetTextView.getHitRect(localRect);
    return new Rect[] { localRect };
  }
  
  public String[] a()
  {
    return new String[] { this.jdField_a_of_type_AndroidWidgetTextView.getText().toString() };
  }
  
  protected View b()
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidViewView.getContext()).inflate(2130970144, null).findViewById(2131369148);
    localView.setLayoutParams(new ViewGroup.LayoutParams(UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 225.0F), UIUtils.a(this.jdField_a_of_type_AndroidViewView.getContext(), 54.0F)));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369150));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369152));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369155));
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)localView.findViewById(2131369154));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131363462));
    this.jdField_b_of_type_AndroidViewViewGroup.setOnClickListener(this);
    return localView;
  }
  
  public void b(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$WidgetRatingChangedListener != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$WidgetRatingChangedListener.a(this, paramFloat);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoInteractRateWidgetRatingBar.setRatable(paramBoolean);
  }
  
  protected void c()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      return;
    }
    float f1 = this.e;
    float f2 = this.jdField_a_of_type_Float;
    float f3 = this.jdField_c_of_type_Float;
    float f4 = this.f;
    float f5 = this.jdField_a_of_type_Float;
    float f6 = this.jdField_d_of_type_Float;
    int i = this.jdField_b_of_type_AndroidViewView.getHeight();
    int j = this.jdField_b_of_type_AndroidViewView.getWidth();
    int k = this.jdField_a_of_type_AndroidViewView.getWidth();
    int m = this.jdField_a_of_type_AndroidViewView.getHeight();
    float f7 = -(m * 1.0F / 2.0F + i * 1.0F / 2.0F - UIUtils.a(this.jdField_b_of_type_AndroidViewView.getContext(), 4.0F));
    float[] arrayOfFloat = PollWidgetUtils.a(UIUtils.a(this.jdField_b_of_type_AndroidViewView.getContext(), 37.0F), f7, this.jdField_b_of_type_Float);
    f7 = arrayOfFloat[0];
    float f8 = arrayOfFloat[1];
    this.jdField_b_of_type_AndroidViewView.setX(f1 * f2 + f3 + this.g * f7 - j * 1.0F / 2.0F);
    this.jdField_b_of_type_AndroidViewView.setY(f4 * f5 + f6 + this.h * f8 - i * 1.0F / 2.0F);
    this.jdField_b_of_type_AndroidViewView.setRotation(this.jdField_b_of_type_Float);
    this.jdField_b_of_type_AndroidViewView.setScaleX(this.g);
    this.jdField_b_of_type_AndroidViewView.setScaleY(this.h);
    SLog.a("InteractPasterWidget", "relayoutAttendView %d", Integer.valueOf(this.jdField_b_of_type_AndroidViewView.hashCode()));
    SLog.b("InteractPasterWidget", "relayoutAttendView 2widgets(%d, %d, %d, %d)  stack=%s", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(j), Integer.valueOf(i), FeedUtils.a(5) });
    SLog.a("InteractPasterWidget", "relayoutAttendView offset(%.2f, %.2f, %.2f, %.2f)", Float.valueOf(this.jdField_c_of_type_Float), Float.valueOf(this.jdField_d_of_type_Float), Float.valueOf(f7), Float.valueOf(f8));
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (paramBoolean) {}
    for (int i = 2130841998;; i = 0)
    {
      localTextView.setBackgroundResource(i);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      this.jdField_c_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      while (i < 2500)
      {
        this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ovt(this), i);
        i += 500;
      }
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ovu(this), i);
      return;
    }
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    c(false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$AttendViewClickListener == null);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetRateWidget$AttendViewClickListener.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.RateWidget
 * JD-Core Version:    0.7.0.1
 */