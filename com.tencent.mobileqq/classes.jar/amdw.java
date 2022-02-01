import com.tencent.qphone.base.util.QLog;

final class amdw
  extends bgod
{
  amdw(int paramInt, amea paramamea) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if (3 == parambgoe.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Amea != null) {
        this.jdField_a_of_type_Amea.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambgoe.a());
      }
    } while (this.jdField_a_of_type_Amea == null);
    this.jdField_a_of_type_Amea.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdw
 * JD-Core Version:    0.7.0.1
 */