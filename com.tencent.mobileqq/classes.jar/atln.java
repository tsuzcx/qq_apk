import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class atln
  extends attp
{
  atln(atlm paramatlm) {}
  
  public void a(int paramInt, List<FavFileInfo> paramList, Bundle paramBundle)
  {
    if (!atlm.a(this.a))
    {
      QLog.d(atlm.a, 1, atlm.b + "<<<getMoreFileRecords is not getting");
      return;
    }
    QLog.i(atlm.a, 1, atlm.b + "<<<getMoreFileRecords result errCode:" + paramInt);
    atlm.a(this.a);
    if (paramInt != 0)
    {
      int i = 2131697492;
      if (paramInt == 65535) {
        i = 2131697493;
      }
      int j = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299011);
      int k = (int)bhmg.a(BaseApplicationImpl.getContext(), 5.0F);
      QQToast.a(BaseApplicationImpl.getContext(), 0, i, 0).b(j - k);
      atlm.b(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(paramInt) } });
      return;
    }
    if (paramBundle != null)
    {
      atlm.a(this.a, paramBundle.getLong("resultTimestamp"));
      boolean bool = paramBundle.getBoolean("fecth_end");
      atlm.a(this.a, paramBundle.getBoolean("fecth_local_end"));
      if ((bool) && ((paramList == null) || (paramList.size() == 0))) {
        atlm.b(this.a, true);
      }
      QLog.i(atlm.a, 1, atlm.b + "getMoreFileRecords result: nextTimestamp:" + atlm.a(this.a) + " gettedListEnd:" + bool + " localEnd:" + atlm.b(this.a));
    }
    for (;;)
    {
      paramBundle = new atls(this.a);
      this.a.a(paramList, paramBundle);
      this.a.a(paramBundle);
      atlm.c(this.a);
      this.a.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0) } });
      return;
      QLog.i(atlm.a, 1, atlm.b + "getMoreFileRecords result: lastTimestamp:" + atlm.a(this.a) + " exData=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atln
 * JD-Core Version:    0.7.0.1
 */