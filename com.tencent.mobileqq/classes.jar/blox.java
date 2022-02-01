import java.util.ArrayList;

public class blox
{
  public int a;
  public String a;
  public ArrayList<String> a;
  public int b;
  public String b;
  public String c;
  
  public blox()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public blox(int paramInt1, String paramString1, String paramString2, String paramString3, ArrayList<String> paramArrayList, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool3 = false;
    boolean bool1;
    if (this == paramObject) {
      bool1 = true;
    }
    label116:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return bool1;
                  bool1 = bool3;
                } while (paramObject == null);
                bool1 = bool3;
              } while (getClass() != paramObject.getClass());
              paramObject = (blox)paramObject;
              bool1 = bool3;
            } while (this.jdField_a_of_type_Int != paramObject.jdField_a_of_type_Int);
            bool1 = bool3;
          } while (this.jdField_b_of_type_Int != paramObject.jdField_b_of_type_Int);
          if (this.jdField_a_of_type_JavaLangString == null) {
            break;
          }
          bool1 = bool3;
        } while (!this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
        if (this.jdField_b_of_type_JavaLangString == null) {
          break label170;
        }
        bool1 = bool3;
      } while (!this.jdField_b_of_type_JavaLangString.equals(paramObject.jdField_b_of_type_JavaLangString));
      if (this.c == null) {
        break label179;
      }
      bool1 = bool3;
    } while (!this.c.equals(paramObject.c));
    label140:
    if (this.jdField_a_of_type_JavaUtilArrayList != null) {
      bool1 = this.jdField_a_of_type_JavaUtilArrayList.equals(paramObject.jdField_a_of_type_JavaUtilArrayList);
    }
    for (;;)
    {
      return bool1;
      if (paramObject.jdField_a_of_type_JavaLangString == null) {
        break;
      }
      return false;
      label170:
      if (paramObject.jdField_b_of_type_JavaLangString == null) {
        break label116;
      }
      return false;
      label179:
      if (paramObject.c == null) {
        break label140;
      }
      return false;
      bool1 = bool2;
      if (paramObject.jdField_a_of_type_JavaUtilArrayList != null) {
        bool1 = false;
      }
    }
  }
  
  public int hashCode()
  {
    int m = 0;
    int n = this.jdField_a_of_type_Int;
    int i;
    int j;
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      i = this.jdField_a_of_type_JavaLangString.hashCode();
      if (this.jdField_b_of_type_JavaLangString == null) {
        break label107;
      }
      j = this.jdField_b_of_type_JavaLangString.hashCode();
      label39:
      if (this.c == null) {
        break label112;
      }
    }
    label107:
    label112:
    for (int k = this.c.hashCode();; k = 0)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList != null) {
        m = this.jdField_a_of_type_JavaUtilArrayList.hashCode();
      }
      return ((k + (j + (i + n * 31) * 31) * 31) * 31 + m) * 31 + this.jdField_b_of_type_Int;
      i = 0;
      break;
      j = 0;
      break label39;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blox
 * JD-Core Version:    0.7.0.1
 */