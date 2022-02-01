import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

public final class bobm
  implements INetEngine.INetEngineListener
{
  public bobm(bobn parambobn, bobg parambobg, String paramString) {}
  
  public void onResp(NetResp paramNetResp)
  {
    boolean bool2 = true;
    bnqm localbnqm;
    if ((paramNetResp != null) && (paramNetResp.mResult == 0))
    {
      bool1 = true;
      bnrh.b("AEEditorMusicHelper", "[downloadMusic], onResp, succeeded=" + bool1);
      if (this.jdField_a_of_type_Bobn != null) {
        this.jdField_a_of_type_Bobn.a(this.jdField_a_of_type_Bobg, bool1, this.jdField_a_of_type_JavaLangString);
      }
      if (paramNetResp != null)
      {
        localbnqm = bnqm.a();
        if (paramNetResp.mResult != 0) {
          break label113;
        }
      }
    }
    label113:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localbnqm.a(bool1, 5, "AEEditorMusicDownload", this.jdField_a_of_type_Bobg.a(), paramNetResp.mErrCode, paramNetResp.reqCost);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bobm
 * JD-Core Version:    0.7.0.1
 */