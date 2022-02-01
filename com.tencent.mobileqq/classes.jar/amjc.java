import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class amjc
  implements bdfl
{
  final int jdField_a_of_type_Int;
  final long jdField_a_of_type_Long;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  final int jdField_b_of_type_Int;
  final long jdField_b_of_type_Long;
  
  public amjc(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    if (paramInt2 > 0) {}
    for (this.jdField_b_of_type_Int = paramInt2;; this.jdField_b_of_type_Int = 30)
    {
      this.jdField_a_of_type_JavaLangThrowable = null;
      if (paramString == null) {}
      return;
    }
  }
  
  public bdfm a(int paramInt1, int paramInt2)
  {
    int j = 1280;
    int i = 30;
    bdfm localbdfm = new bdfm();
    Object localObject;
    if (paramInt1 <= paramInt2)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localbdfm.jdField_a_of_type_JavaIoFile = ((File)localObject);
      if (paramInt2 < 1280) {
        break label278;
      }
      localObject = "720p";
      paramInt1 = j;
      label70:
      if (paramInt2 >= paramInt1) {
        break label307;
      }
    }
    label278:
    label307:
    for (localbdfm.jdField_a_of_type_Int = ((int)(819200 * 1.0D / paramInt1 * paramInt2));; localbdfm.jdField_a_of_type_Int = 819200)
    {
      localbdfm.jdField_a_of_type_Float = (paramInt1 / paramInt2);
      paramInt2 = i;
      if (this.jdField_b_of_type_Int <= 30) {
        paramInt2 = this.jdField_b_of_type_Int;
      }
      localbdfm.jdField_b_of_type_Int = paramInt2;
      localbdfm.jdField_b_of_type_Boolean = a();
      localbdfm.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localbdfm.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("VideoCompressTask", 2, "CompressTask, step: getEncodeConfig() config.setRotation = " + localbdfm.jdField_b_of_type_Boolean + ", scaleRate=" + localbdfm.jdField_a_of_type_Float + ", videoBitRate=" + localbdfm.jdField_a_of_type_Int + ", videoFrameRate=" + localbdfm.jdField_b_of_type_Int + ", beginTime=" + localbdfm.jdField_a_of_type_Long + ", endTime=" + localbdfm.jdField_b_of_type_Long + ",quality:" + (String)localObject + ",videoLongestEdge=" + paramInt1);
      }
      return localbdfm;
      paramInt2 = paramInt1;
      break;
      if (paramInt2 >= 960)
      {
        localObject = "540p";
        paramInt1 = 960;
        break label70;
      }
      paramInt1 = 640;
      localObject = "480p";
      break label70;
    }
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(Throwable paramThrowable)
  {
    QLog.e("VideoCompressTask", 1, "CompressTask, step: HWCompressProcessor onFailed:" + paramThrowable.getMessage());
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjc
 * JD-Core Version:    0.7.0.1
 */