package com.tencent.mobileqq.apollo.aio;

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
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

class ApolloResponseManager$ResponseAdapter
  extends BaseAdapter
{
  List<Integer> a = new ArrayList();
  Context b;
  int c;
  
  public ApolloResponseManager$ResponseAdapter(ApolloResponseManager paramApolloResponseManager, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void a(List<Integer> paramList, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("new actions:");
      ((StringBuilder)localObject1).append(paramList.toString());
      QLog.i("[cmshow]ApolloResponseManager", 2, ((StringBuilder)localObject1).toString());
    }
    this.c = paramInt;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      this.a.clear();
      Object localObject2 = (ApolloDaoManagerServiceImpl)ApolloResponseManager.a(this.d).getRuntimeService(IApolloDaoManagerService.class, "all");
      Object localObject3 = (ApolloManagerServiceImpl)ApolloResponseManager.a(this.d).getRuntimeService(IApolloManagerService.class, "all");
      ArrayList localArrayList = new ArrayList();
      localObject1 = new ArrayList();
      int i = paramList.size();
      paramInt = 0;
      while (paramInt < i)
      {
        j = ((Integer)paramList.get(paramInt)).intValue();
        localObject4 = ((ApolloDaoManagerServiceImpl)localObject2).findActionById(j);
        if (localObject4 != null)
        {
          StringBuilder localStringBuilder;
          if ((((ApolloActionData)localObject4).feeType == 9) && ((((ApolloManagerServiceImpl)localObject3).mUserActionId == null) || (!((ApolloManagerServiceImpl)localObject3).mUserActionId.containsKey(Integer.valueOf(((ApolloActionData)localObject4).actionId)))))
          {
            if (!((ApolloManagerServiceImpl)ApolloResponseManager.a(this.d).getRuntimeService(IApolloManagerService.class, "all")).isSuperYellow(ApolloResponseManager.a(this.d).getCurrentUin()))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("remove vip data:");
              localStringBuilder.append(((ApolloActionData)localObject4).actionName);
              localStringBuilder.append(",id:");
              localStringBuilder.append(j);
              QLog.e("[cmshow]ApolloResponseManager", 1, localStringBuilder.toString());
              break label432;
            }
          }
          else if ((((ApolloActionData)localObject4).feeType != 1) && ((((ApolloActionData)localObject4).isShow == 0) || (((ApolloManagerServiceImpl)localObject3).mUserActionId == null) || (!((ApolloManagerServiceImpl)localObject3).mUserActionId.containsKey(Integer.valueOf(((ApolloActionData)localObject4).actionId)))))
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("remove ");
            localStringBuilder.append(((ApolloActionData)localObject4).feeType);
            localStringBuilder.append(" data:");
            localStringBuilder.append(((ApolloActionData)localObject4).actionName);
            localStringBuilder.append(",id:");
            localStringBuilder.append(j);
            QLog.e("[cmshow]ApolloResponseManager", 1, localStringBuilder.toString());
            break label432;
          }
          ((List)localObject1).add(localObject4);
        }
        label432:
        paramInt += 1;
      }
      if (((List)localObject1).size() < 2)
      {
        paramList = new StringBuilder();
        paramList.append("invalid data size:");
        paramList.append(((List)localObject1).size());
        QLog.e("[cmshow]ApolloResponseManager", 1, paramList.toString());
        return;
      }
      Collections.sort((List)localObject1, this.d.b);
      localObject2 = new Random();
      i = ((List)localObject1).size() - 1;
      paramInt = 0;
      while (paramInt < 2)
      {
        if (i <= 1)
        {
          this.a.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
          localArrayList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).feeType));
        }
        else if (((List)localObject1).get(paramInt) != null)
        {
          j = ((ApolloActionData)((List)localObject1).get(paramInt)).feeType;
          if (j == 1)
          {
            int k;
            do
            {
              j = ((Random)localObject2).nextInt(i - paramInt + 1) + paramInt;
              k = ((ApolloActionData)((List)localObject1).get(j)).actionId;
            } while (this.a.contains(Integer.valueOf(k)));
            this.a.add(Integer.valueOf(k));
            localArrayList.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(j)).feeType));
          }
          else
          {
            this.a.add(Integer.valueOf(((ApolloActionData)((List)localObject1).get(paramInt)).actionId));
            localArrayList.add(Integer.valueOf(j));
          }
        }
        paramInt += 1;
      }
      notifyDataSetChanged();
      Object localObject4 = String.valueOf(ApolloResponseManager.b(this.d));
      paramInt = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(ApolloResponseManager.c(this.d));
      i = this.c;
      int j = paramList.size();
      localObject3 = "0";
      if (j > 0) {
        localObject1 = String.valueOf(paramList.get(0));
      } else {
        localObject1 = "0";
      }
      if (localArrayList.size() > 0) {
        localObject2 = String.valueOf(localArrayList.get(0));
      } else {
        localObject2 = "0";
      }
      if (paramList.size() > 1) {
        paramList = String.valueOf(paramList.get(1));
      } else {
        paramList = "0";
      }
      if (localArrayList.size() > 1) {
        localObject3 = String.valueOf(localArrayList.get(1));
      }
      VipUtils.a(null, "cmshow", "Apollo", "quickresponsepv", (String)localObject4, paramInt, i, new String[] { localObject1, localObject2, paramList, localObject3 });
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject3 = this.b.getResources();
    int i = ((Integer)getItem(paramInt)).intValue();
    Object localObject4;
    if (paramView == null)
    {
      paramView = new ApolloResponseManager.Holder(this.d);
      paramViewGroup = new LinearLayout(this.b);
      localObject1 = (LinearLayout)paramViewGroup;
      ((LinearLayout)localObject1).setOrientation(1);
      localObject4 = new LinearLayout(this.b);
      ((LinearLayout)localObject4).setBackgroundResource(2130838621);
      ((LinearLayout)localObject4).setOrientation(0);
      Object localObject5 = new URLImageView(this.b);
      int j = ViewUtils.dip2px(28.0F);
      Object localObject6 = new LinearLayout.LayoutParams(j, j);
      ((LinearLayout.LayoutParams)localObject6).leftMargin = ViewUtils.dip2px(2.2F);
      ((LinearLayout.LayoutParams)localObject6).gravity = 16;
      ((LinearLayout)localObject4).addView((View)localObject5, (ViewGroup.LayoutParams)localObject6);
      localObject6 = new TextView(this.b);
      ((TextView)localObject6).setTextSize(11.0F);
      ((TextView)localObject6).setMaxLines(1);
      ((TextView)localObject6).setIncludeFontPadding(false);
      ((TextView)localObject6).setGravity(1);
      ((TextView)localObject6).setTextColor(((Resources)localObject3).getColor(2131165830));
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      localLayoutParams.gravity = 16;
      ((LinearLayout)localObject4).addView((View)localObject6, localLayoutParams);
      paramView.a = ((URLImageView)localObject5);
      paramView.b = ((TextView)localObject6);
      localObject5 = new View(this.b);
      paramView.c = ((View)localObject5);
      ((LinearLayout)localObject1).addView((View)localObject4);
      ((LinearLayout)localObject1).addView((View)localObject5);
      paramViewGroup.setTag(paramView);
    }
    else
    {
      localObject1 = (ApolloResponseManager.Holder)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject1;
    }
    paramViewGroup.setTag(2131428473, Integer.valueOf(i));
    paramViewGroup.setTag(2131428474, Integer.valueOf(this.c));
    Object localObject1 = paramView.c;
    float f;
    if (paramInt == this.a.size() - 1) {
      f = 8.0F;
    } else {
      f = 5.0F;
    }
    ((View)localObject1).setMinimumHeight(ViewUtils.dip2px(f));
    try
    {
      localObject1 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject1).mPlayGifImage = true;
      ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Resources)localObject3).getDrawable(2130838557);
      ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Resources)localObject3).getDrawable(2130838559);
      localObject3 = new URL("apollo_gif", "", String.valueOf(i));
      localObject4 = new File(ApolloGifDownloaderImpl.getApolloGifFilePath(i));
      paramView.a.setTag(Integer.valueOf(i));
      if (((File)localObject4).exists())
      {
        localObject1 = URLDrawable.getDrawable((File)localObject4, (URLDrawable.URLDrawableOptions)localObject1);
        paramView.a.setImageDrawable((Drawable)localObject1);
      }
      else
      {
        localObject1 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject1);
        ((URLDrawable)localObject1).setTag(Integer.valueOf(i));
        paramView.a.setImageDrawable((Drawable)localObject1);
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    Object localObject2 = ((ApolloDaoManagerServiceImpl)ApolloResponseManager.a(this.d).getRuntimeService(IApolloDaoManagerService.class, "all")).findActionById(i);
    if (localObject2 != null)
    {
      localObject2 = ((ApolloActionData)localObject2).actionName;
      paramView.b.setText((CharSequence)localObject2);
    }
    paramViewGroup.setOnClickListener(this.d.a);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager.ResponseAdapter
 * JD-Core Version:    0.7.0.1
 */