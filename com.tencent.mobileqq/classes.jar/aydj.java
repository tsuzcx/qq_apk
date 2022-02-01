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

public class aydj
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
  
  static ayco a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    ayck localayck = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localayck = new ayck(paramQQAppInterface);
    }
    do
    {
      return localayck;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new aycn(paramQQAppInterface);
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new aycl(paramQQAppInterface, paramInt);
  }
  
  public static ayco a(ayds paramayds, QQAppInterface paramQQAppInterface)
  {
    if (paramayds == null)
    {
      ayde.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    ayco localayco = a(paramayds.jdField_b_of_type_Int, paramQQAppInterface);
    if (localayco == null)
    {
      ayde.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramayds.jdField_b_of_type_Int);
      return null;
    }
    localayco.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localayco.jdField_a_of_type_Ayds = paramayds;
    localayco.jdField_a_of_type_JavaLangString = paramayds.jdField_a_of_type_JavaLangString;
    localayco.jdField_b_of_type_JavaLangString = paramayds.jdField_b_of_type_JavaLangString;
    localayco.a(paramayds.jdField_a_of_type_Ayel);
    ayde.a("PicBusiManager", "launch", "cmd:" + paramayds.jdField_a_of_type_Int + ",busiType:" + paramayds.jdField_b_of_type_Int + "localUUID:" + paramayds.jdField_a_of_type_JavaLangString);
    switch (paramayds.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localayco;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramayds.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramayds.jdField_a_of_type_Ahav != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramayds.jdField_a_of_type_Ahav.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramayds)
      {
        ayde.b("PicBusiManager", "launch", "error,req == null" + paramayds.getStackTrace());
      }
      continue;
      localayco.d(paramayds);
      continue;
      localayco.a(paramayds);
      continue;
      localayco.c(paramayds);
      continue;
      localayco.a(paramayds);
      continue;
      localayco.a(paramayds.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static aydd a(int paramInt)
  {
    ayck localayck = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localayck = new ayck();
    }
    do
    {
      return localayck;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new aycn();
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new aycl(paramInt);
  }
  
  public static aydn a(int paramInt, Intent paramIntent)
  {
    aydd localaydd = a(paramInt);
    if (localaydd == null) {
      return null;
    }
    return localaydd.a(paramIntent);
  }
  
  public static aydn a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aydd localaydd = a(paramInt1);
    if (localaydd == null) {
      return null;
    }
    return localaydd.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static ayds a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static ayds a(int paramInt1, int paramInt2, int paramInt3)
  {
    ayds localayds = new ayds();
    localayds.jdField_a_of_type_Int = paramInt1;
    localayds.d = paramInt2;
    localayds.jdField_b_of_type_Int = paramInt3;
    return localayds;
  }
  
  public static ayeb a(int paramInt, Intent paramIntent)
  {
    aydd localaydd = a(paramInt);
    if (localaydd == null) {
      return null;
    }
    return localaydd.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    aydd localaydd = a(paramInt);
    if (localaydd == null) {
      return null;
    }
    return localaydd.a(paramIntent);
  }
  
  public static ArrayList<aydn> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aydd localaydd = a(paramInt1);
    if (localaydd == null) {
      return null;
    }
    return localaydd.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    ayde.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new amqv());
        paramQQAppInterface = paramQQAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            ayew.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            ayew.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            ayew.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            ayew.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            ayew.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            ayew.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            ayew.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            ayew.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            ayew.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = ayew.e;
      paramQQAppInterface[1] = ayew.f;
      paramQQAppInterface[2] = ayew.g;
      paramQQAppInterface[3] = ayew.h;
      paramQQAppInterface[4] = ayew.i;
      paramQQAppInterface[5] = ayew.j;
      paramQQAppInterface[6] = ayew.jdField_a_of_type_Int;
      paramQQAppInterface[7] = ayew.jdField_b_of_type_Int;
      paramQQAppInterface[8] = ayew.c;
      ayde.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      ayde.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aydj
 * JD-Core Version:    0.7.0.1
 */