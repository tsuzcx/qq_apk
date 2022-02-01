package com.tencent.mobileqq.apollo.screenshot;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.apollo.meme.ERROR_ENCODE_NO_FRAME;
import com.tencent.mobileqq.apollo.meme.MemeHelper;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.apollo.meme.model.BusinessConfig.FrameType;
import com.tencent.mobileqq.apollo.utils.ApolloRecordUtil;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloFrameEncoder;", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "config", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "tempFilePath", "", "taskId", "", "(Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;Ljava/lang/String;I)V", "frameFile", "Ljava/io/File;", "hasEvaluateStopRecord", "", "hasSetTimeoutScheduler", "<set-?>", "waitingFrameIndex", "getWaitingFrameIndex", "()I", "setWaitingFrameIndex", "(I)V", "waitingFrameIndex$delegate", "Lkotlin/properties/ReadWriteProperty;", "addFrame", "", "pixels", "", "width", "height", "encode", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "outputFilePath", "frameTime", "evaluateStopRecordIfNeed", "getFrameCount", "saveFrame2File", "file", "setTimeoutSchedulerIfNeed", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloFrameEncoder
  implements IApolloScreenshotEncoder
{
  public static final ApolloFrameEncoder.Companion b = new ApolloFrameEncoder.Companion(null);
  private File c;
  private boolean d;
  private boolean e;
  private final ReadWriteProperty f;
  private final IScriptService g;
  private final BusinessConfig h;
  private final String i;
  private final int j;
  
  public ApolloFrameEncoder(@NotNull IScriptService paramIScriptService, @NotNull BusinessConfig paramBusinessConfig, @NotNull String paramString, int paramInt)
  {
    this.g = paramIScriptService;
    this.h = paramBusinessConfig;
    this.i = paramString;
    this.j = paramInt;
    paramIScriptService = Delegates.INSTANCE;
    paramIScriptService = Integer.valueOf(CmShowWnsUtils.Y());
    this.f = ((ReadWriteProperty)new ApolloFrameEncoder..special..inlined.observable.1(paramIScriptService, paramIScriptService, this));
  }
  
  private final void a(int paramInt)
  {
    this.f.setValue(this, a[0], Integer.valueOf(paramInt));
  }
  
  private final void a(File paramFile, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("saveFrame2File ");
    ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
    QLog.d("[cmshow][MemePlayer][ApolloScrshot]_ApolloFrameEncoder", 1, ((StringBuilder)localObject).toString());
    localObject = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    ((Bitmap)localObject).copyPixelsFromBuffer((Buffer)ByteBuffer.wrap(paramArrayOfByte));
    paramArrayOfByte = (byte[])localObject;
    if (this.h.a() != 0) {
      paramArrayOfByte = ApolloRecordUtil.a((Bitmap)localObject, this.h.a());
    }
    if (this.h.c() == BusinessConfig.FrameType.JPEG)
    {
      ImageUtil.b(paramArrayOfByte, 100, paramFile);
      return;
    }
    ImageUtil.a(paramArrayOfByte, 100, paramFile);
  }
  
  private final int d()
  {
    return ((Number)this.f.getValue(this, a[0])).intValue();
  }
  
  private final void e()
  {
    if (this.e) {
      return;
    }
    this.e = true;
    Object localObject = ScriptUtils.a(this.j, true);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ScriptUtils.getStopRecordScript(taskId, true)");
    localObject = new Script((String)localObject);
    this.g.a((Script)localObject);
  }
  
  private final void f()
  {
    if (!this.e)
    {
      if (this.d) {
        return;
      }
      this.d = true;
      long l = 333.33334F;
      MemeHelper.a.a((Function0)new ApolloFrameEncoder.setTimeoutSchedulerIfNeed.1(this, l), l);
    }
  }
  
  @NotNull
  public ActionStatus a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "outputFilePath");
    Object localObject = this.c;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((File)localObject).exists())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("encode frameFile:");
        File localFile = this.c;
        if (localFile == null) {
          Intrinsics.throwNpe();
        }
        ((StringBuilder)localObject).append(localFile.getAbsolutePath());
        ((StringBuilder)localObject).append(" to ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("[cmshow][MemePlayer][ApolloScrshot]_ApolloFrameEncoder", 1, ((StringBuilder)localObject).toString());
        localObject = this.c;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        FileUtils.rename(((File)localObject).getAbsolutePath(), paramString);
        return (ActionStatus)RECORD_COMPLETE.a;
      }
    }
    return (ActionStatus)ERROR_ENCODE_NO_FRAME.a;
  }
  
  public void a()
  {
    IApolloScreenshotEncoder.DefaultImpls.a(this);
  }
  
  public void a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "pixels");
    if (d() == 0) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.i);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(System.nanoTime());
    localObject = new File(((StringBuilder)localObject).toString());
    a((File)localObject, paramArrayOfByte, paramInt1, paramInt2);
    paramArrayOfByte = this.c;
    this.c = ((File)localObject);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.exists())) {
      FileUtils.deleteFile(paramArrayOfByte);
    }
    a(d() - 1);
    f();
  }
  
  public void b()
  {
    IApolloScreenshotEncoder.DefaultImpls.b(this);
  }
  
  public int c()
  {
    if (this.c == null) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloFrameEncoder
 * JD-Core Version:    0.7.0.1
 */