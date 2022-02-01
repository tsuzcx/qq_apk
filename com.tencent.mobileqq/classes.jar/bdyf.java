public class bdyf
{
  public int a;
  public String a;
  public boolean a;
  public boolean b;
  
  public bdyf()
  {
    this.jdField_a_of_type_Int = 80;
  }
  
  public String a(String paramString)
  {
    Object localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    if (paramString != null)
    {
      if (!this.b) {
        break label109;
      }
      if (!paramString.startsWith("http://")) {
        break label72;
      }
      localObject1 = "http://" + this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      localObject1 = (String)localObject1 + "/";
      return localObject1;
      label72:
      localObject1 = localObject2;
      if (paramString.startsWith("https://")) {
        localObject1 = "https://" + this.jdField_a_of_type_JavaLangString;
      }
    }
    label109:
    if (paramString.startsWith("http://")) {
      if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaLangString.startsWith("["))) {
        localObject1 = "http://[" + this.jdField_a_of_type_JavaLangString + "]";
      }
    }
    while (this.jdField_a_of_type_Int != 80)
    {
      return (String)localObject1 + ":" + this.jdField_a_of_type_Int + "/";
      localObject1 = "http://" + this.jdField_a_of_type_JavaLangString;
      continue;
      localObject1 = localObject3;
      if (paramString.startsWith("https://")) {
        if ((this.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_JavaLangString.startsWith("["))) {
          localObject1 = "https://[" + this.jdField_a_of_type_JavaLangString + "]";
        } else {
          localObject1 = "https://" + this.jdField_a_of_type_JavaLangString;
        }
      }
    }
    return (String)localObject1 + "/";
  }
  
  public void a() {}
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangString + ":" + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyf
 * JD-Core Version:    0.7.0.1
 */