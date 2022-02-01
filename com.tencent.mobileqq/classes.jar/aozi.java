import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import mqq.app.QQPermissionCallback;

class aozi
  implements QQPermissionCallback
{
  aozi(aozd paramaozd) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    paramArrayOfString = new aozl();
    paramArrayOfString.a = 2;
    apad.a(this.a.a.recognitions, aozd.a(this.a), paramArrayOfString);
    if (aozd.a(this.a) != null) {
      aozd.a(this.a).a(0, aozd.a(this.a));
    }
    aozd.a(this.a, null);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.a.grant();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozi
 * JD-Core Version:    0.7.0.1
 */