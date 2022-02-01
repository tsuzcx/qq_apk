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

public class azjw
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<azjy> jdField_a_of_type_JavaUtilList;
  int b;
  
  public azjw(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<azjy> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new azjy(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (azjy)this.jdField_a_of_type_JavaUtilList.get(i - 1);
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
    Object localObject = (azjy)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    azjx localazjx;
    String str2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str1;
    if (paramView == null)
    {
      localazjx = new azjx(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131562074, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      localazjx.a = ((URLImageView)paramView.findViewById(2131374895));
      localazjx.a.setTag(new azde(25, Integer.valueOf(paramInt)));
      str2 = bghy.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      str1 = ((azjy)localObject).a(this.jdField_a_of_type_Int);
      if (((azjy)localObject).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localazjx.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          localazjx.a.setContentDescription(anni.a(2131710913) + (paramInt + 1));
        }
        localazjx.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        paramView.setTag(localazjx);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((azjy)localObject).d == 101)
      {
        azfl.a(localazjx.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        localazjx.a.setContentDescription(anni.a(2131710907));
        break;
      }
      if (((azjy)localObject).d != 102) {
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new File(str2, "qvip_profile_photo_more.png");
        localazjx.a.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
      if (!TextUtils.isEmpty(str1)) {
        localazjx.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
      }
      localazjx.a.setContentDescription(anni.a(2131710916));
      break;
      localObject = (azjx)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjw
 * JD-Core Version:    0.7.0.1
 */