package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.mobileqq.app.message.messageclean.FileCleanUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionClearFragment$SessionListAdapter
  extends RecyclerView.Adapter<SessionClearFragment.SessionHolder>
{
  List<CleanMessageItemInfo> jdField_a_of_type_JavaUtilList;
  Map<String, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  
  public SessionClearFragment$SessionListAdapter(List<CleanMessageItemInfo> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilMap.containsKey(paramString)) {
      return ((Integer)this.jdField_a_of_type_JavaUtilMap.get(paramString)).intValue();
    }
    return -1;
  }
  
  public SessionClearFragment.SessionHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreateViewHolder");
    }
    paramViewGroup = SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).getLayoutInflater().inflate(2131563011, paramViewGroup, false);
    return new SessionClearFragment.SessionHolder(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, paramViewGroup);
  }
  
  public CleanMessageItemInfo a(int paramInt)
  {
    return (CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a()
  {
    SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, 0);
    SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, 0);
    int i = 0;
    boolean bool = false;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Boolean)
      {
        SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, (int)(SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment) + ((CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Long));
        SessionClearFragment.d(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment);
        bool = true;
      }
      i += 1;
    }
    if (SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment) == 0)
    {
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).setVisibility(8);
      if (SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment) != this.jdField_a_of_type_JavaUtilList.size()) {
        break label222;
      }
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, 1);
    }
    for (;;)
    {
      SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).setEnabled(bool);
      return;
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).setVisibility(0);
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).setText(HardCodeUtil.a(2131713798) + FileCleanUtils.a(SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment)));
      break;
      label222:
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, 0);
    }
  }
  
  public void a(SessionClearFragment.SessionHolder paramSessionHolder, int paramInt)
  {
    CleanMessageItemInfo localCleanMessageItemInfo = a(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onBindViewHolder info uin=" + localCleanMessageItemInfo.jdField_a_of_type_JavaLangString + " pos=" + paramInt);
    }
    paramSessionHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localCleanMessageItemInfo.b);
    paramSessionHolder.b.setText(localCleanMessageItemInfo.c);
    if ((localCleanMessageItemInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localCleanMessageItemInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      paramSessionHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localCleanMessageItemInfo.jdField_a_of_type_AndroidGraphicsBitmap);
      if (!((CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Boolean) {
        break label351;
      }
      paramSessionHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    }
    for (;;)
    {
      paramSessionHolder.itemView.setOnClickListener(new SessionClearFragment.SessionListAdapter.1(this, paramSessionHolder, paramInt));
      EventCollector.getInstance().onRecyclerBindViewHolder(paramSessionHolder, paramInt, getItemId(paramInt));
      return;
      if (localCleanMessageItemInfo.d != null)
      {
        SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment, localCleanMessageItemInfo.d, 80, 80, paramSessionHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        break;
      }
      Bitmap localBitmap = SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment);
      this.jdField_a_of_type_JavaUtilMap.put(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, Integer.valueOf(paramInt));
      if ((localCleanMessageItemInfo.jdField_a_of_type_Int == 0) || (localCleanMessageItemInfo.jdField_a_of_type_Int == 1000) || (localCleanMessageItemInfo.jdField_a_of_type_Int == 1004)) {
        localBitmap = SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).a(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, true);
      }
      for (;;)
      {
        if (localBitmap == null) {
          break label349;
        }
        paramSessionHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localBitmap);
        break;
        if (localCleanMessageItemInfo.jdField_a_of_type_Int == 1) {
          localBitmap = SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).a(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, true);
        } else if (localCleanMessageItemInfo.jdField_a_of_type_Int == 3000) {
          localBitmap = SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).a(localCleanMessageItemInfo.jdField_a_of_type_JavaLangString, true);
        }
      }
      label349:
      break;
      label351:
      paramSessionHolder.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    }
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    int i = a(paramString1);
    if (i >= 0)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SessionClearFragment", 4, "updateImage  uin: " + paramString1 + " pos =" + i);
      }
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).a(i).d = paramString2;
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).a(i).jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      SessionClearFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment).notifyItemChanged(i);
    }
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "setList sessionList size=" + paramList.size());
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void b()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Boolean = true;
      i += 1;
    }
    notifyDataSetChanged();
    a();
    ReportController.b(null, "dc00898", "", "", "0X800A0C6", "0X800A0C6", 0, 0, String.valueOf(SessionClearFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment)), String.valueOf(SessionClearFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment)), "", "");
  }
  
  public void c()
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((CleanMessageItemInfo)this.jdField_a_of_type_JavaUtilList.get(i)).jdField_a_of_type_Boolean = false;
      i += 1;
    }
    notifyDataSetChanged();
    a();
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.SessionListAdapter
 * JD-Core Version:    0.7.0.1
 */