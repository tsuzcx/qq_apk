import android.content.Context;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tribe.fragment.TribeVideoListPlayerFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class bbdf
  implements BusinessObserver
{
  public bbdf(TribeVideoListPlayerFragment paramTribeVideoListPlayerFragment) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    localContext = BaseApplicationImpl.getApplication().getApplicationContext();
    String str = "";
    paramInt = -1;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          continue;
        }
        WebSsoBody.WebSsoResponseBody localWebSsoResponseBody = new WebSsoBody.WebSsoResponseBody();
        localWebSsoResponseBody.mergeFrom(paramBundle);
        int i = localWebSsoResponseBody.ret.get();
        paramInt = i;
        paramBundle = str;
      }
      catch (Exception paramBundle)
      {
        paramBundle = localContext.getString(2131696747, new Object[] { Integer.valueOf(9992) });
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("TribeVideoListPlayerFragment", 2, "reportVV: retCode = " + paramInt + ", errMsg = " + paramBundle);
      }
      return;
      paramBundle = localContext.getString(2131696747, new Object[] { Integer.valueOf(9991) });
      continue;
      paramBundle = localContext.getString(2131696747, new Object[] { Integer.valueOf(9992) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbdf
 * JD-Core Version:    0.7.0.1
 */