import android.content.Context;
import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.ContextMenuTextView;

public class bcla
  implements View.OnClickListener
{
  public bcla(ContextMenuTextView paramContextMenuTextView) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364824)
    {
      paramView = ContextMenuTextView.a(this.a);
      ContextMenuTextView.a(this.a);
      ((ClipboardManager)paramView.getSystemService("clipboard")).setText(this.a.getText().toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcla
 * JD-Core Version:    0.7.0.1
 */