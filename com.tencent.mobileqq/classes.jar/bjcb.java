import java.util.ArrayList;

class bjcb
{
  int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  bjcb jdField_a_of_type_Bjcb = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static bjcb a()
  {
    bjcb localbjcb = new bjcb();
    localbjcb.a();
    return localbjcb;
  }
  
  String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "LBS_REQ_OK";
    case 1: 
      return "LBS_REQ_PENDING";
    }
    return "LBS_REQ_PERM_OK";
  }
  
  void a()
  {
    if (this.jdField_a_of_type_Bjcb == null) {
      this.jdField_a_of_type_Bjcb = new bjcb();
    }
  }
  
  boolean a(String paramString)
  {
    bjbz.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  void b()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
  }
  
  void c()
  {
    this.jdField_a_of_type_Bjcb.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bjcb.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Bjcb.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bjcb.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bjcb.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjcb
 * JD-Core Version:    0.7.0.1
 */