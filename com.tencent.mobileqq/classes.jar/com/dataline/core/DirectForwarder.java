package com.dataline.core;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DataLineMsgRecord;
import com.tencent.mobileqq.data.DataLineMsgSet;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticAssist;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.Patterns;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.MobileQQ;

public class DirectForwarder
{
  static String a = "DirectForwarder";
  QQAppInterface b;
  
  public DirectForwarder(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private int a(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    StatisticAssist.a(this.b.getApplication().getApplicationContext(), this.b.getCurrentAccountUin(), "dl_forwardin_image");
    if ((paramString != null) && (!paramString.equals("")))
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = paramString.split(";");
      int i = 0;
      for (int j = 0; i < arrayOfString.length; j = k)
      {
        if (FileUtil.b(arrayOfString[i])) {
          paramString = arrayOfString[i];
        }
        try
        {
          paramString = URLDecoder.decode(arrayOfString[i], "UTF-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          int k;
          StringBuilder localStringBuilder;
          break label266;
        }
        catch (IllegalArgumentException paramString)
        {
          label103:
          break label103;
        }
        paramString = arrayOfString[i];
        if (!TextUtils.isEmpty(paramString))
        {
          if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
          {
            localArrayList.add(paramString);
            k = j;
          }
          else
          {
            ReportController.b(this.b, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "shareFromMigSdk|report send link:0X800492E.");
            }
            k = j;
            if (d(paramString, paramInt, paramBoolean, paramCallBack) == 0) {
              k = 1;
            }
          }
        }
        else
        {
          k = j;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("forwardImage|file path invalid. path=");
            localStringBuilder.append(paramString);
            QLog.e("qqdataline", 2, localStringBuilder.toString());
            k = j;
            break label315;
            label266:
            k = j;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("forwardImage. decode exp. imageUrls[i]=");
              paramString.append(arrayOfString[i]);
              QLog.e("qqdataline", 2, paramString.toString());
              k = j;
            }
          }
        }
        label315:
        i += 1;
      }
      if (!localArrayList.isEmpty())
      {
        if (paramBoolean) {
          if (localArrayList.size() > 1)
          {
            ReportController.b(this.b, "CliOper", "", "", "0X8004930", "0X8004930", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report send multi pic:0X8004930.");
            }
          }
          else if (localArrayList.size() == 1)
          {
            ReportController.b(this.b, "CliOper", "", "", "0X800492F", "0X800492F", 0, 0, "", "", "", "");
            if (QLog.isColorLevel()) {
              QLog.e("qqdataline", 2, "forwardImage shareFromMigSdk|report single pics:0X800492F.");
            }
          }
        }
        if (a(localArrayList, 1, paramInt, paramBoolean, paramCallBack) != 0)
        {
          if (j != 0) {
            return 0;
          }
          return 8;
        }
        return 0;
      }
      if (j != 0) {
        return 0;
      }
      return 4;
    }
    else
    {
      QLog.e(a, 2, "forwardPhoto. path=null");
      return 4;
    }
  }
  
  private int a(ArrayList<String> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if (paramArrayList == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "sendMultipleFile paths is null !!!!!!");
      }
      if (paramCallBack != null) {
        paramCallBack.b();
      }
      return 268;
    }
    if (paramBoolean)
    {
      localObject = "";
      int i = 0;
      while (i < paramArrayList.size())
      {
        ReportController.b(this.b, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("sendMultipleFile shareFromMigSdk|report send one from sdk:0X800492D.");
        localObject = localStringBuilder.toString();
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, (String)localObject);
      }
    }
    Object localObject = new DirectForwarder.1(this, paramArrayList, paramInt2);
    long l = a(paramArrayList);
    if (l == 0L)
    {
      if (paramCallBack != null) {
        paramCallBack.a();
      }
      return 128;
    }
    if ((NetworkUtil.isNetworkAvailable(this.b.getApp())) && (!NetworkUtil.isWifiConnected(this.b.getApp())) && (l > 3145728L))
    {
      if (paramCallBack != null) {
        paramCallBack.a((AsyncTask)localObject, paramInt1);
      }
      return 512;
    }
    ((AsyncTask)localObject).execute(new Integer[] { Integer.valueOf(paramInt1) });
    return 0;
  }
  
  private long a(ArrayList<String> paramArrayList)
  {
    long l = 0L;
    if (paramArrayList == null) {
      return 0L;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (str != null) {
        l += new VFSFile(str).length();
      }
    }
    return l;
  }
  
  private DataLineMsgRecord a(ForwardFileInfo paramForwardFileInfo, boolean paramBoolean, int paramInt)
  {
    FileManagerEntity localFileManagerEntity = this.b.getFileManagerDataCenter().a(paramForwardFileInfo.e());
    if (localFileManagerEntity == null) {
      return null;
    }
    int k = DataLineHandler.a(localFileManagerEntity);
    if (!DataLineHandler.l(k)) {
      return null;
    }
    int j = DataLineHandler.a(paramForwardFileInfo.i(), paramBoolean);
    int i = j;
    if (!paramBoolean)
    {
      i = j;
      if (j == 1) {
        i = 0;
      }
    }
    DataLineMsgRecord localDataLineMsgRecord = new DataLineMsgRecord();
    localDataLineMsgRecord.msgtype = DataLineHandler.b(i);
    localDataLineMsgRecord.sessionid = ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(0, paramInt).longValue();
    localDataLineMsgRecord.filename = paramForwardFileInfo.i();
    localDataLineMsgRecord.filesize = paramForwardFileInfo.j();
    localDataLineMsgRecord.fileUuid = paramForwardFileInfo.g();
    localDataLineMsgRecord.fileFrom = k;
    localDataLineMsgRecord.thumbPath = paramForwardFileInfo.p();
    if (!TextUtils.isEmpty(localFileManagerEntity.strFileMd5)) {
      localDataLineMsgRecord.md5 = HexUtil.hexStr2Bytes(localFileManagerEntity.strFileMd5);
    }
    if (!TextUtils.isEmpty(localFileManagerEntity.peerUin)) {
      localDataLineMsgRecord.uOwnerUin = Long.parseLong(localFileManagerEntity.peerUin.replace("+", ""));
    }
    if (TextUtils.isEmpty(paramForwardFileInfo.d()))
    {
      localDataLineMsgRecord.path = paramForwardFileInfo.i();
      return localDataLineMsgRecord;
    }
    localDataLineMsgRecord.path = paramForwardFileInfo.d();
    return localDataLineMsgRecord;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    String str = BaseApplicationImpl.getApplication().getBaseContext().getResources().getString(paramInt1);
    if ((str != null) && (str.length() > 0)) {
      a(str, paramInt2);
    }
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    QQToast localQQToast = new QQToast(paramContext);
    localQQToast.setToastIcon(2130839752);
    localQQToast.setDuration(2000);
    localQQToast.setToastMsg(paramInt);
    localQQToast.show(paramContext.getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(paramContext, 5.0F));
  }
  
  public static void a(Context paramContext, AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt, FMDialogUtil.FMDialogInterface paramFMDialogInterface)
  {
    FMDialogUtil.a(paramContext, 2131889584, 2131889589, new DirectForwarder.2(paramAsyncTask, paramInt, paramFMDialogInterface));
  }
  
  public static void a(String paramString, int paramInt)
  {
    Context localContext = BaseApplicationImpl.getApplication().getBaseContext();
    QQToast.makeText(localContext, paramInt, paramString, 1).show(localContext.getResources().getDimensionPixelSize(2131299920) - (int)DisplayUtils.a(localContext, 5.0F));
  }
  
  private boolean a(Bundle paramBundle, ForwardFileInfo paramForwardFileInfo, int paramInt1, int paramInt2)
  {
    if (paramForwardFileInfo == null) {
      return false;
    }
    Object localObject2 = this.b.getFileManagerDataCenter().a(paramForwardFileInfo.e());
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = localObject2;
      if (paramForwardFileInfo.o() == 10)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramForwardFileInfo.b());
        ((StringBuilder)localObject1).append("");
        localObject1 = QfavHelper.a(paramBundle, ((StringBuilder)localObject1).toString(), 7);
      }
    }
    if (localObject1 == null) {
      return false;
    }
    paramBundle = a;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ForwardOfflineFile forwardFileType: ");
    ((StringBuilder)localObject2).append(paramInt1);
    ((StringBuilder)localObject2).append(" devType:");
    ((StringBuilder)localObject2).append(paramInt2);
    QLog.i(paramBundle, 1, ((StringBuilder)localObject2).toString());
    int i = DataLineHandler.a((FileManagerEntity)localObject1);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 6)
          {
            paramBundle = a;
            paramForwardFileInfo = new StringBuilder();
            paramForwardFileInfo.append("ForwardOfflineFile fileFrom ");
            paramForwardFileInfo.append(i);
            paramForwardFileInfo.append(" is not handled");
            QLog.w(paramBundle, 1, paramForwardFileInfo.toString());
            return false;
          }
          this.b.getFileManagerEngine().a((FileManagerEntity)localObject1, "7", 6000, paramForwardFileInfo.a);
          return true;
        }
        boolean bool;
        if (paramInt1 == 101) {
          bool = true;
        } else {
          bool = false;
        }
        paramBundle = a(paramForwardFileInfo, bool, paramInt2);
        if (paramBundle == null) {
          return false;
        }
        ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramBundle, false);
        return true;
      }
      if (paramInt2 == 1) {
        paramInt1 = 6003;
      } else {
        paramInt1 = 7;
      }
      this.b.getFileManagerEngine().a(paramForwardFileInfo.e(), paramForwardFileInfo.k(), paramForwardFileInfo.b(), Long.parseLong(this.b.getCurrentAccountUin()), paramInt1, paramForwardFileInfo.a());
      return true;
    }
    this.b.getFileManagerEngine().a(3, paramForwardFileInfo.e(), paramInt2);
    return true;
  }
  
  private int b(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    StatisticAssist.a(this.b.getApplication().getApplicationContext(), this.b.getCurrentAccountUin(), "dl_forwardin_file");
    if ((paramString != null) && (!paramString.equals("")))
    {
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = paramString.split(";");
      int i = 0;
      for (int j = 0; i < arrayOfString.length; j = k)
      {
        if (FileUtil.b(arrayOfString[i])) {
          paramString = arrayOfString[i];
        }
        try
        {
          paramString = URLDecoder.decode(arrayOfString[i], "UTF-8");
        }
        catch (UnsupportedEncodingException paramString)
        {
          int k;
          StringBuilder localStringBuilder;
          break label227;
        }
        catch (IllegalArgumentException paramString)
        {
          label104:
          break label104;
        }
        paramString = arrayOfString[i];
        if (!TextUtils.isEmpty(paramString))
        {
          if ((!paramString.startsWith("http://")) && (!paramString.startsWith("https://")))
          {
            localArrayList.add(paramString);
            k = j;
          }
          else
          {
            k = j;
            if (d(paramString, paramInt, paramBoolean, paramCallBack) == 0) {
              k = 1;
            }
          }
        }
        else
        {
          k = j;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("forwardFile|file path invalid. path=");
            localStringBuilder.append(paramString);
            QLog.e("qqdataline", 2, localStringBuilder.toString());
            k = j;
            break label277;
            label227:
            k = j;
            if (QLog.isColorLevel())
            {
              paramString = new StringBuilder();
              paramString.append("forwardFile|decode exp. imageUrls[i]=");
              paramString.append(arrayOfString[i]);
              QLog.e("qqdataline", 2, paramString.toString());
              k = j;
            }
          }
        }
        label277:
        i += 1;
      }
      if (!localArrayList.isEmpty())
      {
        if (paramBoolean)
        {
          ReportController.b(this.b, "CliOper", "", "", "0X8004932", "0X8004932", 0, 0, "", "", "", "");
          if (QLog.isColorLevel()) {
            QLog.e("qqdataline", 2, "forwardFile shareFromMigSdk|report send file:0X8004932.");
          }
        }
        if (a(localArrayList, 0, paramInt, paramBoolean, paramCallBack) != 0)
        {
          if (j != 0) {
            return 0;
          }
          return 8;
        }
        return 0;
      }
      if (j != 0) {
        return 0;
      }
      return 4;
    }
    else
    {
      QLog.e(a, 2, "forwardFile. path=null");
      return 4;
    }
  }
  
  public static void b(Context paramContext, int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 2) && (paramInt != 4))
      {
        if (paramInt != 8)
        {
          if (paramInt != 9) {
            return;
          }
          a(2131892157, 0);
          return;
        }
        a(HardCodeUtil.a(2131901442), 1);
        return;
      }
      a(paramContext, 2131891339);
      return;
    }
    a(2131889669, 2);
  }
  
  private int c(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      if (Patterns.d.matcher(paramString).find()) {
        StatisticAssist.a(this.b.getApplication().getApplicationContext(), this.b.getCurrentAccountUin(), "dl_forwardin_link");
      } else {
        StatisticAssist.a(this.b.getApplication().getApplicationContext(), this.b.getCurrentAccountUin(), "dl_forwardin_text");
      }
      return d(paramString, paramInt, paramBoolean, paramCallBack);
    }
    return 4;
  }
  
  private int d(String paramString, int paramInt, boolean paramBoolean, DirectForwarder.CallBack paramCallBack)
  {
    if (TextUtils.isEmpty(paramString))
    {
      if (paramCallBack != null) {
        paramCallBack.d();
      }
      return 32;
    }
    if (paramString.length() > 3478)
    {
      if (paramCallBack != null) {
        paramCallBack.c();
      }
      return 64;
    }
    if (paramBoolean)
    {
      ReportController.b(this.b, "CliOper", "", "", "0X800492D", "0X800492D", 0, 0, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.e("qqdataline", 2, "sendTextMessage shareFromMigSdk|report send one from sdk:0X800492D.");
      }
    }
    ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramString, paramInt);
    return 0;
  }
  
  public int a(String paramString, Bundle paramBundle, DirectForwarder.CallBack paramCallBack)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return 9;
    }
    int j = paramBundle.getInt("dataline_forward_type", -1);
    Object localObject = paramBundle.getStringArrayList("dataline_forward_pathlist");
    ArrayList localArrayList = paramBundle.getParcelableArrayList("fileinfo_array");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    DataLineHandler localDataLineHandler = (DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(paramString))
    {
      localDataLineHandler.b = AppConstants.DATALINE_PC_UIN;
      localDataLineHandler.c = 0;
    }
    else
    {
      if (!AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(paramString)) {
        break label402;
      }
      localDataLineHandler.b = AppConstants.DATALINE_IPAD_UIN;
      localDataLineHandler.c = 1;
    }
    int k = localDataLineHandler.c;
    if (j == -1) {
      return 2;
    }
    if (j == 100) {
      i = 0;
    } else {
      i = 1;
    }
    if (localObject == null)
    {
      paramCallBack = null;
      paramString = paramCallBack;
      if (localArrayList == null) {}
    }
    try
    {
      paramString = (ArrayList)localArrayList;
    }
    catch (ClassCastException paramString)
    {
      for (;;)
      {
        paramString = paramCallBack;
      }
    }
    if (paramString == null) {
      return 4;
    }
    paramCallBack = new ArrayList();
    paramString = paramString.iterator();
    int i = 0;
    while (paramString.hasNext())
    {
      localObject = (ForwardFileInfo)paramString.next();
      if (a(paramBundle, (ForwardFileInfo)localObject, j, k)) {}
      for (;;)
      {
        i = 1;
        break;
        localObject = a((ForwardFileInfo)localObject, false, k);
        if (localObject == null) {
          break;
        }
        if (!DataLineMsgSet.isSingle((DataLineMsgRecord)localObject)) {
          break label284;
        }
        localArrayList = new ArrayList();
        localArrayList.add(localObject);
        localDataLineHandler.a(localArrayList, false);
      }
      label284:
      paramCallBack.add(localObject);
    }
    if (paramCallBack.size() > 0)
    {
      localDataLineHandler.a(paramCallBack, false);
      return 0;
    }
    if (i == 0) {
      return 4;
    }
    return 0;
    paramString = ((ArrayList)localObject).iterator();
    while (paramString.hasNext())
    {
      paramBundle = (String)paramString.next();
      if ((paramBundle == null) || (paramBundle.equals("/"))) {
        paramString.remove();
      }
    }
    if (!((ArrayList)localObject).isEmpty())
    {
      i = a((ArrayList)localObject, i, k, bool, paramCallBack);
      if (i == 0) {
        return 0;
      }
      return i;
    }
    return 4;
    label402:
    return 8;
  }
  
  public void a()
  {
    this.b = null;
  }
  
  public boolean a(DataLineMsgRecord paramDataLineMsgRecord, int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    if (paramDataLineMsgRecord == null)
    {
      QLog.e(a, 1, "reForwardOfflineFile msg=null ");
      return false;
    }
    if (paramDataLineMsgRecord.nOpType == 31)
    {
      TroopFileTransferManager.a(this.b, paramDataLineMsgRecord.uOwnerUin).a(paramInt2, paramDataLineMsgRecord.uOwnerUin, paramDataLineMsgRecord.busId, Long.valueOf(paramDataLineMsgRecord.selfuin).longValue(), paramDataLineMsgRecord.istroop, paramDataLineMsgRecord.filename, paramDataLineMsgRecord.thumbPath, paramDataLineMsgRecord.filesize, paramDataLineMsgRecord.fileUuid, true, paramDataLineMsgRecord.sessionid, FileManagerUtil.a(this.b, paramInt1));
      paramDataLineMsgRecord.fileMsgStatus = 0L;
      paramDataLineMsgRecord.issuc = true;
    }
    for (;;)
    {
      bool1 = true;
      break;
      if (paramDataLineMsgRecord.nOpType != 29) {
        break;
      }
      if (this.b.getFileManagerEngine().a(3, paramDataLineMsgRecord.trans2Entity(), paramInt1))
      {
        paramDataLineMsgRecord.fileMsgStatus = 0L;
        paramDataLineMsgRecord.issuc = true;
      }
    }
    boolean bool2 = bool1;
    if (3 == paramDataLineMsgRecord.fileFrom)
    {
      bool2 = bool1;
      if (!TextUtils.isEmpty(paramDataLineMsgRecord.fileUuid))
      {
        ((DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).a(paramDataLineMsgRecord, true);
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean a(FileManagerEntity paramFileManagerEntity)
  {
    Bundle localBundle = new Bundle();
    boolean bool = false;
    localBundle.putInt("forward_type", 0);
    localBundle.putBoolean("not_forward", true);
    localBundle.putInt("dataline_forward_type", 100);
    localBundle.putString("dataline_forward_path", paramFileManagerEntity.getFilePath());
    localBundle.putParcelable("fileinfo", ForwardFileOption.b(paramFileManagerEntity));
    if (b(AppConstants.DATALINE_PC_UIN, localBundle, null) == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int b(String paramString, Bundle paramBundle, DirectForwarder.CallBack paramCallBack)
  {
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext())) {
      return 9;
    }
    int i = paramBundle.getInt("dataline_forward_type", -1);
    String str1 = paramBundle.getString("dataline_forward_path");
    String str2 = paramBundle.getString("dataline_forward_text");
    boolean bool = paramBundle.getBoolean("isMigSdkShare", false);
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramBundle.getParcelable("fileinfo");
    DataLineHandler localDataLineHandler = (DataLineHandler)this.b.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
    if (AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(paramString))
    {
      localDataLineHandler.b = AppConstants.DATALINE_PC_UIN;
      localDataLineHandler.c = 0;
    }
    else
    {
      if (!AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(paramString)) {
        break label267;
      }
      localDataLineHandler.b = AppConstants.DATALINE_IPAD_UIN;
      localDataLineHandler.c = 1;
    }
    int j = localDataLineHandler.c;
    if (i == -1) {
      return 2;
    }
    if (a(paramBundle, localForwardFileInfo, i, j)) {
      return 0;
    }
    paramString = str1;
    if (paramBundle.getBoolean("filepath_copy", false)) {
      paramString = QFileUtils.d(str1);
    }
    switch (i)
    {
    default: 
      StatisticAssist.a(this.b.getApplication().getApplicationContext(), this.b.getCurrentAccountUin(), "dl_forwardin_other");
      return 4;
    case 102: 
      return c(str2, j, bool, paramCallBack);
    case 101: 
      return a(paramString, j, bool, paramCallBack);
    }
    return b(paramString, j, bool, paramCallBack);
    label267:
    return 8;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.core.DirectForwarder
 * JD-Core Version:    0.7.0.1
 */