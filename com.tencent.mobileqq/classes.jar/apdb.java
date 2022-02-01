import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class apdb
  implements aowu
{
  private int jdField_a_of_type_Int;
  
  private apdb(apcy paramapcy) {}
  
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
      this.jdField_a_of_type_Apcy.a();
      return;
      apcy.c(this.jdField_a_of_type_Apcy, true);
      continue;
      apcy.d(this.jdField_a_of_type_Apcy, true);
      continue;
      apcy.e(this.jdField_a_of_type_Apcy, true);
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
      Iterator localIterator = apcy.a(this.jdField_a_of_type_Apcy).iterator();
      while (localIterator.hasNext())
      {
        apdc localapdc = (apdc)((WeakReference)localIterator.next()).get();
        if (localapdc != null) {
          localapdc.a(this.jdField_a_of_type_Int);
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
      Iterator localIterator = apcy.a(this.jdField_a_of_type_Apcy).iterator();
      while (localIterator.hasNext())
      {
        apdc localapdc = (apdc)((WeakReference)localIterator.next()).get();
        if (localapdc != null) {
          localapdc.b(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdb
 * JD-Core Version:    0.7.0.1
 */