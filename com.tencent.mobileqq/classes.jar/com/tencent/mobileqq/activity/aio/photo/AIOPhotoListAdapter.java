package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FMConfig;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import vln;
import vlo;
import vlp;
import vlq;

public class AIOPhotoListAdapter
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  public IAIOImageProvider a;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int c = 0;
  
  public AIOPhotoListAdapter(Activity paramActivity, int paramInt, AIOImageListModel paramAIOImageListModel, IAIOImageProvider paramIAIOImageProvider, GridView paramGridView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = paramAIOImageListModel;
    paramAIOImageListModel.d(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = AIOUtils.a(30.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(int paramInt, View paramView)
  {
    long l = SystemClock.uptimeMillis();
    localObject1 = (AIOPhotoListAdapter.ContentHolder)paramView.getTag();
    Object localObject2 = getItem(paramInt);
    if (!AIORichMediaInfo.class.isInstance(localObject2)) {
      return;
    }
    AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localObject2;
    URLImageView localURLImageView = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView;
    localObject2 = ((AIOPhotoListAdapter.ContentHolder)localObject1).c;
    Object localObject3 = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView;
    Object localObject4 = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView;
    View localView = ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidViewView;
    localView.setVisibility(8);
    ((TextView)localObject4).setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    File localFile = null;
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
    {
      ((ImageView)localObject2).setVisibility(4);
      ((TextView)localObject3).setVisibility(4);
      localObject1 = (AIOImageData)localAIORichMediaInfo.a;
      localFile = ((AIOImageData)localObject1).a(1);
      if (localFile != null)
      {
        localObject1 = localURLImageView.getDrawable();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.b;
        if ((localObject1 instanceof URLDrawable))
        {
          localObject4 = ((URLDrawable)localObject1).getURL().toString();
          localObject1 = "";
        }
      }
    }
    try
    {
      localObject2 = localFile.toURI().toURL().toString();
      localObject1 = localObject2;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      for (;;)
      {
        label261:
        label271:
        int i;
        label580:
        label727:
        label742:
        label1000:
        continue;
        label838:
        label985:
        localObject1 = null;
      }
    }
    if (!((String)localObject1).equals(localObject4)) {
      localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
    }
    if (AppSetting.jdField_b_of_type_Boolean)
    {
      localObject1 = "张图片";
      if (localObject1 != null)
      {
        i = paramInt / 4;
        paramView.setContentDescription("已选定第" + (i + 1) + "行第" + (paramInt % 4 + 1) + (String)localObject1);
      }
      if (this.jdField_a_of_type_Boolean) {
        switch (localAIORichMediaInfo.b())
        {
        default: 
          localImageView1.setVisibility(4);
          localImageView2.setVisibility(4);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("AIOPhotoListAdapter", 2, "[updateView] cost: " + (SystemClock.uptimeMillis() - l) + " data" + localAIORichMediaInfo.a);
        return;
        localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFile, (URLDrawable.URLDrawableOptions)localObject3));
        break label261;
        if (((AIOImageData)localObject1).jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837615);
          }
          localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          break label261;
        }
        localURLImageView.setImageDrawable(URLDrawableHelper.b);
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vln(this, (AIOImageData)localObject1));
        break label261;
        if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a))
        {
          localView.setVisibility(0);
          localObject4 = (AIOShortVideoData)localAIORichMediaInfo.a;
          if (((AIOShortVideoData)localObject4).jdField_b_of_type_Int == 0)
          {
            ((ImageView)localObject2).setImageResource(2130838650);
            ((TextView)localObject3).setText(ShortVideoUtils.a(((AIOShortVideoData)localObject4).jdField_a_of_type_Int * 1000));
            ((TextView)localObject3).setVisibility(0);
            ((ImageView)localObject2).setVisibility(0);
            if (((AIOShortVideoData)localObject4).a(0) == null) {
              break label742;
            }
            localObject1 = ((AIOShortVideoData)localObject4).a(0);
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject3 = localURLImageView.getDrawable();
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            if (!(localObject3 instanceof URLDrawable)) {
              break label727;
            }
            localObject3 = ((URLDrawable)localObject3).getURL().toString();
            if ((localObject1 != null) && (!((String)localObject1).equals(localObject3))) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.jdField_b_of_type_Boolean) {
              break;
            }
            localObject1 = "个视频";
            break;
            ((ImageView)localObject2).setImageResource(2130838527);
            ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
            break label580;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2));
            continue;
            if (!((AIOShortVideoData)localObject4).jdField_a_of_type_Boolean)
            {
              localURLImageView.setImageDrawable(URLDrawableHelper.b);
              this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vlo(this, (AIOShortVideoData)localObject4));
            }
          }
        }
        if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
        {
          ((ImageView)localObject2).setVisibility(4);
          ((TextView)localObject3).setVisibility(4);
          localObject4 = (AIOFilePicData)localAIORichMediaInfo.a;
          localObject2 = ((AIOFilePicData)localObject4).a(18);
          localObject1 = ((AIOFilePicData)localObject4).a(18);
          if (localObject2 != null)
          {
            if (localObject2 == null) {
              break label1000;
            }
            localObject2 = localURLImageView.getDrawable();
            localObject3 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
            ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.b;
            if (!(localObject2 instanceof URLDrawable)) {
              break label985;
            }
            if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            }
          }
          for (;;)
          {
            localObject1 = localFile;
            if (!AppSetting.jdField_b_of_type_Boolean) {
              break;
            }
            localObject1 = "张图片";
            break;
            localObject3 = ((AIOFilePicData)localObject4).a(16);
            localObject1 = ((AIOFilePicData)localObject4).a(16);
            localObject2 = localObject3;
            if (localObject3 != null) {
              break label838;
            }
            localObject2 = ((AIOFilePicData)localObject4).a(20);
            localObject1 = ((AIOFilePicData)localObject4).a(20);
            break label838;
            localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            continue;
            if (((AIOFilePicData)localObject4).c)
            {
              if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
                this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130837615);
              }
              localURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
            }
            else
            {
              localURLImageView.setImageDrawable(URLDrawableHelper.b);
              if ((FMConfig.a()) || (this.c != 2)) {
                this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new vlp(this, (AIOFilePicData)localObject4));
              }
            }
          }
        }
        localObject1 = localFile;
        if (!AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a)) {
          break label271;
        }
        localObject1 = (AIOFileVideoData)localAIORichMediaInfo.a;
        localView.setVisibility(0);
        ((ImageView)localObject2).setImageResource(2130838650);
        ((ImageView)localObject2).setVisibility(0);
        ((TextView)localObject3).setText(ShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext, ((AIOFileVideoData)localObject1).a.fileSize));
        ((TextView)localObject3).setVisibility(0);
        if (((AIOFileVideoData)localObject1).a != null)
        {
          float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
          float f2 = this.jdField_a_of_type_Int * 2;
          ((TextView)localObject4).setText((String)TextUtils.ellipsize(((AIOFileVideoData)localObject1).a.fileName, ((TextView)localObject4).getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
          ((TextView)localObject4).setVisibility(0);
        }
        if (((AIOFileVideoData)localObject1).a(0) != null)
        {
          localObject1 = ((AIOFileVideoData)localObject1).a(16);
          localObject2 = localURLImageView.getDrawable();
          localObject3 = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = this.jdField_a_of_type_Int;
          ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.b;
          if ((localObject2 instanceof URLDrawable)) {
            if (!((String)localObject1).equals(((URLDrawable)localObject2).getURL().toString())) {
              localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
            }
          }
        }
        for (;;)
        {
          localObject1 = localFile;
          if (!AppSetting.jdField_b_of_type_Boolean) {
            break;
          }
          localObject1 = "个视频";
          break;
          localURLImageView.setImageDrawable(URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3));
          continue;
          localURLImageView.setImageDrawable(null);
          localURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
        }
        localImageView1.setVisibility(0);
        localImageView2.setImageResource(2130842886);
        localImageView2.setVisibility(0);
        continue;
        localImageView1.setVisibility(4);
        localImageView2.setImageResource(2130842884);
        localImageView2.setVisibility(0);
        continue;
        localImageView1.setVisibility(4);
        localImageView2.setVisibility(4);
      }
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f();
    int j = i;
    if (this.jdField_b_of_type_Boolean)
    {
      int k = i % 4;
      j = i;
      if (k > 0) {
        j = i + (4 - k);
      }
      j += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.f()) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.a(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return AIOImageListModel.b;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    if ((localObject instanceof AIORichMediaInfo)) {}
    do
    {
      return 0;
      if (AIOImageListModel.b.equals(localObject)) {
        return 1;
      }
      if ((localObject instanceof String)) {
        return 2;
      }
      if (AIOImageListModel.jdField_a_of_type_JavaLangObject.equals(localObject)) {
        return 3;
      }
    } while (!jdField_a_of_type_JavaLangObject.equals(localObject));
    return 4;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (paramView == null)
    {
      paramViewGroup = null;
      switch (i)
      {
      default: 
        label48:
        switch (i)
        {
        }
        break;
      }
    }
    Object localObject1;
    do
    {
      do
      {
        return paramView;
        paramViewGroup = paramView.getTag();
        break;
        if (AIOPhotoListAdapter.ContentHolder.class.isInstance(paramViewGroup)) {
          break label48;
        }
        if ((QLog.isColorLevel()) && (paramView != null))
        {
          paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
          QLog.d("AIOPhotoListAdapter", 2, "[getView] type 0 while convertView type " + paramView.jdField_a_of_type_Int);
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970484, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        localObject1 = new AIOPhotoListAdapter.ContentHolder(this);
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131370840));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370842));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369348));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).c = ((ImageView)paramView.findViewById(2131370843));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370844));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131364089));
        ((AIOPhotoListAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370841);
        paramView.setTag(localObject1);
        break label48;
        if (AIOImageListModel.b.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
        paramView.setTag(AIOImageListModel.b);
        break label48;
        if (AIOPhotoListAdapter.HeaderHolder.class.isInstance(paramViewGroup)) {
          break label48;
        }
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970479, null);
        paramViewGroup = new AIOPhotoListAdapter.HeaderHolder(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131366463));
        paramView = new vlq(this, this.jdField_a_of_type_AndroidContentContext);
        Object localObject2 = ((View)localObject1).getLayoutParams();
        if (localObject2 != null)
        {
          ((View)localObject1).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
          paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject2).width, ((ViewGroup.LayoutParams)localObject2).height));
        }
        ((FrameLayout)paramView).addView((View)localObject1);
        paramView.setTag(paramViewGroup);
        break label48;
        if (AIOImageListModel.jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        paramView.setMinimumHeight(this.jdField_b_of_type_Int);
        paramView.setVisibility(4);
        paramView.setTag(AIOImageListModel.jdField_a_of_type_JavaLangObject);
        break label48;
        if (jdField_a_of_type_JavaLangObject.equals(paramViewGroup)) {
          break label48;
        }
        paramView = new vlq(this, this.jdField_a_of_type_AndroidContentContext);
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970478, null);
        localObject2 = new FrameLayout.LayoutParams(-2, -2);
        ((FrameLayout.LayoutParams)localObject2).gravity = 17;
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        paramView.addView((View)localObject1);
        paramView.setTag(jdField_a_of_type_JavaLangObject);
        break label48;
        a(paramInt, paramView);
        return paramView;
      } while (!AIOPhotoListAdapter.HeaderHolder.class.isInstance(paramViewGroup));
      paramViewGroup = (AIOPhotoListAdapter.HeaderHolder)paramViewGroup;
      localObject1 = (String)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    } while (!AppSetting.jdField_b_of_type_Boolean);
    paramInt /= 4;
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setContentDescription("第" + (paramInt + 1) + "行" + (String)localObject1);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return getItemViewType(paramInt) == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */