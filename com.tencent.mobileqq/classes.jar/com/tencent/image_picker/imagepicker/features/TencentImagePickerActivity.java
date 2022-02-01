package com.tencent.image_picker.imagepicker.features;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image_picker.imagepicker.helper.d;
import com.tencent.image_picker.imagepicker.helper.f;
import com.tencent.image_picker.imagepicker.view.SnackBarView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class TencentImagePickerActivity
  extends AppCompatActivity
  implements g
{
  private d a = d.a();
  private ActionBar b;
  private ProgressBar c;
  private TextView d;
  private RecyclerView e;
  private SnackBarView f;
  private com.tencent.luggage.wxa.ax.b g;
  private e h;
  private com.tencent.image_picker.imagepicker.helper.b i;
  private c j;
  private Handler k;
  private ContentObserver l;
  private boolean m;
  
  private void a(c paramc)
  {
    this.c = ((ProgressBar)findViewById(2131440737));
    this.d = ((TextView)findViewById(2131448423));
    this.e = ((RecyclerView)findViewById(2131444517));
    this.f = ((SnackBarView)findViewById(2131432384));
    setSupportActionBar((Toolbar)findViewById(2131447696));
    this.b = getSupportActionBar();
    if (this.b != null)
    {
      Drawable localDrawable = f.a(this);
      int n = paramc.a();
      if ((n != -1) && (localDrawable != null)) {
        localDrawable.setColorFilter(n, PorterDuff.Mode.SRC_ATOP);
      }
      this.b.setDisplayHomeAsUpEnabled(true);
      this.b.setHomeAsUpIndicator(localDrawable);
      this.b.setDisplayShowTitleEnabled(true);
    }
  }
  
  private void b(c paramc)
  {
    this.g = new com.tencent.luggage.wxa.ax.b(this.e, paramc, getResources().getConfiguration().orientation);
    this.g.a(new TencentImagePickerActivity.1(this), new TencentImagePickerActivity.2(this));
    this.g.a(new TencentImagePickerActivity.3(this, paramc));
  }
  
  private void b(List<com.tencent.luggage.wxa.az.b> paramList)
  {
    this.g.a(paramList);
    g();
  }
  
  private com.tencent.luggage.wxa.av.a c()
  {
    if (this.m) {
      return d();
    }
    return e();
  }
  
  private void c(List<com.tencent.luggage.wxa.az.a> paramList)
  {
    this.g.b(paramList);
    g();
  }
  
  private com.tencent.luggage.wxa.au.a d()
  {
    return (com.tencent.luggage.wxa.au.a)getIntent().getParcelableExtra(com.tencent.luggage.wxa.au.a.class.getSimpleName());
  }
  
  private boolean d(List<String> paramList)
  {
    int i1 = paramList.size();
    int n = 0;
    while (n < i1)
    {
      if (ActivityCompat.shouldShowRequestPermissionRationale(this, (String)paramList.get(n))) {
        return true;
      }
      n += 1;
    }
    return false;
  }
  
  @Nullable
  private c e()
  {
    if (this.j == null)
    {
      Bundle localBundle = getIntent().getExtras();
      if (localBundle != null) {
        this.j = ((c)localBundle.getParcelable(c.class.getSimpleName()));
      } else {
        throw new IllegalStateException("This should not happen. Please open an issue!");
      }
    }
    return this.j;
  }
  
  private void f()
  {
    this.i = new com.tencent.image_picker.imagepicker.helper.b(this);
    this.h = new e(new a(this));
    this.h.a(this);
  }
  
  private void g()
  {
    supportInvalidateOptionsMenu();
    this.b.setTitle(this.g.a());
  }
  
  private void h()
  {
    this.h.a(this.g.b());
  }
  
  private void i()
  {
    if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") == 0)
    {
      j();
      return;
    }
    k();
  }
  
  private void j()
  {
    c localc = e();
    this.h.b();
    if (localc != null) {
      this.h.a(localc);
    }
  }
  
  private void k()
  {
    this.a.c("Write External permission is not granted. Requesting permission");
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
    if (ActivityCompat.shouldShowRequestPermissionRationale(this, "android.permission.WRITE_EXTERNAL_STORAGE"))
    {
      ActivityCompat.requestPermissions(this, arrayOfString, 23);
      return;
    }
    if (!this.i.b("writeExternalRequested"))
    {
      this.i.a("writeExternalRequested");
      ActivityCompat.requestPermissions(this, arrayOfString, 23);
      return;
    }
    this.f.b(2131918052, new TencentImagePickerActivity.4(this));
  }
  
  private void l()
  {
    this.a.c("Write External permission is not granted. Requesting permission");
    ArrayList localArrayList = new ArrayList(2);
    if (ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA") != 0) {
      localArrayList.add("android.permission.CAMERA");
    }
    if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
      localArrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
    }
    if (d(localArrayList))
    {
      ActivityCompat.requestPermissions(this, (String[])localArrayList.toArray(new String[localArrayList.size()]), 24);
      return;
    }
    if (!this.i.b("cameraRequested"))
    {
      this.i.a("cameraRequested");
      ActivityCompat.requestPermissions(this, (String[])localArrayList.toArray(new String[localArrayList.size()]), 24);
      return;
    }
    if (this.m)
    {
      Toast.makeText(getApplicationContext(), getString(2131918051), 0).show();
      finish();
      return;
    }
    this.f.b(2131918051, new TencentImagePickerActivity.5(this));
  }
  
  private void m()
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", getPackageName(), null));
    localIntent.addFlags(268435456);
    startActivity(localIntent);
  }
  
  private void n()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      int n = ActivityCompat.checkSelfPermission(this, "android.permission.CAMERA");
      int i1 = 1;
      if (n == 0) {
        n = 1;
      } else {
        n = 0;
      }
      if (ActivityCompat.checkSelfPermission(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
        i1 = 0;
      }
      if ((n != 0) && (i1 != 0))
      {
        o();
        return;
      }
      this.a.c("Camera permission is not granted. Requesting permission");
      l();
      return;
    }
    o();
  }
  
  private void o()
  {
    if (!com.tencent.luggage.wxa.at.a.a(this)) {
      return;
    }
    this.h.a(this, c(), 2000);
  }
  
  public void a()
  {
    this.c.setVisibility(8);
    this.e.setVisibility(8);
    this.d.setVisibility(0);
  }
  
  public void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && ((paramThrowable instanceof NullPointerException))) {
      paramThrowable = "Images not exist";
    } else {
      paramThrowable = "Unknown Error";
    }
    Toast.makeText(this, paramThrowable, 0).show();
  }
  
  public void a(List<com.tencent.luggage.wxa.az.b> paramList)
  {
    Intent localIntent = new Intent();
    localIntent.putParcelableArrayListExtra("selectedImages", (ArrayList)paramList);
    setResult(-1, localIntent);
    finish();
  }
  
  public void a(List<com.tencent.luggage.wxa.az.b> paramList, List<com.tencent.luggage.wxa.az.a> paramList1)
  {
    c localc = e();
    if ((localc != null) && (localc.k()))
    {
      c(paramList1);
      return;
    }
    b(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.c;
    int i1 = 0;
    if (paramBoolean) {
      n = 0;
    } else {
      n = 8;
    }
    ((ProgressBar)localObject).setVisibility(n);
    localObject = this.e;
    int n = i1;
    if (paramBoolean) {
      n = 8;
    }
    ((RecyclerView)localObject).setVisibility(n);
    this.d.setVisibility(8);
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(com.tencent.image_picker.imagepicker.helper.e.a(paramContext));
  }
  
  public void b()
  {
    i();
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
    if (paramInt1 == 2000)
    {
      if (paramInt2 == -1)
      {
        this.h.a(this, paramIntent, c());
        return;
      }
      if ((paramInt2 == 0) && (this.m))
      {
        this.h.c();
        finish();
      }
    }
  }
  
  public void onBackPressed()
  {
    if (this.m)
    {
      super.onBackPressed();
      return;
    }
    this.g.a(new TencentImagePickerActivity.7(this));
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    com.tencent.luggage.wxa.ax.b localb = this.g;
    if (localb != null) {
      localb.a(paramConfiguration.orientation);
    }
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    Intent localIntent = getIntent();
    if ((localIntent != null) && (localIntent.getExtras() != null))
    {
      this.m = getIntent().hasExtra(com.tencent.luggage.wxa.au.a.class.getSimpleName());
      f();
      if (this.m)
      {
        if (paramBundle == null) {
          n();
        }
      }
      else
      {
        paramBundle = e();
        if (paramBundle != null)
        {
          setTheme(paramBundle.l());
          setContentView(2131624048);
          a(paramBundle);
          b(paramBundle);
        }
      }
      return;
    }
    d.a().b("This should not happen. Please open an issue!");
    finish();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131689477, paramMenu);
    return true;
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.h;
    if (localObject != null)
    {
      ((e)localObject).b();
      this.h.e();
    }
    if (this.l != null)
    {
      getContentResolver().unregisterContentObserver(this.l);
      this.l = null;
    }
    localObject = this.k;
    if (localObject != null)
    {
      ((Handler)localObject).removeCallbacksAndMessages(null);
      this.k = null;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int n = paramMenuItem.getItemId();
    if (n == 16908332)
    {
      onBackPressed();
      return true;
    }
    if (n == 2131438115)
    {
      h();
      return true;
    }
    if (n == 2131438105)
    {
      n();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem = paramMenu.findItem(2131438105);
    if (localMenuItem != null)
    {
      c localc = e();
      if (localc != null) {
        localMenuItem.setVisible(localc.d());
      }
    }
    localMenuItem = paramMenu.findItem(2131438115);
    if (localMenuItem != null)
    {
      localMenuItem.setTitle(com.tencent.image_picker.imagepicker.helper.a.c(this, this.j));
      localMenuItem.setVisible(this.g.c());
    }
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    Object localObject = "(empty)";
    if (paramInt != 23)
    {
      if (paramInt != 24)
      {
        localObject = this.a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Got unexpected permission result: ");
        localStringBuilder.append(paramInt);
        ((d)localObject).a(localStringBuilder.toString());
        super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
        return;
      }
      if ((paramArrayOfInt.length != 0) && (paramArrayOfInt[0] == 0))
      {
        this.a.a("Camera permission granted");
        o();
        return;
      }
      paramArrayOfString = this.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Permission not granted: results len = ");
      localStringBuilder.append(paramArrayOfInt.length);
      localStringBuilder.append(" Result code = ");
      if (paramArrayOfInt.length > 0) {
        localObject = Integer.valueOf(paramArrayOfInt[0]);
      }
      localStringBuilder.append(localObject);
      paramArrayOfString.b(localStringBuilder.toString());
      finish();
      return;
    }
    if ((paramArrayOfInt.length != 0) && (paramArrayOfInt[0] == 0))
    {
      this.a.a("Write External permission granted");
      j();
      return;
    }
    paramArrayOfString = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Permission not granted: results len = ");
    localStringBuilder.append(paramArrayOfInt.length);
    localStringBuilder.append(" Result code = ");
    if (paramArrayOfInt.length > 0) {
      localObject = Integer.valueOf(paramArrayOfInt[0]);
    }
    localStringBuilder.append(localObject);
    paramArrayOfString.b(localStringBuilder.toString());
    finish();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.h.a((com.tencent.luggage.wxa.at.b)paramBundle.getSerializable("Key.CameraModule"));
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.m) {
      i();
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("Key.CameraModule", this.h.a());
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.m) {
      return;
    }
    if (this.k == null) {
      this.k = new Handler();
    }
    this.l = new TencentImagePickerActivity.6(this, this.k);
    getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, false, this.l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.TencentImagePickerActivity
 * JD-Core Version:    0.7.0.1
 */