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

public class awjb
{
  static awih a(int paramInt, QQAppInterface paramQQAppInterface)
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
      return new awid(paramQQAppInterface);
    case 1045: 
      return new awig(paramQQAppInterface);
    }
    return new awie(paramQQAppInterface, paramInt);
  }
  
  public static awih a(awjl paramawjl, QQAppInterface paramQQAppInterface)
  {
    if (paramawjl == null)
    {
      awiw.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    awih localawih = a(paramawjl.jdField_b_of_type_Int, paramQQAppInterface);
    if (localawih == null)
    {
      awiw.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramawjl.jdField_b_of_type_Int);
      return null;
    }
    localawih.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localawih.jdField_a_of_type_Awjl = paramawjl;
    localawih.jdField_a_of_type_JavaLangString = paramawjl.jdField_a_of_type_JavaLangString;
    localawih.jdField_b_of_type_JavaLangString = paramawjl.jdField_b_of_type_JavaLangString;
    localawih.a(paramawjl.jdField_a_of_type_Awke);
    awiw.a("PicBusiManager", "launch", "cmd:" + paramawjl.jdField_a_of_type_Int + ",busiType:" + paramawjl.jdField_b_of_type_Int + "localUUID:" + paramawjl.jdField_a_of_type_JavaLangString);
    switch (paramawjl.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localawih;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramawjl.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramawjl.jdField_a_of_type_Agko != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramawjl.jdField_a_of_type_Agko.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramawjl)
      {
        awiw.b("PicBusiManager", "launch", "error,req == null" + paramawjl.getStackTrace());
      }
      continue;
      localawih.d(paramawjl);
      continue;
      localawih.a(paramawjl);
      continue;
      localawih.c(paramawjl);
      continue;
      localawih.a(paramawjl);
      continue;
      localawih.a(paramawjl.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static awiv a(int paramInt)
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
      return new awid();
    case 1045: 
      return new awig();
    }
    return new awie(paramInt);
  }
  
  public static awjf a(int paramInt, Intent paramIntent)
  {
    awiv localawiv = a(paramInt);
    if (localawiv == null) {
      return null;
    }
    return localawiv.a(paramIntent);
  }
  
  public static awjf a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    awiv localawiv = a(paramInt1);
    if (localawiv == null) {
      return null;
    }
    return localawiv.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static awjl a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static awjl a(int paramInt1, int paramInt2, int paramInt3)
  {
    awjl localawjl = new awjl();
    localawjl.jdField_a_of_type_Int = paramInt1;
    localawjl.d = paramInt2;
    localawjl.jdField_b_of_type_Int = paramInt3;
    return localawjl;
  }
  
  public static awju a(int paramInt, Intent paramIntent)
  {
    awiv localawiv = a(paramInt);
    if (localawiv == null) {
      return null;
    }
    return localawiv.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    awiv localawiv = a(paramInt);
    if (localawiv == null) {
      return null;
    }
    return localawiv.a(paramIntent);
  }
  
  public static ArrayList<awjf> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    awiv localawiv = a(paramInt1);
    if (localawiv == null) {
      return null;
    }
    return localawiv.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    awiw.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new alrg());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            awkl.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            awkl.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            awkl.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            awkl.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            awkl.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            awkl.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            awkl.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            awkl.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            awkl.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = awkl.e;
      paramQQAppInterface[1] = awkl.f;
      paramQQAppInterface[2] = awkl.g;
      paramQQAppInterface[3] = awkl.h;
      paramQQAppInterface[4] = awkl.i;
      paramQQAppInterface[5] = awkl.j;
      paramQQAppInterface[6] = awkl.jdField_a_of_type_Int;
      paramQQAppInterface[7] = awkl.jdField_b_of_type_Int;
      paramQQAppInterface[8] = awkl.c;
      awiw.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      awiw.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awjb
 * JD-Core Version:    0.7.0.1
 */