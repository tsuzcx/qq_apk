import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class ashf
  extends anxe
{
  ashf(ashd paramashd) {}
  
  public void a(List<CustomEmotionData> paramList)
  {
    if (ashd.f(this.a) == null) {
      return;
    }
    ashd.g(this.a).removeObserver(ashd.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (ashd.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ashf
 * JD-Core Version:    0.7.0.1
 */