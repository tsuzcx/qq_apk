import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.profile.view.VipPhotoViewForSimple;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;

public class awsd
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<awrw> jdField_a_of_type_JavaUtilList;
  
  public awsd(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<awrw> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple)) {
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
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    awrw localawrw = (awrw)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    View localView;
    if (paramView == null)
    {
      paramViewGroup = new awse(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561817, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      paramViewGroup.a = ((URLImageView)localView.findViewById(2131374117));
      localView.setTag(paramViewGroup);
      paramViewGroup.a.setTag(new awki(25, Integer.valueOf(paramInt)));
      paramViewGroup.a.setOnClickListener(VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
      paramView = (RelativeLayout.LayoutParams)paramViewGroup.a.getLayoutParams();
      if (localawrw != null)
      {
        if ((localawrw.d != 100) && (localawrw.d != 102)) {
          break label320;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label283;
        }
        localView.setBackground(null);
        label173:
        paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    for (;;)
    {
      try
      {
        paramView = localawrw.a();
        if (paramView == null) {
          break label376;
        }
        paramView = new URL("qzone_cover", "original", paramView);
      }
      catch (Exception localException)
      {
        label283:
        paramView = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.qzonecover.", 2, localException.toString());
        paramView = localObject;
        continue;
      }
      if (paramView != null) {
        paramViewGroup.a.setImageDrawable(URLDrawable.getDrawable(paramView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      }
      paramViewGroup.a.setContentDescription(alpo.a(2131717146) + (paramInt + 1));
      return localView;
      paramViewGroup = (awse)paramView.getTag();
      localView = paramView;
      break;
      localView.setBackgroundDrawable(null);
      break label173;
      label320:
      if (localException.d == 101)
      {
        paramViewGroup.a.setScaleType(ImageView.ScaleType.CENTER);
        awmr.a(paramViewGroup.a, "src", VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a, "simpleGridAddSrc");
        paramViewGroup.a.setContentDescription(alpo.a(2131717147));
        return localView;
        label376:
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awsd
 * JD-Core Version:    0.7.0.1
 */