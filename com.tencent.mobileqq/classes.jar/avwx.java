import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import javax.annotation.Nullable;

public class avwx
  implements belg
{
  private QQAppInterface a;
  
  public avwx(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(String paramString, int paramInt)
  {
    bejv localbejv = (bejv)this.a.getManager(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER);
    if (paramInt == 4) {
      bdla.b(this.a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_join_suc", 0, 1, paramString, "", "", "");
    }
    do
    {
      return;
      if (paramInt == 9)
      {
        bdla.b(this.a, "dc00899", "c2c_AIO", "", "sing_tab", "clk_singark_suc", 0, 1, paramString, "", "", "");
        return;
      }
      if (paramInt == 1)
      {
        localbejv.a("sing_tab", "clk_join_suc", 0, paramString);
        return;
      }
    } while (paramInt != 8);
    localbejv.a("sing_tab", "clk_setsing_suc", 0, paramString);
  }
  
  private boolean a(boolean paramBoolean, Bundle paramBundle, String paramString, Context paramContext, int paramInt)
  {
    if ((!paramBoolean) || (paramInt <= 0)) {
      return true;
    }
    paramString = ((avwq)this.a.getManager(QQManagerFactory.FETCH_OPENID_MANAGER)).a(Long.parseLong(paramString), paramInt, true);
    if (TextUtils.isEmpty(paramString))
    {
      Toast.makeText(paramContext, "加载中，请稍后再试。", 1).show();
      return false;
    }
    paramBundle.putString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID", paramString);
    return true;
  }
  
  public int a()
  {
    return 9;
  }
  
  public int a(int paramInt1, String paramString, Context paramContext, int paramInt2, Map<String, bekh> paramMap, Bundle paramBundle)
  {
    a(paramString, paramInt2);
    Object localObject = "4_" + paramInt1 + "_" + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + (String)localObject + " from=" + paramInt2);
    }
    int i;
    if (paramInt1 == 2) {
      i = 2080;
    }
    while (((paramInt2 == 4) || (paramInt2 == 1) || (paramInt2 == 9) || (paramInt2 == 8)) && (paramMap != null) && (paramMap.get(localObject) != null))
    {
      paramMap = (SingTogetherSession)paramMap.get(localObject);
      if (!TextUtils.isEmpty(paramMap.b))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramMap.b, i, null);
        return 1;
        i = 2081;
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA is empty");
      }
    }
    if (TextUtils.isEmpty(""))
    {
      localObject = ((argb)aqxe.a().a(551)).a(4);
      if ((localObject != null) && (((argc)localObject).c != 1))
      {
        bool = TextUtils.isEmpty(((argc)localObject).a);
        if (bool)
        {
          paramMap = "mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc";
          if (!bool) {
            break label299;
          }
          paramInt2 = 2;
          label261:
          if (paramInt1 != 2) {
            break label309;
          }
        }
        label299:
        label309:
        for (bool = true;; bool = false)
        {
          if (a(bool, paramBundle, paramString, paramContext, ((argc)localObject).d)) {
            break label315;
          }
          return 0;
          paramMap = ((argc)localObject).a;
          break;
          paramInt2 = ((argc)localObject).b;
          break label261;
        }
        label315:
        beki.a(this.a, paramInt2, paramMap, null, paramBundle, paramInt1);
        return 2;
      }
      if (paramInt1 == 2) {}
      for (boolean bool = true; !a(bool, paramBundle, paramString, paramContext, 1109995692); bool = false) {
        return 0;
      }
      if (paramInt1 == 1) {}
      for (paramString = beki.a("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle);; paramString = beki.b("mqqapi://miniapp/open?_atype=0&_mappid=1109995692&_mvid=&_path=%2Fpages%2Findex%2Fmain&_vt=3&_sig=87d212c596d5dd75907b38e2a96705ec4d7eef6a557f4cbba1f69df0d0d991fc", paramBundle))
      {
        MiniAppLauncher.startMiniApp(paramContext, paramString, i, null);
        if (QLog.isColorLevel()) {
          QLog.d("TogetherSingDelegate", 2, "TogetherSingDelegate start SCHEMA=" + paramString);
        }
        return 3;
      }
    }
    return -1;
  }
  
  public QQCustomDialog a()
  {
    return null;
  }
  
  public String a()
  {
    return "一起K歌";
  }
  
  public void a() {}
  
  public void a(Context paramContext, int paramInt1, int paramInt2, int paramInt3, @Nullable Map<String, bekh> paramMap, @Nullable Bundle paramBundle) {}
  
  public void a(Context paramContext, SessionInfo paramSessionInfo, int paramInt) {}
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, Bundle paramBundle) {}
  
  public void a(bekh parambekh, int paramInt, String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, bekh> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
  
  public boolean a(Context paramContext, String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Map<String, bekh> paramMap, @Nullable Bundle paramBundle)
  {
    return true;
  }
  
  public boolean b(Context paramContext, String paramString, int paramInt1, int paramInt2, @Nullable Map<String, bekh> paramMap, @Nullable Bundle paramBundle)
  {
    a(paramInt1, paramString, paramContext, paramInt2, paramMap, paramBundle);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avwx
 * JD-Core Version:    0.7.0.1
 */