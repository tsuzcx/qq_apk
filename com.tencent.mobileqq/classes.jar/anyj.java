import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.business.sougou.WordMatchManager.HotWordItem;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class anyj
  extends ClickableSpan
{
  String jdField_a_of_type_JavaLangString;
  WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  String b = "http://m.sogou.com/web/searchList.jsp?pid=sogou-appi-4fc28b7093b135c2&keyword=";
  
  anyj(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static SpannableStringBuilder a(QQAppInterface paramQQAppInterface, String paramString, WordMatchManager.HotWordItem[] paramArrayOfHotWordItem)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfHotWordItem == null)) {
      return null;
    }
    localSpannableStringBuilder = new SpannableStringBuilder(paramString);
    try
    {
      byte[] arrayOfByte = paramString.getBytes("GB2312");
      int i = 0;
      int k;
      for (int j = -1; i < paramArrayOfHotWordItem.length; j = k)
      {
        String str = new String(arrayOfByte, 0, paramArrayOfHotWordItem[i].offset, "GB2312");
        if (a(paramString, str))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("HotWord", 2, "转换到gbk的时候出现了乱码字符。不添加span了");
          break;
        }
        k = j;
        if (j != str.length())
        {
          k = str.length() + paramArrayOfHotWordItem[i].hotWord.length();
          localSpannableStringBuilder.setSpan(new anyj(paramQQAppInterface, paramArrayOfHotWordItem[i].hotWord), str.length(), k, 33);
          if (paramQQAppInterface != null) {
            azqs.b(paramQQAppInterface, "P_CliOper", "aio_search", "", "aio_hotword", "view_hotword", 0, 0, "", "", paramArrayOfHotWordItem[i].hotWord, "");
          }
        }
        i += 1;
      }
      return localSpannableStringBuilder;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  private void a(Context paramContext)
  {
    bhuf localbhuf = (bhuf)bhus.a(paramContext, null);
    localbhuf.a(2131697713, 5);
    localbhuf.c(2131690648);
    localbhuf.a(new anyk(this, paramContext, localbhuf));
    if (!localbhuf.isShowing()) {
      localbhuf.show();
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramString1.length() < paramString2.length())
    {
      bool1 = true;
      return bool1;
    }
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= paramString2.length()) {
        break;
      }
      char c1 = paramString1.charAt(i);
      char c2 = paramString2.charAt(i);
      if ((c2 == '?') && (c1 != c2))
      {
        if (QLog.isColorLevel()) {
          QLog.d("HotWord", 2, "isErrorCharAfterGBKConvert temp1=" + c1 + " temp2=" + c2);
        }
        return true;
      }
      i += 1;
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView == null) {}
    do
    {
      do
      {
        return;
        paramView = paramView.getContext();
      } while (paramView == null);
      a(paramView);
    } while ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null));
    azqs.b((QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get(), "P_CliOper", "aio_search", "", "aio_hotword", "click_hotword", 0, 0, "", "", this.jdField_a_of_type_JavaLangString, "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anyj
 * JD-Core Version:    0.7.0.1
 */