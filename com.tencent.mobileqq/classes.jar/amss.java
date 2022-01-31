import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class amss
  implements amzd
{
  amss(amsq paramamsq, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    amzd localamzd = amsq.a(this.jdField_a_of_type_Amsq, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localamzd != null) {
      localamzd.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    amzd localamzd = amsq.a(this.jdField_a_of_type_Amsq, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localamzd != null) {
      localamzd.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, amze paramamze)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramamze.c + ", url = " + paramamze.a);
    if (paramBoolean) {
      if (!amsq.a(this.jdField_a_of_type_Amsq, paramamze.c, paramamze.b))
      {
        amsq.a(this.jdField_a_of_type_Amsq, paramamze.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    amzd localamzd;
    do
    {
      return;
      if (this.jdField_a_of_type_Amsq.a(paramamze.d, paramamze.c, paramamze.b) == 0) {}
      localamzd = amsq.a(this.jdField_a_of_type_Amsq, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localamzd == null);
    localamzd.a(paramBoolean, paramamze);
  }
  
  public void b()
  {
    amzd localamzd = amsq.a(this.jdField_a_of_type_Amsq, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localamzd != null) {
      localamzd.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amss
 * JD-Core Version:    0.7.0.1
 */