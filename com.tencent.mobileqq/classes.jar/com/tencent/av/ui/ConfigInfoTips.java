package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.report.TraeConfigUpdate;
import com.tencent.avcore.config.ConfigInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ConfigInfoTips
  implements View.OnClickListener
{
  private long[] a = null;
  private Context b = null;
  private boolean c = false;
  private boolean d = false;
  private BroadcastReceiver e = new ConfigInfoTips.1(this);
  
  public ConfigInfoTips(Context paramContext)
  {
    this.b = paramContext;
    this.a = new long[6];
  }
  
  private void a(View paramView)
  {
    Object localObject1 = (Activity)this.b;
    ((Activity)localObject1).findViewById(2131441042).setVisibility(0);
    paramView = (TextView)((Activity)localObject1).findViewById(2131441044);
    localObject1 = (TextView)((Activity)localObject1).findViewById(2131441043);
    int i = ConfigInfo.getSharpConfigVersionFromFile(this.b);
    Object localObject2 = a(ConfigInfo.getSharpConfigPayloadFromFile(this.b));
    String str = ConfigSystemImpl.d(this.b);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append("\n----------\n");
    localObject2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(a(str));
    str = localStringBuilder.toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append("|");
    ((StringBuilder)localObject2).append(TraeConfigUpdate.a().a("load"));
    paramView.setText(((StringBuilder)localObject2).toString());
    ((TextView)localObject1).setText(str);
  }
  
  private void c() {}
  
  String a(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    paramString = new String();
    int n = arrayOfString.length;
    int k = 0;
    int i = 0;
    while (k < n)
    {
      Object localObject = arrayOfString[k];
      int j = ((String)localObject).length();
      int m;
      if (j >= 2) {
        m = ((String)localObject).charAt(j - 2);
      } else {
        m = 0;
      }
      j = i;
      if (m == 125) {
        j = i - 1;
      }
      i = 0;
      while (i < j)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("\t");
        paramString = localStringBuilder.toString();
        i += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append((String)localObject);
      paramString = localStringBuilder.toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\n");
      paramString = ((StringBuilder)localObject).toString();
      i = j;
      if (m == 123) {
        i = j + 1;
      }
      k += 1;
    }
    return paramString;
  }
  
  public void a()
  {
    Object localObject = (Activity)this.b;
    View localView = ((Activity)localObject).findViewById(2131441041);
    if (localView != null)
    {
      localView.setOnClickListener(this);
      localView.setVisibility(0);
    }
    localView = ((Activity)localObject).findViewById(2131441043);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localObject = ((Activity)localObject).findViewById(2131441042);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigTipsConstant.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    this.b.registerReceiver(this.e, (IntentFilter)localObject);
  }
  
  public void b()
  {
    this.b.unregisterReceiver(this.e);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131441042: 
    case 2131441043: 
      ((Activity)this.b).findViewById(2131441042).setVisibility(8);
      break;
    case 2131441041: 
      long[] arrayOfLong = this.a;
      System.arraycopy(arrayOfLong, 1, arrayOfLong, 0, arrayOfLong.length - 1);
      arrayOfLong = this.a;
      arrayOfLong[(arrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      if (this.a[0] >= SystemClock.uptimeMillis() - 2000L) {
        a(paramView);
      }
      break;
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.ConfigInfoTips
 * JD-Core Version:    0.7.0.1
 */