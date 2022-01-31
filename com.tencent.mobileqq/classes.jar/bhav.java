import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

public class bhav
  extends bhaz
{
  private bhaz jdField_a_of_type_Bhaz;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bhav(bhau parambhau, int paramInt)
  {
    super(parambhau, Integer.valueOf(paramInt));
  }
  
  public bhav a(bhaz parambhaz)
  {
    this.jdField_a_of_type_Bhaz = parambhaz;
    return this;
  }
  
  public void a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bhau.a(bhau.a);
      return;
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this.jdField_a_of_type_Bhau);
    }
    this.jdField_a_of_type_Bhau.a(this.jdField_a_of_type_JavaLangString, new bhaw(this), this.b);
  }
  
  public void a(String paramString)
  {
    a(paramString, null);
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhav
 * JD-Core Version:    0.7.0.1
 */