import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import org.json.JSONObject;

public class bkbl
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
  
  public bkbk a(View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {
      return null;
    }
    if (RelativeLayout.class.isInstance(paramView)) {
      return new bkbi("layout", paramView);
    }
    return new bkbk(paramView);
  }
  
  public bkbk a(String paramString, View paramView)
  {
    if ((paramView == null) || (paramView.getClass() == null)) {}
    do
    {
      return null;
      if ("text_view".equals(paramString)) {
        return new bkbj(paramString, paramView);
      }
      if ("image_view".equals(paramString)) {
        return new bkbf(paramString, paramView);
      }
      if ("layout".equals(paramString)) {
        return new bkbi(paramString, paramView);
      }
      if ("lottie_view".equals(paramString)) {
        return new bkbg(paramString, paramView);
      }
    } while (!"mask_view".equals(paramString));
    return new bkbh(paramString, paramView);
  }
  
  public void a(bkbk parambkbk, JSONObject paramJSONObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbl
 * JD-Core Version:    0.7.0.1
 */