import android.os.Bundle;
import com.tencent.mobileqq.mediafocus.MediaFocusStackItem;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;

public class aubs
  extends QIPCModule
{
  public static boolean a;
  private String a;
  private boolean b;
  
  private aubs()
  {
    super("MediaFocusModuleClient");
    b();
  }
  
  public static aubs a()
  {
    return aubv.a();
  }
  
  public static void a()
  {
    aubs localaubs = a();
    if (!jdField_a_of_type_Boolean)
    {
      QIPCClientHelper.getInstance().register(localaubs);
      jdField_a_of_type_Boolean = true;
    }
  }
  
  private void b()
  {
    QIPCClientHelper.getInstance().getClient().connect(new aubt(this));
    QIPCClientHelper.getInstance().getClient().addListener(new aubu(this));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaFocusIpcClient", 2, "action = " + paramString + ", params = " + paramBundle);
    }
    Bundle localBundle = new Bundle();
    if ("actionCheckItemExist".equals(paramString))
    {
      paramBundle.setClassLoader(getClass().getClassLoader());
      paramString = (MediaFocusStackItem)paramBundle.getParcelable("focusItem");
      boolean bool = false;
      if (paramString != null) {
        bool = aubw.a().a(paramString.a(), paramString.b());
      }
      localBundle.putBoolean("isItemExist", bool);
      localBundle.putBoolean("isConnected", this.b);
      localBundle.putParcelable("focusItem", paramString);
    }
    return EIPCResult.createSuccessResult(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aubs
 * JD-Core Version:    0.7.0.1
 */