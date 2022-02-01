package com.tencent.biz.qqstory.takevideo.shareto;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.playmode.util.PlayModeUtils;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.BaseViewHolder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ShareToGroupAdapter
  extends BaseAdapter
{
  protected Context a;
  protected ShareToGroupAdapter.OnSelectStateChangeListener a;
  protected QQAppInterface a;
  protected ArrayList<ShareToGroupAdapter.TroopInfoSelector> a;
  
  public ShareToGroupAdapter(Context paramContext, ArrayList<TroopInfo> paramArrayList, ArrayList<String> paramArrayList1)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = ShareToGroupAdapter.TroopInfoSelector.a(paramArrayList, paramArrayList1);
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ShareToGroupAdapter.TroopInfoSelector localTroopInfoSelector = (ShareToGroupAdapter.TroopInfoSelector)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localTroopInfoSelector.jdField_a_of_type_Boolean) && (!localArrayList.contains(localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin))) {
          localArrayList.add(localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo.troopuin);
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.ShareToGrouopAdapter", 2, "selectTroopUinList" + localArrayList);
    }
    return localArrayList;
  }
  
  public void a(ShareToGroupAdapter.OnSelectStateChangeListener paramOnSelectStateChangeListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter$OnSelectStateChangeListener = paramOnSelectStateChangeListener;
  }
  
  protected void a(ShareToGroupAdapter.TroopInfoSelector paramTroopInfoSelector)
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter$OnSelectStateChangeListener == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter$OnSelectStateChangeListener.a(a(), paramTroopInfoSelector))) {
      if (paramTroopInfoSelector.jdField_a_of_type_Boolean) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      paramTroopInfoSelector.jdField_a_of_type_Boolean = bool;
      notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter$OnSelectStateChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSharetoShareToGroupAdapter$OnSelectStateChangeListener.a(a());
      }
      return;
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ShareToGroupAdapter.TroopInfoSelector localTroopInfoSelector = (ShareToGroupAdapter.TroopInfoSelector)getItem(paramInt);
    TroopInfo localTroopInfo = localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    BaseViewHolder localBaseViewHolder;
    ImageView localImageView;
    Drawable localDrawable;
    if (paramView != null)
    {
      localBaseViewHolder = (BaseViewHolder)paramView.getTag();
      localImageView = (ImageView)localBaseViewHolder.a(2131368076);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTroopFaceDrawable(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label168;
      }
      localImageView.setImageBitmap(ImageUtil.a());
      label69:
      ((TextView)localBaseViewHolder.a(2131368123)).setText(localTroopInfo.getTroopDisplayName());
      ((CheckBox)localBaseViewHolder.a(2131364731)).setChecked(localTroopInfoSelector.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label178;
      }
      paramView.setBackgroundResource(2130839575);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560825, null);
      localBaseViewHolder = new BaseViewHolder(paramView);
      paramView.setTag(localBaseViewHolder);
      break;
      label168:
      localImageView.setImageDrawable(localDrawable);
      break label69;
      label178:
      if (paramInt == 0) {
        paramView.setBackgroundResource(2130839591);
      } else if (paramInt == getCount() - 1) {
        paramView.setBackgroundResource(2130839582);
      } else {
        paramView.setBackgroundResource(2130839585);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToGroupAdapter
 * JD-Core Version:    0.7.0.1
 */