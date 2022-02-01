import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.mobileqq.richstatus.topic.TopicEditTextView;

public class bbwl
  implements ActionMode.Callback
{
  public bbwl(TopicEditTextView paramTopicEditTextView) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return TopicEditTextView.a(this.a);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbwl
 * JD-Core Version:    0.7.0.1
 */