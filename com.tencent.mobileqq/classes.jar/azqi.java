import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class azqi
{
  private azfe jdField_a_of_type_Azfe;
  private bhil jdField_a_of_type_Bhil;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardMoreInfoView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, View> b;
  
  public <T extends View> T a(String paramString)
  {
    if (this.jdField_a_of_type_Bhil == null) {
      return null;
    }
    return (View)this.b.get(paramString);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_Bhil = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.b = null;
  }
  
  public void a(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    if (this.jdField_a_of_type_Bhil != null) {
      if (!(this.jdField_a_of_type_Bhil instanceof bhir)) {
        break label33;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhil.a(null, paramTextView, paramView1, paramImageView, paramView3, paramView4);
      return;
      label33:
      paramView3 = paramView2;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, azfe paramazfe, Runnable paramRunnable)
  {
    if ((paramBaseActivity == null) || (paramazfe == null) || (!azfl.a(paramazfe.jdField_a_of_type_Long)) || (TextUtils.isEmpty(paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo)))
    {
      if ((this.jdField_a_of_type_Bhil != null) && (paramRunnable != null)) {
        paramRunnable.run();
      }
      this.jdField_a_of_type_Bhil = null;
    }
    while (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo)) {
      return;
    }
    this.jdField_a_of_type_Azfe = paramazfe;
    this.jdField_a_of_type_JavaLangString = paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo;
    try
    {
      this.jdField_a_of_type_Bhil = bhip.a(paramBaseActivity, paramazfe.jdField_a_of_type_Azph.a(), paramazfe, paramazfe.jdField_a_of_type_Azph.a());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
      this.jdField_a_of_type_Bhil.a(this.b);
      this.jdField_a_of_type_Bhil.b(this.b);
      this.jdField_a_of_type_Bhil.a(this.b, paramazfe.jdField_a_of_type_ComTencentMobileqqDataCard);
      this.jdField_a_of_type_Bhil.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe);
      this.jdField_a_of_type_Bhil.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe);
      this.jdField_a_of_type_Bhil.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazfe, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c);
      QLog.i("DiyMoreInfoViewHelper", 1, "initDiyTemplate sucess");
      return;
    }
    catch (Exception paramBaseActivity)
    {
      QLog.e("ProfileCardMoreInfoView", 1, new RuntimeException("diy info is illegal :" + paramBaseActivity), new Object[0]);
      this.jdField_a_of_type_Bhil = null;
    }
  }
  
  public void a(ProfileCardMoreInfoView paramProfileCardMoreInfoView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = paramProfileCardMoreInfoView;
    this.jdField_a_of_type_JavaUtilHashMap = paramProfileCardMoreInfoView.a();
    this.b = new HashMap();
  }
  
  public void a(String paramString, TextView paramTextView, View paramView, ImageView paramImageView)
  {
    if (this.jdField_a_of_type_Bhil == null) {
      return;
    }
    this.jdField_a_of_type_Bhil.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  public void a(String paramString, HashMap<String, View> paramHashMap)
  {
    if (this.jdField_a_of_type_Bhil == null) {
      return;
    }
    this.jdField_a_of_type_Bhil.a(this.b, paramString, paramHashMap);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Bhil == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhil.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqi
 * JD-Core Version:    0.7.0.1
 */