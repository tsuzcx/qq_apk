package com.tencent.mobileqq.apollo.view.pannel;

import android.view.View.OnClickListener;
import android.widget.PopupWindow.OnDismissListener;
import java.lang.ref.WeakReference;
import java.util.Deque;

class ApolloPanel$9
  implements PopupWindow.OnDismissListener
{
  ApolloPanel$9(ApolloPanel paramApolloPanel) {}
  
  public void onDismiss()
  {
    View.OnClickListener localOnClickListener = null;
    ApolloPanel.a(this.a, null);
    if ((ApolloPanel.a(this.a) != null) && (ApolloPanel.a(this.a).size() > 0))
    {
      ApolloPanel.PopupWindowData localPopupWindowData = (ApolloPanel.PopupWindowData)ApolloPanel.a(this.a).poll();
      if (ApolloPanel.a(this.a).size() == 0) {
        ApolloPanel.a(this.a, null);
      }
      if (localPopupWindowData != null)
      {
        if (localPopupWindowData.jdField_a_of_type_JavaLangRefWeakReference != null) {
          localOnClickListener = (View.OnClickListener)localPopupWindowData.jdField_a_of_type_JavaLangRefWeakReference.get();
        }
        ApolloPanel.a(this.a, localPopupWindowData.jdField_a_of_type_AndroidViewView, localPopupWindowData.jdField_a_of_type_Int, localPopupWindowData.jdField_a_of_type_JavaLangString, localPopupWindowData.b, localOnClickListener);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.9
 * JD-Core Version:    0.7.0.1
 */