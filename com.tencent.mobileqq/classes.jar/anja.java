import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class anja
  extends biht
{
  anja(File paramFile) {}
  
  public void onDone(bihu parambihu)
  {
    super.onDone(parambihu);
    if ((3 == parambihu.a()) && (this.a.exists())) {}
    try
    {
      nof.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambihu)
    {
      parambihu = parambihu;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambihu.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambihu)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambihu)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambihu.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambihu)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambihu;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anja
 * JD-Core Version:    0.7.0.1
 */