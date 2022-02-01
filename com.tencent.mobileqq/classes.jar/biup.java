import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class biup
  implements aoog
{
  abdj jdField_a_of_type_Abdj = (abdj)abdj.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  public aikq a;
  Handler jdField_a_of_type_AndroidOsHandler = new biuq(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public aoof a;
  biuo jdField_a_of_type_Biuo;
  public String a;
  
  public biup(String paramString)
  {
    if (this.jdField_a_of_type_Abdj == null) {
      this.jdField_a_of_type_Abdj = new abdj("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public biuo a()
  {
    return this.jdField_a_of_type_Biuo;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Biuo != null) {
      return this.jdField_a_of_type_Biuo.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Abdj.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Abdj.a(false);
      return;
    }
    if (this.jdField_a_of_type_Biuo == null) {
      this.jdField_a_of_type_Biuo = new biuo(this, this.jdField_a_of_type_Abdj.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aikq paramaikq)
  {
    if (this.jdField_a_of_type_Aikq != paramaikq) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Biuo != null) {
        this.jdField_a_of_type_Biuo.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Aoof != null) {
        this.jdField_a_of_type_Aoof.d();
      }
    } while (this.jdField_a_of_type_Abdj == null);
    this.jdField_a_of_type_Abdj.jdField_a_of_type_Abdi = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Biuo.a(paramViewGroup, this.jdField_a_of_type_Abdj.jdField_a_of_type_Abdi);
  }
  
  public void a(BaseActivity paramBaseActivity, aikq paramaikq)
  {
    this.jdField_a_of_type_Aikq = paramaikq;
    this.jdField_a_of_type_Abdj.a(paramBaseActivity);
    if (this.jdField_a_of_type_Biuo != null)
    {
      this.jdField_a_of_type_Biuo.a();
      this.jdField_a_of_type_Biuo.a(this.jdField_a_of_type_Abdj.jdField_a_of_type_Abdi);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aoof = new aoof((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aoof.a(this);
      return;
      this.jdField_a_of_type_Biuo = new biuo(this, this.jdField_a_of_type_Abdj.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Biuo == null) {
      return;
    }
    this.jdField_a_of_type_Biuo.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Abdj.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Biuo != null) {
      this.jdField_a_of_type_Biuo.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aikq = null;
    if (this.jdField_a_of_type_Aoof != null) {
      this.jdField_a_of_type_Aoof.d();
    }
    if (this.jdField_a_of_type_Abdj != null) {
      this.jdField_a_of_type_Abdj.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Biuo == null) {}
    while ((this.jdField_a_of_type_Biuo != null) && (this.jdField_a_of_type_Biuo.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Biuo != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Biuo.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biup
 * JD-Core Version:    0.7.0.1
 */