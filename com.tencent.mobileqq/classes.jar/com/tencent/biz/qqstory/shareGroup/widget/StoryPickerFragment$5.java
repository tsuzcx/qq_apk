package com.tencent.biz.qqstory.shareGroup.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

class StoryPickerFragment$5
  implements DialogInterface.OnClickListener
{
  StoryPickerFragment$5(StoryPickerFragment paramStoryPickerFragment) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    }
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("extra_checked_vidset", this.a.a);
    this.a.getActivity().setResult(-1, paramDialogInterface);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.5
 * JD-Core Version:    0.7.0.1
 */