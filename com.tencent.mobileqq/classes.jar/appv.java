import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class appv
{
  private SparseArrayCompat<SparseArrayCompat<apou>> a = new SparseArrayCompat(10);
  private SparseArrayCompat<apou> b = new SparseArrayCompat();
  
  public appv(EmoticonPanelController paramEmoticonPanelController)
  {
    a(1, new apqq(paramEmoticonPanelController));
    a(2, new apqu(paramEmoticonPanelController));
    a(3, new apqf(paramEmoticonPanelController));
    a(4, new aprg(paramEmoticonPanelController));
    a(5, new apqz(paramEmoticonPanelController));
    a(6, new aprf(paramEmoticonPanelController));
  }
  
  private void a(int paramInt, apou paramapou)
  {
    this.b.put(paramInt, paramapou);
    int[] arrayOfInt = paramapou.a();
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
      localSparseArrayCompat1.put(paramInt, paramapou);
      i += 1;
    }
  }
  
  private void a(apou paramapou, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramapou.a();
      return;
    case 2: 
      paramapou.b();
      return;
    case 9: 
      paramapou.g();
      return;
    case 10: 
      paramapou.h();
      return;
    case 8: 
      paramapou.f();
      return;
    case 3: 
      paramapou.a(paramInt2);
      return;
    case 5: 
      paramapou.c();
      return;
    case 4: 
      paramapou.a(paramBoolean);
      return;
    case 7: 
      paramapou.e();
      return;
    }
    paramapou.d();
  }
  
  public <T extends apou> T a(int paramInt)
  {
    return (apou)this.b.get(paramInt);
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
        a((apou)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     appv
 * JD-Core Version:    0.7.0.1
 */