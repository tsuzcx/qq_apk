import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class awjt
  implements bkzq
{
  awjt(awjs paramawjs, bkzi parambkzi) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkzi.e();
      return;
      awjs.a(this.jdField_a_of_type_Awjs).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = awjs.a(this.jdField_a_of_type_Awjs).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      awiz.a(paramView).a.a(3, paramInt, str);
      localObject = new awit(paramInt, str);
      awiz.a(paramView).a((awit)localObject, false);
      bdla.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjt
 * JD-Core Version:    0.7.0.1
 */