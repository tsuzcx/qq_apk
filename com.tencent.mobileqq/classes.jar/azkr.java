import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.profilecard.base.view.ProfileContentTitleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.util.concurrent.ConcurrentHashMap;

public abstract class azkr
  extends azkq<View>
{
  protected azkz a;
  protected azqi a;
  protected biab a;
  
  public azkr(azlw paramazlw, azfe paramazfe)
  {
    super(paramazlw, paramazfe);
  }
  
  private void a(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5, azfl paramazfl)
  {
    azfl.a(paramView1, "background", paramazfl, "commonItemTopBorderBackground");
    azfl.a(paramTextView, "color", paramazfl, "commonItemContentColor");
    azfl.a(paramView2, "color", paramazfl, "commonItemContentColor");
    azfl.a(paramImageView, "src", paramazfl, "commonItemMoreSrc");
    if (paramImageView != null)
    {
      paramView1 = paramImageView.getLayoutParams();
      paramView1.width = -2;
      paramView1.height = -2;
      paramImageView.setLayoutParams(paramView1);
    }
    if (paramView3 != null)
    {
      paramView3.setBackgroundResource(0);
      paramView3.setVisibility(8);
    }
    if (paramView4 != null) {
      paramView4.setBackgroundResource(0);
    }
    if (paramView5 != null) {
      paramView5.setBackgroundResource(0);
    }
  }
  
  private void b(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839434);
    }
    this.jdField_a_of_type_Azqi.a(paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  private void c(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839434);
    }
    if (paramTextView != null) {
      paramTextView.setTextColor(localResources.getColorStateList(2131166986));
    }
    if ((paramView2 instanceof TextView)) {
      ((TextView)paramView2).setTextColor(localResources.getColorStateList(2131167060));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130839273);
        paramView1 = paramImageView.getLayoutParams();
        paramView1.width = -2;
        paramView1.height = -2;
        paramImageView.setLayoutParams(paramView1);
      }
      if (paramView3 != null)
      {
        paramView3.setBackgroundResource(0);
        paramView3.setVisibility(8);
      }
      if (paramView4 != null) {
        paramView4.setBackgroundResource(0);
      }
      if (paramView5 != null) {
        paramView5.setBackgroundResource(0);
      }
      return;
      if ((paramView2 instanceof SingleLineTextView)) {
        ((SingleLineTextView)paramView2).setTextColor(localResources.getColorStateList(2131167060));
      }
    }
  }
  
  protected void a(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView)
  {
    a(paramView1, paramTextView, paramView2, paramImageView, null, null, null);
  }
  
  protected void a(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    try
    {
      azfl localazfl = ((azfe)this.b).jdField_a_of_type_Azfl;
      if ((localazfl != null) && (localazfl.a != null) && (!localazfl.a.isEmpty()))
      {
        a(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5, localazfl);
        return;
      }
      if (azfl.a(((azfe)this.b).jdField_a_of_type_Long))
      {
        b(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
        return;
      }
    }
    catch (Exception paramView1)
    {
      QLog.e("AbsProfileContentComponent", 1, "updateItemTheme fail.", paramView1);
      return;
    }
    c(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  protected void a(TextView paramTextView, View paramView)
  {
    a(null, paramTextView, paramView, null, null, null, null);
  }
  
  protected void a(TextView paramTextView, View paramView, ImageView paramImageView)
  {
    a(null, paramTextView, paramView, paramImageView, null, null, null);
  }
  
  public void a(azkz paramazkz, biab parambiab, azqi paramazqi)
  {
    this.jdField_a_of_type_Azkz = paramazkz;
    this.jdField_a_of_type_Biab = parambiab;
    this.jdField_a_of_type_Azqi = paramazqi;
  }
  
  protected void a(ProfileContentTitleView paramProfileContentTitleView, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (FrameLayout localFrameLayout = paramProfileContentTitleView.jdField_a_of_type_AndroidWidgetFrameLayout;; localFrameLayout = null)
    {
      a(paramProfileContentTitleView.jdField_b_of_type_AndroidViewViewGroup, paramProfileContentTitleView.jdField_a_of_type_AndroidWidgetTextView, null, paramProfileContentTitleView.jdField_b_of_type_AndroidWidgetImageView, paramProfileContentTitleView.jdField_a_of_type_AndroidWidgetImageView, paramProfileContentTitleView.c, localFrameLayout);
      return;
    }
  }
  
  public abstract String a_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azkr
 * JD-Core Version:    0.7.0.1
 */