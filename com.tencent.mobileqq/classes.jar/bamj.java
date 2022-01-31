import android.content.res.Resources;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bamj
{
  private String jdField_a_of_type_JavaLangString;
  private List<bamo> jdField_a_of_type_JavaUtilList;
  
  private bamj()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public bamj(String paramString, int paramInt)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    a(new StringBuilder(this.jdField_a_of_type_JavaLangString), paramInt);
  }
  
  private bamj a(bamo parambamo)
  {
    if (parambamo != null) {
      this.jdField_a_of_type_JavaUtilList.add(parambamo);
    }
    this.jdField_a_of_type_JavaLangString = b();
    return this;
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt)
  {
    int k = this.jdField_a_of_type_JavaLangString.length();
    int m = this.jdField_a_of_type_JavaLangString.length();
    int n = (int)(paramInt * BaseApplicationImpl.getContext().getResources().getDisplayMetrics().density + 0.5F);
    paramInt = 0;
    while (paramInt < m)
    {
      if ((paramStringBuilder.charAt(paramInt) == '<') && (paramInt < k - 2))
      {
        int i = paramStringBuilder.charAt(paramInt + 1);
        if ((i == 36) && (paramInt < k - 3))
        {
          int j = paramStringBuilder.charAt(paramInt + 2);
          if (bamp.a) {
            paramStringBuilder.replace(paramInt + 1, paramInt + 3, "##");
          }
          for (;;)
          {
            if (j >= apsp.a()) {
              break label213;
            }
            if (paramStringBuilder.charAt(paramInt + 3) != '>') {
              break label635;
            }
            j = apsp.b(j);
            i = j;
            if (j == 250) {
              i = 10;
            }
            if (i >= bamd.a) {
              break label635;
            }
            a(new bamm(paramStringBuilder.substring(paramInt, paramInt + 4), i, n));
            paramInt += 4;
            break;
            if (j == 10) {
              paramStringBuilder.setCharAt(paramInt + 2, 'ú');
            }
          }
          label213:
          if ((j >= 255) && (paramInt + 6 < k))
          {
            if (paramStringBuilder.charAt(paramInt + 6) == '>')
            {
              char[] arrayOfChar = new char[3];
              arrayOfChar[0] = paramStringBuilder.charAt(paramInt + 3);
              arrayOfChar[1] = paramStringBuilder.charAt(paramInt + 4);
              arrayOfChar[2] = ((char)(paramStringBuilder.charAt(paramInt + 5) & 0xFF));
              i = 0;
              if (i < 3)
              {
                if (arrayOfChar[i] == 'ú') {
                  arrayOfChar[i] = '\n';
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (arrayOfChar[i] == 'þ') {
                    arrayOfChar[i] = '\r';
                  }
                }
              }
              a(new bamn(paramStringBuilder.substring(paramInt, paramInt + 7), j, n));
              i = 2;
              if (i < 5)
              {
                if (paramStringBuilder.charAt(paramInt + i) == '\n') {
                  paramStringBuilder.setCharAt(paramInt + i, 'ú');
                }
                for (;;)
                {
                  i += 1;
                  break;
                  if (paramStringBuilder.charAt(paramInt + i) == '\r') {
                    paramStringBuilder.setCharAt(paramInt + i, 'þ');
                  }
                }
              }
              paramInt += 7;
            }
          }
          else if (j == 250)
          {
            if (bamp.a) {
              paramStringBuilder.replace(paramInt + 1, paramInt + 3, "##");
            }
            a(new bamm(paramStringBuilder.substring(paramInt, paramInt + 4), 10, n));
            paramInt += 4;
          }
        }
        else if (((i == 37) || (i == 38)) && (paramInt < k - 6))
        {
          a(new baml(paramStringBuilder.substring(paramInt, paramInt + 7)));
          paramInt += 7;
        }
      }
      else
      {
        if ((Character.isHighSurrogate(paramStringBuilder.charAt(paramInt))) && (paramInt <= k - 2) && (Character.isSurrogatePair(paramStringBuilder.charAt(paramInt), paramStringBuilder.charAt(paramInt + 1))) && (a(paramStringBuilder.toString().codePointAt(paramInt))))
        {
          a(new bami(paramStringBuilder.substring(paramInt, paramInt + 2)));
          paramInt += 2;
          continue;
        }
        a(new bamk(String.valueOf(paramStringBuilder.charAt(paramInt))));
      }
      label635:
      paramInt += 1;
    }
  }
  
  private static boolean a(int paramInt)
  {
    return ((paramInt >= 9728) && (paramInt <= 10175)) || (paramInt == 12349) || (paramInt == 8265) || (paramInt == 8252) || ((paramInt >= 8192) && (paramInt <= 8207)) || ((paramInt >= 8232) && (paramInt <= 8239)) || (paramInt == 8287) || ((paramInt >= 8293) && (paramInt <= 8303)) || ((paramInt >= 8448) && (paramInt <= 8527)) || ((paramInt >= 8960) && (paramInt <= 9215)) || ((paramInt >= 11008) && (paramInt <= 11263)) || ((paramInt >= 10496) && (paramInt <= 10623)) || ((paramInt >= 12800) && (paramInt <= 13055)) || ((paramInt >= 55296) && (paramInt <= 57343)) || ((paramInt >= 57344) && (paramInt <= 63743)) || ((paramInt >= 65024) && (paramInt <= 65039)) || (paramInt >= 65536);
  }
  
  public float a(Paint paramPaint)
  {
    float f = 0.0F;
    int i = 0;
    while (i < a())
    {
      f += a(i).a(paramPaint);
      i += 1;
    }
    return f;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public bamj a(int paramInt)
  {
    bamj localbamj = new bamj();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bamo localbamo = (bamo)localIterator.next();
      if (localbamo.a() == paramInt) {
        localbamj.a(localbamo);
      }
    }
    return localbamj;
  }
  
  @NonNull
  public bamo a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (bamo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    throw new IndexOutOfBoundsException("NickString index error");
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bamo localbamo = (bamo)localIterator.next();
      if ((localbamo.a() == 0) || (localbamo.a() == 1)) {
        localStringBuilder.append(localbamo.a());
      }
    }
    return localStringBuilder.toString();
  }
  
  public bamj b(int paramInt)
  {
    bamj localbamj = new bamj();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      bamo localbamo = (bamo)localIterator.next();
      if (localbamo.a() != paramInt) {
        localbamj.a(localbamo);
      }
    }
    return localbamj;
  }
  
  public String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append(((bamo)localIterator.next()).a());
    }
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamj
 * JD-Core Version:    0.7.0.1
 */