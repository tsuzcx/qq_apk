package com.etrump.mixlayout;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

class ETTextView$DecorationHandler
  extends Handler
{
  public ETTextView$DecorationHandler(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2)
    {
      if (i != 3) {
        return;
      }
      if (ETTextView.access$300() != null)
      {
        ETTextView.access$300().recycle();
        ETTextView.access$302(null);
      }
    }
    else
    {
      paramMessage = (ETTextView.DecorationHolder)paramMessage.obj;
      if (paramMessage != null)
      {
        int k = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
        int m = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
        if ((ETTextView.access$300() != null) && ((ETTextView.access$300().getWidth() < k) || (ETTextView.access$300().getHeight() < m)))
        {
          ETTextView.access$300().recycle();
          ETTextView.access$302(null);
        }
        Object localObject1 = ETTextView.access$300();
        i = 0;
        int j = 0;
        if (localObject1 == null) {
          ETTextView.access$302(Bitmap.createBitmap(k, m, Bitmap.Config.ARGB_8888));
        } else {
          ETTextView.access$300().eraseColor(0);
        }
        localObject1 = ETEngine.getInstanceForAnimation();
        Object localObject2 = paramMessage.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a((ETEngine)localObject1, false);
        if (localObject2 != null) {
          ((ETDecoration)localObject2).gotoFrame(paramMessage.jdField_a_of_type_Int);
        }
        paramMessage.jdField_a_of_type_ComEtrumpMixlayoutETLayout.a((ETEngine)localObject1, ETTextView.access$300(), (ETDecoration)localObject2, true);
        if (localObject2 != null) {
          ((ETDecoration)localObject2).deleteDescriptor();
        }
        Bitmap localBitmap = paramMessage.jdField_a_of_type_AndroidGraphicsBitmap;
        if (paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get() != null)
        {
          localObject2 = ETTextView.access$400((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get());
          i = j;
          try
          {
            if (!localBitmap.isRecycled())
            {
              i = j;
              if (((ETTextView)paramMessage.jdField_a_of_type_JavaLangRefWeakReference.get()).mMsgId == paramMessage.jdField_a_of_type_Long)
              {
                localBitmap.eraseColor(0);
                ((ETEngine)localObject1).native_cloneBitmap(ETTextView.access$300(), localBitmap);
                i = 1;
              }
            }
          }
          finally {}
        }
        if (i != 0) {
          ETTextView.access$500().obtainMessage(1, paramMessage).sendToTarget();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.etrump.mixlayout.ETTextView.DecorationHandler
 * JD-Core Version:    0.7.0.1
 */