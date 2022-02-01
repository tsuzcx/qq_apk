import android.os.Bundle;
import eipc.EIPCResult;

class bpdq
  implements bpdn
{
  bpdq(bpdp parambpdp, int paramInt) {}
  
  public void a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("effect_group_json_path", paramString);
    this.jdField_a_of_type_Bpdp.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpdq
 * JD-Core Version:    0.7.0.1
 */