package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import tvh;
import twl;
import uai;
import uar;
import uas;
import uaz;
import uba;
import ucg;
import ved;

public class StoryPlayerGroupHolder$StoryPlayerVideoAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = -1;
  private SparseArray<uaz> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.playernew.StoryPlayerVideoAdapter";
  private ArrayList<uas> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private uar jdField_a_of_type_Uar;
  private ucg jdField_a_of_type_Ucg;
  private StoryPlayerGroupHolder b;
  
  public StoryPlayerGroupHolder$StoryPlayerVideoAdapter(StoryPlayerGroupHolder paramStoryPlayerGroupHolder1, uar paramuar, StoryPlayerGroupHolder paramStoryPlayerGroupHolder2)
  {
    this.jdField_a_of_type_Uar = paramuar;
    this.b = paramStoryPlayerGroupHolder2;
  }
  
  public void a(@NonNull ArrayList<uas> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.playernew.StoryPlayerVideoAdapter" + System.identityHashCode(this) + "[" + paramInt + "]");
    ved.a(this.jdField_a_of_type_JavaLangString, "setDataList, DataSize=%d, VerticalPosition=%d, VidList=%s", Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt), paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(ucg paramucg)
  {
    this.jdField_a_of_type_Ucg = paramucg;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ved.a(this.jdField_a_of_type_JavaLangString, "destroyItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
    paramObject = (uaz)paramObject;
    if (paramObject.c()) {
      paramObject.a(false);
    }
    paramObject.c();
    paramViewGroup.removeView(paramObject.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Uar.a(paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (uaz)paramObject;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (TextUtils.equals(((uas)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString))
      {
        if (paramObject.b == i)
        {
          ved.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_UNCHANGED, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
          if (paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
            paramObject.a(this.jdField_a_of_type_Int, i);
          }
          return -1;
        }
        ved.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_%d, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), Integer.valueOf(i), paramObject.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramObject.b);
        paramObject.a(this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramObject);
        return i;
      }
      i += 1;
    }
    ved.d(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_NONE, old vid=%s, groupId=%s, id=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, this.b.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, Integer.valueOf(System.identityHashCode(this)) });
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    ved.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s, vid=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString, ((uas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    uba localuba = (uba)this.jdField_a_of_type_Uar.a(uba.class);
    if (localuba == null)
    {
      localuba = new uba(paramViewGroup);
      localuba.a(localuba);
      localuba.a(this.b);
      localuba.b();
    }
    for (;;)
    {
      paramViewGroup.addView(localuba.jdField_a_of_type_AndroidViewView);
      paramViewGroup = (VideoViewVideoHolder)localuba.b(VideoViewVideoHolder.class);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_Ucg);
      }
      Object localObject = (uas)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localuba.a(this.jdField_a_of_type_Int, paramInt, (uas)localObject, this.b);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localuba);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b()) && ((TextUtils.equals(localuba.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c())) || (TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString))) && (paramViewGroup != null))
      {
        if (paramInt != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1) {
          break label374;
        }
        ved.a(this.jdField_a_of_type_JavaLangString, "pre-prepared video instantiateItem [↓]. video = %s", localuba);
        paramViewGroup.a(8, "onBind:pre-prepared");
      }
      label425:
      for (;;)
      {
        if ((TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Twl.jdField_a_of_type_JavaLangString)) && ((TextUtils.equals(localuba.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()))))
        {
          ved.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, setSelected => %s", localuba);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(localuba);
        }
        return localuba;
        label374:
        if (paramViewGroup.jdField_a_of_type_Uas != null) {}
        for (paramViewGroup = paramViewGroup.jdField_a_of_type_Uas.jdField_a_of_type_JavaLangString;; paramViewGroup = null)
        {
          if ((paramViewGroup == null) || (paramViewGroup.startsWith("Loading"))) {
            break label425;
          }
          ved.a(this.jdField_a_of_type_JavaLangString, "pre-load video instantiateItem. vid = %s", paramViewGroup);
          tvh.a(paramViewGroup, true);
          break;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == ((uaz)paramObject).jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter
 * JD-Core Version:    0.7.0.1
 */