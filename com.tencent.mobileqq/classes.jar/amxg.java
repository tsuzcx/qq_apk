import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amxg
  extends bhhe
{
  amxg(File paramFile) {}
  
  public void onDone(bhhf parambhhf)
  {
    super.onDone(parambhhf);
    if ((3 == parambhhf.a()) && (this.a.exists())) {}
    try
    {
      nmk.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambhhf)
    {
      parambhhf = parambhhf;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambhhf.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambhhf)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambhhf)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambhhf.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambhhf)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambhhf;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amxg
 * JD-Core Version:    0.7.0.1
 */