import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class bgun
  extends bguw
{
  public void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED)) {
      this.a = ((TroopUploadingThread)bguv.a(paramClass));
    }
    if (this.a == null) {}
    do
    {
      return;
      this.a.a(paramArrayList, paramHashMap, paramList, this);
    } while (this.a.isAlive());
    this.a.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgun
 * JD-Core Version:    0.7.0.1
 */