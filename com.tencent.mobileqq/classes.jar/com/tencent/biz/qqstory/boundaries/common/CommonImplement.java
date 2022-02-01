package com.tencent.biz.qqstory.boundaries.common;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager;
import java.util.List;

public class CommonImplement
{
  public static Drawable a(List<String> paramList)
  {
    return ((ShareGroupIconManager)SuperManager.a(24)).b(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.boundaries.common.CommonImplement
 * JD-Core Version:    0.7.0.1
 */