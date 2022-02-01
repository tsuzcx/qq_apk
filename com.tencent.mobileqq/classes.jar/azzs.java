import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class azzs
  extends bafn
{
  azzs(azzr paramazzr) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("onGetCardDisplaySetting isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramCard != null)) {
      if (bagq.a.a(42425, paramCard, null) != 0) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.a.b(paramBoolean);
      if (azzr.a(this.a) != null) {
        azzr.a(this.a).removeObserver(azzr.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azzs
 * JD-Core Version:    0.7.0.1
 */