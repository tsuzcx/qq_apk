import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class atmh
  implements bhqd
{
  atmh(atmg paramatmg, bhpy parambhpy) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bhpy.e();
      return;
      atmg.a(this.jdField_a_of_type_Atmg).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = atmg.a(this.jdField_a_of_type_Atmg).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      atln.a(paramView).a.a(3, paramInt, str);
      localObject = new atlh(paramInt, str);
      atln.a(paramView).a((atlh)localObject, false);
      azmj.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmh
 * JD-Core Version:    0.7.0.1
 */