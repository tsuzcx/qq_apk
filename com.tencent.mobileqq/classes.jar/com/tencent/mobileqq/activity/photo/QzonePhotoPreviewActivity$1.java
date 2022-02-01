package com.tencent.mobileqq.activity.photo;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class QzonePhotoPreviewActivity$1
  implements AdapterView.OnItemClickListener
{
  QzonePhotoPreviewActivity$1(QzonePhotoPreviewActivity paramQzonePhotoPreviewActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (QzonePhotoPreviewActivity.a(this.a))
    {
      this.a.getActivity().finish();
      AlbumUtil.anim(this.a.getActivity(), true, false);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity.1
 * JD-Core Version:    0.7.0.1
 */