import android.database.DataSetObservable;
import android.database.DataSetObserver;
import java.util.ArrayList;

class bfxg
  extends DataSetObservable
{
  bfxg(bfxe parambfxe) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    for (;;)
    {
      int i;
      synchronized (this.mObservers)
      {
        i = this.mObservers.size() - 1;
        if (i >= 0)
        {
          DataSetObserver localDataSetObserver = (DataSetObserver)this.mObservers.get(i);
          if ((localDataSetObserver instanceof bfxf)) {
            ((bfxf)localDataSetObserver).a(paramInt1, paramInt2);
          } else {
            localDataSetObserver.onChanged();
          }
        }
      }
      return;
      i -= 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfxg
 * JD-Core Version:    0.7.0.1
 */