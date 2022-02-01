package com.tencent.biz.qqstory.storyHome.memory.view.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.infocard.view.MyMemoriesListView.OnUIClickListener;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.RoundedTransformation;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.ThumbnailUrlHelper;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.biz.qqstory.widget.StoryCoverView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class MemoriesInnerListAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  QQUserUIItem jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem;
  private MyMemoriesListView.OnUIClickListener jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener = null;
  private MemoriesInnerListAdapter.MemoriesInnerListEventListener jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter$MemoriesInnerListEventListener = null;
  private RoundedTransformation jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation;
  public String a;
  private HashMap<String, VideoCollectionItem.FakeVideoUIItem> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private List<VideoCollectionItem.FakeVideoUIItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  public String b;
  private HashMap<String, WeakReference<BaseViewHolder>> b;
  
  public MemoriesInnerListAdapter(Context paramContext)
  {
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistAsyncImageRoundedTransformation = new RoundedTransformation(8, 0, 1.6F, UIUtils.jdField_a_of_type_JavaUtilHashMap, null);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem = ((UserManager)SuperManager.a(2)).b(QQStoryContext.a().b());
  }
  
  private View a(int paramInt, ViewGroup paramViewGroup)
  {
    LayoutInflater localLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
    if (getItemViewType(paramInt) == 1) {
      return localLayoutInflater.inflate(2131561700, paramViewGroup, false);
    }
    return localLayoutInflater.inflate(2131561701, paramViewGroup, false);
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    paramString = ThumbnailUrlHelper.a(paramString);
    if (!paramString.equals(paramImageView.getTag())) {
      UIUtils.a(paramImageView, paramString, 80, 128, 4, UIUtils.b, "QQStoryMemory");
    }
  }
  
  private void a(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    SLog.a("Q.qqstory.memories.MemoriesInnerListAdapter", "bindView, position=%d", new Object[] { Integer.valueOf(paramInt) });
    if (getItemViewType(paramInt) == 1)
    {
      VideoCollectionItem.FakeVideoUIItem localFakeVideoUIItem = a(paramInt);
      if (localFakeVideoUIItem == null) {
        return;
      }
      localObject = (StoryCoverView)paramBaseViewHolder.a(2131380758);
      if (localFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem == null)
      {
        ((StoryCoverView)localObject).a.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130846843));
        ((StoryCoverView)localObject).setPollLayout(null, -1, null);
        ((StoryCoverView)localObject).setRateLayout(null, -1, -1L, -1);
      }
      else if (localFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl != null)
      {
        a(((StoryCoverView)localObject).a, localFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
        ((StoryCoverView)localObject).setPollLayout(localFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getPollLayout(), -1, null);
        ((StoryCoverView)localObject).setRateLayout(localFakeVideoUIItem.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.getInteractLayout(), -1, -1L, -1);
      }
      this.jdField_b_of_type_JavaUtilHashMap.put(localFakeVideoUIItem.jdField_a_of_type_JavaLangString, new WeakReference(paramBaseViewHolder));
      paramBaseViewHolder = new StringBuilder();
      paramBaseViewHolder.append(QQStoryConstant.jdField_a_of_type_JavaLangString);
      paramBaseViewHolder.append(" ");
      paramBaseViewHolder.append(paramInt + 1);
      ((StoryCoverView)localObject).setContentDescription(paramBaseViewHolder.toString());
      return;
    }
    Object localObject = (ImageView)paramBaseViewHolder.a(2131373249);
    paramBaseViewHolder = (ImageView)paramBaseViewHolder.a(2131373236);
    QQStoryContext.a();
    if (ThemeUtil.isInNightMode(QQStoryContext.a()))
    {
      paramBaseViewHolder.setBackgroundResource(2130846844);
      ((ImageView)localObject).setImageResource(2130846848);
    }
    else
    {
      paramBaseViewHolder.setBackgroundResource(2130846843);
      ((ImageView)localObject).setImageResource(2130846847);
    }
    ((ImageView)localObject).setContentDescription(HardCodeUtil.a(2131706564));
  }
  
  public VideoCollectionItem.FakeVideoUIItem a(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (VideoCollectionItem.FakeVideoUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    SLog.a("Q.qqstory.memories.MemoriesInnerListAdapter", "position=%s, list size=%s", Integer.valueOf(paramInt), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()));
    return null;
  }
  
  public void a(MyMemoriesListView.OnUIClickListener paramOnUIClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener = paramOnUIClickListener;
  }
  
  public void a(MemoriesInnerListAdapter.MemoriesInnerListEventListener paramMemoriesInnerListEventListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter$MemoriesInnerListEventListener = paramMemoriesInnerListEventListener;
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
    if (!this.jdField_a_of_type_JavaLangString.equals(paramString)) {
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject = (VideoCollectionItem.FakeVideoUIItem)paramList.next();
      paramString = (VideoCollectionItem.FakeVideoUIItem)this.jdField_a_of_type_JavaUtilHashMap.get(((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
      if ((paramString != null) && (((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null))
      {
        paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
        localObject = (WeakReference)this.jdField_b_of_type_JavaUtilHashMap.get(((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (((WeakReference)localObject).get() != null)) {
          a(((StoryCoverView)((BaseViewHolder)((WeakReference)localObject).get()).a(2131380758)).a, paramString.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoThumbnailUrl);
        }
      }
      else
      {
        SLog.d("Q.qqstory.memories.MemoriesInnerListAdapter", "why you come hear?");
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getCount()))
    {
      if ((a(paramInt) instanceof MemoriesInnerListAdapter.PublishVideoItem)) {
        return 0;
      }
      return 1;
    }
    return -1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = a(paramInt, paramViewGroup);
      localView.setFocusable(true);
      paramView = new BaseViewHolder(localView);
    }
    else
    {
      BaseViewHolder localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      localView = paramView;
      paramView = localBaseViewHolder;
    }
    a(paramView, paramInt);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = a(paramInt);
    if (localObject != null) {
      if (getItemViewType(paramInt) == 0)
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener;
        if (localObject != null) {
          ((MyMemoriesListView.OnUIClickListener)localObject).a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener != null) {
          if (getItemViewType(0) == 0) {
            this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener.a(this.jdField_a_of_type_JavaLangString, paramInt - 1, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
          } else {
            this.jdField_a_of_type_ComTencentBizQqstoryShareGroupInfocardViewMyMemoriesListView$OnUIClickListener.a(this.jdField_a_of_type_JavaLangString, paramInt, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
          }
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter$MemoriesInnerListEventListener != null)
        {
          String str = VideoCollectionEntry.getCollectionKey(1, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
          this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMemoryViewAdapterMemoriesInnerListAdapter$MemoriesInnerListEventListener.a(str, paramInt, paramView, ((VideoCollectionItem.FakeVideoUIItem)localObject).jdField_a_of_type_JavaLangString);
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.adapter.MemoriesInnerListAdapter
 * JD-Core Version:    0.7.0.1
 */