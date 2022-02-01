import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

class aogg
  extends apck
{
  aogg(aogf paramaogf, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QLog.d("RedPointLog.RedpointHandler", 1, "onLocationFinish errCode:" + paramInt + ",info:" + paramSosoLbsInfo);
    aogf.a(this.a, paramInt, paramSosoLbsInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogg
 * JD-Core Version:    0.7.0.1
 */