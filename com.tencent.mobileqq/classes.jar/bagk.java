import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.teamwork.TeamWorkFileImportInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class bagk
{
  public static bety a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    bagw localbagw = (bagw)paramQQAppInterface.a(120);
    if ((paramContext == null) || (localbagw == null) || (paramTeamWorkFileImportInfo == null) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1)) {
      return null;
    }
    paramTeamWorkFileImportInfo.g = 6;
    return a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString);
  }
  
  public static bety a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString)
  {
    paramQQAppInterface = (bagw)paramQQAppInterface.a(120);
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null) || (!a(paramTeamWorkFileImportInfo))) {}
    do
    {
      return null;
      paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean = true;
      paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = true;
      if ((!paramQQAppInterface.a(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(paramQQAppInterface.a(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        paramQQAppInterface.a(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((paramQQAppInterface.a(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
    } while ((TextUtils.isEmpty(paramQQAppInterface.a(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean));
    paramString = new Bundle();
    paramString.putString("url", paramQQAppInterface.a(paramTeamWorkFileImportInfo));
    paramString.putBoolean("temp_preview_from_qq", true);
    paramString.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    if (paramTeamWorkFileImportInfo.d()) {
      paramString.putString("tdsourcetag", "s_qq_file_preview");
    }
    for (;;)
    {
      TeamWorkDocEditBrowserActivity.a(paramContext, paramString, false);
      return null;
      paramString.putString("tdsourcetag", "s_qq_file_edit");
    }
  }
  
  public static bety a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    bagw localbagw = (bagw)paramQQAppInterface.a(120);
    if ((localbagw == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    do
    {
      return null;
      paramTeamWorkFileImportInfo.jdField_e_of_type_Boolean = true;
      if (paramString2.equals(paramContext.getString(2131720691))) {}
      for (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = true;; paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean = false)
      {
        localbagw.a(paramTeamWorkFileImportInfo, paramBoolean);
        if ((localbagw.a(paramTeamWorkFileImportInfo)) || (!TextUtils.isEmpty(localbagw.a(paramTeamWorkFileImportInfo))) || (!paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean)) {
          break;
        }
        localbagw.a(paramTeamWorkFileImportInfo);
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((localbagw.a(paramTeamWorkFileImportInfo)) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        a(paramContext, paramTeamWorkFileImportInfo, null);
        return null;
      }
      if ((!TextUtils.isEmpty(localbagw.a(paramTeamWorkFileImportInfo))) && (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean))
      {
        paramQQAppInterface = new Bundle();
        paramQQAppInterface.putString("url", localbagw.a(paramTeamWorkFileImportInfo));
        paramQQAppInterface.putBoolean("temp_preview_from_qq", true);
        paramQQAppInterface.putParcelable("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
        if (paramTeamWorkFileImportInfo.d()) {
          paramQQAppInterface.putString("tdsourcetag", "s_qq_file_preview");
        }
        for (;;)
        {
          TeamWorkDocEditBrowserActivity.a(paramContext, paramQQAppInterface, false);
          return null;
          paramQQAppInterface.putString("tdsourcetag", "s_qq_file_edit");
        }
      }
    } while (paramTeamWorkFileImportInfo.jdField_d_of_type_Boolean);
    a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString1, paramString2, paramBoolean);
    return null;
  }
  
  public static String a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1) {
      return paramTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString;
    }
    return paramTeamWorkFileImportInfo.o;
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {}
    for (String str = "0X800A750";; str = "0X800A751")
    {
      azqs.b(null, "dc00898", "", "", str, str, paramInt2, 0, "", "", "", "");
      do
      {
        return;
      } while (paramInt1 != 1);
    }
  }
  
  public static void a(Context paramContext, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    int i = 1;
    paramString = new Intent(paramContext, TeamWorkDocEditBrowserActivity.class);
    paramString.putExtra("key_team_work_file_import_info", paramTeamWorkFileImportInfo);
    paramString.putExtra("temp_preview_from_qq", true);
    paramString.putExtra("temp_preview_show_loading", true);
    if (paramTeamWorkFileImportInfo != null) {
      if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 1)
      {
        paramString.putExtra("tdsourcetag", "s_qq_aio_edit");
        i = 0;
        j = i;
        if (baic.jdField_a_of_type_JavaUtilMap.containsKey(Integer.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int))) {
          paramString.putExtra("tdsourcetag", (String)baic.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramTeamWorkFileImportInfo.jdField_d_of_type_Int)));
        }
      }
    }
    for (int j = i;; j = 0)
    {
      TeamWorkDocEditBrowserActivity.a(paramString, null, paramContext);
      paramString.addFlags(536870912);
      if (((paramContext instanceof Activity)) && (j != 0) && (b(paramString.getStringExtra("tdsourcetag"))))
      {
        ((Activity)paramContext).startActivityForResult(paramString, 14002);
        return;
        if (paramTeamWorkFileImportInfo.jdField_d_of_type_Int == 5)
        {
          paramString.putExtra("tdsourcetag", "s_QQ_file_share_edit");
          break;
        }
        if (paramTeamWorkFileImportInfo.d())
        {
          paramString.putExtra("tdsourcetag", "s_qq_file_preview");
          i = 0;
          break;
        }
        paramString.putExtra("tdsourcetag", "s_qq_file_edit");
        break;
      }
      paramContext.startActivity(paramString);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, bago parambago)
  {
    if (paramContext == null) {
      QLog.w(paramString, 1, "no context to show dialog");
    }
    do
    {
      return;
      if (b(paramTeamWorkFileImportInfo)) {
        break;
      }
      a(paramQQAppInterface, paramTeamWorkFileImportInfo);
      c(paramTeamWorkFileImportInfo);
      paramQQAppInterface = a(paramQQAppInterface, paramTeamWorkFileImportInfo, paramContext, paramString, paramContext.getString(2131720691), true);
    } while (parambago == null);
    parambago.a(paramQQAppInterface);
    return;
    bhuf localbhuf = (bhuf)bhus.a(paramContext, null);
    String str3;
    String str2;
    if (paramTeamWorkFileImportInfo.d())
    {
      str3 = paramContext.getString(2131692035);
      str2 = paramContext.getString(2131692031);
    }
    for (String str1 = paramContext.getString(2131692033);; str1 = paramContext.getString(2131692032))
    {
      localbhuf.a(2131692036);
      localbhuf.b(str3);
      localbhuf.a(str2, 5);
      localbhuf.a(str1, 5);
      localbhuf.c(2131690648);
      localbhuf.a(new bagl(paramTeamWorkFileImportInfo, localbhuf, paramQQAppInterface, paramContext, paramString, parambago));
      localbhuf.show();
      if (!paramTeamWorkFileImportInfo.d()) {
        break;
      }
      bajr.a(paramQQAppInterface, "0X8009ED0");
      return;
      str3 = paramContext.getString(2131692034);
      str2 = paramContext.getString(2131692029);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramQQAppInterface == null) || (paramTeamWorkFileImportInfo == null)) {}
    do
    {
      return;
      paramQQAppInterface = (bagw)paramQQAppInterface.a(120);
    } while ((paramQQAppInterface == null) || (!paramQQAppInterface.a(paramTeamWorkFileImportInfo)) || ((paramTeamWorkFileImportInfo.g != 1) && (paramTeamWorkFileImportInfo.g != 2)));
    paramQQAppInterface.c(paramTeamWorkFileImportInfo);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    bagw localbagw = (bagw)paramQQAppInterface.a(120);
    if ((localbagw == null) || (paramTeamWorkFileImportInfo == null) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return;
      String str1 = String.format(paramContext.getString(2131720724), new Object[] { paramString2 });
      int k = aoxg.a().a();
      int m = aoxg.a().b();
      int j = 1;
      int i;
      if (!bdiv.b(paramQQAppInterface.getApp(), "com.tencent.tim", "775E696D09856872FDD8AB4F3F06B1E0"))
      {
        paramString2 = String.format(paramContext.getString(2131720724), new Object[] { paramString2 });
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "jumpTimLogin tim not install ");
        }
        i = 0;
        if (i == 0) {
          break label399;
        }
        paramContext = new Bundle();
        if (paramBoolean) {
          break label388;
        }
        if (k == -1) {
          QLog.i(paramString1, 1, "tim entry not defined");
        }
        paramContext.putBoolean("isOpenTeamWork", false);
        paramContext.putInt("timEntry", k);
      }
      for (;;)
      {
        for (;;)
        {
          paramContext.putString("teamworkUrl", localbagw.a(paramTeamWorkFileImportInfo));
          paramContext.putInt("peerType", paramTeamWorkFileImportInfo.jdField_a_of_type_Int);
          paramContext.putString("peerUin", paramTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString);
          paramContext.putInt("busId", paramTeamWorkFileImportInfo.jdField_b_of_type_Int);
          paramContext.putLong("uniSeq", paramTeamWorkFileImportInfo.jdField_a_of_type_Long);
          ((auah)paramQQAppInterface.getManager(242)).a(paramContext);
          return;
          String str2 = bdiv.a(paramQQAppInterface.getApp(), "com.tencent.tim");
          if (QLog.isColorLevel()) {
            QLog.d(paramString1, 2, "jumpTimLogin tim timVersion=" + str2);
          }
          try
          {
            int n = Integer.parseInt(str2.replace(".", ""));
            if (n == 0)
            {
              paramString2 = String.format(paramContext.getString(2131720724), new Object[] { paramString2 });
              i = 0;
              break;
            }
            i = j;
            paramString2 = str1;
            if (n >= m) {
              break;
            }
            paramString2 = paramContext.getString(2131720803);
            i = 0;
          }
          catch (Exception paramString2)
          {
            QLog.w(paramString1, 1, paramString2.toString());
            i = j;
            paramString2 = str1;
          }
        }
        break;
        label388:
        paramContext.putBoolean("isOpenTeamWork", true);
      }
      label399:
      paramQQAppInterface = bdgm.a(paramContext, 0);
      paramQQAppInterface.setMessage(paramString2);
      paramQQAppInterface.setPositiveButton(paramContext.getString(2131691976), new bagm(paramContext, paramString1));
      paramQQAppInterface.setNegativeButton(paramContext.getString(2131693480), new bagn(paramQQAppInterface));
      try
      {
        if (!paramQQAppInterface.isShowing())
        {
          paramQQAppInterface.show();
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        QLog.e(paramString1, 1, "mDialog.show() exception" + paramQQAppInterface.toString());
      }
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if ((paramTeamWorkFileImportInfo == null) || (paramTeamWorkFileImportInfo.jdField_a_of_type_Int != 1)) {}
    label65:
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.sApplication.getRuntime();
      if ((localObject instanceof QQAppInterface)) {}
      for (localObject = (QQAppInterface)localObject;; localObject = null)
      {
        if (localObject == null) {
          break label65;
        }
        localObject = (bagw)((QQAppInterface)localObject).a(120);
        if (localObject == null) {
          break;
        }
        paramTeamWorkFileImportInfo.g = 7;
        ((bagw)localObject).a(paramTeamWorkFileImportInfo);
        return;
      }
    }
  }
  
  public static void a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, String paramString)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      QLog.d(paramString, 2, "try pre import");
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      bagw localbagw = (bagw)localQQAppInterface.a(120);
      if ((!localbagw.a(paramTeamWorkFileImportInfo)) && (TextUtils.isEmpty(localbagw.a(paramTeamWorkFileImportInfo))))
      {
        QLog.i(paramString, 1, " parseFileImportTendoc: no cache");
        paramTeamWorkFileImportInfo.g = 1;
        localbagw.a(paramTeamWorkFileImportInfo);
        return;
      }
      if (paramTeamWorkFileImportInfo.d())
      {
        QLog.i(paramString, 1, " parseFileImportTendoc: has cache, but online preview, drop it");
        localbagw.c(paramTeamWorkFileImportInfo);
        localbagw.e(paramTeamWorkFileImportInfo);
        paramTeamWorkFileImportInfo.g = 1;
        localbagw.a(paramTeamWorkFileImportInfo);
        return;
      }
      QLog.i(paramString, 1, " parseFileImportTendoc: has cache");
      paramTeamWorkFileImportInfo.g = 2;
      paramTeamWorkFileImportInfo.h = 1;
    } while (!paramTeamWorkFileImportInfo.d());
    bajr.a(localQQAppInterface, "0X8009ECF");
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFilePath;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    if (paramInt == 6)
    {
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
      localTeamWorkFileImportInfo.jdField_c_of_type_Boolean = true;
    }
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramQQAppInterface, paramInt);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    if (paramFileManagerEntity == null) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    localTeamWorkFileImportInfo.jdField_c_of_type_JavaLangString = paramFileManagerEntity.strFilePath;
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = paramFileManagerEntity.fileName;
    localTeamWorkFileImportInfo.jdField_e_of_type_Int = paramFileManagerEntity.nFileType;
    localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt1;
    localTeamWorkFileImportInfo.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
    localTeamWorkFileImportInfo.jdField_c_of_type_Int = paramInt2;
    if (paramInt1 == 6)
    {
      localTeamWorkFileImportInfo.jdField_b_of_type_Boolean = false;
      localTeamWorkFileImportInfo.jdField_c_of_type_Boolean = true;
    }
    localTeamWorkFileImportInfo.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    localTeamWorkFileImportInfo.jdField_a_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    localTeamWorkFileImportInfo.jdField_e_of_type_JavaLangString = String.valueOf(paramFileManagerEntity.TroopUin);
    localTeamWorkFileImportInfo.jdField_b_of_type_Int = paramFileManagerEntity.busId;
    localTeamWorkFileImportInfo.jdField_d_of_type_JavaLangString = paramFileManagerEntity.strTroopFilePath;
    localTeamWorkFileImportInfo.jdField_a_of_type_Long = paramFileManagerEntity.uniseq;
    if (paramFileManagerEntity.status != 16) {
      localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    }
    return a(localTeamWorkFileImportInfo, paramContext, paramQQAppInterface, paramInt1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    return (paramTeamWorkFileImportInfo != null) && ((paramTeamWorkFileImportInfo.g == 6) || (paramTeamWorkFileImportInfo.g == 7)) && (paramTeamWorkFileImportInfo.jdField_a_of_type_Int == 1);
  }
  
  public static boolean a(TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Context paramContext, QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (!bdin.d(BaseApplicationImpl.getContext()))
    {
      QQToast.a(paramContext, alud.a(2131715168), 1).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131298914));
      return false;
    }
    if (paramInt == 9) {
      paramTeamWorkFileImportInfo.jdField_d_of_type_Int = paramInt;
    }
    bagw localbagw = (bagw)paramQQAppInterface.a(120);
    paramQQAppInterface = null;
    if (!TextUtils.isEmpty(localbagw.a(paramTeamWorkFileImportInfo))) {
      paramQQAppInterface = localbagw.a(paramTeamWorkFileImportInfo);
    }
    if (!localbagw.a(paramTeamWorkFileImportInfo)) {
      localbagw.a(paramTeamWorkFileImportInfo);
    }
    if (!paramTeamWorkFileImportInfo.a()) {
      a(paramContext, paramTeamWorkFileImportInfo, paramQQAppInterface);
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (aoyt.a(Uri.parse(paramString).getHost()));
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return false;
    }
    TeamWorkFileImportInfo localTeamWorkFileImportInfo = new TeamWorkFileImportInfo();
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    localTeamWorkFileImportInfo.jdField_b_of_type_JavaLangString = str;
    localTeamWorkFileImportInfo.f = paramString1;
    localTeamWorkFileImportInfo.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    localTeamWorkFileImportInfo.jdField_a_of_type_Boolean = true;
    localTeamWorkFileImportInfo.jdField_d_of_type_Int = 12;
    paramString1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramString1 instanceof QQAppInterface)) {
      a(localTeamWorkFileImportInfo, BaseApplicationImpl.getContext(), (QQAppInterface)paramString1, localTeamWorkFileImportInfo.jdField_d_of_type_Int);
    }
    for (;;)
    {
      return true;
      paramString1 = new Bundle();
      paramString1.putParcelable("key_team_work_file_import_info", localTeamWorkFileImportInfo);
      paramString1 = apml.a("ipc_cmd_convert_team_work_url_2_doc", "", -1, paramString1);
      aprh.a().a(paramString1);
    }
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5));
  }
  
  public static boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return false;
    }
    Object localObject = paramJSONObject.optJSONArray("urls");
    if (localObject == null) {}
    for (localObject = null;; localObject = ((JSONArray)localObject).optString(0)) {
      return a((String)localObject, paramJSONObject.optString("filename"), paramJSONObject.optString("cookie"), paramJSONObject.optString("filetype"), paramJSONObject.optString("fileid"));
    }
  }
  
  public static void b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject == null) {}
      do
      {
        return;
        localObject = (bagw)((QQAppInterface)localObject).a(120);
      } while (localObject == null);
      paramTeamWorkFileImportInfo.g = 1;
      ((bagw)localObject).a(paramTeamWorkFileImportInfo);
      return;
    }
  }
  
  private static boolean b(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    while ((paramTeamWorkFileImportInfo.d()) || ((paramTeamWorkFileImportInfo.h != 2) && (paramTeamWorkFileImportInfo.h != 1))) {
      return false;
    }
    return true;
  }
  
  private static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    paramString = (String)baic.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (paramString == null) {
      return false;
    }
    aort localaort = (aort)aoks.a().a(418);
    if (localaort == null) {
      return false;
    }
    paramString = (aoru)localaort.a().get(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.a();
  }
  
  private static void c(TeamWorkFileImportInfo paramTeamWorkFileImportInfo)
  {
    if (paramTeamWorkFileImportInfo == null) {}
    while ((paramTeamWorkFileImportInfo.g == 0) || (paramTeamWorkFileImportInfo.g == 4)) {
      return;
    }
    paramTeamWorkFileImportInfo.g = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bagk
 * JD-Core Version:    0.7.0.1
 */