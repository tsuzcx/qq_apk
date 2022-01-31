import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class arvj
  implements bfoq
{
  arvj(arvi paramarvi, bfol parambfol) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfol.e();
      return;
      arvi.a(this.jdField_a_of_type_Arvi).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = arvi.a(this.jdField_a_of_type_Arvi).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      aruq.a(paramView).a.a(3, paramInt, str);
      localObject = new aruk(paramInt, str);
      aruq.a(paramView).a((aruk)localObject, false);
      axqw.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arvj
 * JD-Core Version:    0.7.0.1
 */