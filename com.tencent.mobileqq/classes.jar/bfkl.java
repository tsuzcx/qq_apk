import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;

public class bfkl
{
  public static final String a;
  protected Handler a;
  protected SparseArray<bfku> a;
  public LinearLayout a;
  public RelativeLayout a;
  public ScrollView a;
  protected bhyt a;
  public SpriteGLView a;
  private VasQuickUpdateManager.CallBacker a;
  public boolean a;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + ".troop/enter_effects/");
  }
  
  public bfkl(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new bfkt(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Bhyt = ((bhyq)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY)).a(1);
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
  
  public static int a(String paramString)
  {
    if (paramString.startsWith("groupeffect_item_"))
    {
      paramString = paramString.substring("groupeffect_item_".length(), paramString.length() - ".zip".length());
      if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
        return Integer.parseInt(paramString);
      }
    }
    return -1;
  }
  
  public static Bitmap a(String paramString, bfku parambfku)
  {
    Bitmap localBitmap = null;
    if (parambfku.c == 2) {
      paramString = paramString + "/yearsvip/yearsvip_s" + parambfku.b + ".png";
    }
    for (;;)
    {
      try
      {
        localBitmap = bheg.a(paramString, null);
        return localBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          paramString = bheg.a(paramString, null);
          return paramString;
        }
        catch (OutOfMemoryError paramString) {}
        paramString = paramString;
        return null;
      }
      if (parambfku.c == 1) {
        paramString = paramString + "/svip/svip_s" + parambfku.b + ".png";
      }
    }
    return null;
  }
  
  private bfkj a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    bfkw localbfkw = (bfkw)((QQAppInterface)localObject).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    boolean bool = localbfkw.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      bfkf localbfkf = localbfkw.a();
      if (localbfkf.a.size() > 0)
      {
        int k = bhiw.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentUin());
        int i;
        int j;
        if (localbfkw.b(this.b))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localbfkf.a.size()) {
            break label259;
          }
          localObject = (bfkj)localbfkf.a.get(j);
          bool = localbfkw.a().getBoolean("gray_tips_no_longer_" + ((bfkj)localObject).jdField_a_of_type_Int, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + ((bfkj)localObject).jdField_a_of_type_Int + " nolongerShow = " + bool);
          }
          if ((!bool) && (((bfkj)localObject).a(i, k)))
          {
            return localObject;
            i = 1;
            break;
          }
          j += 1;
        }
      }
    }
    label259:
    return null;
  }
  
  public static String a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons.zip").getAbsolutePath();
    }
    return null;
  }
  
  public static String a(int paramInt)
  {
    return jdField_a_of_type_JavaLangString + paramInt + File.separator + paramInt + ".zip";
  }
  
  public static String b()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (localBaseApplicationImpl != null) {
      return new File(localBaseApplicationImpl.getFilesDir(), "enterEffectVipIcons").getAbsolutePath();
    }
    return null;
  }
  
  public static void b()
  {
    String str = b();
    if (TextUtils.isEmpty(str)) {
      QLog.e("TroopEnterEffect.Controller", 1, "checkVipIconsExists get null path");
    }
    while (ThemeUtil.getFileNumInFile(new File(str)) != 0) {
      return;
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
  }
  
  public void a()
  {
    if (DeviceInfoUtil.isLowEndPhoneForPreDownload()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    bfkw localbfkw;
    bfku localbfku;
    do
    {
      do
      {
        do
        {
          return;
          if (!bdfk.b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
        return;
        localbfkw = (bfkw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      } while (localbfkw == null);
      localbfku = localbfkw.a(this.b);
    } while ((localbfku == null) || (!a(localbfku)));
    if (System.currentTimeMillis() - localbfku.jdField_a_of_type_Long < 60000L)
    {
      a(localbfku);
      return;
    }
    localbfkw.b(localbfku);
  }
  
  public void a(bfku parambfku)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + parambfku + " isAio = " + this.jdField_a_of_type_Boolean);
    }
    Object localObject1;
    String str;
    Object localObject2;
    View localView2;
    View localView3;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str = ((QQAppInterface)localObject1).getCurrentUin();
      if ((TextUtils.isEmpty(str)) || (!str.equals(parambfku.jdField_a_of_type_JavaLangString))) {
        break label434;
      }
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(parambfku.jdField_a_of_type_Int), "");
      localObject2 = (bfkw)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      if (localObject2 != null) {
        ((bfkw)localObject2).b(parambfku);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      localObject2 = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379391);
      localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131379581);
      localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374261);
      if ((localView1 == null) || (localView1.getVisibility() != 0)) {
        break label466;
      }
      ((RelativeLayout.LayoutParams)localObject2).topMargin = localView1.getBottom();
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
      }
      if (this.jdField_a_of_type_AndroidWidgetScrollView == null)
      {
        this.jdField_a_of_type_AndroidWidgetScrollView = new bfkm(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
        this.jdField_a_of_type_AndroidWidgetScrollView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, DisplayUtil.dip2px(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new bfkn(this, str, parambfku));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new TroopEnterEffectController.3(this, parambfku));
      parambfku = (bfkw)((QQAppInterface)localObject1).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
      localObject1 = a();
      if (localObject1 != null) {
        parambfku.a((bfkj)localObject1, this.b);
      }
      bfkw.a("Grp_AIO", "action_play", new String[0]);
      return;
      label434:
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(parambfku.jdField_a_of_type_Int), "");
      break;
      label466:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView3.getBottom();
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(bfku parambfku)
  {
    int i = parambfku.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i);
    }
    String str = jdField_a_of_type_JavaLangString + i;
    if (bglb.a(new File(str))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    FileUtils.deleteDirectory(str);
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).downloadItem(25L, "groupeffect_item_" + i + ".zip", "TroopEnterEffectController");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, parambfku);
    return false;
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onResume");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.n();
      this.jdField_a_of_type_AndroidWidgetScrollView.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_a_of_type_AndroidWidgetScrollView);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = null;
      this.jdField_a_of_type_AndroidWidgetScrollView = null;
      this.jdField_a_of_type_AndroidWidgetLinearLayout = null;
    }
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    bfkw localbfkw = (bfkw)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.TROOP_ENTER_EFFECT_MANAGER);
    if (localbfkw != null) {
      localbfkw.b(this.b);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfkl
 * JD-Core Version:    0.7.0.1
 */