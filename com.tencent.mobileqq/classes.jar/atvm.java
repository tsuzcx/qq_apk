import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class atvm
  extends ampn
{
  public int a;
  public boolean a;
  public int b;
  
  public atvm(String paramString)
  {
    super(paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Int = ((int)(paramSosoLbsInfo.a.b * 1000000.0D));
      this.b = ((int)(paramSosoLbsInfo.a.a * 1000000.0D));
    }
    if (QLog.isColorLevel()) {
      QLog.i("LoginUserGuideHelper", 2, String.format("onLocationFinish [%s, %s, %s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.b) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atvm
 * JD-Core Version:    0.7.0.1
 */