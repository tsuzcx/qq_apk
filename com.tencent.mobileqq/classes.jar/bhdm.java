import com.tencent.qqmini.sdk.core.tissue.TissueEnv;
import com.tencent.qqmini.sdk.core.tissue.TissueGlobal;

class bhdm
  implements TissueEnv
{
  bhdm(bhdl parambhdl, String paramString) {}
  
  public String getNativeLibDir()
  {
    if (TissueGlobal.verifyTissueEngine(this.jdField_a_of_type_JavaLangString)) {
      return this.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhdm
 * JD-Core Version:    0.7.0.1
 */