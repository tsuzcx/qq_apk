package com.tencent.mobileqq.activity.history;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ChatHistoryTroopMemberFragment$TroopAdmin
  implements Parcelable
{
  public static final Parcelable.Creator<TroopAdmin> CREATOR = new ChatHistoryTroopMemberFragment.TroopAdmin.1();
  public String a;
  public short b;
  public String c;
  public String d;
  
  public ChatHistoryTroopMemberFragment$TroopAdmin() {}
  
  private ChatHistoryTroopMemberFragment$TroopAdmin(Parcel paramParcel)
  {
    this.a = paramParcel.readString();
    this.b = ((short)paramParcel.readInt());
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TroopAdmin))
    {
      paramObject = (TroopAdmin)paramObject;
      String str = this.a;
      if (str != null) {
        return str.equals(paramObject.a);
      }
    }
    return false;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.a);
    paramParcel.writeInt(this.b);
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.TroopAdmin
 * JD-Core Version:    0.7.0.1
 */