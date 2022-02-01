package com.tencent.luggage.wxa.on;

import android.widget.Toast;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;

public class k
  implements i
{
  protected final d a;
  
  public k(@NonNull d paramd)
  {
    this.a = paramd;
  }
  
  public void a(@NonNull String paramString)
  {
    Toast.makeText(this.a.ah(), String.format("jsapi banned %s", new Object[] { paramString }), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.on.k
 * JD-Core Version:    0.7.0.1
 */