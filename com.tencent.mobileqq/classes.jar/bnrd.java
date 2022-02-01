import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class bnrd
  implements INetEngine.INetEngineListener
{
  private bnrc jdField_a_of_type_Bnrc;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bnrd(String paramString1, String paramString2, bnrc parambnrc)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Bnrc = parambnrc;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    bnrh.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + paramNetResp.mResult);
    if (this.jdField_a_of_type_Bnrc != null) {
      this.jdField_a_of_type_Bnrc.a(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bnrc != null) {
      this.jdField_a_of_type_Bnrc.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnrd
 * JD-Core Version:    0.7.0.1
 */