import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.Foreground;

public class anwf
  implements anvn, anvs
{
  @Nullable
  private Object jdField_a_of_type_JavaLangObject;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  
  anwf(Context paramContext, @Nullable anvn paramanvn)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramanvn;
  }
  
  anwf(Context paramContext, @Nullable anvs paramanvs)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaLangObject = paramanvs;
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof anvs)) {
      ((anvs)this.jdField_a_of_type_JavaLangObject).a(paramBoolean, paramInt1, paramInt2, paramString);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof anvn)) {
      ((anvn)this.jdField_a_of_type_JavaLangObject).a(paramBoolean1, paramBoolean2, paramInt, paramString1, paramString2);
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaLangObject instanceof anvn)) {
      return ((anvn)this.jdField_a_of_type_JavaLangObject).a();
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
    if (((this.jdField_a_of_type_JavaLangObject instanceof anvn)) && (!((anvn)this.jdField_a_of_type_JavaLangObject).a())) {}
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
 * Qualified Name:     anwf
 * JD-Core Version:    0.7.0.1
 */