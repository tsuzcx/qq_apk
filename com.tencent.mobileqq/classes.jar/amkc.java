import android.util.SparseArray;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUI;
import cooperation.comic.jsp.QQComicDownloadCountObserver;
import cooperation.comic.ui.QQComicTabBarView;
import cooperation.comic.utils.SimpleBiMap;

public class amkc
  implements QQComicDownloadCountObserver
{
  public amkc(QQComicTabBarView paramQQComicTabBarView) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if ((paramBoolean) && (this.a.a() != 1)) {
      this.a.a(1);
    }
    RedTouchUI localRedTouchUI;
    RedAppInfo localRedAppInfo;
    do
    {
      return;
      localRedTouchUI = (RedTouchUI)this.a.a.get("1113.100801");
      localRedAppInfo = (RedAppInfo)this.a.b.get(1);
    } while ((localRedTouchUI == null) || (!localRedTouchUI.a()) || (localRedAppInfo == null) || (localRedTouchUI.a != localRedAppInfo));
    this.a.b(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amkc
 * JD-Core Version:    0.7.0.1
 */