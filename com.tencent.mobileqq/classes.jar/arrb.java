import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.data.ISong;

public class arrb
  implements artf
{
  public arrb(ListenTogetherManager paramListenTogetherManager) {}
  
  public void a(ISong paramISong)
  {
    if (paramISong != null)
    {
      ListenTogetherManager.a(this.a, paramISong);
      this.a.a(paramISong.a());
      String str = (String)ListenTogetherManager.a(this.a).get(paramISong.a());
      if (!TextUtils.isEmpty(str)) {
        ListenTogetherManager.a(this.a, paramISong.a(), str);
      }
    }
    else
    {
      return;
    }
    ListenTogetherManager.a(this.a, paramISong.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arrb
 * JD-Core Version:    0.7.0.1
 */