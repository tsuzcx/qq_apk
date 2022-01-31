import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class azce
{
  public static asbx a(azch paramazch)
  {
    if (paramazch != null)
    {
      asbx localasbx = new asbx();
      localasbx.jdField_c_of_type_JavaLangString = paramazch.b;
      String str = paramazch.jdField_a_of_type_JavaLangString;
      localasbx.jdField_a_of_type_JavaLangString = str;
      localasbx.d = str;
      localasbx.jdField_a_of_type_Long = paramazch.jdField_a_of_type_Int;
      localasbx.jdField_c_of_type_Boolean = true;
      return localasbx;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return c(((azcd)paramQQAppInterface.getManager(346)).a(paramString1, paramString2));
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
  
  public static ArrayList<benk> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((azcd)paramQQAppInterface.getManager(346)).a(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    Collections.sort(paramString);
    paramQQAppInterface = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      azch localazch = (azch)paramString.next();
      benk localbenk = new benk();
      localbenk.jdField_a_of_type_JavaLangString = localazch.b;
      paramQQAppInterface.add(localbenk);
    }
    return paramQQAppInterface;
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
    Object localObject = ((azcd)paramQQAppInterface.getManager(346)).a(paramString, paramQQAppInterface.getCurrentAccountUin());
    if ((localObject == null) || (((List)localObject).isEmpty()))
    {
      paramNavBarAIO.setTitleIconLeft(0, 0);
      paramImageView1.setOnTouchListener(null);
      paramImageView2.setOnTouchListener(null);
      return;
    }
    Collections.sort((List)localObject, new azcf());
    asbx localasbx = a((azch)((List)localObject).get(0));
    if (((List)localObject).size() > 1)
    {
      localObject = a((azch)((List)localObject).get(1));
      label139:
      paramQQAppInterface = new azcg(paramBoolean, paramQQAppInterface, paramString, paramActivity);
      if (localasbx == null) {
        break label245;
      }
      paramImageView1.setTag(localasbx);
      paramImageView1.setOnTouchListener(paramQQAppInterface);
      label170:
      if (localObject == null) {
        break label254;
      }
      paramImageView2.setTag(localObject);
      paramImageView2.setOnTouchListener(paramQQAppInterface);
    }
    for (;;)
    {
      paramNavBarAIO.setTitleIconLeftForMutualMark(localasbx, (asbx)localObject);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("TroopHonor.utils", 2, "updateAIOTitleTroopHonorInteractiveIcon one:" + localasbx + " two:" + localObject);
      return;
      localObject = null;
      break label139;
      label245:
      paramImageView1.setOnTouchListener(null);
      break label170;
      label254:
      paramImageView2.setOnTouchListener(null);
    }
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    if (paramLong1 != 1L) {}
    while ((paramLong2 != 1003L) && (paramLong2 != 1004L) && (paramLong2 != 1005L) && (paramLong2 != 1006L)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (mnf.a(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((azks)paramQQAppInterface.getManager(203)).b(paramMessageRecord.senderuin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    if (paramQQAppInterface == null) {
      return false;
    }
    return (!paramQQAppInterface.isQidianPrivateTroop()) && (!paramQQAppInterface.isHomeworkTroop());
  }
  
  public static String b(List<azch> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((azch)paramList.get(i)).jdField_a_of_type_Int);
      if (i != paramList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String c(List<azch> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append(((azch)paramList.next()).jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azce
 * JD-Core Version:    0.7.0.1
 */