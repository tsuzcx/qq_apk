import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class apmu
  implements apmj
{
  apmu(apmt paramapmt) {}
  
  public void a(apnb paramapnb)
  {
    apmt.f(this.a, false);
    if (apmt.a(this.a)) {
      return;
    }
    if (apmt.a(this.a) != null) {
      apmt.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramapnb.jdField_a_of_type_Int + ", imageId = " + paramapnb.jdField_a_of_type_JavaLangString);
    if (apmt.a(this.a) != null)
    {
      apnt.a(this.a.a.recognitions, apmt.a(this.a), paramapnb);
      apmt.a(this.a).a(0, apmt.a(this.a));
    }
    apmt.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmu
 * JD-Core Version:    0.7.0.1
 */