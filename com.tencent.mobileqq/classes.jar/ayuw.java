import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class ayuw
  extends ayzz
{
  ayuw(ayuv paramayuv) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @Nullable Card paramCard)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("AnonymousManager", 2, String.format("onGetCardDisplaySetting isSuccess=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if ((paramBoolean) && (paramCard != null)) {
      if (azbc.a.a(42425, paramCard, null) != 0) {
        break label91;
      }
    }
    label91:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.a.b(paramBoolean);
      if (ayuv.a(this.a) != null) {
        ayuv.a(this.a).removeObserver(ayuv.a(this.a));
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuw
 * JD-Core Version:    0.7.0.1
 */