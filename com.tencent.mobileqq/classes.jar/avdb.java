import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class avdb
  implements avdh
{
  avdb(avcw paramavcw, int paramInt, String paramString) {}
  
  public Pair<Integer, String> a()
  {
    return new Pair(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaLangString);
  }
  
  public avco a()
  {
    if (avcw.a(this.jdField_a_of_type_Avcw) == null) {
      QLog.d("LocationHandler", 1, "[LocationManager] getLocation: invoked. location null detected");
    }
    return new avco(this.jdField_a_of_type_Avcw.app.getCurrentUin(), avcw.a(this.jdField_a_of_type_Avcw), avcw.a(this.jdField_a_of_type_Avcw));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avdb
 * JD-Core Version:    0.7.0.1
 */