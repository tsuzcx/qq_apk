import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class apgd
  implements apmi
{
  apgd(apgb paramapgb, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    apmi localapmi = apgb.a(this.jdField_a_of_type_Apgb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapmi != null) {
      localapmi.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    apmi localapmi = apgb.a(this.jdField_a_of_type_Apgb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapmi != null) {
      localapmi.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, apmj paramapmj)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramapmj.c + ", url = " + paramapmj.a);
    if (paramBoolean) {
      if (!apgb.a(this.jdField_a_of_type_Apgb, paramapmj.c, paramapmj.b))
      {
        apgb.a(this.jdField_a_of_type_Apgb, paramapmj.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    apmi localapmi;
    do
    {
      return;
      if (this.jdField_a_of_type_Apgb.a(paramapmj.d, paramapmj.c, paramapmj.b) == 0) {}
      localapmi = apgb.a(this.jdField_a_of_type_Apgb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localapmi == null);
    localapmi.a(paramBoolean, paramapmj);
  }
  
  public void b()
  {
    apmi localapmi = apgb.a(this.jdField_a_of_type_Apgb, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapmi != null) {
      localapmi.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apgd
 * JD-Core Version:    0.7.0.1
 */