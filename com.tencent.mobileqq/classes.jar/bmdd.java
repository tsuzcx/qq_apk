import android.os.Bundle;
import com.tencent.mobileqq.richstatus.RichStatus;
import cooperation.qqindividuality.ipc.QQIndividualityPluginProxyService;
import java.util.ArrayList;

class bmdd
  extends bbvs
{
  private bmdd(bmcz parambmcz) {}
  
  protected void a(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2, ArrayList<RichStatus> paramArrayList, boolean paramBoolean3)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSuccess", paramBoolean1);
    localBundle.putInt("start", paramInt1);
    localBundle.putInt("end", paramInt2);
    localBundle.putBoolean("over", paramBoolean2);
    localBundle.putSerializable("data", paramArrayList);
    localBundle.putBoolean("isAddFromCard", paramBoolean3);
    localBundle.putInt("which_method", 0);
    QQIndividualityPluginProxyService.a().a("qqindividuality_signature", 5, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmdd
 * JD-Core Version:    0.7.0.1
 */