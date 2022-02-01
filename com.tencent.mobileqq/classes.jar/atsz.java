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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class atsz
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public List<String> a;
  
  public atsz(SDKSetEmotionPreviewFragment paramSDKSetEmotionPreviewFragment)
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
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559132, null);
      localView.setLayoutParams(new AbsListView.LayoutParams(SDKSetEmotionPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqFragmentSDKSetEmotionPreviewFragment), SDKSetEmotionPreviewFragment.b(this.jdField_a_of_type_ComTencentMobileqqFragmentSDKSetEmotionPreviewFragment)));
      paramView = new attb(this);
      paramView.a = ((URLImageView)localView.findViewById(2131365963));
      localView.setTag(paramView);
    }
    for (;;)
    {
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mPlayGifImage = ayfc.a((String)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject2).mUseAutoScaleParams = true;
      localObject2 = URLDrawable.getFileDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject2);
      paramView.a.setScaleType(ImageView.ScaleType.FIT_CENTER);
      paramView.a.setImageDrawable((Drawable)localObject2);
      localObject2 = paramView.a;
      paramView.a.setOnClickListener(new atta(this, (String)localObject1, (View)localObject2));
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject1 = (attb)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atsz
 * JD-Core Version:    0.7.0.1
 */