import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class bgid
  implements bgdf
{
  bgid(bgic parambgic) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = ajjy.a(2131646557);
      bgic.d(this.a, paramBaseResp);
    }
    for (;;)
    {
      bgic.a(this.a, bgic.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = ajjy.a(2131646548);
        bgic.d(this.a, paramBaseResp);
      }
      else
      {
        paramBaseResp = ajjy.a(2131646545);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgid
 * JD-Core Version:    0.7.0.1
 */