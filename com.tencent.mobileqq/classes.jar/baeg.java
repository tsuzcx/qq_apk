import android.util.SparseArray;
import com.tencent.mobileqq.profilecard.bussiness.colorscreen.ProfileColorScreenComponent;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class baeg
{
  private static SparseArray<Class<? extends badc>> a = new SparseArray();
  
  static
  {
    a.put(102, badv.class);
    a.put(103, badt.class);
    a.put(104, bads.class);
    a.put(105, badu.class);
    a.put(106, badw.class);
    a.put(1002, badm.class);
    a.put(1004, ProfileColorScreenComponent.class);
    a.put(1005, bahq.class);
    a.put(1006, bagr.class);
    a.put(1007, bafv.class);
    a.put(1008, bagl.class);
    a.put(1009, bahi.class);
    a.put(1010, bagy.class);
    a.put(1011, bahb.class);
    a.put(1012, bahm.class);
    a.put(1013, bahr.class);
    a.put(1014, bagw.class);
    a.put(1015, bafx.class);
    a.put(1016, bahu.class);
    a.put(1017, bagx.class);
    a.put(1018, bahk.class);
    a.put(1019, bagj.class);
    a.put(1020, bagb.class);
    a.put(1021, bafq.class);
    a.put(1022, baft.class);
    a.put(1023, bafm.class);
    a.put(1024, bafl.class);
    a.put(1025, bagt.class);
  }
  
  public static baeh a(int paramInt, baei parambaei, azxr paramazxr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create componentType=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    baeh localbaeh = baix.a(paramInt, parambaei, paramazxr);
    if (QLog.isColorLevel()) {
      QLog.d("ProfileComponentFactory", 2, String.format("create from vas component factory. component=%s", new Object[] { localbaeh }));
    }
    if (localbaeh == null)
    {
      Class localClass = (Class)a.get(paramInt);
      if (localClass != null) {}
      for (;;)
      {
        try
        {
          parambaei = (baeh)localClass.getConstructor(new Class[] { baei.class, azxr.class }).newInstance(new Object[] { parambaei, paramazxr });
          if (QLog.isColorLevel()) {
            QLog.d("ProfileComponentFactory", 2, String.format("create from base component factory. component=%s", new Object[] { parambaei }));
          }
          return parambaei;
        }
        catch (Exception parambaei)
        {
          QLog.e("ProfileComponentFactory", 1, "create component fail.", parambaei);
        }
        parambaei = localbaeh;
      }
    }
    return localbaeh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baeg
 * JD-Core Version:    0.7.0.1
 */