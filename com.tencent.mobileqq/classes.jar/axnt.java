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
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class axnt
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  public String a;
  List<FilterCategoryItem> jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
  boolean jdField_a_of_type_Boolean = true;
  int b;
  
  public axnt(Context paramContext, boolean paramBoolean)
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
      localView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560878, paramViewGroup, false);
    }
    TextView localTextView = (TextView)localView.findViewById(2131366358);
    ImageView localImageView3 = (ImageView)localView.findViewById(2131368206);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131367819);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131364862);
    URLImageView localURLImageView = (URLImageView)localView.findViewById(2131362153);
    CaptureCommonLoadingView localCaptureCommonLoadingView = (CaptureCommonLoadingView)localView.findViewById(2131366361);
    FilterCategoryItem localFilterCategoryItem = (FilterCategoryItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    paramView = axom.a().a();
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
      paramViewGroup = (AbsListView.LayoutParams)localView.getLayoutParams();
      paramView = paramViewGroup;
      if (paramViewGroup == null)
      {
        paramView = new AbsListView.LayoutParams(-1, -1);
        localView.setLayoutParams(paramView);
      }
      paramView.height = this.jdField_b_of_type_Int;
      if (localFilterCategoryItem.a())
      {
        localImageView1.setImageDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845533));
        if (bool)
        {
          localImageView3.setVisibility(0);
          label297:
          localImageView2.setVisibility(8);
          localTextView.setText(alud.a(2131704994));
          localImageView1.setContentDescription(alud.a(2131704997));
          localTextView.setContentDescription(alud.a(2131704998));
        }
      }
      label590:
      do
      {
        return localView;
        bool = false;
        break;
        localImageView3.setVisibility(8);
        break label297;
        if (bool)
        {
          localImageView3.setVisibility(0);
          localTextView.setShadowLayer(0.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166856));
          paramView = URLDrawable.URLDrawableOptions.obtain();
          paramView.mLoadingDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845529);
          paramView.mFailedDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845529);
          localCaptureCommonLoadingView.setMax(10000);
          localCaptureCommonLoadingView.setVisibility(8);
          paramView = URLDrawable.getDrawable(localFilterCategoryItem.d, URLDrawable.URLDrawableOptions.obtain());
          paramView.startDownload();
          localImageView1.setImageDrawable(paramView);
          localTextView.setText(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          localImageView1.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          localTextView.setContentDescription(localFilterCategoryItem.jdField_b_of_type_JavaLangString);
          if (!localFilterCategoryItem.jdField_a_of_type_Boolean) {
            break label658;
          }
          localImageView2.setVisibility(8);
          if (!bdnn.a(localFilterCategoryItem.j)) {
            break label590;
          }
          localURLImageView.setVisibility(8);
        }
        for (;;)
        {
          azqs.b(null, "dc00898", "", "", "0X800859E", "0X800859E", 2, 0, "", "", localFilterCategoryItem.jdField_a_of_type_JavaLangString, "");
          return localView;
          localImageView3.setVisibility(8);
          localTextView.setShadowLayer(3.0F, 0.0F, 0.0F, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166856));
          break;
          try
          {
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
        bool = axom.a().a(3, localFilterCategoryItem.jdField_b_of_type_Int, localFilterCategoryItem.jdField_a_of_type_JavaLangString);
        if (!bool) {
          break label704;
        }
        localImageView2.setVisibility(0);
      } while (!bool);
      label658:
      localImageView2.setImageResource(2130845535);
      return localView;
      label704:
      localImageView2.setVisibility(8);
      return localView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axnt
 * JD-Core Version:    0.7.0.1
 */