import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class blwi
  implements Observer<Boolean>
{
  blwi(blwd paramblwd) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = blwd.a(this.a).a().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (blwd.a(this.a).a())
      {
        blwd.a(this.a).setVisibility(0);
        blwd.a(this.a).setVisibility(0);
        return;
      }
      blwd.a(this.a).setVisibility(8);
      blwd.a(this.a).setVisibility(8);
      return;
    }
    blwd.a(this.a).setVisibility(4);
    blwd.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blwi
 * JD-Core Version:    0.7.0.1
 */