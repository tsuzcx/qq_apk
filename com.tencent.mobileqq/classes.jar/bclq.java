import android.content.Context;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class bclq
  extends ListView
{
  public bclq(DraggableGridView paramDraggableGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bclq
 * JD-Core Version:    0.7.0.1
 */