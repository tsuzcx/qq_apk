package com.tencent.aelight.camera.ae.biz.circle;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.ae.biz.circle.adapter.AlbumListAdapter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class AECircleAlbumListFragment$AlbumListItemClickListener
  implements AdapterView.OnItemClickListener
{
  private AECircleAlbumListFragment$AlbumListItemClickListener(AECircleAlbumListFragment paramAECircleAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAdapterAlbumListAdapter.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView != null) && (paramAdapterView.mMediaFileCount > 0) && (!TextUtils.isEmpty(paramAdapterView.name)))
    {
      boolean bool = this.a.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListLogic.a(paramAdapterView, paramInt, paramView);
      if (this.a.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment$IAlbumListBack != null) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAeBizCircleAECircleAlbumListFragment$IAlbumListBack.a(paramAdapterView, paramInt, bool);
      }
      return;
    }
    QQToast.a(this.a.getActivity(), 2131689974, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.AECircleAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */