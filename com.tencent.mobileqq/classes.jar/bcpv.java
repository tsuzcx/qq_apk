import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bcpv
  extends bcqd
{
  public void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED) || (this.a.a()))
    {
      this.a = ((TroopUploadingThread)bcqc.a(paramClass));
      this.a.a(paramArrayList, paramHashMap, paramList, this);
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpv
 * JD-Core Version:    0.7.0.1
 */