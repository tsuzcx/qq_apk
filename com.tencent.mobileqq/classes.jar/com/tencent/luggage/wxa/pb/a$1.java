package com.tencent.luggage.wxa.pb;

import android.content.Context;
import android.widget.Toast;

final class a$1
  implements Runnable
{
  a$1(Context paramContext, boolean paramBoolean) {}
  
  public void run()
  {
    Context localContext = this.a.getApplicationContext();
    String str;
    if (this.b) {
      str = this.a.getString(2131886773);
    } else {
      str = this.a.getString(2131886771);
    }
    Toast.makeText(localContext, str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pb.a.1
 * JD-Core Version:    0.7.0.1
 */