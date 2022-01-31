package com.tencent.mobileqq.activity.bless;

import android.text.TextUtils;
import aukm;
import auma;

public class BlessWording
  extends aukm
{
  private String editingWording;
  @auma
  public String wording;
  
  public BlessWording() {}
  
  public BlessWording(String paramString)
  {
    this.wording = paramString;
  }
  
  public String getEditingWording()
  {
    return this.editingWording;
  }
  
  public boolean hasEditingWording()
  {
    return !TextUtils.isEmpty(this.editingWording);
  }
  
  public void setEditingWording(String paramString)
  {
    this.editingWording = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessWording
 * JD-Core Version:    0.7.0.1
 */