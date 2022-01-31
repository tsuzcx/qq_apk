package com.tencent.mobileqq.activity.photo.album;

import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import bhqp;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;

class AbstractAlbumListFragment$AlbumListItemClickListener
  implements bhqp
{
  private AbstractAlbumListFragment$AlbumListItemClickListener(AbstractAlbumListFragment paramAbstractAlbumListFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.this$0.listAdapter.getItem(paramInt);
    paramView = this.this$0.getActivity().getIntent();
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      QQToast.a(this.this$0.getActivity(), 2131690067, 0).a();
      return;
    }
    boolean bool = this.this$0.mAlbumListLogic.onItemClick(paramAdapterView, paramInt, paramView);
    this.this$0.albumListChoose.onAlbumListChoose(paramAdapterView, paramInt, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractAlbumListFragment.AlbumListItemClickListener
 * JD-Core Version:    0.7.0.1
 */