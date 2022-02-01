package com.tencent.mobileqq.apollo.screenshot;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.SystemClock;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig;
import com.tencent.mobileqq.apollo.api.player.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.utils.ApolloRecordUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloFrameEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "config", "Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "tempFilePath", "", "(Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;Ljava/lang/String;)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/api/player/model/BusinessConfig;", "frameFile", "Ljava/io/File;", "addFrame", "", "pixels", "", "width", "", "height", "encode", "", "outputFilePath", "frameTime", "getFrameCount", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloFrameEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloFrameEncoder.Companion a;
  @NotNull
  private final BusinessConfig jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig;
  private File jdField_a_of_type_JavaIoFile;
  private final String jdField_a_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloFrameEncoder$Companion = new ApolloFrameEncoder.Companion(null);
  }
  
  public ApolloFrameEncoder(@NotNull BusinessConfig paramBusinessConfig, @NotNull String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig = paramBusinessConfig;
    this.jdField_a_of_type_JavaLangString = paramString;
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
    Bitmap localBitmap;
    if (this.jdField_a_of_type_JavaIoFile == null)
    {
      this.jdField_a_of_type_JavaIoFile = new File(this.jdField_a_of_type_JavaLangString + File.separator + SystemClock.elapsedRealtime());
      localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      localBitmap.copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(paramArrayOfByte));
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig.a() == 0) {
        break label144;
      }
    }
    label144:
    for (paramArrayOfByte = ApolloRecordUtil.a(localBitmap, this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig.a());; paramArrayOfByte = localBitmap)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApiPlayerModelBusinessConfig.a() == BusinessConfig.FrameType.JPEG)
      {
        ImageUtil.b(paramArrayOfByte, 100, this.jdField_a_of_type_JavaIoFile);
        return;
      }
      ImageUtil.a(paramArrayOfByte, 100, this.jdField_a_of_type_JavaIoFile);
      return;
      QLog.w("ApolloScrshot_ApolloFrameEncoder", 1, "addFrame: frameFile already has generated!!");
      return;
    }
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
        return FileUtils.c(localFile.getAbsolutePath(), paramString);
      }
    }
    return false;
  }
  
  public void b()
  {
    IApolloScreenshotEncoder.DefaultImpls.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloFrameEncoder
 * JD-Core Version:    0.7.0.1
 */