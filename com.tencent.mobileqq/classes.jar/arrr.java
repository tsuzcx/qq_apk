import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.content.pm.ShortcutManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Images.Media;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.dataline.mpfile.MpfileTaskInfo;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForDeviceFile;
import com.tencent.mobileqq.data.MessageForDeviceSingleStruct;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.fileassistant.FileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.WeiYunFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FileBrowserActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.1;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.10;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.12;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.16;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.17;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.18;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.21;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.3;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil.8;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONObject;

public class arrr
{
  private static Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private static final String jdField_a_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
  private static ArrayList<Long> jdField_a_of_type_JavaUtilArrayList;
  private static HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static ArrayList<Long> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private static HashMap<String, Integer> jdField_b_of_type_JavaUtilHashMap;
  
  public static int a(int paramInt)
  {
    return a(paramInt, 2);
  }
  
  public static int a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 11: 
    case 13: 
    default: 
      return 2130843981;
    case 2: 
      return 2130843982;
    case 0: 
      return 2130843911;
    case 1: 
      return 2130843926;
    case 3: 
      return 2130843888;
    case 4: 
      return 2130843992;
    case 6: 
      return 2130843991;
    case 5: 
      return 2130843875;
    case 7: 
      return 2130843940;
    case 8: 
      return 2130843892;
    case 9: 
      return 2130843938;
    case 10: 
      return 2130843970;
    case 12: 
      return 2130843947;
    case 14: 
      return 2130843873;
    case 15: 
      return 2130843891;
    case 16: 
      return 2130843902;
    case 17: 
      return 2130843912;
    case 18: 
      return 2130843935;
    case 19: 
      return 2130843936;
    case 20: 
      return 2130843937;
    }
    return 2130843955;
  }
  
  public static int a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isMultiMsg)
    {
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
      if (!TextUtils.isEmpty(paramChatMessage))
      {
        int i = a(paramChatMessage);
        if ((i == 2) || (i == 0)) {
          return i;
        }
      }
    }
    return -1;
  }
  
  public static int a(FileManagerEntity paramFileManagerEntity)
  {
    int k = 0;
    if ((-1 == paramFileManagerEntity.status) || (1 == paramFileManagerEntity.status)) {}
    int j;
    for (int i = 1;; i = 0)
    {
      j = k;
      if (paramFileManagerEntity.bSend)
      {
        j = k;
        if (8 != paramFileManagerEntity.nOpType)
        {
          j = k;
          if (5 != paramFileManagerEntity.nOpType)
          {
            j = k;
            if (1 != paramFileManagerEntity.nOpType) {
              j = 1;
            }
          }
        }
      }
      if (3 != paramFileManagerEntity.getCloudType()) {
        break label135;
      }
      if ((j != 0) && ((j == 0) || (i == 0))) {
        break label133;
      }
      if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) || (paramFileManagerEntity.peerType == 6000)) {
        break;
      }
      return 1;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.WeiYunFileId)) {
      return 2;
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath)) {
      return 4;
    }
    label133:
    return 3;
    label135:
    if (((2 == paramFileManagerEntity.getCloudType()) || (1 == paramFileManagerEntity.getCloudType()) || ((4 == paramFileManagerEntity.getCloudType()) && (paramFileManagerEntity.nOpType != 24))) && (j != 0) && (i == 0) && (!TextUtils.isEmpty(paramFileManagerEntity.getFilePath()))) {
      return 3;
    }
    return paramFileManagerEntity.getCloudType();
  }
  
  public static int a(String paramString)
  {
    label1457:
    for (;;)
    {
      try
      {
        String str1 = arso.a(paramString);
        int i;
        if (str1 != null)
        {
          i = str1.length();
          if (i != 0) {}
        }
        else
        {
          i = -1;
          return i;
        }
        str1 = str1.toLowerCase();
        if (jdField_b_of_type_JavaUtilHashMap == null)
        {
          jdField_b_of_type_JavaUtilHashMap = new HashMap();
          i = Build.VERSION.SDK_INT;
          if (i >= 16)
          {
            try
            {
              int k = MediaCodecList.getCodecCount();
              i = 0;
              if (i < k)
              {
                Object localObject = MediaCodecList.getCodecInfoAt(i);
                if (!((MediaCodecInfo)localObject).isEncoder()) {
                  break label1457;
                }
                localObject = ((MediaCodecInfo)localObject).getSupportedTypes();
                int j = 0;
                if (j >= localObject.length) {
                  break label1457;
                }
                String str2 = MimeTypeMap.getSingleton().getExtensionFromMimeType(localObject[j]);
                if (!TextUtils.isEmpty(str2)) {
                  jdField_b_of_type_JavaUtilHashMap.put("." + str2, Integer.valueOf(1));
                }
                j += 1;
                continue;
              }
              jdField_b_of_type_JavaUtilHashMap.put(".mp3", Integer.valueOf(1));
            }
            catch (Exception localException)
            {
              QLog.i("<QFile>", 1, "GetFileType error, try to get support type failed.");
            }
          }
          else
          {
            jdField_b_of_type_JavaUtilHashMap.put(".flac", Integer.valueOf(1));
            jdField_b_of_type_JavaUtilHashMap.put(".ogg", Integer.valueOf(1));
            jdField_b_of_type_JavaUtilHashMap.put(".wav", Integer.valueOf(1));
            jdField_b_of_type_JavaUtilHashMap.put(".m4a", Integer.valueOf(1));
            jdField_b_of_type_JavaUtilHashMap.remove(".flv");
            jdField_b_of_type_JavaUtilHashMap.remove(".m");
            jdField_b_of_type_JavaUtilHashMap.remove(".webp");
            jdField_b_of_type_JavaUtilHashMap.remove(".vcf");
            jdField_b_of_type_JavaUtilHashMap.put(".bmp", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".jpg", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".jpeg", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".png", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".gif", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".webp", Integer.valueOf(0));
            jdField_b_of_type_JavaUtilHashMap.put(".psd", Integer.valueOf(12));
            jdField_b_of_type_JavaUtilHashMap.put(".swf", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mov", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mp4", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".3gp", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".avi", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".rmvb", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mpg", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".rm", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".asf", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mpeg", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mkv", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".wmv", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".flv", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".f4v", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".webm", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mod", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".mpe", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".fla", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".m4r", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".m4u", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".m4v", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".vob", Integer.valueOf(2));
            jdField_b_of_type_JavaUtilHashMap.put(".doc", Integer.valueOf(3));
            jdField_b_of_type_JavaUtilHashMap.put(".docx", Integer.valueOf(3));
            jdField_b_of_type_JavaUtilHashMap.put(".wps", Integer.valueOf(3));
            jdField_b_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(3));
            jdField_b_of_type_JavaUtilHashMap.put(".zip", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put(".rar", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put(".7z", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put(".tar", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put(".iso", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put("gz", Integer.valueOf(4));
            jdField_b_of_type_JavaUtilHashMap.put(".apk", Integer.valueOf(5));
            jdField_b_of_type_JavaUtilHashMap.put(".apk.rename", Integer.valueOf(5));
            jdField_b_of_type_JavaUtilHashMap.put(".xls", Integer.valueOf(6));
            jdField_b_of_type_JavaUtilHashMap.put(".xlsx", Integer.valueOf(6));
            jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(6));
            jdField_b_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(6));
            jdField_b_of_type_JavaUtilHashMap.put(".et", Integer.valueOf(6));
            jdField_b_of_type_JavaUtilHashMap.put(".ppt", Integer.valueOf(7));
            jdField_b_of_type_JavaUtilHashMap.put(".pptx", Integer.valueOf(7));
            jdField_b_of_type_JavaUtilHashMap.put(".pps", Integer.valueOf(7));
            jdField_b_of_type_JavaUtilHashMap.put(".dps", Integer.valueOf(7));
            jdField_b_of_type_JavaUtilHashMap.put(".keynotes", Integer.valueOf(7));
            jdField_b_of_type_JavaUtilHashMap.put(".htm", Integer.valueOf(8));
            jdField_b_of_type_JavaUtilHashMap.put(".html", Integer.valueOf(8));
            jdField_b_of_type_JavaUtilHashMap.put(".php", Integer.valueOf(8));
            jdField_b_of_type_JavaUtilHashMap.put(".pdf", Integer.valueOf(9));
            jdField_b_of_type_JavaUtilHashMap.put(".txt", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".epub", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".rtf", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".c", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".conf", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".cpp", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".h", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".java", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".log", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".prop", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".rc", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".sh", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".csv", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".xml", Integer.valueOf(10));
            jdField_b_of_type_JavaUtilHashMap.put(".ai", Integer.valueOf(14));
            jdField_b_of_type_JavaUtilHashMap.put(".font", Integer.valueOf(15));
            jdField_b_of_type_JavaUtilHashMap.put(".ipa", Integer.valueOf(16));
            jdField_b_of_type_JavaUtilHashMap.put(".keynote", Integer.valueOf(17));
            jdField_b_of_type_JavaUtilHashMap.put(".note", Integer.valueOf(18));
            jdField_b_of_type_JavaUtilHashMap.put(".numbers", Integer.valueOf(19));
            jdField_b_of_type_JavaUtilHashMap.put(".pages", Integer.valueOf(20));
            jdField_b_of_type_JavaUtilHashMap.put(".sketch", Integer.valueOf(21));
          }
        }
        else
        {
          if (jdField_b_of_type_JavaUtilHashMap.containsKey(str1.toLowerCase()))
          {
            i = ((Integer)jdField_b_of_type_JavaUtilHashMap.get(str1.toLowerCase())).intValue();
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.w("FileManagerUtil<FileAssistant>", 2, "Unknow file Type[" + paramString + "]");
          }
          i = 11;
          continue;
        }
        i += 1;
      }
      finally {}
    }
  }
  
  public static int a(List<FileInfo> paramList, long paramLong)
  {
    int i = 0;
    int j = paramList.size() - 1;
    int k = i;
    if (i <= j)
    {
      k = i + j >>> 1;
      FileInfo localFileInfo = (FileInfo)paramList.get(k);
      if (localFileInfo.b() > paramLong)
      {
        k += 1;
        i = j;
        j = k;
      }
      for (;;)
      {
        k = j;
        j = i;
        i = k;
        break;
        if (localFileInfo.b() >= paramLong) {
          break label103;
        }
        k -= 1;
        j = i;
        i = k;
      }
    }
    label103:
    return k;
  }
  
  public static long a()
  {
    int i = ayxz.jdField_a_of_type_Int;
    ayxz.jdField_a_of_type_Int = i + 1;
    return (short)(int)((int)(i & 0xFFFFFFFF) & 0xFFFF);
  }
  
  public static long a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return -1L;
    case 1004: 
      return 105L;
    case 1000: 
      return 104L;
    case 1001: 
      return 100L;
    case 10002: 
      return 127L;
    case 1006: 
      return 102L;
    case 1010: 
      return 109L;
    }
    return 124L;
  }
  
  public static long a(long paramLong)
  {
    return 2863315899L << 31 | paramLong;
  }
  
  private static long a(long paramLong, TimeZone paramTimeZone)
  {
    return (paramTimeZone.getOffset(paramLong) + paramLong) / 86400000L;
  }
  
  public static long a(QQAppInterface paramQQAppInterface, String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return 0L;
        }
        paramQQAppInterface = f(paramString);
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break label163;
        }
        l = 20971520L;
        if ("txt".equals(paramQQAppInterface.toLowerCase())) {
          l = 102400L;
        }
        paramString = aoxw.a().b();
        if (TextUtils.isEmpty(paramString)) {
          return l;
        }
        paramString = paramString.split("#");
        if (paramString.length != 0) {
          break label165;
        }
        return l;
      }
      catch (Exception paramQQAppInterface)
      {
        long l;
        String[] arrayOfString;
        QLog.e("FileManagerUtil<FileAssistant>", 1, " get docs import file max size exception =" + paramQQAppInterface.toString());
      }
      if (i < paramString.length)
      {
        arrayOfString = paramString[i].split("_");
        if ((arrayOfString[0].contains(paramQQAppInterface)) || (arrayOfString[0].contains(paramQQAppInterface.toLowerCase())))
        {
          l = Long.parseLong(arrayOfString[1]);
          return l;
        }
        i += 1;
      }
      else
      {
        label163:
        return 0L;
        label165:
        i = 0;
      }
    }
  }
  
  public static long a(String paramString)
  {
    if (paramString == null)
    {
      QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
      return 0L;
    }
    VFSFile localVFSFile = new VFSFile(paramString);
    if (!localVFSFile.exists())
    {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " is not exists");
      return 0L;
    }
    long l = localVFSFile.length();
    if (0L == l) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + paramString + " len is 0");
    }
    return l;
  }
  
  public static Intent a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      localObject = null;
    }
    Intent localIntent;
    Bundle localBundle;
    do
    {
      return localObject;
      localIntent = new Intent();
      localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      if ((paramMessageRecord instanceof MessageForFile))
      {
        paramMessageRecord = (MessageForFile)paramMessageRecord;
        localBundle.putParcelable("fileinfo", arzx.a(a(paramQQAppInterface, paramMessageRecord), paramMessageRecord));
        localIntent.putExtras(localBundle);
        return localIntent;
      }
      localObject = localIntent;
    } while (!(paramMessageRecord instanceof MessageForTroopFile));
    paramMessageRecord = (MessageForTroopFile)paramMessageRecord;
    paramQQAppInterface = bcnt.a(paramQQAppInterface, paramMessageRecord);
    Object localObject = a(paramQQAppInterface);
    ((FileManagerEntity)localObject).status = 2;
    ((FileManagerEntity)localObject).nOpType = 24;
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.b(10006);
    if (!TextUtils.isEmpty(((FileManagerEntity)localObject).getFilePath())) {
      localForwardFileInfo.a(paramQQAppInterface.jdField_a_of_type_JavaLangString);
    }
    localForwardFileInfo.d(paramQQAppInterface.g);
    localForwardFileInfo.d(paramQQAppInterface.jdField_c_of_type_Long);
    localForwardFileInfo.a(Long.parseLong(paramMessageRecord.frienduin));
    if (paramQQAppInterface.jdField_a_of_type_JavaUtilUUID != null) {
      localForwardFileInfo.e(paramQQAppInterface.jdField_a_of_type_JavaUtilUUID.toString());
    }
    localForwardFileInfo.d(1);
    localForwardFileInfo.a(1);
    localBundle.putParcelable("fileinfo", localForwardFileInfo);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_from_troop_file", true);
    return localIntent;
  }
  
  public static Bitmap a(Context paramContext, Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        float f = paramContext.getResources().getDisplayMetrics().density;
        int i2 = aepi.a(paramInt, paramContext.getResources());
        j = (int)(paramBitmap.getWidth() * f);
        k = (int)(f * paramBitmap.getHeight());
        paramInt = paramBitmap.getWidth();
        i = paramBitmap.getHeight();
        if (paramInt > i)
        {
          j = (paramInt - i) / 2;
          m = k;
          paramInt = i;
          i1 = 0;
          n = k;
          k = j;
          j = i1;
          paramContext = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
          Canvas localCanvas = new Canvas(paramContext);
          Paint localPaint = new Paint();
          Rect localRect1 = new Rect(k, j, i + k, paramInt + j);
          Rect localRect2 = new Rect(0, 0, n, m);
          RectF localRectF = new RectF(localRect2);
          localPaint.setAntiAlias(true);
          localPaint.setDither(true);
          localPaint.setFilterBitmap(true);
          localCanvas.drawARGB(0, 0, 0, 0);
          localPaint.setColor(-12434878);
          localCanvas.drawRoundRect(localRectF, i2, i2, localPaint);
          localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
          localCanvas.drawBitmap(paramBitmap, localRect1, localRect2, localPaint);
          return paramContext;
        }
        if (i > paramInt)
        {
          k = (i - paramInt) / 2;
          m = j;
          n = j;
          i1 = 0;
          i = paramInt;
          j = k;
          k = i1;
          continue;
        }
        int m = k;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
      int n = j;
      int i1 = 0;
      int k = 0;
      int j = paramInt;
      paramInt = i;
      int i = j;
      j = i1;
    }
  }
  
  public static SpannableString a(String paramString1, String paramString2, arsg paramarsg)
  {
    int i = paramString1.indexOf(paramString2);
    int j = paramString2.length() + i;
    paramString1 = new SpannableString(paramString1);
    paramString2 = new arsc(paramarsg);
    try
    {
      paramString1.setSpan(new ForegroundColorSpan(-12541697), i, j, 33);
      paramString1.setSpan(paramString2, i, j, 33);
      return paramString1;
    }
    catch (Exception paramString2) {}
    return paramString1;
  }
  
  /* Error */
  public static arsh a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokestatic 737	arrr:d	(Ljava/lang/String;)[B
    //   6: invokestatic 743	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   9: astore_1
    //   10: new 165	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   17: invokestatic 748	arqx:a	()Larqx;
    //   20: invokevirtual 750	arqx:d	()Ljava/lang/String;
    //   23: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc_w 752
    //   29: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: aload_1
    //   33: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: astore 4
    //   41: new 754	arsh
    //   44: dup
    //   45: invokespecial 755	arsh:<init>	()V
    //   48: astore 5
    //   50: aload 5
    //   52: iconst_0
    //   53: putfield 756	arsh:jdField_a_of_type_Int	I
    //   56: aload 5
    //   58: aload_1
    //   59: putfield 758	arsh:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   62: aload 4
    //   64: invokestatic 761	arso:b	(Ljava/lang/String;)Z
    //   67: ifeq +51 -> 118
    //   70: new 763	android/graphics/BitmapFactory$Options
    //   73: dup
    //   74: invokespecial 764	android/graphics/BitmapFactory$Options:<init>	()V
    //   77: astore_0
    //   78: aload_0
    //   79: iconst_1
    //   80: putfield 767	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   83: aload 4
    //   85: aload_0
    //   86: invokestatic 772	arsj:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   89: pop
    //   90: aload 5
    //   92: aload_0
    //   93: getfield 775	android/graphics/BitmapFactory$Options:outWidth	I
    //   96: putfield 777	arsh:jdField_b_of_type_Int	I
    //   99: aload 5
    //   101: aload_0
    //   102: getfield 780	android/graphics/BitmapFactory$Options:outHeight	I
    //   105: putfield 782	arsh:jdField_c_of_type_Int	I
    //   108: aload 5
    //   110: aload 4
    //   112: putfield 783	arsh:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   115: aload 5
    //   117: areturn
    //   118: aload_0
    //   119: iconst_1
    //   120: invokestatic 789	android/media/ThumbnailUtils:createVideoThumbnail	(Ljava/lang/String;I)Landroid/graphics/Bitmap;
    //   123: astore_0
    //   124: aload_0
    //   125: astore_2
    //   126: aload_0
    //   127: ifnonnull +21 -> 148
    //   130: aload 5
    //   132: iconst_m1
    //   133: putfield 756	arsh:jdField_a_of_type_Int	I
    //   136: aload 5
    //   138: areturn
    //   139: astore_1
    //   140: aconst_null
    //   141: astore_0
    //   142: aload_1
    //   143: invokevirtual 790	java/lang/Exception:printStackTrace	()V
    //   146: aload_0
    //   147: astore_2
    //   148: new 165	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   155: invokestatic 748	arqx:a	()Larqx;
    //   158: invokevirtual 750	arqx:d	()Ljava/lang/String;
    //   161: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokestatic 795	java/lang/System:currentTimeMillis	()J
    //   167: invokevirtual 798	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   170: ldc 221
    //   172: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: astore 6
    //   180: new 165	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   187: invokestatic 748	arqx:a	()Larqx;
    //   190: invokevirtual 750	arqx:d	()Ljava/lang/String;
    //   193: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: ldc_w 800
    //   199: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 804	bdhb:c	(Ljava/lang/String;)V
    //   208: new 483	com/tencent/mm/vfs/VFSFile
    //   211: dup
    //   212: aload 6
    //   214: invokespecial 486	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   217: astore 7
    //   219: aload 7
    //   221: invokevirtual 807	com/tencent/mm/vfs/VFSFile:getParent	()Ljava/lang/String;
    //   224: astore_0
    //   225: aload_0
    //   226: ifnonnull +6 -> 232
    //   229: aload 5
    //   231: areturn
    //   232: new 483	com/tencent/mm/vfs/VFSFile
    //   235: dup
    //   236: aload_0
    //   237: invokespecial 486	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   240: astore_0
    //   241: aload_0
    //   242: invokevirtual 489	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   245: ifeq +10 -> 255
    //   248: aload_0
    //   249: invokevirtual 810	com/tencent/mm/vfs/VFSFile:isDirectory	()Z
    //   252: ifne +8 -> 260
    //   255: aload_0
    //   256: invokevirtual 813	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   259: pop
    //   260: aload 7
    //   262: invokevirtual 489	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   265: ifeq +11 -> 276
    //   268: aload 7
    //   270: invokevirtual 816	com/tencent/mm/vfs/VFSFile:isFile	()Z
    //   273: ifne +9 -> 282
    //   276: aload 7
    //   278: invokevirtual 819	com/tencent/mm/vfs/VFSFile:createNewFile	()Z
    //   281: pop
    //   282: new 821	java/io/BufferedOutputStream
    //   285: dup
    //   286: new 823	com/tencent/mm/vfs/VFSFileOutputStream
    //   289: dup
    //   290: aload 7
    //   292: invokespecial 826	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   295: invokespecial 829	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   298: astore_0
    //   299: aload_2
    //   300: ifnull +85 -> 385
    //   303: aload_0
    //   304: astore_1
    //   305: aload_2
    //   306: getstatic 835	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   309: bipush 80
    //   311: aload_0
    //   312: invokevirtual 839	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   315: pop
    //   316: aload_0
    //   317: astore_1
    //   318: aload_0
    //   319: invokevirtual 842	java/io/BufferedOutputStream:flush	()V
    //   322: aload_0
    //   323: ifnull +7 -> 330
    //   326: aload_0
    //   327: invokevirtual 845	java/io/BufferedOutputStream:close	()V
    //   330: aload 7
    //   332: invokevirtual 489	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   335: ifeq +222 -> 557
    //   338: aload 6
    //   340: aload 4
    //   342: invokestatic 848	bdhb:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   345: pop
    //   346: aload 6
    //   348: invokestatic 850	arso:c	(Ljava/lang/String;)Z
    //   351: pop
    //   352: aload_2
    //   353: ifnull +21 -> 374
    //   356: aload 5
    //   358: aload_2
    //   359: invokevirtual 629	android/graphics/Bitmap:getWidth	()I
    //   362: putfield 777	arsh:jdField_b_of_type_Int	I
    //   365: aload 5
    //   367: aload_2
    //   368: invokevirtual 632	android/graphics/Bitmap:getHeight	()I
    //   371: putfield 782	arsh:jdField_c_of_type_Int	I
    //   374: aload 5
    //   376: areturn
    //   377: astore_0
    //   378: aload_0
    //   379: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   382: goto -100 -> 282
    //   385: aload_0
    //   386: astore_1
    //   387: aload 5
    //   389: iconst_m1
    //   390: putfield 756	arsh:jdField_a_of_type_Int	I
    //   393: goto -71 -> 322
    //   396: astore_1
    //   397: aload 5
    //   399: bipush 254
    //   401: putfield 756	arsh:jdField_a_of_type_Int	I
    //   404: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   407: ifeq +44 -> 451
    //   410: ldc_w 376
    //   413: iconst_2
    //   414: new 165	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 853
    //   424: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload 6
    //   429: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc_w 855
    //   435: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: aload_1
    //   439: invokevirtual 858	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   442: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   448: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   451: aload_0
    //   452: ifnull -122 -> 330
    //   455: aload_0
    //   456: invokevirtual 845	java/io/BufferedOutputStream:close	()V
    //   459: goto -129 -> 330
    //   462: astore_0
    //   463: goto -133 -> 330
    //   466: astore_3
    //   467: aconst_null
    //   468: astore_0
    //   469: aload_0
    //   470: astore_1
    //   471: aload 5
    //   473: bipush 254
    //   475: putfield 756	arsh:jdField_a_of_type_Int	I
    //   478: aload_0
    //   479: astore_1
    //   480: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +46 -> 529
    //   486: aload_0
    //   487: astore_1
    //   488: ldc_w 376
    //   491: iconst_2
    //   492: new 165	java/lang/StringBuilder
    //   495: dup
    //   496: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   499: ldc_w 853
    //   502: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: aload 6
    //   507: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc_w 860
    //   513: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: aload_3
    //   517: invokevirtual 861	java/io/IOException:getMessage	()Ljava/lang/String;
    //   520: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: aload_0
    //   530: ifnull -200 -> 330
    //   533: aload_0
    //   534: invokevirtual 845	java/io/BufferedOutputStream:close	()V
    //   537: goto -207 -> 330
    //   540: astore_0
    //   541: goto -211 -> 330
    //   544: astore_0
    //   545: aconst_null
    //   546: astore_1
    //   547: aload_1
    //   548: ifnull +7 -> 555
    //   551: aload_1
    //   552: invokevirtual 845	java/io/BufferedOutputStream:close	()V
    //   555: aload_0
    //   556: athrow
    //   557: aload 5
    //   559: iconst_m1
    //   560: putfield 756	arsh:jdField_a_of_type_Int	I
    //   563: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq -192 -> 374
    //   569: ldc_w 376
    //   572: iconst_2
    //   573: ldc_w 863
    //   576: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   579: goto -205 -> 374
    //   582: astore_0
    //   583: goto -253 -> 330
    //   586: astore_1
    //   587: goto -32 -> 555
    //   590: astore_0
    //   591: goto -44 -> 547
    //   594: astore_2
    //   595: aload_0
    //   596: astore_1
    //   597: aload_2
    //   598: astore_0
    //   599: goto -52 -> 547
    //   602: astore_3
    //   603: goto -134 -> 469
    //   606: astore_1
    //   607: aload_3
    //   608: astore_0
    //   609: goto -212 -> 397
    //   612: astore_1
    //   613: goto -471 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	616	0	paramString	String
    //   9	50	1	str1	String
    //   139	4	1	localException1	Exception
    //   304	83	1	str2	String
    //   396	43	1	localFileNotFoundException1	FileNotFoundException
    //   470	82	1	str3	String
    //   586	1	1	localIOException1	IOException
    //   596	1	1	str4	String
    //   606	1	1	localFileNotFoundException2	FileNotFoundException
    //   612	1	1	localException2	Exception
    //   125	243	2	str5	String
    //   594	4	2	localObject1	Object
    //   1	1	3	localObject2	Object
    //   466	51	3	localIOException2	IOException
    //   602	6	3	localIOException3	IOException
    //   39	302	4	str6	String
    //   48	510	5	localarsh	arsh
    //   178	328	6	str7	String
    //   217	114	7	localVFSFile	VFSFile
    // Exception table:
    //   from	to	target	type
    //   118	124	139	java/lang/Exception
    //   276	282	377	java/io/IOException
    //   305	316	396	java/io/FileNotFoundException
    //   318	322	396	java/io/FileNotFoundException
    //   387	393	396	java/io/FileNotFoundException
    //   455	459	462	java/io/IOException
    //   282	299	466	java/io/IOException
    //   533	537	540	java/io/IOException
    //   282	299	544	finally
    //   326	330	582	java/io/IOException
    //   551	555	586	java/io/IOException
    //   305	316	590	finally
    //   318	322	590	finally
    //   387	393	590	finally
    //   471	478	590	finally
    //   480	486	590	finally
    //   488	529	590	finally
    //   397	451	594	finally
    //   305	316	602	java/io/IOException
    //   318	322	602	java/io/IOException
    //   387	393	602	java/io/IOException
    //   282	299	606	java/io/FileNotFoundException
    //   130	136	612	java/lang/Exception
  }
  
  public static arss a(QQAppInterface paramQQAppInterface)
  {
    return new arru(paramQQAppInterface);
  }
  
  public static arss a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return new arrt(paramQQAppInterface, paramInt);
  }
  
  public static bawq a()
  {
    boolean bool = false;
    Object localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    int i = -1;
    int k;
    int j;
    if (localObject != null)
    {
      k = ((NetworkInfo)localObject).getType();
      if (k == 1)
      {
        i = 1;
        j = i;
        i = k;
      }
    }
    for (;;)
    {
      int m = BaseApplicationImpl.sApplication.getMsfConnectedNetType();
      if (m == 2) {}
      for (k = 1;; k = 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("getNetworkInfo,systemType:").append(i).append(" msfType:").append(m).append(" isSameNet:");
          if (j == k) {
            bool = true;
          }
          QLog.i("FileManagerUtil<FileAssistant>.NetDebug", 1, bool);
        }
        if (j == k) {
          break label199;
        }
        localObject = new bawq();
        ((bawq)localObject).jdField_a_of_type_Int = 20000;
        ((bawq)localObject).jdField_b_of_type_Int = 15000;
        ((bawq)localObject).jdField_c_of_type_Int = 10000;
        ((bawq)localObject).jdField_d_of_type_Int = 10000;
        ((bawq)localObject).jdField_e_of_type_Int = 5000;
        ((bawq)localObject).f = 5000;
        return localObject;
        i = 0;
        break;
      }
      label199:
      return null;
      j = 0;
    }
  }
  
  public static ChatMessage a(ChatMessage paramChatMessage)
  {
    Object localObject2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
    if (((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface)) {}
    for (Object localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();; localObject1 = null)
    {
      if ((arsx.a(paramChatMessage)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        int j = Integer.parseInt((String)localObject2);
        if (j == 3)
        {
          localObject1 = (ChatMessage)azaf.a(-2017);
          ((ChatMessage)localObject1).isMultiMsg = paramChatMessage.isMultiMsg;
          ((ChatMessage)localObject1).isReplySource = paramChatMessage.isReplySource;
          ((ChatMessage)localObject1).selfuin = paramChatMessage.selfuin;
          ((ChatMessage)localObject1).shmsgseq = paramChatMessage.shmsgseq;
          ((ChatMessage)localObject1).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          ((ChatMessage)localObject1).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
          a(paramChatMessage, (MessageForTroopFile)localObject1);
          ((MessageForTroopFile)localObject1).istroop = 1;
        }
        for (;;)
        {
          paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
          if (!TextUtils.isEmpty(paramChatMessage)) {
            ((ChatMessage)localObject1).saveExtInfoToExtStr("_m_ForwardFileStatus", paramChatMessage);
          }
          return localObject1;
          if ((j == 1) || (j == 2))
          {
            if (j == 1) {}
            for (int i = -2005;; i = -2014)
            {
              localObject2 = (ChatMessage)azaf.a(i);
              ((ChatMessage)localObject2).isMultiMsg = paramChatMessage.isMultiMsg;
              ((ChatMessage)localObject2).isReplySource = paramChatMessage.isReplySource;
              ((ChatMessage)localObject2).selfuin = paramChatMessage.selfuin;
              ((ChatMessage)localObject2).shmsgseq = paramChatMessage.shmsgseq;
              ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
              ((ChatMessage)localObject2).senderuin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
              a(paramChatMessage, (MessageForFile)localObject2);
              if (localObject1 == null) {
                break label286;
              }
              arsx.a((QQAppInterface)localObject1, (MessageRecord)localObject2, paramChatMessage);
              localObject1 = localObject2;
              break;
            }
            label286:
            if (j == 1)
            {
              ((ChatMessage)localObject2).istroop = 0;
              ((ChatMessage)localObject2).frienduin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
              localObject1 = localObject2;
            }
            else
            {
              localObject1 = localObject2;
              if (j == 2)
              {
                ((ChatMessage)localObject2).istroop = 3000;
                localObject1 = localObject2;
              }
            }
          }
          else
          {
            localObject1 = paramChatMessage;
          }
        }
      }
      return paramChatMessage;
    }
  }
  
  public static FileManagerEntity a()
  {
    Object localObject3 = arbs.b();
    Object localObject2 = arbs.a();
    Object localObject1 = arbs.d();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          return localFileManagerEntity;
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).a() == 0) {
          return a((FileInfo)localObject3);
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (a(((WeiYunFileInfo)localObject2).jdField_c_of_type_JavaLangString) == 0) {
          return a((WeiYunFileInfo)localObject2);
        }
      }
    }
    return null;
  }
  
  public static FileManagerEntity a(Bundle paramBundle)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(2);
    localFileManagerEntity.nOpType = 50;
    localFileManagerEntity.WeiYunFileId = ((String)paramBundle.get("file_id"));
    localFileManagerEntity.fileName = ((String)paramBundle.get("filename"));
    localFileManagerEntity.WeiYunDirKey = ((String)paramBundle.get("pdir_key"));
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(bbtn parambbtn)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(4);
    localFileManagerEntity.fileName = parambbtn.g;
    if (arso.a(parambbtn.jdField_a_of_type_JavaLangString)) {
      localFileManagerEntity.setFilePath(parambbtn.jdField_a_of_type_JavaLangString);
    }
    if (arso.a(parambbtn.jdField_c_of_type_JavaLangString)) {
      localFileManagerEntity.strLargeThumPath = parambbtn.jdField_c_of_type_JavaLangString;
    }
    if (arso.a(parambbtn.jdField_b_of_type_JavaLangString))
    {
      localFileManagerEntity.strThumbPath = parambbtn.jdField_b_of_type_JavaLangString;
      localFileManagerEntity.fileSize = parambbtn.jdField_c_of_type_Long;
      localFileManagerEntity.fProgress = ((float)parambbtn.jdField_d_of_type_Long / (float)parambbtn.jdField_c_of_type_Long);
      localFileManagerEntity.nFileType = a(parambbtn.g);
      if ((6 <= parambbtn.jdField_b_of_type_Int) && (13 != parambbtn.jdField_b_of_type_Int)) {
        break label330;
      }
      localFileManagerEntity.status = 2;
    }
    for (;;)
    {
      if (parambbtn.jdField_a_of_type_JavaUtilUUID != null) {
        localFileManagerEntity.strTroopFileID = parambbtn.jdField_a_of_type_JavaUtilUUID.toString();
      }
      localFileManagerEntity.strTroopFilePath = parambbtn.jdField_e_of_type_JavaLangString;
      localFileManagerEntity.strTroopFileSha1 = parambbtn.f;
      localFileManagerEntity.busId = parambbtn.h;
      localFileManagerEntity.TroopUin = parambbtn.jdField_b_of_type_Long;
      localFileManagerEntity.peerType = 1;
      localFileManagerEntity.peerUin = String.valueOf(parambbtn.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = parambbtn.jdField_a_of_type_Long;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + parambbtn.g + "] by troop size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (!arso.a(parambbtn.jdField_d_of_type_JavaLangString)) {
        break;
      }
      localFileManagerEntity.strMiddleThumPath = parambbtn.jdField_d_of_type_JavaLangString;
      break;
      label330:
      if (12 == parambbtn.jdField_b_of_type_Int) {
        localFileManagerEntity.status = 0;
      } else {
        localFileManagerEntity.status = 1;
      }
    }
  }
  
  public static FileManagerEntity a(MpfileTaskInfo paramMpfileTaskInfo, long paramLong)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(7);
    localFileManagerEntity.bSend = false;
    Object localObject;
    if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_a_of_type_Int)
    {
      localFileManagerEntity.status = -1;
      localFileManagerEntity.fileName = paramMpfileTaskInfo.jdField_d_of_type_JavaLangString;
      localFileManagerEntity.setFilePath(paramMpfileTaskInfo.jdField_e_of_type_JavaLangString);
      localFileManagerEntity.fileSize = paramMpfileTaskInfo.jdField_b_of_type_Long;
      localFileManagerEntity.nFileType = a(paramMpfileTaskInfo.jdField_d_of_type_JavaLangString);
      if (localFileManagerEntity.nFileType == 0)
      {
        localObject = (alqo)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(8);
        if (((alqo)localObject).a().a() != null) {
          break label354;
        }
        if (QLog.isColorLevel()) {
          QLog.e("##########", 2, "插件的service没有启动");
        }
      }
    }
    for (;;)
    {
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      localFileManagerEntity.uniseq = paramMpfileTaskInfo.jdField_d_of_type_Long;
      localFileManagerEntity.strDataLineMPFileID = paramMpfileTaskInfo.jdField_c_of_type_JavaLangString;
      localFileManagerEntity.peerDin = paramLong;
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramMpfileTaskInfo.jdField_d_of_type_JavaLangString + "] by mpfile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)localObject).a().d(localFileManagerEntity);
      return localFileManagerEntity;
      if (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_c_of_type_Int)
      {
        localFileManagerEntity.status = 1;
        localFileManagerEntity.fProgress = 1.0F;
        break;
      }
      if ((paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_d_of_type_Int) || (paramMpfileTaskInfo.g == MpfileTaskInfo.jdField_e_of_type_Int))
      {
        localFileManagerEntity.status = 3;
        localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
        break;
      }
      localFileManagerEntity.status = 2;
      localFileManagerEntity.fProgress = ((float)paramMpfileTaskInfo.jdField_c_of_type_Long / (float)paramMpfileTaskInfo.jdField_b_of_type_Long);
      break;
      label354:
      localFileManagerEntity.strLargeThumPath = String.format("%s/%s", new Object[] { ((alqo)localObject).a().a(), paramMpfileTaskInfo.jdField_d_of_type_JavaLangString });
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, long paramLong, String paramString, int paramInt, ChatMessage paramChatMessage)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramLong, paramString, paramInt);
    if (localFileManagerEntity == null) {}
    paramString = localFileManagerEntity;
    if (localFileManagerEntity == null) {
      paramString = a(paramQQAppInterface, paramChatMessage);
    }
    return paramString;
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!arsx.a(paramChatMessage))) {}
    for (;;)
    {
      return null;
      Object localObject = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      for (int i = Integer.parseInt((String)localObject); (i == 1) || (i == 2); i = -1)
      {
        localObject = new FileManagerEntity();
        ((FileManagerEntity)localObject).nSessionId = a().longValue();
        ((FileManagerEntity)localObject).uniseq = paramChatMessage.uniseq;
        ((FileManagerEntity)localObject).selfUin = paramQQAppInterface.getAccount();
        ((FileManagerEntity)localObject).isReaded = false;
        ((FileManagerEntity)localObject).peerUin = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        arsx.a(paramQQAppInterface, (FileManagerEntity)localObject, paramChatMessage);
        ((FileManagerEntity)localObject).peerNick = a(paramQQAppInterface, ((FileManagerEntity)localObject).peerUin, null, ((FileManagerEntity)localObject).peerType);
        ((FileManagerEntity)localObject).Uuid = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
        ((FileManagerEntity)localObject).fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(str)) {
          ((FileManagerEntity)localObject).fileSize = Long.parseLong(str);
        }
        str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
        {
          if (!((FileManagerEntity)localObject).selfUin.equals(str)) {
            break label356;
          }
          ((FileManagerEntity)localObject).nOpType = 0;
        }
        for (;;)
        {
          ((FileManagerEntity)localObject).status = -1;
          str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
          if (!TextUtils.isEmpty(((FileManagerEntity)localObject).selfUin))
          {
            if (((FileManagerEntity)localObject).selfUin.equals(str)) {
              ((FileManagerEntity)localObject).bSend = false;
            }
          }
          else
          {
            label240:
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
            if (!bdhb.b(str)) {
              break label372;
            }
            ((FileManagerEntity)localObject).setFilePath(str);
            ((FileManagerEntity)localObject).setCloudType(3);
            ((FileManagerEntity)localObject).strFileMd5 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
            ((FileManagerEntity)localObject).strFileSHA = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSha");
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
          }
          try
          {
            ((FileManagerEntity)localObject).imgWidth = Integer.parseInt(str);
            label308:
            str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
            try
            {
              ((FileManagerEntity)localObject).imgHeight = Integer.parseInt(str);
              label326:
              a(paramQQAppInterface, (FileManagerEntity)localObject);
              paramQQAppInterface.a().a((FileManagerEntity)localObject);
              if (a(paramChatMessage)) {
                paramQQAppInterface.a().a((FileManagerEntity)localObject);
              }
              return localObject;
              label356:
              ((FileManagerEntity)localObject).nOpType = 1;
              continue;
              ((FileManagerEntity)localObject).bSend = true;
              break label240;
              label372:
              ((FileManagerEntity)localObject).setCloudType(1);
            }
            catch (NumberFormatException localNumberFormatException1)
            {
              break label326;
            }
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            break label308;
          }
        }
      }
    }
  }
  
  public static FileManagerEntity a(QQAppInterface paramQQAppInterface, MessageForFile paramMessageForFile)
  {
    FileManagerEntity localFileManagerEntity = paramQQAppInterface.a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
    Object localObject = localFileManagerEntity;
    if (localFileManagerEntity == null)
    {
      localFileManagerEntity = paramQQAppInterface.a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (QLog.isColorLevel()) {
        QLog.d("FileManager", 2, "QueryFileEntityByuniseq return null, create new! sessionId[" + String.valueOf(localFileManagerEntity.nSessionId) + "], messageId[" + String.valueOf(localFileManagerEntity.uniseq) + "], peerUin[" + e(localFileManagerEntity.peerUin) + "], peerType[" + String.valueOf(localFileManagerEntity.peerType) + "]");
      }
      localObject = paramQQAppInterface.getEntityManagerFactory().createEntityManager();
      TransFileInfo localTransFileInfo = (TransFileInfo)((awgf)localObject).a(TransFileInfo.class, new String[] { String.valueOf(paramMessageForFile.time), String.valueOf(paramMessageForFile.msgseq), paramQQAppInterface.getCurrentAccountUin(), paramMessageForFile.frienduin });
      ((awgf)localObject).a();
      localFileManagerEntity.status = b(paramMessageForFile.status);
      if (!paramMessageForFile.isSend()) {
        break label442;
      }
      localFileManagerEntity.setCloudType(3);
      if (!TextUtils.isEmpty(paramMessageForFile.url)) {
        break label430;
      }
      localFileManagerEntity.status = 16;
      if (localTransFileInfo != null)
      {
        if (localTransFileInfo.uuid == null) {
          break label492;
        }
        localObject = new String(localTransFileInfo.uuid);
        label277:
        localFileManagerEntity.Uuid = ((String)localObject);
      }
      localFileManagerEntity.fileName = paramMessageForFile.fileName;
      localFileManagerEntity.fileSize = paramMessageForFile.fileSize;
      if (!paramMessageForFile.isSend()) {
        break label499;
      }
    }
    label430:
    label442:
    label492:
    label499:
    for (int i = 0;; i = 1)
    {
      localFileManagerEntity.nOpType = i;
      localFileManagerEntity.peerUin = paramMessageForFile.frienduin;
      localFileManagerEntity.peerType = paramMessageForFile.istroop;
      localFileManagerEntity.peerNick = a(paramQQAppInterface, String.valueOf(paramMessageForFile.frienduin), null, paramMessageForFile.istroop);
      localFileManagerEntity.srvTime = (paramMessageForFile.time * 1000L);
      localFileManagerEntity.strServerPath = paramMessageForFile.urlAtServer;
      localFileManagerEntity.fProgress = ((float)paramQQAppInterface.a().a(paramMessageForFile.frienduin, paramMessageForFile.fileSize, paramMessageForFile.uniseq, paramMessageForFile.istroop) / 100.0F);
      paramQQAppInterface.a().d(localFileManagerEntity);
      localFileManagerEntity.bDelInFM = true;
      localObject = localFileManagerEntity;
      return localObject;
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localFileManagerEntity.setCloudType(1);
      localFileManagerEntity.lastTime = (paramMessageForFile.time * 1000L + 604800000L);
      if (localFileManagerEntity.status != 1) {
        break;
      }
      localFileManagerEntity.setCloudType(3);
      localFileManagerEntity.setFilePath(paramMessageForFile.url);
      break;
      localObject = "";
      break label277;
    }
  }
  
  public static FileManagerEntity a(DataLineMsgRecord paramDataLineMsgRecord)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramDataLineMsgRecord.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramDataLineMsgRecord.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity1 = new FileManagerEntity();
      localFileManagerEntity1.nSessionId = a().longValue();
      paramDataLineMsgRecord.entityID = localFileManagerEntity1.nSessionId;
      localFileManagerEntity1.datalineEntitySessionId = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2 = localFileManagerEntity1;
      if (paramDataLineMsgRecord.nOpType == 31)
      {
        localFileManagerEntity1.strTroopFilePath = paramDataLineMsgRecord.fileUuid;
        localFileManagerEntity2 = localFileManagerEntity1;
      }
    }
    localFileManagerEntity2.setCloudType(6);
    localFileManagerEntity2.bSend = paramDataLineMsgRecord.isSendFromLocal();
    if (paramDataLineMsgRecord.fileMsgStatus == 0L) {
      if (!paramDataLineMsgRecord.issuc)
      {
        localFileManagerEntity2.status = 0;
        if (paramDataLineMsgRecord.nOpType == 1) {
          localFileManagerEntity2.bSend = false;
        }
        localFileManagerEntity2.fileName = paramDataLineMsgRecord.filename;
        if (!TextUtils.isEmpty(paramDataLineMsgRecord.path)) {
          localFileManagerEntity2.setFilePath(paramDataLineMsgRecord.path);
        }
        localFileManagerEntity2.Uuid = paramDataLineMsgRecord.serverPath;
        if ((localFileManagerEntity2.Uuid == null) && ((paramDataLineMsgRecord.nOpType == 31) || (paramDataLineMsgRecord.nOpType == 29))) {
          localFileManagerEntity2.Uuid = paramDataLineMsgRecord.fileUuid;
        }
        if (1 != DataLineMsgRecord.getDevTypeBySeId(paramDataLineMsgRecord.sessionid)) {
          break label582;
        }
        localFileManagerEntity2.peerType = 6003;
        localFileManagerEntity2.peerUin = alof.A;
        label234:
        localFileManagerEntity2.fileSize = paramDataLineMsgRecord.filesize;
        localFileManagerEntity2.strFileMd5 = bdhe.a(paramDataLineMsgRecord.md5);
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.filename);
        if (localFileManagerEntity2.nFileType != 0) {
          break label599;
        }
        localFileManagerEntity2.strThumbPath = paramDataLineMsgRecord.thumbPath;
        localFileManagerEntity2.strLargeThumPath = paramDataLineMsgRecord.thumbPath;
      }
    }
    for (;;)
    {
      if (paramDataLineMsgRecord.strMoloKey != null)
      {
        localFileManagerEntity2.nFileType = a(paramDataLineMsgRecord.path);
        localFileManagerEntity2.isFromrMolo = true;
      }
      localFileManagerEntity2.fProgress = paramDataLineMsgRecord.progress;
      if ((localFileManagerEntity2.fProgress == 1.0D) && ((localFileManagerEntity2.status == 3) || (localFileManagerEntity2.status == -1))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      if ((paramDataLineMsgRecord.nOpType == 1) && (Float.compare(paramDataLineMsgRecord.progress, 1.0F) == 0) && ((TextUtils.isEmpty(paramDataLineMsgRecord.path)) || (!new VFSFile(paramDataLineMsgRecord.path).exists()))) {
        localFileManagerEntity2.fProgress = 0.0F;
      }
      localFileManagerEntity2.uniseq = paramDataLineMsgRecord.sessionid;
      localFileManagerEntity2.nOpType = paramDataLineMsgRecord.nOpType;
      localFileManagerEntity2.srvTime = (paramDataLineMsgRecord.time * 1000L);
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramDataLineMsgRecord.filename + "] by dataline size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramDataLineMsgRecord.progress != 1.0F)
      {
        localFileManagerEntity2.status = 2;
        break;
      }
      localFileManagerEntity2.status = 1;
      break;
      if (paramDataLineMsgRecord.fileMsgStatus == 2L)
      {
        if (paramDataLineMsgRecord.progress == 0.0F)
        {
          localFileManagerEntity2.status = 0;
          break;
        }
        localFileManagerEntity2.status = 3;
        break;
      }
      localFileManagerEntity2.status = -1;
      break;
      label582:
      localFileManagerEntity2.peerType = 6000;
      localFileManagerEntity2.peerUin = alof.z;
      break label234;
      label599:
      if ((localFileManagerEntity2.nFileType == -1) && (paramDataLineMsgRecord.msgtype == -2000)) {
        localFileManagerEntity2.nFileType = 0;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceFile paramMessageForDeviceFile)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceFile.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceFile.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceFile.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceFile.isSendFromLocal();
    localFileManagerEntity2.nOpType = 1;
    if (localFileManagerEntity2.bSend) {
      localFileManagerEntity2.nOpType = 0;
    }
    if ((paramMessageForDeviceFile.nFileStatus == 3) || (paramMessageForDeviceFile.nFileStatus == 1) || (paramMessageForDeviceFile.nFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.fileName = a(paramMessageForDeviceFile.filePath);
      if (!TextUtils.isEmpty(paramMessageForDeviceFile.filePath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceFile.filePath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceFile.fileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceFile.filePath);
      if ((localFileManagerEntity2.nFileType == -1) && (paramMessageForDeviceFile.strServiceName.equals(zxz.jdField_d_of_type_JavaLangString))) {
        localFileManagerEntity2.nFileType = 0;
      }
      localFileManagerEntity2.fProgress = paramMessageForDeviceFile.progress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceFile.uSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceFile.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceFile.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceFile.uniseq;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity2.nSessionId + "] fileName[" + paramMessageForDeviceFile.srcFileName + "] by devices size(" + localFileManagerEntity2.imgHeight + ":" + localFileManagerEntity2.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceFile.nFileStatus == 4) {
        localFileManagerEntity2.status = 3;
      } else if (paramMessageForDeviceFile.nFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceFile.nFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      } else if (paramMessageForDeviceFile.nFileStatus == -1) {
        localFileManagerEntity2.status = -1;
      }
    }
  }
  
  public static FileManagerEntity a(MessageForDeviceSingleStruct paramMessageForDeviceSingleStruct)
  {
    FileManagerEntity localFileManagerEntity1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (paramMessageForDeviceSingleStruct.entityID != 0L) {
      localFileManagerEntity1 = localQQAppInterface.a().a(paramMessageForDeviceSingleStruct.entityID);
    }
    FileManagerEntity localFileManagerEntity2 = localFileManagerEntity1;
    if (localFileManagerEntity1 == null)
    {
      localFileManagerEntity2 = new FileManagerEntity();
      localFileManagerEntity2.nSessionId = a().longValue();
      paramMessageForDeviceSingleStruct.entityID = localFileManagerEntity2.nSessionId;
    }
    localFileManagerEntity2.setCloudType(8);
    localFileManagerEntity2.bSend = paramMessageForDeviceSingleStruct.isSendFromLocal();
    localFileManagerEntity2.nOpType = 0;
    if ((paramMessageForDeviceSingleStruct.nMediaFileStatus == 3) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 1) || (paramMessageForDeviceSingleStruct.nMediaFileStatus == 2)) {
      localFileManagerEntity2.status = 2;
    }
    for (;;)
    {
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.uniseq;
      localFileManagerEntity2.fileName = paramMessageForDeviceSingleStruct.strMediaFileName;
      localFileManagerEntity2.strThumbPath = paramMessageForDeviceSingleStruct.strCoverPath;
      localFileManagerEntity2.strLargeThumPath = paramMessageForDeviceSingleStruct.strCoverPath;
      if (!TextUtils.isEmpty(paramMessageForDeviceSingleStruct.strMediaPath)) {
        localFileManagerEntity2.setFilePath(paramMessageForDeviceSingleStruct.strMediaPath);
      }
      localFileManagerEntity2.fileSize = paramMessageForDeviceSingleStruct.nMediaFileSize;
      localFileManagerEntity2.nFileType = a(paramMessageForDeviceSingleStruct.strMediaFileName);
      localFileManagerEntity2.fProgress = paramMessageForDeviceSingleStruct.nMediaProgress;
      localFileManagerEntity2.uniseq = paramMessageForDeviceSingleStruct.nMediaSessionID;
      localFileManagerEntity2.peerUin = paramMessageForDeviceSingleStruct.frienduin;
      localFileManagerEntity2.peerType = paramMessageForDeviceSingleStruct.istroop;
      localFileManagerEntity2.msgSeq = paramMessageForDeviceSingleStruct.uniseq;
      localQQAppInterface.a().d(localFileManagerEntity2);
      return localFileManagerEntity2;
      if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 5) {
        localFileManagerEntity2.status = 1;
      } else if (paramMessageForDeviceSingleStruct.nMediaFileStatus == 6) {
        localFileManagerEntity2.status = 0;
      }
    }
  }
  
  public static FileManagerEntity a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(6);
    localFileManagerEntity.bSend = paramPrinterItemMsgRecord.isSendFromLocal();
    localFileManagerEntity.status = 1;
    localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename;
    localFileManagerEntity.setFilePath(paramPrinterItemMsgRecord.filename);
    localFileManagerEntity.nOpType = 0;
    if (localFileManagerEntity.bSend) {
      localFileManagerEntity.nOpType = 0;
    }
    int i = paramPrinterItemMsgRecord.filename.lastIndexOf("/");
    if (i >= 0) {}
    for (localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename.substring(i + 1);; localFileManagerEntity.fileName = paramPrinterItemMsgRecord.filename)
    {
      VFSFile localVFSFile = new VFSFile(localFileManagerEntity.getFilePath());
      if (localVFSFile.exists()) {
        localFileManagerEntity.fileSize = localVFSFile.length();
      }
      localFileManagerEntity.nFileType = a(paramPrinterItemMsgRecord.filename);
      localFileManagerEntity.fProgress = 1.0F;
      localFileManagerEntity.uniseq = paramPrinterItemMsgRecord.uSessionID;
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramPrinterItemMsgRecord.filename + "] by print size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(FileInfo paramFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.setCloudType(3);
    localFileManagerEntity.fileName = paramFileInfo.d();
    localFileManagerEntity.setFilePath(paramFileInfo.c());
    localFileManagerEntity.fileSize = paramFileInfo.a();
    if (paramFileInfo.a() == 5) {}
    for (localFileManagerEntity.nFileType = 5;; localFileManagerEntity.nFileType = a(paramFileInfo.d()))
    {
      localFileManagerEntity.status = -1;
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramFileInfo.d() + "]by local size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
      localQQAppInterface.a().d(localFileManagerEntity);
      return localFileManagerEntity;
    }
  }
  
  public static FileManagerEntity a(OfflineFileInfo paramOfflineFileInfo, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.Uuid = paramOfflineFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity.setCloudType(1);
    localFileManagerEntity.strThumbPath = paramOfflineFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity.peerUin = String.valueOf(paramOfflineFileInfo.jdField_a_of_type_Long);
    localFileManagerEntity.peerNick = a(localQQAppInterface, localFileManagerEntity.peerUin, null, paramInt);
    localFileManagerEntity.peerType = paramInt;
    localFileManagerEntity.fileName = paramOfflineFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity.fileSize = paramOfflineFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity.nFileType = a(paramOfflineFileInfo.jdField_b_of_type_JavaLangString);
    localFileManagerEntity.lastTime = paramOfflineFileInfo.jdField_c_of_type_Long;
    localFileManagerEntity.status = -1;
    localFileManagerEntity.srvTime = paramOfflineFileInfo.jdField_d_of_type_Long;
    localFileManagerEntity.bSend = paramOfflineFileInfo.jdField_a_of_type_Boolean;
    if ((localFileManagerEntity.Uuid == null) || (localFileManagerEntity.Uuid.length() == 0)) {
      localFileManagerEntity.nWeiYunSrcType = -1;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity.nSessionId + "] fileName[" + paramOfflineFileInfo.jdField_b_of_type_JavaLangString + "] by offlinefile size(" + localFileManagerEntity.imgHeight + ":" + localFileManagerEntity.imgWidth + ")");
    localQQAppInterface.a().d(localFileManagerEntity);
    return localFileManagerEntity;
  }
  
  public static FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity1 = new FileManagerEntity();
    localFileManagerEntity1.nSessionId = a().longValue();
    localFileManagerEntity1.WeiYunFileId = paramWeiYunFileInfo.jdField_a_of_type_JavaLangString;
    localFileManagerEntity1.fileName = paramWeiYunFileInfo.jdField_c_of_type_JavaLangString;
    localFileManagerEntity1.fileSize = paramWeiYunFileInfo.jdField_a_of_type_Long;
    localFileManagerEntity1.nFileType = a(paramWeiYunFileInfo.jdField_c_of_type_JavaLangString);
    localFileManagerEntity1.strThumbPath = paramWeiYunFileInfo.h;
    localFileManagerEntity1.setCloudType(2);
    localFileManagerEntity1.nWeiYunSrcType = paramWeiYunFileInfo.jdField_a_of_type_Int;
    if (localFileManagerEntity1.nWeiYunSrcType == 2) {
      localFileManagerEntity1.strLargeThumPath = paramWeiYunFileInfo.jdField_e_of_type_JavaLangString;
    }
    localFileManagerEntity1.lastTime = paramWeiYunFileInfo.jdField_b_of_type_Long;
    localFileManagerEntity1.bSend = false;
    localFileManagerEntity1.status = -1;
    localFileManagerEntity1.srvTime = (ayzl.a() * 1000L);
    localFileManagerEntity1.strFileMd5 = paramWeiYunFileInfo.i;
    localFileManagerEntity1.WeiYunDirKey = paramWeiYunFileInfo.jdField_b_of_type_JavaLangString;
    localFileManagerEntity1.strFileSHA = paramWeiYunFileInfo.j;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity2 = localQQAppInterface.a().d(paramWeiYunFileInfo.jdField_a_of_type_JavaLangString);
    if (localFileManagerEntity2 != null)
    {
      localFileManagerEntity1.imgWidth = localFileManagerEntity2.imgWidth;
      localFileManagerEntity1.imgHeight = localFileManagerEntity2.imgHeight;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + localFileManagerEntity1.nSessionId + "] fileName[" + paramWeiYunFileInfo.jdField_c_of_type_JavaLangString + "] by WeiYun size(" + localFileManagerEntity1.imgHeight + ":" + localFileManagerEntity1.imgWidth + ")");
    localQQAppInterface.a().d(localFileManagerEntity1);
    return localFileManagerEntity1;
  }
  
  public static Long a()
  {
    return Long.valueOf((int)(System.currentTimeMillis() / 1000L) << 32 | Math.abs(new Random().nextInt()));
  }
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 1360
    //   6: astore_2
    //   7: aload_2
    //   8: astore_3
    //   9: invokestatic 1588	java/lang/Thread:getAllStackTraces	()Ljava/util/Map;
    //   12: invokestatic 1592	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   15: invokeinterface 1595 2 0
    //   20: checkcast 1597	[Ljava/lang/StackTraceElement;
    //   23: astore 4
    //   25: aload_2
    //   26: astore_3
    //   27: aload 4
    //   29: arraylength
    //   30: istore_1
    //   31: iconst_0
    //   32: istore_0
    //   33: iload_0
    //   34: iload_1
    //   35: if_icmpge +69 -> 104
    //   38: aload 4
    //   40: iload_0
    //   41: aaload
    //   42: astore 5
    //   44: aload_2
    //   45: astore_3
    //   46: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   49: ifeq +17 -> 66
    //   52: aload_2
    //   53: astore_3
    //   54: ldc_w 1599
    //   57: iconst_1
    //   58: aload 5
    //   60: invokevirtual 1602	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   63: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_2
    //   67: astore_3
    //   68: new 165	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   75: aload_2
    //   76: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 5
    //   81: invokevirtual 1602	java/lang/StackTraceElement:toString	()Ljava/lang/String;
    //   84: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc_w 1604
    //   90: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_2
    //   97: iload_0
    //   98: iconst_1
    //   99: iadd
    //   100: istore_0
    //   101: goto -68 -> 33
    //   104: ldc 2
    //   106: monitorexit
    //   107: aload_2
    //   108: areturn
    //   109: astore_2
    //   110: ldc 2
    //   112: monitorexit
    //   113: aload_2
    //   114: athrow
    //   115: astore_2
    //   116: aload_3
    //   117: astore_2
    //   118: goto -14 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	69	0	i	int
    //   30	6	1	j	int
    //   6	102	2	str1	String
    //   109	5	2	localObject1	Object
    //   115	1	2	localException	Exception
    //   117	1	2	localObject2	Object
    //   8	109	3	str2	String
    //   23	16	4	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   42	38	5	localStackTraceElement	java.lang.StackTraceElement
    // Exception table:
    //   from	to	target	type
    //   9	25	109	finally
    //   27	31	109	finally
    //   46	52	109	finally
    //   54	66	109	finally
    //   68	97	109	finally
    //   9	25	115	java/lang/Exception
    //   27	31	115	java/lang/Exception
    //   46	52	115	java/lang/Exception
    //   54	66	115	java/lang/Exception
    //   68	97	115	java/lang/Exception
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    case 8: 
    default: 
      return alud.a(2131704921);
    case 1: 
      return alud.a(2131704915);
    case 0: 
      return alud.a(2131704931);
    case 2: 
      return alud.a(2131704937);
    case 3: 
    case 6: 
    case 7: 
    case 9: 
      return alud.a(2131704924);
    }
    return alud.a(2131704945);
  }
  
  public static String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return String.valueOf(0);
    case 3: 
      return String.valueOf(1);
    case 1: 
      if (paramInt2 == 0) {
        return String.valueOf(2);
      }
      return String.valueOf(4);
    case 0: 
      return String.valueOf(7);
    }
    return String.valueOf(3);
  }
  
  public static String a(long paramLong, int paramInt)
  {
    long l2 = 604800000L;
    long l1 = l2;
    switch (paramInt)
    {
    }
    for (l1 = l2;; l1 = 2592000000L)
    {
      Date localDate1 = new Date(l1 + paramLong);
      Date localDate2 = new Date(ayzl.a() * 1000L);
      paramInt = (int)((localDate1.getTime() - localDate2.getTime()) / 86400000L);
      if (paramInt >= 0) {
        break;
      }
      return alud.a(2131704917);
    }
    if (paramInt == 0) {
      return alud.a(2131704923);
    }
    return paramInt + alud.a(2131704920);
  }
  
  public static String a(TextView paramTextView, int paramInt, String paramString1, String paramString2)
  {
    int j = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    float f = localTextPaint.measureText(paramString1);
    if (f < j) {}
    while (f <= paramInt * j - 50) {
      return paramString2;
    }
    int i = 0;
    for (;;)
    {
      int k = paramString2.length() - i - 1;
      if (k < 1) {}
      for (;;)
      {
        return paramString1;
        paramTextView = paramString2.substring(0, k) + jdField_a_of_type_JavaLangString;
        paramString1 = paramString1.replace(paramString2, paramTextView);
        if (localTextPaint.measureText(paramString1) >= paramInt * j - 50) {
          break;
        }
        paramString1 = paramTextView;
      }
      i += 1;
      paramString2 = paramTextView;
    }
  }
  
  public static String a(TextView paramTextView, String paramString)
  {
    int m = paramTextView.getWidth();
    StringBuilder localStringBuilder = new StringBuilder();
    paramTextView = paramTextView.getPaint();
    if (paramTextView.measureText(paramString) < m) {
      return paramString;
    }
    int j = 0;
    int i = 1;
    while (i < paramString.length())
    {
      int k = i + 1;
      i = k;
      if (paramTextView.measureText(paramString, j, k) >= m - 30)
      {
        localStringBuilder.append(paramString, j, k);
        localStringBuilder.append('\n');
        j = k;
        i = k;
      }
    }
    localStringBuilder.append(paramString, j, i);
    return localStringBuilder.toString();
  }
  
  public static String a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage)
  {
    paramQQAppInterface = paramQQAppInterface.a().a(paramMessage.uniseq, paramMessage.frienduin, paramMessage.istroop);
    if (paramQQAppInterface == null) {
      return null;
    }
    if (paramQQAppInterface.nFileType == -1) {
      paramQQAppInterface.nFileType = a(paramQQAppInterface.getFilePath());
    }
    paramMessage = a(paramQQAppInterface.nFileType);
    return "[" + paramMessage + "]" + paramQQAppInterface.fileName;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, DataLineMsgRecord paramDataLineMsgRecord)
  {
    if (paramDataLineMsgRecord == null) {
      return null;
    }
    paramQQAppInterface = a(a(paramDataLineMsgRecord.path));
    return "[" + paramQQAppInterface + "]" + paramDataLineMsgRecord.filename;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    if (alof.z.equalsIgnoreCase(paramString1)) {
      return alud.a(2131694654);
    }
    if (alof.A.equalsIgnoreCase(paramString1)) {
      return "我的iPad";
    }
    if (alof.v.equalsIgnoreCase(paramString1)) {
      return "";
    }
    return bdgc.b(paramQQAppInterface, paramString1, paramInt);
  }
  
  public static String a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      paramChatMessage = "";
    }
    String str1;
    String str2;
    do
    {
      return paramChatMessage;
      str1 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_750_");
      str2 = paramChatMessage.getExtInfoFromExtStr("_f_thumb_path_384_");
      if (TextUtils.isEmpty(str1)) {
        break;
      }
      paramChatMessage = str1;
    } while (bdhb.b(str1));
    if ((!TextUtils.isEmpty(str1)) && (bdhb.b(str2))) {
      return str2;
    }
    return "";
  }
  
  public static String a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      paramFileManagerEntity = "";
    }
    for (;;)
    {
      return paramFileManagerEntity;
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FileManagerEntity info, ");
        localStringBuilder.append("], nSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nSessionId);
        localStringBuilder.append("], fileName[");
        localStringBuilder.append(paramFileManagerEntity.fileName);
        localStringBuilder.append("], cloudType[");
        localStringBuilder.append(paramFileManagerEntity.getCloudType());
        localStringBuilder.append("], uniseq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.uniseq));
        localStringBuilder.append("], nRelatedSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nRelatedSessionId);
        localStringBuilder.append("], bDelInAio[");
        localStringBuilder.append(paramFileManagerEntity.bDelInAio);
        localStringBuilder.append("], bDelInFM[");
        localStringBuilder.append(paramFileManagerEntity.bDelInFM);
        localStringBuilder.append("], fileSize[");
        localStringBuilder.append(paramFileManagerEntity.fileSize);
        localStringBuilder.append("], fProgress[");
        localStringBuilder.append(paramFileManagerEntity.fProgress);
        localStringBuilder.append("], lastTime[");
        localStringBuilder.append(paramFileManagerEntity.lastTime);
        localStringBuilder.append("], msgSeq[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgSeq));
        localStringBuilder.append("], msgUid[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgUid));
        localStringBuilder.append("], msgTime[");
        localStringBuilder.append(String.valueOf(paramFileManagerEntity.msgTime));
        localStringBuilder.append("], nFileType[");
        localStringBuilder.append(paramFileManagerEntity.nFileType);
        localStringBuilder.append("], nOpType[");
        localStringBuilder.append(paramFileManagerEntity.nOpType);
        localStringBuilder.append("], nWeiYunSrcType[");
        localStringBuilder.append(paramFileManagerEntity.nWeiYunSrcType);
        localStringBuilder.append("], peerNick[");
        localStringBuilder.append(paramFileManagerEntity.peerNick);
        localStringBuilder.append("], peerType[");
        localStringBuilder.append(paramFileManagerEntity.peerType);
        localStringBuilder.append("], peerUin[");
        localStringBuilder.append(e(paramFileManagerEntity.peerUin));
        localStringBuilder.append("], selfUin[");
        localStringBuilder.append(e(paramFileManagerEntity.selfUin));
        localStringBuilder.append("], srvTime[");
        localStringBuilder.append(paramFileManagerEntity.srvTime);
        localStringBuilder.append("], status[");
        localStringBuilder.append(paramFileManagerEntity.status);
        localStringBuilder.append("], strFilePath[");
        localStringBuilder.append(paramFileManagerEntity.getFilePath());
        localStringBuilder.append("], strServerPath[");
        localStringBuilder.append(paramFileManagerEntity.strServerPath);
        localStringBuilder.append("], strThumbPath[");
        localStringBuilder.append(paramFileManagerEntity.strThumbPath);
        localStringBuilder.append("], Uuid[");
        localStringBuilder.append(paramFileManagerEntity.Uuid);
        localStringBuilder.append("], WeiYunFileId[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunFileId);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], strFileMd5[");
        localStringBuilder.append(paramFileManagerEntity.strFileMd5);
        localStringBuilder.append("], strFileSHA[");
        localStringBuilder.append(paramFileManagerEntity.strFileSHA);
        localStringBuilder.append("], nOLfileSessionId[");
        localStringBuilder.append(paramFileManagerEntity.nOLfileSessionId);
        localStringBuilder.append("], WeiYunDirKey[");
        localStringBuilder.append(paramFileManagerEntity.WeiYunDirKey);
        localStringBuilder.append("], _status[");
        localStringBuilder.append(paramFileManagerEntity.getStatus());
        localStringBuilder.append("], bOnceSuccess[");
        localStringBuilder.append(paramFileManagerEntity.bOnceSuccess);
        localStringBuilder.append("], imgHeight[");
        localStringBuilder.append(paramFileManagerEntity.imgHeight);
        localStringBuilder.append("], imgWidth[");
        localStringBuilder.append(paramFileManagerEntity.imgWidth);
        localStringBuilder.append("]");
        paramFileManagerEntity = localStringBuilder.toString();
      }
      finally {}
    }
  }
  
  public static String a(ByteStringMicro paramByteStringMicro)
  {
    try
    {
      paramByteStringMicro = paramByteStringMicro.toByteArray();
      if (paramByteStringMicro == null) {
        return "";
      }
    }
    catch (Exception paramByteStringMicro)
    {
      paramByteStringMicro.printStackTrace();
      return "";
    }
    char[] arrayOfChar = "0123456789ABCDEF".toCharArray();
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramByteStringMicro.length)
    {
      int j = paramByteStringMicro[i];
      localStringBuffer.append(arrayOfChar[(j >>> 4 & 0xF)]);
      localStringBuffer.append(arrayOfChar[(j & 0xF)]);
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  public static String a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FMERROR", 1, "getFileName but strFilePath is null");
      }
      a();
      localObject = "";
      return localObject;
    }
    int k = paramString.length();
    int i = paramString.lastIndexOf('/');
    int j = paramString.lastIndexOf('\\');
    if (j > i) {
      i = j;
    }
    for (;;)
    {
      if (i < 0)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "filepath without / ?");
        }
        i = 0;
      }
      String str2;
      String str1;
      for (;;)
      {
        str2 = paramString.substring(i, k);
        if ((QLog.isColorLevel()) && (str2 != null) && (str2.startsWith("."))) {
          QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
        }
        for (str1 = str2; (str1 != null) && (str1.startsWith(".")); str1 = str1.replaceFirst(".", "")) {}
        i += 1;
      }
      localObject = str1;
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      localObject = "InvaildName";
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("FileManagerUtil<FileAssistant>", 2, "InvaildName ,filePath[" + paramString + "], subName[" + str2 + "]");
      return "InvaildName";
    }
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramString.getBytes().length < paramInt)) {
      return "";
    }
    int j = paramInt / 2;
    int i = paramInt / 4;
    char[] arrayOfChar = paramString.toCharArray();
    StringBuilder localStringBuilder1 = new StringBuilder();
    paramInt = 0;
    if (paramInt < arrayOfChar.length)
    {
      localStringBuilder1.append(arrayOfChar[paramInt]);
      if (localStringBuilder1.toString().getBytes().length <= j) {}
    }
    else
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      j = arrayOfChar.length;
      paramInt = arrayOfChar.length - 1;
      label94:
      if (paramInt <= 0) {
        break label168;
      }
      localStringBuilder2.append(arrayOfChar[paramInt]);
      if (localStringBuilder2.toString().getBytes().length <= i) {
        break label161;
      }
    }
    for (;;)
    {
      return localStringBuilder1.toString() + jdField_a_of_type_JavaLangString + paramString.substring(paramInt);
      paramInt += 1;
      break;
      label161:
      paramInt -= 1;
      break label94;
      label168:
      paramInt = j - 1;
    }
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString)) {}
    Object localObject1;
    int i;
    Object localObject2;
    do
    {
      return null;
      localObject1 = new VFSFile(arqx.a().d());
      if (!((VFSFile)localObject1).exists()) {
        ((VFSFile)localObject1).mkdirs();
      }
      localObject1 = arqx.a().d() + a(paramString) + ".JPG";
      if (arso.b((String)localObject1)) {
        return localObject1;
      }
      i = a(paramString);
      if (i != 0) {
        break label280;
      }
      localObject2 = Looper.getMainLooper();
      if (Thread.currentThread() == ((Looper)localObject2).getThread()) {
        break;
      }
      localObject2 = fa.a(paramString, paramInt1, paramInt2);
    } while (localObject2 == null);
    for (;;)
    {
      try
      {
        arso.a((Bitmap)localObject2, (String)localObject1);
        ((Bitmap)localObject2).recycle();
        fa.a((String)localObject1, fa.a(paramString));
        return localObject1;
      }
      catch (FileNotFoundException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail FileNotFoundException:" + paramString.getMessage());
        return null;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + paramString.getMessage());
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + paramString.getMessage());
        return null;
      }
      arsd.a().execute(new FileManagerUtil.10((String)localObject1, paramString, paramInt1, paramInt2));
      continue;
      label280:
      if (i != 2) {
        break;
      }
      a(paramString, true, paramInt1, paramInt2, 3, new arrs((String)localObject1, paramString));
    }
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return "";
    }
    return paramString1 + paramString2;
  }
  
  public static String a(String paramString, boolean paramBoolean, int paramInt1, TextPaint paramTextPaint, int paramInt2)
  {
    Object localObject;
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null) || (paramInt1 <= 0))
    {
      localObject = "";
      return localObject;
    }
    int j;
    char[] arrayOfChar;
    int k;
    label54:
    int n;
    int m;
    if (paramInt2 > 1)
    {
      j = paramInt2;
      arrayOfChar = paramString.toCharArray();
      localObject = new StringBuilder();
      i = 0;
      k = 0;
      if (i >= arrayOfChar.length) {
        break label399;
      }
      ((StringBuilder)localObject).append(arrayOfChar[i]);
      n = i;
      m = k;
      if (paramTextPaint.measureText(((StringBuilder)localObject).toString()) <= paramInt1) {
        break label273;
      }
      n = i - 1;
      i = k + 1;
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      m = i;
      if (i < j) {
        break label273;
      }
    }
    label393:
    label399:
    for (int i = 1;; i = 0)
    {
      localObject = paramString;
      if (i == 0) {
        break;
      }
      if (paramBoolean)
      {
        j = 6;
        label150:
        if (paramString.length() >= j) {
          break label293;
        }
        localObject = paramString;
        label162:
        StringBuilder localStringBuilder = new StringBuilder((String)localObject);
        m = 0;
        k = 0;
        i = 0;
        label182:
        if (m >= arrayOfChar.length - j) {
          break label393;
        }
        localStringBuilder.append(arrayOfChar[m]);
        if (paramTextPaint.measureText(localStringBuilder.toString()) <= paramInt1 * paramInt2) {
          break label313;
        }
      }
      for (paramInt1 = m - 2;; paramInt1 = i)
      {
        if (paramInt1 > 0) {}
        for (;;)
        {
          if (k != 0) {
            break label368;
          }
          return paramString.substring(0, paramInt1) + jdField_a_of_type_JavaLangString + (String)localObject;
          j = 1;
          break;
          label273:
          i = n + 1;
          k = m;
          break label54;
          j = 15;
          break label150;
          label293:
          localObject = paramString.substring(paramString.length() - j, paramString.length());
          break label162;
          label313:
          if (paramString.substring(m, m + 1).equals(jdField_a_of_type_JavaLangString)) {
            k = 1;
          }
          if (m == arrayOfChar.length - j - 1) {
            i = m - 2;
          }
          m += 1;
          break label182;
          paramInt1 = 0;
        }
        label368:
        return paramString.substring(0, paramInt1) + (String)localObject;
      }
    }
  }
  
  public static String a(Map paramMap)
  {
    try
    {
      paramMap = new JSONObject(paramMap).toString();
      return paramMap;
    }
    catch (Exception paramMap) {}
    return null;
  }
  
  public static ArrayList<FileInfo> a(boolean paramBoolean, int paramInt)
  {
    int i = 0;
    Object localObject2 = new VFSFile(b()).listFiles();
    if (localObject2 == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject3;
    Object localObject1;
    if (i < localObject2.length)
    {
      FileInfo localFileInfo = localObject2[i];
      localObject3 = localFileInfo.getPath();
      if ((!paramBoolean) && (localFileInfo.getName().startsWith("."))) {}
      for (;;)
      {
        i += 1;
        break;
        try
        {
          localFileInfo = new FileInfo((String)localObject3);
          if (localFileInfo != null) {
            localArrayList.add(localFileInfo);
          }
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (;;)
          {
            localFileNotFoundException.printStackTrace();
            localObject1 = null;
          }
        }
      }
    }
    try
    {
      localObject1 = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() > 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Map.Entry)((Iterator)localObject1).next()).getKey();
          if (arso.a((String)localObject2))
          {
            localObject2 = new VFSFile((String)localObject2);
            localObject3 = new FileInfo();
            ((FileInfo)localObject3).d(((VFSFile)localObject2).getName());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).isDirectory());
            ((FileInfo)localObject3).e(((VFSFile)localObject2).getPath());
            ((FileInfo)localObject3).a(((VFSFile)localObject2).length());
            ((FileInfo)localObject3).b(((VFSFile)localObject2).lastModified());
            localArrayList.add(localObject3);
          }
        }
      }
      if (paramInt != 0) {
        break label290;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    Collections.sort(localArrayList, new arsp());
    for (;;)
    {
      return localArrayList;
      label290:
      Collections.sort(localArrayList, new arro());
    }
  }
  
  public static HashMap<String, String> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    if ((paramString != null) && (paramString.length > 0))
    {
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split("_");
        if ((arrayOfString != null) && (arrayOfString.length == 2) && (!TextUtils.isEmpty(arrayOfString[0])) && (!TextUtils.isEmpty(arrayOfString[1]))) {
          localHashMap.put(arrayOfString[0], arrayOfString[1]);
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static LinkedHashMap a(String paramString)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
      }
      return localLinkedHashMap;
    }
    Object localObject = paramString.replace("\"", "");
    paramString = (String)localObject;
    if (((String)localObject).startsWith("{")) {
      paramString = ((String)localObject).substring(1);
    }
    localObject = paramString;
    if (paramString.endsWith("}")) {
      localObject = paramString.substring(0, paramString.length() - 1);
    }
    paramString = ((String)localObject).split(",");
    int i = 0;
    if (i < paramString.length)
    {
      localObject = paramString[i].split(":");
      if (localObject.length == 1) {
        localLinkedHashMap.put(localObject[0].toLowerCase(), "");
      }
      for (;;)
      {
        i += 1;
        break;
        localLinkedHashMap.put(localObject[0].toLowerCase(), localObject[1]);
      }
    }
    return localLinkedHashMap;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      return paramList;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramList.next();
      if (a(localMessageRecord)) {
        localArrayList.add(a((ChatMessage)localMessageRecord));
      } else {
        localArrayList.add(localMessageRecord);
      }
    }
    return localArrayList;
  }
  
  /* Error */
  @TargetApi(9)
  public static Map<String, File> a(Context paramContext)
  {
    // Byte code:
    //   0: new 129	java/util/HashMap
    //   3: dup
    //   4: bipush 10
    //   6: invokespecial 2004	java/util/HashMap:<init>	(I)V
    //   9: astore 4
    //   11: aload 4
    //   13: ldc_w 2006
    //   16: invokestatic 2012	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   19: invokeinterface 2013 3 0
    //   24: pop
    //   25: aload_0
    //   26: ldc_w 2015
    //   29: invokevirtual 2016	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   32: checkcast 2018	android/os/storage/StorageManager
    //   35: astore 5
    //   37: aload 5
    //   39: invokevirtual 2022	java/lang/Object:getClass	()Ljava/lang/Class;
    //   42: ldc_w 2024
    //   45: aconst_null
    //   46: invokevirtual 2030	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   49: aload 5
    //   51: aconst_null
    //   52: invokevirtual 2036	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: checkcast 2038	[Ljava/lang/String;
    //   58: checkcast 2038	[Ljava/lang/String;
    //   61: astore 5
    //   63: aload 5
    //   65: arraylength
    //   66: istore_3
    //   67: iconst_0
    //   68: istore_1
    //   69: iload_1
    //   70: iload_3
    //   71: if_icmpge +166 -> 237
    //   74: aload 5
    //   76: iload_1
    //   77: aaload
    //   78: astore 6
    //   80: new 2040	java/io/File
    //   83: dup
    //   84: aload 6
    //   86: invokespecial 2041	java/io/File:<init>	(Ljava/lang/String;)V
    //   89: astore 7
    //   91: getstatic 135	android/os/Build$VERSION:SDK_INT	I
    //   94: bipush 9
    //   96: if_icmple +357 -> 453
    //   99: aload 7
    //   101: invokevirtual 2044	java/io/File:getUsableSpace	()J
    //   104: lconst_0
    //   105: lcmp
    //   106: ifgt +6 -> 112
    //   109: goto +344 -> 453
    //   112: aload 4
    //   114: invokeinterface 2046 1 0
    //   119: ifne +64 -> 183
    //   122: aload 4
    //   124: invokeinterface 2049 1 0
    //   129: invokeinterface 1028 1 0
    //   134: astore 8
    //   136: aload 8
    //   138: invokeinterface 1017 1 0
    //   143: ifeq +305 -> 448
    //   146: aload 4
    //   148: aload 8
    //   150: invokeinterface 1021 1 0
    //   155: checkcast 20	java/lang/String
    //   158: invokeinterface 1595 2 0
    //   163: checkcast 2040	java/io/File
    //   166: invokevirtual 2050	java/io/File:getPath	()Ljava/lang/String;
    //   169: aload 6
    //   171: invokevirtual 1671	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   174: iconst_1
    //   175: if_icmpne -39 -> 136
    //   178: iconst_1
    //   179: istore_2
    //   180: goto +280 -> 460
    //   183: ldc_w 376
    //   186: iconst_1
    //   187: new 165	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 2052
    //   197: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 7
    //   202: invokevirtual 2050	java/io/File:getPath	()Ljava/lang/String;
    //   205: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: aload 4
    //   216: ldc_w 2054
    //   219: aload 7
    //   221: invokeinterface 2013 3 0
    //   226: pop
    //   227: goto +226 -> 453
    //   230: astore 5
    //   232: aload 5
    //   234: invokevirtual 2055	java/lang/IllegalArgumentException:printStackTrace	()V
    //   237: aload 4
    //   239: ldc_w 2054
    //   242: invokeinterface 2056 2 0
    //   247: ifne +111 -> 358
    //   250: aload_0
    //   251: aconst_null
    //   252: invokevirtual 2060	android/content/Context:getExternalFilesDir	(Ljava/lang/String;)Ljava/io/File;
    //   255: astore_0
    //   256: aload_0
    //   257: ifnull +144 -> 401
    //   260: ldc_w 376
    //   263: iconst_1
    //   264: new 165	java/lang/StringBuilder
    //   267: dup
    //   268: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   271: ldc_w 2062
    //   274: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_0
    //   278: invokevirtual 2050	java/io/File:getPath	()Ljava/lang/String;
    //   281: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   290: aload_0
    //   291: invokevirtual 2065	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   294: aload 4
    //   296: ldc_w 2006
    //   299: invokeinterface 1595 2 0
    //   304: checkcast 2040	java/io/File
    //   307: invokevirtual 2065	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   310: invokevirtual 467	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   313: ifne +45 -> 358
    //   316: ldc_w 376
    //   319: iconst_1
    //   320: new 165	java/lang/StringBuilder
    //   323: dup
    //   324: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   327: ldc_w 2067
    //   330: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 2050	java/io/File:getPath	()Ljava/lang/String;
    //   337: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: aload 4
    //   348: ldc_w 2054
    //   351: aload_0
    //   352: invokeinterface 2013 3 0
    //   357: pop
    //   358: aload 4
    //   360: areturn
    //   361: astore 5
    //   363: aload 5
    //   365: invokevirtual 2068	java/lang/IllegalAccessException:printStackTrace	()V
    //   368: goto -131 -> 237
    //   371: astore 5
    //   373: aload 5
    //   375: invokevirtual 2069	java/lang/reflect/InvocationTargetException:printStackTrace	()V
    //   378: goto -141 -> 237
    //   381: astore 5
    //   383: aload 5
    //   385: invokevirtual 2070	java/lang/NoSuchMethodException:printStackTrace	()V
    //   388: goto -151 -> 237
    //   391: astore 5
    //   393: aload 5
    //   395: invokevirtual 790	java/lang/Exception:printStackTrace	()V
    //   398: goto -161 -> 237
    //   401: ldc_w 376
    //   404: iconst_1
    //   405: ldc_w 2072
    //   408: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload 4
    //   413: areturn
    //   414: astore_0
    //   415: ldc_w 376
    //   418: iconst_1
    //   419: new 165	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   426: ldc_w 2074
    //   429: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_0
    //   433: invokevirtual 476	java/lang/Exception:toString	()Ljava/lang/String;
    //   436: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload 4
    //   447: areturn
    //   448: iconst_0
    //   449: istore_2
    //   450: goto +10 -> 460
    //   453: iload_1
    //   454: iconst_1
    //   455: iadd
    //   456: istore_1
    //   457: goto -388 -> 69
    //   460: iload_2
    //   461: iconst_1
    //   462: if_icmpeq -9 -> 453
    //   465: goto -282 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	paramContext	Context
    //   68	389	1	i	int
    //   179	284	2	j	int
    //   66	6	3	k	int
    //   9	437	4	localHashMap	HashMap
    //   35	40	5	localObject	Object
    //   230	3	5	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   361	3	5	localIllegalAccessException	java.lang.IllegalAccessException
    //   371	3	5	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   381	3	5	localNoSuchMethodException	java.lang.NoSuchMethodException
    //   391	3	5	localException	Exception
    //   78	92	6	str	String
    //   89	131	7	localFile	File
    //   134	15	8	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   11	67	230	java/lang/IllegalArgumentException
    //   80	109	230	java/lang/IllegalArgumentException
    //   112	136	230	java/lang/IllegalArgumentException
    //   136	178	230	java/lang/IllegalArgumentException
    //   183	227	230	java/lang/IllegalArgumentException
    //   11	67	361	java/lang/IllegalAccessException
    //   80	109	361	java/lang/IllegalAccessException
    //   112	136	361	java/lang/IllegalAccessException
    //   136	178	361	java/lang/IllegalAccessException
    //   183	227	361	java/lang/IllegalAccessException
    //   11	67	371	java/lang/reflect/InvocationTargetException
    //   80	109	371	java/lang/reflect/InvocationTargetException
    //   112	136	371	java/lang/reflect/InvocationTargetException
    //   136	178	371	java/lang/reflect/InvocationTargetException
    //   183	227	371	java/lang/reflect/InvocationTargetException
    //   11	67	381	java/lang/NoSuchMethodException
    //   80	109	381	java/lang/NoSuchMethodException
    //   112	136	381	java/lang/NoSuchMethodException
    //   136	178	381	java/lang/NoSuchMethodException
    //   183	227	381	java/lang/NoSuchMethodException
    //   11	67	391	java/lang/Exception
    //   80	109	391	java/lang/Exception
    //   112	136	391	java/lang/Exception
    //   136	178	391	java/lang/Exception
    //   183	227	391	java/lang/Exception
    //   250	256	414	java/lang/Exception
    //   260	358	414	java/lang/Exception
    //   401	411	414	java/lang/Exception
  }
  
  public static void a()
  {
    ThreadManager.post(new FileManagerUtil.3(), 8, null, false);
  }
  
  private static void a(int paramInt, String paramString, FileManagerEntity paramFileManagerEntity)
  {
    if (a(paramInt, paramFileManagerEntity.fileName)) {
      return;
    }
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(d(paramFileManagerEntity.fileName) + BaseApplicationImpl.getContext().getString(2131692913));
  }
  
  public static void a(long paramLong)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = ((QQAppInterface)localObject).a().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      return;
      switch (localFileManagerEntity.nOpType)
      {
      case -1: 
      case 0: 
      case 3: 
      case 7: 
      case 2: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 17: 
      case 18: 
      case 19: 
      default: 
        return;
      case 1: 
      case 5: 
      case 8: 
        localObject = d(localFileManagerEntity.fileName);
        arri.c((String)localObject + BaseApplicationImpl.getContext().getString(2131692527) + arqx.a().b());
        return;
      }
      if (localFileManagerEntity.nOpType == 6)
      {
        if (BaseActivity.sTopActivity != null)
        {
          bkjy.a((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
          return;
        }
        arri.c(BaseApplicationImpl.getContext().getString(2131697816));
        return;
      }
    } while (!bkjc.a(0));
    if (BaseActivity.sTopActivity != null)
    {
      bkjy.a((QQAppInterface)localObject, BaseActivity.sTopActivity, BaseActivity.sTopActivity.getTitleBarHeight());
      return;
    }
    arri.c(BaseApplicationImpl.getContext().getString(2131697816));
  }
  
  public static void a(long paramLong, int paramInt, String paramString)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    FileManagerEntity localFileManagerEntity = localQQAppInterface.a().a(paramLong);
    if (localFileManagerEntity == null) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                switch (localFileManagerEntity.nOpType)
                {
                case -1: 
                case 2: 
                case 10: 
                case 11: 
                case 12: 
                case 13: 
                case 14: 
                case 15: 
                case 16: 
                case 17: 
                case 18: 
                case 19: 
                default: 
                  return;
                }
              } while (a(paramInt, localFileManagerEntity.fileName));
              if ((paramString == null) || (paramString.length() <= 0)) {
                break;
              }
              a(paramString);
              return;
              if ((paramString != null) && (paramString.length() > 0))
              {
                a(paramString);
                return;
              }
            } while (a(paramInt, localFileManagerEntity.fileName));
            a(13, localFileManagerEntity.fileName);
            return;
            if (localFileManagerEntity.nOpType != 4) {
              break;
            }
          } while (!bkjc.a(paramInt));
          if (bkjc.b())
          {
            bkjc.a(localQQAppInterface);
            return;
          }
          a(paramInt, paramString, localFileManagerEntity);
          return;
          a(paramInt, paramString, localFileManagerEntity);
          return;
        } while (!bkjc.a(paramInt));
        if (bkjc.b())
        {
          bkjc.a(localQQAppInterface);
          return;
        }
      } while (a(paramInt, localFileManagerEntity.fileName));
      if ((paramString != null) && (paramString.length() > 0))
      {
        a(paramString);
        return;
      }
      a(11, localFileManagerEntity.fileName);
      return;
    } while (a(paramInt, localFileManagerEntity.fileName));
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(11, localFileManagerEntity.fileName);
    return;
    if ((paramString != null) && (paramString.length() > 0))
    {
      a(paramString);
      return;
    }
    a(13, localFileManagerEntity.fileName);
    return;
    a(13, localFileManagerEntity.fileName);
    return;
    a(paramInt, null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    if ((paramString == null) || (!arso.a(paramString)))
    {
      arri.a(2131692941);
      return;
    }
    if (a(paramString) == 5)
    {
      b(paramActivity, paramString);
      return;
    }
    arrp.a("0X8007152");
    WeakReference localWeakReference = new WeakReference(paramActivity);
    Bundle localBundle = new Bundle();
    localBundle.putString("ChannelId", "biz_src_jc_file");
    QbSdk.openFileReaderListWithQBDownload(paramActivity, paramString, localBundle, new arrz(localWeakReference, paramActivity));
  }
  
  public static void a(Activity paramActivity, String paramString, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("selectMode", true);
    localIntent.putExtra("targetUin", paramString);
    localIntent.putExtra("busiType", 1);
    localIntent.putExtra("sendprepare", paramInt1);
    localIntent.putExtra("apautocreate", paramBoolean);
    localIntent.putExtra("enterfrom", paramInt2);
    localIntent.putExtra("tab_tab_type", 5);
    localIntent.putExtra("qlinkselect", true);
    localIntent.putExtra("qfile_entrance_type_key", 20);
    paramActivity.startActivityForResult(localIntent, 106);
    paramActivity.overridePendingTransition(2130771979, 2130771980);
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    bisq.a(paramActivity, 1, paramString1);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramActivity.getApplicationContext(), FMActivity.class);
    localIntent.putExtra("tab_tab_type", 6);
    localIntent.putExtra("from_qlink", paramBoolean);
    paramActivity.startActivityForResult(localIntent, 108);
    paramActivity.overridePendingTransition(2130771992, 2130771993);
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "[QFILE] QQ - startQFile failed context=null!");
      }
      Toast.makeText(BaseApplication.getContext(), alud.a(2131704944), 0).show();
      return;
    }
    Intent localIntent = new Intent(paramContext, FileAssistantActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("from", "FileAssistant");
    localIntent.putExtra("COMEFROMDESK", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    arqo.a(paramFileManagerEntity).a(paramBoolean, paramContext, new arry(paramFileManagerEntity, paramQQAppInterface));
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (!new VFSFile(paramString).exists())
    {
      arri.a(2131692959);
      return;
    }
    ThreadManager.post(new FileManagerUtil.2(paramContext, paramString), 8, null, true);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ShortcutManager localShortcutManager;
    if (Build.VERSION.SDK_INT >= 26)
    {
      localShortcutManager = (ShortcutManager)paramContext.getSystemService(ShortcutManager.class);
      if ((localShortcutManager != null) && (!a(paramString2, localShortcutManager))) {
        break label35;
      }
    }
    label35:
    while (!localShortcutManager.isRequestPinShortcutSupported()) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.LAUNCHER");
    localIntent.putExtra(paramString1, true);
    localIntent.setClassName(paramContext, JumpActivity.class.getName());
    localIntent.setFlags(337641472);
    String str = "my-shortcut";
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = str;
      if (paramString2.equals(paramContext.getString(2131694083))) {
        paramString1 = "my-dataline-shortcut";
      }
    }
    localShortcutManager.requestPinShortcut(new ShortcutInfo.Builder(paramContext, paramString1).setShortLabel(paramString2).setIcon(Icon.createWithResource(paramContext, paramInt)).setIntent(localIntent).build(), PendingIntent.getBroadcast(paramContext, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 134217728).getIntentSender());
  }
  
  public static void a(ImageView paramImageView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.nFileType == 13)
    {
      Drawable localDrawable = BaseApplication.getContext().getResources().getDrawable(2130843981);
      try
      {
        if (paramFileManagerEntity.strThumbPath == null)
        {
          paramImageView.setImageDrawable(localDrawable);
          return;
        }
        paramFileManagerEntity = new URL(paramFileManagerEntity.strThumbPath);
        if (paramFileManagerEntity == null)
        {
          paramImageView.setImageDrawable(localDrawable);
          return;
        }
      }
      catch (MalformedURLException paramFileManagerEntity)
      {
        paramImageView.setImageDrawable(localDrawable);
        return;
      }
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramFileManagerEntity, localDrawable, localDrawable));
      return;
    }
    paramFileManagerEntity = arso.a(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity == null)
    {
      paramImageView.setImageResource(2130843981);
      return;
    }
    paramImageView.setImageResource(b(paramFileManagerEntity));
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = arso.a(paramString);
    if (paramString == null)
    {
      paramImageView.setImageResource(2130843981);
      return;
    }
    paramImageView.setImageResource(b(paramString));
  }
  
  public static void a(TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      paramTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  public static void a(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    if (paramTextView.getMeasuredWidth() == 0)
    {
      paramTextView.post(new FileManagerUtil.8(paramTextView, paramFileManagerEntity));
      return;
    }
    c(paramTextView, paramFileManagerEntity);
  }
  
  public static void a(com.dataline.util.widget.AsyncImageView paramAsyncImageView, DataLineMsgRecord paramDataLineMsgRecord)
  {
    String str3 = arso.a(paramDataLineMsgRecord.filename);
    if (str3 == null)
    {
      paramAsyncImageView.setImageResource(2130843981);
      label20:
      return;
    }
    String str2 = paramDataLineMsgRecord.filename;
    String str1 = str2;
    if (a(str3) == 0)
    {
      if (!bdhb.b(paramDataLineMsgRecord.thumbPath)) {
        break label100;
      }
      str1 = paramDataLineMsgRecord.thumbPath;
    }
    for (;;)
    {
      paramAsyncImageView.setDefaultImage(b(str3));
      switch (a(str3))
      {
      default: 
        int i = b(str3);
        if (i == 0) {
          break label20;
        }
        paramAsyncImageView.setImageResource(i);
        return;
        label100:
        str1 = str2;
        if (bdhb.b(paramDataLineMsgRecord.path)) {
          str1 = paramDataLineMsgRecord.path;
        }
        break;
      }
    }
    paramAsyncImageView.setAsyncClipSize(128, 128);
    paramAsyncImageView.setAsyncImage(str1);
  }
  
  public static void a(BaseActivity paramBaseActivity, TextView paramTextView)
  {
    if ((paramTextView != null) && (jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseActivity.getResources().getDrawable(2130839223);
      paramTextView.setCompoundDrawablesWithIntrinsicBounds(jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong)
  {
    int k = arbp.a();
    if (k == 0) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
      }
    }
    FileManagerEntity localFileManagerEntity;
    long l;
    do
    {
      String str;
      int i;
      SharedPreferences.Editor localEditor;
      do
      {
        do
        {
          SharedPreferences localSharedPreferences;
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  str = "showTime_" + paramQQAppInterface.getCurrentAccountUin();
                  localFileManagerEntity = paramQQAppInterface.a().b(paramLong);
                  if (localFileManagerEntity != null) {
                    break;
                  }
                } while (!QLog.isColorLevel());
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
                return;
                int j = a(localFileManagerEntity.fileName);
                if (j != -1)
                {
                  i = j;
                  if (j != 11) {}
                }
                else
                {
                  i = a(localFileManagerEntity.getFilePath());
                }
                if ((i == 3) || (i == 6)) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
              return;
              if ((localFileManagerEntity.peerType == 0) || (localFileManagerEntity.peerType == 3000)) {
                break;
              }
            } while (!QLog.isColorLevel());
            QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "aio[" + localFileManagerEntity.peerType + "] not buddy or disc, return!");
            return;
            localSharedPreferences = paramQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
            localEditor = localSharedPreferences.edit();
            i = localSharedPreferences.getInt("AIOshowTime_Total", 0);
            if (i < k) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
          return;
          paramLong = localSharedPreferences.getLong(str, 0L);
          l = ayzl.a();
          if (l - paramLong >= 86400000L) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
        return;
        if (!bdiv.a(paramQQAppInterface.getApp().getBaseContext(), "com.tencent.tim")) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
      return;
      new Handler(ThreadManager.getSubThreadLooper()).postDelayed(new FileManagerUtil.16(paramQQAppInterface, localFileManagerEntity), 1000L);
      localEditor.putLong(str, l);
      localEditor.putInt("AIOshowTime_Total", i + 1);
      localEditor.commit();
    } while (!QLog.isColorLevel());
    QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "lastShowTime[" + l + "],[" + e(localFileManagerEntity.peerUin) + "]add new aiograyTips!");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramLong4, paramLong5, paramInt, paramString6, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, long paramLong4, long paramLong5, int paramInt, String paramString6, Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    if (paramLong2 < 0L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str1 = str2;
      if (paramString2 != null) {
        str1 = str2;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        paramString2 = str1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          float f;
          continue;
          int i = 0;
          continue;
          long l2 = 0L;
          continue;
          long l1 = paramLong2;
        }
      }
      j = arsx.a();
      localHashMap.put("serverip", String.valueOf(paramString2));
      localHashMap.put("param_Server", String.valueOf(paramString2));
      localHashMap.put("param_ftnIP", String.valueOf(paramString2));
      localHashMap.put("param_PeerUin", paramString3);
      localHashMap.put("param_uuid", paramString4);
      localHashMap.put("param_MD5", paramString5);
      localHashMap.put("param_fsized", String.valueOf(paramLong4));
      localHashMap.put("param_fsizeo", String.valueOf(paramLong5));
      localHashMap.put("param_retry", String.valueOf(paramInt));
      localHashMap.put("param_nSessionId", String.valueOf(paramLong1));
      localHashMap.put("param_errMsg", String.valueOf(paramString6));
      localHashMap.put("param_ipStackType", String.valueOf(j));
      localHashMap.put("param_realTransferType", String.valueOf(0));
      if (paramBundle != null)
      {
        l1 = paramBundle.getLong("param_transferTime", -1L);
        if (l1 >= 0L) {
          if ((l1 > 0L) && (paramLong3 >= 1024L))
          {
            f = (float)l1 / 1000.0F;
            l2 = ((float)paramLong3 / f);
            localHashMap.put("param_speed", String.valueOf(l2));
            if (paramBundle != null)
            {
              i = paramBundle.getInt("param_fromType", 0);
              localHashMap.put("param_fromType", String.valueOf(i));
              azri.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, true, paramLong2, paramLong3, localHashMap, paramString6);
              if (QLog.isColorLevel()) {
                QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(true) + "], nSessionId[" + String.valueOf(paramLong1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong3) + "], transfSize[" + String.valueOf(paramLong4) + "], fileSize[" + String.valueOf(paramLong5) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString6) + "], ipStackType[" + String.valueOf(j) + "] realTransferType[" + String.valueOf(0) + "] speed[" + String.valueOf(l2) + "] fromType[" + String.valueOf(i) + "] transferTime[" + String.valueOf(l1) + "]");
              }
              return;
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10)
  {
    a(paramQQAppInterface, paramLong1, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5, paramLong3, paramString6, paramLong4, paramLong5, paramLong6, paramString7, paramString8, paramInt, paramString9, paramString10, new Bundle());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5, long paramLong3, String paramString6, long paramLong4, long paramLong5, long paramLong6, String paramString7, String paramString8, int paramInt, String paramString9, String paramString10, Bundle paramBundle)
  {
    long l1 = paramLong2;
    if (paramLong2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    if (l1 < 1L) {
      paramLong2 = 0L;
    }
    for (;;)
    {
      String str3 = "";
      String str1 = str3;
      if (paramString2 != null) {
        str1 = str3;
      }
      try
      {
        if (paramString2.length() > 0) {
          str1 = paramString2.substring(paramString2.indexOf("://") + 3, paramString2.lastIndexOf(":"));
        }
        if (paramLong2 < 0L)
        {
          paramLong2 = 0L;
          int j = 0;
          i = j;
          if (paramString9 != null)
          {
            i = j;
            if (paramString9.length() > 0)
            {
              if (paramString9.indexOf("Network is unreachable") <= 0) {
                break label901;
              }
              i = 1;
            }
          }
          for (;;)
          {
            if (bdin.d(BaseApplication.getContext()))
            {
              paramString2 = paramString9;
              if (i == 0) {}
            }
            else
            {
              paramLong3 = 9004L;
              paramString2 = paramString9 + "_NotNetWork";
            }
            paramString9 = paramString2;
            if (!paramQQAppInterface.isLogin())
            {
              paramLong3 = 9004L;
              paramString9 = paramString2 + "_NotLogin";
            }
            j = arsx.a();
            paramString2 = new HashMap();
            paramString2.put("serverip", String.valueOf(str1));
            paramString2.put("param_Server", String.valueOf(str1));
            paramString2.put("param_ftnIP", String.valueOf(str1));
            paramString2.put("param_PeerUin", String.valueOf(paramString3));
            paramString2.put("param_uuid", String.valueOf(paramString4));
            paramString2.put("param_MD5", paramString5);
            paramString2.put("param_FailCode", Long.toString(paramLong3));
            paramString2.put("param_errorDesc", String.valueOf(paramString6));
            paramString2.put("param_fsized", String.valueOf(paramLong5));
            paramString2.put("param_fsizeo", String.valueOf(paramLong6));
            paramString2.put("param_url", String.valueOf(paramString7));
            paramString2.put("param_rspHeader", String.valueOf(paramString8));
            paramString2.put("param_retry", String.valueOf(paramInt));
            paramString2.put("param_errMsg", String.valueOf(paramString9 + "uin[" + paramQQAppInterface.getCurrentAccountUin() + "]"));
            paramString2.put("param_nSessionId", String.valueOf(paramLong1));
            paramString2.put("param_ipStackType", String.valueOf(j));
            paramString2.put("param_realTransferType", String.valueOf(0));
            if (paramBundle == null) {
              break label960;
            }
            l2 = paramBundle.getLong("param_transferTime", -1L);
            if (l2 < 0L) {
              break label960;
            }
            if ((l2 <= 0L) || (paramLong4 < 1024L)) {
              break label954;
            }
            float f = (float)l2 / 1000.0F;
            l3 = ((float)paramLong4 / f);
            paramString2.put("param_speed", String.valueOf(l3));
            if (paramBundle == null) {
              break label948;
            }
            i = paramBundle.getInt("param_fromType", 0);
            paramString2.put("param_fromType", String.valueOf(i));
            azri.a(BaseApplication.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, false, paramLong2, paramLong4, paramString2, paramString10);
            if (QLog.isColorLevel()) {
              QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + paramString1 + "], isSuccess[" + String.valueOf(false) + "], nSessionId[" + String.valueOf(paramLong1) + "], param_FailCode[" + String.valueOf(paramLong3) + "], startTime[" + String.valueOf(l1) + "], duration[" + String.valueOf(paramLong2) + "], rpSize[" + String.valueOf(paramLong4) + "], transfSize[" + String.valueOf(paramLong5) + "], fileSize[" + String.valueOf(paramLong6) + "], param_errorDesc[" + String.valueOf(paramString6) + "], retryTimes[" + String.valueOf(paramInt) + "], reserved[" + String.valueOf(paramString10) + "], ipStackType[" + String.valueOf(j) + "] realTransferType[" + String.valueOf(0) + "] speed[" + String.valueOf(l3) + "], errMsg[" + String.valueOf(paramString9) + "] fromType[" + String.valueOf(i) + "] transferTime[" + String.valueOf(l2) + "]");
            }
            return;
            paramLong2 = System.currentTimeMillis() - l1;
            break;
            label901:
            if (paramString9.indexOf("No route to host") > 0)
            {
              i = 1;
            }
            else
            {
              i = j;
              if (paramString9.indexOf("MalformedURLException") > 0) {
                i = 1;
              }
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          String str2 = paramString2;
          continue;
          label948:
          int i = 0;
          continue;
          label954:
          long l3 = 0L;
          continue;
          label960:
          long l2 = paramLong2;
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), paramContext);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    if (!paramFileManagerEntity.bSend)
    {
      paramQQAppInterface = new arsa();
      bdgm.a(paramContext, 230, paramContext.getString(2131698673), paramContext.getString(2131698672), 2131721503, 2131694953, paramQQAppInterface, null).show();
      return;
    }
    paramQQAppInterface = paramContext.getString(2131692524);
    paramFileManagerEntity = paramContext.getString(2131692523);
    bhuf localbhuf = (bhuf)bhus.a(paramContext, null);
    localbhuf.c(paramQQAppInterface);
    localbhuf.d(paramContext.getString(2131690648));
    localbhuf.a(paramFileManagerEntity);
    localbhuf.a(new arsb(localbhuf));
    localbhuf.show();
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.18(paramContext, paramInt, paramString1, paramQQAppInterface, paramString2), 2, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    if (paramChatMessage == null) {}
    while (!(paramChatMessage instanceof MessageForFile)) {
      return;
    }
    arsx.a(paramQQAppInterface, paramContext, a(paramQQAppInterface, (MessageForFile)paramChatMessage));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    label315:
    label317:
    label328:
    label472:
    do
    {
      do
      {
        int j;
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                alto localalto = (alto)paramQQAppInterface.getManager(51);
                Object localObject = paramFileManagerEntity.peerUin;
                if (paramFileManagerEntity.peerType == 3000) {
                  localObject = paramFileManagerEntity.selfUin;
                }
                localObject = localalto.e((String)localObject);
                int i = -1;
                if (localObject != null) {
                  i = ((Friends)localObject).iTermType;
                }
                j = a(paramFileManagerEntity.fileName);
                if (j == 0) {
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] PicFile, from device[" + i + "] size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
                for (;;)
                {
                  if ((!arbp.a()) && (a())) {
                    break label315;
                  }
                  if (j != 0) {
                    break label472;
                  }
                  if (!arsj.b(paramFileManagerEntity)) {
                    break label328;
                  }
                  paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
                  return;
                  if (j != 2) {
                    break label317;
                  }
                  QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] VideoFile, from device[" + i + "] Preload VideoThumb size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
                }
              }
              QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
              return;
              paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 5);
              if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] Preload 384 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
              }
            } while (a());
            paramFileManagerEntity.strThumbPath = paramQQAppInterface.a().a(paramFileManagerEntity, 7);
          } while (!QLog.isColorLevel());
          QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + paramFileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + paramFileManagerEntity.strThumbPath + "]");
          return;
        } while (j != 2);
        if (paramFileManagerEntity.peerType != 3000) {
          break;
        }
        paramQQAppInterface = paramQQAppInterface.a().b(paramFileManagerEntity);
      } while (paramQQAppInterface == null);
      paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
      return;
      paramQQAppInterface = paramQQAppInterface.a().a(paramFileManagerEntity);
    } while (paramQQAppInterface == null);
    paramFileManagerEntity.strLargeThumPath = paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, long paramLong)
  {
    localFile = new File(paramQQAppInterface.getApplication().getFilesDir(), "FileOnlinePreviewConfigV2");
    for (;;)
    {
      try
      {
        if (!HttpDownloadUtil.a(paramQQAppInterface, paramString, localFile)) {
          continue;
        }
        paramString = new arsf();
      }
      catch (Exception paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
        return;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide download xml failed: " + paramString);
        continue;
      }
      finally
      {
        localFile.delete();
      }
      try
      {
        SAXParserFactory.newInstance().newSAXParser().parse(localFile, paramString);
        new arbp(paramQQAppInterface, paramString, paramLong);
        localFile.delete();
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FileManagerUtil<FileAssistant>", 2, "updateGuide with: " + QLog.getStackTraceString(paramQQAppInterface));
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, Context paramContext)
  {
    int i = azrh.a(paramContext, paramString, "Stop_download_2-1_3-1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Stop_download_2-1_3-0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "1", "0", null, null);
    }
    i = azrh.a(paramContext, paramString, "Stop_download_2-2_3-1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Stop_download_2-2_3-0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "2", "0", null, null);
    }
    i = azrh.a(paramContext, paramString, "Start_download_2-0_3-1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Start_download_2-0_3-0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "0", "0", null, null);
    }
    i = azrh.a(paramContext, paramString, "Start_download_2-3_3-1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Start_download_2-3_3-0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, i, 0, "3", "0", null, null);
    }
    i = azrh.a(paramContext, paramString, "Complete_download_2_1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Stop_download_2-0_3-1");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "1", null, null);
    }
    i = azrh.a(paramContext, paramString, "Complete_download_2_0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, i, 0, "0", null, null, null);
    }
    i = azrh.a(paramContext, paramString, "Stop_download_2-0_3-0");
    if (i > 0) {
      azqs.b(paramQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, i, 0, "0", "0", null, null);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ThreadManager.post(new FileManagerUtil.17(paramString2, paramQQAppInterface, paramInt, paramString1), 8, null, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, a());
      }
      return;
    }
    int i = (int)a(paramFileManagerEntity.peerType);
    QLog.i("FileManagerUtil<FileAssistant>", 2, "=_= Id[" + paramFileManagerEntity.nSessionId + "],setTempParam[" + i + "]");
    paramFileManagerEntity.tmpSessionType = i;
    paramFileManagerEntity.tmpSessionSig = a(paramQQAppInterface, paramFileManagerEntity.peerUin, i);
    switch (i)
    {
    case 103: 
    default: 
      return;
    case 102: 
      paramFileManagerEntity.tmpSessionFromPhone = paramString1;
      paramFileManagerEntity.tmpSessionToPhone = paramString2;
      return;
    }
    paramFileManagerEntity.tmpSessionRelatedUin = paramString1;
  }
  
  public static void a(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return;
    }
    Object localObject;
    if ((paramChatMessage instanceof MessageForFile))
    {
      localObject = (MessageForFile)paramChatMessage;
      ((MessageForFile)localObject).uniseq = 0L;
      ((MessageForFile)localObject).msgseq = 0L;
      ((MessageForFile)localObject).fileName = "";
      ((MessageForFile)localObject).fileSize = 0L;
    }
    for (;;)
    {
      paramChatMessage.extStr = null;
      return;
      if ((paramChatMessage instanceof MessageForTroopFile))
      {
        localObject = (MessageForTroopFile)paramChatMessage;
        ((MessageForTroopFile)localObject).uniseq = 0L;
        ((MessageForTroopFile)localObject).msgseq = 0L;
        ((MessageForTroopFile)localObject).url = "";
        ((MessageForTroopFile)localObject).uuid = "";
        ((MessageForTroopFile)localObject).bisID = 0;
        ((MessageForTroopFile)localObject).fileName = "";
        ((MessageForTroopFile)localObject).fileSize = 0L;
        ((MessageForTroopFile)localObject).width = 0;
        ((MessageForTroopFile)localObject).height = 0;
        ((MessageForTroopFile)localObject).duration = 0;
      }
    }
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForFile paramMessageForFile)
  {
    paramMessageForFile.uniseq = paramChatMessage.uniseq;
    paramMessageForFile.msgseq = paramChatMessage.msgseq;
    paramMessageForFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    String str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(ChatMessage paramChatMessage, MessageForTroopFile paramMessageForTroopFile)
  {
    paramMessageForTroopFile.uniseq = paramChatMessage.uniseq;
    paramMessageForTroopFile.msgseq = paramChatMessage.msgseq;
    paramMessageForTroopFile.url = paramChatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
    paramMessageForTroopFile.uuid = UUID.nameUUIDFromBytes(paramMessageForTroopFile.url.getBytes()).toString();
    String str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.bisID = Integer.parseInt(str1);
    }
    paramMessageForTroopFile.fileName = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardSize");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.fileSize = Long.parseLong(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth");
    String str2 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
    {
      paramMessageForTroopFile.width = Integer.parseInt(str1);
      paramMessageForTroopFile.height = Integer.parseInt(str2);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.duration = Integer.parseInt(str1);
    }
    str1 = paramChatMessage.getExtInfoFromExtStr("outest_uin");
    str2 = paramChatMessage.getExtInfoFromExtStr("outest_uintype");
    paramChatMessage = paramChatMessage.getExtInfoFromExtStr("outest_uniseq");
    if (!TextUtils.isEmpty(str1)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uin", str1);
    }
    if (!TextUtils.isEmpty(str2)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uintype", str2);
    }
    if (!TextUtils.isEmpty(paramChatMessage)) {
      paramMessageForTroopFile.saveExtInfoToExtStr("outest_uniseq", paramChatMessage);
    }
  }
  
  public static void a(BaseFileAssistantActivity paramBaseFileAssistantActivity)
  {
    Object localObject = a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 2, "none select!why you can preview!");
      }
      return;
    }
    ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
    localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
    localForwardFileInfo.d(3);
    localForwardFileInfo.b(10007);
    localObject = new Intent(paramBaseFileAssistantActivity, FileBrowserActivity.class);
    ((Intent)localObject).putExtra("FromEditBarPreview", true);
    ((Intent)localObject).putExtra("fileinfo", localForwardFileInfo);
    ((Intent)localObject).putExtra("from_qlink_enter_recent", paramBaseFileAssistantActivity.g());
    paramBaseFileAssistantActivity.startActivityForResult((Intent)localObject, 102);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      QLog.w("FileManagerUtil<FileAssistant>", 1, "entity null!");
    }
    String str;
    do
    {
      do
      {
        return;
        if (!paramFileManagerEntity.isCheckPrivateDir)
        {
          paramFileManagerEntity.isCheckPrivateDir = true;
          str = paramFileManagerEntity.getFilePath();
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.setFilePath(bdzf.a(paramFileManagerEntity.getFilePath()));
          }
          str = paramFileManagerEntity.strThumbPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strThumbPath = bdzf.a(paramFileManagerEntity.strThumbPath);
          }
          str = paramFileManagerEntity.strMiddleThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strMiddleThumPath = bdzf.a(paramFileManagerEntity.strMiddleThumPath);
          }
          str = paramFileManagerEntity.strLargeThumPath;
          if ((str != null) && (str.contains("/Tencent/QQfile_recv/"))) {
            paramFileManagerEntity.strLargeThumPath = bdzf.a(paramFileManagerEntity.strLargeThumPath);
          }
        }
      } while ((paramFileManagerEntity.nFileType != -1) && (paramFileManagerEntity.nFileType != 5));
      str = paramFileManagerEntity.getFilePath();
      if (str == null) {
        break;
      }
      paramFileManagerEntity.nFileType = a(str);
    } while (!str.startsWith(alof.aX + "/Android/data/com.tencent.mobileqq"));
    paramFileManagerEntity.setFilePath(bdzf.a(paramFileManagerEntity.getFilePath()));
    return;
    if ((paramFileManagerEntity.getCloudType() == 3) || (paramFileManagerEntity.getCloudType() == 5))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
      return;
    }
    if ((paramFileManagerEntity.strSrcName != null) && (paramFileManagerEntity.strSrcName.length() > 0))
    {
      paramFileManagerEntity.nFileType = a(paramFileManagerEntity.strSrcName);
      return;
    }
    paramFileManagerEntity.nFileType = a(paramFileManagerEntity.fileName);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.copyFrom(paramFileManagerEntity);
    localFileManagerEntity.nSessionId = a().longValue();
    localFileManagerEntity.status = 2;
    paramQQAppInterface.a().d(localFileManagerEntity);
    paramQQAppInterface = arzx.a(localFileManagerEntity);
    paramQQAppInterface.b(paramInt);
    paramFileManagerEntity = new Bundle();
    paramFileManagerEntity.putInt("forward_type", 0);
    paramFileManagerEntity.putParcelable("fileinfo", paramQQAppInterface);
    paramFileManagerEntity.putBoolean("not_forward", true);
    paramQQAppInterface = new Intent();
    paramQQAppInterface.putExtras(paramFileManagerEntity);
    paramQQAppInterface.putExtra("destroy_last_activity", true);
    paramQQAppInterface.putExtra("forward_type", 0);
    paramQQAppInterface.putExtra("forward_filepath", localFileManagerEntity.getFilePath());
    paramQQAppInterface.putExtra("forward_text", alud.a(2131704933) + d(localFileManagerEntity.fileName) + alud.a(2131704926) + arso.a(localFileManagerEntity.fileSize) + "。");
    paramQQAppInterface.putExtra("k_favorites", c(localFileManagerEntity));
    if (((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7)) && (localFileManagerEntity.nFileType == 0)) {
      paramQQAppInterface.putExtra("forward_type", 1);
    }
    aryv.a(paramActivity, paramQQAppInterface, 103);
  }
  
  public static void a(FileManagerEntity paramFileManagerEntity, QQAppInterface paramQQAppInterface, arsi paramarsi)
  {
    arsd.a().execute(new FileManagerUtil.21(paramFileManagerEntity, paramarsi, paramQQAppInterface));
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    String str = paramFileManagerEntity.getFilePath();
    if (paramFileManagerEntity.nFileType == 0) {
      if (bdhb.b(paramFileManagerEntity.strMiddleThumPath)) {
        str = paramFileManagerEntity.strMiddleThumPath;
      }
    }
    for (;;)
    {
      a(paramAsyncImageView, str, paramFileManagerEntity.nFileType);
      return;
      if (bdhb.b(paramFileManagerEntity.strLargeThumPath))
      {
        str = paramFileManagerEntity.strLargeThumPath;
      }
      else if (bdhb.b(paramFileManagerEntity.getFilePath()))
      {
        str = paramFileManagerEntity.getFilePath();
        ThreadManager.executeOnSubThread(new FileManagerUtil.1(paramFileManagerEntity));
        continue;
        if (paramFileManagerEntity.nFileType == 2)
        {
          if (bdhb.b(paramFileManagerEntity.strLargeThumPath)) {
            str = paramFileManagerEntity.strLargeThumPath;
          } else if (bdhb.b(paramFileManagerEntity.strMiddleThumPath)) {
            str = paramFileManagerEntity.strMiddleThumPath;
          } else {
            str = null;
          }
        }
        else if (paramFileManagerEntity.nFileType == 13) {
          str = baic.f(paramFileManagerEntity.Uuid);
        }
      }
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString)
  {
    int i = a(paramString);
    try
    {
      paramAsyncImageView.setImageResource(a(i));
      return;
    }
    catch (Exception paramAsyncImageView)
    {
      paramAsyncImageView.printStackTrace();
    }
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramAsyncImageView.setDefaultImage(a(paramInt));
    case 0: 
    case 5: 
    case 2: 
      do
      {
        do
        {
          return;
          paramAsyncImageView.setDefaultImage(2130843911);
          paramAsyncImageView.setAsyncImage(paramString);
          return;
          paramAsyncImageView.setDefaultImage(2130843875);
        } while (!arso.b(paramString));
        paramAsyncImageView.setApkIconAsyncImage(paramString);
        return;
        paramAsyncImageView.setDefaultImage(2130843982);
      } while (!arso.b(paramString));
      try
      {
        paramAsyncImageView.setAsyncImage(paramString);
        return;
      }
      catch (Exception paramAsyncImageView)
      {
        paramAsyncImageView.printStackTrace();
        return;
      }
    }
    paramAsyncImageView.setDefaultImage(2130843981);
    paramAsyncImageView.setUrlIconAsyncImage(paramString);
  }
  
  public static void a(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, String paramString, boolean paramBoolean)
  {
    String str = arso.a(paramString);
    if (str == null) {
      paramAsyncImageView.setImageResource(2130843981);
    }
    do
    {
      return;
      paramAsyncImageView.setImageResource(b(paramString));
    } while (!paramBoolean);
    switch (a(str))
    {
    case 1: 
    default: 
      return;
    case 0: 
      paramAsyncImageView.setDefaultImage(2130843911);
      paramAsyncImageView.setAsyncImage(paramString);
      return;
    }
    paramAsyncImageView.setDefaultImage(2130843982);
    paramAsyncImageView.setAsyncImage(paramString);
  }
  
  public static void a(String paramString)
  {
    arri.a(paramString);
  }
  
  public static void a(String paramString, int paramInt)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString = "qlink_new_count_" + paramString;
    localSharedPreferences.edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences localSharedPreferences = BaseApplication.getContext().getSharedPreferences("mobileQQ", 0);
    paramString1 = "qlink_new_flag_" + paramString1 + "_" + paramString2;
    localSharedPreferences.edit().putBoolean(paramString1, paramBoolean).commit();
  }
  
  @TargetApi(10)
  public static void a(String paramString, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, arse paramarse)
  {
    ThreadManager.post(new FileManagerUtil.12(paramString, paramInt3, paramBoolean, paramarse, paramInt1, paramInt2), 8, null, true);
  }
  
  public static void a(List<FileManagerEntity> paramList, Activity paramActivity)
  {
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      long l1 = 0L;
      do
      {
        l2 = l1;
        if (!paramList.hasNext()) {
          break;
        }
        localObject = (FileManagerEntity)paramList.next();
      } while (((FileManagerEntity)localObject).sendCloudUnsuccessful());
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10001);
      localForwardFileInfo.d(((FileManagerEntity)localObject).getCloudType());
      localForwardFileInfo.b(((FileManagerEntity)localObject).nSessionId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileName);
      localForwardFileInfo.c(((FileManagerEntity)localObject).uniseq);
      localForwardFileInfo.c(((FileManagerEntity)localObject).WeiYunFileId);
      localForwardFileInfo.d(((FileManagerEntity)localObject).fileSize);
      localForwardFileInfo.a(((FileManagerEntity)localObject).getFilePath());
      localForwardFileInfo.b(((FileManagerEntity)localObject).Uuid);
      localForwardFileInfo.jdField_a_of_type_Int = afcu.a().a();
      if ((((FileManagerEntity)localObject).getCloudType() == 3) && (((FileManagerEntity)localObject).getFilePath() != null) && (((FileManagerEntity)localObject).getFilePath().length() > 0)) {
        localArrayList2.add(Uri.parse(((FileManagerEntity)localObject).getFilePath()));
      }
      for (;;)
      {
        l2 = localForwardFileInfo.d();
        localArrayList1.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        localArrayList2.add(Uri.parse(""));
      }
    }
    long l2 = 0L;
    paramList = new Bundle();
    Object localObject = new Intent();
    paramList.putInt("forward_type", 0);
    paramList.putParcelableArrayList("fileinfo_array", localArrayList1);
    paramList.putBoolean("not_forward", true);
    ((Intent)localObject).putExtra("sendMultiple", true);
    paramList.putParcelableArrayList("android.intent.extra.STREAM", localArrayList2);
    ((Intent)localObject).putExtras(paramList);
    ((Intent)localObject).putExtra("foward_editbar", true);
    ((Intent)localObject).putExtra("forward_type", 0);
    paramList = alud.a(2131704947);
    if (localArrayList1.size() == 1) {
      paramList = alud.a(2131704928) + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + alud.a(2131704938) + arso.a(((ForwardFileInfo)localArrayList1.get(0)).d()) + "。";
    }
    for (;;)
    {
      ((Intent)localObject).putExtra("forward_text", paramList);
      ((Intent)localObject).putExtra("k_favorites", false);
      aryv.a(paramActivity, (Intent)localObject, 103);
      return;
      if (localArrayList1.size() > 1) {
        paramList = alud.a(2131704922) + d(((ForwardFileInfo)localArrayList1.get(0)).d()) + alud.a(2131704935) + localArrayList1.size() + alud.a(2131704939) + arso.a(l2) + "。";
      }
    }
  }
  
  public static void a(boolean paramBoolean, Context paramContext, arrh paramarrh)
  {
    a(paramBoolean, paramContext, paramarrh, -1);
  }
  
  public static void a(boolean paramBoolean, Context paramContext, arrh paramarrh, int paramInt)
  {
    int j = 2131692759;
    int k = 2;
    if (!bdin.e(BaseApplicationImpl.getContext())) {
      arri.a(2131693417);
    }
    Object localObject;
    int i;
    boolean bool1;
    label93:
    do
    {
      return;
      if (!a())
      {
        paramarrh.a();
        return;
      }
      localObject = (Activity)paramContext;
      if (!paramBoolean) {
        break;
      }
      i = 3;
      boolean bool2 = beaa.a((Activity)localObject, i, new arrw(paramarrh), "");
      bool1 = bool2;
      if (bool2)
      {
        localObject = (Activity)paramContext;
        if (!paramBoolean) {
          break label186;
        }
        i = k;
        bool1 = bezm.a((Activity)localObject, i, new arrx(paramarrh));
      }
    } while (!bool1);
    if ((paramInt == 0) && (aoul.c().a.jdField_a_of_type_Boolean) && (!beav.a().b()))
    {
      if (paramBoolean) {}
      for (paramInt = 2131692759;; paramInt = 2131692756)
      {
        localObject = paramContext.getString(paramInt);
        arre.a(paramContext, paramContext.getString(2131692754), aoul.c().a.a(paramContext, (CharSequence)localObject), paramarrh);
        return;
        i = 2;
        break;
        label186:
        i = 1;
        break label93;
      }
    }
    if (paramBoolean) {}
    for (paramInt = j;; paramInt = 2131692756)
    {
      arre.a(paramContext, 2131692754, paramInt, paramarrh);
      return;
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == arbq.jdField_a_of_type_Int;
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    boolean bool = true;
    switch (paramInt)
    {
    case 8: 
    case 14: 
    default: 
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + String.valueOf(paramInt));
      }
      bool = false;
    case 0: 
      return bool;
    case 1: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692941));
      return true;
    case 2: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 3: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692941));
      return true;
    case 4: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692941));
      return true;
    case 5: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 6: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 7: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 9: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 10: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 11: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    case 12: 
      if (QLog.isDevelopLevel()) {
        a();
      }
      arri.a(2131692966);
      return true;
    case 16: 
      arri.a(2131692932);
      return true;
    case 13: 
      arri.a(d(paramString) + BaseApplicationImpl.getContext().getString(2131692969));
      return true;
    }
    arri.a(2131694968);
    return true;
  }
  
  public static boolean a(long paramLong1, long paramLong2, TimeZone paramTimeZone)
  {
    long l = paramLong1 - paramLong2;
    return (l < 86400000L) && (l > -86400000L) && (a(paramLong1, paramTimeZone) == a(paramLong2, paramTimeZone));
  }
  
  public static boolean a(Context paramContext)
  {
    return (paramContext != null) && ((paramContext instanceof BaseFileAssistantActivity)) && (((BaseFileAssistantActivity)paramContext).h);
  }
  
  public static boolean a(Context paramContext, FileManagerEntity paramFileManagerEntity)
  {
    return (a(paramContext)) && ((paramFileManagerEntity.fileSize > a(((BaseFileAssistantActivity)paramContext).app, paramFileManagerEntity.fileName)) || (!a(paramFileManagerEntity.fileName, ((BaseFileAssistantActivity)paramContext).f)) || ((!arbs.a(paramFileManagerEntity)) && (arbs.b().size() != 0)));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return bdmh.a(paramContext, new String[] { paramString });
    }
    return a(paramString, (ShortcutManager)paramContext.getSystemService(ShortcutManager.class));
  }
  
  public static boolean a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = arbp.a(paramContext, paramString, "FileMaxSize");
    if (paramContext == null) {}
    while (Integer.parseInt(paramContext) * 1048576 < paramLong) {
      return false;
    }
    return true;
  }
  
  public static boolean a(arhz paramarhz)
  {
    int i = paramarhz.c();
    int j = paramarhz.d();
    String str = paramarhz.c();
    paramarhz = paramarhz.e();
    return (i == 3) && (j == 1) && ((!TextUtils.isEmpty(str)) || (!TextUtils.isEmpty(paramarhz)));
  }
  
  public static boolean a(VFSFile paramVFSFile1, VFSFile paramVFSFile2)
  {
    boolean bool1 = true;
    if (paramVFSFile2.exists()) {
      bool1 = paramVFSFile2.delete();
    }
    boolean bool2 = bool1;
    if (bool1) {
      bool2 = paramVFSFile1.renameTo(paramVFSFile2);
    }
    return bool2;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, arhz paramarhz)
  {
    paramQQAppInterface = arbp.a(paramQQAppInterface.getApplication().getBaseContext(), paramarhz.a(), "PreviewMode");
    int j = -1;
    int i = j;
    if (paramQQAppInterface != null)
    {
      i = j;
      if (paramQQAppInterface.length() > 0) {
        i = j;
      }
    }
    do
    {
      try
      {
        j = Integer.parseInt(paramQQAppInterface);
        i = j;
        int k = paramarhz.d();
        i = j;
        if (k == 16)
        {
          bool = false;
          return bool;
        }
      }
      catch (NumberFormatException paramQQAppInterface) {}
      boolean bool = a(i);
    } while (bdin.d(BaseApplicationImpl.getContext()));
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {}
    while ((TextUtils.isEmpty(paramChatMessage.senderuin)) || (!paramChatMessage.senderuin.equals(paramQQAppInterface.getCurrentAccountUin()))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext)
  {
    return a(paramQQAppInterface, paramChatMessage, paramContext, false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage, Context paramContext, boolean paramBoolean)
  {
    azqs.b(paramQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
    if (paramChatMessage == null) {
      return false;
    }
    if (!(paramChatMessage instanceof MessageForFile)) {
      return false;
    }
    MessageForFile localMessageForFile = (MessageForFile)paramChatMessage;
    FileManagerEntity localFileManagerEntity = a(paramQQAppInterface, localMessageForFile);
    switch (localFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      return false;
    case 1: 
      if (paramChatMessage.isSend()) {}
      for (paramChatMessage = paramQQAppInterface.getCurrentAccountUin();; paramChatMessage = localMessageForFile.frienduin)
      {
        if (!paramBoolean) {
          arri.d(paramContext.getString(2131692914));
        }
        paramQQAppInterface.a().a(localFileManagerEntity, paramChatMessage);
        paramQQAppInterface.a().c(localFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] No reInit,Show Juhua");
        }
        paramChatMessage = new arrq();
        paramChatMessage.jdField_b_of_type_JavaLangString = "file_to_weiyun";
        paramChatMessage.jdField_a_of_type_Int = 9;
        paramChatMessage.jdField_a_of_type_Long = localFileManagerEntity.fileSize;
        paramChatMessage.jdField_c_of_type_JavaLangString = arso.a(localFileManagerEntity.fileName);
        arrp.a(paramQQAppInterface.getCurrentAccountUin(), paramChatMessage);
        return true;
      }
    case 2: 
      return false;
    }
    if (!paramBoolean) {
      arri.d(paramContext.getString(2131692914));
    }
    bkjc.a();
    paramQQAppInterface.a().a(localFileManagerEntity.getFilePath(), null, paramQQAppInterface.getAccount(), 0, false);
    paramQQAppInterface.a().c(localFileManagerEntity);
    if (QLog.isColorLevel()) {
      QLog.i("@-@", 1, "mEntity[" + String.valueOf(localFileManagerEntity.nSessionId) + "]'s relateId[" + String.valueOf(localFileManagerEntity.nRelatedSessionId) + "] reInit");
    }
    return true;
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if ((paramChatMessage == null) || (!arsx.a(paramChatMessage))) {}
    do
    {
      return false;
      paramChatMessage = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    } while ((!TextUtils.isEmpty(paramChatMessage)) && (Integer.parseInt(paramChatMessage) != 1));
    return true;
  }
  
  public static boolean a(ChatMessage paramChatMessage, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramChatMessage == null) || (!paramChatMessage.isMultiMsg)) {
      return false;
    }
    String str = paramChatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 4))
    {
      QQToast.a(paramContext, 2131692763, 0).a();
      return false;
    }
    paramChatMessage = aupn.a(paramQQAppInterface, paramChatMessage);
    if ((paramChatMessage != null) && (paramChatMessage.extraflag == 32768))
    {
      QQToast.a(paramContext, 2131692762, 0).a();
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForFile)) {}
    while ((paramMessageRecord instanceof MessageForTroopFile)) {
      return true;
    }
    return false;
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    long l2 = 604800000L;
    if (paramFileManagerEntity == null) {
      return false;
    }
    long l3 = paramFileManagerEntity.srvTime;
    long l1 = l2;
    switch (paramFileManagerEntity.peerType)
    {
    }
    for (l1 = l2; l1 + l3 <= ayzl.a() * 1000L; l1 = 2592000000L) {
      return true;
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return Pattern.compile("[一-龥]").matcher(paramString).find();
  }
  
  @RequiresApi(api=25)
  public static boolean a(String paramString, ShortcutManager paramShortcutManager)
  {
    if (paramShortcutManager == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramShortcutManager = paramShortcutManager.getPinnedShortcuts().iterator();
      do
      {
        if (!paramShortcutManager.hasNext()) {
          break;
        }
      } while (!paramString.equals(((ShortcutInfo)paramShortcutManager.next()).getShortLabel()));
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        return false;
      } while ((paramString2 == null) || (TextUtils.isEmpty(paramString2)));
      paramString1 = arso.a(paramString1);
    } while ((paramString1 == null) || (paramString1.length() == 0) || (paramString2.indexOf(paramString1.toLowerCase()) < 0));
    return true;
  }
  
  public static boolean a(boolean paramBoolean, ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return false;
    }
    paramArrayList = paramArrayList.iterator();
    for (long l = 0L; paramArrayList.hasNext(); l += l) {
      if (arqo.a((FileManagerEntity)paramArrayList.next()).a(paramBoolean)) {
        return true;
      }
    }
    return l > arbp.a();
  }
  
  public static byte[] a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 100: 
      return paramQQAppInterface.a().m(paramString);
    case 127: 
      return paramQQAppInterface.a().k(paramString);
    case 102: 
      return paramQQAppInterface.a().f(paramString);
    case 109: 
      return paramQQAppInterface.a().p(paramString);
    }
    return paramQQAppInterface.a().d(paramString);
  }
  
  /* Error */
  public static byte[] a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 3338	java/io/BufferedInputStream
    //   5: dup
    //   6: new 3340	java/io/FileInputStream
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 3341	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   14: invokespecial 3344	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_0
    //   18: sipush 10240
    //   21: newarray byte
    //   23: astore 4
    //   25: ldc_w 3346
    //   28: invokestatic 3352	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   31: astore_2
    //   32: aload_0
    //   33: aload 4
    //   35: invokevirtual 3358	java/io/InputStream:read	([B)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifle +39 -> 79
    //   43: aload_2
    //   44: aload 4
    //   46: iconst_0
    //   47: iload_1
    //   48: invokevirtual 3362	java/security/MessageDigest:update	([BII)V
    //   51: goto -19 -> 32
    //   54: astore_2
    //   55: aload_3
    //   56: astore_2
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokevirtual 3363	java/io/InputStream:close	()V
    //   65: aload_3
    //   66: astore_2
    //   67: aload_2
    //   68: areturn
    //   69: astore_2
    //   70: aload_2
    //   71: invokevirtual 3364	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   74: aconst_null
    //   75: astore_2
    //   76: goto -44 -> 32
    //   79: aload_0
    //   80: ifnull +7 -> 87
    //   83: aload_0
    //   84: invokevirtual 3363	java/io/InputStream:close	()V
    //   87: aload_2
    //   88: ifnull +25 -> 113
    //   91: aload_2
    //   92: invokevirtual 3367	java/security/MessageDigest:digest	()[B
    //   95: astore_2
    //   96: aload_2
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: aload_0
    //   101: ifnull -34 -> 67
    //   104: aload_0
    //   105: invokevirtual 3363	java/io/InputStream:close	()V
    //   108: aload_3
    //   109: areturn
    //   110: astore_0
    //   111: aload_3
    //   112: areturn
    //   113: aload_3
    //   114: astore_2
    //   115: aload_0
    //   116: ifnull -49 -> 67
    //   119: aload_0
    //   120: invokevirtual 3363	java/io/InputStream:close	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    //   128: astore_0
    //   129: aconst_null
    //   130: astore_0
    //   131: aload_3
    //   132: astore_2
    //   133: aload_0
    //   134: ifnull -67 -> 67
    //   137: aload_0
    //   138: invokevirtual 3363	java/io/InputStream:close	()V
    //   141: aconst_null
    //   142: areturn
    //   143: astore_0
    //   144: aconst_null
    //   145: areturn
    //   146: astore_2
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: ifnull +7 -> 157
    //   153: aload_0
    //   154: invokevirtual 3363	java/io/InputStream:close	()V
    //   157: aload_2
    //   158: athrow
    //   159: astore 4
    //   161: goto -74 -> 87
    //   164: astore_0
    //   165: aconst_null
    //   166: areturn
    //   167: astore_0
    //   168: goto -11 -> 157
    //   171: astore_2
    //   172: goto -23 -> 149
    //   175: astore_2
    //   176: goto -45 -> 131
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_0
    //   182: goto -127 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString	String
    //   38	10	1	i	int
    //   31	13	2	localMessageDigest	java.security.MessageDigest
    //   54	1	2	localFileNotFoundException	FileNotFoundException
    //   56	12	2	localObject1	Object
    //   69	2	2	localNoSuchAlgorithmException	java.security.NoSuchAlgorithmException
    //   75	58	2	localObject2	Object
    //   146	12	2	localObject3	Object
    //   171	1	2	localObject4	Object
    //   175	1	2	localIOException1	IOException
    //   1	131	3	localObject5	Object
    //   23	22	4	arrayOfByte	byte[]
    //   159	1	4	localIOException2	IOException
    // Exception table:
    //   from	to	target	type
    //   18	25	54	java/io/FileNotFoundException
    //   25	32	54	java/io/FileNotFoundException
    //   32	39	54	java/io/FileNotFoundException
    //   43	51	54	java/io/FileNotFoundException
    //   70	74	54	java/io/FileNotFoundException
    //   83	87	54	java/io/FileNotFoundException
    //   91	96	54	java/io/FileNotFoundException
    //   25	32	69	java/security/NoSuchAlgorithmException
    //   104	108	110	java/io/IOException
    //   119	123	125	java/io/IOException
    //   2	18	128	java/io/IOException
    //   137	141	143	java/io/IOException
    //   2	18	146	finally
    //   83	87	159	java/io/IOException
    //   61	65	164	java/io/IOException
    //   153	157	167	java/io/IOException
    //   18	25	171	finally
    //   25	32	171	finally
    //   32	39	171	finally
    //   43	51	171	finally
    //   70	74	171	finally
    //   83	87	171	finally
    //   91	96	171	finally
    //   18	25	175	java/io/IOException
    //   25	32	175	java/io/IOException
    //   32	39	175	java/io/IOException
    //   43	51	175	java/io/IOException
    //   70	74	175	java/io/IOException
    //   91	96	175	java/io/IOException
    //   2	18	179	java/io/FileNotFoundException
  }
  
  /* Error */
  public static byte[] a(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 3340	java/io/FileInputStream
    //   6: dup
    //   7: aload_0
    //   8: invokespecial 3341	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   11: astore 4
    //   13: lload_1
    //   14: ldc2_w 3369
    //   17: lcmp
    //   18: ifge +28 -> 46
    //   21: aload 4
    //   23: astore_3
    //   24: aload_0
    //   25: lload_1
    //   26: invokestatic 3375	com/tencent/qphone/base/util/MD5:getPartfileMd5	(Ljava/lang/String;J)[B
    //   29: astore_0
    //   30: aload_0
    //   31: astore_3
    //   32: aload 4
    //   34: ifnull +10 -> 44
    //   37: aload 4
    //   39: invokevirtual 3376	java/io/FileInputStream:close	()V
    //   42: aload_0
    //   43: astore_3
    //   44: aload_3
    //   45: areturn
    //   46: ldc2_w 3369
    //   49: lstore_1
    //   50: goto -29 -> 21
    //   53: astore_3
    //   54: aload_3
    //   55: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   58: ldc_w 376
    //   61: iconst_1
    //   62: new 165	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   69: ldc_w 3378
    //   72: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_3
    //   76: invokevirtual 3379	java/io/IOException:toString	()Ljava/lang/String;
    //   79: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: aload_0
    //   89: areturn
    //   90: astore 5
    //   92: aconst_null
    //   93: astore_0
    //   94: aload_0
    //   95: astore_3
    //   96: ldc_w 376
    //   99: iconst_1
    //   100: new 165	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 3381
    //   110: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload 5
    //   115: invokevirtual 3379	java/io/IOException:toString	()Ljava/lang/String;
    //   118: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload 6
    //   129: astore_3
    //   130: aload_0
    //   131: ifnull -87 -> 44
    //   134: aload_0
    //   135: invokevirtual 3376	java/io/FileInputStream:close	()V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aload_0
    //   142: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   145: ldc_w 376
    //   148: iconst_1
    //   149: new 165	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 3378
    //   159: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: aload_0
    //   163: invokevirtual 3379	java/io/IOException:toString	()Ljava/lang/String;
    //   166: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_0
    //   178: aconst_null
    //   179: astore_3
    //   180: aload_3
    //   181: ifnull +7 -> 188
    //   184: aload_3
    //   185: invokevirtual 3376	java/io/FileInputStream:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore_3
    //   191: aload_3
    //   192: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   195: ldc_w 376
    //   198: iconst_1
    //   199: new 165	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   206: ldc_w 3378
    //   209: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: aload_3
    //   213: invokevirtual 3379	java/io/IOException:toString	()Ljava/lang/String;
    //   216: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: goto -37 -> 188
    //   228: astore_0
    //   229: goto -49 -> 180
    //   232: astore 5
    //   234: aload 4
    //   236: astore_0
    //   237: goto -143 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	paramString	String
    //   0	240	1	paramLong	long
    //   23	22	3	localObject1	Object
    //   53	23	3	localIOException1	IOException
    //   95	90	3	localObject2	Object
    //   190	23	3	localIOException2	IOException
    //   11	224	4	localFileInputStream	java.io.FileInputStream
    //   90	24	5	localIOException3	IOException
    //   232	1	5	localIOException4	IOException
    //   1	127	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	53	java/io/IOException
    //   3	13	90	java/io/IOException
    //   134	138	140	java/io/IOException
    //   3	13	177	finally
    //   184	188	190	java/io/IOException
    //   24	30	228	finally
    //   96	127	228	finally
    //   24	30	232	java/io/IOException
  }
  
  public static int[] a(String paramString)
  {
    if (!bdhb.b(paramString)) {
      return new int[] { 0, 0 };
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    SafeBitmapFactory.decodeFile(paramString, localOptions);
    int i = bayu.a(paramString);
    int j;
    if ((i == 90) || (i == 270))
    {
      i = localOptions.outWidth;
      j = localOptions.outHeight;
    }
    for (;;)
    {
      return new int[] { j, i };
      j = localOptions.outWidth;
      i = localOptions.outHeight;
    }
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case -1: 
    case 1000: 
    case 2000: 
    case 2008: 
    default: 
      return -1;
    case 1003: 
    case 2003: 
      return 1;
    case 1005: 
    case 2005: 
      return 0;
    case 1004: 
    case 2004: 
    case 4001: 
      return 3;
    case 1001: 
    case 1002: 
    case 2001: 
    case 2002: 
      return 2;
    case 0: 
      return 0;
    case 1: 
      return 1;
    case 3: 
      return 3;
    }
    return 2;
  }
  
  public static int b(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  public static int b(String paramString)
  {
    paramString = arso.a(paramString);
    if (paramString == null) {
      return 2130843981;
    }
    return a(a(paramString));
  }
  
  public static long b()
  {
    return azah.a(azah.a());
  }
  
  private static Bitmap b(Matrix paramMatrix, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int j = paramBitmap.getWidth() - paramInt1;
    int i = paramBitmap.getHeight() - paramInt2;
    Object localObject1;
    Object localObject2;
    if ((j < 0) || (i < 0)) {
      try
      {
        localObject1 = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        paramMatrix = new Canvas((Bitmap)localObject1);
        j = Math.max(0, j / 2);
        i = Math.max(0, i / 2);
        localObject2 = new Rect(j, i, Math.min(paramInt1, paramBitmap.getWidth()) + j, Math.min(paramInt2, paramBitmap.getHeight()) + i);
        i = (paramInt1 - ((Rect)localObject2).width()) / 2;
        j = (paramInt2 - ((Rect)localObject2).height()) / 2;
        paramMatrix.drawBitmap(paramBitmap, (Rect)localObject2, new Rect(i, j, paramInt1 - i, paramInt2 - j), null);
        return localObject1;
      }
      catch (OutOfMemoryError paramMatrix)
      {
        QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        return null;
      }
    }
    float f1 = paramBitmap.getWidth();
    float f2 = paramBitmap.getHeight();
    if (f1 / f2 > paramInt1 / paramInt2)
    {
      f1 = paramInt2 / f2;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        label225:
        if (paramMatrix == null) {
          break label378;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramMatrix = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          if (paramMatrix != paramBitmap) {
            paramBitmap.recycle();
          }
          i = Math.max(0, paramMatrix.getWidth() - paramInt1);
          j = Math.max(0, paramMatrix.getHeight() - paramInt2);
        }
        catch (OutOfMemoryError paramMatrix)
        {
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
          return null;
        }
        try
        {
          localObject2 = Bitmap.createBitmap(paramMatrix, i / 2, j / 2, paramInt1, paramInt2);
          localObject1 = localObject2;
          if (localObject2 == paramMatrix) {
            break;
          }
          localObject1 = localObject2;
          if (paramMatrix == paramBitmap) {
            break;
          }
          paramMatrix.recycle();
          return localObject2;
        }
        catch (OutOfMemoryError paramMatrix)
        {
          label378:
          QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
        }
      }
      paramMatrix = null;
      break label225;
      f1 = paramInt1 / f1;
      if ((f1 < 0.9F) || (f1 > 1.0F))
      {
        paramMatrix.setScale(f1, f1);
        break label225;
      }
      paramMatrix = null;
      break label225;
      paramMatrix = paramBitmap;
    }
    return null;
  }
  
  public static arss b(QQAppInterface paramQQAppInterface)
  {
    return new arrv(paramQQAppInterface);
  }
  
  public static String b()
  {
    return arqx.a().b();
  }
  
  public static String b(int paramInt)
  {
    switch (paramInt)
    {
    case 11: 
    default: 
      return "other";
    case 0: 
      return "image";
    case 1: 
      return "audio";
    case 2: 
      return "video";
    case 3: 
      return "doc";
    case 4: 
      return "zip";
    case 5: 
      return "apk";
    case 6: 
      return "excel";
    case 7: 
      return "ppt";
    case 8: 
      return "html";
    case 9: 
      return "pdf";
    case 10: 
      return "txt";
    }
    return "psd";
  }
  
  public static String b(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject6 = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    Object localObject1;
    label274:
    Object localObject2;
    label283:
    Object localObject5;
    switch (paramFileManagerEntity.nOpType)
    {
    default: 
      localObject1 = null;
      if (paramFileManagerEntity.getCloudType() == 0) {
        localObject1 = localBaseApplication.getString(2131692519);
      }
      if (paramFileManagerEntity.getCloudType() != 5) {
        break label1143;
      }
      if (paramFileManagerEntity.bSend)
      {
        localObject1 = localBaseApplication.getString(2131692552);
        localObject4 = paramFileManagerEntity.peerNick;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject2 == null) || (((String)localObject2).equals(localBaseApplication.getString(2131692526))) || (((String)localObject2).equals(localBaseApplication.getString(2131692520)))) {
          break label1137;
        }
        localObject5 = paramFileManagerEntity.peerNick;
        label323:
        localObject1 = localObject2;
        if (paramFileManagerEntity.nOpType == 1)
        {
          localObject1 = localObject2;
          if (paramFileManagerEntity.bSend) {
            localObject1 = localBaseApplication.getString(2131692552);
          }
        }
        localObject4 = localObject5;
      }
      break;
    }
    try
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject4 = localObject5;
      localObject2 = a(localQQAppInterface, paramFileManagerEntity.peerUin, "", paramFileManagerEntity.peerType);
    }
    catch (Exception localException1)
    {
      label430:
      label467:
      label469:
      do
      {
        for (;;)
        {
          QQAppInterface localQQAppInterface;
          localObject3 = localObject4;
        }
        if ((localObject1 != null) && (localObject3 != null)) {
          return (String)localObject1 + " " + localObject3;
        }
        paramFileManagerEntity = (FileManagerEntity)localObject1;
      } while (localObject1 != null);
      return localObject3;
    }
    try
    {
      if (paramFileManagerEntity.TroopUin == 0L) {
        break label1134;
      }
      localObject4 = ((TroopManager)localQQAppInterface.getManager(52)).b(String.valueOf(paramFileManagerEntity.TroopUin));
      if ((localObject4 != null) && (((TroopInfo)localObject4).getTroopName() != null)) {
        break label910;
      }
      localObject2 = "";
      localObject4 = localObject2;
      if (!paramFileManagerEntity.bSend) {
        break label953;
      }
      localObject4 = localObject2;
      localObject2 = localBaseApplication.getString(2131692485) + (String)localObject2;
      localObject1 = null;
    }
    catch (Exception localException2)
    {
      break label1075;
      break label469;
    }
    Object localObject4 = localObject2;
    if (localObject1 != null) {
      localObject4 = localObject2;
    }
    for (;;)
    {
      try
      {
        if (((String)localObject1).equals(localBaseApplication.getString(2131692526))) {
          localObject4 = null;
        }
        localObject2 = localObject4;
        if (paramFileManagerEntity.peerType != 3000) {
          continue;
        }
        if (localObject1 != null)
        {
          localObject2 = localObject4;
          if (!((String)localObject1).equals(localBaseApplication.getString(2131692526))) {}
        }
        else
        {
          localObject2 = localObject4;
          if (paramFileManagerEntity.nOpType != 28) {
            continue;
          }
        }
        localObject2 = localObject4;
        localObject5 = ((alrk)localQQAppInterface.getManager(53)).a(String.valueOf(paramFileManagerEntity.peerUin));
        if (localObject5 == null) {
          break label1150;
        }
        localObject2 = localObject4;
        if (((DiscussionInfo)localObject5).discussionName != null) {
          continue;
        }
      }
      catch (Exception localException3)
      {
        label910:
        label953:
        continue;
        label1075:
        localObject3 = localObject1;
        localObject1 = localException3;
        continue;
      }
      localObject2 = localObject4;
      if (paramFileManagerEntity.bSend)
      {
        localObject2 = localObject4;
        localObject4 = localBaseApplication.getString(2131692484) + (String)localObject4;
        localObject1 = localObject4;
        localObject2 = localObject6;
        localObject4 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject4;
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(localBaseApplication.getString(2131692520))) || (!paramFileManagerEntity.bSend)) {
          continue;
        }
        paramFileManagerEntity = localBaseApplication.getString(2131692552) + " " + (String)localObject2;
        return paramFileManagerEntity;
        localObject1 = localBaseApplication.getString(2131692519);
        break;
        localObject1 = localBaseApplication.getString(2131692526);
        break;
        if ((paramFileManagerEntity.nFileType == 13) && (paramFileManagerEntity.selfUin.equals(paramFileManagerEntity.peerUin)))
        {
          localObject1 = localBaseApplication.getString(2131692481);
          break;
        }
        localObject1 = localBaseApplication.getString(2131692552);
        break;
        localObject1 = localBaseApplication.getString(2131692520);
        break;
        if (paramFileManagerEntity.bSend)
        {
          localObject1 = localBaseApplication.getString(2131692552);
          break;
        }
        localObject1 = localBaseApplication.getString(2131692519);
        break;
        localObject1 = localBaseApplication.getString(2131721168);
        break;
        localObject1 = localBaseApplication.getString(2131721169);
        break;
        localObject1 = localBaseApplication.getString(2131721174);
        break;
        localObject1 = localBaseApplication.getString(2131721171);
        break;
        localObject1 = localBaseApplication.getString(2131721170);
        break;
        localObject1 = localBaseApplication.getString(2131721172);
        break;
        localObject1 = localBaseApplication.getString(2131721175);
        break;
        localObject1 = localBaseApplication.getString(2131721173);
        break;
        localObject1 = localBaseApplication.getString(2131692519);
        break label274;
        if ((localObject4 != null) && (((TroopInfo)localObject4).getTroopName() != null) && (((TroopInfo)localObject4).getTroopName().length() > 14))
        {
          localObject4 = ((TroopInfo)localObject4).getTroopName();
          localObject2 = localObject4;
          break label430;
        }
        localObject4 = ((TroopInfo)localObject4).getTroopName();
        localObject2 = localObject4;
        break label430;
        localObject4 = localObject2;
        localObject2 = localBaseApplication.getString(2131692483) + (String)localObject2;
        break label467;
        if (localObject5 != null)
        {
          localObject2 = localObject4;
          if (((DiscussionInfo)localObject5).discussionName != null)
          {
            localObject2 = localObject4;
            if (((DiscussionInfo)localObject5).discussionName.length() > 14)
            {
              localObject2 = localObject4;
              localObject4 = ((DiscussionInfo)localObject5).discussionName;
              continue;
            }
          }
        }
        localObject2 = localObject4;
        localObject4 = ((DiscussionInfo)localObject5).discussionName;
        continue;
      }
      localObject2 = localObject4;
      localObject4 = localBaseApplication.getString(2131692482) + (String)localObject4;
      localObject1 = localObject4;
      localObject2 = localObject6;
      continue;
      label1134:
      label1137:
      localObject5 = localObject1;
      break label323;
      label1143:
      Object localObject3 = localObject1;
      localObject1 = null;
      break label283;
      label1150:
      String str = "";
    }
  }
  
  public static String b(String paramString)
  {
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    Object localObject2 = "";
    Object localObject1 = "";
    String str2 = "";
    String str1 = str2;
    if (i > 0)
    {
      if ((j <= 0) || (j <= i)) {
        break label160;
      }
      localObject1 = paramString.substring(i, j);
    }
    for (str1 = paramString.substring(j);; str1 = str2)
    {
      str2 = paramString.substring(0, i);
      localObject2 = localObject1;
      localObject1 = str2;
      VFSFile localVFSFile = new VFSFile(paramString);
      i = 1;
      str2 = paramString;
      paramString = localVFSFile;
      while (paramString.exists())
      {
        str2 = (String)localObject1 + (String)localObject2 + "(" + i + ")" + str1;
        paramString = new VFSFile(str2);
        i += 1;
      }
      label160:
      localObject1 = paramString.substring(i);
    }
    return str2;
  }
  
  public static void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = localQQAppInterface.a().a();
    if (localObject == null) {
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
      if (!TextUtils.isEmpty(localFileManagerEntity.Uuid))
      {
        localFileManagerEntity.status = 16;
        localQQAppInterface.a().a(localFileManagerEntity.peerUin, localFileManagerEntity.fileName, localFileManagerEntity.Uuid, localFileManagerEntity.bSend);
      }
    }
    localQQAppInterface.a().f();
  }
  
  /* Error */
  public static void b(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: ifnonnull +13 -> 19
    //   9: new 28	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 30	java/util/ArrayList:<init>	()V
    //   16: putstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   19: getstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   22: lload_0
    //   23: invokestatic 1582	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   26: invokevirtual 3507	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +7 -> 38
    //   34: ldc 2
    //   36: monitorexit
    //   37: return
    //   38: getstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   41: lload_0
    //   42: invokestatic 1582	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   45: invokevirtual 1914	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   52: ifeq -18 -> 34
    //   55: ldc_w 1172
    //   58: iconst_2
    //   59: new 165	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   66: ldc_w 3509
    //   69: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: lload_0
    //   73: invokestatic 1111	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   76: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: ldc_w 3511
    //   82: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: goto -57 -> 34
    //   94: astore_3
    //   95: ldc 2
    //   97: monitorexit
    //   98: aload_3
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramLong	long
    //   29	2	2	bool	boolean
    //   94	5	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	19	94	finally
    //   19	30	94	finally
    //   38	91	94	finally
  }
  
  public static void b(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("_filename_from_dlg", paramActivity.getString(2131694945));
    localBundle.putString("big_brother_source_key", "biz_src_jc_file");
    localBundle.putString("DOWNLOAD_BIG_BROTHER_SOURCE", "biz_src_jc_file");
    araj.a().a(paramString, localBundle);
  }
  
  public static void b(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new Bundle();
    paramString1.putString("string_uin", paramString2);
    paramString1.putString("string_nick", paramString3);
    bisq.a(paramActivity, 3, paramString1);
  }
  
  public static void b(Context paramContext)
  {
    paramContext.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
  }
  
  public static void b(Context paramContext, String paramString)
  {
    if ((paramString == null) || (!arso.a(paramString)))
    {
      arri.a(2131692941);
      return;
    }
    paramString = FileProvider7Helper.openApkIntent(paramContext, paramString);
    paramString.putExtra("big_brother_source_key", "biz_src_jc_file");
    List localList = paramContext.getPackageManager().queryIntentActivities(paramString, 65536);
    if ((localList.size() == 1) && (((ResolveInfo)localList.get(0)).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity"))) {}
    for (int i = 1;; i = 0)
    {
      if ((localList.size() > 0) && (i == 0)) {
        try
        {
          paramContext.startActivity(paramString);
          return;
        }
        catch (ActivityNotFoundException paramContext)
        {
          arri.a(2131694007);
          return;
        }
      }
      arri.a(2131694007);
      return;
    }
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.strSrcName == null) {
      paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
    }
    while (paramFileManagerEntity.strSrcName.length() != 0) {
      return;
    }
    paramFileManagerEntity.strSrcName = paramFileManagerEntity.fileName;
  }
  
  public static void b(com.tencent.mobileqq.filemanager.widget.AsyncImageView paramAsyncImageView, FileManagerEntity paramFileManagerEntity)
  {
    a(paramFileManagerEntity);
    if (paramFileManagerEntity.nFileType == 0)
    {
      String str2 = paramFileManagerEntity.strLargeThumPath;
      String str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = d(paramFileManagerEntity);
      }
      if (bdhb.b(str1))
      {
        paramFileManagerEntity.strLargeThumPath = str1;
        paramAsyncImageView.setDefaultImage(2130843911);
        paramAsyncImageView.setAsyncImage(str1);
        return;
      }
    }
    a(paramAsyncImageView, paramFileManagerEntity.fileName);
  }
  
  public static void b(String paramString)
  {
    try
    {
      BaseApplicationImpl.getContext().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data=?", new String[] { paramString });
      return;
    }
    catch (Exception paramString) {}
  }
  
  public static boolean b(arhz paramarhz)
  {
    int i = paramarhz.c();
    int j = paramarhz.d();
    return (i == 3) && (j == 1);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, arhz paramarhz)
  {
    boolean bool = true;
    FileManagerEntity localFileManagerEntity = paramarhz.a();
    if (localFileManagerEntity == null) {
      return false;
    }
    int i;
    int j;
    label61:
    int k;
    label98:
    int m;
    label110:
    int n;
    if ((a(paramQQAppInterface, paramarhz)) && (!localFileManagerEntity.isZipInnerFile))
    {
      i = 1;
      if ((paramarhz.b() == 6000) || (paramarhz.c() == 7)) {
        break label154;
      }
      j = 1;
      if ((paramarhz.c() == 3) && (localFileManagerEntity.strTroopFilePath == null) && (localFileManagerEntity.Uuid == null) && (localFileManagerEntity.WeiYunFileId == null)) {
        break label159;
      }
      k = 1;
      if (paramarhz.c() == 0) {
        break label165;
      }
      m = 1;
      if (paramarhz.c() == 5) {
        break label171;
      }
      n = 1;
      label123:
      if ((i == 0) || (j == 0) || (k == 0) || (m == 0) || (n == 0)) {
        break label177;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label154:
      j = 0;
      break label61;
      label159:
      k = 0;
      break label98;
      label165:
      m = 0;
      break label110;
      label171:
      n = 0;
      break label123;
      label177:
      bool = false;
    }
  }
  
  public static boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return !arso.a(paramFileManagerEntity.getFilePath()).equalsIgnoreCase(".mov");
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return new VFSFile(paramString).exists();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + paramString1 + "_" + paramString2, true);
  }
  
  /* Error */
  public static byte[] b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 3600	arrr:a	(Ljava/lang/String;)J
    //   4: lstore 7
    //   6: lload 7
    //   8: ldc2_w 3601
    //   11: lcmp
    //   12: ifge +9 -> 21
    //   15: aconst_null
    //   16: astore 20
    //   18: aload 20
    //   20: areturn
    //   21: ldc2_w 3603
    //   24: lconst_1
    //   25: lsub
    //   26: lstore 17
    //   28: lload 7
    //   30: ldc2_w 1436
    //   33: ldiv
    //   34: ldc2_w 3603
    //   37: ldc2_w 1436
    //   40: ldiv
    //   41: lsub
    //   42: lstore 13
    //   44: lload 7
    //   46: ldc2_w 1436
    //   49: ldiv
    //   50: ldc2_w 3603
    //   53: ldc2_w 1436
    //   56: ldiv
    //   57: ladd
    //   58: lconst_1
    //   59: lsub
    //   60: lstore 15
    //   62: lload 7
    //   64: ldc2_w 3603
    //   67: lsub
    //   68: lstore 9
    //   70: lload 7
    //   72: lconst_1
    //   73: lsub
    //   74: lstore 11
    //   76: ldc_w 3346
    //   79: invokestatic 3352	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   82: astore 20
    //   84: new 3338	java/io/BufferedInputStream
    //   87: dup
    //   88: new 3340	java/io/FileInputStream
    //   91: dup
    //   92: aload_0
    //   93: invokespecial 3341	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   96: invokespecial 3344	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   99: astore 19
    //   101: lconst_0
    //   102: lstore_3
    //   103: iconst_0
    //   104: istore_1
    //   105: aload 19
    //   107: astore_0
    //   108: lload 17
    //   110: lload_3
    //   111: lsub
    //   112: lconst_1
    //   113: ladd
    //   114: ldc2_w 3605
    //   117: invokestatic 3609	java/lang/Math:min	(JJ)J
    //   120: l2i
    //   121: newarray byte
    //   123: astore 21
    //   125: aload 19
    //   127: astore_0
    //   128: aload 19
    //   130: aload 21
    //   132: invokevirtual 3358	java/io/InputStream:read	([B)I
    //   135: istore_2
    //   136: aload 19
    //   138: astore_0
    //   139: aload 20
    //   141: aload 21
    //   143: iconst_0
    //   144: iload_2
    //   145: invokevirtual 3362	java/security/MessageDigest:update	([BII)V
    //   148: lload_3
    //   149: iload_2
    //   150: i2l
    //   151: ladd
    //   152: lstore 5
    //   154: iload_1
    //   155: iload_2
    //   156: iadd
    //   157: istore_2
    //   158: iload_2
    //   159: istore_1
    //   160: lload 5
    //   162: lstore_3
    //   163: lload 5
    //   165: lload 17
    //   167: lconst_0
    //   168: lsub
    //   169: lconst_1
    //   170: ladd
    //   171: lcmp
    //   172: iflt -67 -> 105
    //   175: aload 19
    //   177: astore_0
    //   178: aload 19
    //   180: lload 13
    //   182: lload 17
    //   184: lsub
    //   185: lconst_1
    //   186: lsub
    //   187: invokevirtual 3612	java/io/InputStream:skip	(J)J
    //   190: pop2
    //   191: lconst_0
    //   192: lstore_3
    //   193: iload_2
    //   194: istore_1
    //   195: aload 19
    //   197: astore_0
    //   198: lload 15
    //   200: lload 13
    //   202: lsub
    //   203: lload_3
    //   204: lsub
    //   205: lconst_1
    //   206: ladd
    //   207: ldc2_w 3605
    //   210: invokestatic 3609	java/lang/Math:min	(JJ)J
    //   213: l2i
    //   214: newarray byte
    //   216: astore 21
    //   218: aload 19
    //   220: astore_0
    //   221: aload 19
    //   223: aload 21
    //   225: invokevirtual 3358	java/io/InputStream:read	([B)I
    //   228: istore_2
    //   229: aload 19
    //   231: astore_0
    //   232: aload 20
    //   234: aload 21
    //   236: iconst_0
    //   237: iload_2
    //   238: invokevirtual 3362	java/security/MessageDigest:update	([BII)V
    //   241: lload_3
    //   242: iload_2
    //   243: i2l
    //   244: ladd
    //   245: lstore 5
    //   247: iload_1
    //   248: iload_2
    //   249: iadd
    //   250: istore_2
    //   251: iload_2
    //   252: istore_1
    //   253: lload 5
    //   255: lstore_3
    //   256: lload 5
    //   258: lload 15
    //   260: lload 13
    //   262: lsub
    //   263: lconst_1
    //   264: ladd
    //   265: lcmp
    //   266: iflt -71 -> 195
    //   269: aload 19
    //   271: astore_0
    //   272: aload 19
    //   274: lload 9
    //   276: lload 15
    //   278: lsub
    //   279: lconst_1
    //   280: lsub
    //   281: invokevirtual 3612	java/io/InputStream:skip	(J)J
    //   284: pop2
    //   285: lconst_0
    //   286: lstore_3
    //   287: iload_2
    //   288: istore_1
    //   289: aload 19
    //   291: astore_0
    //   292: lload 11
    //   294: lload 9
    //   296: lsub
    //   297: lload_3
    //   298: lsub
    //   299: lconst_1
    //   300: ladd
    //   301: ldc2_w 3605
    //   304: invokestatic 3609	java/lang/Math:min	(JJ)J
    //   307: l2i
    //   308: newarray byte
    //   310: astore 21
    //   312: aload 19
    //   314: astore_0
    //   315: aload 19
    //   317: aload 21
    //   319: invokevirtual 3358	java/io/InputStream:read	([B)I
    //   322: istore_2
    //   323: iload_2
    //   324: ifgt +17 -> 341
    //   327: aload 19
    //   329: astore_0
    //   330: bipush 8
    //   332: newarray byte
    //   334: astore 21
    //   336: iconst_0
    //   337: istore_2
    //   338: goto +220 -> 558
    //   341: aload 19
    //   343: astore_0
    //   344: aload 20
    //   346: aload 21
    //   348: iconst_0
    //   349: iload_2
    //   350: invokevirtual 3362	java/security/MessageDigest:update	([BII)V
    //   353: lload_3
    //   354: iload_2
    //   355: i2l
    //   356: ladd
    //   357: lstore 5
    //   359: iload_1
    //   360: iload_2
    //   361: iadd
    //   362: istore_2
    //   363: iload_2
    //   364: istore_1
    //   365: lload 5
    //   367: lstore_3
    //   368: lload 5
    //   370: lload 11
    //   372: lload 9
    //   374: lsub
    //   375: lconst_1
    //   376: ladd
    //   377: lcmp
    //   378: iflt -89 -> 289
    //   381: iload_2
    //   382: istore_1
    //   383: goto -56 -> 327
    //   386: aload 19
    //   388: astore_0
    //   389: aload 20
    //   391: aload 21
    //   393: iconst_0
    //   394: bipush 8
    //   396: invokevirtual 3362	java/security/MessageDigest:update	([BII)V
    //   399: aload 19
    //   401: astore_0
    //   402: ldc_w 376
    //   405: iconst_1
    //   406: new 165	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 3614
    //   416: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload_1
    //   420: invokevirtual 913	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   423: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: invokestatic 195	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   429: aload 20
    //   431: ifnull +40 -> 471
    //   434: aload 19
    //   436: astore_0
    //   437: aload 20
    //   439: invokevirtual 3367	java/security/MessageDigest:digest	()[B
    //   442: astore 20
    //   444: aload 20
    //   446: astore_0
    //   447: aload_0
    //   448: astore 20
    //   450: aload 19
    //   452: ifnull -434 -> 18
    //   455: aload 19
    //   457: invokevirtual 3363	java/io/InputStream:close	()V
    //   460: aload_0
    //   461: areturn
    //   462: astore 19
    //   464: aload 19
    //   466: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   469: aload_0
    //   470: areturn
    //   471: aload 19
    //   473: ifnull +8 -> 481
    //   476: aload 19
    //   478: invokevirtual 3363	java/io/InputStream:close	()V
    //   481: aconst_null
    //   482: areturn
    //   483: astore_0
    //   484: aload_0
    //   485: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   488: goto -7 -> 481
    //   491: astore 20
    //   493: aconst_null
    //   494: astore 19
    //   496: aload 19
    //   498: astore_0
    //   499: aload 20
    //   501: invokevirtual 790	java/lang/Exception:printStackTrace	()V
    //   504: aload 19
    //   506: ifnull -25 -> 481
    //   509: aload 19
    //   511: invokevirtual 3363	java/io/InputStream:close	()V
    //   514: goto -33 -> 481
    //   517: astore_0
    //   518: aload_0
    //   519: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   522: goto -41 -> 481
    //   525: astore 19
    //   527: aconst_null
    //   528: astore_0
    //   529: aload_0
    //   530: ifnull +7 -> 537
    //   533: aload_0
    //   534: invokevirtual 3363	java/io/InputStream:close	()V
    //   537: aload 19
    //   539: athrow
    //   540: astore_0
    //   541: aload_0
    //   542: invokevirtual 851	java/io/IOException:printStackTrace	()V
    //   545: goto -8 -> 537
    //   548: astore 19
    //   550: goto -21 -> 529
    //   553: astore 20
    //   555: goto -59 -> 496
    //   558: iload_2
    //   559: bipush 8
    //   561: if_icmpge -175 -> 386
    //   564: aload 21
    //   566: bipush 8
    //   568: iload_2
    //   569: isub
    //   570: iconst_1
    //   571: isub
    //   572: lload 7
    //   574: bipush 64
    //   576: iload_2
    //   577: iconst_1
    //   578: iadd
    //   579: bipush 8
    //   581: imul
    //   582: isub
    //   583: lshr
    //   584: ldc2_w 3615
    //   587: land
    //   588: l2i
    //   589: i2b
    //   590: bastore
    //   591: iload_2
    //   592: iconst_1
    //   593: iadd
    //   594: istore_2
    //   595: goto -37 -> 558
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	598	0	paramString	String
    //   104	316	1	i	int
    //   135	460	2	j	int
    //   102	266	3	l1	long
    //   152	217	5	l2	long
    //   4	569	7	l3	long
    //   68	305	9	l4	long
    //   74	297	11	l5	long
    //   42	219	13	l6	long
    //   60	217	15	l7	long
    //   26	157	17	l8	long
    //   99	357	19	localBufferedInputStream	java.io.BufferedInputStream
    //   462	15	19	localIOException	IOException
    //   494	16	19	localObject1	Object
    //   525	13	19	localObject2	Object
    //   548	1	19	localObject3	Object
    //   16	433	20	localObject4	Object
    //   491	9	20	localException1	Exception
    //   553	1	20	localException2	Exception
    //   123	442	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   455	460	462	java/io/IOException
    //   476	481	483	java/io/IOException
    //   28	62	491	java/lang/Exception
    //   76	101	491	java/lang/Exception
    //   509	514	517	java/io/IOException
    //   28	62	525	finally
    //   76	101	525	finally
    //   533	537	540	java/io/IOException
    //   108	125	548	finally
    //   128	136	548	finally
    //   139	148	548	finally
    //   178	191	548	finally
    //   198	218	548	finally
    //   221	229	548	finally
    //   232	241	548	finally
    //   272	285	548	finally
    //   292	312	548	finally
    //   315	323	548	finally
    //   330	336	548	finally
    //   344	353	548	finally
    //   389	399	548	finally
    //   402	429	548	finally
    //   437	444	548	finally
    //   499	504	548	finally
    //   108	125	553	java/lang/Exception
    //   128	136	553	java/lang/Exception
    //   139	148	553	java/lang/Exception
    //   178	191	553	java/lang/Exception
    //   198	218	553	java/lang/Exception
    //   221	229	553	java/lang/Exception
    //   232	241	553	java/lang/Exception
    //   272	285	553	java/lang/Exception
    //   292	312	553	java/lang/Exception
    //   315	323	553	java/lang/Exception
    //   330	336	553	java/lang/Exception
    //   344	353	553	java/lang/Exception
    //   389	399	553	java/lang/Exception
    //   402	429	553	java/lang/Exception
    //   437	444	553	java/lang/Exception
  }
  
  public static int c(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = paramFileManagerEntity.fileName.toUpperCase();
    if (paramFileManagerEntity.endsWith(".ZIP")) {
      return 13;
    }
    if (paramFileManagerEntity.endsWith(".RAR")) {
      return 14;
    }
    if (paramFileManagerEntity.endsWith(".7Z")) {
      return 15;
    }
    return -1;
  }
  
  @TargetApi(9)
  public static int c(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = arso.c(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).putString(paramString, "-");
      if (Build.VERSION.SDK_INT < 9)
      {
        ((SharedPreferences.Editor)localObject).commit();
        return 0;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return -2;
    }
    ((SharedPreferences.Editor)localObject).apply();
    return 0;
  }
  
  public static String c(FileManagerEntity paramFileManagerEntity)
  {
    String str1 = null;
    Object localObject = BaseApplicationImpl.getContext();
    String str2 = ((Context)localObject).getString(2131692553);
    switch (paramFileManagerEntity.getCloudType())
    {
    case 4: 
    default: 
      localObject = null;
      if (localObject != null) {
        label62:
        if ((paramFileManagerEntity.getCloudType() != 2) || (3 != paramFileManagerEntity.nOpType)) {
          break label163;
        }
      }
      break;
    }
    label163:
    while ((paramFileManagerEntity.getCloudType() == 5) || (paramFileManagerEntity.TroopUin != 0L))
    {
      return localObject;
      localObject = ((Context)localObject).getString(2131692508);
      str1 = a(paramFileManagerEntity.srvTime, paramFileManagerEntity.peerType);
      break;
      localObject = ((Context)localObject).getString(2131692577);
      break;
      localObject = null;
      break;
      localObject = null;
      break;
      localObject = ((Context)localObject).getString(2131698692);
      break;
      localObject = "" + a(str2, str1);
      break label62;
    }
    if (str1 != null) {
      return str1;
    }
    return "";
  }
  
  public static String c(String paramString)
  {
    if (jdField_a_of_type_JavaUtilHashMap == null)
    {
      jdField_a_of_type_JavaUtilHashMap = new HashMap();
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocFileType", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxFileType", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewdocxPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfFileType", "7");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrtfPreviewMode", "0");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptFileType", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptPreviewMode", "4");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxFileType", "6");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpptxPreviewMode", "5");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfFileType", "8");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewpdfPreviewMode", "3");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipFileType", "13");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewzipPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarFileType", "14");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewrarPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileMaxSize", "100");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zFileType", "15");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreView7zPreviewMode", "1");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileMaxSize", "10");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtFileType", "16");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
      jdField_a_of_type_JavaUtilHashMap.put("OnlinePreViewtxtPreviewMode", "2");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowSize", "1024");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFlowTime", "30");
      jdField_a_of_type_JavaUtilHashMap.put("OfflineConfigFtnThumbMaxSize", "32768");
    }
    String str = (String)jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if ((str == null) && (QLog.isColorLevel())) {
      QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + paramString + "],value null!");
    }
    return str;
  }
  
  /* Error */
  public static void c(long paramLong)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: getstatic 3505	arrr:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   18: lload_0
    //   19: invokestatic 1582	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   22: invokevirtual 3780	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   25: pop
    //   26: invokestatic 374	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq -18 -> 11
    //   32: ldc_w 1172
    //   35: iconst_2
    //   36: new 165	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 166	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3509
    //   46: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: lload_0
    //   50: invokestatic 1111	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   53: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: ldc_w 3782
    //   59: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 479	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: goto -57 -> 11
    //   71: astore_2
    //   72: ldc 2
    //   74: monitorexit
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramLong	long
    //   6	2	2	localArrayList	ArrayList
    //   71	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	7	71	finally
    //   15	68	71	finally
  }
  
  public static void c(Context paramContext, String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(paramContext, QQBrowserDelegationActivity.class);
    localIntent.putExtra("param_force_internal_browser", true);
    String str = baic.b("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("tdsourcetag", "s_qq_myfile_banner");
    localIntent.putExtra("url", str);
    localIntent.putExtra("webStyle", "noBottomBar");
    localIntent.putExtra("fromAio", true);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    if (!TeamWorkDocEditBrowserActivity.a(paramContext, str, localIntent.getStringExtra("tdsourcetag"))) {
      aemu.a(paramContext, localIntent, paramString);
    }
  }
  
  private static void c(TextView paramTextView, FileManagerEntity paramFileManagerEntity)
  {
    String str2 = arth.b(paramFileManagerEntity.srvTime);
    String str6 = b(paramFileManagerEntity);
    String str3 = arso.a(paramFileManagerEntity.fileSize);
    String str4 = c(paramFileManagerEntity);
    String str5 = BaseApplicationImpl.getContext().getString(2131692553);
    int j = paramTextView.getWidth();
    TextPaint localTextPaint = paramTextView.getPaint();
    String str1;
    float f;
    if (paramFileManagerEntity.nFileType == 13)
    {
      str1 = str2 + " " + str6 + " " + BaseApplicationImpl.getContext().getString(2131692510);
      f = localTextPaint.measureText(str1) + 30.0F;
      if (f >= j) {
        break label186;
      }
      paramTextView.setText(str1);
    }
    for (;;)
    {
      return;
      str1 = str2 + " " + str6 + str5 + str3 + str5 + str4;
      break;
      label186:
      if (f > j * 2)
      {
        i = 1;
        int k = str6.length();
        while (k - i > 0)
        {
          str1 = str6.substring(0, k - i);
          if (localTextPaint.measureText(str2 + str5 + str1 + jdField_a_of_type_JavaLangString + str5 + str3 + str5 + str4) + 30.0F < j * 2)
          {
            paramTextView.setVisibility(0);
            if (paramFileManagerEntity.nFileType == 13)
            {
              paramTextView.setText(str2 + " " + str6 + jdField_a_of_type_JavaLangString + " " + BaseApplicationImpl.getContext().getString(2131692510));
              return;
            }
            paramTextView.setText(str2 + str5 + str1 + jdField_a_of_type_JavaLangString + str5 + str3 + str5 + str4);
            return;
          }
          i += 1;
        }
        if (paramFileManagerEntity.nFileType == 13)
        {
          paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131692510));
          return;
        }
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
        return;
      }
      if (localTextPaint.measureText(str2 + str5 + str6) + 30.0F <= j) {
        break label802;
      }
      int i = 4;
      while (i <= str6.length())
      {
        str1 = str6.substring(0, i);
        if (localTextPaint.measureText(str2 + str5 + str1) + 30.0F > j)
        {
          str1 = str6.substring(0, i - 1);
          str6 = str6.replace(str1, "");
          if (paramFileManagerEntity.nFileType == 13) {
            paramTextView.setText(str2 + " " + str1 + "\n" + str6 + str5 + BaseApplicationImpl.getContext().getString(2131692510));
          }
          for (;;)
          {
            paramTextView.setVisibility(0);
            return;
            paramTextView.setText(str2 + str5 + str1 + "\n" + str6 + str5 + str3 + str5 + str4);
          }
        }
        i += 1;
      }
    }
    label802:
    if (localTextPaint.measureText(str2 + str5 + str6 + str5 + str3) + 30.0F > j)
    {
      if (paramFileManagerEntity.nFileType == 13) {
        paramTextView.setText(str2 + " " + str6 + "\n" + BaseApplicationImpl.getContext().getString(2131692510));
      }
      for (;;)
      {
        paramTextView.setVisibility(0);
        return;
        paramTextView.setText(str2 + str5 + str6 + "\n" + str3 + str5 + str4);
      }
    }
    if (paramFileManagerEntity.nFileType == 13) {
      paramTextView.setText(str2 + " " + str6 + BaseApplicationImpl.getContext().getString(2131692510));
    }
    for (;;)
    {
      paramTextView.setVisibility(0);
      return;
      paramTextView.setText(str2 + str5 + str6 + str5 + str3 + str5 + str4);
    }
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    boolean bool;
    do
    {
      return;
      bool = arso.a(paramFileManagerEntity.getFilePath());
      if ((bool) && ((paramFileManagerEntity.nOpType == 8) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 1) || (paramFileManagerEntity.nOpType == 16) || (paramFileManagerEntity.nOpType == 14) || (paramFileManagerEntity.nOpType == 15) || (paramFileManagerEntity.nOpType == 17) || (paramFileManagerEntity.nOpType == 18) || (paramFileManagerEntity.nOpType == 19) || (paramFileManagerEntity.nOpType == 190) || (paramFileManagerEntity.nOpType == 5) || (paramFileManagerEntity.nOpType == -1)))
      {
        paramFileManagerEntity.cloudType = 3;
        paramFileManagerEntity.status = 1;
        return;
      }
    } while ((paramFileManagerEntity.getCloudType() != 3) || ((bool) && ((paramFileManagerEntity.nOpType == 0) || (paramFileManagerEntity.nOpType == 6))));
    if (paramFileManagerEntity.nFileType == 5) {
      arrj.a(paramFileManagerEntity);
    }
    if (paramFileManagerEntity.status == 1)
    {
      if (paramFileManagerEntity.peerType == 6000)
      {
        paramFileManagerEntity.setCloudType(6);
        paramFileManagerEntity.status = 16;
        return;
      }
      if ((paramFileManagerEntity.Uuid != null) && (paramFileManagerEntity.Uuid.length() > 0))
      {
        paramFileManagerEntity.setCloudType(1);
        paramFileManagerEntity.status = -1;
        return;
      }
      if ((paramFileManagerEntity.WeiYunFileId != null) && (paramFileManagerEntity.WeiYunFileId.length() > 0))
      {
        paramFileManagerEntity.setCloudType(2);
        paramFileManagerEntity.status = -1;
        return;
      }
      paramFileManagerEntity.status = 16;
      return;
    }
    paramFileManagerEntity.status = 16;
  }
  
  public static boolean c(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool = true;
    if (paramFileManagerEntity == null) {}
    do
    {
      do
      {
        return false;
      } while (paramFileManagerEntity.isZipInnerFile);
      switch (a(paramFileManagerEntity))
      {
      case 5: 
      default: 
        return false;
      case 1: 
      case 2: 
      case 4: 
        return true;
      }
    } while (paramFileManagerEntity.nFileType != 0);
    return true;
    if (paramFileManagerEntity.nFileType == 0) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean c(String paramString)
  {
    return arso.b(paramString);
  }
  
  public static byte[] c(String paramString)
  {
    return b(paramString);
  }
  
  public static int d(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      i = -1;
    }
    Object localObject;
    do
    {
      return i;
      localObject = arso.c(paramString);
    } while (b().equalsIgnoreCase((String)localObject));
    try
    {
      localObject = BaseApplication.getContext().getSharedPreferences("ExternalFileOfFM", 0).edit();
      ((SharedPreferences.Editor)localObject).remove(paramString);
      ((SharedPreferences.Editor)localObject).commit();
      return 0;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return -2;
  }
  
  public static String d(FileManagerEntity paramFileManagerEntity)
  {
    if ((paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.nFileType == 0))
    {
      String str = paramFileManagerEntity.zipInnerPath;
      paramFileManagerEntity = (String)paramFileManagerEntity.mContext;
      paramFileManagerEntity = bhqh.a(paramFileManagerEntity + str);
      return arqx.a().d() + "x-zip-" + paramFileManagerEntity;
    }
    return "";
  }
  
  public static String d(String paramString)
  {
    int i = 3;
    String str;
    if ((paramString == null) || (paramString.length() == 0))
    {
      str = "";
      return str;
    }
    boolean bool = a(paramString);
    if (alsf.a() >= 20.0F) {
      if (bool) {
        i = 7;
      }
    }
    for (;;)
    {
      str = paramString;
      if (paramString.length() <= 16 - i) {
        break;
      }
      int j = paramString.length();
      str = paramString.substring(0, (16 - i) / 2);
      paramString = paramString.substring(j - (16 - i) / 2);
      return str + "..." + paramString;
      if (alsf.a() >= 18.0F)
      {
        if (bool) {
          i = 5;
        } else {
          i = 2;
        }
      }
      else if (alsf.a() >= 17.0F)
      {
        if (!bool) {
          i = 1;
        }
      }
      else {
        i = 0;
      }
    }
  }
  
  public static void d(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject;
    if (paramFileManagerEntity.nFileType == 0) {
      if (bdhb.b(paramFileManagerEntity.getFilePath()))
      {
        localObject = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
        arsj.a(paramFileManagerEntity.getFilePath(), (BitmapFactory.Options)localObject);
        if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
          break label278;
        }
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outHeight;
        int i = bayu.a(paramFileManagerEntity.getFilePath());
        if ((i == 90) || (i == 270))
        {
          paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject).outHeight;
          paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject).outWidth;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + paramFileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    label278:
    do
    {
      do
      {
        for (;;)
        {
          localObject = arsj.a(paramFileManagerEntity);
          if (localObject != null) {
            bayu.a((URL)localObject).downloadImediatly();
          }
          if ((asrc.a().i()) && (b(paramFileManagerEntity.strMiddleThumPath)))
          {
            localObject = new File(paramFileManagerEntity.strMiddleThumPath);
            localObject = asqr.a(BaseApplicationImpl.getContext(), (File)localObject);
            if (localObject == null) {
              break;
            }
            paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
            if (QLog.isDevelopLevel()) {
              QLog.i("IMG_FILE_QR", 1, "createMediThumbnail success:" + paramFileManagerEntity.strQRUrl);
            }
          }
          return;
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
          }
        }
        if (asqr.jdField_a_of_type_Boolean)
        {
          paramFileManagerEntity.strQRUrl = null;
          return;
        }
        paramFileManagerEntity.strQRUrl = "";
        return;
      } while (paramFileManagerEntity.nFileType != 2);
      localObject = a(paramFileManagerEntity.getFilePath());
    } while (((arsh)localObject).jdField_a_of_type_Int == -1);
    paramFileManagerEntity.strLargeThumPath = ((arsh)localObject).jdField_a_of_type_JavaLangString;
    if ((paramFileManagerEntity.imgHeight > 0) && (paramFileManagerEntity.imgWidth > 0)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] has size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
    for (;;)
    {
      QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + paramFileManagerEntity.nSessionId + "] create thumb success size(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      return;
      paramFileManagerEntity.imgWidth = ((arsh)localObject).jdField_b_of_type_Int;
      paramFileManagerEntity.imgHeight = ((arsh)localObject).jdField_c_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "]get local video,(wh)[" + paramFileManagerEntity.imgWidth + ":" + paramFileManagerEntity.imgHeight + "]");
      }
    }
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    while ((paramFileManagerEntity.TroopUin == 0L) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFileID)) || (TextUtils.isEmpty(paramFileManagerEntity.strTroopFilePath))) {
      return false;
    }
    return true;
  }
  
  public static byte[] d(String paramString)
  {
    return a(paramString, a(paramString));
  }
  
  public static int e(String paramString)
  {
    return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + paramString, 0);
  }
  
  public static String e(FileManagerEntity paramFileManagerEntity)
  {
    if (!asrc.a().i())
    {
      paramFileManagerEntity.strQRUrl = "";
      return "";
    }
    if (!TextUtils.isEmpty(paramFileManagerEntity.strQRUrl))
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl:" + paramFileManagerEntity.strQRUrl);
      }
      return paramFileManagerEntity.strQRUrl;
    }
    Object localObject;
    if (xrg.c(paramFileManagerEntity.strMiddleThumPath)) {
      localObject = new File(paramFileManagerEntity.strMiddleThumPath);
    }
    for (String str = "mid";; str = "larg")
    {
      localObject = asqr.a(BaseApplicationImpl.getContext(), (File)localObject);
      if (localObject == null) {
        break label205;
      }
      paramFileManagerEntity.strQRUrl = ((StringBuilder)((Pair)localObject).first).toString();
      if (QLog.isDevelopLevel()) {
        QLog.i("IMG_FILE_QR", 1, "getImageUrl success:" + paramFileManagerEntity.strQRUrl + " use:" + str);
      }
      return paramFileManagerEntity.strQRUrl;
      if (!xrg.c(paramFileManagerEntity.strLargeThumPath)) {
        break;
      }
      localObject = new File(paramFileManagerEntity.strLargeThumPath);
    }
    return null;
    label205:
    return "";
  }
  
  public static String e(String paramString)
  {
    int i = 0;
    String str;
    if (paramString == null)
    {
      str = "";
      return str;
    }
    label180:
    for (;;)
    {
      try
      {
        ByteArrayBuffer localByteArrayBuffer = new ByteArrayBuffer(paramString.length());
        str = paramString;
        if ("AnDrDQ_Fm_String".length() == 0) {
          break;
        }
        if (!paramString.equals(null))
        {
          int j = 0;
          if (j < paramString.length())
          {
            if (i <= "AnDrDQ_Fm_String".length() - 1) {
              break label180;
            }
            i %= "AnDrDQ_Fm_String".length();
            int m = paramString.codePointAt(j) + "AnDrDQ_Fm_String".codePointAt(i);
            int k = m;
            if (m > 65535) {
              k = m % 65535;
            }
            localByteArrayBuffer.append(k);
            j += 1;
            i += 1;
            continue;
          }
        }
        paramString = HexUtil.bytes2HexStr(localByteArrayBuffer.toByteArray());
        str = "#_#" + paramString + "O_O";
        break;
      }
      finally {}
    }
  }
  
  public static void e(FileManagerEntity paramFileManagerEntity)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    StringBuilder localStringBuilder;
    int i;
    for (;;)
    {
      try
      {
        localStringBuilder = new StringBuilder();
        if (paramFileManagerEntity == null)
        {
          localStringBuilder.append("entity is nll,stack:" + a());
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          return;
        }
        i = paramFileManagerEntity.nFileType;
        if ((i != 2) && (i != 0))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is not pic or video, return");
          QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
          continue;
        }
        if (paramFileManagerEntity.imgHeight <= 0) {
          break;
        }
      }
      finally {}
      if (paramFileManagerEntity.imgWidth <= 0) {
        break;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("] OK, return!");
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
    }
    Object localObject1 = paramFileManagerEntity.getFilePath();
    if (arso.b((String)localObject1))
    {
      if (i == 2) {
        bool1 = false;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is local, use local calc size!");
    }
    Object localObject2;
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label426;
      }
      localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
      QLog.e("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      localObject1 = paramFileManagerEntity.strLargeThumPath;
      if (arso.b((String)localObject1))
      {
        localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloude , use largThumb calc size!");
        bool1 = bool2;
      }
      else
      {
        localObject1 = paramFileManagerEntity.strMiddleThumPath;
        if (arso.b((String)localObject1))
        {
          localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
          bool1 = bool2;
        }
        else
        {
          bool1 = bool2;
          if (i == 2)
          {
            localObject2 = paramFileManagerEntity.strThumbPath;
            bool1 = bool2;
            localObject1 = localObject2;
            if (arso.b((String)localObject2))
            {
              localStringBuilder.append("entity[").append(paramFileManagerEntity.nSessionId).append("] video is cloud , use thumb calc size!");
              bool1 = bool2;
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    label426:
    if (bool1)
    {
      localObject2 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      arsj.a((String)localObject1, (BitmapFactory.Options)localObject2);
      if ((paramFileManagerEntity.imgHeight <= 0) || (paramFileManagerEntity.imgWidth <= 0))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outWidth;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outHeight;
      }
      i = bayu.a((String)localObject1);
      if ((i == 90) || (i == 270))
      {
        paramFileManagerEntity.imgWidth = ((BitmapFactory.Options)localObject2).outHeight;
        paramFileManagerEntity.imgHeight = ((BitmapFactory.Options)localObject2).outWidth;
      }
    }
    for (;;)
    {
      localStringBuilder.append(" calc size over size(wh)[").append(paramFileManagerEntity.imgWidth).append(":").append(paramFileManagerEntity.imgHeight).append("]");
      localStringBuilder.append(" useImageCreateThumb:").append(bool1);
      QLog.i("FileManagerUtil<FileAssistant>", 1, localStringBuilder.toString());
      break;
      if (i == 2) {
        d(paramFileManagerEntity);
      } else {
        localStringBuilder.append("!!!!!!!!FILETYPE ERROR!!!!!!!");
      }
    }
  }
  
  public static boolean e(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    if (arso.b(paramFileManagerEntity.strFilePath)) {
      return true;
    }
    if (arso.b(paramFileManagerEntity.strMiddleThumPath)) {
      return true;
    }
    if (arso.b(paramFileManagerEntity.strLargeThumPath)) {
      return true;
    }
    if (arso.b(paramFileManagerEntity.strThumbPath)) {
      return true;
    }
    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + paramFileManagerEntity.nSessionId + "] no Thumb!");
    return false;
  }
  
  public static String f(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    int i = paramString.lastIndexOf(".");
    if ((i > 0) && (i < paramString.length() - 1)) {
      return paramString.substring(i + 1).toUpperCase();
    }
    return "";
  }
  
  public static String g(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = paramString.replace("ftn_compress_getfile", "ftn_compress_getabs");
    return paramString + "size=750&";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrr
 * JD-Core Version:    0.7.0.1
 */