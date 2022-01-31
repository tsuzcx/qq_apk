import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class bcis
  implements baxl
{
  public aepg a;
  Handler jdField_a_of_type_AndroidOsHandler = new bcit(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public baxk a;
  bcir jdField_a_of_type_Bcir;
  public String a;
  xji jdField_a_of_type_Xji = (xji)xji.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public bcis(String paramString)
  {
    if (this.jdField_a_of_type_Xji == null) {
      this.jdField_a_of_type_Xji = new xji("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bcir a()
  {
    return this.jdField_a_of_type_Bcir;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bcir != null) {
      return this.jdField_a_of_type_Bcir.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Xji.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Xji.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bcir == null) {
      this.jdField_a_of_type_Bcir = new bcir(this, this.jdField_a_of_type_Xji.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aepg paramaepg)
  {
    if (this.jdField_a_of_type_Aepg != paramaepg) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bcir != null) {
        this.jdField_a_of_type_Bcir.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Baxk != null) {
        this.jdField_a_of_type_Baxk.d();
      }
    } while (this.jdField_a_of_type_Xji == null);
    this.jdField_a_of_type_Xji.jdField_a_of_type_Xjh = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bcir.a(paramViewGroup, this.jdField_a_of_type_Xji.jdField_a_of_type_Xjh);
  }
  
  public void a(BaseActivity paramBaseActivity, aepg paramaepg)
  {
    this.jdField_a_of_type_Aepg = paramaepg;
    this.jdField_a_of_type_Xji.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bcir != null)
    {
      this.jdField_a_of_type_Bcir.a();
      this.jdField_a_of_type_Bcir.a(this.jdField_a_of_type_Xji.jdField_a_of_type_Xjh);
    }
    for (;;)
    {
      this.jdField_a_of_type_Baxk = new baxk((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Baxk.a(this);
      return;
      this.jdField_a_of_type_Bcir = new bcir(this, this.jdField_a_of_type_Xji.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bcir == null) {
      return;
    }
    this.jdField_a_of_type_Bcir.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xji.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcir != null) {
      this.jdField_a_of_type_Bcir.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aepg = null;
    if (this.jdField_a_of_type_Baxk != null) {
      this.jdField_a_of_type_Baxk.d();
    }
    if (this.jdField_a_of_type_Xji != null) {
      this.jdField_a_of_type_Xji.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bcir == null) {}
    while ((this.jdField_a_of_type_Bcir != null) && (this.jdField_a_of_type_Bcir.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bcir != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bcir.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcis
 * JD-Core Version:    0.7.0.1
 */