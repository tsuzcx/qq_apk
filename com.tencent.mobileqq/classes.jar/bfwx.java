import android.app.Activity;
import android.text.TextUtils;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bfwx
{
  private static View.OnTouchListener a(QQAppInterface paramQQAppInterface, boolean paramBoolean, Activity paramActivity, String paramString)
  {
    return new bfxa(paramBoolean, paramQQAppInterface, paramActivity, paramString);
  }
  
  public static axms a(bfxc parambfxc)
  {
    if (parambfxc != null)
    {
      axms localaxms = new axms();
      localaxms.jdField_c_of_type_JavaLangString = parambfxc.b;
      String str = parambfxc.jdField_a_of_type_JavaLangString;
      localaxms.jdField_a_of_type_JavaLangString = str;
      localaxms.d = str;
      localaxms.jdField_a_of_type_Long = parambfxc.jdField_a_of_type_Int;
      localaxms.jdField_c_of_type_Boolean = true;
      return localaxms;
    }
    return null;
  }
  
  public static axms a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    axms localaxms = new axms();
    localaxms.jdField_c_of_type_JavaLangString = paramString;
    localaxms.jdField_a_of_type_JavaLangString = anvx.a(2131699047);
    localaxms.d = anvx.a(2131699047);
    localaxms.jdField_c_of_type_Boolean = true;
    return localaxms;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return c(((bfwu)paramQQAppInterface.getManager(QQManagerFactory.TROOP_HONOR_MANAGER)).a(paramString1, paramString2));
  }
  
  public static String a(List<Integer> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        localStringBuilder.append(paramList.get(i));
        if (i != paramList.size() - 1) {
          localStringBuilder.append("|");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    localObject = null;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return "";
    }
    try
    {
      troop_honor.GroupUserCardHonor localGroupUserCardHonor = new troop_honor.GroupUserCardHonor();
      localGroupUserCardHonor.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = localObject;
      if (localGroupUserCardHonor.id.has()) {
        paramArrayOfByte = localGroupUserCardHonor.id.get();
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        QLog.d("TroopHonor.utils", 1, "parseRspToHonorList", paramArrayOfByte);
        paramArrayOfByte = localObject;
      }
    }
    return a(paramArrayOfByte);
  }
  
  public static List<Integer> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    ArrayList localArrayList;
    String[] arrayOfString;
    do
    {
      return paramString;
      localArrayList = new ArrayList();
      arrayOfString = paramString.split("\\|");
      paramString = localArrayList;
    } while (arrayOfString.length <= 0);
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString = localArrayList;
      if (i >= j) {
        break;
      }
      paramString = arrayOfString[i];
      try
      {
        localArrayList.add(Integer.valueOf(paramString));
        i += 1;
      }
      catch (NumberFormatException paramString)
      {
        for (;;)
        {
          QLog.d("TroopHonor.utils", 1, "convertStrToHonorList", paramString);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString, NavBarAIO paramNavBarAIO, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null) || (TextUtils.isEmpty(paramString)) || (paramNavBarAIO == null) || (paramImageView1 == null) || (paramImageView2 == null)) {
      return;
    }
    ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString, new bfwy(paramImageView1, paramImageView2, paramQQAppInterface, paramActivity, paramBoolean, paramNavBarAIO));
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 1L) {}
    while ((paramLong2 != 1003L) && (paramLong2 != 1004L) && (paramLong2 != 1005L) && (paramLong2 != 1006L) && (paramLong2 != 1021L)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (nty.a(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((bgls)paramQQAppInterface.getManager(QQManagerFactory.TROOP_ROBOT_MANAGER)).b(paramMessageRecord.senderuin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString) != null;
  }
  
  public static String b(List<bfxc> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((bfxc)paramList.get(i)).jdField_a_of_type_Int);
      if (i != paramList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<axms> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() != 2) || (paramList1 == null) || (paramList1.size() >= 2) || (paramTroopInfo == null)) {}
    label283:
    for (;;)
    {
      return;
      Object localObject = (bfwu)paramQQAppInterface.getManager(QQManagerFactory.TROOP_HONOR_MANAGER);
      if (((bfwu)localObject).b(paramTroopInfo.troopuin))
      {
        localObject = ((bfwu)localObject).a(paramTroopInfo.myHonorList);
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          if (((List)localObject).size() > 1) {
            Collections.sort((List)localObject, new bfwz());
          }
          axms localaxms = a((bfxc)((List)localObject).get(0));
          if (localaxms != null)
          {
            ImageView localImageView = (ImageView)paramList.get(paramList1.size());
            if (localImageView != null)
            {
              localImageView.setTag(localaxms);
              paramList1.add(localaxms);
              localImageView.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
            }
          }
          if (paramList1.size() < 2)
          {
            if (((List)localObject).size() > 1) {}
            for (localObject = a((bfxc)((List)localObject).get(1));; localObject = null)
            {
              if (localObject == null) {
                break label283;
              }
              paramList = (ImageView)paramList.get(paramList1.size());
              if (paramList == null) {
                break;
              }
              paramList1.add(localObject);
              paramList.setTag(localObject);
              paramList.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
              return;
            }
          }
        }
      }
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, List<ImageView> paramList, List<axms> paramList1, TroopInfo paramTroopInfo, boolean paramBoolean)
  {
    if ((paramList == null) || (paramList.size() != 2) || (paramList1 == null) || (paramList1.size() >= 2) || (paramTroopInfo == null)) {
      return false;
    }
    Object localObject = bfyd.a(paramQQAppInterface, paramTroopInfo);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    localObject = a((String)localObject);
    if (localObject == null) {
      return false;
    }
    paramList = (ImageView)paramList.get(paramList1.size());
    if (paramList != null)
    {
      paramList1.add(localObject);
      paramList.setTag(localObject);
      paramList.setOnTouchListener(a(paramQQAppInterface, paramBoolean, paramActivity, paramTroopInfo.troopuin));
      return true;
    }
    return false;
  }
  
  public static String c(List<bfxc> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append(((bfxc)paramList.next()).jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfwx
 * JD-Core Version:    0.7.0.1
 */