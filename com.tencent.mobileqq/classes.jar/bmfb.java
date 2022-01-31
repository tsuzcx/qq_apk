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

class bmfb
  implements bhqd
{
  bmfb(bmey parambmey, bhpy parambhpy, Intent paramIntent, String paramString, Activity paramActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    Object localObject = this.jdField_a_of_type_Bhpy.a(paramInt);
    if (localObject == null)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
    }
    if (((String)localObject).equals(paramView.getResources().getString(2131693485)))
    {
      int i = 1;
      paramInt = i;
      if (this.jdField_a_of_type_Bmey.a.c() == 130)
      {
        paramInt = i;
        if (!this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("extra_is_edited_pic", false)) {
          paramInt = 0;
        }
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_type", paramInt);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("forward_filepath", this.jdField_a_of_type_JavaLangString);
      arum.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentIntent, 19003);
      azmj.b(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.dismiss();
      return;
      if (((String)localObject).equals(paramView.getResources().getString(2131693495)))
      {
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        String str = ((File)localObject).getAbsolutePath();
        agem.a((Activity)paramView.getContext(), (File)localObject, Utils.Crc64String(str), this.jdField_a_of_type_Bmey);
        azmj.b(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
      }
      else if (((String)localObject).equals(paramView.getResources().getString(2131693483)))
      {
        paramView = BaseApplicationImpl.getApplication();
        biqt.b(this.jdField_a_of_type_JavaLangString).a(this.jdField_a_of_type_AndroidAppActivity, paramView.getRuntime().getAccount(), 2131695321, this.jdField_a_of_type_Bmey);
        azmj.b(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfb
 * JD-Core Version:    0.7.0.1
 */