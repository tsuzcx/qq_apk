package com.tencent.ilive.opensdk.params;

public class PTFilterItem
{
  public static final int NONE = -1;
  protected int defProgress;
  public int filterEnumIndex;
  public String filterPath;
  public boolean isColorTone = false;
  public boolean isSelected;
  public String name;
  public int progress;
  public int resId;
  public String saveKey;
  public int type;
  
  public PTFilterItem(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, int paramInt3, boolean paramBoolean)
  {
    this.name = paramString1;
    this.resId = paramInt2;
    this.filterPath = paramString2;
    this.saveKey = paramString3;
    this.progress = paramInt3;
    this.defProgress = paramInt3;
    this.type = paramInt1;
    this.isColorTone = paramBoolean;
  }
  
  public int getDefProgress()
  {
    return this.defProgress;
  }
  
  public int getProgress()
  {
    return this.progress;
  }
  
  public int resetProgress()
  {
    this.progress = this.defProgress;
    return this.progress;
  }
  
  public void resetSelected()
  {
    this.isSelected = false;
  }
  
  public void setProgress(int paramInt)
  {
    this.progress = paramInt;
  }
  
  public void setSelected(boolean paramBoolean)
  {
    this.isSelected = paramBoolean;
  }
  
  public String toString()
  {
    return "PTFilterItemInfo{name='" + this.name + '\'' + ", filterEnumIndex=" + this.filterEnumIndex + ", id:" + this.resId + ",path:" + this.filterPath + ",selected:" + this.isSelected + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.opensdk.params.PTFilterItem
 * JD-Core Version:    0.7.0.1
 */