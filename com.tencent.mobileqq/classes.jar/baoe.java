import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.theme.ListenTogetherTheme.FloatViewSkin.2.1;
import com.tencent.qphone.base.util.QLog;

public class baoe
  extends bdul
{
  baoe(baoc parambaoc) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 36) && ((paramObject instanceof Integer)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FloatViewSkin", 2, "mMusicBusinessObserver: isSuccess" + paramBoolean + "  music player id:" + paramObject);
      }
      paramInt = ((Integer)paramObject).intValue();
      baoc.a(this.a, paramInt);
      if (paramInt > 0)
      {
        this.a.a = true;
        bdwl.a.download(null, baoc.a(this.a), baoc.a(this.a), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baoe
 * JD-Core Version:    0.7.0.1
 */