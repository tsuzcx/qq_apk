package com.tencent.mm.plugin.appbrand.keylogger;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import com.tencent.luggage.wxa.nk.c.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Pattern;

public class KeyStepAnalyserActivity
  extends b
{
  private a b;
  private Pattern c;
  private String d;
  private Class e;
  private int f;
  private int g;
  private int h;
  
  private void a(long paramLong)
  {
    o.d("MicroMsg.KeyStepBaseActivity", "analyse time:%d", new Object[] { Long.valueOf(paramLong) });
    this.b.a(this.d, this.c, paramLong, new KeyStepAnalyserActivity.2(this));
  }
  
  private void a(c.b paramb)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(this, KeyStepAnalyserDetailActivity.class);
    localIntent.putExtra("steps", paramb.a());
    localIntent.putExtra("key_info", paramb.b());
    localIntent.putExtra("key_process_class", this.e);
    startActivity(localIntent);
  }
  
  private void a(List<c.b> paramList)
  {
    ListView localListView = (ListView)findViewById(2131437272);
    KeyStepAnalyserActivity.a locala = new KeyStepAnalyserActivity.a(this);
    localListView.setAdapter(locala);
    localListView.setOnItemClickListener(new KeyStepAnalyserActivity.4(this, locala));
    locala.a(paramList);
  }
  
  private void d()
  {
    new DatePickerDialog(this, new KeyStepAnalyserActivity.3(this), this.f, this.g, this.h).show();
  }
  
  protected int a()
  {
    return 2131624027;
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
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = ((Class)getIntent().getSerializableExtra("process"));
    this.d = g.a(this.e);
    this.c = ((Pattern)getIntent().getSerializableExtra("session_id_prefix"));
    a(getString(2131891087));
    paramBundle = Calendar.getInstance();
    this.f = paramBundle.get(1);
    this.g = paramBundle.get(2);
    this.h = paramBundle.get(5);
    findViewById(2131431616).setOnClickListener(new KeyStepAnalyserActivity.1(this));
    this.b = new a();
    a(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.keylogger.KeyStepAnalyserActivity
 * JD-Core Version:    0.7.0.1
 */