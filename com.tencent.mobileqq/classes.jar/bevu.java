import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bevu
{
  private static final int jdField_a_of_type_Int = bema.a("MiniApp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  private static final String jdField_a_of_type_JavaLangString = bema.a("MiniApp", "qqMiniappRetainAlterViewScene", "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");
  
  private static boolean a(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = bema.a("MiniApp", "mini_game_exit_confirm_animation_scene_black_list", "");
      boolean bool1 = bool2;
      int j;
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        bool1 = bool2;
        if (localObject != null)
        {
          j = localObject.length;
          i = 0;
        }
      }
      for (;;)
      {
        bool1 = bool2;
        String str;
        if (i < j) {
          str = localObject[i];
        }
        try
        {
          int k = Integer.parseInt(str);
          if (k == paramInt)
          {
            bool1 = true;
            return bool1;
          }
        }
        catch (Exception localException)
        {
          betc.d("GameCloseManager", "isInWnsBlackList", localException);
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      betc.d("GameCloseManager", "isInWnsBlackList", localThrowable);
    }
  }
  
  public static boolean a(behq parambehq, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject2 = parambehq.a();
    Object localObject1 = parambehq.a();
    if ((localObject2 == null) || (localObject1 == null)) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((!bfhk.a()) || ((((MiniAppInfo)localObject1).launchParam != null) && ((((MiniAppInfo)localObject1).launchParam.jdField_a_of_type_Int == 2001) || (((MiniAppInfo)localObject1).launchParam.jdField_a_of_type_Int == 1001) || (bfgy.a((MiniAppInfo)localObject1)) || (a(((MiniAppInfo)localObject1).launchParam.jdField_a_of_type_Int)))));
      localObject3 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      i = bfhm.a().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
    } while (i >= jdField_a_of_type_Int);
    localObject1 = beld.a((Context)localObject2, 230);
    ImageView localImageView = new ImageView((Context)localObject2);
    localImageView.setImageDrawable(((MiniAppProxy)localObject3).getDrawable((Context)localObject2, bema.a("MiniApp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif"), 0, 0, null));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView.setAdjustViewBounds(true);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    if (parambehq.f())
    {
      ((LinearLayout.LayoutParams)localObject3).width = (((Activity)localObject2).getResources().getDisplayMetrics().heightPixels / 2);
      ((LinearLayout.LayoutParams)localObject3).height = ((int)(((LinearLayout.LayoutParams)localObject3).width / 1.05F));
    }
    ((LinearLayout.LayoutParams)localObject3).gravity = 1;
    parambehq = new TextView((Context)localObject2);
    parambehq.setText(Html.fromHtml(((Activity)localObject2).getApplicationContext().getString(2131694214)), TextView.BufferType.SPANNABLE);
    parambehq.setTextColor(Color.parseColor("#02081B"));
    parambehq.setGravity(17);
    parambehq.setTypeface(Typeface.DEFAULT, 1);
    localObject2 = new LinearLayout((Context)localObject2);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).addView(localImageView, (ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).addView(parambehq, new LinearLayout.LayoutParams(-2, -2));
    parambehq = new LinearLayout.LayoutParams(-2, -2);
    parambehq.gravity = 17;
    ((bene)localObject1).setCancelable(false);
    ((bene)localObject1).a(null).a(null).a((View)localObject2, parambehq).b("我知道了", new bevv(paramOnClickListener));
    ((bene)localObject1).a().setTypeface(Typeface.DEFAULT, 1);
    ((bene)localObject1).show();
    bfhm.a().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
    return true;
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.whiteList != null) && (paramMiniAppInfo.launchParam != null))
    {
      betc.a("GameCloseManager", "shouldShowAlertViewForBattleGame api " + Arrays.toString(paramMiniAppInfo.whiteList.toArray()) + " scenes " + jdField_a_of_type_JavaLangString);
      Iterator localIterator = paramMiniAppInfo.whiteList.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if ("showRetainAlterViewType1".equals(localObject)) {
            return true;
          }
          if ((!((String)localObject).startsWith("showRetainAlterViewType")) || (TextUtils.isEmpty(jdField_a_of_type_JavaLangString))) {
            continue;
          }
          try
          {
            localObject = new JSONObject(jdField_a_of_type_JavaLangString).optJSONArray(((String)localObject).replace("showRetainAlterViewType", ""));
            if (localObject != null)
            {
              int j = ((JSONArray)localObject).length();
              int i = 0;
              while (i < j)
              {
                int k = ((JSONArray)localObject).optInt(i, 0);
                int m = paramMiniAppInfo.launchParam.jdField_a_of_type_Int;
                if (k == m) {
                  return true;
                }
                i += 1;
              }
            }
          }
          catch (Exception localException)
          {
            betc.d("GameCloseManager", "shouldShowAlertViewForBattleGame ", localException);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean b(behq parambehq, DialogInterface.OnClickListener paramOnClickListener)
  {
    Activity localActivity = parambehq.a();
    parambehq = parambehq.a();
    if ((localActivity == null) || (parambehq == null)) {}
    while (!a(parambehq)) {
      return false;
    }
    parambehq = beld.a(localActivity, 230).a(localActivity.getString(2131694263)).a(localActivity.getString(2131694217)).a(localActivity.getString(2131694209), new bevx()).b(localActivity.getString(2131694216), new bevw(paramOnClickListener));
    parambehq.setCancelable(false);
    parambehq.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bevu
 * JD-Core Version:    0.7.0.1
 */