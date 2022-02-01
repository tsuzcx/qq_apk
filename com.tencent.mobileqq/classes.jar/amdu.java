import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class amdu
  extends bgod
{
  amdu(File paramFile) {}
  
  public void onDone(bgoe parambgoe)
  {
    super.onDone(parambgoe);
    if ((3 == parambgoe.a()) && (this.a.exists())) {}
    try
    {
      npo.a(this.a, this.a.getParent() + File.separator);
      label166:
      return;
    }
    catch (Exception parambgoe)
    {
      parambgoe = parambgoe;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error  error->" + parambgoe.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambgoe)
      {
        return;
      }
    }
    catch (OutOfMemoryError parambgoe)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "unZipFile file error resType->" + parambgoe.getMessage());
      }
      try
      {
        this.a.delete();
        return;
      }
      catch (Exception parambgoe)
      {
        return;
      }
    }
    finally
    {
      try
      {
        this.a.delete();
        throw parambgoe;
      }
      catch (Exception localException)
      {
        break label166;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amdu
 * JD-Core Version:    0.7.0.1
 */