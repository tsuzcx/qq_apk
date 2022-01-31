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

public class atpl
{
  static ator a(int paramInt, QQAppInterface paramQQAppInterface)
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
      return new aton(paramQQAppInterface);
    case 1045: 
      return new atoq(paramQQAppInterface);
    }
    return new atoo(paramQQAppInterface, paramInt);
  }
  
  public static ator a(atpv paramatpv, QQAppInterface paramQQAppInterface)
  {
    if (paramatpv == null)
    {
      atpg.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    ator localator = a(paramatpv.jdField_b_of_type_Int, paramQQAppInterface);
    if (localator == null)
    {
      atpg.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramatpv.jdField_b_of_type_Int);
      return null;
    }
    localator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localator.jdField_a_of_type_Atpv = paramatpv;
    localator.jdField_a_of_type_JavaLangString = paramatpv.jdField_a_of_type_JavaLangString;
    localator.jdField_b_of_type_JavaLangString = paramatpv.jdField_b_of_type_JavaLangString;
    localator.a(paramatpv.jdField_a_of_type_Atqn);
    atpg.a("PicBusiManager", "launch", "cmd:" + paramatpv.jdField_a_of_type_Int + ",busiType:" + paramatpv.jdField_b_of_type_Int + "localUUID:" + paramatpv.jdField_a_of_type_JavaLangString);
    switch (paramatpv.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localator;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramatpv.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramatpv.jdField_a_of_type_Adyk != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramatpv.jdField_a_of_type_Adyk.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramatpv)
      {
        atpg.b("PicBusiManager", "launch", "error,req == null" + paramatpv.getStackTrace());
      }
      continue;
      localator.d(paramatpv);
      continue;
      localator.a(paramatpv);
      continue;
      localator.c(paramatpv);
      continue;
      localator.a(paramatpv);
      continue;
      localator.a(paramatpv.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static atpf a(int paramInt)
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
      return new aton();
    case 1045: 
      return new atoq();
    }
    return new atoo(paramInt);
  }
  
  public static atpp a(int paramInt, Intent paramIntent)
  {
    atpf localatpf = a(paramInt);
    if (localatpf == null) {
      return null;
    }
    return localatpf.a(paramIntent);
  }
  
  public static atpp a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    atpf localatpf = a(paramInt1);
    if (localatpf == null) {
      return null;
    }
    return localatpf.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static atpv a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static atpv a(int paramInt1, int paramInt2, int paramInt3)
  {
    atpv localatpv = new atpv();
    localatpv.jdField_a_of_type_Int = paramInt1;
    localatpv.d = paramInt2;
    localatpv.jdField_b_of_type_Int = paramInt3;
    return localatpv;
  }
  
  public static atqd a(int paramInt, Intent paramIntent)
  {
    atpf localatpf = a(paramInt);
    if (localatpf == null) {
      return null;
    }
    return localatpf.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    atpf localatpf = a(paramInt);
    if (localatpf == null) {
      return null;
    }
    return localatpf.a(paramIntent);
  }
  
  public static ArrayList<atpp> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    atpf localatpf = a(paramInt1);
    if (localatpf == null) {
      return null;
    }
    return localatpf.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    atpg.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new ajhd());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            atqu.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            atqu.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            atqu.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            atqu.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            atqu.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            atqu.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            atqu.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            atqu.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            atqu.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = atqu.e;
      paramQQAppInterface[1] = atqu.f;
      paramQQAppInterface[2] = atqu.g;
      paramQQAppInterface[3] = atqu.h;
      paramQQAppInterface[4] = atqu.i;
      paramQQAppInterface[5] = atqu.j;
      paramQQAppInterface[6] = atqu.jdField_a_of_type_Int;
      paramQQAppInterface[7] = atqu.jdField_b_of_type_Int;
      paramQQAppInterface[8] = atqu.c;
      atpg.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      atpg.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atpl
 * JD-Core Version:    0.7.0.1
 */