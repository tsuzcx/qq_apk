import android.content.Context;
import com.tencent.mobileqq.widget.DraggableGridView;
import com.tencent.widget.ListView;

public class bekr
  extends ListView
{
  public bekr(DraggableGridView paramDraggableGridView, Context paramContext)
  {
    super(paramContext);
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bekr
 * JD-Core Version:    0.7.0.1
 */