import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import java.io.File;

class bbbe
  implements begx
{
  bbbe(bbbd parambbbd) {}
  
  public void a(View paramView, int paramInt, String paramString)
  {
    if (paramString != null)
    {
      if (this.a.jdField_a_of_type_Bbms == null)
      {
        this.a.jdField_a_of_type_Bbms = new bbms(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_Int);
        this.a.jdField_a_of_type_Bbms.c(2131628457);
      }
      this.a.jdField_a_of_type_Bbms.show();
      if (!paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131625002))) {
        break label165;
      }
      if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
        break label115;
      }
      this.a.jdField_b_of_type_Int = 0;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_Begr.dismiss();
      return;
      label115:
      if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
        this.a.jdField_a_of_type_Bbms.dismiss();
      }
      this.a.b(this.a.jdField_b_of_type_JavaLangString);
      continue;
      label165:
      if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131625001)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_Int = 1;
        } else {
          this.a.a(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131627750)))
      {
        if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 1);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131627749)))
      {
        if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        this.a.a(this.a.jdField_b_of_type_JavaLangString, 2);
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131625004)))
      {
        if (TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          this.a.jdField_b_of_type_Int = 2;
        }
        else
        {
          if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
            this.a.jdField_a_of_type_Bbms.dismiss();
          }
          this.a.c(this.a.jdField_b_of_type_JavaLangString);
        }
      }
      else if (paramString.equals(this.a.jdField_a_of_type_AndroidAppActivity.getString(2131627740)))
      {
        if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing())) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
        {
          paramView = new File(this.a.jdField_b_of_type_JavaLangString);
          paramString = ((TeamWorkDocEditBrowserActivity)this.a.jdField_a_of_type_AndroidAppActivity).a.getCurrentAccountUin();
          bfhl.b(paramView.getAbsolutePath()).a(this.a.jdField_a_of_type_AndroidAppActivity, paramString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbbe
 * JD-Core Version:    0.7.0.1
 */