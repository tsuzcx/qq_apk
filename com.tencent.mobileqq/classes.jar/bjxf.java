import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.qphone.base.util.QLog;

class bjxf
  implements bjsb
{
  bjxf(bjxe parambjxe) {}
  
  public void a(BaseResp paramBaseResp)
  {
    int i = 1;
    int j = paramBaseResp.errCode;
    if (j == 0)
    {
      i = 0;
      paramBaseResp = alud.a(2131712740);
      bjxe.d(this.a, paramBaseResp);
    }
    for (;;)
    {
      bjxe.a(this.a, bjxe.a(this.a), i, paramBaseResp);
      return;
      if (j == -2)
      {
        paramBaseResp = alud.a(2131712731);
        bjxe.d(this.a, paramBaseResp);
      }
      else
      {
        paramBaseResp = alud.a(2131712728);
        QLog.e("QZoneSharePictureJsPlugin", 1, "wx share fail:" + j);
        i = j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjxf
 * JD-Core Version:    0.7.0.1
 */