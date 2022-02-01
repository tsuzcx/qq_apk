import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public final class ancx
  implements EIPCResultCallback
{
  public ancx(String paramString1, String paramString2, andc paramandc) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    CmShowRenderView.a(true);
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("selfUinStatus");
    int j = paramEIPCResult.getInt("friendUinStatus");
    ancv.a(this.jdField_a_of_type_JavaLangString, i);
    ancv.a(this.b, j);
    if (this.jdField_a_of_type_Andc != null) {
      this.jdField_a_of_type_Andc.a(true);
    }
    QLog.i("CmShow_CmShowRenderView", 1, "initCmShowData selfUinStatus:" + i + " friendUinStatus:" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ancx
 * JD-Core Version:    0.7.0.1
 */