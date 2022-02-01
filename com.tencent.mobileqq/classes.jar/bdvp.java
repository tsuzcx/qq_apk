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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import mqq.app.Foreground;

public class bdvp
{
  protected static String a = "mqqapi://miniapp/open?_atype=0&_mappid=1109048181&_mvid=&_path=pages%2Fsubmit%2Fstep2%2Fstep2&_vt=3&via=tencent_csd&_sig=1454231204&_nq=billid%3D200708selfqa204d82d5";
  
  public static QQCustomDialog a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString, bdvu parambdvu)
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
            break label467;
          }
          bool2 = true;
          boolean bool5 = a(paramString);
          if (System.currentTimeMillis() >= ((TroopInfo)localObject1).appealDeadline * 1000L) {
            break label473;
          }
          bool4 = true;
          if (((!bool1) && (!bool2)) || (!bool4) || (!bool5)) {
            break label479;
          }
          bool3 = true;
          if (QLog.isColorLevel()) {
            QLog.d("TroopBlockUtils", 2, "showConstantBlockDialog. isOwner = " + bool1 + ", isAdmin = " + bool2 + ", appealDeadline = " + ((TroopInfo)localObject1).appealDeadline + ", isWithAppealPeriod = " + bool4 + ", isGrayTroop = " + bool5 + ", canAppeal = " + bool3);
          }
          if (!bool3) {
            break label631;
          }
          localObject2 = Calendar.getInstance();
          ((Calendar)localObject2).setTimeInMillis(((TroopInfo)localObject1).appealDeadline * 1000L);
          localObject1 = paramActivity.getString(2131696756, new Object[] { Integer.valueOf(((Calendar)localObject2).get(1)), Integer.valueOf(((Calendar)localObject2).get(2) + 1), Integer.valueOf(((Calendar)localObject2).get(5)) });
          bool4 = bool3;
          bool3 = bool1;
          bool1 = bool4;
        }
      }
    }
    for (;;)
    {
      for (;;)
      {
        localObject2 = bfur.a(paramActivity, 230).setTitle(paramActivity.getString(2131696757)).setMessage(2131696755);
        if ((bool1) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          ((QQCustomDialog)localObject2).setMessage((CharSequence)localObject1);
        }
        if ((bool3) || (bool2))
        {
          bcef.b(null, "dc00898", "", "", "0X800B222", "0X800B222", 0, 0, "", "", "", "");
          label356:
          if (!bool1) {
            break label512;
          }
          ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131696754), new bdvq(paramQQAppInterface, paramString, paramActivity));
          ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696754));
          label394:
          if ((!bool3) && (!bool2)) {
            break label587;
          }
          bool1 = true;
          ((QQCustomDialog)localObject2).setNegativeButton(paramActivity.getString(2131714288), new bdvt(parambdvu, bool1));
          ((QQCustomDialog)localObject2).setNegativeButtonContentDescription(paramActivity.getString(2131714288));
          ((QQCustomDialog)localObject2).setCancelable(false);
        }
        try
        {
          if (!paramActivity.isFinishing()) {
            ((QQCustomDialog)localObject2).show();
          }
          return localObject2;
          bool1 = false;
          break;
          label467:
          bool2 = false;
          break label59;
          label473:
          bool4 = false;
          break label84;
          label479:
          bool3 = false;
          break label107;
          bcef.b(null, "dc00898", "", "", "0X800B225", "0X800B225", 0, 0, "", "", "", "");
          break label356;
          label512:
          if (bool3)
          {
            ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131696753), new bdvr(paramQQAppInterface, paramString));
            ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696753));
            break label394;
          }
          ((QQCustomDialog)localObject2).setPositiveButton(paramActivity.getString(2131696752), new bdvs(paramQQAppInterface, paramString));
          ((QQCustomDialog)localObject2).setPositiveButtonContentDescription(paramActivity.getString(2131696752));
          break label394;
          label587:
          bool1 = false;
        }
        catch (Exception paramActivity)
        {
          while (!QLog.isColorLevel()) {}
          QLog.e("TroopBlockUtils", 2, "showConstantBlockDialog exception: " + paramActivity.getMessage());
          return localObject2;
        }
      }
      label631:
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
  
  public static void a(alir paramalir, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface != null) && (!TextUtils.isEmpty(paramString))) {
      if (b(localQQAppInterface, paramString))
      {
        paramalir.b.setImageResource(2130850618);
        paramString = paramalir.b.getLayoutParams();
        if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
        {
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.dpToPx(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.dpToPx(3.0F));
        }
        if (paramalir.d != null)
        {
          paramalir.d.setVisibility(0);
          if (!bbyp.b()) {
            break label129;
          }
          paramalir.d.setBackgroundResource(2130842494);
        }
      }
    }
    label129:
    while (paramalir.d == null)
    {
      do
      {
        return;
        paramalir.d.setBackgroundResource(2130842493);
        return;
      } while (paramalir.d == null);
      paramalir.d.setVisibility(8);
      return;
    }
    paramalir.d.setVisibility(8);
  }
  
  public static void a(View paramView, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopBlockUtils", 2, "updateSearchResultItemViewStatus");
    }
    ImageView localImageView = (ImageView)paramView.findViewById(2131377732);
    paramView = (ImageView)paramView.findViewById(2131369292);
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
      localImageView.setImageResource(2130850618);
      localImageView.setVisibility(0);
      paramString = localImageView.getLayoutParams();
      if ((paramString != null) && ((paramString instanceof RelativeLayout.LayoutParams)))
      {
        if (paramInt2 != 2) {
          break label164;
        }
        ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.dpToPx(6.0F));
        ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.dpToPx(3.0F));
      }
      if (paramView != null)
      {
        paramView.setVisibility(0);
        if (!bbyp.b()) {
          break label193;
        }
        paramView.setBackgroundResource(2130842494);
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
          ((RelativeLayout.LayoutParams)paramString).bottomMargin = (-ViewUtils.dpToPx(3.0F));
          ((RelativeLayout.LayoutParams)paramString).rightMargin = (-ViewUtils.dpToPx(3.0F));
          break;
          paramView.setBackgroundResource(2130842493);
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
    ((anca)paramQQAppInterface.getBusinessHandler(20)).notifyUI(80, true, null);
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
          if ((paramIntent != null) && (paramIntent != paramActivity))
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
    bdvn localbdvn = (bdvn)apub.a().a(673);
    if ((localbdvn != null) && (localbdvn.a(paramString))) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvp
 * JD-Core Version:    0.7.0.1
 */