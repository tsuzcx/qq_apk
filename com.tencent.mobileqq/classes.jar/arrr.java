import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class arrr
  extends anli
{
  arrr(arrp paramarrp) {}
  
  public void a(List<CustomEmotionData> paramList)
  {
    if (arrp.f(this.a) == null) {
      return;
    }
    arrp.g(this.a).removeObserver(arrp.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (arrp.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrr
 * JD-Core Version:    0.7.0.1
 */