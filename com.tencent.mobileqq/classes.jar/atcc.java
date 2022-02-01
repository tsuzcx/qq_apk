import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atcc
  extends atkf
{
  atcc(atcb paramatcb) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!atcb.a(this.a))
    {
      QLog.d(atcb.a, 1, atcb.b + "<<<getMoreFileRecords is not getting");
      return;
    }
    QLog.i(atcb.a, 1, atcb.b + "<<<getMoreFileRecords result errCode:" + paramInt);
    atcb.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131697918;
      if (paramInt == 65535) {
        i = 2131697919;
      }
      int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080);
      int k = (int)bhdz.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(j - k);
      atcb.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      atcb.a(this.a, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      atcb.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        atcb.b(this.a, true);
      }
      QLog.i(atcb.a, 1, atcb.b + "getMoreFileRecords result: nextTimestamp:" + atcb.a(this.a) + " gettedListEnd:" + bool + " localEnd:" + atcb.b(this.a));
    }
    for (;;)
    {
      paramBundle = new atch(this.a);
      this.a.a(paramList, paramBundle);
      this.a.a(paramBundle);
      atcb.c(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0) } });
      return;
      QLog.i(atcb.a, 1, atcb.b + "getMoreFileRecords result: lastTimestamp:" + atcb.a(this.a) + " exData=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atcc
 * JD-Core Version:    0.7.0.1
 */