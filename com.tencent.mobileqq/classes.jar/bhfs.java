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
import com.tencent.widget.AbsListView.LayoutParams;
import dov.com.qq.im.capture.adapter.FilterProviderPagerAdapter;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.util.ArrayList;
import java.util.List;

public class bhfs
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  List<QIMFilterCategoryItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  int b;
  int c;
  int d;
  
  public bhfs(Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.c = paramInt;
  }
  
  private View a()
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    int i = bajq.b(5.0F);
    ((RelativeLayout.LayoutParams)localObject2).setMargins(i, i, i, i);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new URLImageView(this.jdField_a_of_type_AndroidContentContext);
    ((URLImageView)localObject2).setId(2131302061);
    ((URLImageView)localObject2).setImageResource(2130843643);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
    ((RelativeLayout)localObject2).setId(2131302707);
    ((RelativeLayout)localObject2).setBackgroundResource(2130843639);
    ((RelativeLayout)localObject2).setVisibility(8);
    Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject3).topMargin = bajq.b(16.0F);
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject3).setCompoundDrawables(null, null, this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843640), null);
    ((TextView)localObject3).setCompoundDrawablePadding(bajq.b(4.0F));
    ((TextView)localObject3).setText(ajjy.a(2131638815));
    ((TextView)localObject3).setTextSize(2, 12.0F);
    ((TextView)localObject3).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(13, -1);
    ((RelativeLayout)localObject2).addView((View)localObject3, localLayoutParams);
    localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
    ((TextView)localObject2).setId(2131300663);
    ((TextView)localObject2).setTextSize(2, 12.0F);
    ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101537));
    ((TextView)localObject2).setMaxLines(1);
    ((TextView)localObject2).setLines(1);
    ((TextView)localObject2).setShadowLayer(3.0F, 0.0F, 0.0F, Color.parseColor("#7F000000"));
    ((TextView)localObject2).setBackgroundResource(2130843642);
    ((TextView)localObject2).setGravity(17);
    localObject3 = new RelativeLayout.LayoutParams(-1, bajq.b(31.0F));
    ((RelativeLayout.LayoutParams)localObject3).addRule(14, -1);
    ((RelativeLayout.LayoutParams)localObject3).addRule(12, -1);
    ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject2).setId(2131302437);
    ((ImageView)localObject2).setVisibility(8);
    ((ImageView)localObject2).setImageResource(2130843641);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject2 = new QIMCommonLoadingView(this.jdField_a_of_type_AndroidContentContext);
    ((QIMCommonLoadingView)localObject2).setId(2131300666);
    ((QIMCommonLoadingView)localObject2).setVisibility(8);
    ((RelativeLayout)localObject1).addView((View)localObject2, new RelativeLayout.LayoutParams(-1, -1));
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131299217);
    ((ImageView)localObject1).setImageResource(2130845012);
    localObject2 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10, -1);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setId(2131313680);
    ((ImageView)localObject1).setImageResource(2130845019);
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
    if (!bjac.a().c()) {
      bjac.a(this.jdField_a_of_type_JavaUtilList);
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
    TextView localTextView = (TextView)paramViewGroup.findViewById(2131300663);
    ImageView localImageView3 = (ImageView)paramViewGroup.findViewById(2131302437);
    ImageView localImageView1 = (ImageView)paramViewGroup.findViewById(2131302061);
    ImageView localImageView2 = (ImageView)paramViewGroup.findViewById(2131299217);
    QIMCommonLoadingView localQIMCommonLoadingView = (QIMCommonLoadingView)paramViewGroup.findViewById(2131300666);
    QIMFilterCategoryItem localQIMFilterCategoryItem = (QIMFilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView = bjac.a().c(this.c);
    boolean bool = false;
    if (paramView != null) {
      bool = TextUtils.equals(paramView.jdField_a_of_type_JavaLangString, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
    if (!bool) {
      if (((paramView == null) || (paramView.c())) && (localQIMFilterCategoryItem.c())) {
        bool = true;
      }
    }
    for (;;)
    {
      paramViewGroup.setTag(localQIMFilterCategoryItem);
      Object localObject = (AbsListView.LayoutParams)paramViewGroup.getLayoutParams();
      paramView = (View)localObject;
      if (localObject == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        paramViewGroup.setLayoutParams(paramView);
      }
      paramView.height = this.b;
      if (localQIMFilterCategoryItem.c())
      {
        localImageView3.setVisibility(8);
        if (bool) {
          localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843643));
        }
        for (;;)
        {
          localImageView2.setVisibility(8);
          localTextView.setText(ajjy.a(2131638816));
          return paramViewGroup;
          bool = false;
          break;
          localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843644));
        }
      }
      paramView = ((bhgs)bhfm.a(5)).a(localQIMFilterCategoryItem);
      if (bool)
      {
        localImageView3.setVisibility(0);
        localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101213));
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843638);
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130843638);
        localQIMCommonLoadingView.setMax(10000);
        if (paramView.jdField_a_of_type_Int != 1) {
          break label565;
        }
        localQIMCommonLoadingView.setVisibility(0);
        label443:
        localObject = URLDrawable.getDrawable(localQIMFilterCategoryItem.d, (URLDrawable.URLDrawableOptions)localObject);
        if (((URLDrawable)localObject).getStatus() == 2) {
          ((URLDrawable)localObject).restartDownload();
        }
        localImageView1.setImageDrawable((Drawable)localObject);
        localTextView.setText(localQIMFilterCategoryItem.b);
        if (!localQIMFilterCategoryItem.f()) {
          break label584;
        }
        localImageView2.setVisibility(8);
        paramView = (ImageView)paramViewGroup.findViewById(2131313680);
        if (!localQIMFilterCategoryItem.a()) {
          break label575;
        }
        paramView.setImageResource(2130845004);
      }
      for (;;)
      {
        paramView.setVisibility(0);
        return paramViewGroup;
        localImageView3.setVisibility(8);
        localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131101213));
        break;
        label565:
        localQIMCommonLoadingView.setVisibility(8);
        break label443;
        label575:
        paramView.setImageResource(2130845019);
      }
      label584:
      bjac.a();
      bool = bjac.a(3, localQIMFilterCategoryItem.jdField_a_of_type_Int, localQIMFilterCategoryItem.jdField_a_of_type_JavaLangString);
      paramInt = paramView.d();
      localQIMCommonLoadingView.setVisibility(0);
      localQIMCommonLoadingView.setBgCorner(this.d);
      localQIMCommonLoadingView.a(bhpu.a(paramView));
      localImageView2.setVisibility(0);
      if (bool)
      {
        localImageView2.setImageResource(2130845013);
        return paramViewGroup;
      }
      switch (paramInt)
      {
      default: 
        return paramViewGroup;
      case 1: 
      case 3: 
        localImageView2.setVisibility(8);
        return paramViewGroup;
      }
      localImageView2.setImageResource(2130845012);
      return paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhfs
 * JD-Core Version:    0.7.0.1
 */