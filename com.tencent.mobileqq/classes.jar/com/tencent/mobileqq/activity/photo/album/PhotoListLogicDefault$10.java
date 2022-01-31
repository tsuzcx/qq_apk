package com.tencent.mobileqq.activity.photo.album;

import aiml;
import com.tencent.widget.GestureSelectGridView;

public class PhotoListLogicDefault$10
  implements Runnable
{
  public PhotoListLogicDefault$10(aiml paramaiml, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mActivity != null) {
      ((NewPhotoListActivity)this.this$0.mActivity).mGridView.setSelection(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.PhotoListLogicDefault.10
 * JD-Core Version:    0.7.0.1
 */