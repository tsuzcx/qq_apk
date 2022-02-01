package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

public class TroopDisbandActivity$MemberGridAdapter
  extends BaseAdapter
{
  protected int a;
  protected List<String> a;
  
  public TroopDisbandActivity$MemberGridAdapter(TroopDisbandActivity paramTroopDisbandActivity)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_JavaUtilList.add("0");
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilList.size() == 1) && (this.jdField_a_of_type_JavaUtilList.contains(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.d))) {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.d);
    notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(List<String> paramList)
  {
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_JavaUtilList.contains(paramString);
  }
  
  public void b(List<oidb_0x899.memberlist> paramList)
  {
    int j = 0;
    int i;
    if (paramList != null) {
      i = paramList.size();
    } else {
      i = 0;
    }
    if (i > 0)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      while (j < i)
      {
        Object localObject = (oidb_0x899.memberlist)paramList.get(j);
        if ((localObject != null) && (((oidb_0x899.memberlist)localObject).uint64_member_uin.has()))
        {
          localObject = String.valueOf(((oidb_0x899.memberlist)localObject).uint64_member_uin.get());
          if (!this.jdField_a_of_type_JavaUtilList.contains(localObject)) {
            this.jdField_a_of_type_JavaUtilList.add(localObject);
          }
        }
        j += 1;
      }
      notifyDataSetChanged();
    }
  }
  
  public int getCount()
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = j;
    if (j > 6) {
      i = 6;
    }
    return i;
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    int i;
    if (paramView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity);
      i = this.jdField_a_of_type_Int;
      localImageView.setLayoutParams(new AbsListView.LayoutParams(i, i));
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localImageView.setAdjustViewBounds(true);
      paramView = localImageView;
    }
    else
    {
      localImageView = (ImageView)paramView;
      localObject = localImageView.getLayoutParams();
      if (localObject != null)
      {
        i = this.jdField_a_of_type_Int;
        ((ViewGroup.LayoutParams)localObject).width = i;
        ((ViewGroup.LayoutParams)localObject).height = i;
      }
    }
    Object localObject = (String)getItem(paramInt);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!((String)localObject).equals("0"))) {
      localImageView.setImageDrawable(FaceDrawable.getUserFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityTroopDisbandActivity.app, (String)localObject, (byte)3));
    } else {
      localImageView.setImageDrawable(ImageUtil.e());
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopDisbandActivity.MemberGridAdapter
 * JD-Core Version:    0.7.0.1
 */