import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class bosd
  implements Observer<Boolean>
{
  bosd(bory parambory) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = bory.a(this.a).a().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (bory.a(this.a).a())
      {
        bory.a(this.a).setVisibility(0);
        bory.a(this.a).setVisibility(0);
        return;
      }
      bory.a(this.a).setVisibility(8);
      bory.a(this.a).setVisibility(8);
      return;
    }
    bory.a(this.a).setVisibility(4);
    bory.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bosd
 * JD-Core Version:    0.7.0.1
 */