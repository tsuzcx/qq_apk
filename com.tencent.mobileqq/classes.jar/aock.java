import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class aock
  extends LbsManagerService.OnLocationChangeListener
{
  aock(aocj paramaocj, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.d("RedPointLog.RedpointHandler", 1, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    aocj.a(this.a, paramInt, paramSosoLbsInfo, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aock
 * JD-Core Version:    0.7.0.1
 */