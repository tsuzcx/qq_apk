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
import android.widget.CheckBox;
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
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class AIOPhotoListAdapter
  extends AbstractImageAdapter
{
  static final Object jdField_a_of_type_JavaLangObject = new Object();
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AIOImageListModel jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  public boolean a;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -1;
  private int e = -1;
  
  public AIOPhotoListAdapter(Activity paramActivity, int paramInt, AIOImageListModel paramAIOImageListModel, IAIOImageProvider paramIAIOImageProvider, GridView paramGridView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel = paramAIOImageListModel;
    paramAIOImageListModel.d(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_b_of_type_Int = AIOUtils.b(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  public static int a(int paramInt)
  {
    int i = -1;
    if (paramInt != -1)
    {
      paramInt = Integer.valueOf(ChatActivityUtils.b(paramInt)).intValue();
      if (paramInt != 0)
      {
        if (paramInt != 3) {
          return -1;
        }
        return 2;
      }
      i = 1;
    }
    return i;
  }
  
  private void a(int paramInt1, int paramInt2, View paramView, Object paramObject)
  {
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2) {
        return;
      }
      if (!AIOPhotoListAdapter.HeaderHolder.class.isInstance(paramObject)) {
        return;
      }
      paramObject = (AIOPhotoListAdapter.HeaderHolder)paramObject;
      String str = (String)getItem(paramInt2);
      paramObject.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      Object localObject;
      if (AppSetting.d)
      {
        paramInt1 = paramInt2 / 4;
        localObject = paramObject.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131700331));
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append(HardCodeUtil.a(2131700334));
        localStringBuilder.append(str);
        ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      }
      if (a())
      {
        localObject = (ViewGroup)paramObject.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839388));
        }
        paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
        paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(str));
        paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
        paramView.setOnClickListener(new AIOPhotoListAdapter.5(this, str));
      }
    }
    else
    {
      a(paramInt2, paramView);
    }
  }
  
  private void a(View paramView, AIORichMediaInfo paramAIORichMediaInfo, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView, AIOPhotoListAdapter.ContentHolder paramContentHolder)
  {
    paramView.setVisibility(0);
    paramView = (AIOShortVideoData)paramAIORichMediaInfo.a;
    if (paramView.jdField_b_of_type_Int == 0)
    {
      paramImageView.setImageResource(2130839476);
      paramTextView.setText(ShortVideoUtils.stringForTime(paramView.jdField_a_of_type_Int * 1000));
      paramTextView.setVisibility(0);
    }
    else
    {
      paramImageView.setImageResource(2130839329);
      paramContentHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    }
    paramImageView.setVisibility(0);
    if (paramView.a(0) != null)
    {
      paramView = paramView.a(0);
      paramAIORichMediaInfo = URLDrawable.URLDrawableOptions.obtain();
      paramImageView = paramURLImageView.getDrawable();
      int i = this.jdField_a_of_type_Int;
      paramAIORichMediaInfo.mRequestWidth = i;
      paramAIORichMediaInfo.mRequestHeight = i;
      paramAIORichMediaInfo.mLoadingDrawable = URLDrawableHelperConstants.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if ((paramImageView instanceof URLDrawable))
      {
        paramImageView = ((URLDrawable)paramImageView).getURL().toString();
        if ((paramView != null) && (!paramView.equals(paramImageView))) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramAIORichMediaInfo));
        }
      }
      else
      {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramView, paramAIORichMediaInfo));
      }
    }
    else
    {
      if (paramView.jdField_a_of_type_Boolean) {
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOPhotoListAdapter.2(this, paramView));
    }
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, AIORichMediaInfo paramAIORichMediaInfo, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    paramAIORichMediaInfo = (AIOFilePicData)paramAIORichMediaInfo.a;
    paramTextView = paramAIORichMediaInfo.a(18);
    paramImageView = paramAIORichMediaInfo.a(18);
    if (paramTextView == null)
    {
      paramTextView = paramAIORichMediaInfo.a(16);
      paramImageView = paramAIORichMediaInfo.a(16);
      if (paramTextView == null)
      {
        paramTextView = paramAIORichMediaInfo.a(20);
        paramImageView = paramAIORichMediaInfo.a(20);
      }
    }
    if (paramTextView != null)
    {
      paramTextView = paramURLImageView.getDrawable();
      paramAIORichMediaInfo = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      paramAIORichMediaInfo.mRequestWidth = i;
      paramAIORichMediaInfo.mRequestHeight = i;
      paramAIORichMediaInfo.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
      if ((paramTextView instanceof URLDrawable))
      {
        if (!paramImageView.equals(((URLDrawable)paramTextView).getURL().toString())) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramAIORichMediaInfo));
        }
      }
      else {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramAIORichMediaInfo));
      }
    }
    else
    {
      if (paramAIORichMediaInfo.jdField_c_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024);
        }
        paramURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      if ((((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb()) || (this.jdField_c_of_type_Int != 2)) {
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOPhotoListAdapter.3(this, paramAIORichMediaInfo));
      }
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, ImageView paramImageView, TextView paramTextView1, View paramView, TextView paramTextView2, URLImageView paramURLImageView)
  {
    paramView.setVisibility(0);
    paramImageView.setImageResource(2130839476);
    paramImageView.setVisibility(0);
    paramTextView1.setText(ShortVideoUtils.stringForFileSize(this.jdField_a_of_type_AndroidContentContext, paramAIOFileVideoData.h));
    paramTextView1.setVisibility(0);
    float f1 = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    float f2 = this.jdField_a_of_type_Int * 2;
    paramTextView2.setText((String)TextUtils.ellipsize(paramAIOFileVideoData.a, paramTextView2.getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
    paramTextView2.setVisibility(0);
    if (paramAIOFileVideoData.a(0) != null)
    {
      paramAIOFileVideoData = paramAIOFileVideoData.a(16);
      paramImageView = paramURLImageView.getDrawable();
      paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      paramTextView1.mRequestWidth = i;
      paramTextView1.mRequestHeight = i;
      paramTextView1.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
      if ((paramImageView instanceof URLDrawable))
      {
        if (!paramAIOFileVideoData.equals(((URLDrawable)paramImageView).getURL().toString())) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
        }
      }
      else {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOFileVideoData, paramTextView1));
      }
    }
    else
    {
      paramURLImageView.setImageDrawable(null);
      paramURLImageView.setBackgroundColor(Color.parseColor("#D8DAE0"));
    }
  }
  
  private void a(AIOLightVideoData paramAIOLightVideoData, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setImageResource(2130839329);
    paramTextView.setText(ShortVideoUtils.stringForTime(paramAIOLightVideoData.jdField_a_of_type_Int * 1000));
    paramTextView.setVisibility(0);
    paramImageView.setVisibility(0);
    if (paramAIOLightVideoData.a(0) != null)
    {
      paramAIOLightVideoData = paramAIOLightVideoData.a(0);
      paramImageView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView = paramURLImageView.getDrawable();
      int i = this.jdField_a_of_type_Int;
      paramImageView.mRequestWidth = i;
      paramImageView.mRequestHeight = i;
      paramImageView.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      if ((paramTextView instanceof URLDrawable))
      {
        paramTextView = ((URLDrawable)paramTextView).getURL().toString();
        if ((paramAIOLightVideoData != null) && (!paramAIOLightVideoData.equals(paramTextView))) {
          paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
        }
      }
      else
      {
        paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramAIOLightVideoData, paramImageView));
      }
    }
    else
    {
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOPhotoListAdapter.4(this, paramAIOLightVideoData));
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = paramAIORichMediaInfo.getSelected();
      if (i != 1)
      {
        if (i != 2)
        {
          if (paramImageView1 != null) {
            paramImageView1.setVisibility(4);
          }
          if (paramImageView2 != null) {
            paramImageView2.setVisibility(4);
          }
        }
        else
        {
          if (paramImageView1 != null) {
            paramImageView1.setVisibility(4);
          }
          if (paramImageView2 != null)
          {
            paramImageView2.setImageResource(2130845863);
            paramImageView2.setVisibility(0);
          }
        }
      }
      else
      {
        if (paramImageView1 != null) {
          paramImageView1.setVisibility(0);
        }
        if (paramImageView2 != null)
        {
          paramImageView2.setImageResource(2130845866);
          paramImageView2.setVisibility(0);
        }
      }
    }
    else
    {
      if (paramImageView1 != null) {
        paramImageView1.setVisibility(4);
      }
      if (paramImageView2 != null) {
        paramImageView2.setVisibility(4);
      }
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, ImageView paramImageView, TextView paramTextView, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    paramAIORichMediaInfo = (AIOImageData)paramAIORichMediaInfo.a;
    paramImageView = paramAIORichMediaInfo.a(1);
    String str;
    if (paramImageView != null)
    {
      paramAIORichMediaInfo = paramURLImageView.getDrawable();
      paramTextView = URLDrawable.URLDrawableOptions.obtain();
      int i = this.jdField_a_of_type_Int;
      paramTextView.mRequestWidth = i;
      paramTextView.mRequestHeight = i;
      paramTextView.mLoadingDrawable = URLDrawableHelper.TRANSLUCENT;
      if ((paramAIORichMediaInfo instanceof URLDrawable)) {
        str = ((URLDrawable)paramAIORichMediaInfo).getURL().toString();
      }
    }
    try
    {
      paramAIORichMediaInfo = paramImageView.toURI().toURL().toString();
    }
    catch (MalformedURLException paramAIORichMediaInfo)
    {
      label96:
      break label96;
    }
    paramAIORichMediaInfo = "";
    if (!paramAIORichMediaInfo.equals(str))
    {
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramTextView));
      return;
      paramURLImageView.setImageDrawable(URLDrawable.getDrawable(paramImageView, paramTextView));
      return;
      if (paramAIORichMediaInfo.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838024);
        }
        paramURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new AIOPhotoListAdapter.1(this, paramAIORichMediaInfo));
    }
  }
  
  public void a()
  {
    AIOImageListModel localAIOImageListModel = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel;
    if (localAIOImageListModel == null) {
      return;
    }
    if (localAIOImageListModel.a()) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
    this.e = a(this.d);
  }
  
  public void a(int paramInt, View paramView)
  {
    long l = SystemClock.uptimeMillis();
    Object localObject1 = getItem(paramInt);
    Object localObject2 = paramView.getTag();
    if (!AIORichMediaInfo.class.isInstance(localObject1))
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] is not AIORichMediaInfo, position:");
      paramView.append(paramInt);
      QLog.d("AIOPhotoListAdapter", 2, paramView.toString());
      return;
    }
    if (!(localObject2 instanceof AIOPhotoListAdapter.ContentHolder))
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] is not ContentHolder, position:");
      paramView.append(paramInt);
      QLog.d("AIOPhotoListAdapter", 2, paramView.toString());
      return;
    }
    AIOPhotoListAdapter.ContentHolder localContentHolder = (AIOPhotoListAdapter.ContentHolder)localObject2;
    AIORichMediaInfo localAIORichMediaInfo = (AIORichMediaInfo)localObject1;
    URLImageView localURLImageView = localContentHolder.jdField_a_of_type_ComTencentImageURLImageView;
    ImageView localImageView1 = localContentHolder.jdField_a_of_type_AndroidWidgetImageView;
    ImageView localImageView2 = localContentHolder.jdField_b_of_type_AndroidWidgetImageView;
    ImageView localImageView3 = localContentHolder.c;
    TextView localTextView1 = localContentHolder.jdField_a_of_type_AndroidWidgetTextView;
    TextView localTextView2 = localContentHolder.jdField_b_of_type_AndroidWidgetTextView;
    View localView = localContentHolder.jdField_a_of_type_AndroidViewView;
    localView.setVisibility(8);
    localTextView2.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    localObject2 = null;
    localObject1 = null;
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localAIORichMediaInfo, localImageView3, localTextView1, localURLImageView);
      if (AppSetting.d) {
        localObject1 = HardCodeUtil.a(2131700335);
      }
    }
    else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localView, localAIORichMediaInfo, localImageView3, localTextView1, localURLImageView, localContentHolder);
      localObject1 = localObject2;
      if (AppSetting.d) {
        localObject1 = HardCodeUtil.a(2131700333);
      }
    }
    else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localImageView3, localTextView1, localAIORichMediaInfo, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.d) {
        localObject1 = HardCodeUtil.a(2131700329);
      }
    }
    else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      a((AIOFileVideoData)localAIORichMediaInfo.a, localImageView3, localTextView1, localView, localTextView2, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.d) {
        localObject1 = HardCodeUtil.a(2131700332);
      }
    }
    else
    {
      localObject1 = localObject2;
      if (AIOLightVideoData.class.isInstance(localAIORichMediaInfo.a))
      {
        localView.setVisibility(0);
        a((AIOLightVideoData)localAIORichMediaInfo.a, localImageView3, localTextView1, localURLImageView);
        localObject1 = localObject2;
        if (AppSetting.d) {
          localObject1 = HardCodeUtil.a(2131700330);
        }
      }
    }
    if (localObject1 != null)
    {
      int i = paramInt / 4;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700336));
      ((StringBuilder)localObject2).append(i + 1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131700337));
      ((StringBuilder)localObject2).append(paramInt % 4 + 1);
      ((StringBuilder)localObject2).append((String)localObject1);
      paramView.setContentDescription(((StringBuilder)localObject2).toString());
    }
    a(localAIORichMediaInfo, localImageView1, localImageView2);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] cost: ");
      paramView.append(SystemClock.uptimeMillis() - l);
      paramView.append(" data");
      paramView.append(localAIORichMediaInfo.a);
      QLog.d("AIOPhotoListAdapter", 2, paramView.toString());
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.e != -1);
  }
  
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
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g();
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
    if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageListModel.g()) {
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
    boolean bool = localObject instanceof AIORichMediaInfo;
    paramInt = 0;
    if (bool) {
      return 0;
    }
    if (AIOImageListModel.b.equals(localObject)) {
      return 1;
    }
    if ((localObject instanceof String)) {
      return 2;
    }
    if (AIOImageListModel.jdField_a_of_type_JavaLangObject.equals(localObject)) {
      return 3;
    }
    if (jdField_a_of_type_JavaLangObject.equals(localObject)) {
      paramInt = 4;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      localObject1 = null;
    } else {
      localObject1 = paramView.getTag();
    }
    Object localObject2;
    int j;
    if (i != 0)
    {
      if (i != 1)
      {
        Object localObject3;
        if (i != 2)
        {
          if (i != 3)
          {
            if ((i == 4) && (!jdField_a_of_type_JavaLangObject.equals(localObject1)))
            {
              paramView = new AIOPhotoListAdapter.FullWidthFixedViewLayout(this, this.jdField_a_of_type_AndroidContentContext);
              localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561279, null);
              localObject3 = new FrameLayout.LayoutParams(-2, -2);
              ((FrameLayout.LayoutParams)localObject3).gravity = 17;
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              paramView.addView((View)localObject2);
              paramView.setTag(jdField_a_of_type_JavaLangObject);
            }
          }
          else if (!AIOImageListModel.jdField_a_of_type_JavaLangObject.equals(localObject1))
          {
            paramView = new View(this.jdField_a_of_type_AndroidContentContext);
            paramView.setMinimumHeight(this.jdField_b_of_type_Int);
            paramView.setVisibility(4);
            paramView.setTag(AIOImageListModel.jdField_a_of_type_JavaLangObject);
          }
        }
        else if (!AIOPhotoListAdapter.HeaderHolder.class.isInstance(localObject1))
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561280, null);
          localObject1 = new AIOPhotoListAdapter.HeaderHolder(this);
          ((AIOPhotoListAdapter.HeaderHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378615));
          ((AIOPhotoListAdapter.HeaderHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369353));
          paramView = new AIOPhotoListAdapter.FullWidthFixedViewLayout(this, this.jdField_a_of_type_AndroidContentContext);
          localObject3 = ((View)localObject2).getLayoutParams();
          if (localObject3 != null)
          {
            ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
          }
          ((FrameLayout)paramView).addView((View)localObject2);
          paramView.setTag(localObject1);
        }
      }
      else if (!AIOImageListModel.b.equals(localObject1))
      {
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        j = this.jdField_a_of_type_Int;
        paramView.setLayoutParams(new AbsListView.LayoutParams(j, j));
        paramView.setTag(AIOImageListModel.b);
      }
    }
    else if (!AIOPhotoListAdapter.ContentHolder.class.isInstance(localObject1))
    {
      if ((QLog.isColorLevel()) && (paramView != null))
      {
        paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getView] type 0 while convertView type ");
        ((StringBuilder)localObject2).append(paramView.viewType);
        QLog.d("AIOPhotoListAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561291, null);
      j = this.jdField_a_of_type_Int;
      paramView.setLayoutParams(new AbsListView.LayoutParams(j, j));
      localObject2 = new AIOPhotoListAdapter.ContentHolder(this);
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131372648));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131369102));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372653));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).c = ((ImageView)paramView.findViewById(2131372580));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380662));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366819));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131363754);
      paramView.setTag(localObject2);
    }
    a(i, paramInt, paramView, localObject1);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */