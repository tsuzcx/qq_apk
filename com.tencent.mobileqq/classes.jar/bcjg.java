import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class bcjg
  implements baxz
{
  public aepe a;
  Handler jdField_a_of_type_AndroidOsHandler = new bcjh(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public baxy a;
  bcjf jdField_a_of_type_Bcjf;
  public String a;
  xjf jdField_a_of_type_Xjf = (xjf)xjf.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public bcjg(String paramString)
  {
    if (this.jdField_a_of_type_Xjf == null) {
      this.jdField_a_of_type_Xjf = new xjf("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bcjf a()
  {
    return this.jdField_a_of_type_Bcjf;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bcjf != null) {
      return this.jdField_a_of_type_Bcjf.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Xjf.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Xjf.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bcjf == null) {
      this.jdField_a_of_type_Bcjf = new bcjf(this, this.jdField_a_of_type_Xjf.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aepe paramaepe)
  {
    if (this.jdField_a_of_type_Aepe != paramaepe) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bcjf != null) {
        this.jdField_a_of_type_Bcjf.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Baxy != null) {
        this.jdField_a_of_type_Baxy.d();
      }
    } while (this.jdField_a_of_type_Xjf == null);
    this.jdField_a_of_type_Xjf.jdField_a_of_type_Xje = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bcjf.a(paramViewGroup, this.jdField_a_of_type_Xjf.jdField_a_of_type_Xje);
  }
  
  public void a(BaseActivity paramBaseActivity, aepe paramaepe)
  {
    this.jdField_a_of_type_Aepe = paramaepe;
    this.jdField_a_of_type_Xjf.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bcjf != null)
    {
      this.jdField_a_of_type_Bcjf.a();
      this.jdField_a_of_type_Bcjf.a(this.jdField_a_of_type_Xjf.jdField_a_of_type_Xje);
    }
    for (;;)
    {
      this.jdField_a_of_type_Baxy = new baxy((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Baxy.a(this);
      return;
      this.jdField_a_of_type_Bcjf = new bcjf(this, this.jdField_a_of_type_Xjf.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bcjf == null) {
      return;
    }
    this.jdField_a_of_type_Bcjf.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xjf.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bcjf != null) {
      this.jdField_a_of_type_Bcjf.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aepe = null;
    if (this.jdField_a_of_type_Baxy != null) {
      this.jdField_a_of_type_Baxy.d();
    }
    if (this.jdField_a_of_type_Xjf != null) {
      this.jdField_a_of_type_Xjf.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bcjf == null) {}
    while ((this.jdField_a_of_type_Bcjf != null) && (this.jdField_a_of_type_Bcjf.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bcjf != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bcjf.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bcjg
 * JD-Core Version:    0.7.0.1
 */