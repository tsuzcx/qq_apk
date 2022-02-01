import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import mqq.manager.Manager;

public class awgy
  implements Manager
{
  public static final String[] a;
  final awha a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "entry_setting", "entry_aio_video", "entry_file", "entry_chat_audio", "entry_chat_video", "entry_kandian_video" };
  }
  
  public awgy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awha = new awha(paramQQAppInterface.getAccount());
  }
  
  public static CharSequence a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if (paramQQAppInterface != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (awgy)paramQQAppInterface.getManager(221);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
          if (((awgy)localObject1).a())
          {
            localObject1 = ((awgy)localObject1).a(paramInt);
            i = 0;
            j = i;
            localObject2 = paramString;
            if (localObject1 != null)
            {
              j = i;
              localObject2 = paramString;
            }
          }
        }
      }
      catch (Exception paramQQAppInterface)
      {
        Object localObject1;
        i = 0;
      }
      try
      {
        if (!TextUtils.isEmpty(((awhb)localObject1).jdField_a_of_type_JavaLangString))
        {
          j = i;
          localObject2 = paramString;
          if (!TextUtils.isEmpty(((awhb)localObject1).b))
          {
            j = i;
            localObject2 = paramString;
            if (((awhb)localObject1).jdField_a_of_type_JavaLangString.contains(((awhb)localObject1).b))
            {
              j = i;
              localObject2 = paramString;
              if (!TextUtils.isEmpty(((awhb)localObject1).c))
              {
                String str = String.format("%s\n%s", new Object[] { paramString, ((awhb)localObject1).jdField_a_of_type_JavaLangString });
                localObject2 = new SpannableString(str);
                j = str.indexOf(((awhb)localObject1).b);
                int k = ((awhb)localObject1).b.length();
                ((SpannableString)localObject2).setSpan(new awgz(paramContext, ((awhb)localObject1).c, paramQQAppInterface.c(), paramInt), j, k + j, 17);
                j = i;
              }
            }
          }
        }
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d retCode: %d context: %s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(j), paramContext }));
        }
        return localObject2;
      }
      catch (Exception paramQQAppInterface)
      {
        break label301;
      }
      localObject1 = null;
      int i = 3;
      continue;
      localObject1 = ((awgy)localObject1).a(paramInt);
      i = 0;
      continue;
      label301:
      int j = i;
      Object localObject2 = paramString;
      if (QLog.isColorLevel())
      {
        QLog.i("CUOpenCardGuideMng", 2, "getGuideEnty", paramQQAppInterface);
        j = i;
        localObject2 = paramString;
        continue;
        j = 0;
        localObject2 = paramString;
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    int i = bgnt.a(BaseApplicationImpl.getApplication().getApplicationContext());
    Object localObject1 = null;
    long l2 = 0L;
    long l1 = 0L;
    bhhc localbhhc;
    if (i != 1)
    {
      l2 = bgsg.e(paramQQAppInterface.getApp(), paramQQAppInterface.c());
      l1 = System.currentTimeMillis();
      localbhhc = bhhb.a(paramString2, true, false);
      if (QLog.isColorLevel()) {
        QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip info.mPopUpType = " + localbhhc.jdField_a_of_type_Int + ", info.mGuideJumpUrl = " + localbhhc.jdField_a_of_type_JavaLangString);
      }
      paramString2 = (awgy)paramQQAppInterface.getManager(221);
      if (paramString2 == null) {
        break label620;
      }
      if (!paramBoolean) {
        break label577;
      }
      paramString2 = paramString2.a(4);
    }
    for (;;)
    {
      String[] arrayOfString2;
      String[] arrayOfString1;
      Bundle localBundle;
      Object localObject3;
      Object localObject2;
      if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramString2.b)) && (!TextUtils.isEmpty(localbhhc.jdField_a_of_type_JavaLangString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CUOpenCardGuideMng", 2, "WL_DEBUG addCallGrayTip entry.tip = " + paramString2.jdField_a_of_type_JavaLangString + ", entry.keyWord = " + paramString2.b);
        }
        arrayOfString2 = paramString2.jdField_a_of_type_JavaLangString.split("\\|");
        arrayOfString1 = paramString2.b.split("\\|");
        localBundle = null;
        localObject3 = null;
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (arrayOfString2.length >= 2)
        {
          localObject1 = localObject3;
          localObject2 = localBundle;
          if (arrayOfString1.length >= 2)
          {
            if (localbhhc.jdField_a_of_type_Int != 2) {
              break label588;
            }
            localObject2 = arrayOfString2[0];
            localObject1 = arrayOfString1[0];
          }
        }
      }
      for (;;)
      {
        if ((localObject2 != null) && (localObject1 != null))
        {
          localBundle = new Bundle();
          localBundle.putInt("key_action", 1);
          localBundle.putString("textColor", "#40A0FF");
          localBundle.putString("key_action_DATA", localbhhc.jdField_a_of_type_JavaLangString);
          int j = ((String)localObject2).indexOf((String)localObject1);
          int k = ((String)localObject1).length();
          localObject1 = new auxc(paramString1, paramQQAppInterface.c(), (String)localObject2, paramInt, -5020, 3145729, bbyp.a());
          localObject2 = new MessageForUniteGrayTip();
          if (j >= 0) {
            ((auxc)localObject1).a(j, k + j, localBundle);
          }
          ((MessageForUniteGrayTip)localObject2).initGrayTipMsg(paramQQAppInterface, (auxc)localObject1);
          auxd.a(paramQQAppInterface, (MessageForUniteGrayTip)localObject2);
          bcst.b(null, "dc00898", "", "", "0X800812A", "0X800812A", 0, 0, "", "", "", "");
          bgsg.e(paramQQAppInterface.getApp(), paramQQAppInterface.c(), System.currentTimeMillis());
        }
        localObject1 = paramString2;
        if (QLog.isColorLevel()) {
          QLog.i("CUOpenCardGuideMng", 2, "addCallGrayTip, friendUin= " + paramString1 + ",isVideoMsg=" + paramBoolean + ",netType=" + i + ",uinType=" + paramInt + ",lastAlertTime=" + l2 + ",currentTime=" + l1 + ",entry=" + localObject1);
        }
        return;
        label577:
        paramString2 = paramString2.a(3);
        break;
        label588:
        localObject1 = localObject3;
        localObject2 = localBundle;
        if (localbhhc.jdField_a_of_type_Int == 3)
        {
          localObject2 = arrayOfString2[1];
          localObject1 = arrayOfString1[1];
        }
      }
      label620:
      paramString2 = null;
    }
  }
  
  public awhb a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "getGuideEntry entry: %d, isInit: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.jdField_a_of_type_Awha.jdField_a_of_type_Boolean) }));
    }
    this.jdField_a_of_type_Awha.a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Awha.b)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.jdField_a_of_type_Awha.jdField_a_of_type_ArrayOfAwhb.length) {
          localObject1 = this.jdField_a_of_type_Awha.jdField_a_of_type_ArrayOfAwhb[paramInt];
        }
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Awha.a();
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, String.format(Locale.getDefault(), "onGetConfig isInit: %b, config: %s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Awha.jdField_a_of_type_Boolean), paramString }));
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = BaseApplicationImpl.getApplication().getSharedPreferences("ChinaUnicomPhoneCard" + this.jdField_a_of_type_Awha.jdField_a_of_type_JavaLangString, 4).edit();
    paramString.putString("config_content", str);
    paramString.commit();
    this.jdField_a_of_type_Awha.a(str);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Awha.jdField_a_of_type_Boolean;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CUOpenCardGuideMng", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awgy
 * JD-Core Version:    0.7.0.1
 */