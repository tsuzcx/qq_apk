import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class aqus
  extends OrientationEventListener
{
  public aqus(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqus
 * JD-Core Version:    0.7.0.1
 */