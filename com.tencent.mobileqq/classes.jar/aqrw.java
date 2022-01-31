import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class aqrw
{
  public static View a(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
    case 7: 
      return LayoutInflater.from(paramContext).inflate(2131559082, paramViewGroup, false);
    }
    return a(paramContext, paramViewGroup);
  }
  
  public static View a(Context paramContext, ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getWidth();
    ImageView localImageView = new ImageView(paramContext);
    paramViewGroup = localImageView.getLayoutParams();
    paramContext = paramViewGroup;
    if (paramViewGroup == null) {
      paramContext = new ViewGroup.LayoutParams(-2, -2);
    }
    localImageView.setPadding(0, 20, 0, 20);
    paramContext.width = (i - localImageView.getPaddingLeft() - localImageView.getPaddingRight() - localImageView.getPaddingLeft());
    paramContext.height = (i * 200 / 718);
    localImageView.setLayoutParams(paramContext);
    localImageView.setId(2131363043);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    return localImageView;
  }
  
  public static aqrr a(Context paramContext, int paramInt, ViewGroup paramViewGroup)
  {
    View localView = a(paramContext, paramInt, paramViewGroup);
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
      return new aqry(paramContext, localView, paramViewGroup);
    case 7: 
      return new aqrx(paramContext, localView, paramViewGroup);
    }
    return new aqrs(paramContext, localView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqrw
 * JD-Core Version:    0.7.0.1
 */