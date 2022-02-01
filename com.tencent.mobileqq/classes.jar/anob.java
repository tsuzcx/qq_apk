import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.pannel.ApolloPanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import java.net.MalformedURLException;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class anob
{
  private static int jdField_a_of_type_Int;
  private static int b = 1;
  private amme jdField_a_of_type_Amme;
  private amna jdField_a_of_type_Amna;
  private Context jdField_a_of_type_AndroidContentContext;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private anpe jdField_a_of_type_Anpe;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  private ApolloPanel jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel;
  
  public anob(BaseChatPie paramBaseChatPie, SessionInfo paramSessionInfo, ApolloPanel paramApolloPanel, anpe paramanpe)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel = paramApolloPanel;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getContext();
    this.jdField_a_of_type_Anpe = paramanpe;
    this.jdField_a_of_type_Amme = ((amme)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER));
    this.jdField_a_of_type_Amna = this.jdField_a_of_type_Amme.a();
  }
  
  private Drawable a(ApolloActionData paramApolloActionData)
  {
    Object localObject5 = null;
    Object localObject4;
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramApolloActionData == null)) {
      localObject4 = null;
    }
    label106:
    do
    {
      Resources localResources;
      do
      {
        return localObject4;
        localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
        try
        {
          localObject1 = localResources.getDrawable(2130838049);
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            Drawable localDrawable;
            String str;
            localObject1 = null;
            QLog.e("ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] exception=", localException1);
            Object localObject2 = null;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError1)
        {
          for (;;)
          {
            Object localObject1 = null;
            QLog.e("ApolloNewActionFloatViewController", 1, "[getNewActionStaticDrawable] error=", localOutOfMemoryError1);
            Object localObject3 = null;
          }
        }
        for (;;)
        {
          try
          {
            localDrawable = localResources.getDrawable(2130843819);
            localObject4 = localObject1;
            if (paramApolloActionData.status == 0) {
              break;
            }
            str = Integer.toString(1);
          }
          catch (OutOfMemoryError localOutOfMemoryError2)
          {
            break label229;
          }
          catch (Exception localException2)
          {
            break label212;
          }
          try
          {
            localObject4 = new URL("apollo_pic", null, paramApolloActionData.actionId + "_" + paramApolloActionData.actionName);
            localObject5 = localObject4;
          }
          catch (MalformedURLException localMalformedURLException)
          {
            QLog.e("ApolloNewActionFloatViewController", 1, new Object[] { "[getNewActionStaticDrawable] get url exception=", null });
            break label106;
          }
        }
        localObject4 = localObject1;
      } while (localObject5 == null);
      localObject4 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = localDrawable;
      ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = ((Drawable)localObject1);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = AIOUtils.dp2px(90.0F, localResources);
      ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight;
      ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = false;
      localObject1 = URLDrawable.getDrawable(localObject5, (URLDrawable.URLDrawableOptions)localObject4);
      localObject4 = localObject1;
    } while (((URLDrawable)localObject1).getStatus() == 1);
    ((URLDrawable)localObject1).setTag(paramApolloActionData);
    ((URLDrawable)localObject1).addHeader("apollo_uin", this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
    ((URLDrawable)localObject1).addHeader("apollo_tasks", str);
    return localObject1;
  }
  
  @NotNull
  private View.OnClickListener a()
  {
    return new anoj(this);
  }
  
  @NotNull
  private View.OnClickListener a(int paramInt1, ApolloActionData paramApolloActionData, int paramInt2, String paramString1, String paramString2)
  {
    return new anoi(this, paramApolloActionData, paramInt1, paramInt2, paramString1, paramString2);
  }
  
  private RelativeLayout a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558686, null);
    localRelativeLayout.setId(2131362809);
    Resources localResources = this.jdField_a_of_type_AndroidContentContext.getResources();
    int i = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.getHeight() - this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.a().getHeight();
    if (i < AIOUtils.dp2px(213.0F, localResources))
    {
      LinearLayout localLinearLayout = (LinearLayout)localRelativeLayout.findViewById(2131365134);
      i = i - (int)localResources.getDimension(2131296505) - (int)localResources.getDimension(2131296506);
      ((RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams()).bottomMargin = ((int)(i * 0.1D));
      ((RelativeLayout.LayoutParams)((RelativeLayout)localRelativeLayout.findViewById(2131365129)).getLayoutParams()).bottomMargin = ((int)(i * 0.2D));
    }
    return localRelativeLayout;
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt1, Bundle paramBundle, annm paramannm, int paramInt2, String paramString1, String paramString2, Button paramButton)
  {
    switch (paramInt1)
    {
    case 3: 
    default: 
      return;
    case 0: 
      paramButton.setText(anvx.a(2131699973));
      paramButton.setOnClickListener(new anod(this, paramannm, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    case 1: 
      paramButton.setText(anvx.a(2131699983));
      paramButton.setOnClickListener(new anoe(this, paramBundle, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    case 2: 
      paramButton.setText(anvx.a(2131699972));
      paramButton.setOnClickListener(new anof(this, paramApolloActionData, paramBundle, paramInt2, paramString1, paramString2));
      return;
    case 4: 
      paramButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690072));
      paramButton.setOnClickListener(new anog(this, paramApolloActionData, paramInt2, paramString1, paramString2));
      return;
    }
    paramButton.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690098));
    paramButton.setOnClickListener(new anoh(this, paramApolloActionData, paramInt2, paramString1, paramString2));
  }
  
  private void a(ApolloActionData paramApolloActionData, int paramInt, ImageView paramImageView, TextView paramTextView)
  {
    switch (paramInt)
    {
    case 24: 
    case 26: 
    default: 
      return;
    case 20: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(anvx.a(2131699978));
      return;
    case 21: 
      paramImageView.setVisibility(8);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(anvx.a(2131699968));
      return;
    case 22: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838600);
      paramTextView.setTextColor(Color.parseColor("#FFFF8444"));
      paramTextView.setText(paramApolloActionData.extraWording);
      return;
    case 23: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838601);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(anvx.a(2131699970));
      paramImageView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380308);
      paramImageView.setVisibility(0);
      paramImageView.setText(String.valueOf(paramApolloActionData.currencyNum));
      return;
    case 25: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838602);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(anvx.a(2131699979));
      return;
    case 28: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838623);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690074));
      return;
    case 27: 
      paramImageView.setVisibility(0);
      paramImageView.setImageResource(2130838623);
      paramTextView.setVisibility(0);
      paramTextView.setTextColor(Color.parseColor("#FF777777"));
      paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690074));
      return;
    }
    paramImageView.setVisibility(0);
    paramImageView.setImageResource(2130838621);
    paramTextView.setVisibility(0);
    paramTextView.setTextColor(Color.parseColor("#FF777777"));
    paramTextView.setMaxLines(2);
    paramTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690097));
  }
  
  private void a(ApolloActionData paramApolloActionData, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null) {
      VipUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app, "cmshow", "Apollo", paramString, ApolloUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.curType), 0, new String[] { String.valueOf(paramApolloActionData.actionId) });
    }
  }
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    localLayoutParams.addRule(2, 2131362824);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, localLayoutParams);
  }
  
  private void c()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(500L);
    localTranslateAnimation.setRepeatCount(0);
    localTranslateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.startAnimation(localTranslateAnimation);
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView]");
    }
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getParent() != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
    }
    View localView = this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.findViewById(2131362809);
    if (localView != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloNewActionFloatViewController", 2, "[hideNewActionFloatView] remove by id");
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.removeView(localView);
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloNewActionFloatViewController", 2, new Object[] { "[showKapuLockActionView] action=", paramApolloActionData });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (paramApolloActionData == null)) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368419).setVisibility(4);
    ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368666)).setOnClickListener(a());
    Object localObject = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368653);
    new annm(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin()).a = paramApolloActionData;
    ((ImageView)localObject).setImageDrawable(a(paramApolloActionData));
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380298)).setText(paramApolloActionData.actionName);
    ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380297)).setText(paramApolloActionData.description);
    ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363985)).setOnClickListener(a(jdField_a_of_type_Int, paramApolloActionData, 0, null, null));
    localObject = (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363814);
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368399);
    TextView localTextView = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380320);
    localImageView.setVisibility(0);
    localImageView.setImageResource(2130838621);
    localTextView.setVisibility(0);
    localTextView.setMaxLines(2);
    localTextView.setTextColor(Color.parseColor("#FF777777"));
    localTextView.setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690097));
    ((Button)localObject).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690098));
    ((Button)localObject).setOnClickListener(new anoc(this, paramApolloActionData));
    localObject = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject).addRule(2, 2131362824);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelApolloPanel.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject);
    c();
    a(paramApolloActionData, "clkunlocked");
  }
  
  public void a(ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloNewActionFloatViewController", 2, new Object[] { "[showNewActionFloatView] actionInfo=", paramApolloActionData, ", btnType=", Integer.valueOf(paramInt1), ", extraWordingType=", Integer.valueOf(paramInt2), ", pkgId=", Integer.valueOf(paramInt3), ", extra=", paramBundle });
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app == null) || (this.jdField_a_of_type_AndroidContentContext == null) || (paramApolloActionData == null)) {
      return;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getApp().getSharedPreferences("apollo_sp" + this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin(), 0);
    Object localObject4 = String.format("key_new_action_info_%s", new Object[] { String.valueOf(paramInt3) });
    Object localObject5 = ((SharedPreferences)localObject3).getString((String)localObject4, "");
    int i = 0;
    paramInt3 = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    String str = String.format("{\"operateObjectID\":%d}", new Object[] { Integer.valueOf(paramApolloActionData.actionId) });
    if (!TextUtils.isEmpty((CharSequence)localObject5))
    {
      paramInt3 = i;
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        localObject5 = new JSONObject((String)localObject5);
        paramInt3 = i;
        localObject1 = localObject2;
        i = ((JSONObject)localObject5).getInt("adId");
        paramInt3 = i;
        localObject1 = localObject2;
        localObject2 = ((JSONObject)localObject5).getString("traceInfo");
        paramInt3 = i;
        localObject1 = localObject2;
        anme.a(101, String.valueOf(i), (String)localObject2, str);
        paramInt3 = i;
        localObject1 = localObject2;
        ((SharedPreferences)localObject3).edit().remove((String)localObject4).commit();
        localObject1 = localObject2;
        paramInt3 = i;
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView Exception:", localThrowable);
        continue;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = a();
      ((ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368666)).setOnClickListener(a());
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368653);
      localObject2 = new annm(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.app.getCurrentUin());
      ((annm)localObject2).a = paramApolloActionData;
      ((ImageView)localObject3).setImageDrawable(a(paramApolloActionData));
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380298)).setText(paramApolloActionData.actionName);
      ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380297)).setText(paramApolloActionData.description);
      ((Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363985)).setOnClickListener(a(jdField_a_of_type_Int, paramApolloActionData, paramInt3, localObject1, str));
      localObject3 = (ImageView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131368399);
      localObject4 = (TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131380320);
      ((TextView)localObject4).setMaxLines(1);
      a(paramApolloActionData, paramInt2, (ImageView)localObject3, (TextView)localObject4);
      a(paramApolloActionData, paramInt1, paramBundle, (annm)localObject2, paramInt3, localObject1, str, (Button)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131363814));
      b();
      c();
      a(paramApolloActionData, "action_flame_view");
      return;
      QLog.e("ApolloNewActionFloatViewController", 1, "realshowNewActionFloatView no tianshu action data");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anob
 * JD-Core Version:    0.7.0.1
 */