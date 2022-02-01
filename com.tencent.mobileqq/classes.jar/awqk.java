import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class awqk
  implements bliz
{
  awqk(awqj paramawqj, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.e();
      return;
      awqj.a(this.jdField_a_of_type_Awqj).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = awqj.a(this.jdField_a_of_type_Awqj).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      awpq.a(paramView).a.a(3, paramInt, str);
      localObject = new awpk(paramInt, str);
      awpq.a(paramView).a((awpk)localObject, false);
      bdll.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqk
 * JD-Core Version:    0.7.0.1
 */