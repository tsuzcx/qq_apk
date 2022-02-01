import com.tencent.qphone.base.util.QLog;

final class anjc
  extends biht
{
  anjc(int paramInt, anjg paramanjg) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if (3 == parambihu.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.jdField_a_of_type_Int);
      }
      if (this.jdField_a_of_type_Anjg != null) {
        this.jdField_a_of_type_Anjg.a(true, this.jdField_a_of_type_Int);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.jdField_a_of_type_Int + " task.getStatus()->" + parambihu.a());
      }
    } while (this.jdField_a_of_type_Anjg == null);
    this.jdField_a_of_type_Anjg.a(false, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anjc
 * JD-Core Version:    0.7.0.1
 */