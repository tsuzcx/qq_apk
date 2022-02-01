package com.tencent.aelight.camera.aioeditor.capture.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.VideoFilterTools;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.CaptureComboManager;
import com.tencent.aelight.camera.aioeditor.capture.data.FilterSet;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingProgress;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class FilterProviderGridAdapter
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  
  public FilterProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131368343);
    ((URLImageView)localObject2).setImageResource(2130844578);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131369017);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844574);
    ((RelativeLayout)localObject2).setVisibility(8);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.b(16.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844575), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.b(4.0F));
    ((TextView)localObject3).setText(HardCodeUtil.a(2131704707));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131366842);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167394));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    ((TextView)localObject2).setBackgroundResource(2130844577);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-1, ViewUtils.b(31.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131368744);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setImageResource(2130844576);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131366846);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131365257);
    ((ImageView)localObject1).setImageResource(2130846131);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
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
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!VideoFilterTools.a().c()) {
      VideoFilterTools.a(this.jdField_a_of_type_JavaUtilList);
    }
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
      this.b = ((int)((this.jdField_a_of_type_Int - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
      this.d = (this.b * 12 / 160);
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131366842);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131368744);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131368343);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131365257);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramViewGroup.findViewById(2131366846);
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView = VideoFilterTools.a().c(this.c);
    if (paramView != null) {
      bool1 = TextUtils.equals(paramView.jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if (((paramView == null) || (paramView.b())) && (localQIMFilterCategoryItem.b())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
    }
    paramViewGroup.setTag(localQIMFilterCategoryItem);
    Object localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
    paramView = (View)localObject;
    if (localObject == null)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramViewGroup.setLayoutParams(paramView);
    }
    paramView.height = this.b;
    if (localQIMFilterCategoryItem.b())
    {
      localImageView3.setVisibility(8);
      if (bool2)
      {
        localImageView3.setVisibility(0);
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844579));
      }
      else
      {
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844579));
      }
      localImageView2.setVisibility(8);
      localTextView.setText(HardCodeUtil.a(2131704708));
      return paramViewGroup;
    }
    paramView = ((CaptureComboManager)QIMManager.a(5)).a(localQIMFilterCategoryItem);
    if (bool2)
    {
      localImageView3.setVisibility(0);
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
    }
    else
    {
      localImageView3.setVisibility(8);
      localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167004));
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844573);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844573);
    localQIMCommonLoadingView.setMax(10000);
    if (paramView.jdField_a_of_type_Int == 1) {
      localQIMCommonLoadingView.setVisibility(0);
    } else {
      localQIMCommonLoadingView.setVisibility(8);
    }
    localObject = URLDrawable.getDrawable(localQIMFilterCategoryItem.d, (URLDrawable.URLDrawableOptions)localObject);
    if (((URLDrawable)localObject).getStatus() == 2) {
      ((URLDrawable)localObject).restartDownload();
    }
    localImageView1.setImageDrawable((Drawable)localObject);
    localTextView.setText(localQIMFilterCategoryItem.b);
    if (localQIMFilterCategoryItem.f())
    {
      localImageView2.setVisibility(8);
      paramView = (ImageView)paramViewGroup.findViewById(2131381214);
      paramView.setImageResource(2130846136);
      paramView.setVisibility(0);
      return paramViewGroup;
    }
    VideoFilterTools.a();
    boolean bool1 = VideoFilterTools.a(3, localQIMFilterCategoryItem.jdField_a_of_type_Int, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    paramInt = paramView.d();
    localQIMCommonLoadingView.setVisibility(0);
    localQIMCommonLoadingView.setBgCorner(this.d);
    localQIMCommonLoadingView.a(QIMCommonLoadingProgress.a(paramView));
    localImageView2.setVisibility(0);
    if (bool1)
    {
      localImageView2.setImageResource(2130846132);
      return paramViewGroup;
    }
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return paramViewGroup;
        }
      }
      else
      {
        localImageView2.setImageResource(2130846131);
        return paramViewGroup;
      }
    }
    localImageView2.setVisibility(8);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */