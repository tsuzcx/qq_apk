package com.tencent.mobileqq.app.face;

import anvi;

class FaceDecoderImpl$MyFriendListObserver
  extends anvi
{
  private FaceDecoderImpl$MyFriendListObserver(FaceDecoderImpl paramFaceDecoderImpl) {}
  
  public void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    this.this$0.onUpdateHead(paramBoolean, 116, paramString, 200, paramInt);
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 1, paramString, 0, 0);
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 11, paramString, 0, 0);
  }
  
  public void onUpdateQCallHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.this$0.onUpdateHead(paramBoolean1, 16, paramString, paramInt, 0);
  }
  
  public void onUpdateStrangerHead(boolean paramBoolean1, String paramString, int paramInt, boolean paramBoolean2)
  {
    this.this$0.onUpdateHead(paramBoolean1, 32, paramString, paramInt, 0);
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    this.this$0.onUpdateHead(paramBoolean, 4, paramString, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.FaceDecoderImpl.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */