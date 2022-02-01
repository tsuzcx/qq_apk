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

public abstract class azwo
  extends azwn<View>
{
  protected azww a;
  protected baea a;
  protected birs a;
  
  public azwo(azxt paramazxt, azrb paramazrb)
  {
    super(paramazxt, paramazrb);
  }
  
  private void a(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5, azri paramazri)
  {
    azri.a(paramView1, "background", paramazri, "commonItemTopBorderBackground");
    azri.a(paramTextView, "color", paramazri, "commonItemContentColor");
    azri.a(paramView2, "color", paramazri, "commonItemContentColor");
    azri.a(paramImageView, "src", paramazri, "commonItemMoreSrc");
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
      paramView1.setBackgroundResource(2130839498);
    }
    this.jdField_a_of_type_Baea.a(paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5);
  }
  
  private void c(View paramView1, TextView paramTextView, View paramView2, ImageView paramImageView, View paramView3, View paramView4, View paramView5)
  {
    Resources localResources = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources();
    if (paramView1 != null) {
      paramView1.setBackgroundResource(2130839498);
    }
    if (paramTextView != null) {
      paramTextView.setTextColor(localResources.getColorStateList(2131167026));
    }
    if ((paramView2 instanceof TextView)) {
      ((TextView)paramView2).setTextColor(localResources.getColorStateList(2131167106));
    }
    for (;;)
    {
      if (paramImageView != null)
      {
        paramImageView.setImageResource(2130839337);
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
        ((SingleLineTextView)paramView2).setTextColor(localResources.getColorStateList(2131167106));
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
      azri localazri = ((azrb)this.b).jdField_a_of_type_Azri;
      if ((localazri != null) && (localazri.a != null) && (!localazri.a.isEmpty()))
      {
        a(paramView1, paramTextView, paramView2, paramImageView, paramView3, paramView4, paramView5, localazri);
        return;
      }
      if (azri.a(((azrb)this.b).jdField_a_of_type_Long))
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
  
  public void a(azww paramazww, birs parambirs, baea parambaea)
  {
    this.jdField_a_of_type_Azww = paramazww;
    this.jdField_a_of_type_Birs = parambirs;
    this.jdField_a_of_type_Baea = parambaea;
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
 * Qualified Name:     azwo
 * JD-Core Version:    0.7.0.1
 */