package com.tencent.biz.videostory.widget.view.smartmusicview;

import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class EditVideoSmartMusicPart$4
  implements EditVideoSmartMusicPart.onSmartMusicViewListener
{
  EditVideoSmartMusicPart$4(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void a(int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    if (EditVideoSmartMusicPart.a(this.a)) {
      EditVideoSmartMusicPart.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = EditVideoSmartMusicPart.a(this.a).a(paramInt);
    if ((EditVideoSmartMusicPart.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      EditVideoSmartMusicPart.b(this.a);
      EditVideoSmartMusicPart.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      EditVideoSmartMusicPart.a(this.a, localVsMusicItemInfo, paramInt, paramSmartMusicVH);
    }
    EditVideoSmartMusicPart.c(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    EditVideoSmartMusicPart.a(this.a).setHasAutoSet(false);
    if (EditVideoSmartMusicPart.a(this.a) != null)
    {
      paramVsMusicItemInfo = EditVideoSmartMusicPart.a(this.a);
      if (!EditVideoSmartMusicPart.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      EditVideoSmartMusicPart.a(this.a).b();
    }
    EditVideoSmartMusicPart.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (EditVideoSmartMusicPart.a(this.a) != null) && (EditVideoSmartMusicPart.a(this.a).mSongMid != null) && (EditVideoSmartMusicPart.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      EditVideoSmartMusicPart.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.view.smartmusicview.EditVideoSmartMusicPart.4
 * JD-Core Version:    0.7.0.1
 */