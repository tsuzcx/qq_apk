import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class blhf
{
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 1;
    case 3: 
      return 6;
    }
    return 7;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramInt == 7220) {}
    try
    {
      a(paramQQAppInterface, "0X80098E4", "" + paramLong, "", "", "");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, arsh paramarsh, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramarsh.a.strPkgName.equals("com.android.ReadInJoy")) {
        a(paramQQAppInterface, "0X80098E6", "" + a(paramInt1), "" + paramInt2, "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MainFragment paramMainFragment, anxr paramanxr, int paramInt)
  {
    try
    {
      if ((((paramanxr instanceof ReadinjoyTabFrame)) || (paramInt == MainFragment.h)) && ((ReadinjoyTabFrame)paramMainFragment.a(ReadinjoyTabFrame.class) != null) && (paramInt == MainFragment.h) && (paramMainFragment.getActivity().getIntent().getIntExtra("launch_from", 5) == 6)) {
        a(paramQQAppInterface, "0X80098E2", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      if (((paramBaseActivity instanceof ReadInJoyNewFeedsActivity)) && (paramBaseActivity.getIntent().getIntExtra("launch_from", 5) == 6)) {
        a(paramQQAppInterface, "0X80098E2", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord.istroop == 7220) || ((paramMessageRecord.istroop == 1008) && (antf.az.equals(paramMessageRecord.frienduin))))
      {
        a(paramQQAppInterface, "0X80098E5", "" + paramMessageRecord.msgUid, "", "", "");
        return;
      }
      if (paramMessageRecord.istroop == 10007)
      {
        avlf.a(paramQQAppInterface, paramMessageRecord.frienduin, 10006, 1);
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser != null) {}
    try
    {
      if (paramRecentUser.getType() == 7220) {
        a(paramQQAppInterface, "0X80098E3", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    if (paramRecentUser != null) {
      try
      {
        if (paramRecentUser.getType() == 1008)
        {
          if (!"2173223560".equals(paramRecentBaseData.getRecentUserUin())) {
            break label145;
          }
          a(paramQQAppInterface, "0X80098E0", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
        }
        while (paramRecentUser.getType() == 7220)
        {
          a(paramQQAppInterface, "0X80098DF", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
          return;
          label145:
          if (antf.aR.equals(paramRecentBaseData.getRecentUserUin())) {
            a(paramQQAppInterface, "0X80098F2", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
          }
        }
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    bdll.b(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blhf
 * JD-Core Version:    0.7.0.1
 */