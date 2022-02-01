import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class azxr
{
  private static SparseArray<Class<? extends azwn>> a = new SparseArray();
  
  static
  {
    a.put(102, azxg.class);
    a.put(103, azxe.class);
    a.put(104, azxd.class);
    a.put(105, azxf.class);
    a.put(106, azxh.class);
    a.put(1002, azwx.class);
    a.put(1004, ProfileColorScreenComponent.class);
    a.put(1005, bace.class);
    a.put(1006, babd.class);
    a.put(1007, azzg.class);
    a.put(1008, baax.class);
    a.put(1009, babw.class);
    a.put(1010, babk.class);
    a.put(1011, babn.class);
    a.put(1012, baca.class);
    a.put(1013, bacf.class);
    a.put(1014, babi.class);
    a.put(1015, baai.class);
    a.put(1016, bacw.class);
    a.put(1017, babj.class);
    a.put(1018, baby.class);
    a.put(1019, baav.class);
    a.put(1020, baan.class);
    a.put(1021, azzb.class);
    a.put(1022, azze.class);
    a.put(1023, azyx.class);
    a.put(1024, azyw.class);
    a.put(1025, babf.class);
    a.put(1026, azzi.class);
    a.put(1027, bacm.class);
    a.put(1028, bacu.class);
  }
  
  public static azxs a(int paramInt, azxt paramazxt, azrb paramazrb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    azxs localazxs = badz.a(paramInt, paramazxt, paramazrb);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create from vas component factory. component=%s", new Object[] { localazxs }));
    }
    if (localazxs == null)
    {
      Class localClass = (Class)a.get(paramInt);
      if (localClass != null) {}
      for (;;)
      {
        try
        {
          paramazxt = (azxs)localClass.getConstructor(new Class[] { azxt.class, azrb.class }).newInstance(new Object[] { paramazxt, paramazrb });
          if (QLog.isColorLevel()) {
            QLog.d("ProfileComponentFactory", 2, String.format("create from base component factory. component=%s", new Object[] { paramazxt }));
          }
          return paramazxt;
        }
        catch (Exception paramazxt)
        {
          QLog.e("ProfileComponentFactory", 1, "create component fail.", paramazxt);
        }
        paramazxt = localazxs;
      }
    }
    return localazxs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azxr
 * JD-Core Version:    0.7.0.1
 */