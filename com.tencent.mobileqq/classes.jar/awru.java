import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.view.QzonePhotoView;
import java.io.File;
import java.util.List;

public class awru
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<awrw> jdField_a_of_type_JavaUtilList;
  int b;
  
  public awru(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<awrw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new awrw(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (awrw)this.jdField_a_of_type_JavaUtilList.get(i - 1);
      paramList.d = 102;
      this.jdField_a_of_type_JavaUtilList.set(i - 1, paramList);
    }
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
    paramViewGroup = (awrw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (paramView == null)
    {
      paramView = new awrv(this);
      RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131561817, null);
      localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      paramView.a = ((URLImageView)localRelativeLayout.findViewById(2131374117));
      paramView.a.setTag(new awki(25, Integer.valueOf(paramInt)));
      String str2 = bcyw.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      String str1 = paramViewGroup.a(this.jdField_a_of_type_Int);
      if (paramViewGroup.d == 100) {
        if (!TextUtils.isEmpty(str1))
        {
          paramView.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          paramView.a.setContentDescription(alpo.a(2131712522) + (paramInt + 1));
        }
      }
      for (;;)
      {
        paramView.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        localRelativeLayout.setTag(paramView);
        return localRelativeLayout;
        if (paramViewGroup.d == 101)
        {
          awmr.a(paramView.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
          paramView.a.setContentDescription(alpo.a(2131712516));
        }
        else if (paramViewGroup.d == 102)
        {
          if (!TextUtils.isEmpty(str2))
          {
            paramViewGroup = new File(str2, "qvip_profile_photo_more.png");
            paramView.a.setImageDrawable(URLDrawable.getDrawable(paramViewGroup, localURLDrawableOptions));
          }
          if (!TextUtils.isEmpty(str1)) {
            paramView.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          }
          paramView.a.setContentDescription(alpo.a(2131712525));
        }
      }
    }
    paramViewGroup = (awrv)paramView.getTag();
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awru
 * JD-Core Version:    0.7.0.1
 */