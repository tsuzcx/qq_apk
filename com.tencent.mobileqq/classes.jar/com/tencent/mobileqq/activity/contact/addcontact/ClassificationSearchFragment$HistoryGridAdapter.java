package com.tencent.mobileqq.activity.contact.addcontact;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.GetRecommendListListener;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.recent.RecentFaceDecoder;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import java.util.ArrayList;
import java.util.Iterator;

public class ClassificationSearchFragment$HistoryGridAdapter
  extends BaseAdapter
  implements IPublicAccountSearchRecommendManager.GetRecommendListListener, DecodeTaskCompletionListener
{
  private View.OnClickListener b = new ClassificationSearchFragment.HistoryGridAdapter.1(this);
  private boolean c = false;
  private String d;
  private ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> e;
  private RecentFaceDecoder f = new RecentFaceDecoder(paramClassificationSearchFragment.r, this, false);
  
  public ClassificationSearchFragment$HistoryGridAdapter(ClassificationSearchFragment paramClassificationSearchFragment)
  {
    a(true);
  }
  
  public void a()
  {
    RecentFaceDecoder localRecentFaceDecoder = this.f;
    if (localRecentFaceDecoder != null) {
      localRecentFaceDecoder.b();
    }
  }
  
  public void a(ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    this.e = paramArrayList;
    this.d = paramString;
    this.c = paramBoolean;
    if (ClassificationSearchFragment.b(this.a) != null) {
      if (getCount() == 0)
      {
        ((TextView)ClassificationSearchFragment.b(this.a).findViewById(2131445430)).setText(HardCodeUtil.a(2131900122));
        ClassificationSearchFragment.b(this.a).setVisibility(8);
      }
      else
      {
        if (TextUtils.isEmpty(paramString)) {
          ((TextView)ClassificationSearchFragment.b(this.a).findViewById(2131445430)).setText(HardCodeUtil.a(2131900127));
        } else {
          ((TextView)ClassificationSearchFragment.b(this.a).findViewById(2131445430)).setText(paramString);
        }
        ClassificationSearchFragment.b(this.a).setVisibility(0);
        notifyDataSetChanged();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetRecommendSuccess->isFromRecommend:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", title:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", list:");
      paramString = new StringBuilder(localStringBuilder.toString());
      if (paramArrayList == null)
      {
        paramString.append("null");
      }
      else
      {
        paramString.append("size:");
        paramString.append(paramArrayList.size());
      }
      QLog.d("ClassificationSearchFragment", 2, paramString.toString());
      if ((paramArrayList != null) && (paramArrayList.size() > 0))
      {
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          paramString = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)paramArrayList.next();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetRecommendSuccess->");
          localStringBuilder.append(paramString.toString());
          QLog.d("ClassificationSearchFragment", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    ((IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class)).getRecommendList(this.a.r, paramBoolean, this);
  }
  
  public String b()
  {
    return this.d;
  }
  
  public ArrayList<IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem> c()
  {
    return this.e;
  }
  
  public int getCount()
  {
    ArrayList localArrayList = this.e;
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.e;
    if ((localArrayList != null) && (paramInt < localArrayList.size())) {
      return this.e.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.a.getBaseActivity()).inflate(2131625655, null);
    }
    paramView = (IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)getItem(paramInt);
    if (paramView != null)
    {
      Object localObject = this.f;
      if (localObject != null)
      {
        localObject = ((RecentFaceDecoder)localObject).a(1008, paramView.a);
        ((URLImageView)localView.findViewById(2131434878)).setImageDrawable((Drawable)localObject);
      }
      ((TextView)localView.findViewById(2131439121)).setText(paramView.b);
      localView.findViewById(2131431280).setOnClickListener(this.b);
      localView.findViewById(2131431280).setTag(paramView);
      localView.setTag(paramView);
    }
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (ClassificationSearchFragment.b(this.a) != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      if ((paramBitmap == null) && (paramInt1 > 0)) {
        return;
      }
      if (paramBitmap != null)
      {
        GridView localGridView = (GridView)ClassificationSearchFragment.b(this.a).findViewById(2131445427);
        paramInt2 = localGridView.getChildCount();
        paramInt1 = 0;
        while (paramInt1 < paramInt2)
        {
          View localView = localGridView.getChildAt(paramInt1);
          if (paramString.equals(((IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem)localView.getTag()).a)) {
            ((URLImageView)localView.findViewById(2131434878)).setImageBitmap(paramBitmap);
          }
          paramInt1 += 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchFragment.HistoryGridAdapter
 * JD-Core Version:    0.7.0.1
 */