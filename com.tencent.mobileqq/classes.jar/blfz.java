import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class blfz
  implements INetEngine.INetEngineListener
{
  blfz(blfu paramblfu, blgg paramblgg, String paramString1, String paramString2) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (paramNetResp.mResult == 3) {
      return;
    }
    if (paramNetResp.mResult == 0) {}
    for (boolean bool = true;; bool = false)
    {
      int i = paramNetResp.mErrCode;
      this.jdField_a_of_type_Blgg.a(this.jdField_a_of_type_JavaLangString, this.b, bool, paramNetResp.mErrDesc, i);
      return;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Blgg.a(this.jdField_a_of_type_JavaLangString, paramLong2, (float)paramLong1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blfz
 * JD-Core Version:    0.7.0.1
 */