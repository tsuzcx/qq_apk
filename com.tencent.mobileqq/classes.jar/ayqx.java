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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.util.List;

public class ayqx
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<ayqz> jdField_a_of_type_JavaUtilList;
  int b;
  
  public ayqx(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<ayqz> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new ayqz(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (ayqz)this.jdField_a_of_type_JavaUtilList.get(i - 1);
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
    Object localObject = (ayqz)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    ayqy localayqy;
    String str2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str1;
    if (paramView == null)
    {
      localayqy = new ayqy(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131561989, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      localayqy.a = ((URLImageView)paramView.findViewById(2131374797));
      localayqy.a.setTag(new aykg(25, Integer.valueOf(paramInt)));
      str2 = bfrj.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      str1 = ((ayqz)localObject).a(this.jdField_a_of_type_Int);
      if (((ayqz)localObject).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localayqy.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          localayqy.a.setContentDescription(amtj.a(2131711254) + (paramInt + 1));
        }
        localayqy.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        paramView.setTag(localayqy);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((ayqz)localObject).d == 101)
      {
        aymn.a(localayqy.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        localayqy.a.setContentDescription(amtj.a(2131711248));
        break;
      }
      if (((ayqz)localObject).d != 102) {
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new File(str2, "qvip_profile_photo_more.png");
        localayqy.a.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
      if (!TextUtils.isEmpty(str1)) {
        localayqy.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
      }
      localayqy.a.setContentDescription(amtj.a(2131711257));
      break;
      localObject = (ayqy)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayqx
 * JD-Core Version:    0.7.0.1
 */