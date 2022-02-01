import MQQ.QQValueInfoItem;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.vip.qqvaluecard.QQValuePagViewUtil.1;
import com.tencent.pb.profilecard.VaProfileGate.QQValueInfoItem;
import com.tencent.pb.qqvalue.qqvalue.GetQQValueReq;
import com.tencent.pb.qqvalue.qqvalue.GetQQValueRsp;
import com.tencent.pb.qqvalue.qqvalue.UserQQValueInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.NewIntent;
import org.libpag.PAGFile;
import org.libpag.PAGFont;
import org.libpag.PAGView;

public class bibb
{
  public static VasPagView a;
  public static String a;
  private static final Map<String, Integer> a;
  private static String b;
  private static String c = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "setting";
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_b_of_type_JavaLangString = "";
  }
  
  public static int a(String paramString1, String paramString2)
  {
    paramString1 = (Integer)jdField_a_of_type_JavaUtilMap.get(a(paramString1, paramString2));
    if (paramString1 == null) {
      return -2;
    }
    return paramString1.intValue();
  }
  
  private static String a(String paramString1, String paramString2)
  {
    return "cur_" + paramString1 + "_" + paramString2;
  }
  
  public static void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((localQQAppInterface == null) || (TextUtils.isEmpty(localQQAppInterface.getCurrentUin()))) {
      return;
    }
    NewIntent localNewIntent = new NewIntent(localQQAppInterface.getApp(), bhox.class);
    localNewIntent.putExtra("cmd", "qqvalue.GetQQValue");
    qqvalue.GetQQValueReq localGetQQValueReq = new qqvalue.GetQQValueReq();
    localGetQQValueReq.uin.set(Long.valueOf(localQQAppInterface.getCurrentUin()).longValue());
    localNewIntent.putExtra("data", localGetQQValueReq.toByteArray());
    localNewIntent.putExtra("timeout", 30000);
    localQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(Intent paramIntent, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    paramIntent = new qqvalue.GetQQValueRsp();
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return;
      try
      {
        paramIntent.mergeFrom(paramArrayOfByte);
        if ((paramIntent == null) || (!paramIntent.qq_value.has()) || (!paramIntent.qq_value.uin.has())) {
          continue;
        }
        a(paramIntent.qq_value.uin.get() + "", paramIntent.qq_value);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramIntent)
      {
        for (;;)
        {
          paramIntent = null;
        }
      }
    }
  }
  
  public static void a(VasPagView paramVasPagView, String paramString1, String paramString2)
  {
    if (paramVasPagView == null) {}
    for (;;)
    {
      return;
      bibe localbibe = biba.a().a(paramString1);
      if ((localbibe == null) || (localbibe.d == 1) || (localbibe.jdField_a_of_type_Int < -1) || (localbibe.jdField_b_of_type_Int == 0))
      {
        paramVasPagView.setVisibility(8);
        return;
      }
      paramVasPagView.setVisibility(0);
      jdField_a_of_type_ComTencentMobileqqVasUiVasPagView = paramVasPagView;
      jdField_b_of_type_JavaLangString = paramString1;
      int i = b(paramString1, paramString2);
      if ((!"card".equals(jdField_a_of_type_JavaLangString)) || (i != localbibe.jdField_a_of_type_Int))
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          if (!ThemeUtil.isInNightMode((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime())) {
            break label166;
          }
          paramVasPagView.setForeground(new ColorDrawable(1996488704));
        }
        while (!a(paramVasPagView, localbibe, paramString1, paramString2))
        {
          paramVasPagView.setStateChangeListener(new bibd(paramString1, paramString2, localbibe, paramVasPagView));
          if (paramVasPagView.a()) {
            break label174;
          }
          paramVasPagView.a();
          return;
          label166:
          paramVasPagView.setForeground(null);
        }
      }
    }
    label174:
    paramVasPagView.b();
  }
  
  public static void a(String paramString)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      if (jdField_b_of_type_JavaLangString.equals(paramString)) {
        a(jdField_a_of_type_ComTencentMobileqqVasUiVasPagView, paramString, jdField_a_of_type_JavaLangString);
      }
    }
    while (jdField_a_of_type_ComTencentMobileqqVasUiVasPagView == null) {
      return;
    }
    jdField_a_of_type_ComTencentMobileqqVasUiVasPagView.post(new QQValuePagViewUtil.1(paramString));
  }
  
  public static void a(String paramString, QQValueInfoItem paramQQValueInfoItem)
  {
    biba.a().a(paramString, paramQQValueInfoItem);
    b(paramString);
    a(paramString);
  }
  
  public static void a(String paramString, VaProfileGate.QQValueInfoItem paramQQValueInfoItem)
  {
    biba.a().a(paramString, paramQQValueInfoItem);
    b(paramString);
    a(paramString);
  }
  
  public static void a(String paramString, Object paramObject)
  {
    biba.a().a(paramString, paramObject);
    b(paramString);
    a(paramString);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(a(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    if (paramContext == null) {}
    do
    {
      return;
      paramString2 = biba.a().a(paramString2);
    } while (TextUtils.isEmpty(paramString2.jdField_b_of_type_JavaLangString));
    Object localObject = paramString2.jdField_b_of_type_JavaLangString;
    paramString2 = new StringBuilder((String)localObject);
    if (((String)localObject).contains("?")) {
      paramString2.append("&from=" + paramString1);
    }
    for (;;)
    {
      paramString1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("uin", paramString1.getCurrentUin());
      ((Intent)localObject).putExtra("url", paramString2.toString());
      ((Intent)localObject).putExtra("hide_more_button", true);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      paramContext.startActivity((Intent)localObject);
      return;
      paramString2.append("?from=" + paramString1);
    }
  }
  
  public static boolean a(VasPagView paramVasPagView, bibe parambibe, String paramString1, String paramString2)
  {
    if (!parambibe.jdField_a_of_type_Boolean) {
      return false;
    }
    paramVasPagView.removeAllViews();
    paramString1 = new TextView(paramVasPagView.getContext());
    if (parambibe.jdField_a_of_type_Int == -1) {
      paramString1.setBackgroundDrawable(paramVasPagView.getResources().getDrawable(2130850312));
    }
    for (;;)
    {
      paramString1.setPadding(30, 0, 0, 9);
      paramString1.setTextSize(11.0F);
      paramString1.setGravity(17);
      paramString1.setTextScaleX(0.9F);
      paramString1.setTextColor(-1);
      paramString1.setTypeface(Typeface.DEFAULT_BOLD);
      paramVasPagView.addView(paramString1, AIOUtils.dp2px(42.0F, paramString1.getResources()), AIOUtils.dp2px(15.0F, paramString1.getResources()));
      jdField_a_of_type_JavaLangString = paramString2;
      return true;
      paramString1.setBackgroundDrawable(paramVasPagView.getResources().getDrawable(2130850322));
      paramString1.setText(parambibe.jdField_a_of_type_Int + "");
    }
  }
  
  public static int b(String paramString1, String paramString2)
  {
    paramString1 = (Integer)jdField_a_of_type_JavaUtilMap.get(b(paramString1, paramString2));
    if (paramString1 == null) {
      return -2;
    }
    return paramString1.intValue();
  }
  
  private static String b(String paramString1, String paramString2)
  {
    return "old_" + paramString1 + "_" + paramString2;
  }
  
  public static void b(String paramString)
  {
    bibf.a().addUpdateListener(new bibc(paramString));
    bibf.a().a(Long.valueOf(paramString).longValue());
  }
  
  public static void b(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(b(paramString1, paramString2), Integer.valueOf(paramInt));
  }
  
  private static boolean b(PAGView paramPAGView, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (paramPAGView == null) {
      return false;
    }
    Object localObject = new File(paramString2);
    File localFile = new File(paramString3);
    if ((!((File)localObject).exists()) || (!localFile.exists()))
    {
      b(paramString1);
      return false;
    }
    localObject = PAGFont.RegisterFont(paramString2);
    paramString2 = PAGFile.Load(paramString3);
    if ((paramString2 == null) || (localObject == null)) {
      return false;
    }
    int i;
    if (paramString2.numTexts() > 0)
    {
      paramString3 = paramString2.getTextData(0);
      paramString3.fontFamily = ((PAGFont)localObject).fontFamily;
      paramString3.fontStyle = ((PAGFont)localObject).fontStyle;
      i = a(paramString1, paramString4);
      if (i != -1) {
        break label146;
      }
    }
    label146:
    for (paramString1 = "????";; paramString1 = i + "")
    {
      paramString3.text = paramString1;
      paramPAGView.setTextData(0, paramString3);
      paramPAGView.setFile(paramString2);
      paramPAGView.setRepeatCount(-1);
      paramPAGView.play();
      return true;
    }
  }
  
  public static int c(String paramString1, String paramString2)
  {
    paramString1 = (Integer)jdField_a_of_type_JavaUtilMap.get(c(paramString1, paramString2));
    if (paramString1 == null) {
      return 0;
    }
    return paramString1.intValue();
  }
  
  private static String c(String paramString1, String paramString2)
  {
    return "old_" + paramString1 + "_" + paramString2 + "_Trend";
  }
  
  public static void c(String paramString1, String paramString2, int paramInt)
  {
    jdField_a_of_type_JavaUtilMap.put(c(paramString1, paramString2), Integer.valueOf(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bibb
 * JD-Core Version:    0.7.0.1
 */