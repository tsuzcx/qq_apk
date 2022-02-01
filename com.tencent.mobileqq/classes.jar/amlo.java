import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

final class amlo
  extends apck
{
  amlo(String paramString, boolean paramBoolean, NewIntent paramNewIntent, QQAppInterface paramQQAppInterface)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("weatherManager", 2, "startLocation onLocationFinish");
    }
    StringBuilder localStringBuilder;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("errCode ：").append(paramInt).append(" info is null ---> ");
      if (paramSosoLbsInfo != null) {
        break label158;
      }
      bool = true;
    }
    for (;;)
    {
      QLog.d("weatherManager", 2, bool);
      int i = j;
      if (paramInt == 0)
      {
        i = j;
        if (paramSosoLbsInfo != null)
        {
          i = j;
          if (paramSosoLbsInfo.a == null) {}
        }
      }
      try
      {
        i = Integer.parseInt(paramSosoLbsInfo.a.f);
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "LocalInfo" + i);
        }
        this.jdField_a_of_type_MqqAppNewIntent.putExtra("adcode", i);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(this.jdField_a_of_type_MqqAppNewIntent);
        return;
        label158:
        bool = false;
      }
      catch (Throwable paramSosoLbsInfo)
      {
        for (;;)
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.e("weatherManager", 2, paramSosoLbsInfo, new Object[0]);
            i = j;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amlo
 * JD-Core Version:    0.7.0.1
 */