package com.tencent.comic.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observer;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface IQQComicRedTouchService
  extends IRuntimeService
{
  public static final int PATH_CONVERT_MODE_LEBA_2_MORE = 0;
  public static final int PATH_CONVERT_MODE_MORE_2_LEBA = 1;
  
  public abstract void addObserver(Observer paramObserver);
  
  public abstract String convertString(String paramString, int paramInt);
  
  public abstract void deleteObserver(Observer paramObserver);
  
  public abstract Map<String, Object> getRedAppInfo(ArrayList<String> paramArrayList);
  
  public abstract boolean isLebaItemOpen(int paramInt);
  
  public abstract void reportRedTouchClick(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicRedTouchService
 * JD-Core Version:    0.7.0.1
 */