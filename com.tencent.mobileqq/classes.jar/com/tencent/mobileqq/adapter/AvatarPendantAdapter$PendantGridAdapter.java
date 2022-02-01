package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.mobileqq.vas.AvatarPendantShopItemInfo;
import com.tencent.mobileqq.vas.AvatarPendantShopSeriesInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class AvatarPendantAdapter$PendantGridAdapter
  extends BaseAdapter
{
  List<AvatarPendantShopItemInfo> a;
  String b;
  int c;
  int d;
  String e;
  
  public AvatarPendantAdapter$PendantGridAdapter(AvatarPendantAdapter paramAvatarPendantAdapter) {}
  
  public void a(AvatarPendantShopSeriesInfo paramAvatarPendantShopSeriesInfo)
  {
    if (this.a == null) {
      this.a = new ArrayList();
    }
    this.a.clear();
    if (paramAvatarPendantShopSeriesInfo.h == null) {
      return;
    }
    this.b = paramAvatarPendantShopSeriesInfo.f;
    this.c = paramAvatarPendantShopSeriesInfo.j;
    this.d = paramAvatarPendantShopSeriesInfo.e;
    this.e = paramAvatarPendantShopSeriesInfo.d;
    if (this.e == null) {
      this.e = "";
    }
    if ((paramAvatarPendantShopSeriesInfo.g != null) && (paramAvatarPendantShopSeriesInfo.g.equals("actLiTpl"))) {
      this.d = 3;
    }
    if ((!paramAvatarPendantShopSeriesInfo.i) && (paramAvatarPendantShopSeriesInfo.h.size() > 4) && ((paramAvatarPendantShopSeriesInfo.g == null) || (paramAvatarPendantShopSeriesInfo.g.equals("")))) {
      this.a.addAll(paramAvatarPendantShopSeriesInfo.h.subList(0, 4));
    } else {
      this.a.addAll(paramAvatarPendantShopSeriesInfo.h);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if (localList != null) {
      return localList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2;
    label1290:
    Object localObject4;
    if (this.a == null)
    {
      localObject2 = paramView;
    }
    else
    {
      AvatarPendantAdapter.PendantGridAdapter.GridItemHolder localGridItemHolder;
      Object localObject1;
      if (paramView == null)
      {
        localGridItemHolder = new AvatarPendantAdapter.PendantGridAdapter.GridItemHolder(this);
        localObject1 = LayoutInflater.from(this.f.a).inflate(2131628290, paramViewGroup, false);
        localGridItemHolder.g = ((RelativeLayout)((View)localObject1).findViewById(2131439940));
        localGridItemHolder.a = ((ImageView)((View)localObject1).findViewById(2131439939));
        localGridItemHolder.b = ((ImageView)((View)localObject1).findViewById(2131439950));
        localGridItemHolder.c = ((ImageView)((View)localObject1).findViewById(2131439952));
        localGridItemHolder.f = ((TextView)((View)localObject1).findViewById(2131439948));
        localGridItemHolder.d = ((ImageView)((View)localObject1).findViewById(2131439941));
        localGridItemHolder.e = ((ImageView)((View)localObject1).findViewById(2131439951));
        paramView = localGridItemHolder.g.getLayoutParams();
        if (paramView != null)
        {
          paramView.width = this.f.p;
          paramView.height = this.f.q;
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("AvatarPendantAdapter", 2, "getLayoutParams null, it's sad");
          }
          paramView = new ViewGroup.LayoutParams(this.f.p, this.f.q);
        }
        localGridItemHolder.g.setLayoutParams(paramView);
        ((View)localObject1).setTag(localGridItemHolder);
        paramView = (View)localObject1;
      }
      else
      {
        localGridItemHolder = (AvatarPendantAdapter.PendantGridAdapter.GridItemHolder)paramView.getTag();
      }
      AvatarPendantShopItemInfo localAvatarPendantShopItemInfo = (AvatarPendantShopItemInfo)getItem(paramInt);
      if (localAvatarPendantShopItemInfo != null)
      {
        localGridItemHolder.a.setTag(localAvatarPendantShopItemInfo);
        localGridItemHolder.f.setText(localAvatarPendantShopItemInfo.c);
        paramView.setContentDescription(localAvatarPendantShopItemInfo.c);
        int i = localAvatarPendantShopItemInfo.k;
        if (i != 7)
        {
          if (i != 8)
          {
            localGridItemHolder.d.setVisibility(8);
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(AvatarPendantUtil.e);
            ((StringBuilder)localObject1).append("/hot.png");
            localFile = new File(((StringBuilder)localObject1).toString());
            if ((localFile.exists()) && (!this.e.equals("3")))
            {
              localGridItemHolder.d.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.i.get("key_hot.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.v;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.v;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.i.put("key_hot.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.d.setImageDrawable((Drawable)localObject1);
            }
            else
            {
              localGridItemHolder.d.setVisibility(8);
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AvatarPendantUtil.e);
          ((StringBuilder)localObject1).append("/new.png");
          localFile = new File(((StringBuilder)localObject1).toString());
          if ((localFile.exists()) && (!this.e.equals("1")))
          {
            localGridItemHolder.d.setVisibility(0);
            localObject2 = (URLDrawable)AvatarPendantAdapter.i.get("key_new.png");
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.v;
              ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.v;
              localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
              localObject1 = localObject2;
              if (((URLDrawable)localObject2).getStatus() == 1)
              {
                AvatarPendantAdapter.i.put("key_new.png", localObject2);
                localObject1 = localObject2;
              }
            }
            localGridItemHolder.d.setImageDrawable((Drawable)localObject1);
          }
          else
          {
            localGridItemHolder.d.setVisibility(8);
          }
        }
        i = localAvatarPendantShopItemInfo.l;
        if (i != 6)
        {
          if (i != 9)
          {
            if (i != 10)
            {
              localGridItemHolder.e.setVisibility(8);
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(AvatarPendantUtil.e);
              ((StringBuilder)localObject1).append("/limit.png");
              localFile = new File(((StringBuilder)localObject1).toString());
              if (localFile.exists())
              {
                localGridItemHolder.e.setVisibility(0);
                localObject2 = (URLDrawable)AvatarPendantAdapter.i.get("key_limit.png");
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = URLDrawable.URLDrawableOptions.obtain();
                  ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.v;
                  ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.v;
                  localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                  localObject1 = localObject2;
                  if (((URLDrawable)localObject2).getStatus() == 1)
                  {
                    AvatarPendantAdapter.i.put("key_limit.png", localObject2);
                    localObject1 = localObject2;
                  }
                }
                localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
              }
              else
              {
                localGridItemHolder.e.setVisibility(8);
              }
            }
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(AvatarPendantUtil.e);
            ((StringBuilder)localObject1).append("/rare.png");
            localFile = new File(((StringBuilder)localObject1).toString());
            if ((localFile.exists()) && (this.d != 5))
            {
              localGridItemHolder.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.i.get("key_rare.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.v;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.v;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.i.put("key_rare.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
            }
            else
            {
              localGridItemHolder.e.setVisibility(8);
            }
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(AvatarPendantUtil.e);
          ((StringBuilder)localObject1).append("/activity.png");
          localFile = new File(((StringBuilder)localObject1).toString());
          if (localFile.exists())
          {
            i = this.d;
            if ((i != 3) && (i != 5))
            {
              localGridItemHolder.e.setVisibility(0);
              localObject2 = (URLDrawable)AvatarPendantAdapter.i.get("key_activity.png");
              localObject1 = localObject2;
              if (localObject2 == null)
              {
                localObject1 = URLDrawable.URLDrawableOptions.obtain();
                ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.v;
                ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.v;
                localObject2 = URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject1);
                localObject1 = localObject2;
                if (((URLDrawable)localObject2).getStatus() == 1)
                {
                  AvatarPendantAdapter.i.put("key_activity.png", localObject2);
                  localObject1 = localObject2;
                }
              }
              localGridItemHolder.e.setImageDrawable((Drawable)localObject1);
              break label1290;
            }
          }
          localGridItemHolder.e.setVisibility(8);
        }
        localObject2 = localAvatarPendantShopItemInfo.e;
        localObject1 = localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          localObject1 = this.b;
        }
        File localFile = null;
        if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
        {
          localObject2 = (URLDrawable)AvatarPendantAdapter.i.get(localObject1);
          if (localObject2 != null)
          {
            localGridItemHolder.a.setImageDrawable((Drawable)localObject2);
            if ((((URLDrawable)localObject2).getStatus() != 1) && (((URLDrawable)localObject2).getStatus() != 0)) {
              ((URLDrawable)localObject2).restartDownload();
            }
          }
          else
          {
            Object localObject3;
            try
            {
              localObject2 = new URL("protocol_pendant_image", "DEFAULT_HEAD", (String)localObject1);
            }
            catch (MalformedURLException localMalformedURLException1)
            {
              if (QLog.isColorLevel()) {
                QLog.d("AvatarPendantAdapter", 2, localMalformedURLException1.getMessage());
              }
              localObject3 = null;
            }
            if (localObject3 != null)
            {
              URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
              localURLDrawableOptions.mRequestWidth = this.f.t;
              localURLDrawableOptions.mRequestHeight = this.f.u;
              localURLDrawableOptions.mFailedDrawable = this.f.v;
              localURLDrawableOptions.mUseMemoryCache = true;
              localURLDrawableOptions.mLoadingDrawable = this.f.v;
              localObject3 = URLDrawable.getDrawable((URL)localObject3, localURLDrawableOptions);
              localGridItemHolder.a.setImageDrawable((Drawable)localObject3);
              if (((URLDrawable)localObject3).getStatus() == 2) {
                ((URLDrawable)localObject3).restartDownload();
              } else if (((URLDrawable)localObject3).getStatus() == 1) {
                AvatarPendantAdapter.i.put(localObject1, localObject3);
              }
            }
          }
        }
        localGridItemHolder.g.setTag(localAvatarPendantShopItemInfo);
        if (this.c == paramInt) {
          paramView.setBackgroundDrawable(this.f.a.getResources().getDrawable(2130849295));
        } else {
          paramView.setBackgroundDrawable(null);
        }
        if (localAvatarPendantShopItemInfo.a != 0)
        {
          if (localAvatarPendantShopItemInfo.a == this.f.g) {
            localGridItemHolder.c.setVisibility(0);
          } else {
            localGridItemHolder.c.setVisibility(8);
          }
          if (!this.f.B)
          {
            try
            {
              localObject1 = new URL("protocol_pendant_image", "AIO_STATIC", String.valueOf(localAvatarPendantShopItemInfo.a));
            }
            catch (MalformedURLException localMalformedURLException2)
            {
              localObject1 = localFile;
              if (QLog.isColorLevel())
              {
                QLog.d("AvatarPendantAdapter", 2, localMalformedURLException2.getMessage());
                localObject1 = localFile;
              }
            }
            localObject4 = paramView;
            if (localObject1 != null)
            {
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = this.f.t;
              ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = this.f.u;
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = this.f.v;
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = this.f.v;
              localObject1 = URLDrawable.getDrawable((URL)localObject1, (URLDrawable.URLDrawableOptions)localObject4);
              localGridItemHolder.b.setImageDrawable((Drawable)localObject1);
              localObject4 = paramView;
              if (((URLDrawable)localObject1).getStatus() == 2)
              {
                ((URLDrawable)localObject1).restartDownload();
                localObject4 = paramView;
              }
            }
          }
          else
          {
            localGridItemHolder.b.setImageDrawable(null);
            localObject4 = paramView;
          }
        }
        else
        {
          localGridItemHolder.b.setImageDrawable(null);
          localObject4 = paramView;
        }
      }
      else
      {
        localObject4 = paramView;
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject4, paramViewGroup, getItemId(paramInt));
    return localObject4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.PendantGridAdapter
 * JD-Core Version:    0.7.0.1
 */