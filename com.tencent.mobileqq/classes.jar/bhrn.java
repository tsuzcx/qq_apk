import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bhrn
{
  public static float a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) || (paramInt2 == 0)) {
      return 0.0F;
    }
    return Math.round(paramInt1 * 1.0F / paramInt2 * 100.0F) / 100.0F;
  }
  
  public static Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap2 = null;
    Bitmap localBitmap1;
    if ((paramBitmap == null) || (paramBitmap.isRecycled())) {
      localBitmap1 = null;
    }
    do
    {
      return localBitmap1;
      localBitmap1 = paramBitmap;
    } while (a(paramBitmap.getWidth(), paramBitmap.getHeight()) == a(paramInt1, paramInt2));
    Paint localPaint = new Paint();
    localPaint.setStyle(Paint.Style.STROKE);
    localPaint.setAntiAlias(true);
    int i;
    int j;
    if (paramInt1 >= paramBitmap.getWidth())
    {
      localBitmap1 = paramBitmap;
      if (paramInt2 >= paramBitmap.getHeight()) {}
    }
    else
    {
      if (a(paramBitmap.getWidth(), paramInt1) < a(paramBitmap.getHeight(), paramInt2)) {
        break label964;
      }
      i = (int)(paramBitmap.getHeight() * 1.0F / paramBitmap.getWidth() * paramInt1);
      j = paramInt1;
    }
    for (;;)
    {
      localBitmap2 = Bitmap.createBitmap(j, i, Bitmap.Config.ARGB_8888);
      new Canvas(localBitmap2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, localBitmap2.getWidth(), localBitmap2.getHeight()), localPaint);
      localBitmap1 = localBitmap2;
      paramBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(paramBitmap);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, 0, localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), new Rect(0, 0, localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, 0, localBitmap1.getWidth(), localBitmap1.getHeight() / 3), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, 0, paramBitmap.getWidth(), localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, localBitmap1.getHeight()), new Rect(0, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth(), localBitmap1.getHeight()), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, paramBitmap.getWidth(), paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, 0, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), new Rect(localBitmap1.getWidth() / 3, 0, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(0, localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(0, localBitmap1.getHeight() / 3, localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, localBitmap1.getWidth(), localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(paramBitmap.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, paramBitmap.getWidth(), paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight()), new Rect(localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight()), localPaint);
      localCanvas.drawBitmap(localBitmap1, new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, localBitmap1.getWidth() - localBitmap1.getWidth() / 3, localBitmap1.getHeight() - localBitmap1.getHeight() / 3), new Rect(localBitmap1.getWidth() / 3, localBitmap1.getHeight() / 3, paramBitmap.getWidth() - localBitmap1.getWidth() / 3, paramBitmap.getHeight() - localBitmap1.getHeight() / 3), localPaint);
      if (localBitmap2 != null) {
        localBitmap2.recycle();
      }
      return paramBitmap;
      label964:
      j = (int)(paramBitmap.getWidth() * 1.0F / paramBitmap.getHeight() * paramInt2);
      i = paramInt2;
    }
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      yuk.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json is null");
    }
    for (;;)
    {
      return null;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("bg");
        if (paramString == null)
        {
          yuk.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array is null");
          return null;
        }
      }
      catch (JSONException paramString)
      {
        yuk.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json is illegal:" + paramString);
        return null;
      }
      int i = 0;
      while (i < paramString.length())
      {
        JSONObject localJSONObject = paramString.getJSONObject(i);
        if (localJSONObject != null)
        {
          if ("image_view".equals(localJSONObject.optString("type"))) {
            return localJSONObject.optString("content");
          }
          yuk.b("DIYProfileTemplate.QVipUtils", "getDiyTemplateBackground but json bg array don't have image view");
        }
        i += 1;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQVasH5PayBrowserActivity.class);
    localIntent.putExtra("url", paramString);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Card paramCard, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    if (!army.c().a)
    {
      QQToast.a(paramActivity, 0, anzj.a(2131710275), 0).a();
      return;
    }
    if (!TextUtils.equals(paramQQAppInterface.getCurrentAccountUin(), paramCard.uin)) {}
    for (boolean bool = true;; bool = false)
    {
      paramCard = bhhz.a(bool, paramCard.cardId);
      Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
      localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("isShowAd", false);
      localIntent.putExtra("hide_more_button", true);
      localIntent.putExtra("has_red_dot", false);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("individuation_url_type", 40203);
      localIntent.putExtra("url", paramCard);
      VasWebviewUtil.openQQBrowserWithoutAD(paramActivity, paramCard, -1L, localIntent, true, 1036);
      return;
    }
  }
  
  public static void a(TroopInfo paramTroopInfo, String paramString, Activity paramActivity)
  {
    if (paramTroopInfo == null)
    {
      QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage error,because troop info is null");
      return;
    }
    if (paramTroopInfo.checkFlagExt4(3))
    {
      QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open mine page");
      a(armq.c().a("troop", paramTroopInfo.troopuin), paramString, paramActivity);
      return;
    }
    QLog.e("vip_pretty.", 1, "goToPrettyTroopManagePage open home page");
    a(armq.c().a("troop"), paramString, paramActivity);
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("isShowAd", false);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("has_red_dot", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    localIntent.putExtra("individuation_url_type", 40402);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtra("url", paramString1);
    VasWebviewUtil.openQQBrowserWithoutAD(paramContext, paramString1, -1L, localIntent, false, 0);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (!biik.a(paramQQAppInterface, "hide_diy_template_guide", false)) {
      bool = army.c().a;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhrn
 * JD-Core Version:    0.7.0.1
 */