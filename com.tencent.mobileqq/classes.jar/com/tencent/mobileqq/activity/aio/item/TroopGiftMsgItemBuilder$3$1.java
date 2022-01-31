package com.tencent.mobileqq.activity.aio.item;

import adsm;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.widget.BubbleImageView;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopGiftMsgItemBuilder$3$1
  implements Runnable
{
  TroopGiftMsgItemBuilder$3$1(TroopGiftMsgItemBuilder.3 param3) {}
  
  public void run()
  {
    Object localObject = (List)this.a.this$0.b.get(this.a.b);
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((Runnable)((Iterator)localObject).next()).run();
      }
    }
    this.a.this$0.b.remove(this.a.b);
    if (this.a.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.getTag(2131307015).equals(this.a.jdField_a_of_type_JavaLangString))
    {
      localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(this.a.jdField_a_of_type_Int);
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = new ColorDrawable(this.a.jdField_a_of_type_Int);
      localObject = URLDrawable.getDrawable(new File(this.a.this$0.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int)), (URLDrawable.URLDrawableOptions)localObject);
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView.setImageDrawable((Drawable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.3.1
 * JD-Core Version:    0.7.0.1
 */