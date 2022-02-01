import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import org.json.JSONObject;

public class bmne
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
  
  public bmnd a(View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {
      return null;
    }
    if (RelativeLayout.class.isInstance(paramView)) {
      return new bmnb("layout", paramView);
    }
    return new bmnd(paramView);
  }
  
  public bmnd a(String paramString, View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new bmnc(paramString, paramView);
      }
      if ("image_view".equals(paramString)) {
        return new bmmy(paramString, paramView);
      }
      if ("layout".equals(paramString)) {
        return new bmnb(paramString, paramView);
      }
      if ("lottie_view".equals(paramString)) {
        return new bmmz(paramString, paramView);
      }
    } while (!"mask_view".equals(paramString));
    return new bmna(paramString, paramView);
  }
  
  public void a(bmnd parambmnd, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmne
 * JD-Core Version:    0.7.0.1
 */