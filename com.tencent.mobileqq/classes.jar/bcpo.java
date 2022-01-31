import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class bcpo
  extends akgd
{
  bcpo(bcpn parambcpn, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, int paramInt2, String paramString3, int paramInt3, String paramString4, String paramString5, String paramString6)
  {
    super(paramInt1, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString1);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    double d2 = 0.0D;
    if (QLog.isColorLevel()) {
      QLog.d("QidianManager", 2, "onLocationFinish(): BEGIN errCode=" + paramInt);
    }
    String str;
    double d1;
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null)) {
      if (paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString != null)
      {
        str = paramSosoLbsInfo.a.jdField_b_of_type_JavaLangString;
        if (QLog.isColorLevel()) {
          QLog.d("QidianManager", 2, "onLocationFinish() latitude=" + paramSosoLbsInfo.a.a + ", longitude=" + paramSosoLbsInfo.a.jdField_b_of_type_Double + ", address=" + str);
        }
        d1 = paramSosoLbsInfo.a.a;
        d2 = paramSosoLbsInfo.a.jdField_b_of_type_Double;
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcpn.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, true, d1, d2, this.jdField_b_of_type_JavaLangString, this.jdField_b_of_type_Int, this.c, this.d, this.e);
      return;
      str = "";
      break;
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     bcpo
 * JD-Core Version:    0.7.0.1
 */