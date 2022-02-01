import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.LangSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auwg
  implements View.OnClickListener
{
  auwg(auwf paramauwf, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (auwf.a(this.jdField_a_of_type_Auwf, this.jdField_a_of_type_Int))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (localQQAppInterface != null) {
        bdla.b(localQQAppInterface, "dc00898", "", "", "0X800A612", "0X800A612", 0, 0, "", "", "", "");
      }
    }
    if (LangSettingFragment.a(this.jdField_a_of_type_Auwf.a) != ((Integer)paramView.getTag()).intValue()) {
      LangSettingFragment.a(this.jdField_a_of_type_Auwf.a, ((Integer)paramView.getTag()).intValue());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwg
 * JD-Core Version:    0.7.0.1
 */