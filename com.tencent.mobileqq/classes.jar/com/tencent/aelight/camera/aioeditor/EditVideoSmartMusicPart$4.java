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
    if (EditVideoSmartMusicPart.a(this.a)) {
      EditVideoSmartMusicPart.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = EditVideoSmartMusicPart.a(this.a).a(paramInt);
    if ((EditVideoSmartMusicPart.c(this.a) != null) && (localVsMusicItemInfo != null))
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
      EditVideoSmartMusicPart.b(this.a);
      EditVideoSmartMusicPart.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      EditVideoSmartMusicPart.a(this.a, localVsMusicItemInfo, paramInt, paramSmartMusicVH);
    }
    EditVideoSmartMusicPart.c(this.a);
  }
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    if (paramInt == this.a.a) {
      return;
    }
    EditVideoSmartMusicPart.a(this.a).setHasAutoSet(false);
    if (EditVideoSmartMusicPart.a(this.a) != null)
    {
      EditVideoSmartMusicPart.a(this.a).a(EditVideoSmartMusicPart.a(this.a) ^ true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart.4
 * JD-Core Version:    0.7.0.1
 */