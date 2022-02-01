package com.tencent.biz.qqcircle.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta.StIconInfo;
import feedcloud.FeedCloudMeta.StUser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleAvatarListUtils
{
  public static List<String> a(List<FeedCloudMeta.StUser> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList == null) {
      return localArrayList;
    }
    paramList = paramList.iterator();
    do
    {
      if (!paramList.hasNext()) {
        break;
      }
      FeedCloudMeta.StUser localStUser = (FeedCloudMeta.StUser)paramList.next();
      if (!TextUtils.isEmpty(localStUser.icon.iconUrl.get())) {
        localArrayList.add(localStUser.icon.iconUrl.get());
      } else {
        localArrayList.add(localStUser.id.get());
      }
    } while (localArrayList.size() < paramInt);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.QCircleAvatarListUtils
 * JD-Core Version:    0.7.0.1
 */