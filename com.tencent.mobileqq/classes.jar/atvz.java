import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class atvz
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public atvz(List<String> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (paramInt >= 0)) {
      return (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    do
    {
      return str;
      if (paramString.startsWith("//")) {
        return "file:/" + paramString;
      }
      str = paramString;
    } while (!paramString.startsWith("/"));
    return "file://" + paramString;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView != null)
    {
      localObject1 = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject1;
    }
    Object localObject2 = a(a(paramInt));
    Object localObject3 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("BigImageAdapter", 2, "getView position=" + paramInt + ",cache=" + localObject3 + ",url=" + (String)localObject2);
    }
    Object localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1)) {
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      ((ImageView)localObject1).setContentDescription(amtj.a(2131707251) + paramInt);
      break;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject3).mRequestHeight = j;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
        localObject2 = URLDrawable.getDrawable((String)localObject2, (URLDrawable.URLDrawableOptions)localObject3);
        switch (((URLDrawable)localObject2).getStatus())
        {
        default: 
          ((URLDrawable)localObject2).setTag(Integer.valueOf(1));
          ((URLDrawable)localObject2).startDownload();
        }
        if (QLog.isColorLevel()) {
          QLog.d("BigImageAdapter", 2, "getView position=" + paramInt + ",parentWidth=" + i + ",parentHeight=" + j);
        }
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atvz
 * JD-Core Version:    0.7.0.1
 */