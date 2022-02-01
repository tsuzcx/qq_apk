import java.util.ArrayList;

class bplr
{
  int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  bplr jdField_a_of_type_Bplr = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  boolean jdField_a_of_type_Boolean = false;
  
  static bplr a()
  {
    bplr localbplr = new bplr();
    localbplr.a();
    return localbplr;
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
    if (this.jdField_a_of_type_Bplr == null) {
      this.jdField_a_of_type_Bplr = new bplr();
    }
  }
  
  boolean a(String paramString)
  {
    bplp.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
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
    this.jdField_a_of_type_Bplr.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    this.jdField_a_of_type_Bplr.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Bplr.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    this.jdField_a_of_type_Bplr.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Bplr.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bplr
 * JD-Core Version:    0.7.0.1
 */