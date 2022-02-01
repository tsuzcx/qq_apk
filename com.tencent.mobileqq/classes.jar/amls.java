import android.os.Bundle;
import eipc.EIPCResult;

class amls
  implements anfj
{
  amls(amlo paramamlo, Bundle paramBundle, int paramInt) {}
  
  public void onDownloadFinish(boolean paramBoolean, int paramInt)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean) {
      paramInt = 0;
    }
    localEIPCResult.code = paramInt;
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    this.jdField_a_of_type_AndroidOsBundle.putString("apolloErrMsg", "success");
    this.jdField_a_of_type_Amlo.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amls
 * JD-Core Version:    0.7.0.1
 */