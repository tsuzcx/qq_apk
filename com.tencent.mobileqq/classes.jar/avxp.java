import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class avxp
  implements bkhw
{
  avxp(avxo paramavxo, bkho parambkho) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bkho.e();
      return;
      avxo.a(this.jdField_a_of_type_Avxo).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = avxo.a(this.jdField_a_of_type_Avxo).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      avwv.a(paramView).a.a(3, paramInt, str);
      localObject = new avwp(paramInt, str);
      avwv.a(paramView).a((avwp)localObject, false);
      bcst.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avxp
 * JD-Core Version:    0.7.0.1
 */