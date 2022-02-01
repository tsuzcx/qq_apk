import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

public class aqka
  implements aqji, aqjn
{
  @Nullable
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  aqka(Context paramContext, @Nullable aqji paramaqji)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramaqji;
  }
  
  aqka(Context paramContext, @Nullable aqjn paramaqjn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramaqjn;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof aqjn)) {
      ((aqjn)this.jdField_a_of_type_JavaLangObject).a(paramBoolean, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof aqji)) {
      ((aqji)this.jdField_a_of_type_JavaLangObject).a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof aqji)) {
      return ((aqji)this.jdField_a_of_type_JavaLangObject).a();
    }
    return false;
  }
  
  void b(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("TeleScreenListenerWrapper", 1, "jump | jump: " + paramInt1 + ", errCode: " + paramInt2 + ", errMsg: " + paramString);
    a(paramBoolean, paramInt1, paramInt2, paramString);
  }
  
  void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    QLog.d("TeleScreenListenerWrapper", 1, "download | pass: " + paramBoolean2 + ", errCode: " + paramInt + ", errMsg: " + paramString1);
    a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    if (((this.jdField_a_of_type_JavaLangObject instanceof aqji)) && (!((aqji)this.jdField_a_of_type_JavaLangObject).a())) {}
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while ((localContext == null) || (!paramBoolean1) || (paramBoolean2) || (TextUtils.isEmpty(paramString2)));
    Intent localIntent = new Intent(localContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString2);
    if ((localContext instanceof Activity)) {}
    for (paramString1 = (Activity)localContext; paramString1 == null; paramString1 = Foreground.getTopActivity())
    {
      localIntent.addFlags(268435456);
      localContext.startActivity(localIntent);
      return;
    }
    paramString1.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqka
 * JD-Core Version:    0.7.0.1
 */