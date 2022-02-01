package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.soload.SoLoadManager;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/apollo/screenshot/ApolloApngEncoder$Companion;", "", "()V", "SO_NAME", "", "getSO_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "dstDir", "Ljava/io/File;", "kotlin.jvm.PlatformType", "getDstDir", "()Ljava/io/File;", "dstFile", "getDstFile", "libName", "getLibName", "soDebugPath", "getSoDebugPath", "soDirName", "getSoDirName", "soLoaded", "", "getSoLoaded", "()Z", "setSoLoaded", "(Z)V", "zipLevel", "", "isReady", "loadLibIfNeed", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ApolloApngEncoder$Companion
{
  @NotNull
  public final String a()
  {
    return ApolloApngEncoder.a();
  }
  
  public final void a()
  {
    if (((Companion)this).a()) {
      return;
    }
    QLog.d(((Companion)this).a(), 1, "loadLibIfNeed start");
    SoLoadManager.a().a(((Companion)this).b(), (OnLoadListener)ApolloApngEncoder.Companion.loadLibIfNeed.1.a);
  }
  
  public final void a(boolean paramBoolean)
  {
    ApolloApngEncoder.a(paramBoolean);
  }
  
  public final boolean a()
  {
    return ApolloApngEncoder.a();
  }
  
  @NotNull
  public final String b()
  {
    return ApolloApngEncoder.b();
  }
  
  public final boolean b()
  {
    return ((Companion)this).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloApngEncoder.Companion
 * JD-Core Version:    0.7.0.1
 */