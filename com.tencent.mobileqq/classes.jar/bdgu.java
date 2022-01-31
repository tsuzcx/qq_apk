import com.tencent.qqmini.sdk.core.utils.QZipIOException;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class bdgu
  extends ZipFile
{
  public bdgu(File paramFile)
  {
    super(paramFile);
  }
  
  public InputStream getInputStream(ZipEntry paramZipEntry)
  {
    if (QZipIOException.isInvalidEntry(paramZipEntry)) {
      throw new QZipIOException();
    }
    return super.getInputStream(paramZipEntry);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdgu
 * JD-Core Version:    0.7.0.1
 */