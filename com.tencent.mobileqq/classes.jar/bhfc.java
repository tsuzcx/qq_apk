import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

public class bhfc
  extends bhfg
{
  private bhfg jdField_a_of_type_Bhfg;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bhfc(bhfb parambhfb, int paramInt)
  {
    super(parambhfb, Integer.valueOf(paramInt));
  }
  
  public bhfc a(bhfg parambhfg)
  {
    this.jdField_a_of_type_Bhfg = parambhfg;
    return this;
  }
  
  public void a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bhfb.a(bhfb.a);
      return;
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this.jdField_a_of_type_Bhfb);
    }
    this.jdField_a_of_type_Bhfb.a(this.jdField_a_of_type_JavaLangString, new bhfd(this), this.b);
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
 * Qualified Name:     bhfc
 * JD-Core Version:    0.7.0.1
 */