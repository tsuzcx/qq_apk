import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bbye
  implements Manager
{
  private long a;
  public bbyd a;
  
  public bbye(QQAppInterface paramQQAppInterface) {}
  
  public bbyd a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Bbyd != null)) {
      this.jdField_a_of_type_Bbyd.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Bbyd = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Bbyd != null) {
      this.jdField_a_of_type_Bbyd.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Bbyd;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public bbyd a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.a, paramString))
    {
      if (!(this.jdField_a_of_type_Bbyd instanceof bcgs)) {
        this.jdField_a_of_type_Bbyd = new bcgs(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Bbyd;
      if (TroopInfo.isFansTroop(paramTroopChatPie.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Bbyd = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bbyd != null) {
      this.jdField_a_of_type_Bbyd.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bbyd instanceof bcgs)) {
      this.jdField_a_of_type_Bbyd.a(bckt.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bbyd != null) {
      this.jdField_a_of_type_Bbyd.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbyd != null) {
      this.jdField_a_of_type_Bbyd.b();
    }
    this.jdField_a_of_type_Bbyd = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bbyd != null) {
      this.jdField_a_of_type_Bbyd.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbye
 * JD-Core Version:    0.7.0.1
 */