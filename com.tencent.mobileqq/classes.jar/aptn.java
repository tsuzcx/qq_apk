import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aptn
  extends aptq<apto>
{
  public static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = (apto)apub.a().a(678);
    if (localObject1 != null) {
      if (paramBoolean) {
        localObject1 = apto.a((apto)localObject1);
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramContext.getString(2131691355);
      }
      return localObject2;
      if (a(paramContext))
      {
        localObject1 = apto.b((apto)localObject1);
      }
      else
      {
        int i = ((Integer)bfyz.a(paramContext, "", "key_deep_clean_show_time", Integer.valueOf(0))).intValue();
        a(paramContext, i);
        switch (i)
        {
        default: 
          localObject1 = apto.d((apto)localObject1);
          break;
        case 0: 
          localObject1 = apto.b((apto)localObject1);
          break;
        case 1: 
          localObject1 = apto.c((apto)localObject1);
          continue;
          localObject1 = "";
        }
      }
    }
  }
  
  public static void a()
  {
    bfyz.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(true));
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (paramInt < 2) {
      bfyz.a(paramContext, "", true, "key_deep_clean_show_time", Integer.valueOf(paramInt + 1));
    }
  }
  
  public static boolean a()
  {
    apto localapto = (apto)apub.a().a(678);
    return (localapto != null) && (localapto.a());
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Boolean)bfyz.a(paramContext, "", "key_deep_clean_user_click", Boolean.valueOf(false))).booleanValue();
  }
  
  @NonNull
  public apto a(int paramInt)
  {
    return new apto();
  }
  
  @Nullable
  public apto a(aptx[] paramArrayOfaptx)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      paramArrayOfaptx = paramArrayOfaptx[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("DeepCleanConfigProcessor", 2, "onParsed, content:" + paramArrayOfaptx);
      }
      return apto.a(paramArrayOfaptx);
    }
    return new apto();
  }
  
  public void a(apto paramapto)
  {
    bfyz.a(BaseApplication.getContext(), "", true, "key_deep_clean_show_time", Integer.valueOf(0));
    bfyz.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "DeepCleanConfigProcessor onUpdate");
    }
  }
  
  public Class<apto> clazz()
  {
    return apto.class;
  }
  
  public boolean isAccountRelated()
  {
    return false;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 678;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aptn
 * JD-Core Version:    0.7.0.1
 */