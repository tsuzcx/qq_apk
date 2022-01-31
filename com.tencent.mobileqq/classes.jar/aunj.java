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

public class aunj
{
  static aump a(int paramInt, QQAppInterface paramQQAppInterface)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 1006: 
    case 1007: 
    case 1008: 
    case 1009: 
    case 1027: 
    case 1031: 
    case 1034: 
    case 1036: 
    case 1037: 
    case 1038: 
    case 1039: 
    case 1040: 
    case 1041: 
    case 1043: 
    case 1044: 
    case 1048: 
    case 1049: 
    case 1050: 
    case 1051: 
    case 1052: 
    case 1053: 
      return new auml(paramQQAppInterface);
    case 1045: 
      return new aumo(paramQQAppInterface);
    }
    return new aumm(paramQQAppInterface, paramInt);
  }
  
  public static aump a(aunt paramaunt, QQAppInterface paramQQAppInterface)
  {
    if (paramaunt == null)
    {
      aune.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    aump localaump = a(paramaunt.jdField_b_of_type_Int, paramQQAppInterface);
    if (localaump == null)
    {
      aune.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramaunt.jdField_b_of_type_Int);
      return null;
    }
    localaump.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localaump.jdField_a_of_type_Aunt = paramaunt;
    localaump.jdField_a_of_type_JavaLangString = paramaunt.jdField_a_of_type_JavaLangString;
    localaump.jdField_b_of_type_JavaLangString = paramaunt.jdField_b_of_type_JavaLangString;
    localaump.a(paramaunt.jdField_a_of_type_Auol);
    aune.a("PicBusiManager", "launch", "cmd:" + paramaunt.jdField_a_of_type_Int + ",busiType:" + paramaunt.jdField_b_of_type_Int + "localUUID:" + paramaunt.jdField_a_of_type_JavaLangString);
    switch (paramaunt.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localaump;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramaunt.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramaunt.jdField_a_of_type_Aejj != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramaunt.jdField_a_of_type_Aejj.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramaunt)
      {
        aune.b("PicBusiManager", "launch", "error,req == null" + paramaunt.getStackTrace());
      }
      continue;
      localaump.d(paramaunt);
      continue;
      localaump.a(paramaunt);
      continue;
      localaump.c(paramaunt);
      continue;
      localaump.a(paramaunt);
      continue;
      localaump.a(paramaunt.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static aund a(int paramInt)
  {
    switch (paramInt)
    {
    case 1030: 
    default: 
      return null;
    case 1: 
    case 2: 
    case 3: 
    case 5: 
    case 6: 
    case 7: 
    case 1006: 
    case 1007: 
    case 1008: 
    case 1009: 
    case 1027: 
    case 1031: 
    case 1034: 
    case 1036: 
    case 1037: 
    case 1038: 
    case 1039: 
    case 1040: 
    case 1041: 
    case 1043: 
    case 1044: 
    case 1048: 
    case 1049: 
    case 1050: 
    case 1051: 
    case 1052: 
    case 1053: 
      return new auml();
    case 1045: 
      return new aumo();
    }
    return new aumm(paramInt);
  }
  
  public static aunn a(int paramInt, Intent paramIntent)
  {
    aund localaund = a(paramInt);
    if (localaund == null) {
      return null;
    }
    return localaund.a(paramIntent);
  }
  
  public static aunn a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aund localaund = a(paramInt1);
    if (localaund == null) {
      return null;
    }
    return localaund.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static aunt a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static aunt a(int paramInt1, int paramInt2, int paramInt3)
  {
    aunt localaunt = new aunt();
    localaunt.jdField_a_of_type_Int = paramInt1;
    localaunt.d = paramInt2;
    localaunt.jdField_b_of_type_Int = paramInt3;
    return localaunt;
  }
  
  public static auob a(int paramInt, Intent paramIntent)
  {
    aund localaund = a(paramInt);
    if (localaund == null) {
      return null;
    }
    return localaund.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    aund localaund = a(paramInt);
    if (localaund == null) {
      return null;
    }
    return localaund.a(paramIntent);
  }
  
  public static ArrayList<aunn> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aund localaund = a(paramInt1);
    if (localaund == null) {
      return null;
    }
    return localaund.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    aune.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new ajvg());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            auos.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            auos.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            auos.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            auos.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            auos.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            auos.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            auos.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            auos.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            auos.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = auos.e;
      paramQQAppInterface[1] = auos.f;
      paramQQAppInterface[2] = auos.g;
      paramQQAppInterface[3] = auos.h;
      paramQQAppInterface[4] = auos.i;
      paramQQAppInterface[5] = auos.j;
      paramQQAppInterface[6] = auos.jdField_a_of_type_Int;
      paramQQAppInterface[7] = auos.jdField_b_of_type_Int;
      paramQQAppInterface[8] = auos.c;
      aune.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      aune.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunj
 * JD-Core Version:    0.7.0.1
 */