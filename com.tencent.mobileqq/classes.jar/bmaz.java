import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import dov.com.tencent.mobileqq.shortvideo.PtvTemplateManager.PtvTemplateInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class bmaz
{
  public static final SparseArray<ConcurrentHashMap<String, bmaz>> a;
  public static final AccelerateInterpolator a;
  public static final ConcurrentHashMap<String, bmaz> a;
  public byte a;
  float jdField_a_of_type_Float = 1.0F;
  long jdField_a_of_type_Long;
  public ArrayList<WeakReference<bmba>> a;
  long b = 0L;
  long c = 0L;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(3);
    jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator = new AccelerateInterpolator();
  }
  
  public bmaz()
  {
    this.jdField_a_of_type_Byte = 1;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  static bmaz a(int paramInt, String paramString)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localConcurrentHashMap == null)
    {
      localConcurrentHashMap = new ConcurrentHashMap(50);
      jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localConcurrentHashMap);
    }
    for (;;)
    {
      bmaz localbmaz2 = (bmaz)localConcurrentHashMap.get(paramString);
      bmaz localbmaz1 = localbmaz2;
      if (localbmaz2 == null)
      {
        localbmaz1 = new bmaz();
        localConcurrentHashMap.put(paramString, localbmaz1);
      }
      return localbmaz1;
    }
  }
  
  public static bmaz a(Object paramObject)
  {
    bmaz localbmaz = null;
    if ((paramObject instanceof blsn)) {
      localbmaz = a(1, ((blsn)paramObject).a());
    }
    do
    {
      return localbmaz;
      if ((paramObject instanceof PtvTemplateManager.PtvTemplateInfo)) {
        return a(3, ((PtvTemplateManager.PtvTemplateInfo)paramObject).id);
      }
      if ((paramObject instanceof blab)) {
        return a(3, ((blab)paramObject).a);
      }
      if ((paramObject instanceof MusicItemInfo)) {
        return a(2, ((MusicItemInfo)paramObject).mMusicName);
      }
      if ((paramObject instanceof blsq)) {
        return a(4, ((blsq)paramObject).a());
      }
    } while (!(paramObject instanceof blsx));
    return a(5, ((blsx)paramObject).a());
  }
  
  public float a()
  {
    float f1 = 0.01F;
    switch (this.jdField_a_of_type_Byte)
    {
    }
    for (;;)
    {
      return this.jdField_a_of_type_Float;
      if (this.jdField_a_of_type_Long == 0L) {
        return 0.0F;
      }
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if ((float)l > 4250.0F) {
        f1 = 0.85F;
      }
      float f2;
      for (;;)
      {
        this.jdField_a_of_type_Float = f1;
        break;
        f2 = (float)l * 1.0F / 5000.0F;
        if (f2 >= 0.01F) {
          f1 = f2;
        }
      }
      if (this.b == 0L)
      {
        this.b = SystemClock.elapsedRealtime();
      }
      else
      {
        l = SystemClock.elapsedRealtime() - this.b;
        if (l > 1L)
        {
          this.jdField_a_of_type_Float = 1.0F;
        }
        else
        {
          f1 = this.jdField_a_of_type_Float;
          f2 = this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Float = (jdField_a_of_type_AndroidViewAnimationAccelerateInterpolator.getInterpolation((float)l * 1.0F / 1.0F) * (1.0F - f2) + f1);
          continue;
          if (this.c == 0L)
          {
            this.c = SystemClock.elapsedRealtime();
          }
          else
          {
            l = SystemClock.elapsedRealtime() - this.c;
            if (l > 1L) {
              this.jdField_a_of_type_Float = 0.0F;
            }
            this.jdField_a_of_type_Float *= (1.0F - (float)l * 1.0F / 1.0F);
          }
        }
      }
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Float == 0.0F) || (this.jdField_a_of_type_Float == 1.0F))
    {
      this.jdField_a_of_type_Byte = 2;
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.b = 0L;
      this.c = 0L;
      this.jdField_a_of_type_Float = 0.01F;
      a(0.01F);
    }
  }
  
  public void a(float paramFloat)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    if (i >= 0)
    {
      bmba localbmba = (bmba)((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get();
      if (localbmba == null) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      for (;;)
      {
        i -= 1;
        break;
        localbmba.a();
      }
    }
  }
  
  public void a(bmba parambmba)
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
    while (i >= 0)
    {
      bmba localbmba = (bmba)((WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(i)).get();
      if ((localbmba == null) || (localbmba == parambmba)) {
        this.jdField_a_of_type_JavaUtilArrayList.remove(i);
      }
      i -= 1;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Byte = 1;
  }
  
  public void b(bmba parambmba)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(parambmba));
  }
  
  public void c()
  {
    this.jdField_a_of_type_Byte = 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmaz
 * JD-Core Version:    0.7.0.1
 */