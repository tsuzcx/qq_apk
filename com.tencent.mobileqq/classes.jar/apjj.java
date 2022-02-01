import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class apjj
  implements apiy
{
  apjj(apji paramapji) {}
  
  public void a(apjq paramapjq)
  {
    apji.f(this.a, false);
    if (apji.a(this.a)) {
      return;
    }
    if (apji.a(this.a) != null) {
      apji.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramapjq.jdField_a_of_type_Int + ", imageId = " + paramapjq.jdField_a_of_type_JavaLangString);
    if (apji.a(this.a) != null)
    {
      apki.a(this.a.a.recognitions, apji.a(this.a), paramapjq);
      apji.a(this.a).a(0, apji.a(this.a));
    }
    apji.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjj
 * JD-Core Version:    0.7.0.1
 */