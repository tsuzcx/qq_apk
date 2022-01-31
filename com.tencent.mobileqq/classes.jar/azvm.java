import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class azvm
  implements Manager
{
  private long a;
  public azvl a;
  
  public azvm(QQAppInterface paramQQAppInterface) {}
  
  public azvl a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Azvl != null)) {
      this.jdField_a_of_type_Azvl.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Azvl = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Azvl != null) {
      this.jdField_a_of_type_Azvl.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Azvl;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public azvl a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.a, paramString))
    {
      if (!(this.jdField_a_of_type_Azvl instanceof badx)) {
        this.jdField_a_of_type_Azvl = new badx(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Azvl;
      if (TroopInfo.isFansTroop(paramTroopChatPie.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Azvl = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Azvl != null) {
      this.jdField_a_of_type_Azvl.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Azvl instanceof badx)) {
      this.jdField_a_of_type_Azvl.a(bahy.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Azvl != null) {
      this.jdField_a_of_type_Azvl.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Azvl != null) {
      this.jdField_a_of_type_Azvl.b();
    }
    this.jdField_a_of_type_Azvl = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Azvl != null) {
      this.jdField_a_of_type_Azvl.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azvm
 * JD-Core Version:    0.7.0.1
 */