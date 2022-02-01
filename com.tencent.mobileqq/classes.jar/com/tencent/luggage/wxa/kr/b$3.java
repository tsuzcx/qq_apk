package com.tencent.luggage.wxa.kr;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ActivityResultCallback;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.i.e;

class b$3
  implements i.e
{
  b$3(b paramb, a parama, Activity paramActivity, c paramc, int paramInt) {}
  
  public void a(MenuItem paramMenuItem, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      paramMenuItem = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
      paramMenuItem.setType("vnd.android.cursor.item/person");
      b.a(this.e, paramMenuItem, this.a, this.b, this.c);
      localObject = new b.3.2(this);
      try
      {
        LuggageActivityHelper.FOR(this.b).startActivityForResultThrows(paramMenuItem, (LuggageActivityHelper.ActivityResultCallback)localObject);
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        o.b("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case1, get RemoteException[%s] retry", new Object[] { localRemoteException1 });
        LuggageActivityHelper.FOR(this.b).startActivityForResult(paramMenuItem, (LuggageActivityHelper.ActivityResultCallback)localObject);
        return;
      }
    }
    paramMenuItem = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
    b.a(this.e, paramMenuItem, this.a, this.b, this.c);
    this.b.startActivity(paramMenuItem);
    Object localObject = new b.3.1(this);
    try
    {
      LuggageActivityHelper.FOR(this.b).startActivityForResultThrows(paramMenuItem, (LuggageActivityHelper.ActivityResultCallback)localObject);
      return;
    }
    catch (RemoteException localRemoteException2)
    {
      o.b("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case0, get RemoteException[%s] retry", new Object[] { localRemoteException2 });
      b.a(paramMenuItem);
      LuggageActivityHelper.FOR(this.b).startActivityForResult(paramMenuItem, (LuggageActivityHelper.ActivityResultCallback)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kr.b.3
 * JD-Core Version:    0.7.0.1
 */