import android.app.Activity;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.MessageForTroopConfess;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tencent.im.troop.honor.troop_honor.GroupUserCardHonor;

public class bcgg
{
  public static autj a(bcgk parambcgk)
  {
    if (parambcgk != null)
    {
      autj localautj = new autj();
      localautj.jdField_c_of_type_JavaLangString = parambcgk.b;
      String str = parambcgk.jdField_a_of_type_JavaLangString;
      localautj.jdField_a_of_type_JavaLangString = str;
      localautj.d = str;
      localautj.jdField_a_of_type_Long = parambcgk.jdField_a_of_type_Int;
      localautj.jdField_c_of_type_Boolean = true;
      return localautj;
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return c(((bcgc)paramQQAppInterface.getManager(346)).a(paramString1, paramString2));
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
  
  public static ArrayList<biaz> a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = ((bcgc)paramQQAppInterface.getManager(346)).a(paramString);
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    Collections.sort(paramString);
    paramQQAppInterface = new ArrayList();
    paramString = paramString.iterator();
    while (paramString.hasNext())
    {
      bcgk localbcgk = (bcgk)paramString.next();
      biaz localbiaz = new biaz();
      localbiaz.jdField_a_of_type_JavaLangString = localbcgk.b;
      paramQQAppInterface.add(localbiaz);
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
    bcgc localbcgc = (bcgc)paramQQAppInterface.getManager(346);
    if (!localbcgc.b(paramString))
    {
      paramNavBarAIO.setTitleIconLeft(0, 0);
      paramImageView1.setOnTouchListener(null);
      paramImageView2.setOnTouchListener(null);
      return;
    }
    localbcgc.b(paramString, paramQQAppInterface.getCurrentAccountUin(), new bcgh(paramNavBarAIO, paramImageView1, paramImageView2, paramBoolean, paramQQAppInterface, paramString, paramActivity));
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
    if (nav.a(paramMessageRecord)) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForTroopConfess)) {
      return false;
    }
    if ("1000000".equals(paramMessageRecord.senderuin)) {
      return false;
    }
    return !((bcpg)paramQQAppInterface.getManager(203)).b(paramMessageRecord.senderuin);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    return ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString) != null;
  }
  
  public static String b(List<bcgk> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuilder.append(((bcgk)paramList.get(i)).jdField_a_of_type_Int);
      if (i != paramList.size() - 1) {
        localStringBuilder.append("|");
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String c(List<bcgk> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localStringBuilder.append(((bcgk)paramList.next()).jdField_a_of_type_JavaLangString);
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcgg
 * JD-Core Version:    0.7.0.1
 */