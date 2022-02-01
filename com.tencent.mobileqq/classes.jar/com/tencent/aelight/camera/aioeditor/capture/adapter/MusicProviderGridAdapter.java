package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.QimMusicPlayer;
import com.tencent.aelight.camera.aioeditor.capture.view.MusicProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.List;

public class MusicProviderGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  MusicProviderView jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView;
  List<MusicItemInfo> jdField_a_of_type_JavaUtilList;
  int b;
  
  public MusicProviderGridAdapter(Context paramContext, MusicProviderView paramMusicProviderView)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewMusicProviderView = paramMusicProviderView;
  }
  
  private void a(MusicProviderGridAdapter.ViewHolder paramViewHolder)
  {
    MusicItemInfo localMusicItemInfo2 = paramViewHolder.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo;
    int k = localMusicItemInfo2.mType;
    MusicItemInfo localMusicItemInfo1 = ((QimMusicPlayer)QIMManager.a().c(8)).b();
    Object localObject = localMusicItemInfo1;
    if (localMusicItemInfo1 == null) {
      localObject = ((QIMMusicConfigManager)QIMManager.a(2)).a(-1, -1);
    }
    boolean bool = localMusicItemInfo2.equals((MusicItemInfo)localObject);
    int i;
    if ((k != 1) && (k != 5))
    {
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.a(null);
      paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(8);
      paramViewHolder.d.setVisibility(8);
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      localObject = HardCodeUtil.a(2131707074);
      i = 2130844596;
      int j = 2130844593;
      if (k == 3)
      {
        localObject = HardCodeUtil.a(2131707071);
        i = 2130844594;
        j = 2130844595;
      }
      else if (k == 4)
      {
        localObject = HardCodeUtil.a(2131707069);
        i = 2130844589;
        j = 2130844590;
      }
      else if (k == 10)
      {
        localObject = HardCodeUtil.a(2131707075);
        paramViewHolder.d.setVisibility(0);
        i = 2130844597;
        j = 2130844597;
      }
      if (bool) {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(j);
      } else {
        paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(i);
      }
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    paramViewHolder.d.setVisibility(8);
    paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mMusicName);
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(localMusicItemInfo2.mSingername);
    if ((bool) && (!localMusicItemInfo2.isDownloading()))
    {
      i = 2130844576;
      if (localMusicItemInfo2.isMyMusicInfo())
      {
        i = 2130844592;
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131707068));
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      else
      {
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageResource(i);
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    else
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(0);
    localObject = QIMCommonLoadingProgress.a(localMusicItemInfo2);
    paramViewHolder.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.a((QIMCommonLoadingProgress)localObject);
    if ((localMusicItemInfo2.isDownloading()) && (((QIMCommonLoadingProgress)localObject).a == 2)) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    } else if (!localMusicItemInfo2.isFileExist()) {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    } else {
      paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    }
    a(paramViewHolder, localMusicItemInfo2);
  }
  
  public View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371628);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371629);
    ((TextView)localObject2).setPadding(((TextView)localObject2).getPaddingLeft(), ((TextView)localObject2).getPaddingTop(), ((TextView)localObject2).getPaddingRight(), ViewUtils.b(10.0F));
    ((TextView)localObject2).setMaxLines(4);
    ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setShadowLayer(4.0F, 0.0F, 2.0F, Color.parseColor("#80000000"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
    i = ViewUtils.b(5.0F);
    localLayoutParams.topMargin = ViewUtils.b(8.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.addRule(10, -1);
    localLayoutParams.addRule(9, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131371627);
    ((TextView)localObject2).setTextColor(Color.parseColor("#9fffffff"));
    ((TextView)localObject2).setTextSize(2, 9.0F);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(9, -1);
    i = ViewUtils.b(5.0F);
    localLayoutParams.leftMargin = i;
    localLayoutParams.rightMargin = i;
    localLayoutParams.bottomMargin = ViewUtils.b(4.0F);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131371630);
    ((ImageView)localObject2).setImageResource(2130844576);
    ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131374006);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(Color.parseColor("#ffffffff"));
    ((TextView)localObject2).setVisibility(8);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = ViewUtils.b(5.0F);
    localLayoutParams.addRule(12, -1);
    localLayoutParams.addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, localLayoutParams);
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131371646);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131371622);
    ((ImageView)localObject1).setVisibility(8);
    ((ImageView)localObject1).setImageResource(2130846131);
    i = ViewUtils.b(18.0F);
    localObject2 = new RelativeLayout.LayoutParams(i, i);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381214);
    ((ImageView)localObject1).setImageResource(2130846136);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(View paramView)
  {
    paramView = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    if (paramView != null) {
      a(paramView);
    }
  }
  
  public void a(MusicProviderGridAdapter.ViewHolder paramViewHolder, MusicItemInfo paramMusicItemInfo)
  {
    if (TextUtils.isEmpty(paramMusicItemInfo.mAlbumUrl))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130844591);
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    int i = AIOUtils.b(80.0F, paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.getResources());
    localURLDrawableOptions.mRequestWidth = i;
    localURLDrawableOptions.mRequestHeight = i;
    localURLDrawableOptions.mRetryCount = 3;
    localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844591);
    localURLDrawableOptions.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844591);
    paramMusicItemInfo = URLDrawable.getDrawable(paramMusicItemInfo.mAlbumUrl, localURLDrawableOptions);
    if (paramMusicItemInfo.getStatus() == 2) {
      paramMusicItemInfo.restartDownload();
    }
    paramMusicItemInfo.setDecodeHandler(URLDrawableDecodeHandler.u);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramMusicItemInfo);
  }
  
  public void a(List<MusicItemInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_Int <= 0) && (paramViewGroup != null))
    {
      this.jdField_a_of_type_Int = paramViewGroup.getMeasuredWidth();
      this.b = ((int)((this.jdField_a_of_type_Int - MusicProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    MusicItemInfo localMusicItemInfo = (MusicItemInfo)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new MusicProviderGridAdapter.ViewHolder(this);
      paramView = a();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371629));
      paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371627));
      paramViewGroup.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView = ((QIMCommonLoadingView)paramView.findViewById(2131371646));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371628));
      paramViewGroup.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374006));
      paramViewGroup.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371630));
      paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131371622));
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131381214));
      paramView.setTag(paramViewGroup);
    }
    else
    {
      paramViewGroup = (MusicProviderGridAdapter.ViewHolder)paramView.getTag();
    }
    paramViewGroup.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingView.setVisibility(0);
    paramViewGroup.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo = localMusicItemInfo;
    paramViewGroup.jdField_a_of_type_Int = paramInt;
    AbsListView.LayoutParams localLayoutParams2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
    AbsListView.LayoutParams localLayoutParams1 = localLayoutParams2;
    if (localLayoutParams2 == null)
    {
      localLayoutParams1 = new AbsListView.LayoutParams(-1, -1);
      paramView.setLayoutParams(localLayoutParams1);
    }
    localLayoutParams1.height = this.b;
    a(paramViewGroup);
    if (localMusicItemInfo.isWsBanner()) {
      WeishiGuideUtils.a(localMusicItemInfo);
    }
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.MusicProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */