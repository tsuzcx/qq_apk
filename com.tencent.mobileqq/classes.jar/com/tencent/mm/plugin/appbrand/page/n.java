package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.widget.actionbar.e.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.widget.dialog.MMBottomSheet;
import java.util.Iterator;
import java.util.List;

public class n
  implements f.b, f.c
{
  private MMBottomSheet a;
  private String b;
  private u c;
  private View d = null;
  private List<com.tencent.luggage.wxa.nu.a> e;
  
  public n(@NonNull u paramu, @NonNull List<com.tencent.luggage.wxa.nu.a> paramList, boolean paramBoolean)
  {
    this.b = paramu.getAppId();
    this.c = paramu;
    this.e = paramList;
    this.a = new MMBottomSheet(paramu.getContext(), false, paramBoolean ^ true);
    paramu = paramu.q().W();
    o.d("MicroMsg.AppBrandPageActionSheet", "AppBrandPageActionSheet: width [%d]", new Object[] { Integer.valueOf(paramu.getVDisplayMetrics().widthPixels) });
    if (paramu.h_()) {
      this.a.setNewLandscapeMaxWidth((int)(paramu.getVDisplayMetrics().widthPixels * paramu.getScale()));
    }
    b(this.a);
  }
  
  private static com.tencent.luggage.wxa.nu.a a(@NonNull List<com.tencent.luggage.wxa.nu.a> paramList, int paramInt)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.luggage.wxa.nu.a locala = (com.tencent.luggage.wxa.nu.a)paramList.next();
      if (locala.c() == paramInt) {
        return locala;
      }
    }
    return null;
  }
  
  private void a(MenuItem paramMenuItem)
  {
    paramMenuItem = a(this.e, paramMenuItem.getItemId());
    if (a(this.c.getContext(), this.c, this.b, paramMenuItem)) {
      this.a.tryHide();
    }
  }
  
  private void a(g paramg, boolean paramBoolean)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.luggage.wxa.nu.a locala = (com.tencent.luggage.wxa.nu.a)localIterator.next();
      if ((locala != null) && (locala.e() == paramBoolean)) {
        a(this.c.getContext(), this.c, paramg, this.b, locala);
      }
    }
  }
  
  public static boolean a(Context paramContext, u paramu, g paramg, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    if (parama == null) {
      return false;
    }
    parama.g().a(paramContext, paramu, paramg, paramString, parama);
    return true;
  }
  
  public static boolean a(Context paramContext, u paramu, String paramString, com.tencent.luggage.wxa.nu.a parama)
  {
    if (parama == null) {
      return false;
    }
    parama.g().a(paramContext, paramu, paramString, parama);
    return true;
  }
  
  private void b(@NonNull MMBottomSheet paramMMBottomSheet)
  {
    paramMMBottomSheet = this.c.t();
    if (paramMMBottomSheet != null)
    {
      this.a.setTitleView(paramMMBottomSheet, true);
      this.d = paramMMBottomSheet;
    }
    paramMMBottomSheet = this.c.aI();
    if (paramMMBottomSheet != null) {
      this.a.setFooterView(paramMMBottomSheet);
    }
    this.a.setOnCreateMenuListener(new n.1(this));
    this.a.setOnMenuSelectedListener(new n.2(this));
    this.a.setOnCreateSecondMenuListener(new n.3(this));
    this.a.setOnSecondMenuSelectedListener(new n.4(this));
    if (e.a.a == this.c.aH()) {
      this.a.setBackgroundColor(Color.parseColor("#000000"));
    }
  }
  
  protected void a(@NonNull MMBottomSheet paramMMBottomSheet) {}
  
  public final boolean a()
  {
    boolean bool;
    try
    {
      localMMBottomSheet = this.a;
      if (this.c.v()) {
        break label123;
      }
      if (!this.c.m()) {
        break label118;
      }
    }
    catch (Exception localException)
    {
      MMBottomSheet localMMBottomSheet;
      o.b("MicroMsg.AppBrandPageActionSheet", "show exception = %s", new Object[] { localException });
      return false;
    }
    localMMBottomSheet.hideStatusBar(bool);
    localMMBottomSheet = this.a;
    if (!this.c.v()) {
      if (this.c.m()) {
        break label133;
      }
    }
    for (;;)
    {
      localMMBottomSheet.hideNavigationFullScreen(bool);
      a(this.a);
      this.a.tryShow();
      this.c.a(this);
      this.c.a(this);
      return true;
      label118:
      bool = false;
      break;
      label123:
      bool = true;
      break;
      bool = false;
      continue;
      label133:
      bool = true;
    }
  }
  
  public void b()
  {
    c();
  }
  
  protected final boolean c()
  {
    try
    {
      this.a.tryHide();
      this.c.b(this);
      this.c.b(this);
      return true;
    }
    catch (Exception localException)
    {
      o.b("MicroMsg.AppBrandPageActionSheet", "hide exception = %s", new Object[] { localException });
    }
    return false;
  }
  
  public void d()
  {
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.n
 * JD-Core Version:    0.7.0.1
 */