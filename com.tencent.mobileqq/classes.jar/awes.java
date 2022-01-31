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

public class awes
{
  static awdy a(int paramInt, QQAppInterface paramQQAppInterface)
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
      return new awdu(paramQQAppInterface);
    case 1045: 
      return new awdx(paramQQAppInterface);
    }
    return new awdv(paramQQAppInterface, paramInt);
  }
  
  public static awdy a(awfc paramawfc, QQAppInterface paramQQAppInterface)
  {
    if (paramawfc == null)
    {
      awen.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    awdy localawdy = a(paramawfc.jdField_b_of_type_Int, paramQQAppInterface);
    if (localawdy == null)
    {
      awen.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramawfc.jdField_b_of_type_Int);
      return null;
    }
    localawdy.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localawdy.jdField_a_of_type_Awfc = paramawfc;
    localawdy.jdField_a_of_type_JavaLangString = paramawfc.jdField_a_of_type_JavaLangString;
    localawdy.jdField_b_of_type_JavaLangString = paramawfc.jdField_b_of_type_JavaLangString;
    localawdy.a(paramawfc.jdField_a_of_type_Awfv);
    awen.a("PicBusiManager", "launch", "cmd:" + paramawfc.jdField_a_of_type_Int + ",busiType:" + paramawfc.jdField_b_of_type_Int + "localUUID:" + paramawfc.jdField_a_of_type_JavaLangString);
    switch (paramawfc.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localawdy;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramawfc.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramawfc.jdField_a_of_type_Agfz != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramawfc.jdField_a_of_type_Agfz.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramawfc)
      {
        awen.b("PicBusiManager", "launch", "error,req == null" + paramawfc.getStackTrace());
      }
      continue;
      localawdy.d(paramawfc);
      continue;
      localawdy.a(paramawfc);
      continue;
      localawdy.c(paramawfc);
      continue;
      localawdy.a(paramawfc);
      continue;
      localawdy.a(paramawfc.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static awem a(int paramInt)
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
      return new awdu();
    case 1045: 
      return new awdx();
    }
    return new awdv(paramInt);
  }
  
  public static awew a(int paramInt, Intent paramIntent)
  {
    awem localawem = a(paramInt);
    if (localawem == null) {
      return null;
    }
    return localawem.a(paramIntent);
  }
  
  public static awew a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    awem localawem = a(paramInt1);
    if (localawem == null) {
      return null;
    }
    return localawem.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static awfc a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static awfc a(int paramInt1, int paramInt2, int paramInt3)
  {
    awfc localawfc = new awfc();
    localawfc.jdField_a_of_type_Int = paramInt1;
    localawfc.d = paramInt2;
    localawfc.jdField_b_of_type_Int = paramInt3;
    return localawfc;
  }
  
  public static awfl a(int paramInt, Intent paramIntent)
  {
    awem localawem = a(paramInt);
    if (localawem == null) {
      return null;
    }
    return localawem.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    awem localawem = a(paramInt);
    if (localawem == null) {
      return null;
    }
    return localawem.a(paramIntent);
  }
  
  public static ArrayList<awew> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    awem localawem = a(paramInt1);
    if (localawem == null) {
      return null;
    }
    return localawem.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    awen.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new almr());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            awgc.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            awgc.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            awgc.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            awgc.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            awgc.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            awgc.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            awgc.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            awgc.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            awgc.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = awgc.e;
      paramQQAppInterface[1] = awgc.f;
      paramQQAppInterface[2] = awgc.g;
      paramQQAppInterface[3] = awgc.h;
      paramQQAppInterface[4] = awgc.i;
      paramQQAppInterface[5] = awgc.j;
      paramQQAppInterface[6] = awgc.jdField_a_of_type_Int;
      paramQQAppInterface[7] = awgc.jdField_b_of_type_Int;
      paramQQAppInterface[8] = awgc.c;
      awen.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      awen.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awes
 * JD-Core Version:    0.7.0.1
 */