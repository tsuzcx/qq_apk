import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.nearby.interestTag.InterestTagInfo;
import java.util.ArrayList;
import java.util.List;

public class atun
  extends BaseAdapter
{
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  Context jdField_a_of_type_AndroidContentContext;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  List<InterestTagInfo> jdField_a_of_type_JavaUtilList;
  int b;
  int c;
  int d;
  int e;
  int f;
  
  public atun(Context paramContext, Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    int i = this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131298658);
    this.d = paramInt1;
    this.c = (i + paramInt2);
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.f = 0;
    this.e = paramInt3;
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    if ((paramInt > 0) && (this.f == 0)) {
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        this.jdField_a_of_type_JavaUtilList.add(0, null);
        this.jdField_a_of_type_JavaUtilList.add(null);
      }
    }
    for (;;)
    {
      this.f = paramInt;
      notifyDataSetChanged();
      return;
      if ((paramInt == 0) && (this.f > 0) && (this.jdField_a_of_type_JavaUtilList.size() > 2))
      {
        this.jdField_a_of_type_JavaUtilList.remove(0);
        this.jdField_a_of_type_JavaUtilList.remove(this.jdField_a_of_type_JavaUtilList.size() - 1);
      }
    }
  }
  
  public void a(List<InterestTagInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (paramList.size() > 0)) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    if ((this.jdField_a_of_type_JavaUtilList.size() > 0) && (this.f > 0))
    {
      this.jdField_a_of_type_JavaUtilList.add(0, null);
      this.jdField_a_of_type_JavaUtilList.add(null);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public long getItemId(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
        localObject1 = (InterestTagInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      }
    }
    if (localObject1 == null) {
      return 0L;
    }
    return ((InterestTagInfo)localObject1).tagId;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((InterestTagInfo)getItem(paramInt) != null) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    atuo localatuo;
    Object localObject;
    if (i == 0)
    {
      InterestTagInfo localInterestTagInfo = (InterestTagInfo)getItem(paramInt);
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560903, null);
        localatuo = new atuo();
        localatuo.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramViewGroup.findViewById(2131367906));
        localatuo.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131377350));
        paramViewGroup.setTag(localatuo);
        paramViewGroup.setLayoutParams(new ViewGroup.LayoutParams(this.d, this.c));
      }
      for (;;)
      {
        localObject = paramViewGroup;
        if (localInterestTagInfo != null)
        {
          localObject = paramViewGroup;
          if (localatuo != null)
          {
            paramView = localInterestTagInfo.tagIconUrl;
            if ((paramView == null) || (!paramView.equals("icon_more_url"))) {
              break;
            }
            localatuo.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840979);
            if ((localInterestTagInfo.tagType == 10) || (localInterestTagInfo.tagType == 11) || (localInterestTagInfo.tagType == 9)) {
              localatuo.jdField_a_of_type_ComTencentImageURLImageView.setImageResource(2130840980);
            }
            localatuo.jdField_a_of_type_AndroidWidgetTextView.setText(localInterestTagInfo.tagName);
            localObject = paramViewGroup;
          }
        }
        label203:
        return localObject;
        localatuo = (atuo)paramView.getTag();
        paramViewGroup = paramView;
      }
    }
    for (;;)
    {
      try
      {
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = this.b;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = this.jdField_a_of_type_Int;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "nearbyCard";
        if (TextUtils.isEmpty(paramView)) {
          break label455;
        }
        paramView = URLDrawable.getDrawable(aysr.a(paramView), (URLDrawable.URLDrawableOptions)localObject);
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            if (this.e == 7)
            {
              paramView.setTag(bavi.b(this.jdField_a_of_type_Int, this.b, (int)(10.0F * this.jdField_a_of_type_Float)));
              paramView.setDecodeHandler(bavi.c);
            }
            paramView.setDownloadListener(new asyw(this.jdField_a_of_type_AndroidContentContext, "actInterestTagPicDownload"));
          }
          catch (Exception localException2)
          {
            URLImageView localURLImageView;
            View localView;
            continue;
          }
          try
          {
            ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
            ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
            localURLImageView = localatuo.jdField_a_of_type_ComTencentImageURLImageView;
            localObject = paramView;
            if (paramView == null) {
              localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
            }
            localURLImageView.setImageDrawable((Drawable)localObject);
          }
          catch (Exception localException3) {}
        }
        localException1 = localException1;
        paramView = null;
      }
      localException1.printStackTrace();
      continue;
      localView = paramView;
      if (i != 1) {
        break label203;
      }
      localView = paramView;
      if (paramView != null) {
        break label203;
      }
      paramView = new View(this.jdField_a_of_type_AndroidContentContext);
      paramView.setLayoutParams(new ViewGroup.LayoutParams(this.f, this.c));
      return paramView;
      label455:
      paramView = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atun
 * JD-Core Version:    0.7.0.1
 */