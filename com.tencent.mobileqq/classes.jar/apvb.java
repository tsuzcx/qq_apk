import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;

class apvb
  implements apvd
{
  apvb(apva paramapva, apvk paramapvk) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("pskey", paramString);
    }
    paramString = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Apvk.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apvb
 * JD-Core Version:    0.7.0.1
 */