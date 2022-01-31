import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class asft
  extends BaseAdapter
{
  int jdField_a_of_type_Int = -1;
  SparseArray<URLDrawable> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private List<String> jdField_a_of_type_JavaUtilList;
  
  public asft(List<String> paramList)
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
    if (paramView != null) {
      return paramView;
    }
    String str = a(a(paramInt));
    URLDrawable localURLDrawable = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("BigImageAdapter", 2, "getView position=" + paramInt + ",cache=" + localURLDrawable + ",url=" + str);
    }
    paramView = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
    if ((localURLDrawable != null) && (localURLDrawable.getStatus() == 1)) {
      paramView.setImageDrawable(localURLDrawable);
    }
    for (;;)
    {
      paramView.setContentDescription(alpo.a(2131708521) + paramInt);
      return paramView;
      if (!TextUtils.isEmpty(str))
      {
        int i = paramViewGroup.getWidth();
        int j = paramViewGroup.getHeight();
        paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
        paramViewGroup.mRequestWidth = i;
        paramViewGroup.mRequestHeight = j;
        paramViewGroup.mLoadingDrawable = baul.a;
        paramViewGroup = URLDrawable.getDrawable(str, paramViewGroup);
        switch (paramViewGroup.getStatus())
        {
        default: 
          paramViewGroup.setTag(Integer.valueOf(1));
          paramViewGroup.startDownload();
        }
        if (QLog.isColorLevel()) {
          QLog.d("BigImageAdapter", 2, "getView position=" + paramInt + ",parentWidth=" + i + ",parentHeight=" + j);
        }
        paramView.setImageDrawable(paramViewGroup);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asft
 * JD-Core Version:    0.7.0.1
 */