import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class aosk
{
  public final int a;
  long jdField_a_of_type_Long = 0L;
  apte jdField_a_of_type_Apte = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  public String a;
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  long b;
  public String b;
  int jdField_c_of_type_Int = 0;
  long jdField_c_of_type_Long = 0L;
  public String c;
  int d;
  public String d;
  public final String e;
  
  public aosk(String paramString, int paramInt)
  {
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_d_of_type_Int = -1;
    this.e = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  void a()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_c_of_type_Int == 1) {
        return;
      }
      if (this.jdField_c_of_type_Int == -1) {
        QLog.w(PromotionConfigInfo.TAG, 1, "clearDownladFlag, ZipItem[" + this + "]");
      }
      a(0);
      this.jdField_a_of_type_Long = 0L;
      this.jdField_b_of_type_Long = 0L;
      this.jdField_c_of_type_Long = 0L;
      return;
    }
  }
  
  void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_Int = paramInt;
      return;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_Int + ", id[" + this.e + "], index[" + this.jdField_a_of_type_Int + "], net_type[" + this.jdField_b_of_type_Int + "], url[" + this.jdField_a_of_type_JavaLangString + "], md5[" + this.jdField_b_of_type_JavaLangString + "], zipFilePath[" + this.jdField_c_of_type_JavaLangString + "], unzipDirPath[" + this.jdField_d_of_type_JavaLangString + "], callByPreDownload[" + this.jdField_a_of_type_Boolean + "], downloadType[" + this.jdField_c_of_type_Int + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aosk
 * JD-Core Version:    0.7.0.1
 */