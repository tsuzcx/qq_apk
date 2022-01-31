import android.support.v4.util.SparseArrayCompat;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;

public class apue
{
  private SparseArrayCompat<SparseArrayCompat<aptd>> a = new SparseArrayCompat(10);
  private SparseArrayCompat<aptd> b = new SparseArrayCompat();
  
  public apue(EmoticonPanelController paramEmoticonPanelController)
  {
    a(1, new apuz(paramEmoticonPanelController));
    a(2, new apvd(paramEmoticonPanelController));
    a(3, new apuo(paramEmoticonPanelController));
    a(4, new apvp(paramEmoticonPanelController));
    a(5, new apvi(paramEmoticonPanelController));
    a(6, new apvo(paramEmoticonPanelController));
  }
  
  private void a(int paramInt, aptd paramaptd)
  {
    this.b.put(paramInt, paramaptd);
    int[] arrayOfInt = paramaptd.a();
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
      localSparseArrayCompat1.put(paramInt, paramaptd);
      i += 1;
    }
  }
  
  private void a(aptd paramaptd, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      paramaptd.a();
      return;
    case 2: 
      paramaptd.b();
      return;
    case 9: 
      paramaptd.g();
      return;
    case 10: 
      paramaptd.h();
      return;
    case 8: 
      paramaptd.f();
      return;
    case 3: 
      paramaptd.a(paramInt2);
      return;
    case 5: 
      paramaptd.c();
      return;
    case 4: 
      paramaptd.a(paramBoolean);
      return;
    case 7: 
      paramaptd.e();
      return;
    }
    paramaptd.d();
  }
  
  public <T extends aptd> T a(int paramInt)
  {
    return (aptd)this.b.get(paramInt);
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
        a((aptd)localSparseArrayCompat.valueAt(i), paramInt1, paramInt2, paramBoolean);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apue
 * JD-Core Version:    0.7.0.1
 */