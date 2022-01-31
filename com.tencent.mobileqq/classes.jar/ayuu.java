import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ayuu
  implements Manager
{
  private long a;
  public ayut a;
  
  public ayuu(QQAppInterface paramQQAppInterface) {}
  
  public ayut a(long paramLong, boolean paramBoolean, aejb paramaejb, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Ayut != null)) {
      this.jdField_a_of_type_Ayut.a(false, paramaejb, paramBoolean);
    }
    this.jdField_a_of_type_Ayut = a(paramaejb, paramString);
    if (this.jdField_a_of_type_Ayut != null) {
      this.jdField_a_of_type_Ayut.a(true, paramaejb, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Ayut;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public ayut a(aejb paramaejb, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramaejb.a, paramString))
    {
      if (!(this.jdField_a_of_type_Ayut instanceof azco)) {
        this.jdField_a_of_type_Ayut = new azco(paramaejb.a, paramaejb.a(), paramaejb);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Ayut;
      if (TroopInfo.isFansTroop(paramaejb.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Ayut = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Ayut != null) {
      this.jdField_a_of_type_Ayut.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Ayut instanceof azco)) {
      this.jdField_a_of_type_Ayut.a(azgh.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ayut != null) {
      this.jdField_a_of_type_Ayut.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Ayut != null) {
      this.jdField_a_of_type_Ayut.b();
    }
    this.jdField_a_of_type_Ayut = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Ayut != null) {
      this.jdField_a_of_type_Ayut.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayuu
 * JD-Core Version:    0.7.0.1
 */