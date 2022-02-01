package com.tencent.mobileqq.activity.aio.item;

import android.widget.ImageView;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$7$3
  implements Runnable
{
  MarketFaceItemBuilder$7$3(MarketFaceItemBuilder.7 param7, MarketFaceItemBuilder.Holder paramHolder, Emoticon paramEmoticon) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((MarketFaceItemBuilder.Holder)localObject).t != null)) {
      if ((this.c.a.E) && (this.c.a.D.isDPCSupportH5Magic()))
      {
        this.a.t.setVisibility(0);
        this.a.t.setImageResource(2130837998);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("magicFaceIcon visible,h5source download sucess and doesnot needplay epId = ");
          ((StringBuilder)localObject).append(this.b.epId);
          QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        this.a.t.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.3
 * JD-Core Version:    0.7.0.1
 */