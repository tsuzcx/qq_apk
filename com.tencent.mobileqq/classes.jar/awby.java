import android.widget.Button;
import android.widget.PopupMenu;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.olympic.activity.ScanTorchActivity;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class awby
{
  static final String jdField_a_of_type_JavaLangString = amuc.jdField_a_of_type_JavaLangString + "_Res";
  long jdField_a_of_type_Long = 0L;
  private amts jdField_a_of_type_Amts;
  private amub jdField_a_of_type_Amub;
  private awcd jdField_a_of_type_Awcd;
  private azgh jdField_a_of_type_Azgh;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private ScanTorchActivity jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity;
  private boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = { 100, 100, 100, 100, 100 };
  
  public awby(ScanTorchActivity paramScanTorchActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = paramScanTorchActivity;
  }
  
  private void a(AppInterface paramAppInterface, amts paramamts)
  {
    if ((paramamts != null) && ((!paramamts.jdField_a_of_type_Boolean) || (paramamts.a() != null)))
    {
      this.jdField_a_of_type_Amts = paramamts;
      d(paramAppInterface);
      amuc.a(paramAppInterface).a(paramAppInterface, paramamts.jdField_a_of_type_JavaLangString);
      a(paramAppInterface, this.jdField_a_of_type_Awcd.c());
      return;
    }
    a("onGetTransferDoorConfig", paramAppInterface, true);
  }
  
  private void a(AppInterface paramAppInterface, boolean paramBoolean)
  {
    boolean bool = a(paramAppInterface);
    if (this.jdField_a_of_type_ArrayOfInt[0] == 100) {
      a("tryDownload", paramAppInterface);
    }
    if (bool)
    {
      a("tryDownload", paramAppInterface, false);
      return;
    }
    this.jdField_a_of_type_Boolean = paramBoolean;
    a("tryDownload", true);
  }
  
  private void a(String paramString, AppInterface paramAppInterface)
  {
    boolean bool1 = false;
    if (d()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkEntryRes, scanTorchActivity为空");
    }
    boolean bool2;
    do
    {
      return;
      paramAppInterface = a();
      if (paramAppInterface == null)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "checkEntryRes, promotion为空");
        return;
      }
      bool2 = this.jdField_a_of_type_Awcd.b();
      if (this.jdField_a_of_type_ArrayOfInt[0] == 100) {
        bool1 = true;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkEntryRes, from[" + paramString + "], isReadyShowEntry[" + bool2 + "], isEntryReady[" + bool1 + "], promotionItem[" + paramAppInterface + "]");
    } while ((!bool2) || (!bool1));
    this.jdField_a_of_type_Awcd.a(paramAppInterface);
  }
  
  private void a(String paramString, AppInterface paramAppInterface, boolean paramBoolean)
  {
    if (d()) {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, scanTorchActivity为空, from[" + paramString + "], notify[" + paramBoolean + "]");
    }
    do
    {
      return;
      paramAppInterface = a();
      if (paramAppInterface != null) {
        break;
      }
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, promotionItem为空, from[" + paramString + "], notify[" + paramBoolean + "]");
    } while (!paramBoolean);
    this.jdField_a_of_type_Awcd.a(paramAppInterface, false);
    return;
    a("checkAllRes", true);
    if (a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, 还在下载中, from[" + paramString + "], notify[" + paramBoolean + "]");
      return;
    }
    if (b())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, 下载失败, from[" + paramString + "], notify[" + paramBoolean + "]");
      this.jdField_a_of_type_Awcd.a(paramAppInterface, false);
      return;
    }
    if (!this.jdField_a_of_type_Awcd.a())
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, ArEngine未准备好, from[" + paramString + "], notify[" + paramBoolean + "]");
      return;
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "checkAllRes, all ready, from[" + paramString + "], notify[" + paramBoolean + "]");
    a();
    this.jdField_a_of_type_Awcd.a(paramAppInterface, true);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (d()) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Long == 0L)
      {
        this.jdField_a_of_type_Long = (System.currentTimeMillis() + 1500L);
        QLog.w(jdField_a_of_type_JavaLangString, 1, "showDownloadProgress, 忽略1, from[" + paramString + "], progress[" + paramBoolean + "]");
        return;
      }
      if (this.jdField_a_of_type_Long > System.currentTimeMillis())
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "showDownloadProgress, 忽略2, from[" + paramString + "], progress[" + paramBoolean + "]");
        return;
      }
    } while ((!paramBoolean) || (!c()));
    this.jdField_a_of_type_Awcd.a("PromotionRes_" + paramString, 0);
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.c);
  }
  
  public int a()
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_ArrayOfInt.length)
    {
      j += this.jdField_a_of_type_ArrayOfInt[i];
      i += 1;
    }
    return j / this.jdField_a_of_type_ArrayOfInt.length;
  }
  
  public amts a()
  {
    return this.jdField_a_of_type_Amts;
  }
  
  void a()
  {
    if (AudioHelper.a(5) != 1) {}
    Button localButton;
    do
    {
      return;
      localButton = (Button)this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity.findViewById(2131365026);
      localButton.setVisibility(0);
    } while (localButton.getTag() != null);
    localButton.setTag(new Object());
    localButton.setOnClickListener(new awcc(this));
  }
  
  public void a(awcd paramawcd)
  {
    this.jdField_a_of_type_Awcd = paramawcd;
  }
  
  public void a(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a(AppInterface paramAppInterface, PopupMenu paramPopupMenu) {}
  
  public void a(AppInterface paramAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Awcd.c())
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "getRes,  需要显示穿越门进度条");
      this.jdField_a_of_type_Boolean = true;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "getRes, activityID[" + paramString + "], TotalProgress[" + a() + "]");
    amuc.a(paramAppInterface).a(paramAppInterface, new awbz(this, paramString, paramAppInterface));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if ((this.jdField_a_of_type_ArrayOfInt[i] >= 0) && (this.jdField_a_of_type_ArrayOfInt[i] <= 99))
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "isDownloading, index[" + i + "], Progress[" + this.jdField_a_of_type_ArrayOfInt[i] + "]");
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    Object localObject1 = a();
    if (localObject1 == null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "isResReady no promotion Item so reay");
      return true;
    }
    localObject1 = ((amts)localObject1).a();
    int i = ((TreeMap)localObject1).size();
    Object localObject2;
    if (i + 1 > this.jdField_a_of_type_ArrayOfInt.length)
    {
      localObject2 = "checkRes, zip数目不对, itemCount[" + i + "]";
      QLog.w(jdField_a_of_type_JavaLangString, 1, (String)localObject2);
      if (AudioHelper.d()) {
        throw new IllegalStateException((String)localObject2);
      }
    }
    localObject1 = ((TreeMap)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (amtt)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if (amtz.a(paramAppInterface.getCurrentAccountUin(), (amtt)localObject2)) {
        this.jdField_a_of_type_ArrayOfInt[localObject2.a] = 100;
      } else {
        this.jdField_a_of_type_ArrayOfInt[localObject2.a] = 0;
      }
    }
    if (aziv.b())
    {
      this.jdField_a_of_type_ArrayOfInt[3] = 100;
      int j = a();
      QLog.w(jdField_a_of_type_JavaLangString, 1, "checkRes, itemCount[" + i + "], Progress0[" + this.jdField_a_of_type_ArrayOfInt[0] + "], Progress1[" + this.jdField_a_of_type_ArrayOfInt[1] + "], Progress2[" + this.jdField_a_of_type_ArrayOfInt[2] + "], Progress3[" + this.jdField_a_of_type_ArrayOfInt[3] + "], TotalProgress[" + j + "]");
      if (j != 100) {
        break label324;
      }
    }
    label324:
    for (boolean bool = true;; bool = false)
    {
      return bool;
      this.jdField_a_of_type_ArrayOfInt[3] = 0;
      break;
    }
  }
  
  public void b(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqOlympicActivityScanTorchActivity = null;
    if (this.jdField_a_of_type_Amub != null)
    {
      amuc.a(paramAppInterface).b(this.jdField_a_of_type_Amub);
      this.jdField_a_of_type_Amub = null;
    }
    if (this.jdField_a_of_type_Azgh != null) {
      azgg.a().a(false, this.jdField_a_of_type_Azgh);
    }
    this.jdField_a_of_type_Amts = null;
  }
  
  public boolean b()
  {
    if (a()) {}
    for (;;)
    {
      return false;
      int i = 0;
      while (i < this.jdField_a_of_type_ArrayOfInt.length)
      {
        if (this.jdField_a_of_type_ArrayOfInt[i] < 0)
        {
          QLog.w(jdField_a_of_type_JavaLangString, 1, "isDownloadError, index[" + i + "], errCode[" + this.jdField_a_of_type_ArrayOfInt[i] + "]");
          return true;
        }
        i += 1;
      }
    }
  }
  
  public void c(AppInterface paramAppInterface)
  {
    amts localamts = a();
    boolean bool2 = a();
    boolean bool1 = false;
    if (!bool2) {
      bool1 = b();
    }
    QLog.w(jdField_a_of_type_JavaLangString, 1, "reTry, promotionItem[" + localamts + "], isDownloading[" + bool2 + "], isDownloadError[" + bool1 + "], needShowDownloadProgress[" + this.jdField_a_of_type_Boolean + "], TotalProgress[" + a() + "]");
    this.jdField_a_of_type_Boolean = true;
    if (localamts == null) {}
    while (bool2) {
      return;
    }
    amuc.a(paramAppInterface).a(paramAppInterface, localamts.jdField_a_of_type_JavaLangString);
    a(paramAppInterface, this.jdField_a_of_type_Awcd.c());
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  void d(AppInterface paramAppInterface)
  {
    if (this.jdField_a_of_type_Amub != null) {
      return;
    }
    this.jdField_a_of_type_Azgh = new awca(this, paramAppInterface);
    azgg.a().a(true, this.jdField_a_of_type_Azgh);
    this.jdField_a_of_type_Amub = new awcb(this, paramAppInterface);
    amuc.a(paramAppInterface).a(this.jdField_a_of_type_Amub);
  }
  
  public void e(AppInterface paramAppInterface)
  {
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onAREngineReady");
    a("onAREngineReady", paramAppInterface, false);
  }
  
  public void f(AppInterface paramAppInterface)
  {
    a("onAREngineReady", paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awby
 * JD-Core Version:    0.7.0.1
 */