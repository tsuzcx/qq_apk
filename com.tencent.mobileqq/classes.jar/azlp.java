import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.mobileqq.troop.utils.TroopUploadingThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public abstract class azlp
  extends Observable
{
  protected TroopUploadingThread a;
  
  public ArrayList<azln> a()
  {
    if (this.a != null) {
      return this.a.a();
    }
    return null;
  }
  
  public abstract void a(Class<? extends Thread> paramClass, ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, String paramString);
  
  public void a(Observer paramObserver)
  {
    super.deleteObserver(paramObserver);
  }
  
  public void notifyObservers(Object paramObject)
  {
    super.setChanged();
    super.notifyObservers(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azlp
 * JD-Core Version:    0.7.0.1
 */