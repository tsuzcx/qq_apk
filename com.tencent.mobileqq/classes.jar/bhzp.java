import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import org.json.JSONObject;

public class bhzp
{
  public View a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new TextView(paramContext);
      }
      if ("image_view".equals(paramString)) {
        return new ImageView(paramContext);
      }
      if ("layout".equals(paramString)) {
        return new RelativeLayout(paramContext);
      }
      if ("lottie_view".equals(paramString)) {
        return new DiniFlyAnimationView(paramContext);
      }
    } while (!"mask_view".equals(paramString));
    return new ImageView(paramContext);
  }
  
  public bhzo a(View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {
      return null;
    }
    if (RelativeLayout.class.isInstance(paramView)) {
      return new bhzm("layout", paramView);
    }
    return new bhzo(paramView);
  }
  
  public bhzo a(String paramString, View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new bhzn(paramString, paramView);
      }
      if ("image_view".equals(paramString)) {
        return new bhzj(paramString, paramView);
      }
      if ("layout".equals(paramString)) {
        return new bhzm(paramString, paramView);
      }
      if ("lottie_view".equals(paramString)) {
        return new bhzk(paramString, paramView);
      }
    } while (!"mask_view".equals(paramString));
    return new bhzl(paramString, paramView);
  }
  
  public void a(bhzo parambhzo, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhzp
 * JD-Core Version:    0.7.0.1
 */