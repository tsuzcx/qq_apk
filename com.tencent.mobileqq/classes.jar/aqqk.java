import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.settings.ColorNoteSettingFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aqqk
  implements CompoundButton.OnCheckedChangeListener
{
  public aqqk(ColorNoteSettingFragment paramColorNoteSettingFragment, QQAppInterface paramQQAppInterface) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    aqnr.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBoolean);
    if (!paramBoolean) {
      new aqns().c(null);
    }
    ((aqoj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a(paramBoolean);
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      bdla.b(null, "dc00898", "", "", "0X800A8B0", "0X800A8B0", i, 0, "", "", "", "");
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqk
 * JD-Core Version:    0.7.0.1
 */