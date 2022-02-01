package com.tencent.ilive.litepages.room.webmodule.event;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.tencent.ilive.base.event.ModuleEventInterface;
import java.util.ArrayList;

@SuppressLint({"ParcelCreator"})
public class PreloadLuxuryAnimationEvent
  implements ModuleEventInterface
{
  public ArrayList<String> effectIds;
  
  public PreloadLuxuryAnimationEvent(ArrayList<String> paramArrayList)
  {
    this.effectIds = paramArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.event.PreloadLuxuryAnimationEvent
 * JD-Core Version:    0.7.0.1
 */