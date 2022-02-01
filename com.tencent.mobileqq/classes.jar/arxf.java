import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class arxf
{
  private SparseArrayCompat<SparseArrayCompat<arwe>> a = new SparseArrayCompat(10);
  private SparseArrayCompat<arwe> b = new SparseArrayCompat();
  
  public arxf(EmoticonPanelController paramEmoticonPanelController)
  {
    a(1, new aryb(paramEmoticonPanelController));
    a(2, new aryf(paramEmoticonPanelController));
    a(3, new arxr(paramEmoticonPanelController));
    a(4, new aryv(paramEmoticonPanelController));
    a(5, new aryo(paramEmoticonPanelController));
    a(6, new aryu(paramEmoticonPanelController));
    a(7, new aryi(paramEmoticonPanelController));
    a(8, new aryw(paramEmoticonPanelController));
  }
  
  private void a(int paramInt, arwe paramarwe)
  {
    this.b.put(paramInt, paramarwe);
    int[] arrayOfInt = paramarwe.a();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      SparseArrayCompat localSparseArrayCompat2 = (SparseArrayCompat)this.a.get(k);
      SparseArrayCompat localSparseArrayCompat1 = localSparseArrayCompat2;
      if (localSparseArrayCompat2 == null)
      {
        localSparseArrayCompat1 = new SparseArrayCompat();
        this.a.put(k, localSparseArrayCompat1);
      }
      localSparseArrayCompat1.put(paramInt, paramarwe);
      i += 1;
    }
  }
  
  private void a(arwe paramarwe, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramarwe.d();
      return;
    case 2: 
      paramarwe.e();
      return;
    case 9: 
      paramarwe.j();
      return;
    case 10: 
      paramarwe.k();
      return;
    case 8: 
      paramarwe.i();
      return;
    case 3: 
      paramarwe.a(paramInt2);
      return;
    case 5: 
      paramarwe.f();
      return;
    case 4: 
      paramarwe.a(paramBoolean);
      return;
    case 7: 
      paramarwe.h();
      return;
    }
    paramarwe.g();
  }
  
  public <T extends arwe> T a(int paramInt)
  {
    return (arwe)this.b.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, -1, false);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    SparseArrayCompat localSparseArrayCompat = (SparseArrayCompat)this.a.get(paramInt1);
    if (localSparseArrayCompat == null) {}
    for (;;)
    {
      return;
      int j = localSparseArrayCompat.size();
      int i = 0;
      while (i < j)
      {
        a((arwe)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxf
 * JD-Core Version:    0.7.0.1
 */