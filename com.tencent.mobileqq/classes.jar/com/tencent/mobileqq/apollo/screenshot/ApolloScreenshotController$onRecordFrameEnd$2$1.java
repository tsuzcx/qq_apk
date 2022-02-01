package com.tencent.mobileqq.apollo.screenshot;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
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
    Object localObject2 = null;
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
    Object localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
    Object localObject1;
    Object localObject4;
    label184:
    Object localObject5;
    label337:
    boolean bool;
    if ((this.this$0.jdField_a_of_type_Boolean) && (str != null))
    {
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
      if (localObject1 != null) {
        ((IApolloActionRecordListener)localObject1).b();
      }
      if (((IApolloScreenshotEncoder)localObject3).a(str, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.d()))
      {
        ApolloScreenshotController.a(ApolloScreenshotController.a, str, this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
        if (localObject4 != null)
        {
          localObject1 = ApolloScreenshotController.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
          if (localObject1 != null)
          {
            localObject1 = ((File)localObject1).getAbsolutePath();
            ((IApolloActionRecordListener)localObject4).a(true, (String)localObject1);
          }
        }
        else
        {
          if (!(localObject3 instanceof ApolloGifEncoder)) {
            break label633;
          }
          localObject4 = ApolloAvatarFileManager.a();
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          if (localObject1 == null) {
            break label586;
          }
          localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).b());
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((ApolloAvatarFileManager)localObject4).a(((Integer)localObject1).intValue(), (List)((ApolloGifEncoder)localObject3).a());
          localObject3 = BaseApplicationImpl.getApplication().getSharedPreferences("avatar_cmshow_face_file_path_sp", 0);
          ((SharedPreferences)localObject3).edit().putString("sp_key_avatar_cmshow_face_frame_path" + this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener.b(), this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.b()).commit();
          localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.b() + "/video/";
          localObject5 = ApolloAvatarFileManager.a();
          localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
          if (localObject1 == null) {
            break label591;
          }
          localObject1 = Integer.valueOf(((IApolloActionRecordListener)localObject1).b());
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((ApolloAvatarFileManager)localObject5).b(((Integer)localObject1).intValue(), (String)localObject4);
          ((SharedPreferences)localObject3).edit().putString("sp_key_avatar_cmshow_face_video_path" + this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener.b(), (String)localObject4).commit();
          bool = true;
        }
      }
    }
    for (;;)
    {
      localObject3 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
      if (localObject3 != null)
      {
        int i = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.a();
        localObject4 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c();
        localObject1 = localObject2;
        if (bool)
        {
          localObject5 = ApolloScreenshotController.a.a(this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c());
          localObject1 = localObject2;
          if (localObject5 != null) {
            localObject1 = ((File)localObject5).getAbsolutePath();
          }
        }
        ((IApolloActionRecordListener)localObject3).a(i, (String)localObject4, (String)localObject1);
      }
      QLog.d("ApolloScrshot", 4, "onRecordFrameEnd key:" + this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c() + " taskId:" + this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotApolloCoderResource.c() + " director:" + this.this$0.jdField_a_of_type_Long + ", success:" + bool + ", resultPath?" + str);
      return;
      localObject1 = null;
      break;
      label586:
      localObject1 = null;
      break label184;
      label591:
      localObject1 = null;
      break label337;
      localObject1 = this.this$0.jdField_a_of_type_ComTencentMobileqqApolloScreenshotIApolloActionRecordListener;
      if (localObject1 != null) {
        ((IApolloActionRecordListener)localObject1).a(false, null);
      }
      bool = false;
      continue;
      ((IApolloScreenshotEncoder)localObject3).b();
      bool = false;
      continue;
      label633:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.screenshot.ApolloScreenshotController.onRecordFrameEnd.2.1
 * JD-Core Version:    0.7.0.1
 */