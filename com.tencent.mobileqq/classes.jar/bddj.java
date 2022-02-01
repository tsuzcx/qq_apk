import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class bddj
  implements Callable<File>
{
  bddj(bddi parambddi) {}
  
  public File a()
  {
    if ((!bddi.a(this.a).exists()) || (!bddi.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!bddi.a(this.a, bddi.a(this.a), bddi.a(this.a), bddi.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (bddi.a(this.a).exists())
    {
      return bddi.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bddj
 * JD-Core Version:    0.7.0.1
 */