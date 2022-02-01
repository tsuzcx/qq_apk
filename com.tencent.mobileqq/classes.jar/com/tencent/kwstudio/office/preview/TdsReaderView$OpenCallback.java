package com.tencent.kwstudio.office.preview;

import android.os.Bundle;

public abstract interface TdsReaderView$OpenCallback
{
  public static final int ACTION_OPEN_ERROR = 2001;
  public static final String RESULT_ = "result_";
  public static final String RESULT_0 = "result_0";
  public static final String RESULT_1 = "result_1";
  public static final int VIEW_GET_TITLE_BAR_HEIGHT = 1001;
  public static final int VIEW_SET_TITLE_BAR_VISIBILITY = 1002;
  
  public abstract void onCallBackAction(Integer paramInteger, Object paramObject, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.kwstudio.office.preview.TdsReaderView.OpenCallback
 * JD-Core Version:    0.7.0.1
 */