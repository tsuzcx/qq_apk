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

public class bilj
  implements FaceDecoder.DecodeTaskCompletionListener
{
  aapg jdField_a_of_type_Aapg = (aapg)aapg.jdField_a_of_type_JavaUtilHashMap.get("Werewolves.apk");
  public aiav a;
  Handler jdField_a_of_type_AndroidOsHandler = new bilk(this, Looper.getMainLooper());
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  bili jdField_a_of_type_Bili;
  public FaceDecoder a;
  public String a;
  
  public bilj(String paramString)
  {
    if (this.jdField_a_of_type_Aapg == null) {
      this.jdField_a_of_type_Aapg = new aapg("2584", "Werewolves.apk");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public bili a()
  {
    return this.jdField_a_of_type_Bili;
  }
  
  public String a(String paramString)
  {
    if (this.jdField_a_of_type_Bili != null) {
      return this.jdField_a_of_type_Bili.a(paramString);
    }
    return null;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Aapg.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Aapg.a(false);
      return;
    }
    if (this.jdField_a_of_type_Bili == null) {
      this.jdField_a_of_type_Bili = new bili(this, this.jdField_a_of_type_Aapg.jdField_a_of_type_JavaLangClassLoader);
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    localMessage.arg1 = 0;
    localMessage.sendToTarget();
  }
  
  public void a(aiav paramaiav)
  {
    if (this.jdField_a_of_type_Aiav != paramaiav) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Bili != null) {
        this.jdField_a_of_type_Bili.b();
      }
      if (this.jdField_a_of_type_AndroidViewViewGroup != null)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
        this.jdField_a_of_type_AndroidViewViewGroup = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      }
    } while (this.jdField_a_of_type_Aapg == null);
    this.jdField_a_of_type_Aapg.jdField_a_of_type_Aapf = null;
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    this.jdField_a_of_type_Bili.a(paramViewGroup, this.jdField_a_of_type_Aapg.jdField_a_of_type_Aapf);
  }
  
  public void a(BaseActivity paramBaseActivity, aiav paramaiav)
  {
    this.jdField_a_of_type_Aiav = paramaiav;
    this.jdField_a_of_type_Aapg.a(paramBaseActivity);
    if (this.jdField_a_of_type_Bili != null)
    {
      this.jdField_a_of_type_Bili.a();
      this.jdField_a_of_type_Bili.a(this.jdField_a_of_type_Aapg.jdField_a_of_type_Aapf);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
      return;
      this.jdField_a_of_type_Bili = new bili(this, this.jdField_a_of_type_Aapg.jdField_a_of_type_JavaLangClassLoader);
    }
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Bili == null) {
      return;
    }
    this.jdField_a_of_type_Bili.a(paramString, paramArrayOfByte);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Aapg.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Bili != null) {
      this.jdField_a_of_type_Bili.a();
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
      this.jdField_a_of_type_AndroidViewViewGroup = null;
    }
    this.jdField_a_of_type_Aiav = null;
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
    }
    if (this.jdField_a_of_type_Aapg != null) {
      this.jdField_a_of_type_Aapg.c();
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Bili == null) {}
    while ((this.jdField_a_of_type_Bili != null) && (this.jdField_a_of_type_Bili.a())) {
      return true;
    }
    return false;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if ((this.jdField_a_of_type_Bili != null) && ((paramInt2 == 32) || (paramInt2 == 1))) {
      this.jdField_a_of_type_Bili.a(paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bilj
 * JD-Core Version:    0.7.0.1
 */