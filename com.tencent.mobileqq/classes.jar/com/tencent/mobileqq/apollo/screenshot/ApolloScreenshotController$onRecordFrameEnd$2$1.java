package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.meme.ERROR_JS_CALLBACK_ACTION_FAIL;
import com.tencent.mobileqq.apollo.meme.RECORD_COMPLETE;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.cmshow.engine.action.ActionStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ApolloScreenshotController$onRecordFrameEnd$2$1
  implements Runnable
{
  ApolloScreenshotController$onRecordFrameEnd$2$1(ApolloScreenshotController.onRecordFrameEnd.2 param2) {}
  
  public final void run()
  {
    Object localObject1 = this.this$0.a.a();
    IApolloScreenshotEncoder localIApolloScreenshotEncoder = this.this$0.a.d();
    boolean bool = this.this$0.b;
    Object localObject2 = null;
    if ((bool) && (localObject1 != null))
    {
      localObject3 = this.this$0.c;
      if (localObject3 != null) {
        ((IApolloActionRecordListener)localObject3).c();
      }
      localObject3 = localIApolloScreenshotEncoder.a((String)localObject1, this.this$0.a.j());
      Object localObject4;
      if (Intrinsics.areEqual(localObject3, RECORD_COMPLETE.a))
      {
        ApolloScreenshotController.INSTANCE.a(ApolloScreenshotController.a, (String)localObject1, this.this$0.a.i());
        localObject4 = this.this$0.c;
        if (localObject4 != null)
        {
          localObject1 = ApolloScreenshotController.a.a(this.this$0.a.i());
          if (localObject1 != null) {
            localObject1 = ((File)localObject1).getAbsolutePath();
          } else {
            localObject1 = null;
          }
          ((IApolloActionRecordListener)localObject4).a((ActionStatus)localObject3, (String)localObject1);
        }
        localObject1 = localObject3;
        if ((localIApolloScreenshotEncoder instanceof ApolloGifEncoder))
        {
          localObject4 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
          localObject1 = this.this$0.c;
          if (localObject1 != null) {
            localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).f());
          } else {
            localObject1 = null;
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((IApolloAvatarFileManager)localObject4).putAction2FrameFilePath(((Integer)localObject1).intValue(), (List)((ApolloGifEncoder)localIApolloScreenshotEncoder).d());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.this$0.a.b());
          ((StringBuilder)localObject1).append("/video/");
          localObject4 = ((StringBuilder)localObject1).toString();
          IApolloAvatarFileManager localIApolloAvatarFileManager = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
          localObject1 = this.this$0.c;
          if (localObject1 != null) {
            localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).f());
          } else {
            localObject1 = null;
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localIApolloAvatarFileManager.putAction2VideoFilePath(((Integer)localObject1).intValue(), (String)localObject4);
          localObject1 = localObject3;
        }
      }
      else
      {
        localObject4 = this.this$0.c;
        localObject1 = localObject3;
        if (localObject4 != null)
        {
          ((IApolloActionRecordListener)localObject4).a((ActionStatus)localObject3, null);
          localObject1 = localObject3;
        }
      }
    }
    else
    {
      localObject1 = (ActionStatus)ERROR_JS_CALLBACK_ACTION_FAIL.a;
    }
    localIApolloScreenshotEncoder.b();
    bool = Intrinsics.areEqual(localObject1, RECORD_COMPLETE.a);
    this.this$0.a.a((ActionStatus)localObject1);
    localObject1 = localObject2;
    if (bool)
    {
      localObject3 = ApolloScreenshotController.a.a(this.this$0.a.i());
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = ((File)localObject3).getAbsolutePath();
      }
    }
    localObject2 = ApolloScreenshotController.a(this.this$0.this$0);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("onRecordFrameEnd key:");
    ((StringBuilder)localObject3).append(this.this$0.a.i());
    ((StringBuilder)localObject3).append(" taskId:");
    ((StringBuilder)localObject3).append(this.this$0.a.h());
    ((StringBuilder)localObject3).append(", ");
    ((StringBuilder)localObject3).append("success:");
    ((StringBuilder)localObject3).append(bool);
    ((StringBuilder)localObject3).append(", status:");
    ((StringBuilder)localObject3).append(this.this$0.a.c());
    ((StringBuilder)localObject3).append(", resultPath?");
    ((StringBuilder)localObject3).append((String)localObject1);
    QLog.i((String)localObject2, 1, ((StringBuilder)localObject3).toString());
    localObject2 = this.this$0.c;
    if (localObject2 != null) {
      ((IApolloActionRecordListener)localObject2).a(this.this$0.a.c(), this.this$0.a.i(), (String)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.2.1
 * JD-Core Version:    0.7.0.1
 */