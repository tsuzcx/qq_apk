import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class aovy
  implements apcd
{
  aovy(aovw paramaovw, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    apcd localapcd = aovw.a(this.jdField_a_of_type_Aovw, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapcd != null) {
      localapcd.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    apcd localapcd = aovw.a(this.jdField_a_of_type_Aovw, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapcd != null) {
      localapcd.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, apce paramapce)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramapce.c + ", url = " + paramapce.a);
    if (paramBoolean) {
      if (!aovw.a(this.jdField_a_of_type_Aovw, paramapce.c, paramapce.b))
      {
        aovw.a(this.jdField_a_of_type_Aovw, paramapce.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    apcd localapcd;
    do
    {
      return;
      if (this.jdField_a_of_type_Aovw.a(paramapce.d, paramapce.c, paramapce.b) == 0) {}
      localapcd = aovw.a(this.jdField_a_of_type_Aovw, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localapcd == null);
    localapcd.a(paramBoolean, paramapce);
  }
  
  public void b()
  {
    apcd localapcd = aovw.a(this.jdField_a_of_type_Aovw, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localapcd != null) {
      localapcd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aovy
 * JD-Core Version:    0.7.0.1
 */