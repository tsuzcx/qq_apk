package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.PoiMapActivity;
import com.tencent.mobileqq.ar.arengine.ARCloudLBSLocationCheckResult.POIInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ARLBSPOIDialog$3
  implements View.OnClickListener
{
  ARLBSPOIDialog$3(ARLBSPOIDialog paramARLBSPOIDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    Intent localIntent = new Intent(paramView.getContext(), PoiMapActivity.class);
    double d = this.a.v.a;
    Double.isNaN(d);
    localIntent = localIntent.putExtra("lat", Double.toString(d * 1.0D / 1000000.0D));
    d = this.a.v.b;
    Double.isNaN(d);
    localIntent = localIntent.putExtra("lon", Double.toString(d * 1.0D / 1000000.0D));
    this.a.a.startActivity(localIntent);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARLBSPOIDialog.3
 * JD-Core Version:    0.7.0.1
 */