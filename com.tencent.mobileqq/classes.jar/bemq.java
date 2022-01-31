import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class bemq
  implements bdbc
{
  public agqq a;
  Handler jdField_a_of_type_AndroidOsHandler = new bemr(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bdbb a;
  bemp jdField_a_of_type_Bemp;
  public String a;
  zcn jdField_a_of_type_Zcn = (zcn)zcn.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public bemq(String paramString)
  {
    if (this.jdField_a_of_type_Zcn == null) {
      this.jdField_a_of_type_Zcn = new zcn("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bemp a()
  {
    return this.jdField_a_of_type_Bemp;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bemp != null) {
      return this.jdField_a_of_type_Bemp.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Zcn.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Zcn.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bemp == null) {
      this.jdField_a_of_type_Bemp = new bemp(this, this.jdField_a_of_type_Zcn.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(agqq paramagqq)
  {
    if (this.jdField_a_of_type_Agqq != paramagqq) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bemp != null) {
        this.jdField_a_of_type_Bemp.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Bdbb != null) {
        this.jdField_a_of_type_Bdbb.d();
      }
    } while (this.jdField_a_of_type_Zcn == null);
    this.jdField_a_of_type_Zcn.jdField_a_of_type_Zcm = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bemp.a(paramViewGroup, this.jdField_a_of_type_Zcn.jdField_a_of_type_Zcm);
  }
  
  public void a(BaseActivity paramBaseActivity, agqq paramagqq)
  {
    this.jdField_a_of_type_Agqq = paramagqq;
    this.jdField_a_of_type_Zcn.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bemp != null)
    {
      this.jdField_a_of_type_Bemp.a();
      this.jdField_a_of_type_Bemp.a(this.jdField_a_of_type_Zcn.jdField_a_of_type_Zcm);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bdbb = new bdbb((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Bdbb.a(this);
      return;
      this.jdField_a_of_type_Bemp = new bemp(this, this.jdField_a_of_type_Zcn.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bemp == null) {
      return;
    }
    this.jdField_a_of_type_Bemp.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Zcn.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bemp != null) {
      this.jdField_a_of_type_Bemp.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Agqq = null;
    if (this.jdField_a_of_type_Bdbb != null) {
      this.jdField_a_of_type_Bdbb.d();
    }
    if (this.jdField_a_of_type_Zcn != null) {
      this.jdField_a_of_type_Zcn.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bemp == null) {}
    while ((this.jdField_a_of_type_Bemp != null) && (this.jdField_a_of_type_Bemp.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bemp != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bemp.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemq
 * JD-Core Version:    0.7.0.1
 */