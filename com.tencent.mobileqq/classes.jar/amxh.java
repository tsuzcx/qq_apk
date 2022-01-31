import com.tencent.mobileqq.ar.aidl.ARCommonConfigInfo.NativeSoRes;
import com.tencent.qphone.base.util.QLog;

class amxh
  implements andm
{
  amxh(amxf paramamxf, ARCommonConfigInfo.NativeSoRes paramNativeSoRes) {}
  
  public void a()
  {
    andm localandm = amxf.a(this.jdField_a_of_type_Amxf, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localandm != null) {
      localandm.a();
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    andm localandm = amxf.a(this.jdField_a_of_type_Amxf, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localandm != null) {
      localandm.a(paramLong1, paramLong2);
    }
  }
  
  public void a(boolean paramBoolean, andn paramandn)
  {
    QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes onARResourceDownloadComplete. result = " + paramBoolean + ", name = " + this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a + ", filename = " + paramandn.c + ", url = " + paramandn.a);
    if (paramBoolean) {
      if (!amxf.a(this.jdField_a_of_type_Amxf, paramandn.c, paramandn.b))
      {
        amxf.a(this.jdField_a_of_type_Amxf, paramandn.c);
        QLog.i("AREngine_ArNativeSoManager", 1, "downloadSoRes failed. checkFileValid failed.");
      }
    }
    andm localandm;
    do
    {
      return;
      if (this.jdField_a_of_type_Amxf.a(paramandn.d, paramandn.c, paramandn.b) == 0) {}
      localandm = amxf.a(this.jdField_a_of_type_Amxf, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    } while (localandm == null);
    localandm.a(paramBoolean, paramandn);
  }
  
  public void b()
  {
    andm localandm = amxf.a(this.jdField_a_of_type_Amxf, this.jdField_a_of_type_ComTencentMobileqqArAidlARCommonConfigInfo$NativeSoRes.a);
    if (localandm != null) {
      localandm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxh
 * JD-Core Version:    0.7.0.1
 */