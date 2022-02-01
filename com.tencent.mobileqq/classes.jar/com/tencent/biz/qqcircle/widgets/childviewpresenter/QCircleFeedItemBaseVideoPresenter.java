package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller;
import com.tencent.biz.qqcircle.widgets.QCirclePaiTongKuanIconView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.qcircle.api.global.QCircleHostGlobalInfo;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StVideo;

public abstract class QCircleFeedItemBaseVideoPresenter
  extends QCircleBaseFeedChildPresenter
{
  public View mLoadingProgressView;
  public QCirclePaiTongKuanIconView mPaiTongKuanImg;
  public ImageView mPlayIconImg;
  public FrameLayout mPlayerContainer;
  public QCircleFeedPlayerScroller mPlayerHelper;
  public SeekBar mProgressBar;
  public TextView mProgressText;
  public URLImageView mVideoCoverImg;
  public ImageView mVoiceIcon;
  
  private String isNeedReplaceTmpPic(FeedCloudMeta.StFeed paramStFeed, String paramString)
  {
    String str2 = QCircleHostGlobalInfo.getVideoCoverTempPath();
    String str1 = paramString;
    if (str2 != null)
    {
      str1 = paramString;
      if (str2.contains(paramStFeed.video.fileId.get())) {
        str1 = str2;
      }
    }
    return str1;
  }
  
  protected void bindCover(FeedCloudMeta.StFeed paramStFeed)
  {
    Object localObject2 = QCirclePluginGlobalInfo.b(paramStFeed.id.get());
    Object localObject1 = paramStFeed.cover.picUrl.get();
    if (localObject2 != null) {
      localObject1 = ((FeedCloudMeta.StFeed)localObject2).cover.picUrl.get();
    }
    if ((this.mVideoCoverImg.getTag(2131441643) instanceof String)) {
      localObject2 = (String)this.mVideoCoverImg.getTag(2131441643);
    } else {
      localObject2 = "";
    }
    paramStFeed = isNeedReplaceTmpPic(paramStFeed, (String)localObject1);
    this.mVideoCoverImg.setTag(2131441643, paramStFeed);
    if (!((String)localObject2).equals(paramStFeed))
    {
      localObject1 = this.mVoiceIcon;
      if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() != 8)) {
        this.mVoiceIcon.setVisibility(8);
      }
      this.mVideoCoverImg.setVisibility(0);
      paramStFeed = new Option().setUrl(paramStFeed).setTargetView(this.mVideoCoverImg).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.mVideoCoverImg.getLayoutParams().width).setRequestHeight(this.mVideoCoverImg.getLayoutParams().height);
      QCircleFeedPicLoader.g().loadImage(paramStFeed, new QCircleFeedItemBaseVideoPresenter.1(this));
    }
  }
  
  public void onDataBind(Object paramObject1, Object paramObject2)
  {
    if (((paramObject1 instanceof RecyclerView.ViewHolder)) && ((paramObject2 instanceof FeedBlockData)))
    {
      QCircleFeedPlayerScroller localQCircleFeedPlayerScroller = this.mPlayerHelper;
      if (localQCircleFeedPlayerScroller != null) {
        localQCircleFeedPlayerScroller.a((RecyclerView.ViewHolder)paramObject1, ((FeedBlockData)paramObject2).b());
      }
    }
  }
  
  public void setPlayHelper(QCircleFeedPlayerScroller paramQCircleFeedPlayerScroller)
  {
    this.mPlayerHelper = paramQCircleFeedPlayerScroller;
  }
  
  public void setVoiceIconAndProgressText(boolean paramBoolean)
  {
    Object localObject = this.mVoiceIcon;
    float f2 = 0.8F;
    float f1;
    if (localObject != null)
    {
      if (paramBoolean) {
        f1 = 0.8F;
      } else {
        f1 = 1.0F;
      }
      ((ImageView)localObject).setAlpha(f1);
    }
    localObject = this.mProgressText;
    if (localObject != null)
    {
      if (paramBoolean) {
        f1 = f2;
      } else {
        f1 = 1.0F;
      }
      ((TextView)localObject).setAlpha(f1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBaseVideoPresenter
 * JD-Core Version:    0.7.0.1
 */