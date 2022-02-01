import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategoryItem;
import com.tencent.mobileqq.richmedia.capture.view.CaptureCommonLoadingView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class bben
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List<FilterCategoryItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  int b;
  
  public bben(Context paramContext, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = "FilterProviderGridAdapter";
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(List<FilterCategoryItem> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if ((paramList != null) && (QLog.isColorLevel())) {
        QLog.d("CapturePtvTemplateManager", 2, "FilterProviderGridAdapter setData size = " + paramList.size());
      }
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)localIterator.next();
        if (!localFilterCategoryItem.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaUtilList.add(localFilterCategoryItem);
        }
      }
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilList.size()) {
      return null;
    }
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
      this.jdField_b_of_type_Int = ((int)((this.jdField_a_of_type_Int - FilterProviderPagerAdapter.jdField_b_of_type_Int * 3 - paramViewGroup.getPaddingLeft() - paramViewGroup.getPaddingRight()) / 4 + 0.5F));
    }
    View localView = paramView;
    if (paramView == null) {
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561120, paramViewGroup, false);
    }
    TextView localTextView = (TextView)localView.findViewById(2131366659);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131368606);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131368212);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131365141);
    URLImageView localURLImageView = (URLImageView)localView.findViewById(2131362234);
    CaptureCommonLoadingView localCaptureCommonLoadingView = (CaptureCommonLoadingView)localView.findViewById(2131366662);
    FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView = bbfg.a().a();
    boolean bool = false;
    if (paramView != null) {
      bool = TextUtils.equals(paramView.jdField_a_of_type_JavaLangString, localFilterCategoryItem.jdField_a_of_type_JavaLangString);
    }
    if (!bool) {
      if (((paramView == null) || (paramView.a())) && (localFilterCategoryItem.a())) {
        bool = true;
      }
    }
    for (;;)
    {
      localView.setTag(localFilterCategoryItem);
      AbsListView.LayoutParams localLayoutParams = (AbsListView.LayoutParams)localView.getLayoutParams();
      paramView = localLayoutParams;
      if (localLayoutParams == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        localView.setLayoutParams(paramView);
      }
      paramView.height = this.jdField_b_of_type_Int;
      if (localFilterCategoryItem.a())
      {
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845946));
        if (bool)
        {
          localImageView3.setVisibility(0);
          label300:
          localImageView2.setVisibility(8);
          localTextView.setText(anzj.a(2131703497));
          localImageView1.setContentDescription(anzj.a(2131703500));
          localTextView.setContentDescription(anzj.a(2131703501));
        }
      }
      for (;;)
      {
        EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
        return localView;
        bool = false;
        break;
        localImageView3.setVisibility(8);
        break label300;
        if (bool)
        {
          localImageView3.setVisibility(0);
          localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166942));
          label402:
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845942);
          paramView.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845942);
          localCaptureCommonLoadingView.setMax(10000);
          localCaptureCommonLoadingView.setVisibility(8);
          paramView = URLDrawable.getDrawable(localFilterCategoryItem.d, URLDrawable.URLDrawableOptions.obtain());
          paramView.startDownload();
          localImageView1.setImageDrawable(paramView);
          localTextView.setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          localImageView1.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          localTextView.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          if (!localFilterCategoryItem.jdField_a_of_type_Boolean) {
            break label678;
          }
          localImageView2.setVisibility(8);
          if (!bhsr.a(localFilterCategoryItem.j)) {
            break label610;
          }
          localURLImageView.setVisibility(8);
        }
        for (;;)
        {
          bdll.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 2, 0, "", "", localFilterCategoryItem.jdField_a_of_type_JavaLangString, "");
          break;
          localImageView3.setVisibility(8);
          localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166942));
          break label402;
          try
          {
            label610:
            localURLImageView.setVisibility(0);
            localURLImageView.setImageDrawable(URLDrawable.getDrawable(localFilterCategoryItem.j));
            paramView = localURLImageView.getLayoutParams();
            paramView.height = 42;
            paramView.width = 42;
            localURLImageView.setLayoutParams(paramView);
          }
          catch (Exception paramView)
          {
            QLog.e("PtvTemplateItemView", 1, "PtvTemplateItemView bindData mBadgeImg.setImageDrawable(URLDrawable.getDrawable(info.badgeurl)) catch an Exception.", paramView);
            localURLImageView.setVisibility(8);
          }
        }
        label678:
        bool = bbfg.a().a(3, localFilterCategoryItem.jdField_b_of_type_Int, localFilterCategoryItem.jdField_a_of_type_JavaLangString);
        if (bool)
        {
          localImageView2.setVisibility(0);
          if (bool) {
            localImageView2.setImageResource(2130845948);
          }
        }
        else
        {
          localImageView2.setVisibility(8);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bben
 * JD-Core Version:    0.7.0.1
 */