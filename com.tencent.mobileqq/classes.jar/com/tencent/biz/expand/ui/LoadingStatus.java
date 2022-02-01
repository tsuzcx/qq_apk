package com.tencent.biz.expand.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/LoadingStatus;", "", "(Ljava/lang/String;I)V", "LOADING", "LOADING_ERROR_NETWORK", "LOADING_ERROR", "LOADING_SUCCESS", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum LoadingStatus
{
  static
  {
    LoadingStatus localLoadingStatus1 = new LoadingStatus("LOADING", 0);
    LOADING = localLoadingStatus1;
    LoadingStatus localLoadingStatus2 = new LoadingStatus("LOADING_ERROR_NETWORK", 1);
    LOADING_ERROR_NETWORK = localLoadingStatus2;
    LoadingStatus localLoadingStatus3 = new LoadingStatus("LOADING_ERROR", 2);
    LOADING_ERROR = localLoadingStatus3;
    LoadingStatus localLoadingStatus4 = new LoadingStatus("LOADING_SUCCESS", 3);
    LOADING_SUCCESS = localLoadingStatus4;
    $VALUES = new LoadingStatus[] { localLoadingStatus1, localLoadingStatus2, localLoadingStatus3, localLoadingStatus4 };
  }
  
  private LoadingStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.LoadingStatus
 * JD-Core Version:    0.7.0.1
 */