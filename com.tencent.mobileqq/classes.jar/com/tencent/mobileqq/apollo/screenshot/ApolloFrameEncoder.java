package com.tencent.mobileqq.apollo.screenshot;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.player.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.utils.ApolloRecordUtil;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloFrameEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "config", "Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;", "tempFilePath", "", "taskId", "", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;Lcom/tencent/mobileqq/apollo/player/model/BusinessConfig;Ljava/lang/String;I)V", "frameFile", "Ljava/io/File;", "addFrame", "", "pixels", "", "width", "height", "encode", "", "outputFilePath", "frameTime", "getFrameCount", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloFrameEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloFrameEncoder.Companion a;
  private final int jdField_a_of_type_Int;
  private final BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig;
  private final IScriptService jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
  private File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloFrameEncoder$Companion = new ApolloFrameEncoder.Companion(null);
  }
  
  public ApolloFrameEncoder(@NotNull IScriptService paramIScriptService, @NotNull BusinessConfig paramBusinessConfig, @NotNull String paramString, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService = paramIScriptService;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig = paramBusinessConfig;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_JavaIoFile == null) {
      return 0;
    }
    return 1;
  }
  
  public void a()
  {
    IApolloScreenshotEncoder.DefaultImpls.a(this);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (this.jdField_a_of_type_JavaIoFile == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(SystemClock.elapsedRealtime());
      this.jdField_a_of_type_JavaIoFile = new File(((StringBuilder)localObject).toString());
      localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject).copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(paramArrayOfByte));
      paramArrayOfByte = (byte[])localObject;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig.a() != 0) {
        paramArrayOfByte = ApolloRecordUtil.a((Bitmap)localObject, this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig.a());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloPlayerModelBusinessConfig.a() == BusinessConfig.FrameType.JPEG) {
        ImageUtil.b(paramArrayOfByte, 100, this.jdField_a_of_type_JavaIoFile);
      } else {
        ImageUtil.a(paramArrayOfByte, 100, this.jdField_a_of_type_JavaIoFile);
      }
      paramArrayOfByte = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptIScriptService;
      localObject = ScriptUtil.a(this.jdField_a_of_type_Int, true);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "ScriptUtil.getStopRecordScript(taskId, true)");
      paramArrayOfByte.a(new Script((String)localObject));
      return;
    }
    QLog.w("[ApolloScrshot]_ApolloFrameEncoder", 1, "addFrame: frameFile already has generated!!");
  }
  
  public boolean a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    File localFile = this.jdField_a_of_type_JavaIoFile;
    if (localFile != null)
    {
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
    IApolloScreenshotEncoder.DefaultImpls.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloFrameEncoder
 * JD-Core Version:    0.7.0.1
 */