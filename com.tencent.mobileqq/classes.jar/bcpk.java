import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.ProfileCardVideoCoverShowView;
import java.util.ArrayList;

public class bcpk
  extends BaseAdapter
{
  public bcpk(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView) {}
  
  public bcpm a(int paramInt)
  {
    return (bcpm)ProfileCardVideoCoverShowView.a(this.a).get(paramInt);
  }
  
  public int getCount()
  {
    return ProfileCardVideoCoverShowView.a(this.a).size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131560963, null, false);
      paramViewGroup.setTag((ImageView)paramViewGroup.findViewById(2131367776));
      paramView = new StateListDrawable();
      paramView.addState(ProfileCardVideoCoverShowView.a(), new ColorDrawable(855638016));
      paramView.addState(ProfileCardVideoCoverShowView.b(), new ColorDrawable(0));
      paramViewGroup.findViewById(2131377633).setBackgroundDrawable(paramView);
    }
    paramView = (ImageView)paramViewGroup.getTag();
    bcpm localbcpm = a(paramInt);
    if (TextUtils.isEmpty(localbcpm.a)) {
      paramView.setImageDrawable(null);
    }
    while (paramInt == 0)
    {
      paramViewGroup.setPadding(actj.a(12.0F, this.a.getResources()), 0, 0, 0);
      return paramViewGroup;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mRequestHeight = actj.a(178.0F, this.a.getResources());
      localURLDrawableOptions.mRequestWidth = actj.a(100.0F, this.a.getResources());
      paramView.setImageDrawable(URLDrawable.getDrawable(localbcpm.a, localURLDrawableOptions));
    }
    paramViewGroup.setPadding(0, 0, 0, 0);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcpk
 * JD-Core Version:    0.7.0.1
 */