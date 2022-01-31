package com.tencent.image;

import com.tencent.qphone.base.util.QLog;

class QQLiveImage$4$1
  implements AbsThirdDataSourceAdapter.OnPreparedCallback
{
  QQLiveImage$4$1(QQLiveImage.4 param4, QQLiveDrawable.QQLiveDrawableParams paramQQLiveDrawableParams) {}
  
  public void onPrepared()
  {
    if (QLog.isColorLevel()) {
      QLog.d(QQLiveImage.TAG + this.this$1.this$0.ID, 2, "initAndStartPlayer(): DATA_SOURCE_TYPE_THIRD，onPrepared: ");
    }
    if (this.val$params != null) {
      this.this$1.this$0.initAndStartPlayer(this.val$params.mStartPosi);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.4.1
 * JD-Core Version:    0.7.0.1
 */