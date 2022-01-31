import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2.1;
import com.tencent.qphone.base.util.QLog;

public class aylx
  extends bbqu
{
  aylx(aylv paramaylv) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 36) && ((paramObject instanceof Integer)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FloatViewSkin", 2, "mMusicBusinessObserver: isSuccess" + paramBoolean + "  music player id:" + paramObject);
      }
      paramInt = ((Integer)paramObject).intValue();
      aylv.a(this.a, paramInt);
      if (paramInt > 0)
      {
        this.a.a = true;
        bbsr.a.download(null, aylv.a(this.a), aylv.a(this.a), false);
      }
    }
    else
    {
      return;
    }
    this.a.a = false;
    ThreadManagerV2.getUIHandlerV2().post(new FloatViewSkin.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aylx
 * JD-Core Version:    0.7.0.1
 */