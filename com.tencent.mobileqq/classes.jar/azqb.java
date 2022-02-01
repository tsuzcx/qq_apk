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

public class azqb
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
  
  static azpg a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    azpc localazpc = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localazpc = new azpc(paramQQAppInterface);
    }
    do
    {
      return localazpc;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new azpf(paramQQAppInterface);
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new azpd(paramQQAppInterface, paramInt);
  }
  
  public static azpg a(azqk paramazqk, QQAppInterface paramQQAppInterface)
  {
    if (paramazqk == null)
    {
      azpw.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    azpg localazpg = a(paramazqk.jdField_b_of_type_Int, paramQQAppInterface);
    if (localazpg == null)
    {
      azpw.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramazqk.jdField_b_of_type_Int);
      return null;
    }
    localazpg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localazpg.jdField_a_of_type_Azqk = paramazqk;
    localazpg.jdField_a_of_type_JavaLangString = paramazqk.jdField_a_of_type_JavaLangString;
    localazpg.jdField_b_of_type_JavaLangString = paramazqk.jdField_b_of_type_JavaLangString;
    localazpg.a(paramazqk.jdField_a_of_type_Azrd);
    azpw.a("PicBusiManager", "launch", "cmd:" + paramazqk.jdField_a_of_type_Int + ",busiType:" + paramazqk.jdField_b_of_type_Int + "localUUID:" + paramazqk.jdField_a_of_type_JavaLangString);
    switch (paramazqk.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localazpg;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramazqk.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramazqk.jdField_a_of_type_Aief != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramazqk.jdField_a_of_type_Aief.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramazqk)
      {
        azpw.b("PicBusiManager", "launch", "error,req == null" + paramazqk.getStackTrace());
      }
      continue;
      localazpg.d(paramazqk);
      continue;
      localazpg.a(paramazqk);
      continue;
      localazpg.c(paramazqk);
      continue;
      localazpg.a(paramazqk);
      continue;
      localazpg.a(paramazqk.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static azpv a(int paramInt)
  {
    azpc localazpc = null;
    if (a.contains(Integer.valueOf(paramInt))) {
      localazpc = new azpc();
    }
    do
    {
      return localazpc;
      if (b.contains(Integer.valueOf(paramInt))) {
        return new azpf();
      }
    } while (!c.contains(Integer.valueOf(paramInt)));
    return new azpd(paramInt);
  }
  
  public static azqf a(int paramInt, Intent paramIntent)
  {
    azpv localazpv = a(paramInt);
    if (localazpv == null) {
      return null;
    }
    return localazpv.a(paramIntent);
  }
  
  public static azqf a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    azpv localazpv = a(paramInt1);
    if (localazpv == null) {
      return null;
    }
    return localazpv.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static azqk a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static azqk a(int paramInt1, int paramInt2, int paramInt3)
  {
    azqk localazqk = new azqk();
    localazqk.jdField_a_of_type_Int = paramInt1;
    localazqk.d = paramInt2;
    localazqk.jdField_b_of_type_Int = paramInt3;
    return localazqk;
  }
  
  public static azqt a(int paramInt, Intent paramIntent)
  {
    azpv localazpv = a(paramInt);
    if (localazpv == null) {
      return null;
    }
    return localazpv.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    azpv localazpv = a(paramInt);
    if (localazpv == null) {
      return null;
    }
    return localazpv.a(paramIntent);
  }
  
  public static ArrayList<azqf> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    azpv localazpv = a(paramInt1);
    if (localazpv == null) {
      return null;
    }
    return localazpv.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    azpw.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new anwm());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            azro.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            azro.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            azro.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            azro.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            azro.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            azro.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            azro.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            azro.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            azro.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = azro.e;
      paramQQAppInterface[1] = azro.f;
      paramQQAppInterface[2] = azro.g;
      paramQQAppInterface[3] = azro.h;
      paramQQAppInterface[4] = azro.i;
      paramQQAppInterface[5] = azro.j;
      paramQQAppInterface[6] = azro.jdField_a_of_type_Int;
      paramQQAppInterface[7] = azro.jdField_b_of_type_Int;
      paramQQAppInterface[8] = azro.c;
      azpw.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      azpw.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqb
 * JD-Core Version:    0.7.0.1
 */