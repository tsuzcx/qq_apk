import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import org.json.JSONObject;

public class bnvo
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
  
  public bnvn a(View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {
      return null;
    }
    if (RelativeLayout.class.isInstance(paramView)) {
      return new bnvl("layout", paramView);
    }
    return new bnvn(paramView);
  }
  
  public bnvn a(String paramString, View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new bnvm(paramString, paramView);
      }
      if ("image_view".equals(paramString)) {
        return new bnvi(paramString, paramView);
      }
      if ("layout".equals(paramString)) {
        return new bnvl(paramString, paramView);
      }
      if ("lottie_view".equals(paramString)) {
        return new bnvj(paramString, paramView);
      }
    } while (!"mask_view".equals(paramString));
    return new bnvk(paramString, paramView);
  }
  
  public void a(bnvn parambnvn, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnvo
 * JD-Core Version:    0.7.0.1
 */