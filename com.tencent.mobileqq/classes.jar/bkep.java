import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public abstract class bkep
{
  public int a;
  public String a;
  protected boolean a;
  public int b;
  protected String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  
  public bkep()
  {
    this.jdField_a_of_type_Int = 256;
  }
  
  private void a(bkev parambkev, String paramString)
  {
    if (parambkev != null)
    {
      parambkev.jdField_a_of_type_Int = 2;
      parambkev.jdField_a_of_type_JavaLangString = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginPreloadStrategy", 2, "pluginType:" + this.jdField_b_of_type_Int + "  " + paramString);
    }
  }
  
  public int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (paramString == null)) {
      return 3;
    }
    Object localObject1 = (nmq)paramQQAppInterface.getManager(70);
    int m;
    if (localObject1 != null) {
      m = ((nmq)localObject1).a(paramQQAppInterface);
    }
    for (int k = ((nmq)localObject1).a();; k = 0)
    {
      Object localObject2 = (azvi)paramQQAppInterface.getManager(36);
      int i = 0;
      int j = 0;
      boolean bool1 = false;
      boolean bool2 = bool1;
      int n = j;
      int i1;
      if (localObject2 != null)
      {
        n = ((azvi)localObject2).b(0);
        localObject1 = ((azvi)localObject2).b(0);
        localObject2 = ((azvi)localObject2).a();
        if ((localObject1 == null) || (((List)localObject1).isEmpty())) {
          break label663;
        }
        bool1 = false;
        i = 0;
        i1 = 0;
        if (i1 < ((List)localObject1).size())
        {
          BusinessInfoCheckUpdate.AppInfo localAppInfo = (BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i1);
          j = i;
          if (localAppInfo.mission_level.get() != 0) {
            break label657;
          }
          j = i;
          if (localAppInfo.path.get().contains(".")) {
            break label657;
          }
          if (localAppInfo.iNewFlag.get() != 1) {}
          for (;;)
          {
            i1 += 1;
            break;
            j = 0;
            for (;;)
            {
              if ((j >= ((List)localObject2).size()) || (localAppInfo.uiAppId.get() == ((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).appid.get()))
              {
                if ((j >= ((List)localObject2).size()) || (((BusinessInfoCheckUpdate.AppSetting)((List)localObject2).get(j)).setting.get())) {
                  break label288;
                }
                break;
              }
              j += 1;
            }
            label288:
            i += 1;
            j = i;
            if (!paramString.equals(localAppInfo.path.get())) {
              break label657;
            }
            bool1 = true;
          }
        }
        j = i;
        i = n;
        n = j;
        bool2 = bool1;
      }
      for (;;)
      {
        paramString = (bbox)paramQQAppInterface.getManager(10);
        int i2 = 0;
        i1 = 0;
        if (paramString != null)
        {
          i2 = paramString.a(1);
          i1 = paramString.a(2);
        }
        j = 0;
        bool1 = false;
        paramQQAppInterface = (ReadInJoyManager)paramQQAppInterface.getManager(96);
        label413:
        int i6;
        int i3;
        label433:
        int i4;
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.a();
          if (paramQQAppInterface != null)
          {
            j = paramQQAppInterface.a();
            if ((paramQQAppInterface == null) || (!paramQQAppInterface.a())) {
              break label617;
            }
            bool1 = true;
          }
        }
        else
        {
          i6 = i2 + k + i + j;
          if (m <= 0) {
            break label623;
          }
          i3 = 1;
          if (i1 <= 0) {
            break label629;
          }
          i4 = 1;
          label441:
          if (!bool1) {
            break label635;
          }
        }
        label617:
        label623:
        label629:
        label635:
        for (int i5 = 1;; i5 = 0)
        {
          i3 = i5 + (n + i3 + i4);
          if (QLog.isColorLevel()) {
            QLog.d("PluginPreloadStrategy", 2, "Troop redTouch: " + m + "; Troop num: " + k + "; Message num: " + i + "; Leba redTouch: " + n + "; Business has redTouch: " + bool2 + "; QZone msg count: " + i2 + "; QZone new count: " + i1 + "; ReadInJoy notify count: " + j + "; ReadInJoy need show notify: " + bool1 + "; Total redTouch: " + i3 + "; Total num: " + i6);
          }
          if (!bool2) {
            break label643;
          }
          if ((i6 != 0) || (i3 != 1)) {
            break label641;
          }
          return 4;
          j = 0;
          break;
          bool1 = false;
          break label413;
          i3 = 0;
          break label433;
          i4 = 0;
          break label441;
        }
        label641:
        return 1;
        label643:
        if ((i6 > 0) || (i3 > 0)) {
          return 2;
        }
        return 3;
        label657:
        i = j;
        break;
        label663:
        i = n;
        bool2 = bool1;
        n = j;
      }
      m = 0;
    }
  }
  
  protected abstract void a();
  
  public void a(bkev parambkev) {}
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((1 << Calendar.getInstance().get(7) - 1 & paramInt1) == 0) {}
    while ((1 << Calendar.getInstance().get(11) & paramInt2) == 0) {
      return false;
    }
    return true;
  }
  
  public boolean a(bker parambker, String paramString1, QQAppInterface paramQQAppInterface, String paramString2, int paramInt, long paramLong, int[] paramArrayOfInt, bkev parambkev)
  {
    if (parambker == null) {
      return false;
    }
    if ((parambker.jdField_h_of_type_Boolean) && (!a(paramString2)))
    {
      a(parambkev, "preload:fail:notinleba");
      return false;
    }
    if (parambker.jdField_b_of_type_Boolean)
    {
      int i = a(paramQQAppInterface, paramString1);
      if ((parambker.jdField_c_of_type_Boolean) && (i == 4))
      {
        a(parambkev, "preload:ok:reddotonly");
        return true;
      }
      if ((parambker.jdField_d_of_type_Boolean) && ((i == 1) || (i == 4)))
      {
        a(parambkev, "preload:ok:reddot");
        return true;
      }
      if ((parambker.jdField_e_of_type_Boolean) && (i == 2))
      {
        a(parambkev, "preload:fail:lebareddot");
        return false;
      }
    }
    if ((parambker.a) && (!a(parambker.jdField_b_of_type_Int, parambker.jdField_c_of_type_Int)))
    {
      a(parambkev, "preload:fail:timecontrol");
      return false;
    }
    if ((parambker.j) && (paramInt < parambker.jdField_f_of_type_Int))
    {
      a(parambkev, "preload:fail:usedtimeslimit");
      return false;
    }
    if (parambker.jdField_i_of_type_Boolean)
    {
      long l = parambker.jdField_e_of_type_Int * 60 * 60 * 1000;
      if (System.currentTimeMillis() - paramLong > l)
      {
        a(parambkev, "preload:fail:notactive");
        return false;
      }
    }
    if (parambker.jdField_f_of_type_Boolean)
    {
      if ((System.currentTimeMillis() - paramLong) / 1000L <= parambker.jdField_d_of_type_Int) {
        paramInt = 1;
      }
      while (paramInt != 0) {
        if (parambker.jdField_g_of_type_Boolean)
        {
          a(parambkev, "preload:ok:cdperiod");
          return true;
          paramInt = 0;
        }
        else
        {
          a(parambkev, "preload:fail:cdperiod");
          return false;
        }
      }
    }
    if ((parambker.k) && (parambker.jdField_g_of_type_Int > 0) && (!a(paramString1, paramQQAppInterface.getCurrentAccountUin(), parambker.jdField_g_of_type_Int, paramArrayOfInt, parambker.jdField_h_of_type_Int, parambker.jdField_i_of_type_Int)))
    {
      a(parambkev, "preload:fail:notinuserlearn");
      return false;
    }
    a(parambkev, "preload:ok:normal");
    return true;
  }
  
  public abstract boolean a(bkev parambkev);
  
  public boolean a(String paramString)
  {
    Object localObject = ajek.a().b();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aqmf localaqmf = (aqmf)((Iterator)localObject).next();
      if ((localaqmf != null) && (localaqmf.a != null) && (localaqmf.a.strPkgName != null) && (localaqmf.a.strPkgName.contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramInt1 <= 0) || (paramArrayOfInt == null)) {
      return false;
    }
    String str1 = paramString1 + "_userlearn_lasttime:" + paramString2;
    String str2 = paramString1 + "_userlearn_timearea:" + paramString2;
    String str3 = paramString1 + "_userlearn_timearea_inhour:" + paramString2 + ":";
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("ppp_profile", bfyt.a());
    long l = localSharedPreferences.getLong(str1, 0L);
    int i = localSharedPreferences.getInt(str2, 3);
    if ((System.currentTimeMillis() - l > 86400000L) || (paramInt1 != i))
    {
      paramString2 = a(paramArrayOfInt, paramInt1, paramInt2, paramInt3);
      paramString1 = paramString2;
      if (paramString2 == null) {
        break label382;
      }
      paramInt2 = 0;
      while (paramInt2 < paramInt1)
      {
        localSharedPreferences.edit().putInt(str3 + paramInt2, paramString2[paramInt2]).commit();
        paramInt2 += 1;
      }
      localSharedPreferences.edit().putInt(str2, paramInt1).commit();
      localSharedPreferences.edit().putLong(str1, System.currentTimeMillis()).commit();
    }
    for (;;)
    {
      if (paramString2 != null)
      {
        paramInt2 = Calendar.getInstance().get(11);
        paramInt3 = paramString2.length;
        paramInt1 = 0;
        while (paramInt1 < paramInt3)
        {
          if (paramInt2 == paramString2[paramInt1])
          {
            return true;
            paramString2 = new int[i];
            paramInt1 = 0;
            for (;;)
            {
              paramString1 = paramString2;
              if (paramInt1 >= i) {
                break;
              }
              paramString2[paramInt1] = localSharedPreferences.getInt(str3 + paramInt1, paramInt1 + 20);
              paramInt1 += 1;
            }
          }
          paramInt1 += 1;
        }
      }
      return false;
      label382:
      paramString2 = paramString1;
    }
  }
  
  public int[] a(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramArrayOfInt == null) || (paramInt1 <= 0) || (paramInt1 > paramArrayOfInt.length)) {}
    do
    {
      return null;
      localObject = new bkeq(this, paramInt3);
      switch (paramInt2)
      {
      default: 
        return null;
      case 1: 
        paramInt2 = ((bkeq)localObject).a(paramArrayOfInt, paramInt1);
      }
    } while (paramInt2 == -1);
    paramInt3 = paramInt2 - paramInt1 / 2;
    paramInt2 = paramInt3;
    if (paramInt3 < 0) {
      paramInt2 = paramInt3 + paramArrayOfInt.length;
    }
    Object localObject = new int[paramInt1];
    paramInt3 = 0;
    if (paramInt3 < paramInt1)
    {
      localObject[paramInt3] = paramInt2;
      int i = paramInt2 + 1;
      if (i >= paramArrayOfInt.length) {}
      for (paramInt2 = -paramArrayOfInt.length;; paramInt2 = 0)
      {
        paramInt3 += 1;
        paramInt2 = i + paramInt2;
        break;
      }
    }
    return localObject;
    return ((bkeq)localObject).a(paramArrayOfInt, paramInt1);
  }
  
  public boolean b(bkev parambkev)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkep
 * JD-Core Version:    0.7.0.1
 */