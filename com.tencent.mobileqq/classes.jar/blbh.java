import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

class blbh
  implements bmeo<Boolean>
{
  blbh(blbe paramblbe) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    int i = 200;
    if (paramBoolean == null) {
      return;
    }
    Intent localIntent = blbe.a(this.a).a().getIntent();
    if (localIntent != null) {
      i = localIntent.getIntExtra("AECAMERA_MODE", 200);
    }
    if (paramBoolean.booleanValue())
    {
      if ((blbe.a(this.a).a()) && (i != 202))
      {
        blbe.a(this.a).setVisibility(0);
        return;
      }
      blbe.a(this.a).setVisibility(8);
      return;
    }
    blbe.a(this.a).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbh
 * JD-Core Version:    0.7.0.1
 */