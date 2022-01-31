import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import java.net.URL;
import java.util.List;

public class ardr
  extends BaseAdapter
  implements aikc
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<argc> jdField_a_of_type_JavaUtilList;
  private Drawable b;
  
  public ardr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850063);
    this.b = paramContext.getResources().getDrawable(2130839228);
  }
  
  private void a(View paramView, URLDrawable paramURLDrawable, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 4: 
    case 5: 
    case 7: 
    default: 
      paramInt = 0;
      if (paramURLDrawable.isAnim()) {
        break;
      }
    }
    for (;;)
    {
      paramView.setTag(2131296390, Boolean.valueOf(bool));
      if (bool) {
        paramView.setTag(2131296389, Integer.valueOf(paramInt));
      }
      return;
      paramInt = 1;
      break;
      paramInt = 2;
      break;
      paramInt = 3;
      break;
      bool = false;
    }
  }
  
  public void a(List<argc> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    argc localargc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560680, null);
      paramViewGroup = new ardt(this, null);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131367910));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377844));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131372321));
      paramView.setTag(paramViewGroup);
      localargc = (argc)getItem(paramInt);
      if (localargc != null) {
        break label111;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    label111:
    do
    {
      return paramView;
      paramViewGroup = (ardt)paramView.getTag();
      break;
      URL localURL = localargc.a();
      int i = localargc.a();
      if (localURL != null)
      {
        Object localObject = this.b;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        localURLDrawableOptions.mPlayGifImage = true;
        localURLDrawableOptions.mUseExifOrientation = false;
        localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        if (localargc.a()) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        }
        for (;;)
        {
          a(paramView, (URLDrawable)localObject, localargc.b());
          if ((i != 1) || (!AsyncImageView.a(localURL)) || (!arof.a(localargc.b()))) {
            break;
          }
          ((URLDrawable)localObject).setTag(Integer.valueOf(1));
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
          return paramView;
          paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
        }
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        return paramView;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    } while (localargc.b());
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramView.setTag(2131296386, Float.valueOf(1.0F));
    return paramView;
  }
  
  public View onCreateView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    return null;
  }
  
  public void onDestroyView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
  }
  
  public void onShowAreaChanged(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      paramView.updateRegionBitmap(paramRegionDrawableData);
    }
  }
  
  public void onSlot(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
  public void onViewDetached(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean) {}
  
  public void onscaleBegin(int paramInt, View paramView, ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ardr
 * JD-Core Version:    0.7.0.1
 */