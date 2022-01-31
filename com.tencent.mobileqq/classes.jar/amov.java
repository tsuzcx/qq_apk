import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;

public class amov
  implements ArkViewImplement.LoadCallback
{
  public amov(QQDailyArkView paramQQDailyArkView) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if (paramInt != 1) {
      QQDailyArkView.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amov
 * JD-Core Version:    0.7.0.1
 */