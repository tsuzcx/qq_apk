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

public class azvs
  extends BaseAdapter
{
  int jdField_a_of_type_Int;
  List<azvu> jdField_a_of_type_JavaUtilList;
  int b;
  
  public azvs(QzonePhotoView paramQzonePhotoView) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public void a(List<azvu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView)) {
        this.jdField_a_of_type_JavaUtilList.add(new azvu(paramList.size(), 101, null));
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      paramList = (azvu)this.jdField_a_of_type_JavaUtilList.get(i - 1);
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
    Object localObject = (azvu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    azvt localazvt;
    String str2;
    URLDrawable.URLDrawableOptions localURLDrawableOptions;
    String str1;
    if (paramView == null)
    {
      localazvt = new azvt(this);
      paramView = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.getContext()).inflate(2131562054, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int));
      localazvt.a = ((URLImageView)paramView.findViewById(2131375038));
      localazvt.a.setTag(new azpb(25, Integer.valueOf(paramInt)));
      str2 = bhaa.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView.a, -1L);
      localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestHeight = this.b;
      localURLDrawableOptions.mRequestWidth = this.jdField_a_of_type_Int;
      str1 = ((azvu)localObject).a(this.jdField_a_of_type_Int);
      if (((azvu)localObject).d == 100)
      {
        if (!TextUtils.isEmpty(str1))
        {
          localazvt.a.setImageDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
          localazvt.a.setContentDescription(anvx.a(2131711601) + (paramInt + 1));
        }
        localazvt.a.setOnClickListener(QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView));
        paramView.setTag(localazvt);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      if (((azvu)localObject).d == 101)
      {
        azri.a(localazvt.a, "src", QzonePhotoView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewQzonePhotoView).a, "photoAddSrc");
        localazvt.a.setContentDescription(anvx.a(2131711595));
        break;
      }
      if (((azvu)localObject).d != 102) {
        break;
      }
      if (!TextUtils.isEmpty(str2))
      {
        localObject = new File(str2, "qvip_profile_photo_more.png");
        localazvt.a.setImageDrawable(URLDrawable.getDrawable((File)localObject, localURLDrawableOptions));
      }
      if (!TextUtils.isEmpty(str1)) {
        localazvt.a.setBackgroundDrawable(URLDrawable.getDrawable(str1, localURLDrawableOptions));
      }
      localazvt.a.setContentDescription(anvx.a(2131711604));
      break;
      localObject = (azvt)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvs
 * JD-Core Version:    0.7.0.1
 */