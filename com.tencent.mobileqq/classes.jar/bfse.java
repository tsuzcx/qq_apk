import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.util.SecurePhoneBannerManager.7;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.TipsBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class bfse
{
  private static volatile bfse jdField_a_of_type_Bfse;
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  private String d;
  
  private Dialog a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    ReportDialog localReportDialog = new ReportDialog(paramContext, 2131755230);
    View localView = LayoutInflater.from(paramContext).inflate(2131560971, null);
    Object localObject1 = localReportDialog.getWindow();
    if ((localObject1 != null) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      ((Window)localObject1).addFlags(67108864);
    }
    ImmersiveUtils.a((Window)localObject1, true);
    localReportDialog.setContentView(localView);
    Object localObject2 = (TextView)localView.findViewById(2131379736);
    localObject1 = (TextView)localView.findViewById(2131379514);
    TextView localTextView1 = (TextView)localView.findViewById(2131379466);
    TextView localTextView2 = (TextView)localView.findViewById(2131379544);
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(2131370144);
    ((TextView)localObject2).setText(this.c);
    localTextView2.setText(this.d);
    localObject2 = new GradientDrawable();
    int i = ViewUtils.dpToPx(10.0F);
    ((GradientDrawable)localObject2).setCornerRadii(new float[] { i, i, i, i, 0.0F, 0.0F, 0.0F, 0.0F });
    ((GradientDrawable)localObject2).setColor(paramContext.getResources().getColor(2131167177));
    localLinearLayout.setBackgroundDrawable((Drawable)localObject2);
    i = paramContext.getResources().getColor(2131167119);
    if (bjuk.a())
    {
      localLinearLayout.setBackgroundResource(2130849631);
      i = -16777216;
    }
    localObject2 = new GradientDrawable();
    ((GradientDrawable)localObject2).setCornerRadius(AIOUtils.dp2px(6.0F, paramContext.getResources()));
    ((TextView)localObject1).setBackgroundDrawable((Drawable)localObject2);
    ((GradientDrawable)localObject2).setColor(i);
    localTextView1.setOnClickListener(new bfsh(this, paramQQAppInterface, paramContext, localReportDialog));
    ((TextView)localObject1).setOnClickListener(new bfsi(this, paramContext, paramQQAppInterface, localReportDialog));
    localLinearLayout.setOnClickListener(new bfsj(this));
    localView.setOnClickListener(new bfsk(this, paramContext, localReportDialog, paramQQAppInterface));
    return localReportDialog;
  }
  
  public static bfse a()
  {
    if (jdField_a_of_type_Bfse == null) {}
    try
    {
      if (jdField_a_of_type_Bfse == null) {
        jdField_a_of_type_Bfse = new bfse();
      }
      return jdField_a_of_type_Bfse;
    }
    finally {}
  }
  
  private void a(Context paramContext)
  {
    paramContext.startActivity(new Intent(paramContext, QQBrowserActivity.class).putExtra("url", this.jdField_a_of_type_JavaLangString));
  }
  
  private void a(Context paramContext, Dialog paramDialog)
  {
    if (paramDialog == null) {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim dialog is null");
    }
    do
    {
      return;
      if (paramContext == null)
      {
        QLog.e("SecurePhoneBannerManager", 1, "showDialogEnterAnim context is null");
        return;
      }
      paramDialog = (LinearLayout)paramDialog.findViewById(2131370144);
    } while (paramDialog == null);
    paramDialog.startAnimation(AnimationUtils.loadAnimation(paramContext, 2130772332));
  }
  
  private void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    QLog.d("SecurePhoneBannerManager", 1, "dismiss banner");
    paramQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134070);
    this.jdField_a_of_type_Boolean = false;
    bfyz.a(paramContext, paramQQAppInterface.getAccount(), true, "sp_key_secure_phone_notice_time", Integer.valueOf(this.jdField_a_of_type_Int));
    if (paramInt == 1) {
      ThreadManager.getUIHandler().post(new SecurePhoneBannerManager.7(this, paramContext));
    }
    bbon.b(paramQQAppInterface, paramInt, null);
  }
  
  private void b(Context paramContext, Dialog paramDialog)
  {
    if (paramDialog == null) {
      QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim dialog is null");
    }
    LinearLayout localLinearLayout;
    do
    {
      return;
      if (paramContext == null)
      {
        QLog.e("SecurePhoneBannerManager", 1, "showDialogExitAnim context is null");
        return;
      }
      localLinearLayout = (LinearLayout)paramDialog.findViewById(2131370144);
    } while (localLinearLayout == null);
    paramContext = AnimationUtils.loadAnimation(paramContext, 2130772333);
    paramContext.setAnimationListener(new bfsg(this, paramDialog));
    localLinearLayout.startAnimation(paramContext);
  }
  
  public TipsBar a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SecurePhoneBannerManager", 2, "initSecurePhoneBanner");
    }
    TipsBar localTipsBar = new TipsBar(paramContext);
    localTipsBar.setVisibility(8);
    localTipsBar.a().setText(this.jdField_b_of_type_JavaLangString);
    localTipsBar.setTipsIcon(paramContext.getResources().getDrawable(2130839319));
    localTipsBar.setOriginalOnClickListener(new bfsf(this, paramQQAppInterface, paramContext));
    return localTipsBar;
  }
  
  public void a()
  {
    try
    {
      QLog.d("SecurePhoneBannerManager", 1, "destory");
      jdField_a_of_type_Bfse = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState");
    if (paramQQAppInterface == null) {
      QLog.d("SecurePhoneBannerManager", 1, "getSecurePhoneState, app is null");
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, isShowing");
        }
        paramQQAppInterface.getHandler(Conversation.class).sendEmptyMessage(1134069);
        return;
      }
      if (paramQQAppInterface.isLogin()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not login");
    return;
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (this.jdField_a_of_type_Int == 0) {}
    for (int i = ((Integer)bfyz.a(paramContext, str, "sp_key_secure_phone_notice_time", Integer.valueOf(0))).intValue();; i = this.jdField_a_of_type_Int)
    {
      long l = i;
      if (System.currentTimeMillis() >= l * 1000L) {
        break label156;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("SecurePhoneBannerManager", 2, "getSecurePhoneState, but not time");
      return;
    }
    label156:
    bbon.b(paramQQAppInterface, new bfsl(this, paramQQAppInterface, paramContext, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfse
 * JD-Core Version:    0.7.0.1
 */