import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

public class bbxk
{
  private static final String[] a = { "libgnustl_shared.so", "libSNPE.so", "libQMCF_snpe.so" };
  
  private static boolean b()
  {
    String str = bbxj.b();
    synchronized (bbxj.a())
    {
      boolean bool1 = FileUtils.fileExists(str + "libQMCF.so");
      boolean bool2 = FileUtils.fileExists(str + a[2]);
      if (QLog.isColorLevel()) {
        QLog.i("SVAF_SoLoad", 2, String.format("isArtFilterSoExist, qmcfso[%s], snpeso[%s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxk
 * JD-Core Version:    0.7.0.1
 */