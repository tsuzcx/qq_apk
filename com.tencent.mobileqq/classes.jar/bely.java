import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class bely
  implements bemc
{
  protected belh a;
  protected beli a;
  private bema jdField_a_of_type_Bema;
  private bemm jdField_a_of_type_Bemm;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private boolean b;
  
  public bely(beli parambeli, bema parambema)
  {
    this.jdField_a_of_type_Belh = belm.a("\n", null);
    this.jdField_b_of_type_JavaLangString = belm.b(1);
    this.jdField_a_of_type_Beli = parambeli;
    this.jdField_a_of_type_Bema = parambema;
  }
  
  private String a(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < this.jdField_a_of_type_Beli.a.size())
    {
      int j = this.jdField_a_of_type_Beli.a.keyAt(i);
      Pair localPair = (Pair)this.jdField_a_of_type_Beli.a.get(j);
      if ((!((String)localPair.first).equals("author")) || (!((String)localPair.second).equals(paramString))) {
        break label98;
      }
      str = Integer.toString(j, belm.jdField_a_of_type_Int);
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
  private String a(String paramString, belm parambelm)
  {
    parambelm = belm.a(parambelm.jdField_a_of_type_JavaLangString);
    bemd localbemd = new bemd();
    while (parambelm.hasNext())
    {
      bemg localbemg = (bemg)parambelm.next();
      if (localbemg.jdField_a_of_type_Char == '+')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = localbemg.jdField_a_of_type_JavaLangString.split("\\*");
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (bemq.a(str)) {}
          for (;;)
          {
            i += 1;
            break;
            Pair localPair = this.jdField_a_of_type_Beli.a(Integer.parseInt(str, belm.jdField_a_of_type_Int));
            if (localPair != null) {
              if ("author".equals(localPair.first)) {
                localStringBuilder.append('*').append(paramString);
              } else {
                localStringBuilder.append('*').append(str);
              }
            }
          }
        }
        localbemg.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      localbemd.a(localbemg);
    }
    localbemd.b();
    return localbemd.toString();
  }
  
  public beli a()
  {
    return this.jdField_a_of_type_Beli;
  }
  
  public bemn a(String paramString)
  {
    beli localbeli = null;
    if (!bemq.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString = belm.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Beli);
      if (bemq.a(paramString)) {
        break label171;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaLangString = belm.b(belm.b(paramString));
    }
    for (;;)
    {
      String str = paramString;
      if (!bemq.a(paramString))
      {
        paramString = belm.a(paramString, this.jdField_a_of_type_Beli);
        localbeli = paramString.jdField_a_of_type_Beli;
        str = paramString.jdField_a_of_type_JavaLangString;
      }
      return new bemn(str, localbeli);
      if (this.jdField_a_of_type_Beli.a != null)
      {
        str = a(paramString);
        paramString = belm.a(this.jdField_b_of_type_JavaLangString);
        str = a(str, paramString);
        this.jdField_b_of_type_JavaLangString = belm.a(paramString.jdField_b_of_type_Int, paramString.c, str, paramString.jdField_b_of_type_JavaLangString);
        belm.a(this.jdField_b_of_type_JavaLangString);
      }
      if (belm.a(this.jdField_b_of_type_JavaLangString))
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
    if (bemq.a(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalStateException("applySubmittedChangesToBase: no submitted changes to apply");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether applying committed changeset: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Belh = belm.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Belh, this.jdField_a_of_type_Beli);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(belh parambelh, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|setBaseAttributedText: " + parambelh.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Belh = belm.a(parambelh);
    if (!bemq.a(paramString))
    {
      paramString = beli.a(paramString);
      this.jdField_a_of_type_Belh.jdField_b_of_type_JavaLangString = belm.a(this.jdField_a_of_type_Belh.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Beli);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = belm.b(parambelh.jdField_a_of_type_JavaLangString.length());
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Bema.a(parambelh);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(bemm parambemm)
  {
    this.jdField_a_of_type_Bemm = parambemm;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (belm.a(paramString)));
      this.jdField_b_of_type_JavaLangString = belm.b(this.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Beli);
    } while (this.jdField_a_of_type_Bemm == null);
    this.jdField_a_of_type_Bemm.a();
  }
  
  public void a(String paramString1, String paramString2, beli parambeli)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = paramString1;
    if (parambeli != null) {
      str = belm.a(paramString1, parambeli, this.jdField_a_of_type_Beli);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|applyChangesToBase: " + this.jdField_a_of_type_Belh.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Belh = belm.a(str, this.jdField_a_of_type_Belh, this.jdField_a_of_type_Beli);
    paramString1 = str;
    if (!bemq.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = belm.b(str, paramString1, false, this.jdField_a_of_type_Beli);
      paramString1 = belm.b(paramString1, str, true, this.jdField_a_of_type_Beli);
    }
    parambeli = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = belm.b(paramString1, parambeli, true, this.jdField_a_of_type_Beli);
    paramString1 = belm.b(parambeli, paramString1, false, this.jdField_a_of_type_Beli);
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Bema.a(paramString1, true, paramString2);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return (!bemq.a(this.jdField_a_of_type_JavaLangString)) || (!belm.a(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return !bemq.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bely
 * JD-Core Version:    0.7.0.1
 */