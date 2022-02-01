package com.tencent.av.gaudio;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.avatar.QavUpdateAvatarViewHelper;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.utils.AVUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class GaInviteLockActivity$11
  implements Runnable
{
  GaInviteLockActivity$11(GaInviteLockActivity paramGaInviteLockActivity) {}
  
  public void run()
  {
    int i = this.this$0.jdField_a_of_type_Int;
    long l = this.this$0.jdField_a_of_type_Long;
    int j = AVUtil.c(this.this$0.jdField_b_of_type_Int);
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(i, String.valueOf(l), null);
    String str1 = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(j, String.valueOf(this.this$0.jdField_b_of_type_Long), String.valueOf(this.this$0.jdField_a_of_type_Long));
    String str2 = this.this$0.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mAsyncSubThreadRunnable[groupName,");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("],[peerName,");
    localStringBuilder.append(str1);
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    if ((!this.this$0.isFinishing()) && (GaInviteLockActivity.a(this.this$0) != null))
    {
      GaInviteLockActivity.a(this.this$0).removeCallbacks(GaInviteLockActivity.a(this.this$0));
      GaInviteLockActivity.a(this.this$0).a((String)localObject, str1);
      GaInviteLockActivity.a(this.this$0).post(GaInviteLockActivity.a(this.this$0));
    }
    if (GaInviteLockActivity.a(this.this$0) == null) {
      GaInviteLockActivity.a(this.this$0, new QavUpdateAvatarViewHelper());
    }
    localObject = new AvatarParam(j, String.valueOf(this.this$0.jdField_b_of_type_Long), null, true);
    GaInviteLockActivity.a(this.this$0).a(this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface, this.this$0.jdField_a_of_type_AndroidWidgetImageView, (AvatarParam)localObject, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteLockActivity.11
 * JD-Core Version:    0.7.0.1
 */