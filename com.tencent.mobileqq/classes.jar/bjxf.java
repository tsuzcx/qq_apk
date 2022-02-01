import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bjxf
  implements View.OnClickListener
{
  bjxf(bjxe parambjxe) {}
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjxf
 * JD-Core Version:    0.7.0.1
 */