package com.tencent.biz.troopgift;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0xcd1.Oidb_0xcd1.EmptyPackagePage;

public class TroopGiftAioPanelData$EmptyPackagePage
{
  public int a = 0;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public TroopGiftAioPanelData$EmptyPackagePage(Oidb_0xcd1.EmptyPackagePage paramEmptyPackagePage)
  {
    this.a = paramEmptyPackagePage.enable.get();
    this.b = paramEmptyPackagePage.wording.get();
    this.c = paramEmptyPackagePage.jump_wording.get();
    this.d = paramEmptyPackagePage.jump_url.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.EmptyPackagePage
 * JD-Core Version:    0.7.0.1
 */