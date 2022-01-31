import com.tencent.widget.soload.LoadExtResult;
import java.util.List;

class besf
  implements besg
{
  besf(bese parambese, int paramInt, besc parambesc, besg parambesg) {}
  
  public void a(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, bese.a(this.jdField_a_of_type_Bese));
    bese.a(this.jdField_a_of_type_Bese, paramLoadExtResult);
    if (paramInt == 0) {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_Besc.a.size() - 1) {
        if (this.jdField_a_of_type_Besg != null) {
          this.jdField_a_of_type_Besg.a(paramInt, paramLoadExtResult);
        }
      }
    }
    do
    {
      return;
      bese.a(this.jdField_a_of_type_Bese, this.jdField_a_of_type_Besc, this.jdField_a_of_type_Besg, this.jdField_a_of_type_Int + 1);
      return;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
    } while (this.jdField_a_of_type_Besg == null);
    this.jdField_a_of_type_Besg.a(paramInt, paramLoadExtResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     besf
 * JD-Core Version:    0.7.0.1
 */