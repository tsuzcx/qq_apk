import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atqb
  implements atqh
{
  atqb(atpw paramatpw, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public atpo a()
  {
    if (atpw.a(this.jdField_a_of_type_Atpw) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new atpo(this.jdField_a_of_type_Atpw.app.c(), atpw.a(this.jdField_a_of_type_Atpw), atpw.a(this.jdField_a_of_type_Atpw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqb
 * JD-Core Version:    0.7.0.1
 */