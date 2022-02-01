package com.tencent.ilive.litepages.room.webmodule.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import com.tencent.ilive.base.event.ModuleEventInterface;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ParcelCreator"})
public class LiteShowLuxuryAnimationEvent
  implements ModuleEventInterface
{
  public String comboEffectWording;
  public List<LiteShowLuxuryAnimationEvent> data = new ArrayList();
  public String effectId;
  public int effectNum;
  public int effectType;
  public String giftIcon;
  public String giftName;
  public long giftTimestamp;
  public int giftType;
  public long giftid;
  public int giftnum;
  public String headKey;
  public long headTimestamp;
  public String headUrl;
  public String mBusinessUid;
  public MsgExtInfo mMsgExtInfo;
  public String playName;
  public long playUin;
  public long roomid;
  public long subroomid;
  public String uName;
  public long uin;
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.event.LiteShowLuxuryAnimationEvent
 * JD-Core Version:    0.7.0.1
 */