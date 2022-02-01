import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.SingleLineTextView;
import com.tencent.widget.ThemeURLImageView;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class bbxa
{
  private static String jdField_a_of_type_JavaLangString = "";
  private static WeakReference<Drawable> jdField_a_of_type_JavaLangRefWeakReference;
  
  public static Drawable a(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getResources().getDrawable(2130846165);
  }
  
  private static Drawable a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (jdField_a_of_type_JavaLangRefWeakReference != null)
    {
      Drawable localDrawable = (Drawable)jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localDrawable != null) {
        if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString))
        {
          paramQQAppInterface = localDrawable;
          if (jdField_a_of_type_JavaLangString.equals(ThemeUtil.curThemeId)) {}
        }
        else
        {
          ThemeUtil.setThemeFilter(localDrawable, ThemeUtil.curThemeId);
          jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
          paramQQAppInterface = localDrawable;
        }
      }
    }
    do
    {
      return paramQQAppInterface;
      paramContext = a(paramContext);
      paramQQAppInterface = paramContext;
    } while (paramContext == null);
    paramQQAppInterface = paramContext.getConstantState().newDrawable().mutate();
    ThemeUtil.setThemeFilter(paramQQAppInterface, ThemeUtil.curThemeId);
    jdField_a_of_type_JavaLangString = ThemeUtil.curThemeId;
    jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static ThemeURLImageView a(Context paramContext)
  {
    if (paramContext == null) {}
    Drawable localDrawable;
    do
    {
      return null;
      localDrawable = a(paramContext);
    } while (localDrawable == null);
    paramContext = new ThemeURLImageView(paramContext);
    paramContext.setContentDescription("BOT");
    paramContext.setImageDrawable(localDrawable);
    return paramContext;
  }
  
  public static void a(Context paramContext, SingleLineTextView paramSingleLineTextView, String paramString)
  {
    if ((paramSingleLineTextView == null) || (TextUtils.isEmpty(paramString)) || (paramContext == null)) {}
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((!(localAppRuntime instanceof QQAppInterface)) || (!bghs.b((QQAppInterface)localAppRuntime, paramString))) {
        break;
      }
      paramString = a((QQAppInterface)localAppRuntime, paramContext);
    } while (paramString == null);
    paramSingleLineTextView.setCompoundDrawablePadding((int)bhdz.a(paramContext, 5.0F));
    paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(paramString);
    return;
    paramSingleLineTextView.setDrawableRight2WithIntrinsicBounds(null);
  }
  
  public static boolean a(String paramString)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    return ((localAppRuntime instanceof QQAppInterface)) && (bghs.b((QQAppInterface)localAppRuntime, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxa
 * JD-Core Version:    0.7.0.1
 */