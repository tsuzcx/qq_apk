package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.meme.model.BusinessConfig;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.cmshow.engine.action.COMPLETE;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource;", "", "taskId", "", "uniKey", "", "frameTime", "type", "Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "config", "Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "scriptService", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "recordFrameCount", "(ILjava/lang/String;ILcom/tencent/mobileqq/apollo/screenshot/EncodeType;Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;I)V", "getConfig", "()Lcom/tencent/mobileqq/apollo/meme/model/BusinessConfig;", "encoder", "Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "getEncoder", "()Lcom/tencent/mobileqq/apollo/screenshot/IApolloScreenshotEncoder;", "getFrameTime", "()I", "gifFilePath", "getGifFilePath", "()Ljava/lang/String;", "outputFilePath", "getOutputFilePath", "status", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "getStatus", "()Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "setStatus", "(Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;)V", "getTaskId", "tempFilePath", "getType", "()Lcom/tencent/mobileqq/apollo/screenshot/EncodeType;", "getUniKey", "addFrame", "", "forceStopRecord", "", "getRecordFrameCount", "initTempFilePath", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloCoderResource
{
  public static final ApolloCoderResource.Companion a = new ApolloCoderResource.Companion(null);
  private static String n;
  private final String b;
  @Nullable
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private ActionStatus e;
  @NotNull
  private final IApolloScreenshotEncoder f;
  private final int g;
  @NotNull
  private final String h;
  private final int i;
  @NotNull
  private final EncodeType j;
  @NotNull
  private final BusinessConfig k;
  private final IScriptService l;
  private int m;
  
  static
  {
    ApolloCoderResource.Companion.a(a);
  }
  
  public ApolloCoderResource(int paramInt1, @NotNull String paramString, int paramInt2, @NotNull EncodeType paramEncodeType, @NotNull BusinessConfig paramBusinessConfig, @NotNull IScriptService paramIScriptService, int paramInt3)
  {
    this.g = paramInt1;
    this.h = paramString;
    this.i = paramInt2;
    this.j = paramEncodeType;
    this.k = paramBusinessConfig;
    this.l = paramIScriptService;
    this.m = paramInt3;
    paramString = new StringBuilder();
    paramString.append(n);
    paramString.append(File.separator);
    paramString.append("cmshowTempPics");
    paramString.append(File.separator);
    paramString.append(this.h);
    this.b = paramString.toString();
    this.c = a.a(this.h);
    paramString = new StringBuilder();
    paramString.append(n);
    paramString.append(File.separator);
    paramString.append("cmshowGifDatas");
    paramString.append(File.separator);
    paramString.append(this.h);
    this.d = paramString.toString();
    this.e = ((ActionStatus)COMPLETE.a);
    paramString = this.j;
    paramInt1 = ApolloCoderResource.WhenMappings.$EnumSwitchMapping$0[paramString.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 == 3) {
          paramString = (IApolloScreenshotEncoder)new ApolloFrameEncoder(this.l, this.k, this.b, this.g);
        } else {
          throw new NoWhenBranchMatchedException();
        }
      }
      else {
        paramString = (IApolloScreenshotEncoder)new ApolloGifEncoder(this.k, this.d);
      }
    }
    else {
      paramString = (IApolloScreenshotEncoder)new ApolloApngEncoder();
    }
    this.f = paramString;
    l();
    this.f.a();
  }
  
  private final void l()
  {
    try
    {
      String str = this.b;
      if ((this.f instanceof ApolloGifEncoder)) {
        str = this.d;
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
      FileUtils.createFileIfNotExits(this.c);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloCoderResource", 1, "initTempFilePath", localThrowable);
    }
  }
  
  @Nullable
  public final String a()
  {
    return this.c;
  }
  
  public final void a(@NotNull ActionStatus paramActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "<set-?>");
    this.e = paramActionStatus;
  }
  
  @NotNull
  public final String b()
  {
    return this.d;
  }
  
  @NotNull
  public final ActionStatus c()
  {
    return this.e;
  }
  
  @NotNull
  public final IApolloScreenshotEncoder d()
  {
    return this.f;
  }
  
  public final int e()
  {
    return this.m;
  }
  
  public final void f()
  {
    this.m += 1;
  }
  
  public final boolean g()
  {
    return this.m >= 100;
  }
  
  public final int h()
  {
    return this.g;
  }
  
  @NotNull
  public final String i()
  {
    return this.h;
  }
  
  public final int j()
  {
    return this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource
 * JD-Core Version:    0.7.0.1
 */