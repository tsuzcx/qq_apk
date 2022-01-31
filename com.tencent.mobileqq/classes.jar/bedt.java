import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import java.io.File;

class bedt
  implements bhqe
{
  bedt(beds parambeds) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.a.jdField_a_of_type_Bepp == null)
      {
        this.a.jdField_a_of_type_Bepp = new bepp(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Bepp.c(2131694217);
      }
      this.a.jdField_a_of_type_Bepp.show();
      if (!paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690614))) {
        break label165;
      }
      if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
        break label115;
      }
      this.a.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bhpy.dismiss();
      return;
      label115:
      if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
        this.a.jdField_a_of_type_Bepp.dismiss();
      }
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      continue;
      label165:
      if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690613)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693493)))
      {
        if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
          this.a.jdField_a_of_type_Bepp.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 1);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693492)))
      {
        if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
          this.a.jdField_a_of_type_Bepp.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 2);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690616)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          this.a.jdField_b_of_type_Int = 2;
        }
        else
        {
          if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
            this.a.jdField_a_of_type_Bepp.dismiss();
          }
          this.a.c(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693483)))
      {
        if ((this.a.jdField_a_of_type_Bepp != null) && (this.a.jdField_a_of_type_Bepp.isShowing())) {
          this.a.jdField_a_of_type_Bepp.dismiss();
        }
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          paramView = new File(this.a.jdField_b_of_type_JavaLangString);
          paramString = ((TeamWorkDocEditBrowserActivity)this.a.jdField_a_of_type_AndroidAppActivity).a.getCurrentAccountUin();
          biqt.b(paramView.getAbsolutePath()).a(this.a.jdField_a_of_type_AndroidAppActivity, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bedt
 * JD-Core Version:    0.7.0.1
 */