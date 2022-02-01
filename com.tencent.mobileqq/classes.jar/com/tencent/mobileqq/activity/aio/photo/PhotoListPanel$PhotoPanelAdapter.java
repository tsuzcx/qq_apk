package com.tencent.mobileqq.activity.aio.photo;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.qqalbum.IAlbumUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.util.WeakReference;

public class PhotoListPanel$PhotoPanelAdapter
  extends RecyclerView.Adapter<PhotoListPanel.PhotoPanelAdapter.RecyclerHolder>
{
  public WeakReference<PhotoListPanel> a;
  public ArrayList<LocalMediaInfo> b = new ArrayList();
  boolean c;
  
  public PhotoListPanel$PhotoPanelAdapter(PhotoListPanel paramPhotoListPanel)
  {
    this.a = new WeakReference(paramPhotoListPanel);
    this.c = ThemeUtil.isNowThemeIsNight(((PhotoListPanel)this.a.get()).i, false, null);
  }
  
  public int a(String paramString)
  {
    paramString = b(paramString);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.getMediaType(paramString);
  }
  
  public PhotoListPanel.PhotoPanelAdapter.RecyclerHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new PhotoListPanel.PhotoPanelAdapter.RecyclerHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131627642, paramViewGroup, false));
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    ArrayList localArrayList = this.b;
    if ((localArrayList != null) && (paramInt != -1) && (localArrayList.size() > paramInt)) {
      return (LocalMediaInfo)this.b.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      ((LocalMediaInfo)localIterator.next()).mChecked = false;
    }
  }
  
  public void a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    paramRecyclerHolder.itemView.setOnClickListener(new PhotoListPanel.PhotoPanelAdapter.1(this, paramInt));
    paramRecyclerHolder.j.a(paramInt);
    paramRecyclerHolder.j.a(paramRecyclerHolder.c);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramRecyclerHolder.b;
    Object localObject4 = new EmptyDrawable(((PhotoListPanel)this.a.get()).ab, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject5 = new EmptyDrawable(((PhotoListPanel)this.a.get()).ac, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = AlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
    Object localObject6 = paramRecyclerHolder.g;
    if ((localObject3 != null) && ((localObject6 == null) || (!((URLDrawable)localObject6).getURL().equals(localObject3))))
    {
      localObject6 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject6).mRequestWidth = ((LocalMediaInfo)localObject1).thumbWidth;
      ((URLDrawable.URLDrawableOptions)localObject6).mRequestHeight = ((LocalMediaInfo)localObject1).thumbHeight;
      if ((((LocalMediaInfo)localObject1).thumbWidth > 0) && (((LocalMediaInfo)localObject1).thumbHeight > 0))
      {
        ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = ((Drawable)localObject4);
        ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = ((Drawable)localObject5);
      }
      else
      {
        ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = ((PhotoListPanel)this.a.get()).ad;
        ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = ((PhotoListPanel)this.a.get()).ae;
      }
      localObject4 = URLDrawable.getDrawable((URL)localObject3, (URLDrawable.URLDrawableOptions)localObject6);
      if (QLog.isColorLevel())
      {
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("PhotoListPanel,adapter getView(), url :");
        ((StringBuilder)localObject5).append(((URL)localObject3).toString());
        QLog.d("PhotoListPanel", 2, ((StringBuilder)localObject5).toString());
      }
      ((URLDrawable)localObject4).setTag(localObject1);
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
      paramRecyclerHolder.g = ((URLDrawable)localObject4);
    }
    localObject2 = paramRecyclerHolder.c;
    localObject3 = paramRecyclerHolder.f;
    ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
    if (((LocalMediaInfo)localObject1).mChecked)
    {
      i = ((PhotoListPanel)this.a.get()).d.indexOf(((LocalMediaInfo)localObject1).path);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
    }
    else
    {
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
    }
    if (this.c) {
      ((NumberCheckBox)localObject2).setTextColor(-1509949441);
    }
    localObject3 = paramRecyclerHolder.e;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      ((ImageView)localObject3).setVisibility(4);
      paramRecyclerHolder.i.setVisibility(4);
    }
    else if (i == 1)
    {
      ((ImageView)localObject3).setVisibility(0);
      localObject3 = paramRecyclerHolder.i;
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((IAlbumUtils)QRoute.api(IAlbumUtils.class)).formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
    }
    else
    {
      ((ImageView)localObject3).setVisibility(4);
      paramRecyclerHolder.i.setVisibility(4);
    }
    if ((Utils.c(((PhotoListPanel)this.a.get()).l.b)) && (paramInt == 0))
    {
      localObject3 = (BabyQHandler)((PhotoListPanel)this.a.get()).i.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (((BabyQHandler)localObject3).b(1))
      {
        ((BabyQHandler)localObject3).a();
        ((PhotoListPanel)this.a.get()).P = paramRecyclerHolder.h;
        ((PhotoListPanel)this.a.get()).Z = true;
      }
      if (((PhotoListPanel)this.a.get()).Z)
      {
        paramRecyclerHolder.h.setVisibility(0);
        BabyQHandler.a(((PhotoListPanel)this.a.get()).k, paramRecyclerHolder.h);
      }
      else
      {
        paramRecyclerHolder.h.setVisibility(4);
      }
    }
    else
    {
      paramRecyclerHolder.h.setVisibility(4);
    }
    if (AppSetting.e)
    {
      localObject3 = PhotoUtils.createContentDescription(i, (LocalMediaInfo)localObject1, paramInt);
      paramRecyclerHolder.itemView.setContentDescription((CharSequence)localObject3);
      localObject1 = PhotoUtils.createContentDescriptionWithCheckBox(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
      paramRecyclerHolder.c.setContentDescription((CharSequence)localObject1);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.b.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
      ((PhotoListPanel)this.a.get()).N.setVisibility(8);
      ((PhotoListPanel)this.a.get()).F.setVisibility(0);
      this.b.addAll(paramList);
      notifyDataSetChanged();
      ((PhotoListPanel)this.a.get()).n();
      if (!((PhotoListPanel)this.a.get()).d.isEmpty())
      {
        String.format(((PhotoListPanel)this.a.get()).getResources().getString(2131915833), new Object[] { Integer.valueOf(((PhotoListPanel)this.a.get()).d.size()) });
        return;
      }
      ((PhotoListPanel)this.a.get()).getResources().getString(2131915828);
      return;
    }
    PhotoListPanel.b = 0;
    ((PhotoListPanel)this.a.get()).N.setVisibility(0);
    ((PhotoListPanel)this.a.get()).F.setVisibility(8);
  }
  
  public LocalMediaInfo b(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.b.iterator();
    Object localObject1;
    do
    {
      localObject1 = localObject2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject1 = (LocalMediaInfo)localIterator.next();
    } while (!((LocalMediaInfo)localObject1).path.equals(paramString));
    return localObject1;
  }
  
  void b(List<LocalMediaInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    ((PhotoListPanel)this.a.get()).aa.post(new PhotoListPanel.PhotoPanelAdapter.2(this, paramList));
  }
  
  public int getItemCount()
  {
    return this.b.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.getMediaType(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter
 * JD-Core Version:    0.7.0.1
 */