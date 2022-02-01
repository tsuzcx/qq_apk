package com.tencent.mobileqq.bubble;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import apwn;
import apxi;
import apxp;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class BubbleNewAIOAnim$7
  implements Runnable
{
  public BubbleNewAIOAnim$7(apxi paramapxi) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_JavaUtilArrayList != null) && (this.this$0.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_JavaUtilArrayList.iterator();
      if (localIterator.hasNext())
      {
        apxp localapxp = (apxp)localIterator.next();
        File localFile = new File(this.this$0.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.this$0.jdField_b_of_type_Int, false), this.this$0.jdField_a_of_type_Apwn.a);
        int i = 0;
        label93:
        Object localObject1;
        String str;
        if (i < localapxp.jdField_b_of_type_Int)
        {
          localObject1 = localFile.getAbsolutePath() + File.separatorChar + localapxp.jdField_b_of_type_JavaLangString + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
          str = localapxp.a + (String)localObject1;
          if (this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(str)) {
            break label310;
          }
          Object localObject3 = BaseApplicationImpl.sImageCache.get(str);
          if ((localObject3 == null) || (!(localObject3 instanceof Bitmap))) {
            break label259;
          }
          localObject1 = (Bitmap)localObject3;
        }
        for (;;)
        {
          if (localObject1 != null)
          {
            BaseApplicationImpl.sImageCache.put(str, localObject1);
            this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, localObject1);
          }
          i += 1;
          break label93;
          break;
          try
          {
            label259:
            localObject1 = BubbleManager.a((String)localObject1, null);
          }
          catch (Exception localException)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BubbleNewAIOAnim", 4, "decode error!", localException);
            }
            Object localObject2 = null;
          }
          catch (OutOfMemoryError localOutOfMemoryError)
          {
            if (QLog.isColorLevel()) {
              QLog.e("BubbleNewAIOAnim", 4, "decode error!", localOutOfMemoryError);
            }
            localBitmap = null;
          }
          continue;
          label310:
          Bitmap localBitmap = (Bitmap)this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7
 * JD-Core Version:    0.7.0.1
 */