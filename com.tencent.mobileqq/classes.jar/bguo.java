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
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.MiniAppUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tencent.qqmini.sdk.utils.StorageUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class bguo
{
  private static final int jdField_a_of_type_Int = bglq.a("qqminiapp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  private static final String jdField_a_of_type_JavaLangString = bglq.a("qqminiapp", "qqMiniappRetainAlterViewScene", "{\"2\": [\"2072\"],\"3\": [\"1037\"]}");
  
  private static boolean a(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = bglq.a("qqminiapp", "mini_game_exit_confirm_animation_scene_black_list", "");
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
          QMLog.e("GameCloseManager", "isInWnsBlackList", localException);
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("GameCloseManager", "isInWnsBlackList", localThrowable);
    }
  }
  
  public static boolean a(bgho parambgho, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject2 = parambgho.a();
    Object localObject1 = parambgho.a();
    if ((localObject2 == null) || (localObject1 == null)) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((!QUAUtil.isQQApp()) || ((((MiniAppInfo)localObject1).launchParam != null) && ((((MiniAppInfo)localObject1).launchParam.scene == 2001) || (((MiniAppInfo)localObject1).launchParam.scene == 1001) || (MiniAppUtils.isFromPullDownEntry((MiniAppInfo)localObject1)) || (a(((MiniAppInfo)localObject1).launchParam.scene)))));
      localObject3 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      i = StorageUtil.getPreference().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
    } while (i >= jdField_a_of_type_Int);
    localObject1 = bgkp.a((Context)localObject2, 230);
    ImageView localImageView = new ImageView((Context)localObject2);
    localImageView.setImageDrawable(((MiniAppProxy)localObject3).getDrawable((Context)localObject2, bglq.a("qqminiapp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif"), 0, 0, null));
    localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    localImageView.setAdjustViewBounds(true);
    Object localObject3 = new LinearLayout.LayoutParams(-2, -2);
    if (parambgho.c())
    {
      ((LinearLayout.LayoutParams)localObject3).width = (((Activity)localObject2).getResources().getDisplayMetrics().heightPixels / 2);
      ((LinearLayout.LayoutParams)localObject3).height = ((int)(((LinearLayout.LayoutParams)localObject3).width / 1.05F));
    }
    ((LinearLayout.LayoutParams)localObject3).gravity = 1;
    parambgho = new TextView((Context)localObject2);
    parambgho.setText(Html.fromHtml(((Activity)localObject2).getApplicationContext().getString(2131694332)), TextView.BufferType.SPANNABLE);
    parambgho.setTextColor(Color.parseColor("#02081B"));
    parambgho.setGravity(17);
    parambgho.setTypeface(Typeface.DEFAULT, 1);
    localObject2 = new LinearLayout((Context)localObject2);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).addView(localImageView, (ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject2).addView(parambgho, new LinearLayout.LayoutParams(-2, -2));
    parambgho = new LinearLayout.LayoutParams(-2, -2);
    parambgho.gravity = 17;
    ((bgmu)localObject1).setCancelable(false);
    ((bgmu)localObject1).a(null).a(null).a((View)localObject2, parambgho).b("我知道了", new bgup(paramOnClickListener));
    ((bgmu)localObject1).a().setTypeface(Typeface.DEFAULT, 1);
    ((bgmu)localObject1).show();
    StorageUtil.getPreference().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
    return true;
  }
  
  private static boolean a(MiniAppInfo paramMiniAppInfo)
  {
    if ((paramMiniAppInfo != null) && (paramMiniAppInfo.whiteList != null) && (paramMiniAppInfo.launchParam != null))
    {
      QMLog.d("GameCloseManager", "shouldShowAlertViewForBattleGame api " + Arrays.toString(paramMiniAppInfo.whiteList.toArray()) + " scenes " + jdField_a_of_type_JavaLangString);
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
                int m = paramMiniAppInfo.launchParam.scene;
                if (k == m) {
                  return true;
                }
                i += 1;
              }
            }
          }
          catch (Exception localException)
          {
            QMLog.e("GameCloseManager", "shouldShowAlertViewForBattleGame ", localException);
          }
        }
      }
    }
    return false;
  }
  
  public static boolean b(bgho parambgho, DialogInterface.OnClickListener paramOnClickListener)
  {
    Activity localActivity = parambgho.a();
    parambgho = parambgho.a();
    if ((localActivity == null) || (parambgho == null)) {}
    while (!a(parambgho)) {
      return false;
    }
    parambgho = bgkp.a(localActivity, 230).a(localActivity.getString(2131694402)).a(localActivity.getString(2131694336)).a(localActivity.getString(2131694326), new bgur()).b(localActivity.getString(2131694335), new bguq(paramOnClickListener));
    parambgho.setCancelable(false);
    parambgho.show();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bguo
 * JD-Core Version:    0.7.0.1
 */