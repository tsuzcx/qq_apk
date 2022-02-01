package com.tencent.av.utils;

import java.util.HashMap;

final class PerfReporter$2
  extends HashMap<String, PerfReporter.DeltaTime>
{
  PerfReporter$2()
  {
    put("prerender_time", new PerfReporter.DeltaTime(null));
    put("aefilter_time", new PerfReporter.DeltaTime(null));
    put("postrender_time", new PerfReporter.DeltaTime(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.PerfReporter.2
 * JD-Core Version:    0.7.0.1
 */