package com.tencent.mobileqq.apollo.process.ui.framework;

import amwn;
import amyd;
import amyo;
import amyx;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anev;
import bkys;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558940, null);
    amyx localamyx = amwn.a();
    int i;
    Object localObject;
    if ((localamyx != null) && (localamyx.b()))
    {
      i = 1;
      if (!paramBoolean) {
        break label286;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364771));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364775));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364780));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364778));
      localRelativeLayout.findViewById(2131364769).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364770).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364767).setOnClickListener(this);
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
      paramContext = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131376956);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramContext.addView(this, (ViewGroup.LayoutParams)localObject);
      invalidate();
      if (localamyx != null)
      {
        localamyx.b();
        this.jdField_a_of_type_Int = localamyx.jdField_a_of_type_Int;
      }
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_kxw", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
      i = 0;
      break;
      label286:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364774));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364776));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364779));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364777));
      localRelativeLayout.findViewById(2131364772).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364773).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364768).setOnClickListener(this);
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
    paramURLImageView.setImageDrawable(anev.a(true, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/" + paramString.substring(paramString.lastIndexOf("/") + 1), null, paramString, true));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Amyo != null) {
      this.jdField_a_of_type_Amyo.i();
    }
    this.jdField_a_of_type_Bkys.sendEmptyMessageDelayed(102, 500L);
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("xyId", 3112);
        localJSONObject.put("src", 888001);
        amyd.a("cs.create_xy.local", localJSONObject.toString(), false, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        b();
        VipUtils.a(null, "cmshow", "Apollo", "BeGuiClick", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      }
      catch (Exception localException)
      {
        QLog.e("cmframe_CmGameGuideView", 1, "cmgame_framework_guide_play_btn e:", localException);
      }
      continue;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_xxlb", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      continue;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView
 * JD-Core Version:    0.7.0.1
 */