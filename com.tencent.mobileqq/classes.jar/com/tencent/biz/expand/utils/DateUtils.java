package com.tencent.biz.expand.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/utils/DateUtils;", "", "()V", "formatDate", "", "time", "", "isDayMore", "", "compareDay", "", "lastTime", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class DateUtils
{
  public static final DateUtils a = new DateUtils();
  
  @Nullable
  public final String a(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd").format(new Date(paramLong));
  }
  
  public final boolean a(int paramInt, long paramLong)
  {
    return (System.currentTimeMillis() - paramLong) * 1.0D / 86400000.0D >= paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.utils.DateUtils
 * JD-Core Version:    0.7.0.1
 */