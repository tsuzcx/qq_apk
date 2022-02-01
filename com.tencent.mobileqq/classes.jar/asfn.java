import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.2.1;
import java.util.List;

public class asfn
  extends anub
{
  asfn(asfl paramasfl) {}
  
  public void onDelEmoResponse(boolean paramBoolean)
  {
    if (asfl.e(this.a) == null) {}
    while (!paramBoolean) {
      return;
    }
    this.a.b();
  }
  
  public void onUploadReq(List<CustomEmotionData> paramList)
  {
    if (asfl.f(this.a) == null) {
      return;
    }
    asfl.g(this.a).removeObserver(asfl.a(this.a));
    ThreadManager.excute(new FavroamingManager.2.1(this, paramList), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asfn
 * JD-Core Version:    0.7.0.1
 */