package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloCoderResource$Companion;", "", "()V", "TAG", "", "rootPath", "getGifFilePathByKey", "recordKey", "getOutputFilePathByKey", "getRootPath", "initOutputDirIfNeed", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloCoderResource$Companion
{
  private final void a()
  {
    try
    {
      File localFile = new File(((Companion)this).a());
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File(localFile, ".nomedia");
      if (!localFile.exists())
      {
        localFile.createNewFile();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloCoderResource", 1, "initOutputDirIfNeed", localThrowable);
    }
  }
  
  @Nullable
  public final String a()
  {
    if (ApolloCoderResource.d() == null)
    {
      Object localObject = BaseApplication.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplication.getContext()");
      localObject = ((BaseApplication)localObject).getExternalCacheDir();
      StringBuilder localStringBuilder = new StringBuilder();
      if (localObject != null) {
        localObject = ((File)localObject).getPath();
      } else {
        localObject = null;
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("cmshow");
      ApolloCoderResource.a(localStringBuilder.toString());
    }
    return ApolloCoderResource.d();
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "recordKey");
    Companion localCompanion = (Companion)this;
    if (localCompanion.a() != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localCompanion.a());
      localStringBuilder.append('/');
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloCoderResource.Companion
 * JD-Core Version:    0.7.0.1
 */