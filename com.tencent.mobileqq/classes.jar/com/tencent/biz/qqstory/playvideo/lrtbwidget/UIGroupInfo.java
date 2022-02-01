package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UIGroupInfo
  extends IDataProvider.GroupInfo
{
  public final boolean a;
  public final String g;
  public final ErrorMessage h;
  
  public UIGroupInfo(@NonNull ErrorMessage paramErrorMessage, boolean paramBoolean)
  {
    super(new IDataProvider.GroupId(localStringBuilder.toString()));
    this.g = null;
    this.h = paramErrorMessage;
    this.a = paramBoolean;
    this.c = new ArrayList();
    this.c.add("ERROR");
    this.d = new HashMap();
    this.d.put("ERROR", "ERROR");
  }
  
  public UIGroupInfo(@NonNull String paramString, boolean paramBoolean)
  {
    super(new IDataProvider.GroupId(localStringBuilder.toString()));
    this.g = paramString;
    this.h = null;
    this.a = paramBoolean;
    this.c = new ArrayList();
    this.c.add("LOADING");
    this.d = new HashMap();
    this.d.put("LOADING", "LOADING");
  }
  
  public boolean b()
  {
    return this.h != null;
  }
  
  public boolean c()
  {
    return this.g != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.UIGroupInfo
 * JD-Core Version:    0.7.0.1
 */