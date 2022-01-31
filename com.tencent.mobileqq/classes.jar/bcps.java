import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qidian.QidianProfileCardActivity;

class bcps
  implements View.OnClickListener
{
  bcps(bcpr parambcpr) {}
  
  public void onClick(View paramView)
  {
    ((ClipboardManager)this.a.jdField_a_of_type_ComTencentQidianQidianProfileCardActivity.getSystemService("clipboard")).setText(this.a.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bcps
 * JD-Core Version:    0.7.0.1
 */