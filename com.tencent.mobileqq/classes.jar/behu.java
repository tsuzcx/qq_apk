import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class behu
  implements Manager
{
  private long a;
  public beht a;
  
  public behu(QQAppInterface paramQQAppInterface) {}
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public beht a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Beht != null)) {
      this.jdField_a_of_type_Beht.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Beht = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Beht != null) {
      this.jdField_a_of_type_Beht.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Beht;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public beht a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.app, paramString))
    {
      if (!(this.jdField_a_of_type_Beht instanceof beqp)) {
        this.jdField_a_of_type_Beht = new beqp(paramTroopChatPie.app, paramTroopChatPie.getActivity(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Beht;
      if (TroopInfo.isFansTroop(paramTroopChatPie.app, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Beht = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Beht != null) {
      this.jdField_a_of_type_Beht.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Beht instanceof beqp)) {
      this.jdField_a_of_type_Beht.a(beyy.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beht != null) {
      this.jdField_a_of_type_Beht.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Beht != null) {
      this.jdField_a_of_type_Beht.b();
    }
    this.jdField_a_of_type_Beht = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Beht != null) {
      this.jdField_a_of_type_Beht.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     behu
 * JD-Core Version:    0.7.0.1
 */