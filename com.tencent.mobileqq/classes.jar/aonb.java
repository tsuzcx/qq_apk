import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class aonb
  extends aokh<aonc>
{
  public int a()
  {
    return 567;
  }
  
  @NonNull
  public aonc a(int paramInt)
  {
    return new aonc();
  }
  
  @Nullable
  public aonc a(aoko[] paramArrayOfaoko)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onParsed");
    }
    if ((paramArrayOfaoko != null) && (paramArrayOfaoko.length > 0))
    {
      paramArrayOfaoko = paramArrayOfaoko[0].a;
      if (QLog.isColorLevel()) {
        QLog.d("BroadcastConfProcessor", 2, "onParsed, content:" + paramArrayOfaoko);
      }
      aonc localaonc = aonc.a(paramArrayOfaoko);
      if (!TextUtils.isEmpty(paramArrayOfaoko))
      {
        BaseApplicationImpl.getApplication().getSharedPreferences("broadcast_white_pref", 4).edit().putString("white_list", paramArrayOfaoko).apply();
        MobileQQ.addBroadcastWhitList(localaonc.a);
      }
    }
    return new aonc();
  }
  
  public Class<aonc> a()
  {
    return aonc.class;
  }
  
  public void a(int paramInt) {}
  
  public void a(aonc paramaonc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BroadcastConfProcessor", 2, "onUpdate");
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
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
 * Qualified Name:     aonb
 * JD-Core Version:    0.7.0.1
 */