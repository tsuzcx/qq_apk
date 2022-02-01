import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqtp
  implements View.OnClickListener
{
  aqtp(aqto paramaqto, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)aqto.a(this.jdField_a_of_type_Aqto).get(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
    Bundle localBundle = new Bundle();
    if (aqto.a(this.jdField_a_of_type_Aqto) == 17104896) {
      if ((localColorNote.getServiceType() == 16908288) || (localColorNote.getServiceType() == 16908290)) {
        localBundle.putBoolean("isFromFavourite", true);
      }
    }
    for (;;)
    {
      aqre.a(paramView.getContext(), localColorNote, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSectionAdapter", 0, "getAllViews#onClick: index: " + this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
      }
      bdll.b(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", aqsd.b(aqto.a(this.jdField_a_of_type_Aqto)), 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a() + 1), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqto.a(this.jdField_a_of_type_Aqto) == 16908289) {
        localBundle.putBoolean("history_note", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtp
 * JD-Core Version:    0.7.0.1
 */