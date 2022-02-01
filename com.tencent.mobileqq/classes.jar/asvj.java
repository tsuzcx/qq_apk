import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class asvj
  extends atbu
{
  asvj(asvi paramasvi) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!asvi.a(this.a))
    {
      QLog.d(asvi.a, 1, asvi.b + "<<<getMoreFileRecords is not getting");
      return;
    }
    QLog.i(asvi.a, 1, asvi.b + "<<<getMoreFileRecords result errCode:" + paramInt);
    asvi.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131697411;
      if (paramInt == 65535) {
        i = 2131697412;
      }
      int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298998);
      int k = (int)bgme.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(j - k);
      asvi.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      asvi.a(this.a, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      asvi.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        asvi.b(this.a, true);
      }
      QLog.i(asvi.a, 1, asvi.b + "getMoreFileRecords result: nextTimestamp:" + asvi.a(this.a) + " gettedListEnd:" + bool + " localEnd:" + asvi.b(this.a));
    }
    for (;;)
    {
      paramBundle = new asvo(this.a);
      this.a.a(paramList, paramBundle);
      this.a.a(paramBundle);
      asvi.c(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0) } });
      return;
      QLog.i(asvi.a, 1, asvi.b + "getMoreFileRecords result: lastTimestamp:" + asvi.a(this.a) + " exData=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvj
 * JD-Core Version:    0.7.0.1
 */