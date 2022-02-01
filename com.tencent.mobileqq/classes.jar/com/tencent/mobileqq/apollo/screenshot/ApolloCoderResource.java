package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "", "taskId", "", "uniKey", "", "frameTime", "type", "Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "config", "Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "recordFrameCount", "(ILjava/lang/String;ILcom/tencent/mobileqq/apollo/screenshot/EncodeType;Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;I)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "encoder", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "getEncoder", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "getFrameTime", "gifFilePath", "getGifFilePath", "()Ljava/lang/String;", "outputFilePath", "getOutputFilePath", "getTaskId", "tempFilePath", "getTempFilePath", "getType", "()Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "getUniKey", "addFrame", "", "forceStopRecord", "", "getRecordFrameCount", "initTempFilePath", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloCoderResource
{
  public static final ApolloCoderResource.Companion a;
  private static String e;
  private int jdField_a_of_type_Int;
  @NotNull
  private final BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig;
  @NotNull
  private final EncodeType jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
  @NotNull
  private final IApolloScreenshotEncoder jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder;
  private final IScriptService jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final int jdField_b_of_type_Int;
  @Nullable
  private final String jdField_b_of_type_JavaLangString;
  private final int jdField_c_of_type_Int;
  @NotNull
  private final String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  @NotNull
  private final String jdField_d_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource$Companion = new ApolloCoderResource.Companion(null);
    ApolloCoderResource.Companion.a(jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource$Companion);
  }
  
  public ApolloCoderResource(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull EncodeType paramEncodeType, @NotNull BusinessConfig paramBusinessConfig, @NotNull IScriptService paramIScriptService, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType = paramEncodeType;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig = paramBusinessConfig;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = paramIScriptService;
    this.jdField_d_of_type_Int = paramInt3;
    paramString = new StringBuilder();
    paramString.append(e);
    paramString.append(File.separator);
    paramString.append("cmshowTempPics");
    paramString.append(File.separator);
    paramString.append(this.jdField_d_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangString = paramString.toString();
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource$Companion.a(this.jdField_d_of_type_JavaLangString);
    paramString = new StringBuilder();
    paramString.append(e);
    paramString.append(File.separator);
    paramString.append("cmshowGifDatas");
    paramString.append(File.separator);
    paramString.append(this.jdField_d_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = paramString.toString();
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
    paramInt1 = ApolloCoderResource.WhenMappings.a[paramString.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          paramString = (IApolloScreenshotEncoder)new ApolloFrameEncoder(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_Int);
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        paramString = (IApolloScreenshotEncoder)new ApolloGifEncoder(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig, this.jdField_c_of_type_JavaLangString);
      }
    }
    else {
      paramString = (IApolloScreenshotEncoder)new ApolloApngEncoder();
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder = paramString;
    b();
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder.a();
  }
  
  private final void b()
  {
    try
    {
      String str = this.jdField_a_of_type_JavaLangString;
      if ((this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder instanceof ApolloGifEncoder)) {
        str = this.jdField_c_of_type_JavaLangString;
      }
      File localFile = new File(str);
      if (localFile.exists()) {
        if (localFile.isDirectory()) {
          FileUtils.deleteDirectory(str);
        } else if (localFile.isFile()) {
          localFile.delete();
        }
      }
      localFile.mkdir();
      FileUtils.createFileIfNotExits(this.jdField_b_of_type_JavaLangString);
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
  public final IApolloScreenshotEncoder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder;
  }
  
  @Nullable
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
  
  @NotNull
  public final String c()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public final int d()
  {
    return this.jdField_c_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource
 * JD-Core Version:    0.7.0.1
 */