package com.tencent.av.redpacket.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import atky;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import yyi;

class RedPacketShareFragment$1$1
  implements Runnable
{
  RedPacketShareFragment$1$1(RedPacketShareFragment.1 param1, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$1.this$0.getActivity() == null) || (this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$1.this$0.getActivity().isFinishing())) {
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      RedPacketShareFragment.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$1.this$0);
      yyi.a(1, 2131695956);
      return;
    }
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$1.this$0.a(false);
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("forward_type", 1);
    ((Bundle)localObject).putString("forward_filepath", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("forward_thumb", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("forward_urldrawable_big_url", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putString("forward_extra", this.jdField_a_of_type_JavaLangString);
    ((Bundle)localObject).putInt(atky.e, 1);
    Intent localIntent = new Intent();
    localIntent.putExtra("isFromShare", false);
    localIntent.putExtras((Bundle)localObject);
    localObject = new ForwardFileInfo();
    ((ForwardFileInfo)localObject).b(10012);
    localIntent.putExtra("fileinfo", (Parcelable)localObject);
    atky.a(this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketShareFragment$1.this$0.getActivity(), localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.RedPacketShareFragment.1.1
 * JD-Core Version:    0.7.0.1
 */