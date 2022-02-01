import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloFrameEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "tempFilePath", "", "(Ljava/lang/String;)V", "frameFile", "Ljava/io/File;", "addFrame", "", "pixels", "", "width", "", "height", "encode", "", "outputFilePath", "frameTime", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbl
  implements anbq
{
  public static final anbm a;
  private File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Anbm = new anbm(null);
  }
  
  public anbl(@NotNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    anbr.a(this);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (this.jdField_a_of_type_JavaIoFile == null)
    {
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString + File.separator + SystemClock.elapsedRealtime());
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(paramArrayOfByte));
      bheg.a(localBitmap, 100, this.jdField_a_of_type_JavaIoFile);
      return;
    }
    QLog.w("ApolloScrshot_ApolloFrameEncoder", 1, "addFrame: frameFile already has generated!!");
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    if (this.jdField_a_of_type_JavaIoFile != null)
    {
      File localFile = this.jdField_a_of_type_JavaIoFile;
      if (localFile == null) {
        Intrinsics.throwNpe();
      }
      if (localFile.exists())
      {
        localFile = this.jdField_a_of_type_JavaIoFile;
        if (localFile == null) {
          Intrinsics.throwNpe();
        }
        return FileUtils.rename(localFile.getAbsolutePath(), paramString);
      }
    }
    return false;
  }
  
  public void b()
  {
    anbr.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbl
 * JD-Core Version:    0.7.0.1
 */