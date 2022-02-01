package com.tencent.liteav.basic.module;

public class a
{
  private String mID = "";
  
  public void clearID()
  {
    try
    {
      if (this.mID.length() != 0)
      {
        TXCStatus.b(this.mID);
        this.mID = "";
      }
      return;
    }
    finally {}
  }
  
  public void finalize()
  {
    clearID();
    super.finalize();
  }
  
  public double getDoubleValue(int paramInt)
  {
    return TXCStatus.d(this.mID, paramInt);
  }
  
  public double getDoubleValue(int paramInt1, int paramInt2)
  {
    return TXCStatus.d(this.mID, paramInt1, paramInt2);
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public int getIntValue(int paramInt)
  {
    return TXCStatus.c(this.mID, paramInt);
  }
  
  public int getIntValue(int paramInt1, int paramInt2)
  {
    return TXCStatus.c(this.mID, paramInt1, paramInt2);
  }
  
  public long getLongValue(int paramInt)
  {
    return TXCStatus.a(this.mID, paramInt);
  }
  
  public long getLongValue(int paramInt1, int paramInt2)
  {
    return TXCStatus.a(this.mID, paramInt1, paramInt2);
  }
  
  public String getStringValue(int paramInt)
  {
    return TXCStatus.b(this.mID, paramInt);
  }
  
  public String getStringValue(int paramInt1, int paramInt2)
  {
    return TXCStatus.b(this.mID, paramInt1, paramInt2);
  }
  
  public void setID(String paramString)
  {
    clearID();
    try
    {
      if (paramString.length() != 0)
      {
        this.mID = paramString;
        TXCStatus.a(this.mID);
      }
      return;
    }
    finally {}
  }
  
  public boolean setStatusValue(int paramInt1, int paramInt2, Object paramObject)
  {
    return TXCStatus.a(this.mID, paramInt1, paramInt2, paramObject);
  }
  
  public boolean setStatusValue(int paramInt, Object paramObject)
  {
    return TXCStatus.a(this.mID, paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.a
 * JD-Core Version:    0.7.0.1
 */