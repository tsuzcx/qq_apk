import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class azvk
  implements Manager
{
  private long a;
  public azvj a;
  
  public azvk(QQAppInterface paramQQAppInterface) {}
  
  public azvj a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Azvj != null)) {
      this.jdField_a_of_type_Azvj.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Azvj = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Azvj != null) {
      this.jdField_a_of_type_Azvj.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Azvj;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public azvj a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.a, paramString))
    {
      if (!(this.jdField_a_of_type_Azvj instanceof badj)) {
        this.jdField_a_of_type_Azvj = new badj(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Azvj;
      if (TroopInfo.isFansTroop(paramTroopChatPie.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Azvj = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azvj != null) {
      this.jdField_a_of_type_Azvj.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Azvj instanceof badj)) {
      this.jdField_a_of_type_Azvj.a(bahk.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azvj != null) {
      this.jdField_a_of_type_Azvj.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azvj != null) {
      this.jdField_a_of_type_Azvj.b();
    }
    this.jdField_a_of_type_Azvj = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Azvj != null) {
      this.jdField_a_of_type_Azvj.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvk
 * JD-Core Version:    0.7.0.1
 */