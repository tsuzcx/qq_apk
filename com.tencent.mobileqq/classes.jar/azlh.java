import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;

public class azlh
  extends azlp
{
  public void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, String paramString)
  {
    if ((this.a == null) || (this.a.getState() == Thread.State.TERMINATED) || (this.a.a()))
    {
      this.a = ((TroopUploadingThread)azlo.a(paramClass));
      this.a.a(paramArrayList, paramHashMap, paramString, this);
      this.a.start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlh
 * JD-Core Version:    0.7.0.1
 */