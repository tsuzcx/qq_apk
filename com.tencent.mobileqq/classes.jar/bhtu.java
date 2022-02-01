import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

public class bhtu
  implements aobv
{
  aazg jdField_a_of_type_Aazg = (aazg)aazg.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  public aiay a;
  Handler jdField_a_of_type_AndroidOsHandler = new bhtv(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public aobu a;
  bhtt jdField_a_of_type_Bhtt;
  public String a;
  
  public bhtu(String paramString)
  {
    if (this.jdField_a_of_type_Aazg == null) {
      this.jdField_a_of_type_Aazg = new aazg("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bhtt a()
  {
    return this.jdField_a_of_type_Bhtt;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bhtt != null) {
      return this.jdField_a_of_type_Bhtt.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Aazg.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aazg.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bhtt == null) {
      this.jdField_a_of_type_Bhtt = new bhtt(this, this.jdField_a_of_type_Aazg.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aiay paramaiay)
  {
    if (this.jdField_a_of_type_Aiay != paramaiay) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bhtt != null) {
        this.jdField_a_of_type_Bhtt.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_Aobu != null) {
        this.jdField_a_of_type_Aobu.d();
      }
    } while (this.jdField_a_of_type_Aazg == null);
    this.jdField_a_of_type_Aazg.jdField_a_of_type_Aazf = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bhtt.a(paramViewGroup, this.jdField_a_of_type_Aazg.jdField_a_of_type_Aazf);
  }
  
  public void a(BaseActivity paramBaseActivity, aiay paramaiay)
  {
    this.jdField_a_of_type_Aiay = paramaiay;
    this.jdField_a_of_type_Aazg.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bhtt != null)
    {
      this.jdField_a_of_type_Bhtt.a();
      this.jdField_a_of_type_Bhtt.a(this.jdField_a_of_type_Aazg.jdField_a_of_type_Aazf);
    }
    for (;;)
    {
      this.jdField_a_of_type_Aobu = new aobu((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_Aobu.a(this);
      return;
      this.jdField_a_of_type_Bhtt = new bhtt(this, this.jdField_a_of_type_Aazg.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bhtt == null) {
      return;
    }
    this.jdField_a_of_type_Bhtt.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aazg.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhtt != null) {
      this.jdField_a_of_type_Bhtt.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aiay = null;
    if (this.jdField_a_of_type_Aobu != null) {
      this.jdField_a_of_type_Aobu.d();
    }
    if (this.jdField_a_of_type_Aazg != null) {
      this.jdField_a_of_type_Aazg.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bhtt == null) {}
    while ((this.jdField_a_of_type_Bhtt != null) && (this.jdField_a_of_type_Bhtt.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bhtt != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bhtt.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhtu
 * JD-Core Version:    0.7.0.1
 */