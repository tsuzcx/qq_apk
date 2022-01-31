import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.fileviewer.viewer.VideoFileViewer.2;
import com.tencent.mobileqq.filemanager.widget.DragContainerLayout;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aron
  extends arod
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private SeekBar jdField_a_of_type_AndroidWidgetSeekBar;
  private bhvx jdField_a_of_type_Bhvx = new aros(this);
  private DragContainerLayout jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_b_of_type_Boolean;
  private View jdField_c_of_type_AndroidViewView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private boolean jdField_c_of_type_Boolean;
  private RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  
  public aron(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  private String a(long paramLong)
  {
    long l3 = paramLong / 1000L;
    paramLong = l3 / 86400L;
    long l1 = l3 % 86400L / 3600L;
    long l2 = l3 % 86400L % 3600L / 60L;
    l3 = l3 % 86400L % 3600L % 60L;
    String str2;
    String str1;
    if (paramLong > 0L)
    {
      str2 = String.format("%02d:%02d:%02d:%02d", new Object[] { Long.valueOf(paramLong), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
      if (QLog.isDevelopLevel())
      {
        QLog.d("#@#@", 1, "getTick 161 [" + str2 + "]");
        str1 = str2;
      }
    }
    do
    {
      do
      {
        return str1;
        if (l1 <= 0L) {
          break;
        }
        str2 = String.format("%02d:%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) });
        str1 = str2;
      } while (!QLog.isDevelopLevel());
      QLog.d("#@#@", 1, "getTick 167 [" + str2 + "]");
      return str2;
      str2 = String.format("%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3) });
      str1 = str2;
    } while (!QLog.isDevelopLevel());
    QLog.d("#@#@", 1, "getTick 174 [" + str2 + "]");
    return str2;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    QLog.i("FileBrowserViewBase", 4, "FileBrowserViewBase: VideoFileViewer initFileView");
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      this.jdField_a_of_type_AndroidViewView = ((LayoutInflater)BaseApplicationImpl.getContext().getSystemService("layout_inflater")).inflate(2131560700, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.e = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372217));
      this.f = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362548));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131379597));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372337));
      this.h = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375738));
      this.h.setText(alud.a(2131716654));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372336));
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetSeekBar = ((SeekBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131372109));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131372072));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370187));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131378041));
      this.g = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363021));
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131366322));
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout != null)
    {
      Rect localRect = arsx.a(this.jdField_a_of_type_AndroidAppActivity, a(), paramInt1, paramInt2);
      if (localRect != null) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setOriginRect(localRect);
      }
    }
  }
  
  public void a(long paramLong)
  {
    this.f.setText(a(paramLong));
  }
  
  @TargetApi(16)
  public void a(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT > 16)
    {
      this.jdField_c_of_type_AndroidViewView.setBackground(paramDrawable);
      return;
    }
    this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(paramDrawable);
  }
  
  public void a(SeekBar.OnSeekBarChangeListener paramOnSeekBarChangeListener)
  {
    if (paramOnSeekBarChangeListener != null) {
      this.jdField_a_of_type_AndroidWidgetSeekBar.setOnSeekBarChangeListener(paramOnSeekBarChangeListener);
    }
  }
  
  public void a(String paramString, View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.jdField_c_of_type_AndroidViewView == null)
    {
      this.jdField_c_of_type_AndroidViewView = aqxi.a(paramString).a(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_c_of_type_AndroidViewView.setId(2131379898);
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(-16777216);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      paramString.addRule(13, -1);
      this.jdField_c_of_type_AndroidViewView.setLayoutParams(paramString);
      paramString = ((ViewGroup)this.jdField_c_of_type_AndroidViewView).getChildAt(0);
      if (paramString != null) {
        paramString.addOnLayoutChangeListener(new aroo(this));
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout = new DragContainerLayout(this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setContainerLongClickListener(paramOnLongClickListener);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.addView(this.jdField_c_of_type_AndroidViewView);
      int i = this.jdField_a_of_type_AndroidAppActivity.getResources().getDisplayMetrics().widthPixels;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout.setGestureChangeListener(this.jdField_a_of_type_Bhvx);
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqFilemanagerWidgetDragContainerLayout, 0, paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).removeView(this.jdField_c_of_type_AndroidViewView);
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    localRelativeLayout.setBackgroundColor(Color.parseColor("#D8DAE0"));
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidAppActivity);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, 2130843925, 0, 0);
    localTextView.setText(paramString2);
    localTextView.setTextSize(12.0F);
    localTextView.setTextColor(Color.parseColor("#83889A"));
    localTextView.setPadding(0, 15, 0, 0);
    localRelativeLayout.addView(localTextView, -2, -2);
    ((RelativeLayout.LayoutParams)localTextView.getLayoutParams()).addRule(13);
    if (arso.b(paramString1))
    {
      paramString2 = new TextView(this.jdField_a_of_type_AndroidAppActivity);
      paramString2.setText("用QQ浏览器打开");
      paramString2.setContentDescription("用qq浏览器打开");
      paramString2.setTextSize(12.0F);
      paramString2.setTextColor(Color.parseColor("#12B7F5"));
      paramString2.setOnClickListener(new arop(this, paramString1));
      localRelativeLayout.addView(paramString2, -2, -2);
      paramString1 = (RelativeLayout.LayoutParams)paramString2.getLayoutParams();
      paramString1.addRule(13);
      paramString1.addRule(12);
      paramString1.setMargins(0, 0, 0, 40);
      paramString2.setLayoutParams(paramString1);
    }
    int i = (int)(((WindowManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("window")).getDefaultDisplay().getWidth() * 0.75D);
    ((ViewGroup)this.jdField_a_of_type_AndroidViewView).addView(localRelativeLayout, -1, i);
    ((RelativeLayout.LayoutParams)localRelativeLayout.getLayoutParams()).addRule(13);
    b(false);
    this.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.e.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetSeekBar.setVisibility(4);
    this.f.setVisibility(4);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundDrawable(null);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new aroq(this));
  }
  
  public View b()
  {
    return this.jdField_c_of_type_AndroidViewView;
  }
  
  public void b(long paramLong)
  {
    this.e.setText(a(paramLong));
  }
  
  public void b(View.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      this.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.h.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean)) {}
    for (boolean bool = true;; bool = false)
    {
      super.b(bool);
      this.jdField_c_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public void c()
  {
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeAllViews();
    }
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setProgress(paramInt);
  }
  
  public void c(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.h != null)
    {
      localTextView = this.h;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  @TargetApi(11)
  public void d()
  {
    if (Build.VERSION.SDK_INT >= 11)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { 1.0F, 0.3F });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(2500L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new aror(this));
    }
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetSeekBar.setMax(paramInt);
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845325);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691183));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130845323);
    this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_AndroidAppActivity.getString(2131691186));
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_AndroidWidgetLinearLayout.getVisibility() == 0) && (Build.VERSION.SDK_INT >= 11))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  public void e(boolean paramBoolean)
  {
    TextView localTextView;
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      localTextView = this.jdField_d_of_type_AndroidWidgetTextView;
      if (!paramBoolean) {
        break label24;
      }
    }
    label24:
    for (int i = 0;; i = 4)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.clearAnimation();
    if (Build.VERSION.SDK_INT > 11) {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(1.0F);
    }
  }
  
  public void f(boolean paramBoolean)
  {
    int j = 0;
    LinearLayout localLinearLayout;
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      i = 1;
      localLinearLayout = this.jdField_a_of_type_AndroidWidgetLinearLayout;
      if (i == 0) {
        break label44;
      }
    }
    label44:
    for (int i = j;; i = 8)
    {
      localLinearLayout.setVisibility(i);
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    int j = 0;
    RelativeLayout localRelativeLayout;
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      i = 1;
      localRelativeLayout = this.jdField_b_of_type_AndroidWidgetRelativeLayout;
      if (i == 0) {
        break label44;
      }
    }
    label44:
    for (int i = j;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      this.jdField_b_of_type_Boolean = paramBoolean;
      return;
      i = 0;
      break;
    }
  }
  
  public void h(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
      localRotateAnimation.setDuration(500L);
      localRotateAnimation.setRepeatCount(-1);
      localRotateAnimation.setRepeatMode(1);
      localRotateAnimation.setStartTime(-1L);
      localRotateAnimation.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(localRotateAnimation);
      return;
    }
    this.jdField_a_of_type_AndroidAppActivity.runOnUiThread(new VideoFileViewer.2(this));
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      float f3;
      float f4;
      do
      {
        for (;;)
        {
          return false;
          this.jdField_a_of_type_Float = f1;
          this.jdField_b_of_type_Float = f2;
        }
        f3 = Math.abs(f1 - this.jdField_a_of_type_Float);
        f4 = Math.abs(f2 - this.jdField_b_of_type_Float);
        QLog.i("FileBrowserViewBase", 1, "absX[" + f3 + "] --- absY[" + f4 + "]，mPressDownY[" + this.jdField_b_of_type_Float + "]，currTouchY【" + f2 + "】");
      } while (f3 <= f4);
      if (f1 - this.jdField_a_of_type_Float > 20.0F)
      {
        QLog.i("FileBrowserViewBase", 1, "<--  左滑");
        return true;
      }
    } while (f1 - this.jdField_a_of_type_Float >= -20.0F);
    QLog.i("FileBrowserViewBase", 1, "-->  右滑");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aron
 * JD-Core Version:    0.7.0.1
 */