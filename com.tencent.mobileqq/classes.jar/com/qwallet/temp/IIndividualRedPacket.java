package com.qwallet.temp;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfo;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={""})
public abstract interface IIndividualRedPacket
  extends IRuntimeService
{
  public abstract int IndividualRedPacketManager$FLAG_REDPACKET_CANNOT_USE();
  
  public abstract int IndividualRedPacketManager$FLAG_REDPACKET_ENABLE();
  
  public abstract boolean IndividualRedPacketResDownloader$isShowRedpacket();
  
  public abstract void dealRedPacketToShow(RedPacketInfo paramRedPacketInfo);
  
  public abstract boolean getIndividualRedPacketEnable();
  
  public abstract String getMallURL(int paramInt);
  
  public abstract String getTenpayCombineImg(String paramString1, String paramString2);
  
  public abstract boolean isAllowShowRedpacket();
  
  public abstract boolean isIndividualRedPacketEnable();
  
  public abstract boolean isSDCardError();
  
  public abstract void setRedPacketFlags(int paramInt1, int paramInt2, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IIndividualRedPacket
 * JD-Core Version:    0.7.0.1
 */