package com.example.tissue;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity
  extends Activity
{
  public static final String LOG_TAG = "MenuActivity";
  private static final int REQUEST_WRITE_STORAGE = 112;
  
  private void checkAndLoadApkg()
  {
    if ((Build.VERSION.SDK_INT >= 23) && (checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0) && (checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        requestPermissions(new String[] { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE" }, 112);
      }
      return;
    }
    loadApkg();
  }
  
  private void initUI()
  {
    setContentView(2130903041);
    Button localButton1 = (Button)findViewById(2130837507);
    Button localButton2 = (Button)findViewById(2130837504);
    Button localButton3 = (Button)findViewById(2130837505);
    MenuActivity.EventListener localEventListener = new MenuActivity.EventListener(this);
    localButton1.setOnClickListener(localEventListener);
    localButton3.setOnClickListener(localEventListener);
    localButton2.setOnClickListener(localEventListener);
    findViewById(2130837508).setOnClickListener(localEventListener);
    findViewById(2130837506).setOnClickListener(localEventListener);
    checkAndLoadApkg();
  }
  
  private void loadApkg()
  {
    Log.i("MenuActivity", "授权检查成功");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initUI();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (paramInt == 112)
    {
      if ((paramArrayOfInt[0] != 0) || (paramArrayOfInt[1] != 0)) {
        break label30;
      }
      loadApkg();
    }
    for (;;)
    {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
      return;
      label30:
      Toast.makeText(this, "您拒绝了授权", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MenuActivity
 * JD-Core Version:    0.7.0.1
 */