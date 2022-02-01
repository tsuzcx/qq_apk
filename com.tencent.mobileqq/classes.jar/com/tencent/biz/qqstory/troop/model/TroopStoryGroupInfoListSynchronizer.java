package com.tencent.biz.qqstory.troop.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.playvideo.model.BaseVidListPlayingListSync;
import java.util.List;

public class TroopStoryGroupInfoListSynchronizer
  extends BaseVidListPlayingListSync
{
  String d;
  public List<String> e;
  public boolean f;
  VidToGroupInfoPuller g;
  
  protected void a(int paramInt)
  {
    if (this.g == null) {
      this.g = new VidToGroupInfoPuller(this.d, this.e);
    }
    if (this.g.c()) {
      return;
    }
    if (!this.f)
    {
      if (this.g.a(this.e, new ErrorMessage(), false, false)) {
        this.g.a();
      }
      this.f = true;
    }
  }
  
  protected VidToVideoInfoPuller b()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.troop.model.TroopStoryGroupInfoListSynchronizer
 * JD-Core Version:    0.7.0.1
 */