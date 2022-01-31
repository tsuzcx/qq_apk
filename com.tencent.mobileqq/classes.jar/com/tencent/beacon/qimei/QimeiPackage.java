package com.tencent.beacon.qimei;

import com.tencent.beacon.core.wup.JceStruct;
import com.tencent.beacon.core.wup.a;
import com.tencent.beacon.core.wup.b;

public final class QimeiPackage
  extends JceStruct
  implements Cloneable
{
  public String androidId = "";
  public String brand = "";
  public boolean broot = false;
  public String cid = "";
  public String imei = "";
  public String imsi = "";
  public String mac = "";
  public String model = "";
  public String osVersion = "";
  public String qimei = "";
  public String qq = "";
  
  public final void readFrom(a parama)
  {
    this.qimei = parama.b(0, false);
    this.imei = parama.b(1, false);
    this.mac = parama.b(2, false);
    this.imsi = parama.b(3, false);
    this.androidId = parama.b(4, false);
    this.model = parama.b(5, false);
    this.brand = parama.b(6, false);
    this.osVersion = parama.b(7, false);
    this.broot = parama.a(8, false);
    this.qq = parama.b(9, false);
    this.cid = parama.b(10, false);
  }
  
  public final void writeTo(b paramb)
  {
    if (this.qimei != null) {
      paramb.a(this.qimei, 0);
    }
    if (this.imei != null) {
      paramb.a(this.imei, 1);
    }
    if (this.mac != null) {
      paramb.a(this.mac, 2);
    }
    if (this.imsi != null) {
      paramb.a(this.imsi, 3);
    }
    if (this.androidId != null) {
      paramb.a(this.androidId, 4);
    }
    if (this.model != null) {
      paramb.a(this.model, 5);
    }
    if (this.brand != null) {
      paramb.a(this.brand, 6);
    }
    if (this.osVersion != null) {
      paramb.a(this.osVersion, 7);
    }
    paramb.a(this.broot, 8);
    if (this.qq != null) {
      paramb.a(this.qq, 9);
    }
    if (this.cid != null) {
      paramb.a(this.cid, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.beacon.qimei.QimeiPackage
 * JD-Core Version:    0.7.0.1
 */