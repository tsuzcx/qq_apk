package com.tencent.mobileqq.apollo.process.ui.framework;

import akro;
import aktg;
import aktr;
import akua;
import akze;
import alef;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bhow;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class CmGameGuideView
  extends FrameworkView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  
  public CmGameGuideView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, true);
  }
  
  public CmGameGuideView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    if (paramStartCheckParam.viewMode == 0) {}
    for (boolean bool = true;; bool = false)
    {
      a(paramContext, bool);
      return;
    }
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558835, null);
    akua localakua = akro.a();
    int i;
    Object localObject;
    if ((localakua != null) && (localakua.b()))
    {
      i = 1;
      if (!paramBoolean) {
        break label286;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364397));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364401));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364406));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364404));
      localRelativeLayout.findViewById(2131364395).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364396).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364393).setOnClickListener(this);
      localObject = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play.png";
      paramContext = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus.png";
      label135:
      a(this.jdField_a_of_type_ComTencentImageURLImageView, (String)localObject);
      a(this.jdField_b_of_type_ComTencentImageURLImageView, paramContext);
      if (i == 0) {
        break label385;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      addView(localRelativeLayout);
      paramContext = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131375990);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramContext.addView(this, (ViewGroup.LayoutParams)localObject);
      invalidate();
      if (localakua != null)
      {
        localakua.b();
        this.jdField_a_of_type_Int = localakua.jdField_a_of_type_Int;
      }
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_kxw", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
      i = 0;
      break;
      label286:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364400));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364402));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364405));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364403));
      localRelativeLayout.findViewById(2131364398).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364399).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364394).setOnClickListener(this);
      localObject = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play_landscape.png";
      paramContext = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus_landscape.png";
      break label135;
      label385:
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
  }
  
  private void a(URLImageView paramURLImageView, String paramString)
  {
    if ((paramURLImageView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramURLImageView.setImageDrawable(akze.a(true, alef.k + paramString.substring(paramString.lastIndexOf("/") + 1), null, paramString, true));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aktr != null) {
      this.jdField_a_of_type_Aktr.i();
    }
    this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(102, 500L);
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131364397: 
    default: 
      return;
    case 2131364395: 
    case 2131364398: 
      paramView = new JSONObject();
      try
      {
        paramView.put("xyId", 3112);
        paramView.put("src", 888001);
        aktg.a("cs.create_xy.local", paramView.toString(), false, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        b();
        VipUtils.a(null, "cmshow", "Apollo", "BeGuiClick", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
        return;
      }
      catch (Exception paramView)
      {
        QLog.e("cmframe_CmGameGuideView", 1, "cmgame_framework_guide_play_btn e:", paramView);
        return;
      }
    case 2131364396: 
    case 2131364399: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_xxlb", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView
 * JD-Core Version:    0.7.0.1
 */