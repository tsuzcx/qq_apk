package com.tencent.biz.qqstory.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

final class DateUtils$2
  extends ThreadLocal<DateFormat>
{
  protected DateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.DateUtils.2
 * JD-Core Version:    0.7.0.1
 */