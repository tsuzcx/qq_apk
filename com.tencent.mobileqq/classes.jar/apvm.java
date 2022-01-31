import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileTansferItemEntity;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.TroopFileDetailBrowserActivity;
import com.tencent.mobileqq.filemanager.util.QFileUtils.2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class apvm
{
  public static int a()
  {
    int i = 1;
    switch (NetConnInfoCenter.getActiveNetIpFamily(true))
    {
    default: 
      i = 0;
    case 1: 
      return i;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    default: 
      return -1;
    case 1: 
    case 2: 
      return 0;
    case 5: 
    case 6: 
      return 3000;
    }
    return 1;
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 * 1.0F / paramInt2 >= 1.777778F) {
      return 2;
    }
    return 1;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramInt == 0) {}
    do
    {
      return 1;
      if (paramInt == 3000) {
        return 101;
      }
    } while (paramInt != 1);
    paramQQAppInterface = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString);
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.isNewTroop) {
        return 113;
      }
      return 4;
    }
    return 4;
  }
  
  public static int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      do
      {
        return -1;
        paramString = paramString.split("@");
      } while ((paramString == null) || (paramString.length <= 0));
      paramString = paramString[0];
    } while (TextUtils.isEmpty(paramString));
    return Integer.parseInt(paramString);
  }
  
  public static Rect a(Context paramContext, Rect paramRect, int paramInt1, int paramInt2)
  {
    if (paramRect == null) {
      return paramRect;
    }
    paramRect = new Rect(paramRect);
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    int i = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    if (paramInt1 <= i) {
      if (paramInt2 > j) {
        break label328;
      }
    }
    for (;;)
    {
      int k = paramInt1;
      if (paramInt1 == 0) {
        k = i;
      }
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = j;
      }
      paramInt2 = paramRect.right - paramRect.left;
      int m = paramRect.bottom - paramRect.top;
      float f2 = paramInt2 * 1.0F / k;
      float f1 = m * 1.0F / paramInt1 * j - m;
      f2 = i * f2 - paramInt2;
      if ((f1 > 0.0F) && (paramInt2 > m))
      {
        paramRect.top = ((int)(paramRect.top - Math.ceil(f1 / 2.0F)));
        paramRect.bottom = ((int)(paramRect.bottom + Math.ceil(f1 / 2.0F)));
      }
      if ((f2 > 0.0F) && (paramInt2 < m))
      {
        paramRect.left = ((int)(paramRect.left - Math.ceil(f2 / 2.0F)));
        double d = paramRect.right;
        paramRect.right = ((int)(Math.ceil(f2 / 2.0F) + d));
      }
      if ((bkvi.c) && (bkvi.a))
      {
        paramInt1 = bkvi.b((Activity)paramContext);
        paramRect.top -= paramInt1;
        paramRect.bottom -= paramInt1;
      }
      paramRect.top += 10;
      paramRect.bottom -= 10;
      paramRect.left += 10;
      paramRect.right -= 10;
      return paramRect;
      paramInt1 = i;
      break;
      label328:
      paramInt2 = j;
    }
  }
  
  public static Rect a(View paramView, String paramString)
  {
    if ((paramView != null) && (!TextUtils.isEmpty(paramString)))
    {
      int i = apug.a(paramString);
      if ((i == 2) || (i == 0)) {
        return xpu.a(paramView);
      }
    }
    return null;
  }
  
  public static SpannableString a(String paramString1, String paramString2, apuv paramapuv)
  {
    int k = paramString1.indexOf(paramString2);
    if (k < 0) {
      return new SpannableString(paramString1);
    }
    int m = paramString2.length();
    int j = Color.parseColor("#4799DF");
    if (paramapuv != null) {}
    for (int i = Color.parseColor("#A3CCEF");; i = j)
    {
      paramString2 = new ColorStateList(new int[][] { { 16842919 }, new int[0] }, new int[] { i, j });
      paramString1 = new SpannableString(paramString1);
      paramString1.setSpan(new annk(new apvn(paramapuv), paramString2), k, k + m, 33);
      return paramString1;
    }
  }
  
  public static azqv a(QQAppInterface paramQQAppInterface, long paramLong, azpi paramazpi)
  {
    azqv localazqv2 = TroopFileTransferManager.a(paramQQAppInterface, paramLong).a(paramazpi.jdField_b_of_type_JavaLangString);
    azqv localazqv1 = localazqv2;
    if (localazqv2 == null)
    {
      localazqv1 = bakx.a(paramQQAppInterface, paramLong, paramazpi.jdField_a_of_type_JavaUtilUUID.toString(), paramazpi.jdField_b_of_type_JavaLangString, paramazpi.jdField_c_of_type_JavaLangString, paramazpi.jdField_a_of_type_Long, paramazpi.jdField_a_of_type_Int);
      localazqv1.jdField_c_of_type_JavaLangString = paramazpi.j;
      localazqv1.d = paramazpi.k;
      localazqv1.jdField_b_of_type_JavaLangString = paramazpi.i;
    }
    return localazqv1;
  }
  
  public static bbjs a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    bbjs localbbjs = new bbjs();
    localbbjs.jdField_a_of_type_JavaLangString = paramString;
    localbbjs.jdField_b_of_type_Int = paramInt;
    localbbjs.jdField_b_of_type_Boolean = true;
    localbbjs.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    localbbjs.jdField_b_of_type_JavaLangString = "";
    return localbbjs;
  }
  
  public static String a(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public static String a(long paramLong)
  {
    if (paramLong <= 0L) {
      return "00:00:00";
    }
    paramLong /= 1000L;
    String str1;
    String str2;
    if (paramLong / 3600L > 9L)
    {
      str1 = paramLong / 3600L + "";
      if (paramLong % 3600L / 60L <= 9L) {
        break label205;
      }
      str2 = paramLong % 3600L / 60L + "";
      label96:
      if (paramLong % 3600L % 60L <= 9L) {
        break label237;
      }
    }
    label205:
    label237:
    for (String str3 = paramLong % 3600L % 60L + "";; str3 = "0" + paramLong % 3600L % 60L)
    {
      return str1 + ":" + str2 + ":" + str3;
      str1 = "0" + paramLong / 3600L;
      break;
      str2 = "0" + paramLong % 3600L / 60L;
      break label96;
    }
  }
  
  public static String a(long paramLong, int paramInt, String paramString)
  {
    if (paramInt == 128) {
      return "[Thumb]" + paramLong + "-" + paramString;
    }
    if (paramInt == 383) {
      return "[Thumb]320" + paramLong + "-" + paramString;
    }
    return "[Thumb]" + paramInt + paramLong + "-" + paramString;
  }
  
  public static String a(Context paramContext, int paramInt1, int paramInt2, TextView paramTextView1, TextView paramTextView2, String paramString1, String paramString2)
  {
    paramTextView1 = paramTextView1.getPaint();
    paramTextView2 = paramTextView2.getPaint();
    int i = actj.a(7.0F, paramContext.getResources());
    int j = (int)paramTextView2.measureText(paramString2);
    int k = actj.a(15.0F, paramContext.getResources());
    switch (paramInt1)
    {
    case 1: 
    default: 
      return paramString1;
    }
    return (String)TextUtils.ellipsize(paramString1, paramTextView1, paramInt2 - i * 2 - j - k, TextUtils.TruncateAt.END);
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692476));
      }
      localStringBuilder.append("来自");
      localStringBuilder.append(paramString2);
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692476));
      }
      localStringBuilder.append(paramString3);
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(paramContext.getString(2131692476));
      }
      localStringBuilder.append(paramString4);
    }
    return localStringBuilder.toString();
  }
  
  private static String a(AppInterface paramAppInterface, MessageForFile paramMessageForFile)
  {
    String str1 = "select * from " + FileManagerEntity.tableName() + " where  uniseq = " + paramMessageForFile.uniseq;
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().a(FileManagerEntity.class, str1, null);
    if (paramAppInterface == null) {
      paramAppInterface = null;
    }
    String str2;
    do
    {
      return paramAppInterface;
      paramAppInterface = (FileManagerEntity)paramAppInterface.get(0);
      str2 = paramAppInterface.getFilePath();
      if (apug.b(str2))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str2;
      }
      str1 = aptm.a().c();
      if (paramAppInterface.Uuid == null) {
        break;
      }
      String str3 = MD5.toMD5(paramAppInterface.Uuid);
      str3 = str1 + str3;
      if (apug.b(str3))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
        }
        return str3;
      }
      str1 = str1 + "dsc-" + String.valueOf(paramAppInterface.Uuid.replace("/", ""));
      if (!apug.b(str1)) {
        break;
      }
      paramAppInterface = str1;
    } while (!QLog.isDebugVersion());
    QLog.i("FileClean", 1, "find tmp file[" + str2 + "] for msg:" + paramMessageForFile.uniseq);
    return str1;
    return null;
  }
  
  private static String a(AppInterface paramAppInterface, MessageForTroopFile paramMessageForTroopFile)
  {
    String str1 = ajsd.bo;
    Object localObject = new TroopFileTansferItemEntity();
    ((TroopFileTansferItemEntity)localObject).troopuin = Long.parseLong(paramMessageForTroopFile.frienduin);
    String str2 = "select * from " + ((TroopFileTansferItemEntity)localObject).getTableName() + " where troopuin = ? and _sId = ?";
    paramAppInterface = paramAppInterface.getEntityManagerFactory().createEntityManager().a(TroopFileTansferItemEntity.class, str2, new String[] { "" + ((TroopFileTansferItemEntity)localObject).troopuin, SecurityUtile.a(paramMessageForTroopFile.uuid) });
    if (paramAppInterface == null)
    {
      if (QLog.isDebugVersion()) {
        QLog.i("FileClean", 1, "find troop file result is null, for msg:" + paramMessageForTroopFile.uniseq);
      }
      return null;
    }
    localObject = paramAppInterface.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramAppInterface = (TroopFileTansferItemEntity)((Iterator)localObject).next();
      if (paramAppInterface.Id.equals(UUID.fromString(paramMessageForTroopFile.uuid)))
      {
        localObject = paramAppInterface.LocalFile;
        paramAppInterface = paramAppInterface.FilePath;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (apug.b((String)localObject)))
      {
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find troop file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return localObject;
      }
      if (TextUtils.isEmpty(paramAppInterface))
      {
        if (!QLog.isDebugVersion()) {
          break;
        }
        QLog.i("FileClean", 1, "find troop file but filePath is null, for msg:" + paramMessageForTroopFile.uniseq);
        return null;
      }
      localObject = MD5.toMD5(paramAppInterface);
      localObject = str1 + (String)localObject;
      str1 = str1 + bbea.a(paramAppInterface.getBytes()) + ".tmp";
      if (apvd.a(str1) > 0L) {
        localObject = str1;
      }
      for (;;)
      {
        if (apug.b((String)localObject))
        {
          if (QLog.isDebugVersion()) {
            QLog.i("FileClean", 1, "find tmp file[" + (String)localObject + "] for msg:" + paramMessageForTroopFile.uniseq);
          }
          return localObject;
        }
        paramAppInterface = aptm.a().c() + bflg.a(paramAppInterface);
        if (!apug.b(paramAppInterface)) {
          break;
        }
        if (QLog.isDebugVersion()) {
          QLog.i("FileClean", 1, "find tmp2 file[" + paramAppInterface + "] for msg:" + paramMessageForTroopFile.uniseq);
        }
        return paramAppInterface;
      }
      paramAppInterface = null;
      localObject = null;
    }
  }
  
  public static String a(AppInterface paramAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (QLog.isColorLevel()) {
        QLog.i("FileClean", 1, "queryFilePathForMessage, msg is null");
      }
    }
    do
    {
      return null;
      if (MessageForFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForFile");
        }
        return a(paramAppInterface, (MessageForFile)paramMessageRecord);
      }
      if (MessageForTroopFile.class.isInstance(paramMessageRecord))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileClean", 1, "queryFilePathForMessage, msg is MessageForTroopFile");
        }
        return a(paramAppInterface, (MessageForTroopFile)paramMessageRecord);
      }
    } while (!QLog.isColorLevel());
    QLog.i("FileClean", 1, "queryFilePathForMessage, msg is :" + paramMessageRecord.msgtype);
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2)
  {
    Object localObject = (baky)paramQQAppInterface.getManager(48);
    if (localObject != null)
    {
      if (((baky)localObject).a(String.valueOf(paramLong1), String.valueOf(paramLong2))) {
        return ajya.a(2131709723);
      }
      localObject = ((baky)localObject).a(String.valueOf(paramLong1));
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if ((localObject != null) && (((balf)localObject).jdField_a_of_type_Long != 0L))
      {
        if (paramQQAppInterface != null)
        {
          paramQQAppInterface = paramQQAppInterface.b(String.valueOf(paramLong1));
          if ((paramQQAppInterface != null) && ((paramQQAppInterface.isTroopOwner(String.valueOf(paramLong2))) || (paramQQAppInterface.isTroopAdmin(String.valueOf(paramLong2))))) {
            return "";
          }
        }
        return ajya.a(2131709735);
      }
    }
    return "";
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    return a(paramQQAppInterface, paramMessageRecord, true);
  }
  
  public static String a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    if (paramMessageRecord == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mrUniseq[").append(paramMessageRecord.uniseq).append("] ");
    localStringBuilder.append("mrSeq[").append(paramMessageRecord.msgseq).append("] ");
    localStringBuilder.append("mrUid[").append(paramMessageRecord.msgUid).append("] ");
    if (paramBoolean)
    {
      if (!(paramMessageRecord instanceof MessageForFile)) {
        break label160;
      }
      paramQQAppInterface = paramQQAppInterface.a().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (paramQQAppInterface != null)
      {
        localStringBuilder.append("offFileName[").append(paramQQAppInterface.fileName).append("] ");
        localStringBuilder.append("offFileUuid[").append(paramQQAppInterface.Uuid).append("] ");
      }
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label160:
      if ((paramMessageRecord instanceof MessageForTroopFile))
      {
        paramQQAppInterface = bakx.a(paramQQAppInterface, (MessageForTroopFile)paramMessageRecord);
        if (paramQQAppInterface != null)
        {
          localStringBuilder.append("troopFileName[").append(paramQQAppInterface.g).append("] ");
          localStringBuilder.append("troopFileId").append(paramQQAppInterface.e).append("] ");
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    int i = paramString1.indexOf(paramString3);
    if (i < 0) {}
    do
    {
      int j;
      do
      {
        return paramString2;
        j = paramString1.indexOf("\n");
      } while (j <= i);
      paramString1 = paramString1.substring(i + paramString3.length(), j);
    } while ((paramString1.contains(paramString2)) || (paramString1.length() >= paramString2.length()));
    paramString2 = new StringBuilder(paramString2);
    paramString2.insert(paramString1.length(), "\n");
    return paramString2.toString();
  }
  
  /* Error */
  public static void a(Context paramContext, Rect paramRect, ChatMessage paramChatMessage, SessionInfo paramSessionInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: new 641	android/os/Bundle
    //   6: dup
    //   7: invokespecial 642	android/os/Bundle:<init>	()V
    //   10: astore 8
    //   12: aload_1
    //   13: ifnull +12 -> 25
    //   16: aload 8
    //   18: ldc_w 644
    //   21: aload_1
    //   22: invokevirtual 648	android/os/Bundle:putParcelable	(Ljava/lang/String;Landroid/os/Parcelable;)V
    //   25: aload 8
    //   27: ldc_w 650
    //   30: iload 4
    //   32: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   35: aload 8
    //   37: ldc_w 656
    //   40: iload 5
    //   42: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   45: aload_3
    //   46: getfield 659	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   49: iconst_1
    //   50: if_icmpne +36 -> 86
    //   53: aload 8
    //   55: ldc_w 661
    //   58: iconst_1
    //   59: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   62: aload 8
    //   64: ldc_w 663
    //   67: aload_3
    //   68: getfield 664	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   71: invokevirtual 668	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 8
    //   76: ldc_w 670
    //   79: aload_3
    //   80: getfield 671	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   83: invokevirtual 668	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload_3
    //   87: getfield 659	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   90: iconst_1
    //   91: if_icmpeq +13 -> 104
    //   94: aload_3
    //   95: getfield 659	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   98: sipush 3000
    //   101: if_icmpne +238 -> 339
    //   104: aload 8
    //   106: ldc_w 673
    //   109: iconst_2
    //   110: invokevirtual 677	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   113: aload 8
    //   115: ldc_w 679
    //   118: aload_2
    //   119: getfield 684	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   122: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   125: aload 8
    //   127: ldc_w 686
    //   130: invokestatic 691	android/os/Process:myPid	()I
    //   133: invokevirtual 677	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   136: aload_2
    //   137: getfield 694	com/tencent/mobileqq/data/ChatMessage:selfuin	Ljava/lang/String;
    //   140: astore_1
    //   141: aload_2
    //   142: getfield 684	com/tencent/mobileqq/data/ChatMessage:isMultiMsg	Z
    //   145: ifne +10 -> 155
    //   148: aload_2
    //   149: getfield 697	com/tencent/mobileqq/data/ChatMessage:isReplySource	Z
    //   152: ifeq +316 -> 468
    //   155: getstatic 703	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   158: aconst_null
    //   159: invokevirtual 707	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   162: astore 9
    //   164: aload_1
    //   165: astore 7
    //   167: aload 9
    //   169: instanceof 19
    //   172: ifeq +10 -> 182
    //   175: aload 9
    //   177: invokevirtual 712	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   180: astore 7
    //   182: aload 7
    //   184: astore_1
    //   185: getstatic 718	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   188: invokevirtual 722	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   191: invokevirtual 712	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   194: iconst_1
    //   195: invokestatic 727	atzv:a	(Ljava/lang/String;I)Z
    //   198: istore 4
    //   200: aload 8
    //   202: ldc_w 729
    //   205: iload 4
    //   207: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   210: iload 4
    //   212: ifeq +35 -> 247
    //   215: getstatic 718	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   218: invokevirtual 722	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   221: invokevirtual 712	mqq/app/AppRuntime:getAccount	()Ljava/lang/String;
    //   224: invokestatic 730	atzv:a	(Ljava/lang/String;)Ljava/lang/String;
    //   227: astore 7
    //   229: aload 7
    //   231: invokestatic 42	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   234: ifne +13 -> 247
    //   237: aload 8
    //   239: ldc_w 732
    //   242: aload 7
    //   244: invokevirtual 668	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   247: aload 8
    //   249: ldc_w 734
    //   252: aload_3
    //   253: getfield 659	com/tencent/mobileqq/activity/aio/SessionInfo:jdField_a_of_type_Int	I
    //   256: invokevirtual 677	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   259: aload 8
    //   261: ldc_w 736
    //   264: aload_2
    //   265: getfield 737	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   268: invokevirtual 668	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: getstatic 718	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   274: aload_1
    //   275: invokevirtual 741	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   278: checkcast 19	com/tencent/mobileqq/app/QQAppInterface
    //   281: astore 7
    //   283: aload_2
    //   284: instanceof 343
    //   287: ifeq +125 -> 412
    //   290: aload_0
    //   291: instanceof 743
    //   294: ifeq +62 -> 356
    //   297: aload 8
    //   299: ldc_w 745
    //   302: iconst_1
    //   303: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   306: aload_0
    //   307: aload 8
    //   309: new 747	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService
    //   312: dup
    //   313: aload_1
    //   314: aload_2
    //   315: getfield 737	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   318: aload_2
    //   319: getfield 748	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   322: aload_2
    //   323: invokespecial 751	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   326: aload_2
    //   327: aload 7
    //   329: invokestatic 756	aehw:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   332: iconst_m1
    //   333: iload 6
    //   335: invokestatic 761	bgky:a	(Landroid/content/Context;Landroid/os/Bundle;Laejb;Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;II)V
    //   338: return
    //   339: aload 8
    //   341: ldc_w 673
    //   344: iconst_1
    //   345: invokevirtual 677	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   348: goto -235 -> 113
    //   351: astore 7
    //   353: goto -168 -> 185
    //   356: aload_0
    //   357: instanceof 763
    //   360: ifne +111 -> 471
    //   363: aload_0
    //   364: instanceof 765
    //   367: ifeq +6 -> 373
    //   370: goto +101 -> 471
    //   373: aload_0
    //   374: instanceof 767
    //   377: ifeq +22 -> 399
    //   380: aload_0
    //   381: checkcast 767	com/tencent/mobileqq/activity/PublicFragmentActivity
    //   384: invokevirtual 770	com/tencent/mobileqq/activity/PublicFragmentActivity:a	()Lcom/tencent/mobileqq/fragment/PublicBaseFragment;
    //   387: instanceof 772
    //   390: ifeq +72 -> 462
    //   393: iconst_2
    //   394: istore 6
    //   396: goto -99 -> 297
    //   399: aload_0
    //   400: instanceof 774
    //   403: ifeq +59 -> 462
    //   406: iconst_5
    //   407: istore 6
    //   409: goto -112 -> 297
    //   412: aload 8
    //   414: ldc_w 745
    //   417: iconst_1
    //   418: invokevirtual 654	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   421: aload_0
    //   422: aload 8
    //   424: new 747	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService
    //   427: dup
    //   428: aload_1
    //   429: aload_2
    //   430: getfield 737	com/tencent/mobileqq/data/ChatMessage:frienduin	Ljava/lang/String;
    //   433: aload_2
    //   434: getfield 748	com/tencent/mobileqq/data/ChatMessage:istroop	I
    //   437: aload_2
    //   438: invokespecial 751	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:<init>	(Ljava/lang/String;Ljava/lang/String;ILcom/tencent/mobileqq/data/ChatMessage;)V
    //   441: aload_2
    //   442: aload 7
    //   444: invokestatic 756	aehw:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;
    //   447: iconst_m1
    //   448: aload_3
    //   449: getfield 776	com/tencent/mobileqq/activity/aio/SessionInfo:c	I
    //   452: invokestatic 761	bgky:a	(Landroid/content/Context;Landroid/os/Bundle;Laejb;Lcom/tencent/mobileqq/activity/aio/photo/AIORichMediaData;II)V
    //   455: return
    //   456: astore_0
    //   457: aload_0
    //   458: invokevirtual 779	mqq/app/AccountNotMatchException:printStackTrace	()V
    //   461: return
    //   462: iconst_m1
    //   463: istore 6
    //   465: goto -168 -> 297
    //   468: goto -283 -> 185
    //   471: iconst_2
    //   472: istore 6
    //   474: goto -177 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	477	0	paramContext	Context
    //   0	477	1	paramRect	Rect
    //   0	477	2	paramChatMessage	ChatMessage
    //   0	477	3	paramSessionInfo	SessionInfo
    //   0	477	4	paramBoolean1	boolean
    //   0	477	5	paramBoolean2	boolean
    //   1	472	6	i	int
    //   165	163	7	localObject	Object
    //   351	92	7	localException	java.lang.Exception
    //   10	413	8	localBundle	Bundle
    //   162	14	9	localAppRuntime	mqq.app.AppRuntime
    // Exception table:
    //   from	to	target	type
    //   155	164	351	java/lang/Exception
    //   167	182	351	java/lang/Exception
    //   271	297	456	mqq/app/AccountNotMatchException
    //   297	338	456	mqq/app/AccountNotMatchException
    //   356	370	456	mqq/app/AccountNotMatchException
    //   373	393	456	mqq/app/AccountNotMatchException
    //   399	406	456	mqq/app/AccountNotMatchException
    //   412	455	456	mqq/app/AccountNotMatchException
  }
  
  public static void a(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, apuv paramapuv)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString2))) {
      if (paramTextView.getWidth() == 0) {
        paramTextView.post(new QFileUtils.2(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramapuv));
      }
    }
    while (TextUtils.isEmpty(str.replace(" ", "")))
    {
      return;
      b(paramContext, paramTextView, paramString1, paramString2, paramString3, paramString4, paramString5, paramBoolean, paramapuv);
      return;
    }
    paramTextView.setText(paramString5 + str);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, FileManagerEntity paramFileManagerEntity)
  {
    if ((paramQQAppInterface == null) || (paramActivity == null)) {}
    while (paramFileManagerEntity == null) {
      return;
    }
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = apug.a().longValue();
    paramQQAppInterface.a().d(localFileManagerEntity);
    int i = aqcg.a(paramFileManagerEntity);
    paramFileManagerEntity = aqcg.a(localFileManagerEntity);
    paramFileManagerEntity.b(i);
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelable("fileinfo", paramFileManagerEntity);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramFileManagerEntity = new Intent();
    paramFileManagerEntity.putExtras(paramQQAppInterface);
    paramFileManagerEntity.putExtra("destroy_last_activity", true);
    paramFileManagerEntity.putExtra("forward_type", 0);
    paramFileManagerEntity.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramFileManagerEntity.putExtra("forward_text", ajya.a(2131709722) + apug.d(localFileManagerEntity.fileName) + ajya.a(2131709734) + apvd.a(localFileManagerEntity.fileSize) + "。");
    paramFileManagerEntity.putExtra("k_favorites", apug.c(localFileManagerEntity));
    if ((!apvd.b(localFileManagerEntity.getFilePath())) && ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 0);
    }
    if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
      paramFileManagerEntity.putExtra("forward_type", 1);
    }
    if (!bbfj.d(BaseApplication.getContext()))
    {
      aptx.a(2131692666);
      return;
    }
    if (aptd.a(localFileManagerEntity).a(false))
    {
      aptt.a(paramActivity, 2131692673, 2131692678, new apvr(paramActivity, paramFileManagerEntity));
      return;
    }
    aqbe.a(paramActivity, paramFileManagerEntity, 103);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, long paramLong1, String paramString1, String paramString2, String paramString3, long paramLong2, int paramInt)
  {
    if (TroopFileTransferManager.a(paramQQAppInterface, paramLong1) == null) {}
    do
    {
      return;
      paramString2 = bakx.a(paramQQAppInterface, paramLong1, paramString1, paramString2, paramString3, paramLong2, paramInt);
    } while (paramString2 == null);
    paramString1 = new Bundle();
    paramString1.putInt("dataline_forward_type", 100);
    if (bbdx.b(paramString2.jdField_a_of_type_JavaLangString)) {
      paramString1.putString("dataline_forward_path", paramString2.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramQQAppInterface = (ajum)paramQQAppInterface.a(8);
      paramString2 = new apvu(paramContext);
      paramInt = paramQQAppInterface.a().b(ajsd.z, paramString1, paramString2);
      if ((paramString2.a) && (paramInt != 0)) {
        break;
      }
      eo.b(paramContext, paramInt);
      return;
      paramString3 = apug.a(paramString2);
      paramString3.status = 2;
      paramString3.nOpType = 24;
      paramString3 = aqcg.a(paramString3);
      paramString3.d(1);
      paramString3.b(10006);
      paramString3.a(1);
      paramString3.a(paramLong1);
      if (paramString2.jdField_a_of_type_JavaUtilUUID != null) {
        paramString3.e(paramString2.jdField_a_of_type_JavaUtilUUID.toString());
      }
      paramString1.putParcelable("fileinfo", paramString3);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, azqv paramazqv, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramQQAppInterface, paramContext, paramSessionInfo, paramChatMessage, paramLong1, paramazqv, paramString, paramLong2, paramInt1, paramInt2, paramRect, paramBoolean1, paramBoolean2, false);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, long paramLong1, azqv paramazqv, String paramString, long paramLong2, int paramInt1, int paramInt2, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if ((paramContext instanceof BasePluginActivity)) {
      paramContext = ((BasePluginActivity)paramContext).getOutActivity();
    }
    for (;;)
    {
      paramazqv = new apoo(paramQQAppInterface, paramContext, paramLong1, paramazqv, paramInt1);
      paramazqv.a(paramLong2);
      paramazqv.a(paramString);
      paramazqv.a(paramSessionInfo);
      paramazqv.a(paramChatMessage);
      paramazqv.a(paramBoolean1);
      paramazqv.b(paramBoolean3);
      if ((paramBoolean2) && ((ChatMessage)paramQQAppInterface.a().c(paramSessionInfo.jdField_a_of_type_JavaLangString, paramSessionInfo.jdField_a_of_type_Int, paramChatMessage.shmsgseq) == null)) {
        paramazqv.c(false);
      }
      paramContext = new apok(paramContext, paramazqv);
      paramContext.a(paramInt2);
      if (paramRect != null) {
        paramContext.a(paramRect);
      }
      paramContext.a(TroopFileDetailBrowserActivity.class);
      paramContext.a(a(paramQQAppInterface));
      paramContext.b(a(paramQQAppInterface));
      paramContext.a();
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, SessionInfo paramSessionInfo, ChatMessage paramChatMessage, Rect paramRect, int paramInt1, int paramInt2, FileManagerEntity paramFileManagerEntity, boolean paramBoolean1, boolean paramBoolean2)
  {
    apab.a(paramContext, new apvo(paramQQAppInterface, paramContext, paramFileManagerEntity, paramInt2, paramSessionInfo, paramChatMessage, paramBoolean1, paramBoolean2, paramInt1, paramRect));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    apvs localapvs;
    int i;
    do
    {
      return;
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putInt("dataline_forward_type", 100);
      localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
      localBundle.putParcelable("fileinfo", aqcg.a(paramFileManagerEntity));
      paramFileManagerEntity = (ajum)paramQQAppInterface.a(8);
      localapvs = new apvs(paramContext);
      i = paramFileManagerEntity.a().b(ajsd.z, localBundle, localapvs);
    } while ((localapvs.a) && (i != 0));
    eo.b(paramContext, i);
    axqy.b(paramQQAppInterface, "CliOper", "", "", "0X800644B", "0X800644B", 0, 0, "6", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!apug.a(paramMessageRecord1))) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord2 = paramMessageRecord2.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramMessageRecord1.istroop = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramMessageRecord1.frienduin = paramMessageRecord2;
      return;
    } while (i != 2);
    paramMessageRecord1.istroop = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity, MessageRecord paramMessageRecord)
  {
    if (paramFileManagerEntity == null) {}
    int i;
    do
    {
      String str;
      do
      {
        do
        {
          return;
          str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
        } while (TextUtils.isEmpty(str));
        i = Integer.parseInt(str);
        paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
        str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (i != 1) {
          break;
        }
        paramFileManagerEntity.peerType = 0;
      } while ((TextUtils.isEmpty(paramQQAppInterface)) || (TextUtils.isEmpty(str)) || (!paramQQAppInterface.equals(str)));
      paramFileManagerEntity.peerUin = paramMessageRecord;
      return;
    } while (i != 2);
    paramFileManagerEntity.peerType = 3000;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List<azpi> paramList, Activity paramActivity, long paramLong)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    while (paramLong == 0L) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramList = paramList.iterator();
    long l1 = 0L;
    if (paramList.hasNext())
    {
      azqv localazqv = a(paramQQAppInterface, paramLong, (azpi)paramList.next());
      FileManagerEntity localFileManagerEntity = apug.a(localazqv);
      localFileManagerEntity.status = 2;
      localFileManagerEntity.nOpType = 24;
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.b(10006);
      if (!TextUtils.isEmpty(localFileManagerEntity.getFilePath())) {
        localForwardFileInfo.a(localazqv.jdField_a_of_type_JavaLangString);
      }
      localForwardFileInfo.d(localazqv.g);
      localForwardFileInfo.d(localazqv.jdField_c_of_type_Long);
      localForwardFileInfo.a(paramLong);
      if (localazqv.jdField_a_of_type_JavaUtilUUID != null) {
        localForwardFileInfo.e(localazqv.jdField_a_of_type_JavaUtilUUID.toString());
      }
      if (!TextUtils.isEmpty(localazqv.jdField_c_of_type_JavaLangString))
      {
        localForwardFileInfo.f(localazqv.jdField_c_of_type_JavaLangString);
        label209:
        localForwardFileInfo.d(1);
        localForwardFileInfo.a(3);
        if (!bbdx.b(localazqv.jdField_a_of_type_JavaLangString)) {
          break label295;
        }
        localArrayList2.add(Uri.parse(localazqv.jdField_a_of_type_JavaLangString));
      }
      for (;;)
      {
        long l2 = localazqv.jdField_c_of_type_Long;
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (TextUtils.isEmpty(localazqv.d)) {
          break label209;
        }
        localForwardFileInfo.f(localazqv.d);
        break label209;
        label295:
        localArrayList2.add(Uri.parse(""));
      }
    }
    paramQQAppInterface = new Bundle();
    paramList = new Intent();
    paramQQAppInterface.putInt("forward_type", 0);
    paramQQAppInterface.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramQQAppInterface.putBoolean("not_forward", true);
    paramQQAppInterface.putBoolean("support_multi_forward", true);
    paramList.putExtra("sendMultiple", true);
    paramQQAppInterface.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    paramList.putExtras(paramQQAppInterface);
    paramList.putExtra("foward_editbar", true);
    paramList.putExtra("forward_type", 0);
    paramQQAppInterface = ajya.a(2131709724);
    if (localArrayList1.size() == 1) {
      paramQQAppInterface = ajya.a(2131709732) + apug.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + ajya.a(2131709733) + apvd.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      paramList.putExtra("forward_text", paramQQAppInterface);
      paramList.putExtra("k_favorites", false);
      aqbe.a(paramActivity, paramList, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramQQAppInterface = ajya.a(2131709728) + apug.d(((ForwardFileInfo)localArrayList1.get(0)).d()) + ajya.a(2131709727) + localArrayList1.size() + ajya.a(2131709730) + apvd.a(l1) + "。";
      }
    }
  }
  
  public static boolean a()
  {
    int i = NetConnInfoCenter.getActiveNetIpFamily(true);
    return (i == 2) || (i == 3);
  }
  
  public static boolean a(int paramInt1, int paramInt2, long paramLong)
  {
    if (paramInt1 * paramInt2 >= 350000000L) {}
    while ((Math.max(paramInt1, paramInt2) > 30000L) || (paramLong >= 31457280L)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      return false;
    }
    String str2 = apug.a(paramString);
    int i = apug.a(str2);
    String str1 = "";
    if (i == 0) {
      str1 = ajsd.bc;
    }
    while (TextUtils.isEmpty(str1))
    {
      return false;
      if (i == 2) {
        str1 = ajsd.bf;
      }
    }
    new File(str1).mkdirs();
    str1 = new File(str1, str2).getAbsolutePath();
    bbdx.d(paramString, str1);
    paramString = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    String str3 = ayxo.a(paramContext, str2);
    int j = gr.a(str1);
    ContentValues localContentValues = new ContentValues(7);
    localContentValues.put("title", str2);
    localContentValues.put("_display_name", localFile.getName());
    localContentValues.put("date_modified", Long.valueOf(localFile.lastModified() / 1000L));
    localContentValues.put("mime_type", str3);
    localContentValues.put("_data", str1);
    localContentValues.put("_size", Long.valueOf(localFile.length()));
    if (i == 0)
    {
      localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
      localContentValues.put("orientation", Integer.valueOf(j));
    }
    for (;;)
    {
      paramContext.getContentResolver().insert(paramString, localContentValues);
      bbef.a(paramContext, str1);
      return true;
      if (i == 2)
      {
        long l = ShortVideoUtils.a(str1);
        localContentValues.put("datetaken", Long.valueOf(System.currentTimeMillis()));
        localContentValues.put("duration", Long.valueOf(l));
        paramString = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
      }
    }
  }
  
  public static boolean a(Context paramContext, boolean paramBoolean, apvg paramapvg)
  {
    int j = 2;
    boolean bool1;
    if (!bbfj.e(BaseApplicationImpl.getContext()))
    {
      aptx.a(2131693314);
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      Activity localActivity = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      i = 3;
      bool2 = bbwq.a(localActivity, i, new apvp(paramapvg), "");
      bool1 = bool2;
    } while (!bool2);
    paramContext = (Activity)paramContext;
    if (paramBoolean) {}
    for (int i = j;; i = 1)
    {
      return bcwb.a(paramContext, i, new apvq(paramapvg));
      i = 2;
      break;
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    int i = VipUtils.a(paramQQAppInterface, null);
    paramQQAppInterface = (aoww)paramQQAppInterface.getManager(317);
    if (i >> 8 == 2)
    {
      if (((i & 0xF) == 1) && (paramQQAppInterface.c())) {
        return true;
      }
      if (paramQQAppInterface.b()) {
        return true;
      }
    }
    else if (paramQQAppInterface.a())
    {
      return true;
    }
    return false;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (((!paramMessageRecord.isMultiMsg) && (!paramMessageRecord.isReplySource)) || (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType")))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    int i;
    int j;
    if (paramFileManagerEntity != null)
    {
      i = paramFileManagerEntity.nOpType;
      j = paramFileManagerEntity.status;
    }
    return ((i != 21) && (i != 22) && (i != 24) && (i != 25) && (i != 28) && (i != 30)) || ((j != 0) && (j != 2));
  }
  
  public static boolean a(boolean paramBoolean, long paramLong, String paramString)
  {
    if (!bbfj.d(BaseApplicationImpl.getContext())) {}
    long l;
    do
    {
      return false;
      if (!apug.a())
      {
        QLog.i("QFileUtils", 1, "checkShowFlowDialog. do not show with Wi-Fi.");
        return false;
      }
      l = apei.a();
      apei.b();
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. fileSize[" + paramLong + "] limit[" + l + "]");
    } while (paramLong < l);
    if (paramBoolean)
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. download so show.");
      return true;
    }
    if (bbdx.b(paramString))
    {
      QLog.i("QFileUtils", 1, "checkShowFlowDialog. is not local File do not show.");
      return false;
    }
    QLog.i("QFileUtils", 1, "checkShowFlowDialog. show flow dialog");
    return true;
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 10;
    case 0: 
      return 7;
    case 2: 
      return 8;
    case 4: 
      return 6;
    case 1: 
      return 9;
    case 10: 
      return 5;
    case 3: 
      return 1;
    case 6: 
      return 2;
    case 7: 
      return 3;
    }
    return 4;
  }
  
  public static int b(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      paramInt2 = 4;
    }
    do
    {
      return paramInt2;
      if (paramInt1 == 3) {
        return 3;
      }
      if (paramInt1 == 0) {
        return 4;
      }
      if (paramInt1 == 2) {
        return 4;
      }
    } while (paramInt1 != 4);
    return 12;
  }
  
  public static String b(int paramInt, String paramString)
  {
    return paramInt + "@" + paramString;
  }
  
  public static String b(long paramLong)
  {
    float f;
    String str;
    if (paramLong > 1048576L)
    {
      f = (float)paramLong / 1048576.0F;
      str = new DecimalFormat("0.00").format(f);
      return ajya.a(2131709726) + str + "MB/s";
    }
    if (paramLong > 1024L)
    {
      f = (float)paramLong / 1024.0F;
      str = new DecimalFormat("0.00").format(f);
      return ajya.a(2131709725) + str + "KB/s";
    }
    return ajya.a(2131709731) + paramLong + "KB/s";
  }
  
  public static void b(Context paramContext, TextView paramTextView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean, apuv paramapuv)
  {
    String str = a(paramContext, paramString1, paramString2, paramString3, paramString4);
    Object localObject = null;
    str = apug.a(paramTextView, 2, paramString5 + str, paramString2);
    paramString2 = localObject;
    if (!TextUtils.isEmpty(str))
    {
      paramContext = a(paramContext, paramString1, str, paramString3, paramString4);
      paramContext = apug.a(paramTextView, paramString5 + paramContext);
      paramString1 = a(paramContext, str, ajya.a(2131709729));
      if (!paramBoolean) {
        break label155;
      }
    }
    label155:
    for (paramString2 = a(paramContext, paramString1, paramapuv);; paramString2 = new SpannableString(paramContext))
    {
      if ((paramString2 != null) && (paramString2.length() > 0))
      {
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.setText(paramString2);
        paramTextView.setFocusable(false);
        paramTextView.setClickable(false);
        paramTextView.setLongClickable(false);
      }
      return;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    if ((paramMessageRecord1 == null) || (!apug.a(paramMessageRecord1))) {}
    while ((paramMessageRecord2 == null) || (!apug.a(paramMessageRecord2))) {
      return;
    }
    paramQQAppInterface.a().a().a(paramMessageRecord1, paramMessageRecord2);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = a();
    paramQQAppInterface = (aoww)paramQQAppInterface.getManager(317);
    if (paramQQAppInterface != null) {}
    for (boolean bool1 = paramQQAppInterface.d();; bool1 = false) {
      return (bool2) && (bool1);
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((6 != paramFileManagerEntity.getCloudType()) || (apvd.b(paramFileManagerEntity.getFilePath()))) {
      return false;
    }
    return true;
  }
  
  public static int c(int paramInt)
  {
    switch (paramInt)
    {
    case 5: 
    case 8: 
    default: 
      return 6;
    case 3: 
      return 1;
    case 6: 
      return 3;
    case 7: 
      return 2;
    case 9: 
      return 4;
    }
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apvm
 * JD-Core Version:    0.7.0.1
 */