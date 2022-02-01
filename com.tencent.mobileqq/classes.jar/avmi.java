import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingView;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.listener.IVideoOuterStatusListener;
import com.tencent.qphone.base.util.QLog;
import javax.annotation.Nonnull;
import mqq.util.WeakReference;

public class avmi
{
  private static volatile avmi jdField_a_of_type_Avmi;
  private long jdField_a_of_type_Long;
  private avmm jdField_a_of_type_Avmm;
  private bhnx jdField_a_of_type_Bhnx;
  private volatile WatchTogetherFloatingData jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData;
  private WatchTogetherFloatingView jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView;
  private WeakReference<avml> jdField_a_of_type_MqqUtilWeakReference;
  private volatile boolean jdField_a_of_type_Boolean;
  private WatchTogetherFloatingData jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData;
  private WeakReference<IVideoOuterStatusListener> jdField_b_of_type_MqqUtilWeakReference;
  
  private int a(Context paramContext, float paramFloat)
  {
    Object localObject = new FloatingScreenParams.FloatingBuilder();
    if (paramFloat < 1.0F) {}
    FloatingScreenManager localFloatingScreenManager;
    for (int i = 1;; i = 2)
    {
      localObject = ((FloatingScreenParams.FloatingBuilder)localObject).setShapeType(i).setCanMove(true).setRatio(paramFloat).setFloatingCenterX(300).setFloatingCenterY(-680).build();
      localFloatingScreenManager = FloatingScreenManager.getInstance();
      i = localFloatingScreenManager.enterWatchTogetherFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView, (FloatingScreenParams)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
      }
      if (i != 1) {
        break;
      }
      avmc.a(paramContext, 4, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin());
      return i;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(localFloatingScreenManager.setFloatingVideoListener(new avmj(this), 2));
    localFloatingScreenManager.setWindowClickListener(2, new avmk(this, paramContext));
    return 0;
  }
  
  public static avmi a()
  {
    if (jdField_a_of_type_Avmi == null) {}
    try
    {
      if (jdField_a_of_type_Avmi == null) {
        jdField_a_of_type_Avmi = new avmi();
      }
      return jdField_a_of_type_Avmi;
    }
    finally {}
  }
  
  private boolean a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow uin is empty or data==null");
      }
    }
    do
    {
      return false;
      if ((paramString.equals(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin())) && (paramInt == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType())) {
        break;
      }
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder("closeFloatingWindow uin or type not match:");
    localStringBuilder.append("mCurType=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()).append(" sessionType=").append(paramInt).append(" mCurUin=").append(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin()).append(" uin=").append(paramString);
    QLog.d("WatchFloatingWindowController", 2, localStringBuilder.toString());
    return false;
    return true;
  }
  
  public int a(Context paramContext, @Nonnull WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(BaseApplicationImpl.getContext(), 2131693948, 0).a();
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return 4;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData != null) && (paramWatchTogetherFloatingData != null) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin().equals(paramWatchTogetherFloatingData.getCurUin())) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType() == this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType()) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "showFloatingWindow:  duplicate show");
      }
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return 5;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = new WatchTogetherFloatingView(BaseApplicationImpl.getContext());
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(true);
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = paramWatchTogetherFloatingData;
      if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() > 0.0D) && (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth() > 0.0D)) {
        break label204;
      }
    }
    label204:
    for (float f = 0.5625F;; f = (float)(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight() / this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()))
    {
      int i = a(paramContext, f);
      if (i == 0) {
        break label224;
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
      return i;
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(paramWatchTogetherFloatingData.getSmallUrl());
      break;
    }
    label224:
    this.jdField_a_of_type_Boolean = true;
    Intent localIntent = new Intent();
    localIntent.putExtra("web_view_module_from", 1);
    localIntent.putExtra("url", paramWatchTogetherFloatingData.getSmallUrl());
    this.jdField_a_of_type_Bhnx = new bhnx(localIntent, paramContext);
    this.jdField_a_of_type_Bhnx.a();
    avmc.a(true, paramWatchTogetherFloatingData.getCurUin(), paramWatchTogetherFloatingData.getCurType(), true);
    bies.a(BaseApplicationImpl.getContext(), 50, 0);
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, oooo");
      }
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), true);
  }
  
  public void a(double paramDouble1, double paramDouble2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "updateWindowSize videoWidth =" + paramDouble1 + " videoHeight=" + paramDouble2);
    }
    if ((paramDouble1 <= 0.0D) || (paramDouble2 <= 0.0D)) {
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is invalid");
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
      if ((paramDouble1 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoWidth()) || (paramDouble2 != this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getVideoHeight())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "updateWindowSize params is equal");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoWidth(paramDouble1);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setVideoHeight(paramDouble2);
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    float f = (float)(paramDouble2 / paramDouble1);
    localFloatingScreenManager.updateFloatingWindowRatio(f, 2);
    if (f < 1.0F) {}
    for (int i = 1;; i = 2)
    {
      localFloatingScreenManager.updateFloatingWindowShape(i, 2);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    a(this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType(), paramInt);
  }
  
  public void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WatchFloatingWindowController", 2, "showFloatingWindowByPendingData");
    }
    if (paramContext == null) {}
    while (this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {
      return;
    }
    a(paramContext, this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData);
  }
  
  public void a(avml paramavml)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramavml);
  }
  
  public void a(WatchTogetherFloatingData paramWatchTogetherFloatingData)
  {
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = paramWatchTogetherFloatingData;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) || (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null)) {}
    do
    {
      return;
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((avml)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt2);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a() == 1);
    a(paramString, paramInt1, true);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (!a(paramString, paramInt)) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeFloatingWindow, but isSuccessCreateFloatingView is false");
    return;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    this.jdField_b_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData = null;
    if (this.jdField_a_of_type_Bhnx != null)
    {
      this.jdField_a_of_type_Bhnx.e();
      this.jdField_a_of_type_Bhnx.c();
      this.jdField_a_of_type_Bhnx = null;
    }
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView = null;
    FloatingScreenManager.getInstance().quitFloatingScreen(2);
    avmc.a(false, paramString, paramInt, paramBoolean);
    if (this.jdField_a_of_type_Avmm != null)
    {
      awjg.a().a(this.jdField_a_of_type_Avmm);
      this.jdField_a_of_type_Avmm = null;
    }
    this.jdField_b_of_type_MqqUtilWeakReference = null;
    FloatingScreenManager.getInstance().setFloatingVideoListener(null, 2);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return;
    }
    avml localavml = (avml)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      localavml.b(i);
      return;
    }
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_Bhnx == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return false;
      localTouchWebView = this.jdField_a_of_type_Bhnx.a;
    } while (localTouchWebView == null);
    return localTouchWebView.isShown();
  }
  
  public void b()
  {
    int i = 2;
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("WatchFloatingWindowController", 2, "closeOrQuitBusiness, but isSuccessCreateFloatingView is false");
    return;
    String str = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin();
    int j = this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurType();
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.isIsAdm()) {
      i = 1;
    }
    a(str, j, i);
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData == null);
        if (this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() != paramInt) {
          break;
        }
      } while (paramInt != 2);
      bcst.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
      return;
      if (QLog.isColorLevel()) {
        QLog.d("WatchFloatingWindowController", 2, "updateLoadingStatus mLoadingStatus=" + this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getLoadingStatus() + " status=" + paramInt);
      }
      this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.setLoadingStatus(paramInt);
      if (paramInt == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(false);
        if (this.jdField_a_of_type_Avmm == null)
        {
          this.jdField_a_of_type_Avmm = new avmm(this.jdField_b_of_type_MqqUtilWeakReference);
          awjg.a().a(1, this.jdField_a_of_type_Avmm);
          return;
        }
        this.jdField_a_of_type_Avmm.a(this.jdField_b_of_type_MqqUtilWeakReference);
        return;
      }
    } while (paramInt != 2);
    bcst.b(null, "dc00899", "Grp_AIO", "", "video_tab", "clk_refresh_error", 0, 0, this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingData.getCurUin(), "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a();
  }
  
  public void b(avml paramavml)
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() == paramavml)) {
      this.jdField_a_of_type_MqqUtilWeakReference = null;
    }
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView == null) || (this.jdField_a_of_type_Bhnx == null)) {}
    TouchWebView localTouchWebView;
    do
    {
      return;
      localTouchWebView = this.jdField_a_of_type_Bhnx.a;
    } while (localTouchWebView == null);
    this.jdField_a_of_type_ComTencentMobileqqIntervideoYiqikanWatchTogetherFloatingView.a(localTouchWebView);
    this.jdField_a_of_type_Bhnx.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avmi
 * JD-Core Version:    0.7.0.1
 */