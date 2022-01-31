package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.BabyQHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import vmh;
import vmk;
import vml;

public class PhotoListPanel$MyAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  public ArrayList a;
  int b;
  int c;
  int d;
  
  public PhotoListPanel$MyAdapter(PhotoListPanel paramPhotoListPanel)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    int i = AIOUtils.a(4.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.b = i;
    this.c = i;
    this.jdField_a_of_type_Int = AIOUtils.a(27.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
    this.d = AIOUtils.a(57.0F, paramPhotoListPanel.jdField_a_of_type_AndroidAppActivity.getResources());
  }
  
  public int a(String paramString)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    return AlbumUtil.a(paramString);
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject1 = localObject2;
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > paramInt) {
        localObject1 = (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public LocalMediaInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    LocalMediaInfo localLocalMediaInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localLocalMediaInfo = (LocalMediaInfo)localIterator.next();
    } while (!localLocalMediaInfo.path.equals(paramString));
    for (paramString = localLocalMediaInfo;; paramString = null) {
      return paramString;
    }
  }
  
  public void a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((LocalMediaInfo)localIterator.next()).mChecked = false;
    }
  }
  
  public void a(View paramView1, View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidOsHandler.post(new vml(this, paramView2, paramInt1, paramInt2, paramInt3, paramInt4, paramView1));
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0))
    {
      PhotoListPanel.g = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentWidgetHorizontalListView.setVisibility(0);
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
    notifyDataSetChanged();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h();
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.isEmpty()) {
      String.format(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131432951), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.size()) });
    }
    for (;;)
    {
      PhotoListPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.getResources().getString(2131432952);
    }
  }
  
  public void b(List paramList)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      a(paramList);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidOsHandler.post(new vmk(this, paramList));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    return AlbumUtil.a(a(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.d("check", 2, "getView position=" + paramInt);
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    label391:
    int i;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970482, paramViewGroup, false);
      paramViewGroup = new PhotoListPanel.MyAdapter.Holder(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131370835));
      paramViewGroup.jdField_a_of_type_Vmh = new vmh(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel);
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131364032));
      paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370837);
      if (!AppSetting.b) {
        a(paramView, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox, this.jdField_a_of_type_Int, this.b, this.c, this.d);
      }
      if (paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setOnClickListener(paramViewGroup.jdField_a_of_type_Vmh);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$MyAdapter.getItemViewType(paramInt);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.m) && (paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox != null)) {
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setVisibility(8);
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370838));
      paramViewGroup.b = ((ImageView)paramView.findViewById(2131370836));
      paramView.setTag(paramViewGroup);
      paramViewGroup.jdField_a_of_type_Vmh.a(paramInt);
      paramViewGroup.jdField_a_of_type_Vmh.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      localObject1 = a(paramInt);
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView;
      Object localObject4 = new EmptyDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.h, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
      EmptyDrawable localEmptyDrawable = new EmptyDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.i, ((LocalMediaInfo)localObject1).thumbWidth, ((LocalMediaInfo)localObject1).thumbHeight);
      URL localURL = AlbumUtil.a((LocalMediaInfo)localObject1, "FLOW_THUMB");
      localObject3 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
      if ((localURL != null) && ((localObject3 == null) || (!((URLDrawable)localObject3).getURL().equals(localURL))))
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if ((((LocalMediaInfo)localObject1).thumbWidth <= 0) || (((LocalMediaInfo)localObject1).thumbHeight <= 0)) {
          break label678;
        }
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject4);
        localURLDrawableOptions.mFailedDrawable = localEmptyDrawable;
        localObject4 = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        ((URLDrawable)localObject4).setTag(localObject1);
        ((URLImageView)localObject2).setImageDrawable((Drawable)localObject4);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
        if (localObject3 != null) {
          ((URLDrawable)localObject3).cancelDownload(true);
        }
      }
      localObject2 = paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox;
      localObject3 = paramViewGroup.b;
      ((NumberCheckBox)localObject2).setTag(Integer.valueOf(paramInt));
      if (!((LocalMediaInfo)localObject1).mChecked) {
        break label705;
      }
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_JavaUtilLinkedList.indexOf(((LocalMediaInfo)localObject1).path);
      if (i >= 0) {
        ((NumberCheckBox)localObject2).setCheckedNumber(i + 1);
      }
      ((ImageView)localObject3).setVisibility(0);
      label497:
      localObject3 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
      i = getItemViewType(paramInt);
      if (i != 0) {
        break label720;
      }
      ((ImageView)localObject3).setVisibility(4);
      label521:
      if ((!Utils.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a)) || (paramInt != 0)) {
        break label755;
      }
      localObject3 = (BabyQHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(53);
      if (((BabyQHandler)localObject3).a(1))
      {
        ((BabyQHandler)localObject3).b();
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.c = paramViewGroup.jdField_a_of_type_AndroidViewView;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k = true;
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.k) {
        break label744;
      }
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      BabyQHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_AndroidAppActivity, paramViewGroup.jdField_a_of_type_AndroidViewView);
    }
    for (;;)
    {
      if (AppSetting.b)
      {
        paramView.setContentDescription(PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt));
        localObject1 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt, ((NumberCheckBox)localObject2).isChecked());
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject1);
      }
      return paramView;
      paramViewGroup = (PhotoListPanel.MyAdapter.Holder)paramView.getTag();
      break;
      label678:
      localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.jdField_a_of_type_ComTencentMobileqqDrawableEmptyDrawable;
      localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel.b;
      break label391;
      label705:
      ((NumberCheckBox)localObject2).setChecked(false);
      ((ImageView)localObject3).setVisibility(4);
      break label497;
      label720:
      if (i == 1)
      {
        ((ImageView)localObject3).setVisibility(0);
        break label521;
      }
      ((ImageView)localObject3).setVisibility(4);
      break label521;
      label744:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
      continue;
      label755:
      paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.MyAdapter
 * JD-Core Version:    0.7.0.1
 */