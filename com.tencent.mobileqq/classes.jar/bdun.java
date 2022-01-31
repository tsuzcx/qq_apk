import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

public class bdun
  extends bdur
{
  private bdur jdField_a_of_type_Bdur;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bdun(bdum parambdum, int paramInt)
  {
    super(parambdum, Integer.valueOf(paramInt));
  }
  
  public bdun a(bdur parambdur)
  {
    this.jdField_a_of_type_Bdur = parambdur;
    return this;
  }
  
  public void a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bdum.a(bdum.a);
      return;
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this.jdField_a_of_type_Bdum);
    }
    this.jdField_a_of_type_Bdum.a(this.jdField_a_of_type_JavaLangString, new bduo(this), this.b);
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
 * Qualified Name:     bdun
 * JD-Core Version:    0.7.0.1
 */