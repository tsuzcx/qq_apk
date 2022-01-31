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

public class aunl
{
  static aumr a(int paramInt, QQAppInterface paramQQAppInterface)
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
      return new aumn(paramQQAppInterface);
    case 1045: 
      return new aumq(paramQQAppInterface);
    }
    return new aumo(paramQQAppInterface, paramInt);
  }
  
  public static aumr a(aunv paramaunv, QQAppInterface paramQQAppInterface)
  {
    if (paramaunv == null)
    {
      aung.b("PicBusiManager", "launch", "error,req == null");
      return null;
    }
    aumr localaumr = a(paramaunv.jdField_b_of_type_Int, paramQQAppInterface);
    if (localaumr == null)
    {
      aung.b("PicBusiManager", "launch", "error,busiInterface == null,req.busiType:" + paramaunv.jdField_b_of_type_Int);
      return null;
    }
    localaumr.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    localaumr.jdField_a_of_type_Aunv = paramaunv;
    localaumr.jdField_a_of_type_JavaLangString = paramaunv.jdField_a_of_type_JavaLangString;
    localaumr.jdField_b_of_type_JavaLangString = paramaunv.jdField_b_of_type_JavaLangString;
    localaumr.a(paramaunv.jdField_a_of_type_Auon);
    aung.a("PicBusiManager", "launch", "cmd:" + paramaunv.jdField_a_of_type_Int + ",busiType:" + paramaunv.jdField_b_of_type_Int + "localUUID:" + paramaunv.jdField_a_of_type_JavaLangString);
    switch (paramaunv.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      return localaumr;
      paramQQAppInterface = a(paramQQAppInterface);
      Intent localIntent = new Intent(BaseApplication.getContext(), PeakService.class);
      localIntent.putExtra("ServiceAction", 1);
      localIntent.putExtra("CompressInfo", paramaunv.jdField_a_of_type_ComTencentMobileqqPicCompressInfo);
      localIntent.putExtra("CompressConfig", paramQQAppInterface);
      if (paramaunv.jdField_a_of_type_Aejh != null) {
        localIntent.putExtra("CompressCallback", new BinderWarpper(paramaunv.jdField_a_of_type_Aejh.asBinder()));
      }
      try
      {
        BaseApplication.getContext().startService(localIntent);
      }
      catch (Exception paramaunv)
      {
        aung.b("PicBusiManager", "launch", "error,req == null" + paramaunv.getStackTrace());
      }
      continue;
      localaumr.d(paramaunv);
      continue;
      localaumr.a(paramaunv);
      continue;
      localaumr.c(paramaunv);
      continue;
      localaumr.a(paramaunv);
      continue;
      localaumr.a(paramaunv.jdField_a_of_type_JavaUtilArrayList);
    }
  }
  
  static aunf a(int paramInt)
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
      return new aumn();
    case 1045: 
      return new aumq();
    }
    return new aumo(paramInt);
  }
  
  public static aunp a(int paramInt, Intent paramIntent)
  {
    aunf localaunf = a(paramInt);
    if (localaunf == null) {
      return null;
    }
    return localaunf.a(paramIntent);
  }
  
  public static aunp a(int paramInt1, MessageForPic paramMessageForPic, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aunf localaunf = a(paramInt1);
    if (localaunf == null) {
      return null;
    }
    return localaunf.a(paramMessageForPic, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static aunv a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, 0, paramInt2);
  }
  
  public static aunv a(int paramInt1, int paramInt2, int paramInt3)
  {
    aunv localaunv = new aunv();
    localaunv.jdField_a_of_type_Int = paramInt1;
    localaunv.d = paramInt2;
    localaunv.jdField_b_of_type_Int = paramInt3;
    return localaunv;
  }
  
  public static auod a(int paramInt, Intent paramIntent)
  {
    aunf localaunf = a(paramInt);
    if (localaunf == null) {
      return null;
    }
    return localaunf.a(paramIntent);
  }
  
  public static CompressInfo a(int paramInt, Intent paramIntent)
  {
    aunf localaunf = a(paramInt);
    if (localaunf == null) {
      return null;
    }
    return localaunf.a(paramIntent);
  }
  
  public static ArrayList<aunp> a(int paramInt1, MessageForMixedMsg paramMessageForMixedMsg, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    aunf localaunf = a(paramInt1);
    if (localaunf == null) {
      return null;
    }
    return localaunf.a(paramMessageForMixedMsg, paramInt2, paramString1, paramString2, paramString3);
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.picCompressArgConfig.name(), "9|960|960|960|960|960|960|80|70|70");
    aung.a("PicBusiManager", "getCompressConfigFromServer", "compressConfig = " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      try
      {
        Integer[] arrayOfInteger = new Integer[10];
        Arrays.fill(arrayOfInteger, Integer.valueOf(0));
        int i = DeviceProfileManager.a(str, arrayOfInteger, new ajve());
        paramQQAppInterface = paramQQAppInterface.c();
        if ((!TextUtils.isEmpty(paramQQAppInterface)) && (i >= arrayOfInteger.length))
        {
          if (Integer.parseInt(String.valueOf(paramQQAppInterface.charAt(paramQQAppInterface.length() - 1))) > arrayOfInteger[0].intValue()) {
            continue;
          }
          if (arrayOfInteger[1].intValue() >= 960) {
            auou.e = arrayOfInteger[1].intValue();
          }
          if (arrayOfInteger[2].intValue() >= 960) {
            auou.f = arrayOfInteger[2].intValue();
          }
          if (arrayOfInteger[3].intValue() >= 960) {
            auou.g = arrayOfInteger[3].intValue();
          }
          if (arrayOfInteger[4].intValue() >= 960) {
            auou.h = arrayOfInteger[4].intValue();
          }
          if (arrayOfInteger[5].intValue() >= 960) {
            auou.i = arrayOfInteger[5].intValue();
          }
          if (arrayOfInteger[6].intValue() >= 960) {
            auou.j = arrayOfInteger[6].intValue();
          }
          if ((arrayOfInteger[7].intValue() > 0) && (arrayOfInteger[7].intValue() <= 100)) {
            auou.jdField_a_of_type_Int = arrayOfInteger[7].intValue();
          }
          if ((arrayOfInteger[8].intValue() > 0) && (arrayOfInteger[8].intValue() <= 100)) {
            auou.jdField_b_of_type_Int = arrayOfInteger[8].intValue();
          }
          if ((arrayOfInteger[9].intValue() > 0) && (arrayOfInteger[9].intValue() <= 100)) {
            auou.c = arrayOfInteger[9].intValue();
          }
        }
      }
      catch (NumberFormatException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
        continue;
      }
      paramQQAppInterface = new int[9];
      paramQQAppInterface[0] = auou.e;
      paramQQAppInterface[1] = auou.f;
      paramQQAppInterface[2] = auou.g;
      paramQQAppInterface[3] = auou.h;
      paramQQAppInterface[4] = auou.i;
      paramQQAppInterface[5] = auou.j;
      paramQQAppInterface[6] = auou.jdField_a_of_type_Int;
      paramQQAppInterface[7] = auou.jdField_b_of_type_Int;
      paramQQAppInterface[8] = auou.c;
      aung.a("PicBusiManager", "getCompressConfigFromServer", "result = " + Arrays.toString(paramQQAppInterface));
      return paramQQAppInterface;
      aung.a("PicBusiManager", "getCompressConfigFromServer", "current uin do not match");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aunl
 * JD-Core Version:    0.7.0.1
 */