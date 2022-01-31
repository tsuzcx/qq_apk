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
import vlc;
import vld;
import vle;
import voj;
import vpa;
import vpe;
import vpj;
import vpk;
import vpl;
import vqy;
import wsv;
import xmh;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  private ArrayList<vle> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Integer, StoryPlayerGroupHolder> a;
  private voj jdField_a_of_type_Voj;
  private vpa jdField_a_of_type_Vpa;
  private vqy jdField_a_of_type_Vqy;
  private voj b = new vpe(this);
  
  public StoryPlayerGroupAdapter(vpa paramvpa)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Vpa = paramvpa;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    vle localvle = (vle)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localvle.c()) {
      if ((localvle instanceof vlc)) {
        localArrayList.add(vpk.a("LoadingGroup-" + localvle.jdField_a_of_type_Vld.a, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, localvle, localArrayList);
      return;
      localArrayList.add(vpk.a("LoadingGroup-" + localvle.jdField_a_of_type_Vld.a, null, ((vpl)localvle).b));
      continue;
      if (localvle.b())
      {
        if ((localvle instanceof vlc)) {
          localArrayList.add(vpk.a("ErrorGroup-" + localvle.jdField_a_of_type_Vld.a, null, ((vlc)localvle).a));
        } else {
          localArrayList.add(vpk.a("ErrorGroup-" + localvle.jdField_a_of_type_Vld.a, null, ((vpl)localvle).a));
        }
      }
      else if (localvle.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localArrayList.add(vpk.a("EmptyGroup-" + localvle.jdField_a_of_type_Vld.a, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = localvle.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new vpk(str, (String)localvle.jdField_a_of_type_JavaUtilMap.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_a_of_type_Vpa.a(paramInt);
  }
  
  public List<vle> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(@NonNull ArrayList<vle> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(voj paramvoj, vqy paramvqy)
  {
    this.jdField_a_of_type_Voj = paramvoj;
    this.jdField_a_of_type_Vqy = paramvqy;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.jdField_a_of_type_Int), paramObject);
    localStoryPlayerGroupHolder.c();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Vpa.a().a(localStoryPlayerGroupHolder);
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
      if (((vle)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Vld.equals(paramObject.jdField_a_of_type_Vld))
      {
        if (i == paramObject.jdField_a_of_type_Int)
        {
          wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.jdField_a_of_type_Int), paramObject.jdField_a_of_type_Vld.a);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((vle)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)
    {
      xmh.a(false, "can not get group info by position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_a_of_type_Vpa.a().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_a_of_type_Vpa);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_a_of_type_Vpa);
      localStoryPlayerGroupHolder1.b();
      localStoryPlayerGroupHolder1.a(this.b, this.jdField_a_of_type_Vqy);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    wsv.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */