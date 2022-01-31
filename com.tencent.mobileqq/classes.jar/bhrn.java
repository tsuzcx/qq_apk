import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class bhrn
  implements bhmj
{
  bhrn(bhrm parambhrm) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = ajya.a(2131712356);
      bhrm.d(this.a, paramBaseResp);
    }
    for (;;)
    {
      bhrm.a(this.a, bhrm.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = ajya.a(2131712347);
        bhrm.d(this.a, paramBaseResp);
      }
      else
      {
        paramBaseResp = ajya.a(2131712344);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhrn
 * JD-Core Version:    0.7.0.1
 */