package com.tencent.aelight.camera.ae.biz.circle.adapter;

import androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup;
import com.tencent.util.ArrayUtils;

class PhotoGridAdapter$1
  extends GridLayoutManager.SpanSizeLookup
{
  PhotoGridAdapter$1(PhotoGridAdapter paramPhotoGridAdapter) {}
  
  public int getSpanSize(int paramInt)
  {
    if (ArrayUtils.isOutOfArrayIndex(paramInt, this.a.a)) {
      return 3;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.adapter.PhotoGridAdapter.1
 * JD-Core Version:    0.7.0.1
 */