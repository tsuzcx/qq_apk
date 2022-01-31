import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class ansz
  extends ajvz
{
  ansz(ansx paramansx) {}
  
  public void a(List<CustomEmotionData> paramList)
  {
    if (ansx.f(this.a) == null) {
      return;
    }
    ansx.g(this.a).removeObserver(ansx.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (ansx.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ansz
 * JD-Core Version:    0.7.0.1
 */