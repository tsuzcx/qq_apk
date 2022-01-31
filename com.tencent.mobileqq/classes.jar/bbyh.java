import org.json.JSONObject;

public class bbyh
{
  public int a;
  public boolean a;
  
  public bbyh()
  {
    this.jdField_a_of_type_Int = -30009;
  }
  
  public bbyh(JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_Int = -30009;
    this.jdField_a_of_type_Int = paramJSONObject.optInt("ret", -30009);
    if ((this.jdField_a_of_type_Int == 0) && (paramJSONObject.optInt("flag", 0) == 1)) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public String toString()
  {
    return "LiangHaoStatusRsp{ret=" + this.jdField_a_of_type_Int + ", flag=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbyh
 * JD-Core Version:    0.7.0.1
 */