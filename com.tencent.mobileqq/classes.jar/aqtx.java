import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqtx
  implements CompoundButton.OnCheckedChangeListener
{
  public aqtx(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aqre.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    if (!paramBoolean) {
      new aqrf().c(null);
    }
    ((aqrw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(168)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      bdll.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtx
 * JD-Core Version:    0.7.0.1
 */