package com.tencent.biz.qqstory.playvideo.watcherlist;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
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
  protected List a;
  
  public QQStoryWatcherListAdapter(Context paramContext, View.OnTouchListener paramOnTouchListener)
  {
    this.jdField_a_of_type_Int = -1;
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
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public void b(List paramList)
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
    int i;
    label39:
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_Int == -1)
      {
        i = 2130970853;
        paramView = new BaseViewHolder(paramView.inflate(i, null));
        paramViewGroup = (QQUserUIItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        localObject = (TextView)paramView.a(2131362876);
        String str = paramViewGroup.getUserIconUrl();
        if (TextUtils.isEmpty(str)) {
          break label249;
        }
        if (QLog.isColorLevel()) {
          QLog.w("zivonchen", 2, "fillFriendsData userIconUrl = " + str);
        }
        PlayModeUtils.a(this.jdField_a_of_type_AndroidContentContext.getResources(), (TextView)localObject, str, 13.0F, 2.0F);
        label127:
        ((TextView)localObject).setText(PlayModeUtils.a(paramViewGroup));
        localObject = (ImageView)paramView.a(2131364953);
        if ((!paramViewGroup.isVip) || (!HttpUtil.a(paramViewGroup.headUrl))) {
          break label267;
        }
        UIUtils.a((ImageView)localObject, paramViewGroup.headUrl, 38, 38, 1);
      }
    }
    for (;;)
    {
      paramView.a = paramViewGroup;
      if (this.jdField_a_of_type_AndroidViewView$OnTouchListener != null) {
        paramView.a().setOnTouchListener(this.jdField_a_of_type_AndroidViewView$OnTouchListener);
      }
      paramView.a().setOnClickListener(paramView);
      if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener != null) {
        paramView.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistCommonChildViewClickListener);
      }
      return paramView.a();
      i = this.jdField_a_of_type_Int;
      break;
      paramView = (BaseViewHolder)paramView.getTag();
      break label39;
      label249:
      ((TextView)localObject).setCompoundDrawablePadding(0);
      ((TextView)localObject).setCompoundDrawables(null, null, null, null);
      break label127;
      label267:
      if (!TextUtils.isEmpty(paramViewGroup.qq)) {
        PlayModeUtils.a((ImageView)localObject, paramViewGroup.qq);
      } else {
        ((ImageView)localObject).setImageDrawable(ImageUtil.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.watcherlist.QQStoryWatcherListAdapter
 * JD-Core Version:    0.7.0.1
 */