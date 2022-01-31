import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

public class aoej
  implements CompoundButton.OnCheckedChangeListener
{
  public aoej(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aobw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    if (!paramBoolean) {
      new aobx().c(null);
    }
    ((aocm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      azqs.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoej
 * JD-Core Version:    0.7.0.1
 */