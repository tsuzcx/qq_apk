package com.tencent.mobileqq.apollo.process.ui.framework;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.process.chanel.CmGameToolCmdChannel;
import com.tencent.mobileqq.apollo.process.data.CmGameLauncher;
import com.tencent.mobileqq.apollo.process.data.CmGameManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class CmGameGuideView
  extends FrameworkView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 0;
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
    if (paramStartCheckParam.viewMode == 0) {
      bool = true;
    }
    a(paramContext, bool);
  }
  
  private void a(Context paramContext, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558981, null);
    CmGameManager localCmGameManager = CmGameUtil.a();
    int i;
    Object localObject;
    if ((localCmGameManager != null) && (localCmGameManager.b()))
    {
      i = 1;
      if (!paramBoolean) {
        break label286;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364889));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364893));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364898));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364896));
      localRelativeLayout.findViewById(2131364887).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364888).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364885).setOnClickListener(this);
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
      paramContext = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131377365);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramContext.addView(this, (ViewGroup.LayoutParams)localObject);
      invalidate();
      if (localCmGameManager != null)
      {
        localCmGameManager.b();
        this.jdField_a_of_type_Int = localCmGameManager.jdField_a_of_type_Int;
      }
      VipUtils.a(null, "cmshow", "Apollo", "BeGuiShow_kxw", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
      i = 0;
      break;
      label286:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364892));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131364894));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364897));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131364895));
      localRelativeLayout.findViewById(2131364890).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364891).setOnClickListener(this);
      localRelativeLayout.findViewById(2131364886).setOnClickListener(this);
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
    paramURLImageView.setImageDrawable(((IApolloUtil)QRoute.api(IApolloUtil.class)).getDrawable(true, "/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/" + paramString.substring(paramString.lastIndexOf("/") + 1), null, paramString, true));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameLauncher.i();
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(102, 500L);
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
        CmGameToolCmdChannel.a("cs.create_xy.local", localJSONObject.toString(), false, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView
 * JD-Core Version:    0.7.0.1
 */