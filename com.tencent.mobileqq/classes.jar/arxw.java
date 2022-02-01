import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class arxw
  extends asfz
{
  arxw(arxv paramarxv) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!arxv.a(this.a))
    {
      QLog.d(arxv.a, 1, arxv.b + "<<<getMoreFileRecords is not getting");
      return;
    }
    QLog.i(arxv.a, 1, arxv.b + "<<<getMoreFileRecords result errCode:" + paramInt);
    arxv.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131697638;
      if (paramInt == 65535) {
        i = 2131697639;
      }
      int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299076);
      int k = (int)bfvh.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(j - k);
      arxv.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      arxv.a(this.a, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      arxv.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        arxv.b(this.a, true);
      }
      QLog.i(arxv.a, 1, arxv.b + "getMoreFileRecords result: nextTimestamp:" + arxv.a(this.a) + " gettedListEnd:" + bool + " localEnd:" + arxv.b(this.a));
    }
    for (;;)
    {
      paramBundle = new aryb(this.a);
      this.a.a(paramList, paramBundle);
      this.a.a(paramBundle);
      arxv.c(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0) } });
      return;
      QLog.i(arxv.a, 1, arxv.b + "getMoreFileRecords result: lastTimestamp:" + arxv.a(this.a) + " exData=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxw
 * JD-Core Version:    0.7.0.1
 */