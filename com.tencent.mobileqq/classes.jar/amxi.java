import com.tencent.qphone.base.util.QLog;

final class amxi
  extends bhhe
{
  amxi(int paramInt, amxm paramamxm) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if (3 == parambhhf.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Amxm != null) {
        this.jdField_a_of_type_Amxm.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambhhf.a());
      }
    } while (this.jdField_a_of_type_Amxm == null);
    this.jdField_a_of_type_Amxm.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxi
 * JD-Core Version:    0.7.0.1
 */