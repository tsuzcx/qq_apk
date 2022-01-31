package com.tencent.mobileqq.apollo.game;

import aixq;
import aiyl;
import aiyn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class WebGameFakeView
{
  public static AtomicBoolean a;
  public aiyl a;
  public Context a;
  public Bundle a;
  private View a;
  public Window a;
  public ApolloFragment a;
  public WebGameFakeView.Director a;
  public CmGameInitParams a;
  public boolean a;
  public boolean b;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public WebGameFakeView(Window paramWindow, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director = new WebGameFakeView.Director();
    a(paramWindow);
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      Serializable localSerializable = this.jdField_a_of_type_AndroidOsBundle.getSerializable("game_init");
      if ((localSerializable != null) && ((localSerializable instanceof CmGameStartChecker.StartCheckParam))) {
        return ((CmGameStartChecker.StartCheckParam)localSerializable).gameId;
      }
    }
    return -1;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public CmGameInitParams a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams;
  }
  
  public void a()
  {
    RelativeLayout localRelativeLayout1;
    RelativeLayout localRelativeLayout2;
    TextView localTextView;
    ImageView localImageView;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director != null) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      localRelativeLayout1 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131362611);
      localRelativeLayout2 = (RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131364687);
      localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362610);
      localTextView.setVisibility(0);
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362612);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.frontColor))
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.frontColor.trim().toLowerCase().equals("#000000")) {
          break label234;
        }
        localImageView.setImageResource(2130839677);
        localRelativeLayout2.setBackgroundResource(0);
        if (ImmersiveUtils.a()) {
          ImmersiveUtils.a(this.jdField_a_of_type_AndroidViewWindow, false);
        }
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.bgColor)) && (this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof ApolloGameActivity))) {
        ((ApolloGameActivity)this.jdField_a_of_type_AndroidContentContext).a(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.bgColor));
      }
      localTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.frontColor));
      localTextView.setText(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.title);
      localTextView.setTextSize(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.titleSize);
      localRelativeLayout1.setBackgroundColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.bgColor));
      return;
      label234:
      if (this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director.frontColor.trim().toLowerCase().equals("#ffffff"))
      {
        localImageView.setImageResource(2130846797);
        localRelativeLayout2.setBackgroundResource(2130838316);
        if (ImmersiveUtils.a()) {
          ImmersiveUtils.a(this.jdField_a_of_type_AndroidViewWindow, true);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGameView", 2, new Object[] { "[notifyEngineSharedResult], aioType:", Integer.valueOf(paramInt3), ",gameId:", Integer.valueOf(paramInt2), ",ret:", Integer.valueOf(paramInt1) });
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("ret", paramInt1);
      localJSONObject.put("gameId", paramInt2);
      localJSONObject.put("aioType", paramInt3);
      localJSONObject.put("shareTo", paramInt4);
      a("sc.share_game_to_friend_result.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameView", 1, localThrowable, new Object[0]);
    }
  }
  
  public void a(aiyl paramaiyl)
  {
    this.jdField_a_of_type_Aiyl = paramaiyl;
  }
  
  public void a(Intent paramIntent)
  {
    ImageView localImageView;
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362612);
      if (aixq.a().a() <= 1) {
        break label83;
      }
      localImageView.setVisibility(0);
      localImageView.setOnClickListener(new aiyn(this, localImageView));
    }
    for (;;)
    {
      if (paramIntent != null)
      {
        paramIntent = paramIntent.getSerializableExtra("Director");
        if ((paramIntent != null) && ((paramIntent instanceof WebGameFakeView.Director)))
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloGameWebGameFakeView$Director = ((WebGameFakeView.Director)paramIntent);
          a();
        }
      }
      return;
      label83:
      localImageView.setVisibility(8);
    }
  }
  
  public void a(View paramView)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramView != null))
    {
      this.jdField_a_of_type_AndroidViewView = paramView;
      TextView localTextView = (TextView)paramView.findViewById(2131362610);
      paramView = (FrameLayout)paramView.findViewById(2131366941);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.addRule(3, 2131362611);
      paramView.setLayoutParams(localLayoutParams);
      paramView.requestLayout();
      localTextView.setVisibility(0);
    }
  }
  
  public void a(Window paramWindow)
  {
    this.jdField_a_of_type_AndroidViewWindow = paramWindow;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidViewWindow.getContext();
  }
  
  public void a(CmGameInitParams paramCmGameInitParams)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = paramCmGameInitParams;
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.a(paramCmGameInitParams);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.b(paramString1, paramString2);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewWindow = null;
    this.jdField_a_of_type_Aiyl = null;
    this.jdField_a_of_type_AndroidOsBundle = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessDataCmGameInitParams = null;
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentMobileqqApolloGameApolloFragment = null;
    if (paramBoolean)
    {
      if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity)))
      {
        ((Activity)this.jdField_a_of_type_AndroidContentContext).finish();
        this.jdField_a_of_type_AndroidContentContext = null;
      }
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.b();
    }
  }
  
  public void b(Intent paramIntent)
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof Activity))) {
      ((Activity)this.jdField_a_of_type_AndroidContentContext).runOnUiThread(new WebGameFakeView.2(this, paramIntent));
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.c();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.e();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.d();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.f();
    }
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Aiyl != null) {
      this.jdField_a_of_type_Aiyl.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.WebGameFakeView
 * JD-Core Version:    0.7.0.1
 */