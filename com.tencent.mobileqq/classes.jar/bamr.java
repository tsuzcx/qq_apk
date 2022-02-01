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

public class bamr
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
      FileManagerEntity localFileManagerEntity = auea.a(localFileInfo);
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
  
  public static balb a()
  {
    return new balb(12, BaseApplicationImpl.getContext().getString(2131720035));
  }
  
  public static balb a(bald parambald, boolean paramBoolean)
  {
    if (parambald != null)
    {
      balf localbalf = new balf(115);
      localbalf.jdField_a_of_type_JavaLangString = parambald.jdField_a_of_type_JavaLangString;
      localbalf.jdField_b_of_type_JavaLangString = parambald.jdField_b_of_type_JavaLangString;
      localbalf.jdField_b_of_type_Int = parambald.jdField_a_of_type_Int;
      localbalf.jdField_a_of_type_Boolean = false;
      localbalf.jdField_b_of_type_Boolean = paramBoolean;
      if (paramBoolean)
      {
        parambald = String.format(BaseApplicationImpl.getContext().getString(2131720025), new Object[] { parambald.jdField_b_of_type_JavaLangString });
        parambald = new balb(1, parambald, localbalf);
        if (paramBoolean) {
          break label126;
        }
      }
      label126:
      for (paramBoolean = true;; paramBoolean = false)
      {
        parambald.jdField_a_of_type_Boolean = paramBoolean;
        return parambald;
        parambald = String.format(BaseApplicationImpl.getContext().getString(2131720028), new Object[] { parambald.jdField_b_of_type_JavaLangString });
        break;
      }
    }
    return null;
  }
  
  public static balb a(bali parambali)
  {
    return new balb(9, BaseApplicationImpl.getContext().getString(2131720046), parambali);
  }
  
  public static balb a(String paramString)
  {
    return new balb(2, paramString);
  }
  
  public static balb a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = new balg(paramString1, paramString2, paramString3);
    paramString2 = new balb(5, "");
    paramString2.jdField_a_of_type_Balg = paramString1;
    return paramString2;
  }
  
  public static balb a(String paramString, List<bald> paramList)
  {
    return new balb(7, String.format(BaseApplicationImpl.getContext().getString(2131720029), new Object[] { paramString }), paramList);
  }
  
  public static balb a(String paramString, boolean paramBoolean)
  {
    paramString = new balb(3, paramString);
    paramString.jdField_a_of_type_Boolean = paramBoolean;
    return paramString;
  }
  
  public static balb a(boolean paramBoolean)
  {
    balb localbalb = new balb(10, "");
    localbalb.jdField_b_of_type_Boolean = paramBoolean;
    return localbalb;
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
    paramList = anvx.a(2131709087);
    if (localArrayList.size() == 1) {
      paramList = anvx.a(2131709089) + auea.d(((ForwardFileInfo)localArrayList.get(0)).d()) + anvx.a(2131709086) + FileUtil.filesizeToString(((ForwardFileInfo)localArrayList.get(0)).d()) + "。";
    }
    for (;;)
    {
      localIntent.putExtra("forward_text", paramList);
      localIntent.putExtra("k_favorites", false);
      aupt.a(paramActivity, localIntent, 103);
      return;
      if (localArrayList.size() > 1) {
        paramList = anvx.a(2131709090) + auea.d(((ForwardFileInfo)localArrayList.get(0)).d()) + anvx.a(2131709091) + localArrayList.size() + anvx.a(2131709092) + FileUtil.filesizeToString(l) + "。";
      }
    }
  }
  
  public static balb b()
  {
    return new balb(6, BaseApplicationImpl.getContext().getString(2131720046));
  }
  
  public static balb b(String paramString)
  {
    return new balb(4, paramString);
  }
  
  public static void b(List<String> paramList, Activity paramActivity)
  {
    QLog.flushLog();
    ShareAppLogHelper localShareAppLogHelper = new ShareAppLogHelper(paramActivity);
    localShareAppLogHelper.a(new bams(paramList, paramActivity));
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
  
  public static balb c()
  {
    return new balb(0, BaseApplicationImpl.getContext().getString(2131720036));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bamr
 * JD-Core Version:    0.7.0.1
 */