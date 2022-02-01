package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

public class StoryPlayerGroupHolder$StoryPlayerVideoAdapter
  extends PagerAdapter
{
  private String b = "Q.qqstory.playernew.StoryPlayerVideoAdapter";
  private ArrayList<StoryPlayerVideoData> c = new ArrayList();
  private int d = -1;
  private StoryPlayerGroupHolder e;
  private StoryPlayerObjectRecycler f;
  private SparseArray<VideoHolderBase> g = new SparseArray();
  private VideoViewVideoHolder.VideoViewListener h;
  
  public StoryPlayerGroupHolder$StoryPlayerVideoAdapter(StoryPlayerGroupHolder paramStoryPlayerGroupHolder1, StoryPlayerObjectRecycler paramStoryPlayerObjectRecycler, StoryPlayerGroupHolder paramStoryPlayerGroupHolder2)
  {
    this.f = paramStoryPlayerObjectRecycler;
    this.e = paramStoryPlayerGroupHolder2;
  }
  
  public void a(VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.h = paramVideoViewListener;
  }
  
  public void a(@NonNull ArrayList<StoryPlayerVideoData> paramArrayList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.StoryPlayerVideoAdapter");
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    this.b = localStringBuilder.toString();
    SLog.a(this.b, "setDataList, DataSize=%d, VerticalPosition=%d, VidList=%s", Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt), paramArrayList);
    this.c.clear();
    this.c.addAll(paramArrayList);
    this.d = paramInt;
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    SLog.a(this.b, "destroyItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s", Integer.valueOf(this.d), Integer.valueOf(paramInt), this.e.e.b);
    paramObject = (VideoHolderBase)paramObject;
    if (paramObject.f()) {
      paramObject.a(false);
    }
    paramObject.e();
    paramViewGroup.removeView(paramObject.b);
    this.f.a(paramObject);
    this.g.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.c.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (VideoHolderBase)paramObject;
    int i = 0;
    while (i < this.c.size())
    {
      if (TextUtils.equals(((StoryPlayerVideoData)this.c.get(i)).b, paramObject.c.b))
      {
        if (paramObject.e == i)
        {
          SLog.a(this.b, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_UNCHANGED, vid = %s", Integer.valueOf(this.d), Integer.valueOf(paramObject.e), paramObject.c.b);
          int j = paramObject.d;
          int k = this.d;
          if (j != k) {
            paramObject.a(k, i);
          }
          return -1;
        }
        SLog.a(this.b, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_%d, vid = %s", Integer.valueOf(this.d), Integer.valueOf(paramObject.e), Integer.valueOf(i), paramObject.c.b);
        this.g.remove(paramObject.e);
        paramObject.a(this.d, i);
        this.g.put(i, paramObject);
        return i;
      }
      i += 1;
    }
    SLog.d(this.b, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_NONE, old vid=%s, groupId=%s, id=%d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramObject.e), paramObject.c.b, this.e.e.b, Integer.valueOf(System.identityHashCode(this)) });
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    SLog.a(this.b, "instantiateItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s, vid=%s", Integer.valueOf(this.d), Integer.valueOf(paramInt), this.e.e.b, ((StoryPlayerVideoData)this.c.get(paramInt)).b);
    Object localObject2 = (VideoHolderContainer)this.f.a(VideoHolderContainer.class);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new VideoHolderContainer(paramViewGroup);
      ((VideoHolderContainer)localObject1).a((VideoHolderContainer)localObject1);
      ((VideoHolderContainer)localObject1).a(this.e);
      ((VideoHolderContainer)localObject1).d();
    }
    paramViewGroup.addView(((VideoHolderContainer)localObject1).b);
    paramViewGroup = (VideoViewVideoHolder)((VideoHolderContainer)localObject1).b(VideoViewVideoHolder.class);
    if (paramViewGroup != null) {
      paramViewGroup.a(this.h);
    }
    localObject2 = (StoryPlayerVideoData)this.c.get(paramInt);
    ((VideoHolderContainer)localObject1).a(this.d, paramInt, (StoryPlayerVideoData)localObject2, this.e);
    this.g.put(paramInt, localObject1);
    localObject2 = this.a;
    localObject2 = ((StoryPlayerGroupHolder)localObject2).a(((StoryPlayerGroupHolder)localObject2).e.b);
    if ((this.a.l()) && ((TextUtils.equals(((VideoHolderContainer)localObject1).c.b, (CharSequence)localObject2)) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt == this.a.j.getCurrentItem())) || (TextUtils.equals(StoryPlayerGroupHolder.d(this.a).o().b, this.a.e.b))) && (paramViewGroup != null)) {
      if (paramInt == this.a.j.getCurrentItem() + 1)
      {
        SLog.a(this.b, "pre-prepared video instantiateItem [↓]. video = %s", localObject1);
        paramViewGroup.a(8, "onBind:pre-prepared");
      }
      else
      {
        if (paramViewGroup.c != null) {
          paramViewGroup = paramViewGroup.c.b;
        } else {
          paramViewGroup = null;
        }
        if ((paramViewGroup != null) && (!paramViewGroup.startsWith("Loading")))
        {
          SLog.a(this.b, "pre-load video instantiateItem. vid = %s", paramViewGroup);
          TVKPreloader.a(paramViewGroup, true);
        }
      }
    }
    if ((TextUtils.equals(StoryPlayerGroupHolder.d(this.a).o().b, this.a.e.b)) && ((TextUtils.equals(((VideoHolderContainer)localObject1).c.b, (CharSequence)localObject2)) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt == this.a.j.getCurrentItem()))))
    {
      SLog.a(this.b, "instantiateItem, setSelected => %s", localObject1);
      this.a.a((VideoHolderBase)localObject1);
    }
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == ((VideoHolderBase)paramObject).b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter
 * JD-Core Version:    0.7.0.1
 */