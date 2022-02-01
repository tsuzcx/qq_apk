package com.tencent.luggage.wxa.pb;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.py.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;

public class a
{
  private static void a(@NonNull Context paramContext, boolean paramBoolean)
  {
    t.a(new a.1(paramContext, paramBoolean));
  }
  
  public static boolean a(boolean paramBoolean, @NonNull Context paramContext, @NonNull String paramString, int paramInt)
  {
    if (paramBoolean) {}
    try
    {
      if (((com.tencent.luggage.wxa.iy.a)e.a(com.tencent.luggage.wxa.iy.a.class)).c(paramString, paramInt))
      {
        new b(paramContext).a(paramContext.getResources().getString(2131886901)).a();
        return true;
      }
      a(paramContext, paramBoolean);
      return false;
    }
    catch (Exception localException)
    {
      int i;
      MMAlertDialog localMMAlertDialog;
      o.b("MicroMsg.CollectionModifyInteractLogic", "performClick, (%s %d) added = %b, modify e = %s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean), localException });
      a(paramContext, paramBoolean);
    }
    i = ((com.tencent.luggage.wxa.iy.a)e.a(com.tencent.luggage.wxa.iy.a.class)).b(paramString, paramInt);
    if (i == 0)
    {
      new b(paramContext).a(paramContext.getResources().getString(2131886900)).a();
      return true;
    }
    if (i == -2)
    {
      i = ((com.tencent.luggage.wxa.iy.a)e.a(com.tencent.luggage.wxa.iy.a.class)).e();
      localMMAlertDialog = new MMAlertDialog.Builder(paramContext).setTitle("").setMsg(paramContext.getResources().getString(2131886756, new Object[] { Integer.valueOf(i) })).setPositiveBtnText(2131891461).setCancelable(false).create();
      if (localMMAlertDialog != null)
      {
        localMMAlertDialog.setCanceledOnTouchOutside(false);
        localMMAlertDialog.setCanBack(true);
        localMMAlertDialog.show();
        return false;
      }
    }
    else if (i == -3)
    {
      localMMAlertDialog = new MMAlertDialog.Builder(paramContext).setTitle("").setMsg(2131886755).setPositiveBtnText(2131891461).setCancelable(false).create();
      if (localMMAlertDialog != null)
      {
        localMMAlertDialog.setCanceledOnTouchOutside(false);
        localMMAlertDialog.setCanBack(true);
        localMMAlertDialog.show();
        return false;
      }
    }
    else
    {
      a(paramContext, paramBoolean);
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pb.a
 * JD-Core Version:    0.7.0.1
 */