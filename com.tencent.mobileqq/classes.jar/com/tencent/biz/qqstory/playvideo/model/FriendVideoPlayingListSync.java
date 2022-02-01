package com.tencent.biz.qqstory.playvideo.model;

import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class FriendVideoPlayingListSync
  extends BaseVidListPlayingListSync
{
  protected String b;
  
  protected VidToVideoInfoPuller a()
  {
    Object localObject = ((UserManager)SuperManager.a(2)).b(this.b);
    int i;
    if ((localObject != null) && (((QQUserUIItem)localObject).isVip)) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = this.a;
    String str = this.b;
    if (i != 0) {
      i = 5;
    } else {
      i = 7;
    }
    return new VidToVideoInfoPuller((String)localObject, str, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.model.FriendVideoPlayingListSync
 * JD-Core Version:    0.7.0.1
 */