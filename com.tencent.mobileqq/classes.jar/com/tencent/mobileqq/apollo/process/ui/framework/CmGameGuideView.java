package com.tencent.mobileqq.apollo.process.ui.framework;

import aing;
import aioy;
import aipj;
import aips;
import aitu;
import aiys;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import bajr;
import befq;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
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
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131493243, null);
    aips localaips = aing.a();
    int i;
    Object localObject;
    if ((localaips != null) && (localaips.b()))
    {
      i = 1;
      if (!paramBoolean) {
        break label286;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131298773));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131298777));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131298782));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131298780));
      localRelativeLayout.findViewById(2131298771).setOnClickListener(this);
      localRelativeLayout.findViewById(2131298772).setOnClickListener(this);
      localRelativeLayout.findViewById(2131298769).setOnClickListener(this);
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
      paramContext = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131309745);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramContext.addView(this, (ViewGroup.LayoutParams)localObject);
      invalidate();
      if (localaips != null)
      {
        localaips.b();
        this.jdField_a_of_type_Int = localaips.jdField_a_of_type_Int;
      }
      bajr.a(null, "cmshow", "Apollo", "BeGuiShow_kxw", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
      i = 0;
      break;
      label286:
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131298776));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localRelativeLayout.findViewById(2131298778));
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131298781));
      this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localRelativeLayout.findViewById(2131298779));
      localRelativeLayout.findViewById(2131298774).setOnClickListener(this);
      localRelativeLayout.findViewById(2131298775).setOnClickListener(this);
      localRelativeLayout.findViewById(2131298770).setOnClickListener(this);
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
    paramURLImageView.setImageDrawable(aitu.a(true, aiys.k + paramString.substring(paramString.lastIndexOf("/") + 1), null, paramString, true));
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aipj != null) {
      this.jdField_a_of_type_Aipj.i();
    }
    this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(102, 500L);
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131298773: 
    default: 
      return;
    case 2131298771: 
    case 2131298774: 
      paramView = new JSONObject();
      try
      {
        paramView.put("xyId", 3112);
        paramView.put("src", 888001);
        aioy.a("cs.create_xy.local", paramView.toString(), false, null, this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);
        b();
        bajr.a(null, "cmshow", "Apollo", "BeGuiClick", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
        return;
      }
      catch (Exception paramView)
      {
        QLog.e("cmframe_CmGameGuideView", 1, "cmgame_framework_guide_play_btn e:", paramView);
        return;
      }
    case 2131298772: 
    case 2131298775: 
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      bajr.a(null, "cmshow", "Apollo", "BeGuiShow_xxlb", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId), String.valueOf(this.jdField_a_of_type_Int) });
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameGuideView
 * JD-Core Version:    0.7.0.1
 */