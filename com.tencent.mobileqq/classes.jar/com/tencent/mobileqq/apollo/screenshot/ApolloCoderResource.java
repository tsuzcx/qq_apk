package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "", "taskId", "", "uniKey", "", "frameTime", "type", "Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "config", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "recordFrameCount", "(ILjava/lang/String;ILcom/tencent/mobileqq/apollo/screenshot/EncodeType;Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;I)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "encoder", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "getEncoder", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "getFrameTime", "gifFilePath", "getGifFilePath", "()Ljava/lang/String;", "outputFilePath", "getOutputFilePath", "getTaskId", "tempFilePath", "getTempFilePath", "getType", "()Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "getUniKey", "addFrame", "", "forceStopRecord", "", "getRecordFrameCount", "initTempFilePath", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloCoderResource
{
  public static final ApolloCoderResource.Companion a;
  private static String e;
  private int jdField_a_of_type_Int;
  @NotNull
  private final BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig;
  @NotNull
  private final EncodeType jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
  @NotNull
  private final IApolloScreenshotEncoder jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder;
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
  
  public ApolloCoderResource(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull EncodeType paramEncodeType, @NotNull BusinessConfig paramBusinessConfig, int paramInt3)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType = paramEncodeType;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig = paramBusinessConfig;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_a_of_type_JavaLangString = (e + File.separator + "cmshowTempPics" + File.separator + this.jdField_d_of_type_JavaLangString);
    this.jdField_b_of_type_JavaLangString = jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource$Companion.a(this.jdField_d_of_type_JavaLangString);
    this.jdField_c_of_type_JavaLangString = (e + File.separator + "cmshowGifDatas" + File.separator + this.jdField_d_of_type_JavaLangString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
    switch (ApolloCoderResource.WhenMappings.a[paramString.ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 1: 
      paramString = (IApolloScreenshotEncoder)new ApolloApngEncoder();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder = paramString;
      b();
      this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloScreenshotEncoder.a();
      return;
      paramString = (IApolloScreenshotEncoder)new ApolloGifEncoder(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig, this.jdField_c_of_type_JavaLangString);
      continue;
      paramString = (IApolloScreenshotEncoder)new ApolloFrameEncoder(this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig, this.jdField_a_of_type_JavaLangString);
    }
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
      if (localFile.exists())
      {
        if (!localFile.isDirectory()) {
          break label60;
        }
        FileUtils.a(str);
      }
      for (;;)
      {
        localFile.mkdir();
        FileUtils.c(this.jdField_b_of_type_JavaLangString);
        return;
        label60:
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
  public final EncodeType a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScreenshotEncodeType;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource
 * JD-Core Version:    0.7.0.1
 */