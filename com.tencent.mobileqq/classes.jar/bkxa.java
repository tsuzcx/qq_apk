import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class bkxa
  implements bmac<Boolean>
{
  bkxa(bkwx parambkwx) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    int i = 200;
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = bkwx.a(this.a).a().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if ((bkwx.a(this.a).a()) && (i != 202))
      {
        bkwx.a(this.a).setVisibility(0);
        return;
      }
      bkwx.a(this.a).setVisibility(8);
      return;
    }
    bkwx.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkxa
 * JD-Core Version:    0.7.0.1
 */