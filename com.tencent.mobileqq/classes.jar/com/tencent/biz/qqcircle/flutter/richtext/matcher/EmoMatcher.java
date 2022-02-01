package com.tencent.biz.qqcircle.flutter.richtext.matcher;

import com.tencent.biz.qqcircle.bizparts.danmaku.matcher.TextMatcher;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCell;
import com.tencent.biz.qqcircle.bizparts.danmaku.text.TextLayoutBase;
import com.tencent.biz.qqcircle.flutter.richtext.QcircleFlutterTextCellParser;
import com.tencent.qcircle.cooperation.config.QCircleConfigHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public class EmoMatcher
  extends TextMatcher
{
  public EmoMatcher(Pattern paramPattern)
  {
    super(paramPattern);
  }
  
  public static String b(String paramString)
  {
    return QCircleConfigHelper.a("QZoneSetting", "EmotionURL", "https://qzonestyle.gtimg.cn/qzone/em/$id@2x.gif#kp=1").replace("$id", paramString);
  }
  
  public ArrayList<TextCell> a(int paramInt, boolean paramBoolean, TextLayoutBase paramTextLayoutBase, CharSequence paramCharSequence, ArrayList<TextCell> paramArrayList)
  {
    return null;
  }
  
  public HashMap<String, Object> a(int paramInt, boolean paramBoolean, CharSequence paramCharSequence)
  {
    paramCharSequence = new HashMap();
    try
    {
      paramCharSequence.put("emojiUrl", b(this.a.substring(4, this.a.indexOf("[/em]"))));
      paramCharSequence.put("nodeType", Integer.valueOf(QcircleFlutterTextCellParser.r));
      paramCharSequence.put("displayWidth", Double.valueOf(20.0D));
      paramCharSequence.put("displayHeight", Double.valueOf(20.0D));
      return paramCharSequence;
    }
    catch (Exception localException)
    {
      QLog.d(QcircleFlutterTextCellParser.a, 1, localException.getMessage());
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.richtext.matcher.EmoMatcher
 * JD-Core Version:    0.7.0.1
 */