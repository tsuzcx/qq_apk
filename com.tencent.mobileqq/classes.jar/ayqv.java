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
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.troop.enterEffect.TroopEnterEffectController.3;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Vector;

public class ayqv
{
  public static final String a;
  protected Handler a;
  protected SparseArray<ayre> a;
  public LinearLayout a;
  public RelativeLayout a;
  public ScrollView a;
  protected batr a;
  public SpriteGLView a;
  private VasQuickUpdateManager.CallBacker a;
  public boolean a;
  protected String b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ajed.aU + ".troop/enter_effects/";
  }
  
  public ayqv(QQAppInterface paramQQAppInterface, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new ayrd(this);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_Batr = ((bato)paramQQAppInterface.getManager(47)).a(1);
    ((VasQuickUpdateManager)paramQQAppInterface.getManager(184)).addCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
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
  
  public static Bitmap a(String paramString, ayre paramayre)
  {
    Bitmap localBitmap = null;
    if (paramayre.c == 2) {
      paramString = paramString + "/yearsvip/yearsvip_s" + paramayre.b + ".png";
    }
    for (;;)
    {
      try
      {
        localBitmap = bacm.a(paramString, null);
        return localBitmap;
      }
      catch (OutOfMemoryError paramString)
      {
        try
        {
          paramString = bacm.a(paramString, null);
          return paramString;
        }
        catch (OutOfMemoryError paramString) {}
        paramString = paramString;
        return null;
      }
      if (paramayre.c == 1) {
        paramString = paramString + "/svip/svip_s" + paramayre.b + ".png";
      }
    }
    return null;
  }
  
  private ayqt a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    ayrg localayrg = (ayrg)((QQAppInterface)localObject).getManager(231);
    boolean bool = localayrg.a();
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips isShowEnterEffectEveryTime = " + false + " hasShowToday = " + bool);
    }
    if (!bool)
    {
      ayqp localayqp = localayrg.a();
      if (localayqp.a.size() > 0)
      {
        int k = bajo.a((QQAppInterface)localObject, ((QQAppInterface)localObject).c());
        int i;
        int j;
        if (localayrg.b(this.b))
        {
          i = 2;
          j = 0;
        }
        for (;;)
        {
          if (j >= localayqp.a.size()) {
            break label259;
          }
          localObject = (ayqt)localayqp.a.get(j);
          bool = localayrg.a().getBoolean("gray_tips_no_longer_" + ((ayqt)localObject).jdField_a_of_type_Int, false);
          if (QLog.isColorLevel()) {
            QLog.d("TroopEnterEffect.Controller", 2, "getGrayTips id = " + ((ayqt)localObject).jdField_a_of_type_Int + " nolongerShow = " + bool);
          }
          if ((!bool) && (((ayqt)localObject).a(i, k)))
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
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).downloadItem(1004L, "enterEffectVipIcons", "TroopEnterEffectController");
  }
  
  public void a()
  {
    if (babp.e()) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isLowEndPhoneForPreDownload = true");
      }
    }
    ayrg localayrg;
    ayre localayre;
    do
    {
      do
      {
        do
        {
          return;
          if (!awnu.b()) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("TroopEnterEffect.Controller", 2, "playAnimaions: isSimpleUISwitch = true");
        return;
        localayrg = (ayrg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(231);
      } while (localayrg == null);
      localayre = localayrg.a(this.b);
    } while ((localayre == null) || (!a(localayre)));
    if (System.currentTimeMillis() - localayre.jdField_a_of_type_Long < 60000L)
    {
      a(localayre);
      return;
    }
    localayrg.b(localayre);
  }
  
  public void a(ayre paramayre)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "showAnimation: enterEffectData = " + paramayre + " isAio = " + this.jdField_a_of_type_Boolean);
    }
    Object localObject1;
    String str;
    Object localObject2;
    View localView2;
    View localView3;
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView == null)
    {
      localObject1 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      str = ((QQAppInterface)localObject1).c();
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramayre.jdField_a_of_type_JavaLangString))) {
        break label434;
      }
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E5F", "", 1, 0, 0, "", Integer.toString(paramayre.jdField_a_of_type_Int), "");
      localObject2 = (ayrg)((QQAppInterface)localObject1).getManager(231);
      if (localObject2 != null) {
        ((ayrg)localObject2).b(paramayre);
      }
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView = new SpriteGLView(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 1);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.b = true;
      localObject2 = new RelativeLayout.LayoutParams(-1, 0);
      View localView1 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131311893);
      localView2 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131312048);
      localView3 = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131307242);
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
        this.jdField_a_of_type_AndroidWidgetScrollView = new ayqw(this, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext());
        this.jdField_a_of_type_AndroidWidgetScrollView.setClickable(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.setEnabled(false);
        this.jdField_a_of_type_AndroidWidgetScrollView.addView(this.jdField_a_of_type_AndroidWidgetLinearLayout, -1, azvv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight()));
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetScrollView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView, -1, 0);
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.setOnTouchListener(new ayqx(this, str, paramayre));
      this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView.post(new TroopEnterEffectController.3(this, paramayre));
      paramayre = (ayrg)((QQAppInterface)localObject1).getManager(231);
      localObject1 = a();
      if (localObject1 != null) {
        paramayre.a((ayqt)localObject1, this.b);
      }
      ayrg.a("Grp_AIO", "action_play", new String[0]);
      return;
      label434:
      VasWebviewUtil.reportCommercialDrainage(str, "style", "0X8008E60", "", 1, 0, 0, "", Integer.toString(paramayre.jdField_a_of_type_Int), "");
      break;
      label466:
      if ((localView2 != null) && (localView2.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView2.getBottom();
      } else if ((localView3 != null) && (localView3.getVisibility() == 0)) {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = localView3.getBottom();
      } else {
        ((RelativeLayout.LayoutParams)localObject2).topMargin = azvv.a(this.jdField_a_of_type_AndroidWidgetRelativeLayout.getContext(), 50.0F);
      }
    }
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public boolean a(ayre paramayre)
  {
    int i = paramayre.jdField_a_of_type_Int;
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "downloadAnimationResources: id = " + i);
    }
    String str = jdField_a_of_type_JavaLangString + i;
    if (azkd.a(new File(str))) {
      return true;
    }
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(i) != null) {
      return false;
    }
    bace.a(str);
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).downloadItem(25L, "groupeffect_item_" + i + ".zip", "TroopEnterEffectController");
    this.jdField_a_of_type_AndroidUtilSparseArray.put(i, paramayre);
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
    ayrg localayrg = (ayrg)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(231);
    if (localayrg != null) {
      localayrg.b(this.b);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopEnterEffect.Controller", 2, "onDestroy remove quickupdate callback");
    }
    ((VasQuickUpdateManager)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(184)).removeCallBacker(this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayqv
 * JD-Core Version:    0.7.0.1
 */