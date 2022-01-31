import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import java.util.List;

class amis
  implements amjf
{
  amis(amiq paramamiq, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    amgo localamgo = new amgo();
    ColorNote localColorNote2;
    if ((amgr.a()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a())) {
      localColorNote2 = (ColorNote)amiq.a(this.jdField_a_of_type_Amiq).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localamgo.a(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      amiq.a(this.jdField_a_of_type_Amiq, localColorNote2, paramInt);
      bcql.a(paramView.getContext(), 2, ajya.a(2131690876), 500).a();
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
 * Qualified Name:     amis
 * JD-Core Version:    0.7.0.1
 */