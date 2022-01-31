package com.tencent.mobileqq.apollo.process.ui.framework;

import akpq;
import akpy;
import akro;
import aktr;
import akvn;
import akvo;
import alpo;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bhow;
import com.tencent.biz.webviewplugin.Hole;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class QzoneGameFloatView
  extends FrameworkView
  implements View.OnClickListener
{
  public int a;
  public View a;
  public Hole a;
  private boolean a;
  public int b;
  public View b;
  private boolean b;
  public View c;
  private boolean c;
  public View d;
  public View e;
  public View f;
  public View g;
  public View h;
  public View i;
  
  public QzoneGameFloatView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    this.jdField_c_of_type_Boolean = true;
    paramContext = LayoutInflater.from(paramContext);
    if (paramStartCheckParam.mGameType == 5) {}
    for (int j = 2131559819;; j = 2131559820)
    {
      paramContext = (FrameLayout)paramContext.inflate(j, null);
      this.i = a();
      if (paramStartCheckParam.mGameType == 5)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_Boolean = true;
        setFrameViewStyle(paramStartCheckParam);
      }
      a(paramContext, this);
      RelativeLayout localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375990);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      addView(paramContext, localLayoutParams);
      if (paramStartCheckParam.mGameType == 5)
      {
        e();
        if ((this.g != null) && (this.g.getVisibility() == 0)) {
          this.g.setVisibility(8);
        }
      }
      setBackgroundColor(0);
      localRelativeLayout.addView(this.i);
      localRelativeLayout.addView(this, localLayoutParams);
      return;
    }
  }
  
  private View a()
  {
    View localView = new View((Context)this.jdField_a_of_type_MqqUtilWeakReference.get());
    localView.setId(2131370067);
    localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    localView.setBackgroundColor(1996488704);
    localView.setVisibility(8);
    return localView;
  }
  
  private void e()
  {
    if ((this.f != null) && ((this.f instanceof TextView)) && (this.jdField_c_of_type_Boolean))
    {
      ((TextView)this.f).setCompoundDrawablesWithIntrinsicBounds(0, 2130842266, 0, 0);
      ((TextView)this.f).setTextColor(getResources().getColor(2131167082));
    }
    if ((this.g != null) && ((this.g instanceof TextView)))
    {
      ((TextView)this.g).setCompoundDrawablesWithIntrinsicBounds(0, 2130842263, 0, 0);
      ((TextView)this.g).setTextColor(getResources().getColor(2131167082));
    }
    if ((this.e != null) && ((this.e instanceof TextView)))
    {
      ((TextView)this.e).setCompoundDrawablesWithIntrinsicBounds(0, 2130842257, 0, 0);
      ((TextView)this.e).setTextColor(getResources().getColor(2131167082));
    }
    if ((this.d != null) && ((this.d instanceof TextView)))
    {
      ((TextView)this.d).setCompoundDrawablesWithIntrinsicBounds(0, 2130842254, 0, 0);
      ((TextView)this.d).setTextColor(getResources().getColor(2131167082));
    }
    if ((this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView instanceof Button))) {
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130842259);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setEnabled(false);
  }
  
  @TargetApi(16)
  public void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics();
    int j;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.viewMode > 0) {
      if (localDisplayMetrics.heightPixels > localDisplayMetrics.widthPixels)
      {
        j = localDisplayMetrics.heightPixels;
        this.jdField_a_of_type_Int = j;
        if (localDisplayMetrics.heightPixels <= localDisplayMetrics.widthPixels) {
          break label375;
        }
        j = localDisplayMetrics.widthPixels;
        label64:
        this.jdField_b_of_type_Int = j;
        this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131366482);
        this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377831);
        this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131363442);
        this.d = paramView.findViewById(2131365864);
        this.f = paramView.findViewById(2131376504);
        this.g = paramView.findViewById(2131376365);
        this.h = paramView.findViewById(2131370702);
        this.e = paramView.findViewById(2131366613);
        this.jdField_a_of_type_ComTencentBizWebviewpluginHole = ((Hole)paramView.findViewById(2131367672));
        b();
        this.g.setVisibility(0);
        this.e.setVisibility(0);
        if (!this.jdField_c_of_type_Boolean) {
          break label453;
        }
        this.f.setVisibility(0);
        label197:
        this.d.setVisibility(0);
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
        SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("secondHandSharePre", 0);
        if ((!localSharedPreferences.getBoolean("first_float_tip", true)) || (this.jdField_b_of_type_Boolean)) {
          break label465;
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        localSharedPreferences.edit().putBoolean("first_float_tip", false).apply();
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(new akvn(this, paramView, localDisplayMetrics));
      }
    }
    for (;;)
    {
      paramView = new akvo(this, localDisplayMetrics);
      this.d.setOnClickListener(paramOnClickListener);
      this.f.setOnClickListener(paramOnClickListener);
      this.h.setOnClickListener(paramOnClickListener);
      this.g.setOnClickListener(paramOnClickListener);
      this.e.setOnClickListener(paramOnClickListener);
      this.jdField_a_of_type_AndroidViewView.setOnTouchListener(paramView);
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(paramView);
      this.i.setOnTouchListener(paramView);
      return;
      j = localDisplayMetrics.widthPixels;
      break;
      label375:
      j = localDisplayMetrics.heightPixels;
      break label64;
      if (localDisplayMetrics.heightPixels < localDisplayMetrics.widthPixels)
      {
        j = localDisplayMetrics.heightPixels;
        label403:
        this.jdField_a_of_type_Int = j;
        if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels) {
          break label444;
        }
      }
      label444:
      for (j = localDisplayMetrics.widthPixels;; j = localDisplayMetrics.heightPixels)
      {
        this.jdField_b_of_type_Int = j;
        break;
        j = localDisplayMetrics.widthPixels;
        break label403;
      }
      label453:
      this.f.setVisibility(8);
      break label197;
      label465:
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void b()
  {
    c();
  }
  
  public void c()
  {
    int j = this.jdField_b_of_type_Int;
    int k = this.jdField_a_of_type_Int;
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = ((int)(k - localDisplayMetrics.density * 70.0F));
    localLayoutParams.topMargin = (j / 2 - this.jdField_a_of_type_AndroidViewView.getWidth() / 2);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void d()
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    this.jdField_a_of_type_Int = localDisplayMetrics.widthPixels;
    this.jdField_b_of_type_Int = localDisplayMetrics.heightPixels;
    c();
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.d) {
      if ((this.jdField_a_of_type_Aktr == null) || (!this.jdField_a_of_type_Aktr.a()))
      {
        QLog.d("cmframe_QzoneGameFloatView", 1, "game not running, finish");
        ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
      }
    }
    do
    {
      for (;;)
      {
        return;
        QLog.d("cmframe_QzoneGameFloatView", 1, "notify game");
        if (!b())
        {
          if (this.jdField_a_of_type_Akpy != null) {
            this.jdField_a_of_type_Akpy.a();
          }
          this.jdField_a_of_type_Aktr.i();
          if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) == 0)) {
            this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(102, 1000L);
          }
        }
        while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)
        {
          akro.a(akro.a(), akpq.a(0, 0, 3, 901003004, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
          return;
          this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(102, 5000L);
          QLog.i("cmframe_QzoneGameFloatView", 1, "comm flag bit0 is 1.");
          continue;
          this.jdField_a_of_type_Bhow.sendEmptyMessage(111);
        }
        continue;
        if (paramView == this.f)
        {
          if ((this.jdField_b_of_type_Boolean) && (!this.jdField_c_of_type_Boolean))
          {
            QQToast.a(getContext(), 0, alpo.a(2131712283), 0).a();
            return;
          }
          if ((this.jdField_a_of_type_Aktr != null) && (this.jdField_a_of_type_Aktr.c()))
          {
            QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
            return;
          }
          if ((this.jdField_a_of_type_Aktr != null) && (this.jdField_a_of_type_Aktr.a()) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null)) {
            try
            {
              paramView = new JSONObject();
              paramView.put("gameId", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
              paramView.put("isSelectFriend", 1);
              paramView.put("gameMode", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameMode);
              paramView.put("roomId", this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.roomId);
              this.jdField_a_of_type_Aktr.b(paramView.toString());
              if (this.jdField_a_of_type_Akpy != null) {
                this.jdField_a_of_type_Akpy.b();
              }
              if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
                continue;
              }
              akro.a(akro.a(), akpq.a(0, 0, 3, 901003002, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
              return;
            }
            catch (Exception paramView)
            {
              for (;;)
              {
                QLog.e("cmframe_QzoneGameFloatView", 1, "share game error, e=", paramView);
              }
            }
          }
        }
        else
        {
          if (paramView != this.e) {
            break;
          }
          if ((this.jdField_a_of_type_Aktr != null) && (this.jdField_a_of_type_Aktr.c()))
          {
            QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
            return;
          }
          if ((this.jdField_a_of_type_Aktr != null) && (this.jdField_a_of_type_Aktr.a()))
          {
            f();
            QLog.d("cmframe_QzoneGameFloatView", 1, "pack up game");
            if (this.jdField_a_of_type_Akpy != null) {
              this.jdField_a_of_type_Akpy.c();
            }
            if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {
              akro.a(akro.a(), akpq.a(0, 0, 3, 901003003, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src));
            }
          }
          while ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter != 0) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter != 1) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter == 7))
          {
            return;
            ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).finish();
          }
        }
      }
    } while ((paramView != this.g) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null));
    if ((this.jdField_a_of_type_Aktr != null) && (this.jdField_a_of_type_Aktr.c()))
    {
      QLog.e("cmframe_QzoneGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
      return;
    }
    ApolloGameUtil.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId, null);
  }
  
  public void setFloatBtnBackground(View paramView, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean) {
      paramView.setBackgroundResource(2130842261);
    }
  }
  
  public void setFloatingShareVisible(boolean paramBoolean)
  {
    View localView;
    if (this.f != null)
    {
      localView = this.f;
      if (!paramBoolean) {
        break label67;
      }
    }
    label67:
    for (int j = 8;; j = 0)
    {
      localView.setVisibility(j);
      if ((!paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null) && ((this.jdField_a_of_type_AndroidViewView.getVisibility() == 8) || (this.jdField_a_of_type_AndroidViewView.getVisibility() == 4))) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      return;
    }
  }
  
  public void setFrameViewStyle(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if (paramStartCheckParam != null) {}
    try
    {
      String str = paramStartCheckParam.extInfoFromSvr;
      if (str != null)
      {
        int j = new JSONObject(str).optInt("needShowShare", 1);
        ThreadManagerV2.getUIHandlerV2().post(new QzoneGameFloatView.1(this, j, paramStartCheckParam));
      }
      return;
    }
    catch (Throwable paramStartCheckParam)
    {
      QLog.e("cmframe_QzoneGameFloatView", 1, paramStartCheckParam, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView
 * JD-Core Version:    0.7.0.1
 */