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
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class ShareToGroupAdapter
  extends BaseAdapter
{
  protected Context a;
  protected ShareToGroupAdapter.OnSelectStateChangeListener a;
  protected QQAppInterface a;
  protected ArrayList a;
  
  public ShareToGroupAdapter(Context paramContext, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = PlayModeUtils.a();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = ShareToGroupAdapter.TroopInfoSelector.a(paramArrayList1, paramArrayList2);
  }
  
  public ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ShareToGroupAdapter.TroopInfoSelector localTroopInfoSelector = (ShareToGroupAdapter.TroopInfoSelector)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localTroopInfoSelector.jdField_a_of_type_Boolean) && (!localArrayList.contains(localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin))) {
          localArrayList.add(localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin);
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
    TroopInfo localTroopInfo = localTroopInfoSelector.jdField_a_of_type_ComTencentMobileqqDataTroopInfo;
    Object localObject;
    Drawable localDrawable;
    if (paramView != null)
    {
      localObject = (BaseViewHolder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
      localObject = (ImageView)paramView.a(2131368512);
      localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(localTroopInfo.troopuin);
      if (localDrawable != null) {
        break label154;
      }
      ((ImageView)localObject).setImageBitmap(ImageUtil.f());
    }
    for (;;)
    {
      ((TextView)paramView.a(2131368513)).setText(localTroopInfo.getTroopName());
      ((CheckBox)paramView.a(2131368510)).setChecked(localTroopInfoSelector.jdField_a_of_type_Boolean);
      if (getCount() > 1) {
        break label164;
      }
      paramViewGroup.setBackgroundResource(2130838619);
      return paramViewGroup;
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969940, null);
      paramView = new BaseViewHolder(paramViewGroup);
      paramViewGroup.setTag(paramView);
      break;
      label154:
      ((ImageView)localObject).setImageDrawable(localDrawable);
    }
    label164:
    if (paramInt == 0)
    {
      paramViewGroup.setBackgroundResource(2130838631);
      return paramViewGroup;
    }
    if (paramInt == getCount() - 1)
    {
      paramViewGroup.setBackgroundResource(2130838626);
      return paramViewGroup;
    }
    paramViewGroup.setBackgroundResource(2130838629);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.shareto.ShareToGroupAdapter
 * JD-Core Version:    0.7.0.1
 */