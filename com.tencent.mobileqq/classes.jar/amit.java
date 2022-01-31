import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import java.util.List;

class amit
  implements amjg
{
  amit(amir paramamir, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    amgp localamgp = new amgp();
    ColorNote localColorNote2;
    if ((amgs.a()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a())) {
      localColorNote2 = (ColorNote)amir.a(this.jdField_a_of_type_Amir).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localamgp.a(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      amir.a(this.jdField_a_of_type_Amir, localColorNote2, paramInt);
      bcpw.a(paramView.getContext(), 2, ajyc.a(2131690876), 500).a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amit
 * JD-Core Version:    0.7.0.1
 */