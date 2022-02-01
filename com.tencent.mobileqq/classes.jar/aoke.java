import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class aoke
  implements aodx
{
  private int jdField_a_of_type_Int;
  
  private aoke(aokb paramaokb) {}
  
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
      this.jdField_a_of_type_Aokb.a();
      return;
      aokb.c(this.jdField_a_of_type_Aokb, true);
      continue;
      aokb.d(this.jdField_a_of_type_Aokb, true);
      continue;
      aokb.e(this.jdField_a_of_type_Aokb, true);
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
      Iterator localIterator = aokb.a(this.jdField_a_of_type_Aokb).iterator();
      while (localIterator.hasNext())
      {
        aokf localaokf = (aokf)((WeakReference)localIterator.next()).get();
        if (localaokf != null) {
          localaokf.a(this.jdField_a_of_type_Int);
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
      Iterator localIterator = aokb.a(this.jdField_a_of_type_Aokb).iterator();
      while (localIterator.hasNext())
      {
        aokf localaokf = (aokf)((WeakReference)localIterator.next()).get();
        if (localaokf != null) {
          localaokf.b(paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoke
 * JD-Core Version:    0.7.0.1
 */