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

public class baci
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<back> jdField_a_of_type_JavaUtilList;
  int b;
  
  public baci(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<back> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new back(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (back)this.jdField_a_of_type_JavaUtilList.get(i - 1);
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
    Object localObject = (back)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    bacj localbacj;
    String str2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str1;
    if (paramView == null)
    {
      localbacj = new bacj(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131562114, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      localbacj.a = ((URLImageView)paramView.findViewById(2131375032));
      localbacj.a.setTag(new azvr(25, Integer.valueOf(paramInt)));
      str2 = bhhz.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      str1 = ((back)localObject).a(this.jdField_a_of_type_Int);
      if (((back)localObject).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localbacj.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          localbacj.a.setContentDescription(anzj.a(2131711022) + (paramInt + 1));
        }
        localbacj.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        paramView.setTag(localbacj);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((back)localObject).d == 101)
      {
        azxy.a(localbacj.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        localbacj.a.setContentDescription(anzj.a(2131711016));
        break;
      }
      if (((back)localObject).d != 102) {
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new File(str2, "qvip_profile_photo_more.png");
        localbacj.a.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
      if (!TextUtils.isEmpty(str1)) {
        localbacj.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
      }
      localbacj.a.setContentDescription(anzj.a(2131711025));
      break;
      localObject = (bacj)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baci
 * JD-Core Version:    0.7.0.1
 */