import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class bdwu
  implements Callable<File>
{
  bdwu(bdwt parambdwt) {}
  
  public File a()
  {
    if ((!bdwt.a(this.a).exists()) || (!bdwt.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!bdwt.a(this.a, bdwt.a(this.a), bdwt.a(this.a), bdwt.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (bdwt.a(this.a).exists())
    {
      return bdwt.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwu
 * JD-Core Version:    0.7.0.1
 */