package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;

class QQLiveImage$7$1
  implements AbsThirdDataSourceAdapter.OnPreparedCallback
{
  QQLiveImage$7$1(QQLiveImage.7 param7, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams) {}
  
  public void onPrepared()
  {
    if (URLDrawable.depImp.mLog.isColorLevel()) {
      URLDrawable.depImp.mLog.d(QQLiveImage.TAG + this.this$1.this$0.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，onPrepared: ");
    }
    if (this.val$params != null) {
      this.this$1.this$0.initAndStartPlayer(this.val$params.mStartPosi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.7.1
 * JD-Core Version:    0.7.0.1
 */