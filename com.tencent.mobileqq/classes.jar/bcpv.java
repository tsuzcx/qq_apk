import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class bcpv
  implements Callable<File>
{
  bcpv(bcpu parambcpu) {}
  
  public File a()
  {
    if ((!bcpu.a(this.a).exists()) || (!bcpu.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!bcpu.a(this.a, bcpu.a(this.a), bcpu.a(this.a), bcpu.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (bcpu.a(this.a).exists())
    {
      return bcpu.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcpv
 * JD-Core Version:    0.7.0.1
 */