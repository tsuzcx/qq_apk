import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.app.qqdaily.QQDailyArkView;

public class apbs
  implements ArkViewImplement.LoadCallback
{
  public apbs(QQDailyArkView paramQQDailyArkView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbs
 * JD-Core Version:    0.7.0.1
 */