import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.activity.BaseChatPie;

class bemq
  implements ActionMode.Callback
{
  bemq(bemp parambemp) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    String str = "";
    Object localObject = bemp.a(this.a).a;
    paramMenuItem = str;
    if (localObject != null)
    {
      localObject = ((EditText)localObject).getText();
      paramMenuItem = str;
      if (localObject != null) {
        paramMenuItem = localObject.toString();
      }
    }
    this.a.b(paramMenuItem, 1);
    paramActionMode.finish();
    return true;
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    if ((this.a.a()) && (bemp.a(this.a))) {
      paramMenu.add(0, 3, 196608, anzj.a(2131719376));
    }
    return this.a.a();
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemq
 * JD-Core Version:    0.7.0.1
 */