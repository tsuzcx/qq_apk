public class arcp
{
  private static aqks a;
  private static aqks b;
  public String a;
  public String b;
  private aqks c;
  public String c;
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public arcp()
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
    aqks[] arrayOfaqks = new aqks[2];
    if ((this.d != null) && (!this.e.equals("")))
    {
      if (this.jdField_c_of_type_Aqks == null) {
        this.jdField_c_of_type_Aqks = new aqks(this.d, 1, 1);
      }
      arrayOfaqks[0] = this.jdField_c_of_type_Aqks;
    }
    if (paramBoolean)
    {
      arrayOfaqks[1] = jdField_b_of_type_Aqks;
      return;
    }
    arrayOfaqks[1] = jdField_a_of_type_Aqks;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arcp
 * JD-Core Version:    0.7.0.1
 */