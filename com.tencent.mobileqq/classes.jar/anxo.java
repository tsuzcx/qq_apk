import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.colornote.ColorNoteCurd.1;
import com.tencent.mobileqq.colornote.ColorNoteCurd.2;
import com.tencent.mobileqq.colornote.ColorNoteCurd.3;
import com.tencent.mobileqq.colornote.ColorNoteCurd.4;
import com.tencent.mobileqq.colornote.ColorNoteCurd.5;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.util.Pair;

public class anxo
{
  private Handler jdField_a_of_type_AndroidOsHandler = new anxp(this);
  private anxq jdField_a_of_type_Anxq;
  private anxr jdField_a_of_type_Anxr = new anxr();
  
  public anxo()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject instanceof QQAppInterface))
    {
      localQQAppInterface = (QQAppInterface)localObject;
      if (localQQAppInterface != null) {
        break label74;
      }
      localObject = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Anxr.a(localQQAppInterface);
      this.jdField_a_of_type_Anxr.a((anyf)localObject);
      return;
      localQQAppInterface = null;
      break;
      label74:
      if (localQQAppInterface.a() == null) {
        localObject = null;
      } else {
        localObject = localQQAppInterface.a().a();
      }
    }
  }
  
  private boolean c()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, paramString, 0);
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.2(this, paramInt1, paramString, paramInt2), 32, null, true);
      return;
    }
    b(paramInt1, paramString, paramInt2);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.3(this, paramInt, paramString, paramBoolean), 32, null, true);
      return;
    }
    b(paramInt, paramString, paramBoolean);
  }
  
  public void a(Bundle paramBundle)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.1(this, paramBundle), 32, null, true);
      return;
    }
    b(paramBundle);
  }
  
  public void a(anxq paramanxq)
  {
    this.jdField_a_of_type_Anxq = paramanxq;
  }
  
  public void a(ColorNote paramColorNote)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.4(this, paramColorNote), 32, null, true);
      return;
    }
    b(paramColorNote);
  }
  
  public boolean a()
  {
    return anyk.a().c();
  }
  
  public boolean a(int paramInt, String paramString)
  {
    return anyk.a().a(paramInt, paramString);
  }
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    boolean bool = anxr.b(paramInt1, paramString, paramInt2);
    Message localMessage = Message.obtain();
    localMessage.obj = new Pair(Integer.valueOf(paramInt1), paramString);
    if (bool) {}
    for (localMessage.what = 5;; localMessage.what = 6)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void b(int paramInt, String paramString, boolean paramBoolean)
  {
    Bundle localBundle = anxr.a(paramInt, paramString, paramBoolean);
    if (localBundle == null) {
      return;
    }
    localBundle.putInt("key_service_type", paramInt);
    localBundle.putString("key_sub_type", paramString);
    paramString = Message.obtain();
    paramString.what = 9;
    paramString.obj = localBundle;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
  }
  
  public void b(Bundle paramBundle)
  {
    boolean bool = this.jdField_a_of_type_Anxr.a(paramBundle);
    Message localMessage = Message.obtain();
    localMessage.obj = paramBundle;
    if (bool) {}
    for (localMessage.what = 3;; localMessage.what = 4)
    {
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
    }
  }
  
  public void b(ColorNote paramColorNote)
  {
    Object localObject = paramColorNote.getUniKey();
    boolean bool2 = true;
    if (paramColorNote.mMainTitle != null) {
      bool2 = anxr.a((String)localObject, "mMainTitle", paramColorNote.mMainTitle);
    }
    boolean bool1 = bool2;
    if (paramColorNote.mSubTitle != null) {
      bool1 = bool2 & anxr.a((String)localObject, "mSubTitle", paramColorNote.mSubTitle);
    }
    bool2 = bool1;
    if (paramColorNote.mPicUrl != null) {
      bool2 = bool1 & anxr.a((String)localObject, "mPicUrl", paramColorNote.mPicUrl);
    }
    localObject = Message.obtain();
    if (bool2) {}
    for (((Message)localObject).what = 10;; ((Message)localObject).what = 11)
    {
      ((Message)localObject).obj = paramColorNote;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
      return;
    }
  }
  
  public boolean b()
  {
    return anyk.a().b();
  }
  
  public void c(ColorNote paramColorNote)
  {
    if (c())
    {
      ThreadManagerV2.excute(new ColorNoteCurd.5(this, paramColorNote), 32, null, true);
      return;
    }
    d(paramColorNote);
  }
  
  public void d(ColorNote paramColorNote)
  {
    anxr.a(paramColorNote);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anxo
 * JD-Core Version:    0.7.0.1
 */