import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqzh
  implements aqzn
{
  aqzh(aqzc paramaqzc, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public aqyu a()
  {
    if (aqzc.a(this.jdField_a_of_type_Aqzc) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new aqyu(this.jdField_a_of_type_Aqzc.app.c(), aqzc.a(this.jdField_a_of_type_Aqzc), aqzc.a(this.jdField_a_of_type_Aqzc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     aqzh
 * JD-Core Version:    0.7.0.1
 */