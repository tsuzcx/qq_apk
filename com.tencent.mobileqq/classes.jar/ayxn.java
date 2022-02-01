import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.PeakService;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.BinderWarpper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ayxn
{
  private static HashSet<Integer> a = new HashSet();
  private static HashSet<Integer> b = new HashSet();
  private static HashSet<Integer> c = new HashSet();
  
  static
  {
    a.add(Integer.valueOf(1008));
    a.add(Integer.valueOf(1007));
    a.add(Integer.valueOf(1009));
    a.add(Integer.valueOf(1006));
    a.add(Integer.valueOf(1027));
    a.add(Integer.valueOf(1031));
    a.add(Integer.valueOf(1034));
    a.add(Integer.valueOf(1038));
    a.add(Integer.valueOf(1036));
    a.add(Integer.valueOf(1037));
    a.add(Integer.valueOf(1039));
    a.add(Integer.valueOf(1040));
    a.add(Integer.valueOf(1041));
    a.add(Integer.valueOf(1043));
    a.add(Integer.valueOf(1048));
    a.add(Integer.valueOf(1));
    a.add(Integer.valueOf(2));
    a.add(Integer.valueOf(3));
    a.add(Integer.valueOf(5));
    a.add(Integer.valueOf(6));
    a.add(Integer.valueOf(7));
    a.add(Integer.valueOf(1050));
    a.add(Integer.valueOf(1051));
    a.add(Integer.valueOf(1052));
    a.add(Integer.valueOf(1053));
    b.add(Integer.valueOf(1045));
    c.add(Integer.valueOf(1042));
    c.add(Integer.valueOf(1047));
    c.add(Integer.valueOf(1054));
    c.add(Integer.valueOf(1044));
    c.add(Integer.valueOf(1049));
  }
  
  static aywt a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    aywp localaywp = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localaywp = new aywp(paramQQAppInterface);
    }
    do
    {
      return localaywp;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new ayws(paramQQAppInterface);
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new aywq(paramQQAppInterface, paramInt);
  }
  
  public static aywt a(ayxx paramayxx, QQAppInterface paramQQAppInterface)
  {
    if (paramayxx == null)
    {
      ayxi.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    aywt localaywt = a(paramayxx.jdField_b_of_type_Int, paramQQAppInterface);
    if (localaywt == null)
    {
      ayxi.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramayxx.jdField_b_of_type_Int);
      return null;
    }
    localaywt.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localaywt.jdField_a_of_type_Ayxx = paramayxx;
    localaywt.jdField_a_of_type_JavaLangString = paramayxx.jdField_a_of_type_JavaLangString;
    localaywt.jdField_b_of_type_JavaLangString = paramayxx.jdField_b_of_type_JavaLangString;
    localaywt.a(paramayxx.jdField_a_of_type_Ayyq);
    ayxi.a("PicBusiManager", "launch", "cmd:" + paramayxx.jdField_a_of_type_Int + ",busiType:" + paramayxx.jdField_b_of_type_Int + "localUUID:" + paramayxx.jdField_a_of_type_JavaLangString);
    switch (paramayxx.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localaywt;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramayxx.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramayxx.jdField_a_of_type_Ahur != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramayxx.jdField_a_of_type_Ahur.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramayxx)
      {
        ayxi.b("PicBusiManager", "launch", "error,req == null" + paramayxx.getStackTrace());
      }
      continue;
      localaywt.d(paramayxx);
      continue;
      localaywt.a(paramayxx);
      continue;
      localaywt.c(paramayxx);
      continue;
      localaywt.a(paramayxx);
      continue;
      localaywt.a(paramayxx.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static ayxh a(int paramInt)
  {
    aywp localaywp = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localaywp = new aywp();
    }
    do
    {
      return localaywp;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new ayws();
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new aywq(paramInt);
  }
  
  public static ayxr a(int paramInt, Intent paramIntent)
  {
    ayxh localayxh = a(paramInt);
    if (localayxh == null) {
      return null;
    }
    return localayxh.a(paramIntent);
  }
  
  public static ayxr a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    ayxh localayxh = a(paramInt1);
    if (localayxh == null) {
      return null;
    }
    return localayxh.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static ayxx a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static ayxx a(int paramInt1, int paramInt2, int paramInt3)
  {
    ayxx localayxx = new ayxx();
    localayxx.jdField_a_of_type_Int = paramInt1;
    localayxx.d = paramInt2;
    localayxx.jdField_b_of_type_Int = paramInt3;
    return localayxx;
  }
  
  public static ayyg a(int paramInt, Intent paramIntent)
  {
    ayxh localayxh = a(paramInt);
    if (localayxh == null) {
      return null;
    }
    return localayxh.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    ayxh localayxh = a(paramInt);
    if (localayxh == null) {
      return null;
    }
    return localayxh.a(paramIntent);
  }
  
  public static ArrayList<ayxr> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    ayxh localayxh = a(paramInt1);
    if (localayxh == null) {
      return null;
    }
    return localayxh.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    ayxi.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new ankp());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            ayzb.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            ayzb.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            ayzb.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            ayzb.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            ayzb.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            ayzb.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            ayzb.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            ayzb.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            ayzb.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = ayzb.e;
      paramQQAppInterface[1] = ayzb.f;
      paramQQAppInterface[2] = ayzb.g;
      paramQQAppInterface[3] = ayzb.h;
      paramQQAppInterface[4] = ayzb.i;
      paramQQAppInterface[5] = ayzb.j;
      paramQQAppInterface[6] = ayzb.jdField_a_of_type_Int;
      paramQQAppInterface[7] = ayzb.jdField_b_of_type_Int;
      paramQQAppInterface[8] = ayzb.c;
      ayxi.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      ayxi.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxn
 * JD-Core Version:    0.7.0.1
 */