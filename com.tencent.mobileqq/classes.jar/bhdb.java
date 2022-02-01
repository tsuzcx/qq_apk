import QC.GetItemWatchWordRsp;
import android.os.Bundle;
import eipc.EIPCModule;
import eipc.EIPCResult;

class bhdb
  implements anil
{
  bhdb(bhda parambhda, EIPCModule paramEIPCModule, int paramInt) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof GetItemWatchWordRsp)))
    {
      paramObject = (GetItemWatchWordRsp)paramObject;
      EIPCResult localEIPCResult = new EIPCResult();
      localEIPCResult.data = new Bundle();
      localEIPCResult.data.putInt("ret", paramObject.ret);
      localEIPCResult.data.putString("sharemsg", paramObject.sharemsg);
      localEIPCResult.data.putString("errmsg", paramObject.errmsg);
      this.jdField_a_of_type_EipcEIPCModule.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhdb
 * JD-Core Version:    0.7.0.1
 */