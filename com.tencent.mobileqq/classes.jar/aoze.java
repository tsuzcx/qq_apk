import android.os.Handler;
import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo;
import com.tencent.qphone.base.util.QLog;

class aoze
  implements aoyt
{
  aoze(aozd paramaozd) {}
  
  public void a(aozl paramaozl)
  {
    aozd.f(this.a, false);
    if (aozd.a(this.a)) {
      return;
    }
    if (aozd.a(this.a) != null) {
      aozd.a(this.a).removeMessages(2);
    }
    QLog.i("AREngine_ARCloudControl", 1, "onARCloudLBSLocationCheckComplete. retCode = " + paramaozl.jdField_a_of_type_Int + ", imageId = " + paramaozl.jdField_a_of_type_JavaLangString);
    if (aozd.a(this.a) != null)
    {
      apad.a(this.a.a.recognitions, aozd.a(this.a), paramaozl);
      aozd.a(this.a).a(0, aozd.a(this.a));
    }
    aozd.a(this.a, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoze
 * JD-Core Version:    0.7.0.1
 */