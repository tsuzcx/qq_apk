import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.qphone.base.util.QLog;

public class aows
  extends aokh<aowp>
{
  public static aowp a()
  {
    aowp localaowp = (aowp)aoks.a().a(529);
    if (localaowp != null) {
      return localaowp;
    }
    return new aowp();
  }
  
  public int a()
  {
    return 529;
  }
  
  @NonNull
  public aowp a(int paramInt)
  {
    return new aowp();
  }
  
  @Nullable
  public aowp a(aoko[] paramArrayOfaoko)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str;
    if (paramArrayOfaoko != null)
    {
      localObject1 = localObject2;
      if (paramArrayOfaoko.length > 0)
      {
        str = paramArrayOfaoko[0].a;
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str)) {
          if (QLog.isColorLevel()) {
            QLog.e("SigTopicConfProcessor", 1, "SigTopic.[onParsed] type=" + a() + ", content = " + str);
          }
        }
      }
    }
    try
    {
      paramArrayOfaoko = (aowq)aolc.a(str, aowq.class);
      localObject1 = new aowp(str, paramArrayOfaoko);
      return localObject1;
    }
    catch (QStorageInstantiateException paramArrayOfaoko)
    {
      for (;;)
      {
        QLog.e("SigTopicConfProcessor", 1, "readJsonOrXml failed", paramArrayOfaoko);
        paramArrayOfaoko = null;
      }
    }
  }
  
  public Class<aowp> a()
  {
    return aowp.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aowp paramaowp) {}
  
  public int b()
  {
    return 0;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aows
 * JD-Core Version:    0.7.0.1
 */