import com.tencent.qqmini.sdk.core.utils.QZipIOException;
import java.io.File;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class bgpl
  extends ZipFile
{
  public bgpl(File paramFile)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgpl
 * JD-Core Version:    0.7.0.1
 */