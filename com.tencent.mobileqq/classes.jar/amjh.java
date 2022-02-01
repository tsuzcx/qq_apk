import com.tencent.qphone.base.util.QLog;

class amjh
  extends aofu
{
  amjh(amjc paramamjc) {}
  
  protected void onAddRobot(boolean paramBoolean, int paramInt, long paramLong1, long paramLong2)
  {
    String str = String.valueOf(paramLong1);
    if ((str != null) && (str.equals(amjc.a(this.a))))
    {
      amjc.a(this.a, String.valueOf(paramLong2), paramBoolean, paramInt);
      QLog.d("RobotAdapter", 2, "onAddRobot  success" + paramBoolean + " resultCode " + paramInt);
      return;
    }
    QLog.i("RobotAdapter", 2, "onAddRobot  troop" + paramLong1 + " cur " + amjc.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjh
 * JD-Core Version:    0.7.0.1
 */