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
    Object localObject1;
    int i;
    label42:
    QQUserUIItem localQQUserUIItem;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Int == -1)
      {
        i = 2131562000;
        localObject1 = new BaseViewHolder(((LayoutInflater)localObject1).inflate(i, null));
        localQQUserUIItem = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject2 = (TextView)((BaseViewHolder)localObject1).a(2131372288);
        String str = localQQUserUIItem.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label286;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject2, str, 13.0F, 2.0F);
        label133:
        ((TextView)localObject2).setText(PlayModeUtils.a(localQQUserUIItem));
        localObject2 = (ImageView)((BaseViewHolder)localObject1).a(2131368336);
        if ((!localQQUserUIItem.isVip) || (!HttpUtil.isValidUrl(localQQUserUIItem.headUrl))) {
          break label304;
        }
        UIUtils.a((ImageView)localObject2, localQQUserUIItem.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      ((BaseViewHolder)localObject1).a = localQQUserUIItem;
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        ((BaseViewHolder)localObject1).a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      ((BaseViewHolder)localObject1).a().setOnClickListener((View.OnClickListener)localObject1);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener != null) {
        ((BaseViewHolder)localObject1).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
      }
      localObject1 = ((BaseViewHolder)localObject1).a();
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
      i = this.jdField_a_of_type_Int;
      break;
      localObject1 = (BaseViewHolder)paramView.getTag();
      break label42;
      label286:
      ((TextView)localObject2).setCompoundDrawablePadding(0);
      ((TextView)localObject2).setCompoundDrawables(null, null, null, null);
      break label133;
      label304:
      if (!TextUtils.isEmpty(localQQUserUIItem.qq)) {
        PlayModeUtils.a((ImageView)localObject2, localQQUserUIItem.qq);
      } else {
        ((ImageView)localObject2).setImageDrawable(ImageUtil.d());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter
 * JD-Core Version:    0.7.0.1
 */