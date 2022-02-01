import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class avdq
  implements bjoe
{
  avdq(avdp paramavdp, bjnw parambjnw) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjnw.e();
      return;
      avdp.a(this.jdField_a_of_type_Avdp).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = avdp.a(this.jdField_a_of_type_Avdp).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      avcw.a(paramView).a.a(3, paramInt, str);
      localObject = new avcq(paramInt, str);
      avcw.a(paramView).a((avcq)localObject, false);
      bcef.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdq
 * JD-Core Version:    0.7.0.1
 */