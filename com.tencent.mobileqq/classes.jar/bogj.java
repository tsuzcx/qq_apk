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
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.ArrayList;
import java.util.List;

public class bogj
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  
  public bogj(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = ViewUtils.dpToPx(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131368381);
    ((URLImageView)localObject2).setImageResource(2130844502);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131369056);
    ((RelativeLayout)localObject2).setBackgroundResource(2130844498);
    ((RelativeLayout)localObject2).setVisibility(8);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = ViewUtils.dpToPx(16.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844499), null);
    ((TextView)localObject3).setCompoundDrawablePadding(ViewUtils.dpToPx(4.0F));
    ((TextView)localObject3).setText(anvx.a(2131704079));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131366800);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167363));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    ((TextView)localObject2).setBackgroundResource(2130844501);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-1, ViewUtils.dpToPx(31.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131368790);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setImageResource(2130844500);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131366805);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131365253);
    ((ImageView)localObject1).setImageResource(2130845935);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131381546);
    ((ImageView)localObject1).setImageResource(2130845942);
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
    if (!bpjt.a().c()) {
      bpjt.a(this.jdField_a_of_type_JavaUtilList);
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
    if (paramView == null) {
      paramView = a();
    }
    for (;;)
    {
      TextView localTextView = (TextView)paramView.findViewById(2131366800);
      ImageView localImageView3 = (ImageView)paramView.findViewById(2131368790);
      ImageView localImageView1 = (ImageView)paramView.findViewById(2131368381);
      ImageView localImageView2 = (ImageView)paramView.findViewById(2131365253);
      QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramView.findViewById(2131366805);
      QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject1 = bpjt.a().c(this.c);
      boolean bool = false;
      if (localObject1 != null) {
        bool = TextUtils.equals(((QIMFilterCategoryItem)localObject1).jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
      }
      if (!bool) {
        if (((localObject1 == null) || (((QIMFilterCategoryItem)localObject1).c())) && (localQIMFilterCategoryItem.c())) {
          bool = true;
        }
      }
      for (;;)
      {
        paramView.setTag(localQIMFilterCategoryItem);
        Object localObject2 = (AbsListView.LayoutParams)paramView.getLayoutParams();
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new AbsListView.LayoutParams(-1, -1);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        }
        ((AbsListView.LayoutParams)localObject1).height = this.b;
        if (localQIMFilterCategoryItem.c())
        {
          localImageView3.setVisibility(8);
          if (bool)
          {
            localImageView3.setVisibility(0);
            localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844503));
            label302:
            localImageView2.setVisibility(8);
            localTextView.setText(anvx.a(2131704080));
          }
        }
        for (;;)
        {
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return paramView;
          bool = false;
          break;
          localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844503));
          break label302;
          localObject1 = ((bohj)bogd.a(5)).a(localQIMFilterCategoryItem);
          if (bool)
          {
            localImageView3.setVisibility(0);
            localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166975));
            label409:
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844497);
            ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130844497);
            localQIMCommonLoadingView.setMax(10000);
            if (((boic)localObject1).jdField_a_of_type_Int != 1) {
              break label599;
            }
            localQIMCommonLoadingView.setVisibility(0);
            label473:
            localObject2 = URLDrawable.getDrawable(localQIMFilterCategoryItem.d, (URLDrawable.URLDrawableOptions)localObject2);
            if (((URLDrawable)localObject2).getStatus() == 2) {
              ((URLDrawable)localObject2).restartDownload();
            }
            localImageView1.setImageDrawable((Drawable)localObject2);
            localTextView.setText(localQIMFilterCategoryItem.b);
            if (!localQIMFilterCategoryItem.f()) {
              break label619;
            }
            localImageView2.setVisibility(8);
            localObject1 = (ImageView)paramView.findViewById(2131381546);
            if (!localQIMFilterCategoryItem.a()) {
              break label609;
            }
            ((ImageView)localObject1).setImageResource(2130845929);
          }
          for (;;)
          {
            ((ImageView)localObject1).setVisibility(0);
            break;
            localImageView3.setVisibility(8);
            localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166975));
            break label409;
            label599:
            localQIMCommonLoadingView.setVisibility(8);
            break label473;
            label609:
            ((ImageView)localObject1).setImageResource(2130845942);
          }
          label619:
          bpjt.a();
          bool = bpjt.a(3, localQIMFilterCategoryItem.jdField_a_of_type_Int, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
          int i = ((boic)localObject1).d();
          localQIMCommonLoadingView.setVisibility(0);
          localQIMCommonLoadingView.setBgCorner(this.d);
          localQIMCommonLoadingView.a(boov.a(localObject1));
          localImageView2.setVisibility(0);
          if (bool) {
            localImageView2.setImageResource(2130845936);
          } else {
            switch (i)
            {
            default: 
              break;
            case 1: 
            case 3: 
              localImageView2.setVisibility(8);
              break;
            case 2: 
              localImageView2.setImageResource(2130845935);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bogj
 * JD-Core Version:    0.7.0.1
 */