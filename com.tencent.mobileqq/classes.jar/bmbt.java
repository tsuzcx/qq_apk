import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class bmbt
  implements INetEngine.INetEngineListener
{
  private bmbs jdField_a_of_type_Bmbs;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  bmbt(String paramString1, String paramString2, bmbs parambmbs)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Bmbs = parambmbs;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    bmbx.b("AEDownloader", "onResp url: " + this.jdField_a_of_type_JavaLangString + " resultcode: " + paramNetResp.mResult);
    if (this.jdField_a_of_type_Bmbs != null) {
      this.jdField_a_of_type_Bmbs.a(paramNetResp);
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    if (this.jdField_a_of_type_Bmbs != null) {
      this.jdField_a_of_type_Bmbs.a((int)((float)paramLong1 / (float)paramLong2 * 100.0F));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmbt
 * JD-Core Version:    0.7.0.1
 */