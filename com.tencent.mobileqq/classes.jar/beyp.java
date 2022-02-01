import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class beyp
  implements Manager
{
  private long a;
  public beyo a;
  
  public beyp(QQAppInterface paramQQAppInterface) {}
  
  public beyo a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Beyo != null)) {
      this.jdField_a_of_type_Beyo.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Beyo = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Beyo != null) {
      this.jdField_a_of_type_Beyo.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Beyo;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public beyo a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.a, paramString))
    {
      if (!(this.jdField_a_of_type_Beyo instanceof bfhg)) {
        this.jdField_a_of_type_Beyo = new bfhg(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Beyo;
      if (TroopInfo.isFansTroop(paramTroopChatPie.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Beyo = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Beyo != null) {
      this.jdField_a_of_type_Beyo.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Beyo instanceof bfhg)) {
      this.jdField_a_of_type_Beyo.a(bfpj.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Beyo != null) {
      this.jdField_a_of_type_Beyo.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Beyo != null) {
      this.jdField_a_of_type_Beyo.b();
    }
    this.jdField_a_of_type_Beyo = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Beyo != null) {
      this.jdField_a_of_type_Beyo.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyp
 * JD-Core Version:    0.7.0.1
 */