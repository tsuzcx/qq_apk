package com.tencent.biz.qqstory.playvideo.preload;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class PlayerDataPreLoader$Result
{
  public List<String> a = new ArrayList();
  public List<String> b = new ArrayList();
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!this.b.contains(paramString))) {
      this.b.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.preload.PlayerDataPreLoader.Result
 * JD-Core Version:    0.7.0.1
 */