package com.tencent.gdtad.basics.adbox;

import android.content.Context;
import android.view.Window;
import com.tencent.biz.subscribe.utils.NavigationBarUtil;

public class GdtAdBox
  implements IGdtAdBox
{
  private GdtAdBoxData a;
  private Context b;
  private GdtAdBoxListener c;
  private GdtAdBoxDialog d;
  
  public static GdtAdBoxBuilder a(Context paramContext)
  {
    return new GdtAdBoxBuilder(paramContext);
  }
  
  public GdtAdBoxData a()
  {
    return this.a;
  }
  
  void a(GdtAdBoxData paramGdtAdBoxData)
  {
    this.a = paramGdtAdBoxData;
  }
  
  void a(GdtAdBoxListener paramGdtAdBoxListener)
  {
    this.c = paramGdtAdBoxListener;
  }
  
  public void b()
  {
    this.d = new GdtAdBoxDialogCompact(this.b);
    this.d.a(this);
    Window localWindow = this.d.getWindow();
    NavigationBarUtil.a(localWindow);
    NavigationBarUtil.b(localWindow);
    this.d.show();
    NavigationBarUtil.c(localWindow);
  }
  
  void b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public void c()
  {
    GdtAdBoxDialog localGdtAdBoxDialog = this.d;
    if ((localGdtAdBoxDialog != null) && (localGdtAdBoxDialog.isShowing()))
    {
      this.d.dismiss();
      this.d = null;
    }
    this.c = null;
    this.a = null;
    this.b = null;
  }
  
  public void d()
  {
    GdtAdBoxListener localGdtAdBoxListener = this.c;
    if (localGdtAdBoxListener != null) {
      localGdtAdBoxListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.adbox.GdtAdBox
 * JD-Core Version:    0.7.0.1
 */