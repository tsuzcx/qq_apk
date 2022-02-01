package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
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
  private OnSuperPageChangeListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener;
  private StoryPlayerGlobalHolder jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder;
  private VideoViewVideoHolder.VideoViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener;
  private ArrayList<IDataProvider.GroupInfo> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  Map<Integer, StoryPlayerGroupHolder> jdField_a_of_type_JavaUtilMap = new HashMap();
  private OnSuperPageChangeListener b = new StoryPlayerGroupAdapter.1(this);
  
  public StoryPlayerGroupAdapter(StoryPlayerGlobalHolder paramStoryPlayerGlobalHolder)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder = paramStoryPlayerGlobalHolder;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    IDataProvider.GroupInfo localGroupInfo = (IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localGroupInfo.c()) {
      if ((localGroupInfo instanceof IDataProvider.FakeGroupInfo)) {
        localArrayList.add(StoryPlayerVideoData.a("LoadingGroup-" + localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, localGroupInfo, localArrayList);
      return;
      localArrayList.add(StoryPlayerVideoData.a("LoadingGroup-" + localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a, null, ((UIGroupInfo)localGroupInfo).b));
      continue;
      if (localGroupInfo.b())
      {
        if ((localGroupInfo instanceof IDataProvider.FakeGroupInfo)) {
          localArrayList.add(StoryPlayerVideoData.a("ErrorGroup-" + localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a, null, ((IDataProvider.FakeGroupInfo)localGroupInfo).a));
        } else {
          localArrayList.add(StoryPlayerVideoData.a("ErrorGroup-" + localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a, null, ((UIGroupInfo)localGroupInfo).a));
        }
      }
      else if (localGroupInfo.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localArrayList.add(StoryPlayerVideoData.a("EmptyGroup-" + localGroupInfo.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = localGroupInfo.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new StoryPlayerVideoData(str, (String)localGroupInfo.jdField_a_of_type_JavaUtilMap.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a(paramInt);
  }
  
  public List<IDataProvider.GroupInfo> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(OnSuperPageChangeListener paramOnSuperPageChangeListener, VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetOnSuperPageChangeListener = paramOnSuperPageChangeListener;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = paramVideoViewListener;
  }
  
  public void a(@NonNull ArrayList<IDataProvider.GroupInfo> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilMap.clear();
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.jdField_a_of_type_Int), paramObject);
    localStoryPlayerGroupHolder.c();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().a(localStoryPlayerGroupHolder);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (StoryPlayerGroupHolder)paramObject;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (((IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.equals(paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId))
      {
        if (i == paramObject.jdField_a_of_type_Int)
        {
          SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.jdField_a_of_type_Int), paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.a);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((IDataProvider.GroupInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)
    {
      AssertUtils.a(false, "can not get group info by position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder.a().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGlobalHolder);
      localStoryPlayerGroupHolder1.b();
      localStoryPlayerGroupHolder1.a(this.b, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    SLog.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), localStoryPlayerGroupHolder1);
    a(paramInt, localStoryPlayerGroupHolder1);
    return localStoryPlayerGroupHolder1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof StoryPlayerGroupHolder))
    {
      bool1 = bool2;
      if (((StoryPlayerGroupHolder)paramObject).jdField_a_of_type_AndroidViewView == paramView) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */