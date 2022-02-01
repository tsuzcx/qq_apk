package com.tencent.biz.qcircleshadow.lib.variation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.mobileqq.emoticon.QQEmojiUtil;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiUniversalPanel.Builder;
import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.qcircle.tempapi.api.IQQBaseService;
import com.tencent.mobileqq.qcircle.tempapi.api.IQZoneService;
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.TextUtils.LoadSysEmojiCallback;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class HostEmotionUtil
{
  public static String EMO_PREFIX()
  {
    return QCircleServiceImpl.getQZoneService().EMO_PREFIX();
  }
  
  public static String EMO_TAIL()
  {
    return QCircleServiceImpl.getQZoneService().EMO_TAIL();
  }
  
  public static String SIGN_ICON_URL_END()
  {
    return QCircleServiceImpl.getQZoneService().SIGN_ICON_URL_END();
  }
  
  public static String SIGN_ICON_URL_PREFIX()
  {
    return QCircleServiceImpl.getQZoneService().SIGN_ICON_URL_PREFIX();
  }
  
  public static Pattern SMILEY_PATTERN()
  {
    return QCircleServiceImpl.getQZoneService().SMILEY_PATTERN();
  }
  
  public static void addToCommonUse(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo)
  {
    paramSystemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.waitAppRuntime(null), null);
  }
  
  public static String getDescription(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      if (QQSysFaceUtil.getLocalIdFromEMCode(paramString) != -1) {
        return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.getLocalIdFromEMCode(paramString));
      }
    } while (QQEmojiUtil.getLocalIdFromEMCode(paramString) == -1);
    return QQEmojiUtil.getEmojiDescription(QQEmojiUtil.getLocalIdFromEMCode(paramString));
  }
  
  public static int getDoubleEmoji(int paramInt1, int paramInt2)
  {
    return QCircleServiceImpl.getQQService().getDoubleEmoji(paramInt1, paramInt2);
  }
  
  public static int getEmoCount(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().getEmoCount(paramString);
  }
  
  public static Drawable getEmoDrawable(int paramInt1, int paramInt2)
  {
    return ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmoDrawable(paramInt1, paramInt2);
  }
  
  public static Drawable getEmoDrawableFromEMCode(String paramString)
  {
    return ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmoDrawableFromEMCode(paramString);
  }
  
  public static String getEmoString(int paramInt1, int paramInt2)
  {
    return ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmoString(paramInt1, paramInt2);
  }
  
  public static String getEmoUrlFromConfig(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().getEmoUrlFromConfig(paramString);
  }
  
  public static Drawable getEmojiDrawable(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
  {
    return ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmojiDrawable(paramInt);
  }
  
  public static View getEmojiPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    return new SystemAndEmojiUniversalPanel.Builder(paramContext).setFilterSysFaceBeyond255Enable(true).setEmoticonCallback(paramEmoticonCallback).setShowCommonUsedSystemEmoji(true).create(QCircleServiceImpl.getQQService().getEmotionImpl());
  }
  
  public static String getEmojiString(int paramInt)
  {
    return com.tencent.mobileqq.text.TextUtils.getEmojiString(paramInt);
  }
  
  public static int getEmojiUnicode(int paramInt)
  {
    return QCircleServiceImpl.getQQService().getEmojiUnicode(paramInt);
  }
  
  public static String getFaceString(int paramInt)
  {
    return QCircleServiceImpl.getQQService().getFaceString(paramInt);
  }
  
  public static int getLocalIdFromEMCodeFromEmoji(String paramString)
  {
    return QCircleServiceImpl.getQQService().getLocalIdFromEMCodeFromEmoji(paramString);
  }
  
  public static int getLocalIdFromEMCodeFromSystem(String paramString)
  {
    return QCircleServiceImpl.getQQService().getLocalIdFromEMCodeFromSystem(paramString);
  }
  
  public static int getSingleEmoji(int paramInt)
  {
    return QCircleServiceImpl.getQQService().getSingleEmoji(paramInt);
  }
  
  public static Drawable getSysEmotcationDrawable(int paramInt, boolean paramBoolean)
  {
    return com.tencent.mobileqq.text.TextUtils.getSysEmotcationDrawable(paramInt, paramBoolean);
  }
  
  public static boolean isSkinEmoji(int paramInt)
  {
    return QCircleServiceImpl.getQQService().isSkinEmoji(paramInt);
  }
  
  public static String replaceEmoCode(String paramString1, String paramString2)
  {
    return QCircleServiceImpl.getQZoneService().replaceEmoCode(paramString1, paramString2);
  }
  
  public static String splash2Emo(String paramString)
  {
    return QCircleServiceImpl.getQZoneService().splash2Emo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil
 * JD-Core Version:    0.7.0.1
 */