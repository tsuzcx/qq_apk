package com.tencent.biz.qqcircle.immersive;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.immersive.bean.QFSRecentlyFeedStateData;
import com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel;
import feedcloud.FeedCloudMeta.StFeed;

public class QFSFolderRightProfileFragment
  extends QFSFolderProfileFragment
  implements Observer<QFSRecentlyFeedStateData>
{
  private FeedCloudMeta.StFeed e;
  
  public QFSFolderRightProfileFragment()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("qfs_key_bundle_personal_fragment_scene", "qfs_personal_fragment_scene_client");
    setArguments(localBundle);
  }
  
  private void E()
  {
    QCircleFeedDataCenter.a().a(this);
  }
  
  public void a(QFSRecentlyFeedStateData paramQFSRecentlyFeedStateData)
  {
    if (paramQFSRecentlyFeedStateData != null)
    {
      this.e = ((FeedCloudMeta.StFeed)paramQFSRecentlyFeedStateData.a.get());
      if ((this.e != null) && (this.d != null)) {
        this.d.a(this.e);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    E();
  }
  
  public int x()
  {
    return -1;
  }
  
  protected void y()
  {
    FeedCloudMeta.StFeed localStFeed = this.e;
    if (localStFeed != null) {
      a(localStFeed);
    }
    super.y();
  }
  
  public void z()
  {
    if ((this.d != null) && (this.d.o()))
    {
      this.d.l();
      this.d.b(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.QFSFolderRightProfileFragment
 * JD-Core Version:    0.7.0.1
 */