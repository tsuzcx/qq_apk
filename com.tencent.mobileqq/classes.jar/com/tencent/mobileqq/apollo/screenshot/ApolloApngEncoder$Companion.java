package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder$Companion;", "", "()V", "SO_NAME", "", "getSO_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "dstDir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "getDstDir", "()Ljava/io/File;", "dstFile", "getDstFile", "libName", "getLibName", "soDebugPath", "getSoDebugPath", "soDirName", "getSoDirName", "soLoaded", "", "getSoLoaded", "()Z", "setSoLoaded", "(Z)V", "zipLevel", "", "isReady", "loadLibIfNeed", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ApolloApngEncoder$Companion
{
  @NotNull
  public final String a()
  {
    return ApolloApngEncoder.d();
  }
  
  public final void a(boolean paramBoolean)
  {
    ApolloApngEncoder.a(paramBoolean);
  }
  
  @NotNull
  public final String b()
  {
    return ApolloApngEncoder.e();
  }
  
  public final boolean c()
  {
    return ApolloApngEncoder.f();
  }
  
  public final boolean d()
  {
    return ((Companion)this).c();
  }
  
  public final void e()
  {
    Companion localCompanion = (Companion)this;
    if (localCompanion.c()) {
      return;
    }
    QLog.d(localCompanion.a(), 1, "loadLibIfNeed start");
    SoLoadManager.getInstance().load(localCompanion.b(), (OnLoadListener)ApolloApngEncoder.Companion.loadLibIfNeed.1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder.Companion
 * JD-Core Version:    0.7.0.1
 */