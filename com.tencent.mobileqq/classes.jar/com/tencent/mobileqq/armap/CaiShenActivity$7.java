package com.tencent.mobileqq.armap;

import android.text.TextUtils;

class CaiShenActivity$7
  implements Runnable
{
  CaiShenActivity$7(CaiShenActivity paramCaiShenActivity) {}
  
  public void run()
  {
    
    if (CaiShenActivity.access$200(this.this$0) == 4) {}
    for (String str = CaiShenActivity.access$400(this.this$0);; str = CaiShenActivity.access$500(this.this$0))
    {
      if (!TextUtils.isEmpty(str)) {
        JniCommon.nativeSetModelLogo(str);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.CaiShenActivity.7
 * JD-Core Version:    0.7.0.1
 */