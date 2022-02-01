import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class bnqp
  implements Observer<Boolean>
{
  bnqp(bnqm parambnqm) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = bnqm.a(this.a).a().getIntent();
    if (localIntent != null) {
      localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if (bnqm.a(this.a).a())
      {
        bnqm.a(this.a).setVisibility(0);
        return;
      }
      bnqm.a(this.a).setVisibility(8);
      return;
    }
    bnqm.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnqp
 * JD-Core Version:    0.7.0.1
 */