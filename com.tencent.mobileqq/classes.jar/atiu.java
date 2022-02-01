import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1;
import com.tencent.tmassistant.appinfo.aidl.GetAppInfoCallback;
import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.List;

public class atiu
  extends GetAppInfoCallback
{
  atiu(atip paramatip) {}
  
  public void onGetAppInfoResponse(int paramInt1, int paramInt2, List<AppDetail> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new QFileAppStorePromoteManager.FetchAppInfoCallback.1(this, paramInt1, paramInt2, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atiu
 * JD-Core Version:    0.7.0.1
 */