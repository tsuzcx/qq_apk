import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class bbfs
  implements azwh
{
  public aeeh a;
  Handler jdField_a_of_type_AndroidOsHandler = new bbft(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public azwg a;
  bbfr jdField_a_of_type_Bbfr;
  public String a;
  xai jdField_a_of_type_Xai = (xai)xai.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public bbfs(String paramString)
  {
    if (this.jdField_a_of_type_Xai == null) {
      this.jdField_a_of_type_Xai = new xai("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bbfr a()
  {
    return this.jdField_a_of_type_Bbfr;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bbfr != null) {
      return this.jdField_a_of_type_Bbfr.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Xai.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Xai.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bbfr == null) {
      this.jdField_a_of_type_Bbfr = new bbfr(this, this.jdField_a_of_type_Xai.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aeeh paramaeeh)
  {
    if (this.jdField_a_of_type_Aeeh != paramaeeh) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bbfr != null) {
        this.jdField_a_of_type_Bbfr.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Azwg != null) {
        this.jdField_a_of_type_Azwg.d();
      }
    } while (this.jdField_a_of_type_Xai == null);
    this.jdField_a_of_type_Xai.jdField_a_of_type_Xah = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bbfr.a(paramViewGroup, this.jdField_a_of_type_Xai.jdField_a_of_type_Xah);
  }
  
  public void a(BaseActivity paramBaseActivity, aeeh paramaeeh)
  {
    this.jdField_a_of_type_Aeeh = paramaeeh;
    this.jdField_a_of_type_Xai.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bbfr != null)
    {
      this.jdField_a_of_type_Bbfr.a();
      this.jdField_a_of_type_Bbfr.a(this.jdField_a_of_type_Xai.jdField_a_of_type_Xah);
    }
    for (;;)
    {
      this.jdField_a_of_type_Azwg = new azwg((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Azwg.a(this);
      return;
      this.jdField_a_of_type_Bbfr = new bbfr(this, this.jdField_a_of_type_Xai.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bbfr == null) {
      return;
    }
    this.jdField_a_of_type_Bbfr.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Xai.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bbfr != null) {
      this.jdField_a_of_type_Bbfr.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aeeh = null;
    if (this.jdField_a_of_type_Azwg != null) {
      this.jdField_a_of_type_Azwg.d();
    }
    if (this.jdField_a_of_type_Xai != null) {
      this.jdField_a_of_type_Xai.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bbfr == null) {}
    while ((this.jdField_a_of_type_Bbfr != null) && (this.jdField_a_of_type_Bbfr.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bbfr != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bbfr.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bbfs
 * JD-Core Version:    0.7.0.1
 */