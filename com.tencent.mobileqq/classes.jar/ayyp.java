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

public class ayyp
{
  private aymg jdField_a_of_type_Aymg;
  private bgpj jdField_a_of_type_Bgpj;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardMoreInfoView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, View> b;
  
  public <T extends View> T a(String paramString)
  {
    if (this.jdField_a_of_type_Bgpj == null) {
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
    this.jdField_a_of_type_Bgpj = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.b = null;
  }
  
  public void a(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    if (this.jdField_a_of_type_Bgpj != null) {
      if (!(this.jdField_a_of_type_Bgpj instanceof bgpp)) {
        break label33;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bgpj.a(null, paramTextView, paramView1, paramImageView, paramView3, paramView4);
      return;
      label33:
      paramView3 = paramView2;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, aymg paramaymg, Runnable paramRunnable)
  {
    if ((paramBaseActivity == null) || (paramaymg == null) || (!aymn.a(paramaymg.jdField_a_of_type_Long)) || (TextUtils.isEmpty(paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo)))
    {
      if ((this.jdField_a_of_type_Bgpj != null) && (paramRunnable != null)) {
        paramRunnable.run();
      }
      this.jdField_a_of_type_Bgpj = null;
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo))
      {
        this.jdField_a_of_type_Aymg = paramaymg;
        this.jdField_a_of_type_JavaLangString = paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo;
        try
        {
          this.jdField_a_of_type_Bgpj = bgpn.a(paramBaseActivity, paramaymg.jdField_a_of_type_Ayxo.a(), paramaymg, paramaymg.jdField_a_of_type_Ayxo.a());
          if (this.b != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
            this.jdField_a_of_type_Bgpj.a(this.b);
            this.jdField_a_of_type_Bgpj.b(this.b);
            this.jdField_a_of_type_Bgpj.a(this.b, paramaymg.jdField_a_of_type_ComTencentMobileqqDataCard);
            this.jdField_a_of_type_Bgpj.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg);
            this.jdField_a_of_type_Bgpj.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg);
            this.jdField_a_of_type_Bgpj.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaymg, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c);
            QLog.i("DiyMoreInfoViewHelper", 1, "initDiyTemplate sucess");
            return;
          }
        }
        catch (Exception paramBaseActivity)
        {
          QLog.e("ProfileCardMoreInfoView", 1, new RuntimeException("diy info is illegal :" + paramBaseActivity), new Object[0]);
          this.jdField_a_of_type_Bgpj = null;
        }
      }
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
    if (this.jdField_a_of_type_Bgpj == null) {
      return;
    }
    this.jdField_a_of_type_Bgpj.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  public void a(String paramString, HashMap<String, View> paramHashMap)
  {
    if (this.jdField_a_of_type_Bgpj == null) {
      return;
    }
    this.jdField_a_of_type_Bgpj.a(this.b, paramString, paramHashMap);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Bgpj == null) {
      return false;
    }
    return this.jdField_a_of_type_Bgpj.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyp
 * JD-Core Version:    0.7.0.1
 */