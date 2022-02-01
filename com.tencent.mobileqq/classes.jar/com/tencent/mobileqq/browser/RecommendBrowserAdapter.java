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
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private ArrayList<BrowserItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<String, Drawable> jdField_a_of_type_JavaUtilMap = new LRULinkedHashMap(20);
  
  public RecommendBrowserAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = a();
  }
  
  private int a()
  {
    String str = BrowserUtilKt.a();
    if (!TextUtils.isEmpty(str))
    {
      str = BrowserDialogViewModel.a(str);
      int i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        BrowserItem localBrowserItem = (BrowserItem)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((str != null) && (str.equals(localBrowserItem.e()))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  private static Drawable a(Context paramContext, String paramString)
  {
    paramString = paramContext.getPackageManager().getApplicationInfo(paramString, 128);
    paramString = ((IQQFileSelectorUtil)QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(paramContext, paramString.publicSourceDir);
    if (paramString != null) {
      return paramString;
    }
    return paramContext.getResources().getDrawable(2130844325);
  }
  
  @NotNull
  private RecommendBrowserAdapter.EntryHolder a(View paramView)
  {
    RecommendBrowserAdapter.EntryHolder localEntryHolder = new RecommendBrowserAdapter.EntryHolder(null);
    localEntryHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131369163));
    localEntryHolder.b = ((TextView)paramView.findViewById(2131378039));
    localEntryHolder.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131369083));
    localEntryHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369006));
    localEntryHolder.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131378494));
    return localEntryHolder;
  }
  
  private void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView.setOnClickListener(new RecommendBrowserAdapter.1(this, paramInt));
  }
  
  private void a(int paramInt, RecommendBrowserAdapter.EntryHolder paramEntryHolder)
  {
    long l = System.currentTimeMillis();
    BrowserItem localBrowserItem = (BrowserItem)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    b(paramInt, paramEntryHolder);
    b(paramEntryHolder, localBrowserItem);
    a(paramEntryHolder, localBrowserItem);
    a("bindIconView", l);
  }
  
  private void a(RecommendBrowserAdapter.EntryHolder paramEntryHolder, BrowserItem paramBrowserItem)
  {
    Object localObject;
    if (!paramBrowserItem.a())
    {
      if (!TextUtils.isEmpty(paramBrowserItem.c()))
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(0);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable;
        paramBrowserItem = URLDrawable.getDrawable(paramBrowserItem.c(), (URLDrawable.URLDrawableOptions)localObject);
        paramEntryHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBrowserItem);
        return;
      }
      paramEntryHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(new ColorDrawable(0));
      return;
    }
    try
    {
      localObject = paramBrowserItem.e();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        paramBrowserItem = (Drawable)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      }
      else
      {
        paramBrowserItem = a(this.jdField_a_of_type_AndroidContentContext, (String)localObject);
        this.jdField_a_of_type_JavaUtilMap.put(localObject, paramBrowserItem);
      }
      paramEntryHolder.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(paramBrowserItem);
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
    if (paramInt == this.jdField_a_of_type_Int)
    {
      paramEntryHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramEntryHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void b(RecommendBrowserAdapter.EntryHolder paramEntryHolder, BrowserItem paramBrowserItem)
  {
    paramEntryHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramBrowserItem.a());
    paramEntryHolder.b.setText(paramBrowserItem.b());
    if (paramBrowserItem.a())
    {
      paramEntryHolder.b.setVisibility(8);
      paramEntryHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(16);
      paramBrowserItem = (LinearLayout.LayoutParams)paramEntryHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      paramBrowserItem.setMargins(paramBrowserItem.leftMargin, 0, paramBrowserItem.rightMargin, paramBrowserItem.bottomMargin);
      paramEntryHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBrowserItem);
      return;
    }
    paramEntryHolder.b.setVisibility(0);
    paramEntryHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setGravity(0);
    paramBrowserItem = (LinearLayout.LayoutParams)paramEntryHolder.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298349);
    paramBrowserItem.setMargins(paramBrowserItem.leftMargin, (int)f, paramBrowserItem.rightMargin, paramBrowserItem.bottomMargin);
    paramEntryHolder.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBrowserItem);
  }
  
  @Nullable
  BrowserItem a()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    int j = this.jdField_a_of_type_Int;
    if ((i > j) && (j >= 0)) {
      return (BrowserItem)this.jdField_a_of_type_JavaUtilArrayList.get(j);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void a(List<BrowserItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
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
    View localView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(BaseApplication.context).inflate(2131561300, paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.browser.RecommendBrowserAdapter
 * JD-Core Version:    0.7.0.1
 */