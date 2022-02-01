package com.tencent.mm.ui;

import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog;
import com.tencent.mm.ui.widget.dialog.MMAlertDialog.Builder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class AlertActivity
  extends AppCompatActivity
{
  private static MMAlertDialog.Builder a;
  private DialogInterface.OnDismissListener b;
  private DialogInterface.OnCancelListener c;
  private boolean d = false;
  
  public static void a(MMAlertDialog.Builder paramBuilder)
  {
    a = paramBuilder;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setStatusBarColor(getResources().getColor(17170445));
    }
    this.d = getIntent().getBooleanExtra("dialog_show_top", false);
    paramBundle = a;
    if (paramBundle != null)
    {
      paramBundle.setContext(this);
      this.b = a.getDismissListener();
      this.c = a.getCancelListener();
      a.setOnDismissListener(new AlertActivity.1(this));
      a.setOnCancelListener(new AlertActivity.2(this));
      paramBundle = a.create();
      if (this.d)
      {
        Window localWindow = paramBundle.getWindow();
        if (localWindow != null)
        {
          if (Build.VERSION.SDK_INT >= 26) {
            localWindow.setType(2038);
          } else {
            localWindow.setType(2002);
          }
          f.b("MicroMsg.AlertActivity", "show top window not null!!", new Object[0]);
        }
      }
      paramBundle.show();
      if (!paramBundle.isShowing())
      {
        f.e("MicroMsg.AlertActivity", "show dialog FAILED, finish AlertActivity!", new Object[0]);
        finish();
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a = null;
  }
  
  protected void onPause()
  {
    overridePendingTransition(0, 0);
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.AlertActivity
 * JD-Core Version:    0.7.0.1
 */