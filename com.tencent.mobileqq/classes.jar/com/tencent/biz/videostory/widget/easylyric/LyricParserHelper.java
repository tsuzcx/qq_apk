package com.tencent.biz.videostory.widget.easylyric;

import android.text.TextUtils;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import java.util.List;

public class LyricParserHelper
{
  private static LyricParserHelper.Instance jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricParserHelper$Instance = new LyricParserHelper.Instance();
  private ILyricParser jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricParser = new CommonLyricParser();
  private ILyricParser b = new QrcLyricParser();
  
  public static LyricParserHelper a()
  {
    return (LyricParserHelper)jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricLyricParserHelper$Instance.getInstance();
  }
  
  public Lyric a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    do
    {
      return null;
      if ("LRC".equals(paramString2.toUpperCase())) {
        return this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricParser.a(paramString1);
      }
    } while (!"QRC".equals(paramString2.toUpperCase()));
    return this.b.a(paramString1);
  }
  
  public Sentence a(Lyric paramLyric, long paramLong)
  {
    Object localObject;
    if (paramLyric == null)
    {
      localObject = null;
      return localObject;
    }
    List localList = paramLyric.a();
    if (localList == null) {
      return null;
    }
    int j = localList.size();
    if (j < 1) {
      return null;
    }
    int i = 0;
    label43:
    if (i < j - 1)
    {
      paramLyric = (Sentence)localList.get(i);
      localObject = (Sentence)localList.get(i + 1);
      if ((paramLong < paramLyric.a) || (((Sentence)localObject).a < paramLong)) {}
    }
    for (;;)
    {
      localObject = paramLyric;
      if (paramLyric != null) {
        break;
      }
      return (Sentence)localList.get(j - 1);
      i += 1;
      break label43;
      paramLyric = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricParserHelper
 * JD-Core Version:    0.7.0.1
 */