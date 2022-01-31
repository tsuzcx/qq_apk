import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class amwe
  implements amvn
{
  amwe(amwd paramamwd) {}
  
  public void a(amwl paramamwl)
  {
    amwd.f(this.a, false);
    if (amwd.a(this.a)) {
      return;
    }
    if (amwd.a(this.a) != null) {
      amwd.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramamwl.jdField_a_of_type_Int + ", imageId = " + paramamwl.jdField_a_of_type_JavaLangString);
    if (amwd.a(this.a) != null)
    {
      amxd.a(this.a.a.recognitions, amwd.a(this.a), paramamwl);
      amwd.a(this.a).a(0, amwd.a(this.a));
    }
    amwd.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amwe
 * JD-Core Version:    0.7.0.1
 */