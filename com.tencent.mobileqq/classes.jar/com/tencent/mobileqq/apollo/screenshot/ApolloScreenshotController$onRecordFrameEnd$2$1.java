package com.tencent.mobileqq.apollo.screenshot;

import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
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
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
    Object localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
    boolean bool3 = this.this$0.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    StringBuilder localStringBuilder = null;
    boolean bool1 = bool2;
    Object localObject3;
    Object localObject4;
    if (bool3)
    {
      bool1 = bool2;
      if (str != null)
      {
        localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
        if (localObject1 != null) {
          ((IApolloActionRecordListener)localObject1).b();
        }
        if (((IApolloScreenshotEncoder)localObject2).a(str, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.d()))
        {
          ApolloScreenshotController.INSTANCE.a(ApolloScreenshotController.a, str, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
          localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          if (localObject3 != null)
          {
            localObject1 = ApolloScreenshotController.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
            if (localObject1 != null) {
              localObject1 = ((File)localObject1).getAbsolutePath();
            } else {
              localObject1 = null;
            }
            ((IApolloActionRecordListener)localObject3).a(true, (String)localObject1);
          }
          if ((localObject2 instanceof ApolloGifEncoder))
          {
            localObject3 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
            localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
            if (localObject1 != null) {
              localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).b());
            } else {
              localObject1 = null;
            }
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            ((IApolloAvatarFileManager)localObject3).putAction2FrameFilePath(((Integer)localObject1).intValue(), (List)((ApolloGifEncoder)localObject2).a());
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.b());
            ((StringBuilder)localObject1).append("/video/");
            localObject3 = ((StringBuilder)localObject1).toString();
            localObject4 = (IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class);
            localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
            if (localObject1 != null) {
              localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).b());
            } else {
              localObject1 = null;
            }
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            ((IApolloAvatarFileManager)localObject4).putAction2VideoFilePath(((Integer)localObject1).intValue(), (String)localObject3);
          }
          bool1 = true;
        }
        else
        {
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          bool1 = bool2;
          if (localObject1 != null)
          {
            ((IApolloActionRecordListener)localObject1).a(false, null);
            bool1 = bool2;
          }
        }
      }
    }
    ((IApolloScreenshotEncoder)localObject2).b();
    localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
    if (localObject2 != null)
    {
      int i = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
      localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c();
      localObject1 = localStringBuilder;
      if (bool1)
      {
        localObject4 = ApolloScreenshotController.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
        localObject1 = localStringBuilder;
        if (localObject4 != null) {
          localObject1 = ((File)localObject4).getAbsolutePath();
        }
      }
      ((IApolloActionRecordListener)localObject2).a(i, (String)localObject3, (String)localObject1);
    }
    Object localObject1 = ApolloScreenshotController.a(this.this$0.this$0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRecordFrameEnd key:");
    localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
    localStringBuilder.append(" taskId:");
    localStringBuilder.append(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
    localStringBuilder.append(", success:");
    localStringBuilder.append(bool1);
    localStringBuilder.append(", resultPath?");
    localStringBuilder.append(str);
    QLog.i((String)localObject1, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.2.1
 * JD-Core Version:    0.7.0.1
 */