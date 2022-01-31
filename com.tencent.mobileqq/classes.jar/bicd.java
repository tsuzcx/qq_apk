import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.io.File;
import mqq.app.AppRuntime;

class bicd
  implements begw
{
  bicd(bica parambica, begr parambegr, Intent paramIntent, String paramString, Activity paramActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    Object localObject = this.jdField_a_of_type_Begr.a(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
    }
    if (((String)localObject).equals(paramView.getResources().getString(2131627742)))
    {
      int i = 1;
      paramInt = i;
      if (this.jdField_a_of_type_Bica.a.c() == 130)
      {
        paramInt = i;
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_edited_pic", false)) {
          paramInt = 0;
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
      aphp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 19003);
      awqx.b(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.dismiss();
      return;
      if (((String)localObject).equals(paramView.getResources().getString(2131627752)))
      {
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        String str = ((File)localObject).getAbsolutePath();
        adwz.a((Activity)paramView.getContext(), (File)localObject, Utils.Crc64String(str), this.jdField_a_of_type_Bica);
        awqx.b(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
      }
      else if (((String)localObject).equals(paramView.getResources().getString(2131627740)))
      {
        paramView = BaseApplicationImpl.getApplication();
        bfhl.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, paramView.getRuntime().getAccount(), 2131629481, this.jdField_a_of_type_Bica);
        awqx.b(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bicd
 * JD-Core Version:    0.7.0.1
 */