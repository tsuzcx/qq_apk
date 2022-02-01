import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aqwq
  extends aqwt<aqwr>
{
  public static String a(Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = (aqwr)aqxe.a().a(678);
    if (localObject1 != null) {
      if (paramBoolean) {
        localObject1 = aqwr.a((aqwr)localObject1);
      }
    }
    for (;;)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = paramContext.getString(2131691440);
      }
      return localObject2;
      if (a(paramContext))
      {
        localObject1 = aqwr.b((aqwr)localObject1);
      }
      else
      {
        int i = ((Integer)bhhr.a(paramContext, "", "key_deep_clean_show_time", Integer.valueOf(0))).intValue();
        a(paramContext, i);
        switch (i)
        {
        default: 
          localObject1 = aqwr.d((aqwr)localObject1);
          break;
        case 0: 
          localObject1 = aqwr.b((aqwr)localObject1);
          break;
        case 1: 
          localObject1 = aqwr.c((aqwr)localObject1);
          continue;
          localObject1 = "";
        }
      }
    }
  }
  
  public static void a()
  {
    bhhr.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(true));
  }
  
  private static void a(Context paramContext, int paramInt)
  {
    if (paramInt < 2) {
      bhhr.a(paramContext, "", true, "key_deep_clean_show_time", Integer.valueOf(paramInt + 1));
    }
  }
  
  public static boolean a()
  {
    aqwr localaqwr = (aqwr)aqxe.a().a(678);
    return (localaqwr != null) && (localaqwr.a());
  }
  
  private static boolean a(Context paramContext)
  {
    return ((Boolean)bhhr.a(paramContext, "", "key_deep_clean_user_click", Boolean.valueOf(false))).booleanValue();
  }
  
  @NonNull
  public aqwr a(int paramInt)
  {
    return new aqwr();
  }
  
  @Nullable
  public aqwr a(aqxa[] paramArrayOfaqxa)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      paramArrayOfaqxa = paramArrayOfaqxa[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("DeepCleanConfigProcessor", 2, "onParsed, content:" + paramArrayOfaqxa);
      }
      return aqwr.a(paramArrayOfaqxa);
    }
    return new aqwr();
  }
  
  public void a(aqwr paramaqwr)
  {
    bhhr.a(BaseApplication.getContext(), "", true, "key_deep_clean_show_time", Integer.valueOf(0));
    bhhr.a(BaseApplication.getContext(), "", true, "key_deep_clean_user_click", Boolean.valueOf(false));
    if (QLog.isColorLevel()) {
      QLog.d("DeepCleanConfigProcessor", 2, "DeepCleanConfigProcessor onUpdate");
    }
  }
  
  public Class<aqwr> clazz()
  {
    return aqwr.class;
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
 * Qualified Name:     aqwq
 * JD-Core Version:    0.7.0.1
 */