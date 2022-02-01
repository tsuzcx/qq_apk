import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource$Companion;", "", "()V", "TAG", "", "rootPath", "getOutputFilePathByKey", "recordKey", "getRootPath", "initOutputDirIfNeed", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbj
{
  private final void a()
  {
    try
    {
      File localFile = new File(anbi.c());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(localFile, ".nomedia");
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloCoderResource", 1, "initOutputDirIfNeed", localThrowable);
    }
  }
  
  @NotNull
  public final String a()
  {
    return anbi.c();
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    return anbi.c() + '/' + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbj
 * JD-Core Version:    0.7.0.1
 */