import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aqtq
  implements aqud
{
  aqtq(aqto paramaqto, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    aqrf localaqrf = new aqrf();
    ColorNote localColorNote2;
    if ((aqri.a()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a())) {
      localColorNote2 = (ColorNote)aqto.a(this.jdField_a_of_type_Aqto).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localaqrf.a(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      aqto.a(this.jdField_a_of_type_Aqto, localColorNote2, paramInt);
      QQToast.a(paramView.getContext(), 2, anzj.a(2131690771), 500).a();
      return;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtq
 * JD-Core Version:    0.7.0.1
 */