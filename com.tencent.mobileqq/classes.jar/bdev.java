import android.support.v4.util.SparseArrayCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public class bdev
  implements bdez
{
  protected bdee a;
  protected bdef a;
  private bdex jdField_a_of_type_Bdex;
  private bdfj jdField_a_of_type_Bdfj;
  protected String a;
  private boolean jdField_a_of_type_Boolean;
  protected String b;
  private boolean b;
  
  public bdev(bdef parambdef, bdex parambdex)
  {
    this.jdField_a_of_type_Bdee = bdej.a("\n", null);
    this.jdField_b_of_type_JavaLangString = bdej.b(1);
    this.jdField_a_of_type_Bdef = parambdef;
    this.jdField_a_of_type_Bdex = parambdex;
  }
  
  private String a(String paramString)
  {
    String str = "";
    int i = 0;
    if (i < this.jdField_a_of_type_Bdef.a.size())
    {
      int j = this.jdField_a_of_type_Bdef.a.keyAt(i);
      Pair localPair = (Pair)this.jdField_a_of_type_Bdef.a.get(j);
      if ((!((String)localPair.first).equals("author")) || (!((String)localPair.second).equals(paramString))) {
        break label98;
      }
      str = Integer.toString(j, bdej.jdField_a_of_type_Int);
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
  private String a(String paramString, bdej parambdej)
  {
    parambdej = bdej.a(parambdej.jdField_a_of_type_JavaLangString);
    bdfa localbdfa = new bdfa();
    while (parambdej.hasNext())
    {
      bdfd localbdfd = (bdfd)parambdej.next();
      if (localbdfd.jdField_a_of_type_Char == '+')
      {
        StringBuilder localStringBuilder = new StringBuilder();
        String[] arrayOfString = localbdfd.jdField_a_of_type_JavaLangString.split("\\*");
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (bdfn.a(str)) {}
          for (;;)
          {
            i += 1;
            break;
            Pair localPair = this.jdField_a_of_type_Bdef.a(Integer.parseInt(str, bdej.jdField_a_of_type_Int));
            if (localPair != null) {
              if ("author".equals(localPair.first)) {
                localStringBuilder.append('*').append(paramString);
              } else {
                localStringBuilder.append('*').append(str);
              }
            }
          }
        }
        localbdfd.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      }
      localbdfa.a(localbdfd);
    }
    localbdfa.b();
    return localbdfa.toString();
  }
  
  public bdef a()
  {
    return this.jdField_a_of_type_Bdef;
  }
  
  public bdfk a(String paramString)
  {
    bdef localbdef = null;
    if (!bdfn.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString = bdej.b(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_Bdef);
      if (bdfn.a(paramString)) {
        break label171;
      }
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_b_of_type_JavaLangString = bdej.b(bdej.b(paramString));
    }
    for (;;)
    {
      String str = paramString;
      if (!bdfn.a(paramString))
      {
        paramString = bdej.a(paramString, this.jdField_a_of_type_Bdef);
        localbdef = paramString.jdField_a_of_type_Bdef;
        str = paramString.jdField_a_of_type_JavaLangString;
      }
      return new bdfk(str, localbdef);
      if (this.jdField_a_of_type_Bdef.a != null)
      {
        str = a(paramString);
        paramString = bdej.a(this.jdField_b_of_type_JavaLangString);
        str = a(str, paramString);
        this.jdField_b_of_type_JavaLangString = bdej.a(paramString.jdField_b_of_type_Int, paramString.c, str, paramString.jdField_b_of_type_JavaLangString);
        bdej.a(this.jdField_b_of_type_JavaLangString);
      }
      if (bdej.a(this.jdField_b_of_type_JavaLangString))
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
    if (bdfn.a(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalStateException("applySubmittedChangesToBase: no submitted changes to apply");
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether applying committed changeset: " + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bdee = bdej.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bdee, this.jdField_a_of_type_Bdef);
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(bdee parambdee, String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|setBaseAttributedText: " + parambdee.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bdee = bdej.a(parambdee);
    if (!bdfn.a(paramString))
    {
      paramString = bdef.a(paramString);
      this.jdField_a_of_type_Bdee.jdField_b_of_type_JavaLangString = bdej.a(this.jdField_a_of_type_Bdee.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Bdef);
    }
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_JavaLangString = bdej.b(parambdee.jdField_a_of_type_JavaLangString.length());
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Bdex.a(parambdee);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public void a(bdfj parambdfj)
  {
    this.jdField_a_of_type_Bdfj = parambdfj;
  }
  
  public void a(String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while ((this.jdField_b_of_type_Boolean) || (bdej.a(paramString)));
      this.jdField_b_of_type_JavaLangString = bdej.b(this.jdField_b_of_type_JavaLangString, paramString, this.jdField_a_of_type_Bdef);
    } while (this.jdField_a_of_type_Bdfj == null);
    this.jdField_a_of_type_Bdfj.a();
  }
  
  public void a(String paramString1, String paramString2, bdef parambdef)
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    String str = paramString1;
    if (parambdef != null) {
      str = bdej.a(paramString1, parambdef, this.jdField_a_of_type_Bdef);
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChangesetTracker", 2, "WriteTogether|applyChangesToBase: " + this.jdField_a_of_type_Bdee.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_Bdee = bdej.a(str, this.jdField_a_of_type_Bdee, this.jdField_a_of_type_Bdef);
    paramString1 = str;
    if (!bdfn.a(this.jdField_a_of_type_JavaLangString))
    {
      paramString1 = this.jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_JavaLangString = bdej.b(str, paramString1, false, this.jdField_a_of_type_Bdef);
      paramString1 = bdej.b(paramString1, str, true, this.jdField_a_of_type_Bdef);
    }
    parambdef = this.jdField_b_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = bdej.b(paramString1, parambdef, true, this.jdField_a_of_type_Bdef);
    paramString1 = bdej.b(parambdef, paramString1, false, this.jdField_a_of_type_Bdef);
    this.jdField_b_of_type_Boolean = true;
    try
    {
      this.jdField_a_of_type_Bdex.a(paramString1, true, paramString2);
      return;
    }
    finally
    {
      this.jdField_b_of_type_Boolean = false;
    }
  }
  
  public boolean a()
  {
    return (!bdfn.a(this.jdField_a_of_type_JavaLangString)) || (!bdej.a(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean b()
  {
    return !bdfn.a(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdev
 * JD-Core Version:    0.7.0.1
 */