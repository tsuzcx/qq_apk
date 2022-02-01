package com.tencent.mobileqq.ar.codeEngine;

import com.tencent.mobileqq.ar.IMiniResourceListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class MiniCodeController$MiniCodeMiniResourceListener
  implements IMiniResourceListener
{
  private int jdField_a_of_type_Int;
  
  private MiniCodeController$MiniCodeMiniResourceListener(MiniCodeController paramMiniCodeController) {}
  
  public void a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadSuccess type=%d", new Object[] { Integer.valueOf(paramInt) }));
      }
      this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController.a();
      return;
      MiniCodeController.c(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController, true);
      continue;
      MiniCodeController.d(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController, true);
      continue;
      MiniCodeController.e(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController, true);
      this.jdField_a_of_type_Int = 100;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    while (paramInt1 == 0)
    {
      Iterator localIterator = MiniCodeController.a(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController).iterator();
      while (localIterator.hasNext())
      {
        MiniCodeController.OnMiniInitListener localOnMiniInitListener = (MiniCodeController.OnMiniInitListener)((WeakReference)localIterator.next()).get();
        if (localOnMiniInitListener != null) {
          localOnMiniInitListener.a(this.jdField_a_of_type_Int);
        }
      }
      this.jdField_a_of_type_Int = paramInt2;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MiniRecog.MiniCodeController", 2, String.format("onMiniDownloadError type=%d error=%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    if (paramInt1 == 0)
    {
      Iterator localIterator = MiniCodeController.a(this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController).iterator();
      while (localIterator.hasNext())
      {
        MiniCodeController.OnMiniInitListener localOnMiniInitListener = (MiniCodeController.OnMiniInitListener)((WeakReference)localIterator.next()).get();
        if (localOnMiniInitListener != null) {
          localOnMiniInitListener.b(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniCodeController.MiniCodeMiniResourceListener
 * JD-Core Version:    0.7.0.1
 */