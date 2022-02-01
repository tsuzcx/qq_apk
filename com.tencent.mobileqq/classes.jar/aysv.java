import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class aysv
{
  private static SparseArray<Class<? extends ayrr>> a = new SparseArray();
  
  static
  {
    a.put(102, aysk.class);
    a.put(103, aysi.class);
    a.put(104, aysh.class);
    a.put(105, aysj.class);
    a.put(106, aysl.class);
    a.put(1002, aysb.class);
    a.put(1004, ProfileColorScreenComponent.class);
    a.put(1005, ayxh.class);
    a.put(1006, aywi.class);
    a.put(1007, ayuk.class);
    a.put(1008, aywc.class);
    a.put(1009, aywz.class);
    a.put(1010, aywp.class);
    a.put(1011, ayws.class);
    a.put(1012, ayxd.class);
    a.put(1013, ayxi.class);
    a.put(1014, aywn.class);
    a.put(1015, ayvm.class);
    a.put(1016, ayxl.class);
    a.put(1017, aywo.class);
    a.put(1018, ayxb.class);
    a.put(1019, aywa.class);
    a.put(1020, ayvs.class);
    a.put(1021, ayuf.class);
    a.put(1022, ayui.class);
    a.put(1023, ayub.class);
    a.put(1024, ayua.class);
    a.put(1025, aywk.class);
    a.put(1026, ayum.class);
  }
  
  public static aysw a(int paramInt, aysx paramaysx, aymg paramaymg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    aysw localaysw = ayyo.a(paramInt, paramaysx, paramaymg);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create from vas component factory. component=%s", new Object[] { localaysw }));
    }
    if (localaysw == null)
    {
      Class localClass = (Class)a.get(paramInt);
      if (localClass != null) {}
      for (;;)
      {
        try
        {
          paramaysx = (aysw)localClass.getConstructor(new Class[] { aysx.class, aymg.class }).newInstance(new Object[] { paramaysx, paramaymg });
          if (QLog.isColorLevel()) {
            QLog.d("ProfileComponentFactory", 2, String.format("create from base component factory. component=%s", new Object[] { paramaysx }));
          }
          return paramaysx;
        }
        catch (Exception paramaysx)
        {
          QLog.e("ProfileComponentFactory", 1, "create component fail.", paramaysx);
        }
        paramaysx = localaysw;
      }
    }
    return localaysw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysv
 * JD-Core Version:    0.7.0.1
 */