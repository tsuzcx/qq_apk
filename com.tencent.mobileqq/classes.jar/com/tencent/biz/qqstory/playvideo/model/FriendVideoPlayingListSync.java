package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class FriendVideoPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected String d;
  
  protected VidToVideoInfoPuller b()
  {
    Object localObject = ((UserManager)SuperManager.a(2)).b(this.d);
    int i;
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.c;
    String str = this.d;
    if (i != 0) {
      i = 5;
    } else {
      i = 7;
    }
    return new VidToVideoInfoPuller((String)localObject, str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.FriendVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */