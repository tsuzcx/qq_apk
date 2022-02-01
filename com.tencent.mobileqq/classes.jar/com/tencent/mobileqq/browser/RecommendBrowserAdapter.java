package com.tencent.mobileqq.browser;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class RecommendBrowserAdapter
  extends BaseAdapter
{
  private ArrayList<BrowserItem> a = new ArrayList();
  private Context b;
  private int c;
  private Map<String, Drawable> d = new LRULinkedHashMap(20);
  
  public RecommendBrowserAdapter(Context paramContext)
  {
    this.b = paramContext;
    this.c = c();
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    paramString = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
    paramString = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(paramContext, paramString.publicSourceDir);
    if (paramString != null) {
      return paramString;
    }
    return paramContext.getResources().getDrawable(2130845642);
  }
  
  @NotNull
  private RecommendBrowserAdapter.EntryHolder a(View paramView)
  {
    RecommendBrowserAdapter.EntryHolder localEntryHolder = new RecommendBrowserAdapter.EntryHolder(null);
    localEntryHolder.a = ((TextView)paramView.findViewById(2131436136));
    localEntryHolder.b = ((TextView)paramView.findViewById(2131446539));
    localEntryHolder.c = ((URLImageView)paramView.findViewById(2131436047));
    localEntryHolder.d = ((ImageView)paramView.findViewById(2131435965));
    localEntryHolder.e = ((LinearLayout)paramView.findViewById(2131447109));
    return localEntryHolder;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView.setOnClickListener(new RecommendBrowserAdapter.1(this, paramInt));
  }
  
  private void a(int paramInt, RecommendBrowserAdapter.EntryHolder paramEntryHolder)
  {
    long l = System.currentTimeMillis();
    BrowserItem localBrowserItem = (BrowserItem)this.a.get(paramInt);
    b(paramInt, paramEntryHolder);
    b(paramEntryHolder, localBrowserItem);
    a(paramEntryHolder, localBrowserItem);
    a("bindIconView", l);
  }
  
  private void a(RecommendBrowserAdapter.EntryHolder paramEntryHolder, BrowserItem paramBrowserItem)
  {
    Object localObject;
    if (!paramBrowserItem.f())
    {
      if (!TextUtils.isEmpty(paramBrowserItem.c()))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        paramBrowserItem = URLDrawable.getDrawable(paramBrowserItem.c(), (URLDrawable.URLDrawableOptions)localObject);
        paramEntryHolder.c.setImageDrawable(paramBrowserItem);
        return;
      }
      paramEntryHolder.c.setImageDrawable(new ColorDrawable(0));
      return;
    }
    try
    {
      localObject = paramBrowserItem.e();
      if (this.d.containsKey(localObject))
      {
        paramBrowserItem = (Drawable)this.d.get(localObject);
      }
      else
      {
        paramBrowserItem = a(this.b, (String)localObject);
        this.d.put(localObject, paramBrowserItem);
      }
      paramEntryHolder.c.setImageDrawable(paramBrowserItem);
      return;
    }
    catch (Exception paramEntryHolder)
    {
      QLog.e("[BrowserOpt] RecommendBrowserAdapter", 1, "bindIconView: failed. ", paramEntryHolder);
    }
  }
  
  private static void a(String paramString, long paramLong)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(" [cost] countTime: invoked. ");
      QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, new Object[] { localStringBuilder.toString(), " ms: ", Long.valueOf(l - paramLong) });
    }
  }
  
  private void b(int paramInt, RecommendBrowserAdapter.EntryHolder paramEntryHolder)
  {
    if (paramInt == this.c)
    {
      paramEntryHolder.d.setVisibility(0);
      return;
    }
    paramEntryHolder.d.setVisibility(8);
  }
  
  private void b(RecommendBrowserAdapter.EntryHolder paramEntryHolder, BrowserItem paramBrowserItem)
  {
    paramEntryHolder.a.setText(paramBrowserItem.a());
    paramEntryHolder.b.setText(paramBrowserItem.b());
    if (paramBrowserItem.f())
    {
      paramEntryHolder.b.setVisibility(8);
      paramEntryHolder.e.setGravity(16);
      paramBrowserItem = (LinearLayout.LayoutParams)paramEntryHolder.a.getLayoutParams();
      paramBrowserItem.setMargins(paramBrowserItem.leftMargin, 0, paramBrowserItem.rightMargin, paramBrowserItem.bottomMargin);
      paramEntryHolder.a.setLayoutParams(paramBrowserItem);
      return;
    }
    paramEntryHolder.b.setVisibility(0);
    paramEntryHolder.e.setGravity(0);
    paramBrowserItem = (LinearLayout.LayoutParams)paramEntryHolder.a.getLayoutParams();
    float f = this.b.getResources().getDimension(2131299050);
    paramBrowserItem.setMargins(paramBrowserItem.leftMargin, (int)f, paramBrowserItem.rightMargin, paramBrowserItem.bottomMargin);
    paramEntryHolder.a.setLayoutParams(paramBrowserItem);
  }
  
  private int c()
  {
    String str = BrowserUtilKt.a();
    if (!TextUtils.isEmpty(str))
    {
      str = BrowserDialogViewModel.a(str);
      int i = 0;
      while (i < this.a.size())
      {
        BrowserItem localBrowserItem = (BrowserItem)this.a.get(i);
        if ((str != null) && (str.equals(localBrowserItem.e()))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  @Nullable
  BrowserItem a()
  {
    int i = this.a.size();
    int j = this.c;
    if ((i > j) && (j >= 0)) {
      return (BrowserItem)this.a.get(j);
    }
    return null;
  }
  
  public void a(List<BrowserItem> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public void b()
  {
    this.d.clear();
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplication.context).inflate(2131627656, paramViewGroup, false);
      paramView = a(localView);
      localView.setTag(paramView);
    }
    else
    {
      RecommendBrowserAdapter.EntryHolder localEntryHolder = (RecommendBrowserAdapter.EntryHolder)paramView.getTag();
      localView = paramView;
      paramView = localEntryHolder;
    }
    a(paramInt, paramView);
    a(paramInt, localView, paramViewGroup);
    EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.browser.RecommendBrowserAdapter
 * JD-Core Version:    0.7.0.1
 */