package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.FakeGroupInfo;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.AssertUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  Map<Integer, StoryPlayerGroupHolder> a = new HashMap();
  private ArrayList<IDataProvider.GroupInfo> b = new ArrayList();
  private OnSuperPageChangeListener c;
  private VideoViewVideoHolder.VideoViewListener d;
  private StoryPlayerGlobalHolder e;
  private OnSuperPageChangeListener f = new StoryPlayerGroupAdapter.1(this);
  
  public StoryPlayerGroupAdapter(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    this.e = paramStoryPlayerGlobalHolder;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)this.b.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    Object localObject;
    if (localGroupInfo.c())
    {
      if ((localGroupInfo instanceof IDataProvider.FakeGroupInfo))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LoadingGroup-");
        ((StringBuilder)localObject).append(localGroupInfo.b.b);
        localArrayList.add(StoryPlayerVideoData.a(((StringBuilder)localObject).toString(), null, "Fake-Loading"));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("LoadingGroup-");
        ((StringBuilder)localObject).append(localGroupInfo.b.b);
        localArrayList.add(StoryPlayerVideoData.a(((StringBuilder)localObject).toString(), null, ((UIGroupInfo)localGroupInfo).g));
      }
    }
    else if (localGroupInfo.b())
    {
      if ((localGroupInfo instanceof IDataProvider.FakeGroupInfo))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ErrorGroup-");
        ((StringBuilder)localObject).append(localGroupInfo.b.b);
        localArrayList.add(StoryPlayerVideoData.a(((StringBuilder)localObject).toString(), null, ((IDataProvider.FakeGroupInfo)localGroupInfo).a));
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ErrorGroup-");
        ((StringBuilder)localObject).append(localGroupInfo.b.b);
        localArrayList.add(StoryPlayerVideoData.a(((StringBuilder)localObject).toString(), null, ((UIGroupInfo)localGroupInfo).h));
      }
    }
    else if (localGroupInfo.c.isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("EmptyGroup-");
      ((StringBuilder)localObject).append(localGroupInfo.b.b);
      localArrayList.add(StoryPlayerVideoData.a(((StringBuilder)localObject).toString(), null, new ErrorMessage(97000000, "no vid")));
    }
    else
    {
      localObject = localGroupInfo.c.iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        localArrayList.add(new StoryPlayerVideoData(str, (String)localGroupInfo.d.get(str)));
      }
    }
    paramStoryPlayerGroupHolder.a(paramInt, localGroupInfo, localArrayList);
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.e.a(paramInt);
  }
  
  public List<IDataProvider.GroupInfo> a()
  {
    return Collections.unmodifiableList(this.b);
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener, VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.c = paramOnSuperPageChangeListener;
    this.d = paramVideoViewListener;
  }
  
  public void a(@NonNull ArrayList<IDataProvider.GroupInfo> paramArrayList)
  {
    this.b.clear();
    this.b.addAll(paramArrayList);
    this.a.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.d), paramObject);
    localStoryPlayerGroupHolder.f();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.b);
    this.e.k().a(localStoryPlayerGroupHolder);
  }
  
  public int getCount()
  {
    return this.b.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (StoryPlayerGroupHolder)paramObject;
    int i = 0;
    while (i < this.b.size())
    {
      if (((IDataProvider.GroupInfo)this.b.get(i)).b.equals(paramObject.e))
      {
        if (i == paramObject.d)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.d));
          this.a.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.d), Integer.valueOf(i));
        this.a.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.d), paramObject.e.b);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((IDataProvider.GroupInfo)this.b.get(paramInt) == null)
    {
      paramViewGroup = new StringBuilder();
      paramViewGroup.append("can not get group info by position = ");
      paramViewGroup.append(paramInt);
      paramViewGroup.append(", size = ");
      paramViewGroup.append(this.b.size());
      AssertUtils.assertTrue(false, paramViewGroup.toString());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.e.k().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.e);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.e);
      localStoryPlayerGroupHolder1.e();
      localStoryPlayerGroupHolder1.a(this.f, this.d);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.b);
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.b);
    this.a.put(Integer.valueOf(paramInt), localStoryPlayerGroupHolder1);
    a(paramInt, localStoryPlayerGroupHolder1);
    return localStoryPlayerGroupHolder1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool3 = paramObject instanceof StoryPlayerGroupHolder;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (((StoryPlayerGroupHolder)paramObject).b == paramView) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */