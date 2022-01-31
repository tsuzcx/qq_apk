import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import java.util.List;

class amir
  implements View.OnClickListener
{
  amir(amiq paramamiq, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)amiq.a(this.jdField_a_of_type_Amiq).get(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
    Bundle localBundle = new Bundle();
    if (amiq.a(this.jdField_a_of_type_Amiq) == 17104896) {
      if ((localColorNote.getServiceType() == 16908288) || (localColorNote.getServiceType() == 16908290)) {
        localBundle.putBoolean("isFromFavourite", true);
      }
    }
    for (;;)
    {
      amgn.a(paramView.getContext(), localColorNote, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSectionAdapter", 0, "getAllViews#onClick: index: " + this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
      }
      axqy.b(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", amhh.b(amiq.a(this.jdField_a_of_type_Amiq)), 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a() + 1), "", "", "");
      return;
      if (amiq.a(this.jdField_a_of_type_Amiq) == 16908289) {
        localBundle.putBoolean("history_note", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amir
 * JD-Core Version:    0.7.0.1
 */