import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

public class bfav
  extends bfaz
{
  private bfaz jdField_a_of_type_Bfaz;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bfav(bfau parambfau, int paramInt)
  {
    super(parambfau, Integer.valueOf(paramInt));
  }
  
  public bfav a(bfaz parambfaz)
  {
    this.jdField_a_of_type_Bfaz = parambfaz;
    return this;
  }
  
  public void a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bfau.a(bfau.a);
      return;
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this.jdField_a_of_type_Bfau);
    }
    this.jdField_a_of_type_Bfau.a(this.jdField_a_of_type_JavaLangString, new bfaw(this), this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfav
 * JD-Core Version:    0.7.0.1
 */