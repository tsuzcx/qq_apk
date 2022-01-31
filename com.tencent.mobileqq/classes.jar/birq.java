import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class birq
  implements bjob<Boolean>
{
  birq(birn parambirn) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    int i = 200;
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = birn.a(this.a).a().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if ((birn.a(this.a).a()) && (i != 202))
      {
        birn.a(this.a).setVisibility(0);
        return;
      }
      birn.a(this.a).setVisibility(8);
      return;
    }
    birn.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     birq
 * JD-Core Version:    0.7.0.1
 */