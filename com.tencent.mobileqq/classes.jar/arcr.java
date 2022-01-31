import android.content.Context;
import com.tencent.kwstudio.office.base.IGlobal;
import com.tencent.mobileqq.filemanager.fileviewer.FileView.TdsReaderGlobal;
import java.io.File;
import java.io.InputStream;
import java.util.concurrent.Executor;

public final class arcr
  implements IGlobal
{
  private final TdsReaderGlobal a;
  
  private arcr(TdsReaderGlobal paramTdsReaderGlobal)
  {
    this.a = paramTdsReaderGlobal;
  }
  
  public Context getApplicationContext()
  {
    return TdsReaderGlobal.a(this.a);
  }
  
  public Executor getExecutor()
  {
    return TdsReaderGlobal.a(this.a);
  }
  
  public String getFileDir()
  {
    Context localContext = getApplicationContext();
    File localFile2 = localContext.getExternalFilesDir(null);
    File localFile1 = localFile2;
    if (localFile2 == null) {
      localFile1 = localContext.getFilesDir();
    }
    return localFile1.getAbsolutePath();
  }
  
  public InputStream getResourceAsStream(String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arcr
 * JD-Core Version:    0.7.0.1
 */