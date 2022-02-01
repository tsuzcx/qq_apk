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
import xmr;
import xms;
import xmt;
import xpy;
import xqp;
import xqt;
import xqy;
import xqz;
import xra;
import xsn;
import yuk;
import znw;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  private ArrayList<xmt> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Integer, StoryPlayerGroupHolder> a;
  private xpy jdField_a_of_type_Xpy;
  private xqp jdField_a_of_type_Xqp;
  private xsn jdField_a_of_type_Xsn;
  private xpy b = new xqt(this);
  
  public StoryPlayerGroupAdapter(xqp paramxqp)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Xqp = paramxqp;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    xmt localxmt = (xmt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localxmt.c()) {
      if ((localxmt instanceof xmr)) {
        localArrayList.add(xqz.a("LoadingGroup-" + localxmt.jdField_a_of_type_Xms.a, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, localxmt, localArrayList);
      return;
      localArrayList.add(xqz.a("LoadingGroup-" + localxmt.jdField_a_of_type_Xms.a, null, ((xra)localxmt).b));
      continue;
      if (localxmt.b())
      {
        if ((localxmt instanceof xmr)) {
          localArrayList.add(xqz.a("ErrorGroup-" + localxmt.jdField_a_of_type_Xms.a, null, ((xmr)localxmt).a));
        } else {
          localArrayList.add(xqz.a("ErrorGroup-" + localxmt.jdField_a_of_type_Xms.a, null, ((xra)localxmt).a));
        }
      }
      else if (localxmt.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localArrayList.add(xqz.a("EmptyGroup-" + localxmt.jdField_a_of_type_Xms.a, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = localxmt.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new xqz(str, (String)localxmt.jdField_a_of_type_JavaUtilMap.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_a_of_type_Xqp.a(paramInt);
  }
  
  public List<xmt> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(@NonNull ArrayList<xmt> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(xpy paramxpy, xsn paramxsn)
  {
    this.jdField_a_of_type_Xpy = paramxpy;
    this.jdField_a_of_type_Xsn = paramxsn;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.jdField_a_of_type_Int), paramObject);
    localStoryPlayerGroupHolder.c();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Xqp.a().a(localStoryPlayerGroupHolder);
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
      if (((xmt)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Xms.equals(paramObject.jdField_a_of_type_Xms))
      {
        if (i == paramObject.jdField_a_of_type_Int)
        {
          yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.jdField_a_of_type_Int), paramObject.jdField_a_of_type_Xms.a);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((xmt)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)
    {
      znw.a(false, "can not get group info by position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_a_of_type_Xqp.a().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_a_of_type_Xqp);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_a_of_type_Xqp);
      localStoryPlayerGroupHolder1.b();
      localStoryPlayerGroupHolder1.a(this.b, this.jdField_a_of_type_Xsn);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    yuk.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
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