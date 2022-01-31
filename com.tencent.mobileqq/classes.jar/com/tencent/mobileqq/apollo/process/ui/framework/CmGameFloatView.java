package com.tencent.mobileqq.apollo.process.ui.framework;

import ailv;
import aing;
import aipj;
import aird;
import ajds;
import ajjy;
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
import bajr;
import befq;
import begr;
import begw;
import behe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.data.CmGamePushItem;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloGameData;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
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
  private begr jdField_a_of_type_Begr;
  private begw jdField_a_of_type_Begw = new aird(this);
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
    RelativeLayout localRelativeLayout = (RelativeLayout)LayoutInflater.from(paramContext).inflate(2131493242, null);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131298036));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131297953));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)localRelativeLayout.findViewById(2131298075));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setPlayLoop(true);
    this.jdField_a_of_type_AndroidViewView = localRelativeLayout.findViewById(2131303558);
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)localRelativeLayout.findViewById(2131304763));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838343);
    if (c()) {
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    addView(localRelativeLayout);
    localRelativeLayout = (RelativeLayout)((Activity)this.jdField_a_of_type_MqqUtilWeakReference.get()).findViewById(2131309745);
    int i = (int)paramContext.getResources().getDimension(2131165333);
    int j = (int)paramContext.getResources().getDimension(2131165332);
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
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838342);
      if (!TextUtils.isEmpty(paramString2))
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, paramString2, ajds.a(paramString2), true);
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
      bajr.a(null, "cmshow", "Apollo", "packetshow", 0, 0, new String[] { paramString1 });
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838344);
        break;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838344);
        break;
        if (!this.jdField_b_of_type_Boolean) {
          break label322;
        }
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setGifData(100, null, "https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip", ajds.a("https://cmshow.gtimg.cn/client/img/apollo_game_audio_micBig.zip"), false);
      } while (!this.jdField_d_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838342);
      if (this.jdField_c_of_type_Boolean) {
        if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b() == 3) {
          this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.b();
        }
      }
      for (;;)
      {
        this.jdField_a_of_type_Boolean = true;
        return;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838935);
        continue;
        this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageResource(2130838933);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130838343);
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
    if (this.jdField_a_of_type_Aipj != null)
    {
      String str = this.jdField_a_of_type_Aipj.a().mTempAIOUin;
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
      localLayoutParams.topMargin = ((int)localResources.getDimension(2131165333));
      localLayoutParams.rightMargin = ((int)localResources.getDimension(2131165332));
      QLog.d("cmframe_CmGameFloatView", 1, "[handleMessage] MSG_RESET_TOP_MENU reset");
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) {}
    label102:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            switch (paramView.getId())
            {
            default: 
              return;
            case 2131297953: 
              if ((this.jdField_a_of_type_Aipj != null) && (this.jdField_a_of_type_Aipj.a())) {
                break label994;
              }
              QLog.d("cmframe_CmGameFloatView", 1, "game not running, finish");
              paramView = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
              if ((paramView != null) && (!paramView.isFinishing())) {
                paramView.finish();
              }
              break;
            }
          } while (this.jdField_a_of_type_MqqUtilWeakReference == null);
          paramView = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
        } while ((paramView == null) || (!(paramView instanceof ApolloGameActivity)));
        ((ApolloGameActivity)paramView).g();
        return;
      } while (this.jdField_a_of_type_Aipj == null);
      if (this.jdField_a_of_type_Aipj.c())
      {
        QLog.e("cmframe_CmGameFloatView", 1, "onClick mGameLauncher.isDisableMoreMenu():true");
        return;
      }
    } while ((this.jdField_a_of_type_Begr != null) && (this.jdField_a_of_type_Begr.isShowing()));
    label322:
    int j;
    if (this.jdField_a_of_type_Begr == null) {
      if (a())
      {
        this.jdField_a_of_type_Begr = ((begr)behe.a(this.jdField_a_of_type_Aipj.a(), null));
        if (QLog.isColorLevel()) {
          QLog.d("cmframe_CmGameFloatView", 2, new Object[] { "isWhiteUsr:", Boolean.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) });
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem == null) {
          break label1277;
        }
        paramView = ajjy.a(2131636275);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content)) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label781;
        }
        this.jdField_a_of_type_Begr.a(paramView, 2130849053, 0);
        this.jdField_d_of_type_Int = 0;
        this.jdField_a_of_type_AndroidUtilSparseIntArray.put(0, 6);
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.src;
        int k = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId;
        paramView = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.msg_id;
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.is_show_red != 1) {
          break label802;
        }
        i = 1;
        label381:
        bajr.a(null, "cmshow", "Apollo", "exporePromoteInUnversialFrame", j, 0, new String[] { String.valueOf(k), paramView, String.valueOf(i) });
      }
    }
    label467:
    label994:
    label1277:
    for (int i = 1;; i = 0)
    {
      j = i;
      if (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.disableMinGame)
      {
        j = this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.enter;
        if ((j == 0) || (j == 1) || (j == 7))
        {
          this.jdField_a_of_type_Begr.a(2131624553, 0);
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
                break label821;
              }
              this.jdField_a_of_type_Begr.c(ajjy.a(2131636280));
              this.jdField_a_of_type_Int = j;
              this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 5);
              i = j + 1;
            }
          }
        }
        this.jdField_a_of_type_Begr.a(2131624559, 0);
        paramView = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        paramView.put(i, 1);
        this.jdField_a_of_type_Begr.a(2131624547, 0);
        paramView = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        i = j + 1;
        paramView.put(j, 3);
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name))) {
          break label837;
        }
        this.jdField_a_of_type_Begr.a(ajjy.a(2131636277) + this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.game.name, 0);
        paramView = this.jdField_a_of_type_AndroidUtilSparseIntArray;
        j = i + 1;
        paramView.put(i, 2);
        paramView = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
        if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr) {
          break label851;
        }
        this.jdField_a_of_type_Begr.c(2131625035);
        this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_Begw);
      }
      do
      {
        do
        {
          this.jdField_a_of_type_Begr.show();
          bajr.a(null, "cmshow", "Apollo", "more_info", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId) });
          return;
          this.jdField_a_of_type_Begr = ((begr)behe.b(this.jdField_a_of_type_Aipj.a(), null));
          break;
          this.jdField_a_of_type_Begr.a(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.pushItem.content, 0);
          break label322;
          i = 0;
          break label381;
          this.jdField_a_of_type_Begr.a(2131624554, 0);
          break label467;
          this.jdField_a_of_type_Begr.c(ajjy.a(2131636279));
          break label527;
          this.jdField_a_of_type_Begr.a(2131624557, 0);
          break label663;
          bool = paramView.getBoolean("game_debug_tool_switch", true);
          paramView = this.jdField_a_of_type_Begr;
          if (bool) {}
          for (i = 2131624551;; i = 2131624552)
          {
            paramView.a(i, 0);
            this.e = j;
            this.jdField_a_of_type_AndroidUtilSparseIntArray.put(j, 9);
            break;
          }
        } while (!this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.isWhiteUsr);
        paramView = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 0);
      } while (this.e < 0);
      boolean bool = paramView.getBoolean("game_debug_tool_switch", true);
      paramView = this.jdField_a_of_type_Begr;
      j = this.e;
      Object localObject = getResources();
      if (bool) {}
      for (i = 2131624551;; i = 2131624552)
      {
        paramView.a(j, ((Resources)localObject).getString(i));
        break;
      }
      QLog.d("cmframe_CmGameFloatView", 1, "notify game");
      if (!b())
      {
        if (this.jdField_a_of_type_Ailv != null) {
          this.jdField_a_of_type_Ailv.a();
        }
        this.jdField_a_of_type_Aipj.i();
        if ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam == null) || ((this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.commFlag & 0x1) == 0))
        {
          this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(102, 1000L);
          break label102;
        }
        this.jdField_a_of_type_Befq.sendEmptyMessageDelayed(102, 5000L);
        QLog.i("cmframe_CmGameFloatView", 1, "comm flag bit0 is 1.");
        break label102;
      }
      this.jdField_a_of_type_Befq.sendEmptyMessage(111);
      break label102;
      if (this.jdField_a_of_type_Boolean)
      {
        if (!aing.e())
        {
          b();
          return;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("cmframe_CmGameFloatView", 2, "[onClick] click audio button too fast.");
        return;
      }
      localObject = (String)this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.getTag();
      if (this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) {}
      for (paramView = String.valueOf(this.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.gameId);; paramView = "")
      {
        bajr.a(null, "cmshow", "Apollo", "clickpacket", 0, 0, new String[] { paramView });
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        paramView = super.getContext();
        Intent localIntent = new Intent(paramView, QQBrowserActivity.class);
        localIntent.putExtra("url", (String)localObject);
        localIntent.putExtra("portraitOnly", true);
        localIntent.putExtra("hide_operation_bar", true);
        localIntent.putExtra("hide_more_button", true);
        paramView.startActivity(localIntent);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.CmGameFloatView
 * JD-Core Version:    0.7.0.1
 */