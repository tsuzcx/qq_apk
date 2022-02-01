package com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp;

public abstract interface IStickerPresenter<M extends IStickerModel, V extends IStickerView>
{
  public abstract M a();
  
  public abstract void a(V paramV, M paramM);
  
  public abstract void a(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.adapter.mvp.IStickerPresenter
 * JD-Core Version:    0.7.0.1
 */