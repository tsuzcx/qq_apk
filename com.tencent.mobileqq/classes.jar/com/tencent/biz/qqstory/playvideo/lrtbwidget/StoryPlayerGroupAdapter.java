package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import xcx;
import xcy;
import xcz;
import xge;
import xgv;
import xgz;
import xhe;
import xhf;
import xhg;
import xit;
import ykq;
import zdl;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  private ArrayList<xcz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Integer, StoryPlayerGroupHolder> a;
  private xge jdField_a_of_type_Xge;
  private xgv jdField_a_of_type_Xgv;
  private xit jdField_a_of_type_Xit;
  private xge b = new xgz(this);
  
  public StoryPlayerGroupAdapter(xgv paramxgv)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Xgv = paramxgv;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    xcz localxcz = (xcz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localxcz.c()) {
      if ((localxcz instanceof xcx)) {
        localArrayList.add(xhf.a("LoadingGroup-" + localxcz.jdField_a_of_type_Xcy.a, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, localxcz, localArrayList);
      return;
      localArrayList.add(xhf.a("LoadingGroup-" + localxcz.jdField_a_of_type_Xcy.a, null, ((xhg)localxcz).b));
      continue;
      if (localxcz.b())
      {
        if ((localxcz instanceof xcx)) {
          localArrayList.add(xhf.a("ErrorGroup-" + localxcz.jdField_a_of_type_Xcy.a, null, ((xcx)localxcz).a));
        } else {
          localArrayList.add(xhf.a("ErrorGroup-" + localxcz.jdField_a_of_type_Xcy.a, null, ((xhg)localxcz).a));
        }
      }
      else if (localxcz.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localArrayList.add(xhf.a("EmptyGroup-" + localxcz.jdField_a_of_type_Xcy.a, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = localxcz.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new xhf(str, (String)localxcz.jdField_a_of_type_JavaUtilMap.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_a_of_type_Xgv.a(paramInt);
  }
  
  public List<xcz> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(@NonNull ArrayList<xcz> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(xge paramxge, xit paramxit)
  {
    this.jdField_a_of_type_Xge = paramxge;
    this.jdField_a_of_type_Xit = paramxit;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.jdField_a_of_type_Int), paramObject);
    localStoryPlayerGroupHolder.c();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Xgv.a().a(localStoryPlayerGroupHolder);
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
      if (((xcz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Xcy.equals(paramObject.jdField_a_of_type_Xcy))
      {
        if (i == paramObject.jdField_a_of_type_Int)
        {
          ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.jdField_a_of_type_Int), paramObject.jdField_a_of_type_Xcy.a);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((xcz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)
    {
      zdl.a(false, "can not get group info by position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_a_of_type_Xgv.a().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_a_of_type_Xgv);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_a_of_type_Xgv);
      localStoryPlayerGroupHolder1.b();
      localStoryPlayerGroupHolder1.a(this.b, this.jdField_a_of_type_Xit);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    ykq.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */