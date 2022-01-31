import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

public class baja
{
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = new StringBuilder(paramString);
    int k = paramString.length();
    int j;
    for (int i = 0; i < k; i = j + 1)
    {
      j = i;
      if ('\024' == paramString.charAt(i))
      {
        j = i;
        if (i + 1 < k)
        {
          j = i;
          if ('ÿ' == paramString.charAt(i + 1))
          {
            j = i;
            if (i + 2 < k)
            {
              if (paramString.charAt(i + 2) == '\024') {
                paramString.setCharAt(i + 2, 'ý');
              }
              j = i + 4;
            }
          }
        }
      }
    }
    return paramString.toString();
  }
  
  public static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, String paramString)
  {
    biqt.a(null, a(paramString)).b(paramQQAppInterface, null).a(paramActivity, paramQQAppInterface.getAccount());
    birh.a(paramQQAppInterface, 6, 1);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", -1);
    localBundle.putString("forward_text", paramString);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    paramString.putExtra("direct_send_if_dataline_forward", true);
    arum.a(paramActivity, paramString, 21);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, true);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      ClipboardManager localClipboardManager = (ClipboardManager)BaseApplicationImpl.getContext().getSystemService("clipboard");
      if (localClipboardManager != null)
      {
        localClipboardManager.setPrimaryClip(ClipData.newPlainText(paramString2, paramString1));
        if (paramBoolean) {
          QQToast.a(BaseApplicationImpl.getContext(), 2, alpo.a(2131706932), 0).a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baja
 * JD-Core Version:    0.7.0.1
 */