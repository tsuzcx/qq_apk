package com.tencent.biz.qqstory.base.videoupload;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.Iterator;
import java.util.List;

final class StoryVideoUploadManager$1
  implements DialogInterface.OnClickListener
{
  StoryVideoUploadManager$1(List paramList) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      StoryVideoUploadManager.a((String)localIterator.next());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager.1
 * JD-Core Version:    0.7.0.1
 */