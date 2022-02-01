import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class awpv
  implements awqb
{
  awpv(awpq paramawpq, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public awpi a()
  {
    if (awpq.a(this.jdField_a_of_type_Awpq) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new awpi(this.jdField_a_of_type_Awpq.app.c(), awpq.a(this.jdField_a_of_type_Awpq), awpq.a(this.jdField_a_of_type_Awpq));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awpv
 * JD-Core Version:    0.7.0.1
 */