package com.tencent.mobileqq.activity.photo.album.albumlist;

import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

class AbstractAlbumListFragment$AlbumListItemClickListener
  implements AdapterView.OnItemClickListener
{
  private AbstractAlbumListFragment$AlbumListItemClickListener(AbstractAlbumListFragment paramAbstractAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListAdapter.a(paramInt);
    paramView = this.a.getActivity().getIntent();
    if ((paramAdapterView != null) && (paramAdapterView.mMediaFileCount > 0) && (!TextUtils.isEmpty(paramAdapterView.name)))
    {
      boolean bool = this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistAlbumListCustomization.a(paramAdapterView, paramInt, paramView);
      if (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistIAlbumListChoose != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoAlbumAlbumlistIAlbumListChoose.a(paramAdapterView, paramInt, bool);
      }
      return;
    }
    QQToast.a(this.a.getActivity(), 2131689974, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */