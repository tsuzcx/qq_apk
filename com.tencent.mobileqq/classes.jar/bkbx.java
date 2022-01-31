import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class bkbx
{
  public static int a(float paramFloat1, float paramFloat2)
  {
    float f = paramFloat1;
    if (paramFloat1 < 0.0F) {
      f = 1.0F;
    }
    return (int)(paramFloat2 / f + 0.5F);
  }
  
  private static int a(int paramInt)
  {
    Object localObject1 = Aladdin.getConfig(265).getString("floating_layer_top_margin", "");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        return -1;
      }
      localObject1 = new JSONObject((String)localObject1).optString("top_margin", "");
      QLog.d("ReadInjoyFloatingWindowModule", 1, " getFloatingWindowHeight! marginContent=" + (String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
          if (localObject2 != null)
          {
            String str = ((JSONObject)localObject2).optString("type", "");
            localObject2 = ((JSONObject)localObject2).optString("margin", "");
            if (!TextUtils.isEmpty(str))
            {
              boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
              if (!bool) {
                try
                {
                  int j = Integer.parseInt(str);
                  float f = Float.parseFloat((String)localObject2);
                  if (j == paramInt)
                  {
                    j = a(paramInt, f);
                    return j;
                  }
                }
                catch (Exception localException2)
                {
                  QLog.d("ReadInjoyFloatingWindowModule", 1, " getFloatingWindowHeight array error! msg=" + localException2);
                }
              }
            }
          }
          i += 1;
        }
      }
      return -1;
    }
    catch (Exception localException1)
    {
      QLog.d("ReadInjoyFloatingWindowModule", 1, " getFloatingWindowHeight error! msg=" + localException1);
    }
  }
  
  private static int a(int paramInt, float paramFloat)
  {
    int i = (int)paramFloat;
    float f2 = -1.0F;
    float f1 = f2;
    int j = i;
    if (paramFloat > 0.0F)
    {
      f1 = f2;
      j = i;
      if (paramFloat < 1.0F) {
        j = i;
      }
    }
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      j = i;
      int k = (int)(localDisplayMetrics.heightPixels * paramFloat);
      if (k > 0) {
        i = k;
      }
      j = i;
      f1 = localDisplayMetrics.density;
      j = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("ReadInjoyFloatingWindowModule", 1, " getMarginTop error! msg=" + localException);
        f1 = f2;
      }
    }
    QLog.d("ReadInjoyFloatingWindowModule", 1, " getMarginTop,busiType=" + paramInt + " ,configMarginPx=" + paramFloat + "  ,realMarginPx=" + j);
    if (f1 > 0.0F) {
      return a(f1, j);
    }
    return -1;
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, Bundle paramBundle, int paramInt3)
  {
    if (paramContext == null) {
      return;
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    int i = a(paramInt2);
    if ((i > 0) && (i < 10000)) {
      localBundle.putInt("margin_top", i);
    }
    localBundle.putInt("floating_window_scene", paramInt1);
    localBundle.putInt("floating_window_business", paramInt2);
    if (paramInt1 == 4) {
      localBundle.putBoolean("float_layer_back_view", true);
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      QLog.d("ReadInjoyFloatingWindowModule", 1, " openFloatingWindow : scene=" + paramInt1 + "  busiType=" + paramInt2 + "\t marginTop=" + i + "\t bundle=" + localBundle);
      return;
      a(paramContext, paramInt1, localBundle, paramInt3);
      continue;
      smk.a(paramContext, paramInt2, localBundle);
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, boolean paramBoolean)
  {
    a(paramContext, paramInt1, paramInt2, paramString1, paramString2, paramInt3, paramBoolean, null);
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = true;
    QLog.d("ReadInjoyFloatingWindowModule", 1, "openViolaActivityOnKandianDaily scene: " + paramInt1 + " luanchFrom: " + paramInt2 + " rowKey: " + paramString1 + " topicId: " + paramString2 + " busiType: " + paramInt3 + " needGrayBar: " + paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putInt("floating_window_scene", paramInt1);
    localBundle.putString("floating_window_rowkey", paramString1);
    localBundle.putString("float_layer_topic_id", paramString2);
    localBundle.putBoolean("up_animation", false);
    localBundle.putBoolean("gray_bar", paramBoolean);
    localBundle.putInt("floating_window_business", paramInt3);
    if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_scroll_to_top", 0) == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localBundle.putBoolean("scroll_to_top", paramBoolean);
      if (localBundle != null) {
        localBundle.putBundle("floating_bundle_extra_data", paramBundle);
      }
      KandianDailyManager.a(paramContext, false, localBundle, paramInt2);
      return;
    }
  }
  
  public static void a(Context paramContext, int paramInt1, int paramInt2, String paramString1, String paramString2, boolean paramBoolean)
  {
    boolean bool = true;
    QLog.d("ReadInjoyFloatingWindowModule", 1, "openNativeArticleOnKandianDaily scene: " + paramInt1 + " luanchFrom: " + paramInt2 + " rowKey: " + paramString1 + " url: " + paramString2 + " needGrayBar: " + paramBoolean);
    Bundle localBundle = new Bundle();
    localBundle.putInt("floating_window_scene", paramInt1);
    localBundle.putString("floating_window_rowkey", paramString1);
    localBundle.putString("float_layer_article_url", paramString2);
    localBundle.putBoolean("up_animation", false);
    localBundle.putBoolean("gray_bar", paramBoolean);
    localBundle.putInt("floating_window_business", 1);
    if (Aladdin.getConfig(261).getIntegerFromString("enable_floating_scroll_to_top", 0) == 1) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      localBundle.putBoolean("scroll_to_top", paramBoolean);
      KandianDailyManager.a(paramContext, false, localBundle, paramInt2);
      return;
    }
  }
  
  private static void a(Context paramContext, int paramInt1, Bundle paramBundle, int paramInt2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, FastWebActivity.class);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putBoolean("launch_from_floating_window", true);
    localIntent.putExtras(localBundle);
    boolean bool = a(localBundle, localIntent, paramInt2);
    if (bool) {
      paramContext.startActivity(localIntent);
    }
    QLog.d("ReadInjoyFloatingWindowModule", 1, " openNativeArticle : scene=" + paramInt1 + "  isLegal=" + bool);
  }
  
  public static void a(Context paramContext, HashMap<String, String> paramHashMap)
  {
    int n = 0;
    if (paramHashMap == null) {
      QLog.d("ReadInjoyFloatingWindowModule", 1, " jump2FloatingWindow error! attrs is null!");
    }
    Object localObject = paramContext;
    if (paramContext == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    String str1 = (String)paramHashMap.get("rowkey");
    String str3 = (String)paramHashMap.get("url");
    String str2 = (String)paramHashMap.get("topicID");
    for (;;)
    {
      int j;
      try
      {
        j = Integer.parseInt((String)paramHashMap.get("busiType"));
      }
      catch (Exception paramContext)
      {
        label187:
        i = 0;
        j = -1;
      }
      for (;;)
      {
        try
        {
          i = Integer.parseInt((String)paramHashMap.get("scene"));
        }
        catch (Exception paramContext)
        {
          i = 0;
          continue;
        }
        try
        {
          k = Integer.parseInt((String)paramHashMap.get("channelID"));
          m = i;
          if (j == -1)
          {
            i = n;
            if (i == 0) {}
          }
        }
        catch (Exception paramContext)
        {
          continue;
        }
        try
        {
          paramContext = new Bundle();
          paramContext.putString("floating_window_rowkey", str1);
          if (!TextUtils.isEmpty(str3)) {
            paramContext.putString("float_layer_article_url", URLDecoder.decode(str3, "utf-8"));
          }
          if (!TextUtils.isEmpty(str2)) {
            paramContext.putString("float_layer_topic_id", str2);
          }
          a((Context)localObject, m, j, paramContext, k);
        }
        catch (Exception paramContext)
        {
          QLog.d("ReadInjoyFloatingWindowModule", 1, "jump2FloatingWindow error! e=" + paramContext);
          break label187;
        }
      }
      QLog.d("ReadInjoyFloatingWindowModule", 1, "busiType=" + j + " ，rowkey=" + str1 + " ，topicID=" + str2 + " ，scene=" + m + " ，channelID=" + k);
      return;
      QLog.d("ReadInjoyFloatingWindowModule", 1, " parseInt error! e=" + paramContext);
      int k = 0;
      int m = i;
      continue;
      i = n;
      if (localObject != null) {
        if (j == 4)
        {
          i = n;
          if (!TextUtils.isEmpty(str2)) {
            i = 1;
          }
        }
        else
        {
          i = n;
          if (!TextUtils.isEmpty(str1)) {
            i = 1;
          }
        }
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    Object localObject = Uri.parse(paramString);
    QLog.d("ReadInjoyFloatingWindowModule", 1, "openFloatLayer: " + paramString);
    String str1;
    String str3;
    int i;
    if (localObject != null)
    {
      ((Uri)localObject).getQueryParameter("viola_share_url");
      str1 = ((Uri)localObject).getQueryParameter("rowkey");
      String str2 = ((Uri)localObject).getQueryParameter("cc_media_type");
      str3 = ((Uri)localObject).getQueryParameter("viola_media_type");
      localObject = ((Uri)localObject).getQueryParameter("topic_id");
      if ("10001".equals(str2))
      {
        a(paramContext, 4, 15, str1, paramString, true);
        return true;
      }
      if ("10050".equals(str3)) {
        i = 3;
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        a(paramContext, 4, 15, str1, (String)localObject, i, true);
        return true;
        if ("10051".equals(str3))
        {
          i = 4;
          continue;
        }
        if ("10052".equals(str3)) {
          i = 2;
        }
      }
      else
      {
        return false;
      }
      i = -1;
    }
  }
  
  public static boolean a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QLog.d("ReadInjoyFloatingWindowModule", 1, "openFloatLayerVideo: " + paramString);
    if (!TextUtils.isEmpty(paramString))
    {
      a(paramContext, 4, 15, paramString, "", 2, true, paramBundle);
      return true;
    }
    return false;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    boolean bool3 = false;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (paramBundle != null)
      {
        bool2 = bool3;
        if (bool1)
        {
          bool2 = bool3;
          if (!TextUtils.isEmpty(paramBundle.getString("floating_window_rowkey"))) {
            bool2 = true;
          }
        }
      }
      QLog.d("ReadInjoyFloatingWindowModule", 1, "checkParamsLegal outside" + bool1 + " isLegal=" + bool2);
      return bool2;
    }
  }
  
  private static boolean a(Bundle paramBundle, Intent paramIntent, int paramInt)
  {
    boolean bool3 = false;
    if (Build.VERSION.SDK_INT >= 21) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool3;
      if (paramBundle != null)
      {
        bool2 = bool3;
        if (bool1)
        {
          String str = paramBundle.getString("floating_window_rowkey");
          paramBundle = paramBundle.getString("float_layer_article_url");
          bool2 = bool3;
          if (!TextUtils.isEmpty(str))
          {
            ArticleInfo localArticleInfo = new ArticleInfo();
            localArticleInfo.innerUniqueID = str;
            localArticleInfo.mChannelID = paramInt;
            if (!TextUtils.isEmpty(paramBundle)) {
              localArticleInfo.mArticleContentUrl = paramBundle;
            }
            paramIntent.putExtra("fast_web_article_info", localArticleInfo);
            bool2 = true;
          }
        }
      }
      QLog.d("ReadInjoyFloatingWindowModule", 1, " ocheckOpenNativeVertify isVersionLegal=" + bool1 + " isLegal=" + bool2);
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkbx
 * JD-Core Version:    0.7.0.1
 */