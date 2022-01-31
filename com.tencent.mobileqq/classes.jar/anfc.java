import CardPay.LBSInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.thirdpay.ThirdPayManager;

public final class anfc
  extends SosoInterface.OnLocationListener
{
  public anfc(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, QQAppInterface paramQQAppInterface)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    String str;
    if (QLog.isColorLevel())
    {
      if (paramSosoLbsInfo == null)
      {
        str = "soso lbs info null.";
        QLog.i("ThirdPayManager", 2, str);
      }
    }
    else {
      if ((paramInt != 0) || (paramSosoLbsInfo == null)) {
        break label110;
      }
    }
    label110:
    for (paramSosoLbsInfo = new LBSInfo(paramSosoLbsInfo.a.jdField_a_of_type_Double, paramSosoLbsInfo.a.b, paramSosoLbsInfo.a.jdField_e_of_type_Double, paramSosoLbsInfo.a.jdField_a_of_type_Float, paramSosoLbsInfo.a.d, paramSosoLbsInfo.a.jdField_e_of_type_JavaLangString, paramSosoLbsInfo.a.g, paramSosoLbsInfo.a.h);; paramSosoLbsInfo = new LBSInfo())
    {
      ThirdPayManager.a(this.a, paramSosoLbsInfo);
      return;
      str = paramSosoLbsInfo.toString();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfc
 * JD-Core Version:    0.7.0.1
 */