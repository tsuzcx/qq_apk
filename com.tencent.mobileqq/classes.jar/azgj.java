import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.home.MainFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qassistant.util.CommandUtils.4;
import com.tencent.mobileqq.testassister.ShareAppLogHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class azgj
{
  public static int a()
  {
    try
    {
      String str = BaseActivity.sTopActivity.getActivityName();
      if ("SplashActivity_MainFragment".equals(str))
      {
        if (FrameHelperActivity.b()) {
          return 8;
        }
        int i = MainFragment.a().a();
        if (i == MainFragment.jdField_b_of_type_Int) {
          return 1;
        }
        if (i == MainFragment.d) {
          return 2;
        }
        if (i == MainFragment.h) {
          return 9;
        }
        if (i == MainFragment.e) {
          return 10;
        }
      }
      else if (!"SplashActivity_ChatFragment".equals(str)) {}
      switch (ChatFragment.a().a.sessionInfo.curType)
      {
      default: 
        if ("FriendProfileCardActivity".equals(str)) {
          return 7;
        }
        if ("UniteSearchActivity".equals(str)) {
          return 12;
        }
        if ("QQSettingSettingActivity".equals(str)) {
          return 13;
        }
        boolean bool = "AssistantSettingActivity".equals(str);
        if (bool) {
          return 14;
        }
        break;
      }
    }
    catch (Exception localException) {}
    return 15;
    return 5;
    return 4;
    return 3;
    return 6;
  }
  
  public static int a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.hour;
  }
  
  private static long a(Set<FileInfo> paramSet, ArrayList<ForwardFileInfo> paramArrayList, ArrayList<Uri> paramArrayList1)
  {
    paramSet = paramSet.iterator();
    long l1 = 0L;
    if (paramSet.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramSet.next();
      FileManagerEntity localFileManagerEntity = aszt.a(localFileInfo);
      ForwardFileInfo localForwardFileInfo = new ForwardFileInfo();
      localForwardFileInfo.b(10000);
      localForwardFileInfo.d(localFileManagerEntity.getCloudType());
      localForwardFileInfo.b(localFileManagerEntity.nSessionId);
      localForwardFileInfo.d(localFileManagerEntity.fileName);
      localForwardFileInfo.c(localFileManagerEntity.uniseq);
      localForwardFileInfo.c(localFileManagerEntity.WeiYunFileId);
      localForwardFileInfo.d(localFileManagerEntity.fileSize);
      localForwardFileInfo.a(localFileManagerEntity.getFilePath());
      localForwardFileInfo.b(localFileManagerEntity.Uuid);
      if (!TextUtils.isEmpty(localFileManagerEntity.strLargeThumPath)) {
        localForwardFileInfo.f(localFileManagerEntity.strLargeThumPath);
      }
      for (;;)
      {
        paramArrayList1.add(Uri.parse(localFileInfo.c()));
        long l2 = localForwardFileInfo.d();
        paramArrayList.add(localForwardFileInfo);
        l1 = l2 + l1;
        break;
        if (!TextUtils.isEmpty(localFileManagerEntity.strMiddleThumPath)) {
          localForwardFileInfo.f(localFileManagerEntity.strMiddleThumPath);
        } else {
          localForwardFileInfo.f(localFileManagerEntity.strThumbPath);
        }
      }
    }
    return l1;
  }
  
  public static azfk a()
  {
    return new azfk(12, BaseApplicationImpl.getContext().getString(2131719582));
  }
  
  public static azfk a(azfm paramazfm, boolean paramBoolean)
  {
    if (paramazfm != null)
    {
      azfo localazfo = new azfo(115);
      localazfo.jdField_a_of_type_JavaLangString = paramazfm.jdField_a_of_type_JavaLangString;
      localazfo.jdField_b_of_type_JavaLangString = paramazfm.jdField_b_of_type_JavaLangString;
      localazfo.jdField_b_of_type_Int = paramazfm.jdField_a_of_type_Int;
      localazfo.jdField_a_of_type_Boolean = false;
      localazfo.jdField_b_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        paramazfm = String.format(BaseApplicationImpl.getContext().getString(2131719572), new Object[] { paramazfm.jdField_b_of_type_JavaLangString });
        paramazfm = new azfk(1, paramazfm, localazfo);
        if (paramBoolean) {
          break label126;
        }
      }
      label126:
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramazfm.jdField_a_of_type_Boolean = paramBoolean;
        return paramazfm;
        paramazfm = String.format(BaseApplicationImpl.getContext().getString(2131719575), new Object[] { paramazfm.jdField_b_of_type_JavaLangString });
        break;
      }
    }
    return null;
  }
  
  public static azfk a(azfr paramazfr)
  {
    return new azfk(9, BaseApplicationImpl.getContext().getString(2131719593), paramazfr);
  }
  
  public static azfk a(String paramString)
  {
    return new azfk(2, paramString);
  }
  
  public static azfk a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new azfp(paramString1, paramString2, paramString3);
    paramString2 = new azfk(5, "");
    paramString2.jdField_a_of_type_Azfp = paramString1;
    return paramString2;
  }
  
  public static azfk a(String paramString, List<azfm> paramList)
  {
    return new azfk(7, String.format(BaseApplicationImpl.getContext().getString(2131719576), new Object[] { paramString }), paramList);
  }
  
  public static azfk a(String paramString, boolean paramBoolean)
  {
    paramString = new azfk(3, paramString);
    paramString.jdField_a_of_type_Boolean = paramBoolean;
    return paramString;
  }
  
  public static azfk a(boolean paramBoolean)
  {
    azfk localazfk = new azfk(10, "");
    localazfk.jdField_b_of_type_Boolean = paramBoolean;
    return localazfk;
  }
  
  public static String a(long paramLong)
  {
    Time localTime = new Time();
    localTime.set(paramLong);
    return localTime.year + "-" + (localTime.month + 1) + "-" + localTime.monthDay;
  }
  
  public static void a(List<String> paramList, Activity paramActivity)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      return;
    }
    Bundle localBundle;
    Intent localIntent;
    long l;
    ArrayList localArrayList;
    HashSet localHashSet;
    try
    {
      localBundle = new Bundle();
      localIntent = new Intent();
      l = 0L;
      localArrayList = new ArrayList();
      localHashSet = new HashSet();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localHashSet.add(new FileInfo((String)paramList.next()));
      }
      paramList = new ArrayList();
    }
    catch (FileNotFoundException paramList)
    {
      paramList.printStackTrace();
      return;
    }
    if (localHashSet.size() > 0) {
      l = a(localHashSet, localArrayList, paramList) + 0L;
    }
    localBundle.putInt("forward_type", 0);
    localBundle.putParcelableArrayList("fileinfo_array", localArrayList);
    localBundle.putBoolean("not_forward", true);
    localIntent.putExtra("sendMultiple", true);
    localBundle.putParcelableArrayList("android.intent.extra.STREAM", paramList);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("foward_editbar", true);
    localIntent.putExtra("forward_type", 0);
    paramList = amtj.a(2131708740);
    if (localArrayList.size() == 1) {
      paramList = amtj.a(2131708742) + aszt.d(((ForwardFileInfo)localArrayList.get(0)).d()) + amtj.a(2131708739) + FileUtil.filesizeToString(((ForwardFileInfo)localArrayList.get(0)).d()) + "。";
    }
    for (;;)
    {
      localIntent.putExtra("forward_text", paramList);
      localIntent.putExtra("k_favorites", false);
      atky.a(paramActivity, localIntent, 103);
      return;
      if (localArrayList.size() > 1) {
        paramList = amtj.a(2131708743) + aszt.d(((ForwardFileInfo)localArrayList.get(0)).d()) + amtj.a(2131708744) + localArrayList.size() + amtj.a(2131708745) + FileUtil.filesizeToString(l) + "。";
      }
    }
  }
  
  public static azfk b()
  {
    return new azfk(6, BaseApplicationImpl.getContext().getString(2131719593));
  }
  
  public static azfk b(String paramString)
  {
    return new azfk(4, paramString);
  }
  
  public static void b(List<String> paramList, Activity paramActivity)
  {
    QLog.flushLog();
    ShareAppLogHelper localShareAppLogHelper = new ShareAppLogHelper(paramActivity);
    localShareAppLogHelper.a(new azgk(paramList, paramActivity));
    long l1 = System.currentTimeMillis();
    long l2 = l1 - 600000L;
    Object localObject = String.format("%02d", new Object[] { Integer.valueOf(a(l2)) });
    paramList = String.format("%02d", new Object[] { Integer.valueOf(a(l1)) });
    String str = a(l2);
    paramActivity = a(l1);
    localObject = ShareAppLogHelper.a(str + "-" + (String)localObject, "-");
    paramList = ShareAppLogHelper.a(paramActivity + "-" + paramList, "-");
    ThreadManagerV2.getUIHandlerV2().postDelayed(new CommandUtils.4(localShareAppLogHelper, (Time)localObject, paramList), 500L);
  }
  
  public static azfk c()
  {
    return new azfk(0, BaseApplicationImpl.getContext().getString(2131719583));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgj
 * JD-Core Version:    0.7.0.1
 */