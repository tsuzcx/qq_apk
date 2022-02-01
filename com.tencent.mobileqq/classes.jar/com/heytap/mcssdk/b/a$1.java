package com.heytap.mcssdk.b;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.f.d;

class a$1
  implements Runnable
{
  a$1(a parama, Context paramContext) {}
  
  public void run()
  {
    if (d.a(this.a)) {
      return;
    }
    String str2 = this.a.getString(2131916979);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "System Default Channel";
    }
    boolean bool = a.a(this.b, this.a, "Heytap PUSH", str1, 3);
    d.a(this.a, bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.b.a.1
 * JD-Core Version:    0.7.0.1
 */