package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import java.lang.ref.WeakReference;

class FrameHelperActivity$9$1
  implements Runnable
{
  FrameHelperActivity$9$1(FrameHelperActivity.9 param9, Conversation paramConversation, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation != null) && (this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.isAdded()))
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityHomeConversation.b;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        i = AIOUtils.b(12.0F, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.getResources());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i, i);
      }
      Drawable localDrawable = this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.getResources().getDrawable(2130838630);
      int i = AIOUtils.b(9.0F, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.getResources());
      localDrawable.setBounds(0, 0, i, i);
      ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.getResources()));
      ((TextView)localObject).setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, localDrawable, null);
      localObject = ((TextView)localObject).getTag(2131366283);
      if ((localObject instanceof WeakReference))
      {
        localObject = (WeakReference)localObject;
        if ((((WeakReference)localObject).get() instanceof TextView))
        {
          localObject = (TextView)((WeakReference)localObject).get();
          break label181;
        }
      }
      localObject = null;
      label181:
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setCompoundDrawablePadding(AIOUtils.b(2.0F, this.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity$9.a.getResources()));
        ((TextView)localObject).setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, localDrawable, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.1
 * JD-Core Version:    0.7.0.1
 */