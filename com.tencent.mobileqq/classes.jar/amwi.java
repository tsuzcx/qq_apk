import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class amwi
  implements QQPermissionCallback
{
  amwi(amwd paramamwd) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new amwl();
    paramArrayOfString.a = 2;
    amxd.a(this.a.a.recognitions, amwd.a(this.a), paramArrayOfString);
    if (amwd.a(this.a) != null) {
      amwd.a(this.a).a(0, amwd.a(this.a));
    }
    amwd.a(this.a, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwi
 * JD-Core Version:    0.7.0.1
 */