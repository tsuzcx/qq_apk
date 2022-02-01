import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.app.Foreground;

public class bfmf
{
  protected static String a = "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fsubmit%2Fstep2%2Fstep2&_vt=3&via=tencent_csd&_sig=1454231204&_nq=billid%3D200708selfqa204d82d5";
  
  public static bhpc a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, bfmk parambfmk)
  {
    Object localObject1 = (TroopManager)paramQQAppInterface.getManager(52);
    boolean bool1;
    boolean bool2;
    label59:
    boolean bool4;
    label84:
    boolean bool3;
    label107:
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((TroopManager)localObject1).b(paramString);
      if (localObject1 != null) {
        if ((((TroopInfo)localObject1).dwAdditionalFlag & 1L) == 1L)
        {
          bool1 = true;
          if ((((TroopInfo)localObject1).dwCmdUinUinFlag & 1L) != 1L) {
            break label460;
          }
          bool2 = true;
          boolean bool5 = a(paramString);
          if (System.currentTimeMillis() >= ((TroopInfo)localObject1).appealDeadline * 1000L) {
            break label466;
          }
          bool4 = true;
          if (((!bool1) && (!bool2)) || (!bool4) || (!bool5)) {
            break label472;
          }
          bool3 = true;
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUtils", 2, "showConstantBlockDialog. isOwner = " + bool1 + ", isAdmin = " + bool2 + ", appealDeadline = " + ((TroopInfo)localObject1).appealDeadline + ", isWithAppealPeriod = " + bool4 + ", isGrayTroop = " + bool5 + ", canAppeal = " + bool3);
          }
          if (!bool3) {
            break label586;
          }
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(((TroopInfo)localObject1).appealDeadline * 1000L);
          localObject1 = paramActivity.getString(2131696615, new Object[] { Integer.valueOf(((Calendar)localObject2).get(1)), Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) });
          bool4 = bool3;
          bool3 = bool1;
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      localObject2 = bhlq.a(paramActivity, 230).setTitle(paramActivity.getString(2131696616)).setMessage(2131696614);
      if ((bool1) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
        ((bhpc)localObject2).setMessage((CharSequence)localObject1);
      }
      if ((bool3) || (bool2))
      {
        bdll.b(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
        label356:
        if (!bool1) {
          break label505;
        }
        ((bhpc)localObject2).setPositiveButton(paramActivity.getString(2131696613), new bfmg(paramQQAppInterface, paramString, paramActivity));
        ((bhpc)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696613));
        label394:
        if ((!bool3) && (!bool2)) {
          break label580;
        }
      }
      label580:
      for (bool1 = true;; bool1 = false)
      {
        ((bhpc)localObject2).setNegativeButton(paramActivity.getString(2131714056), new bfmj(parambfmk, bool1));
        ((bhpc)localObject2).setNegativeButtonContentDescription(paramActivity.getString(2131714056));
        ((bhpc)localObject2).setCancelable(false);
        ((bhpc)localObject2).show();
        return localObject2;
        bool1 = false;
        break;
        label460:
        bool2 = false;
        break label59;
        label466:
        bool4 = false;
        break label84;
        label472:
        bool3 = false;
        break label107;
        bdll.b(null, "dc00898", "", "", "0X800B225", "0X800B225", 0, 0, "", "", "", "");
        break label356;
        label505:
        if (bool3)
        {
          ((bhpc)localObject2).setPositiveButton(paramActivity.getString(2131696612), new bfmh(paramQQAppInterface, paramString));
          ((bhpc)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696612));
          break label394;
        }
        ((bhpc)localObject2).setPositiveButton(paramActivity.getString(2131696611), new bfmi(paramQQAppInterface, paramString));
        ((bhpc)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696611));
        break label394;
      }
      label586:
      bool4 = bool1;
      localObject1 = "";
      bool1 = bool3;
      bool3 = bool4;
      continue;
      localObject1 = "";
      bool1 = false;
      bool2 = false;
      bool3 = false;
    }
  }
  
  public static void a(amnx paramamnx, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      if (b(localQQAppInterface, paramString))
      {
        paramamnx.b.setImageResource(2130850693);
        paramString = paramamnx.b.getLayoutParams();
        if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
        {
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-bhtq.b(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-bhtq.b(3.0F));
        }
        if (paramamnx.d != null)
        {
          paramamnx.d.setVisibility(0);
          if (!bdgb.b()) {
            break label129;
          }
          paramamnx.d.setBackgroundResource(2130842448);
        }
      }
    }
    label129:
    while (paramamnx.d == null)
    {
      do
      {
        return;
        paramamnx.d.setBackgroundResource(2130842447);
        return;
      } while (paramamnx.d == null);
      paramamnx.d.setVisibility(8);
      return;
    }
    paramamnx.d.setVisibility(8);
  }
  
  public static void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131377963);
    paramView = (ImageView)paramView.findViewById(2131369276);
    if (localImageView != null)
    {
      if (paramInt1 != 1) {
        break label237;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {
        break label219;
      }
      if (!b(localQQAppInterface, paramString)) {
        break label201;
      }
      localImageView.setImageResource(2130850693);
      localImageView.setVisibility(0);
      paramString = localImageView.getLayoutParams();
      if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
      {
        if (paramInt2 != 2) {
          break label164;
        }
        ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-bhtq.b(6.0F));
        ((RelativeLayout.LayoutParams)paramString).rightMargin = (-bhtq.b(3.0F));
      }
      if (paramView != null)
      {
        paramView.setVisibility(0);
        if (!bdgb.b()) {
          break label193;
        }
        paramView.setBackgroundResource(2130842448);
      }
    }
    label164:
    label193:
    label201:
    label219:
    label237:
    do
    {
      do
      {
        do
        {
          return;
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-bhtq.b(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-bhtq.b(3.0F));
          break;
          paramView.setBackgroundResource(2130842447);
          return;
          localImageView.setVisibility(8);
        } while (paramView == null);
        paramView.setVisibility(8);
        return;
        localImageView.setVisibility(8);
      } while (paramView == null);
      paramView.setVisibility(8);
      return;
      localImageView.setVisibility(8);
    } while (paramView == null);
    paramView.setVisibility(8);
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ((aoip)paramQQAppInterface.a(20)).notifyUI(80, true, null);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("uin");
    if ((paramIntent.getIntExtra("uintype", -1) == 1) && (str != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBlockUtils", 2, "checkBlockTroopBeforeEnterAio");
      }
      if (b(paramQQAppInterface, str))
      {
        if ((paramActivity instanceof ChatActivity))
        {
          paramIntent = Foreground.getTopActivity();
          if (paramIntent != null)
          {
            paramActivity.finish();
            a(paramIntent, paramQQAppInterface, str, null);
            return true;
          }
          a(paramActivity, paramQQAppInterface, str, null);
          return true;
        }
        a(paramActivity, paramQQAppInterface, str, null);
        return true;
      }
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a(paramString, false, false);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.isTroopBlocked;
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    bfmd localbfmd = (bfmd)aran.a().a(673);
    if ((localbfmd != null) && (localbfmd.a(paramString))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopBlockUtils", 2, "isGrayTroop = " + bool);
      }
      return bool;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.isTroopBlocked;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "isConstantBlockTroop. TroopManager is null. isConstantBlockTroop = false");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfmf
 * JD-Core Version:    0.7.0.1
 */