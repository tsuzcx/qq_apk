import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;

public class amja
  implements CompoundButton.OnCheckedChangeListener
{
  public amja(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    amgo.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    if (!paramBoolean) {
      new amgp().b(null);
    }
    ((amhd)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      axqw.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amja
 * JD-Core Version:    0.7.0.1
 */