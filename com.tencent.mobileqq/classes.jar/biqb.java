import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import java.io.File;

class biqb
  implements blja
{
  biqb(biqa parambiqa) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.a.jdField_a_of_type_Bjbs == null)
      {
        this.a.jdField_a_of_type_Bjbs = new bjbs(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Bjbs.c(2131693490);
      }
      this.a.jdField_a_of_type_Bjbs.show();
      if (!paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690554))) {
        break label165;
      }
      if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
        break label115;
      }
      this.a.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Blir.dismiss();
      return;
      label115:
      if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
        this.a.jdField_a_of_type_Bjbs.dismiss();
      }
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      continue;
      label165:
      if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690553)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692966)))
      {
        if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
          this.a.jdField_a_of_type_Bjbs.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 1);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692965)))
      {
        if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
          this.a.jdField_a_of_type_Bjbs.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 2);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690555)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          this.a.jdField_b_of_type_Int = 2;
        }
        else
        {
          if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
            this.a.jdField_a_of_type_Bjbs.dismiss();
          }
          this.a.c(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131692960)))
      {
        if ((this.a.jdField_a_of_type_Bjbs != null) && (this.a.jdField_a_of_type_Bjbs.isShowing())) {
          this.a.jdField_a_of_type_Bjbs.dismiss();
        }
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          paramView = new File(this.a.jdField_b_of_type_JavaLangString);
          paramString = ((TeamWorkDocEditBrowserActivity)this.a.jdField_a_of_type_AndroidAppActivity).a.getCurrentAccountUin();
          bmko.b(paramView.getAbsolutePath()).a(this.a.jdField_a_of_type_AndroidAppActivity, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biqb
 * JD-Core Version:    0.7.0.1
 */