package com.tencent.biz.pubaccount.util;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGround;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.ForeBackGroundCallback;
import java.util.List;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.IdlePushWakeParam;

public class SneakyCallback
  implements ReadinjoySPEventReport.ForeBackGroundCallback
{
  private static SneakyCallback a = new SneakyCallback();
  
  public static void a()
  {
    ReadinjoySPEventReport.ForeBackGround.a(a);
  }
  
  public static void a(int paramInt) {}
  
  public static void a(List<oidb_cmd0x80a.IdlePushWakeParam> paramList) {}
  
  public static void b()
  {
    ReadinjoySPEventReport.ForeBackGround.b(a);
  }
  
  public void l() {}
  
  public void m() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.SneakyCallback
 * JD-Core Version:    0.7.0.1
 */