import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class anfc
  extends bhyn
{
  anfc(File paramFile) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if ((3 == parambhyo.a()) && (this.a.exists())) {}
    try
    {
      nwp.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambhyo)
    {
      parambhyo = parambhyo;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambhyo.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambhyo)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambhyo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambhyo.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambhyo)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambhyo;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anfc
 * JD-Core Version:    0.7.0.1
 */