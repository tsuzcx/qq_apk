import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bimd
  implements View.OnClickListener
{
  bimd(bimc parambimc) {}
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_JavaLangString);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimd
 * JD-Core Version:    0.7.0.1
 */