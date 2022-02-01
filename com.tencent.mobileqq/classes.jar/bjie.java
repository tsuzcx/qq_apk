import com.tencent.qqprotect.qsec.QSecFramework;

final class bjie
  implements bjit
{
  private long a;
  
  public bjie(long paramLong)
  {
    this.a = paramLong;
  }
  
  public void a(int paramInt, bjis parambjis, bjiu parambjiu)
  {
    long l1 = 0L;
    if (this.a != 0L)
    {
      if ((paramInt != 1) && (paramInt != 2) && (paramInt != 4)) {
        break label46;
      }
      QSecFramework.a(5L, this.a, paramInt, 0L, null, null, null, null);
    }
    label46:
    while (paramInt != 3) {
      return;
    }
    int i = parambjiu.jdField_a_of_type_Int;
    int j = parambjiu.b;
    int k = parambjiu.c;
    int m = parambjiu.d;
    parambjis = parambjiu.jdField_a_of_type_ArrayOfByte;
    long l2 = this.a;
    long l3 = paramInt;
    if (parambjiu.jdField_a_of_type_Boolean) {
      l1 = 1L;
    }
    QSecFramework.a(5L, l2, l3, l1, null, null, new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), parambjis }, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjie
 * JD-Core Version:    0.7.0.1
 */