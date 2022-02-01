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
  List<QIMFilterCategoryItem> a = new ArrayList();
  int b;
  int c;
  int d;
  int e;
  private Context f;
  
  public FilterProviderGridAdapter(Context paramContext, int paramInt)
  {
    this.f = paramContext;
    this.d = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.f);
    Object localObject1 = new RelativeLayout(this.f);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.f);
    ((URLImageView)localObject2).setId(2131435219);
    ((URLImageView)localObject2).setImageResource(2130845951);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new RelativeLayout(this.f);
    ((RelativeLayout)localObject2).setId(2131435977);
    ((RelativeLayout)localObject2).setBackgroundResource(2130845947);
    ((RelativeLayout)localObject2).setVisibility(8);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.dpToPx(16.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.f);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.f.getResources().getDrawable(2130845948), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    ((TextView)localObject3).setText(HardCodeUtil.a(2131902610));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.f.getResources().getColor(2131168464));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(this.f);
    ((TextView)localObject2).setId(2131433168);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.f.getResources().getColor(2131168464));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    ((TextView)localObject2).setBackgroundResource(2130845950);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(31.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.f);
    ((ImageView)localObject2).setId(2131435657);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setImageResource(2130845949);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new QIMCommonLoadingView(this.f);
    ((QIMCommonLoadingView)localObject2).setId(2131433172);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.f);
    ((ImageView)localObject1).setId(2131431428);
    ((ImageView)localObject1).setImageResource(2130847601);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.f);
    ((ImageView)localObject1).setId(2131450262);
    ((ImageView)localObject1).setImageResource(2130847606);
    ((ImageView)localObject1).setVisibility(8);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    return localRelativeLayout;
  }
  
  public void a(List<QIMFilterCategoryItem> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    if (!VideoFilterTools.a().k()) {
      VideoFilterTools.b(this.a);
    }
  }
  
  public int getCount()
  {
    return this.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.a.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.b <= 0) && (paramViewGroup != null))
    {
      this.b = paramViewGroup.getMeasuredWidth();
      this.c = ((int)((this.b - FilterProviderPagerAdapter.b * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
      this.e = (this.c * 12 / 160);
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = a();
    }
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131433168);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131435657);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131435219);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131431428);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramViewGroup.findViewById(2131433172);
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.a.get(paramInt);
    paramView = VideoFilterTools.a().c(this.d);
    if (paramView != null) {
      bool1 = TextUtils.equals(paramView.a, localQIMFilterCategoryItem.a);
    } else {
      bool1 = false;
    }
    boolean bool2 = bool1;
    if (!bool1) {
      if (((paramView == null) || (paramView.c())) && (localQIMFilterCategoryItem.c())) {
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
    paramView.height = this.c;
    if (localQIMFilterCategoryItem.c())
    {
      localImageView3.setVisibility(8);
      if (bool2)
      {
        localImageView3.setVisibility(0);
        localImageView1.setImageDrawable(this.f.getResources().getDrawable(2130845952));
      }
      else
      {
        localImageView1.setImageDrawable(this.f.getResources().getDrawable(2130845952));
      }
      localImageView2.setVisibility(8);
      localTextView.setText(HardCodeUtil.a(2131902611));
      return paramViewGroup;
    }
    paramView = ((CaptureComboManager)QIMManager.a(5)).b(localQIMFilterCategoryItem);
    if (bool2)
    {
      localImageView3.setVisibility(0);
      localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.f.getResources().getColor(2131167939));
    }
    else
    {
      localImageView3.setVisibility(8);
      localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.f.getResources().getColor(2131167939));
    }
    localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.f.getResources().getDrawable(2130845946);
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.f.getResources().getDrawable(2130845946);
    localQIMCommonLoadingView.setMax(10000);
    if (paramView.b == 1) {
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
    if (localQIMFilterCategoryItem.g())
    {
      localImageView2.setVisibility(8);
      paramView = (ImageView)paramViewGroup.findViewById(2131450262);
      paramView.setImageResource(2130847606);
      paramView.setVisibility(0);
      return paramViewGroup;
    }
    VideoFilterTools.a();
    boolean bool1 = VideoFilterTools.a(3, localQIMFilterCategoryItem.e, localQIMFilterCategoryItem.a);
    paramInt = paramView.j();
    localQIMCommonLoadingView.setVisibility(0);
    localQIMCommonLoadingView.setBgCorner(this.e);
    localQIMCommonLoadingView.a(QIMCommonLoadingProgress.a(paramView));
    localImageView2.setVisibility(0);
    if (bool1)
    {
      localImageView2.setImageResource(2130847602);
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
        localImageView2.setImageResource(2130847601);
        return paramViewGroup;
      }
    }
    localImageView2.setVisibility(8);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.adapter.FilterProviderGridAdapter
 * JD-Core Version:    0.7.0.1
 */