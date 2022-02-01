import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class asmt
{
  private SparseArrayCompat<SparseArrayCompat<asls>> a = new SparseArrayCompat(10);
  private SparseArrayCompat<asls> b = new SparseArrayCompat();
  
  public asmt(EmoticonPanelController paramEmoticonPanelController)
  {
    a(1, new asnp(paramEmoticonPanelController));
    a(2, new asnt(paramEmoticonPanelController));
    a(3, new asnf(paramEmoticonPanelController));
    a(4, new asoj(paramEmoticonPanelController));
    a(5, new asoc(paramEmoticonPanelController));
    a(6, new asoi(paramEmoticonPanelController));
    a(7, new asnw(paramEmoticonPanelController));
    a(8, new asok(paramEmoticonPanelController));
  }
  
  private void a(int paramInt, asls paramasls)
  {
    this.b.put(paramInt, paramasls);
    int[] arrayOfInt = paramasls.a();
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
      localSparseArrayCompat1.put(paramInt, paramasls);
      i += 1;
    }
  }
  
  private void a(asls paramasls, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramasls.d();
      return;
    case 2: 
      paramasls.e();
      return;
    case 9: 
      paramasls.j();
      return;
    case 10: 
      paramasls.k();
      return;
    case 8: 
      paramasls.i();
      return;
    case 3: 
      paramasls.a(paramInt2);
      return;
    case 5: 
      paramasls.f();
      return;
    case 4: 
      paramasls.a(paramBoolean);
      return;
    case 7: 
      paramasls.h();
      return;
    }
    paramasls.g();
  }
  
  public <T extends asls> T a(int paramInt)
  {
    return (asls)this.b.get(paramInt);
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
        a((asls)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asmt
 * JD-Core Version:    0.7.0.1
 */