package com.tencent.biz.qqcircle.immersive.feed;

import android.text.TextUtils;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedStateData;
import com.tencent.biz.qqcircle.immersive.views.banner.QFSImageBanner;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;

class QFSFeedChildPicPresenter$FeedStateObserver
  implements Observer<FeedStateData>
{
  private final WeakReference<QFSFeedChildPicPresenter> a;
  
  QFSFeedChildPicPresenter$FeedStateObserver(QFSFeedChildPicPresenter paramQFSFeedChildPicPresenter)
  {
    this.a = new WeakReference(paramQFSFeedChildPicPresenter);
  }
  
  public void a(FeedStateData paramFeedStateData)
  {
    QFSFeedChildPicPresenter localQFSFeedChildPicPresenter = (QFSFeedChildPicPresenter)this.a.get();
    if (localQFSFeedChildPicPresenter == null) {
      return;
    }
    if (paramFeedStateData == null)
    {
      QLog.d("PIC-QFSFeedChildPicPresenter", 1, "[onChanged] feed state data should not be null.");
      return;
    }
    Object localObject = (FeedCloudMeta.StFeed)localQFSFeedChildPicPresenter.c;
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((FeedCloudMeta.StFeed)localObject).id.get();
    }
    if (!TextUtils.equals(paramFeedStateData.b(), (CharSequence)localObject)) {
      return;
    }
    int i = paramFeedStateData.a();
    if ((QFSFeedChildPicPresenter.b(localQFSFeedChildPicPresenter) != null) && (QFSFeedChildPicPresenter.b(localQFSFeedChildPicPresenter).getCurrentItem() != i))
    {
      QFSFeedChildPicPresenter.b(localQFSFeedChildPicPresenter).setCurrentItem(i, false);
      QFSFeedChildPicPresenter.a(localQFSFeedChildPicPresenter, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPicPresenter.FeedStateObserver
 * JD-Core Version:    0.7.0.1
 */