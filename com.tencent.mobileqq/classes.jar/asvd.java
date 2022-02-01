import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;

public class asvd
{
  public int a;
  public boolean a;
  public int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
  int f = 0;
  
  public asvd(QfileBaseFavFileTabView paramQfileBaseFavFileTabView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
  }
  
  public String a()
  {
    return " startCount:" + this.jdField_a_of_type_Int + " targetCount:" + this.b + " ReqSeq:" + this.c + " continueCount:" + this.d + " mNoNewDataCount:" + this.e + " mLastRecordSize:" + this.f;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.b = 0;
    this.d = 0;
    this.e = 0;
    this.f = 0;
  }
  
  public void a(int paramInt)
  {
    this.d += 1;
    if (paramInt == this.f) {
      this.e += 1;
    }
    this.f = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c += 1;
    this.d = 0;
    this.e = 0;
    this.f = paramInt1;
  }
  
  public boolean a()
  {
    return (this.e < 5) || (this.d > 10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asvd
 * JD-Core Version:    0.7.0.1
 */