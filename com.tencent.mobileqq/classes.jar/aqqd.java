import android.view.View;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class aqqd
  implements aqqq
{
  aqqd(aqqb paramaqqb, HistoryFormItem paramHistoryFormItem) {}
  
  public void a(View paramView, int paramInt, boolean paramBoolean)
  {
    aqns localaqns = new aqns();
    ColorNote localColorNote2;
    if ((aqnv.a()) && (this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.a())) {
      localColorNote2 = (ColorNote)aqqb.a(this.jdField_a_of_type_Aqqb).get(paramInt);
    }
    try
    {
      ColorNote localColorNote1 = (ColorNote)localColorNote2.clone();
      if (localColorNote1 != null)
      {
        localColorNote1.setType(0);
        localaqns.a(localColorNote1.parseBundle());
      }
      this.jdField_a_of_type_ComTencentMobileqqColornoteSettingsHistoryFormItem.setEnable(false);
      aqqb.a(this.jdField_a_of_type_Aqqb, localColorNote2, paramInt);
      QQToast.a(paramView.getContext(), 2, anvx.a(2131690896), 500).a();
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
 * Qualified Name:     aqqd
 * JD-Core Version:    0.7.0.1
 */