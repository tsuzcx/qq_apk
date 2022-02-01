import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class aogh
  implements aofw
{
  aogh(aogg paramaogg) {}
  
  public void a(aogo paramaogo)
  {
    aogg.f(this.a, false);
    if (aogg.a(this.a)) {
      return;
    }
    if (aogg.a(this.a) != null) {
      aogg.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramaogo.jdField_a_of_type_Int + ", imageId = " + paramaogo.jdField_a_of_type_JavaLangString);
    if (aogg.a(this.a) != null)
    {
      aohg.a(this.a.a.recognitions, aogg.a(this.a), paramaogo);
      aogg.a(this.a).a(0, aogg.a(this.a));
    }
    aogg.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aogh
 * JD-Core Version:    0.7.0.1
 */