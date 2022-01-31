package com.tencent.biz.qqstory.database;

import android.os.Parcel;
import auko;
import aumc;
import java.util.ArrayList;
import java.util.List;

public class ShareGroupEntry
  extends auko
{
  public int allowStrangerVisitAndPost;
  public String backgroundUrl;
  public long dbCacheTime = -1L;
  public int followCount;
  public long groupUin;
  public byte[] headerUnionIdListBytes;
  public int isDisband;
  public int isSubscribed;
  public int memberCount;
  public String name;
  public int ownerType;
  public String ownerUnionId;
  @aumc
  public String shareGroupId;
  public int type;
  public int videoCount;
  
  public static String getShareGroupSelectionNoArg()
  {
    return "shareGroupId=?";
  }
  
  public List<String> getHeaderUnionIdListBytes()
  {
    if (this.headerUnionIdListBytes == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      ArrayList localArrayList = new ArrayList();
      localParcel.unmarshall(this.headerUnionIdListBytes, 0, this.headerUnionIdListBytes.length);
      localParcel.setDataPosition(0);
      localParcel.readStringList(localArrayList);
      return localArrayList;
    }
    finally
    {
      localParcel.recycle();
    }
  }
  
  public void setHeaderUnionIdListBytes(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      localParcel.writeStringList(paramList);
      this.headerUnionIdListBytes = localParcel.marshall();
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.ShareGroupEntry
 * JD-Core Version:    0.7.0.1
 */