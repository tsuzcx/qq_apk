import android.text.TextUtils;
import com.tencent.tissue.v8rt.engine.SpeedUtil;

public class bfbm
  extends bfbq
{
  private bfbq jdField_a_of_type_Bfbq;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public bfbm(bfbl parambfbl, int paramInt)
  {
    super(parambfbl, Integer.valueOf(paramInt));
  }
  
  public bfbm a(bfbq parambfbq)
  {
    this.jdField_a_of_type_Bfbq = parambfbq;
    return this;
  }
  
  public void a()
  {
    super.a();
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Bfbl.a(bfbl.a);
      return;
    }
    if ((!TextUtils.isEmpty(this.b)) && (this.b.contains("QLogic.js"))) {
      SpeedUtil.DEFAULT.event("runQLogicJs start " + this.jdField_a_of_type_Bfbl);
    }
    this.jdField_a_of_type_Bfbl.a(this.jdField_a_of_type_JavaLangString, new bfbn(this), this.b);
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
 * Qualified Name:     bfbm
 * JD-Core Version:    0.7.0.1
 */