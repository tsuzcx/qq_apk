import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class bhqw
  implements bhls
{
  bhqw(bhqv parambhqv) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = ajyc.a(2131712345);
      bhqv.d(this.a, paramBaseResp);
    }
    for (;;)
    {
      bhqv.a(this.a, bhqv.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = ajyc.a(2131712336);
        bhqv.d(this.a, paramBaseResp);
      }
      else
      {
        paramBaseResp = ajyc.a(2131712333);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhqw
 * JD-Core Version:    0.7.0.1
 */