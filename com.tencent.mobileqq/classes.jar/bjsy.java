import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class bjsy
  implements bjnu
{
  bjsy(bjsx parambjsx) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = alpo.a(2131712728);
      bjsx.d(this.a, paramBaseResp);
    }
    for (;;)
    {
      bjsx.a(this.a, bjsx.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = alpo.a(2131712719);
        bjsx.d(this.a, paramBaseResp);
      }
      else
      {
        paramBaseResp = alpo.a(2131712716);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjsy
 * JD-Core Version:    0.7.0.1
 */