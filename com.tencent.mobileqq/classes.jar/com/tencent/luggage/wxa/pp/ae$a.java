package com.tencent.luggage.wxa.pp;

import android.content.Context;
import android.content.ContextWrapper;
import androidx.annotation.Nullable;

public class ae$a
{
  @Nullable
  public static ae a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    if ((paramContext instanceof ae)) {
      return (ae)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      Context localContext = ((ContextWrapper)paramContext).getBaseContext();
      if (localContext != paramContext) {
        return a(localContext);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.ae.a
 * JD-Core Version:    0.7.0.1
 */