import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class bdgi
  implements ActionMode.Callback
{
  bdgi(bdgh parambdgh) {}
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    String str = "";
    Object localObject = bdgh.a(this.a).input;
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
    if ((this.a.a()) && (bdgh.a(this.a))) {
      paramMenu.add(0, 3, 196608, amtj.a(2131719695));
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
 * Qualified Name:     bdgi
 * JD-Core Version:    0.7.0.1
 */