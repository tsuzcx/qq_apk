package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import xlo;
import xms;
import xqp;
import xqy;
import xqz;
import xrg;
import xrh;
import xsn;
import yuk;

public class StoryPlayerGroupHolder$StoryPlayerVideoAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = -1;
  private SparseArray<xrg> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.playernew.StoryPlayerVideoAdapter";
  private ArrayList<xqz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private xqy jdField_a_of_type_Xqy;
  private xsn jdField_a_of_type_Xsn;
  private StoryPlayerGroupHolder b;
  
  public StoryPlayerGroupHolder$StoryPlayerVideoAdapter(StoryPlayerGroupHolder paramStoryPlayerGroupHolder1, xqy paramxqy, StoryPlayerGroupHolder paramStoryPlayerGroupHolder2)
  {
    this.jdField_a_of_type_Xqy = paramxqy;
    this.b = paramStoryPlayerGroupHolder2;
  }
  
  public void a(@NonNull ArrayList<xqz> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.playernew.StoryPlayerVideoAdapter" + System.identityHashCode(this) + "[" + paramInt + "]");
    yuk.a(this.jdField_a_of_type_JavaLangString, "setDataList, DataSize=%d, VerticalPosition=%d, VidList=%s", Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt), paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void a(xsn paramxsn)
  {
    this.jdField_a_of_type_Xsn = paramxsn;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    yuk.a(this.jdField_a_of_type_JavaLangString, "destroyItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
    paramObject = (xrg)paramObject;
    if (paramObject.c()) {
      paramObject.a(false);
    }
    paramObject.c();
    paramViewGroup.removeView(paramObject.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Xqy.a(paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (xrg)paramObject;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (TextUtils.equals(((xqz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString))
      {
        if (paramObject.b == i)
        {
          yuk.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_UNCHANGED, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
          if (paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
            paramObject.a(this.jdField_a_of_type_Int, i);
          }
          return -1;
        }
        yuk.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_%d, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), Integer.valueOf(i), paramObject.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramObject.b);
        paramObject.a(this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramObject);
        return i;
      }
      i += 1;
    }
    yuk.d(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_NONE, old vid=%s, groupId=%s, id=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString, this.b.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, Integer.valueOf(System.identityHashCode(this)) });
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    yuk.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s, vid=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString, ((xqz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    xrh localxrh = (xrh)this.jdField_a_of_type_Xqy.a(xrh.class);
    if (localxrh == null)
    {
      localxrh = new xrh(paramViewGroup);
      localxrh.a(localxrh);
      localxrh.a(this.b);
      localxrh.b();
    }
    for (;;)
    {
      paramViewGroup.addView(localxrh.jdField_a_of_type_AndroidViewView);
      paramViewGroup = (VideoViewVideoHolder)localxrh.b(VideoViewVideoHolder.class);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_Xsn);
      }
      Object localObject = (xqz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localxrh.a(this.jdField_a_of_type_Int, paramInt, (xqz)localObject, this.b);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localxrh);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b()) && ((TextUtils.equals(localxrh.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c())) || (TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString))) && (paramViewGroup != null))
      {
        if (paramInt != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1) {
          break label374;
        }
        yuk.a(this.jdField_a_of_type_JavaLangString, "pre-prepared video instantiateItem [↓]. video = %s", localxrh);
        paramViewGroup.a(8, "onBind:pre-prepared");
      }
      label425:
      for (;;)
      {
        if ((TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_Xms.jdField_a_of_type_JavaLangString)) && ((TextUtils.equals(localxrh.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()))))
        {
          yuk.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, setSelected => %s", localxrh);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(localxrh);
        }
        return localxrh;
        label374:
        if (paramViewGroup.jdField_a_of_type_Xqz != null) {}
        for (paramViewGroup = paramViewGroup.jdField_a_of_type_Xqz.jdField_a_of_type_JavaLangString;; paramViewGroup = null)
        {
          if ((paramViewGroup == null) || (paramViewGroup.startsWith("Loading"))) {
            break label425;
          }
          yuk.a(this.jdField_a_of_type_JavaLangString, "pre-load video instantiateItem. vid = %s", paramViewGroup);
          xlo.a(paramViewGroup, true);
          break;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == ((xrg)paramObject).jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter
 * JD-Core Version:    0.7.0.1
 */