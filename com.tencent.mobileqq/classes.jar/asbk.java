import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.LangSettingFragment;

class asbk
  implements View.OnClickListener
{
  asbk(asbj paramasbj, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (asbj.a(this.jdField_a_of_type_Asbj, this.jdField_a_of_type_Int))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        azmj.b(localQQAppInterface, "dc00898", "", "", "0X800A612", "0X800A612", 0, 0, "", "", "", "");
      }
    }
    if (LangSettingFragment.a(this.jdField_a_of_type_Asbj.a) != ((Integer)paramView.getTag()).intValue()) {
      LangSettingFragment.a(this.jdField_a_of_type_Asbj.a, ((Integer)paramView.getTag()).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbk
 * JD-Core Version:    0.7.0.1
 */