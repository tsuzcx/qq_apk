package com.tencent.mobileqq.apollo.api.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.data.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class ApolloResponseManagerImpl$ResponseAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  List<Integer> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public ApolloResponseManagerImpl$ResponseAdapter(ApolloResponseManagerImpl paramApolloResponseManagerImpl, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ApolloResponseManager", 2, "new actions:" + paramList.toString());
    }
    this.jdField_a_of_type_Int = paramInt;
    Object localObject1;
    int j;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      localObject2 = (ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mApp.getRuntimeService(IApolloDaoManagerService.class, "all");
      localObject4 = (ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mApp.getRuntimeService(IApolloManagerService.class, "all");
      localObject3 = new ArrayList();
      localObject1 = new ArrayList();
      i = paramList.size();
      paramInt = 0;
      if (paramInt < i)
      {
        j = ((Integer)paramList.get(paramInt)).intValue();
        ApolloActionData localApolloActionData = ((ApolloDaoManagerServiceImpl)localObject2).findActionById(j);
        if (localApolloActionData == null) {}
        for (;;)
        {
          paramInt += 1;
          break;
          if ((localApolloActionData.feeType == 9) && ((((ApolloManagerServiceImpl)localObject4).mUserActionId == null) || (!((ApolloManagerServiceImpl)localObject4).mUserActionId.containsKey(Integer.valueOf(localApolloActionData.actionId)))))
          {
            if (!((ApolloManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mApp.getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mApp.getCurrentUin())) {
              QLog.e("ApolloResponseManager", 1, "remove vip data:" + localApolloActionData.actionName + ",id:" + j);
            }
          }
          else if ((localApolloActionData.feeType != 1) && ((localApolloActionData.isShow == 0) || (((ApolloManagerServiceImpl)localObject4).mUserActionId == null) || (!((ApolloManagerServiceImpl)localObject4).mUserActionId.containsKey(Integer.valueOf(localApolloActionData.actionId)))))
          {
            QLog.e("ApolloResponseManager", 1, "remove " + localApolloActionData.feeType + " data:" + localApolloActionData.actionName + ",id:" + j);
            continue;
          }
          ((List)localObject1).add(localApolloActionData);
        }
      }
      if (((List)localObject1).size() < 2) {
        QLog.e("ApolloResponseManager", 1, "invalid data size:" + ((List)localObject1).size());
      }
    }
    else
    {
      return;
    }
    Collections.sort((List)localObject1, this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mComparator);
    Object localObject2 = new Random();
    int i = ((List)localObject1).size() - 1;
    paramInt = 0;
    if (paramInt < 2)
    {
      if (i <= 1)
      {
        this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
        ((List)localObject3).add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).feeType));
      }
      for (;;)
      {
        paramInt += 1;
        break;
        if (((List)localObject1).get(paramInt) != null)
        {
          j = ((ApolloActionData)((List)localObject1).get(paramInt)).feeType;
          if (j == 1)
          {
            int k;
            do
            {
              j = ((Random)localObject2).nextInt(i - paramInt + 1) + paramInt;
              k = ((ApolloActionData)((List)localObject1).get(j)).actionId;
            } while (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(k)));
            this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(k));
            ((List)localObject3).add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(j)).feeType));
          }
          else
          {
            this.jdField_a_of_type_JavaUtilList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
            ((List)localObject3).add(Integer.valueOf(j));
          }
        }
      }
    }
    notifyDataSetChanged();
    Object localObject4 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mSenderUin);
    paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mSessionType);
    i = this.jdField_a_of_type_Int;
    if (paramList.size() > 0)
    {
      localObject1 = String.valueOf(paramList.get(0));
      if (((List)localObject3).size() <= 0) {
        break label880;
      }
      localObject2 = String.valueOf(((List)localObject3).get(0));
      label790:
      if (paramList.size() <= 1) {
        break label887;
      }
      paramList = String.valueOf(paramList.get(1));
      label811:
      if (((List)localObject3).size() <= 1) {
        break label893;
      }
    }
    label880:
    label887:
    label893:
    for (Object localObject3 = String.valueOf(((List)localObject3).get(1));; localObject3 = "0")
    {
      VipUtils.a(null, "cmshow", "Apollo", "quickresponsepv", (String)localObject4, paramInt, i, new String[] { localObject1, localObject2, paramList, localObject3 });
      return;
      localObject1 = "0";
      break;
      localObject2 = "0";
      break label790;
      paramList = "0";
      break label811;
    }
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
    Object localObject3 = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = ((Integer)getItem(paramInt)).intValue();
    Object localObject1;
    Object localObject2;
    Object localObject4;
    if (paramView == null)
    {
      paramView = new ApolloResponseManagerImpl.Holder(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl);
      localObject1 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject1).setOrientation(1);
      localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      ((LinearLayout)localObject2).setBackgroundResource(2130838717);
      ((LinearLayout)localObject2).setOrientation(0);
      localObject4 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
      int j = AIOUtils.a(28.0F, (Resources)localObject3);
      Object localObject5 = new LinearLayout.LayoutParams(j, j);
      ((LinearLayout.LayoutParams)localObject5).leftMargin = AIOUtils.a(2.2F, (Resources)localObject3);
      ((LinearLayout.LayoutParams)localObject5).gravity = 16;
      ((LinearLayout)localObject2).addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      ((TextView)localObject5).setTextSize(11.0F);
      ((TextView)localObject5).setMaxLines(1);
      ((TextView)localObject5).setIncludeFontPadding(false);
      ((TextView)localObject5).setGravity(1);
      ((TextView)localObject5).setTextColor(((Resources)localObject3).getColor(2131167040));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject2).addView((View)localObject5, localLayoutParams);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localObject4);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localObject5);
      localObject4 = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.jdField_a_of_type_AndroidViewView = ((View)localObject4);
      ((LinearLayout)localObject1).addView((View)localObject2);
      ((LinearLayout)localObject1).addView((View)localObject4);
      ((View)localObject1).setTag(paramView);
    }
    for (;;)
    {
      ((View)localObject1).setTag(2131362843, Integer.valueOf(i));
      ((View)localObject1).setTag(2131362844, Integer.valueOf(this.jdField_a_of_type_Int));
      localObject2 = paramView.jdField_a_of_type_AndroidViewView;
      float f;
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        f = 8.0F;
        label342:
        ((View)localObject2).setMinimumHeight(AIOUtils.a(f, (Resources)localObject3));
      }
      try
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = true;
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Resources)localObject3).getDrawable(2130838654);
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Resources)localObject3).getDrawable(2130838656);
        localObject3 = new URL("apollo_gif", "", String.valueOf(i));
        localObject4 = new File(ApolloGifDownloaderImpl.getApolloGifFilePath(i));
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setTag(Integer.valueOf(i));
        if (((File)localObject4).exists())
        {
          localObject2 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject2);
          paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        }
        for (;;)
        {
          label463:
          localObject2 = ((ApolloDaoManagerServiceImpl)this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mApp.getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
          if (localObject2 != null)
          {
            localObject2 = ((ApolloActionData)localObject2).actionName;
            paramView.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
          }
          ((View)localObject1).setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqApolloApiImplApolloResponseManagerImpl.mOnResponseClickLis);
          EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
          return localObject1;
          localObject2 = (ApolloResponseManagerImpl.Holder)paramView.getTag();
          localObject1 = paramView;
          paramView = (View)localObject2;
          break;
          f = 5.0F;
          break label342;
          localObject2 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject2);
          ((URLDrawable)localObject2).setTag(Integer.valueOf(i));
          paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        }
      }
      catch (Throwable localThrowable)
      {
        break label463;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloResponseManagerImpl.ResponseAdapter
 * JD-Core Version:    0.7.0.1
 */