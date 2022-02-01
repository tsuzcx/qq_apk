import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class bele
  implements beli
{
  protected bekn a;
  protected beko a;
  private belg jdField_a_of_type_Belg;
  private bels jdField_a_of_type_Bels;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private boolean b;
  
  public bele(beko parambeko, belg parambelg)
  {
    this.jdField_a_of_type_Bekn = beks.a("\n", null);
    this.jdField_b_of_type_JavaLangString = beks.b(1);
    this.jdField_a_of_type_Beko = parambeko;
    this.jdField_a_of_type_Belg = parambelg;
  }
  
  private String a(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < this.jdField_a_of_type_Beko.a.size())
    {
      int j = this.jdField_a_of_type_Beko.a.keyAt(i);
      Pair localPair = (Pair)this.jdField_a_of_type_Beko.a.get(j);
      if ((!((String)localPair.first).equals("author")) || (!((String)localPair.second).equals(paramString))) {
        break label98;
      }
      str = Integer.toString(j, beks.jdField_a_of_type_Int);
    }
    label98:
    for (;;)
    {
      i += 1;
      break;
      return str;
    }
  }
  
  @NotNull
  private String a(String paramString, beks parambeks)
  {
    parambeks = beks.a(parambeks.jdField_a_of_type_JavaLangString);
    belj localbelj = new belj();
    while (parambeks.hasNext())
    {
      belm localbelm = (belm)parambeks.next();
      if (localbelm.jdField_a_of_type_Char == '+')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = localbelm.jdField_a_of_type_JavaLangString.split("\\*");
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (belw.a(str)) {}
          for (;;)
          {
            i += 1;
            break;
            Pair localPair = this.jdField_a_of_type_Beko.a(Integer.parseInt(str, beks.jdField_a_of_type_Int));
            if (localPair != null) {
              if ("author".equals(localPair.first)) {
                localStringBuilder.append('*').append(paramString);
              } else {
                localStringBuilder.append('*').append(str);
              }
            }
          }
        }
        localbelm.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      localbelj.a(localbelm);
    }
    localbelj.b();
    return localbelj.toString();
  }
  
  public beko a()
  {
    return this.jdField_a_of_type_Beko;
  }
  
  public belt a(String paramString)
  {
    beko localbeko = null;
    if (!belw.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString = beks.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Beko);
      if (belw.a(paramString)) {
        break label171;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaLangString = beks.b(beks.b(paramString));
    }
    for (;;)
    {
      String str = paramString;
      if (!belw.a(paramString))
      {
        paramString = beks.a(paramString, this.jdField_a_of_type_Beko);
        localbeko = paramString.jdField_a_of_type_Beko;
        str = paramString.jdField_a_of_type_JavaLangString;
      }
      return new belt(str, localbeko);
      if (this.jdField_a_of_type_Beko.a != null)
      {
        str = a(paramString);
        paramString = beks.a(this.jdField_b_of_type_JavaLangString);
        str = a(str, paramString);
        this.jdField_b_of_type_JavaLangString = beks.a(paramString.jdField_b_of_type_Int, paramString.c, str, paramString.jdField_b_of_type_JavaLangString);
        beks.a(this.jdField_b_of_type_JavaLangString);
      }
      if (beks.a(this.jdField_b_of_type_JavaLangString))
      {
        paramString = null;
        break;
      }
      paramString = this.jdField_b_of_type_JavaLangString;
      break;
      label171:
      paramString = null;
    }
  }
  
  public void a()
  {
    if (belw.a(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalStateException("applySubmittedChangesToBase: no submitted changes to apply");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether applying committed changeset: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bekn = beks.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bekn, this.jdField_a_of_type_Beko);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(bekn parambekn, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|setBaseAttributedText: " + parambekn.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bekn = beks.a(parambekn);
    if (!belw.a(paramString))
    {
      paramString = beko.a(paramString);
      this.jdField_a_of_type_Bekn.jdField_b_of_type_JavaLangString = beks.a(this.jdField_a_of_type_Bekn.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Beko);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = beks.b(parambekn.jdField_a_of_type_JavaLangString.length());
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Belg.a(parambekn);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(bels parambels)
  {
    this.jdField_a_of_type_Bels = parambels;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (beks.a(paramString)));
      this.jdField_b_of_type_JavaLangString = beks.b(this.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Beko);
    } while (this.jdField_a_of_type_Bels == null);
    this.jdField_a_of_type_Bels.a();
  }
  
  public void a(String paramString1, String paramString2, beko parambeko)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = paramString1;
    if (parambeko != null) {
      str = beks.a(paramString1, parambeko, this.jdField_a_of_type_Beko);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|applyChangesToBase: " + this.jdField_a_of_type_Bekn.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bekn = beks.a(str, this.jdField_a_of_type_Bekn, this.jdField_a_of_type_Beko);
    paramString1 = str;
    if (!belw.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = beks.b(str, paramString1, false, this.jdField_a_of_type_Beko);
      paramString1 = beks.b(paramString1, str, true, this.jdField_a_of_type_Beko);
    }
    parambeko = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = beks.b(paramString1, parambeko, true, this.jdField_a_of_type_Beko);
    paramString1 = beks.b(parambeko, paramString1, false, this.jdField_a_of_type_Beko);
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Belg.a(paramString1, true, paramString2);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return (!belw.a(this.jdField_a_of_type_JavaLangString)) || (!beks.a(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return !belw.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bele
 * JD-Core Version:    0.7.0.1
 */