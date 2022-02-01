import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.dinifly.OnCompositionLoadedListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;

public class aylm
{
  static final String jdField_a_of_type_JavaLangString = aost.jdField_a_of_type_JavaLangString + "_Guide";
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aylp jdField_a_of_type_Aylp;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  boolean jdField_a_of_type_Boolean = false;
  
  public aylm(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381273));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381274));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidAppActivity.findViewById(2131381272));
  }
  
  private boolean a()
  {
    return (this.jdField_a_of_type_Aylp == null) || ((this.jdField_a_of_type_Aylp != null) && (!this.jdField_a_of_type_Aylp.a()));
  }
  
  public void a(int paramInt)
  {
    int i = 1;
    if (a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "showText, isDestroyed, textIndex[" + paramInt + "]");
      return;
    }
    if (this.jdField_a_of_type_Aylp == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "showText, mPromotionRes为null, textIndex[" + paramInt + "]");
      return;
    }
    Object localObject = this.jdField_a_of_type_Aylp.a();
    if (localObject != null)
    {
      localObject = ((aosj)localObject).a(paramInt);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      }
    }
    for (paramInt = i;; paramInt = 0)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (paramInt != 0) {}
      for (i = 0;; i = 8)
      {
        ((TextView)localObject).setVisibility(i);
        if (paramInt == 0) {
          break;
        }
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(this.jdField_a_of_type_AndroidWidgetImageView.getVisibility());
      return;
    }
  }
  
  public void a(aosj paramaosj)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "loadRes, hadLoad[" + this.jdField_a_of_type_Boolean + "]");
    if (a()) {}
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    Object localObject = this.jdField_a_of_type_AndroidAppActivity.getResources();
    int i = ((Resources)localObject).getDisplayMetrics().densityDpi;
    int j = ((Resources)localObject).getDisplayMetrics().densityDpi;
    localObject = aosp.b(paramaosj);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "PromotionGuide, path is null");
      return;
    }
    if (!new File((String)localObject).exists())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "PromotionGuide, file not exist");
      return;
    }
    paramaosj = (String)localObject + "guide.json";
    localObject = new ayln(this, (String)localObject, i, j);
    try
    {
      LottieComposition.Factory.fromInputStream(this.jdField_a_of_type_AndroidAppActivity, new FileInputStream(paramaosj), (OnCompositionLoadedListener)localObject);
      return;
    }
    catch (Exception paramaosj)
    {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "loadWorldCupGuideAnimation failed. err = " + paramaosj.getMessage());
    }
  }
  
  public void a(aylp paramaylp)
  {
    this.jdField_a_of_type_Aylp = paramaylp;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidAppActivity = null;
    if (this.jdField_a_of_type_AndroidWidgetImageView != null) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.cancelAnimation();
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ImageView localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageView.setVisibility(i);
      if (!paramBoolean) {
        break;
      }
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(this.jdField_a_of_type_AndroidWidgetTextView.getVisibility());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylm
 * JD-Core Version:    0.7.0.1
 */