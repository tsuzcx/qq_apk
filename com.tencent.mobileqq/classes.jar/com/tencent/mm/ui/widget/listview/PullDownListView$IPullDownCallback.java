package com.tencent.mm.ui.widget.listview;

public abstract interface PullDownListView$IPullDownCallback
{
  public abstract void init();
  
  public abstract void onCoordinationViewClosing(int paramInt);
  
  public abstract void onCoordinationViewOpening(int paramInt);
  
  public abstract void onListInnerScroll(int paramInt);
  
  public abstract void onMuteIn();
  
  public abstract void onMuteOut();
  
  public abstract void onPostClose();
  
  public abstract void onPostOpen(boolean paramBoolean);
  
  public abstract void onPreClose();
  
  public abstract void onPreOpen();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.IPullDownCallback
 * JD-Core Version:    0.7.0.1
 */