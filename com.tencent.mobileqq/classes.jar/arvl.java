import android.content.Intent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.QQAppInterface;

class arvl
  implements bfph
{
  arvl(arvk paramarvk, bfpc parambfpc) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Bfpc.e();
      return;
      arvk.a(this.jdField_a_of_type_Arvk).finish();
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      Object localObject = arvk.a(this.jdField_a_of_type_Arvk).getIntent();
      String str = ((Intent)localObject).getStringExtra("uin");
      paramInt = ((Intent)localObject).getIntExtra("uintype", -1);
      arus.a(paramView).a.a(3, paramInt, str);
      localObject = new arum(paramInt, str);
      arus.a(paramView).a((arum)localObject, false);
      axqy.b(null, "CliOper", "", "", "0X800A76E", "0X800A76E", 0, 0, "", "0", "0", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arvl
 * JD-Core Version:    0.7.0.1
 */