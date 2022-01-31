import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class anab
  implements amto
{
  private int jdField_a_of_type_Int;
  
  anab(amzy paramamzy) {}
  
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
      this.jdField_a_of_type_Amzy.a();
      return;
      amzy.c(this.jdField_a_of_type_Amzy, true);
      continue;
      amzy.d(this.jdField_a_of_type_Amzy, true);
      continue;
      amzy.e(this.jdField_a_of_type_Amzy, true);
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
      Iterator localIterator = amzy.a(this.jdField_a_of_type_Amzy).iterator();
      while (localIterator.hasNext())
      {
        anac localanac = (anac)((WeakReference)localIterator.next()).get();
        if (localanac != null) {
          localanac.b(this.jdField_a_of_type_Int);
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
      Iterator localIterator = amzy.a(this.jdField_a_of_type_Amzy).iterator();
      while (localIterator.hasNext())
      {
        anac localanac = (anac)((WeakReference)localIterator.next()).get();
        if (localanac != null) {
          localanac.c(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anab
 * JD-Core Version:    0.7.0.1
 */