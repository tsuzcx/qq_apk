package com.tencent.biz.qqstory.playvideo.watcherlist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.ChildViewClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class QQStoryWatcherListAdapter
  extends BaseAdapter
{
  protected int a;
  protected Context a;
  View.OnTouchListener a;
  protected QQStoryContext a;
  protected ChildViewClickListener a;
  protected List<QQUserUIItem> a;
  
  public QQStoryWatcherListAdapter(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = null;
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = null;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = QQStoryContext.a();
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = paramOnTouchListener;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(ChildViewClickListener paramChildViewClickListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener = paramChildViewClickListener;
  }
  
  public void a(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b(List<QQUserUIItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      int j = this.jdField_a_of_type_Int;
      int i = j;
      if (j == -1) {
        i = 2131561834;
      }
      localObject1 = new BaseViewHolder(((LayoutInflater)localObject1).inflate(i, null));
    }
    else
    {
      localObject1 = (BaseViewHolder)paramView.getTag();
    }
    Object localObject2 = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject3 = (TextView)((BaseViewHolder)localObject1).a(2131371877);
    String str = ((QQUserUIItem)localObject2).getUserIconUrl();
    if (!TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("fillFriendsData userIconUrl = ");
        localStringBuilder.append(str);
        QLog.w("zivonchen", 2, localStringBuilder.toString());
      }
      PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject3, str, 13.0F, 2.0F);
    }
    else
    {
      ((TextView)localObject3).setCompoundDrawablePadding(0);
      ((TextView)localObject3).setCompoundDrawables(null, null, null, null);
    }
    ((TextView)localObject3).setText(PlayModeUtils.a((QQUserUIItem)localObject2));
    localObject3 = (ImageView)((BaseViewHolder)localObject1).a(2131368087);
    if ((((QQUserUIItem)localObject2).isVip) && (HttpUtil.isValidUrl(((QQUserUIItem)localObject2).headUrl))) {
      UIUtils.a((ImageView)localObject3, ((QQUserUIItem)localObject2).headUrl, 38, 38, 1);
    } else if (!TextUtils.isEmpty(((QQUserUIItem)localObject2).qq)) {
      PlayModeUtils.a((ImageView)localObject3, ((QQUserUIItem)localObject2).qq);
    } else {
      ((ImageView)localObject3).setImageDrawable(ImageUtil.f());
    }
    ((BaseViewHolder)localObject1).a = localObject2;
    if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
      ((BaseViewHolder)localObject1).a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
    }
    ((BaseViewHolder)localObject1).a().setOnClickListener((View.OnClickListener)localObject1);
    localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener;
    if (localObject2 != null) {
      ((BaseViewHolder)localObject1).a((ChildViewClickListener)localObject2);
    }
    Object localObject1 = ((BaseViewHolder)localObject1).a();
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter
 * JD-Core Version:    0.7.0.1
 */