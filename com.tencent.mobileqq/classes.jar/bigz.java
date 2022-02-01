import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import java.io.File;

class bigz
  implements bkzr
{
  bigz(bigy parambigy) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.a.jdField_a_of_type_Bisl == null)
      {
        this.a.jdField_a_of_type_Bisl = new bisl(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Bisl.c(2131693769);
      }
      this.a.jdField_a_of_type_Bisl.show();
      if (!paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690671))) {
        break label165;
      }
      if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
        break label115;
      }
      this.a.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Bkzi.dismiss();
      return;
      label115:
      if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
        this.a.jdField_a_of_type_Bisl.dismiss();
      }
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      continue;
      label165:
      if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690670)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693157)))
      {
        if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
          this.a.jdField_a_of_type_Bisl.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 1);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693156)))
      {
        if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
          this.a.jdField_a_of_type_Bisl.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 2);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131690672)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          this.a.jdField_b_of_type_Int = 2;
        }
        else
        {
          if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
            this.a.jdField_a_of_type_Bisl.dismiss();
          }
          this.a.c(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131693151)))
      {
        if ((this.a.jdField_a_of_type_Bisl != null) && (this.a.jdField_a_of_type_Bisl.isShowing())) {
          this.a.jdField_a_of_type_Bisl.dismiss();
        }
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          paramView = new File(this.a.jdField_b_of_type_JavaLangString);
          paramString = ((TeamWorkDocEditBrowserActivity)this.a.jdField_a_of_type_AndroidAppActivity).a.getCurrentAccountUin();
          bmad.b(paramView.getAbsolutePath()).a(this.a.jdField_a_of_type_AndroidAppActivity, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bigz
 * JD-Core Version:    0.7.0.1
 */