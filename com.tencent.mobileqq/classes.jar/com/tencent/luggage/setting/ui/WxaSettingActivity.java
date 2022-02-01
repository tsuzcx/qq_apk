package com.tencent.luggage.setting.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.Preference;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import com.tencent.luggage.ui.WmpfPresentationActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper;
import com.tencent.luggage.util.LuggageActivityHelper.ILuggageActivityHelper;
import com.tencent.luggage.util.PresentationActivityHelper;
import com.tencent.luggage.wxa.qw.fj;
import com.tencent.luggage.wxa.qw.jc;
import com.tencent.luggage.wxa.qw.jd;
import com.tencent.luggage.wxa.qw.lg;
import com.tencent.luggage.wxa.qw.lh;
import com.tencent.luggage.wxa.qw.lp;
import com.tencent.luggage.wxa.qw.lq;
import com.tencent.luggage.wxa.qw.n;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.luggage.wxa.qz.x;
import com.tencent.mm.modelappbrand.image.AppBrandSimpleImageLoader;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.weui.base.preference.IPreferenceScreen;
import com.tencent.weui.base.preference.WeUIPreference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WxaSettingActivity
  extends WeUIPreference
  implements LuggageActivityHelper.ILuggageActivityHelper
{
  private com.tencent.luggage.wxa.ek.a A;
  private com.tencent.luggage.wxa.di.b B;
  private com.tencent.luggage.wxa.di.b C;
  private com.tencent.luggage.wxa.di.b D;
  private int E = 0;
  @Nullable
  private int[] F;
  private com.tencent.luggage.wxa.eh.c G;
  private com.tencent.luggage.wxa.eh.b H;
  private WxaSettingActivity.c I;
  private Context J;
  private View K;
  private boolean L = false;
  protected IPreferenceScreen a;
  boolean b = false;
  boolean c = false;
  List<n> d = new ArrayList();
  private com.tencent.luggage.wxa.di.a h;
  private com.tencent.luggage.wxa.di.c i;
  private n j;
  private n k;
  private n l;
  private int m;
  private int n;
  private String o;
  private String p;
  private String q;
  private boolean r = true;
  private boolean s = false;
  private boolean t = false;
  private boolean u = false;
  private int v = 0;
  private int w;
  private boolean x = false;
  private com.tencent.mm.plugin.appbrand.widget.dialog.d y;
  private com.tencent.luggage.wxa.ek.a z;
  
  private int a(com.tencent.luggage.wxa.ih.d paramd)
  {
    boolean bool = paramd.j();
    int i1 = 1;
    if (bool) {
      return -1;
    }
    if (paramd.g() == 1) {
      return 1;
    }
    if (paramd.g() == 0) {
      i1 = 0;
    }
    return i1;
  }
  
  private void a(int paramInt)
  {
    int i1 = l();
    if (paramInt != i1)
    {
      this.s = true;
      o.d("Luggage.STANDALONE.WxaSettingActivity", "onClickLocationPreference, change location state to:%s", new Object[] { Integer.valueOf(paramInt) });
      b(paramInt);
      a(new WxaSettingActivity.25(this, paramInt, i1));
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, @Nullable int[] paramArrayOfInt, @Nullable WxaSettingActivity.d paramd)
  {
    Intent localIntent = new Intent(paramContext, WxaSettingActivity.class);
    localIntent.putExtra("KEY_APPID", paramString1);
    localIntent.putExtra("KEY_USERNAME", paramString2);
    localIntent.putExtra("KEY_NICKNAME", paramString3);
    localIntent.putExtra("KEY_FORCE_ACTIVITY_FULLSCREEN", com.tencent.mm.plugin.appbrand.ui.c.a(paramContext));
    localIntent.putExtra("KEY_DISPLAY_ID", paramInt);
    if ((paramBoolean) && (paramInt == 0)) {
      localIntent.putExtra("KEY_UI_THEME", 1);
    }
    if (paramArrayOfInt != null) {
      localIntent.putExtra("KEY_MENU_VIEW_SIZE", paramArrayOfInt);
    }
    ((PresentationActivityHelper)LuggageActivityHelper.FOR(paramContext, PresentationActivityHelper.class)).startActivityForResult(localIntent, new WxaSettingActivity.18(paramd));
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean, @Nullable WxaSettingActivity.d paramd)
  {
    a(paramContext, paramString1, paramString2, paramString3, paramBoolean, 0, null, paramd);
  }
  
  private void a(Preference paramPreference)
  {
    if (paramPreference.getKey().equalsIgnoreCase("both"))
    {
      this.w = 2;
      this.B.a(false);
      this.C.a(false);
      paramPreference = this.D;
      if (paramPreference != null) {
        paramPreference.a(true);
      }
    }
    else if (paramPreference.getKey().equalsIgnoreCase("foreground"))
    {
      this.w = 1;
      this.C.a(true);
      this.B.a(false);
      paramPreference = this.D;
      if (paramPreference != null) {
        paramPreference.a(false);
      }
    }
    else
    {
      this.w = 0;
      this.B.a(true);
      this.C.a(false);
      paramPreference = this.D;
      if (paramPreference != null) {
        paramPreference.a(false);
      }
    }
    this.a.notifyDataSetChanged();
  }
  
  private void a(WxaSettingActivity.b paramb)
  {
    if (!x.a(r.a()))
    {
      Toast.makeText(this.J, getString(2131916366), 1).show();
      if (paramb != null) {
        paramb.a(false);
      }
      return;
    }
    t.a(new WxaSettingActivity.9(this, paramb));
  }
  
  private void a(com.tencent.luggage.wxa.di.a parama, n paramn)
  {
    this.l = paramn;
    if (this.l.d == null) {
      return;
    }
    this.m = this.l.d.d;
    parama.a(com.tencent.luggage.wxa.qx.a.e(this.J, 40), com.tencent.luggage.wxa.qx.a.e(this.J, 40));
    parama.setPersistent(false);
    parama.setKey(this.l.a);
    parama.setTitle(this.l.b);
    this.H = new com.tencent.luggage.wxa.eh.b(this.l.d);
    if (this.l.c == 2)
    {
      parama.setSummary(2131886770);
      parama.a(null);
      parama.c(8);
      parama.b(8);
      return;
    }
    parama.setSummary("");
    parama.a(2130842125);
    parama.c(0);
    parama.b(0);
    paramn = new StringBuilder();
    paramn.append("userinfo default_avatar_id = ");
    paramn.append(this.l.d.d);
    o.d("Luggage.STANDALONE.WxaSettingActivity", paramn.toString());
    paramn = this.l.d.a.iterator();
    while (paramn.hasNext())
    {
      jd localjd = (jd)paramn.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("userinfo list avatar id = ");
      localStringBuilder.append(localjd.a);
      o.d("Luggage.STANDALONE.WxaSettingActivity", localStringBuilder.toString());
      if (this.l.d.d == localjd.a) {
        AppBrandSimpleImageLoader.instance().load(new WxaSettingActivity.28(this, parama), localjd.c, new WxaSettingActivity.29(this));
      }
    }
  }
  
  private void a(com.tencent.luggage.wxa.eh.c paramc)
  {
    com.tencent.luggage.wxa.ej.a.a.a(this.q, this.o, paramc, new WxaSettingActivity.26(this));
  }
  
  private void a(lq paramlq)
  {
    if ((paramlq.b != null) && (paramlq.b.size() > 0))
    {
      paramlq = paramlq.b.iterator();
      while (paramlq.hasNext())
      {
        n localn = (n)paramlq.next();
        if ("scope.userInfo".equals(localn.a))
        {
          int i1 = 0;
          while (i1 < this.d.size())
          {
            if ("scope.userInfo".equals(((n)this.d.get(i1)).a)) {
              break label109;
            }
            i1 += 1;
          }
          i1 = -1;
          label109:
          if (i1 != -1)
          {
            this.d.remove(i1);
            this.d.add(i1, localn);
          }
          else
          {
            this.d.add(localn);
          }
          runOnUiThread(new WxaSettingActivity.30(this, localn));
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    com.tencent.luggage.wxa.ej.a.a.a(paramString, this.o, new WxaSettingActivity.7(this));
  }
  
  private void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.x = false;
    this.A = this.z;
    this.z = new com.tencent.luggage.wxa.ek.a(this, this.J, this.F);
    com.tencent.luggage.wxa.ek.a locala = this.z;
    String str = paramString;
    if (af.c(paramString)) {
      str = getString(2131886769);
    }
    locala.a(str);
    this.z.b(new WxaSettingActivity.20(this));
    this.z.a(new WxaSettingActivity.21(this));
    this.z.a(new WxaSettingActivity.22(this));
    this.a = this.z.j();
    paramString = this.a;
    if (paramString == null) {
      return;
    }
    paramString.removeAll();
    this.y.a(this.z);
    this.A.getContentView().postDelayed(new WxaSettingActivity.24(this), 100L);
    this.B = new com.tencent.luggage.wxa.di.b(this.J);
    this.B.setKey("none");
    this.B.a(2131887135);
    this.a.addPreference(this.B);
    this.C = new com.tencent.luggage.wxa.di.b(this.J);
    this.C.setKey("foreground");
    this.C.a(2131887134);
    this.a.addPreference(this.C);
    if (paramBoolean)
    {
      this.D = new com.tencent.luggage.wxa.di.b(this.J);
      this.D.setKey("both");
      this.D.a(2131887133);
      this.a.addPreference(this.D);
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        this.B.a(true);
      }
      else
      {
        paramString = this.D;
        if (paramString != null) {
          paramString.a(true);
        }
      }
    }
    else {
      this.C.a(true);
    }
    this.a.notifyDataSetChanged();
  }
  
  private void a(String paramString, @Nullable WxaSettingActivity.b paramb)
  {
    LinkedList localLinkedList = new LinkedList();
    int i1 = l();
    Object localObject = this.d.iterator();
    while (((Iterator)localObject).hasNext())
    {
      n localn = (n)((Iterator)localObject).next();
      if ((localn != null) && ((this.u) || (!this.t) || (!localn.a.equals("scope.userLocationBackground")) || (i1 == 2)))
      {
        fj localfj = new fj();
        if (localn.a.equals("scope.userInfo")) {
          localfj.c = this.m;
        }
        localfj.a = localn.a;
        localfj.b = localn.c;
        localLinkedList.add(localfj);
      }
    }
    localObject = new lp();
    ((lp)localObject).a = paramString;
    ((lp)localObject).b = localLinkedList;
    ((com.tencent.luggage.wxa.ob.b)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp_modauth", paramString, (com.tencent.luggage.wxa.qu.a)localObject, lq.class).d(new WxaSettingActivity.17(this)).a(new WxaSettingActivity.16(this)).a(new WxaSettingActivity.15(this, paramb)).a(new WxaSettingActivity.14(this, paramb));
  }
  
  private void a(List<n> paramList, com.tencent.luggage.wxa.eh.c paramc)
  {
    if ((this.b) && (this.c)) {
      b(paramList, paramc);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    runOnUiThread(new WxaSettingActivity.31(this, paramBoolean));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, Preference paramPreference, IPreferenceScreen paramIPreferenceScreen, n paramn)
  {
    t.a(new WxaSettingActivity.8(this, paramBoolean1, paramPreference, paramBoolean2, paramn, paramIPreferenceScreen));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1 = this.n;
    Object localObject;
    if (i1 == 0)
    {
      if (getDefaultSharedPreferences() != null)
      {
        localObject = getDefaultSharedPreferences().edit();
        ((SharedPreferences.Editor)localObject).putBoolean("foreground", paramBoolean1);
        ((SharedPreferences.Editor)localObject).putBoolean("none", paramBoolean2);
        ((SharedPreferences.Editor)localObject).putBoolean("both", paramBoolean3);
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    else if (i1 == 1)
    {
      localObject = this.z;
      if ((localObject != null) && (((com.tencent.luggage.wxa.ek.a)localObject).m() != null))
      {
        localObject = this.z.m().edit();
        ((SharedPreferences.Editor)localObject).putBoolean(this.C.getKey(), paramBoolean1);
        ((SharedPreferences.Editor)localObject).putBoolean(this.B.getKey(), paramBoolean2);
        com.tencent.luggage.wxa.di.b localb = this.D;
        if (localb != null) {
          ((SharedPreferences.Editor)localObject).putBoolean(localb.getKey(), paramBoolean3);
        }
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
  }
  
  public static boolean a(com.tencent.luggage.wxa.oq.c paramc)
  {
    boolean bool = true;
    if (paramc == null)
    {
      o.c("Luggage.STANDALONE.WxaSettingActivity", "preferUseDialogMode with invalid window, stack=%s", new Object[] { Log.getStackTraceString(new Throwable()) });
      return false;
    }
    if (!paramc.f())
    {
      if ((paramc instanceof com.tencent.luggage.wxa.os.b)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private boolean a(List<n> paramList, com.tencent.luggage.wxa.eh.c paramc, boolean paramBoolean)
  {
    if (((paramList != null) && ((paramList.size() > 0) || (paramBoolean))) || ((paramc != null) && (paramc.a()))) {
      return false;
    }
    o.b("Luggage.STANDALONE.WxaSettingActivity", "authItems is empty");
    a(true);
    return true;
  }
  
  private void b(int paramInt)
  {
    boolean bool3 = true;
    o.d("Luggage.STANDALONE.WxaSettingActivity", "updateLocationAuthState, state:%d", new Object[] { Integer.valueOf(paramInt) });
    j();
    i();
    n localn;
    if (paramInt == 2)
    {
      localn = this.k;
      if (localn != null) {
        localn.c = 1;
      }
      localn = this.j;
      if (localn != null) {
        localn.c = 1;
      }
    }
    else if (paramInt == 1)
    {
      localn = this.j;
      if (localn != null) {
        localn.c = 1;
      }
      localn = this.k;
      if (localn != null) {
        localn.c = 2;
      }
    }
    else
    {
      localn = this.j;
      if (localn != null) {
        localn.c = 2;
      }
      localn = this.k;
      if (localn != null) {
        localn.c = 2;
      }
    }
    boolean bool1;
    if (paramInt == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramInt == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (paramInt != 2) {
      bool3 = false;
    }
    a(bool1, bool2, bool3);
  }
  
  private void b(List<n> paramList)
  {
    paramList = paramList.iterator();
    boolean bool3 = false;
    boolean bool2 = false;
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      boolean bool5 = af.c(localn.a);
      boolean bool4 = true;
      boolean bool1 = true;
      if ((!bool5) && (localn.a.equalsIgnoreCase("scope.userLocation")))
      {
        if (localn.c != 1) {
          bool1 = false;
        }
        bool3 = bool1;
      }
      else if ((!af.c(localn.a)) && (localn.a.equalsIgnoreCase("scope.userLocationBackground")))
      {
        if (localn.c == 1) {
          bool1 = bool4;
        } else {
          bool1 = false;
        }
        bool2 = bool1;
      }
    }
    paramList = new WxaSettingActivity.a();
    paramList.a = bool3;
    paramList.b = bool2;
    com.tencent.luggage.wxa.by.b.a(this.o, paramList);
  }
  
  private void b(List<n> paramList, com.tencent.luggage.wxa.eh.c paramc)
  {
    this.t = b(this.o, paramList);
    if (a(paramList, paramc, this.t)) {
      return;
    }
    if ((this.t) && ((paramList.isEmpty()) || (!d(paramList))))
    {
      j();
      i();
    }
    a(false);
    runOnUiThread(new WxaSettingActivity.27(this, paramList, paramc));
  }
  
  private void b(boolean paramBoolean)
  {
    JSONArray localJSONArray = new JSONArray();
    Object localObject1 = this.d.iterator();
    Object localObject3;
    while (((Iterator)localObject1).hasNext())
    {
      n localn = (n)((Iterator)localObject1).next();
      if (localn != null)
      {
        localObject3 = new JSONObject();
        try
        {
          ((JSONObject)localObject3).put("scope", localn.a);
          ((JSONObject)localObject3).put("state", localn.c);
          ((JSONObject)localObject3).put("desc", localn.b);
          localJSONArray.put(localObject3);
        }
        catch (JSONException localJSONException1)
        {
          o.a("Luggage.STANDALONE.WxaSettingActivity", localJSONException1, "", new Object[0]);
        }
      }
    }
    localObject1 = new JSONObject();
    Object localObject2 = this.G;
    if (localObject2 != null) {
      try
      {
        ((JSONObject)localObject1).put("mainSwitch", ((com.tencent.luggage.wxa.eh.c)localObject2).b());
        localObject2 = new JSONArray();
        localObject3 = this.G.c().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          com.tencent.luggage.wxa.ih.d locald = (com.tencent.luggage.wxa.ih.d)((Iterator)localObject3).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("title", locald.b());
          localJSONObject.put("templateId", locald.c());
          localJSONObject.put("templateType", locald.d());
          localJSONObject.put("status", a(locald));
          localJSONObject.put("tid", locald.k());
          ((JSONArray)localObject2).put(localJSONObject);
        }
        ((JSONObject)localObject1).put("templatesInfo", localObject2);
      }
      catch (JSONException localJSONException2)
      {
        o.a("Luggage.STANDALONE.WxaSettingActivity", localJSONException2, "", new Object[0]);
      }
    }
    o.e("Luggage.STANDALONE.WxaSettingActivity", "authInfo %s", new Object[] { localJSONArray });
    o.d("Luggage.STANDALONE.WxaSettingActivity", "setResData, subscriptionsSetting:%s", new Object[] { localObject1 });
    Intent localIntent = new Intent();
    localIntent.putExtra("KEY_AUTHORIZE_STR", localJSONArray.toString());
    localIntent.putExtra("KEY_APP_SUBSCRIPTIONS_SETTING", ((JSONObject)localObject1).toString());
    localIntent.putExtra("KEY_APP_CLOSE_MENU", paramBoolean);
    c(this.d);
    localIntent.putExtra("KEY_LOCATION_AUTH_FLAG", this.v);
    PresentationActivityHelper.setResult(-1, getIntent(), localIntent);
  }
  
  private static boolean b(String paramString, List<n> paramList)
  {
    if (com.tencent.mm.plugin.appbrand.appstorage.a.a(paramString)) {
      return true;
    }
    return e(paramList);
  }
  
  private void c()
  {
    lg locallg = new lg();
    locallg.a = this.o;
    ((com.tencent.luggage.wxa.ob.b)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.ob.b.class)).b("/cgi-bin/mmbiz-bin/wxaapp_getauthinfo", this.o, locallg, lh.class).a(new WxaSettingActivity.6(this)).d(new WxaSettingActivity.5(this));
  }
  
  private void c(List<n> paramList)
  {
    paramList = paramList.iterator();
    int i4 = 0;
    int i3 = 0;
    int i2 = 0;
    while (paramList.hasNext())
    {
      n localn = (n)paramList.next();
      boolean bool = af.c(localn.a);
      int i5 = 1;
      i1 = 1;
      if ((!bool) && (localn.a.equalsIgnoreCase("scope.userLocation")))
      {
        if (localn.c != 1) {
          i1 = 0;
        }
        i3 = i1;
      }
      else if ((!af.c(localn.a)) && (localn.a.equalsIgnoreCase("scope.userLocationBackground")))
      {
        if (localn.c == 1) {
          i1 = i5;
        } else {
          i1 = 0;
        }
        i2 = i1;
      }
    }
    int i1 = i4;
    if (i3 != 0) {
      i1 = 2;
    }
    this.v = (i1 | i2);
  }
  
  private void c(List<n> paramList, com.tencent.luggage.wxa.eh.c paramc)
  {
    o.d("Luggage.STANDALONE.WxaSettingActivity", "updatePreferencesInternal, authItems size = %d", new Object[] { Integer.valueOf(paramList.size()) });
    paramList = paramList.iterator();
    Object localObject;
    while (paramList.hasNext())
    {
      localObject = (n)paramList.next();
      if (localObject != null)
      {
        o.d("Luggage.STANDALONE.WxaSettingActivity", "updatePreferencesInternal, find scope:%s, state:%d", new Object[] { ((n)localObject).a, Integer.valueOf(((n)localObject).c) });
        if ((!af.c(((n)localObject).a)) && (((n)localObject).a.equalsIgnoreCase("scope.userLocationBackground")))
        {
          this.k = ((n)localObject);
        }
        else if ((!af.c(((n)localObject).a)) && (((n)localObject).a.equalsIgnoreCase("scope.userLocation")))
        {
          this.j = ((n)localObject);
          this.i = new com.tencent.luggage.wxa.di.c(this.J);
          this.i.setPersistent(false);
          this.i.setKey(((n)localObject).a);
          this.i.setTitle(((n)localObject).b);
          this.a.addPreference(this.i);
        }
        else if ((!af.c(((n)localObject).a)) && (((n)localObject).a.equalsIgnoreCase("scope.userInfo")))
        {
          if (this.h == null) {
            this.h = new com.tencent.luggage.wxa.di.a(this.J);
          }
          if (((n)localObject).d == null)
          {
            o.d("Luggage.STANDALONE.WxaSettingActivity", "scope userinfo's UserAvatarInfo is null, can not be add into Preference");
          }
          else
          {
            this.h.setPersistent(false);
            this.a.addPreference(this.h);
            a(this.h, (n)localObject);
          }
        }
        else
        {
          com.tencent.luggage.wxa.di.d locald = new com.tencent.luggage.wxa.di.d(this.J);
          locald.setPersistent(false);
          locald.setKey(((n)localObject).a);
          locald.setTitle(((n)localObject).b);
          boolean bool;
          if (((n)localObject).c == 1) {
            bool = true;
          } else {
            bool = false;
          }
          locald.setChecked(bool);
          this.a.addPreference(locald);
        }
      }
    }
    k();
    if ((paramc != null) && (paramc.a()))
    {
      localObject = new com.tencent.luggage.wxa.di.c(this.J);
      ((com.tencent.luggage.wxa.di.c)localObject).setPersistent(false);
      ((com.tencent.luggage.wxa.di.c)localObject).setKey("preference_key_subscribe_msg");
      ((com.tencent.luggage.wxa.di.c)localObject).setTitle(getString(2131886990));
      if (paramc.b()) {
        paramList = "";
      } else {
        paramList = getString(2131886991);
      }
      ((com.tencent.luggage.wxa.di.c)localObject).setSummary(paramList);
      this.a.addPreference((Preference)localObject);
    }
    this.a.notifyDataSetChanged();
  }
  
  private void d()
  {
    t.a(new WxaSettingActivity.11(this));
  }
  
  private boolean d(List<n> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        n localn = (n)paramList.next();
        if ((localn != null) && (!af.c(localn.a)) && (localn.a.equalsIgnoreCase("scope.userLocation"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void e()
  {
    t.a(new WxaSettingActivity.13(this));
  }
  
  private static boolean e(List<n> paramList)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        n localn = (n)paramList.next();
        if ((localn != null) && (!af.c(localn.a)) && (localn.a.equalsIgnoreCase("scope.userLocationBackground"))) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void f()
  {
    b(true);
  }
  
  private void g()
  {
    if (this.j == null)
    {
      o.d("Luggage.STANDALONE.WxaSettingActivity", "onClickLocationPreference, auth item location is null");
      return;
    }
    int i1 = l();
    o.d("Luggage.STANDALONE.WxaSettingActivity", "onClickLocationPreference, current location state:%s", new Object[] { Integer.valueOf(i1) });
    int i2 = this.n;
    if (i2 == 1)
    {
      a(this.j.b, i1, this.t);
      return;
    }
    if (i2 == 0)
    {
      Intent localIntent = new Intent(this, WmpfAuthorizeDetailUI.class);
      localIntent.putExtra("key_title", this.j.b);
      localIntent.putExtra("key_desc", com.tencent.mm.plugin.appbrand.appstorage.a.b(this.o));
      localIntent.putExtra("key_state", i1);
      localIntent.putExtra("key_three_state", this.t);
      localIntent.putExtra("key_display_id", this.E);
      ((PresentationActivityHelper)LuggageActivityHelper.FOR(this, PresentationActivityHelper.class)).startActivityForResult(localIntent, new WxaSettingActivity.19(this));
    }
  }
  
  private void h()
  {
    WmpfPresentationActivityHelper.a.a(this);
    WmpfPresentationActivityHelper.a.b(this);
    if (this.n == 1)
    {
      overridePendingTransition(0, 0);
      return;
    }
    try
    {
      TypedArray localTypedArray = obtainStyledAttributes(16973825, new int[] { 16842938, 16842939 });
      overridePendingTransition(localTypedArray.getResourceId(0, 0), localTypedArray.getResourceId(1, 0));
      localTypedArray.recycle();
      return;
    }
    catch (Exception localException) {}
  }
  
  private void i()
  {
    if (this.k == null)
    {
      o.d("Luggage.STANDALONE.WxaSettingActivity", "create AuthItemLocationBackground");
      this.k = new n();
      n localn = this.k;
      localn.c = 2;
      localn.a = "scope.userLocationBackground";
      localn.b = getString(2131887137);
      this.d.add(this.k);
    }
  }
  
  private void j()
  {
    if (this.j == null)
    {
      o.d("Luggage.STANDALONE.WxaSettingActivity", "create AuthItemLocation");
      this.j = new n();
      n localn = this.j;
      localn.c = 2;
      localn.a = "scope.userLocation";
      localn.b = getString(2131887137);
      this.d.add(this.j);
    }
  }
  
  private void k()
  {
    if (this.i == null) {
      return;
    }
    int i1 = l();
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        this.i.setSummary(2131887142);
        return;
      }
      this.i.setSummary(2131887140);
      return;
    }
    this.i.setSummary(2131887141);
  }
  
  private int l()
  {
    n localn = this.j;
    int i1;
    if ((localn != null) && (localn.c == 1)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (i1 == 2) {
      return 0;
    }
    localn = this.k;
    if ((localn != null) && (localn.c == 1)) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    if (i1 == 2) {
      return 1;
    }
    return 2;
  }
  
  private void m()
  {
    getWindow().requestFeature(10);
    com.tencent.mm.ui.a.a(getWindow());
    getWindow().getDecorView().setBackgroundColor(0);
    ((ViewGroup)getWindow().getDecorView()).getChildAt(0).setFitsSystemWindows(false);
    getWindow().getDecorView().setFitsSystemWindows(false);
    supportRequestWindowFeature(10);
    supportRequestWindowFeature(1);
  }
  
  private void n()
  {
    this.y = new com.tencent.mm.plugin.appbrand.widget.dialog.d(((com.tencent.mm.ui.base.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.mm.ui.base.e.class)).a(this));
    this.y.setFitsSystemWindows(false);
    ((ViewGroup)getWindow().getDecorView()).addView(this.y);
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public int getResourceId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      o.b("Luggage.STANDALONE.WxaSettingActivity", "onActivityResult, intent is null");
      return;
    }
    o.b("Luggage.STANDALONE.WxaSettingActivity", "onActivityResult: unhandled result");
  }
  
  public void onBackPressed()
  {
    o.e("Luggage.STANDALONE.WxaSettingActivity", "onBackPressed !");
    if (this.n == 1)
    {
      com.tencent.mm.plugin.appbrand.widget.dialog.d locald = this.y;
      if ((locald != null) && (locald.b()))
      {
        this.y.a(new WxaSettingActivity.10(this));
        return;
      }
    }
    f();
    super.onBackPressed();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    com.tencent.luggage.wxa.rh.d.d(this);
    if (getIntent() != null)
    {
      this.F = getIntent().getIntArrayExtra("KEY_MENU_VIEW_SIZE");
      this.E = getIntent().getIntExtra("KEY_DISPLAY_ID", 0);
      this.n = getIntent().getIntExtra("KEY_UI_THEME", 0);
      this.p = getIntent().getStringExtra("KEY_NICKNAME");
      paramBundle = getIntent().getStringExtra("KEY_USERNAME");
      this.q = paramBundle;
      if (af.c(paramBundle))
      {
        o.b("Luggage.STANDALONE.WxaSettingActivity", "username is null");
        h();
        return;
      }
    }
    this.I = new WxaSettingActivity.c(this);
    if (this.n == 1)
    {
      setTheme(2131952522);
      m();
      n();
    }
    else
    {
      setTheme(2131952521);
    }
    try
    {
      paramBundle = obtainStyledAttributes(16973825, new int[] { 16842936, 16842937 });
      overridePendingTransition(paramBundle.getResourceId(0, 0), paramBundle.getResourceId(1, 0));
      paramBundle.recycle();
    }
    catch (Exception paramBundle)
    {
      label191:
      int i1;
      com.tencent.luggage.wxa.ek.a locala;
      break label191;
    }
    super.onCreate(null);
    this.J = ((com.tencent.mm.ui.base.e)com.tencent.luggage.wxa.ba.e.a(com.tencent.mm.ui.base.e.class)).a(this);
    paramBundle = getIntent().getStringExtra("KEY_APPID");
    this.o = paramBundle;
    if (af.c(paramBundle))
    {
      h();
      return;
    }
    i1 = this.n;
    if (i1 == 0)
    {
      if (getSupportActionBar() != null) {
        getSupportActionBar().show();
      }
      setTitle(2131886769);
      setBackBtn(new WxaSettingActivity.1(this));
      this.a = getPreferenceScreen();
    }
    else if (i1 == 1)
    {
      this.z = new com.tencent.luggage.wxa.ek.a(this, this.J, this.F);
      this.z.a(getString(2131886769));
      this.z.a(new WxaSettingActivity.12(this));
      this.a = this.z.j();
    }
    if (this.n == 1)
    {
      if (findViewById(2131438781) != null)
      {
        findViewById(2131438781).setVisibility(8);
        getWindow().getDecorView().findViewById(16908290).setVisibility(8);
      }
      paramBundle = this.y;
      if (paramBundle != null)
      {
        locala = this.z;
        if (locala != null) {
          paramBundle.a(locala);
        }
      }
    }
    d();
    if ((getIntent() != null) && (getIntent().getBooleanExtra("KEY_FORCE_ACTIVITY_FULLSCREEN", false)))
    {
      getWindow().addFlags(1024);
      getWindow().getDecorView().setSystemUiVisibility(0x2 | 0x400 | getWindow().getDecorView().getSystemUiVisibility() | 0x200 | 0x1000);
      if ((Build.VERSION.SDK_INT >= 28) && (getWindow() != null))
      {
        paramBundle = getWindow().getAttributes();
        paramBundle.layoutInDisplayCutoutMode = 1;
        getWindow().setAttributes(paramBundle);
      }
    }
    c();
    a(this.q);
    this.v = 0;
    this.K = ((View)getWindow().getDecorView().findViewById(16908290).getParent());
    i1 = this.n;
    if ((i1 != 1) && (this.E != 0))
    {
      if ((i1 == 0) && ((this.K instanceof ViewGroup))) {
        WmpfPresentationActivityHelper.a.a(this, (ViewGroup)this.K, this.E, true);
      }
    }
    else {
      WmpfPresentationActivityHelper.a.a(this, null, this.E, true);
    }
    WmpfPresentationActivityHelper.a.a(this, new WxaSettingActivity.23(this));
  }
  
  protected void onPause()
  {
    if (this.s) {
      o.e("Luggage.STANDALONE.WxaSettingActivity", "onPause key change!");
    }
    super.onPause();
  }
  
  public boolean onPreferenceTreeClick(IPreferenceScreen paramIPreferenceScreen, Preference paramPreference)
  {
    String str = paramPreference.getKey();
    boolean bool = false;
    o.e("Luggage.STANDALONE.WxaSettingActivity", "onPreferenceTreeClcik.(key : %s)", new Object[] { str });
    if (this.d == null)
    {
      o.c("Luggage.STANDALONE.WxaSettingActivity", "mAuthItem == null");
      return false;
    }
    str = paramPreference.getKey();
    if (af.c(str))
    {
      o.b("Luggage.STANDALONE.WxaSettingActivity", "key is null");
      return false;
    }
    if (str.equalsIgnoreCase("scope.userLocation"))
    {
      g();
      return false;
    }
    if (str.equalsIgnoreCase("scope.userInfo"))
    {
      if (this.l == null) {
        return true;
      }
      paramIPreferenceScreen = new Intent(this, AppBrandUserInfoAuthorizeUI.class);
      paramIPreferenceScreen.putExtra("key_app_id", this.o);
      paramIPreferenceScreen.putExtra("key_nickname", this.p);
      paramIPreferenceScreen.putExtra("key_user_info", this.H);
      if (this.l.c == 1) {
        bool = true;
      }
      paramIPreferenceScreen.putExtra("key_is_state_open", bool);
      paramIPreferenceScreen.putExtra("key_display_id", this.E);
      ((PresentationActivityHelper)LuggageActivityHelper.FOR(this, PresentationActivityHelper.class)).startActivityForResult(paramIPreferenceScreen, new WxaSettingActivity.32(this));
      return true;
    }
    if ("preference_key_subscribe_msg".equals(str))
    {
      paramIPreferenceScreen = new Intent(this, BizSubscribeMsgManagerUI.class);
      paramIPreferenceScreen.putExtra("key_biz_username", this.q);
      paramIPreferenceScreen.putExtra("key_biz_presenter_class", com.tencent.luggage.wxa.ei.c.class.getName());
      paramIPreferenceScreen.putExtra("key_biz_nickname", this.p);
      paramIPreferenceScreen.putExtra("key_biz_app_id", this.o);
      paramIPreferenceScreen.putExtra("key_biz_data", this.G);
      paramIPreferenceScreen.putExtra("key_display_id", this.E);
      ((PresentationActivityHelper)LuggageActivityHelper.FOR(this, PresentationActivityHelper.class)).startActivityForResult(paramIPreferenceScreen, new WxaSettingActivity.33(this));
      return true;
    }
    if ((paramPreference instanceof com.tencent.luggage.wxa.di.b))
    {
      this.x = true;
      a(paramPreference);
    }
    if ((paramPreference instanceof com.tencent.luggage.wxa.di.d))
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (n)localIterator.next();
        if (str.equals(af.b(((n)localObject).a)))
        {
          this.s = true;
          if (((com.tencent.luggage.wxa.di.d)paramPreference).isChecked())
          {
            ((n)localObject).c = 1;
            a(new WxaSettingActivity.34(this, paramPreference, paramIPreferenceScreen, (n)localObject));
          }
          else if (this.r)
          {
            this.r = false;
            MMAlertDialog.Builder localBuilder = new MMAlertDialog.Builder(this.J);
            localBuilder.setMsg(getString(2131886760));
            localBuilder.setPositiveBtnText(getString(2131886759));
            localBuilder.setPositiveBtnListener(new WxaSettingActivity.35(this, (n)localObject, paramPreference, paramIPreferenceScreen));
            localBuilder.setNegativeBtnText(getString(2131887626));
            localBuilder.setNegativeBtnListener(new WxaSettingActivity.2(this, (n)localObject, paramPreference, paramIPreferenceScreen));
            localBuilder.setOnCancelListener(new WxaSettingActivity.3(this, (n)localObject, paramPreference, paramIPreferenceScreen));
            localObject = localBuilder.create();
            ((MMAlertDialog)localObject).setCanceledOnTouchOutside(false);
            ((MMAlertDialog)localObject).show();
          }
          else
          {
            ((n)localObject).c = 2;
            a(new WxaSettingActivity.4(this, paramPreference, paramIPreferenceScreen, (n)localObject));
          }
        }
      }
    }
    return false;
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.n == 1)
    {
      com.tencent.luggage.wxa.ek.a locala = this.z;
      if (locala != null) {
        locala.l();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    View localView = getWindow().getDecorView();
    if (localView != null) {
      localView.setSystemUiVisibility(localView.getSystemUiVisibility() & 0xFFFFFEFF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.setting.ui.WxaSettingActivity
 * JD-Core Version:    0.7.0.1
 */