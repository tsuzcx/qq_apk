package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(21)
class b$d
  extends ScanCallback
{
  private final WeakReference<e> a;
  
  b$d(e parame)
  {
    this.a = new WeakReference(parame);
  }
  
  public void onBatchScanResults(List<ScanResult> paramList)
  {
    e locale = (e)this.a.get();
    if (locale == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new h((ScanResult)paramList.next()));
    }
    locale.a(localArrayList);
  }
  
  public void onScanFailed(int paramInt)
  {
    e locale = (e)this.a.get();
    if (locale != null) {
      locale.a(paramInt);
    }
  }
  
  public void onScanResult(int paramInt, ScanResult paramScanResult)
  {
    e locale = (e)this.a.get();
    if (locale != null) {
      locale.a(paramInt, new h(paramScanResult));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.b.d
 * JD-Core Version:    0.7.0.1
 */