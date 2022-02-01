import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class aqqc
  implements View.OnClickListener
{
  aqqc(aqqb paramaqqb, HistoryFormItem paramHistoryFormItem) {}
  
  public void onClick(View paramView)
  {
    ColorNote localColorNote = (ColorNote)aqqb.a(this.jdField_a_of_type_Aqqb).get(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
    Bundle localBundle = new Bundle();
    if (aqqb.a(this.jdField_a_of_type_Aqqb) == 17104896) {
      if ((localColorNote.getServiceType() == 16908288) || (localColorNote.getServiceType() == 16908290)) {
        localBundle.putBoolean("isFromFavourite", true);
      }
    }
    for (;;)
    {
      aqnr.a(paramView.getContext(), localColorNote, localBundle);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSectionAdapter", 0, "getAllViews#onClick: index: " + this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a());
      }
      bdla.b(null, "dc00898", "", "", "0X800AA7F", "0X800AA7F", aqoq.b(aqqb.a(this.jdField_a_of_type_Aqqb)), 0, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a() + 1), "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (aqqb.a(this.jdField_a_of_type_Aqqb) == 16908289) {
        localBundle.putBoolean("history_note", true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqc
 * JD-Core Version:    0.7.0.1
 */