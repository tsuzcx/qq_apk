package com.tencent.biz.common.offline;

import com.tencent.biz.common.offline.util.ILog;

final class HtmlOffline$3
  implements AsyncBack
{
  public void loaded(String paramString, int paramInt)
  {
    if ((paramInt == 0) && (HtmlOffline.a.a())) {
      HtmlOffline.a.a("HtmlCheckUpdate", 2, "CODE_SUCCESS");
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.3
 * JD-Core Version:    0.7.0.1
 */