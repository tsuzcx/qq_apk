import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.Callable;

class bdwe
  implements Callable<File>
{
  bdwe(bdwd parambdwd) {}
  
  public File a()
  {
    if ((!bdwd.a(this.a).exists()) || (!bdwd.a(this.a)))
    {
      long l = System.currentTimeMillis();
      if (!bdwd.a(this.a, bdwd.a(this.a), bdwd.a(this.a), bdwd.a(this.a).getAbsolutePath())) {
        break label111;
      }
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm success, cost=" + (System.currentTimeMillis() - l));
    }
    while (bdwd.a(this.a).exists())
    {
      return bdwd.a(this.a);
      label111:
      QLog.i("studyroom.AssetsPmUpdater", 1, "copy asset pm fail");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwe
 * JD-Core Version:    0.7.0.1
 */