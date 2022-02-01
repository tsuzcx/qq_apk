package com.tencent.biz.qqstory.shareGroup.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StoryPickerHorizontalListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  final int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  StoryPickerHorizontalListView.OnCheckBoxClickListener jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnCheckBoxClickListener;
  StoryPickerHorizontalListView.OnHorizontalItemClickListener jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener;
  public String a;
  HashMap<String, VideoCollectionItem.FakeVideoUIItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<VideoCollectionItem.FakeVideoUIItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  final int jdField_b_of_type_Int;
  HashMap<String, WeakReference<StoryPickerHorizontalListAdapter.ItemHolder>> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  final int c;
  
  public StoryPickerHorizontalListAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = UIUtils.a(paramContext, 90.0F);
    this.jdField_b_of_type_Int = UIUtils.a(paramContext, 146.0F);
    this.c = UIUtils.a(paramContext, 4.0F);
  }
  
  private View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561775, paramViewGroup, false);
    paramViewGroup.setTag(new StoryPickerHorizontalListAdapter.ItemHolder(this, paramViewGroup));
    return paramViewGroup;
  }
  
  private void a(View paramView, int paramInt)
  {
    paramView = (StoryPickerHorizontalListAdapter.ItemHolder)paramView.getTag();
    VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
    paramView.a(localFakeVideoUIItem, paramInt);
    this.jdField_b_of_type_JavaUtilHashMap.put(localFakeVideoUIItem.jdField_a_of_type_JavaLangString, new WeakReference(paramView));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!paramString.equals(paramImageView.getTag())))
    {
      UIUtils.a(paramImageView, ThumbnailUrlHelper.a(paramString), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c, UIUtils.b, "QQStoryMemory");
      paramImageView.setTag(paramString);
    }
  }
  
  public VideoCollectionItem.FakeVideoUIItem a(int paramInt)
  {
    return (VideoCollectionItem.FakeVideoUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(StoryPickerHorizontalListView.OnCheckBoxClickListener paramOnCheckBoxClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnCheckBoxClickListener = paramOnCheckBoxClickListener;
  }
  
  public void a(StoryPickerHorizontalListView.OnHorizontalItemClickListener paramOnHorizontalItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener = paramOnHorizontalItemClickListener;
  }
  
  public void a(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      this.jdField_a_of_type_JavaUtilHashMap.put(localFakeVideoUIItem.jdField_a_of_type_JavaLangString, localFakeVideoUIItem);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    super.notifyDataSetChanged();
  }
  
  public void b(List<VideoCollectionItem.FakeVideoUIItem> paramList, String paramString)
  {
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      SLog.d("StoryPickerHorizontalListAdapter", "mCollectionId=%s, but update id=%s", new Object[] { this.jdField_a_of_type_JavaLangString, paramString });
      return;
    }
    SLog.a("StoryPickerHorizontalListAdapter", "updateData");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      paramString = (VideoCollectionItem.FakeVideoUIItem)this.jdField_a_of_type_JavaUtilHashMap.get(((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
      if ((paramString != null) && (((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
      {
        paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          localObject = ((StoryPickerHorizontalListAdapter.ItemHolder)((WeakReference)localObject).get()).a;
          a(((StoryCoverView)localObject).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
          ((StoryCoverView)localObject).setPollLayout(paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
          ((StoryCoverView)localObject).setRateLayout(paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = a(paramViewGroup);
      localView.setFocusable(true);
    }
    a(localView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener != null)
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
      String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, QQStoryContext.a().b());
      this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerHorizontalListView$OnHorizontalItemClickListener.a(str, paramInt, paramView, localFakeVideoUIItem);
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerHorizontalListAdapter
 * JD-Core Version:    0.7.0.1
 */