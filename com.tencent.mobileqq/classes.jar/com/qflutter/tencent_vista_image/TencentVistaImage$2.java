package com.qflutter.tencent_vista_image;

import java.util.Map;
import rx.functions.Action1;

class TencentVistaImage$2
  implements Action1<TextureRecord>
{
  TencentVistaImage$2(TencentVistaImage paramTencentVistaImage) {}
  
  public void call(TextureRecord paramTextureRecord)
  {
    if (paramTextureRecord.release()) {
      TencentVistaImage.access$000(this.this$0).remove(paramTextureRecord.getTextureKey());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.TencentVistaImage.2
 * JD-Core Version:    0.7.0.1
 */