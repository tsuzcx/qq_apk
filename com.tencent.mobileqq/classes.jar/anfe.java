import com.tencent.qphone.base.util.QLog;

final class anfe
  extends bhyn
{
  anfe(int paramInt, anfi paramanfi) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if (3 == parambhyo.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Anfi != null) {
        this.jdField_a_of_type_Anfi.onDownloadFinish(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambhyo.a());
      }
    } while (this.jdField_a_of_type_Anfi == null);
    this.jdField_a_of_type_Anfi.onDownloadFinish(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfe
 * JD-Core Version:    0.7.0.1
 */