import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class aodb
  implements aojg
{
  aodb(aocz paramaocz, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    aojg localaojg = aocz.a(this.jdField_a_of_type_Aocz, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localaojg != null) {
      localaojg.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    aojg localaojg = aocz.a(this.jdField_a_of_type_Aocz, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localaojg != null) {
      localaojg.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, aojh paramaojh)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramaojh.c + ", url = " + paramaojh.a);
    if (paramBoolean) {
      if (!aocz.a(this.jdField_a_of_type_Aocz, paramaojh.c, paramaojh.b))
      {
        aocz.a(this.jdField_a_of_type_Aocz, paramaojh.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    aojg localaojg;
    do
    {
      return;
      if (this.jdField_a_of_type_Aocz.a(paramaojh.d, paramaojh.c, paramaojh.b) == 0) {}
      localaojg = aocz.a(this.jdField_a_of_type_Aocz, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localaojg == null);
    localaojg.a(paramBoolean, paramaojh);
  }
  
  public void b()
  {
    aojg localaojg = aocz.a(this.jdField_a_of_type_Aocz, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localaojg != null) {
      localaojg.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodb
 * JD-Core Version:    0.7.0.1
 */