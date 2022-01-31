import com.tencent.mobileqq.startup.step.MigrateSubscribeDB;
import java.io.File;
import java.util.Comparator;

public class axos
  implements Comparator<File>
{
  public axos(MigrateSubscribeDB paramMigrateSubscribeDB) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile2.lastModified() - paramFile1.lastModified();
    if (l > 0L) {
      return 1;
    }
    if (l == 0L) {
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axos
 * JD-Core Version:    0.7.0.1
 */