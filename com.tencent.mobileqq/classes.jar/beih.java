import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class beih
  implements bcwt
{
  public agmb a;
  Handler jdField_a_of_type_AndroidOsHandler = new beii(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public bcws a;
  beig jdField_a_of_type_Beig;
  public String a;
  yxy jdField_a_of_type_Yxy = (yxy)yxy.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public beih(String paramString)
  {
    if (this.jdField_a_of_type_Yxy == null) {
      this.jdField_a_of_type_Yxy = new yxy("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public beig a()
  {
    return this.jdField_a_of_type_Beig;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Beig != null) {
      return this.jdField_a_of_type_Beig.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Yxy.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Yxy.a(false);
      return;
    }
    if (this.jdField_a_of_type_Beig == null) {
      this.jdField_a_of_type_Beig = new beig(this, this.jdField_a_of_type_Yxy.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(agmb paramagmb)
  {
    if (this.jdField_a_of_type_Agmb != paramagmb) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Beig != null) {
        this.jdField_a_of_type_Beig.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Bcws != null) {
        this.jdField_a_of_type_Bcws.d();
      }
    } while (this.jdField_a_of_type_Yxy == null);
    this.jdField_a_of_type_Yxy.jdField_a_of_type_Yxx = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Beig.a(paramViewGroup, this.jdField_a_of_type_Yxy.jdField_a_of_type_Yxx);
  }
  
  public void a(BaseActivity paramBaseActivity, agmb paramagmb)
  {
    this.jdField_a_of_type_Agmb = paramagmb;
    this.jdField_a_of_type_Yxy.a(paramBaseActivity);
    if (this.jdField_a_of_type_Beig != null)
    {
      this.jdField_a_of_type_Beig.a();
      this.jdField_a_of_type_Beig.a(this.jdField_a_of_type_Yxy.jdField_a_of_type_Yxx);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bcws = new bcws((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Bcws.a(this);
      return;
      this.jdField_a_of_type_Beig = new beig(this, this.jdField_a_of_type_Yxy.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Beig == null) {
      return;
    }
    this.jdField_a_of_type_Beig.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Yxy.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Beig != null) {
      this.jdField_a_of_type_Beig.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Agmb = null;
    if (this.jdField_a_of_type_Bcws != null) {
      this.jdField_a_of_type_Bcws.d();
    }
    if (this.jdField_a_of_type_Yxy != null) {
      this.jdField_a_of_type_Yxy.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Beig == null) {}
    while ((this.jdField_a_of_type_Beig != null) && (this.jdField_a_of_type_Beig.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Beig != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Beig.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beih
 * JD-Core Version:    0.7.0.1
 */