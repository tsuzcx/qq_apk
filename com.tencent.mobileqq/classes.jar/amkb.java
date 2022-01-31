import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class amkb
  extends OrientationEventListener
{
  public amkb(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout, Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void onOrientationChanged(int paramInt)
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amkb
 * JD-Core Version:    0.7.0.1
 */