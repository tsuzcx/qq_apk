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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.List;

public class azwb
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  List<azvu> jdField_a_of_type_JavaUtilList;
  
  public azwb(VipPhotoViewForSimple paramVipPhotoViewForSimple, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public void a(List<azvu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    int i = paramList.size();
    if (i < 16) {
      if (VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple)) {
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
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    azvu localazvu = (azvu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    azwc localazwc;
    View localView;
    if (paramView == null)
    {
      localazwc = new azwc(this);
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562054, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      localazwc.a = ((URLImageView)localView.findViewById(2131375038));
      localView.setTag(localazwc);
      localazwc.a.setTag(new azpb(25, Integer.valueOf(paramInt)));
      localazwc.a.setOnClickListener(VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple));
      paramView = (RelativeLayout.LayoutParams)localazwc.a.getLayoutParams();
      if (localazvu != null)
      {
        if ((localazvu.d != 100) && (localazvu.d != 102)) {
          break label345;
        }
        if (Build.VERSION.SDK_INT < 16) {
          break label308;
        }
        localView.setBackground(null);
        label179:
        localazwc.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      }
    }
    label405:
    for (;;)
    {
      try
      {
        paramView = localazvu.a();
        if (paramView == null) {
          break label405;
        }
        paramView = new URL("qzone_cover", "original", paramView);
      }
      catch (Exception localException)
      {
        label308:
        paramView = localObject;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("Q.qzonecover.", 2, localException.toString());
        paramView = localObject;
        continue;
      }
      if (paramView != null) {
        localazwc.a.setImageDrawable(URLDrawable.getDrawable(paramView, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.c, this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple.d));
      }
      localazwc.a.setContentDescription(anvx.a(2131716126) + (paramInt + 1));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localazwc = (azwc)paramView.getTag();
      localView = paramView;
      break;
      localView.setBackgroundDrawable(null);
      break label179;
      label345:
      if (localException.d == 101)
      {
        localazwc.a.setScaleType(ImageView.ScaleType.CENTER);
        azri.a(localazwc.a, "src", VipPhotoViewForSimple.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipPhotoViewForSimple).a, "simpleGridAddSrc");
        localazwc.a.setContentDescription(anvx.a(2131716127));
        continue;
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwb
 * JD-Core Version:    0.7.0.1
 */