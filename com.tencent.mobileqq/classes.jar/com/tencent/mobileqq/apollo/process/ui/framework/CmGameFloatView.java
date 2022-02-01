package com.tencent.mobileqq.apollo.process.ui.framework;

import amnt;
import ampj;
import amrk;
import amte;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anhe;
import anni;
import bkgm;
import bkho;
import bkhw;
import bkif;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class CmGameFloatView
  extends FrameworkView
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = -1;
  private SparseIntArray jdField_a_of_type_AndroidUtilSparseIntArray = new SparseIntArray();
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private bkho jdField_a_of_type_Bkho;
  private bkhw jdField_a_of_type_Bkhw = new amte(this);
  private FrameGifView jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int e = -1;
  
  public CmGameFloatView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CmGameFloatView(Context paramContext, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    super(paramContext, paramStartCheckParam);
    a(paramContext);
    a(paramStartCheckParam);
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318))) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
  
  private void a(Context paramContext)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131558905, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131363832));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131363741));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)localRelativeLayout.findViewById(2131363884));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout.findViewById(2131369874);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131371304));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838511);
    if (c()) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    addView(localRelativeLayout);
    localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131376797);
    int i = (int)paramContext.getResources().getDimension(2131296445);
    int j = (int)paramContext.getResources().getDimension(2131296444);
    paramContext = new RelativeLayout.LayoutParams(-2, -2);
    paramContext.addRule(11);
    paramContext.addRule(10);
    paramContext.rightMargin = j;
    paramContext.topMargin = i;
    localRelativeLayout.addView(this, paramContext);
  }
  
  private boolean c()
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null)) {
      bool = false;
    }
    while (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red == 1) {
      return bool;
    }
    return false;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
  }
  
  public void a(CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && ((paramStartCheckParam.src == 319) || (paramStartCheckParam.src == 318)))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", paramStartCheckParam.mTempAIOUin);
      localBundle.putBoolean("key_open_voice", false);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_aduio_enter_room", localBundle, null);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mTempAIOUin)))
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      ThreadManager.getUIHandler().post(new CmGameFloatView.2(this, paramBoolean));
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "[updateRedPacketButton] isVisible=", Boolean.valueOf(paramBoolean), ", url=", paramString1, ", iconUrl=", paramString2 });
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)))
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setTag(paramString1);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838510);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, paramString2, anhe.a(paramString2), true);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b() == 3)
        {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b();
          if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {
            break label350;
          }
        }
      }
    }
    label322:
    label350:
    for (paramString1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; paramString1 = "")
    {
      VipUtils.a(null, "cmshow", "Apollo", "packetshow", 0, 0, new String[] { paramString1 });
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838512);
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838512);
        break;
        if (!this.jdField_b_of_type_Boolean) {
          break label322;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", anhe.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      } while (!this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838510);
      if (this.jdField_c_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b() == 3) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839207);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130839205);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838511);
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmframe_CmGameFloatView", 2, "[onQueryVoiceStatus] get voice status.");
    }
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mGameType == 3);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Amrk != null)
    {
      String str = this.jdField_a_of_type_Amrk.a().mTempAIOUin;
      Bundle localBundle = new Bundle();
      localBundle.putString("key_game_friUin", str);
      QIPCClientHelper.getInstance().callServer("cm_game_module", "action_voice_switch", localBundle, null);
    }
  }
  
  public void d()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.addRule(11);
      localLayoutParams.addRule(10);
      Resources localResources = ((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).getResources();
      localLayoutParams.topMargin = ((int)localResources.getDimension(2131296445));
      localLayoutParams.rightMargin = ((int)localResources.getDimension(2131296444));
      QLog.d("cmframe_CmGameFloatView", 1, "[handleMessage] MSG_RESET_TOP_MENU reset");
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    Object localObject1;
    label112:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        switch (paramView.getId())
        {
        default: 
          break;
        case 2131363741: 
          if ((this.jdField_a_of_type_Amrk != null) && (this.jdField_a_of_type_Amrk.a())) {
            break label1033;
          }
          QLog.d("cmframe_CmGameFloatView", 1, "game not running, finish");
          localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
          if ((localObject1 != null) && (!((Activity)localObject1).isFinishing())) {
            ((Activity)localObject1).finish();
          }
          if (this.jdField_a_of_type_MqqUtilWeakReference != null)
          {
            localObject1 = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
            if ((localObject1 != null) && ((localObject1 instanceof ApolloGameActivity))) {
              ((ApolloGameActivity)localObject1).g();
            }
          }
          break;
        case 2131363832: 
          if (this.jdField_a_of_type_Amrk != null)
          {
            if (!this.jdField_a_of_type_Amrk.c()) {
              break label185;
            }
            QLog.e("cmframe_CmGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
          }
          break;
        }
      }
    } while ((this.jdField_a_of_type_Bkho != null) && (this.jdField_a_of_type_Bkho.isShowing()));
    label185:
    label234:
    int j;
    if (this.jdField_a_of_type_Bkho == null) {
      if (a())
      {
        this.jdField_a_of_type_Bkho = ((bkho)bkif.a(this.jdField_a_of_type_Amrk.a(), null));
        if (QLog.isColorLevel()) {
          QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "isWhiteUsr:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null) {
          break label1328;
        }
        localObject1 = anni.a(2131700874);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content)) {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label813;
        }
        this.jdField_a_of_type_Bkho.a((String)localObject1, 2130850388, 0);
        label343:
        this.jdField_d_of_type_Int = 0;
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 6);
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src;
        int k = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.msg_id;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label834;
        }
        i = 1;
        label403:
        VipUtils.a(null, "cmshow", "Apollo", "exporePromoteInUnversialFrame", j, 0, new String[] { String.valueOf(k), localObject1, String.valueOf(i) });
      }
    }
    label550:
    label813:
    label1328:
    for (int i = 1;; i = 0)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        if ((j == 0) || (j == 1) || (j == 7))
        {
          this.jdField_a_of_type_Bkho.a(2131690029, 0);
          label490:
          this.jdField_a_of_type_AndroidUtilSparseIntArray.put(i, 0);
          j = i + 1;
        }
      }
      else
      {
        i = j;
        if (this.jdField_b_of_type_Boolean)
        {
          i = j;
          if (this.jdField_d_of_type_Boolean)
          {
            i = j;
            if (!this.jdField_a_of_type_Boolean)
            {
              if (!this.jdField_c_of_type_Boolean) {
                break label853;
              }
              this.jdField_a_of_type_Bkho.c(anni.a(2131700879));
              this.jdField_a_of_type_Int = j;
              this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 5);
              i = j + 1;
            }
          }
        }
        this.jdField_a_of_type_Bkho.a(2131690032, 0);
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        ((SparseIntArray)localObject1).put(i, 1);
        this.jdField_a_of_type_Bkho.a(2131690024, 0);
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        i = j + 1;
        ((SparseIntArray)localObject1).put(j, 3);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name))) {
          break label869;
        }
        this.jdField_a_of_type_Bkho.a(anni.a(2131700876) + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name, 0);
        label690:
        localObject1 = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        ((SparseIntArray)localObject1).put(i, 2);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) {
          break label883;
        }
        this.jdField_a_of_type_Bkho.c(2131690582);
        this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_Bkhw);
      }
      label834:
      label853:
      label869:
      label883:
      do
      {
        do
        {
          this.jdField_a_of_type_Bkho.show();
          VipUtils.a(null, "cmshow", "Apollo", "more_info", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
          break;
          this.jdField_a_of_type_Bkho = ((bkho)bkif.b(this.jdField_a_of_type_Amrk.a(), null));
          break label234;
          this.jdField_a_of_type_Bkho.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content, 0);
          break label343;
          i = 0;
          break label403;
          this.jdField_a_of_type_Bkho.a(2131690030, 0);
          break label490;
          this.jdField_a_of_type_Bkho.c(anni.a(2131700878));
          break label550;
          this.jdField_a_of_type_Bkho.a(2131690031, 0);
          break label690;
          bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
          localObject1 = this.jdField_a_of_type_Bkho;
          if (bool) {}
          for (i = 2131690027;; i = 2131690028)
          {
            ((bkho)localObject1).a(i, 0);
            this.e = j;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 9);
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr);
        localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      } while (this.e < 0);
      boolean bool = ((SharedPreferences)localObject1).getBoolean("game_debug_tool_switch", true);
      localObject1 = this.jdField_a_of_type_Bkho;
      j = this.e;
      Object localObject2 = getResources();
      if (bool) {}
      for (i = 2131690027;; i = 2131690028)
      {
        ((bkho)localObject1).a(j, ((Resources)localObject2).getString(i));
        break;
      }
      QLog.d("cmframe_CmGameFloatView", 1, "notify game");
      if (!b())
      {
        if (this.jdField_a_of_type_Amnt != null) {
          this.jdField_a_of_type_Amnt.a();
        }
        this.jdField_a_of_type_Amrk.i();
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) == 0))
        {
          this.jdField_a_of_type_Bkgm.sendEmptyMessageDelayed(102, 1000L);
          break label112;
        }
        this.jdField_a_of_type_Bkgm.sendEmptyMessageDelayed(102, 5000L);
        QLog.i("cmframe_CmGameFloatView", 1, "comm flag bit0 is 1.");
        break label112;
      }
      this.jdField_a_of_type_Bkgm.sendEmptyMessage(111);
      break label112;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!ampj.e())
        {
          b();
          break;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmframe_CmGameFloatView", 2, "[onClick] click audio button too fast.");
        break;
      }
      localObject2 = (String)this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {}
      for (localObject1 = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; localObject1 = "")
      {
        VipUtils.a(null, "cmshow", "Apollo", "clickpacket", 0, 0, new String[] { localObject1 });
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          break;
        }
        localObject1 = super.getContext();
        Intent localIntent = new Intent((Context)localObject1, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject2);
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hide_more_button", true);
        ((Context)localObject1).startActivity(localIntent);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView
 * JD-Core Version:    0.7.0.1
 */