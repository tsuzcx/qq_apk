import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.fragment.SDKSetEmotionPreviewFragment;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class aqjh
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public List<String> a;
  
  public aqjh(SDKSetEmotionPreviewFragment paramSDKSetEmotionPreviewFragment)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramSDKSetEmotionPreviewFragment.getActivity().getLayoutInflater();
  }
  
  public void a(List<String> paramList)
  {
    if (paramList == null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 0)
      {
        this.jdField_a_of_type_JavaUtilList.clear();
        notifyDataSetChanged();
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    notifyDataSetChanged();
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
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559020, null);
      paramView.setLayoutParams(new AbsListView.LayoutParams(SDKSetEmotionPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentSDKSetEmotionPreviewFragment), SDKSetEmotionPreviewFragment.b(this.jdField_a_of_type_ComTencentMobileqqFragmentSDKSetEmotionPreviewFragment)));
      paramViewGroup = new aqjj(this);
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131365571));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      String str = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = aywk.a;
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = aywk.a;
      ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = auoy.a(str);
      ((URLDrawable.URLDrawableOptions)localObject).mUseAutoScaleParams = true;
      localObject = URLDrawable.getFileDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
      paramViewGroup.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramViewGroup.a.setImageDrawable((Drawable)localObject);
      localObject = paramViewGroup.a;
      paramViewGroup.a.setOnClickListener(new aqji(this, str, (View)localObject));
      return paramView;
      paramViewGroup = (aqjj)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqjh
 * JD-Core Version:    0.7.0.1
 */