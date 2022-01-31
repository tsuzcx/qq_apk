package com.tencent.gdtad.statistics;

public class GdtTraceReporter
{
  public static void a(int paramInt, String paramString1, String paramString2)
  {
    paramString1 = "http://t.gdt.qq.com/conv/src/50/conv?" + "click_id={$clickid$}&product_id={$appid$}&conv_type={$convtype$}&conv_time={$convtime$}".replace("{$clickid$}", paramString1).replace("{$appid$}", paramString2).replace("{$convtype$}", new StringBuilder().append(paramInt).append("").toString()).replace("{$convtime$}", new StringBuilder().append(System.currentTimeMillis()).append("").toString());
    GdtReporter.a().a(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.gdtad.statistics.GdtTraceReporter
 * JD-Core Version:    0.7.0.1
 */