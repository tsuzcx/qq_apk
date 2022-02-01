package com.tencent.biz.pubaccount.readinjoy.ugc.editvideo;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import osg;

class EditVideoFragment$7
  implements Runnable
{
  EditVideoFragment$7(EditVideoFragment paramEditVideoFragment) {}
  
  public void run()
  {
    Intent localIntent = osg.b(this.this$0.getActivity(), 0, 70);
    if (localIntent != null) {
      localIntent.putExtra("edit_video_jump_and_refresh", true);
    }
    this.this$0.getActivity().startActivity(localIntent);
    this.this$0.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment.7
 * JD-Core Version:    0.7.0.1
 */