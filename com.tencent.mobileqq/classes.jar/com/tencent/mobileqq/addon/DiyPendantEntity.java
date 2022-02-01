package com.tencent.mobileqq.addon;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.pb.pendant.DiyAddonUser.UserStickerInfo;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiyPendantEntity
  extends Entity
{
  public int borderId;
  public int diyId;
  @notColumn
  public ArrayList<DiyPendantSticker> stickerList;
  public byte[] stickers;
  @unique
  public String uinAndDiyId;
  public long updateTs;
  
  public ArrayList<DiyPendantSticker> getStickerInfoList()
  {
    if (this.stickerList != null) {
      return this.stickerList;
    }
    if (this.stickers != null) {}
    try
    {
      this.stickerList = ((ArrayList)new ObjectInputStream(new ByteArrayInputStream(this.stickers)).readObject());
      return new ArrayList();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public byte[] setStickerInfoList(List<DiyAddonUser.UserStickerInfo> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return null;
    }
    try
    {
      this.stickerList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (DiyAddonUser.UserStickerInfo)paramList.next();
        this.stickerList.add(new DiyPendantSticker(((DiyAddonUser.UserStickerInfo)localObject).type.get(), ((DiyAddonUser.UserStickerInfo)localObject).stickerid.get(), ((DiyAddonUser.UserStickerInfo)localObject).angle.get(), ((DiyAddonUser.UserStickerInfo)localObject).text.get(), ((DiyAddonUser.UserStickerInfo)localObject).fontid.get(), ((DiyAddonUser.UserStickerInfo)localObject).fonttype.get(), ((DiyAddonUser.UserStickerInfo)localObject).fontcolor.get()));
      }
      paramList = new ByteArrayOutputStream();
    }
    catch (IOException paramList)
    {
      paramList.printStackTrace();
      return null;
    }
    Object localObject = new ObjectOutputStream(paramList);
    ((ObjectOutputStream)localObject).writeObject(this.stickerList);
    ((ObjectOutputStream)localObject).flush();
    this.stickers = paramList.toByteArray();
    paramList = this.stickers;
    return paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.addon.DiyPendantEntity
 * JD-Core Version:    0.7.0.1
 */