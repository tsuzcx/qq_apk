package com.tencent.mm.plugin.appbrand.appcache;

import android.content.res.Resources;
import android.util.SparseIntArray;
import androidx.annotation.StringRes;
import com.tencent.luggage.wxa.qz.r;

public final class b
{
  private static final SparseIntArray a = new SparseIntArray(3);
  
  static
  {
    a.put(1, 2131886758);
    a.put(2, 2131886757);
  }
  
  public static String a(int paramInt)
  {
    paramInt = b(paramInt);
    return r.d().getString(paramInt);
  }
  
  @StringRes
  public static int b(int paramInt)
  {
    return a.get(paramInt, 2131886906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b
 * JD-Core Version:    0.7.0.1
 */