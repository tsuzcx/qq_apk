import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class barm
  implements aycb
{
  public int a;
  public long a;
  public long b;
  public long c;
  
  barm(bara parambara)
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a()
  {
    this.c = NetConnInfoCenter.getServerTimeMillis();
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i(".troop.send_giftTroopGiftAnimationController", 2, "animation frame end. requestState:" + this.jdField_a_of_type_Int);
      }
      return;
      this.jdField_a_of_type_Bara.a(0L);
      continue;
      this.jdField_a_of_type_Bara.a(3000L);
      continue;
      long l = this.c - this.b;
      if (l >= 2000L)
      {
        this.jdField_a_of_type_Bara.a(0L);
      }
      else
      {
        this.jdField_a_of_type_Bara.a(2000L - l);
        continue;
        this.jdField_a_of_type_Bara.a(3000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     barm
 * JD-Core Version:    0.7.0.1
 */