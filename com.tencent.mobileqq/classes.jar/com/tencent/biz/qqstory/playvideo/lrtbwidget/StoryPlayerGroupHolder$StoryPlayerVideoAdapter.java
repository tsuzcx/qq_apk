package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

public class StoryPlayerGroupHolder$StoryPlayerVideoAdapter
  extends PagerAdapter
{
  private int jdField_a_of_type_Int = -1;
  private SparseArray<VideoHolderBase> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private StoryPlayerObjectRecycler jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler;
  private VideoViewVideoHolder.VideoViewListener jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener;
  private String jdField_a_of_type_JavaLangString = "Q.qqstory.playernew.StoryPlayerVideoAdapter";
  private ArrayList<StoryPlayerVideoData> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private StoryPlayerGroupHolder b;
  
  public StoryPlayerGroupHolder$StoryPlayerVideoAdapter(StoryPlayerGroupHolder paramStoryPlayerGroupHolder1, StoryPlayerObjectRecycler paramStoryPlayerObjectRecycler, StoryPlayerGroupHolder paramStoryPlayerGroupHolder2)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler = paramStoryPlayerObjectRecycler;
    this.b = paramStoryPlayerGroupHolder2;
  }
  
  public void a(VideoViewVideoHolder.VideoViewListener paramVideoViewListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener = paramVideoViewListener;
  }
  
  public void a(@NonNull ArrayList<StoryPlayerVideoData> paramArrayList, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Q.qqstory.playernew.StoryPlayerVideoAdapter");
    localStringBuilder.append(System.identityHashCode(this));
    localStringBuilder.append("[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("]");
    this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
    SLog.a(this.jdField_a_of_type_JavaLangString, "setDataList, DataSize=%d, VerticalPosition=%d, VidList=%s", Integer.valueOf(paramArrayList.size()), Integer.valueOf(paramInt), paramArrayList);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramArrayList);
    this.jdField_a_of_type_Int = paramInt;
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "destroyItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
    paramObject = (VideoHolderBase)paramObject;
    if (paramObject.c()) {
      paramObject.a(false);
    }
    paramObject.c();
    paramViewGroup.removeView(paramObject.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler.a(paramObject);
    this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemPosition(Object paramObject)
  {
    paramObject = (VideoHolderBase)paramObject;
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (TextUtils.equals(((StoryPlayerVideoData)this.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString))
      {
        if (paramObject.b == i)
        {
          SLog.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_UNCHANGED, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
          int j = paramObject.jdField_a_of_type_Int;
          int k = this.jdField_a_of_type_Int;
          if (j != k) {
            paramObject.a(k, i);
          }
          return -1;
        }
        SLog.a(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_%d, vid = %s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), Integer.valueOf(i), paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramObject.b);
        paramObject.a(this.jdField_a_of_type_Int, i);
        this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramObject);
        return i;
      }
      i += 1;
    }
    SLog.d(this.jdField_a_of_type_JavaLangString, "getItemPosition, verticalPosition=%d, old position = %d => POSITION_NONE, old vid=%s, groupId=%s, id=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramObject.b), paramObject.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, this.b.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, Integer.valueOf(System.identityHashCode(this)) });
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    SLog.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, verticalPosition=%d, horizontalPosition=%d, groupId=%s, vid=%s", Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(paramInt), this.b.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString, ((StoryPlayerVideoData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_a_of_type_JavaLangString);
    Object localObject2 = (VideoHolderContainer)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler.a(VideoHolderContainer.class);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new VideoHolderContainer(paramViewGroup);
      ((VideoHolderContainer)localObject1).a((VideoHolderContainer)localObject1);
      ((VideoHolderContainer)localObject1).a(this.b);
      ((VideoHolderContainer)localObject1).b();
    }
    paramViewGroup.addView(((VideoHolderContainer)localObject1).jdField_a_of_type_AndroidViewView);
    paramViewGroup = (VideoViewVideoHolder)((VideoHolderContainer)localObject1).b(VideoViewVideoHolder.class);
    if (paramViewGroup != null) {
      paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener);
    }
    localObject2 = (StoryPlayerVideoData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    ((VideoHolderContainer)localObject1).a(this.jdField_a_of_type_Int, paramInt, (StoryPlayerVideoData)localObject2, this.b);
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder;
    localObject2 = ((StoryPlayerGroupHolder)localObject2).a(((StoryPlayerGroupHolder)localObject2).jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b()) && ((TextUtils.equals(((VideoHolderContainer)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, (CharSequence)localObject2)) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c())) || (TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString))) && (paramViewGroup != null)) {
      if (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1)
      {
        SLog.a(this.jdField_a_of_type_JavaLangString, "pre-prepared video instantiateItem [↓]. video = %s", localObject1);
        paramViewGroup.a(8, "onBind:pre-prepared");
      }
      else
      {
        if (paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {
          paramViewGroup = paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;
        } else {
          paramViewGroup = null;
        }
        if ((paramViewGroup != null) && (!paramViewGroup.startsWith("Loading")))
        {
          SLog.a(this.jdField_a_of_type_JavaLangString, "pre-load video instantiateItem. vid = %s", paramViewGroup);
          TVKPreloader.a(paramViewGroup, true);
        }
      }
    }
    if ((TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) && ((TextUtils.equals(((VideoHolderContainer)localObject1).jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, (CharSequence)localObject2)) || ((TextUtils.isEmpty((CharSequence)localObject2)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()))))
    {
      SLog.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, setSelected => %s", localObject1);
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a((VideoHolderBase)localObject1);
    }
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == ((VideoHolderBase)paramObject).jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter
 * JD-Core Version:    0.7.0.1
 */