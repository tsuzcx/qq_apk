package com.tencent.av.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.config.ConfigInfo;
import com.tencent.av.report.TraeConfigUpdate;
import jrw;

public class ConfigInfoTips
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new jrw(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private boolean jdField_a_of_type_Boolean;
  private long[] jdField_a_of_type_ArrayOfLong;
  private boolean b;
  
  public ConfigInfoTips(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfLong = new long[6];
  }
  
  private void a(View paramView)
  {
    paramView = (Activity)this.jdField_a_of_type_AndroidContentContext;
    paramView.findViewById(2131365919).setVisibility(0);
    TextView localTextView1 = (TextView)paramView.findViewById(2131365920);
    TextView localTextView2 = (TextView)paramView.findViewById(2131365921);
    int n = ConfigInfo.instance().getSharpConfigVersionFromFile();
    String[] arrayOfString = ConfigInfo.instance().getSharpConfigPayloadFromFile().split("\n");
    paramView = new String();
    int i1 = arrayOfString.length;
    int k = 0;
    int i = 0;
    String str;
    int j;
    if (k < i1)
    {
      str = arrayOfString[k];
      j = str.length();
      if (j < 2) {
        break label269;
      }
    }
    label269:
    for (int m = str.charAt(j - 2);; m = 0)
    {
      j = i;
      if (m == 125) {
        j = i - 1;
      }
      i = 0;
      while (i < j)
      {
        paramView = paramView + "\t";
        i += 1;
      }
      paramView = paramView + str;
      paramView = paramView + "\n";
      i = j;
      if (m == 123) {
        i = j + 1;
      }
      k += 1;
      break;
      localTextView1.setText(String.valueOf(n) + "|" + TraeConfigUpdate.a().a("load"));
      localTextView2.setText(paramView);
      return;
    }
  }
  
  private void c() {}
  
  public void a()
  {
    Object localObject = (Activity)this.jdField_a_of_type_AndroidContentContext;
    View localView = ((Activity)localObject).findViewById(2131365370);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localView = ((Activity)localObject).findViewById(2131365921);
    if (localView != null) {
      localView.setOnClickListener(this);
    }
    localObject = ((Activity)localObject).findViewById(2131365919);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(this);
    }
    localObject = new IntentFilter();
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_WRITE_CONFIG_INFO_TO_FILE");
    ((IntentFilter)localObject).addAction("com.tencent.av.ui.ConfigInfoTips.ACTION_IS_GETTED_SHARP_CONFIG_PAYLOAD");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, (IntentFilter)localObject);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131365370: 
      do
      {
        return;
        System.arraycopy(this.jdField_a_of_type_ArrayOfLong, 1, this.jdField_a_of_type_ArrayOfLong, 0, this.jdField_a_of_type_ArrayOfLong.length - 1);
        this.jdField_a_of_type_ArrayOfLong[(this.jdField_a_of_type_ArrayOfLong.length - 1)] = SystemClock.uptimeMillis();
      } while (this.jdField_a_of_type_ArrayOfLong[0] < SystemClock.uptimeMillis() - 2000L);
      a(paramView);
      return;
    }
    ((Activity)this.jdField_a_of_type_AndroidContentContext).findViewById(2131365919).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.ConfigInfoTips
 * JD-Core Version:    0.7.0.1
 */