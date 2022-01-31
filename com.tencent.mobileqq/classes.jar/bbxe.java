import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mobileqq.vip.diy.ETTextViewPlus;
import com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class bbxe
  extends bhyx
{
  private String a;
  private String b = "";
  private int c = -1;
  private int d = -1;
  
  public bbxe(String paramString1, View paramView, String paramString2)
  {
    super(paramString1, paramView);
    this.jdField_a_of_type_JavaLangString = "";
    this.b = paramString2;
  }
  
  protected ViewGroup.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams, JSONObject paramJSONObject)
  {
    paramLayoutParams.width = -1;
    paramLayoutParams.height = -2;
    int i = ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin;
    ((ViewGroup.MarginLayoutParams)paramLayoutParams).leftMargin = 0;
    if ((this.jdField_a_of_type_AndroidViewView instanceof ProfileTemplateNickNameContainer))
    {
      ProfileTemplateNickNameContainer localProfileTemplateNickNameContainer = (ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView;
      localProfileTemplateNickNameContainer.setTextViewX(i);
      if ("center_horizontal".equals(paramJSONObject.optString("gravity"))) {
        localProfileTemplateNickNameContainer.setTextCenter();
      }
    }
    return paramLayoutParams;
  }
  
  protected void a(String paramString1, String paramString2)
  {
    if ("f".equals(paramString1)) {}
    for (;;)
    {
      try
      {
        this.c = Integer.parseInt(paramString2);
        if (QLog.isColorLevel()) {
          QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font id=" + this.c);
        }
        return;
      }
      catch (NumberFormatException paramString1)
      {
        veg.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font id illegal :" + paramString2 + " error=" + paramString1);
        return;
      }
      if ("ft".equals(paramString1)) {
        try
        {
          this.d = Integer.parseInt(paramString2);
          if (QLog.isColorLevel())
          {
            QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "parse name font type=" + this.d);
            return;
          }
        }
        catch (NumberFormatException paramString1)
        {
          veg.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "pf_name font type illegal :" + paramString2 + " error=" + paramString1);
          return;
        }
      }
    }
    if ("bg".equals(paramString1))
    {
      this.jdField_a_of_type_JavaLangString = paramString2;
      return;
    }
    super.a(paramString1, paramString2);
  }
  
  protected void b()
  {
    super.b();
    if ((this.jdField_a_of_type_AndroidViewView instanceof ProfileTemplateNickNameContainer))
    {
      ETTextViewPlus localETTextViewPlus = ((ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView).a();
      if ((this.c <= 0) || (this.d <= 0)) {
        break label112;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.ProfileTemplateNickNameViewModule", 1, "set name font id=" + this.c + " type=" + this.d);
      }
      localETTextViewPlus.setFontAsync(this.c, this.d);
    }
    for (;;)
    {
      ((ProfileTemplateNickNameContainer)this.jdField_a_of_type_AndroidViewView).setTextBgUrl(this.jdField_a_of_type_JavaLangString);
      return;
      label112:
      veg.e("DIYProfileTemplate.ProfileTemplateNickNameViewModule", "profile nick name set font error because font id=" + this.c + " type=" + this.d + " is illegal!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbxe
 * JD-Core Version:    0.7.0.1
 */