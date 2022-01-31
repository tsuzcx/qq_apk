import NS_USER_ACTION_REPORT.ActionInfo;

class bhdx
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private long b;
  
  public bhdx(long paramLong, int paramInt)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public bhdx(long paramLong1, int paramInt, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramLong2;
  }
  
  public ActionInfo a()
  {
    ActionInfo localActionInfo = new ActionInfo();
    localActionInfo.oper_time = this.jdField_a_of_type_Long;
    localActionInfo.action_id = this.jdField_a_of_type_Int;
    localActionInfo.action_value = this.b;
    return localActionInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhdx
 * JD-Core Version:    0.7.0.1
 */