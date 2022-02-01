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

public class baea
{
  private azrb jdField_a_of_type_Azrb;
  private bhzt jdField_a_of_type_Bhzt;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ProfileCardMoreInfoView jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView;
  private String jdField_a_of_type_JavaLangString;
  private HashMap<String, View> jdField_a_of_type_JavaUtilHashMap;
  private HashMap<String, View> b;
  
  public <T extends View> T a(String paramString)
  {
    if (this.jdField_a_of_type_Bhzt == null) {
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
    this.jdField_a_of_type_Bhzt = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView = null;
    this.jdField_a_of_type_JavaUtilHashMap = null;
    this.b = null;
  }
  
  public void a(TextView paramTextView, View paramView1, ImageView paramImageView, View paramView2, View paramView3, View paramView4)
  {
    if (this.jdField_a_of_type_Bhzt != null) {
      if (!(this.jdField_a_of_type_Bhzt instanceof bhzz)) {
        break label33;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhzt.a(null, paramTextView, paramView1, paramImageView, paramView3, paramView4);
      return;
      label33:
      paramView3 = paramView2;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, azrb paramazrb, Runnable paramRunnable)
  {
    if ((paramBaseActivity == null) || (paramazrb == null) || (!azri.a(paramazrb.jdField_a_of_type_Long)) || (TextUtils.isEmpty(paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo)))
    {
      if ((this.jdField_a_of_type_Bhzt != null) && (paramRunnable != null)) {
        paramRunnable.run();
      }
      this.jdField_a_of_type_Bhzt = null;
    }
    for (;;)
    {
      return;
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo))
      {
        this.jdField_a_of_type_Azrb = paramazrb;
        this.jdField_a_of_type_JavaLangString = paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard.diyComplicatedInfo;
        try
        {
          this.jdField_a_of_type_Bhzt = bhzx.a(paramBaseActivity, paramazrb.jdField_a_of_type_Bacz.a(), paramazrb, paramazrb.jdField_a_of_type_Bacz.a());
          if (this.b != null)
          {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramBaseActivity.app;
            this.jdField_a_of_type_Bhzt.a(this.b);
            this.jdField_a_of_type_Bhzt.b(this.b);
            this.jdField_a_of_type_Bhzt.a(this.b, paramazrb.jdField_a_of_type_ComTencentMobileqqDataCard);
            this.jdField_a_of_type_Bhzt.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb);
            this.jdField_a_of_type_Bhzt.b(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb);
            this.jdField_a_of_type_Bhzt.a(this.b, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramazrb, this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c);
            QLog.i("DiyMoreInfoViewHelper", 1, "initDiyTemplate sucess");
            return;
          }
        }
        catch (Exception paramBaseActivity)
        {
          QLog.e("ProfileCardMoreInfoView", 1, new RuntimeException("diy info is illegal :" + paramBaseActivity), new Object[0]);
          this.jdField_a_of_type_Bhzt = null;
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
    if (this.jdField_a_of_type_Bhzt == null) {
      return;
    }
    this.jdField_a_of_type_Bhzt.a(paramString, paramTextView, paramView, paramImageView);
  }
  
  public void a(String paramString, HashMap<String, View> paramHashMap)
  {
    if (this.jdField_a_of_type_Bhzt == null) {
      return;
    }
    this.jdField_a_of_type_Bhzt.a(this.b, paramString, paramHashMap);
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_Bhzt == null) {
      return false;
    }
    return this.jdField_a_of_type_Bhzt.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baea
 * JD-Core Version:    0.7.0.1
 */