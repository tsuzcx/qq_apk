import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime.Status;

public class azho
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DiniFlyAnimationView jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public azho(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public static void a(View paramView, boolean paramBoolean1, TextView paramTextView, boolean paramBoolean2)
  {
    boolean bool = ThemeUtil.isNowThemeIsNight(null, false, "");
    paramView.setSelected(paramBoolean1);
    int i;
    String str;
    if (paramBoolean2)
    {
      i = 2130839431;
      if (bool) {
        i = 2130839429;
      }
      paramView.setBackgroundResource(i);
      if (paramTextView != null)
      {
        if (!bool) {
          break label71;
        }
        str = "#FFFFFF";
      }
    }
    for (;;)
    {
      paramTextView.setTextColor(Color.parseColor(str));
      paramView.invalidate();
      return;
      i = 2130839430;
      break;
      label71:
      if (paramBoolean1) {
        str = "#FFFFFF";
      } else {
        str = "#03081A";
      }
    }
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public void a()
  {
    this.c = false;
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating()) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.stop();
    }
    this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.setFrame(0);
  }
  
  public void a(Activity paramActivity)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView == null) || (paramActivity == null)) {
      return;
    }
    if (bhxt.a().a()) {
      if (this.jdField_b_of_type_AndroidViewView != null) {
        if (this.jdField_b_of_type_AndroidViewView.getVisibility() != 0) {
          break label131;
        }
      }
    }
    label131:
    for (int i = 9;; i = 0)
    {
      paramActivity = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramActivity.leftMargin = agej.a(i, localView.getResources());
      localView.setLayoutParams(paramActivity);
      localView.setVisibility(0);
      paramActivity = (ImageView)localView.findViewById(2131369851);
      paramActivity.setImageDrawable(paramActivity.getResources().getDrawable(2130837544));
      paramActivity = (TextView)localView.findViewById(2131369875);
      paramActivity.setText(2131691164);
      a(localView, false, paramActivity, this.jdField_a_of_type_Boolean);
      return;
      localView.setVisibility(8);
      return;
    }
  }
  
  public void a(Context paramContext, ViewGroup paramViewGroup, int paramInt)
  {
    paramContext = View.inflate(paramContext, 2131558431, null);
    this.jdField_a_of_type_AndroidViewView = paramContext.findViewById(2131365243);
    this.jdField_b_of_type_AndroidViewView = paramContext.findViewById(2131365241);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView = ((DiniFlyAnimationView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369853));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369851));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = agej.a(9.0F, paramViewGroup.getResources());
    localLayoutParams.leftMargin = agej.a(14.0F, paramViewGroup.getResources());
    localLayoutParams.rightMargin = localLayoutParams.leftMargin;
    paramViewGroup.addView(paramContext, paramInt, localLayoutParams);
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new mve());
    this.jdField_b_of_type_AndroidViewView.setOnTouchListener(new mve());
    if (this.jdField_b_of_type_Boolean) {
      naw.a(BaseApplicationImpl.getContext(), "online_status_smart/data.json", "online_status_smart/images/", 24, 34, -1, new azhp(this));
    }
  }
  
  public void a(azib paramazib)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    a();
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(8);
    if (!TextUtils.isEmpty(paramazib.b))
    {
      int i = agej.a(24.0F, this.jdField_a_of_type_AndroidWidgetImageView.getResources());
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = i;
      localURLDrawableOptions.mRequestHeight = i;
      paramazib = URLDrawable.getDrawable(paramazib.b, localURLDrawableOptions);
      if (paramazib != null)
      {
        paramazib.setBounds(0, 0, i, i);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramazib);
      }
    }
  }
  
  public void a(BaseActivity paramBaseActivity, AppRuntime.Status paramStatus, long paramLong)
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if ((localView == null) || (paramBaseActivity == null) || (paramStatus == null)) {
      return;
    }
    if (!azin.a())
    {
      localView.setVisibility(8);
      a();
      return;
    }
    azib localazib = ((arfp)aran.a().a(652)).a.a;
    localView.setVisibility(0);
    TextView localTextView = (TextView)localView.findViewById(2131369875);
    if (localazib.a == null)
    {
      paramBaseActivity = "";
      localTextView.setText(paramBaseActivity);
      if (!a(paramStatus, paramLong)) {
        a(localazib);
      }
      paramBaseActivity = azhq.a().a(AppRuntime.Status.online, 40001L);
      if ((!azib.a(paramStatus, paramLong)) || (!azin.b(paramBaseActivity))) {
        break label162;
      }
    }
    label162:
    for (boolean bool = true;; bool = false)
    {
      a(localView, bool, localTextView, this.jdField_a_of_type_Boolean);
      return;
      paramBaseActivity = localazib.a;
      break;
    }
  }
  
  public boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni mUseLottiAni=", Boolean.valueOf(this.jdField_b_of_type_Boolean) });
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("OnLineStatusCustomSmartViewCtrl", 4, new Object[] { " showLottiAni onlineStatus=", paramStatus, " extStatus=", Long.valueOf(paramLong) });
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqDiniflyDiniFlyAnimationView.setVisibility(0);
    if ((paramStatus == AppRuntime.Status.online) && (paramLong == 40001L)) {
      b();
    }
    for (;;)
    {
      return true;
      a();
    }
  }
  
  public View b()
  {
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public void b()
  {
    this.c = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) && (!this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.isAnimating())) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azho
 * JD-Core Version:    0.7.0.1
 */