import android.os.Bundle;
import android.text.TextUtils;
import eipc.EIPCResult;

class apyy
  implements apza
{
  apyy(apyx paramapyx, apyv paramapyv) {}
  
  public void a(String paramString1, long paramLong, String paramString2, String paramString3)
  {
    Bundle localBundle = new Bundle();
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      localBundle.putString("userAccount", paramString1);
      localBundle.putString("openID", paramString2);
      localBundle.putString("openToken", paramString3);
      localBundle.putLong("dstAppID", paramLong);
    }
    this.jdField_a_of_type_Apyv.a(EIPCResult.createResult(0, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apyy
 * JD-Core Version:    0.7.0.1
 */