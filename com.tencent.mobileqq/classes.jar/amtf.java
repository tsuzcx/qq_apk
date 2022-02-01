import com.tencent.mobileqq.app.BusinessObserver;
import java.util.ArrayList;
import java.util.HashMap;

public class amtf
  implements BusinessObserver
{
  public void a(boolean paramBoolean, ArrayList<ArrayList<String>> paramArrayList, ArrayList<String> paramArrayList1) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt == 1)
    {
      paramObject = (HashMap)paramObject;
      a(paramBoolean, (ArrayList)paramObject.get("mq_kandian_svc_results"), (ArrayList)paramObject.get("mq_kandian_svc_sentences"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtf
 * JD-Core Version:    0.7.0.1
 */