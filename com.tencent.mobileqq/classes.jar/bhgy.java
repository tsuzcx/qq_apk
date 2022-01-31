import com.tencent.qqmini.sdk.log.QMLog;
import java.lang.reflect.Proxy;

public class bhgy
{
  public static Object a(bhgz parambhgz)
  {
    try
    {
      ClassLoader localClassLoader = bhgq.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.ITXLivePushListener");
      parambhgz = new bhhe(parambhgz);
      parambhgz = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhgz);
      return parambhgz;
    }
    catch (ClassNotFoundException parambhgz)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhgz);
    }
    return null;
  }
  
  public static Object a(bhha parambhha)
  {
    try
    {
      ClassLoader localClassLoader = bhgq.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$ITXSnapshotListener");
      parambhha = new bhhb(parambhha);
      parambhha = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhha);
      return parambhha;
    }
    catch (ClassNotFoundException parambhha)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhha);
    }
    return null;
  }
  
  public static Object a(bhhc parambhhc)
  {
    try
    {
      ClassLoader localClassLoader = bhgq.class.getClassLoader();
      Class localClass = Class.forName("com.tencent.rtmp.TXLivePusher$OnBGMNotify");
      parambhhc = new bhhd(parambhhc);
      parambhhc = Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, parambhhc);
      return parambhhc;
    }
    catch (ClassNotFoundException parambhhc)
    {
      QMLog.e("TXLivePushListenerRefle", "newInstance", parambhhc);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhgy
 * JD-Core Version:    0.7.0.1
 */