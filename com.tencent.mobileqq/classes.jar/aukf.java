import android.os.Bundle;
import eipc.EIPCResult;

class aukf
  extends axkv
{
  aukf(auke paramauke, int paramInt) {}
  
  public void ipJudgeSuccess(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("usable", paramBoolean);
    localBundle.putString("msg", paramString);
    this.jdField_a_of_type_Auke.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(0, localBundle));
  }
  
  public void onFailedResponse(String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cmd", paramString1);
    localBundle.putInt("code", paramInt);
    localBundle.putString("msg", paramString2);
    this.jdField_a_of_type_Auke.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createResult(-102, localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aukf
 * JD-Core Version:    0.7.0.1
 */