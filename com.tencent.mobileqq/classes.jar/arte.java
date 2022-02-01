import android.os.Handler;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

class arte
  implements View.OnClickListener
{
  arte(artb paramartb, String paramString) {}
  
  public void onClick(View paramView)
  {
    artb.a(this.jdField_a_of_type_Artb).removeCallbacks(artb.a(this.jdField_a_of_type_Artb));
    artb.a(this.jdField_a_of_type_Artb).run();
    int i = artb.a(this.jdField_a_of_type_Artb).a.getSelectionStart();
    Editable localEditable = artb.a(this.jdField_a_of_type_Artb).a.getEditableText();
    if ((i < 0) || (i >= localEditable.length())) {
      localEditable.append(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      bdll.b(artb.a(this.jdField_a_of_type_Artb).a(), "dc00898", "", "", "0X800B22C", "0X800B22C", 0, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localEditable.insert(i, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arte
 * JD-Core Version:    0.7.0.1
 */