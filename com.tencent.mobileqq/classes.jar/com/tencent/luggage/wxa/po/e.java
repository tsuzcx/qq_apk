package com.tencent.luggage.wxa.po;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.id.a.b;
import com.tencent.luggage.wxa.lr.c;

@SuppressLint({"AppCompatCustomView"})
public class e
  extends f
  implements a
{
  @Nullable
  private c a = null;
  @Nullable
  private a.b b;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  @Nullable
  public a.b getKeyValueSet()
  {
    return this.b;
  }
  
  @Nullable
  public c getReferrerPolicy()
  {
    return this.a;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void setImageByteArray(byte[] paramArrayOfByte) {}
  
  public void setImageFilePath(String paramString) {}
  
  public void setKeyValueSet(@Nullable a.b paramb)
  {
    this.b = paramb;
  }
  
  public void setReferrerPolicy(@Nullable c paramc)
  {
    this.a = paramc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.po.e
 * JD-Core Version:    0.7.0.1
 */