import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;

class bcvd
  implements baej
{
  public int a;
  public long a;
  public long b;
  public long c;
  
  bcvd(bcur parambcur)
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
      this.jdField_a_of_type_Bcur.a(0L);
      continue;
      this.jdField_a_of_type_Bcur.a(3000L);
      continue;
      long l = this.c - this.b;
      if (l >= 2000L)
      {
        this.jdField_a_of_type_Bcur.a(0L);
      }
      else
      {
        this.jdField_a_of_type_Bcur.a(2000L - l);
        continue;
        this.jdField_a_of_type_Bcur.a(3000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcvd
 * JD-Core Version:    0.7.0.1
 */