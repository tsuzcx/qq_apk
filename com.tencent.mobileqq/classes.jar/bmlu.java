import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public final class bmlu
  implements INetEngine.INetEngineListener
{
  public bmlu(bmlv parambmlv, bmlo parambmlo, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    bmbc localbmbc;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0))
    {
      bool1 = true;
      bmbx.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Bmlv != null) {
        this.jdField_a_of_type_Bmlv.a(this.jdField_a_of_type_Bmlo, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (paramNetResp != null)
      {
        localbmbc = bmbc.a();
        if (paramNetResp.mResult != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbmbc.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bmlo.a(), paramNetResp.mErrCode, paramNetResp.reqCost);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmlu
 * JD-Core Version:    0.7.0.1
 */