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
import twk;
import twl;
import twm;
import tzr;
import uai;
import uam;
import uar;
import uas;
import uat;
import ucg;
import ved;
import vxp;

public class StoryPlayerGroupAdapter
  extends PagerAdapter
{
  private ArrayList<twm> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public Map<Integer, StoryPlayerGroupHolder> a;
  private tzr jdField_a_of_type_Tzr;
  private uai jdField_a_of_type_Uai;
  private ucg jdField_a_of_type_Ucg;
  private tzr b = new uam(this);
  
  public StoryPlayerGroupAdapter(uai paramuai)
  {
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_Uai = paramuai;
  }
  
  private void a(int paramInt, StoryPlayerGroupHolder paramStoryPlayerGroupHolder)
  {
    twm localtwm = (twm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ArrayList localArrayList = new ArrayList();
    if (localtwm.c()) {
      if ((localtwm instanceof twk)) {
        localArrayList.add(uas.a("LoadingGroup-" + localtwm.jdField_a_of_type_Twl.a, null, "Fake-Loading"));
      }
    }
    for (;;)
    {
      paramStoryPlayerGroupHolder.a(paramInt, localtwm, localArrayList);
      return;
      localArrayList.add(uas.a("LoadingGroup-" + localtwm.jdField_a_of_type_Twl.a, null, ((uat)localtwm).b));
      continue;
      if (localtwm.b())
      {
        if ((localtwm instanceof twk)) {
          localArrayList.add(uas.a("ErrorGroup-" + localtwm.jdField_a_of_type_Twl.a, null, ((twk)localtwm).a));
        } else {
          localArrayList.add(uas.a("ErrorGroup-" + localtwm.jdField_a_of_type_Twl.a, null, ((uat)localtwm).a));
        }
      }
      else if (localtwm.jdField_a_of_type_JavaUtilList.isEmpty())
      {
        localArrayList.add(uas.a("EmptyGroup-" + localtwm.jdField_a_of_type_Twl.a, null, new ErrorMessage(97000000, "no vid")));
      }
      else
      {
        Iterator localIterator = localtwm.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(new uas(str, (String)localtwm.jdField_a_of_type_JavaUtilMap.get(str)));
        }
      }
    }
  }
  
  @Deprecated
  @Nullable
  public StoryPlayerGroupHolder a(int paramInt)
  {
    return this.jdField_a_of_type_Uai.a(paramInt);
  }
  
  public List<twm> a()
  {
    return Collections.unmodifiableList(this.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(@NonNull ArrayList<twm> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_JavaUtilMap.clear();
    notifyDataSetChanged();
  }
  
  public void a(tzr paramtzr, ucg paramucg)
  {
    this.jdField_a_of_type_Tzr = paramtzr;
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    StoryPlayerGroupHolder localStoryPlayerGroupHolder = (StoryPlayerGroupHolder)paramObject;
    ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "destroyItem, verticalPosition = %d, holderPosition = %d, object = %s", Integer.valueOf(paramInt), Integer.valueOf(localStoryPlayerGroupHolder.jdField_a_of_type_Int), paramObject);
    localStoryPlayerGroupHolder.c();
    paramViewGroup.removeView(localStoryPlayerGroupHolder.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Uai.a().a(localStoryPlayerGroupHolder);
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
      if (((twm)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_Twl.equals(paramObject.jdField_a_of_type_Twl))
      {
        if (i == paramObject.jdField_a_of_type_Int)
        {
          ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_UNCHANGED", Integer.valueOf(paramObject.jdField_a_of_type_Int));
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
          a(i, paramObject);
          return -1;
        }
        ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, old vertical position = %d => POSITION_%d", Integer.valueOf(paramObject.jdField_a_of_type_Int), Integer.valueOf(i));
        this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(i), paramObject);
        a(i, paramObject);
        return i;
      }
      i += 1;
    }
    ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "getItemPosition, vertical position = %d , groupId = %s => POSITION_NONE", Integer.valueOf(paramObject.jdField_a_of_type_Int), paramObject.jdField_a_of_type_Twl.a);
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d", Integer.valueOf(paramInt));
    if ((twm)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt) == null)
    {
      vxp.a(false, "can not get group info by position = " + paramInt + ", size = " + this.jdField_a_of_type_JavaUtilArrayList.size());
      return null;
    }
    StoryPlayerGroupHolder localStoryPlayerGroupHolder2 = (StoryPlayerGroupHolder)this.jdField_a_of_type_Uai.a().a(StoryPlayerGroupHolder.class);
    StoryPlayerGroupHolder localStoryPlayerGroupHolder1 = localStoryPlayerGroupHolder2;
    if (localStoryPlayerGroupHolder2 == null)
    {
      localStoryPlayerGroupHolder1 = new StoryPlayerGroupHolder(paramViewGroup, this.jdField_a_of_type_Uai);
      localStoryPlayerGroupHolder1.a(localStoryPlayerGroupHolder1);
      localStoryPlayerGroupHolder1.a(this.jdField_a_of_type_Uai);
      localStoryPlayerGroupHolder1.b();
      localStoryPlayerGroupHolder1.a(this.b, this.jdField_a_of_type_Ucg);
    }
    paramViewGroup.addView(localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
    ved.a("Q.qqstory.playernew.StoryPlayerGroupAdapter", "instantiateItem, verticalPosition = %d, addView = %s", Integer.valueOf(paramInt), localStoryPlayerGroupHolder1.jdField_a_of_type_AndroidViewView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupAdapter
 * JD-Core Version:    0.7.0.1
 */