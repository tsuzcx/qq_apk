import com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder;
import com.tencent.mobileqq.apollo.screenshot.EncodeType;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "", "taskId", "", "uniKey", "", "frameTime", "type", "Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "recordFrameCount", "(ILjava/lang/String;ILcom/tencent/mobileqq/apollo/screenshot/EncodeType;I)V", "encoder", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "getEncoder", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "getFrameTime", "outputFilePath", "getOutputFilePath", "()Ljava/lang/String;", "getTaskId", "tempFilePath", "getTempFilePath", "getType", "()Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "getUniKey", "addFrame", "", "forceStopRecord", "", "getRecordFrameCount", "initTempFilePath", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class anbi
{
  public static final anbj a;
  private static final String jdField_d_of_type_JavaLangString;
  private int jdField_a_of_type_Int;
  @NotNull
  private final anbq jdField_a_of_type_Anbq;
  @NotNull
  private final EncodeType jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @NotNull
  private final String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  
  static
  {
    jdField_a_of_type_Anbj = new anbj(null);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = BaseApplication.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
    localObject = ((BaseApplication)localObject).getExternalCacheDir();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    jdField_d_of_type_JavaLangString = ((File)localObject).getPath() + File.separator + "cmshow";
    anbj.a(jdField_a_of_type_Anbj);
  }
  
  public anbi(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull EncodeType paramEncodeType, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_c_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType = paramEncodeType;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = (jdField_d_of_type_JavaLangString + File.separator + "cmshowTempPics" + File.separator + this.jdField_c_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_Anbj.a(this.jdField_c_of_type_JavaLangString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
    switch (anbk.a[paramString.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      paramString = (anbq)new ApolloApngEncoder();
    }
    for (;;)
    {
      this.jdField_a_of_type_Anbq = paramString;
      b();
      this.jdField_a_of_type_Anbq.a();
      return;
      paramString = (anbq)new anbn(this.jdField_a_of_type_JavaLangString);
      continue;
      paramString = (anbq)new anbl(this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private final void b()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      File localFile = new File(str);
      if (localFile.exists())
      {
        if (!localFile.isDirectory()) {
          break label45;
        }
        FileUtils.deleteDirectory(str);
      }
      for (;;)
      {
        localFile.mkdir();
        FileUtils.createFileIfNotExits(this.jdField_b_of_type_JavaLangString);
        return;
        label45:
        if (localFile.isFile()) {
          localFile.delete();
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloCoderResource", 1, "initTempFilePath", localThrowable);
    }
  }
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @NotNull
  public final anbq a()
  {
    return this.jdField_a_of_type_Anbq;
  }
  
  @NotNull
  public final EncodeType a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public final void a()
  {
    this.jdField_d_of_type_Int += 1;
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean a()
  {
    return this.jdField_d_of_type_Int >= 100;
  }
  
  public final int b()
  {
    return this.jdField_d_of_type_Int;
  }
  
  @NotNull
  public final String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public final int d()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbi
 * JD-Core Version:    0.7.0.1
 */