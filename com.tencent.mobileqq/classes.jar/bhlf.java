import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Proxy;

public class bhlf
{
  public static Object a(bhlg parambhlg)
  {
    try
    {
      ClassLoader localClassLoader = bhkx.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.ITXLivePushListener");
      parambhlg = new bhll(parambhlg);
      parambhlg = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhlg);
      return parambhlg;
    }
    catch (ClassNotFoundException parambhlg)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhlg);
    }
    return null;
  }
  
  public static Object a(bhlh parambhlh)
  {
    try
    {
      ClassLoader localClassLoader = bhkx.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener");
      parambhlh = new bhli(parambhlh);
      parambhlh = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhlh);
      return parambhlh;
    }
    catch (ClassNotFoundException parambhlh)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhlh);
    }
    return null;
  }
  
  public static Object a(bhlj parambhlj)
  {
    try
    {
      ClassLoader localClassLoader = bhkx.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify");
      parambhlj = new bhlk(parambhlj);
      parambhlj = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhlj);
      return parambhlj;
    }
    catch (ClassNotFoundException parambhlj)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhlj);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhlf
 * JD-Core Version:    0.7.0.1
 */