package com.tencent.mm.plugin.appbrand.keylogger;

import com.tencent.luggage.wxa.nk.c.c;
import java.util.Comparator;

class KeyStepAnalyserDetailActivity$2
  implements Comparator<c.c>
{
  KeyStepAnalyserDetailActivity$2(KeyStepAnalyserDetailActivity paramKeyStepAnalyserDetailActivity) {}
  
  public int a(c.c paramc1, c.c paramc2)
  {
    if (paramc1.g > paramc2.g) {
      return -1;
    }
    if (paramc1.g < paramc2.g) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserDetailActivity.2
 * JD-Core Version:    0.7.0.1
 */