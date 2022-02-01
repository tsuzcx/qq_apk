package com.tencent.avcore.data;

public class RecordParam
{
  public int fps;
  public int height;
  public long intervalTime = 67L;
  public int width;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    boolean bool3 = paramObject instanceof RecordParam;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (RecordParam)paramObject;
      int i;
      if (this.width == paramObject.width) {
        i = 1;
      } else {
        i = 0;
      }
      if ((i != 0) && (this.height == paramObject.height)) {
        i = 1;
      } else {
        i = 0;
      }
      bool1 = bool2;
      if (i != 0)
      {
        bool1 = bool2;
        if (this.fps == paramObject.fps) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isValid()
  {
    return (this.width != 0) && (this.height != 0) && (this.fps != 0);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecordParam{");
    localStringBuilder.append("width: ");
    localStringBuilder.append(this.width);
    localStringBuilder.append(", height: ");
    localStringBuilder.append(this.height);
    localStringBuilder.append(", fps: ");
    localStringBuilder.append(this.fps);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public boolean update(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (this.width != paramInt1)
    {
      this.width = paramInt1;
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (this.height != paramInt2)
    {
      this.height = paramInt2;
      bool = true;
    }
    if (this.fps != paramInt3)
    {
      this.fps = paramInt3;
      if (this.fps == 0) {
        this.fps = 15;
      }
      this.intervalTime = (1000 / this.fps);
    }
    return bool;
  }
  
  public boolean update(RecordParam paramRecordParam)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramRecordParam != null)
    {
      if (!paramRecordParam.isValid()) {
        return false;
      }
      int i = this.width;
      int j = paramRecordParam.width;
      if (i != j)
      {
        this.width = j;
        bool1 = true;
      }
      i = this.height;
      j = paramRecordParam.height;
      if (i != j)
      {
        this.height = j;
        bool1 = true;
      }
      i = this.fps;
      j = paramRecordParam.fps;
      bool2 = bool1;
      if (i != j)
      {
        this.fps = j;
        if (this.fps == 0) {
          this.fps = 15;
        }
        this.intervalTime = (1000 / this.fps);
        bool2 = bool1;
      }
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.data.RecordParam
 * JD-Core Version:    0.7.0.1
 */