import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class anek
  implements amyd
{
  private int jdField_a_of_type_Int;
  
  anek(aneh paramaneh) {}
  
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
      this.jdField_a_of_type_Aneh.a();
      return;
      aneh.c(this.jdField_a_of_type_Aneh, true);
      continue;
      aneh.d(this.jdField_a_of_type_Aneh, true);
      continue;
      aneh.e(this.jdField_a_of_type_Aneh, true);
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
      Iterator localIterator = aneh.a(this.jdField_a_of_type_Aneh).iterator();
      while (localIterator.hasNext())
      {
        anel localanel = (anel)((WeakReference)localIterator.next()).get();
        if (localanel != null) {
          localanel.b(this.jdField_a_of_type_Int);
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
      Iterator localIterator = aneh.a(this.jdField_a_of_type_Aneh).iterator();
      while (localIterator.hasNext())
      {
        anel localanel = (anel)((WeakReference)localIterator.next()).get();
        if (localanel != null) {
          localanel.c(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anek
 * JD-Core Version:    0.7.0.1
 */