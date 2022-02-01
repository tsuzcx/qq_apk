import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class azgu
{
  public static View a(@NonNull Context paramContext)
  {
    paramContext = new View(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramContext.setBackgroundColor(0);
    return paramContext;
  }
  
  public static View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131562989, paramViewGroup, false);
  }
  
  public static TextView a(@NonNull Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramContext.setGravity(17);
    paramContext.setTextColor(-1);
    paramContext.setShadowLayer(0.0F, ScreenUtil.dip2px(0.5F), ScreenUtil.dip2px(1.5F), 2131167329);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setMaxLines(3);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    paramContext.setPadding(ScreenUtil.dip2px(23.0F), 0, ScreenUtil.dip2px(23.0F), 0);
    return paramContext;
  }
  
  public static View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131562987, paramViewGroup, false);
  }
  
  public static TextView b(@NonNull Context paramContext)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    localTextView.setGravity(17);
    localTextView.setTextColor(paramContext.getResources().getColor(2131167319));
    localTextView.setTextSize(1, 14.0F);
    localTextView.setShadowLayer(0.0F, ScreenUtil.dip2px(0.5F), ScreenUtil.dip2px(1.5F), 2131167329);
    return localTextView;
  }
  
  public static View c(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131562985, paramViewGroup, false);
  }
  
  public static TextView c(@NonNull Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramContext.setGravity(17);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 34.0F);
    paramContext.setShadowLayer(0.0F, ScreenUtil.dip2px(0.5F), ScreenUtil.dip2px(1.5F), 2131167329);
    return paramContext;
  }
  
  public static View d(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131562986, paramViewGroup, false);
  }
  
  public static TextView d(@NonNull Context paramContext)
  {
    paramContext = new TextView(paramContext);
    paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    paramContext.setGravity(17);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setShadowLayer(0.0F, ScreenUtil.dip2px(0.5F), ScreenUtil.dip2px(1.5F), 2131167329);
    return paramContext;
  }
  
  public static TextView e(@NonNull Context paramContext)
  {
    paramContext = new TextView(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.leftMargin = ScreenUtil.dip2px(28.0F);
    localLayoutParams.rightMargin = ScreenUtil.dip2px(28.0F);
    paramContext.setLayoutParams(localLayoutParams);
    paramContext.setTextColor(-1);
    paramContext.setTextSize(1, 22.0F);
    paramContext.setShadowLayer(0.0F, ScreenUtil.dip2px(0.5F), ScreenUtil.dip2px(1.5F), 2131167329);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgu
 * JD-Core Version:    0.7.0.1
 */