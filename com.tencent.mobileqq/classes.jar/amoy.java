import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class amoy
  extends bhyn
{
  amoy(String paramString1, File paramFile, AtomicInteger paramAtomicInteger1, int paramInt1, int paramInt2, AtomicInteger paramAtomicInteger2, AtomicInteger paramAtomicInteger3, amoz paramamoz, amow paramamow, String paramString2, List paramList) {}
  
  public void onDone(bhyo parambhyo)
  {
    boolean bool = true;
    super.onDone(parambhyo);
    if (QLog.isColorLevel()) {
      QLog.d("rscContent_CmShowRscDownloader", 1, "download url:" + this.jdField_a_of_type_JavaLangString + " task.getStatus()->" + parambhyo.a());
    }
    if (3 == parambhyo.a()) {
      if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          nwp.a(this.jdField_a_of_type_JavaIoFile, this.jdField_a_of_type_JavaIoFile.getParent() + File.separator);
          this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() != this.c.get()) {
            break;
          }
          if (this.jdField_a_of_type_Amoz != null)
          {
            parambhyo = "";
            if (this.jdField_a_of_type_Amow != null) {
              parambhyo = this.jdField_a_of_type_Amow.c();
            }
            amoz localamoz = this.jdField_a_of_type_Amoz;
            if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() > 0) {
              bool = false;
            }
            localamoz.a(bool, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilList, parambhyo);
            if (QLog.isColorLevel()) {
              QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download all done uin: " + this.jdField_b_of_type_JavaLangString + "all cnt: " + this.c.get() + ", err cnt: " + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get());
            }
          }
          return;
        }
        catch (Exception parambhyo)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambhyo.getMessage());
          continue;
        }
        catch (OutOfMemoryError parambhyo)
        {
          this.jdField_a_of_type_JavaIoFile.delete();
          this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("rscContent_CmShowRscDownloader", 2, "unZipFile file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " error->" + parambhyo.getMessage());
          continue;
        }
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
        QLog.d("rscContent_CmShowRscDownloader", 1, "download file error resType->" + this.jdField_a_of_type_Int + " id->" + this.jdField_b_of_type_Int + " task.getStatus()->" + parambhyo.a());
      }
    } while (!QLog.isColorLevel());
    QLog.d("rscContent_CmShowRscDownloader", 2, "downloadApolloRes download uin:" + this.jdField_b_of_type_JavaLangString + ", cb cnt: " + this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.get() + ", all cnt: " + this.c.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amoy
 * JD-Core Version:    0.7.0.1
 */