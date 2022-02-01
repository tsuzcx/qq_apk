import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class apjo
  implements appt
{
  apjo(apjm paramapjm, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    appt localappt = apjm.a(this.jdField_a_of_type_Apjm, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localappt != null) {
      localappt.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    appt localappt = apjm.a(this.jdField_a_of_type_Apjm, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localappt != null) {
      localappt.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, appu paramappu)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramappu.c + ", url = " + paramappu.a);
    if (paramBoolean) {
      if (!apjm.a(this.jdField_a_of_type_Apjm, paramappu.c, paramappu.b))
      {
        apjm.a(this.jdField_a_of_type_Apjm, paramappu.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    appt localappt;
    do
    {
      return;
      if (this.jdField_a_of_type_Apjm.a(paramappu.d, paramappu.c, paramappu.b) == 0) {}
      localappt = apjm.a(this.jdField_a_of_type_Apjm, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localappt == null);
    localappt.a(paramBoolean, paramappu);
  }
  
  public void b()
  {
    appt localappt = apjm.a(this.jdField_a_of_type_Apjm, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localappt != null) {
      localappt.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apjo
 * JD-Core Version:    0.7.0.1
 */