import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class arbd
  extends amrn
{
  arbd(arbb paramarbb) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    if (arbb.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
  
  public void onUploadReq(List<CustomEmotionData> paramList)
  {
    if (arbb.f(this.a) == null) {
      return;
    }
    arbb.g(this.a).removeObserver(arbb.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arbd
 * JD-Core Version:    0.7.0.1
 */