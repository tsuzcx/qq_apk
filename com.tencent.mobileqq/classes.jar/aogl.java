import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class aogl
  implements QQPermissionCallback
{
  aogl(aogg paramaogg) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new aogo();
    paramArrayOfString.a = 2;
    aohg.a(this.a.a.recognitions, aogg.a(this.a), paramArrayOfString);
    if (aogg.a(this.a) != null) {
      aogg.a(this.a).a(0, aogg.a(this.a));
    }
    aogg.a(this.a, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogl
 * JD-Core Version:    0.7.0.1
 */