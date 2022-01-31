package com.tencent.mobileqq.activity.aio.stickerrecommended;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="md5")
public class StickerRecCacheEntity
  extends awge
{
  public String filePath;
  public long lastTime;
  public String md5;
  
  public StickerRecCacheEntity() {}
  
  public StickerRecCacheEntity(String paramString1, long paramLong, String paramString2)
  {
    this.filePath = paramString1;
    this.lastTime = paramLong;
    this.md5 = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while ((getClass() != paramObject.getClass()) || (!(paramObject instanceof StickerRecCacheEntity)));
    paramObject = (StickerRecCacheEntity)paramObject;
    return this.md5.equals(paramObject.md5);
  }
  
  public void replace(StickerRecCacheEntity paramStickerRecCacheEntity)
  {
    if (paramStickerRecCacheEntity != null) {
      this.lastTime = paramStickerRecCacheEntity.lastTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecCacheEntity
 * JD-Core Version:    0.7.0.1
 */