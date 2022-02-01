package com.tencent.beacon.pack;

public final class QimeiPackage
  extends AbstractJceStruct
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
  
  protected Object clone()
  {
    return super.clone();
  }
  
  public void readFrom(a parama)
  {
    this.qimei = parama.a(0, false);
    this.imei = parama.a(1, false);
    this.mac = parama.a(2, false);
    this.imsi = parama.a(3, false);
    this.androidId = parama.a(4, false);
    this.model = parama.a(5, false);
    this.brand = parama.a(6, false);
    this.osVersion = parama.a(7, false);
    this.broot = parama.a(this.broot, 8, false);
    this.qq = parama.a(9, false);
    this.cid = parama.a(10, false);
  }
  
  public void writeTo(b paramb)
  {
    String str = this.qimei;
    if (str != null) {
      paramb.a(str, 0);
    }
    str = this.imei;
    if (str != null) {
      paramb.a(str, 1);
    }
    str = this.mac;
    if (str != null) {
      paramb.a(str, 2);
    }
    str = this.imsi;
    if (str != null) {
      paramb.a(str, 3);
    }
    str = this.androidId;
    if (str != null) {
      paramb.a(str, 4);
    }
    str = this.model;
    if (str != null) {
      paramb.a(str, 5);
    }
    str = this.brand;
    if (str != null) {
      paramb.a(str, 6);
    }
    str = this.osVersion;
    if (str != null) {
      paramb.a(str, 7);
    }
    paramb.a(this.broot, 8);
    str = this.qq;
    if (str != null) {
      paramb.a(str, 9);
    }
    str = this.cid;
    if (str != null) {
      paramb.a(str, 10);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.pack.QimeiPackage
 * JD-Core Version:    0.7.0.1
 */