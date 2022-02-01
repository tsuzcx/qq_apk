import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class aqrf
  extends OrientationEventListener
{
  public aqrf(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqrf
 * JD-Core Version:    0.7.0.1
 */