import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public class bame
{
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private bami jdField_a_of_type_Bami;
  private String jdField_a_of_type_JavaLangString;
  
  protected bame(String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread(paramString);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    a(paramString, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
  }
  
  private void a(String paramString, Looper paramLooper)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Bami = new bami(paramLooper, this, null);
  }
  
  public final Message a(int paramInt)
  {
    return Message.obtain(this.jdField_a_of_type_Bami, paramInt);
  }
  
  public final Message a(int paramInt, Object paramObject)
  {
    return Message.obtain(this.jdField_a_of_type_Bami, paramInt, paramObject);
  }
  
  protected final baly a()
  {
    bami localbami = this.jdField_a_of_type_Bami;
    if (localbami == null) {
      return null;
    }
    return bami.a(localbami);
  }
  
  protected String a(int paramInt)
  {
    return null;
  }
  
  protected String a(Message paramMessage)
  {
    return "";
  }
  
  protected void a() {}
  
  public final void a(int paramInt)
  {
    bami localbami = this.jdField_a_of_type_Bami;
    if (localbami == null) {
      return;
    }
    localbami.sendMessage(a(paramInt));
  }
  
  public final void a(int paramInt, Object paramObject)
  {
    bami localbami = this.jdField_a_of_type_Bami;
    if (localbami == null) {
      return;
    }
    localbami.sendMessage(a(paramInt, paramObject));
  }
  
  protected final void a(Message paramMessage)
  {
    bami.a(this.jdField_a_of_type_Bami, paramMessage);
  }
  
  protected final void a(baly parambaly)
  {
    bami.a(this.jdField_a_of_type_Bami, parambaly);
  }
  
  protected final void a(bamd parambamd)
  {
    bami.a(this.jdField_a_of_type_Bami, parambamd, null);
  }
  
  protected void a(String paramString)
  {
    Log.d(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected boolean a(Message paramMessage)
  {
    return true;
  }
  
  protected void b() {}
  
  protected void b(Message paramMessage)
  {
    if (bami.a(this.jdField_a_of_type_Bami)) {
      b(" - unhandledMessage: msg.what=" + paramMessage.what);
    }
  }
  
  protected final void b(bamd parambamd)
  {
    bami.a(this.jdField_a_of_type_Bami, parambamd);
  }
  
  protected void b(String paramString)
  {
    Log.e(this.jdField_a_of_type_JavaLangString, paramString);
  }
  
  protected final void c()
  {
    bami localbami = this.jdField_a_of_type_Bami;
    if (localbami == null) {
      return;
    }
    bami.a(localbami);
  }
  
  protected void c(Message paramMessage) {}
  
  public void d()
  {
    bami localbami = this.jdField_a_of_type_Bami;
    if (localbami == null) {
      return;
    }
    bami.b(localbami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bame
 * JD-Core Version:    0.7.0.1
 */