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
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if ("LRC".equals(paramString2.toUpperCase())) {
      return this.jdField_a_of_type_ComTencentBizVideostoryWidgetEasylyricILyricParser.a(paramString1);
    }
    if ("QRC".equals(paramString2.toUpperCase())) {
      return this.b.a(paramString1);
    }
    return null;
  }
  
  public Sentence a(Lyric paramLyric, long paramLong)
  {
    Object localObject = null;
    if (paramLyric == null) {
      return null;
    }
    List localList = paramLyric.a();
    if (localList == null) {
      return null;
    }
    int k = localList.size();
    if (k < 1) {
      return null;
    }
    int i = 0;
    int m;
    Sentence localSentence;
    do
    {
      int j;
      do
      {
        m = k - 1;
        paramLyric = (Lyric)localObject;
        if (i >= m) {
          break;
        }
        paramLyric = (Sentence)localList.get(i);
        j = i + 1;
        localSentence = (Sentence)localList.get(j);
        i = j;
      } while (paramLong < paramLyric.a);
      i = j;
    } while (localSentence.a < paramLong);
    localObject = paramLyric;
    if (paramLyric == null) {
      localObject = (Sentence)localList.get(m);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.videostory.widget.easylyric.LyricParserHelper
 * JD-Core Version:    0.7.0.1
 */