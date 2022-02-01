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
  public ArrayList<LocalMediaInfo> a;
  public WeakReference<PhotoListPanel> a;
  boolean a;
  
  public PhotoListPanel$PhotoPanelAdapter(PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramPhotoListPanel);
    this.jdField_a_of_type_Boolean = ThemeUtil.isNowThemeIsNight(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false, null);
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.getMediaType(paramString);
  }
  
  public PhotoListPanel.PhotoPanelAdapter.RecyclerHolder a(ViewGroup paramViewGroup, int paramInt)
  {
    return new PhotoListPanel.PhotoPanelAdapter.RecyclerHolder(this, LayoutInflater.from(paramViewGroup.getContext()).inflate(2131561286, paramViewGroup, false));
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
    if ((localArrayList != null) && (paramInt != -1) && (localArrayList.size() > paramInt)) {
      return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
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
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LocalMediaInfo)localIterator.next()).mChecked = false;
    }
  }
  
  public void a(PhotoListPanel.PhotoPanelAdapter.RecyclerHolder paramRecyclerHolder, int paramInt)
  {
    paramRecyclerHolder.itemView.setOnClickListener(new PhotoListPanel.PhotoPanelAdapter.1(this, paramInt));
    paramRecyclerHolder.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$CheckBoxClickedListener.a(paramInt);
    paramRecyclerHolder.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$CheckBoxClickedListener.a(paramRecyclerHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
    Object localObject1 = a(paramInt);
    Object localObject2 = paramRecyclerHolder.jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = new EmptyDrawable(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject5 = new EmptyDrawable(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).j, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
    Object localObject3 = AlbumUtil.generateAlbumThumbURL((LocalMediaInfo)localObject1, "FLOW_THUMB");
    Object localObject6 = paramRecyclerHolder.jdField_a_of_type_ComTencentImageURLDrawable;
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
        ((URLDrawable.URLDrawableOptions)localObject6).mLoadingDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
        ((URLDrawable.URLDrawableOptions)localObject6).mFailedDrawable = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_b_of_type_ComTencentMobileqqDrawableEmptyDrawable;
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
      paramRecyclerHolder.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
    }
    localObject2 = paramRecyclerHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
    localObject3 = paramRecyclerHolder.b;
    ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
    if (((LocalMediaInfo)localObject1).mChecked)
    {
      i = ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).path);
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
    if (this.jdField_a_of_type_Boolean) {
      ((NumberCheckBox)localObject2).setTextColor(-1509949441);
    }
    localObject3 = paramRecyclerHolder.jdField_a_of_type_AndroidWidgetImageView;
    int i = getItemViewType(paramInt);
    if (i == 0)
    {
      ((ImageView)localObject3).setVisibility(4);
      paramRecyclerHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    else if (i == 1)
    {
      ((ImageView)localObject3).setVisibility(0);
      localObject3 = paramRecyclerHolder.jdField_a_of_type_AndroidWidgetTextView;
      ((TextView)localObject3).setVisibility(0);
      ((TextView)localObject3).setText(((IAlbumUtils)QRoute.api(IAlbumUtils.class)).formatTimeToString(((LocalMediaInfo)localObject1).mDuration));
    }
    else
    {
      ((ImageView)localObject3).setVisibility(4);
      paramRecyclerHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    if ((Utils.b(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) && (paramInt == 0))
    {
      localObject3 = (BabyQHandler)((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.BABY_Q_HANDLER);
      if (((BabyQHandler)localObject3).a(1))
      {
        ((BabyQHandler)localObject3).a();
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).c = paramRecyclerHolder.jdField_a_of_type_AndroidViewView;
        ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).l = true;
      }
      if (((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).l)
      {
        paramRecyclerHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        BabyQHandler.a(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidAppActivity, paramRecyclerHolder.jdField_a_of_type_AndroidViewView);
      }
      else
      {
        paramRecyclerHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
      }
    }
    else
    {
      paramRecyclerHolder.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    if (AppSetting.d)
    {
      localObject3 = PhotoUtils.createContentDescription(i, (LocalMediaInfo)localObject1, paramInt);
      paramRecyclerHolder.itemView.setContentDescription((CharSequence)localObject3);
      localObject1 = PhotoUtils.createContentDescriptionWithCheckBox(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
      paramRecyclerHolder.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
    }
    EventCollector.getInstance().onRecyclerBindViewHolder(paramRecyclerHolder, paramInt, getItemId(paramInt));
  }
  
  public void a(List<LocalMediaInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList != null) && (paramList.size() != 0))
    {
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(8);
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
      notifyDataSetChanged();
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).j();
      if (!((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        String.format(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718341), new Object[] { Integer.valueOf(((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_JavaUtilLinkedList.size()) });
        return;
      }
      ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources().getString(2131718336);
      return;
    }
    PhotoListPanel.jdField_b_of_type_Int = 0;
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidViewView.setVisibility(0);
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
  
  void b(List<LocalMediaInfo> paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    ((PhotoListPanel)this.jdField_a_of_type_MqqUtilWeakReference.get()).jdField_a_of_type_AndroidOsHandler.post(new PhotoListPanel.PhotoPanelAdapter.2(this, paramList));
  }
  
  public int getItemCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.getMediaType(a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.PhotoPanelAdapter
 * JD-Core Version:    0.7.0.1
 */