package com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import yuq;
import yur;
import yut;
import yvb;
import yvc;
import yvm;

public class FacePagerAdapter
  extends PagerAdapter
  implements yvm
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List<FaceListPage> jdField_a_of_type_JavaUtilList = new LinkedList();
  private Queue<FaceListPage> jdField_a_of_type_JavaUtilQueue = new LinkedList();
  private yuq jdField_a_of_type_Yuq;
  private yut jdField_a_of_type_Yut;
  private yvb jdField_a_of_type_Yvb;
  
  public FacePagerAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a()
  {
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    yur localyur = this.jdField_a_of_type_Yvb.a(paramInt);
    if (localyur != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
        if (localFaceListPage.a == paramInt) {
          localFaceListPage.a(localyur);
        }
      }
    }
  }
  
  public void a(yuq paramyuq)
  {
    this.jdField_a_of_type_Yuq = paramyuq;
  }
  
  public void a(yut paramyut)
  {
    this.jdField_a_of_type_Yut = paramyut;
  }
  
  public void a(yvc paramyvc)
  {
    this.jdField_a_of_type_Yvb = paramyvc;
    notifyDataSetChanged();
  }
  
  public void b(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FaceListPage localFaceListPage = (FaceListPage)localIterator.next();
      if (localFaceListPage.a == paramInt) {
        localFaceListPage.a();
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramObject = (FaceListPage)paramObject;
    paramViewGroup.removeView(paramObject);
    paramObject.a = -1;
    paramObject.a(null);
    this.jdField_a_of_type_JavaUtilQueue.offer(paramObject);
    this.jdField_a_of_type_JavaUtilList.remove(paramObject);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Yvb == null) {
      return 0;
    }
    return this.jdField_a_of_type_Yvb.a();
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.jdField_a_of_type_Yvb == null) {
      return null;
    }
    yur localyur = this.jdField_a_of_type_Yvb.a(paramInt);
    FaceListPage localFaceListPage2 = (FaceListPage)this.jdField_a_of_type_JavaUtilQueue.poll();
    FaceListPage localFaceListPage1 = localFaceListPage2;
    if (localFaceListPage2 == null) {
      localFaceListPage1 = new FaceListPage(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Yut, this.jdField_a_of_type_Yuq);
    }
    paramViewGroup.addView(localFaceListPage1);
    localFaceListPage1.a = paramInt;
    localFaceListPage1.a(localyur);
    this.jdField_a_of_type_JavaUtilList.add(localFaceListPage1);
    return localFaceListPage1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePagerAdapter
 * JD-Core Version:    0.7.0.1
 */