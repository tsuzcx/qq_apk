package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator.AnimatorListener;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.luggage.scanner.qbar.LuggageFileDecodeQueue;
import com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher;
import com.tencent.luggage.util.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URISyntaxException;

public class BaseScanUI
  extends AppCompatActivity
{
  private FrameLayout a;
  private a b;
  private ScannerFlashSwitcher c;
  private View d;
  private View e;
  private ImageView f;
  private TextView g;
  private Vibrator h;
  private boolean i = true;
  private long j;
  private int k;
  private boolean l = true;
  private boolean m = true;
  private boolean n = true;
  private int[] o;
  private int p;
  private boolean q;
  private boolean r;
  private boolean s;
  private boolean t;
  private boolean u = false;
  private boolean v = true;
  private boolean w = true;
  private boolean x = false;
  private a.a y = new BaseScanUI.1(this);
  private com.tencent.luggage.wxa.qy.c z = new BaseScanUI.4(this);
  
  private void a(int paramInt)
  {
    o.d("Luggage.ScanUI", "operateFlash operation: %d", new Object[] { Integer.valueOf(paramInt) });
    Object localObject = new com.tencent.luggage.wxa.dk.b();
    ((com.tencent.luggage.wxa.dk.b)localObject).a.a = paramInt;
    com.tencent.luggage.wxa.qy.a.a.a((com.tencent.luggage.wxa.qy.b)localObject);
    localObject = this.c;
    if (localObject != null)
    {
      if (paramInt == 1)
      {
        ((ScannerFlashSwitcher)localObject).e();
        return;
      }
      ((ScannerFlashSwitcher)localObject).f();
    }
  }
  
  private void a(long paramLong, Bundle paramBundle, com.tencent.luggage.scanner.qbar.d paramd)
  {
    if ((paramd != null) && (paramBundle != null))
    {
      paramBundle.putInt("result_code_format", paramd.typeID);
      paramBundle.putString("result_content", paramd.data);
      paramBundle.putString("result_code_name", paramd.typeName);
      paramBundle.putByteArray("result_raw_data", paramd.rawData);
      paramBundle.putInt("result_code_version", paramd.a);
      paramBundle = new Intent();
      paramBundle.putExtra("key_scan_result", paramd.data);
      paramBundle.putExtra("key_scan_result_raw", paramd.rawData);
      paramBundle.putExtra("key_scan_result_code_name", paramd.typeName);
      paramBundle.putExtra("key_scan_result_code_version", paramd.a);
      setResult(-1, paramBundle);
      setResult(-1, paramBundle);
    }
  }
  
  private void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new AlertDialog.Builder(paramContext);
    paramContext.setMessage(paramString1).setTitle(paramString2).setCancelable(paramBoolean).setPositiveButton(paramString3, paramOnClickListener1).setNegativeButton(paramString4, paramOnClickListener2);
    paramContext.show();
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    a(paramView, paramBoolean, null);
  }
  
  private void a(View paramView, boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramView == null) {
      return;
    }
    float f2 = 0.0F;
    if ((paramBoolean) && (paramView.getAlpha() != 0.0F))
    {
      o.c("Luggage.ScanUI", "animateAlpha show ignore, view: %s", new Object[] { paramView });
      return;
    }
    if ((!paramBoolean) && (paramView.getAlpha() != 1.0F))
    {
      o.c("Luggage.ScanUI", "animateAlpha hide ignore, view: %s", new Object[] { paramView });
      return;
    }
    o.f("Luggage.ScanUI", "animateAlpha show: %b, view: %s", new Object[] { Boolean.valueOf(paramBoolean), paramView });
    paramAnimatorListener = new BaseScanUI.2(this, paramAnimatorListener, paramView, paramBoolean);
    paramView.setVisibility(0);
    if (paramBoolean) {
      f1 = 0.0F;
    } else {
      f1 = 1.0F;
    }
    paramView.setAlpha(f1);
    paramView = paramView.animate();
    float f1 = f2;
    if (paramBoolean) {
      f1 = 1.0F;
    }
    paramView.alpha(f1).setListener(paramAnimatorListener).setDuration(200L).start();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.setVisibility(0);
      this.b.o();
      this.d.setOnClickListener(new BaseScanUI.3(this));
      locala = this.b;
      if (locala != null) {
        locala.a(true);
      }
      b(false);
      return;
    }
    this.d.setVisibility(8);
    a locala = this.b;
    if (locala != null) {
      locala.a(false);
    }
  }
  
  private void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    o.f("Luggage.ScanUI", "switchCloseView isMultiCode: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.g.setAlpha(0.0F);
      a(this.f, false, new BaseScanUI.16(this, paramAnimatorListener));
      return;
    }
    a(this.g, false, new BaseScanUI.17(this, paramAnimatorListener));
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    o.f("Luggage.ScanUI", "showFlash show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    ScannerFlashSwitcher localScannerFlashSwitcher;
    if (paramBoolean1)
    {
      localScannerFlashSwitcher = this.c;
      if ((localScannerFlashSwitcher != null) && (!localScannerFlashSwitcher.isShown()))
      {
        this.b.k();
        if (paramBoolean2)
        {
          this.c.a();
          return;
        }
        this.c.setVisibility(0);
      }
    }
    else
    {
      localScannerFlashSwitcher = this.c;
      if ((localScannerFlashSwitcher != null) && (!localScannerFlashSwitcher.d()))
      {
        this.b.l();
        if (paramBoolean2)
        {
          this.c.b();
          return;
        }
        this.c.setVisibility(8);
      }
    }
  }
  
  private void b(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }
  
  private void c()
  {
    f.a.c(new BaseScanUI.10(this));
    this.h.vibrate(10L);
  }
  
  private void d()
  {
    this.h = ((Vibrator)getSystemService("vibrator"));
  }
  
  private void e()
  {
    com.tencent.luggage.scanner.scanner.ui.widget.b localb = this.b.getSharedMaskView();
    if (localb == null) {
      return;
    }
    if (!this.t)
    {
      localb.getGalleryButton().setVisibility(0);
      localb.setOnGalleryClickListener(new BaseScanUI.11(this));
      return;
    }
    localb.getGalleryButton().setVisibility(8);
  }
  
  private void f()
  {
    if (!this.w) {
      return;
    }
    o.d("Luggage.ScanUI", "selectImageFromGallery currentMode: %d", new Object[] { Integer.valueOf(this.k) });
    if (j())
    {
      this.u = true;
      Intent localIntent = new Intent("android.intent.action.PICK");
      localIntent.setType("image/*");
      startActivityForResult(localIntent, 4660);
    }
  }
  
  private void g()
  {
    Object localObject = this.b.getSharedMaskView();
    if (localObject != null) {
      this.c = ((com.tencent.luggage.scanner.scanner.ui.widget.b)localObject).getFlashSwitcherView();
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((ScannerFlashSwitcher)localObject).setOnClickListener(new BaseScanUI.12(this));
      this.b.setFlashStatus(this.c.c());
    }
  }
  
  private void h()
  {
    this.f.setVisibility(0);
    this.f.setOnClickListener(new BaseScanUI.13(this));
    this.g.setOnClickListener(new BaseScanUI.14(this));
  }
  
  private void i()
  {
    o.d("Luggage.ScanUI", "processMultiCodeCancel isShowingMultiCodeResult: %b", new Object[] { Boolean.valueOf(this.x) });
    if (!this.x) {
      return;
    }
    this.x = false;
    a(false, new BaseScanUI.15(this));
  }
  
  private boolean j()
  {
    return com.tencent.luggage.scanner.scanner.util.d.a(this.k);
  }
  
  private void k()
  {
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (com.tencent.luggage.wxa.hg.c.a(19)) {
      getWindow().addFlags(67109888);
    } else {
      getWindow().setFlags(1024, 1024);
    }
    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }
  }
  
  private void l()
  {
    setResult(0);
    finish();
    overridePendingTransition(0, 0);
  }
  
  private void m()
  {
    o.d("Luggage.ScanUI", "onResumeAfterChkPermission needPauseScan: %b", new Object[] { Boolean.valueOf(this.u) });
    if (!this.u) {
      this.b.c();
    }
    com.tencent.luggage.wxa.qy.a.a.b(this.z);
  }
  
  private void n()
  {
    if (!j.a(this, "android.permission.CAMERA", 16, "", ""))
    {
      a(this, getString(2131892414), getString(2131892420), getString(2131891078), getString(2131887626), false, new BaseScanUI.5(this), new BaseScanUI.6(this));
      return;
    }
    m();
  }
  
  private void o()
  {
    o.d("Luggage.ScanUI", "resumeScan");
    this.u = false;
    a locala = this.b;
    if (locala != null) {
      locala.c();
    }
  }
  
  private void p()
  {
    int i1 = this.k;
    if ((i1 != 1) && (i1 != 4) && (i1 != 8))
    {
      this.b.setScanCallback(null);
      return;
    }
    this.b.setScanCallback(this.y);
  }
  
  protected void a()
  {
    this.a = ((FrameLayout)findViewById(2131445271));
    k();
    this.d = findViewById(2131445276);
    this.e = findViewById(2131447720);
    this.f = ((ImageView)findViewById(2131430821));
    this.g = ((TextView)findViewById(2131438993));
    this.b = new a(this);
    this.b.setBottomExtraHeight(0);
    this.b.setActivity(this);
    this.a.addView(this.b, 0, new FrameLayout.LayoutParams(-1, -1));
    this.b.b();
    this.b.setShowScanTips(this.l);
    this.b.setScanMode(this.k);
    this.b.j();
    e();
    p();
    int[] arrayOfInt = this.o;
    if ((arrayOfInt != null) && (arrayOfInt.length > 0)) {
      this.b.setScanCodeReaders(arrayOfInt);
    }
    g();
    h();
  }
  
  public boolean b()
  {
    o.d("Luggage.ScanUI", "should check camera %s", new Object[] { Boolean.valueOf(this.i) });
    if (this.i)
    {
      boolean bool = j.a(this, "android.permission.CAMERA", 16, "", "");
      o.d("Luggage.ScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      return bool;
    }
    return true;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 != 4660) {
      return;
    }
    if ((paramInt2 == -1) && (paramIntent != null))
    {
      Object localObject = paramIntent.getData();
      paramIntent = null;
      try
      {
        localObject = com.tencent.luggage.scanner.scanner.util.a.a(this, (Uri)localObject);
        paramIntent = (Intent)localObject;
      }
      catch (URISyntaxException localURISyntaxException)
      {
        for (;;)
        {
          localURISyntaxException.printStackTrace();
        }
      }
      if (af.c(paramIntent))
      {
        o.c("Luggage.ScanUI", "preScanImage is null");
        return;
      }
      o.d("Luggage.ScanUI", "select: [%s]", new Object[] { paramIntent });
      long l1 = System.currentTimeMillis();
      LuggageFileDecodeQueue.getInstance().addDecodeTask(this, l1, paramIntent, new BaseScanUI.9(this, l1), this.o);
      return;
    }
    o();
  }
  
  public void onBackPressed()
  {
    o.f("Luggage.ScanUI", "onBackPressed");
    a locala = this.b;
    if ((locala != null) && (locala.n()))
    {
      i();
      return;
    }
    l();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if ((Build.VERSION.SDK_INT >= 28) && (getWindow() != null))
    {
      paramBundle = getWindow().getAttributes();
      paramBundle.layoutInDisplayCutoutMode = 1;
      getWindow().setAttributes(paramBundle);
    }
    if (getWindow() != null) {
      getWindow().setSoftInputMode(3);
    }
    setContentView(2131624041);
    d();
    this.o = getIntent().getIntArrayExtra("key_support_scan_code_type");
    this.p = getIntent().getIntExtra("key_scan_entry_scene", 0);
    this.q = getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false);
    this.r = getIntent().getBooleanExtra("key_set_result_after_scan", true);
    this.s = getIntent().getBooleanExtra("key_is_hide_right_btn", false);
    this.k = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
    this.l = getIntent().getBooleanExtra("key_show_scan_tips", true);
    this.t = this.s;
    a();
    this.j = System.currentTimeMillis();
  }
  
  protected void onDestroy()
  {
    o.d("Luggage.ScanUI", "onDestroy()");
    super.onDestroy();
    a locala = this.b;
    if (locala != null) {
      locala.g();
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    o.d("Luggage.ScanUI", "onPause needPauseScan: %b", new Object[] { Boolean.valueOf(this.u) });
    a locala = this.b;
    if (locala != null)
    {
      locala.e();
      if (this.u) {
        this.b.h();
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    o.d("Luggage.ScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    if (paramInt != 16) {
      return;
    }
    if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == -1))
    {
      this.i = false;
      a(this, getString(2131892414), getString(2131892420), getString(2131891078), getString(2131887626), false, new BaseScanUI.7(this), new BaseScanUI.8(this));
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    o.d("Luggage.ScanUI", "BaseScanUI onResume needPauseScan: %b", new Object[] { Boolean.valueOf(this.u) });
    if (b()) {
      n();
    }
    getWindow().addFlags(128);
  }
  
  protected void onStop()
  {
    super.onStop();
    a locala = this.b;
    if (locala != null) {
      locala.f();
    }
    this.c.f();
    com.tencent.luggage.wxa.qy.a.a.c(this.z);
    getWindow().clearFlags(128);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */