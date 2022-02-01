package com.tencent.mobileqq.app;

import afur;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import anmk;
import com.tencent.mobileqq.activity.Conversation;
import java.lang.ref.WeakReference;

public class FrameHelperActivity$9$1
  implements Runnable
{
  public FrameHelperActivity$9$1(anmk paramanmk, Conversation paramConversation, Drawable paramDrawable, String paramString) {}
  
  public void run()
  {
    Drawable localDrawable;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityConversation != null) && (this.jdField_a_of_type_Anmk.a.isAdded()))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        i = afur.a(12.0F, this.jdField_a_of_type_Anmk.a.getResources());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, 0, i, i);
      }
      localDrawable = this.jdField_a_of_type_Anmk.a.getResources().getDrawable(2130838663);
      int i = afur.a(9.0F, this.jdField_a_of_type_Anmk.a.getResources());
      localDrawable.setBounds(0, 0, i, i);
      ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
      ((TextView)localObject).setCompoundDrawablePadding(afur.a(2.0F, this.jdField_a_of_type_Anmk.a.getResources()));
      ((TextView)localObject).setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, localDrawable, null);
      localObject = ((TextView)localObject).getTag(2131366055);
      if ((!(localObject instanceof WeakReference)) || (!(((WeakReference)localObject).get() instanceof TextView))) {
        break label219;
      }
    }
    label219:
    for (Object localObject = (TextView)((WeakReference)localObject).get();; localObject = null)
    {
      if (localObject != null)
      {
        ((TextView)localObject).setText(this.jdField_a_of_type_JavaLangString);
        ((TextView)localObject).setCompoundDrawablePadding(afur.a(2.0F, this.jdField_a_of_type_Anmk.a.getResources()));
        ((TextView)localObject).setCompoundDrawables(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, localDrawable, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.9.1
 * JD-Core Version:    0.7.0.1
 */