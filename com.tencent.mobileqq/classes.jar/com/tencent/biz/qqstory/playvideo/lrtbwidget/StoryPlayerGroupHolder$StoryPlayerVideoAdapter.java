package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
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
    this.jdField_a_of_type_JavaLangString = ("Q.qqstory.playernew.StoryPlayerVideoAdapter" + System.identityHashCode(this) + "[" + paramInt + "]");
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
          if (paramObject.jdField_a_of_type_Int != this.jdField_a_of_type_Int) {
            paramObject.a(this.jdField_a_of_type_Int, i);
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
    VideoHolderContainer localVideoHolderContainer = (VideoHolderContainer)this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerObjectRecycler.a(VideoHolderContainer.class);
    if (localVideoHolderContainer == null)
    {
      localVideoHolderContainer = new VideoHolderContainer(paramViewGroup);
      localVideoHolderContainer.a(localVideoHolderContainer);
      localVideoHolderContainer.a(this.b);
      localVideoHolderContainer.b();
    }
    for (;;)
    {
      paramViewGroup.addView(localVideoHolderContainer.jdField_a_of_type_AndroidViewView);
      paramViewGroup = (VideoViewVideoHolder)localVideoHolderContainer.b(VideoViewVideoHolder.class);
      if (paramViewGroup != null) {
        paramViewGroup.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoViewListener);
      }
      Object localObject = (StoryPlayerVideoData)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      localVideoHolderContainer.a(this.jdField_a_of_type_Int, paramInt, (StoryPlayerVideoData)localObject, this.b);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localVideoHolderContainer);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString);
      if ((this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.b()) && ((TextUtils.equals(localVideoHolderContainer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c())) || (TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString))) && (paramViewGroup != null))
      {
        if (paramInt != this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c() + 1) {
          break label374;
        }
        SLog.a(this.jdField_a_of_type_JavaLangString, "pre-prepared video instantiateItem [↓]. video = %s", localVideoHolderContainer);
        paramViewGroup.a(8, "onBind:pre-prepared");
      }
      label425:
      for (;;)
      {
        if ((TextUtils.equals(StoryPlayerGroupHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder).a().jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId.jdField_a_of_type_JavaLangString)) && ((TextUtils.equals(localVideoHolderContainer.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString, (CharSequence)localObject)) || ((TextUtils.isEmpty((CharSequence)localObject)) && (paramInt == this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetXViewPager.c()))))
        {
          SLog.a(this.jdField_a_of_type_JavaLangString, "instantiateItem, setSelected => %s", localVideoHolderContainer);
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerGroupHolder.a(localVideoHolderContainer);
        }
        return localVideoHolderContainer;
        label374:
        if (paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData != null) {}
        for (paramViewGroup = paramViewGroup.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetStoryPlayerVideoData.jdField_a_of_type_JavaLangString;; paramViewGroup = null)
        {
          if ((paramViewGroup == null) || (paramViewGroup.startsWith("Loading"))) {
            break label425;
          }
          SLog.a(this.jdField_a_of_type_JavaLangString, "pre-load video instantiateItem. vid = %s", paramViewGroup);
          TVKPreloader.a(paramViewGroup, true);
          break;
        }
      }
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == ((VideoHolderBase)paramObject).jdField_a_of_type_AndroidViewView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.StoryPlayerGroupHolder.StoryPlayerVideoAdapter
 * JD-Core Version:    0.7.0.1
 */