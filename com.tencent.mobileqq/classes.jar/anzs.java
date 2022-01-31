import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import java.util.List;

class anzs
  implements View.OnClickListener
{
  anzs(anzr paramanzr, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)anzr.a(this.jdField_a_of_type_Anzr).get(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
    Bundle localBundle = new Bundle();
    if (anzr.a(this.jdField_a_of_type_Anzr) == 17104896) {
      if ((localColorNote.getServiceType() == 16908288) || (localColorNote.getServiceType() == 16908290)) {
        localBundle.putBoolean("isFromFavourite", true);
      }
    }
    for (;;)
    {
      anxn.a(paramView.getContext(), localColorNote, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSectionAdapter", 0, "getAllViews#onClick: index: " + this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
      }
      azmj.b(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", anyi.b(anzr.a(this.jdField_a_of_type_Anzr)), 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a() + 1), "", "", "");
      return;
      if (anzr.a(this.jdField_a_of_type_Anzr) == 16908289) {
        localBundle.putBoolean("history_note", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anzs
 * JD-Core Version:    0.7.0.1
 */