import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class aqzv
  implements begw
{
  aqzv(aqzu paramaqzu, begr parambegr) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Begr.e();
      return;
      aqzu.a(this.jdField_a_of_type_Aqzu).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = aqzu.a(this.jdField_a_of_type_Aqzu).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      aqzc.a(paramView).a.a(3, paramInt, str);
      localObject = new aqyw(paramInt, str);
      aqzc.a(paramView).a((aqyw)localObject, false);
      awqx.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzv
 * JD-Core Version:    0.7.0.1
 */