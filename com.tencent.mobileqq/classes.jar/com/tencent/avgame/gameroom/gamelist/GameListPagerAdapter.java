package com.tencent.avgame.gameroom.gamelist;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import myg;
import nal;
import nar;

public class GameListPagerAdapter
  extends PagerAdapter
{
  protected int a;
  protected Context a;
  protected SparseArray<GameListItemView> a;
  protected LayoutInflater a;
  protected List<myg> a;
  protected nal a;
  protected nar a;
  protected boolean a;
  
  public GameListPagerAdapter(Context paramContext, nar paramnar, nal paramnal)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Nar = paramnar;
    this.jdField_a_of_type_Nal = paramnal;
  }
  
  public myg a(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (paramInt >= 0) {}
    try
    {
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        myg localmyg = (myg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        return localmyg;
      }
      return null;
    }
    finally {}
  }
  
  public void a(List<myg> paramList, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GameListPagerAdapter", 2, "gameList: " + paramList + " isHost:" + paramBoolean + " currentGameIndex:" + paramInt);
    }
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (paramList != null) {
        this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Int = paramInt;
      notifyDataSetChanged();
      return;
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
  }
  
  public int getCount()
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      int i = this.jdField_a_of_type_JavaUtilList.size();
      return i;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    GameListItemView localGameListItemView = (GameListItemView)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      myg localmyg = (myg)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      ??? = localGameListItemView;
      if (localGameListItemView == null)
      {
        ??? = (GameListItemView)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558729, null);
        ((GameListItemView)???).setOnBeginOrPrepareClickListener(this.jdField_a_of_type_Nar);
        ((GameListItemView)???).a(this.jdField_a_of_type_Nal);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, ???);
      }
      ((GameListItemView)???).a(localmyg, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Int, paramInt);
      paramViewGroup.addView((View)???);
      return ???;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.gamelist.GameListPagerAdapter
 * JD-Core Version:    0.7.0.1
 */