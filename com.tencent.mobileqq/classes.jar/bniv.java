import eipc.EIPCResult;
import java.util.List;

class bniv
  implements bnkw
{
  private int jdField_a_of_type_Int;
  private int b;
  private int c;
  
  public bniv(bnis parambnis, int paramInt)
  {
    this.c = paramInt;
  }
  
  public void onAEDownloadFinish(bnkt parambnkt, String paramString, boolean paramBoolean, int paramInt)
  {
    bnrh.b("AECMShowQipcModule", "CmShowAEDownloadCallBack, localFilePath=" + paramString + ", downloaded=" + paramBoolean + ", errorType=" + paramInt);
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Int += 1;
        if (this.jdField_a_of_type_Int + this.b == bnis.a(this.jdField_a_of_type_Bnis).size())
        {
          parambnkt = new EIPCResult();
          if (this.b == 0) {
            break;
          }
          parambnkt.code = -1;
          this.jdField_a_of_type_Bnis.callbackResult(this.c, parambnkt);
        }
        return;
      }
      finally {}
      this.b += 1;
    }
    parambnkt.code = 0;
    this.jdField_a_of_type_Bnis.callbackResult(this.c, parambnkt);
  }
  
  public void onAEProgressUpdate(bnkt parambnkt, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniv
 * JD-Core Version:    0.7.0.1
 */