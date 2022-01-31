import com.tencent.qphone.base.util.QLog;

final class avrm
  implements avdi
{
  avrm(avrq paramavrq, String paramString) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.i("NearbyMomentProtocol", 1, "deleteMomentFeed error, errorCode =" + paramInt);
    if (this.jdField_a_of_type_Avrq != null) {
      this.jdField_a_of_type_Avrq.a(false, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avrm
 * JD-Core Version:    0.7.0.1
 */