package com.tencent.biz.qqstory.videoplayer;

import android.content.Context;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.VideoPlayModeBase;
import com.tencent.biz.qqstory.playvideo.CustomViewPager.CustomViewPagerAdapter;
import com.tencent.biz.qqstory.playvideo.QQStoryVideoPlayerErrorView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.VideoViewFactory;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.PollWidgetUtils;
import com.tencent.biz.qqstory.view.widget.QQStoryLoadingView;
import com.tencent.biz.qqstory.view.widget.RateWidget;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class VideoPlayerPagerAdapter
  extends CustomViewPager.CustomViewPagerAdapter
  implements View.OnClickListener
{
  public SparseArray a;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public VideoPlayModeBase a;
  public ArrayList a;
  private Queue jdField_a_of_type_JavaUtilQueue = new LinkedList();
  
  public VideoPlayerPagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private void a(int paramInt, View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
    StoryVideoItem localStoryVideoItem;
    do
    {
      return;
      int i = paramInt;
      if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.qqstory.player.VideoPlayerPagerAdapter", 2, "bindItem: position >= mStoryVideoItemList.size(), position=" + paramInt + ", mStoryVideoItemList.size() = " + this.jdField_a_of_type_JavaUtilArrayList.size());
        }
        i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      }
      localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)paramView.getTag();
      localVideoViewHolder.jdField_c_of_type_Int = i;
      SLog.d("Q.qqstory.player.VideoPlayerPagerAdapter", "VideoPlayerPagerAdapter, bindItem : position=%d, videoView hashCode=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.hashCode()) });
      this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localVideoViewHolder);
      localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase == null) {
        break;
      }
    } while (localStoryVideoItem == null);
    paramView.setTag(-666, localStoryVideoItem);
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.c(localVideoViewHolder, localStoryVideoItem);
    return;
    throw new InvalidParameterException("VideoPlayerPAgerAdapter not set mStoryPlayerController");
  }
  
  public int a(String paramString)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      if (localStoryVideoItem.mVid.equals(paramString))
      {
        paramString = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
        if ((paramString != null) && (paramString.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView != null)) {
          paramString.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(localStoryVideoItem);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(i);
      }
    }
    for (;;)
    {
      if (i >= 0) {
        a(i);
      }
      return i;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilQueue != null) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
      {
        VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.valueAt(i);
        if (localVideoViewHolder != null)
        {
          localVideoViewHolder.a();
          localVideoViewHolder.b();
        }
        i += 1;
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
  
  public void a(int paramInt)
  {
    int i = paramInt - 1;
    while (i <= paramInt + 1)
    {
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(i);
      if (localVideoViewHolder != null) {
        localVideoViewHolder.jdField_c_of_type_Int = i;
      }
      i += 1;
    }
  }
  
  public void a(VideoPlayModeBase paramVideoPlayModeBase)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase = paramVideoPlayModeBase;
  }
  
  public void a(List paramList)
  {
    if (paramList != null) {}
    for (int i = paramList.size();; i = 0)
    {
      SLog.d("Q.qqstory.player.YPlayModeUtils", "addStoryVideoItem, size=%d", new Object[] { Integer.valueOf(i) });
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
      return;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    long l = SystemClock.uptimeMillis();
    paramObject = (View)paramObject;
    this.jdField_a_of_type_JavaUtilQueue.offer(paramObject);
    paramViewGroup.removeView(paramObject);
    paramViewGroup = paramObject.getTag();
    if (((paramViewGroup instanceof VideoPlayerPagerAdapter.VideoViewHolder)) && (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null)) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a((VideoPlayerPagerAdapter.VideoViewHolder)paramViewGroup);
    }
    paramViewGroup = (VideoPlayerPagerAdapter.VideoViewHolder)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if ((paramViewGroup != null) && (paramViewGroup.jdField_c_of_type_Boolean))
    {
      paramViewGroup.jdField_c_of_type_Boolean = false;
      if (QLog.isColorLevel()) {
        QLog.d("wyx", 2, new Object[] { "destroyItem: is multiplex. position=", Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      SLog.a("Q.qqstory.player.VideoPlayerPagerAdapter", "destroyItem: position = %d, cost = %d", Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis() - l));
      return;
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder = (VideoPlayerPagerAdapter.VideoViewHolder)((View)paramObject).getTag();
    StoryVideoItem localStoryVideoItem = (StoryVideoItem)((View)paramObject).getTag(-666);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_b_of_type_Int == localVideoViewHolder.jdField_c_of_type_Int) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.b())) {
      return super.getItemPosition(paramObject);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.c())
    {
      int i = this.jdField_a_of_type_JavaUtilArrayList.indexOf(localStoryVideoItem);
      SLog.a("Q.qqstory.player.VideoPlayerPagerAdapter", "getItemPosition, position=%d, newPosition=%s, item=%s", Integer.valueOf(localVideoViewHolder.jdField_c_of_type_Int), Integer.valueOf(i), localStoryVideoItem);
      if (i >= 0)
      {
        if (localVideoViewHolder.jdField_c_of_type_Int == i)
        {
          if (QLog.isColorLevel()) {
            QLog.d("wyx", 2, new Object[] { "getItemPosition: contained same item. old position=", Integer.valueOf(localVideoViewHolder.jdField_c_of_type_Int), ", new position=", Integer.valueOf(i), ", vid=", localStoryVideoItem.mVid, ", view hashCode=", Integer.valueOf(paramObject.hashCode()) });
          }
          SLog.a("Q.qqstory.player.VideoPlayerPagerAdapter", "getItemPosition, skip position %d refresh", Integer.valueOf(i));
          return super.getItemPosition(paramObject);
        }
        if (QLog.isColorLevel()) {
          QLog.d("wyx", 2, new Object[] { "getItemPosition: contained new item. old position=", Integer.valueOf(localVideoViewHolder.jdField_c_of_type_Int), ", new position=", Integer.valueOf(i), ", vid=", localStoryVideoItem.mVid, ", view hashCode=", Integer.valueOf(paramObject.hashCode()) });
        }
        localVideoViewHolder.jdField_c_of_type_Int = i;
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(i));
        localVideoViewHolder.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, localVideoViewHolder);
        ((View)paramObject).setTag(-666, localStoryVideoItem);
        return i;
      }
      if (QLog.isColorLevel()) {
        QLog.d("wyx", 2, new Object[] { "getItemPosition: not found multiplex item. vid=", localStoryVideoItem.mVid });
      }
      return -2;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    long l = SystemClock.uptimeMillis();
    SLog.d("Q.qqstory.player.VideoPlayerPagerAdapter", "[5] instantiateItem, position = %d", new Object[] { Integer.valueOf(paramInt) });
    View localView = (View)this.jdField_a_of_type_JavaUtilQueue.poll();
    if (localView != null) {}
    for (boolean bool = true;; bool = false)
    {
      VideoPlayerPagerAdapter.VideoViewHolder localVideoViewHolder;
      if (localView == null)
      {
        localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970831, paramViewGroup, false);
        localVideoViewHolder = new VideoPlayerPagerAdapter.VideoViewHolder(this);
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryUtilsPollWidgetUtils$IPollWidget = PollWidgetUtils.a(localView.getContext(), 1, 1, null);
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInteractPasterWidget = new RateWidget(localView.getContext());
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)localView.findViewById(2131371939));
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131368995));
        localVideoViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131362707));
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371943));
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryViewWidgetQQStoryLoadingView = ((QQStoryLoadingView)localView.findViewById(2131363616));
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)localView.findViewById(2131362985));
        localVideoViewHolder.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131371948));
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131371942));
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
        localVideoViewHolder.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131371945));
        localVideoViewHolder.jdField_c_of_type_AndroidWidgetLinearLayout = ((LinearLayout)localView.findViewById(2131371946));
        localVideoViewHolder.d = ((LinearLayout)localView.findViewById(2131371944));
        localVideoViewHolder.e = ((LinearLayout)localView.findViewById(2131371947));
        localVideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131371938));
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null)
        {
          QQStoryContext.a();
          QQStoryManager localQQStoryManager = (QQStoryManager)QQStoryContext.a().getManager(180);
          if ((localQQStoryManager != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.jdField_b_of_type_Boolean) && (localQQStoryManager.k))
          {
            localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = VideoViewFactory.a(BaseApplicationImpl.getContext()).a(2);
            ((ViewGroup)localView).addView(localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(), 0, new RelativeLayout.LayoutParams(-1, -1));
            this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(this.jdField_a_of_type_AndroidViewLayoutInflater, this, localVideoViewHolder);
          }
        }
        else
        {
          localView.setTag(localVideoViewHolder);
        }
      }
      for (;;)
      {
        a(paramInt, localView);
        paramViewGroup.addView(localView, -1, -1);
        SLog.a("Q.qqstory.player.VideoPlayerPagerAdapter", "instantiateItem: useCacheView=%s, position = %d, cost = %d", Boolean.valueOf(bool), Integer.valueOf(paramInt), Long.valueOf(SystemClock.uptimeMillis() - l));
        return localView;
        localVideoViewHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView = VideoViewFactory.a(BaseApplicationImpl.getContext()).a(1);
        break;
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    SLog.d("Q.qqstory.player.YPlayModeUtils", "[4] VideoPlayerPagerAdapter, notifyDataSetChanged");
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryPlaymodeVideoPlayModeBase.a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.videoplayer.VideoPlayerPagerAdapter
 * JD-Core Version:    0.7.0.1
 */