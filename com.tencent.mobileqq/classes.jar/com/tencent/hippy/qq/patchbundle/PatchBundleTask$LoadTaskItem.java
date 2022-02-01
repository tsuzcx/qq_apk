package com.tencent.hippy.qq.patchbundle;

class PatchBundleTask$LoadTaskItem
{
  public String mFilePath;
  public String mUrl;
  
  public PatchBundleTask$LoadTaskItem(String paramString)
  {
    this.mUrl = paramString;
    this.mFilePath = PatchUtils.getBundleFilePath(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchBundleTask.LoadTaskItem
 * JD-Core Version:    0.7.0.1
 */