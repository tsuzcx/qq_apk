package com.tencent.mobileqq.app;

import android.view.View;
import java.lang.ref.WeakReference;

class TroopQZoneUploadAlbumHandler$CallbackPack
{
  WeakReference<View> a;
  WeakReference<TroopQZoneUploadAlbumHandler.Callback> b;
  
  public TroopQZoneUploadAlbumHandler$CallbackPack(TroopQZoneUploadAlbumHandler paramTroopQZoneUploadAlbumHandler, View paramView, TroopQZoneUploadAlbumHandler.Callback paramCallback)
  {
    this.a = new WeakReference(paramView);
    this.b = new WeakReference(paramCallback);
  }
  
  public View a()
  {
    return (View)this.a.get();
  }
  
  public TroopQZoneUploadAlbumHandler.Callback b()
  {
    return (TroopQZoneUploadAlbumHandler.Callback)this.b.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.CallbackPack
 * JD-Core Version:    0.7.0.1
 */