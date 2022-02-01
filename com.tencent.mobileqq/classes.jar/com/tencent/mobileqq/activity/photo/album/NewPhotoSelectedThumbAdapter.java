package com.tencent.mobileqq.activity.photo.album;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.presenter.PreviewPresenter;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewScene;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class NewPhotoSelectedThumbAdapter
  extends BaseAdapter
  implements AdapterView.OnItemClickListener
{
  PhotoPreviewCustomizationDefault a;
  private ColorDrawable b;
  private Drawable c;
  private ArrayList<String> d = new ArrayList();
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public NewPhotoSelectedThumbAdapter(PhotoPreviewCustomizationDefault paramPhotoPreviewCustomizationDefault)
  {
    this.a = paramPhotoPreviewCustomizationDefault;
    this.b = new ColorDrawable(570425344);
    this.c = this.a.c.getResources().getDrawable(2130849738);
    this.e = Utils.a(63.0F, this.a.c.getResources());
    this.f = Utils.a(55.0F, this.a.c.getResources());
    this.g = Utils.a(26.0F, this.a.c.getResources());
    this.h = Utils.a(19.0F, this.a.c.getResources());
    this.i = Utils.a(8.0F, this.a.c.getResources());
    this.j = Utils.a(1.0F, this.a.c.getResources());
  }
  
  public static URL a(LocalMediaInfo paramLocalMediaInfo, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("albumthumbpreview");
    localStringBuilder.append("://");
    localStringBuilder.append(paramLocalMediaInfo.path);
    if (paramString != null)
    {
      localStringBuilder.append("#");
      localStringBuilder.append(paramString);
    }
    try
    {
      paramLocalMediaInfo = new URL(localStringBuilder.toString());
      return paramLocalMediaInfo;
    }
    catch (MalformedURLException paramLocalMediaInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PhotoSelectedThumbAdapter", 2, paramLocalMediaInfo.getMessage(), paramLocalMediaInfo);
      }
    }
    return null;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    LocalMediaInfo localLocalMediaInfo = this.a.i.c(paramString);
    paramString = localLocalMediaInfo;
    if (localLocalMediaInfo == null)
    {
      paramString = new LocalMediaInfo();
      paramString.mMediaType = 0;
    }
    return paramString;
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    this.d = paramArrayList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.d.size();
  }
  
  public Object getItem(int paramInt)
  {
    ArrayList localArrayList = this.d;
    if ((localArrayList != null) && (localArrayList.size() > paramInt)) {
      return (String)this.d.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    NewPhotoSelectedThumbAdapter.Holder localHolder;
    Object localObject1;
    if (paramView == null)
    {
      localHolder = new NewPhotoSelectedThumbAdapter.Holder(this);
      localObject1 = new RelativeLayout(this.a.c);
      localHolder.a = new URLImageView(this.a.c);
      localHolder.a.setPadding(this.i, 0, 0, 0);
      paramView = (RelativeLayout)localObject1;
      paramView.addView(localHolder.a, this.e, this.f);
      localHolder.b = new ImageView(this.a.c);
      localHolder.b.setPadding(this.i, 0, 0, 0);
      localHolder.b.setImageResource(2130842447);
      paramView.addView(localHolder.b, this.e, this.f);
      localHolder.c = new ImageView(this.a.c);
      localHolder.c.setImageResource(2130839532);
      localHolder.c.setPadding(this.i, 0, 0, this.j);
      localObject2 = new RelativeLayout.LayoutParams(this.g, this.h);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      localHolder.c.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localHolder.c.setVisibility(4);
      paramView.addView(localHolder.c);
      ((View)localObject1).setTag(localHolder);
    }
    else
    {
      localHolder = (NewPhotoSelectedThumbAdapter.Holder)paramView.getTag();
      localObject1 = paramView;
    }
    paramView = (String)getItem(paramInt);
    Object localObject2 = paramView;
    if (paramView == null) {
      localObject2 = "";
    }
    LocalMediaInfo localLocalMediaInfo = a((String)localObject2);
    localLocalMediaInfo.path = ((String)localObject2);
    int k = this.f;
    localLocalMediaInfo.thumbWidth = k;
    localLocalMediaInfo.thumbHeight = k;
    paramView = this.a.s().getItem(this.a.s().m());
    Object localObject4 = null;
    if ((paramView != null) && (paramView.baseData != null)) {
      paramView = paramView.baseData.filePath;
    } else {
      paramView = null;
    }
    if (paramView != null)
    {
      localObject3 = localHolder.b;
      if (paramView.equals(localObject2)) {
        k = 0;
      } else {
        k = 4;
      }
      ((ImageView)localObject3).setVisibility(k);
    }
    else
    {
      localHolder.b.setVisibility(4);
    }
    int m = this.a.i.b((String)localObject2);
    k = 1;
    if (m == 1)
    {
      if (localLocalMediaInfo.isSystemMeidaStore) {
        paramView = a(localLocalMediaInfo, "VIDEO");
      } else {
        paramView = a(localLocalMediaInfo, "APP_VIDEO");
      }
    }
    else if (new File((String)localObject2).exists())
    {
      paramView = a(localLocalMediaInfo, "DEFAULT");
    }
    else
    {
      if (QAlbumUtil.isNetUrl((String)localObject2))
      {
        localObject3 = null;
        break label531;
      }
      paramView = null;
    }
    k = 0;
    Object localObject3 = paramView;
    label531:
    if ((localObject3 != null) || (k != 0))
    {
      URLDrawable localURLDrawable = localHolder.d;
      if (k != 0)
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        k = this.f;
        paramView.mRequestWidth = k;
        paramView.mRequestHeight = k;
        paramView.mLoadingDrawable = this.b;
        paramView = URLDrawable.getDrawable(SharpPUtils.getWebpUrl((String)localObject2), paramView);
      }
      else if (localURLDrawable != null)
      {
        paramView = localObject4;
        if (localURLDrawable.getURL().toString().equals(((URL)localObject3).toString())) {}
      }
      else
      {
        paramView = QQAlbumUtils.a((URL)localObject3, this.b, this.c);
      }
      if (paramView != null)
      {
        paramView.setTag(localLocalMediaInfo);
        localHolder.a.setImageDrawable(paramView);
        localHolder.d = paramView;
      }
      if (this.a.d.z.containsValue(localObject2)) {
        localHolder.c.setVisibility(0);
      } else {
        localHolder.c.setVisibility(4);
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    String str = (String)this.d.get(paramInt);
    int k = this.a.d.y.indexOf(str);
    if (k >= 0)
    {
      this.a.i.browserModel.setSelectedIndex(k);
      this.a.i.a.scrollToCurrentPosition();
      this.a.a(k);
      notifyDataSetChanged();
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoSelectedThumbAdapter
 * JD-Core Version:    0.7.0.1
 */