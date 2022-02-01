import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;

class apkw
  implements apky
{
  apkw(apkv paramapkv, aplf paramaplf) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("pskey", paramString);
    }
    paramString = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_Aplf.a(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apkw
 * JD-Core Version:    0.7.0.1
 */