import cooperation.qzone.statistic.access.concept.Collector;

public class bgdz
  extends bgec
{
  protected int a;
  protected long a;
  protected boolean a;
  
  public bgdz(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = 30000L;
    this.jdField_a_of_type_Int = 50;
    this.jdField_a_of_type_Boolean = true;
    a(paramLong);
    a(paramInt);
    a(paramBoolean);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a(Collector paramCollector)
  {
    int i;
    int j;
    label30:
    int k;
    if (paramCollector.a().a() > 0)
    {
      i = 1;
      if (System.currentTimeMillis() - paramCollector.a() <= this.jdField_a_of_type_Long) {
        break label89;
      }
      j = 1;
      if (paramCollector.a().a() < this.jdField_a_of_type_Int) {
        break label94;
      }
      k = 1;
      label47:
      if ((!this.jdField_a_of_type_Boolean) || (!paramCollector.a())) {
        break label100;
      }
    }
    label89:
    label94:
    label100:
    for (int m = 1;; m = 0)
    {
      if ((i == 0) || ((j == 0) && (k == 0) && (m == 0))) {
        break label106;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label30;
      k = 0;
      break label47;
    }
    label106:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgdz
 * JD-Core Version:    0.7.0.1
 */