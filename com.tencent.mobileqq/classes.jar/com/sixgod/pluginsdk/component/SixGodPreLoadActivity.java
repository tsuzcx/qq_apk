package com.sixgod.pluginsdk.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sixgod.pluginsdk.PluginLoadParams;
import com.sixgod.pluginsdk.log.SGLog;

public class SixGodPreLoadActivity
  extends Activity
{
  protected PluginLoadParams a = null;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a = PluginLoadParams.parseFromJson(super.getIntent().getStringExtra("plugin_load_params"));
    SGLog.a("SixGodPreLoadActivity onCreate ");
    SGLog.a("SixGodPreLoadActivity loadPlugin ");
    new h(this).start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.component.SixGodPreLoadActivity
 * JD-Core Version:    0.7.0.1
 */