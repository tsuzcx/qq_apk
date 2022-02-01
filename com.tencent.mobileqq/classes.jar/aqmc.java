public class aqmc
{
  private static aptg a;
  private static aptg b;
  public String a;
  public String b;
  private aptg c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public aqmc()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
  }
  
  public void a()
  {
    if (this.e.equals("LOCAL")) {
      if (!this.f.equals("1")) {}
    }
    label24:
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
              break label24;
              break label24;
              break label24;
              do
              {
                return;
              } while ((this.f.equals("2")) || (this.f.equals("4")) || (this.f.equals("5")) || (this.f.equals("6")) || (!this.f.equals("7")));
              return;
            } while ((this.e.equals("WAP")) || (this.e.equals("TMTWAP")) || (this.e.equals("WAPI")) || (this.e.equals("TMTWAPI")) || (this.e.equals("VOICECALL")));
            if (!this.e.equals("QQMSG")) {
              break;
            }
          } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
          return;
        } while ((this.e.equals("AUTOQQMSG")) || (this.e.equals("HTTP")) || (this.e.equals("AUTOSMS")));
        if (!this.e.equals("USERSMS")) {
          break;
        }
      } while (!this.jdField_c_of_type_JavaLangString.equals("AUTO"));
      return;
    } while (!this.e.equals("RESET"));
  }
  
  public void a(boolean paramBoolean)
  {
    aptg[] arrayOfaptg = new aptg[2];
    if ((this.d != null) && (!this.e.equals("")))
    {
      if (this.jdField_c_of_type_Aptg == null) {
        this.jdField_c_of_type_Aptg = new aptg(this.d, 1, 1);
      }
      arrayOfaptg[0] = this.jdField_c_of_type_Aptg;
    }
    if (paramBoolean)
    {
      arrayOfaptg[1] = jdField_b_of_type_Aptg;
      return;
    }
    arrayOfaptg[1] = jdField_a_of_type_Aptg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqmc
 * JD-Core Version:    0.7.0.1
 */