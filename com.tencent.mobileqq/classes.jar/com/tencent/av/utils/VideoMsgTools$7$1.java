package com.tencent.av.utils;

import android.content.Context;
import android.os.Bundle;
import bbfn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class VideoMsgTools$7$1
  implements Runnable
{
  VideoMsgTools$7$1(VideoMsgTools.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    Context localContext = (Context)this.this$0.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localContext == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (this.this$0.jdField_a_of_type_Int == 3000) {}
    for (int i = 1;; i = 10)
    {
      localBundle.putInt("MultiAVType", i);
      if (this.this$0.jdField_a_of_type_Boolean) {
        localBundle.putBoolean("isVideo", true);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (this.a != null) {
        localBundle.putParcelableArrayList("invitelist", this.a);
      }
      if (this.this$0.jdField_a_of_type_Int == 1) {
        localBundle.putBoolean("enableInvite", bbfn.a("selectMemberToStartGAudioChat", localQQAppInterface, this.this$0.jdField_a_of_type_JavaLangString));
      }
      ChatActivityUtils.a(localQQAppInterface, localContext, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_JavaLangString, true, true, null, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.7.1
 * JD-Core Version:    0.7.0.1
 */