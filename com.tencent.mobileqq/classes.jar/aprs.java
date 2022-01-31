import android.text.TextUtils;
import java.io.Reader;

public final class aprs
  extends aprr
{
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString = "word";
  private boolean jdField_a_of_type_Boolean;
  private final char[] jdField_a_of_type_ArrayOfChar = new char['ÿ'];
  private int jdField_b_of_type_Int;
  private final char[] jdField_b_of_type_ArrayOfChar = new char[1024];
  private int c;
  private int d;
  
  public aprs(Reader paramReader, int paramInt)
  {
    this.jdField_a_of_type_JavaIoReader = paramReader;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final aprp a()
  {
    int m = this.jdField_b_of_type_Int;
    int k = 0;
    for (;;)
    {
      this.jdField_b_of_type_Int += 1;
      if (this.c >= this.d)
      {
        this.d = this.jdField_a_of_type_JavaIoReader.read(this.jdField_b_of_type_ArrayOfChar);
        this.c = 0;
      }
      int n;
      if (this.d == -1) {
        if (k > 0)
        {
          n = m;
          if (this.jdField_a_of_type_Boolean == true)
          {
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            n = m;
          }
        }
      }
      int i1;
      for (;;)
      {
        if ((n == this.jdField_a_of_type_Int - 1) && (k == 0))
        {
          return null;
          return null;
          Object localObject = this.jdField_b_of_type_ArrayOfChar;
          n = this.c;
          this.c = (n + 1);
          int j = localObject[n];
          localObject = Character.UnicodeBlock.of(j);
          if ((localObject == Character.UnicodeBlock.BASIC_LATIN) || (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS))
          {
            int i = j;
            char c1;
            if (localObject == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
              c1 = (char)(j - 65248);
            }
            if (Character.isLetter(c1))
            {
              if (k == 0) {
                n = this.jdField_b_of_type_Int - 1;
              }
              do
              {
                localObject = this.jdField_a_of_type_ArrayOfChar;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c1);
                this.jdField_a_of_type_JavaLangString = "letter";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label700;
                }
                k = m;
                break;
                if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "double")) {
                  break label260;
                }
                n = m;
              } while (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "digit"));
              label260:
              this.jdField_b_of_type_Int -= 1;
              this.c -= 1;
              this.jdField_a_of_type_JavaLangString = "letter";
              n = m;
              if (this.jdField_a_of_type_Boolean != true) {
                continue;
              }
              this.jdField_a_of_type_Boolean = false;
              k = 0;
              n = m;
              continue;
            }
            if (Character.isDigit(c1))
            {
              if (k == 0) {
                n = this.jdField_b_of_type_Int - 1;
              }
              do
              {
                localObject = this.jdField_a_of_type_ArrayOfChar;
                m = k + 1;
                localObject[k] = Character.toLowerCase(c1);
                this.jdField_a_of_type_JavaLangString = "digit";
                i1 = n;
                k = m;
                if (m != 255) {
                  break label700;
                }
                k = m;
                break;
                if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "double")) {
                  break label405;
                }
                n = m;
              } while (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, "letter"));
              label405:
              this.jdField_b_of_type_Int -= 1;
              this.c -= 1;
              this.jdField_a_of_type_JavaLangString = "digit";
              n = m;
              if (this.jdField_a_of_type_Boolean != true) {
                continue;
              }
              this.jdField_a_of_type_Boolean = false;
              k = 0;
              n = m;
              continue;
            }
            if (k <= 0) {
              break;
            }
            n = m;
            if (this.jdField_a_of_type_Boolean != true) {
              continue;
            }
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            break;
          }
          if (Character.isLetter(j))
          {
            if (k == 0)
            {
              m = this.jdField_b_of_type_Int - 1;
              this.jdField_a_of_type_ArrayOfChar[k] = j;
              this.jdField_a_of_type_JavaLangString = "double";
              k += 1;
              break;
            }
            if ((TextUtils.equals(this.jdField_a_of_type_JavaLangString, "letter")) || (TextUtils.equals(this.jdField_a_of_type_JavaLangString, "digit")))
            {
              this.jdField_b_of_type_Int -= 1;
              this.c -= 1;
              n = m;
              continue;
            }
            localObject = this.jdField_a_of_type_ArrayOfChar;
            n = k + 1;
            localObject[k] = j;
            this.jdField_a_of_type_JavaLangString = "double";
            i1 = m;
            k = n;
            if (n != 2) {
              break label700;
            }
            this.jdField_b_of_type_Int -= 1;
            this.c -= 1;
            this.jdField_a_of_type_Boolean = true;
            k = n;
            n = m;
            continue;
          }
          if (k <= 0) {
            break;
          }
          n = m;
          if (this.jdField_a_of_type_Boolean == true)
          {
            this.jdField_a_of_type_Boolean = false;
            k = 0;
            break;
          }
        }
      }
      return new aprp(new String(this.jdField_a_of_type_ArrayOfChar, 0, k), n, k + n, this.jdField_a_of_type_JavaLangString);
      label700:
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aprs
 * JD-Core Version:    0.7.0.1
 */