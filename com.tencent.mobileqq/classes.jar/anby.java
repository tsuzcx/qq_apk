import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import dov.com.tencent.biz.qqstory.takevideo.EditSyncQzonePart;

public class anby
  implements View.OnClickListener
{
  public anby(EditSyncQzonePart paramEditSyncQzonePart) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a;
    if (!EditSyncQzonePart.a(this.a)) {}
    for (boolean bool = true;; bool = false)
    {
      EditSyncQzonePart.a(paramView, bool);
      EditSyncQzonePart.a(this.a, EditSyncQzonePart.a(this.a));
      StoryConfigManager.c(EditSyncQzonePart.a(this.a));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anby
 * JD-Core Version:    0.7.0.1
 */