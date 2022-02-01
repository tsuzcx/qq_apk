import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class bfyj
  implements Manager
{
  private long a;
  public bfyi a;
  
  public bfyj(QQAppInterface paramQQAppInterface) {}
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bfyi a(long paramLong, boolean paramBoolean, TroopChatPie paramTroopChatPie, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopClassControllerMan", 2, "updateTroopAioClassUI troopClassType" + paramLong + ", currentTroopClassType" + this.jdField_a_of_type_Long);
    }
    if ((paramLong != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_Bfyi != null)) {
      this.jdField_a_of_type_Bfyi.a(false, paramTroopChatPie, paramBoolean);
    }
    this.jdField_a_of_type_Bfyi = a(paramTroopChatPie, paramString);
    if (this.jdField_a_of_type_Bfyi != null) {
      this.jdField_a_of_type_Bfyi.a(true, paramTroopChatPie, paramBoolean);
    }
    for (;;)
    {
      this.jdField_a_of_type_Long = paramLong;
      return this.jdField_a_of_type_Bfyi;
      if (QLog.isColorLevel()) {
        QLog.d("TroopClassControllerMan", 2, "currenTroopClassController is null!!!");
      }
    }
  }
  
  public bfyi a(TroopChatPie paramTroopChatPie, String paramString)
  {
    if (TroopInfo.isHomeworkTroop(paramTroopChatPie.a, paramString))
    {
      if (!(this.jdField_a_of_type_Bfyi instanceof bghh)) {
        this.jdField_a_of_type_Bfyi = new bghh(paramTroopChatPie.a, paramTroopChatPie.a(), paramTroopChatPie);
      }
      this.jdField_a_of_type_Long = 32L;
    }
    for (;;)
    {
      return this.jdField_a_of_type_Bfyi;
      if (TroopInfo.isFansTroop(paramTroopChatPie.a, paramString))
      {
        this.jdField_a_of_type_Long = 27L;
      }
      else
      {
        this.jdField_a_of_type_Bfyi = null;
        this.jdField_a_of_type_Long = 0L;
        if (QLog.isColorLevel()) {
          QLog.d("TroopClassControllerMan", 2, "getControllerByTroopUin null " + paramString);
        }
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Bfyi != null) {
      this.jdField_a_of_type_Bfyi.c();
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bfyi instanceof bghh)) {
      this.jdField_a_of_type_Bfyi.a(bgpk.b(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Bfyi != null) {
      this.jdField_a_of_type_Bfyi.b(paramBoolean);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bfyi != null) {
      this.jdField_a_of_type_Bfyi.b();
    }
    this.jdField_a_of_type_Bfyi = null;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Bfyi != null) {
      this.jdField_a_of_type_Bfyi.a();
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyj
 * JD-Core Version:    0.7.0.1
 */