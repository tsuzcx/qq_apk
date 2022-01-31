package com.example.tissue;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity
  extends Activity
{
  public static final String LOG_TAG = "MenuActivity";
  private static final int REQUEST_WRITE_STORAGE = 112;
  
  private void initUI()
  {
    setContentView(2130903041);
    Button localButton1 = (Button)findViewById(2130837506);
    Button localButton2 = (Button)findViewById(2130837504);
    Button localButton3 = (Button)findViewById(2130837505);
    MenuActivity.EventListener localEventListener = new MenuActivity.EventListener(this);
    localButton1.setOnClickListener(localEventListener);
    localButton3.setOnClickListener(localEventListener);
    localButton2.setOnClickListener(localEventListener);
    findViewById(2130837507).setOnClickListener(localEventListener);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    initUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.example.tissue.MenuActivity
 * JD-Core Version:    0.7.0.1
 */