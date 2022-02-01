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

public class azjv
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
  
  static azja a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    aziw localaziw = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localaziw = new aziw(paramQQAppInterface);
    }
    do
    {
      return localaziw;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new aziz(paramQQAppInterface);
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new azix(paramQQAppInterface, paramInt);
  }
  
  public static azja a(azke paramazke, QQAppInterface paramQQAppInterface)
  {
    if (paramazke == null)
    {
      azjq.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    azja localazja = a(paramazke.jdField_b_of_type_Int, paramQQAppInterface);
    if (localazja == null)
    {
      azjq.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramazke.jdField_b_of_type_Int);
      return null;
    }
    localazja.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localazja.jdField_a_of_type_Azke = paramazke;
    localazja.jdField_a_of_type_JavaLangString = paramazke.jdField_a_of_type_JavaLangString;
    localazja.jdField_b_of_type_JavaLangString = paramazke.jdField_b_of_type_JavaLangString;
    localazja.a(paramazke.jdField_a_of_type_Azkx);
    azjq.a("PicBusiManager", "launch", "cmd:" + paramazke.jdField_a_of_type_Int + ",busiType:" + paramazke.jdField_b_of_type_Int + "localUUID:" + paramazke.jdField_a_of_type_JavaLangString);
    switch (paramazke.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localazja;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramazke.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramazke.jdField_a_of_type_Ahtv != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramazke.jdField_a_of_type_Ahtv.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramazke)
      {
        azjq.b("PicBusiManager", "launch", "error,req == null" + paramazke.getStackTrace());
      }
      continue;
      localazja.d(paramazke);
      continue;
      localazja.a(paramazke);
      continue;
      localazja.c(paramazke);
      continue;
      localazja.a(paramazke);
      continue;
      localazja.a(paramazke.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static azjp a(int paramInt)
  {
    aziw localaziw = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localaziw = new aziw();
    }
    do
    {
      return localaziw;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new aziz();
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new azix(paramInt);
  }
  
  public static azjz a(int paramInt, Intent paramIntent)
  {
    azjp localazjp = a(paramInt);
    if (localazjp == null) {
      return null;
    }
    return localazjp.a(paramIntent);
  }
  
  public static azjz a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    azjp localazjp = a(paramInt1);
    if (localazjp == null) {
      return null;
    }
    return localazjp.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static azke a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static azke a(int paramInt1, int paramInt2, int paramInt3)
  {
    azke localazke = new azke();
    localazke.jdField_a_of_type_Int = paramInt1;
    localazke.d = paramInt2;
    localazke.jdField_b_of_type_Int = paramInt3;
    return localazke;
  }
  
  public static azkn a(int paramInt, Intent paramIntent)
  {
    azjp localazjp = a(paramInt);
    if (localazjp == null) {
      return null;
    }
    return localazjp.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    azjp localazjp = a(paramInt);
    if (localazjp == null) {
      return null;
    }
    return localazjp.a(paramIntent);
  }
  
  public static ArrayList<azjz> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    azjp localazjp = a(paramInt1);
    if (localazjp == null) {
      return null;
    }
    return localazjp.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    azjq.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new antj());
        paramQQAppInterface = paramQQAppInterface.getCurrentUin();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            azli.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            azli.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            azli.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            azli.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            azli.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            azli.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            azli.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            azli.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            azli.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = azli.e;
      paramQQAppInterface[1] = azli.f;
      paramQQAppInterface[2] = azli.g;
      paramQQAppInterface[3] = azli.h;
      paramQQAppInterface[4] = azli.i;
      paramQQAppInterface[5] = azli.j;
      paramQQAppInterface[6] = azli.jdField_a_of_type_Int;
      paramQQAppInterface[7] = azli.jdField_b_of_type_Int;
      paramQQAppInterface[8] = azli.c;
      azjq.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      azjq.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjv
 * JD-Core Version:    0.7.0.1
 */