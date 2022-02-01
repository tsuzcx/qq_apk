import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class aniy
  extends biht
{
  aniy(File paramFile, amsx paramamsx, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger1, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, anjf paramanjf, String paramString, List paramList) {}
  
  public void onDone(bihu parambihu)
  {
    boolean bool = true;
    super.onDone(parambihu);
    if (3 == parambihu.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    for (;;)
    {
      try
      {
        nof.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
        aniv.a(this.jdField_a_of_type_Amsx, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.c.get()) {
          break label413;
        }
        if (this.jdField_a_of_type_Anjf != null)
        {
          parambihu = this.jdField_a_of_type_Anjf;
          if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
            bool = false;
          }
          parambihu.a(bool, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList);
          if (QLog.isColorLevel()) {
            QLog.d("ApolloResDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_a_of_type_JavaLangString + "all cnt: " + this.c.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
          }
        }
        this.jdField_a_of_type_JavaIoFile.delete();
        return;
      }
      catch (Exception parambihu)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambihu.getMessage());
        continue;
      }
      catch (OutOfMemoryError parambihu)
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambihu.getMessage());
        continue;
      }
      this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      QLog.d("ApolloResDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + parambihu.a());
      continue;
      label413:
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloRes download uin:" + this.jdField_a_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.c.get());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aniy
 * JD-Core Version:    0.7.0.1
 */