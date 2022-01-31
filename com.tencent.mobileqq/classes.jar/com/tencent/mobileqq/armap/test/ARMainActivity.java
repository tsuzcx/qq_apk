package com.tencent.mobileqq.armap.test;

import aban;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.qq.im.poi.LbsPackListActivity;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.armap.ARMapActivity;
import com.tencent.mobileqq.armap.ARMapBaseTitleActivity;
import com.tencent.mobileqq.armap.OpenBoxActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ARMainActivity
  extends ARMapBaseTitleActivity
  implements View.OnClickListener
{
  public static String a;
  Button a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "key_armap_guide_switch";
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    boolean bool = new File(ArNativeSoLoader.a() + File.separator + "inner665.ini").exists();
    QLog.d("ARMainActivity", 1, "innerSo=" + bool);
    if (bool) {
      System.loadLibrary("armapengine");
    }
    for (;;)
    {
      setContentView(2130970199);
      findViewById(2131369568).setOnClickListener(this);
      findViewById(2131362556).setOnClickListener(this);
      findViewById(2131369569).setOnClickListener(this);
      findViewById(2131369570).setOnClickListener(this);
      findViewById(2131369572).setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131369571));
      this.jdField_a_of_type_AndroidWidgetButton.setOnLongClickListener(new aban(this));
      return true;
      if (!ARNativeBridge.loadNativeLibrary())
      {
        QLog.d("ARMainActivity", 1, "ARMapActivity, load SO failed");
        QQToast.a(this, 1, "数据加载失败", 1).a();
        finish();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369568: 
      paramView = new Intent(getActivity(), ARMapActivity.class);
      paramView.putExtra("load_armap", false);
      startActivity(paramView);
      return;
    case 2131362556: 
      paramView = new Intent(getActivity(), ARWebTestActivity.class);
      paramView.putExtra("url", "http://mma.qq.com/dev-tmp/qqar-map/map.html");
      startActivity(paramView);
    case 2131369569: 
      startActivity(new Intent(this, ArmapJumpActivity.class));
      return;
    case 2131369570: 
      paramView = new Intent(this, OpenBoxActivity.class);
      paramView.putExtra("task_id", 1891095575279602L);
      paramView.putExtra("task_type", 7);
      paramView.putExtra("poi_id", 3363504214613702166L);
      paramView.putExtra("distance", 100);
      paramView.putExtra("business_name", "");
      startActivity(paramView);
      return;
    }
    startActivity(new Intent(this, LbsPackListActivity.class));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.test.ARMainActivity
 * JD-Core Version:    0.7.0.1
 */