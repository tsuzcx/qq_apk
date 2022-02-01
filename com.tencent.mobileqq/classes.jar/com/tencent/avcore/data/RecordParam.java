package com.tencent.avcore.data;

public class RecordParam
{
  public int fps;
  public int height;
  public long intervalTime = 67L;
  public int width;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label71:
    label74:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof RecordParam)) {
        break;
      }
      paramObject = (RecordParam)paramObject;
      if (this.width == paramObject.width)
      {
        i = 1;
        if ((i == 0) || (this.height != paramObject.height)) {
          break label71;
        }
      }
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (this.fps == paramObject.fps)) {
          break label74;
        }
        return false;
        i = 0;
        break;
      }
    }
    return false;
  }
  
  public boolean isValid()
  {
    return (this.width != 0) && (this.height != 0) && (this.fps != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParam{").append("width: ").append(this.width).append(", height: ").append(this.height).append(", fps: ").append(this.fps).append("}");
    return localStringBuilder.toString();
  }
  
  public boolean update(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (this.width != paramInt1)
    {
      this.width = paramInt1;
      bool1 = true;
    }
    if (this.height != paramInt2)
    {
      this.height = paramInt2;
      bool1 = bool2;
    }
    for (;;)
    {
      if (this.fps != paramInt3)
      {
        this.fps = paramInt3;
        if (this.fps == 0) {
          this.fps = 15;
        }
        this.intervalTime = (1000 / this.fps);
      }
      return bool1;
    }
  }
  
  public boolean update(RecordParam paramRecordParam)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if ((paramRecordParam == null) || (!paramRecordParam.isValid()))
    {
      bool2 = false;
      return bool2;
    }
    if (this.width != paramRecordParam.width)
    {
      this.width = paramRecordParam.width;
      bool1 = true;
    }
    if (this.height != paramRecordParam.height)
    {
      this.height = paramRecordParam.height;
      bool1 = bool2;
    }
    for (;;)
    {
      bool2 = bool1;
      if (this.fps == paramRecordParam.fps) {
        break;
      }
      this.fps = paramRecordParam.fps;
      if (this.fps == 0) {
        this.fps = 15;
      }
      this.intervalTime = (1000 / this.fps);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.data.RecordParam
 * JD-Core Version:    0.7.0.1
 */