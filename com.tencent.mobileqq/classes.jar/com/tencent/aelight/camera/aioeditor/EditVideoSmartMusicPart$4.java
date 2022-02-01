package com.tencent.aelight.camera.aioeditor;

import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class EditVideoSmartMusicPart$4
  implements EditVideoSmartMusicPart.onSmartMusicViewListener
{
  EditVideoSmartMusicPart$4(EditVideoSmartMusicPart paramEditVideoSmartMusicPart) {}
  
  public void a(int paramInt, SmartMusicAdapter.SmartMusicVH paramSmartMusicVH)
  {
    if (EditVideoSmartMusicPart.g(this.a)) {
      EditVideoSmartMusicPart.h(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = EditVideoSmartMusicPart.i(this.a).a(paramInt);
    if ((EditVideoSmartMusicPart.j(this.a) != null) && (localVsMusicItemInfo != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPositionChange:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", music name:");
      localStringBuilder.append(localVsMusicItemInfo.mMusicName);
      localStringBuilder.append(", musicSongMid:");
      localStringBuilder.append(localVsMusicItemInfo.mSongMid);
      localStringBuilder.append(", musicCoverUrl:");
      localStringBuilder.append(localVsMusicItemInfo.mAlbumUrl);
      localStringBuilder.append(", musicUrl:");
      localStringBuilder.append(localVsMusicItemInfo.mUrl);
      QLog.i("EditVideoSmartMusicPart", 1, localStringBuilder.toString());
      EditVideoSmartMusicPart.k(this.a);
      EditVideoSmartMusicPart.j(this.a).setText(localVsMusicItemInfo.mMusicName);
      EditVideoSmartMusicPart.a(this.a, localVsMusicItemInfo, paramInt, paramSmartMusicVH);
    }
    EditVideoSmartMusicPart.l(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramInt == this.a.c) {
      return;
    }
    EditVideoSmartMusicPart.e(this.a).setHasAutoSet(false);
    if (EditVideoSmartMusicPart.f(this.a) != null)
    {
      EditVideoSmartMusicPart.f(this.a).a(EditVideoSmartMusicPart.g(this.a) ^ true);
      EditVideoSmartMusicPart.f(this.a).b();
    }
    EditVideoSmartMusicPart.e(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (EditVideoSmartMusicPart.m(this.a) != null) && (EditVideoSmartMusicPart.m(this.a).mSongMid != null) && (EditVideoSmartMusicPart.m(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      EditVideoSmartMusicPart.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.4
 * JD-Core Version:    0.7.0.1
 */