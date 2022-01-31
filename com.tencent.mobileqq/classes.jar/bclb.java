import android.content.Context;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class bclb
  extends ListView
{
  public bclb(DraggableGridView paramDraggableGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bclb
 * JD-Core Version:    0.7.0.1
 */