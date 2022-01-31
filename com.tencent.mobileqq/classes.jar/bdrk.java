import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
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

public class bdrk
  extends bdih
{
  private static final int jdField_a_of_type_Int = bdhg.a("MiniApp", "mini_game_exit_confirm_animation_expoure_times_threshold", 3);
  private Context jdField_a_of_type_AndroidContentContext;
  
  public bdrk(bdcz parambdcz)
  {
    super(parambdcz);
    this.jdField_a_of_type_AndroidContentContext = parambdcz.a();
  }
  
  private static boolean a(int paramInt)
  {
    return (paramInt >= 3001) && (paramInt <= 3010);
  }
  
  private static boolean b(int paramInt)
  {
    boolean bool2 = false;
    try
    {
      Object localObject = bdhg.a("MiniApp", "mini_game_exit_confirm_animation_scene_black_list", "");
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
          bdnw.d("GameCapsuleButton", "isInWnsBlackList", localException);
          i += 1;
        }
      }
      return false;
    }
    catch (Throwable localThrowable)
    {
      bdnw.d("GameCapsuleButton", "isInWnsBlackList", localThrowable);
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_Bdcz.a();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      if (!((Activity)localObject).moveTaskToBack(true))
      {
        bdnw.d("GameCapsuleButton", "moveTaskToBack failed, finish the activity.");
        ((Activity)localObject).finish();
      }
      this.jdField_a_of_type_Bdcz.a(bdfl.a(60));
    }
    if (this.jdField_a_of_type_Bdcz.e())
    {
      localObject = this.jdField_a_of_type_Bdcz.a();
      if ((localObject != null) && (((MiniAppInfo)localObject).launchParam != null) && (!TextUtils.isEmpty(((MiniAppInfo)localObject).launchParam.f))) {
        bdgs.a(((MiniAppInfo)localObject).launchParam.f);
      }
    }
  }
  
  public void a()
  {
    bdnw.b("GameCapsuleButton", "on close click");
    if (!a(this.jdField_a_of_type_Bdcz.a(), new bdrl(this))) {
      c();
    }
  }
  
  public boolean a(MiniAppInfo paramMiniAppInfo, DialogInterface.OnClickListener paramOnClickListener)
  {
    Object localObject1 = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
    if (!"qq".equals(((MiniAppProxy)localObject1).getAppName())) {}
    int i;
    do
    {
      do
      {
        return false;
      } while ((paramMiniAppInfo != null) && (paramMiniAppInfo.launchParam != null) && ((paramMiniAppInfo.launchParam.jdField_a_of_type_Int == 2001) || (paramMiniAppInfo.launchParam.jdField_a_of_type_Int == 1001) || (a(paramMiniAppInfo.launchParam.jdField_a_of_type_Int)) || (b(paramMiniAppInfo.launchParam.jdField_a_of_type_Int))));
      paramMiniAppInfo = this.jdField_a_of_type_Bdcz.a();
      if ((paramMiniAppInfo == null) || (paramMiniAppInfo.isFinishing()))
      {
        bdnw.c("GameCapsuleButton", "Activity is not exiting, no need to response close button");
        return false;
      }
      i = bdzf.a().getInt("pref_key_mini_game_close_confirm_exposure_times", 0);
    } while (i >= jdField_a_of_type_Int);
    paramMiniAppInfo = bdgk.a(paramMiniAppInfo, 230);
    Object localObject2 = bdhg.a("MiniApp", "mini_game_exit_confirm_animation_image_url", "https://qzonestyle.gtimg.cn/aoi/sola/20191114160727_AqDlaIYOnx.gif");
    localObject2 = ((MiniAppProxy)localObject1).getDrawable(this.jdField_a_of_type_AndroidContentContext, (String)localObject2, 0, 0, null);
    localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
    ((ImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    ((ImageView)localObject1).setAdjustViewBounds(true);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    if (this.jdField_a_of_type_Bdcz.f())
    {
      localLayoutParams.width = (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels / 2);
      localLayoutParams.height = ((int)(localLayoutParams.width / 1.05F));
    }
    localLayoutParams.gravity = 1;
    TextView localTextView = new TextView(this.jdField_a_of_type_AndroidContentContext);
    localTextView.setText(Html.fromHtml(this.jdField_a_of_type_AndroidContentContext.getString(2131628571)), TextView.BufferType.SPANNABLE);
    localTextView.setTextColor(Color.parseColor("#02081B"));
    localTextView.setGravity(17);
    localTextView.setTypeface(Typeface.DEFAULT, 1);
    localObject2 = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    ((LinearLayout)localObject2).setOrientation(1);
    ((LinearLayout)localObject2).addView((View)localObject1, localLayoutParams);
    ((LinearLayout)localObject2).addView(localTextView, new LinearLayout.LayoutParams(-2, -2));
    localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 17;
    paramMiniAppInfo.setCancelable(false);
    paramMiniAppInfo.a(null).a(null).a((View)localObject2, (LinearLayout.LayoutParams)localObject1).b("我知道了", new bdrm(this, paramOnClickListener));
    paramMiniAppInfo.a().setTypeface(Typeface.DEFAULT, 1);
    paramMiniAppInfo.show();
    bdzf.a().edit().putInt("pref_key_mini_game_close_confirm_exposure_times", i + 1).apply();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdrk
 * JD-Core Version:    0.7.0.1
 */