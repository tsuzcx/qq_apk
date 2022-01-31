package com.tencent.a.a.a.a;

import android.content.Context;
import android.util.Log;
import com.tencent.wxop.stat.common.g;

public final class e
  extends f
{
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(String paramString)
  {
    try
    {
      Log.i("MID", "write mid to Settings.System");
      g.a(this.a).a(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="), paramString);
      return;
    }
    finally {}
  }
  
  protected final boolean a()
  {
    return h.a(this.a, "android.permission.WRITE_SETTINGS");
  }
  
  protected final String b()
  {
    try
    {
      Log.i("MID", "read mid from Settings.System");
      String str = g.a(this.a).a(h.f("4kU71lN96TJUomD1vOU9lgj9Tw=="));
      return str;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.a.a.a.a.e
 * JD-Core Version:    0.7.0.1
 */