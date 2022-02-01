package com.etrump.mixlayout.api;

public abstract interface IETFont
{
  public abstract void copy(IETFont paramIETFont);
  
  public abstract void disableEffects(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int getColor();
  
  public abstract long getDIYConfigHandle();
  
  public abstract int getFontType();
  
  public abstract int getId();
  
  public abstract String getPath();
  
  public abstract int getSize();
  
  public abstract long get_substitution();
  
  public abstract boolean isBold();
  
  public abstract void onDestroy();
  
  public abstract void parseDIYJsonString(String paramString);
  
  public abstract void setBold(boolean paramBoolean);
  
  public abstract void setColor(int paramInt);
  
  public abstract void setCrochet(boolean paramBoolean, int paramInt1, int paramInt2);
  
  public abstract void setDIYConfigHandle(long paramLong);
  
  public abstract void setFontType(int paramInt);
  
  public abstract void setId(int paramInt);
  
  public abstract void setPath(String paramString);
  
  public abstract void setShadow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setSize(float paramFloat);
  
  public abstract void set_substitution(long paramLong);
  
  public abstract String toString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.api.IETFont
 * JD-Core Version:    0.7.0.1
 */