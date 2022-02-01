import android.os.Bundle;
import eipc.EIPCResult;
import java.util.HashMap;

class bniu
  implements bnjf
{
  bniu(bnis parambnis, int paramInt) {}
  
  public void a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_resource_download_all_succeeded", paramBoolean);
    localBundle.putSerializable("key_resource_download_result", paramHashMap);
    this.jdField_a_of_type_Bnis.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniu
 * JD-Core Version:    0.7.0.1
 */