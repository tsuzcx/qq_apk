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
  static final Object a = new Object();
  IAIOImageProvider b;
  public boolean c = false;
  WeakReferenceHandler d = new WeakReferenceHandler(ThreadManager.getSubThreadLooper(), null);
  Drawable e;
  private int f;
  private LayoutInflater g;
  private Context i;
  private AIOImageListModel j;
  private GridView k;
  private int l;
  private boolean m = false;
  private int n = 0;
  private boolean o = false;
  private int p = -1;
  private int q = -1;
  
  public AIOPhotoListAdapter(Activity paramActivity, int paramInt, AIOImageListModel paramAIOImageListModel, IAIOImageProvider paramIAIOImageProvider, GridView paramGridView)
  {
    this.i = paramActivity;
    this.g = paramActivity.getLayoutInflater();
    this.f = paramInt;
    this.j = paramAIOImageListModel;
    paramAIOImageListModel.f(4);
    this.b = paramIAIOImageProvider;
    this.k = paramGridView;
    this.l = AIOUtils.b(40.0F, this.i.getResources());
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
      paramObject.a.setText(str);
      Object localObject;
      if (AppSetting.e)
      {
        paramInt1 = paramInt2 / 4;
        localObject = paramObject.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131898371));
        localStringBuilder.append(paramInt1 + 1);
        localStringBuilder.append(HardCodeUtil.a(2131898374));
        localStringBuilder.append(str);
        ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      }
      if (a())
      {
        localObject = (ViewGroup)paramObject.b.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).setBackgroundDrawable(this.i.getResources().getDrawable(2130839572));
        }
        paramObject.b.setVisibility(0);
        paramObject.b.setChecked(this.j.t.a(str));
        paramObject.b.setClickable(false);
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
    if (paramView.d == 0)
    {
      paramImageView.setImageResource(2130839666);
      paramTextView.setText(ShortVideoUtils.stringForTime(paramView.c * 1000));
      paramTextView.setVisibility(0);
    }
    else
    {
      paramImageView.setImageResource(2130839509);
      paramContentHolder.e.setVisibility(4);
    }
    paramImageView.setVisibility(0);
    if (paramView.c(0) != null)
    {
      paramView = paramView.b(0);
      paramAIORichMediaInfo = URLDrawable.URLDrawableOptions.obtain();
      paramImageView = paramURLImageView.getDrawable();
      int i1 = this.f;
      paramAIORichMediaInfo.mRequestWidth = i1;
      paramAIORichMediaInfo.mRequestHeight = i1;
      paramAIORichMediaInfo.mLoadingDrawable = URLDrawableHelperConstants.a;
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
      if (paramView.e) {
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      this.d.post(new AIOPhotoListAdapter.2(this, paramView));
    }
  }
  
  private void a(ImageView paramImageView, TextView paramTextView, AIORichMediaInfo paramAIORichMediaInfo, URLImageView paramURLImageView)
  {
    paramImageView.setVisibility(4);
    paramTextView.setVisibility(4);
    paramAIORichMediaInfo = (AIOFilePicData)paramAIORichMediaInfo.a;
    paramTextView = paramAIORichMediaInfo.c(18);
    paramImageView = paramAIORichMediaInfo.b(18);
    if (paramTextView == null)
    {
      paramTextView = paramAIORichMediaInfo.c(16);
      paramImageView = paramAIORichMediaInfo.b(16);
      if (paramTextView == null)
      {
        paramTextView = paramAIORichMediaInfo.c(20);
        paramImageView = paramAIORichMediaInfo.b(20);
      }
    }
    if (paramTextView != null)
    {
      paramTextView = paramURLImageView.getDrawable();
      paramAIORichMediaInfo = URLDrawable.URLDrawableOptions.obtain();
      int i1 = this.f;
      paramAIORichMediaInfo.mRequestWidth = i1;
      paramAIORichMediaInfo.mRequestHeight = i1;
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
      if (paramAIORichMediaInfo.i)
      {
        if (this.e == null) {
          this.e = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066);
        }
        paramURLImageView.setImageDrawable(this.e);
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      if ((((IFMConfig)QRoute.api(IFMConfig.class)).preDownloadThumb()) || (this.n != 2)) {
        this.d.post(new AIOPhotoListAdapter.3(this, paramAIORichMediaInfo));
      }
    }
  }
  
  private void a(AIOFileVideoData paramAIOFileVideoData, ImageView paramImageView, TextView paramTextView1, View paramView, TextView paramTextView2, URLImageView paramURLImageView)
  {
    paramView.setVisibility(0);
    paramImageView.setImageResource(2130839666);
    paramImageView.setVisibility(0);
    paramTextView1.setText(ShortVideoUtils.stringForFileSize(this.i, paramAIOFileVideoData.O));
    paramTextView1.setVisibility(0);
    float f1 = this.i.getResources().getDisplayMetrics().density;
    float f2 = this.f * 2;
    paramTextView2.setText((String)TextUtils.ellipsize(paramAIOFileVideoData.a, paramTextView2.getPaint(), f2 - f1 * 4.0F * 8.0F, TextUtils.TruncateAt.END));
    paramTextView2.setVisibility(0);
    if (paramAIOFileVideoData.c(0) != null)
    {
      paramAIOFileVideoData = paramAIOFileVideoData.b(16);
      paramImageView = paramURLImageView.getDrawable();
      paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
      int i1 = this.f;
      paramTextView1.mRequestWidth = i1;
      paramTextView1.mRequestHeight = i1;
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
    paramImageView.setImageResource(2130839509);
    paramTextView.setText(ShortVideoUtils.stringForTime(paramAIOLightVideoData.c * 1000));
    paramTextView.setVisibility(0);
    paramImageView.setVisibility(0);
    if (paramAIOLightVideoData.c(0) != null)
    {
      paramAIOLightVideoData = paramAIOLightVideoData.b(0);
      paramImageView = URLDrawable.URLDrawableOptions.obtain();
      paramTextView = paramURLImageView.getDrawable();
      int i1 = this.f;
      paramImageView.mRequestWidth = i1;
      paramImageView.mRequestHeight = i1;
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
      this.d.post(new AIOPhotoListAdapter.4(this, paramAIOLightVideoData));
    }
  }
  
  private void a(AIORichMediaInfo paramAIORichMediaInfo, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (this.c)
    {
      int i1 = paramAIORichMediaInfo.getSelected();
      if (i1 != 1)
      {
        if (i1 != 2)
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
            paramImageView2.setImageResource(2130847333);
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
          paramImageView2.setImageResource(2130841341);
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
    paramImageView = paramAIORichMediaInfo.c(1);
    String str;
    if (paramImageView != null)
    {
      paramAIORichMediaInfo = paramURLImageView.getDrawable();
      paramTextView = URLDrawable.URLDrawableOptions.obtain();
      int i1 = this.f;
      paramTextView.mRequestWidth = i1;
      paramTextView.mRequestHeight = i1;
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
      if (paramAIORichMediaInfo.e)
      {
        if (this.e == null) {
          this.e = BaseApplicationImpl.getApplication().getResources().getDrawable(2130838066);
        }
        paramURLImageView.setImageDrawable(this.e);
        return;
      }
      paramURLImageView.setImageDrawable(URLDrawableHelper.TRANSLUCENT);
      this.d.post(new AIOPhotoListAdapter.1(this, paramAIORichMediaInfo));
    }
  }
  
  public static int c(int paramInt)
  {
    int i1 = -1;
    if (paramInt != -1)
    {
      paramInt = Integer.valueOf(ChatActivityUtils.c(paramInt)).intValue();
      if (paramInt != 0)
      {
        if (paramInt != 3) {
          return -1;
        }
        return 2;
      }
      i1 = 1;
    }
    return i1;
  }
  
  public void a(int paramInt)
  {
    this.p = paramInt;
    this.q = c(this.p);
  }
  
  public void a(int paramInt, View paramView)
  {
    long l1 = SystemClock.uptimeMillis();
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
    URLImageView localURLImageView = localContentHolder.a;
    ImageView localImageView1 = localContentHolder.b;
    ImageView localImageView2 = localContentHolder.c;
    ImageView localImageView3 = localContentHolder.d;
    TextView localTextView1 = localContentHolder.e;
    TextView localTextView2 = localContentHolder.f;
    View localView = localContentHolder.g;
    localView.setVisibility(8);
    localTextView2.setVisibility(8);
    localURLImageView.setBackgroundColor(0);
    localObject2 = null;
    localObject1 = null;
    if (AIOImageData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localAIORichMediaInfo, localImageView3, localTextView1, localURLImageView);
      if (AppSetting.e) {
        localObject1 = HardCodeUtil.a(2131898375);
      }
    }
    else if (AIOShortVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localView, localAIORichMediaInfo, localImageView3, localTextView1, localURLImageView, localContentHolder);
      localObject1 = localObject2;
      if (AppSetting.e) {
        localObject1 = HardCodeUtil.a(2131898373);
      }
    }
    else if (AIOFilePicData.class.isInstance(localAIORichMediaInfo.a))
    {
      a(localImageView3, localTextView1, localAIORichMediaInfo, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.e) {
        localObject1 = HardCodeUtil.a(2131898369);
      }
    }
    else if (AIOFileVideoData.class.isInstance(localAIORichMediaInfo.a))
    {
      a((AIOFileVideoData)localAIORichMediaInfo.a, localImageView3, localTextView1, localView, localTextView2, localURLImageView);
      localObject1 = localObject2;
      if (AppSetting.e) {
        localObject1 = HardCodeUtil.a(2131898372);
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
        if (AppSetting.e) {
          localObject1 = HardCodeUtil.a(2131898370);
        }
      }
    }
    if (localObject1 != null)
    {
      int i1 = paramInt / 4;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898376));
      ((StringBuilder)localObject2).append(i1 + 1);
      ((StringBuilder)localObject2).append(HardCodeUtil.a(2131898377));
      ((StringBuilder)localObject2).append(paramInt % 4 + 1);
      ((StringBuilder)localObject2).append((String)localObject1);
      paramView.setContentDescription(((StringBuilder)localObject2).toString());
    }
    a(localAIORichMediaInfo, localImageView1, localImageView2);
    if (QLog.isColorLevel())
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] cost: ");
      paramView.append(SystemClock.uptimeMillis() - l1);
      paramView.append(" data");
      paramView.append(localAIORichMediaInfo.a);
      QLog.d("AIOPhotoListAdapter", 2, paramView.toString());
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.o) && (this.q != -1);
  }
  
  public boolean areAllItemsEnabled()
  {
    return false;
  }
  
  public void b()
  {
    AIOImageListModel localAIOImageListModel = this.j;
    if (localAIOImageListModel == null) {
      return;
    }
    if (localAIOImageListModel.g()) {
      notifyDataSetChanged();
    }
  }
  
  public void b(int paramInt)
  {
    this.n = paramInt;
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean != this.m)
    {
      this.m = paramBoolean;
      notifyDataSetChanged();
      return true;
    }
    return false;
  }
  
  public int getCount()
  {
    int i1 = this.j.m();
    int i2 = i1;
    if (this.m)
    {
      int i3 = i1 % 4;
      i2 = i1;
      if (i3 > 0) {
        i2 = i1 + (4 - i3);
      }
      i2 += 1;
    }
    return i2;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.m) {
      return this.j.h(paramInt);
    }
    if (paramInt < this.j.m()) {
      return this.j.h(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return a;
    }
    return AIOImageListModel.k;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    boolean bool = localObject instanceof AIORichMediaInfo;
    paramInt = 0;
    if (bool) {
      return 0;
    }
    if (AIOImageListModel.k.equals(localObject)) {
      return 1;
    }
    if ((localObject instanceof String)) {
      return 2;
    }
    if (AIOImageListModel.j.equals(localObject)) {
      return 3;
    }
    if (a.equals(localObject)) {
      paramInt = 4;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      localObject1 = null;
    } else {
      localObject1 = paramView.getTag();
    }
    Object localObject2;
    int i2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        Object localObject3;
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if ((i1 == 4) && (!a.equals(localObject1)))
            {
              paramView = new AIOPhotoListAdapter.FullWidthFixedViewLayout(this, this.i);
              localObject2 = this.g.inflate(2131627635, null);
              localObject3 = new FrameLayout.LayoutParams(-2, -2);
              ((FrameLayout.LayoutParams)localObject3).gravity = 17;
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              paramView.addView((View)localObject2);
              paramView.setTag(a);
            }
          }
          else if (!AIOImageListModel.j.equals(localObject1))
          {
            paramView = new View(this.i);
            paramView.setMinimumHeight(this.l);
            paramView.setVisibility(4);
            paramView.setTag(AIOImageListModel.j);
          }
        }
        else if (!AIOPhotoListAdapter.HeaderHolder.class.isInstance(localObject1))
        {
          localObject2 = this.g.inflate(2131627636, null);
          localObject1 = new AIOPhotoListAdapter.HeaderHolder(this);
          ((AIOPhotoListAdapter.HeaderHolder)localObject1).a = ((TextView)((View)localObject2).findViewById(2131447246));
          ((AIOPhotoListAdapter.HeaderHolder)localObject1).b = ((CheckBox)((View)localObject2).findViewById(2131436369));
          paramView = new AIOPhotoListAdapter.FullWidthFixedViewLayout(this, this.i);
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
      else if (!AIOImageListModel.k.equals(localObject1))
      {
        paramView = new View(this.i);
        i2 = this.f;
        paramView.setLayoutParams(new AbsListView.LayoutParams(i2, i2));
        paramView.setTag(AIOImageListModel.k);
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
      paramView = this.g.inflate(2131627647, null);
      i2 = this.f;
      paramView.setLayoutParams(new AbsListView.LayoutParams(i2, i2));
      localObject2 = new AIOPhotoListAdapter.ContentHolder(this);
      ((AIOPhotoListAdapter.ContentHolder)localObject2).a = ((URLImageView)paramView.findViewById(2131440193));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).a.setAdjustViewBounds(false);
      ((AIOPhotoListAdapter.ContentHolder)localObject2).b = ((ImageView)paramView.findViewById(2131436068));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).c = ((ImageView)paramView.findViewById(2131440198));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).d = ((ImageView)paramView.findViewById(2131440118));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).e = ((TextView)paramView.findViewById(2131449621));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).f = ((TextView)paramView.findViewById(2131433141));
      ((AIOPhotoListAdapter.ContentHolder)localObject2).g = paramView.findViewById(2131429678);
      paramView.setTag(localObject2);
    }
    a(i1, paramInt, paramView, localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter
 * JD-Core Version:    0.7.0.1
 */