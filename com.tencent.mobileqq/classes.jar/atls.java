import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class atls
  implements atly
{
  atls(atln paramatln, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public atlf a()
  {
    if (atln.a(this.jdField_a_of_type_Atln) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new atlf(this.jdField_a_of_type_Atln.app.c(), atln.a(this.jdField_a_of_type_Atln), atln.a(this.jdField_a_of_type_Atln));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atls
 * JD-Core Version:    0.7.0.1
 */