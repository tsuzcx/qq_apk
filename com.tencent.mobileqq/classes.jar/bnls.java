import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.activity.contacts.base.tabs.SimpleSlidingIndicator;

class bnls
  implements Observer<Boolean>
{
  bnls(bnln parambnln) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = bnln.a(this.a).a().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (bnln.a(this.a).a())
      {
        bnln.a(this.a).setVisibility(0);
        bnln.a(this.a).setVisibility(0);
        return;
      }
      bnln.a(this.a).setVisibility(8);
      bnln.a(this.a).setVisibility(8);
      return;
    }
    bnln.a(this.a).setVisibility(4);
    bnln.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnls
 * JD-Core Version:    0.7.0.1
 */