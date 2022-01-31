import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class azxw
  implements Callable<File>
{
  azxw(azxv paramazxv) {}
  
  public File a()
  {
    if ((!azxv.a(this.a).exists()) || (!azxv.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!azxv.a(this.a, azxv.a(this.a), azxv.a(this.a), azxv.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (azxv.a(this.a).exists())
    {
      return azxv.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxw
 * JD-Core Version:    0.7.0.1
 */