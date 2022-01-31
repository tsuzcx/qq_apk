import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class baea
{
  private static int jdField_a_of_type_Int = 1;
  private static volatile baea jdField_a_of_type_Baea;
  public static HashMap<String, Integer> a;
  private static List<TouchWebView> jdField_a_of_type_JavaUtilList = new ArrayList();
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  
  private baea()
  {
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static baea a()
  {
    if (jdField_a_of_type_Baea == null) {}
    try
    {
      if (jdField_a_of_type_Baea == null) {
        jdField_a_of_type_Baea = new baea();
      }
      return jdField_a_of_type_Baea;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, TouchWebView paramTouchWebView)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 34	baea:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   6: ifnonnull +13 -> 19
    //   9: new 36	java/util/HashMap
    //   12: dup
    //   13: invokespecial 37	java/util/HashMap:<init>	()V
    //   16: putstatic 34	baea:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   19: aload_0
    //   20: ifnull +30 -> 50
    //   23: getstatic 34	baea:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   26: aload_0
    //   27: invokevirtual 41	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast 43	java/lang/Integer
    //   33: astore_3
    //   34: aload_3
    //   35: ifnonnull +24 -> 59
    //   38: getstatic 34	baea:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   41: aload_0
    //   42: iconst_1
    //   43: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   46: invokevirtual 51	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   49: pop
    //   50: aload_0
    //   51: aload_1
    //   52: invokestatic 55	atcy:a	(Ljava/lang/String;Lcom/tencent/biz/ui/TouchWebView;)V
    //   55: ldc 2
    //   57: monitorexit
    //   58: return
    //   59: aload_3
    //   60: invokevirtual 59	java/lang/Integer:intValue	()I
    //   63: istore_2
    //   64: getstatic 34	baea:jdField_a_of_type_JavaUtilHashMap	Ljava/util/HashMap;
    //   67: aload_0
    //   68: iload_2
    //   69: iconst_1
    //   70: iadd
    //   71: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: invokevirtual 51	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: goto -28 -> 50
    //   81: astore_0
    //   82: ldc 2
    //   84: monitorexit
    //   85: aload_0
    //   86: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	paramString	String
    //   0	87	1	paramTouchWebView	TouchWebView
    //   63	8	2	i	int
    //   33	27	3	localInteger	Integer
    // Exception table:
    //   from	to	target	type
    //   3	19	81	finally
    //   23	34	81	finally
    //   38	50	81	finally
    //   50	55	81	finally
    //   59	78	81	finally
  }
  
  public TouchWebView a(Context paramContext)
  {
    byte[] arrayOfByte = jdField_a_of_type_ArrayOfByte;
    TouchWebView localTouchWebView = null;
    try
    {
      QLog.e("TenDocWebViewPool", 1, "tendocpreload getWebView =  " + jdField_a_of_type_JavaUtilList.size());
      if (jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localTouchWebView = (TouchWebView)jdField_a_of_type_JavaUtilList.get(0);
        jdField_a_of_type_JavaUtilList.remove(0);
        ViewGroup localViewGroup = (ViewGroup)localTouchWebView.getParent();
        if (localViewGroup != null) {
          localViewGroup.removeView(localTouchWebView);
        }
        ((MutableContextWrapper)localTouchWebView.getContext()).setBaseContext(paramContext);
      }
      return localTouchWebView;
    }
    finally {}
  }
  
  public List<TouchWebView> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  public void a(TouchWebView paramTouchWebView)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
    if (paramTouchWebView != null)
    {
      ??? = (ViewGroup)paramTouchWebView.getParent();
      if (??? != null) {
        ((ViewGroup)???).removeView(paramTouchWebView);
      }
      synchronized (jdField_a_of_type_ArrayOfByte)
      {
        if ((paramTouchWebView instanceof SwiftReuseTouchWebView))
        {
          Context localContext = paramTouchWebView.getContext();
          if ((localContext instanceof MutableContextWrapper)) {
            ((MutableContextWrapper)localContext).setBaseContext(BaseApplicationImpl.sApplication);
          }
          if (jdField_a_of_type_JavaUtilList.size() < jdField_a_of_type_Int)
          {
            QLog.i("TenDocWebViewPool", 1, "tendocpreload recycleWebView  ");
            jdField_a_of_type_JavaUtilList.add(paramTouchWebView);
          }
        }
        else
        {
          return;
        }
        paramTouchWebView.destroy();
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("TenDocWebViewPool", 1, "tendocpreload init" + a());
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (!a())
      {
        Object localObject = new Bundle();
        ((Bundle)localObject).putInt("_accelerator_mode_", 3);
        if (SwiftReuseTouchWebView.b == 0) {
          befo.a().a((Bundle)localObject);
        }
        QLog.i("TenDocWebViewPool", 1, "init");
        localObject = SwiftReuseTouchWebView.a(BaseApplicationImpl.sApplication);
        ((TouchWebView)localObject).setWebViewClient(new baec(this));
        ((TouchWebView)localObject).setWebChromeClient(new baeb(this));
        jdField_a_of_type_JavaUtilList.add(localObject);
      }
      badz.a = paramString;
      return;
    }
  }
  
  public boolean a()
  {
    return jdField_a_of_type_JavaUtilList.size() > 0;
  }
  
  public boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (a())
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        TouchWebView localTouchWebView = (TouchWebView)a().get(0);
        localTouchWebView.setWebViewClient(new baec(this));
        localTouchWebView.setWebChromeClient(new baeb(this));
        localTouchWebView.loadUrlOriginal(paramString);
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baea
 * JD-Core Version:    0.7.0.1
 */