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

public class beou
  extends BaseAdapter
{
  public beou(ProfileCardVideoCoverShowView paramProfileCardVideoCoverShowView) {}
  
  public beow a(int paramInt)
  {
    return (beow)ProfileCardVideoCoverShowView.a(this.a).get(paramInt);
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
      paramViewGroup = LayoutInflater.from(this.a.getContext()).inflate(2131561146, null, false);
      paramViewGroup.setTag((ImageView)paramViewGroup.findViewById(2131367910));
      paramView = new StateListDrawable();
      paramView.addState(ProfileCardVideoCoverShowView.a(), new ColorDrawable(855638016));
      paramView.addState(ProfileCardVideoCoverShowView.b(), new ColorDrawable(0));
      paramViewGroup.findViewById(2131378175).setBackgroundDrawable(paramView);
    }
    paramView = (ImageView)paramViewGroup.getTag();
    beow localbeow = a(paramInt);
    if (TextUtils.isEmpty(localbeow.a)) {
      paramView.setImageDrawable(null);
    }
    while (paramInt == 0)
    {
      paramViewGroup.setPadding(aekt.a(12.0F, this.a.getResources()), 0, 0, 0);
      return paramViewGroup;
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(0);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      localURLDrawableOptions.mRequestHeight = aekt.a(178.0F, this.a.getResources());
      localURLDrawableOptions.mRequestWidth = aekt.a(100.0F, this.a.getResources());
      paramView.setImageDrawable(URLDrawable.getDrawable(localbeow.a, localURLDrawableOptions));
    }
    paramViewGroup.setPadding(0, 0, 0, 0);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beou
 * JD-Core Version:    0.7.0.1
 */