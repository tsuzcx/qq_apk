import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QzonePluginProxyActivity;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class auxd
{
  public static int a = -16692;
  public static int b = -16693;
  
  public static Drawable a(int paramInt)
  {
    Iterator localIterator = auxc.a.iterator();
    while (localIterator.hasNext())
    {
      auxi localauxi = (auxi)localIterator.next();
      if (paramInt == localauxi.jdField_a_of_type_Long) {
        return localauxi.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getConstantState().newDrawable();
      }
    }
    return null;
  }
  
  private static Class<?> a(Context paramContext, String paramString)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = Class.forName(paramString);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = QzonePluginProxyActivity.a(paramContext).loadClass(paramString);
          return localObject2;
        }
        catch (Throwable paramContext)
        {
          QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from qzone plugin class loader.");
        }
        localThrowable = localThrowable;
        QLog.e("StickyNotePublishUtils", 1, "loadQZoneClass, failed to load class from normal class loader.");
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return localObject1;
  }
  
  public static String a(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      if ((paramEditText.getText() instanceof ayks))
      {
        ayks localayks = (ayks)paramEditText.getText();
        if (localayks != null) {
          return localayks.a();
        }
      }
      if ((paramEditText != null) && (paramEditText.getEditableText() != null)) {
        return paramEditText.getEditableText().toString();
      }
    }
    return null;
  }
  
  public static void a(Context paramContext, long paramLong1, long paramLong2, String paramString, boolean paramBoolean, bhjw parambhjw)
  {
    try
    {
      paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
      if (paramContext != null) {
        paramContext.getMethod("modifyStickyNotePriv", new Class[] { Long.TYPE, Long.TYPE, String.class, Boolean.TYPE, bhjw.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString, Boolean.valueOf(paramBoolean), parambhjw });
      }
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("StickyNotePublishUtils", 1, "modifyStickyNotePriv fail.", paramContext);
    }
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, long paramLong1, long paramLong2, boolean paramBoolean, String paramString1, String paramString2, String paramString3, bhjw parambhjw)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickyNotePublishUtils", 0, String.format("publishStickyNote, hostUin=%s publishUin=%s isPublic=%s bgColor=%s vasExtendInfo=%s content=%s callback=%s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, parambhjw }));
    }
    if ((paramContext == null) || (paramQQAppInterface == null) || (paramLong1 == 0L) || (paramLong2 == 0L) || (TextUtils.isEmpty(paramString3))) {
      QLog.e("StickyNotePublishUtils", 1, "publishStickyNote, params invalid.");
    }
    for (;;)
    {
      return;
      boolean bool1 = bhbh.a(paramContext, paramQQAppInterface);
      boolean bool2 = bhbh.b(paramContext, paramQQAppInterface);
      if ((!bool1) || (!bool2))
      {
        QLog.e("StickyNotePublishUtils", 1, String.format("publishStickyNote, init fail. initEnv=%s initServlet=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        return;
      }
      try
      {
        paramContext = a(paramContext, "com.qzone.publish.stickynote.StickyNotePublishProxy");
        if (paramContext != null)
        {
          paramContext.getMethod("publishStickyNote", new Class[] { Long.TYPE, Long.TYPE, Boolean.TYPE, String.class, String.class, String.class, bhjw.class }).invoke(null, new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean), paramString1, paramString2, paramString3, parambhjw });
          return;
        }
      }
      catch (Exception paramContext)
      {
        QLog.e("StickyNotePublishUtils", 1, "publishStickyNote fail.", paramContext);
      }
    }
  }
  
  public static String b(EditText paramEditText)
  {
    if (paramEditText != null)
    {
      paramEditText = a(paramEditText);
      if (!TextUtils.isEmpty(paramEditText)) {
        return bhun.b(paramEditText.replaceAll(ajyc.a(2131705791), ajyc.a(2131705793)).replaceAll(ajyc.a(2131705790), "/MM"));
      }
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxd
 * JD-Core Version:    0.7.0.1
 */