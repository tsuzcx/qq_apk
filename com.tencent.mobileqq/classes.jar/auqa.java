import java.io.Reader;

public final class auqa
  extends aupy
{
  private int jdField_a_of_type_Int;
  private final char[] jdField_a_of_type_ArrayOfChar = new char['ÿ'];
  private int jdField_b_of_type_Int;
  private final char[] jdField_b_of_type_ArrayOfChar = new char[1024];
  private int c;
  private int d;
  private int e;
  private int f = -1;
  
  public auqa(Reader paramReader)
  {
    this.jdField_a_of_type_JavaIoReader = paramReader;
  }
  
  private final void a(char paramChar)
  {
    if (this.d == 0) {
      this.e = (this.jdField_a_of_type_Int - 1);
    }
    char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
    int i = this.d;
    this.d = (i + 1);
    arrayOfChar[i] = Character.toLowerCase(paramChar);
  }
  
  private final aupw b()
  {
    if (this.d > 0)
    {
      String str2 = "other";
      String str1 = str2;
      switch (Character.getType(this.jdField_a_of_type_ArrayOfChar[0]))
      {
      default: 
        str1 = str2;
      }
      for (;;)
      {
        return new aupw(new String(this.jdField_a_of_type_ArrayOfChar, 0, this.d), this.e, this.e + this.d, str1);
        str1 = "num";
        continue;
        str1 = "en";
        continue;
        str1 = "cn";
      }
    }
    return null;
  }
  
  public final aupw a()
  {
    this.d = 0;
    this.e = this.jdField_a_of_type_Int;
    char c1;
    do
    {
      this.jdField_a_of_type_Int += 1;
      if (this.jdField_b_of_type_Int >= this.c)
      {
        this.c = this.jdField_a_of_type_JavaIoReader.read(this.jdField_b_of_type_ArrayOfChar);
        this.jdField_b_of_type_Int = 0;
      }
      if (this.c == -1)
      {
        this.f = -1;
        return b();
      }
      char[] arrayOfChar = this.jdField_b_of_type_ArrayOfChar;
      int i = this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = (i + 1);
      c1 = arrayOfChar[i];
      switch (Character.getType(c1))
      {
      }
    } while (this.d <= 0);
    return b();
    if (this.f == -1) {
      this.f = 0;
    }
    do
    {
      do
      {
        a(c1);
        if (this.d != 255) {
          break;
        }
        return b();
      } while (this.f == 0);
      this.f = 0;
    } while (this.d <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
    if (this.f == -1) {
      this.f = 1;
    }
    do
    {
      do
      {
        a(c1);
        if (this.d != 255) {
          break;
        }
        return b();
      } while (this.f == 1);
      this.f = 1;
    } while (this.d <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
    if (this.f == -1) {
      this.f = 2;
    }
    do
    {
      do
      {
        a(c1);
        return b();
      } while (this.f == 2);
      this.f = 2;
    } while (this.d <= 0);
    this.jdField_b_of_type_Int -= 1;
    this.jdField_a_of_type_Int -= 1;
    return b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqa
 * JD-Core Version:    0.7.0.1
 */