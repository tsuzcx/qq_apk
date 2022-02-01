import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import java.util.HashMap;

public class bhar
  implements FaceDecoder.DecodeTaskCompletionListener
{
  public ahgc a;
  Handler jdField_a_of_type_AndroidOsHandler = new bhas(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  bhaq jdField_a_of_type_Bhaq;
  public FaceDecoder a;
  public String a;
  zzu jdField_a_of_type_Zzu = (zzu)zzu.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  
  public bhar(String paramString)
  {
    if (this.jdField_a_of_type_Zzu == null) {
      this.jdField_a_of_type_Zzu = new zzu("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bhaq a()
  {
    return this.jdField_a_of_type_Bhaq;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bhaq != null) {
      return this.jdField_a_of_type_Bhaq.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Zzu.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Zzu.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bhaq == null) {
      this.jdField_a_of_type_Bhaq = new bhaq(this, this.jdField_a_of_type_Zzu.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(ahgc paramahgc)
  {
    if (this.jdField_a_of_type_Ahgc != paramahgc) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bhaq != null) {
        this.jdField_a_of_type_Bhaq.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      }
    } while (this.jdField_a_of_type_Zzu == null);
    this.jdField_a_of_type_Zzu.jdField_a_of_type_Zzt = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bhaq.a(paramViewGroup, this.jdField_a_of_type_Zzu.jdField_a_of_type_Zzt);
  }
  
  public void a(BaseActivity paramBaseActivity, ahgc paramahgc)
  {
    this.jdField_a_of_type_Ahgc = paramahgc;
    this.jdField_a_of_type_Zzu.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bhaq != null)
    {
      this.jdField_a_of_type_Bhaq.a();
      this.jdField_a_of_type_Bhaq.a(this.jdField_a_of_type_Zzu.jdField_a_of_type_Zzt);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      return;
      this.jdField_a_of_type_Bhaq = new bhaq(this, this.jdField_a_of_type_Zzu.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bhaq == null) {
      return;
    }
    this.jdField_a_of_type_Bhaq.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Zzu.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bhaq != null) {
      this.jdField_a_of_type_Bhaq.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Ahgc = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_Zzu != null) {
      this.jdField_a_of_type_Zzu.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bhaq == null) {}
    while ((this.jdField_a_of_type_Bhaq != null) && (this.jdField_a_of_type_Bhaq.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bhaq != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bhaq.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhar
 * JD-Core Version:    0.7.0.1
 */