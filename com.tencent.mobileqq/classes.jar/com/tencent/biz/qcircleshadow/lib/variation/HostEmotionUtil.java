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
import com.tencent.mobileqq.qqemoticon.api.ISysEmoApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.TextUtils.LoadSysEmojiCallback;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class HostEmotionUtil
{
  public static String EMO_PREFIX()
  {
    return "[em]";
  }
  
  public static String EMO_TAIL()
  {
    return "[/em]";
  }
  
  public static String SIGN_ICON_URL_END()
  {
    return ".gif";
  }
  
  public static String SIGN_ICON_URL_PREFIX()
  {
    return "https://qzonestyle.gtimg.cn/qzone/em/";
  }
  
  public static Pattern SMILEY_PATTERN()
  {
    return QzoneEmotionUtils.SMILEY_PATTERN;
  }
  
  public static void addToCommonUse(SystemAndEmojiEmoticonInfo paramSystemAndEmojiEmoticonInfo)
  {
    paramSystemAndEmojiEmoticonInfo.addToCommonUsed(MobileQQ.sMobileQQ.waitAppRuntime(null), null);
  }
  
  public static String getDescription(String paramString)
  {
    if (android.text.TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QQSysFaceUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQSysFaceUtil.getFaceDescription(QQSysFaceUtil.getLocalIdFromEMCode(paramString));
    }
    if (QQEmojiUtil.getLocalIdFromEMCode(paramString) != -1) {
      return QQEmojiUtil.getEmojiDescription(QQEmojiUtil.getLocalIdFromEMCode(paramString));
    }
    return null;
  }
  
  public static int getDoubleEmoji(int paramInt1, int paramInt2)
  {
    return EmotcationConstants.getDoubleEmoji(paramInt1, paramInt2);
  }
  
  public static int getEmoCount(String paramString)
  {
    return QzoneEmotionUtils.getEmoCount(paramString);
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
    return QzoneEmotionUtils.getEmoUrlFromConfig(paramString);
  }
  
  public static Drawable getEmojiDrawable(int paramInt, TextUtils.LoadSysEmojiCallback paramLoadSysEmojiCallback)
  {
    return ((ISysEmoApi)QRoute.api(ISysEmoApi.class)).getEmojiDrawable(paramInt);
  }
  
  public static View getEmojiPanel(Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    return new SystemAndEmojiUniversalPanel.Builder(paramContext).setEmoticonCallback(paramEmoticonCallback).setShowCommonUsedSystemEmoji(true).create(QCircleServiceImpl.getQQService().getEmotionImpl());
  }
  
  public static String getEmojiString(int paramInt)
  {
    return com.tencent.mobileqq.text.TextUtils.getEmojiString(paramInt);
  }
  
  public static int getEmojiUnicode(int paramInt)
  {
    return QQEmojiUtil.getEmojiUnicode(paramInt);
  }
  
  public static String getFaceString(int paramInt)
  {
    return QQSysFaceUtil.getFaceString(paramInt);
  }
  
  public static int getLocalIdFromEMCodeFromEmoji(String paramString)
  {
    return QQEmojiUtil.getLocalIdFromEMCode(paramString);
  }
  
  public static int getLocalIdFromEMCodeFromSystem(String paramString)
  {
    return QQSysFaceUtil.getLocalIdFromEMCode(paramString);
  }
  
  public static int getSingleEmoji(int paramInt)
  {
    return EmotcationConstants.getSingleEmoji(paramInt);
  }
  
  public static Drawable getSysEmotcationDrawable(int paramInt, boolean paramBoolean)
  {
    return com.tencent.mobileqq.text.TextUtils.getSysEmotcationDrawable(paramInt, paramBoolean);
  }
  
  public static boolean isSkinEmoji(int paramInt)
  {
    return EmotcationConstants.isSkinEmoji(paramInt);
  }
  
  public static String replaceEmoCode(String paramString1, String paramString2)
  {
    return QzoneEmotionUtils.replaceEmoCode(paramString1, paramString2);
  }
  
  public static String splash2Emo(String paramString)
  {
    return QzoneEmotionUtils.splash2Emo(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.variation.HostEmotionUtil
 * JD-Core Version:    0.7.0.1
 */